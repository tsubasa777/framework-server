package net.lunar.zeus.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * application context 工具
 * 
 * @author Michael
 * @version 1.0.0
 */
public class ApplicationContextUtil implements ApplicationContextAware{

	private static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
	
	public static ApplicationContext getContext() {
		return ctx;
	}
	
	/**
	 * 获取对象
	 * @param beanId 对象ID
	 * @param clazz 对象class类型
	 * @return
	 */
	public static <T> T getBean(String beanId, Class<T> clazz) {
		return (T)ctx.getBean(beanId);
	}
	
	/**
	 * 获取对象
	 * @param clazz 对象class类型
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return ctx.getBean(clazz);
	}

}
