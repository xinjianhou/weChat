/**
 * @Title: IProcessDao.java
 * @Package com.xinjian.wechat.dao
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 16, 2018 9:55:49 PM
 * @version V1.0
 */

package com.xinjian.wechat.dao;

import com.xinjian.wechat.pojo.service.WeChatEvent;
import com.xinjian.wechat.pojo.service.WeChatException;
import com.xinjian.wechat.pojo.service.WeChatLocationEvent;
import com.xinjian.wechat.pojo.service.WeChatMenuEvent;
import com.xinjian.wechat.pojo.service.WeChatMessage;
import com.xinjian.wechat.pojo.service.WeChatQRCodeEvent;
import com.xinjian.wechat.pojo.service.WeChatTextMessage;

/**
 * <p>Title: IProcessDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 16, 2018
 */
public interface IProcessDao {


	/**
	 * <p>Title: deteterEvent </p>
	 * <p>Description: </p>
	 * @param fromUserName
	 * @return
	 */
	int deteterEvent(String fromUserName);

	/**
	 * <p>Title: findEventItem </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	WeChatEvent findEventItem(WeChatEvent record);

	/**
	 * <p>Title: findMessageItem </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	WeChatMessage findMessageItem(WeChatMessage record);
	/**
	 * <p>Title: insert </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertEvent(WeChatEvent record);

	/**
	 * <p>Title: insertException </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertException(WeChatException record);

	/**
	 * <p>Title: insertlocationEvent </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertlocationEvent(WeChatLocationEvent record);

	/**
	 * <p>Title: insertMenuEvent </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertMenuEvent(WeChatMenuEvent record);

	/**
	 * <p>Title: insertMessage </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertMessage(WeChatMessage record);

	/**
	 * <p>Title: insertQRCodeEvent </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertQRCodeEvent(WeChatQRCodeEvent record);

	/**
	 * <p>Title: insertTextMessage </p>
	 * <p>Description: </p>
	 * @param textMessage
	 */
	int insertTextMessage(WeChatTextMessage record);
}
