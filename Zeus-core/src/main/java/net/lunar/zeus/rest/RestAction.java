package net.lunar.zeus.rest;

import net.lunar.zeus.utils.JsonUtil;

public class RestAction<T> {
	
	private String url;
	
	private String action;
	
	private T params;

	public String getUrlAction() {
		return url + "/" + action;
	}
	
	public String getJsonParams() {
		return JsonUtil.toString(params);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public T getParams() {
		return params;
	}

	public void setParams(T params) {
		this.params = params;
	}
	
	public static <P> RestAction<P> newInstance(Class<P> clazz) {
		return new RestAction<P>();
	}

}
