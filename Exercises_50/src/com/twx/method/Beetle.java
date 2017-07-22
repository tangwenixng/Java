package com.twx.method;
/**
 * 继承与初始化过程：<br>
 * 1.首先访问Beetle.main()方法，加载器开始启动并加载Beetle.class文件。编译器注意到有一个基类Insect.<br>
 * 2.初始化基类中的static成员变量，接着是导出类的static.<br>
 * 3.类加载完毕，创建对象。
 * @author twx
 *
 */
public class Beetle extends Insect{
	private int k=printInit("Beetle.k initialized");
	public Beetle(){
		System.out.println("k="+k);
		System.out.println("j="+j);
	}
	private static int x2=printInit("Beetle.x2 initialized");
	public static void main(String[] args) {
		System.out.println("begin...");
		Beetle beetle=new Beetle();
	}
}

class Insect{
	private int i=9;
	protected int j;
	public Insect(){
		System.out.println("i="+i+", j="+j);
		j=39;
	}
	
	private static int x1=printInit("static Insect.x1 initialized");
	
	static int printInit(String s){
		System.out.println(s);
		return 56;
	}
}
