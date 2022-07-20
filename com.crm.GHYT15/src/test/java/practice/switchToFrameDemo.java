package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class switchToFrameDemo {

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility excelut=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
	
		String campname = excelut.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		
		
		WebDriver driver=new ChromeDriver();
		wdu.waitForElementInDOM(driver);
		driver.get(ul);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		
		//driver.findElement(By.xpath("(//span[@class='cke_text cke_inline_label'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("cristan");
		

	}

}
