package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement ClickOnCreateCampainimg;

	

	

	public WebElement getClickOnCreateCampainLookUp() {
		return ClickOnCreateCampainimg;
	}

	//=========================================
	public CampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//=========================================
	
	
	public void ClickOnCreateCampainimage() {
		ClickOnCreateCampainimg.click();
	}
	
	

}
