/**
 * @Title: EventType.java
 * @Package com.xinjian.wechat.strategy.type
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 17, 2018 10:20:51 PM
 * @version V1.0
 */

package com.xinjian.wechat.strategy.type;

import com.xinjian.wechat.service.event.LocationEvent;
import com.xinjian.wechat.service.event.MenuEvent;
import com.xinjian.wechat.service.event.QRCodeEvent;
import com.xinjian.wechat.service.event.SubscribeEvent;

/**
 * <p>Title: EventType
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author xinjianhou
 * @date Apr 17, 2018
 */
public enum EventType {

	/**
	 * @Fields CLICK_EVENT : TODO
	 */
	CLICK_EVENT("CLICK", "menuEventStrategy",MenuEvent.class),
	/**
	 * @Fields VIEW_EVENT : TODO
	 */
	VIEW_EVENT("VIEW", "menuEventStrategy",MenuEvent.class),
	/**
	 * @Fields SCAN_EVENT : TODO
	 */
	SCAN_EVENT("SCAN", "QRCodeEventStrategy",QRCodeEvent.class),
	/**
	 * @Fields SUBSCRIBE_EVENT : TODO
	 */
	SUBSCRIBE_EVENT("subscribe", "subscribeEventStrategy",SubscribeEvent.class),
	/**
	 * @Fields UNSUBSCRIBE_EVENT : TODO
	 */
	UNSUBSCRIBE_EVENT("unsubscribe", "subscribeEventStrategy",SubscribeEvent.class),
	/**
	 * @Fields LOCATION_EVENT : TODO
	 */
	LOCATION_EVENT("LOCATION", "locationEventStrategy",LocationEvent.class);

	/**
	 * <p>Title: getTypeByCode </p>
	 * <p>Description: </p>
	 * @param code
	 * @return
	 */
	public static EventType getTypeByCode(final String code) {

		final EventType defalutType = EventType.SUBSCRIBE_EVENT;
		for (final EventType eType : EventType.values()) {
			if (code.equals(eType.getCode())) {
				return eType;
			}
		}
		return defalutType;
	}

	/**
	 * @Fields code : TODO
	 */
	private String code;

	/**
	 * @Fields event : TODO
	 */
	private String event;

	/**
	 * @Fields beanClass : TODO
	 */
	private Class<?>  beanClass;

	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param code
	 * @param event
	 * @param beanClass
	 */
	private EventType(final String code, final String event, final Class<?>  beanClass) {
		this.code = code;
		this.event = event;
		this.beanClass=beanClass;
	}

	/**
	 * @return the beanClass
	 */
	public Class<?> getBeanClass() {
		return beanClass;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}


}
