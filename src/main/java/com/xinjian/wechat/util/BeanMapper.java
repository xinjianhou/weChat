/**
 * @Title: BeanMapper.java
 * @Package com.xinjian.wechat.util
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 19, 2018 4:26:52 PM
 * @version V1.0
 */

package com.xinjian.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;

/**
 * <p>
 * Title: BeanMapper
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author xinjianhou
 * @date Apr 19, 2018
 */
public class BeanMapper {

	/**
	 * @Fields dozer : TODO
	 */
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	/**
	 * <p>
	 * Title: beanToMap
	 * </p>
	 * <p>
	 * Description: 将对象转为map
	 * </p>
	 *
	 * @param source
	 * @return
	 */
	public static Map<String, Object> beanToMap(final Object source) {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		dozer.map(source, map);
		return map;
	}

	/**
	 * <p>Title: mapToObject </p>
	 * <p>Description: </p>
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(final Map<String, String> map, final Class<?> beanClass) throws Exception {
		if (map == null) {
			return null;
		}

		Class<?> tempClass = beanClass;
		final Object obj = beanClass.newInstance();
		final List<Field> fieldList = new ArrayList<Field>();
		while (tempClass != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass(); // 得到父类,然后赋给自己
		}

		for (final Field field : fieldList) {
			final int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			if(!StringUtils.isBlank(map.get(field.getName()))){
				field.setAccessible(true);
				if (field.getType().getName().endsWith("long")) {
					field.set(obj, new Long(map.get(field.getName())));
				} else {
					field.set(obj, map.get(field.getName()));
				}

			}
		}

		return obj;

	}
}
