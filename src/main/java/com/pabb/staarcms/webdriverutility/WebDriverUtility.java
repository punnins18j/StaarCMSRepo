package com.pabb.staarcms.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Poornima 
 * 
 * This class is used to store all the Generic Methods related to WebDriver actions
 */
public class WebDriverUtility {

	/**
	 * This is a generic method to implement Implicit wait webdriver action
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This is a generic method to implement maximize browser action
	 * @param driver
	 * 
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param driver
	 * @param browser
	 * @return
	 * 
	 * This Method is used to Get the Browser
	 */
	public WebDriver getBrowser(WebDriver driver, String browser) {
		browser = browser.toLowerCase();

		switch (browser) {
			case "chrome": {
				driver = new ChromeDriver();
				break;
			}
			case "firefox": {
				driver = new FirefoxDriver();
				break;
			}
			case "edge": {
				driver = new EdgeDriver();
				break;
			}
			case "safari": {
				driver = new SafariDriver();
				break;
			}
			default: {
				driver = new ChromeDriver();
			}
		}

		return driver;
	}
	
	/**
	 * 
	 * @param driver
	 * @param name
	 * @throws IOException
	 * 
	 * This Method is used to take the screenshot 
	 */
	public void getScreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/" + name + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	/**
	 * 
	 * @param driver
	 * @param url
	 * 
	 * This Method is used to enter the url in the browser
	 */
	public void get(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * 
	 * This Method is used perform Select By index action on a select box
	 */
	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * 
	 * This Method is used perform Select By Value action on a select box
	 */
	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * 
	 * This Method is used perform Select By Visible text action on a select box
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * 
	 * This method is used to deselect by index
	 */
	public void deSelectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByIndex(index);
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * 
	 * This Method is used to deselect by value
	 */
	public void deSelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * 
	 * Thid Method is used to deselect all options 
	 */
	public void deSelectAll(WebElement element, String text) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByVisibleText(text);
	}
	/**
	 * 
	 * @param element
	 * @return
	 * 
	 * This Method is used to get All options of a select box
	 */
	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allOptions = s.getOptions();
		return allOptions;
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * 
	 * This Method is used to move a mouse pointer to specified Web element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	/**
	 * 
	 * @param driver
	 * 
	 * This method is used to handle Alert popup
	 */
	public void handleAlertPopup(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
}
