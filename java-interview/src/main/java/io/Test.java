package io;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			MyUtil.fileCopy("C:\\Users\\twx\\Desktop\\test.txt", "C:\\Users\\twx\\Desktop\\output.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
