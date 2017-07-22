package com.twx.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
/**
 * Collection ºÍ Iterator
 * @author twx
 *
 */
public class InterfaceVsIterator {
	public static void main(String[] args) {
		List<Pet> petList=Pets.arrayList(8);
		Set<Pet> petSet=new HashSet<>(petList);
		Map<String, Pet> petMap=new HashMap<String,Pet>();
		String[] strings=("Tdf, Dsa, Fda, Garry, Helly, Wade, James").split(", ");
		for(int i=0;i<strings.length;i++){
			petMap.put(strings[i], petList.get(i));
		}
		display(petList);
		display(petSet);
		
		display(petList.iterator());
		display(petSet.iterator());

		System.out.println(petMap);
	}
	
	public static void display(Collection<Pet> collection) {
		for(Pet p: collection){
			System.out.print(p.id()+" "+p+" ");
		}
		System.out.println();
	}
	
	public static void display(Iterator<Pet> iterator) {
		while(iterator.hasNext()){
			Pet pet=iterator.next();
			System.out.print(pet.id()+" "+pet+" ");
		}
		System.out.println();
	}
}
