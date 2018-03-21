package com.shunxin.wechat.service.message.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LocationReqMessage extends BaseReqMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 9031933999504865439L;

	/**
	 * @Fields location_X : TODO
	 */
	private String Location_X;

	/**
	 * @Fields location_Y : TODO
	 */
	private String Location_Y;

	/**
	 * @Fields scale : TODO
	 */
	private String Scale;

	/**
	 * @Fields label : TODO
	 */
	private String Label;

}
