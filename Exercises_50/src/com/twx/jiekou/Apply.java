package com.twx.jiekou;
/**
 * 策略设计模式
 * @author twx
 *
 */
public class Apply {
	public static void process(Processor p,Object s) {
		System.out.println(p.process(s));
	}
}
