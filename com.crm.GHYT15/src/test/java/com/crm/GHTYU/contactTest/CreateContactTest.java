package com.crm.GHTYU.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;
import com.crm.GHYT15.POMrepository.ContactInformationPage;
import com.crm.GHYT15.POMrepository.CreateContactPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;

public class CreateContactTest  {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility wu=new WebDriverUtility();
		LoginPage lp=new LoginPage(driver);
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		HomePage hp=new HomePage(driver);
		
		
		FileUtility fu=new FileUtility();
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
		
		
		String lastname = eu.getExcelData("Sheet1", 1, 3)+ju.getrandomNymber();
		String contactname = eu.getExcelData("Sheet1", 1, 3);
		
		lp.LoginToApplication(ul, un, pw);
	
	    CreateContactPage ccp=new CreateContactPage(driver);
	    
	    hp.clickcontactModule();
		
	    ccp.ClickOnCreatecontactIMG();
		
        ccp.LastNameComp(lastname);
        ccp.ClickOnsaveButton();
         
        ContactInformationPage ci=new ContactInformationPage(driver);
        String text = ci.GetTheTextinContactInformation();

		System.out.println(text);

		String expectResult = contactname;

		if(text.contains(expectResult)) {
			System.out.println("matching successfull");	
		}
		else {
			System.out.println("Not matching");
		}	
		hp.ClickonLogOUTToApplication();
	}

}
