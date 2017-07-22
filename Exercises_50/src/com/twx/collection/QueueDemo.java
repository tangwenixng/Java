package com.twx.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * Queue:对列
 * peek() 在队列为空时返回 null,而 element()会抛出异常
 * poll() 在队列为空时返回 null,而remove() 会抛出异常
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
			//自动包装机自动将 nextInt()方法返回的int型数据 包装成Integer
			queue.offer(random.nextInt(i+10));
		}
		printQ(queue);
		
		Queue<Character>  characters=new LinkedList<Character>();
		for(char c: "Bdfdfkdf".toCharArray()){
			//自动包装机自动将 char型数据 包装成Character
			characters.offer(c);
		}
		printQ(characters);
 	}
}
