package com.twx.decorator;

public class Milk extends Decorator {
	private String description = "牛奶";
	private Beverage beverage;
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription(){  
//		System.out.println("3加了牛奶");
        return beverage.getDescription()+description+" ";  
    }  
    public double getPrice(){  
        return beverage.getPrice()+20;  //20表示牛奶的价格  
    } 
}
