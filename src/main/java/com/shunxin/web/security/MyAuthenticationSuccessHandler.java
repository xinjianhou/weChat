/**
 * @Title: MyAuthenticationSuccessHandler.java
 * @Package com.shunxin.web.security
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 18, 2018 7:59:56 PM
 * @version V1.0
 */

package com.shunxin.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.shunxin.web.service.user.IUserService;
import com.shunxin.web.vo.user.UserVo;

/**
 * <p>Title: MyAuthenticationSuccessHandler</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 18, 2018
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	/**
	 * @Fields userService : TODO
	 */
	@Autowired
	private IUserService userService;
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication)
					throws IOException, ServletException {

		// 认证成功后，获取用户信息并添加到session中
		final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		final UserVo user = userService.getUserByUserName(userDetails.getUsername());
		request.getSession().setAttribute("user", user);

		super.onAuthenticationSuccess(request, response, authentication);

	}
}
