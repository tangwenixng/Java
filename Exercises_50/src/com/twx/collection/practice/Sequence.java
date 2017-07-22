package com.twx.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Á·Ï°3
 * Á·Ï°9
 * @author twx
 *
 */

/*interface Selector {
	boolean end();

	Object current();

	void next();
}*/

public class Sequence {
	private ArrayList<Object> list=new ArrayList<>();

	public void add(Object x) {
		list.add(x);
	}

	/*private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == list.size();
		}

		public Object current() {
			return list.get(i);
		}

		public void next() {
			if (i < list.size())
				i++;
		}
		public Sequence outer(){
			return Sequence.this;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}*/
	public Iterator<Object> iterator(){
		return list.iterator();
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
//		Selector selector = sequence.selector();
		Iterator<Object> iterator = sequence.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
} /*
	 * Output: 0 1 2 3 4 5 6 7 8 9
	 */// :~
