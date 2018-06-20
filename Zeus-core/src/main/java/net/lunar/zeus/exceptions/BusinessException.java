package net.lunar.zeus.exceptions;

/**
 * 业务异常
 * @author Michael
 * @version 1.0.0
 */
public class BusinessException extends RuntimeException{
	
	private String code;
	
	private String desc;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
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
	
}
