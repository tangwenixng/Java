package com.twx.iterator;

public class ConcreteIterator extends Iterator{
	private ConcreteAggregate aggregate;
	int current;
	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public Object next() {
		Object res = null;
		if(current<aggregate.size())
			res = aggregate.get(current);
		current++;
		return res;
	}

	@Override
	public boolean hasNext() {
		return current<aggregate.size()?true:false;
	}

}
