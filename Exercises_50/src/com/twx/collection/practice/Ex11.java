package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ex11 {
	public static void iterator(Iterator iterator){
		while(iterator.hasNext()){
			System.out.print(iterator.next().toString()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<>(Arrays.asList("sfs","abc","123","Tom","twx"));
		list.add("abc");
		Set<String> set=new HashSet<>();
		set.addAll(list);
		
		iterator(list.iterator());
		iterator(set.iterator());
	}
}
