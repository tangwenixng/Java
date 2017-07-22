package com.twx.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate{

	private List<Object> list = new ArrayList<Object>();
	
	public int size(){
		return list.size();
	}
	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	public Object get(int index){
		return list.get(index);
	}
	
	public void add(Object obj){
		list.add(obj);
	}

}
