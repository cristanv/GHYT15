package com.crm.GHYT15.POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GHYT15.GenericUtility.WebDriverUtility;

public class contactPage extends WebDriverUtility{
WebDriver driver;
	
	@FindBy(xpath  = "//input[@name='search_text']")
	private WebElement writesearchComp;
	
	@FindBy(xpath  = "//input[@name='submit']")
	private WebElement clickOnSearchNOwButton;
	
	@FindBy(xpath  = "(//select[@id='bas_searchfield'])[1]")
	private WebElement clickonListBoxDropdown;
	
	@FindBy(xpath  = "//span[@class='genHeaderSmall']")
	private WebElement GetTextToConfirm;
	
	//===================================================
	
	public contactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//==============================================
	
	public WebElement getWritesearchComp() {
		return writesearchComp;
	}

	public WebElement getClickOnSearchNOwButton() {
		return clickOnSearchNOwButton;
	}

	public WebElement getClickonListBoxDropdown() {
		return clickonListBoxDropdown;
	}
	
	public WebElement getGetTextToConfirm() {
		return GetTextToConfirm;
	}

     //=================================================


	public void WritesearchComp(String lastname) {
		writesearchComp.sendKeys(lastname);
	}

	public void ClickOnSearchNOwButton() {
		clickOnSearchNOwButton.click();
	}

	public void ClickonListBoxDropdown() {
		//clickonListBoxDropdown.click();
		select(clickonListBoxDropdown, 2);
	}
	
	public String StriGetTextToConfirm() {
		String text = GetTextToConfirm.getText();
		return text;
	}	
}
