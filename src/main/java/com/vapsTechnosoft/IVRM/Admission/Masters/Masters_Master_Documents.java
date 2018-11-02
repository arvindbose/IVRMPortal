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
public class Masters_Master_Documents extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Documents.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[13]")
	// WebElement btnMasters_masterDocument;

	@FindBy(xpath = "//a[@href='#/app/masterdocument/38']")
	WebElement btnMasters_masterDocument;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterDocumentMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//input[@name='name']")
	WebElement input_DocumentName;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement input_DocumentDescription;

	@FindBy(xpath = "//label[contains(text(),' Document Is Mandatory Or Not :')]/following-sibling::input")
	WebElement chkMandatoryDoc;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByDocumentName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterDocument;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterDocumentsList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Documents(WebDriver driver) {
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
	 * Navigate to Admission Masters Master document
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterDocument_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterDocument);
		log("Clicked on master document Button and object is:-" + btnMasters_masterDocument.toString());
	}

	/**
	 * Validation of masters master document screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterDocument_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterDocumentMsgDispaly.getText());
			txtMasters_MasterDocumentMsgDispaly.isDisplayed();
			log("Master document page is dispalyed and object is:-" + txtMasters_MasterDocumentMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterDocumentData(String documentName, String documentDescription) throws Exception {
		inputTextIntoInputField(input_DocumentName, documentName);
		log("Entered document name " + documentName + " and object is:-" + input_DocumentName.toString());

		inputTextIntoInputField(input_DocumentDescription, documentDescription);
		log("Entered document discription " + documentDescription + " and object is:-"
				+ input_DocumentDescription.toString());
		isDisplayed(chkMandatoryDoc);
		if (!chkMandatoryDoc.isSelected()) {
			chkMandatoryDoc.click();
			Thread.sleep(1000);
			log("Selected document as mandatory check box and object is:-" + chkMandatoryDoc.toString());
		} else {
			log("Mandatory document check box is already selected and object is:-" + chkMandatoryDoc.toString());
			Thread.sleep(500);
		}

	}

	public void submitBlankMasterDocumentForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master Document form and object is:-" + btnSave.toString());

	}

	public void clearDocumentInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on cancel button to clear filled Document info and object is:-" + btnCancelClear.toString());

	}

	public void saveDocumentInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Document info and object is:-" + btnSave.toString());

	}

	public void minimizeMasterDocument() throws Exception {

		clickOnButton(btnMin_MaxMasterDocument);
		log("clicked on master Document minimize button and object is:-" + btnMin_MaxMasterDocument.toString());

	}

	public void maximizeMasterDocument() throws Exception {

		clickOnButton(btnMin_MaxMasterDocument);
		log("clicked on master Document maximize button and object is:-" + btnMin_MaxMasterDocument.toString());

	}

	public void minimizeMasterDocumentList() throws Exception {

		clickOnButton(btnMin_MaxMasterDocumentsList);
		log("Master Document list table data minimize and object is:-" + btnMin_MaxMasterDocumentsList.toString());

	}

	public void maximizeMasterDocumentList() throws Exception {

		clickOnButton(btnMin_MaxMasterDocumentsList);
		log("Master Document list table table data maximized and object is:-"
				+ btnMin_MaxMasterDocumentsList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByDocumentName() throws Exception {

		clickOnButton(btnSortByDocumentName);
		log("Sorted the record with Document name and object is:-" + btnSortByDocumentName.toString());

	}

	public void searchWithDocumentNameInTheGrid(String documentName) throws Exception {

		inputTextIntoInputField(inputSearch, documentName);
		log("Entered Document name to search: " + documentName + " and object is:-" + inputSearch.toString());

	}

	public void verifyDocumentNameInTheGrid(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {

			try {
				String documentname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Document Name: " + documentname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				Assert.assertEquals(documentname, documentName);
				log("Document name created is updated in the record grid.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void editMasterDocument(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String documentname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Document Name: " + documentname);
				// Thread.sleep(2000);

				if (documentname.equalsIgnoreCase(documentName)) {
					Thread.sleep(1000);
					// Assert.assertEquals(documentname, documentName);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master document list grid to edit record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterDocument(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String documentname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Document Name: " + documentname);
				// Thread.sleep(2000);

				if (documentname.equalsIgnoreCase(documentName)) {
					// Thread.sleep(1000);
					// Assert.assertEquals(documentname, documentName);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the master document list grid to delete record");

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
