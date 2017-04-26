package com.xxx.opensys.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;


public class Test {
	
    private static final int MAX = 100000; // Max size of Hashmap
    
    static void printpairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];
 
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
 
            // checking for condition
            if (temp>=0 && binmap[temp])
            {
                System.out.println("Pair with given sum " +
                                    sum + " is (" + arr[i] +
                                    ", "+temp+")");
            }
            binmap[arr[i]] = true;
        }
    }


	public static void main(String[] args) throws Exception{
		
//		int[] a = {1,3,2,5,8,10,9,15};
//		getSumNum(a, 10);
		
		char a = 'b';
		char b = 1;
		
		 int c = a & b;
		
		 Integer i1 = 1;
		 Integer i2 = 2;
		 
		 int[]  array = new int[2];
		 array[0] = 3;
		 array[1] = 4;
		 
		System.out.println(array);

	}



	

	
}
