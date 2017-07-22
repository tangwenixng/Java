package com.teaegg.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo2();
	}
	
	/**
	 * 使用FileWriter类写文本文件
	 */
	public static void demo1() {
		String fileName="g:"+File.separator+"test.txt";
		
		try {
			//使用这个构造函数时，如果存在test.txt文件，                       
			//则先把这个文件给删除掉，然后创建新的test.txt
			FileWriter fileWriter=new FileWriter(fileName);
			
			fileWriter.write("Hello demo:\n");
			fileWriter.write("this is just a test:\n");
			fileWriter.write("i love you!");
			fileWriter.close();
			
			System.out.println("ending!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用FileWriter类往文本文件中追加信息
	 */
	public static void demo2(){
		
		String fileName="g:"+File.separator+"test.txt";
		try {
			//使用这个构造函数时，如果存在test.txt文件，                       
			//则直接往test.txt中追加字符串
			FileWriter fileWriter=new FileWriter(fileName,true);
			
			SimpleDateFormat format=new SimpleDateFormat();
			String str=format.format(new Date());
			
			fileWriter.write("\n\t"+str);
			fileWriter.close();
			
			System.out.println("ending");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
