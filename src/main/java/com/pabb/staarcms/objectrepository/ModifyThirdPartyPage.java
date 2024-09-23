package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * This class is used to store all the web elements present in Modify Third-party page
 */
public class ModifyThirdPartyPage {


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
		
	@FindBy(name="save")
	private WebElement saveBtn;
	
	public ModifyThirdPartyPage(WebDriver driver)
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

	public WebElement getSaveBtn() {
		return saveBtn;
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
	 * This Method is used to modify Third-party
	 */
	public void modifyThirdParty(String tpName, String tpType,String tpCustomerCode)
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
		saveBtn.click();;
	}
}
