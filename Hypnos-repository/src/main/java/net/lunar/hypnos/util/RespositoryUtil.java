package net.lunar.hypnos.util;

import org.springframework.util.ObjectUtils;

import net.lunar.hypnos.model.entity.BaseEntity;

public class RespositoryUtil {
	
	
	public static boolean isNewRecord(BaseEntity entity) {
		if(entity == null) {
			return true;
		}
		return ObjectUtils.isEmpty(entity.getId());
	}
	
	
}
