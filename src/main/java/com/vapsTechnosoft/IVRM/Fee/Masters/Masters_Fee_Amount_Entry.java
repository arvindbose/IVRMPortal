/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Amount_Entry extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Amount_Entry.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	private WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[1]")
	// private WebElement btnFeeAmtEntry;

	@FindBy(xpath = "//a[@href='#/app/FeeAmountEntry/87']")
	private WebElement btnFeeAmtEntry;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	private WebElement txtFeeAmtEntryMsgDispaly;

	@FindBy(xpath = "//input[@value='stud']")
	private WebElement rdBtn_Student;

	@FindBy(xpath = "//input[@value='stfoth']")
	private WebElement rdBtn_Staff;

	@FindBy(xpath = "//input[@value='stfothamt']")
	private WebElement rdBtn_Others;

	@FindBy(xpath = "//label[text()='Academic Year:']/following-sibling::div/select")
	private WebElement selAcademicYr;

	@FindBy(xpath = "//label[text()='Category:']/following-sibling::div/select")
	private WebElement selCategory;

	@FindBy(xpath = "//label[text()='Fee Group:']/following-sibling::div/select")
	private WebElement selFeeGroup;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[1]/tbody/tr")
	private List<WebElement> tblRows;

	@FindBy(xpath = "(//body[@id='style-4']//div/label/input)[4]")
	private WebElement chkRegular;

	@FindBy(xpath = "(//body[@id='style-4']//div/label/input)[5]")
	private WebElement chkECS;

	@FindBy(xpath = "//div[@id='myModal']/div/div/div[3]/button")
	private WebElement btnAddToCart;

	@FindBy(xpath = "//div[@id='myModal']//div/table/tbody/tr")
	private List<WebElement> tblFeeSlabRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	private WebElement successfulMessage;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']//div/input")
	private WebElement inputSearch;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnPopUpYesDeleteit;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnPopUpCancel;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	private List<WebElement> tblAmtGridRows;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	@FindBy(xpath = "//span[contains(text(),'ECS Flag')]/preceding-sibling::input")
	private WebElement chkECSFlag;

	public Masters_Fee_Amount_Entry(WebDriver driver) {
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
	 * Navigate to Fee Amount Entry 1. Click on Fee Tab 2. Click on Fee sub-tab
	 * Masters 3. click on Masters sub tab Fee Amount Entry
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_FeeAmountEntry() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeAmtEntry);
		log("Clicked on Fee Amount Entry Button and object is:-" + btnFeeAmtEntry.toString());

	}

	/**
	 * Validation of Fee Amount Entry page is displayed
	 * 
	 * @return
	 */

	public boolean verifyFeeAmountEntryPage() {
		try {
			System.out.println(txtFeeAmtEntryMsgDispaly.getText());
			txtFeeAmtEntryMsgDispaly.isDisplayed();
			log("Fee Amount Entry page is dispalyed and object is:-" + txtFeeAmtEntryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fee amount entry page Academic year, Category and Fee group selection
	 * 
	 * @param academicYear
	 * @param category
	 * @param feeGroup
	 * @throws Exception
	 */
	public void selectAcademicYrCategoryAndFeeGroup(String academicYear, String category, String feeGroup)
			throws Exception {

		isDisplayed(rdBtn_Student);
		if (!rdBtn_Student.isSelected()) {
			rdBtn_Student.click();
			log("Student radio button is selected and object is:-" + rdBtn_Student.toString());
			Thread.sleep(1000);
		} else {
			log("Student radio button is already selected and object is:-" + rdBtn_Student.toString());
			Thread.sleep(1000);
		}

		selectElementFromDropDown(selAcademicYr, academicYear);
		log("selected academic year:-" + academicYear + " and object is " + selAcademicYr.toString());

		selectElementFromDropDown(selCategory, category);
		log("selected category:-" + category + " and object is " + selCategory.toString());

		selectElementFromDropDown(selFeeGroup, feeGroup);
		log("selected fee group:-" + feeGroup + " and object is " + selFeeGroup.toString());

	}

	public void amountEntrytabledata(String installment, String amount, String dueMonth, String dueDate)
			throws Exception {

		int rows = tblRows.size();
		System.out.println("Number of rows " + rows);
		for (int i = 1; i <= rows; i++) {
			WebElement txtInstallment = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[4]"));
			String installName = txtInstallment.getText();
			System.out.println("Installment Name: " + installName);
			Thread.sleep(1000);
			if (installName.equalsIgnoreCase(installment)) {
				Assert.assertEquals(installName, installment);

				log("Installment Name is available in the amount entry table" + installName.toString());
				Thread.sleep(1000);

				WebElement amtentry = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[6]/input"));
				amtentry.clear();
				amtentry.sendKeys(amount);
				;
				log("Amount entered in the input field.");
				Thread.sleep(500);

				WebElement selDueMonth = driver.findElement(
						By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[7]/select"));
				select = new Select(selDueMonth);
				select.selectByVisibleText(dueMonth);
				log("selected due month:-" + dueMonth + " and object is " + selDueMonth.toString());
				Thread.sleep(500);
				WebElement inputDueDate = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[8]/input"));
				inputDueDate.clear();
				inputDueDate.sendKeys(dueDate);
				;
				log("Due date entered in the input field.");
				Thread.sleep(1000);
				WebElement chkFineSlab = driver.findElement(
						By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[9]/label/input"));

				if (!chkFineSlab.isSelected()) {
					chkFineSlab.click();
					log("select the check box for fine slab");
					Thread.sleep(2000);
				} else {
					log("Fine slab check box is already selected.");
				}
			}
		}
	}

	public void feeSlabDetailsPopUpTable(String serialNo, String Per_Day, String fine_amount) throws Exception {

		if (!chkRegular.isSelected()) {
			chkRegular.click();
			log("Regular check box is checked and object is:-" + chkRegular.toString());
			Thread.sleep(1000);
		} else {
			log("Regular check box is already checked.");
		}

		int row = tblFeeSlabRows.size();
		System.out.println("Number of rows: " + row);
		for (int j = 1; j <= row; j++) {
			String serialNum = driver.findElement(By.xpath("//div[@id='myModal']//div/table/tbody/tr[" + j + "]/td[1]"))
					.getText();
			System.out.println("Serial Number: " + serialNum);
			Thread.sleep(1000);
			if (serialNum.equalsIgnoreCase(serialNo)) {
				Assert.assertEquals(serialNum, serialNo);

				log("Serial number matched with the table serial num");
				Thread.sleep(1000);

				WebElement checkbox = driver
						.findElement(By.xpath("//div[@id='myModal']//div/table/tbody/tr[" + j + "]/td[2]/label"));

				if (!checkbox.isSelected()) {

					checkbox.click();
					log("Check box is selected corresponding slab name and object is:-" + checkbox.toString());
					Thread.sleep(1000);

				} else {
					log("check box is already selected.");
				}

				WebElement selFineType = driver
						.findElement(By.xpath("//div[@id='myModal']//div/table/tbody/tr[" + j + "]/td[6]/select"));

				selectElementFromDropDown(selFineType, Per_Day);
				log("selected fine type :-" + Per_Day + " and object is " + selFineType.toString());
				Thread.sleep(1000);

				WebElement amtFine = driver
						.findElement(By.xpath("//div[@id='myModal']//div/table/tbody/tr[" + j + "]/td[7]/input"));

				inputTextIntoInputField(amtFine, fine_amount);
				log("Fine amount entered " + fine_amount + " and object is:-" + amtFine.toString());
				Thread.sleep(1000);
				break;
			}

		}
	}

	public void clickOnAddToCartButton() throws Exception {

		clickOnButton(btnAddToCart);
		log("Clicked on Add to Cart button and object is:-" + btnAddToCart);

	}

	public void clickOn_AddToCart_SuccessOkBtn() throws Exception {
		String Expected_confirmationMsg = "Selected Fine Slab is added successfully";

		Assert.assertEquals(successfulMessage.getText(), Expected_confirmationMsg);
		log("Successful message is verified.");

		clickOnButton(btnOkonSuccess);
		log("clicked on add to cart success OK button and object is:-" + btnOkonSuccess.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());

	}

	public void searchWithInstallmentName(String InstallmentName) throws Exception {

		inputTextIntoInputField(inputSearch, InstallmentName);
		log("Entered installment name for search and object is:-" + inputSearch.toString());

	}

	public void deleteRecordsFromAmountEntryGrid(String InstallmentName) throws Exception {
		int rows = tblAmtGridRows.size();
		System.out.println(rows);
		try {
			for (int i = 1; i <= rows; i++) {

				String installMent = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[4]"))
						.getText();
				System.out.println(installMent);
				Thread.sleep(1000);
				if (installMent.equals(InstallmentName)) {
					Assert.assertEquals(installMent, InstallmentName);
					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[6]/a"))
							.click();
					log("Clicked on delete link for corresponding Installment in grid");

					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void recordDeleteConfirmation() throws Exception {

		clickOnButton(btnPopUpYesDeleteit);
		log("Clicked on yes delete is button for record delete confirmation and object is:-"
				+ btnPopUpYesDeleteit.toString());

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());

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

	public void popUpWindowMessage_DeleteCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deletion Cancelled");
			log("Record deleted Cancel message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeletedSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
