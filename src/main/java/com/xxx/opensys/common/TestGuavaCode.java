package com.xxx.opensys.common;

import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xxx.opensys.dto.UserDTO;

public class TestGuavaCode {

	public static void main(String[] args) {
		
		UserDTO sto = new UserDTO();
		sto.setId(1);
		
		UserDTO dto = new UserDTO();
		dto.setId(2);
		
		List<UserDTO> users = Lists.newArrayList(sto,dto);

		
//		List<Integer> ids = Lists.transform(users, new Function<UserDTO, Integer>() {
//
//			public Integer apply(UserDTO input) {
//				return input.getId();
//			}
//		});
//		
//		Set set1 = Sets.newHashSet(1,2,3);
//		Set set2 = Sets.newHashSet(1,2);
//		System.out.println(Sets.difference(set1, set2));

//		System.out.println(ids);
		
	}

}
