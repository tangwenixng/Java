package com.twx.jiekou;

 abstract class Impl {
	public Impl() {
		print();
	}
	public abstract void print();
}

 public class Test_9_3 extends Impl{
	private int value=47;
	
	@Override
	public void print() {
		System.out.println(value);
	}
	public static void main(String[] args) {
		Test_9_3 test=new Test_9_3();
		test.print();
	}
}
