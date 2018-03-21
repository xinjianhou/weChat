/**
 * @Title: UserDaoImpl.java
 * @Package com.shunxin.web.dao.user.impl
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 9:18:31 PM
 * @version V1.0
 */

package com.shunxin.web.dao.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shunxin.web.dao.user.IUserDao;
import com.shunxin.web.mapper.user.UserMapper;
import com.shunxin.web.pojo.user.User;

/**
 * <p>Title: UserDaoImpl</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired @Qualifier("userMapper")
	private UserMapper usermapper;

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IUserDao#getUserByUserName(java.lang.String)
	 */
	@Override
	public User getUserByUserName(final String userName) {

		return usermapper.getUserByUserName(userName);
	}

	/* (non-Javadoc)
	 * @see com.shunxin.web.dao.user.IUserDao#insertUser(com.shunxin.web.pojo.User)
	 */
	@Override
	public int insertUser(final User user) {

		return usermapper.insert(user);
	}

}
