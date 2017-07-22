package com.twx.inner;

public class Ex7 {
	private String name;
	private String getName(){
		return this.name;
	}
	
	class Ex7_Inner{
		public void setName(String s){
			name=s;
		}
	}
	
	public static void main(String[] args) {
		Ex7 ex7=new Ex7();
		Ex7_Inner inner = ex7.new Ex7_Inner();
		inner.setName("twx");
		System.out.println(ex7.getName());
	}
}
