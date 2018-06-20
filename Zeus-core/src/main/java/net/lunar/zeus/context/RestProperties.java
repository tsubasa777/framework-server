package net.lunar.zeus.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zeus.rest")
public class RestProperties {
	private int connectTimeout;
	
	private int connectionRequestTimeout;

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public void setConnectionRequestTimeout(int connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}
	
}
