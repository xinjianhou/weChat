package com.xinjian.wechat.dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xinjian.wechat.service.message.response.Article;
import com.xinjian.wechat.service.message.response.Image;
import com.xinjian.wechat.service.message.response.ImageResMessage;
import com.xinjian.wechat.service.message.response.NewsResMessage;
import com.xinjian.wechat.service.message.response.TextResMessage;
import com.xinjian.wechat.util.GlobalConstants;
import com.xinjian.wechat.util.MessageUtil;

/**
 * <p>Title: MsgDispatcher</p>
 * <p>Description:消息处理分发器 </p>
 * @author xinjianhou
 * @date Mar 12, 2018
 */
public class MsgDispatcher {

	/**
	 * <p>Title: processMessage </p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	public static String processMessage(final Map<String, String> map) {

		final String openid=map.get("FromUserName"); //用户 openid
		final String mpid=map.get("ToUserName");   //公众号原始 ID
		String msg = "";
		switch (map.get("MsgType")) {
		case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
			TextResMessage resMessage = new TextResMessage();
			resMessage.setToUserName(openid);
			resMessage.setFromUserName(mpid);
			resMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
			resMessage.setContent(GlobalConstants.getString("access_token"));
			resMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			msg = MessageUtil.messageToXML(resMessage);
			break;
		case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:
			System.out.println("================location");
			final NewsResMessage newmsg = new NewsResMessage();
			newmsg.setToUserName(openid);
			newmsg.setFromUserName(mpid);
			newmsg.setCreateTime(new Date().getTime());
			newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			final Article article=new Article();
			article.setDescription("这是图文消息 1"); //图文消息的描述
			article.setPicUrl("http://res.cuiyongzhi.com/2016/03/201603086749_6850.png"); //图文消息图片地址
			article.setTitle("图文消息 1");  //图文消息标题
			article.setUrl("http://www.cuiyongzhi.com");  //图文 url 链接
			final List<Article> list=new ArrayList<Article>();
			list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
			newmsg.setArticleCount(list.size());
			newmsg.setArticles(list);
			msg = MessageUtil.messageToXML(newmsg);
			break;
		case MessageUtil.REQ_MESSAGE_TYPE_VOICE:
			System.out.println("================voice");
			break;
		case MessageUtil.REQ_MESSAGE_TYPE_VIDEO:
			System.out.println("================video");
			break;
		case MessageUtil.REQ_MESSAGE_TYPE_SHORT_VIDEO:
			System.out.println("===============shortvideo");
			break;
		case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
			final Image img = new Image();
			final ImageResMessage imgmsg = new ImageResMessage();
			imgmsg.setToUserName(openid);
			imgmsg.setFromUserName(mpid);
			imgmsg.setCreateTime(new Date().getTime());
			imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);

			img.setMediaId("o538VwoHLrUkxbpnfrl9CIOvp40SAn3QMLHEwkYumGBaNn4KxOAb0p7bZGYOXXnB");
			imgmsg.setImage(img);
			msg = MessageUtil.messageToXML(imgmsg);
		default:
			resMessage = new TextResMessage();
		}
		return msg;
	}

}
