package com.pabb.staarcms.thirdpartytest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.ListOfThirdPartiesPage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.objectrepository.ThirdPartyDetailsPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

/**
 * @author Poornima 
 * 
 * This class is used to view the list of all Third-parties created
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)
public class ListOfThirdPartiesTest extends BaseClass {
	
	/**
	 * 
	 * @throws Exception
	 * 
	 * This Methos is used to view the list of all Third-parties created
	 */
	@Test(groups = { "smokeTest", "regressionTest" })
	public void listOfAllThirdPartiesSmokeTest() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		ListOfThirdPartiesPage lp = new ListOfThirdPartiesPage(driver);
		
		/* create object of soft assert class*/
		SoftAssert sa = new SoftAssert();
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Third-parties major tab");

		/*click on Third-parties major tab */
		h.getThirdPartyTab().click();
		
		/* Get page title from excel and validate with assertion */
		String eTitleTpMajorTab = eLib.getDataFromExcelFile("PageTitles", 1, 1);
		String aTitleTpMajorTab = driver.getTitle();
		sa.assertEquals(aTitleTpMajorTab,eTitleTpMajorTab);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to List of Third-parties");

		/* click on List Link in the left navigation bar */
		tp.getListLink().click();
		
		/* Get page title from excel and validate with assertion */
		String eTitleList = eLib.getDataFromExcelFile("PageTitles", 4, 1);
		String aTitleList = driver.getTitle();
		sa.assertEquals(aTitleList,eTitleList);	
		sa.assertAll();
	}
}
