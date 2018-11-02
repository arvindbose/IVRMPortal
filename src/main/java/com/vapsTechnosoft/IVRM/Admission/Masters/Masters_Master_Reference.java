/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

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
public class Masters_Master_Reference extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Reference.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[11]")
	// WebElement btnMasters_masterReference;

	@FindBy(xpath = "//a[@href='#/app/masterreference/22']")
	WebElement btnMasters_masterReference;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterReferenceMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_ReferenceName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_ReferenceDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByReferenceName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterReference;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterReferenceList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Reference(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterReference_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterReference);
		log("Clicked on master reference Button and object is:-" + btnMasters_masterReference.toString());

	}

	/**
	 * Validation of masters master source screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterReference_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterReferenceMsgDispaly.getText());
			txtMasters_MasterReferenceMsgDispaly.isDisplayed();
			log("Master Reference page is dispalyed and object is:-" + txtMasters_MasterReferenceMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterReferenceDetailsData(String referenceName, String referenceDescription) {

		inputTextIntoInputField(input_ReferenceName, referenceName);
		log("Entered Reference name " + referenceName + " and object is:-" + input_ReferenceName.toString());

		inputTextIntoInputField(input_ReferenceDescription, referenceDescription);
		log("Entered Reference discription " + referenceDescription + " and object is:-"
				+ input_ReferenceDescription.toString());

	}

	public void submitBlankMasterReferenceForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master reference form and object is:-" + btnSave.toString());

	}

	public void clearReferenceInfoData() throws Exception {

		clickOnButton(btnClear);
		log("Clicked on clear button to clear filled reference info and object is:-" + btnClear.toString());

	}

	public void saveReferenceInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled reference info and object is:-" + btnSave.toString());

	}

	public void minimizeMasterReference() throws Exception {

		clickOnButton(btnMin_MaxMasterReference);
		log("clicked on master reference minimize button and object is:-" + btnMin_MaxMasterReference.toString());

	}

	public void maximizeMasterReference() throws Exception {

		clickOnButton(btnMin_MaxMasterReference);
		log("clicked on master Reference maximize button and object is:-" + btnMin_MaxMasterReference.toString());

	}

	public void minimizeMasterReferenceList() throws Exception {

		clickOnButton(btnMin_MaxMasterReferenceList);
		log("Master reference list table data minimize and object is:-" + btnMin_MaxMasterReferenceList.toString());

	}

	public void maximizeMasterReferenceList() throws Exception {

		clickOnButton(btnMin_MaxMasterReferenceList);
		log("Master reference list table table data maximized and object is:-"
				+ btnMin_MaxMasterReferenceList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByReferenceName() throws Exception {
		btnSortByReferenceName.click();
		clickOnButton(btnSortByReferenceName);
		log("Sorted the record with Reference name and object is:-" + btnSortByReferenceName.toString());

	}

	public void searchWithReferenceNameInTheGrid(String referenceName) {

		inputTextIntoInputField(inputSearch, referenceName);
		log("Entered reference name to search: " + referenceName + " and object is:-" + inputSearch.toString());
	}

	public void verifyReferenceNameInTheGrid(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String referencename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Reference Name: " + referencename);
				// Thread.sleep(2000);
				if (referencename.equals(referenceName)) {
					Assert.assertEquals(referencename, referenceName);
					log("Reference name created is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editMasterReference(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String referencename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Reference Name: " + referencename);
				// Thread.sleep(2000);
				if (referencename.equalsIgnoreCase(referenceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the master reference list grid to edit record");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterReference(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String referencename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Reference Name: " + referencename);
				// Thread.sleep(2000);
				if (referencename.equalsIgnoreCase(referenceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the master reference list grid to delete record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

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
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_DeletedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
