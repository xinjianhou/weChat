package com.xinjian.wechat.mapper.service;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.service.WeChatLocationEvent;

/**
 * <p>Title: WeChatLocationEventMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 18, 2018
 */
@Repository
public interface WeChatLocationEventMapper {
	/**
	 * <p>Title: deleteByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <p>Title: insert </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insert(WeChatLocationEvent record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WeChatLocationEvent record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WeChatLocationEvent selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WeChatLocationEvent record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WeChatLocationEvent record);
}