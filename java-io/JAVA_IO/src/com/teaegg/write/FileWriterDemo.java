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
	 * ʹ��FileWriter��д�ı��ļ�
	 */
	public static void demo1() {
		String fileName="g:"+File.separator+"test.txt";
		
		try {
			//ʹ��������캯��ʱ���������test.txt�ļ���                       
			//���Ȱ�����ļ���ɾ������Ȼ�󴴽��µ�test.txt
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
	 * ʹ��FileWriter�����ı��ļ���׷����Ϣ
	 */
	public static void demo2(){
		
		String fileName="g:"+File.separator+"test.txt";
		try {
			//ʹ��������캯��ʱ���������test.txt�ļ���                       
			//��ֱ����test.txt��׷���ַ���
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
