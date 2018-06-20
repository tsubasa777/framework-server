package net.lunar.hypnos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import net.lunar.hypnos.context.BeetlSqlProperties;
import net.lunar.hypnos.context.DataSourceProperties;

/**
 * 数据源和事物配置
 * @author Michael
 * @version 1.0.0
 */
@Configuration
public class SimpleDataSourceConfig {
	
	/**
	 * 数据源配置
	 * @return
	 */
	@Bean("dataSourceProperties")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	/**
	 * 生成数据源
	 * @param dataSourceProperties
	 * @return
	 */
	@Bean("datasource")
	@Primary
	public DataSource dataSource(@Qualifier("dataSourceProperties") DataSourceProperties dataSourceProperties) {
		System.out.println("url -->" + dataSourceProperties.getUrl());
		DruidDataSource druidDataSource = (DruidDataSource)dataSourceProperties.initializeDataSource();
		System.out.println("create datasource-->"+druidDataSource);
		return druidDataSource;
	}
	
	/**
     * 开启事务
     * 
     * @param datasource
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager getDataSourceTransactionManager(@Qualifier("datasource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }
}
