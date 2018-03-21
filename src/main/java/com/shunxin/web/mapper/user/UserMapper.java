package com.shunxin.web.mapper.user;

import org.springframework.stereotype.Repository;

import com.shunxin.web.pojo.user.User;
/**
 * <p>Title: UserMapper</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Repository
public interface UserMapper {

	/**
	 * <p>Title: deleteByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * <p>Title: getUserByUserName </p>
	 * <p>Description: </p>
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String  userName);

	/**
	 * <p>Title: insert </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insert(User record);

	/**
	 * <p>Title: insertSelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int insertSelective(User record);

	/**
	 * <p>Title: selectByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 */
	User selectByPrimaryKey(Integer userId);

	/**
	 * <p>Title: updateByPrimaryKey </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(User record);

	/**
	 * <p>Title: updateByPrimaryKeySelective </p>
	 * <p>Description: </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(User record);
}