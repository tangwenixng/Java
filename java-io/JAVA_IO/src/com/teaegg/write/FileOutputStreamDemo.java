package com.teaegg.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节流 --写操作
 * 		1、使用File找到一个文件
 * 		2、使用字节流OutputStream的子类进行实例化操作
 * 		3、进行读写操作
 * 		4、关闭
 * @author twx
 *
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) {
		//要写入的目标文件
		File file=new File("g:"+File.separator+"io.txt");
		
		OutputStream outputStream=null;
		
		try {
			//实例化对象
			outputStream=new FileOutputStream(file);
//			outputStream=new FileOutputStream(file,true);
			
			//要写入的--源
			String string="this just is a test message.";
			
			byte[] bytes=string.getBytes();
			
			//方法1：直接写入
//			outputStream.write(bytes);
			//方法2：循环写入
			for(int i=0;i<bytes.length;i++){
				outputStream.write(i);
			}
			outputStream.close();
			System.out.println("ok");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
