package com.xxx.opensys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.entity.User;
import com.xxx.opensys.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
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
	// @ResponseBody
	public String getAll(ModelMap map) {
		List<UserDTO> users = userService.getAllUsers();
		map.addAttribute("userlist", users);
		return "listUser";
	}

	@RequestMapping("list2/{pageNumber}")
	// @ResponseBody
	public String getAll2(ModelMap model, @PathVariable(value = "pageNumber") Integer pageNumber) {
		Page<User> page = userService.getAll(pageNumber);
		model.addAttribute("page", page);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		List<Integer> pages = Lists.newArrayList();
		for (Integer p = begin; p <= end; p++) {
			pages.add(p);
		}
		boolean showPrevious = (page.hasPrevious());
		boolean showNext = (page.hasNext());

		model.addAttribute("showPrevious", showPrevious);
		model.addAttribute("showNext", showNext);
		model.addAttribute("pages", pages);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "listUser";
	}

	@RequestMapping("modify")
	// @ResponseBody
	public String modify(ModelMap map, @RequestBody UserDTO userDTO) {
		List<UserDTO> users = userService.getAllUsers();
		map.addAttribute("user", users.get(0));
		map.addAttribute("userlist", users);
		return "listUser";
	}

	@RequestMapping("bulk-update")
	@ResponseBody
	public List<UserDTO> bulkInactive(@RequestBody List<Integer> ids) {
		List<UserDTO> users = userService.bulkInactive(ids);
		return users;
	}

	// @RequestMapping("test01")
	// @ResponseBody
	// public List<String> test(@RequestParam(value = "userId") String userId,
	// @RequestParam(value = "name") String name,
	// @RequestParam("ids") List<String> ids,
	// @RequestParam(value = "test") String test) {
	// System.out.println(userId);
	// System.out.println(name);
	// System.out.println(ids);
	// System.out.println(test);
	// return ids;
	// }
	@RequestMapping("test01")
	@ResponseBody
	public List<String> test(@RequestParam("name") String name, @RequestParam("ids") List<Integer> ids,
			HttpServletRequest request) {

		// System.out.println(idList);
		System.out.println(name);
		System.out.println(ids);
		String[] s = request.getParameterValues("ids");

		System.out.println(request.getContentType());
		System.out.println(s);
		System.out.println(request.getParameter("name"));

		return Lists.newArrayList();
	}

	@RequestMapping("username")
	@ResponseBody
	public UserDTO findByUserName(@RequestParam("userName") String userName) {
		log.info("userName is: {}", userName);
		UserDTO user = userService.getOneByUserName(userName);
		return user;
	}
}
