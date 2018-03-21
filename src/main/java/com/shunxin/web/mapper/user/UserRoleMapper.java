package com.shunxin.web.mapper.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shunxin.web.pojo.user.UserRole;

/**
 * <p>Title: UserRoleMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Repository("userRoleMapper")
public interface UserRoleMapper {
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