package com.shunxin.web.mapper.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shunxin.web.pojo.user.Role;

/**
 * <p>Title: RoleMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Repository("roleMapper")
public interface RoleMapper {

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
	public List<Role> selectByRoleIds(final List<Integer> roleIds);

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