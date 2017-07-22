package com.twx.decorator;

public class Test {
	public static void main(String[] args) {
		Beverage beverage = new CoffeeBean2();
//		System.out.println(beverage.getDescription());
		
		Milk milk= new Milk(beverage);
		
		Mocha mocha = new Mocha(milk);
		
		System.out.println(mocha.getDescription());
//		System.out.println(beverage.getDescription()+"\n加了摩卡和牛奶的咖啡价格："+beverage.getPrice());
	}
}
