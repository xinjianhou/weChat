/**
 * @Title: LocationEventStrategy.java
 * @Package com.xinjian.wechat.strategy.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 23, 2018 9:30:36 AM
 * @version V1.0
 */

package com.xinjian.wechat.strategy.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xinjian.wechat.business.IProcessBusiness;
import com.xinjian.wechat.pojo.service.WeChatException;
import com.xinjian.wechat.service.event.LocationEvent;
import com.xinjian.wechat.strategy.IStrategy;
import com.xinjian.wechat.util.BeanMapper;

/**
 * <p>Title: LocationEventStrategy</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 23, 2018
 */
@Component
public class LocationEventStrategy implements IStrategy {

	/**
	 * @Fields processBusiness : TODO
	 */
	@Autowired
	private IProcessBusiness processBusiness;


	/* (non-Javadoc)
	 * @see com.xinjian.wechat.strategy.IStrategy#process(java.util.Map, java.lang.Class)
	 */
	@Override
	public void process(final Map<String, String> map, final Class<?> T) {
		try {
			final LocationEvent bean= (LocationEvent) BeanMapper.mapToObject(map, T.getClass());

			processBusiness.processLocationEvent(bean);
		}catch(final WeChatException e) {
			processBusiness.processException(e,map);
		} catch (final Exception e) {
			e.printStackTrace();

		}

	}

}
