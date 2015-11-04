package com.simpleSchedule.Security;

import com.simpleSchedule.service.MyUserDetailsService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * Created by steveg on 04/11/15.
 */
public class SimpleSocialUserDetailsService implements SocialUserDetailsService {

	private MyUserDetailsService myUserDetailsService;

	public SimpleSocialUserDetailsService(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(userId);
		return (SocialUserDetails) userDetails;
	}
}
