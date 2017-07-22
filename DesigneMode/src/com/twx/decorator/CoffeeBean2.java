package com.twx.decorator;

public class CoffeeBean2 implements Beverage {
	private String descripton = "第二种咖啡加入了 ";
	@Override
	public String getDescription() {
//		System.out.println("2第二种咖啡店");
		return descripton;
	}

	@Override
	public double getPrice() {
		return 60;
	}

}
