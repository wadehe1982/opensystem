package com.xxx.opensys.test;

public class QuickSortTest {
	
	public static void quickSort(int[] a, int left, int right){
		
		if(left < right){
			int k = partition(a, left, right);
			quickSort(a, left, k-1);
			quickSort(a, k+1, right);
		}
	}

	private static int partition(int[] a, int left, int right) {
		//以最右端元素为基准点
		int k = a[right];
		
		return 0;
	}

	public static void main(String[] args) {
		
		

	}

}
