/**
 * @Title: MessageType.java
 * @Package com.xinjian.wechat.strategy.type
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 23, 2018 10:37:39 AM
 * @version V1.0
 */

package com.xinjian.wechat.strategy.type;

import com.xinjian.wechat.service.message.request.TextReqMessage;

/**
 * <p>Title: MessageType</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 23, 2018
 */
public enum MessageType {

	TEXT_MESSAGE("text","textMessageStrategy",TextReqMessage.class),


	;

	public static MessageType getTypeByCode(final String code) {

		final MessageType defalutType = MessageType.TEXT_MESSAGE;
		for (final MessageType mType : MessageType.values()) {
			if (code.equals(mType.getCode())) {
				return mType;
			}
		}
		return defalutType;
	}

	/**
	 * @Fields code : TODO
	 */
	private String code;

	/**
	 * @Fields event : TODO
	 */
	private String message;

	/**
	 * @Fields beanClass : TODO
	 */
	private Class<?>  beanClass;


	private MessageType(final String code, final String message, final Class<?> beanClass) {
		this.code = code;
		this.message = message;
		this.beanClass = beanClass;
	}


	/**
	 * @return the beanClass
	 */
	public Class<?> getBeanClass() {
		return beanClass;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
