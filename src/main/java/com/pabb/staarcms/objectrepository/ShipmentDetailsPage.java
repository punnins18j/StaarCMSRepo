package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentDetailsPage {

	@FindBy(xpath="//div[@class='inline-block floatleft valignmiddle maxwidth750 marginbottomonly refid refidpadding']")
	private WebElement shipmentID;
	
	@FindBy(xpath="//a[text()='Create shipment']")
	private WebElement createShipmentBtn;
	
	
	public ShipmentDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getShipmentID() {
		return shipmentID;
	}

	public WebElement getCreateShipmentBtn() {
		return createShipmentBtn;
	}
	
	
	
}
