package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GHYT15.GenericUtility.ExcelUtility;


public class BookTicketProgramForDataProvider {
	@Test(dataProvider = "dataProvider_bookTicketTest")
	public void bookTicketTest(String src,String dst) {
		System.out.println("Book ticket from"+src+"to"+dst);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest() throws EncryptedDocumentException, IOException{
		Object[][] objArr=new Object[5][2];
		
		ExcelUtility eu=new ExcelUtility();
		String bang = eu.getExcelData("Sheet3", 1, 0);
		objArr[0][0]=bang;
		objArr[0][1]="Goa";
		
		objArr[1][0]=bang;
		objArr[1][1]="Mysore";
		
		objArr[2][0]=bang;
		objArr[2][1]="Mangalore";
		
		objArr[3][0]=bang;
		objArr[3][1]="Hydarabad";
		
		objArr[4][0]="Bangal";
		objArr[4][1]="Mp";
		
		return objArr;
		
	}

}
