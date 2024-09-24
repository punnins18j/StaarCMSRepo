package com.pabb.staarcms.thirdpartytest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.objectrepository.ThirdPartyDetailsPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

/**
 *@author Poornima
 *
 *This class is used to create a Third Party with mandatory fields
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)

public class CreateThirdPartyAsCustomerSmokeTest extends BaseClass {

	/**
	 * 
	 * @throws Exception
	 * 
	 * This Methos is used to Create a Third-party with mandatory fields
	 */
	@Test(groups = { "smokeTest", "regressionTest" })
	public void createThirdPartyWithMandatoryFieldsTest() throws Exception
	{
		
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ThirdPartyDetailsPage tdp = new ThirdPartyDetailsPage(driver);
		
		/* create object of soft assert class*/
		SoftAssert sa = new SoftAssert();
		
		UtilityClassObject.getTest().log(Status.INFO, "User is able to open the browser and login to the application ");
		/*click on Third-parties major tab */
		h.getThirdPartyTab().click();
		
		/* Get page title from excel to validate with Assertion */
		String eTitleTpMajorTab = eLib.getDataFromExcelFile("PageTitles", 1, 1);
		String aTitleTpMajorTab = driver.getTitle();
		sa.assertEquals(aTitleTpMajorTab,eTitleTpMajorTab);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to New Third Party Page");

		/*click on New Third Party link and Navigate to Create Third party page*/
		tp.getNewThirdPartyLink().click();
		
		/* Get page title from excel to validate with Assertion */
		String eTitleNewTpLink = eLib.getDataFromExcelFile("PageTitles", 2, 1);
		String aTitleNewTpLink = driver.getTitle();
		sa.assertEquals(eTitleNewTpLink,aTitleNewTpLink);
		
		UtilityClassObject.getTest().log(Status.INFO, "Create Third-party as Customer  with mandatory fields");

		/*get Random number from java Utility */
		int random_number = jLib.getRandomNumber();
		
		/* get data from excel file to crate Third-party*/
		String tpName = eLib.getDataFromExcelFile("ThirdParty", 1, 0)+random_number;
		String tpType = eLib.getDataFromExcelFile("ThirdParty", 1, 1);
		String tpCustomerCode = eLib.getDataFromExcelFile("ThirdParty", 1, 2);
		
		/* create third party with mandatory fields*/
		ntp.createThirdPartyWithMandatoryFields(tpName,tpType,tpCustomerCode);			
				
		/* Get page title from excel file to validate with Assertion */
		String eTitleTpDetailsPage = tpName+eLib.getDataFromExcelFile("PageTitles", 3, 1);
		String aTitleTpDetailsPage = driver.getTitle();
		sa.assertEquals(aTitleTpDetailsPage,eTitleTpDetailsPage);
		
		UtilityClassObject.getTest().log(Status.INFO, "Third-party created successfully");
		sa.assertAll();
	}
}
