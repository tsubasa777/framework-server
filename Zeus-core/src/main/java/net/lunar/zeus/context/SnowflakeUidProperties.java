package net.lunar.zeus.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for uid generator
 * @author Michael
 * @version 1.0.0
 */
@ConfigurationProperties(prefix="zeus.uid")
public class SnowflakeUidProperties {

	/**  */
	private long workerId = 0L;
	
	/**  */
	private long datacenterId = 0L;

	public long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	public long getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(long datacenterId) {
		this.datacenterId = datacenterId;
	}

}
