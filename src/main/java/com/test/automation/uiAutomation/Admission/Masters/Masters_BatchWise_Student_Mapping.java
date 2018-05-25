/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

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

import com.test.automation.uiAutomation.testBase.TestBase;

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[18]")
	WebElement btnMasters_BatchWiseStudentMapp;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_BatchWiseStudentMappMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selAcademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selClass;

	@FindBy(xpath = "(//select[@id='sel1'])[3]")
	WebElement selSection;

	@FindBy(xpath = "(//select[@id='sel1'])[4]")
	WebElement selSubject;

	@FindBy(xpath = "//select[@id='sel123']")
	WebElement selBatch;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
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

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/thead/tr/th[2]/a")
	WebElement btnSortByStudentName_StudentMappList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "(//label[@class='radio-inline']/input)[1]")
	WebElement rdbtn_CreateBatch;

	@FindBy(xpath = "(//label[@class='radio-inline']/input)[2]")
	WebElement rdbtn_UpdateBatch;

	public Masters_BatchWise_Student_Mapping(WebDriver driver) {
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
	 * Navigate to Admission Masters Batch-wise Student mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_BatchWiseStudentMapping_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_BatchWiseStudentMapp);

		btnMasters_BatchWiseStudentMapp.click();
		log("Clicked on BatchWise Student Mapp Button and object is:-" + btnMasters_BatchWiseStudentMapp.toString());
		waitForElement(driver, 10, btnSave);
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

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtMasters_BatchWiseStudentMappMsgDispaly);
		Thread.sleep(2000);
		
		select = new Select(selAcademicYear);
		select.selectByVisibleText(academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), academicYr);
		Thread.sleep(1000);

		select = new Select(selClass);
		select.selectByVisibleText(classBatch);
		log("selected class: " + classBatch + " and object is:- " + selClass.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), classBatch);
		Thread.sleep(1000);

		select = new Select(selSection);
		select.selectByVisibleText(section);
		log("selected section: " + section + " and object is:- " + selSection.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), section);
		Thread.sleep(1000);

		select = new Select(selSubject);
		select.selectByVisibleText(subject);
		log("selected staff: " + subject + " and object is:- " + selSubject.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), subject);
		Thread.sleep(1000);

		input_Batch.clear();
		input_Batch.sendKeys(batchName);
		log("Entered new Batch Name: " + batchName + " and object is:-" + input_Batch.toString());
		Thread.sleep(2000);

	}

	public void fillBatchwiseStudentMappFormTo_UpdateBatch(String academicYr, String classBatch, String section,
			String subject, String batchName) throws Exception {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtMasters_BatchWiseStudentMappMsgDispaly);
		Thread.sleep(2000);
		
		select = new Select(selAcademicYear);
		select.selectByVisibleText(academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), academicYr);
		Thread.sleep(1000);

		select = new Select(selClass);
		select.selectByVisibleText(classBatch);
		log("selected class: " + classBatch + " and object is:- " + selClass.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), classBatch);
		Thread.sleep(1000);

		select = new Select(selSection);
		select.selectByVisibleText(section);
		log("selected section: " + section + " and object is:- " + selSection.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), section);
		Thread.sleep(1000);

		select = new Select(selSubject);
		select.selectByVisibleText(subject);
		log("selected staff: " + subject + " and object is:- " + selSubject.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), subject);
		Thread.sleep(1000);

		select = new Select(selBatch);
		select.selectByVisibleText(batchName);
		log("selected batch: " + batchName + " and object is:- " + selBatch.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), batchName);
		Thread.sleep(1000);
	}

	public void sortStudentListByStudentName() throws Exception {

		btnSortByStudentName_StudentList.click();
		log("Sorted the record with student name in student list and object is:-"
				+ btnSortByStudentName_StudentList.toString());
		Thread.sleep(2000);
	}

	public void sortStudentMappListByStudentName() throws Exception {

		btnSortByStudentName_StudentMappList.click();
		log("Sorted the record with student name in student mapp list and object is:-"
				+ btnSortByStudentName_StudentMappList.toString());
		Thread.sleep(2000);
	}

	public void minimizeBatchWiseStudentMapping() throws Exception {

		btnMin_MaxBatchWiseStudentMapp.click();
		log("Batch wise student mapping page is minimized and object is:-" + btnMin_MaxBatchWiseStudentMapp.toString());
		Thread.sleep(2000);
	}

	public void maximizeBatchWiseStudentMapping() throws Exception {

		btnMin_MaxBatchWiseStudentMapp.click();
		log("Batch wise student mapping page is maximized and object is:-" + btnMin_MaxBatchWiseStudentMapp.toString());
		Thread.sleep(2000);
	}

	public void minimizeStudentList() throws Exception {

		btnMin_MaxStudentList.click();
		log("Student list page is minimized and object is:-" + btnMin_MaxStudentList.toString());
		Thread.sleep(2000);
	}

	public void maximizeStudentList() throws Exception {

		btnMin_MaxStudentList.click();
		log("Student List page is maximized and object is:-" + btnMin_MaxStudentList.toString());
		Thread.sleep(2000);
	}

	public void minimizeStudentMappList() throws Exception {

		btnMin_MaxStudentMappList.click();
		log("Student mapp list page is minimized and object is:-" + btnMin_MaxStudentList.toString());
		Thread.sleep(2000);
	}

	public void maximizeStudentMappList() throws Exception {

		btnMin_MaxStudentMappList.click();
		log("Student mapp list page is maximized and object is:-" + btnMin_MaxStudentMappList.toString());
		Thread.sleep(2000);
	}

	public void searchWithRegNoAcademicYearTo_SelectStudent(String academicYr) throws Exception {

		input_SearchStudentList.clear();
		input_SearchStudentList.sendKeys(academicYr);
		log("Entered academic no to search: " + academicYr + " and object is:-" + input_SearchStudentList.toString());
		Thread.sleep(2000);
	}

	public void searchWithBatchNameIntheGrid(String batchName) throws Exception {
		input_SearchStudentMappList.clear();
		input_SearchStudentMappList.sendKeys(batchName);
		log("Entered batch name to search: " + batchName + " and object is:-" + input_SearchStudentMappList.toString());
		Thread.sleep(2000);
	}

	public void submitBlankBatchWiseStudentMappForm() throws Exception {

		btnSave.click();
		log("Submit blank Batch Wise Student Mapp form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void clearBatchWiseStudentMappInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Batch Wise Student Mapp info and object is:-"
				+ btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveBatchWiseStudentMappInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled BatchWise Student Mapp info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}
	
	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
	
	public void selectStudentToMappWithBatchFromStudentList(String academicYr) throws Exception{
		int rows = tblRows_StudentList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			WebElement chkstudent = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input"));
			
			if(!chkstudent.isSelected()){
				chkstudent.click();
				Thread.sleep(2000);
				log("For "+i+" student check box checked");
			}
			
			else{
				log("For "+i+" student check box already checked");
				Thread.sleep(2000);
			}
				
		}
	}
		
	public void verifyBatchNameUpdatedInTheGrid(String batchName) {

		int rows = tblRows_StudentMappList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String batchname = driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[7]"))
					.getText().trim();
			System.out.println("Batch Name: " + batchname);
			// Thread.sleep(2000);
			try {
				
				Assert.assertEquals(batchname, batchName);	
				log("Batch name mapped is updated in the record grid.");


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
