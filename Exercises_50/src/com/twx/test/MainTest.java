package com.twx.test;

public class MainTest {

	public static void main(String[] args) {
		/*MainTest test=new MainTest();
		System.out.println(test.fallDown(10));*/
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";
		String str4 = str1 + str2;
		System.out.println(str3 == str4);//false

		String str5 = "string";
		System.out.println(str3 == str5);//true
	}

	/**
	 * Æ¤ÇòÂäµØ
	 * @param number
	 * @return
	 */
	public double fallDown(int number){
		double height=100;
		double sum=100;
		for(int i=2;i<=number;i++){
			height=height/2.0;
			sum+=2*height;
			if(i==number){
				System.out.println(height/2.0);
			}
		}
		return sum;
	}
}
