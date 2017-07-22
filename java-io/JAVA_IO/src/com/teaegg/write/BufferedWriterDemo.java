package com.teaegg.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 当写入的内容很多时：
 * 使用BufferedWriter类写文本文件
 * @author twx
 *
 */
public class BufferedWriterDemo {

	public static void main(String[] args) {
		String fileName="g:"+File.separator+"test.txt";
		
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
			writer.write("hello:");
			writer.newLine();
			writer.write("my name is twx");
			writer.close();
			System.out.println("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
