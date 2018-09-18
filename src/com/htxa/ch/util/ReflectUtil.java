package com.htxa.ch.util;


import java.lang.reflect.Field;
import java.util.Map;

//@Log4j
public class ReflectUtil {
	public static void setProperty(Object bean, String propertyName, String value){
//		Assert.isNull(bean, "设置属性的对象不能为空");
//		Assert.isNull(propertyName, "设置的对象属性不能为空");
		try {
			Class clazz = bean.getClass();
			Field field = clazz.getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(bean, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量设置属性
	 * @param bean
	 * @param fieldValueMap
	 */
	public static void setProperty(Object bean, Map<String,String> fieldValueMap){
//		Assert.isNull(bean, "设置属性的对象不能为空");
//		Assert.isNull(fieldValueMap, "设置的fieldValueMap不能为空");
		try {
			Class clazz = bean.getClass();
			for(Map.Entry<String, String> entry : fieldValueMap.entrySet()){
				Field field = clazz.getDeclaredField(entry.getKey());
				field.setAccessible(true);
				field.set(bean, entry.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		Features bean = new Features();
//		ReflectUtil.setProperty(bean, "fromwho", "sanling");
//		ReflectUtil.setProperty(bean, "towho", "30");
//
//		System.out.println(bean.getFromwho()+","+bean.getTowho());
//	}

}
