package com.xinjian.wechat.mapper.service;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.service.WeChatQRCodeEvent;
/**
 * <p>Title: WeChatQRCodeEventMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 18, 2018
 */
@Repository
public interface WeChatQRCodeEventMapper {
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
	int insert(WeChatQRCodeEvent record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WeChatQRCodeEvent record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WeChatQRCodeEvent selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WeChatQRCodeEvent record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WeChatQRCodeEvent record);
}