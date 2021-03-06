package com.xxx.opensys.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Value("${key}")
	private String key;

	@RequestMapping("index")
	public String index() {
		System.out.println(key);
		return "index/index";
	}

	@RequestMapping("index1")
	public String index1() {
		return "index/index1";
	}

	@RequestMapping("index2")
	public String index2() {
		return "index/index2";
	}
	@RequestMapping("index3")
	public String index3() {
		return "index/index3";
	}
	@RequestMapping("index4")
	public String index4() {
		return "index/index4";
	}
}
