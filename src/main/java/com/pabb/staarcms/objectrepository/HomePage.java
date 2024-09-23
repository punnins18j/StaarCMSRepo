package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima
 * This class is used to store all the web Elements present in HomePage
 */
public class HomePage {
	
	@FindBy(xpath="//span[@class='hidden-xs maxwidth200 atoploginusername hideonsmartphone paddingleft']")
	private WebElement accName;
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//span[@class='fas fa-home fa-fw']")
	private WebElement homeTab;
	
	@FindBy(xpath="//span[@class='fas fa-building fa-fw pictofixedwidth']")
	private WebElement thirdPartyTab;
	
	@FindBy(xpath="//span[@class='fas fa-cube fa-fw pictofixedwidth']")
	private WebElement servicesTab;
	
	@FindBy(xpath="//span[@class='fas fa-suitcase  em092 infobox-contrat fa-fw pictofixedwidth']")
	private WebElement commerceTab;
	
	@FindBy(xpath="//span[text()='Tickets']")
	private WebElement ticketsTab;
	
	@FindBy(xpath="//span[@class='fas fa-tools fa-fw pictofixedwidth']")
	private WebElement toolsTab;
	
	@FindBy(xpath="//a[@title='My Dashboard']")
	private WebElement dashboardTab;
	
	@FindBy(xpath="//a[@title='Setup']")
	private WebElement setupTab;
	
	@FindBy(xpath="//a[@title='Admin Tools']")
	private WebElement adminToolsTab;
	
	@FindBy(xpath="//a[@title='Users & Groups']")
	private WebElement usersAndGroupsTab;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccName() {
		return accName;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getThirdPartyTab() {
		return thirdPartyTab;
	}

	public WebElement getServicesTab() {
		return servicesTab;
	}

	public WebElement getCommerceTab() {
		return commerceTab;
	}

	public WebElement getTicketsTab() {
		return ticketsTab;
	}

	public WebElement getToolsTab() {
		return toolsTab;
	}

	public WebElement getDashboardTab() {
		return dashboardTab;
	}

	public WebElement getSetupTab() {
		return setupTab;
	}

	public WebElement getAdminToolsTab() {
		return adminToolsTab;
	}

	public WebElement getUsersAndGroupsTab() {
		return usersAndGroupsTab;
	}
	/**
	 * This method is used to Logout from the application
	 */
	public void setLogOut()
	{
		accName.click();
		logoutBtn.click();
	}
	
}
