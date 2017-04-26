package com.xxx.opensys.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class LambdaTest3 {

	public static void main(String[] args) {
		
		List<Integer> list = Lists.newArrayList(9,2,3,4,5);
		
		 List<Integer> tmp = list.stream().sorted().collect(Collectors.toList());
		
		System.out.println(tmp);
		
		int[] a = {2,10,8,0,-4};
		
//		OptionalInt tmp = ;
		
		int[] array = Arrays.stream(a).sorted().toArray();
		
		System.out.println(Arrays.asList(array));
//		System.out.println(Arrays.stream(a).min().getAsInt());
		
		List<String> l = Lists.newArrayList("a","b","c");
		
		Optional<String> tmp1 = l.stream().reduce((q, b)-> q + "-" + b);
		
		System.out.println(tmp1);
	}

}
