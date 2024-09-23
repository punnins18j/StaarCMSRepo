package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * 
 * This class is used to store all the web elements present in Third-party details page
 */
public class ThirdPartyDetailsPage {

	@FindBy(xpath="//div[@class='inline-block floatleft valignmiddle maxwidth750 marginbottomonly refid refidpadding']")
	private WebElement thirdNameName;
	
	@FindBy(xpath="//td[text()='Nature of Third party']/following-sibling::td/a")
	private WebElement natureOfThirdParty;
	
	@FindBy(xpath="//span[@class='clipboardCPValue']")
	private WebElement customerCode;
	
	@FindBy(xpath="//span[@class='badge  badge-status4 badge-status']")
	private WebElement status;
	
	@FindBy(xpath = "//a[text()='Modify']")
	private WebElement modifyBtn;
	
	@FindBy(id="select2-status-container")
	private WebElement statusSelBx;
	
	@FindBy(xpath="(//input[@class='select2-search__field'])[2]")
	private WebElement statusTxtBx;
	
	@FindBy(xpath="//span[text()='Closed']")
	private WebElement statusText;
	
	public ThirdPartyDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getThirdNameName() {
		return thirdNameName;
	}

	public WebElement getNatureOfThirdParty() {
		return natureOfThirdParty;
	}

	public WebElement getCustomerCode() {
		return customerCode;
	}

	public WebElement getStatus() {
		return status;
	}
	
	public WebElement getModifyBtn() {
		return modifyBtn;
	}

	public WebElement getStatusSelBx() {
		return statusSelBx;
	}

	public WebElement getStatusTxtBx() {
		return statusTxtBx;
	}

	public WebElement getStatusText() {
		return statusText;
	}
	
	
}
