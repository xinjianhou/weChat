package com.xinjian.wechat.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.xinjian.wechat.service.message.response.Article;
import com.xinjian.wechat.service.message.response.Image;
import com.xinjian.wechat.service.message.response.ImageResMessage;
import com.xinjian.wechat.service.message.response.Music;
import com.xinjian.wechat.service.message.response.MusicResMessage;
import com.xinjian.wechat.service.message.response.NewsResMessage;
import com.xinjian.wechat.service.message.response.TextResMessage;
import com.xinjian.wechat.service.message.response.Video;
import com.xinjian.wechat.service.message.response.VideoResMessage;
import com.xinjian.wechat.service.message.response.Voice;
import com.xinjian.wechat.service.message.response.VoiceResMessage;


/**
 * <p>Title: MessageUtil</p>
 * <p>Description: 消息工具类</p>
 * @author xinjianhou
 * @date Mar 12, 2018
 */
public class MessageUtil {

	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 返回消息类型：语音
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	/**
	 * 返回消息类型：多客服消息
	 */
	public static final String RESP_MESSAGE_TYPE_CUSTOMER = "";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：小视频
	 */
	public static final String REQ_MESSAGE_TYPE_SHORT_VIDEO = "shortvideo";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：事件推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：SCAN(扫描订阅)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(点击菜单跳转链接)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

	/**
	 * 事件类型：LOCATION(上报地理位置)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * @Fields xstream : TODO
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(final Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有 xml 节点的转换都增加 CDATA 标记
				boolean cdata = true;

				@Override
				@SuppressWarnings("rawtypes")
				public void startNode(final String name, final Class clazz) {
					super.startNode(name, clazz);
				}

				@Override
				protected void writeText(final QuickWriter writer, final String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description:转换图片响应信息 </p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final  ImageResMessage resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		xstream.alias("Image", new Image().getClass());
		return xstream.toXML(resMessage);
	}
	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description:转换音乐响应信息</p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final  MusicResMessage resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		xstream.alias("music", new Music().getClass());
		return xstream.toXML(resMessage);
	}
	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description:转换图文响应信息 </p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final  NewsResMessage resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(resMessage);
	}
	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description: 转换文本响应信息</p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final TextResMessage resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		return xstream.toXML(resMessage);
	}

	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description:转换视频响应信息 </p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final VideoResMessage  resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		xstream.alias("Video", new Video().getClass());
		return xstream.toXML(resMessage);
	}
	/**
	 * <p>Title: messageToXML </p>
	 * <p>Description:转换语音响应信息 </p>
	 * @param resMessage
	 * @return
	 */
	public static String messageToXML(final VoiceResMessage  resMessage) {
		xstream.alias("xml",resMessage.getClass() );
		xstream.alias("Voice", new Voice().getClass());
		return xstream.toXML(resMessage);
	}
	/**
	 * <p>Title: parseXml </p>
	 * <p>Description: 格式化转义XML</p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(final HttpServletRequest request) throws Exception {
		// 将解析结果存储在 HashMap 中
		final Map<String, String> map = new HashMap<String, String>();

		// 从 request 中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		final SAXReader reader = new SAXReader();
		final Document document = reader.read(inputStream);
		// 得到 xml 根元素
		final Element root = document.getRootElement();
		// 得到根元素的所有子节点
		final List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (final Element e : elementList) {
			map.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

}
