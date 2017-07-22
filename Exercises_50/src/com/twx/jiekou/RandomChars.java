package com.twx.jiekou;

import java.util.Random;

public class RandomChars {
	private Random random =new Random();
	public char create(){
		return (char)random.nextInt(100);
	}
}
