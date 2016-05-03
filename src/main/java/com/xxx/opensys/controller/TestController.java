package com.xxx.opensys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.opensys.dto.AddressDTO;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.entity.Address;
import com.xxx.opensys.service.AddressService;
import com.xxx.opensys.service.UserService;

@Controller
public class TestController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@RequestMapping("test")
	@ResponseBody
	public List<UserDTO> test(ModelMap map) {
		map.addAttribute("name", "wade");
		map.addAttribute("flag", false);
		List<UserDTO> list = userService.getByUserName("user7");
		System.out.println(list);
		map.addAttribute("user", list);
		return list;
	}

	@RequestMapping(value="find/{id}",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public UserDTO test1(@PathVariable Integer id) {

		UserDTO dto = userService.getById(id);

		System.out.println(dto);

		return dto;
	}

	@RequestMapping("save")
	@ResponseBody()
	public UserDTO save() {

		UserDTO saved = new UserDTO();
		Address a = new Address();
		a.setAddress1("a1");
		a.setAddress2("a2");
		a.setZipcoede("123");
		saved.setAddress(a);

		saved.setPassword("test_pwd");
		saved.setUserName("test_user");
		UserDTO dto = userService.save(saved);
		return dto;
	}

	@RequestMapping(value="address/{id}",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public AddressDTO findAddressById(@PathVariable Integer id) {
		return addressService.getById(id);
	}

	@RequestMapping("testjs")
	public String test() {
		return "testjs";
	}

}
