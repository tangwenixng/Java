package com.twx.iterator;

public class Test {
	public static void main(String[] args) {
		ConcreteAggregate aggregate = new ConcreteAggregate();
		aggregate.add("大鸟");
		aggregate.add("小鸟");
		aggregate.add("菜鸟");
		aggregate.add("笨鸟");
		aggregate.add("鸟蛋");
		
		Iterator iterator = aggregate.createIterator();
		while(iterator.hasNext()){
			Object object = iterator.next();
			System.out.println(object);
		}
	}
}
