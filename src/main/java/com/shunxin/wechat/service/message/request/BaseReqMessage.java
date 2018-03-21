package com.shunxin.wechat.service.message.request;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
public class BaseReqMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 8988639240719712929L;

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

	/**
	 * @Fields msgId : TODO
	 */
	private long MsgId;


}
