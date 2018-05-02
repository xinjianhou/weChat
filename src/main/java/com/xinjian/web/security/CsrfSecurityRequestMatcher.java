/**
 * @Title: CsrfSecurityRequestMatcher.java
 * @Package com.xinjian.web.security
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 2, 2018 9:45:50 PM
 * @version V1.0
 */

package com.xinjian.web.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * <p>Title: CsrfSecurityRequestMatcher</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 2, 2018
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher {

	private final Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
	private final RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("^/.*", null);

	@Override
	public boolean matches(final HttpServletRequest request) {
		if(allowedMethods.matcher(request.getMethod()).matches()){
			return false;
		}

		return !unprotectedMatcher.matches(request);
	}

}
