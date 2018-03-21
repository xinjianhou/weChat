/**
 * @Title: ViewButton.java
 * @Package com.shunxin.wechat.service.menu
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 15, 2018 4:52:23 PM
 * @version V1.0
 */

package com.shunxin.wechat.service.menu;

import lombok.Data;

/**
 * <p>Title: ViewButton</p>
 * <p>Description: 视图型菜单事件</p>
 * @author xinjianhou
 * @date Mar 15, 2018
 */
@Data
public class ViewButton {
	/**
	 * @Fields type : TODO
	 */
	private String type;
	/**
	 * @Fields name : TODO
	 */
	private String name;
	/**
	 * @Fields url : TODO
	 */
	private String url;
}
