package com.twx.jiekou;
/**
 * 9.4  Á·Ï°11
 * @author twx
 *
 */
public class ElecProduct {
	public String swap(String str){
		String string="";
		
		char[] array = str.toCharArray();
		for(int i=0;i<array.length;i+=2){
			if((i+1)<array.length){
				string+=charSwap(array[i], array[i+1]);
			}else if((i+1)==array.length)
				string+=array[i];
		}
		return string;
	}
	
	private String charSwap(char a,char b){
		return String.valueOf(b)+String.valueOf(a);
	}
}
