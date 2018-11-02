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
public class Masters_Custom_Fee_Group extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Yearly_Class_Category.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[6]")
	// WebElement btnCustomFeeGr;

	@FindBy(xpath = "//a[@href='#/app/FeeGroupsGrouping/84']")
	WebElement btnCustomFeeGr;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtCustomFeeGrMsgDispaly;

	@FindBy(xpath = "//input[@name='name']")
	WebElement inputFeeGroupName;

	@FindBy(xpath = "//input[@name='codename']")
	WebElement inputFeeGroupCode;

	@FindBy(xpath = "//input[@ng-model='searchchkbx']")
	WebElement inputFeeGroupSearch;

	// @FindBy(xpath = "//span[contains(text(),'Susdiny Fee Group')]")
	// WebElement chkFeeGroup;

	@FindBy(xpath = "(//input[@name='Grpoption'])[1]")
	WebElement chkFeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Fee Group')]/preceding-sibling::input")
	WebElement chkboxSelectionFeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//input[@ng-model='search']")
	WebElement inputSearch;

	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Custom_Fee_Group(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to custom fee group
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_Custom_FeeGroup() throws Exception {

		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnCustomFeeGr);
		log("Clicked on Custom fee group Button and object is:-" + btnCustomFeeGr.toString());

	}

	/**
	 * Validation of custom fee group screen message
	 * 
	 * @return
	 */
	public boolean verifyCustomFeeGroupPage() {
		try {
			System.out.println(txtCustomFeeGrMsgDispaly.getText());
			txtCustomFeeGrMsgDispaly.isDisplayed();
			log("Custom Fee Group page is dispalyed and object is:-" + txtCustomFeeGrMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter the input for custom fee group creation
	 * 
	 * @param customFeeGrName
	 * @param feeGroupCode
	 * @param Feegroup
	 * @throws Exception
	 */
	public void enterCustomFeeGrNameGroupCodeAndSelectFeeGroup(String customFeeGrName, String feeGroupCode,
			String Feegroup) throws Exception {

		inputTextIntoInputField(inputFeeGroupName, customFeeGrName);
		log("Entered custom fee group name: " + customFeeGrName + " and object is:-" + inputFeeGroupName.toString());

		inputTextIntoInputField(inputFeeGroupCode, feeGroupCode);
		log("Entered fee group code: " + feeGroupCode + " and object is:-" + inputFeeGroupCode.toString());

		inputTextIntoInputField(inputFeeGroupSearch, Feegroup);
		log("Entered fee group for search " + Feegroup + " and object is:-" + inputFeeGroupSearch.toString());
		// try {
		// isDisplayed(chkFeeGroup);
		// String feeGroupselection = chkFeeGroup.getText().trim();
		// Assert.assertEquals(feeGroupselection, Feegroup);
		// } catch (Exception e) {
		// e.printStackTrace();
		// log("Fee group for selection is not matched");
		// }
		isDisplayed(chkFeeGroup);
		try {
			if (!chkFeeGroup.isSelected()) {

				chkFeeGroup.click();
				log("Fee group check box is selected for the specific group and object is:-" + chkFeeGroup.toString());
			} else {
				log("Check box is already selected and object is:-" + chkFeeGroup.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void clickOnSaveButton_Blank() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button to submit blank form and object is:-" + btnSave.toString());
		Thread.sleep(1000);

	}

	/**
	 * Click on save button to save the custom fee group input value
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(2000);

	}

	/**
	 * validation of Record saved successfully message
	 * 
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
	 * click on OK button after Saving the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);

	}

	/**
	 * Search with the created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void searchByGroupNameInGrid(String customGroupName) throws Exception {

		inputTextIntoInputField(inputSearch, customGroupName);
		log("Entered Class category name:" + customGroupName + " and object is:-" + inputSearch.toString());

	}

	/**
	 * verify for the created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void verifyCustomGroupupdatedInGrid(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customGroup = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println(customGroup);
				Thread.sleep(2000);
				if (customGroup.equals(customGroupName)) {
					Assert.assertEquals(customGroup, customGroupName);
					log("Custom group name is update in the grid:" + customGroup);
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit custom group name created
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void edit_CustomFeeGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customgroup = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println(customgroup);
				Thread.sleep(2000);
				if (customgroup.equals(customGroupName)) {
					Assert.assertEquals(customgroup, customGroupName);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/a"))
							.click();
					log("Clicked on edit link for corresponding group name in grid");
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deactivation of created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void deactivationOfCreatedCustomGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customgroup = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println(customgroup);
				Thread.sleep(2000);
				if (customgroup.equals(customGroupName)) {
					Assert.assertEquals(customgroup, customGroupName);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"))
							.click();
					log("Clicked on deactivation link in custom group grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Confirmation message validation for deactivation
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}

	public void confirmationForDeactivation_Cancel() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked Cancel button to cancel deactivation of record and object is:" + btnPopUpCancel.toString());
		Thread.sleep(1000);
	}

	/**
	 * Activation of created custom group
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void activationOfCreatedCustomGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customgroup = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println(customgroup);
				Thread.sleep(2000);
				if (customgroup.equals(customGroupName)) {
					Assert.assertEquals(customgroup, customGroupName);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"))
							.click();
					log("Clicked on activation link in Custom group name grid");
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Activation confirmation pop up validation
	 * 
	 * @throws Exception
	 */
	public void confirmationForActivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);

	}

	public void confirmationForActivation_Cancel() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked Cancel button to cancel activation and object is:" + btnPopUpCancel.toString());
		Thread.sleep(1000);

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
