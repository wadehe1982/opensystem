package com.xxx.opensys.algorithm;

import java.util.Arrays;

public class RemoveDuplicateInArray {

	public static void main(String[] args) {
		
		int[] array =  {1, 2, 2, 3, 3};

		System.out.println(removeDuplicatesNaive(array));
	}
	
	public static int[] removeDuplicatesNaive(int[] A) {
		if (A.length < 2)
			return A;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 
		int[] B = Arrays.copyOf(A, j + 1);
	 
		return B;
	}

}
