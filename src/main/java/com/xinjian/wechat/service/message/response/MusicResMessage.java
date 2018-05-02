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
public class MusicResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -544522201728603324L;
	/**
	 * @Fields music : TODO
	 */
	private Music Music;
}
