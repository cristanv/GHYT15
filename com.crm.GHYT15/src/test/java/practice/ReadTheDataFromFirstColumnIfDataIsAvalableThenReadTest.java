package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromFirstColumnIfDataIsAvalableThenReadTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Loginsheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet data = wb.getSheet("Sheet1");

		int count = data.getLastRowNum();
		String expectedResult = "IPHONE_14";
		for(int i=1;i<=count;i++) {
			Row row = data.getRow(i);
			String FirstColumn = row.getCell(0).getStringCellValue();

			if(FirstColumn.equals(expectedResult)) {
				String SecondColumn = row.getCell(1).getStringCellValue();
				System.out.println("available=====>"+SecondColumn);
			}
		}
	}
}
