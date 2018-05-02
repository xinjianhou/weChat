package com.xinjian.wechat.service.message.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class VideoReqMessage extends BaseReqMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6771215794663150769L;

	/**
	 * @Fields mediaId : TODO
	 */
	private String MediaId;

	/**
	 * @Fields thumbMediaId : TODO
	 */
	private String ThumbMediaId;


}
