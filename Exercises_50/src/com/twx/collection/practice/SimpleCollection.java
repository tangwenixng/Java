package com.twx.collection.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * µÚ19ÕÂ Á·Ï°2
 * @author twx
 *
 */
public class SimpleCollection {
	public static void main(String[] args) {
		Random random=new Random();
		Set<Integer> c=new HashSet<>();
		for(int i=0;i<5;i++){
			c.add(random.nextInt(30));
		}
		for(Integer i:c)
			System.out.println(i);
	}
}
