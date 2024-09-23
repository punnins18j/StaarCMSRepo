package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * 
 * This class is used to store all the web elements present in Create New Third-party page
 */
public class NewThirdPartyPage {

	@FindBy(id="name")
	private WebElement thirdPartyNameTbx;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single flat']")
	private WebElement prospectOrCustomerSelBox;
	
	@FindBy(xpath="//li[text()='Customer']")
	private WebElement customerOption;
	
	@FindBy(xpath="//li[text()='Prospect']")
	private WebElement prospectOption;
	
	@FindBy(xpath="//li[text()='Not prospect, nor customer']")
	private WebElement notProspectOrCustomerOption;
	
	@FindBy(xpath="//li[text()='Prospect / Customer']")
	private WebElement prospectOrCustomerOption;
	
	@FindBy(id="customer_code")
	private WebElement customerCodeTbx;
		
	@FindBy(xpath="//input[@value='Create third party']")
	private WebElement createThirdPartyBtn;
	
	public NewThirdPartyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getThirdPartyNameTbx() {
		return thirdPartyNameTbx;
	}

	public WebElement getProspectOrCustomerSelBox() {
		return prospectOrCustomerSelBox;
	}

	public WebElement getCustomerOption() {
		return customerOption;
	}

	public WebElement getProspectOption() {
		return prospectOption;
	}

	public WebElement getNotProspectOrCustomerOption() {
		return notProspectOrCustomerOption;
	}

	public WebElement getProspectOrCustomerOption() {
		return prospectOrCustomerOption;
	}

	public WebElement getCreateThirdPartyBtn() {
		return createThirdPartyBtn;
	}
	
	public WebElement getCustomerCodeTbx() {
		return customerCodeTbx;
	}

	/**
	 * 
	 * @param tpName
	 * @param tpType
	 * @param tpCustomerCode
	 * 
	 * This method is used to create a Third party with mandatory fields
	 */
	public void createThirdPartyWithMandatoryFields(String tpName, String tpType,String tpCustomerCode)
	{
		thirdPartyNameTbx.sendKeys(tpName);
		prospectOrCustomerSelBox.click();
		
		switch(tpType)
		{
			case "Customer":
			{
				customerOption.click();
				break;
			}
			case "Prospect":
			{
				prospectOption.click();
				break;
			}
			case "Not prospect, nor customer":
			{
				notProspectOrCustomerOption.click();
				break;
			}
			case "Prospect / Customer":
			{
				prospectOrCustomerOption.click();
				break;
			}
		}
		createThirdPartyBtn.click();;
	}
}
