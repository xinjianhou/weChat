/**
 * @Title: ProcessBusinessImpl.java
 * @Package com.xinjian.wechat.business.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 16, 2018 7:51:09 PM
 * @version V1.0
 */

package com.xinjian.wechat.business.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinjian.web.dozer.BeanMapperService;
import com.xinjian.wechat.business.IProcessBusiness;
import com.xinjian.wechat.dao.IProcessDao;
import com.xinjian.wechat.pojo.service.WeChatEvent;
import com.xinjian.wechat.pojo.service.WeChatException;
import com.xinjian.wechat.pojo.service.WeChatLocationEvent;
import com.xinjian.wechat.pojo.service.WeChatMenuEvent;
import com.xinjian.wechat.pojo.service.WeChatMessage;
import com.xinjian.wechat.pojo.service.WeChatQRCodeEvent;
import com.xinjian.wechat.pojo.service.WeChatTextMessage;
import com.xinjian.wechat.service.event.LocationEvent;
import com.xinjian.wechat.service.event.MenuEvent;
import com.xinjian.wechat.service.event.QRCodeEvent;
import com.xinjian.wechat.service.event.SubscribeEvent;
import com.xinjian.wechat.service.message.request.TextReqMessage;

/**
 * <p>Title: ProcessBusinessImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 16, 2018
 */
@Service
public class ProcessBusinessImpl implements IProcessBusiness {

	/**
	 * @Fields processDao : TODO
	 */
	@Autowired
	private IProcessDao processDao;

	/**
	 * @Fields mapperService : TODO
	 */
	@Autowired
	private BeanMapperService mapperService;

	/**
	 * <p>Title: processException </p>
	 * <p>Description: </p>
	 * @param e
	 */
	@Override
	public void processException(final WeChatException e,final Map<String,String> map) {
		e.setType(map.get("MsgType"));
		e.setException(map.toString());
		processDao.insertException(e);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.business.IProcessBusiness#processLocationEvent(com.xinjian.wechat.service.event.LocationEvent)
	 */
	@Override
	public void processLocationEvent(final LocationEvent event) throws WeChatException {
		final WeChatEvent eventBo = mapperService.mapper(event, WeChatEvent.class);

		try {
			if(null == processDao.findEventItem(eventBo)) {
				final int id = processDao.insertEvent(eventBo);
				final WeChatLocationEvent locationEvent = new WeChatLocationEvent();
				locationEvent.setEventId(id);
				locationEvent.setLatitude(event.getLatitude());
				locationEvent.setLongitude(event.getLongitude());
				locationEvent.setPrecisionVal(event.getPrecision());
				processDao.insertlocationEvent(locationEvent);
			}
		}catch(final Exception e) {
			throw new WeChatException();
		}
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.business.IProcessBusiness#processMenuEvent(com.xinjian.wechat.service.event.MenuEvent)
	 */
	@Override
	public void processMenuEvent(final MenuEvent event) throws WeChatException {
		final WeChatEvent eventBo = mapperService.mapper(event, WeChatEvent.class);

		try {
			if(null == processDao.findEventItem(eventBo)) {
				final int id = processDao.insertEvent(eventBo);
				final WeChatMenuEvent menuEvent = new WeChatMenuEvent();
				menuEvent.setEventId(id);
				menuEvent.setEventKey(event.getEventKey());

				processDao.insertMenuEvent(menuEvent);
			}
		}catch(final Exception e) {
			throw new WeChatException();
		}

	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.business.IProcessBusiness#processQRCodeEvent(com.xinjian.wechat.service.event.QRCodeEvent)
	 */
	@Override
	public void processQRCodeEvent(final QRCodeEvent event) throws WeChatException {
		final WeChatEvent eventBo = mapperService.mapper(event, WeChatEvent.class);

		try {
			if(null == processDao.findEventItem(eventBo)) {
				final int id = processDao.insertEvent(eventBo);
				final WeChatQRCodeEvent QREvent = new WeChatQRCodeEvent();
				QREvent.setEventId(id);
				QREvent.setEventKey(event.getEventKey());
				QREvent.setTicket(event.getTicket());
				processDao.insertQRCodeEvent(QREvent);
			}
		}catch(final Exception e) {
			throw new WeChatException();
		}
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.business.IProcessBusiness#processSubcribeEvent(com.xinjian.wechat.service.event.SubscribeEvent)
	 */
	@Override
	public void processSubcribeEvent(final SubscribeEvent event) throws WeChatException{
		final WeChatEvent eventBo = mapperService.mapper(event, WeChatEvent.class);

		try {
			if(null == processDao.findEventItem(eventBo)) {
				//订阅就存，取消就删
				if("unsubscribe".equalsIgnoreCase(eventBo.getEvent())) {
					processDao.deteterEvent(eventBo.getFromUserName());
				}else {
					processDao.insertEvent(eventBo);
				}
			}
		}catch(final Exception e) {
			throw new WeChatException();
		}


	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.business.IProcessBusiness#processTextMessage(com.xinjian.wechat.service.message.request.TextReqMessage)
	 */
	@Override
	public void processTextMessage(final TextReqMessage message) throws WeChatException {
		final WeChatMessage messageBo = mapperService.mapper(message, WeChatMessage.class);

		try {
			if(null == processDao.findMessageItem(messageBo)) {
				final int id = processDao.insertMessage(messageBo);
				final WeChatTextMessage textMessage = new WeChatTextMessage();
				textMessage.setMsgId(id);
				textMessage.setContent(message.getContent());
				processDao.insertTextMessage(textMessage);
			}
		}catch(final Exception e) {
			throw new WeChatException();
		}
	}

}
