package com.twx.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, Integer> map=new HashMap<Integer,Integer>();
		Random random=new Random(30);
		for(int i=0;i<1000;i++){
			int k=random.nextInt(10);
			Integer v=map.get(k);
			map.put(k, v==null?1:v+1);
		}
		System.out.println(map);
	}
}
