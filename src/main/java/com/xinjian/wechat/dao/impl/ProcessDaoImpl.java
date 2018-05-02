/**
 * @Title: ProcessDaoImpl.java
 * @Package com.xinjian.wechat.dao.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 16, 2018 9:57:22 PM
 * @version V1.0
 */

package com.xinjian.wechat.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinjian.wechat.dao.IProcessDao;
import com.xinjian.wechat.mapper.service.WeChatEventMapper;
import com.xinjian.wechat.mapper.service.WeChatExceptionMapper;
import com.xinjian.wechat.mapper.service.WeChatLocationEventMapper;
import com.xinjian.wechat.mapper.service.WeChatMenuEventMapper;
import com.xinjian.wechat.mapper.service.WeChatMessageMapper;
import com.xinjian.wechat.mapper.service.WeChatQRCodeEventMapper;
import com.xinjian.wechat.mapper.service.WeChatTextMessageMapper;
import com.xinjian.wechat.pojo.service.WeChatEvent;
import com.xinjian.wechat.pojo.service.WeChatException;
import com.xinjian.wechat.pojo.service.WeChatLocationEvent;
import com.xinjian.wechat.pojo.service.WeChatMenuEvent;
import com.xinjian.wechat.pojo.service.WeChatMessage;
import com.xinjian.wechat.pojo.service.WeChatQRCodeEvent;
import com.xinjian.wechat.pojo.service.WeChatTextMessage;

/**
 * <p>Title: ProcessDaoImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 16, 2018
 */
@Repository
public class ProcessDaoImpl implements IProcessDao {
	/**
	 * @Fields eventMapper : TODO
	 */
	@Autowired
	private WeChatEventMapper eventMapper;

	/**
	 * @Fields qrCodeMapper : TODO
	 */
	@Autowired
	private WeChatQRCodeEventMapper qrCodeMapper;

	/**
	 * @Fields exceptionMapper : TODO
	 */
	@Autowired
	private WeChatExceptionMapper exceptionMapper;

	/**
	 * @Fields menuMapper : TODO
	 */
	@Autowired
	private WeChatMenuEventMapper menuMapper;

	/**
	 * @Fields locationMapper : TODO
	 */
	@Autowired
	private WeChatLocationEventMapper locationMapper;

	/**
	 * @Fields messageMapper : TODO
	 */
	@Autowired
	private WeChatMessageMapper messageMapper;

	/**
	 * @Fields textMessageMapper : TODO
	 */
	@Autowired
	private WeChatTextMessageMapper textMessageMapper;


	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#deteterEvent(java.lang.String)
	 */
	@Override
	public int deteterEvent(final String fromUserName) {
		return eventMapper.deleteByFromUserName(fromUserName);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#findEventItem(com.xinjian.wechat.pojo.service.WeChatEvent)
	 */
	@Override
	public WeChatEvent findEventItem(final WeChatEvent record) {

		return eventMapper.findItem(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#findMessageItem(com.xinjian.wechat.pojo.service.WeChatMessage)
	 */
	@Override
	public WeChatMessage findMessageItem(final WeChatMessage record) {

		return messageMapper.findItem(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insert(com.xinjian.wechat.pojo.service.WeChatEvent)
	 */
	@Override
	public int insertEvent(final WeChatEvent record) {
		eventMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertException(com.xinjian.wechat.pojo.service.WeChatException)
	 */
	@Override
	public int insertException(final WeChatException record) {
		exceptionMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertlocationEvent(com.xinjian.wechat.pojo.service.WeChatLocationEvent)
	 */
	@Override
	public int insertlocationEvent(final WeChatLocationEvent record) {
		locationMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertMenuEvent(com.xinjian.wechat.pojo.service.WeChatMenuEvent)
	 */
	@Override
	public int insertMenuEvent(final WeChatMenuEvent record) {
		menuMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertMessage(com.xinjian.wechat.pojo.service.WeChatMessage)
	 */
	@Override
	public int insertMessage(final WeChatMessage record) {
		messageMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertQRCodeEvent(com.xinjian.wechat.pojo.service.WeChatQRCodeEvent)
	 */
	@Override
	public int insertQRCodeEvent(final WeChatQRCodeEvent record) {
		qrCodeMapper.insert(record);
		return  record.getId();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IProcessDao#insertTextMessage(com.xinjian.wechat.pojo.service.WeChatTextMessage)
	 */
	@Override
	public int insertTextMessage(final WeChatTextMessage record) {
		textMessageMapper.insert(record);
		return  record.getId();

	}


}
