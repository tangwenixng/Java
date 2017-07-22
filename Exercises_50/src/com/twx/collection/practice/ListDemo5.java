package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Cymric;
import typeinfo.pets.Hamster;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
/**
 * 11.5 List
 * @author twx
 *
 */
public class ListDemo5 {
	public static List<Integer> listIntegerGenerator(int n){
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random(47);
		for(int i=0;i<n;i++){
			list.add(random.nextInt(30));
		}
		return list;
	}
	public static void main(String[] args) {
		Random random=new Random(47);
		List<Integer> list=listIntegerGenerator(10);
		System.out.println(list);
		list.add(random.nextInt(30));
		System.out.println(list);
		System.out.println(list.contains(29));
		System.out.println(list.indexOf(13));
		List<Integer> subList=list.subList(0, 4);
		Collections.sort(subList);
		System.out.println(subList);
		System.out.println(list.retainAll(subList));
	}
}
