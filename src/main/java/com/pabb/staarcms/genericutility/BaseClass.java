package com.pabb.staarcms.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.pabb.staarcms.fileutility.*;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.LoginPage;
import com.pabb.staarcms.webdriverutility.*;

/**
 * @author Poornima
 * 
 *         This class is used to store all the Configuration methods in the
 *         Framework
 */
public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	/* create objects for Utility files */
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuite() {
		Reporter.log("=== Connect to DB and Report Config ===", true);
	}

	/**
	 * This Configuration Method is used to launch Browser in the Framework
	 * 
	 * @throws Exception
	 */
	// @Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void beforeClass(/* String browser */) throws Exception {
		
		Reporter.log("== Open Browser ==", true);
		String browser = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		String url = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));

		driver = wLib.getBrowser(driver, browser);
		sdriver = driver;

		UtilityClassObject.setSdriver(sdriver);

		wLib.maximize(driver);
		wLib.waitForPageToLoad(driver);

		wLib.get(driver, url);
	}

	/**
	 * This Configuration Method is used for Login to the application
	 * 
	 * @throws Exception
	 */
	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void beforeMethod() throws Exception {
		Reporter.log("= login =", true);

		String username = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String password = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));

		LoginPage l = new LoginPage(driver);
		l.setLogin(username, password);
	}

	/**
	 * This Congiguration Method is used to Logout from the application
	 */

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void afterMethod() {
		Reporter.log("= logout =", true);

		/* create pom class objects */
		HomePage h = new HomePage(driver);

		h.setLogOut();
	}

	/**
	 * This Configuration method is used to Close the Browser in the Framework
	 */
	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void afterClass() {
		Reporter.log("=== Close Browser ===", true);

		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		Reporter.log("=== Close DB Connection and Report BackUp ===", true);
	}
}
