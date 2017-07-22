package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Á·Ï°1
 * @author twx
 *
 */
public class Gerbil8 {
	private int gerbilNumber;
	public Gerbil8(int i) {
		this.gerbilNumber=i;
	}
	public static void hop(Iterator<Gerbil8> it) {
		while(it.hasNext()){
			Gerbil8 next = it.next();
			System.out.println("It's number is :"+next.gerbilNumber);
		}
	}
	public static void main(String[] args) {
		ArrayList<Gerbil8> list=new ArrayList<Gerbil8>();
		for(int i=0;i<5;i++)
			list.add(new Gerbil8(i));
		/*for(Gerbil g:list)
			g.hop();*/
		hop(list.iterator());
	}
}
