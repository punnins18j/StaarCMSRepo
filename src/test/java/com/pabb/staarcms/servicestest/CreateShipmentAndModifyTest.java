package com.pabb.staarcms.servicestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pabb.staarcms.genericutility.BaseClass;
import com.pabb.staarcms.objectrepository.CommerceAreaPage;
import com.pabb.staarcms.objectrepository.CreateShipmentPage;
import com.pabb.staarcms.objectrepository.HomePage;
import com.pabb.staarcms.objectrepository.ListOfShipmentsPage;
import com.pabb.staarcms.objectrepository.NewCommercialProposalPage;
import com.pabb.staarcms.objectrepository.NewOrderPage;
import com.pabb.staarcms.objectrepository.NewThirdPartyPage;
import com.pabb.staarcms.objectrepository.OrderDetailsPage;
import com.pabb.staarcms.objectrepository.ProposalDetails;
import com.pabb.staarcms.objectrepository.SendMailPage;
import com.pabb.staarcms.objectrepository.ServicesAreaPage;
import com.pabb.staarcms.objectrepository.ShipmentCardPage;
import com.pabb.staarcms.objectrepository.ShipmentDetailsPage;
import com.pabb.staarcms.objectrepository.ThirdPartiesPage;
import com.pabb.staarcms.webdriverutility.UtilityClassObject;

@Listeners(com.pabb.staarcms.listenerutility.ListenerImplementation.class)
public class CreateShipmentAndModifyTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createShipmentAndModifyTest() throws Exception
	{
		/* Create object for POM classes */
		HomePage h = new HomePage(driver);
		ThirdPartiesPage tp = new ThirdPartiesPage(driver);
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		CommerceAreaPage cap = new CommerceAreaPage(driver);
		NewCommercialProposalPage ncp = new NewCommercialProposalPage(driver);
		ProposalDetails pd = new ProposalDetails(driver);
		NewOrderPage nop = new NewOrderPage(driver);
		OrderDetailsPage odp = new OrderDetailsPage(driver);
		ShipmentDetailsPage sdp = new ShipmentDetailsPage(driver);
		CreateShipmentPage csp = new CreateShipmentPage(driver);
		ShipmentCardPage scp = new ShipmentCardPage(driver);
		ServicesAreaPage sap = new ServicesAreaPage(driver);
		ListOfShipmentsPage los = new ListOfShipmentsPage(driver);
		SendMailPage smp = new SendMailPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Third-parties area and create the Third party as in pre-condition");

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
		
		UtilityClassObject.getTest().log(Status.INFO, " User is able to open the browser and login to the application");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Commerce Area and create the proposal");

		/* Click on Commerce major tab */
		h.getCommerceTab().click();
		
		/*Get page title of commerce area page from excel and validate with Assertion*/
		String eTitleCommerceMajorTab = eLib.getDataFromExcelFile("PageTitles", 7, 1);
		String aTitleCommerceMajorTab = driver.getTitle();
		Assert.assertEquals(aTitleCommerceMajorTab, eTitleCommerceMajorTab);
		
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
		
		UtilityClassObject.getTest().log(Status.INFO, "Proposal created and validated successfully");

		UtilityClassObject.getTest().log(Status.INFO, "Accept the proposal");

		/*Click on Set Accepted/Rejected button*/
		pd.getSetAcceptedOrRefusedBtn().click();
		
		/* Verify Set Accepted/Refused Confirm box is displayed or not*/
		Assert.assertTrue(pd.getSetStatusSelBx().isDisplayed());
		
		/* Select Signed and Click on Yes*/
		/* Get the status from excel file*/
		String status = eLib.getDataFromExcelFile("Proposals", 1, 8);
		String note = eLib.getDataFromExcelFile("Proposals", 1, 7);
		pd.handleConfirmation(status,note);
		
		/*Verify the Proposal for Signed or not*/
		Assert.assertTrue(pd.getSignedText().isDisplayed());
		
		UtilityClassObject.getTest().log(Status.INFO, "Proposal created, validated and Accepted");

		UtilityClassObject.getTest().log(Status.INFO, "Create Sales order and validate");

		pd.getCreateOrderBtn().click();
		
		/*Get page title of New Order page from excel and validate with Assertion*/
		String eTitleNewOrderPage = eLib.getDataFromExcelFile("PageTitles", 11, 1);
		String aTitleNewOrderPage = driver.getTitle();
		Assert.assertEquals(aTitleNewOrderPage, eTitleNewOrderPage);
		
		/* Click on Create Draft Button*/
		nop.getCreateDraftBtn().click();
		
		/* Verift order details page is displayed or not with draft status*/
		Assert.assertTrue(odp.getDraftText().isDisplayed());
		
		/* Click on Validate button*/
		odp.getValidateBtn().click();
		
		/* verify confirmation box is displayed or not*/
		Assert.assertTrue(odp.getValidateConfirmationBox().isDisplayed());
		
		/*Click on yes button*/
		odp.getYesBtn().click();
		
		/* verify sales order is validated or not and Assert*/
		Assert.assertTrue(odp.getValidatedText().isDisplayed());
		
		/* Click on Create button */
		odp.getCreateOrderBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Sales order created and validated successfully");

		UtilityClassObject.getTest().log(Status.INFO, "Move the order to shipment from Sales Order");
		
		/* Click on Create Shipment button */
		odp.getCreateShipmentOpt().click();
		
		/*  reference ID */
		String shipmentID = sdp.getShipmentID().getText();
		
		shipmentID = shipmentID.substring(0, 11);
		
		/* Get page title of Shipment details page from excel and Assert*/
		String eTitleShipmentDetailsPage = shipmentID+eLib.getDataFromExcelFile("PageTitles", 12, 1);
		String aTitleShipmentDetailsPage = driver.getTitle();
		Assert.assertEquals(aTitleShipmentDetailsPage, eTitleShipmentDetailsPage);
		
		/* Click on Create Shipment Button*/
		sdp.getCreateShipmentBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Shipment created successfully");
		
		UtilityClassObject.getTest().log(Status.INFO, "Add the shipment details and validate the shipment");

		/*Click on delivery method drop down */
		csp.getDeliveryMethodSelBx().click();
		
		/*get Shipment method from excel file*/
		String deliveryMethod = eLib.getDataFromExcelFile("Shipments", 1, 0);
		csp.getDeliveryMethodOpt().sendKeys(deliveryMethod+Keys.ENTER);
		
		/*Get Quantity to ship from excel and Click on Qty to ship*/
		String qtyToShip = eLib.getDataFromExcelFile("Shipments", 1, 1);
		csp.getQtyTxtBx().sendKeys(qtyToShip);
		
		/*click on Create Shipment Button*/
		csp.getCreateBtn().click();
		
		/* validate the page and click on validate button*/
		Assert.assertTrue(scp.getDraftStatus().isDisplayed());
		scp.getValidateBtn().click();
		
		/*Click on Yes button in confirmation box*/
		Assert.assertTrue(scp.getConfirmationBoxText().isDisplayed());
		scp.getYesBtn().click();

		String shipmentRefNo = scp.getShipmentNo().getText().substring(0, 11);
		
		/*Verify the page and Assert*/
		Assert.assertTrue(scp.getValidatedText().isDisplayed());
		
		UtilityClassObject.getTest().log(Status.INFO, "Shipment validated successfully");

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Services majot tab and search the shipment in the list");

		/*Click on Services Major tab*/
		h.getServicesTab().click();
		
		/* verify the  page by getting the page title from excel and assert */
		String eTitleServicesAreaPage = eLib.getDataFromExcelFile("PageTitles", 13, 1);
		String aTitleServicesAreaPage = driver.getTitle();
		Assert.assertEquals(aTitleServicesAreaPage, eTitleServicesAreaPage);
		
		/* click on list link */
		sap.getListLink().click();
		
		/* Validate list of shipments page and Assert*/
		String eTitleListOfShipmentsPage = eLib.getDataFromExcelFile("PageTitles", 14, 1);
		String aTitleListOfShipmentsPage = driver.getTitle();
		Assert.assertEquals(aTitleListOfShipmentsPage, eTitleListOfShipmentsPage);
		
		/*Enter the reference name and search the shipment*/
		los.getRefNo().sendKeys(shipmentRefNo+Keys.ENTER);
		
		/* click on the created shipment in the list */
		los.getShipmentRefNoInList().click();
		
		/*Veryfy the page and Assert*/
		Assert.assertTrue(los.getValidateText().isDisplayed());
		
		UtilityClassObject.getTest().log(Status.INFO, "Shipment found in the list");

		UtilityClassObject.getTest().log(Status.INFO, "Modify the Shipment method and send mail");

		/* Click on edit icon*/
		scp.getEditShippingMethodIcon().click();
		
		/* Enter the Delivery method by getting from excel */
		String deliveryMethodModify = eLib.getDataFromExcelFile("Shipments", 1, 2);
		scp.getShipmentMethodSelBx().click();
		scp.getShipmentMethodOptTxtBx().sendKeys(deliveryMethodModify+Keys.ENTER);
		
		/* Click on Modify Button */
		scp.getModifyBtn().click();
		
		/*Click on Send Mail*/
		scp.getSendMailBtn().click();
		
		/*Enter the mail id */
		String mailID = eLib.getDataFromExcelFile("Shipments", 1, 3);
		smp.getSendToTxtBx().sendKeys(mailID);
		
		/*Click on Send mail Button*/
		smp.getSendMailBtn().click();
		
		/*verifu mail sent or not*/
		Assert.assertFalse(smp.getFailedText().isDisplayed());
		
		UtilityClassObject.getTest().log(Status.INFO, "Mail send failed");
	}
}
