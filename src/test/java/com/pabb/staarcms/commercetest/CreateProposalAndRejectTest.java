package com.pabb.staarcms.commercetest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.CommerceAreaPage;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.NewCommercialProposalPage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.ProposalDetails;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

/**
 * @author Poornima
 * 
 * This class is used to create a proposal and reject
 */
@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)
public class CreateProposalAndRejectTest extends BaseClass{

	/**
	 * @throws Exception
	 * 
	 * This Method is used to create a Proposal, validate and reject
	 */
	@Test(groups = "regressionTest")
	public void createProposalAndReject() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		NewCommercialProposalPage ncp = new NewCommercialProposalPage(driver);
		ProposalDetails pd = new ProposalDetails(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Third party page and create the Third-party as in Pre-condition");

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
		
		UtilityClassObject.getTest().log(Status.INFO, "Third-party created successfully");

		String eTitleTpDetailsPage = tpName+eLib.getDataFromExcelFile("PageTitles", 3, 1);
		String aTitleTpDetailsPage = driver.getTitle();
		Assert.assertEquals(aTitleTpDetailsPage,eTitleTpDetailsPage);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Commerce Area page");

		/* Click on Commerce major tab */
		h.getCommerceTab().click();
		
		/*Get page title of commerce area page from excel and validate with Assertion*/
		String eTitleCommerceMajorTab = eLib.getDataFromExcelFile("PageTitles", 7, 1);
		String aTitleCommerceMajorTab = driver.getTitle();
		Assert.assertEquals(aTitleCommerceMajorTab, eTitleCommerceMajorTab);
		
		UtilityClassObject.getTest().log(Status.INFO, "Create New proposal");

		/* Click on New proposal link */
		cap.getNewProposalLink().click();
		
		/*Get page title of new Proposal page from excel and validate with Assertion*/
		String eTitleNewProposalPage = eLib.getDataFromExcelFile("PageTitles", 8, 1);
		String aTitleNewProposalPage = driver.getTitle();
		Assert.assertEquals(aTitleNewProposalPage, eTitleNewProposalPage);
		
		/* create new proposal*/
		ncp.createNewProposal(tpName);
		
		/*  reference ID */
		String refID = pd.getRefID().getText();
		
		refID = refID.substring(0, refID.indexOf(')')+1);
		
		/*Get page title of Proposal details page from excel and validate with Assertion*/
		String eTitleProposalDetailsPage = refID+eLib.getDataFromExcelFile("PageTitles", 10, 1);
		String aTitleProposalDetailsPage = driver.getTitle();
		Assert.assertEquals(aTitleProposalDetailsPage, eTitleProposalDetailsPage);
		Assert.assertTrue(pd.getDraftText().isDisplayed());
		
		/* get data from excel file*/
		String propType = eLib.getDataFromExcelFile("Proposals", 1, 0);
		String propName = eLib.getDataFromExcelFile("Proposals", 1, 1);
		String unitPrice = eLib.getDataFromExcelFile("Proposals", 1, 3);
		String qty = eLib.getDataFromExcelFile("Proposals", 1, 4);
		String discount = eLib.getDataFromExcelFile("Proposals", 1, 5);
		
		UtilityClassObject.getTest().log(Status.INFO, "Add Products and validate the proposal");

		/* Enter all the details to add the Product/service */
		pd.addProduct(propType,propName,unitPrice,qty,discount);
		
		/* Verify validate button displayed or not */
		Assert.assertTrue(pd.getValidateBtn().isDisplayed());
		
		/* validate proposal */
		pd.getValidateBtn().click();
		
		/* Verify confirmation message is displayed or not */
		Assert.assertTrue(pd.getConfirmationBoxText().isDisplayed());
		
		/* Click on Yes in the confirmation box*/
		pd.getValidateConfirmBtn().click();
		
		/* Verify the Validated Text on the page */
		Assert.assertTrue(pd.getValidateText().isDisplayed());
		
		UtilityClassObject.getTest().log(Status.INFO, "Reject the proposal by selected Not-signed option");

		/*Click on Set Accepted/Rejected button*/
		pd.getSetAcceptedOrRefusedBtn().click();
		
		/* Verify Set Accepted/Refused Confirm box is displayed or not*/
		Assert.assertTrue(pd.getSetStatusSelBx().isDisplayed());
		
		/* Select Unsigned and Click on Yes*/
		/* Get the status from excel file*/
		String status = eLib.getDataFromExcelFile("Proposals", 1, 6);
		String note = eLib.getDataFromExcelFile("Proposals", 1, 7);
		pd.handleConfirmation(status,note);
		
		/*Verify the Proposal is Not-Signed or not*/
		Assert.assertTrue(pd.getNotSignedText().isDisplayed());
	}
}
