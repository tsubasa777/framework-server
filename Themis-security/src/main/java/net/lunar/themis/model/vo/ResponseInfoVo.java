package net.lunar.themis.model.vo;

import net.lunar.themis.constants.ResponseCodeEnums;
import net.lunar.zeus.model.common.ResultSupport;

public class ResponseInfoVo<T> {

	private String code;
	
	private String desc;
	
	private T data;
	
	public ResponseInfoVo() {
		this.code = ResponseCodeEnums.SUCCESS.code;
		this.desc = ResponseCodeEnums.SUCCESS.desc;
	}
	
	public ResponseInfoVo(T data) {
		this.code = ResponseCodeEnums.SUCCESS.code;
		this.desc = ResponseCodeEnums.SUCCESS.desc;
		this.data = data;
	}
	
	public ResponseInfoVo(ResponseCodeEnums responseCodeEnums) {
		this.code = responseCodeEnums.code;
		this.desc = responseCodeEnums.desc;
	}
	
	public ResponseInfoVo(ResponseCodeEnums responseCodeEnums, T data) {
		this.code = responseCodeEnums.code;
		this.desc = responseCodeEnums.desc;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static <R> ResponseInfoVo<R> newInstance(Class<R> clazz) {
		return new ResponseInfoVo<R>();
	}
	
	public static <R> ResponseInfoVo<R> newInstance(ResultSupport<R> result, Class<R> clazz) {
		ResponseInfoVo<R> response = new ResponseInfoVo<R>();
		if(result.isSucssess()) {
			response.setData(result.getResult());
		} else {
			response.setCode(result.getCode());
			response.setDesc(result.getDesc());
		}
		return response;
	}
	
	
}
