package com.xinjian.wechat.service.message.response;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>Title: TextResMessage</p>
 * <p>Description: 文本响应信息</p>
 * @author xinjianhou
 * @date Mar 13, 2018
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TextResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2497247563105645879L;
	/**
	 * @Fields content : TODO
	 */
	private String Content;

}
