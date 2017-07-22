package com.twx.test;

import java.io.File;

import com.twx.opt.MSExcel_Impl;

public class ReadExcelTest {

	public static void main(String[] args) {
		//运行测试程序：报Unable to recognize OLE stream错
		//原因：不支出读取 excel 2007 文件(*.xlsx)。只支持 excel 2003 (*.xls)
		//读取excel2007可以换poi包
		File file=new java.io.File("G:\\slim-teaegg\\test.xls");
		System.out.println(MSExcel_Impl.readExcel(file));

	}
}
