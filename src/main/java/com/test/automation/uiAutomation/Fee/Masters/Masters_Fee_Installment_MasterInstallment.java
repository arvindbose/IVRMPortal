/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

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

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[9]")
	WebElement btnFeeInstallment;

	@FindBy(xpath = "//label[contains(text(),'Installment Name:')]/following-sibling::div/input")
	WebElement input_InstallmentName;

	@FindBy(xpath = "(//label[contains(text(),'Type:')]/following-sibling::div/select)[1]")
	WebElement sel_InstallmentType;

	@FindBy(xpath = "//label[contains(text(),'No. of installments:')]/following-sibling::div/input")
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
	WebElement input_Search_MasterGr;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
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
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void nevigateToFeeInstallment_MasterInstallment() throws Exception {
		if (btnFee.isDisplayed()) {
			btnFee.click();
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Fee Navigation element not present.");
			Thread.sleep(500);
		}
		if (feeMasters.isDisplayed()) {
			feeMasters.click();
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee Masters Navigation element not present.");
			Thread.sleep(500);
		}
		if (btnFeeInstallment.isDisplayed()) {
			btnFeeInstallment.click();
			log("Clicked on Fee Installment Button and object is:-" + btnFeeInstallment.toString());
			Thread.sleep(5000);
		} else {
			log("Fee Installment Navigation element not present.");
			Thread.sleep(500);
		}
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
		if (input_InstallmentName.isDisplayed()) {
			input_InstallmentName.clear();
			input_InstallmentName.sendKeys(MasterInstallmentName);
			log("Entered Fee master installment name:-" + MasterInstallmentName + " and object is "
					+ input_InstallmentName.toString());
			Thread.sleep(1000);
		} else {
			log("Installment Name element is not present");
			Thread.sleep(500);
		}

		if (sel_InstallmentType.isDisplayed()) {
			select = new Select(sel_InstallmentType);
			select.selectByVisibleText(MasterInstallmentType);

			log("Selected installment type:-" + MasterInstallmentType + " and object is:- "
					+ sel_InstallmentType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), MasterInstallmentType);
			Thread.sleep(2000);
		} else {
			log("Installment type element is not present");
			Thread.sleep(500);
		}
		if (input_NoOfInstallment.isDisplayed()) {
			input_NoOfInstallment.clear();
			input_NoOfInstallment.sendKeys(NoOfInstallment);
			log("Entered No. of installment:-" + NoOfInstallment + " and object is "
					+ input_NoOfInstallment.toString());
			Thread.sleep(1000);
		} else {
			log("No Of Installment element is not present");
			Thread.sleep(500);
		}
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

		txtInstallmentName1.sendKeys(Installment1);
		log("entered 1st installment name:-" + Installment1 + " and object is " + txtInstallmentName1.toString());
		Thread.sleep(1000);
		txtInstallmentName2.sendKeys(Installment2);
		log("entered 2nd installment name:-" + Installment2 + " and object is " + txtInstallmentName2.toString());
		Thread.sleep(1000);
		txtInstallmentName3.sendKeys(Installment3);
		log("entered 3rd installment name:-" + Installment3 + " and object is " + txtInstallmentName3.toString());
		Thread.sleep(1000);
		txtInstallmentName4.sendKeys(Installment4);
		log("entered 4th installment name:-" + Installment4 + " and object is " + txtInstallmentName4.toString());
		Thread.sleep(1000);
		txtInstallmentName5.sendKeys(Installment5);
		log("entered 5th installment name:-" + Installment5 + " and object is " + txtInstallmentName5.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {
		if (btn_Save_MasterInstallment.isDisplayed()) {
			btn_Save_MasterInstallment.click();
			log("clicked on save button and object is:-" + btn_Save_MasterInstallment.toString());
			Thread.sleep(7000);
		} else {
			log("Save Button element is not present");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearedFilledForm() throws Exception {
		if (btn_Cancel_MasterInstallment.isDisplayed()) {
			btn_Cancel_MasterInstallment.click();
			log("clicked on cancel button to cleared filled data and object is:-"
					+ btn_Cancel_MasterInstallment.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel Button element is not present");
			Thread.sleep(500);
		}
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
		if (btnOkonSuccess.isDisplayed()) {
			btnOkonSuccess.click();
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK Button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with the created Fee Installment
	 * 
	 * @param installmentName
	 * @throws Exception
	 */

	public void searchBy_InstallmentName_InFeeMasterInstallmentGridView(String installmentName) throws Exception {
		if (input_Search_MasterGr.isDisplayed()) {
			input_Search_MasterGr.clear();
			input_Search_MasterGr.sendKeys(installmentName);
			log("Entered Master Fee Installment Name:" + installmentName + " and object is:-"
					+ input_Search_MasterGr.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present");
			Thread.sleep(500);
		}
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
		for (int i = 1; i <= rows; i++) {
			String feeinstallment = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Installment Master " + feeinstallment);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feeinstallment, installmentName);
				log("Master Fee Installment name is update in the grid:" + feeinstallment);
				Thread.sleep(1000);
				// break;
			} catch (Exception e) {
				e.printStackTrace();
			}

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
		for (int i = 1; i <= rows; i++) {
			String feeinstallment = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Installment Master " + installmentName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feeinstallment, installmentName);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/a")).click();
				log("Clicked on edit link for corresponding Master Fee Installment name in grid");
				Thread.sleep(1000);
				// break;
			} catch (Exception e) {
				e.printStackTrace();
			}

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
		for (int i = 1; i <= rows; i++) {
			String feeinstallment = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feeinstallment);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feeinstallment, installmentName);
				WebElement deactiveLink = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/span"));
				String deactivetext = deactiveLink.getText().trim();
				Assert.assertEquals("Deactivate", deactivetext);

				deactiveLink.click();
				log("Clicked on deactivation link in Master fee Installment grid");
				Thread.sleep(1000);
				// break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Confirmation validation for deactivation, activation
	 * 
	 * @throws Exception
	 */

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes deactivate or activate or delete it button and object is:-"
					+ btnYesDeleteOrDeactIt.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Activate/Deactivate button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_PopUp() throws Exception {
		if (btnPopUpCancel.isDisplayed()) {
			btnPopUpCancel.click();
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
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
		for (int i = 1; i <= rows; i++) {
			String feeinstallment = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Installment Master " + feeinstallment);
			Thread.sleep(2000);
			try {
				WebElement activeLink = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]/span"));
				String activatext = activeLink.getText().trim();
				Assert.assertEquals("Activate", activatext);

				activeLink.click();
				log("Clicked on activation link in Master fee Installment in grid");
				Thread.sleep(1000);
				// break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeAndMaximize_MasterInstallment() throws Exception {
		if (btnMin_MaxMasterInstallment.isDisplayed()) {
			btnMin_MaxMasterInstallment.click();
			log("clicked on master Installment minimize and maximize button and object is:-"
					+ btnMin_MaxMasterInstallment.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Master Installment button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_MasterFeeInstallmentGridView() throws Exception {
		if (btnMin_MaxMasterFeeInstallmentGridView.isDisplayed()) {
			btnMin_MaxMasterFeeInstallmentGridView.click();
			log("Master Fee Installment grid table data minimize and maximize and object is:-"
					+ btnMin_MaxMasterFeeInstallmentGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Master Fee Installment grid button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_FeeMasterInstallmentGridView() throws Exception {
		if (btnMin_MaxMasterFeeMasterInstallmentGridView.isDisplayed()) {
			btnMin_MaxMasterFeeMasterInstallmentGridView.click();
			log("Fee Master Installment grid view table data minimize and maximize and object is:-"
					+ btnMin_MaxMasterFeeMasterInstallmentGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Fee Master Installment grid button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortByMasterInstallmentName() throws Exception {
		if (btnSortByInstallmentName.isDisplayed()) {
			btnSortByInstallmentName.click();
			log("Sorted the record with Fee Installment name and object is:-" + btnSortByInstallmentName.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}
}
