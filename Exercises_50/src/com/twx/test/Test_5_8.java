package com.twx.test;

public class Test_5_8 {
	public static  void f(String... str){
		for(String s:str){
			System.out.print(s+" ");
		}
	}
	public static void main(String[] args) {
		String string[]={"twx","gj","hello"};
		f(string);
	}
}
