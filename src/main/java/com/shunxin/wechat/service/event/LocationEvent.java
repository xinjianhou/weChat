package com.shunxin.wechat.service.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LocationEvent extends BaseEvent {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5329202869363909886L;

	/**
	 * @Fields Latitude : TODO
	 */
	private String Latitude;

	/**
	 * @Fields Longitude : TODO
	 */
	private String Longitude;

	/**
	 * @Fields Precision : TODO
	 */
	private String Precision;

}
