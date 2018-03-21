/**
 * @Title: IUserService.java
 * @Package com.shunxin.web.service.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 8:08:52 PM
 * @version V1.0
 */

package com.shunxin.web.service.user;

import com.shunxin.web.vo.user.UserVo;

/**
 * <p>Title: IUserService</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
public interface IUserService {

	/**
	 * <p>Title: getUserByUserName </p>
	 * <p>Description: 按用户名查找用户</p>
	 * @param userName
	 * @return User
	 */
	UserVo getUserByUserName(String userName);

	/**
	 * <p>Title: insertUser </p>
	 * <p>Description: 单条插入用户</p>
	 * @param user
	 * @return 插入数量
	 */
	int insertUser(UserVo user);

}
