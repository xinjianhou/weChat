/**
 * @Title: RoleDao.java
 * @Package com.shunxin.web.dao.user.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 9:56:27 PM
 * @version V1.0
 */

package com.shunxin.web.dao.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shunxin.web.dao.user.IRoleDao;
import com.shunxin.web.mapper.user.RoleMapper;
import com.shunxin.web.pojo.user.Role;

/**
 * <p>Title: RoleDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Repository
public class RoleDao implements IRoleDao {

	/**
	 * @Fields rolemapper : TODO
	 */
	@Autowired
	private RoleMapper rolemapper;

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(final Integer roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#insert(com.shunxin.web.pojo.user.Role)
	 */
	@Override
	public int insert(final Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#insertSelective(com.shunxin.web.pojo.user.Role)
	 */
	@Override
	public int insertSelective(final Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Role selectByPrimaryKey(final Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#selectByRoleIds(java.util.List)
	 */
	@Override
	public List<Role> selectByRoleIds(final List<Integer> roleIds) {

		return rolemapper.selectByRoleIds(roleIds);
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#updateByPrimaryKey(com.shunxin.web.pojo.user.Role)
	 */
	@Override
	public int updateByPrimaryKey(final Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IRoleDao#updateByPrimaryKeySelective(com.shunxin.web.pojo.user.Role)
	 */
	@Override
	public int updateByPrimaryKeySelective(final Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
