package com.teaegg.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ��д������ݺܶ�ʱ��
 * ʹ��BufferedWriter��д�ı��ļ�
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
