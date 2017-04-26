package com.xxx.opensys.algorithm;

public class BinaryDecimalConvert {

	public static void main(String[] args) {

		String a = "10110010110";
		String b = "1010";
		
		int i = 100;
		
		System.out.println("100 二进制： " + Integer.toBinaryString(i)); //1100100
		System.out.println("100 八进制： " + Integer.toOctalString(i));//144
		System.out.println("100 十六进制： " + Integer.toHexString(i));//64
		
		System.out.println(" 二进制字符串ToInt： " + Integer.parseInt("1100100", 2));//100
		System.out.println(" 八进制字符串ToInt： " + Integer.parseInt("144", 8));//100
		System.out.println(" 十六进制字符串ToInt： " + Integer.parseInt("64", 16));//100
		
		System.out.println(Integer.parseInt(a, 2));
		System.out.println(Integer.parseInt(b, 2));
		
		int result = Integer.parseInt(a,2) + Integer.parseInt(b, 2);
		
		System.out.println(result);
				
	}
	


}
