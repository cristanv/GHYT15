package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement ClickOnCreateOrganizationImage;
	
	//=====================================================
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//=====================================================

	public WebElement getClickOnCreateOrganizationImage() {
		return ClickOnCreateOrganizationImage;
	}
	//================================================

	public void ClickOnCreateOrganizationImage() {
		ClickOnCreateOrganizationImage.click();
	}
	
	
}
