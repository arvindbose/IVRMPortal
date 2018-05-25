/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Yearly_Group_HeadMap extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Yearly_Group_HeadMap.class.getName());

	WebDriver driver;
	Select select;
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[8]")
	WebElement btnYFGHMap;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtyearlyFGHmap;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selAcademicYr;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selfeeGroup;

	@FindBy(xpath = "(//select[@id='sel1'])[3]")
	WebElement selFeeHead1;

	@FindBy(xpath = "(//select[@id='sel1'])[4]")
	WebElement selfeeInstallment1;

	@FindBy(xpath = "(//select[@id='sel1'])[5]")
	WebElement selFeeHead2;

	@FindBy(xpath = "(//select[@id='sel1'])[6]")
	WebElement selfeeInstallment2;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[1]/td[5]/label/input")
	WebElement chkFine1;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[1]/td[6]/label/input")
	WebElement chkActive1;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[1]/td[7]/label/input")
	WebElement chkCommonAmt1;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[5]/label/input")
	WebElement chkFine2;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[6]/label/input")
	WebElement chkActive2;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[7]/label/input")
	WebElement chkCommonAmt2;

	@FindBy(xpath = "//div[@class='text-right']/button[1]")
	WebElement btnAddNew;

	@FindBy(xpath = "//div[@class='text-right']/button[2]")
	WebElement btnRemove;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	public Masters_Yearly_Group_HeadMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/**
 * Home button validation after successful login
 * 
 * @return
 */
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
/**
 * Navigate to Yearly group head map
 * 
 * @throws Exception
 */
	public void nevigateToMasters_YearlyGrHeadMap() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);

		btnYFGHMap.click();
		log("Clicked on yearly Fee Group Head map Button and object is:-" + btnYFGHMap.toString());
		Thread.sleep(1000);
	}
/**
 * Validate yearly group head map message is displayed on the screen
 * 
 * @return
 */
	public boolean verifyYearlyFeeHeadGrMapPage() {
		try {
			System.out.println(txtyearlyFGHmap.getText());
			txtyearlyFGHmap.isDisplayed();
			log("Yearly Fee Group Head Map page is dispalyed and object is:-" + txtyearlyFGHmap.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Select academic year and Fee group from the drop down list
	 * 
	 * @param AcademicYr
	 * @param FeeGroup
	 * @throws Exception
	 */

	public void selectAcademicYearAndFeeGroup(String AcademicYr, String FeeGroup) throws Exception {

		select = new Select(selAcademicYr);
		select.selectByVisibleText(AcademicYr);
		log("selected Academic year:-" + AcademicYr + " and object is " + selAcademicYr.toString());
		Thread.sleep(1000);

		select = new Select(selfeeGroup);
		select.selectByVisibleText(FeeGroup);
		log("selected fee group:-" + FeeGroup + " and object is " + selfeeGroup.toString());
		Thread.sleep(1000);

	}
/**
 * Select Fee Head, Fee Installment,  Fine, Active and Common amount from head installment table
 * 
 * @param feeHead
 * @param feeInstallment
 * @throws Exception
 */
	
	public void mapFeeHeadAndInstallment(String feeHead, String feeInstallment) throws Exception {

		select = new Select(selFeeHead1);
		select.selectByVisibleText(feeHead);
		log("selected fee head:-" + feeHead + " and object is " + selFeeHead1.toString());
		Thread.sleep(1000);

		select = new Select(selfeeInstallment1);
		select.selectByVisibleText(feeInstallment);
		log("selected fee Installment:-" + feeInstallment + " and object is " + selfeeInstallment1.toString());
		Thread.sleep(1000);
		
		if(!chkFine1.isSelected()){
		chkFine1.click();
		log("clicked on fine checkbox and object is:-" + chkFine1.toString());
		Thread.sleep(1000);
		}
		else{
			log("Fine check box is already selected and object is:-" +chkFine1.toString());
		}
		
		if(!chkActive1.isSelected()){
		chkActive1.click();
		log("clicked on Active checkbox and object is:-" + chkActive1.toString());
		Thread.sleep(1000);
		}
		else{
			log("Active check box is already selected and object is:-" + chkActive1.toString());
		}
		
		if(!chkCommonAmt1.isSelected()){
		chkCommonAmt1.click();
		log("clicked on Common Amount checkbox and object is:-" + chkCommonAmt1.toString());
		Thread.sleep(1000);
		}
		else{
			log("Common amount check box is already selected and object is:-" +chkCommonAmt1.toString());
		}
	}
	/**
	 * click on add New button
	 * @throws Exception 
	 */
	
	public void addNewFeeHead() throws Exception{
		btnAddNew.click();
		log("clicked on Add new button and object is:-" + btnAddNew.toString());
		Thread.sleep(1000);
	}
	
	/**
	 * click on add button and add fee head and installment
	 * 
	 * @throws Exception
	 */
	public void verifyUserAbleToAddNewHead(String feeHead2, String feeInstallment2) throws Exception {
		
		select = new Select(selFeeHead2);
		select.selectByVisibleText(feeHead2);
		log("selected fee head:-" + feeHead2 + " and object is " + selFeeHead2.toString());
		Thread.sleep(1000);

		select = new Select(selfeeInstallment2);
		select.selectByVisibleText(feeInstallment2);
		log("selected fee installment2:-" + feeInstallment2 + " and object is " + selfeeInstallment2.toString());
		Thread.sleep(1000);

		chkFine2.click();
		log("clicked on fine2 checkbox and object is:-" + chkFine2.toString());
		Thread.sleep(1000);

		chkActive2.click();
		log("clicked on Active2 checkbox and object is:-" + chkActive2.toString());
		Thread.sleep(1000);

		chkCommonAmt2.click();
		log("clicked on Common Amount2 checkbox and object is:-" + chkCommonAmt2.toString());
		Thread.sleep(1000);
	}

	/**
	 * Click on remove button to remove new head
	 * 
	 * @throws Exception
	 */
	public void removeAddedFeeHeadAndInstallment() throws Exception {

		btnRemove.click();
		log("clicked on remove button and added head is removed and object is:-" + chkFine1.toString());
		Thread.sleep(1000);
	}
	/**
	 * After selection of all required value clcik on save button
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	/**
	 * Validate pop up window successful message
	 * @return
	 */
	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * click OK button after successful submission
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}
}
