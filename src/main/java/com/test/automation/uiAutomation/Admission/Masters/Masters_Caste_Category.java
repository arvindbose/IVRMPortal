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
public class Masters_Caste_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Caste_Category.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[1]")
	WebElement btnMasters_CasteCategory;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_CasteCategoryMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_CasteCategoryName;

	@FindBy(xpath = "//textarea[@name='Description']")
	WebElement input_CategoryDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]")
	WebElement btnSortByCasteCategoryName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterCasteCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxCastecategoryList;

	public Masters_Caste_Category(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Caste Category
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_CasteCategory_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_CasteCategory);

		btnMasters_CasteCategory.click();
		log("Clicked on Caste Category Button and object is:-" + btnMasters_CasteCategory.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters Caste Category screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_CasteCategory_BGHSPage() {
		try {
			System.out.println(txtMasters_CasteCategoryMsgDispaly.getText());
			txtMasters_CasteCategoryMsgDispaly.isDisplayed();
			log("Master Caste Category page is dispalyed and object is:-"
					+ txtMasters_CasteCategoryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterCasteCategoryDetailsData(String casteCategoryName, String casteCategoryDescription) {

		input_CasteCategoryName.clear();
		input_CasteCategoryName.sendKeys(casteCategoryName);
		log("Entered caste category name " + casteCategoryName + " and object is:-"
				+ input_CasteCategoryName.toString());

		input_CategoryDescription.clear();
		input_CategoryDescription.sendKeys(casteCategoryDescription);
		log("Entered caste category description " + casteCategoryDescription + " and object is:-"
				+ input_CategoryDescription.toString());

	}

	public void submitBlankMasterCasteCategoryForm() throws Exception {

		btnSave.click();
		log("Submit blank master caste category form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void clearCasteCategoryInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Caste Category info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveCasteCategoryInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Caste Category info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void searchWithCasteCategoryNameInTheGrid(String casteCategoryName) {

		inputSearch.clear();
		inputSearch.sendKeys(casteCategoryName);
		log("Enterd Caste Category name to search: " + casteCategoryName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterCasteCategory() throws Exception {
		btnMin_MaxMasterCasteCategory.click();
		log("clicked on master Caste Category minimize button and object is:-"
				+ btnMin_MaxMasterCasteCategory.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterCasteCategory() throws Exception {
		btnMin_MaxMasterCasteCategory.click();
		log("clicked on master Caste Category maximize button and object is:-"
				+ btnMin_MaxMasterCasteCategory.toString());
		Thread.sleep(2000);
	}

	public void minimizeCasteCategoryList() throws Exception {

		btnMin_MaxCastecategoryList.click();
		log("Master Caste Category list table data minimize and object is:-" + btnMin_MaxCastecategoryList.toString());
		Thread.sleep(2000);
	}

	public void maximizeCasteCategoryList() throws Exception {

		btnMin_MaxCastecategoryList.click();
		log("Master Caste Category list table data maximized and object is:-" + btnMin_MaxCastecategoryList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByCasteCategoryName() throws Exception {
		btnSortByCasteCategoryName.click();
		log("Sorted the record with Caste Category name and object is:-" + btnSortByCasteCategoryName.toString());
		Thread.sleep(3000);
	}

	public void editMasterCasteCategory(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castecategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Caste Category Name: " + castecategoryname);
			// Thread.sleep(2000);
			try {
				if (castecategoryname.equalsIgnoreCase(casteCategoryName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the Caste Category list grid to edit record");

					break;
				} else {
					log("Caste Category Name not matched with the Caste Category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteMasterCasteCategory(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castecategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Caste Category Name: " + castecategoryname);
			// Thread.sleep(2000);
			try {
				if (castecategoryname.equalsIgnoreCase(casteCategoryName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the Caste Category list grid to delete record");

					break;
				} else {
					log("Caste Category Name not matched with the Caste Category list grid");
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

	public void verifyCasteCategoryNameInTheGrid(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String castecategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Caste Category Name: " + castecategoryname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(castecategoryname, casteCategoryName);
				log("Caste Category name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
