package com.binay.userdetails.rest.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private JwtTokenManager jwtTokenManager;
	
	public JwtConfigurer(JwtTokenManager jwtTokenManager) {
		this.jwtTokenManager = jwtTokenManager;
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter customFilter = new JwtAuthenticationFilter(jwtTokenManager);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

