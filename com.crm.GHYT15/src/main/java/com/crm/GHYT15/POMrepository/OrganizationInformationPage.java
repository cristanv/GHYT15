package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
WebDriver driver;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement GetTheTextToVerify;
	
	
	
	//=======================================
		public OrganizationInformationPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//========================================



		public WebElement getGetTheTextToVerify() {
			return GetTheTextToVerify;
		}

//=================================

		public String GetTheTextToVerify() {
			String text = GetTheTextToVerify.getText();
			return text;
		}
		
		
		
		

}
