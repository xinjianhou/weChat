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
public class LinkReqMessage extends BaseReqMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 8839082105248687793L;

	/**
	 * @Fields title : TODO
	 */
	private String Title;

	/**
	 * @Fields description : TODO
	 */
	private String Description;


	/**
	 * @Fields Url : TODO
	 */
	private String Url;


}
