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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[11]")
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

	public Masters_Master_Reference(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterReference_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterReference);

		btnMasters_masterReference.click();
		log("Clicked on master reference Button and object is:-" + btnMasters_masterReference.toString());
		waitForElement(driver, 10, btnSave);
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

		input_ReferenceName.clear();
		input_ReferenceName.sendKeys(referenceName);
		log("Entered Reference name " + referenceName + " and object is:-" + input_ReferenceName.toString());

		input_ReferenceDescription.clear();
		input_ReferenceDescription.sendKeys(referenceDescription);
		log("Entered Reference discription " + referenceDescription + " and object is:-"
				+ input_ReferenceDescription.toString());

	}
	public void submitBlankMasterReferenceForm() throws Exception {

		btnSave.click();
		log("Submit blank master reference form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}


	public void clearReferenceInfoData() throws Exception {
		btnClear.click();
		log("Clicked on clear button to clear filled reference info and object is:-" + btnClear.toString());
		Thread.sleep(15000);
	}

	public void saveReferenceInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled reference info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeMasterReference() throws Exception {
		btnMin_MaxMasterReference.click();
		log("clicked on master reference minimize button and object is:-" + btnMin_MaxMasterReference.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterReference() throws Exception {
		btnMin_MaxMasterReference.click();
		log("clicked on master Reference maximize button and object is:-" + btnMin_MaxMasterReference.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterReferenceList() throws Exception {

		btnMin_MaxMasterReferenceList.click();
		log("Master reference list table data minimize and object is:-" + btnMin_MaxMasterReferenceList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterReferenceList() throws Exception {

		btnMin_MaxMasterReferenceList.click();
		log("Master reference list table table data maximized and object is:-" + btnMin_MaxMasterReferenceList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByReferenceName() throws Exception {
		btnSortByReferenceName.click();
		log("Sorted the record with Reference name and object is:-" + btnSortByReferenceName.toString());
		Thread.sleep(3000);
	}

	public void searchWithReferenceNameInTheGrid(String referenceName) {

		inputSearch.clear();
		inputSearch.sendKeys(referenceName);
		log("Entered reference name to search: " + referenceName + " and object is:-" + inputSearch.toString());
	}

	public void verifyReferenceNameInTheGrid(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String referencename = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Reference Name: " + referencename);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(referencename, referenceName);
				log("Reference name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void editMasterReference(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String referencename = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Reference Name: " + referencename);
			// Thread.sleep(2000);
			try {
				if (referencename.equalsIgnoreCase(referenceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master reference list grid to edit record");

					break;
				} else {
					log("Reference Name not matched with the master reference list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void deleteMasterReference(String referenceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String referencename = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Reference Name: " + referencename);
			// Thread.sleep(2000);
			try {
				if (referencename.equalsIgnoreCase(referenceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the master reference list grid to delete record");

					break;
				} else {
					log("Reference Name not matched with the master reference list grid");
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
