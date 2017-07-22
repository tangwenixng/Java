package com.twx.jiekou;
/**
 * 策略设计模式
 * @author twx
 *
 */
public class StringTest {

	public static void main(String[] args) {
		String s="hei,girl hah... i love you";
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}

}
