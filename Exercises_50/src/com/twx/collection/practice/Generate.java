package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
/**
 * 11 ÕÂ Á·Ï°4
 * @author twx
 *
 */
public class Generate {
	Random random=new Random();
	public String next(){
		switch (random.nextInt(3)) {
		default:
		case 0:
			return "Xialuoke";
		case 1:
			return "White";
		case 2:
			return "Snow";
		}
	}
	public Collection fill(Collection<String> c) {
		for(int i=0;i<10;i++)
			c.add(next());
		return c;	
	}
	
	public static void main(String[] args) {
		Generate g=new Generate();
		System.out.println(g.fill(new ArrayList<String>()));
		System.out.println(g.fill(new LinkedList<String>()));
	}
}
