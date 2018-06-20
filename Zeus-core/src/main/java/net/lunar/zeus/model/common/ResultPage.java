package net.lunar.zeus.model.common;

import java.util.Collection;

public class ResultPage<T> extends PageSupport {
	
	private static final long serialVersionUID = -3085324154244990454L;
	
	private Collection<T> resultList;

	public Collection<T> getResultList() {
		return resultList;
	}

	public void setResultList(Collection<T> resultList) {
		this.resultList = resultList;
	}
	
}
