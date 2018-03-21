/**
 * @Title: IRoleDao.java
 * @Package com.shunxin.web.dao.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 9:55:35 PM
 * @version V1.0
 */

package com.shunxin.web.dao.user;

import java.util.List;

import com.shunxin.web.pojo.user.Role;

/**
 * <p>Title: IRoleDao</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
public interface IRoleDao {

	/**
	 * <p>Title: deleteByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param roleId
	 * @return
	 */
	int deleteByPrimaryKey(Integer roleId);

	/**
	 * <p>Title: insert </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insert(Role record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(Role record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param roleId
	 * @return
	 */
	Role selectByPrimaryKey(Integer roleId);

	/**
	 * <p>Title: selectByRoleIds </p>
	 * <p>Description: </p>
	 * @param roleIds
	 * @return
	 */
	List<Role> selectByRoleIds(List<Integer> roleIds);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Role record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Role record);
}
