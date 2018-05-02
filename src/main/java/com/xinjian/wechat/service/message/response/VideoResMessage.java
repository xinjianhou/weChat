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
public class VideoResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7267225431154061991L;
	/**
	 * @Fields video : TODO
	 */
	private Video Video;

}
