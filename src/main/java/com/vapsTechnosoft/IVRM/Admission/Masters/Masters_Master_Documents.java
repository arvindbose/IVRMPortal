/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

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
public class Masters_Master_Documents extends TestBase{

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[13]")
	WebElement btnMasters_masterDocument;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterDocumentMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
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

	public Masters_Master_Documents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(7000);
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
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterDocument);

		btnMasters_masterDocument.click();
		log("Clicked on master document Button and object is:-" + btnMasters_masterDocument.toString());
		waitForElement(driver, 10, btnSave);
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
	
	public void enterMasterDocumentData(String documentName, String documentDescription) {

		input_DocumentName.clear();
		input_DocumentName.sendKeys(documentName);
		log("Entered document name " + documentName + " and object is:-" + input_DocumentName.toString());

		input_DocumentDescription.clear();
		input_DocumentDescription.sendKeys(documentDescription);
		log("Entered document discription " + documentDescription + " and object is:-"
				+ input_DocumentDescription.toString());
		
		if (!chkMandatoryDoc.isSelected()) {
			chkMandatoryDoc.click();
			log("Selected document as mandatory check box and object is:-" + chkMandatoryDoc.toString());
		} else {
			log("Mandatory document check box is already selected and object is:-" + chkMandatoryDoc.toString());

		}

	}
	
	public void submitBlankMasterDocumentForm() throws Exception {

		btnSave.click();
		log("Submit blank master Document form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}


	public void clearDocumentInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on cancel button to clear filled Document info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveDocumentInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Document info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeMasterDocument() throws Exception {
		btnMin_MaxMasterDocument.click();
		log("clicked on master Document minimize button and object is:-" + btnMin_MaxMasterDocument.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterDocument() throws Exception {
		btnMin_MaxMasterDocument.click();
		log("clicked on master Document maximize button and object is:-" + btnMin_MaxMasterDocument.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterDocumentList() throws Exception {

		btnMin_MaxMasterDocumentsList.click();
		log("Master Document list table data minimize and object is:-" + btnMin_MaxMasterDocumentsList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterDocumentList() throws Exception {

		btnMin_MaxMasterDocumentsList.click();
		log("Master Document list table table data maximized and object is:-" + btnMin_MaxMasterDocumentsList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByDocumentName() throws Exception {
		btnSortByDocumentName.click();
		log("Sorted the record with Document name and object is:-" + btnSortByDocumentName.toString());
		Thread.sleep(3000);
	}

	public void searchWithDocumentNameInTheGrid(String documentName) {

		inputSearch.clear();
		inputSearch.sendKeys(documentName);
		log("Entered Document name to search: " + documentName + " and object is:-" + inputSearch.toString());
	}

	public void verifyDocumentNameInTheGrid(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String documentname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Document Name: " + documentname);
			// Thread.sleep(2000);
			
			try {
				
				Assert.assertEquals(documentname, documentName);
				log("Document name created is updated in the record grid.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void editMasterDocument(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String documentname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Document Name: " + documentname);
			// Thread.sleep(2000);
			try {
				if (documentname.equalsIgnoreCase(documentName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master document list grid to edit record");

					break;
				} else {
					log("Document Name not matched with the master document list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void deleteMasterDocument(String documentName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String documentname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Document Name: " + documentname);
			// Thread.sleep(2000);
			try {
				if (documentname.equalsIgnoreCase(documentName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the master document list grid to delete record");

					break;
				} else {
					log("Document Name not matched with the master document list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}

	public void clickOnCancelButton() throws Exception {

		btnCancel.click();
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}
	
}
