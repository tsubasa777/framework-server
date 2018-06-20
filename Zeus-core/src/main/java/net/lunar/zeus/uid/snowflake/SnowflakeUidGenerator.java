package net.lunar.zeus.uid.snowflake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.lunar.zeus.context.SnowflakeUidProperties;
import net.lunar.zeus.uid.UidGenerator;

/**
 * SnowflowId发号器
 * @author Michael
 * @version 1.0.0
 */
public class SnowflakeUidGenerator implements UidGenerator {
	
	private SnowflakeUidWorker snowflakeUidWorker;
	
	public SnowflakeUidGenerator(long workerId, long datacenterId) {
		this.snowflakeUidWorker = new SnowflakeUidWorker(workerId, datacenterId);
	}
	
	@Override
	public long nextId() {
		return snowflakeUidWorker.nextId();
	}

	@Override
	public String nextIdStr() {
		return String.valueOf(snowflakeUidWorker.nextId());
	}

}
