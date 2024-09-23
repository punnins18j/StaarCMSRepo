package com.pabb.staarcms.thirdpartytest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
 * This class is used to view created Third-party in the List
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)
public class VerifyThirdPartyInListTest  extends BaseClass {
	
	/**
	 * @throws Exception
	 * 
	 * This Method is used to view created Third-party in the List
	 */
	@Test(groups = "regressionTest")
	public void verifyThirdPartyTest() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ThirdPartyDetailsPage tdp = new ThirdPartyDetailsPage(driver);
		ListOfThirdPartiesPage lp = new ListOfThirdPartiesPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Third-parties page");

		/*click on Third-parties major tab */
		h.getThirdPartyTab().click();
		String eTitleTpMajorTab = eLib.getDataFromExcelFile("PageTitles", 1, 1);
		String aTitleTpMajorTab = driver.getTitle();
		Assert.assertEquals(aTitleTpMajorTab,eTitleTpMajorTab);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to New Third-party page and create Third-party");

		/*click on New Third Party link*/
		tp.getNewThirdPartyLink().click();
		String eTitleNewTpLink = eLib.getDataFromExcelFile("PageTitles", 2, 1);
		String aTitleNewTpLink = driver.getTitle();
		Assert.assertEquals(eTitleNewTpLink,aTitleNewTpLink);
		
		/*create third party with mandatory fields*/
		
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
		Assert.assertEquals(aTitleTpDetailsPage,eTitleTpDetailsPage);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to List of all Third-parties");

		/* click on List Link in the left navigation bar */
		tp.getListLink().click();
		
		String eTitleList = eLib.getDataFromExcelFile("PageTitles", 4, 1);
		String aTitleList = driver.getTitle();
		Assert.assertEquals(aTitleList,eTitleList);
		
		UtilityClassObject.getTest().log(Status.INFO, "Search Third-party in the list");

		/* search third party in the list*/
		lp.searchThirdParty(tpName);
		
		String aTpNameInList = lp.getTpNameInList().getText();
		Assert.assertEquals(tpName, aTpNameInList);
	}
}
