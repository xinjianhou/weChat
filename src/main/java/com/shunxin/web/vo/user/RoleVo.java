/**
 * @Title: RoleVo.java
 * @Package com.shunxin.web.vo.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 2:32:28 PM
 * @version V1.0
 */

package com.shunxin.web.vo.user;

import com.shunxin.web.vo.BaseVo;

import lombok.Data;

/**
 * <p>Title: RoleVo</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Data
public class RoleVo extends BaseVo {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -2379370690679913866L;

	/**
	 * @Fields roleCd : TODO
	 */
	private String roleCd;

	/**
	 * @Fields roleName : TODO
	 */
	private String roleName;

}
