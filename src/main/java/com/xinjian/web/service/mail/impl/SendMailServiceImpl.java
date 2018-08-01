/**
 * @Title: SentMailServiceImpl.java
 * @Package com.xinjian.web.service.mail.impl
 * @Description: TODO
 * @author xinjianhou
 * @date May 8, 2018 8:15:24 PM
 * @version V1.0
 */

package com.xinjian.web.service.mail.impl;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.stereotype.Service;

import com.xinjian.web.service.mail.ISendMailService;
import com.xinjian.wechat.util.GlobalConstants;

/**
 * <p>Title: SentMailServiceImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 8, 2018
 */
@Service("sendMailServiceImpl")
public class SendMailServiceImpl implements ISendMailService {

	/**
	 * <p>Title: createMimeMessage </p>
	 * <p>Description: </p>
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @return
	 * @throws Exception
	 */
	private MimeMessage createMimeMessage(final Session session, final String sendMail, final String receiveMail, final String picture, final String file, final String title, final String content) throws Exception {
		final MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人
		message.setFrom(new InternetAddress(sendMail, "WeChat", "UTF-8"));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.addRecipient(RecipientType.TO, new InternetAddress(receiveMail, "hello", "UTF-8"));

		// 4. Subject: 邮件主题
		message.setSubject(title);

		/*
		 * 下面是邮件内容的创建:
		 */

		final MimeBodyPart text = new MimeBodyPart();
		// 7. （文本+图片）设置 文本 和 图片 “节点”的关系（将 文本 和 图片 “节点”合成一个混合“节点”）
		final MimeMultipart mm_text_image = new MimeMultipart();
		final MimeBodyPart text_image = new MimeBodyPart();
		// 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
		final MimeMultipart mm = new MimeMultipart();
		// 5. 创建图片“节点”
		if(null != picture && new File(picture).exists()) {
			final MimeBodyPart image = new MimeBodyPart();
			final DataHandler dh = new DataHandler(new FileDataSource(picture)); // 读取本地文件
			image.setDataHandler(dh);                   // 将图片数据添加到“节点”
			image.setContentID("image_fairy_tail");     // 为“节点”设置一个唯一编号（在文本“节点”将引用该ID）

			// 6. 创建文本“节点”

			//    这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
			text.setContent(content+"<br/><img src='cid:image_fairy_tail'/>", "text/html;charset=UTF-8");


			mm_text_image.addBodyPart(text);
			mm_text_image.addBodyPart(image);
			mm_text_image.setSubType("related");    // 关联关系

			// 8. 将 文本+图片 的混合“节点”封装成一个普通“节点”
			//    最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
			//    上面的 mm_text_image 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart

		}else {
			text.setContent(content, "text/html;charset=UTF-8");
			mm_text_image.addBodyPart(text);

		}

		text_image.setContent(mm_text_image);
		if(null != file && new File(file).exists()) {
			// 9. 创建附件“节点”
			final MimeBodyPart attachment = new MimeBodyPart();
			final DataHandler dh2 = new DataHandler(new FileDataSource(file));  // 读取本地文件
			attachment.setDataHandler(dh2);                                             // 将附件数据添加到“节点”
			attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // 设置附件的文件名（需要编码）


			mm.addBodyPart(text_image);
			mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
			mm.setSubType("mixed");//混合关系

		}else {
			mm.addBodyPart(text_image);
		}
		// 11. 设置整个邮件的关系（将最终的混合“节点”作为邮件的内容添加到邮件对象）
		message.setContent(mm);



		// 12. 设置发件时间
		message.setSentDate(new Date());

		// 13. 保存上面的所有设置
		message.saveChanges();

		return message;
	}
	/* (non-Javadoc)
	 * @see com.xinjian.web.service.mail.ISendMailService#sendMail()
	 */
	@Override
	public void sendMail(final String toMailAccount) throws Exception {
		final Properties props = new Properties();                    // 参数配置
		props.setProperty("mail.transport.protocol", GlobalConstants.getString("mail.transport.protocol"));   // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", GlobalConstants.getString("mail.smtp.host"));   // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", GlobalConstants.getString("mail.smtp.auth"));


		final Session session = Session.getInstance(props);
		session.setDebug(true);

		final MimeMessage message = createMimeMessage(session, GlobalConstants.getString("mail.account"), toMailAccount, null, null, "hello", "nihaoma");

		// 4. 根据 Session 获取邮件传输对象
		final Transport transport = session.getTransport();
		//PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
		transport.connect(GlobalConstants.getString("mail.account"), GlobalConstants.getString("mail.password"));

		//发送邮件
		transport.sendMessage(message, message.getAllRecipients());

		// 7. 关闭连接
		transport.close();
	}


}
