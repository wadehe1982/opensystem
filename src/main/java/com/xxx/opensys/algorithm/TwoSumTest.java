package com.xxx.opensys.algorithm;

import java.util.Arrays;
import java.util.HashMap;
/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * For example:
 *Input: numbers={2, 7, 11, 15}, target=9
 *Output: index1=0, index2=1
 *
 */
public class TwoSumTest {

	public static void main(String[] args) {
		
		

	}
	/**
	 * Time complexity of this solution is O(n).
	 * Time complexity depends on the put and get operations 
	 * of HashMap which is normally O(1).
	 */
	public static int[] twoSum1(int[] numbers, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index ;
				result[1] = i;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
	 
		return result;
	}
	
	/*
	 * Two Sum II – Input array is sorted (Java)
	 * To solve this problem, we can use two points to scan the array from both sides. See Java solution below:
	 */
	@SuppressWarnings("unused")
	private static void getSumNum(int[] numbers, int target) {
		
		Arrays.sort(numbers);
		
		for(int i = 0, j = numbers.length -1; i < j;){
			int r1 = numbers[i];
			int r2 = numbers[j];
			if(r1 + r2 == target){
				System.out.println(r1 + ":" + r2);
				return;
			}else if(r1 + r2 > target){
				j --;
			}else{
				i ++;
			}
		}
		System.out.println("no result");
		
	}

}
