package net.lunar.themis.model.bo;

import net.lunar.themis.constants.ResponseCodeEnums;
import net.lunar.zeus.model.common.ResultSupport;

public class ThemisResult<T> extends ResultSupport<T> {
	
	private ResponseCodeEnums responseCodeEnums;
	
	public ThemisResult() {
		this.setCode(ResponseCodeEnums.SUCCESS.code);
		this.setDesc(ResponseCodeEnums.SUCCESS.desc);
		responseCodeEnums = ResponseCodeEnums.SUCCESS;
	} 

	public ThemisResult(T result) {
		this();
		this.setResult(result);
	}
	
	public ThemisResult(ResponseCodeEnums responseCodeEnums) {
		this.setCode(responseCodeEnums.code);
		this.setDesc(responseCodeEnums.desc);
		this.responseCodeEnums = responseCodeEnums;
	}
	 
	@Override
	public boolean isSucssess() {
		return ResponseCodeEnums.SUCCESS.code.equals(getCode());
	}
	
	public ResponseCodeEnums getResponseCodeEnums() {
		return responseCodeEnums;
	}

	public void setResponseCodeEnums(ResponseCodeEnums responseCodeEnums) {
		this.responseCodeEnums = responseCodeEnums;
	}

	public static <R> ThemisResult<R> newInstance(Class<R> clazz) {
		return new ThemisResult<R>();
	}
}
