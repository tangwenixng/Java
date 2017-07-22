package com.twx.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import sun.reflect.generics.tree.VoidDescriptor;

public class SetDemo {
	public static void main(String[] args) {
		SetDemo setDemo=new SetDemo();
		/*setDemo.method1();
		System.out.println();
		setDemo.method2();*/
		setDemo.method3();
	}
	//有序排列
	public void method1() {
		Random random=new Random(47);
		SortedSet<Integer> inSet=new TreeSet<Integer>();
		
		for(int i=0;i<1000;i++){
			inSet.add(random.nextInt(30));
		}
		System.out.println(inSet);
	}
	//无序排列
	public void method2() {
		Random random=new Random(50);
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<1000;i++){
			set.add(random.nextInt(30));
		}
		System.out.println(set);
	}
	
	public void method3(){
		Set<String> words=new TreeSet<String>(new TextFile("setTest.txt", "\\W+"));
		System.out.println(words);
	}
}
