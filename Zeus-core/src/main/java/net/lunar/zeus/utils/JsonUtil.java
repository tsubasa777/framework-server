package net.lunar.zeus.utils;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	public static <T> T toObject(String text, Class<T> clazz) {
		return JSONObject.parseObject(text, clazz);
	}
	
	public static <T> List<T> toList(String text, Class<T> clazz) {
		return JSONObject.parseArray(text, clazz);
	}
	
	public static String toString(Object object) {
		return JSONObject.toJSONString(object);
	}
	
	public static String toString(Object[] array) {
		return JSONArray.toJSONString(array);
	}
}
