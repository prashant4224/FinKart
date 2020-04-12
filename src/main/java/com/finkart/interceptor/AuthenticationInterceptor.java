package com.finkart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.finkart.entity.User;
import com.finkart.service.AuthenticationService;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	AuthenticationService authenticationService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		User user = authenticationService.authenticate(token);
		request.setAttribute("user", user);
		
		return super.preHandle(request, response, handler);
	}
}
