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
 * @author Arvind
 *
 *         "Fee Module - Custom Fee Special Head"
 * 
 *         TC_F1_263,TC_F1_265,TC_F1_267,TC_F1_268
 * 
 */
public class Masters_Custom_Fee_Special_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Custom_Fee_Special_Head.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[5]")
	// WebElement btnCustomFeeSpecialHead;

	@FindBy(xpath = "//a[@href='#/app/SpecialFeeHead/85']")
	WebElement btnCustomFeeSpecialHead;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtCustomFeeSpecialHeadMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Special Fee Head Name :')]/following-sibling::div/input")
	WebElement input_SplFeeHeadName;

	@FindBy(xpath = "//label[contains(text(),'Fee Head :')]/following-sibling::div/input")
	WebElement input_FeeHeadSearch;

	// @FindBy(xpath = "//span[contains(text(),'Annual Fees')]")
	// WebElement chk_FeeHeadText;

	@FindBy(xpath = "(//input[@name='clsse'])[1]")
	WebElement chk_FeeHead;

	// @FindBy(xpath = "//span[contains(text(),'Annual
	// Fees')]/preceding-sibling::input")
	// WebElement chk_boxSelectionFeeHead;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//div[@class='input-group']/span/following-sibling::input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btn_OkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_Max_SpecialFeeHead;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_Max_SpecialHeadGridView;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[4]/a")
	WebElement btnSortBy_FeeHead;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Custom_Fee_Special_Head(WebDriver driver) {
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
	 * Navigate to custom special fee head
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_Custom_Special_FeeHead() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnCustomFeeSpecialHead);
		log("Clicked on Custom Fee Special Head Button and object is:-" + btnCustomFeeSpecialHead.toString());

	}

	/**
	 * Validation of custom special fee head screen message
	 * 
	 * @return
	 */
	public boolean verifyCustomSpecialFeeHeadPage() {
		try {
			System.out.println(txtCustomFeeSpecialHeadMsgDispaly.getText());
			txtCustomFeeSpecialHeadMsgDispaly.isDisplayed();
			log("Custom Special Fee Head page is dispalyed and object is:-"
					+ txtCustomFeeSpecialHeadMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter Special fee head name and select Fee head
	 * 
	 * @param specialFeeHead
	 * @param feehead
	 * @throws Exception
	 */

	public void fill_CustomSpecialFeeHeadForm(String specialFeeHead, String feehead) throws Exception {

		inputTextIntoInputField(input_SplFeeHeadName, specialFeeHead);
		log("Entered special fee head name:" + specialFeeHead + " and object is:-" + input_SplFeeHeadName.toString());

		inputTextIntoInputField(input_FeeHeadSearch, feehead);
		log("Entered fee head for search " + feehead + " and object is:-" + input_FeeHeadSearch.toString());

		isDisplayed(chk_FeeHead);
		try {
			if (!chk_FeeHead.isSelected()) {
				chk_FeeHead.click();
				log("Fee head check box is selected for the specific group");
			} else {
				log("Fee head Check box is already selected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCancelButton_ClearFilledForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("clicked on cancel button and object is:-" + btn_Cancel.toString());

	}

	/**
	 * Click on save button to save the custom special fee head input value
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton() throws Exception {

		clickOnButton(btn_Save);
		log("clicked on save button and object is:-" + btn_Save.toString());
		Thread.sleep(1000);

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

		clickOnButton(btn_OkonSuccess);
		log("clicked on OK button and object is:-" + btn_OkonSuccess.toString());
		Thread.sleep(1000);
	}

	/**
	 * Search with the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void searchBySpLFeeHeadNameInGrid(String specialfeehead) throws Exception {

		inputTextIntoInputField(input_Search, specialfeehead);
		log("Entered custom special fee head name:" + specialfeehead + " and object is:-" + input_Search.toString());
	}

	/**
	 * verify for the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void verifyCustomSPLFeeHeadupdatedInGrid(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customSPLFeeHead = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
				Thread.sleep(2000);
				if (customSPLFeeHead.equals(specialFeeHead)) {
					Assert.assertEquals(customSPLFeeHead, specialFeeHead);
					log("Custom speceal fee head name is update in the grid:" + customSPLFeeHead);
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			log("Custom Special fee head is not updated in the grid.");
		}
	}

	/**
	 * Edit custom Special fee head name created
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void edit_CustomSplFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customSPLFeeHead = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();

				Thread.sleep(2000);
				if (customSPLFeeHead.equals(specialFeeHead)) {
					Assert.assertEquals(customSPLFeeHead, specialFeeHead);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/a"))
							.click();
					log("Clicked on edit link for corresponding special Fee Head name in grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			log("Edit link is not clicked for editing of custom special fee head");
			Thread.sleep(500);
		}
	}

	/**
	 * Deactivation of created custom special Fee Head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void deactivationOfCreatedCustomSPLFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customSPLFeeHead = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				Thread.sleep(2000);
				if (customSPLFeeHead.equals(specialFeeHead)) {
					Assert.assertEquals(customSPLFeeHead, specialFeeHead);
					WebElement deactiveLink = driver
							.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					log("Clicked on deactivation link in custom special Fee Head grid");

					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			log("Deactivation link is not available for the custom special fee head");
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

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());

	}

	/**
	 * Activation of created custom group
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void activationOfCreatedCustomSPLFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String customSPLFeeHead = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
				Thread.sleep(2000);
				if (customSPLFeeHead.equals(specialFeeHead)) {
					Assert.assertEquals(customSPLFeeHead, specialFeeHead);
					WebElement activeLink = driver
							.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"));
					String activatext = activeLink.getText().trim();
					Assert.assertEquals(activatext, "Activate");
					activeLink.click();
					log("Clicked on activation link in Custom special Fee Head name grid");
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			log("Activation link is not available in the custom special fee head");
		}
	}

	public void minimizeAndMaximize_SpecialFeeHead() throws Exception {

		clickOnButton(btnMin_Max_SpecialFeeHead);
		log("clicked on Special Fee Head minimize and maximize button and object is:-"
				+ btnMin_Max_SpecialFeeHead.toString());

	}

	public void minimizeAndMaximize_SpecialHeadGridView() throws Exception {

		clickOnButton(btnMin_Max_SpecialHeadGridView);
		log("Special Head grid table data minimize and maximize and object is:-"
				+ btnMin_Max_SpecialHeadGridView.toString());

	}

	public void sortByFeeHead() throws Exception {

		clickOnButton(btnSortBy_FeeHead);
		log("Sorted the record with Fee Head and object is:-" + btnSortBy_FeeHead.toString());

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
