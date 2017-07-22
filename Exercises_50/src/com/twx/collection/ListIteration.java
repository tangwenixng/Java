package com.twx.collection;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
/**
 * ListIterator��Iterator���ӽӿڡ�<br>ListIterator����˫���ƶ������Բ�����ǰλ�õ�ǰһ���ͺ�һ��Ԫ�ص�������
 * ���ҿ�����set()�����滻�����ʹ������һ��Ԫ�أ�������28-32�У�
 * @author twx
 *
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets=Pets.arrayList(8);
		//AbstractList.class ���ڲ���ʵ����ListIterator�ӿ�
		ListIterator<Pet> iterator=pets.listIterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+", "+iterator.nextIndex()+", "+iterator.previousIndex()+"; ");
		}
		System.out.println();
		while(iterator.hasPrevious())
			System.out.print(iterator.previous().id()+" ");
		System.out.println();
		System.out.println(pets);
		
		//�滻��λ�� ��3����ʼ��ǰ������Ԫ��
		iterator=pets.listIterator(3);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.set(Pets.randomPet());
		}
		System.out.println(pets);
	}
	
}
