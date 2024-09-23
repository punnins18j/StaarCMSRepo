package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfShipmentsPage {
	
	@FindBy(name="search_ref_exp")
	private WebElement refNo;
	
	@FindBy(xpath="//tr[@class='liste_titre']/following-sibling::tr//a[@class='classfortooltip']")
	private WebElement shipmentRefNoInList;
	
	@FindBy(xpath="//span[text()='Validated (products to ship or already shipped)']")
	private WebElement validateText;
	
	public ListOfShipmentsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRefNo() {
		return refNo;
	}

	public WebElement getShipmentRefNoInList() {
		return shipmentRefNoInList;
	}

	public WebElement getValidateText() {
		return validateText;
	}
	
	
}
