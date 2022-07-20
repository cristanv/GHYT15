package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
WebDriver driver;

	@FindBy(xpath   = "//span[@class='dvHeaderText']")
	private WebElement GetTextFromCampaigninfPage;
	
	//==================================================
	public CampaignInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//================================================

	
	public WebElement getGetTextFromCampaigninfPage() {
		return GetTextFromCampaigninfPage;
	}

	
	//===================================================
	
	
	public String GetTextFromCampaigninfPage() {
		String text = GetTextFromCampaigninfPage.getText();
		return text;
	}


	
	
	
	
	
	
}

