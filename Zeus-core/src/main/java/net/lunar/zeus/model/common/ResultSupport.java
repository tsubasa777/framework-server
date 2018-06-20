package net.lunar.zeus.model.common;

import java.io.Serializable;

/**
 * 返回对象支持
 * @author Michael
 * @version 1.0.0
 * @param <T>
 */
public abstract class ResultSupport<T> implements Serializable {
	
	protected String code;
	
	protected String desc;
	
	protected T result;
	
	public ResultSupport() {
		
	}
	
	public ResultSupport(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public ResultSupport(String code, String desc, T result) {
		this.code = code;
		this.desc = desc;
		this.result = result;
	}

	/**
	 * 判断返回是成功
	 * 
	 * @return
	 */
	public abstract boolean isSucssess();

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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
