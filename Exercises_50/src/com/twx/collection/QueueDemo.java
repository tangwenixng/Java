package com.twx.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * Queue:����
 * peek() �ڶ���Ϊ��ʱ���� null,�� element()���׳��쳣
 * poll() �ڶ���Ϊ��ʱ���� null,��remove() ���׳��쳣
 * @author twx
 *
 */
public class QueueDemo {
	public static <E>  void printQ(Queue<E> q) {
		while(q.peek()!=null){
			System.out.print(q.remove()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<Integer>();
		System.out.println(queue);
		Random random=new Random(30);
		for(int i=0;i<10;i++){
			//�Զ���װ���Զ��� nextInt()�������ص�int������ ��װ��Integer
			queue.offer(random.nextInt(i+10));
		}
		printQ(queue);
		
		Queue<Character>  characters=new LinkedList<Character>();
		for(char c: "Bdfdfkdf".toCharArray()){
			//�Զ���װ���Զ��� char������ ��װ��Character
			characters.offer(c);
		}
		printQ(characters);
 	}
}
