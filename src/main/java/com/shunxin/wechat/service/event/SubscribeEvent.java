package com.shunxin.wechat.service.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
final @EqualsAndHashCode(callSuper=false)
public class SubscribeEvent extends BaseEvent {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 6226274925937414197L;

}
