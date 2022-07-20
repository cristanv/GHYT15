package com.crm.GHYT15.GenericUtility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class listnerImplimentation extends BaseClass implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String res = result.getMethod().getMethodName();
		TakesScreenshot t=(TakesScreenshot) driver;
		String date = new Date().toString().replaceAll(":", "-");
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+res+date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
		
//		String testName = result.getMethod().getMethodName();
//		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.driver);
//		String date = new Date().toString().replaceAll(":", "-");
//	    File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
//	    try {
//	    	FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+date+".png"));	
//	    }catch(IOException e) {
//	    	e.printStackTrace();
//	    }
//	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
}
