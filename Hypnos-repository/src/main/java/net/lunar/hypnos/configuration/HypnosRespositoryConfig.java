package net.lunar.hypnos.configuration;

import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@Configuration
@Import(BeetSqlConfig.class)
public class HypnosRespositoryConfig {
	/**
     * 配置包扫描
     * @Qualifier("beetlSqlProperties") BeetlSqlProperties beetlSqlProperties
     * @param beetlSqlProperties 
     * @return
	 */
	@Bean("beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer beetlSqlScannerConfigurer(Environment env) {
        BeetlSqlScannerConfigurer config = new BeetlSqlScannerConfigurer();
        config.setBasePackage(env.getProperty("hypnos.base-package"));
        config.setDaoSuffix(env.getProperty("hypnos.mapper-suffix"));
        config.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return config;
    }
	
}
