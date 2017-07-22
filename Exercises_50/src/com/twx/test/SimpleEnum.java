package com.twx.test;

public class SimpleEnum {
	public static void main(String[] args) {
		/*Spiciness sn=Spiciness.HOT;
		System.out.println(sn);*/
		for(Spiciness s: Spiciness.values())
			System.out.print(s+" ");
	}
}
