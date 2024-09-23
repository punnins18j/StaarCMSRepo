package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateShipmentPage {
	@FindBy(id="select2-shipping_method_id-container")
	private WebElement deliveryMethodSelBx;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement deliveryMethodOpt;
	
	@FindBy(id="qtyl0")
	private WebElement qtyTxtBx; 
	
	@FindBy(xpath="//input[@name='add']")
	private WebElement createBtn;
	
	public CreateShipmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeliveryMethodSelBx() {
		return deliveryMethodSelBx;
	}

	public WebElement getDeliveryMethodOpt() {
		return deliveryMethodOpt;
	}
	
	public WebElement getQtyTxtBx() {
		return qtyTxtBx;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	
	
}
