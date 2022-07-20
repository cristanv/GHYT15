package com.crm.GHTY.OpportunitiesTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;
import com.crm.GHYT15.POMrepository.LoginPage;

public class CreateOpportunitiesWithOrganizationAndCampaignSourceTest extends WebDriverUtility{

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wu=new WebDriverUtility();
		wu.waitForElementInDOM(driver);
		//waitForElementInDOM(driver);
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		
		
		
		
		String ul=fu.getPropertyKeyValue("url");
		String un=fu.getPropertyKeyValue("username");
		String pw=fu.getPropertyKeyValue("password");

		ju.getrandomNymber();
		
		String username = eu.getExcelData("Sheet1", 1, 0)+ju.getrandomNymber();
		String lastname = eu.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		String Productname = eu.getExcelData("Sheet1", 1, 5)+ju.getrandomNymber();
		String Orgname = eu.getExcelData("Sheet1", 1, 7)+ju.getrandomNymber();
		String Oponame = eu.getExcelData("Sheet1", 1, 8)+ju.getrandomNymber();
		String Organizname = eu.getExcelData("Sheet2", 1, 0)+ju.getrandomNymber();
		String Opname = eu.getExcelData("Sheet2", 2, 0)+ju.getrandomNymber();
		String camp = eu.getExcelData("Sheet2", 1, 1)+ju.getrandomNymber();
		String Oppinf = eu.getExcelData("Sheet1", 1, 2)+ju.getrandomNymber();
		String CrtingnewOpp = eu.getExcelData("Sheet1", 1, 3)+ju.getrandomNymber();
		
		

//		FileInputStream fs=new FileInputStream("./data/Loginsheet.xlsx");		
//		Workbook wb=WorkbookFactory.create(fs);
		//String username = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue()+num;
//		String lastname = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue()+num;
//		String Productname = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue()+num;
//		String Orgname = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue()+num;
//		String Oponame = wb.getSheet("Sheet1").getRow(1).getCell(8).getStringCellValue()+num;
//		String Organizname = wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue()+num;
//		String Opname = wb.getSheet("Sheet2").getRow(2).getCell(0).getStringCellValue()+num;
//		String camp = wb.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue()+num;
//		String Oppinf = wb.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue()+num;
//		String CrtingnewOpp = wb.getSheet("Sheet2").getRow(1).getCell(3).getStringCellValue()+num;
		System.out.println(camp);
		
		
		System.out.println(Orgname);
		System.out.println(Productname);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApplication(ul, un, pw);
		
		
//		driver.get(ul);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
//		driver.findElement(By.id("submitButton")).click();	
//		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Orgname);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Actual Result:  "+text);

		//String expectResult = "Caliper Marketing pvt ltd";

		if(text.contains(Orgname)) {
			System.out.println("====Result matching successfull====");	
		}
		else {
			System.out.println("Not matching");
		}
		
		Actions a=new Actions(driver);
		WebElement path = driver.findElement(By.xpath("//a[.='More']"));
		a.moveToElement(path).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(Productname);	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		String text2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Actual Result:  "+text2);

		//String expectResult2 = "HP Laptop";
		//System.out.println("Expected Result: "+expectResult2);

		if(text2.contains(Productname)) {
			System.out.println("====Result matching successfull====");	
		}
		else {
			System.out.println("--Result Not matching--");
		}
		
		driver.findElement(By.xpath("(//a[.='Opportunities'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(Oponame);
		
		
		WebElement pth = driver.findElement(By.id("related_to_type"));
		Select s=new Select(pth);
		s.selectByValue("Accounts");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String wh = it.next();
			driver.switchTo().window(wh);
			String text3 = driver.findElement(By.className("moduleName")).getText();
			if(text3.contains(Organizname))
				break;				
		}
		driver.findElement(By.id("search_txt")).sendKeys(Orgname);
		driver.findElement(By.name("search")).click();
	    driver.findElement(By.id("1")).click();
	    
	    Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set2.iterator();
		
		while(it2.hasNext()) {
			String wh2 = it2.next();
			driver.switchTo().window(wh2);
			String text4 = driver.findElement(By.xpath("(//a[.='Opportunities'])[2]")).getText();
			if(text4.contains(Opname))
				break;				
		}
	    driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
	    
	    Set<String> set3 = driver.getWindowHandles();
	    Iterator<String> it3 = set3.iterator();
	    while(it3.hasNext()) {
	    	String wh3 = it3.next();
	    	driver.switchTo().window(wh3);
	    	String text5 = driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
	    	if(text5.contains(camp)) {
	    	break;
	    }
		
		driver.findElement(By.name("search_text")).sendKeys(Productname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		
//		Set<String> set4 = driver.getWindowHandles();
//		Iterator<String> it4 = set4.iterator();
//		while(it4.hasNext()) {
//			String wh4 = it4.next();
//			driver.switchTo().window(wh4);
//			String text6 = driver.findElement(By.className("lvtHeaderText")).getText();
//			if(text6.contains(CrtingnewOpp)) {
//			break;
//		}
//		
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		
//		String text7 = driver.findElement(By.className("dvHeaderText")).getText();
//		if(text7.contains(Oppinf)) {
//			System.out.println("Opportunity information Text is Matching Successfully");
//		}
//		else
//			System.out.println("Not Matching");
//	
//	}
	    }
	}
}
