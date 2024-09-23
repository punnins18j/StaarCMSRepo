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

	public void getScreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/" + name + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	public void get(WebDriver driver, String url)
	{
		driver.get(url);
	}

	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void deSelectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByIndex(index);
	}

	public void deSelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByValue(value);
	}

	public void deSelectAll(WebElement element, String text) {
		Select s = new Select(element);
		if (s.isMultiple())
			s.deselectByVisibleText(text);
	}

	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allOptions = s.getOptions();
		return allOptions;
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void handleAlertPopup(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
}
