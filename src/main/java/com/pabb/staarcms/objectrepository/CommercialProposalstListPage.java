package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * This class is used to store all the web elements present Commercial List page
 */
public class CommercialProposalstListPage {
	
	@FindBy(linkText = "Drafts")
	private WebElement draftsLink;
	
	@FindBy(name="search_ref")
	private WebElement refTxtBx;
	
	@FindBy(name="search_societe")
	private WebElement thirdPartyTxtBx;
	
	@FindBy(xpath="(//tr[@class='liste_titre']/following-sibling::tr//a)[1]")
	private WebElement refID;
	
	public CommercialProposalstListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getDraftsLink() {
		return draftsLink;
	}

	public WebElement getRefTxtBx() {
		return refTxtBx;
	}

	public WebElement getThirdPartyTxtBx() {
		return thirdPartyTxtBx;
	}
	
	public WebElement getRefID() {
		return refID;
	}
	
	
	/**
	 * 
	 * @param refID
	 * This Method is used to search a Proposal with the reference ID
	 */
	public void searchProposal(String refID)
	{
		refTxtBx.sendKeys(refID+Keys.ENTER);
	}
	
	
}
