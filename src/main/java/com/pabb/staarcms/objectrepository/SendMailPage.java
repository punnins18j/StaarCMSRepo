package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMailPage {

	@FindBy(id="sendto")
	private WebElement sendToTxtBx;
	
	@FindBy(id="sendmail")
	private WebElement sendMailBtn;
	
	@FindBy(xpath="//div[contains(text(),'Failed to send mail')]")
	private WebElement failedText;
	
	public SendMailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSendToTxtBx() {
		return sendToTxtBx;
	}

	public WebElement getSendMailBtn() {
		return sendMailBtn;
	}

	public WebElement getFailedText() {
		return failedText;
	}
	
	
}
