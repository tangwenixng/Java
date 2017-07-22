package com.twx.singleton;

import java.sql.Connection;

public class Test {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println("hashcode 1: "+singleton.hashCode());
		
		Singleton singleton2 = Singleton.getInstance();
		System.out.println("hashcode 1: "+singleton2.hashCode());
	}
}
