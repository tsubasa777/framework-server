package net.lunar.themis.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.lunar.hypnos.configuration.HypnosRespositoryConfig;
import net.lunar.hypnos.configuration.SimpleDataSourceConfig;
import net.lunar.zeus.configuration.RestProcessorConfig;
import net.lunar.zeus.configuration.SnowflakeUidConfig;

@Configuration
@Import({
	SimpleDataSourceConfig.class,
	SnowflakeUidConfig.class,
	RestProcessorConfig.class,
	HypnosRespositoryConfig.class
})
public class ThemisSecurityConfig {
	
}
