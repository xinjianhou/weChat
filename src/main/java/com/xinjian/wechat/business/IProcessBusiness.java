/**
 * @Title: IProcessBusiness.java
 * @Package com.xinjian.wechat.business
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 16, 2018 7:48:36 PM
 * @version V1.0
 */

package com.xinjian.wechat.business;

import java.util.Map;

import com.xinjian.wechat.pojo.service.WeChatException;
import com.xinjian.wechat.service.event.LocationEvent;
import com.xinjian.wechat.service.event.MenuEvent;
import com.xinjian.wechat.service.event.QRCodeEvent;
import com.xinjian.wechat.service.event.SubscribeEvent;
import com.xinjian.wechat.service.message.request.TextReqMessage;

/**
 * <p>Title: IProcessBusiness</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 16, 2018
 */
public interface IProcessBusiness {

	/**
	 * <p>Title: processException </p>
	 * <p>Description: </p>
	 * @param e
	 */
	public void processException(WeChatException e,Map<String,String> map);

	/**
	 * <p>Title: processLocationEvent </p>
	 * <p>Description: </p>
	 * @param event
	 * @throws WeChatException
	 */
	public void processLocationEvent(LocationEvent event)throws WeChatException;

	/**
	 * <p>Title: processMenuEvent </p>
	 * <p>Description: </p>
	 * @param event
	 * @throws WeChatException
	 */
	public void processMenuEvent(MenuEvent event)throws WeChatException;

	/**
	 * <p>Title: processQRCodeEvent </p>
	 * <p>Description: </p>
	 * @param map
	 */
	public void processQRCodeEvent(QRCodeEvent event)throws WeChatException;

	/**
	 * <p>Title: processSubcribeEvent </p>
	 * <p>Description: </p>
	 * @param event
	 * @throws WeChatException
	 */
	public void processSubcribeEvent(SubscribeEvent event)throws WeChatException;

	/**
	 * <p>Title: processTextMessage </p>
	 * <p>Description: </p>
	 * @param message
	 * @throws WeChatException
	 */
	public void processTextMessage(TextReqMessage message)throws WeChatException;

}
