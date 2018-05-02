/**
 * @Title: BasePOJO.java
 * @Package com.xinjian.web.pojo.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 4:49:31 PM
 * @version V1.0
 */

package com.xinjian.web.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * <p>Title: BasePOJO</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Data
public class BasePOJO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7084549010588291189L;

	/**
	 * @Fields createTime : TODO
	 */
	protected Date createTime;

	/**
	 * @Fields updateTime : TODO
	 */
	protected Date updateTime;
}
