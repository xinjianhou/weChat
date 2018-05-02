/**
 * @Title: BaseVo.java
 * @Package com.xinjian.web.vo
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 5:03:12 PM
 * @version V1.0
 */

package com.xinjian.web.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * <p>Title: BaseVo</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Data
public class BaseVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2288692058488610171L;

	/**
	 * @Fields createTime : TODO
	 */
	protected Date createTime;

	/**
	 * @Fields updateTime : TODO
	 */
	protected Date updateTime;
}
