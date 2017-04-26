package com.xxx.opensys.test.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySecondLargest {
	
	public static void main(String[] args) {
		Integer[] array = {2,1,3,5,7,10,9,11,12,4};
		
		Arrays.sort(array, Comparator.reverseOrder());
		
		int max = 0;
		int second = 0;

		int length = array.length;
		
		for(int i = 0; i < length; i ++){
			int current = array[i];
			if(current > max){
				second = max;
				max = current;
			}else if(current > second){
				second = current;
			}
		}
		System.out.println(max);
		System.out.println(second);
	}

}
