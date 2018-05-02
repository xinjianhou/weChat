package com.xinjian.wechat.mapper.service;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.service.WeChatLocationMessage;

/**
 * <p>Title: WeChatLocationMessageMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 23, 2018
 */
@Repository
public interface WeChatLocationMessageMapper {
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
	int insert(WeChatLocationMessage record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WeChatLocationMessage record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WeChatLocationMessage selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WeChatLocationMessage record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WeChatLocationMessage record);
}