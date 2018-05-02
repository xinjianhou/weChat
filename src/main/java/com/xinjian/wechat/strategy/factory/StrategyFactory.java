/**
 * @Title: EventStrategyFactory.java
 * @Package com.xinjian.wechat.strategy.factory
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 18, 2018 2:08:54 PM
 * @version V1.0
 */

package com.xinjian.wechat.strategy.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xinjian.wechat.strategy.IStrategy;

/**
 * <p>Title: EventStrategyFactory</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 18, 2018
 */
/**
 * <p>Title: EventStrategyFactory</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 19, 2018
 */
@Component
public class StrategyFactory {
	/**
	 * @Fields eventStrategy : TODO
	 */
	@Autowired
	private final   Map<String, IStrategy> strategy = new HashMap<String,IStrategy>();

	/**
	 * <p>Title: doStrategy </p>
	 * <p>Description: </p>
	 * @param type
	 * @return
	 */
	public IStrategy doStrategy(final String type){

		return this.strategy.get(type);
	}

	/**
	 * <p>Title: getEventStrategy </p>
	 * <p>Description: </p>
	 * @return
	 */
	public Map<String, IStrategy> getEventStrategy() {
		return strategy;
	}
}
