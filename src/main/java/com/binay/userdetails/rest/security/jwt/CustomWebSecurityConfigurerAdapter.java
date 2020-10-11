package com.binay.userdetails.rest.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	@Autowired
    JwtTokenManager jwtTokenManager;    
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	 PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();//PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 return passwordEncoder;
	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/userdetails").permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/userdetails/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/userdetails/**").hasAnyRole("NON-ADMIN", "ADMIN")
                .anyRequest().authenticated()
            .and()
            .headers().frameOptions().sameOrigin()
            .and()
            .apply(new JwtConfigurer(jwtTokenManager));
    }

}
