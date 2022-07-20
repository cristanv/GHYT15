package com.crm.GHTYU.CampaignTest;

import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.FileUtility;
import com.crm.GHYT15.GenericUtility.JavaUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;
import com.crm.GHYT15.POMrepository.CampaignInformationPage;
import com.crm.GHYT15.POMrepository.CampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewCampaignPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;

public class CreateCampaignTest extends WebDriverUtility{

		public static void main(String[] args) throws Throwable {
			WebDriver driver=new ChromeDriver();
			
			FileUtility fu=new FileUtility();
			WebDriverUtility wdu=new WebDriverUtility();
			ExcelUtility excelut=new ExcelUtility();
			JavaUtility ju=new JavaUtility();
			LoginPage lp=new LoginPage(driver);
			HomePage hp=new HomePage(driver);
			CreateNewCampaignPage cnp=new CreateNewCampaignPage(driver);
			CampaignPage cp=new CampaignPage(driver);
			CampaignInformationPage cip=new CampaignInformationPage(driver);
				
			String ul = fu.getPropertyKeyValue("url");
			String un = fu.getPropertyKeyValue("username");
			String pw = fu.getPropertyKeyValue("password");
			
			String campname = excelut.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
			System.out.println(campname);
			
			wdu.waitForElementInDOM(driver);
			lp.LoginToApplication(ul, un, pw);
			
			hp.ClickOnCampaignModule();
		
			cp.ClickOnCreateCampainimage();
			
			cnp.WriteCampaignNameInComp(campname);
			cnp.ClickOnSaveButton();
			
			String text = cip.GetTextFromCampaigninfPage();
			System.out.println("Actual Result:  "+text);
			
			//To match the Text
			//Assert.assertEquals(text, campname);
			Assert.assertTrue(text.contains(campname));

//			if(text.contains(campname)) {
//				System.out.println("====Result matching successfull====");	
//			}
//			else {
//				System.out.println("--Result Not matching--");
//			}
			hp.ClickonLogOUTToApplication();
		}
}
