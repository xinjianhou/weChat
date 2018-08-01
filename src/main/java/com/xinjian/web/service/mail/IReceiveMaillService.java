/**
 * @Title: IReceiveMaillService.java
 * @Package com.xinjian.web.service.mail
 * @Description: TODO
 * @author xinjianhou
 * @date May 8, 2018 12:15:49 PM
 * @version V1.0
 */

package com.xinjian.web.service.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * <p>Title: IReceiveMaillService</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 8, 2018
 */

public interface IReceiveMaillService {

	/**
	 * <p>Title: deleteMessage </p>
	 * <p>Description: 删除邮件</p>
	 * @param messages
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void deleteMessage(final Message ...messages)throws MessagingException, IOException;

	/**
	 * <p>Title: getFrom </p>
	 * <p>Description: 获取邮件发送人</p>
	 * @param msg
	 * @return String
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public String getFrom(final MimeMessage msg) throws MessagingException, UnsupportedEncodingException;

	/**
	 * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
	 * <p>Message.RecipientType.TO  收件人</p>
	 * <p>Message.RecipientType.CC  抄送</p>
	 * <p>Message.RecipientType.BCC 密送</p>
	 * @param msg 邮件内容
	 * @param type 收件人类型
	 * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
	 * @throws MessagingException
	 */
	public String getReceiveAddress(final MimeMessage msg, final Message.RecipientType type) throws MessagingException;

	/**
	 * <p>Title: resceive </p>
	 * <p>Description: 接收邮件</p>
	 * @throws Exception
	 */
	public void resceive()throws Exception;
}
