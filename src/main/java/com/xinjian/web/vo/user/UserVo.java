/**
 * @Title: UserVo.java
 * @Package com.xinjian.web.vo.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 1:55:41 PM
 * @version V1.0
 */

package com.xinjian.web.vo.user;

import java.util.List;

import com.xinjian.web.vo.BaseVo;

import lombok.Data;

/**
 * <p>Title: UserVo</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Data
public class UserVo extends BaseVo {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -1529123479685355103L;

	/**
	 * @Fields userId : TODO
	 */
	private Integer userId;

	/**
	 * @Fields userName : TODO
	 */
	private String userName;

	/**
	 * @Fields password : TODO
	 */
	private String password;

	/**
	 * @Fields realName : TODO
	 */
	private String realName;

	/**
	 * @Fields roles : TODO
	 */
	private List<RoleVo> roles;


}
