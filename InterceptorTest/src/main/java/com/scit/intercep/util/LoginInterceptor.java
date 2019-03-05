package com.scit.intercep.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		
		String userId = (String)hs.getAttribute("userId");
		
		if(userId==null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		} else {
			return true;
		}
		
	}
}
