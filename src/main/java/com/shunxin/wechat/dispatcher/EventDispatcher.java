/**
 * @Title: EventDispatcher.java
 * @Package com.shunxin.wechart.dispatcher
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 12, 2018 8:47:42 PM
 * @version V1.0
 */

package com.shunxin.wechat.dispatcher;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.shunxin.wechat.service.message.response.Image;
import com.shunxin.wechat.service.message.response.ImageResMessage;
import com.shunxin.wechat.util.HttpPostUploadUtil;
import com.shunxin.wechat.util.MessageUtil;

import net.sf.json.JSONObject;

/**
 * <p>Title: EventDispatcher</p>
 * <p>Description: 事件处理分发器</p>
 * @author xinjianhou
 * @date Mar 12, 2018
 */
public class EventDispatcher {

	/**
	 * <p>Title: processEvent </p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	public static String processEvent(final Map<String, String> map) {

		final String openid = map.get("FromUserName"); // 用户openid
		final String mpid = map.get("ToUserName"); // 公众号原始ID
		final ImageResMessage imgmsg = new ImageResMessage();
		imgmsg.setToUserName(openid);
		imgmsg.setFromUserName(mpid);
		imgmsg.setCreateTime(new Date().getTime());
		imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
		switch(map.get("Event")){
		case MessageUtil.EVENT_TYPE_CLICK:
			System.out.println("=============click");
			break;
		case MessageUtil.EVENT_TYPE_SUBSCRIBE:
			System.out.println("============sub");
			final Image img = new Image();
			final HttpPostUploadUtil util=new HttpPostUploadUtil("image");
			final String filepath="/Users/xinjianhou/Downloads/IMG_7493.JPG";
			final Map<String, String> textMap = new HashMap<String, String>();
			textMap.put("name", "testname");
			final Map<String, String> fileMap = new HashMap<String, String>();
			fileMap.put("userfile", filepath);
			final String mediaidrs = util.formUpload(textMap, fileMap);
			System.out.println(mediaidrs);
			final String mediaid=JSONObject.fromObject(mediaidrs).getString("media_id");
			img.setMediaId(mediaid);
			imgmsg.setImage(img);
			break;
		case MessageUtil.EVENT_TYPE_UNSUBSCRIBE:
			System.out.println("============unsub");
			break;
		case MessageUtil.EVENT_TYPE_SCAN:
			System.out.println("===============scan");
			break;
		case MessageUtil.EVENT_TYPE_VIEW:
			System.out.println("============view");
			break;
		case MessageUtil.EVENT_TYPE_LOCATION:
			System.out.println("=============location");
			break;
		}
		return MessageUtil.messageToXML(imgmsg);
	}

}
