package com.teaegg.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * ×Ö½ÚÁ÷--¶Á²Ù×÷
 * @author twx
 *
 */
public class InputStreamDemo {
	public static void main(String[] args) {
		File file=new File("g:"+File.separator+"io.txt");
		
		try {
			InputStream inputStream=new FileInputStream(file);
			
			byte[] b=new byte[(int) file.length()];
			for(int i=0;i<b.length;i++){
				b[i]=(byte)inputStream.read();
			}
			System.out.println(new String(b));
			System.out.println("ending");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
