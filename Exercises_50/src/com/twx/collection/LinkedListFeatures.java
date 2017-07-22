package com.twx.collection;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;
/**
 * 操作LinkedList
 * @author twx
 *
 */
public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets=new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println(pets);
		
		System.out.println("pets.getFirst: "+pets.getFirst());
		System.out.println("pets.element: "+pets.element());//为什么和上一行相同呢？
		System.out.println("pets.peek: "+pets.peek());
		
		System.out.println();
		
		//remove() removeFirst() poll() pop()都是删除列表的第一个元素
		System.out.println("pets.remove: "+pets.remove());
		System.out.println(pets);
		
		System.out.println("pets.removeFirst: "+pets.removeFirst());//这一行 和上面的结果不一样了！！
		System.out.println(pets);
		
		System.out.println("pets.poll： "+pets.poll());
		System.out.println(pets);
		
		System.out.println("pop: "+pets.pop());
		System.out.println(pets);
		
		System.out.println();
		
		//addFirst() 在列表的头部添加（栈顶）
		pets.addFirst(new Rat());
		System.out.println(pets);
		
		//offer() add() 是在列表的末尾添加(栈底)
		pets.offer(Pets.randomPet());
		System.out.println("After pets.random: "+pets);
		pets.add(Pets.randomPet());
		System.out.println("After add(): "+pets);
		pets.addLast(new Hamster());
		System.out.println("After addLast(): "+pets);
		
		System.out.println("After removeLast(): "+pets.removeLast());
		System.out.println(pets);
		
	}
}
