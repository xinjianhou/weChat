package com.xinjian.wechat.service.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class QRCodeEvent extends BaseEvent {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 5489124910102319372L;

	/**
	 * @Fields eventKey : TODO
	 */
	private String EventKey;

	/**
	 * @Fields ticket : TODO
	 */
	private String Ticket;

}
