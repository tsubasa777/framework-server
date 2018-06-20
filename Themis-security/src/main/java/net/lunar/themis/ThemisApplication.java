package net.lunar.themis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Michael
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableTransactionManagement
public class ThemisApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(ThemisApplication.class, args);
	}
}
