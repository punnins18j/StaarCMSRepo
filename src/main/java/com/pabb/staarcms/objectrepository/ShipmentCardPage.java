package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentCardPage {
	@FindBy(xpath="//a[text()='Validate']")
	private WebElement validateBtn;
	
	@FindBy(xpath="//div[@class='inline-block floatleft valignmiddle maxwidth750 marginbottomonly refid refidpadding']")
	private WebElement shipmentNo;
	
	@FindBy(xpath="//span[text()='Draft']")
	private WebElement draftStatus;
	
	@FindBy(xpath="//span[text()='Confirm shipment']")
	private WebElement confirmationBoxText;
	
	@FindBy(xpath="//span[text()='Validated (products to ship or already shipped)']")
	private WebElement validatedText;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesBtn;
	
	@FindBy(xpath="//td[text()='Shipping method']/following-sibling::td/a/span[@class='fas fa-pencil-alt']")
	private WebElement editShippingMethodIcon;
	
	@FindBy(id="select2-shipping_method_id-container")
	private WebElement shipmentMethodSelBx;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement shipmentMethodOptTxtBx;
	
	@FindBy(xpath="//input[@value='Modify']")
	private WebElement modifyBtn;
	
	@FindBy(xpath="//a[text()='Send email']")
	private WebElement sendMailBtn;
	
	
	
	public ShipmentCardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}

	public WebElement getShipmentNo() {
		return shipmentNo;
	}

	public WebElement getDraftStatus() {
		return draftStatus;
	}

	public WebElement getConfirmationBoxText() {
		return confirmationBoxText;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getValidatedText() {
		return validatedText;
	}

	public WebElement getEditShippingMethodIcon() {
		return editShippingMethodIcon;
	}

	public WebElement getShipmentMethodSelBx() {
		return shipmentMethodSelBx;
	}

	public WebElement getShipmentMethodOptTxtBx() {
		return shipmentMethodOptTxtBx;
	}

	public WebElement getModifyBtn() {
		return modifyBtn;
	}

	public WebElement getSendMailBtn() {
		return sendMailBtn;
	}
	
}
