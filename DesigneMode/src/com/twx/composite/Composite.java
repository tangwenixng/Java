package com.twx.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
	private List<Component> list = new ArrayList<Component>();
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		list.add(component);
	}

	@Override
	public void remove(Component component) {
		list.remove(component);
	}

	@Override
	public void display(int depth) {
		StringBuilder sb = new StringBuilder(depth);
		for(int i=0;i<depth;i++)
			sb.append("-");
		System.out.println(sb.toString()+name);
		
		for(Component c:list){
			c.display(depth+2);
		}
	}

}
