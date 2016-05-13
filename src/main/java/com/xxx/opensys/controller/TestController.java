package com.xxx.opensys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.opensys.dto.AddressDTO;
import com.xxx.opensys.service.AddressService;

@Controller
public class TestController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "address/{id}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public AddressDTO findAddressById(@PathVariable Integer id) {
		return addressService.getById(id);
	}

	@RequestMapping("testjs")
	public String test() {
		return "testjs";
	}

}
