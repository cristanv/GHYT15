package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllRowDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Loginsheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet data = wb.getSheet("Sheet1");
		
		int count = data.getLastRowNum();
		
		for(int i=1;i<=count;i++) {
			Row row = data.getRow(i);
			String firstcolumn = row.getCell(0).getStringCellValue();
			String secondcolumn = row.getCell(1).getStringCellValue();
			System.out.println(firstcolumn+"\t"+secondcolumn);
		}

	}

}
