package net.lunar.zeus.rest;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import net.lunar.zeus.utils.MapUtil;

public class RestProcessor {
	private RestTemplate restTemplate;
	
	public <T> T delete(RestAction<?> action, Class<T> clazz) {
		return exchange(action, HttpMethod.DELETE, clazz);
	}
	
	public <T> T put(RestAction<?> action, Class<T> clazz) {
		return exchange(action, HttpMethod.PUT, clazz);
	}
	
	public <T> T post(RestAction<?> action, Class<T> clazz) {
		return exchange(action, HttpMethod.POST, clazz);
	}
	
	public <T> T get(RestAction<?> action, Class<T> clazz) {
		Map<String, Object> paramsMap = null;
		if(action.getParams() instanceof Map) {
			paramsMap = (Map<String, Object>) action.getParams();
		} else {
			paramsMap = MapUtil.convertToMap(action.getParams());
		}
		
		StringBuffer realUrl = new StringBuffer(action.getUrlAction());
		realUrl.append("?");
		
		boolean flg = false;
		for(Entry<String, Object> entry : paramsMap.entrySet()) {
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if(ObjectUtils.isEmpty(key) || ObjectUtils.isEmpty(value)) {
				continue;
			}
			
			String valueStr = null;
			if(value instanceof Collection) {
				Collection collection = (Collection) value;
				valueStr = parseString(collection.toArray());
			} else if(value.getClass().isArray()) {
				valueStr = parseString((Object[])value);
			} else if(value instanceof CharSequence) {
				valueStr = (String) value;
			} else {
				valueStr = String.valueOf(value);
			}
			
			if(flg) {
				realUrl.append("&");
			}
			realUrl.append(key);
			realUrl.append("=");
			realUrl.append(valueStr);
			flg = true;
		}
		
		return exchange(realUrl.toString(), null, HttpMethod.GET, clazz);
	}
	
	private <T> T exchange(RestAction<?> action, HttpMethod method, Class<T> clazz) {
		return exchange(action.getUrlAction(), action.getParams(), method, clazz);
	}
	
	private <T> T exchange(String url, Object params, HttpMethod method, Class<T> resultClass) {
		
		HttpHeaders headers = new HttpHeaders();
		MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
		MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
		headers.setContentType(mediaType);
		
		String paramStr = JSONObject.toJSONString(params);
		
		HttpEntity<String> entity = new HttpEntity<String>(paramStr, headers);
		
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(url, method, entity, String.class);
		String responseStr = responseEntity.getBody();
		
		return JSONObject.parseObject(responseStr, resultClass);
	}
	
	private String parseString(Object[] array) {
		boolean flg = false;
		StringBuffer sb = new StringBuffer();
		for (Object object : array) {
			if(ObjectUtils.isEmpty(object)) {
				continue;
			}
			if(flg) {
				sb.append(",");
			}
			sb.append(object.toString());
			flg = true;
		}
		
		return sb.toString();
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
}
