package com.xxx.opensys.test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GuavaTest {

	public static void main(String[] args) {
		
		User u1 = User.builder().id(1).age(1).name("u1").build();
		User u2 = User.builder().id(2).age(2).name("u2").build();
		User u3 = User.builder().id(3).age(3).name("u3").build();
		User u4 = User.builder().id(4).age(4).name("u4").build();
		User u5 = User.builder().id(5).age(5).name("u5").build();
		User u6 = User.builder().id(6).age(6).name("u6").build();
		User u7 = User.builder().id(7).age(7).name("u7").build();

		List<User> list = Lists.newArrayList(u1,u2,u3,u4,u5,u6,u7);
		
	
//		Iterable<User> tmp = Iterables.filter(list, new Predicate<User>() {
//			public boolean apply(User input) {
//				return input.getAge() < 3;
//			}
//		});
//		Iterable<User> tmp = Iterables.filter(list, u1);
//		Iterable<User> tmp = FluentIterable.from(list).filter(u7);
//		Collection<User> tmp = Collections2.filter(list, new Predicate<User>() {
//			public boolean apply(User input) {
//				return input.getAge() < 3;
//			}
//		});
//		System.out.println(tmp);
		
		Map<Integer,String> map = Maps.newHashMap();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		Map<Integer,String> filtered = Maps.filterKeys(map, new Predicate<Integer>() {

			public boolean apply(Integer input) {
				return input >= 3;
			}
		});
		System.out.println(filtered);
	}

}
