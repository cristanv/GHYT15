package com.crm.GHYT15.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.GHYT15.POMrepository.CreateContactPage;
import com.crm.GHYT15.POMrepository.HomePage;
import com.crm.GHYT15.POMrepository.LoginPage;

public class BaseClass {
//	static {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//	}
	
	public static WebDriver driver;
	
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	public FileUtility fu=new FileUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void confiConnectDB() {
		System.out.println("==========connect to DB=========");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void OpenBrowser() throws Throwable {
		Reporter.log("open browser",true);
		//String browser = System.getProperty("browser");
		String browser = fu.getPropertyKeyValue("Browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		wu.waitForElementInDOM(driver);		
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void CloseBrowser() {
		Reporter.log("close browser",true);
		driver.quit();
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void loginToApplicationTest() throws Throwable {
		Reporter.log("login To Application",true);
		String ul = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pw = fu.getPropertyKeyValue("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApplication(ul, un, pw);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logoutToApplicatioTest() {
		Reporter.log("logout",true);
		HomePage hp=new HomePage(driver);
		hp.ClickonLogOUTToApplication();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void confiCloseDB() {
		System.out.println("==========close DB==========");
	}
}
