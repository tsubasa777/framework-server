package net.lunar.zeus.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import net.lunar.zeus.context.RestProperties;
import net.lunar.zeus.rest.RestProcessor;

/**
 * Rest请求模版配置
 * @author Michael
 * @version 1.0.0
 */
@Configuration
public class RestProcessorConfig {
	
	@Bean("restProperties")
	public RestProperties restProperties() {
		return new RestProperties();
	}
	
	public RestProcessorConfig() {
		System.out.println("rest constrct");
	}
	
	@Bean("restRequestFactory")
	public ClientHttpRequestFactory restRequestFactory(@Qualifier("restProperties") RestProperties restProperties) {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(restProperties.getConnectionRequestTimeout());
		requestFactory.setConnectTimeout(restProperties.getConnectTimeout());
		return requestFactory;
	}
	
	@Bean("loadBalancedRestTemplate")
//	@LoadBanlanced
	public RestTemplate loadBalancedRestTemplate(@Qualifier("restRequestFactory") ClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(clientHttpRequestFactory);
		return restTemplate;
	}
	
	@Bean(name="loadBalancedRestProcessor")
	public RestProcessor loadBalancedRestProcessor(@Qualifier("loadBalancedRestTemplate") RestTemplate restTemplate) {
		RestProcessor restProcessor = new RestProcessor();
		restProcessor.setRestTemplate(restTemplate);
		return restProcessor;
	}
	
	@Bean("simpleRestTemplate")
	public RestTemplate simpleRestTemplate(@Qualifier("restRequestFactory") ClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(clientHttpRequestFactory);
		return restTemplate;
	}
	
	@Bean(name="simpleRestProcessor")
	public RestProcessor simpleRestProcessor(@Qualifier("simpleRestTemplate") RestTemplate restTemplate) {
		RestProcessor restProcessor = new RestProcessor();
		restProcessor.setRestTemplate(restTemplate);
		return restProcessor;
	}
	
}
