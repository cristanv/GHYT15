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
import org.openqa.selenium.support.ui.Select;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;
import com.crm.GHYT15.POMrepository.ContactInformationPage;
import com.crm.GHYT15.POMrepository.CreateContactPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.contactPage;

public class CreateAndDeleteTheContact extends WebDriverUtility{

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		
		FileUtility fu=new FileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
			
		String ul =fu.getPropertyKeyValue("url");
		String un =fu.getPropertyKeyValue("username");
		String pw =fu.getPropertyKeyValue("password");
		
		String lastname = eu.getExcelData("Sheet1", 1, 3)+ju.getrandomNymber();
		String AlertText = eu.getExcelData("Sheet2", 1, 4);
		String textToConfirmcontact = eu.getExcelData("Sheet2", 4, 2);
		System.out.println(textToConfirmcontact);
		
		wu.waitForElementInDOM(driver);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApplication(ul, un, pw);
	
		
		HomePage hp=new HomePage(driver);
		hp.clickcontactModule();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.ClickOnCreatecontactIMG();
		
		ccp.LastNameComp(lastname);
        ccp.ClickOnsaveButton();

		
        ContactInformationPage ci=new ContactInformationPage(driver);
        ci.ClickOnDeleteButton();
		 
		wu.swithToAlertWindowAndAccpect(driver, AlertText);//Alert popup
		
		contactPage cp=new contactPage(driver);
				
		cp.WritesearchComp(lastname);
		
		
		cp.ClickonListBoxDropdown();
		cp.ClickOnSearchNOwButton();
		
		String text = cp.StriGetTextToConfirm();
		
		String expectResult = textToConfirmcontact;
		if(text.contains(expectResult)) {
			System.out.println("Contact Deletion successfull");	
		}
		else {
			System.out.println("Contact Deletion Failed");
		}
		
		hp.ClickonLogOUTToApplication();
	}

}
