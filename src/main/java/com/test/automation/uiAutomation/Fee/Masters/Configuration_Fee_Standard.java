/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Configuration_Fee_Standard extends TestBase {

	public static final Logger log = Logger.getLogger(Configuration_Fee_Standard.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Configuration')][1]")
	WebElement feeConfiguration;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Configuration')][1]/following::li[1]")
	WebElement btnFeeStandard;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Fee Group')]/preceding-sibling::input")
	WebElement btnFeeGroup;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Fee Term')]/preceding-sibling::input")
	WebElement btnFeeTerm;

	@FindBy(xpath = "//span[contains(text(),'Concession Process')]")
	WebElement chkFeeConcessionProc;

	@FindBy(xpath = "//span[contains(text(),'Card Type')]")
	WebElement chkCardtype;

	@FindBy(xpath = "//label[contains(text(),'Debit Card Charges:')]/following-sibling::div/input")
	WebElement txtEnterDebitCardCharge;

	@FindBy(xpath = "//label[contains(text(),'Credit Card Charges:')]/following-sibling::div/input")
	WebElement txtEnterCreditCardCharge;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	public Configuration_Fee_Standard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void nevigateTofeeStandard() throws Exception {
		if(btnFee.isDisplayed()){
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);
		}
		else{
			log("Fee button element is not present.");
			Thread.sleep(500);
		}
		if(feeConfiguration.isDisplayed()){
		feeConfiguration.click();
		log("Clicked on Fee Configuration Button and object is:-" + feeConfiguration.toString());
		Thread.sleep(1000);
		}
		else{
			log("fee Configuration button element is not present.");
			Thread.sleep(500);
		}
		if(btnFeeStandard.isDisplayed()){
		btnFeeStandard.click();
		log("Clicked on Fee Standard Button and object is:-" + btnFeeStandard.toString());
		Thread.sleep(1000);
		}
		else{
			log("Fee Standard button element is not present.");
			Thread.sleep(500);
		}
	}

	public void selectFeeGroupRadioBtn() throws Exception {
		
		if(!btnFeeGroup.isSelected()){
			btnFeeGroup.click();
		log("Fee Group radio Button is selected and object is:-" + btnFeeGroup.toString());
		Thread.sleep(1000);
		}
		else{
			log("Fee Group radio Button is already selected " + btnFeeGroup.toString());
			Thread.sleep(1000);
		}
	}

	public void selectConcessionProcess() throws Exception {
		
		if(!chkFeeConcessionProc.isSelected()){
			chkFeeConcessionProc.click();
		log("Concession Process check box is selected and object is:-" + chkFeeConcessionProc.toString());
		Thread.sleep(1000);
		}
		else{
			log("Concession Process check box is already selected (OR) element not present and object is:-" + chkFeeConcessionProc.toString());
			Thread.sleep(500);
		}
	}

	public void selectCardTypeAndEnterCharges() throws Exception {
		
			if(!chkCardtype.isSelected()){
			chkCardtype.click();
		log("Card type check box is selected and object is:-" + chkCardtype.toString());
		Thread.sleep(1000);
			}
			else{
				log("Card type check box is already selected and object is:-" + chkCardtype.toString());
				Thread.sleep(500);
			}
	
		if(txtEnterDebitCardCharge.isDisplayed()){
		txtEnterDebitCardCharge.sendKeys("10");
		log("entered debit card transaction charge:-" + "10" + " and object is " + txtEnterDebitCardCharge.toString());
		Thread.sleep(1000);
	}
	else{
		log("Debit card transaction charge element is not present.");
		Thread.sleep(500);
	}
		if(txtEnterCreditCardCharge.isDisplayed()){
		txtEnterCreditCardCharge.sendKeys("15");
		log("entered credit card transaction charge:-" + "15" + " and object is " + txtEnterCreditCardCharge.toString());
		Thread.sleep(1000);
	}
	else{
		log("Debit card transaction charge element is not present.");
		Thread.sleep(500);
	}
	}
	public void clickedOnSaveButton() throws Exception{
		if(btnSave.isDisplayed()){
		btnSave.click();
		log("clicked on save button and object is:-"+btnSave.toString());
		Thread.sleep(7000);
	}
	else{
		log("Save button element is not present.");
		Thread.sleep(500);
	}
	}
	public boolean successMessagevalidation(){
		try {
			
			successfulMessage.isDisplayed();
			log("Record saved successfully is dispalyed and object is:-"+successfulMessage.toString());
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			return false;
		}

}
public void clickOnSuccessOkButton() throws Exception{
	if(btnOkonSuccess.isDisplayed()){
	btnOkonSuccess.click();
	log("Clicked on Ok button of success confirmation and object is:-"+btnOkonSuccess.toString());
	Thread.sleep(2000);
}
else{
	log("Save button element is not present.");
	Thread.sleep(500);
}
}
}
