package com.xinjian.wechat.mapper.service;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.service.WeChatEvent;

/**
 * <p>Title: WeChatEventMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 17, 2018
 */
@Repository
public interface WeChatEventMapper {
	/**
	 * <p>Title: deleteByFromUserName </p>
	 * <p>Description: </p>
	 * @param fromUserName
	 * @return
	 */
	int deleteByFromUserName(String fromUserName);

	/**
	 * <p>Title: deleteByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <p>Title: findItem </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	WeChatEvent findItem(WeChatEvent record);

	/**
	 * <p>Title: insert </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insert(WeChatEvent record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WeChatEvent record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WeChatEvent selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WeChatEvent record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WeChatEvent record);
}