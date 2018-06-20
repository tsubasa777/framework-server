package net.lunar.hypnos.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.lunar.hypnos.context.BeetlSqlProperties;
import net.lunar.hypnos.interceptor.DebugLogInterceptor;
import net.lunar.hypnos.interceptor.DefaultLogInterceptor;
import net.lunar.hypnos.uidGen.HypnosUidGenerator;
import net.lunar.zeus.uid.UidGenerator;

@Configuration
public class BeetSqlConfig {
	/**
	 * 
	 * @return
	 */
	@Bean("beetlSqlProperties")
	public BeetlSqlProperties beetlSqlProperties() {
		System.out.println("new beetlprop");
		return new BeetlSqlProperties();
	}
	
	@Bean("hypnosUidGenerator")
	public HypnosUidGenerator hypnosUidGenerator(@Qualifier("uidGenerator") UidGenerator uidGenerator) {
		HypnosUidGenerator hypnosUidGenerator = new HypnosUidGenerator();
		hypnosUidGenerator.setUidGenerator(uidGenerator);
		return hypnosUidGenerator;
	}
    
    
    @Bean("sqlManagerFactoryBean")
    public SqlManagerFactoryBean sqlManagerFactoryBean(@Qualifier("datasource") DataSource datasource, @Qualifier("beetlSqlProperties") BeetlSqlProperties beetlSqlProperties, HypnosUidGenerator hypnosUidGenerator) {
		BeetlSqlDataSource source = new BeetlSqlDataSource();
    	source.setMasterSource(datasource);
    	
    	String dialect = beetlSqlProperties.getDialect();
        String dialectClassName = dialect;//env.getProperty(dialect.toLowerCase(), "org.beetl.sql.core.db.MySqlStyle");
    	
    	DBStyle dbStyle = null;
        try {
			Class driverClass = Class.forName(dialectClassName);
			dbStyle = (DBStyle) driverClass.newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        factory.setCs(source);
        factory.setDbStyle(dbStyle);
    	
        List<Interceptor> interceptors = new ArrayList<Interceptor>();
        // debug模式
        boolean debugMode = beetlSqlProperties.isShowSqlDebug();
        if(debugMode) {
        	interceptors.add(new DebugLogInterceptor());
        } else {
        	interceptors.add(new DefaultLogInterceptor());
        }
        factory.setInterceptors(interceptors.toArray(new Interceptor[interceptors.size()]));
        
        // 开启驼峰
        factory.setNc(new UnderlinedNameConversion());
        
        // sql文件路径
        String mapperSource = beetlSqlProperties.getMapperSource();
        factory.setSqlLoader(new ClasspathLoader(mapperSource));
        
        try {
			factory.getObject().addIdAutonGen("hypnosUid", hypnosUidGenerator);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    	return factory;
    }
    
}
