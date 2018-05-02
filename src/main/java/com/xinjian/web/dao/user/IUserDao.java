/**
 * @Title: IUserDao.java
 * @Package com.xinjian.web.dao.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 8:57:00 PM
 * @version V1.0
 */

package com.xinjian.web.dao.user;

import com.xinjian.web.pojo.user.User;

/**
 * <p>Title: IUserDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
public interface IUserDao {
	/**
	 * <p>Title: getUserByUserName </p>
	 * <p>Description: 按用户名查找用户</p>
	 * @param userName
	 * @return User
	 */
	User getUserByUserName(String userName);

	/**
	 * <p>Title: insertUser </p>
	 * <p>Description: 单条插入用户</p>
	 * @param user
	 * @return 插入数量
	 */
	int insertUser(User user);

}
