package com.xxx.opensys.authentication;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;
import com.xxx.opensys.constant.Constants;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.service.UserService;

@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN_URL = "/opensystem/login";
	private static final String DO_LOGIN_URL = "/opensystem/doLogin";
	
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler == null) {
			return true;
		}
		
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		if(DO_LOGIN_URL.equals(request.getRequestURI()) || LOGIN_URL.equals(request.getRequestURI())){
			return true;
		}else{
			Cookie userCookie = WebUtils.getCookie(request, Constants.COOKIE_NAME_USER);
			Cookie pwdCookie = WebUtils.getCookie(request, Constants.COOKIE_NAME_PASSWORD);
			if(userCookie != null && pwdCookie != null){
				String user = userCookie.getValue();
				String pwd = pwdCookie.getValue();
				List<UserDTO> users = userService.getByUserName(user);
				if(CollectionUtils.isNotEmpty(users)){
					for(UserDTO userDTO : users){
						if(userDTO.getPassword().equals(pwd)){
							return true;
						}
					}
				}
			}
			response.sendRedirect(LOGIN_URL);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
