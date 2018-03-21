/**
 * @Title: MyUserDetailsService.java
 * @Package com.shunxin.web.security
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 16, 2018 7:58:21 PM
 * @version V1.0
 */

package com.shunxin.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shunxin.web.service.user.IUserService;
import com.shunxin.web.vo.user.RoleVo;
import com.shunxin.web.vo.user.UserVo;

/**
 * <p>Title: MyUserDetailsService</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 16, 2018
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

	/**
	 * @Fields userService : TODO
	 */
	@Autowired @Qualifier("userService")
	private IUserService userService;

	private Collection<GrantedAuthority> getAuthorities(final UserVo user){
		final List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		final List<RoleVo> list=user.getRoles();
		for(final RoleVo role:list){
			authList.add(new SimpleGrantedAuthority(role.getRoleCd()));
		}
		return authList;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String arg0) throws UsernameNotFoundException {
		final UserVo user = userService.getUserByUserName(arg0);
		if (user != null) {
			final Collection<GrantedAuthority> authList = getAuthorities(user);
			return new User(user.getUserName(), user.getPassword(),authList);
		}
		throw new UsernameNotFoundException("User '" + arg0+ "' not found.");
	}
}
