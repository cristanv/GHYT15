package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcelFileTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Loginsheet.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		String ul = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		
		String un = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		String pw = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		
		WebDriver driver=new ChromeDriver();
		driver.get(ul);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();		

	}

}
