package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima
 * 
 * This class is used to store all the web Elements in the New Order page
 */
public class NewOrderPage {
	
	@FindBy(xpath="//input[@name='save']")
	private WebElement createDraftBtn;;
	
	public NewOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateDraftBtn() {
		return createDraftBtn;
	}
	
	
}
