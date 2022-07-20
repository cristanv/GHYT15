package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.ExcelUtility;
import com.crm.GHYT15.GenericUtility.WebDriverUtility;


public class CreateContactPage extends WebDriverUtility {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement clickOnCreatecontactIMG;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement WriteLastNameComp;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement clickOnOrganizationLookupIcon;
	
	@FindBy(id = "search_txt")
	private WebElement writeOnSearchComponent;
	
	@FindBy(id = "//input[@name='search']")
	private WebElement clickOnSearchButton;
	
	@FindBy(id = "1")
	private WebElement clickOnOrganizationName;
	
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement clickOnSaveButton;
	

	//====================================================
	
	
	
	
	public WebElement getClickOnCreatecontactIMG() {
		return clickOnCreatecontactIMG;
	}

	public WebElement getWriteLastNameComp() {
		return WriteLastNameComp;
	}

	public WebElement getWriteOnSearchComponent() {
		return writeOnSearchComponent;
	}

	public WebElement getClickOnSearchButton() {
		return clickOnSearchButton;
	}

	public WebElement getClickOnOrganizationName() {
		return clickOnOrganizationName;
	}

	public WebElement getLastNameComp() {
		return WriteLastNameComp;
	}

	public WebElement getClickOnOrganizationLookupIcon() {
		return clickOnOrganizationLookupIcon;
	}

	public WebElement getClickOnSaveButton() {
		return clickOnSaveButton;
	}
	
	//===============================================
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//===============================================

	public void ClickOnCreatecontactIMG() {
		clickOnCreatecontactIMG.click();
	}

	public void LastNameComp(String lastname) {
		WriteLastNameComp.sendKeys(lastname);
	}

	public void ClickOnOrganizationLookupIcon() {
		clickOnOrganizationLookupIcon.click();
	}
	
	public void ClickOnsaveButton() {
		clickOnSaveButton.click();
	}

	
	public void switchToOrganizationLookupPage(String organizationname,String PartialwindowTitleOfOrganization) {
		
		swithToWindow(driver, PartialwindowTitleOfOrganization);
		writeOnSearchComponent.sendKeys(organizationname);
		clickOnSearchButton.click();
		clickOnOrganizationName.click();
		
	}
	
    public void switchTocurrentPage(String organizationname,String PartialwindowTitleOfCurrentPage) {
		
		swithToWindow(driver, PartialwindowTitleOfCurrentPage);
		clickOnSaveButton.click();
    }	
}
