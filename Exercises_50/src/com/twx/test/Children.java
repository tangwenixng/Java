package com.twx.test;

public class Children extends Father{
	@Override
	public void edu() {
		System.out.println("Child edu...");
	}
	public static void main(String[] args) {
		Father f=new Children();
		f.work();
	}
}
