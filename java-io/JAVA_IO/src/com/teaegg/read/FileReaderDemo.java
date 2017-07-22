package com.teaegg.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 使用FileReader类读文本文件
 * @author twx
 * java.io.InputStreamReader
 * 		java.io.FileReader
 *
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		File file=new File("g:"+File.separator+"test.txt");
		int c=0;
		try {
			FileReader reader=new FileReader(file);
			c=reader.read();
			while(c!=-1){
				System.out.print((char)c);
				c=reader.read();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
