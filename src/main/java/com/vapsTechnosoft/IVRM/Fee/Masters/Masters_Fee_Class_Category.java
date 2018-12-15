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
public class Masters_Fee_Class_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Class_Category.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[7]")
	// WebElement btnFeeClassCategory;

	@FindBy(xpath = "//a[@href='#/app/FeeClassCategory/83']")
	WebElement btnFeeClassCategory;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeClassCategoryMsgDispaly;

	@FindBy(xpath = "//input[@name='name123']")
	WebElement input_ClassCategoryName;

	@FindBy(xpath = "//input[@name='ccde']")
	WebElement input_ClassCategoryCode;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//input[@ng-model='search']")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	@FindBy(xpath = "//table/thead/tr/th[2]/a[text()='Category Name']")
	WebElement sort_CategoryName;

	@FindBy(xpath = "(//table/tbody)[1]/tr/td[2]")
	List<WebElement> list_CategoryName;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxClassCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxFeeClassCategoryGridView;

	public Masters_Fee_Class_Category(WebDriver driver) {
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

	public void nevigateToMasters_Fee_ClassCategory() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeClassCategory);
		log("Clicked on Fee class category Button and object is:-" + btnFeeClassCategory.toString());

	}

	public boolean verifyFeeClassCategoryPage() {
		try {
			System.out.println(txtFeeClassCategoryMsgDispaly.getText());
			txtFeeClassCategoryMsgDispaly.isDisplayed();
			log("Fee class category page is dispalyed and object is:-" + txtFeeClassCategoryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterClassCategoryNameAndCode(String classCategoryName, String classCategoryCode) throws Exception {

		inputTextIntoInputField(input_ClassCategoryName, classCategoryName);
		log("Entered class category name: " + classCategoryName + " and object is:-"
				+ input_ClassCategoryName.toString());

		inputTextIntoInputField(input_ClassCategoryCode, classCategoryCode);
		log("Entered class category Code: " + classCategoryCode + " and object is:-"
				+ input_ClassCategoryCode.toString());

	}

	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void clickOnCancelButton_ToClearFilledData() throws Exception {

		clickOnButton(btnCancel);
		log("clicked on Cancel button to clear filled data and object is:-" + btnCancel.toString());
		Thread.sleep(1000);
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

	public void searchByClassCategoryName(String classCtgName) throws Exception {

		inputTextIntoInputField(inputSearch, classCtgName);
		log("Entered class category name for search:" + classCtgName + " and object is:-" + inputSearch.toString());

	}

	public void verifyClassCategoryNameUpdatedInGrid(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classCategoryName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println(classCategoryName);
				Thread.sleep(500);
				if (classCategoryName.equals(classCtgName)) {
					Assert.assertEquals(classCategoryName, classCtgName);

					log("Class category name is updated in the grid:" + classCategoryName);
					Thread.sleep(500);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivationOfCreatedClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classCtgrName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(classCtgrName);
				Thread.sleep(500);
				if (classCtgrName.equals(classCtgName)) {
					Assert.assertEquals(classCtgrName, classCtgName);
					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
							.click();
					log("Clicked on deactivation link in Fee term grid");

					Thread.sleep(500);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmationForDeactivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on record Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}

	public void clickonCancel_PopUpWindow() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on record Yes Deactivate it button and object is:" + btnPopUpCancel.toString());
		Thread.sleep(1000);
	}

	public boolean verifyDeactivationSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Fee Term Deactivated Successfully message is dispalyed and object is:-"
					+ successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	// Activation
	public void activationOfCreatedClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classCategoryName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(classCategoryName);
				Thread.sleep(500);
				if (classCategoryName.equals(classCtgName)) {
					Assert.assertEquals(classCategoryName, classCtgName);
					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
							.click();
					log("Clicked on activation link in Fee class category grid");

					Thread.sleep(500);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmationForActivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}

	public boolean verifyActivationSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Class category activated Successfully message is dispalyed and object is:-"
					+ successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	// Edit

	public void editFeeClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classcategoryName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(classcategoryName);
				Thread.sleep(500);
				if (classcategoryName.equals(classCtgName)) {
					Assert.assertEquals(classcategoryName, classCtgName);
					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/a"))
							.click();
					log("Clicked on Edit link in class category grid");

					Thread.sleep(500);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifySuccessfulPopUpEdit() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record updated successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

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
			assertEquals(text, "Record Deactivation Cancelled");
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
			assertEquals(text, "Deactivated Successfully");
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
			assertEquals(text, "Record Activation Cancelled");
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
			assertEquals(text, "Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortByFeeClassCategory() throws Exception {

		clickOnButton(sort_CategoryName);
		SortData_InColumn_AscendingOrder(list_CategoryName);
		log("Sorted the record with Category name in Ascending order and object is:-" + sort_CategoryName.toString());

	}

	public void minimizeAndMaximize_FeeClassCategory() throws Exception {

		clickOnButton(btnMin_MaxClassCategory);
		log("clicked on Fee Class Category minimize and maximize button and object is:-"
				+ btnMin_MaxClassCategory.toString());
		Thread.sleep(1000);

	}

	public void minimizeAndMaximize_FeeClassCategoryGridView() throws Exception {

		clickOnButton(btnMin_MaxFeeClassCategoryGridView);
		log("Fee Class Category grid table data minimize and maximize and object is:-"
				+ btnMin_MaxFeeClassCategoryGridView.toString());
		Thread.sleep(1000);

	}

}
