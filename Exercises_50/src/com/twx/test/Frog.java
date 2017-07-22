package com.twx.test;

public class Frog extends Amphibian{
	public static void main(String[] args) {
		Amphibian apb=new Frog();
		apb.run();
		apb.eat("fish");
	}
	@Override
	public void run(){
		System.out.println("Frog is running");
	}
	@Override
	public String eat(String str){
		System.out.println("Frog is eating "+str);
		return str;
	}
}

class Amphibian{
	private int a=9;
	private String s="momo";
	protected Integer integer;
	
	public void run(){
		System.out.println("Amphi is runing");
	}
	public String eat(String str){
		System.out.println("Amphi is eating "+str);
		return str;
	}
}
