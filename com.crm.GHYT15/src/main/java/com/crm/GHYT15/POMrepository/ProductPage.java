package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement ClickOnCreateNewProductImage;

	//==================================================
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//==================================================
	public WebElement getClickOnCreateNewProductImage() {
		return ClickOnCreateNewProductImage;
	}
	
	//======================================================

	public void ClickOnCreateNewProductImage() {
		ClickOnCreateNewProductImage.click();
	}
	
	
	
	

}
