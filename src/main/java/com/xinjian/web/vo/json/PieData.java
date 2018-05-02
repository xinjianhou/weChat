/**
 * @Title: PieData.java
 * @Package com.xinjian.web.vo.json
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 26, 2018 11:03:03 AM
 * @version V1.0
 */

package com.xinjian.web.vo.json;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Title: PieData</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 26, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PieData implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 46348809812314604L;

	/**
	 * @Fields name : TODO
	 */
	private String name;
	/**
	 * @Fields value : TODO
	 */
	private int value;

}
