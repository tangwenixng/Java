package com.twx.collection;

import java.util.ArrayList;
import java.util.Collection;
/**
 * ÈÝÆ÷µÄ´òÓ¡
 * @author twx
 *
 */
public class PrintingContainers {
	public static Collection fill(Collection<String> c) {
		c.add("cat");
		c.add("cat");
		c.add("dog");
		c.add("dog");
		return c;
	}
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
	}
}
