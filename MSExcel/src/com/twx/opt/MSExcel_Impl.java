package com.twx.opt;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
/**
 * jxl.jar包只能操作  .xls文件
 * 包名：opt==operation
 * @author twx
 *
 */
public class MSExcel_Impl {
	/**
	 * 读取excel内容
	 * @param file
	 * @return
	 */
	public static String readExcel(File file){
		StringBuffer stringBuffer=new StringBuffer();
		Workbook wb=null;
		try {
			//获取-工作簿-对象
			wb=Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(wb==null)
			return null;
		
		//获取工作表--sheet
		Sheet[] sheets=wb.getSheets();
		
		if(sheets!=null&&sheets.length>0){
			//循环工作表
			for(Sheet sheet:sheets){
				int row=sheet.getRows();
				//循环-行
				for(int i=0;i<row;i++){
					//获取这一行的所有单元格
					Cell[] cells=sheet.getRow(i);
					if(cells!=null&&cells.length>0){
						//循环单元格
						for(Cell cell:cells){
							String content=cell.getContents();
							stringBuffer.append(content+" ");
						}
						stringBuffer.append("\n");
					}
				}
			}
		}
		wb.close();
		return stringBuffer.toString();
	}
	
	/**
	 * 写入Excel文件
	 * @param fileName
	 */
	public static void writeExcel(String fileName){
		WritableWorkbook wwb=null;
		
		try {
			//创建一个“可写的”工作簿对象
			wwb=Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(wwb!=null){
			//创建工作表
			WritableSheet ws=wwb.createSheet("sheet1", 0);
			
			//添加单元格
			//10行5列
			for(int i=0;i<10;i++){
				for(int j=0;j<5;j++){
					//第一个参数表示列，第二个参数表示行
					Label label=new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列");
					
					try {
						//把数据添加到单元格里
						ws.addCell(label);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				//写入文件中
				wwb.write();
				wwb.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查询文件中是否包含 keyWord关键字
	 * @param file
	 * @param keyWord
	 * @return
	 */
	public static boolean searchKeyWord(File file,String keyWord){
		boolean result=false;
		
		Workbook wb=null;
		
		try {
			//获取工作簿--对象
			wb=Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		if(wb==null)
			return result;
		
		Sheet[] sheets=wb.getSheets();
		
		if(sheets!=null&&sheets.length>0){
			boolean sheetFlag=false;
			//便利  工作表 sheet
			for(Sheet sheet:sheets){
				if(sheetFlag)
					break;
				
				boolean rowFlag=false;
				int row=sheet.getRows();
				//循环 行
				for(int i=0;i<row;i++){
					if(rowFlag)
						break;
					
					boolean cellFlag=false;
					//获得 这一行的 所有 单元格
					Cell[] cells=sheet.getRow(i);
					for(Cell cell:cells){
						if(cellFlag)
							break;
						
						//获取 到 单元格的  内容
						String str=cell.getContents();
						if(str.contains(keyWord)){
							sheetFlag=true;
							rowFlag=true;
							cellFlag=true;
							result=true;
						}
					}
				}
			}
		}
		wb.close();
		
		return result;
	}
}
