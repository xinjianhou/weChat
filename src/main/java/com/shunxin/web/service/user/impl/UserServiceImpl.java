/**
 * @Title: UserServiceImpl.java
 * @Package com.shunxin.web.service.user.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 8:51:11 PM
 * @version V1.0
 */

package com.shunxin.web.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shunxin.web.dao.user.IRoleDao;
import com.shunxin.web.dao.user.IUserDao;
import com.shunxin.web.dao.user.IUserRoleDao;
import com.shunxin.web.dozer.BeanMapperService;
import com.shunxin.web.pojo.user.Role;
import com.shunxin.web.pojo.user.User;
import com.shunxin.web.pojo.user.UserRole;
import com.shunxin.web.service.user.IUserService;
import com.shunxin.web.vo.user.RoleVo;
import com.shunxin.web.vo.user.UserVo;

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
	 * @see com.shunxin.web.service.user.IUserService#getUserByUserName(java.lang.String)
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
	 * @see com.shunxin.web.service.user.IUserService#insertUser(com.shunxin.web.pojo.User)
	 */
	@Override
	public int insertUser(final UserVo user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
