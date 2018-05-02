package com.xinjian.wechat.mapper.service;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.service.WeChatMenuEvent;

/**
 * <p>Title: WeChatMenuEventMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 22, 2018
 */
@Repository
public interface WeChatMenuEventMapper {
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
	int insert(WeChatMenuEvent record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WeChatMenuEvent record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WeChatMenuEvent selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WeChatMenuEvent record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WeChatMenuEvent record);
}