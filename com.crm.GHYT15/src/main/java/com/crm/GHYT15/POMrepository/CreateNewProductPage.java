package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility{
	WebDriver driver;

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement writeProductNameInComp;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement ClickOnSaveButton;

	@FindBy(xpath  = "//input[@id='search_txt']")
	private WebElement writeProductNameInChildProductPage;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement ClickOnSEarchButton;
	
	@FindBy(id = "1")
	private WebElement ClickOnProductNameSelected;
	
	//===============================================
	public WebElement getWriteProductNameInComp() {
		return writeProductNameInComp;
	}

	public WebElement getWriteProductNameInChildProductPage() {
		return writeProductNameInChildProductPage;
	}

	public WebElement getClickOnSEarchButton() {
		return ClickOnSEarchButton;
	}
	
	public WebElement getClickOnProductNameSelected() {
		return ClickOnProductNameSelected;
	}

	public WebElement getClickOnSaveButton() {
		return ClickOnSaveButton;
	}

	//========================================
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//========================================
	
	public void writeProductNameInComp(String ProductName) {
		writeProductNameInComp.sendKeys(ProductName);
	}
	
	public void ClickOnSaveButton() {
		ClickOnSaveButton.click();
	}
	
	
	
	public void SwitchToProductWindow(String Title,String ProductName ) throws InterruptedException {
		swithToWindow(driver, Title);
		Thread.sleep(4000);
		writeProductNameInChildProductPage.sendKeys(ProductName);
		ClickOnSEarchButton.click();
		ClickOnProductNameSelected.click();
	}
	
	public void SwitchToCreateNewCampaignWindow(String PartialWindowTitle) {
		swithToWindow(driver, PartialWindowTitle);
	}
	
	
	
	
	
	
	

}
