package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pabb.staarcms.genericutility.BaseClass;

/**
 * @author Poornima 
 * This class is used to store all the web elements present in Login page
 */
public class LoginPage {

	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(id="password")
	private WebElement pwtbx;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement lgBtn;

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * 
	 * This Method is used to Login to the application
	 */
	public void setLogin(String username,String password)
	{
		untbx.sendKeys(username);
		pwtbx.sendKeys(password);
		lgBtn.click();
		
	}
}
