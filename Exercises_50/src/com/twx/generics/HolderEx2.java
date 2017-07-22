package com.twx.generics;
class Cryon{
	private String name;
	public Cryon(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
}

public class HolderEx2<T> {
	private T a,b,c;
	public HolderEx2(T a,T b,T c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public T getA() {
		return a;
	}
	public void setA(T a) {
		this.a = a;
	}
	public T getB() {
		return b;
	}
	public void setB(T b) {
		this.b = b;
	}
	public T getC() {
		return c;
	}
	public void setC(T c) {
		this.c = c;
	}
	public String toString() {
		return "a:"+a+", b:"+b+", c:"+c;
	}
	public static void main(String[] args) {
		HolderEx2<Cryon> holderEx2=new HolderEx2<Cryon>(new Cryon("JJ"), new Cryon("KJ"), new Cryon("Micle"));
		System.out.println(holderEx2);
	}
}
