package net.lunar.zeus.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 
 * @author Michael
 * @version 1.0.0
 */
public class MapUtil {
	
	/**
	 * 
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> convertToMap(Object bean) {
		Map<String, Object> result = new TreeMap<String, Object>();
		
		// commons-beanutils
		for(PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(bean.getClass())) {
			if("class".equals(pd.getName())) {
				continue;
			}
			
			try {
				Object value = PropertyUtils.getProperty(bean, pd.getName());
				result.put(pd.getName(), value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static <T> T convertToBean(Map<String, Object> map, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			
			for(Entry<String, Object> entry : map.entrySet()) {
				PropertyUtils.setProperty(bean, entry.getKey(), entry.getValue());
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
