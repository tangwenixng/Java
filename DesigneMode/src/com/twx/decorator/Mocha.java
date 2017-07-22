package com.twx.decorator;

public class Mocha extends Decorator {
	private String description = "摩卡";
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription(){  
//		System.out.println("4加了摩卡");
        return beverage.getDescription()+description+" ";  
    }  
    public double getPrice(){  
        return beverage.getPrice()+10;  
    } 
}
