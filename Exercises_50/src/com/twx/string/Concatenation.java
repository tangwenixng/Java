package com.twx.string;
/**
 * javap ��������ϰ<p>
 * ������ 1���� javac �ļ���.java �� 2��javap -c  �ļ���.class 
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
