/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

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

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Caste extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Caste.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[2]")
	WebElement btnMasters_MasterCaste;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterCasteMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_CasteName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_CasteDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByCasteName;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[1]")
	WebElement sel_Castecategory;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterCaste;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxCreatedCasteList;

	public Masters_Master_Caste(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Caste
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterCaste_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_MasterCaste);

		btnMasters_MasterCaste.click();
		log("Clicked on Master Caste Button and object is:-" + btnMasters_MasterCaste.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters Master Caste screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterCaste_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterCasteMsgDispaly.getText());
			txtMasters_MasterCasteMsgDispaly.isDisplayed();
			log("Master Caste Category page is dispalyed and object is:-"
					+ txtMasters_MasterCasteMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterCasteDetailsData(String casteName, String casteDescription, String casteCategory)
			throws Exception {

		input_CasteName.clear();
		input_CasteName.sendKeys(casteName);
		log("Entered caste name " + casteName + " and object is:-" + input_CasteName.toString());

		input_CasteDescription.clear();
		input_CasteDescription.sendKeys(casteDescription);
		log("Entered caste description " + casteDescription + " and object is:-" + input_CasteDescription.toString());

		select = new Select(sel_Castecategory);
		select.selectByVisibleText(casteCategory);
		log("selected caste category " + casteCategory + " and object is:- " + sel_Castecategory.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), casteCategory);
		Thread.sleep(1000);

	}

	public void submitBlankMasterCasteForm() throws Exception {

		btnSave.click();
		log("Submit blank master caste form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void clearMasterCasteInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled master Caste info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveMasterCasteInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Master Caste info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void searchWithCasteNameInTheGrid(String casteName) {

		inputSearch.clear();
		inputSearch.sendKeys(casteName);
		log("Enterd Caste name to search: " + casteName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterCaste() throws Exception {
		btnMin_MaxMasterCaste.click();
		log("clicked on master Caste minimize button and object is:-" + btnMin_MaxMasterCaste.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterCaste() throws Exception {
		btnMin_MaxMasterCaste.click();
		log("clicked on master Caste maximize button and object is:-" + btnMin_MaxMasterCaste.toString());
		Thread.sleep(2000);
	}

	public void minimizeCreatedCasteList() throws Exception {

		btnMin_MaxCreatedCasteList.click();
		log("Master Created Caste list table data minimize and object is:-" + btnMin_MaxCreatedCasteList.toString());
		Thread.sleep(2000);
	}

	public void maximizeCreatedCasteList() throws Exception {

		btnMin_MaxCreatedCasteList.click();
		log("Master Created Caste list table data maximized and object is:-" + btnMin_MaxCreatedCasteList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByCasteName() throws Exception {
		btnSortByCasteName.click();
		log("Sorted the record with Caste name and object is:-" + btnSortByCasteName.toString());
		Thread.sleep(3000);
	}

	public void editMasterCaste(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castename = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Caste Name: " + castename);
			// Thread.sleep(2000);
			try {
				if (castename.equalsIgnoreCase(casteName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the created Caste list grid to edit record");

					break;
				} else {
					log("Caste Name not matched with the Created Caste list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteMasterCaste(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castename = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Caste Category Name: " + castename);
			// Thread.sleep(2000);
			try {
				if (castename.equalsIgnoreCase(casteName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the Created Caste list grid to delete record");

					break;
				} else {
					log("Caste Name not matched with the created Caste list grid");
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

	public void verifyCasteNameInTheGrid(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castename = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Caste Category Name: " + castename);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(castename, casteName);
				log("Caste name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
