package net.lunar.zeus.model.bo;

import net.lunar.zeus.model.common.ResultSupport;

public class SimpleErrorResult<T> extends ResultSupport<T>{

	private static final long serialVersionUID = -1024650502273391492L;

	public boolean isSucssess() {
		return false;
	}
	
	public SimpleErrorResult(String code, String desc) {
		super.setCode(code);
		super.setDesc(desc);
	}
}
