package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * This class is used to store all the web elements present in Create Commercial Proposal page
 */
public class NewCommercialProposalPage {
	
	@FindBy(xpath="//span[@id='select2-socid-container']")
	private WebElement thirdPartySelBox;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement thirdPartyName;
	
	@FindBy(name="save")
	private WebElement createDraftBtn;
	
	public NewCommercialProposalPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getThirdPartySelBox() {
		return thirdPartySelBox;
	}
	
	public WebElement getThirdPartyName() {
		return thirdPartyName;
	}
	
	public WebElement getCreateDraftBtn() {
		return createDraftBtn;
	}
	
	/**
	 * 
	 * @param tpName
	 * 
	 * This Method is used to Create a Proposal
	 */
	public void createNewProposal(String tpName)
	{
		thirdPartySelBox.click();
		thirdPartyName.sendKeys(tpName+Keys.ENTER);
		createDraftBtn.click();
	}
}
