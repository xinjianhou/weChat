/**
 * @Title: UserServiceImpl.java
 * @Package com.xinjian.web.service.user.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 8:51:11 PM
 * @version V1.0
 */

package com.xinjian.web.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xinjian.web.dao.user.IRoleDao;
import com.xinjian.web.dao.user.IUserDao;
import com.xinjian.web.dao.user.IUserRoleDao;
import com.xinjian.web.dozer.BeanMapperService;
import com.xinjian.web.pojo.user.Role;
import com.xinjian.web.pojo.user.User;
import com.xinjian.web.pojo.user.UserRole;
import com.xinjian.web.service.user.IUserService;
import com.xinjian.web.vo.user.RoleVo;
import com.xinjian.web.vo.user.UserVo;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	/**
	 * @Fields userDao : TODO
	 */
	@Autowired @Qualifier("userDao")
	private IUserDao userDao;

	/**
	 * @Fields userRoleDao : TODO
	 */
	@Autowired
	private IUserRoleDao userRoleDao;

	/**
	 * @Fields roleDao : TODO
	 */
	@Autowired
	private IRoleDao roleDao;
	/**
	 * @Fields mapper : TODO
	 */
	@Autowired
	private BeanMapperService mapper;

	/* (non-Javadoc)
	 * @see com.xinjian.web.service.user.IUserService#getUserByUserName(java.lang.String)
	 */
	@Override
	public UserVo getUserByUserName(final String userName) {

		UserVo userVo = null;
		List<RoleVo> roleVos = null;
		final User user = userDao.getUserByUserName(userName);
		if(user != null) {
			userVo = mapper.mapper(user, UserVo.class);
			final Integer userId =  user.getUserId();
			final List<UserRole> userRoles = userRoleDao.selectByUserId(userId);
			final List<Integer> roleIds = new ArrayList<Integer>();
			if(CollectionUtils.isNotEmpty(userRoles)) {
				for(final UserRole userRole:userRoles) {
					roleIds.add(userRole.getRoleId());
				}
			}
			if(CollectionUtils.isNotEmpty(roleIds)) {
				final List<Role> roles = roleDao.selectByRoleIds(roleIds);
				if(CollectionUtils.isNotEmpty(roles)) {
					roleVos = mapper.mapperList(roles, RoleVo.class);
					userVo.setRoles(roleVos);
				}
			}
		}

		return userVo;
	}

	/* (non-Javadoc)
	 * @see com.xinjian.web.service.user.IUserService#insertUser(com.xinjian.web.pojo.User)
	 */
	@Override
	public int insertUser(final UserVo user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
