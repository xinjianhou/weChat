package com.shunxin.wechat.service.event;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
public class BaseEvent implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8737409873085893820L;

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
	 * @Fields Event : TODO
	 */
	private String Event;
}
