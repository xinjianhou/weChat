package com.xinjian.wechat.mapper.user;

import org.springframework.stereotype.Repository;

import com.xinjian.wechat.pojo.user.WechatUser;

/**
 * <p>Title: WechatUserMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 24, 2018
 */
@Repository
public interface WechatUserMapper {
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
	int insert(WechatUser record);

	/**
	 * <p>Title: insertOrUpdate </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertOrUpdate(WechatUser record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(WechatUser record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	WechatUser selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(WechatUser record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(WechatUser record);
}