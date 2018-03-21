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
public class MenuEvent extends BaseEvent {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5395161054079847701L;

	/**
	 * @Fields eventKey : TODO
	 */
	private String EventKey;
}
