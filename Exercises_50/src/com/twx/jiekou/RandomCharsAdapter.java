package com.twx.jiekou;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class RandomCharsAdapter extends RandomChars implements Readable{
	private int size;
	public RandomCharsAdapter(int size) {
		this.size=size;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(size--==0)
			return -1;
		String string=Character.toString(create())+" ";
		cb.append(string);
		return string.length();
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new RandomCharsAdapter(10));
		while(scanner.hasNext()){
			System.out.print(scanner.next()+" ");
		}
	}
}
