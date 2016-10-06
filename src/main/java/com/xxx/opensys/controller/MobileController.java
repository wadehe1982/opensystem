package com.xxx.opensys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mobile")
public class MobileController {
	
	@RequestMapping("test1")
	public String test1(){
		return "mobile/layout/page/mobileTest1";
	}

}
