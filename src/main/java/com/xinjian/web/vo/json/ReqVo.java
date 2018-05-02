/**
 * @Title: ReqVo.java
 * @Package com.xinjian.web.vo.json
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 25, 2018 9:57:22 PM
 * @version V1.0
 */

package com.xinjian.web.vo.json;

import com.xinjian.web.vo.BaseVo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Title: ReqVo</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 25, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ReqVo extends BaseVo {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4369216427680373829L;
	/**
	 * @Fields type : TODO
	 */
	private String type;
}
