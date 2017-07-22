package com.twx.decorator;

public class CoffeeBean1 implements Beverage {
	private String descripton = "第一种咖啡加入了 ";
	@Override
	public String getDescription() {
//		System.out.println("1第一种咖啡店");
		return descripton;
	}

	@Override
	public double getPrice() {
		return 50;
	}

}
