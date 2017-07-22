package com.twx.collection;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
/**
 * ListIterator是Iterator的子接口。<br>ListIterator可以双向移动，可以产生当前位置的前一个和后一个元素的索引，
 * 并且可以用set()方法替换它访问过的最后一个元素（见代码28-32行）
 * @author twx
 *
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets=Pets.arrayList(8);
		//AbstractList.class 的内部类实现了ListIterator接口
		ListIterator<Pet> iterator=pets.listIterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+", "+iterator.nextIndex()+", "+iterator.previousIndex()+"; ");
		}
		System.out.println();
		while(iterator.hasPrevious())
			System.out.print(iterator.previous().id()+" ");
		System.out.println();
		System.out.println(pets);
		
		//替换从位置 【3】开始向前的所有元素
		iterator=pets.listIterator(3);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.set(Pets.randomPet());
		}
		System.out.println(pets);
	}
	
}
