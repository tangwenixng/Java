package com.twx.jiekou.InterfaceAndFactory;

public class Factories {
	public static void main(String[] args) {
		serviceConsume(new ImplFactory1());
		serviceConsume(new ImplFactory2());
	}
	
	public static void serviceConsume(ServiceFactory sf) {
		Service service=sf.getService();
		service.method1();
		service.method2();
	}
}
