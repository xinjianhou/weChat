package com.xinjian.wechat.service.message.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VoiceResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6883714120104464095L;
	/**
	 * @Fields voice : TODO
	 */
	private Voice Voice;
}
