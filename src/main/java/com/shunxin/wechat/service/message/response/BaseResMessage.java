package com.shunxin.wechat.service.message.response;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
public class BaseResMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8424604178468551250L;

	/**
	 * @Fields toUserName : TODO
	 */
	private String ToUserName;

	/**
	 * @Fields fromUserName : TODO
	 */
	private String FromUserName;

	/**
	 * @Fields createTime : TODO
	 */
	private long CreateTime;

	/**
	 * @Fields msgType : TODO
	 */
	private String MsgType;

}
