package net.lunar.zeus.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.lunar.zeus.context.SnowflakeUidProperties;
import net.lunar.zeus.uid.UidGenerator;
import net.lunar.zeus.uid.snowflake.SnowflakeUidGenerator;

@Configuration
public class SnowflakeUidConfig {
	
	@Bean("snowflakeUidProperties")
	public SnowflakeUidProperties snowflakeUidProperties() {
		return new SnowflakeUidProperties();
	}
	
	@Bean("uidGenerator")
	public UidGenerator snowflakeUidGenerator(@Qualifier("snowflakeUidProperties") SnowflakeUidProperties snowflakeUidProperties) {
		UidGenerator uidGenerator = new SnowflakeUidGenerator(snowflakeUidProperties.getWorkerId(), snowflakeUidProperties.getDatacenterId());
		return uidGenerator;
	}
	
}
