package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility {
	
WebDriver driver;

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement writeCampaignNameInComp;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement ClickOnProductLookUpIcon;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement ClickOnSaveButton;
	
	@FindBy(id = "search_txt")
	private WebElement WriteTheProductNameComp;
	
	@FindBy(xpath  = "//input[@name='search']")
	private WebElement ClickOnSearchButton;
	
	@FindBy(id  = "1")
	private WebElement ClickOnProductName;
	
	
	//================================================
	public CreateNewCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//=================================================

	public WebElement getWriteCampaignNameInComp() {
		return writeCampaignNameInComp;
	}

	public WebElement getClickOnProductLookUpIcon() {
		return ClickOnProductLookUpIcon;
	}
	public WebElement getClickOnSaveButton() {
		return ClickOnSaveButton;
	}
	
	//====================================================
	
	public void WriteCampaignNameInComp(String CampaignName) {
		writeCampaignNameInComp.sendKeys(CampaignName);
	}

	public void ClickOnProductLookUpIcon() {
		WebDriverUtility wu=new WebDriverUtility();
		WebElement target = ClickOnProductLookUpIcon;
		wu.waitForElement(driver, ClickOnProductLookUpIcon);
		ClickOnProductLookUpIcon.click();
	}
	
    public void switchToProductLookupPage(String ProductName,String PartialwindowTitleOfProduct) {
		swithToWindow(driver, PartialwindowTitleOfProduct);
		WriteTheProductNameComp.sendKeys(ProductName);
		ClickOnSearchButton.click();
		ClickOnProductName.click();	
	}
    
    public void switchToCurrentPageCampaig(String ProductName,String PartialwindowTitleOfCampaign) {
		swithToWindow(driver, PartialwindowTitleOfCampaign);	
	}
    
    @Override
    	public void swithToWindow(WebDriver driver, String partialWindowTitle) {
    		super.swithToWindow(driver, partialWindowTitle);
    	}
    
    public void ClickOnSaveButton() {
		ClickOnSaveButton.click();
	}
    
}
