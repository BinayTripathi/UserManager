package com.binay.userdetails.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.binay.userdetails.rest.interceptor.UserInterceptor;

@Component
public class UserManagerWebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	UserInterceptor userInceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(userInceptor);
	}

}
