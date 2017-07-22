package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex6 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, "twx","james","wade","bruce");
		String s=new String("GG");
		list.add(s);
		System.out.println(list);
		
		List<String> asList = Arrays.asList(list.get(1),list.get(4));
		System.out.println(asList);
	}
}
