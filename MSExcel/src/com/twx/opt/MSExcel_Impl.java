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
 * jxl.jar��ֻ�ܲ���  .xls�ļ�
 * ������opt==operation
 * @author twx
 *
 */
public class MSExcel_Impl {
	/**
	 * ��ȡexcel����
	 * @param file
	 * @return
	 */
	public static String readExcel(File file){
		StringBuffer stringBuffer=new StringBuffer();
		Workbook wb=null;
		try {
			//��ȡ-������-����
			wb=Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(wb==null)
			return null;
		
		//��ȡ������--sheet
		Sheet[] sheets=wb.getSheets();
		
		if(sheets!=null&&sheets.length>0){
			//ѭ��������
			for(Sheet sheet:sheets){
				int row=sheet.getRows();
				//ѭ��-��
				for(int i=0;i<row;i++){
					//��ȡ��һ�е����е�Ԫ��
					Cell[] cells=sheet.getRow(i);
					if(cells!=null&&cells.length>0){
						//ѭ����Ԫ��
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
	 * д��Excel�ļ�
	 * @param fileName
	 */
	public static void writeExcel(String fileName){
		WritableWorkbook wwb=null;
		
		try {
			//����һ������д�ġ�����������
			wwb=Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(wwb!=null){
			//����������
			WritableSheet ws=wwb.createSheet("sheet1", 0);
			
			//��ӵ�Ԫ��
			//10��5��
			for(int i=0;i<10;i++){
				for(int j=0;j<5;j++){
					//��һ��������ʾ�У��ڶ���������ʾ��
					Label label=new Label(j, i, "���ǵ�"+(i+1)+"�У���"+(j+1)+"��");
					
					try {
						//��������ӵ���Ԫ����
						ws.addCell(label);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				//д���ļ���
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
	 * ��ѯ�ļ����Ƿ���� keyWord�ؼ���
	 * @param file
	 * @param keyWord
	 * @return
	 */
	public static boolean searchKeyWord(File file,String keyWord){
		boolean result=false;
		
		Workbook wb=null;
		
		try {
			//��ȡ������--����
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
			//����  ������ sheet
			for(Sheet sheet:sheets){
				if(sheetFlag)
					break;
				
				boolean rowFlag=false;
				int row=sheet.getRows();
				//ѭ�� ��
				for(int i=0;i<row;i++){
					if(rowFlag)
						break;
					
					boolean cellFlag=false;
					//��� ��һ�е� ���� ��Ԫ��
					Cell[] cells=sheet.getRow(i);
					for(Cell cell:cells){
						if(cellFlag)
							break;
						
						//��ȡ �� ��Ԫ���  ����
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
