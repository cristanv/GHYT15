package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class FrameWorkExample_one {

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
		driver.get(ul);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement path = driver.findElement(By.xpath("//a[.='More']"));
		wdu.mouseOverOnElement(driver, path);
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campname);	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Actual Result:  "+text);

		
	

		if(text.contains(campname)) {
			System.out.println("====Result matching successfull====");	
		}
		else {
			System.out.println("--Result Not matching--");
		}
		
		
		WebElement target = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wdu.mouseOverOnElement(driver, target);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
		driver.close();
	
	}

}
