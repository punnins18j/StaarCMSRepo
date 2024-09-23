package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesAreaPage {
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement listLink;
	
	public ServicesAreaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getListLink() {
		return listLink;
	}
	
	
}
