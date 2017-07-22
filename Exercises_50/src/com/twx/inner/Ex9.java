package com.twx.inner;

interface Ex9_Interface{
	String getName();
}
public class Ex9 {
	private String name;
	public Ex9_Interface getInterface(){
		return new Ex9_Interface(){
			public String getName() {return name;}
		};
	}
}
