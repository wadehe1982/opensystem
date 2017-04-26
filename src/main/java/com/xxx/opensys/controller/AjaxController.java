package com.xxx.opensys.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.service.AsyncService;

@Controller
@RequestMapping("ajax")
public class AjaxController {
//	@Autowired
//	private AsyncService asyncService;

	
	
//	@RequestMapping("test1")
//	@ResponseBody
//	public String buttonAsyncEvent(){
//		Future<String> result = asyncService.asyncTest1(new Date());
//		
////		try {
////			System.out.println(result.get());
////		} catch (Exception e) {
////			System.out.println(e);
////		}
//		if(result.isDone()){
//			System.out.println("xxxxxxxx-----DONE!-------XXXXXXXX");
//		}
//		return "success";
//	}
//	@RequestMapping("test2")
//	@ResponseBody
//	public String test2(){
//		Future<String> result = asyncService.asyncTest2();
//		System.out.println("hello");
//		try {
//			return result.get();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		return "dummy";
//	}
	
	@RequestMapping("save")
	@ResponseBody
	public String test3(){
		String key = "test_key";
		String value = "test_value";
//		String value1 = redisClient.get(key);
		return key;
	}
	
	
	@RequestMapping("saveObject")
	@ResponseBody
	public String test5(){
		String key = "user";
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setUserName("name1");
		user.setPassword("pwd1");
		return key;
	}
	


}
