package com.pabb.staarcms.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Poornima 
 * 
 * This class is used to store all the web elements present in Proposal details page
 */
public class ProposalDetails {

	@FindBy(xpath="//div[@class='inline-block floatleft valignmiddle maxwidth750 marginbottomonly refid refidpadding']")
	private WebElement refID;
	
	@FindBy(xpath="//span[@id='select2-select_type-container']")
	private WebElement typeSelBx;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement typeTxtBx;
	
	@FindBy(id="dp_desc")
	private WebElement descrTxtArea;
	
	@FindBy(id="tva_tx")
	private WebElement salesTaxSelBx;
	
	@FindBy(id="price_ht")
	private WebElement unitPriceTxtBx;
	
	@FindBy(id="qty")
	private WebElement qtyTxtBx;
	
	@FindBy(id="remise_percent")
	private WebElement discTxtBx;
	
	@FindBy(id="addline")
	private WebElement addBtn;
	
	@FindBy(xpath = "//a[text()='Validate']")
	private WebElement validateBtn;
	
	@FindBy(xpath = "//a[text()='Set accepted/refused']")
	private WebElement setAcceptedOrRefusedBtn;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement validateConfirmBtn;
	
	@FindBy(xpath="//span[@id='select2-statut-container']")
	private WebElement setStatusSelBx;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement setStatusTxtBx;
	
	@FindBy(id="note_private")
	private WebElement noteTxtBx;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement setAcceptedOrRefusedConfirmBtn;
	
	@FindBy(xpath="//span[text()='Draft (needs to be validated)']")
	private WebElement draftText;
	
	@FindBy(id="ui-id-1")
	private WebElement confirmationBoxText;
	
	@FindBy(xpath="//span[text()='Validated (proposal is open)']")
	private WebElement validateText;
	
	@FindBy(xpath="//span[text()='Not signed (closed)']")
	private WebElement notSignedText;
	
	@FindBy(xpath="//span[text()='Signed (needs billing)']")
	private WebElement signedText;
	
	@FindBy(xpath = "//a[text()='Create order']")
	private WebElement createOrderBtn;
	
	public ProposalDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRefID() {
		return refID;
	}

	public WebElement getTypeSelBx() {
		return typeSelBx;
	}

	public WebElement getTypeTxtBx() {
		return typeTxtBx;
	}

	public WebElement getDescrTxtArea() {
		return descrTxtArea;
	}

	public WebElement getSalesTaxSelBx() {
		return salesTaxSelBx;
	}

	public WebElement getUnitPriceTxtBx() {
		return unitPriceTxtBx;
	}

	public WebElement getQtyTxtBx() {
		return qtyTxtBx;
	}

	public WebElement getDiscTxtBx() {
		return discTxtBx;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}
	
	public WebElement getValidateConfirmBtn() {
		return validateConfirmBtn;
	}
	
	public WebElement getSetAcceptedOrRefusedBtn() {
		return setAcceptedOrRefusedBtn;
	}
	
	public WebElement getSetStatusSelBx() {
		return setStatusSelBx;
	}

	public WebElement getSetStatusTxtBx() {
		return setStatusTxtBx;
	}

	public WebElement getNoteTxtBx() {
		return noteTxtBx;
	}

	public WebElement getSetAcceptedOrRefusedConfirmBtn() {
		return setAcceptedOrRefusedConfirmBtn;
	}
	
	public WebElement getDraftText() {
		return draftText;
	}
	
	
	public WebElement getConfirmationBoxText() {
		return confirmationBoxText;
	}
	
	public WebElement getValidateText() {
		return validateText;
	}
	
	public WebElement getNotSignedText() {
		return notSignedText;
	}
	
	public WebElement getSignedText() {
		return signedText;
	}
	
	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	/**
	 * 
	 * @param type
	 * @param descr
	 * @param unitPrice
	 * @param quantity
	 * @param discount
	 * 
	 * This Method is used to Add a product/service with the price details
	 */
	public void addProduct(String type, String descr, String unitPrice, String quantity,String discount)
	{
		typeSelBx.click();
		typeTxtBx.sendKeys(type+Keys.ENTER);
		descrTxtArea.sendKeys(descr);
		unitPriceTxtBx.sendKeys(unitPrice);
		qtyTxtBx.sendKeys(quantity);
		discTxtBx.sendKeys(discount);
		addBtn.click();	
	}
	
	/**
	 * @param status
	 * @param note
	 * 
	 * This Method is used to Select the status 
	 */
	public void handleConfirmation(String status,String note)
	{
		setStatusSelBx.click();
		setStatusTxtBx.sendKeys(status+Keys.ENTER);
		noteTxtBx.sendKeys(note);
		setAcceptedOrRefusedConfirmBtn.click();
	}
	
}
