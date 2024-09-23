package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * 
 * This class is used to store all the web elements present in Third-parties page
 */
public class ThirdPartiesPage {

	@FindBy(linkText = "New Third Party")
	private WebElement newThirdPartyLink;
	
	@FindBy(linkText = "List of Customers")
	private WebElement listOfCustomersLink;
	
	@FindBy(linkText = "List")
	private WebElement listLink;
	
	public ThirdPartiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewThirdPartyLink() {
		return newThirdPartyLink;
	}

	public WebElement getListOfCustomersLink() {
		return listOfCustomersLink;
	}

	public WebElement getListLink() {
		return listLink;
	}
	
}
