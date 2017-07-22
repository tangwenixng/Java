package com.twx.collection;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;
/**
 * ����LinkedList
 * @author twx
 *
 */
public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets=new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println(pets);
		
		System.out.println("pets.getFirst: "+pets.getFirst());
		System.out.println("pets.element: "+pets.element());//Ϊʲô����һ����ͬ�أ�
		System.out.println("pets.peek: "+pets.peek());
		
		System.out.println();
		
		//remove() removeFirst() poll() pop()����ɾ���б�ĵ�һ��Ԫ��
		System.out.println("pets.remove: "+pets.remove());
		System.out.println(pets);
		
		System.out.println("pets.removeFirst: "+pets.removeFirst());//��һ�� ������Ľ����һ���ˣ���
		System.out.println(pets);
		
		System.out.println("pets.poll�� "+pets.poll());
		System.out.println(pets);
		
		System.out.println("pop: "+pets.pop());
		System.out.println(pets);
		
		System.out.println();
		
		//addFirst() ���б��ͷ����ӣ�ջ����
		pets.addFirst(new Rat());
		System.out.println(pets);
		
		//offer() add() �����б��ĩβ���(ջ��)
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
