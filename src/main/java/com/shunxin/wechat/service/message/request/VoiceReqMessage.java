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
public class VoiceReqMessage extends BaseReqMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1618571466973146856L;

	/**
	 * @Fields mediaId : TODO
	 */
	private String MediaId;

	/**
	 * @Fields format : TODO
	 */
	private String Format;

	/**
	 * @Fields Recognition : TODO
	 */
	private String Recognition;
}
