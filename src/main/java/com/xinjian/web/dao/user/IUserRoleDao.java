/**
 * @Title: IUserRoleDao.java
 * @Package com.xinjian.web.dao.login
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 9:51:35 PM
 * @version V1.0
 */

package com.xinjian.web.dao.user;

import java.util.List;

import com.xinjian.web.pojo.user.UserRole;

/**
 * <p>Title: IUserRoleDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
public interface IUserRoleDao {

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
	int insert(UserRole record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(UserRole record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	UserRole selectByPrimaryKey(Integer id);

	/**
	 * <p>Title: selectByUserId </p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 */
	List<UserRole> selectByUserId(Integer userId);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(UserRole record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(UserRole record);
}
