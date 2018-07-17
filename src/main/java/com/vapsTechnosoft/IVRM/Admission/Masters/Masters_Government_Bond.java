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
public class Masters_Government_Bond extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Government_Bond.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[23]")
	WebElement btnMasters_GovernmentBond;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_GovernmentBondMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_BondName;

	@FindBy(xpath = "//textarea[@name='gbdescription']")
	WebElement input_BondDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByBondName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterGovtBond;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxGovtBondList;

	public Masters_Government_Bond(WebDriver driver) {
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
	 * Navigate to Admission Masters Government Bond
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_GovernmentBond_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_GovernmentBond);

		btnMasters_GovernmentBond.click();
		log("Clicked on Government Bond Button and object is:-" + btnMasters_GovernmentBond.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters Government Bond screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_GovernmentBond_BGHSPage() {
		try {
			System.out.println(txtMasters_GovernmentBondMsgDispaly.getText());
			txtMasters_GovernmentBondMsgDispaly.isDisplayed();
			log("Government Bond page is dispalyed and object is:-" + txtMasters_GovernmentBondMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterGovernmentBondDetailsData(String bondName, String bondDescription) {

		input_BondName.clear();
		input_BondName.sendKeys(bondName);
		log("Entered bond name " + bondName + " and object is:-" + input_BondName.toString());

		input_BondDescription.clear();
		input_BondDescription.sendKeys(bondDescription);
		log("Entered Bond description " + bondDescription + " and object is:-" + input_BondDescription.toString());

	}

	public void submitBlankGovernmentBondForm() throws Exception {

		btnSave.click();
		log("Submit blank Government Bond form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void clearGovernmentBondInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Government Bond info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveGovernmentBondInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Government Bond info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void searchWithGovernmentBondNameInTheGrid(String bondName) {

		inputSearch.clear();
		inputSearch.sendKeys(bondName);
		log("Entered bond name to search: " + bondName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterGovernmentBond() throws Exception {
		btnMin_MaxMasterGovtBond.click();
		log("clicked on Government Bond minimize button and object is:-" + btnMin_MaxMasterGovtBond.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterGovernmentBond() throws Exception {
		btnMin_MaxMasterGovtBond.click();
		log("clicked on Government Bond maximize button and object is:-" + btnMin_MaxMasterGovtBond.toString());
		Thread.sleep(2000);
	}

	public void minimizeGovernmentBondList() throws Exception {

		btnMin_MaxGovtBondList.click();
		log("Government Bond list table data minimize and object is:-" + btnMin_MaxGovtBondList.toString());
		Thread.sleep(2000);
	}

	public void maximizeGovernmentBondList() throws Exception {

		btnMin_MaxGovtBondList.click();
		log("Government Bond list table data maximized and object is:-" + btnMin_MaxGovtBondList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByBondName() throws Exception {
		btnSortByBondName.click();
		log("Sorted the record with bond name and object is:-" + btnSortByBondName.toString());
		Thread.sleep(3000);
	}

	public void editGovernmentBond(String bondName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String bondname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Bond Name: " + bondname);
			// Thread.sleep(2000);
			try {
				if (bondname.equalsIgnoreCase(bondName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the Government Bondlist grid to edit record");

					break;
				} else {
					log("Bond Name not matched with the Government Bond list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteGovernmentBond(String bondName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String bondname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Bond Name: " + bondname);
			// Thread.sleep(2000);
			try {
				if (bondname.equalsIgnoreCase(bondName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the Government Bond list grid to delete record");

					break;
				} else {
					log("Bond Name not matched with the Government Bond list grid");
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

	public void verifyBondNameInTheGrid(String bondName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String bondname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Bond Name: " + bondname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(bondname, bondName);
				log("Bond name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
