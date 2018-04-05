/**
 * @Title: ResultVo.java
 * @Package com.shunxin.web.vo.json
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 29, 2018 12:52:56 PM
 * @version V1.0
 */

package com.shunxin.web.vo.json;

import com.shunxin.web.vo.BaseVo;

import lombok.Data;

/**
 * <p>Title: ResultVo</p>
 * <p>Description: 用于json的返回</p>
 * @author xinjianhou
 * @date Mar 29, 2018
 */
@Data
public class ResultVo extends BaseVo {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -7414229421765069509L;

	/**
	 * @Fields result : TODO
	 */
	private String result;
}
