package com.twx.string;
/**
 * javap 反编译练习<p>
 * 方法： 1、先 javac 文件名.java ； 2、javap -c  文件名.class 
 * @author twx
 *
 */
public class Concatenation {
	public static void main(String[] args) {
		String mango="mango";
		String string="abc"+mango+"def"+47;
		System.out.println(string);
	}
}
