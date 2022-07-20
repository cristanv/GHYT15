package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	
	WebDriver driver;
	
	@FindBy(linkText = "Contacts")
	private WebElement clickcontactModule;
	
	@FindBy(linkText = "Organizations")
	private WebElement clickOrganizationModule;
	
	@FindBy(linkText = "Campaigns")
	private WebElement ClickCampaignModule;
	
	@FindBy(linkText = "Opportunities")
	private WebElement clickOpportunityModule;
	
	@FindBy(linkText = "Sign Out")
	private WebElement Logoutlink;
	
	@FindBy(xpath = "(//td[@class='small'])[2]")
	private WebElement morelink;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement logoutClick;
	
	@FindBy(xpath = "//a[.='More']")
	private WebElement ClickUsingmoveToCampaign;
	
	@FindBy(linkText  = "Products")
	private WebElement ClickOnProductModule;
	
	
	//===================================================
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//===================================================
	
	
	

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getClickOnProductModule() {
		return ClickOnProductModule;
	}

	public WebElement getLogoutClick() {
		return logoutClick;
	}

	public WebElement getContactModule() {
		return clickcontactModule;
	}

	public WebElement getOrganizationModule() {
		return clickOrganizationModule;
	}

	public WebElement getCampaignModule() {
		return ClickCampaignModule;
	}

	public WebElement getOpportunityModule() {
		return clickOpportunityModule;
	}

	public WebElement getLogoutlink() {
		return Logoutlink;
	}
	
	
	
	
	//=========================================
	
	
	
	public void ClickonLogOUTToApplication() {	
	  WebDriverUtility wu=new WebDriverUtility();
	  wu.mouseOverOnElement(driver, morelink);
	  logoutClick.click(); 	
	}

	
	public void clickcontactModule() {
		clickcontactModule.click();
	}

	public void clickOrganizationModule() {
		clickOrganizationModule.click();
	}

	public void ClickOnCampaignModule() {
		mouseOverOnElement(driver, ClickUsingmoveToCampaign);
		ClickCampaignModule.click();
	}

	public void clickOpportunityModule() {
		clickOpportunityModule.click();
	}
	
	public void ClickOnProductModule() {
		ClickOnProductModule.click();
	}
		
}
