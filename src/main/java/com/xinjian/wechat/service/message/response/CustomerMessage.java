/**
 * @Title: CustomerMessage.java
 * @Package com.xinjian.wechat.service.message.response
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 14, 2018 10:38:50 PM
 * @version V1.0
 */

package com.xinjian.wechat.service.message.response;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>Title: CustomerMessage</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 14, 2018
 */
@Data
public class CustomerMessage implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -2487780291826170424L;
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
}
