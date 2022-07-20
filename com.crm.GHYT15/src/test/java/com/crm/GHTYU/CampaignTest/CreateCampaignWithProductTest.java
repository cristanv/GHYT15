package com.crm.GHTYU.CampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import com.crm.GHYT15.POMrepository.CampaignInformationPage;
import com.crm.GHYT15.POMrepository.CampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewCampaignPage;
import com.crm.GHYT15.POMrepository.CreateNewProductPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;
import com.crm.GHYT15.POMrepository.ProductPage;

public class CreateCampaignWithProductTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility excelut=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CreateNewCampaignPage cnc=new CreateNewCampaignPage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		ProductPage pp=new ProductPage(driver);
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
		
		String campname = excelut.getExcelData("Sheet1", 1, 4)+ju.getrandomNymber();
		String prodname = excelut.getExcelData("Sheet1", 1, 5)+ju.getrandomNymber();
		String prod = excelut.getExcelData("Sheet1", 1, 6)+ju.getrandomNymber();
		String campnm = excelut.getExcelData("Sheet2", 1, 1)+ju.getrandomNymber();
		String Campignname = excelut.getExcelData("Sheet1", 1, 4);
		
		
		
		wdu.waitForElementInDOM(driver);
		lp.LoginToApplication(ul, un, pw);

		
		hp.ClickOnProductModule();
		pp.ClickOnCreateNewProductImage();
		
		cnp.writeProductNameInComp(prodname);
		cnp.ClickOnSaveButton();
		
		hp.ClickOnCampaignModule();
		
		cp.ClickOnCreateCampainimage();
		cnc.WriteCampaignNameInComp(campname);
		cnc.ClickOnProductLookUpIcon();
				
		cnp.SwitchToProductWindow(prod, prodname);
		
		cnp.SwitchToCreateNewCampaignWindow(campnm);
		
		cnc.ClickOnSaveButton();
		String text = cip.GetTextFromCampaigninfPage();
		System.out.println(text);
		
		if(text.contains(Campignname)) {
			System.out.println("Matching successfull");
		}
		else {
			System.out.println("Not Matching");
		}
		
		hp.ClickonLogOUTToApplication();
	}
}
