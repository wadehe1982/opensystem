package com.xxx.opensys.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.CookieGenerator;

import com.xxx.opensys.constant.Constants;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private static int duration = 60 * 60;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute("user") String user, @ModelAttribute("password") String pwd, HttpServletResponse response){
		List<UserDTO> users = userService.getByUserName(user);
		if(CollectionUtils.isNotEmpty(users)){
			for(UserDTO userDTO : users){
				if(userDTO.getPassword().equals(pwd)){
					CookieGenerator generator = new CookieGenerator();
					Cookie userCookie = new Cookie(Constants.COOKIE_NAME_USER, user);
					userCookie.setMaxAge(duration);
					Cookie pwdCookie = new Cookie(Constants.COOKIE_NAME_PASSWORD, pwd);
					pwdCookie.setMaxAge(duration);
					response.addCookie(userCookie);
					response.addCookie(pwdCookie);
					return "redirect:/user/list";
				}
			}
		}
		return "login";
	}

}
