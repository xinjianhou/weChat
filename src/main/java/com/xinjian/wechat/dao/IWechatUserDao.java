/**
 * @Title: IWechatUserDao.java
 * @Package com.xinjian.wechat.dao
 * @Description: TODO
 * @author xinjianhou
 * @date May 2, 2018 8:32:32 PM
 * @version V1.0
 */

package com.xinjian.wechat.dao;

import java.util.List;

import com.xinjian.wechat.pojo.user.WechatUser;

/**
 * <p>Title: IWechatUserDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 2, 2018
 */
public interface IWechatUserDao {

	/**
	 * <p>Title: deleteByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <p>Title: getAllWechatUsers </p>
	 * <p>Description: </p>
	 * @return
	 */
	List<WechatUser> getAllWechatUsers();

	/**
	 * <p>Title: getWechatUserByOpenId </p>
	 * <p>Description: </p>
	 * @param openid
	 * @return
	 */
	WechatUser getWechatUserByOpenId(String openid);

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
