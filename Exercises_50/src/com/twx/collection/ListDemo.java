package com.twx.collection;

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
public class ListDemo {
	public static void main(String[] args) {
		Random random=new Random(47);
		List<Pet> pets=Pets.arrayList(7);
		System.out.println("1: "+pets);
		
		Hamster hamster=new Hamster();
		pets.add(hamster);
		System.out.println("2 "+pets);
		//contains方法用来判断某个对象是否在列表中
		System.out.println("3:"+pets.contains(hamster));
		
		pets.remove(hamster);
		
		Pet pet=pets.get(2);
		//indexOf 可以用来找寻 对象在列表中的位置
		System.out.println("4: "+pet+" "+pets.indexOf(pet));
		
		Pet cymric=new Cymric();
		System.out.println("5: "+pets.indexOf(cymric));
		System.out.println("6: "+pets.remove(cymric));
		
		System.out.println("7: "+pets.remove(pet));
		System.out.println("8: "+pets);
		
		pets.add(3, new Mouse());//效率不及 LinkedList
		System.out.println("9: "+pets);
		
		List<Pet> sublist=pets.subList(1, 4);
		System.out.println("sublist: "+sublist);
		System.out.println("10: "+pets.containsAll(sublist));
		
		//排序并不会改变containsAll的判断
		Collections.sort(sublist);
		System.out.println("sorted sublist: "+sublist);
		System.out.println("11: "+pets.containsAll(sublist));
		
		Collections.shuffle(sublist, random);
		System.out.println("shuffle sublist: "+sublist);
		System.out.println("12: "+pets.containsAll(sublist));
		
		List<Pet> copy=new ArrayList<Pet>(pets);
		sublist=Arrays.asList(pets.get(1),pets.get(4));
		System.out.println("sub: "+sublist);
		//是否有交集
		copy.retainAll(sublist);
		System.out.println("13: "+copy);
		
		copy=new ArrayList<Pet>(pets);
		copy.remove(2);
		System.out.println("14: "+copy);
		
		copy.removeAll(sublist);
		System.out.println("15: "+copy);
	}
}
