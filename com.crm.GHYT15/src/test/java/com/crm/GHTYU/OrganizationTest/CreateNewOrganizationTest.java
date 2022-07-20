package com.crm.GHTYU.OrganizationTest;

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
import com.crm.GHYT15.POMrepository.CreateNewOrganizationPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.OrganizationInformationPage;
import com.crm.GHYT15.POMrepository.OrganizationPage;

public class CreateNewOrganizationTest extends WebDriverUtility{

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		driver=new ChromeDriver();
		
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganizationPage op=new OrganizationPage(driver);
		
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
		
		lp.LoginToApplication(ul, un, pw);
		
		WebDriverUtility wu=new WebDriverUtility();
		wu.waitForElementInDOM(driver);

		String Organizname = eu.getExcelData("Sheet1", 1, 7)+ju.getrandomNymber();
		String organiztionNameToConfirm = eu.getExcelData("Sheet1", 1, 7);

		hp.clickOrganizationModule();
		
		op.ClickOnCreateOrganizationImage();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.WriteOrganizationNameComp(Organizname);
		cnop.ClickOnSaveButton();
	
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String text = oip.GetTheTextToVerify();
		System.out.println(text);
		String expectResult = organiztionNameToConfirm;

		if(text.contains(expectResult)) {
			System.out.println("matching successfull");	
		}
		else {
			System.out.println("Not matching");
		}
		
		hp.ClickonLogOUTToApplication();

	}

}
