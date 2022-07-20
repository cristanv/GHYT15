package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
WebDriver driver;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement writeOrganizationNameComp;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement ClickOnSaveButton;
	
//	@FindBy(xpath = "//span[@class='dvHeaderText']")
//	private WebElement ClickOnCreateCampainimg;
//	
	
	
	
	//=======================================
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//========================================

	public WebElement getWriteOrganizationNameComp() {
		return writeOrganizationNameComp;
	}

	public WebElement getClickOnSaveButton() {
		return ClickOnSaveButton;
	}
	//=========================================

	public void WriteOrganizationNameComp(String OrganizationName) {
		writeOrganizationNameComp.sendKeys(OrganizationName);;
	}
	public void ClickOnSaveButton( ) {
		ClickOnSaveButton.click();
	}

}
