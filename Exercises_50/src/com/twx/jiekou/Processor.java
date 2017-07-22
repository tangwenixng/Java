package com.twx.jiekou;

public interface Processor {
	String name();
	Object process(Object input);
}
