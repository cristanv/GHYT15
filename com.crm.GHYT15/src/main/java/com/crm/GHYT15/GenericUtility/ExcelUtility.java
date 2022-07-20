package com.crm.GHYT15.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.result.Row;

public class ExcelUtility {
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Loginsheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();	
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/Loginsheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setExcelData(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Loginsheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./data/Loginsheet.xlsx");
		wb.write(fos);
		wb.close();		
	}
}



