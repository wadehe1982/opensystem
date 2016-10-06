package com.xxx.opensys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("index")
	public String index() {
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
}
