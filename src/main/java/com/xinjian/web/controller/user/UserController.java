/**
 * @Title: UserController.java
 * @Package com.xinjian.web.controller.user
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 18, 2018 7:51:36 PM
 * @version V1.0
 */

package com.xinjian.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinjian.web.service.user.IUserService;
import com.xinjian.web.vo.json.ResultVo;
import com.xinjian.web.vo.user.UserVo;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 18, 2018
 */
@Controller
public class UserController {

	/**
	 * @Fields userService : TODO
	 */
	@Autowired
	private IUserService userService;

	/**
	 * <p>Title: deny </p>
	 * <p>Description: 被拒绝后的页面 </p>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/security/deny")
	public String deny(final HttpServletRequest request, final HttpServletResponse response) {

		return "/pages/deny";

	}
	/**
	 * <p>Title: home </p>
	 * <p>Description: 登陆主页 </p>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/welcome")
	public ModelAndView home(final HttpServletRequest request, final HttpServletResponse response) {
		final ModelAndView modelAndView = new ModelAndView();
		final UserVo user= (UserVo) request.getSession().getAttribute("user");
		modelAndView.addObject("user", user);
		modelAndView.addObject("id", "welcome");
		modelAndView.setViewName("/pages/welcome");

		return modelAndView;
	}
	/**
	 * <p>Title: login </p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/before_check.do", method = RequestMethod.GET)
	public @ResponseBody ResultVo login(final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam(value = "username", required = true) final String userName,
			@RequestParam(value = "password", required = true) final String password) {


		final ResultVo result = new ResultVo();
		final UserVo user = 	userService.getUserByUserName(userName);
		if (null != user) {
			if(!password.equals(user.getPassword())) {
				result.setResult("pwdFalse");
			}
		}else {
			result.setResult("nameFalse");
		}
		return result;

	}

	/**
	 * <p>Title: welcome </p>
	 * <p>Description: 解决index访问</p>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = {"/","/index"})
	public String welcome(final HttpServletRequest request, final HttpServletResponse response) {

		if(null != request.getSession().getAttribute("user")){
			return "redirect:/welcome";
		}else{

			return "forward:/index.jsp";
		}
	}
}
