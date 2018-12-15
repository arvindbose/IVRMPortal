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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[2]")
	// WebElement btnMasters_MasterCaste;

	@FindBy(xpath = "//a[@href='#/app/mastercaste/72']")
	WebElement btnMasters_MasterCaste;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterCasteMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//input[@name='name']")
	WebElement input_CasteName;

	@FindBy(xpath = "//input[@name='description']")
	WebElement input_CasteDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByCasteName;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_CasteName;

	@FindBy(xpath = "//select[@name='cat' and @data-ng-model='imcC_Id']")
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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Caste(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Caste
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterCaste_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_MasterCaste);
		log("Clicked on Master Caste Button and object is:-" + btnMasters_MasterCaste.toString());

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

		inputTextIntoInputField(input_CasteName, casteName);
		log("Entered caste name " + casteName + " and object is:-" + input_CasteName.toString());

		inputTextIntoInputField(input_CasteDescription, casteDescription);
		log("Entered caste description " + casteDescription + " and object is:-" + input_CasteDescription.toString());

		selectElementFromDropDown(sel_Castecategory, casteCategory);
		log("selected caste category " + casteCategory + " and object is:- " + sel_Castecategory.toString());

	}

	public void submitBlankMasterCasteForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master caste form and object is:-" + btnSave.toString());

	}

	public void clearMasterCasteInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled master Caste info and object is:-" + btnCancelClear.toString());
		Thread.sleep(1000);
	}

	public void saveMasterCasteInfoData() throws Exception {
		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Master Caste info and object is:-" + btnSave.toString());

	}

	public void searchWithCasteNameInTheGrid(String casteName) {

		inputTextIntoInputField(inputSearch, casteName);
		log("Enterd Caste name to search: " + casteName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterCaste() throws Exception {

		clickOnButton(btnMin_MaxMasterCaste);
		log("clicked on master Caste minimize button and object is:-" + btnMin_MaxMasterCaste.toString());

	}

	public void maximizeMasterCaste() throws Exception {

		clickOnButton(btnMin_MaxMasterCaste);
		log("clicked on master Caste maximize button and object is:-" + btnMin_MaxMasterCaste.toString());
		Thread.sleep(2000);
	}

	public void minimizeCreatedCasteList() throws Exception {

		clickOnButton(btnMin_MaxCreatedCasteList);
		log("Master Created Caste list table data minimize and object is:-" + btnMin_MaxCreatedCasteList.toString());

	}

	public void maximizeCreatedCasteList() throws Exception {

		clickOnButton(btnMin_MaxCreatedCasteList);
		log("Master Created Caste list table data maximized and object is:-" + btnMin_MaxCreatedCasteList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByCasteName() throws Exception {

		clickOnButton(btnSortByCasteName);
		SortData_InColumn_DescendingOrder(list_CasteName);
		log("Sorted the record with Caste name in Descending order and object is:-" + btnSortByCasteName.toString());

	}

	public void editMasterCaste(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String castename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Caste Name: " + castename);
				// Thread.sleep(2000);
				if (castename.equals(casteName)) {
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the created Caste list grid to edit record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterCaste(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String castename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Caste Category Name: " + castename);

				Thread.sleep(1000);
				if (castename.equals(casteName)) {
					// assertEquals(castename, casteName);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/a[2]"))
							.click();

					Thread.sleep(2000);
					log("Clicked on the delete link in the Created Caste list grid to delete record");

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

	public void verifyCasteNameInTheGrid(String casteName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String castename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Caste Category Name: " + castename);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (castename.equals(casteName)) {
					// assertEquals(castename, casteName);
					log("Caste name created is updated in the record grid.");
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
	public void popWindowMessage_DeleteCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Caste Deletion Cancelled");
			log("Record Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void popWindowMessage_DeletedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Caste Deleted Successfully");
			log("Caste Deleted Successfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
