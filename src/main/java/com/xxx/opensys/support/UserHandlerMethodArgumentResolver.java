package com.xxx.opensys.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.xxx.opensys.authentication.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> paramType = parameter.getParameterType();
		log.info("paramType is: {}", paramType);
		return UserInfo.class.isAssignableFrom(paramType);
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		Class<?> paramType = parameter.getParameterType();
		if (WebRequest.class.isAssignableFrom(paramType)) {
			return webRequest;
		}

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		if (UserInfo.class.isAssignableFrom(paramType)){
			return request.getSession().getAttribute("user");
		}
		return null;
	}

}
