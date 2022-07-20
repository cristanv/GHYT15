package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class ContactInformationPage extends WebDriverUtility{
	
	
WebDriver  driver;
	
	
	@FindBy(xpath = "(//input[@class='crmbutton small delete'])[1]")
	private WebElement clickOnDeleteButton;
	
	@FindBy(xpath = "(//span[contains(text(),'Cristanv')])[1]")
	private WebElement GetTheTextinContactInformation;
	
	

	//===================================================
	
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//======================================================
	public WebElement getClickOnDeleteButton() {
		return clickOnDeleteButton;
	}

	public WebElement getGetTheTextinContactInformation() {
		return GetTheTextinContactInformation;
	}

	//=======================================================================

	public void ClickOnDeleteButton() {
		clickOnDeleteButton.click();
	}

	public String GetTheTextinContactInformation() {
		String text = GetTheTextinContactInformation.getText();
		return text;
	}
	
}
