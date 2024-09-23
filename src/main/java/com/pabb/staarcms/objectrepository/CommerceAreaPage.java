package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * This class is used to store all the web elements present in Commerce area page
 */
public class CommerceAreaPage {
	
	@FindBy(linkText = "New proposal")
	private WebElement newProposalLink;
	
	@FindBy(xpath = "//div[@class='menu_contenu menu_contenu_comm_propal_list']/a")
	private WebElement propListLink;
	
	@FindBy(xpath="//div[@class='menu_contenu menu_contenu_comm_propal_stats_index']/a")
	private WebElement propStatisticsLink;
	
	@FindBy(linkText = "New order")
	private WebElement newOrderLink;
	
	@FindBy(xpath = "//div[@class='menu_contenu menu_contenu_commande_list']/a")
	private WebElement orderListLink;
	
	@FindBy(xpath="//div[@class='menu_contenu menu_contenu_commande_stats_index']/a")
	private WebElement orderStatisticsLink;
	
	public CommerceAreaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewProposalLink() {
		return newProposalLink;
	}

	public WebElement getPropListLink() {
		return propListLink;
	}

	public WebElement getPropStatisticsLink() {
		return propStatisticsLink;
	}

	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebElement getOrderListLink() {
		return orderListLink;
	}

	public WebElement getOrderStatisticsLink() {
		return orderStatisticsLink;
	}
}
