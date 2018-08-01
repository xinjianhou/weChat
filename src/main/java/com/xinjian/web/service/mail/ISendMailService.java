/**
 * @Title: ISentMailService.java
 * @Package com.xinjian.web.service.mail
 * @Description: TODO
 * @author xinjianhou
 * @date May 8, 2018 8:14:52 PM
 * @version V1.0
 */

package com.xinjian.web.service.mail;

/**
 * <p>Title: ISentMailService</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 8, 2018
 */
public interface ISendMailService {

	/**
	 * <p>Title: sendMail </p>
	 * <p>Description: </p>
	 */
	public void sendMail(String toMailAccount)throws Exception;

}
