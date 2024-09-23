package com.pabb.staarcms.commercetest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.CommerceAreaPage;
import com.pabb.staarcms.objectrepository.CommercialProposalstListPage;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.ListOfThirdPartiesPage;
import com.pabb.staarcms.objectrepository.NewCommercialProposalPage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.ProposalDetails;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.objectrepository.ThirdPartyDetailsPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

/**
 * @author Poornima
 * 
 * This class is used to verify the List of proposals 
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)

public class VerifyListOfProposalsTest extends BaseClass {
	
	/**
	 * @throws Exception
	 * 
	 * This Method is used to verify the list of proposals in the draft stage
	 */
	@Test(groups = "regressionTest")
	public void verifyListOfProposalsInTheDraftStageTest() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		NewCommercialProposalPage ncp = new NewCommercialProposalPage(driver);
		CommercialProposalstListPage clp = new CommercialProposalstListPage(driver);
		ProposalDetails pd = new ProposalDetails(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Third-parties area and create the Third party");

		/*click on Third-parties major tab */
		h.getThirdPartyTab().click();
		String eTitleTpMajorTab = eLib.getDataFromExcelFile("PageTitles", 1, 1);
		String aTitleTpMajorTab = driver.getTitle();
		Assert.assertEquals(aTitleTpMajorTab,eTitleTpMajorTab);
		
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
		
		String eTitleTpDetailsPage = tpName+eLib.getDataFromExcelFile("PageTitles", 3, 1);
		String aTitleTpDetailsPage = driver.getTitle();
		Assert.assertEquals(aTitleTpDetailsPage,eTitleTpDetailsPage);
		
		UtilityClassObject.getTest().log(Status.INFO, "Third-party created successfully");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Commerce area and create the proposal");

		/* Click on Commerce major tab */
		h.getCommerceTab().click();
		
		/* Click on New proposal link */
		cap.getNewProposalLink().click();
		
		/* create new proposal*/
		ncp.createNewProposal(tpName);
		
		UtilityClassObject.getTest().log(Status.INFO, "Proposal created successfully");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Drafts list and search for Proposal");

		/*  reference ID */
		String refID = pd.getRefID().getText();
		
		refID = refID.substring(0, refID.indexOf(')')+1);
		
		/* click on Drafts link in left navigation bar*/
		clp.getDraftsLink().click();
		
		/* enter the reference id in the search box*/
		clp.searchProposal(refID);
		
		/* get the reference ID*/
		String aRefID = clp.getRefID().getText();
		Assert.assertEquals(aRefID, refID);
		
		UtilityClassObject.getTest().log(Status.INFO, "Proposal appeared in the list");
	}
}
