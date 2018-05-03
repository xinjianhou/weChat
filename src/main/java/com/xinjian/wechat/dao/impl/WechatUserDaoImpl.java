/**
 * @Title: WechatUserDaoImpl.java
 * @Package com.xinjian.wechat.dao.impl
 * @Description: TODO
 * @author xinjianhou
 * @date May 2, 2018 9:07:53 PM
 * @version V1.0
 */

package com.xinjian.wechat.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinjian.wechat.dao.IWechatUserDao;
import com.xinjian.wechat.mapper.user.WechatUserMapper;
import com.xinjian.wechat.pojo.user.WechatUser;

/**
 * <p>Title: WechatUserDaoImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 2, 2018
 */
@Repository
public class WechatUserDaoImpl implements IWechatUserDao {

	/**
	 * @Fields userMapper : TODO
	 */
	@Autowired
	private WechatUserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(final Integer id) {

		return userMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#getAllWechatUsers()
	 */
	@Override
	public List<WechatUser> getAllWechatUsers() {

		return userMapper.getAllWechatUsers();
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#getWechatUserByOpenId(java.lang.String)
	 */
	@Override
	public WechatUser getWechatUserByOpenId(final String openid) {

		return userMapper.getWechatUserByOpenId(openid);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#insert(com.xinjian.wechat.pojo.user.WechatUser)
	 */
	@Override
	public int insert(final WechatUser record) {

		return userMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#insertOrUpdate(com.xinjian.wechat.pojo.user.WechatUser)
	 */
	@Override
	public int insertOrUpdate(final WechatUser record) {

		return userMapper.insertOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#insertSelective(com.xinjian.wechat.pojo.user.WechatUser)
	 */
	@Override
	public int insertSelective(final WechatUser record) {

		return userMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public WechatUser selectByPrimaryKey(final Integer id) {

		return userMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#updateByPrimaryKey(com.xinjian.wechat.pojo.user.WechatUser)
	 */
	@Override
	public int updateByPrimaryKey(final WechatUser record) {

		return userMapper.updateByPrimaryKey(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.wechat.dao.IWechatUserDao#updateByPrimaryKeySelective(com.xinjian.wechat.pojo.user.WechatUser)
	 */
	@Override
	public int updateByPrimaryKeySelective(final WechatUser record) {

		return userMapper.updateByPrimaryKeySelective(record);
	}

}
