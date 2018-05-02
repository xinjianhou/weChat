package com.xinjian.wechat.util;

import java.util.Properties;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
public class GlobalConstants {
	/**
	 * @Fields interfaceUrlProperties : TODO
	 */
	public static Properties interfaceUrlProperties;

	/**
	 * <p>Title: getBoolean </p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static Boolean getBoolean(final String key) {
		final String Properties = (String) interfaceUrlProperties.get(key);
		return Properties == null ? null : Boolean.valueOf(Properties);
	}

	/**
	 * <p>Title: getInt </p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static Integer getInt(final String key) {
		final String Properties = (String) interfaceUrlProperties.get(key);
		return Properties == null ? null : Integer.parseInt(Properties);
	}

	/**
	 * <p>Title: getLong </p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static Long getLong(final String key) {
		final String Properties = (String) interfaceUrlProperties.get(key);
		return Properties == null ? null : Long.valueOf(Properties);
	}

	/**
	 * <p>Title: getString </p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static String getString(final String key) {
		final String Properties = (String) interfaceUrlProperties.get(key);
		return Properties == null ? null : Properties;
	}
}
