package com.teaegg.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用BufferedReader类读文本文件
 * @author twx
 *
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {
		File file=new File("g:"+File.separator+"test.txt");
		String str="";
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			str=reader.readLine();
			while(str!=null){
				System.out.println(str);
				str=reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
