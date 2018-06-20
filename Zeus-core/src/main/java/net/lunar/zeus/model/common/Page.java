package net.lunar.zeus.model.common;

public class Page<T> extends PageSupport {

	private static final long serialVersionUID = -8981828149722503186L;
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
