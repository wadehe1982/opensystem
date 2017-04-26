package com.xxx.opensys.algorithm;

public class HalfAccurrence {

	public static void main(String[] args) {
		
		int[] array = {1,2,1,3,1,1,1,6,7};
		
		int count = 0;
		int value = 0;
		
		for (int i = 0; i < array.length; i ++){
			
			if(i == 0){
				count = 1;
				value = array[i];
			}else{
				if(array[i] == value){
					count ++;
				}else if(array[i] != value && count > 0){
					count --;
				}else{
					value = array[i];
					count = 1;
				}
			}
		}
			
			
		
		System.out.println(value);

	}

}
