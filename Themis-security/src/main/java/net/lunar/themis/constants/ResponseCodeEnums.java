package net.lunar.themis.constants;

public enum ResponseCodeEnums {

	SUCCESS("0000", "交易功能"),
	ILLEGAL_ARGUMENT("1000", "参数错误"),
	
	TIME_OUT("8888","交易超时"),
	SYSTEM_ERROR("9999", "系统错误")
	;
	
	private ResponseCodeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public final String code;
	
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
}
