/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_BatchWise_Student_Mapping extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_BatchWise_Student_Mapping.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[18]")
	// WebElement btnMasters_BatchWiseStudentMapp;

	@FindBy(xpath = "//a[@href='#/app/BatchwiseStudentMapping/60']")
	WebElement btnMasters_BatchWiseStudentMapp;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_BatchWiseStudentMappMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//select[@id='sel1' and @name='acdyear']")
	WebElement selAcademicYear;

	@FindBy(xpath = "//select[@id='sel1' and @name='cls']")
	WebElement selClass;

	@FindBy(xpath = "//select[@id='sel1' and @name='sec']")
	WebElement selSection;

	@FindBy(xpath = "//select[@id='sel1' and @name='subject']")
	WebElement selSubject;

	@FindBy(xpath = "//select[@id='sel123' and @name='batch123']")
	WebElement selBatch;

	@FindBy(xpath = "//input[@name='batch']")
	WebElement input_Batch;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_SearchStudentList;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement input_SearchStudentMappList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxBatchWiseStudentMapp;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxStudentMappList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr")
	List<WebElement> tblRows_StudentList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows_StudentMappList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/thead/tr/th[3]/a")
	WebElement btnSortByStudentName_StudentList;
	
	@FindBy(xpath = "(//table/tbody)[1]/tr/td[3]")
	private List<WebElement> list_StudentNameInStuList;
	
	

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/thead/tr/th[2]/a")
	WebElement btnSortByStudentName_StudentMappList;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_StudentNameInMapList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "(//label[@class='radio-inline']/input)[1]")
	WebElement rdbtn_CreateBatch;

	@FindBy(xpath = "(//label[@class='radio-inline']/input)[2]")
	WebElement rdbtn_UpdateBatch;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_BatchWise_Student_Mapping(WebDriver driver) {
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
	 * Navigate to Admission Masters Batch-wise Student mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_BatchWiseStudentMapping_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_BatchWiseStudentMapp);
		log("Clicked on BatchWise Student Mapp Button and object is:-" + btnMasters_BatchWiseStudentMapp.toString());

	}

	/**
	 * Validation of masters Batch-wise Student mapping screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_BatchWiseStudentMapp_BGHSPage() {
		try {
			System.out.println(txtMasters_BatchWiseStudentMappMsgDispaly.getText());
			txtMasters_BatchWiseStudentMappMsgDispaly.isDisplayed();
			log("Batch-wise Student mapping page is dispalyed and object is:-"
					+ txtMasters_BatchWiseStudentMappMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void selectRadioButtonTo_CreateNewBatch() throws Exception {
		isDisplayed(rdbtn_CreateBatch);
		if (!rdbtn_CreateBatch.isSelected()) {
			rdbtn_CreateBatch.click();
			log("Create new Batch radio button is selected and object is:-" + rdbtn_CreateBatch.toString());
			Thread.sleep(1000);
		} else {
			log("Create new Batch radio button is already selected and object is:-" + rdbtn_CreateBatch.toString());
			Thread.sleep(1000);
		}
	}

	public void selectRadioButtonTo_UpdateCreatedBatch() throws Exception {
		isDisplayed(rdbtn_UpdateBatch);
		if (!rdbtn_UpdateBatch.isSelected()) {
			rdbtn_UpdateBatch.click();
			log("Update Batch radio button is selected and object is:-" + rdbtn_UpdateBatch.toString());
			Thread.sleep(1000);
		} else {
			log("Update Batch radio button is already selected and object is:-" + rdbtn_UpdateBatch.toString());
			Thread.sleep(1000);
		}
	}

	public void fillBatchwiseStudentMappFormTo_CreateNewBatch(String academicYr, String classBatch, String section,
			String subject, String batchName) throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_BatchWiseStudentMappMsgDispaly);
		Thread.sleep(2000);

		selectElementFromDropDown(selAcademicYear, academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());

		selectElementFromDropDown(selClass, classBatch);
		log("selected class: " + classBatch + " and object is:- " + selClass.toString());

		selectElementFromDropDown(selSection, section);
		log("selected section: " + section + " and object is:- " + selSection.toString());

		selectElementFromDropDown(selSubject, subject);
		log("selected staff: " + subject + " and object is:- " + selSubject.toString());

		inputTextIntoInputField(input_Batch, batchName);
		log("Entered new Batch Name: " + batchName + " and object is:-" + input_Batch.toString());

	}

	public void fillBatchwiseStudentMappFormTo_UpdateBatch(String academicYr, String classBatch, String section,
			String subject, String batchName) throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_BatchWiseStudentMappMsgDispaly);
		Thread.sleep(2000);

		selectElementFromDropDown(selAcademicYear, academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());

		selectElementFromDropDown(selClass, classBatch);
		log("selected class: " + classBatch + " and object is:- " + selClass.toString());

		selectElementFromDropDown(selSection, section);
		log("selected section: " + section + " and object is:- " + selSection.toString());

		selectElementFromDropDown(selSubject, subject);
		log("selected staff: " + subject + " and object is:- " + selSubject.toString());

		selectElementFromDropDown(selBatch, batchName);
		log("selected batch: " + batchName + " and object is:- " + selBatch.toString());

	}

	public void sortStudentListByStudentName() throws Exception {

		clickOnButton(btnSortByStudentName_StudentList);
		SortData_InColumn_DescendingOrder(list_StudentNameInStuList);
		log("Sorted the record with student name in student list Descending order and object is:-"
				+ btnSortByStudentName_StudentList.toString());

	}

	public void sortStudentMappListByStudentName() throws Exception {

		clickOnButton(btnSortByStudentName_StudentMappList);
		SortData_InColumn_DescendingOrder(list_StudentNameInMapList);
		log("Sorted the record with student name in student mapp list Descending order and object is:-"
				+ btnSortByStudentName_StudentMappList.toString());

	}

	public void minimizeBatchWiseStudentMapping() throws Exception {

		clickOnButton(btnMin_MaxBatchWiseStudentMapp);
		log("Batch wise student mapping page is minimized and object is:-" + btnMin_MaxBatchWiseStudentMapp.toString());

	}

	public void maximizeBatchWiseStudentMapping() throws Exception {

		clickOnButton(btnMin_MaxBatchWiseStudentMapp);
		log("Batch wise student mapping page is maximized and object is:-" + btnMin_MaxBatchWiseStudentMapp.toString());

	}

	public void minimizeStudentList() throws Exception {

		clickOnButton(btnMin_MaxStudentList);
		log("Student list page is minimized and object is:-" + btnMin_MaxStudentList.toString());

	}

	public void maximizeStudentList() throws Exception {

		clickOnButton(btnMin_MaxStudentList);
		log("Student List page is maximized and object is:-" + btnMin_MaxStudentList.toString());

	}

	public void minimizeStudentMappList() throws Exception {

		clickOnButton(btnMin_MaxStudentMappList);
		log("Student mapp list page is minimized and object is:-" + btnMin_MaxStudentList.toString());

	}

	public void maximizeStudentMappList() throws Exception {

		clickOnButton(btnMin_MaxStudentMappList);
		log("Student mapp list page is maximized and object is:-" + btnMin_MaxStudentMappList.toString());

	}

	public void searchWithRegNoAcademicYearTo_SelectStudent(String academicYr) throws Exception {

		inputTextIntoInputField(input_SearchStudentList, academicYr);
		log("Entered academic no to search: " + academicYr + " and object is:-" + input_SearchStudentList.toString());

	}

	public void searchWithBatchNameIntheGrid(String batchName) throws Exception {

		inputTextIntoInputField(input_SearchStudentMappList, batchName);
		log("Entered batch name to search: " + batchName + " and object is:-" + input_SearchStudentMappList.toString());

	}

	public void submitBlankBatchWiseStudentMappForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank Batch Wise Student Mapp form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void clearBatchWiseStudentMappInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled Batch Wise Student Mapp info and object is:-"
				+ btnCancelClear.toString());

	}

	public void saveBatchWiseStudentMappInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled BatchWise Student Mapp info and object is:-" + btnSave.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void selectStudentToMappWithBatchFromStudentList(String academicYr) throws Exception {
		int rows = tblRows_StudentList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				WebElement chkstudent = driver.findElement(
						By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input"));

				if (!chkstudent.isSelected()) {
					chkstudent.click();
					Thread.sleep(2000);
					log("For " + i + " student check box checked");
				}

				else {
					log("For " + i + " student check box already checked");
					Thread.sleep(2000);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyBatchNameUpdatedInTheGrid(String batchName) {

		int rows = tblRows_StudentMappList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String batchname = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[7]"))
						.getText().trim();
				System.out.println("Batch Name: " + batchname);
				// Thread.sleep(2000);
				if (batchname.equals(batchName)) {

					Assert.assertEquals(batchname, batchName);
					log("Batch name mapped is updated in the record grid.");
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
			assertEquals(text, "Record Saved/Updated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Update() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record not Saved/Updated");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
