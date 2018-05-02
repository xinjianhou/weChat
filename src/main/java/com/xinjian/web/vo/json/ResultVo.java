/**
 * @Title: ResultVo.java
 * @Package com.xinjian.web.vo.json
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 29, 2018 12:52:56 PM
 * @version V1.0
 */

package com.xinjian.web.vo.json;

import java.util.List;

import com.xinjian.web.vo.BaseVo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Title: ResultVo</p>
 * <p>Description: 用于json的返回</p>
 * @author xinjianhou
 * @date Mar 29, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ResultVo extends BaseVo {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -7414229421765069509L;

	/**
	 * @Fields result : TODO
	 */
	private String result;

	/**
	 * @Fields label : TODO
	 */
	private String[] label;

	/**
	 * @Fields data : TODO
	 */
	private int[] data;

	/**
	 * @Fields value : TODO
	 */
	private List<PieData> value;
}
