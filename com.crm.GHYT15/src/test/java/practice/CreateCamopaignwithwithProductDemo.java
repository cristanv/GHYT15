package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class CreateCamopaignwithwithProductDemo {

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility excelut=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
		
		
		
		String campname = excelut.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		String prodname = excelut.getExcelData("Sheet1", 1, 5)+ju.getrandomNymber();
		String prod = excelut.getExcelData("Sheet1", 1, 6)+ju.getrandomNymber();
		String campnm = excelut.getExcelData("Sheet2", 1, 1)+ju.getrandomNymber();
		String Campignname = excelut.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		
		
		WebDriver driver=new ChromeDriver();
		wdu.waitForElementInDOM(driver);
		driver.get(ul);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prodname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		WebElement path = driver.findElement(By.xpath("//a[.='More']"));
		
		wdu.mouseOverOnElement(driver, path);
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campname);	
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		

		
//		WebElement target = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//		wdu.mouseOverOnElement(driver, target);
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
		//driver.close();
		
		wdu.switchToChildWindow(driver, prod);
		
		driver.findElement(By.id("search_txt")).sendKeys(prodname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.id("1")).click();
		
		wdu.switchToParentWindow(driver, campnm);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(text);
		
		if(text.contains(Campignname)) {
			System.out.println("Matching successfull");
		}
		else {
			System.out.println("Not Matching");
		}
		Actions act=new Actions(driver);
		WebElement target = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		act.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
       
		
	}
	
	

}


