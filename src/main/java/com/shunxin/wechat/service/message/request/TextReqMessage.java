package com.shunxin.wechat.service.message.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TextReqMessage extends BaseReqMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -397264903885786566L;

	/**
	 * @Fields content : TODO
	 */
	private String Content;

}
