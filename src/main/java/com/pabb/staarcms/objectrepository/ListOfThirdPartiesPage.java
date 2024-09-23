package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * This class is used to store all the web elements present in Third-party List page
 */
public class ListOfThirdPartiesPage {

	@FindBy(xpath="//div[@class='titre inline-block']")
	private WebElement listType;
	
	@FindBy(name="search_nom")
	private WebElement tpNameTbx;
	
	@FindBy(xpath="//tr[@class='liste_titre']/following-sibling::tr//a[@class='classfortooltip refurl valignmiddle']")
	private WebElement tpNameInList;
	
	public ListOfThirdPartiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getListType() {
		return listType;
	}
	
	public WebElement getTpNameTbx() {
		return tpNameTbx;
	}
	
	public WebElement getTpNameInList() {
		return tpNameInList;
	}
	
	/**
	 * @param tpName
	 * This Method is used to search a Third-party with Third-party name
	 */
	public void searchThirdParty(String tpName)
	{
		tpNameTbx.sendKeys(tpName+Keys.ENTER);
	}
}
