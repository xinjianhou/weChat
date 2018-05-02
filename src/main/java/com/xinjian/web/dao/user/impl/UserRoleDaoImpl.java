/**
 * @Title: UserRoleDaoImpl.java
 * @Package com.xinjian.web.dao.user.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 9:59:39 PM
 * @version V1.0
 */

package com.xinjian.web.dao.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xinjian.web.dao.user.IUserRoleDao;
import com.xinjian.web.mapper.user.UserRoleMapper;
import com.xinjian.web.pojo.user.UserRole;

/**
 * <p>Title: UserRoleDaoImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl implements IUserRoleDao {

	@Autowired @Qualifier("userRoleMapper")
	private UserRoleMapper userRoleMapper;
	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(final Integer id) {

		return userRoleMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#insert(com.xinjian.web.pojo.UserRole)
	 */
	@Override
	public int insert(final UserRole record) {

		return userRoleMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#insertSelective(com.xinjian.web.pojo.UserRole)
	 */
	@Override
	public int insertSelective(final UserRole record) {

		return userRoleMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public UserRole selectByPrimaryKey(final Integer id) {

		return userRoleMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#selectByUserId(java.lang.Integer)
	 */
	@Override
	public List<UserRole> selectByUserId(final Integer userId) {

		return userRoleMapper.selectByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#updateByPrimaryKey(com.xinjian.web.pojo.UserRole)
	 */
	@Override
	public int updateByPrimaryKey(final UserRole record) {

		return userRoleMapper.updateByPrimaryKey(record);
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.dao.user.IUserRoleDao#updateByPrimaryKeySelective(com.xinjian.web.pojo.UserRole)
	 */
	@Override
	public int updateByPrimaryKeySelective(final UserRole record) {

		return userRoleMapper.updateByPrimaryKeySelective(record);
	}

}
