package com.twx.classdemo;

import java.lang.reflect.Field;

/**
 * ��ϰ8<p>
 * ��ϰ9
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
	 * ���ܣ�
	 * 	�ܹ���ӡ���������ڼ̳���ϵ�е�������
	 * @param o
	 */
	public static void Hierarchy(Object o) {
		//��ӡһ�����е� �������Ϣ
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