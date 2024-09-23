package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima
 * 
 * This class is used to store all the web elements in the Order details Page 
 */
public class OrderDetailsPage {
	
	@FindBy(xpath="//a[text()='Validate']")
	private WebElement validateBtn;
	
	@FindBy(xpath="//span[text()='Draft (needs to be validated)']")
	private WebElement draftText;
	
	@FindBy(xpath="//span[text()='Validate order']")
	private WebElement validateConfirmationBox;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesBtn;
	
	@FindBy(xpath="//span[text()='Validated']")
	private WebElement validatedText;
	
	@FindBy(xpath="//a[contains(text(),'Create')]")
	private WebElement createOrderBtn;
	
	@FindBy(xpath="//a[text()='Create shipment']")
	private WebElement createShipmentOpt;
	
	public OrderDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}

	public WebElement getDraftText() {
		return draftText;
	}

	public WebElement getValidateConfirmationBox() {
		return validateConfirmationBox;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getValidatedText() {
		return validatedText;
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public WebElement getCreateShipmentOpt() {
		return createShipmentOpt;
	}
	
	
	
}
