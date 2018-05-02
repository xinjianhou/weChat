/**
 * @Title: ClickButton.java
 * @Package com.xinjian.wechat.service.menu
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 15, 2018 4:41:13 PM
 * @version V1.0
 */

package com.xinjian.wechat.service.menu;

import lombok.Data;

/**
 * <p>Title: ClickButton</p>
 * <p>Description: 点击型菜单事件</p>
 * @author xinjianhou
 * @date Mar 15, 2018
 */
@Data
public class ClickButton {

	/**
	 * @Fields type : TODO
	 */
	private String type;
	/**
	 * @Fields name : TODO
	 */
	private String name;
	/**
	 * @Fields key : TODO
	 */
	private String key;

}
