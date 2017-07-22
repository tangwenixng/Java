package com.twx.method;

public class Dog {
	public String speek;
	private String touch;
	protected String run;
	public Dog(String touch){
		this.touch=touch;
		System.out.println("i'm dog!");
	}
	
	void get(){
		System.out.println("get dog...");
	}
	protected void run() {
		System.out.println("run...");
	}
}
