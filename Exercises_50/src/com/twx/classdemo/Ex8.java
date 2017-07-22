package com.twx.classdemo;

import java.lang.reflect.Field;

/**
 * 练习8<p>
 * 练习9
 * @author twx
 *
 */
class A {
	private String as;
}

class B extends A {
	private String bs;
	private int bi;
}

class C extends B {
	private String cs="abc";
	private int ci=10;
	
	public void find() {
		System.out.println("find()");
	}
}

public class Ex8 {
	/**
	 * 功能：
	 * 	能够打印出对象所在继承体系中的所有类
	 * @param o
	 */
	public static void Hierarchy(Object o) {
		//打印一个类中的 相关域信息
		Field[] fields = o.getClass().getDeclaredFields();
		if(fields.length==0)
			System.out.println(o.getClass()+" has no fields");
		if(fields.length>0){
			System.out.println("Field(s) of "+o.getClass()+" :");
			for(Field field:fields){
				System.out.print(" "+field.getName());
			}
		}
		System.out.println();
		//end
		if(o.getClass().getSuperclass() != null) {		
			System.out.println(o.getClass() + " is a subclass of " + 
				o.getClass().getSuperclass()); 
			try {
				Hierarchy(o.getClass().getSuperclass().newInstance());
			} catch(InstantiationException e) {
				System.out.println("Unable to instantiate obj");
			} catch(IllegalAccessException e) {
				System.out.println("Unable to access");
			}
		} 
	}		
	public static void main(String[] args) {
		Hierarchy(new C());
	}
}