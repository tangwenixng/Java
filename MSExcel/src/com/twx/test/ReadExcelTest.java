package com.twx.test;

import java.io.File;

import com.twx.opt.MSExcel_Impl;

public class ReadExcelTest {

	public static void main(String[] args) {
		//���в��Գ��򣺱�Unable to recognize OLE stream��
		//ԭ�򣺲�֧����ȡ excel 2007 �ļ�(*.xlsx)��ֻ֧�� excel 2003 (*.xls)
		//��ȡexcel2007���Ի�poi��
		File file=new java.io.File("G:\\slim-teaegg\\test.xls");
		System.out.println(MSExcel_Impl.readExcel(file));

	}
}
