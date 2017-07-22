package com.twx.composite;
/**
 * 叶子节点
 * @author twx
 *
 */
public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		System.out.println("不能再添加了");
	}

	@Override
	public void remove(Component component) {
		System.out.println("不能删除了");
	}

	@Override
	public void display(int depth) {
		StringBuilder sb = new StringBuilder(depth);
		for(int i=0;i<depth;i++)
			sb.append("-");
		System.out.println(sb.toString()+name);
	}
}
