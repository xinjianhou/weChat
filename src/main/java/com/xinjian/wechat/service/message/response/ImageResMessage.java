package com.xinjian.wechat.service.message.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 10, 2018
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 67387944742518177L;

	/**
	 * @Fields image : TODO
	 */
	private Image Image;
}
