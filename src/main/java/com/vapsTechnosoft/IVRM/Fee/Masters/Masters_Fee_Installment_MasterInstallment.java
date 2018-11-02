/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Installment_MasterInstallment extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Installment_MasterInstallment.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[9]")
	// WebElement btnFeeInstallment;

	@FindBy(xpath = "//a[@href='#/app/MasterFeeInstallment/81']")
	WebElement btnFeeInstallment;

	@FindBy(xpath = "//input[@name='name123']")
	WebElement input_InstallmentName;

	@FindBy(xpath = "//select[@name='typ']")
	WebElement sel_InstallmentType;

	@FindBy(xpath = "//input[@name='noofinstall']")
	WebElement input_NoOfInstallment;

	@FindBy(xpath = "//table[@id='personalDetail']/tbody/tr[1]/td[2]/input[2]")
	WebElement txtInstallmentName1;

	@FindBy(xpath = "//table[@id='personalDetail']/tbody/tr[2]/td[2]/input[2]")
	WebElement txtInstallmentName2;

	@FindBy(xpath = "//table[@id='personalDetail']/tbody/tr[3]/td[2]/input[2]")
	WebElement txtInstallmentName3;

	@FindBy(xpath = "//table[@id='personalDetail']/tbody/tr[4]/td[2]/input[2]")
	WebElement txtInstallmentName4;

	@FindBy(xpath = "//table[@id='personalDetail']/tbody/tr[5]/td[2]/input[2]")
	WebElement txtInstallmentName5;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeInstallmentScreen;

	@FindBy(xpath = "//h3[contains(text(),'Fee Installment Grid View')]")
	WebElement txtFIGridView;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[1]")
	WebElement btn_Save_MasterInstallment;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	WebElement btn_Cancel_MasterInstallment;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "(//div[@class='input-group']/span/following-sibling::input)[1]")
	WebElement input_Search_MasterInstallment;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterInstallment;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterFeeInstallmentGridView;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxMasterFeeMasterInstallmentGridView;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/thead/tr/th[2]/a")
	WebElement btnSortByInstallmentName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */

	public Masters_Fee_Installment_MasterInstallment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Home button verification/display
	 * 
	 * @return
	 */
	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void navigateToFeeInstallment_MasterInstallment() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeInstallment);
		log("Clicked on Fee Installment Button and object is:-" + btnFeeInstallment.toString());

	}

	public boolean verifyFeeInstallmentScreen() {
		try {
			System.out.println(txtFeeInstallmentScreen.getText());
			txtFeeInstallmentScreen.isDisplayed();
			log("Fee Installment screen page is dispalyed and object is:-" + txtFeeInstallmentScreen.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fillMasterInstallmentForm(String MasterInstallmentName, String MasterInstallmentType,
			String NoOfInstallment) throws Exception {

		inputTextIntoInputField(input_InstallmentName, MasterInstallmentName);
		log("Entered Fee master installment name:-" + MasterInstallmentName + " and object is "
				+ input_InstallmentName.toString());

		selectElementFromDropDown(sel_InstallmentType, MasterInstallmentType);
		log("Selected installment type:-" + MasterInstallmentType + " and object is:- "
				+ sel_InstallmentType.toString());

		inputTextIntoInputField(input_NoOfInstallment, NoOfInstallment);
		log("Entered No. of installment:-" + NoOfInstallment + " and object is " + input_NoOfInstallment.toString());

	}

	public boolean verifyFeeInstallmentGridIsPresent() {
		try {
			System.out.println(txtFIGridView.getText());
			txtFIGridView.isDisplayed();
			log("Fee Installment grid view is dispalyed and object is:-" + txtFIGridView.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterNameForSelectedNoOfInstallment(String Installment1, String Installment2, String Installment3,
			String Installment4, String Installment5) throws Exception {

		inputTextIntoInputField(txtInstallmentName1, Installment1);
		log("entered 1st installment name:-" + Installment1 + " and object is " + txtInstallmentName1.toString());

		inputTextIntoInputField(txtInstallmentName2, Installment2);
		log("entered 2nd installment name:-" + Installment2 + " and object is " + txtInstallmentName2.toString());

		inputTextIntoInputField(txtInstallmentName3, Installment3);
		log("entered 3rd installment name:-" + Installment3 + " and object is " + txtInstallmentName3.toString());

		inputTextIntoInputField(txtInstallmentName4, Installment4);
		log("entered 4th installment name:-" + Installment4 + " and object is " + txtInstallmentName4.toString());

		inputTextIntoInputField(txtInstallmentName5, Installment5);
		log("entered 5th installment name:-" + Installment5 + " and object is " + txtInstallmentName5.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btn_Save_MasterInstallment);
		log("clicked on save button and object is:-" + btn_Save_MasterInstallment.toString());
		Thread.sleep(1000);
	}

	public void clickOnCancelButton_ToClearedFilledForm() throws Exception {

		clickOnButton(btn_Cancel_MasterInstallment);
		log("clicked on cancel button to cleared filled data and object is:-"
				+ btn_Cancel_MasterInstallment.toString());

	}

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

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());

	}

	/**
	 * Search with the created Fee Installment
	 * 
	 * @param installmentName
	 * @throws Exception
	 */

	public void searchBy_InstallmentName_InFeeMasterInstallmentGridView(String installmentName) throws Exception {

		inputTextIntoInputField(input_Search_MasterInstallment, installmentName);
		log("Entered Master Fee Installment Name:" + installmentName + " and object is:-"
				+ input_Search_MasterInstallment.toString());
	}

	/**
	 * verify for the created Master Fee Installment
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void verifyMasterFeeInstallment_UpdatedInGrid(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("Created Fee Installment Master " + feeinstallment);
				Thread.sleep(500);
				if (feeinstallment.equals(installmentName)) {
					Assert.assertEquals(feeinstallment, installmentName);
					log("Master Fee Installment name is update in the grid:" + feeinstallment);
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit Master fee Installment name created
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void edit_MasterFeeInstallment(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("Created Fee Installment Master " + installmentName);
				Thread.sleep(2000);
				if (feeinstallment.equals(installmentName)) {
					Assert.assertEquals(feeinstallment, installmentName);
					driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/a"))
							.click();
					log("Clicked on edit link for corresponding Master Fee Installment name in grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * De-activation of created Master Fee Installment
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void deactivationOfCreated_MasterFeeInstallment(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("Created Fee Group Master " + feeinstallment);
				Thread.sleep(2000);
				if (feeinstallment.equals(installmentName)) {
					Assert.assertEquals(feeinstallment, installmentName);
					WebElement deactiveLink = driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					log("Clicked on deactivation link in Master fee Installment grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Confirmation validation for deactivation, activation
	 * 
	 * @throws Exception
	 */

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(1000);

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());

	}

	/**
	 * Activation of created Master fee Installment
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void activationOfCreatedFeeInstallment_MasterInstallment(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("Created Fee Installment Master " + feeinstallment);
				Thread.sleep(2000);
				if (feeinstallment.equals(installmentName)) {
					Assert.assertEquals(feeinstallment, installmentName);
					WebElement activeLink = driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/span"));
					String activatext = activeLink.getText().trim();
					Assert.assertEquals(activatext, "Activate");

					activeLink.click();
					log("Clicked on activation link in Master fee Installment in grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeAndMaximize_MasterInstallment() throws Exception {

		clickOnButton(btnMin_MaxMasterInstallment);
		log("clicked on master Installment minimize and maximize button and object is:-"
				+ btnMin_MaxMasterInstallment.toString());

	}

	public void minimizeAndMaximize_MasterFeeInstallmentGridView() throws Exception {

		clickOnButton(btnMin_MaxMasterFeeInstallmentGridView);
		log("Master Fee Installment grid table data minimize and maximize and object is:-"
				+ btnMin_MaxMasterFeeInstallmentGridView.toString());

	}

	public void minimizeAndMaximize_FeeMasterInstallmentGridView() throws Exception {

		clickOnButton(btnMin_MaxMasterFeeMasterInstallmentGridView);
		log("Fee Master Installment grid view table data minimize and maximize and object is:-"
				+ btnMin_MaxMasterFeeMasterInstallmentGridView.toString());

	}

	public void sortByMasterInstallmentName() throws Exception {

		clickOnButton(btnSortByInstallmentName);
		log("Sorted the record with Fee Installment name and object is:-" + btnSortByInstallmentName.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated for edit.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeactivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeactivateSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_ActivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_ActivateSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
