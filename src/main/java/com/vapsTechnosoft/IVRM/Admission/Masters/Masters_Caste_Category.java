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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[1]")
	// WebElement btnMasters_CasteCategory;

	@FindBy(xpath = "//a[@href='#/app/castecategory/70']")
	WebElement btnMasters_CasteCategory;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_CasteCategoryMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//input[@name='Category']")
	WebElement input_CasteCategoryName;

	@FindBy(xpath = "//textarea[@name='Description']")
	WebElement input_CategoryDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]")
	WebElement btnSortByCasteCategoryName;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_CasteCategoryName;

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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	@FindBy(xpath = "//table/thead/tr/th")
	List<WebElement> casteCategoryGrid_Th;

	@FindBy(xpath = "//table/tbody/tr[1]/td")
	List<WebElement> casteCategoryGrid_Tr1;

	public Masters_Caste_Category(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Caste Category
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_CasteCategory_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_CasteCategory);
		log("Clicked on Caste Category Button and object is:-" + btnMasters_CasteCategory.toString());
		// Thread.sleep(5000);

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

	public void enterMasterCasteCategoryDetailsData(String casteCategoryName, String casteCategoryDescription)
			throws Exception {

		inputTextIntoInputField(input_CasteCategoryName, casteCategoryName);
		log("Entered caste category name " + casteCategoryName + " and object is:-"
				+ input_CasteCategoryName.toString());

		inputTextIntoInputField(input_CategoryDescription, casteCategoryDescription);
		log("Entered caste category description " + casteCategoryDescription + " and object is:-"
				+ input_CategoryDescription.toString());

	}

	public void submitBlankMasterCasteCategoryForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master caste category form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void clearCasteCategoryInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled Caste Category info and object is:-" + btnCancelClear.toString());
		Thread.sleep(1000);
	}

	public void saveCasteCategoryInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Caste Category info and object is:-" + btnSave.toString());

	}

	public void searchWithCasteCategoryNameInTheGrid(String casteCategoryName) {

		inputTextIntoInputField(inputSearch, casteCategoryName);
		log("Enterd Caste Category name to search: " + casteCategoryName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterCasteCategory() throws Exception {

		clickOnButton(btnMin_MaxMasterCasteCategory);
		log("clicked on master Caste Category minimize button and object is:-"
				+ btnMin_MaxMasterCasteCategory.toString());

	}

	public void maximizeMasterCasteCategory() throws Exception {

		clickOnButton(btnMin_MaxMasterCasteCategory);
		log("clicked on master Caste Category maximize button and object is:-"
				+ btnMin_MaxMasterCasteCategory.toString());

	}

	public void minimizeCasteCategoryList() throws Exception {

		clickOnButton(btnMin_MaxCastecategoryList);
		log("Master Caste Category list table data minimize and object is:-" + btnMin_MaxCastecategoryList.toString());

	}

	public void maximizeCasteCategoryList() throws Exception {

		clickOnButton(btnMin_MaxCastecategoryList);
		log("Master Caste Category list table data maximized and object is:-" + btnMin_MaxCastecategoryList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByCasteCategoryName() throws Exception {
		
		clickOnButton(btnSortByCasteCategoryName);
		SortData_InColumn_DescendingOrder(list_CasteCategoryName);
		log("Sorted the record with Caste Category name In Descending order and object is:-" + btnSortByCasteCategoryName.toString());

	}

	public void editMasterCasteCategory(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String castecategoryname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Caste Category Name: " + castecategoryname);
				// Thread.sleep(2000);
				if (castecategoryname.equals(casteCategoryName)) {
					// assertEquals(castecategoryname, casteCategoryName);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the Caste Category list grid to edit record");

					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteMasterCasteCategory(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String castecategoryname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Caste Category Name: " + castecategoryname);
				// Thread.sleep(2000);

				if (castecategoryname.equals(casteCategoryName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the Caste Category list grid to delete record");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(2000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void verifyCasteCategoryNameInTheGrid(String casteCategoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);

		try {
			for (int i = 1; i <= rows; i++) {
				String castecategoryname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Caste Category Name: " + castecategoryname);

				Thread.sleep(1000);
				if (castecategoryname.equals(casteCategoryName)) {
					// Assert.assertEquals(castecategoryname,
					// casteCategoryName);
					log("Caste Category name created is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateGrid_ColumnHeader() throws Exception {
		verifyColumnHeaderWithExcelData(casteCategoryGrid_Th, "AdmissionMasterGridHeader.xlsx", "CasteCategoryHeader",
				"Masters_Admission");
	}

	public void validateGrid_RowValue() throws Exception {
		verifyRowValuesWithExcelData(casteCategoryGrid_Tr1, "AdmissionMasterGridHeader.xlsx", "CasteCategoryData",
				"Masters_Admission");
	}

}
