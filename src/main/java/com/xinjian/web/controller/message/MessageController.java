/**
 * @Title: MessageController.java
 * @Package com.xinjian.web.controller.message
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 14, 2018 9:54:27 AM
 * @version V1.0
 */

package com.xinjian.web.controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinjian.web.vo.user.UserVo;

/**
 * <p>Title: MessageController</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 14, 2018
 */
@Controller
public class MessageController {


	@RequestMapping(value="/message")
	public ModelAndView message(final HttpServletRequest request, final HttpServletResponse response) {
		final ModelAndView modelAndView = new ModelAndView();
		final UserVo user= (UserVo) request.getSession().getAttribute("user");
		modelAndView.addObject("user", user);
		modelAndView.addObject("id", "message");
		modelAndView.setViewName("/pages/message");

		return modelAndView;
	}
}
