package com.twx.inner;

public class Outer {
	class Inner{
		
	}
	
	public Inner getInner(){
		return new Inner();
	}
	
	public static void main(String[] args) {
		Outer outer=new Outer();
		Inner inner = outer.getInner();
	}
}
