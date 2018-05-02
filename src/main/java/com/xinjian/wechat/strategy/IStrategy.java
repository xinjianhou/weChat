/**
 * @Title: IEventStrategy.java
 * @Package com.xinjian.wechat.strategy
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 18, 2018 1:35:29 PM
 * @version V1.0
 */

package com.xinjian.wechat.strategy;

import java.util.Map;

/**
 * <p>Title: IEventStrategy</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 18, 2018
 */
public interface IStrategy {

	/**
	 * <p>Title: process </p>
	 * <p>Description: </p>
	 * @param map
	 */
	void process(final Map<String, String> map,Class<?> T);
}
