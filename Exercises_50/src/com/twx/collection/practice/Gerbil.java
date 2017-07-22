package com.twx.collection.practice;

import java.util.ArrayList;
/**
 * Á·Ï°1
 * @author twx
 *
 */
public class Gerbil {
	private int gerbilNumber;
	public Gerbil(int i) {
		this.gerbilNumber=i;
	}
	public void hop() {
		System.out.println("It's number is :"+gerbilNumber);
	}
	public static void main(String[] args) {
		ArrayList<Gerbil> list=new ArrayList<Gerbil>();
		for(int i=0;i<5;i++)
			list.add(new Gerbil(i));
		for(Gerbil g:list)
			g.hop();
	}
}
