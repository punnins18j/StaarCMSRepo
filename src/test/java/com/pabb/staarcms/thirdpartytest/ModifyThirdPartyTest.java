package com.pabb.staarcms.thirdpartytest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.ListOfThirdPartiesPage;
import com.pabb.staarcms.objectrepository.ModifyThirdPartyPage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.objectrepository.ThirdPartyDetailsPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

/**
 *@author Poornima
 *
 *This class is used to modify a Third Party 
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)
public class ModifyThirdPartyTest extends BaseClass {
	
	/**
	 * @throws Exception
	 * 
	 * This Method is used to modify Third-party
	 */
	@Test(groups = "regressionTest")
	public void modifyThirdPartyTest() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ThirdPartyDetailsPage tdp = new ThirdPartyDetailsPage(driver);
		ListOfThirdPartiesPage lp = new ListOfThirdPartiesPage(driver);
		ModifyThirdPartyPage mtp = new ModifyThirdPartyPage(driver);
		
		/* create object of soft assert class*/
		SoftAssert sa = new SoftAssert();
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		/*click on Third-parties major tab */
		h.getThirdPartyTab().click();
		String eTitleTpMajorTab = eLib.getDataFromExcelFile("PageTitles", 1, 1);
		String aTitleTpMajorTab = driver.getTitle();
		sa.assertEquals(aTitleTpMajorTab,eTitleTpMajorTab);
		
		
		/*click on New Third Party link*/
		tp.getNewThirdPartyLink().click();
		String eTitleNewTpLink = eLib.getDataFromExcelFile("PageTitles", 2, 1);
		String aTitleNewTpLink = driver.getTitle();
		sa.assertEquals(eTitleNewTpLink,aTitleNewTpLink);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to  New Third-party page ");

		/*get Random number */
		int random_number = jLib.getRandomNumber();
		
		/* get data from excel file*/
		
		String tpName = eLib.getDataFromExcelFile("ThirdParty", 1, 0)+random_number;
		String tpType = eLib.getDataFromExcelFile("ThirdParty", 1, 1);
		String tpCustomerCode = eLib.getDataFromExcelFile("ThirdParty", 1, 2);
		
		/* create third party with mandatory fields*/
		ntp.createThirdPartyWithMandatoryFields(tpName,tpType,tpCustomerCode);			
		
		UtilityClassObject.getTest().log(Status.INFO, "Third-party created successfully");
		
		String eTitleTpDetailsPage = tpName+eLib.getDataFromExcelFile("PageTitles", 3, 1);
		String aTitleTpDetailsPage = driver.getTitle();
		sa.assertEquals(aTitleTpDetailsPage,eTitleTpDetailsPage);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to List of all Third-parties page");

		/* click on List Link in the left navigation bar */
		tp.getListLink().click();
		
		/*Get the page title of List page from excel and Assert*/
		String eTitleList = eLib.getDataFromExcelFile("PageTitles", 4, 1);
		String aTitleList = driver.getTitle();
		sa.assertEquals(aTitleList,eTitleList);
		
		UtilityClassObject.getTest().log(Status.INFO, "Enter Third-party name in filters and search Third-party");

		/* search third party in the list*/
		lp.searchThirdParty(tpName);
		
		String aTpNameInList = lp.getTpNameInList().getText();
		sa.assertEquals(tpName, aTpNameInList);
		
		/* click on Third-party Name from the list */
		lp.getTpNameInList().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Modify Third-party page");

		/* Click on Modify Button in Third-party details page */
		tdp.getModifyBtn().click();
		
		/*Get the page title of Third-party Modify page from excel and Assert*/
		String eTitleModify = tpName+eLib.getDataFromExcelFile("PageTitles", 3, 1);
		String aTitleModify = driver.getTitle();
		sa.assertEquals(aTitleModify,eTitleModify);
		
		/* Change the status to Closed and Save */
		String statusModified = eLib.getDataFromExcelFile("ThirdParty", 1, 4);
		tdp.getStatusSelBx().click();
		tdp.getStatusTxtBx().sendKeys(statusModified+Keys.ENTER);
		
		/* Modify the details needed */
		mtp.getSaveBtn();
		
		sa.assertTrue(tdp.getStatusText().isDisplayed());
		sa.assertAll();
	}
}
