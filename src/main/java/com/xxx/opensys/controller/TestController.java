package com.xxx.opensys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.opensys.dto.AddressDTO;
import com.xxx.opensys.dto.StudentDTO;
import com.xxx.opensys.entity.Rate;
import com.xxx.opensys.entity.Student;
import com.xxx.opensys.exception.LoginException;
import com.xxx.opensys.repository.RateCustomRepository;
import com.xxx.opensys.repository.RateRepository;
import com.xxx.opensys.service.AddressService;
import com.xxx.opensys.service.StudentService;

@Controller
public class TestController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private RateRepository rateRepository;
	
	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private RateCustomRepository rateCustomRepository;
	
	@RequestMapping(value = "address/{id}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public AddressDTO findAddressById(@PathVariable Integer id) {
		return addressService.getById(id);
	}
	@RequestMapping("test4")
	@ResponseBody
	public Student test4(){
//		List<Rate> rates = rateRepository.getByLastOrderData(20);
//		StudentDTO students = studentService.getStudent();
		Student students = studentService.getStudent();
		List<Rate> rates = rateCustomRepository.get();
		System.out.println(rates);
		return students;
	}

	@RequestMapping("testjs")
	public String test() {
		return "testjs";
	}
	
	@RequestMapping("test1")
	public String test1() {
		return "test1";
	}
	@RequestMapping("test2")
	public String test2() {
		return "test2";
	}
	@RequestMapping("test-home")
	public String testHome() {
		return "test-home";
	}
	@RequestMapping("test-profile")
	public String testProfile() {
		return "test-profile";
	}
	
	@RequestMapping("adminLTE")
	public String testAdminLTE() {
		return "testAdminLTE";
	}
	
	@RequestMapping("async")
	public String testAsync() {
		return "asyncTest1";
	}
	@RequestMapping("require-main")
	public String testRequireMain() {
		return "require-main";
	}
	@RequestMapping("error")
	public String testErrorMapping() throws LoginException {
		throw new LoginException();
	}
	@RequestMapping("404")
	public String testError404() {
		return "hello";
	}
}
