/**
 * @Title: UserController.java
 * @Package com.shunxin.web.controller.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 18, 2018 7:51:36 PM
 * @version V1.0
 */

package com.shunxin.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 18, 2018
 */
@Controller
public class UserController {

	/**
	 * <p>Title: login </p>
	 * <p>Description: 处理登陆信息</p>
	 * @param model
	 * @param error
	 * @return
	 */
	@RequestMapping("/login")
	public String login(final Model model,
			@RequestParam(value = "error", required = false) final String error) {
		if (error != null) {
			model.addAttribute("error", "用户名或密码错误");
		}
		return "index";
	}
}
