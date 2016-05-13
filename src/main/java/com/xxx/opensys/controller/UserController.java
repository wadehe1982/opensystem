package com.xxx.opensys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "find/{id}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public UserDTO test1(@PathVariable Integer id) {
		UserDTO dto = userService.getById(id);
		return dto;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody()
	public UserDTO save(@RequestBody UserDTO userDTO) {
		UserDTO dto = userService.save(userDTO);
		return dto;
	}

	@RequestMapping("new")
	public String createUser() {
		return "newUser";
	}

	@RequestMapping("list")
	@ResponseBody
	public List<UserDTO> getAll() {
		List<UserDTO> users = userService.getAllUsers();
		return users;
	}

}
