package com.twx.method;

import java.util.Random;
/**
 * final关键字的用法
 * @author twx
 *
 */
public class FinalDemo {
	private static Random rand=new Random();
	private String id;
	
	public  FinalDemo(String id) {
		this.id=id;
	}
	//编译期常量
	private final int valueOne=9;
	private static final int VALUE_TWO=99;
	/**
	 * public 可以被用于包之外<br>
	 * static 强调只有一份<br>
	 * final 是一个常量
	 */
	public static final int VALUE_THREE=39;
	
	private final int i4=rand.nextInt(20);
	static final int INT_5=rand.nextInt(20);
	
	
	
	private Value v1=new Value(11);
	/**
	 * 不能因为v2是一个常量，就认为它不能被改变；<br>
	 * 它只是一个引用，只是无法再指向另一个新的对象；
	 */
	private final Value v2=new Value(22);
	private static final Value	VAL_3=new Value(33);
	
	private final int[] a={1,2,3,4,5,6,};
	public String toString() {
		return id+": "+"i4="+i4+" , INT_5="+INT_5;
		
	}
	
	public static void main(String[] args) {
		FinalDemo fd1=new FinalDemo("fd1");
		fd1.v2.i++;
		fd1.v1=new Value(9);
		
		for(int i=0;i<fd1.a.length;i++){
			fd1.a[i]++;
		}
		System.out.println(fd1);
		System.out.println("new line");
		
		FinalDemo fd2=new FinalDemo("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}

class Value{
	int i;
	public Value(int i){
		this.i=i;
	}
}
