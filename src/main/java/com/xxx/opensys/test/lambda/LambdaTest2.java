package com.xxx.opensys.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import java.util.function.*;


public class LambdaTest2 {

	public static void main(String[] args) {
		
		
//		List<Integer> list = Lists.newArrayList(2,1,3,7,5,4);
		
//		List<Integer> tmp = list.stream().map(e->e*2).collect(Collectors.toList());
		
		List<UserEntity> list = new ArrayList<>();
		UserEntity user = new UserEntity();
		user.setAge(1);
		user.setName("name1");
		
		UserEntity user1 = new UserEntity();
		user1.setAge(2);
		user1.setName("name2");
		
		UserEntity user2 = new UserEntity();
		user2.setAge(3);
		user2.setName("name2");
		
		list.add(user);
		list.add(user1);
		list.add(user2);
		
//		List<UserDTO> tmp = list.stream().map(e->e.valueOf()).collect(Collectors.toList());
		
//		Map<String, UserDTO> map = list.stream().map(e->e.valueOf()).collect(Collectors.toMap(UserDTO::getName, e->e));	
		
//		Map<String, List<UserDTO>> map1 = list.stream().map(e->e.valueOf()).collect(Collectors.groupingBy(UserDTO::getName));
		
		Map<String, UserDTO> map3 = list.stream().map(e->e.valueOf()).collect(Collectors.toMap(UserDTO::getName, Function.identity(), (k1,k2)->k2));
		
//		System.out.println(map1);
		
//		System.out.println(map3);
		
		List<String> list1 = Lists.newArrayList("abc","2amv","4nmm","7umn","aou");
		
//		从一个字符串列表中选出以数字开头的字符串并输出
		list1.stream().filter(e->Character.isDigit(e.charAt(0))).collect(Collectors.toList()).forEach(e->System.out.println(e));;
		
//		new Thread(()->{System.out.println(Thread.currentThread().getName());}).start();
		
		//从一个字符串列表中，选出所有不以数字开头的字符串，将其转换成大写形式，并把结果放到新的集合当中
		List<String> tmp1 = list1.stream().filter(e->!Character.isDigit(e.charAt(0))).map(e->e.toUpperCase()).collect(Collectors.toList());
		System.out.println(tmp1);
//		System.out.println(tmp);

	}

}
