/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
public class Masters_Student_Fee_GroupMap extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Student_Fee_GroupMap.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[2]")
	WebElement btnStudentFGrMap;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtStudentFeeGrmap;

	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	WebElement rdBtn_All;

	@FindBy(xpath = "//span[contains(text(),'Fee Class Category')]/preceding-sibling::input")
	WebElement rdBtn_FeeClassCategory;

	@FindBy(xpath = "//span[contains(text(),'Admission Category')]/preceding-sibling::input")
	WebElement rdBtn_AdmissionClassCategory;

	@FindBy(xpath = "//span[contains(text(),'Regular Student')]/preceding-sibling::input")
	WebElement rdBtn_RegularStudent;

	@FindBy(xpath = "//span[contains(text(),'New Student')]/preceding-sibling::input")
	WebElement rdBtn_NewStudent;

	@FindBy(xpath = "//span[contains(text(),'Class Wise')]/preceding-sibling::input")
	WebElement chk_ClassWise;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Fee Class Category:')]/following-sibling::div/select")
	WebElement sel_FeeClassCategory;

	@FindBy(xpath = "//label[contains(text(),'Admission Class Category:')]/following-sibling::div/select")
	WebElement sel_AdmClassCategory;

	@FindBy(xpath = "(//select[@id='sel1' and @name='search_for'])[1]")
	WebElement sel_Search_StuList;

	@FindBy(xpath = "//span[text()='Baldwin CoEducation School Fee']//preceding-sibling::input[@name='selcolchbx']")
	WebElement chk_GroupList;

	@FindBy(xpath = "//input[@name='searchstu_text' and @ng-model='searchtxtstud']")
	WebElement input_Search_StuList;

	@FindBy(xpath = "(//span[contains(text(),'Search')]/parent::button)[1]")
	WebElement btn_Search_StuList;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	WebElement btn_CancelSearch_StuList;

	@FindBy(xpath = "(//span[contains(text(),'Save')]//parent::button)[1]")
	WebElement btn_Save;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]//parent::button)[2]")
	WebElement btn_Cancel;

	@FindBy(xpath = "(//select[@id='sel1' and @name='search_for'])[4]")
	WebElement sel_Search_OutputGrid;

	@FindBy(xpath = "//input[@name='search_text' and @ng-model='searchtxt']")
	WebElement input_Search_OutputGrid;

	@FindBy(xpath = "(//span[contains(text(),'Search')]/parent::button)[4]")
	WebElement btn_Search_OutputGrid;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[7]")
	WebElement btn_CancelSearch_OutputGrid;

	// @FindBy(xpath = "(//body[@id='style-4']//div/table)[1]/tbody/tr")
	// List<WebElement> tblRows_StuList;

	@FindBy(xpath = "//table//tbody//tr[1]//td[6]//label//input")
	WebElement chk_toSelectStuForGroupMap;

	@FindBy(xpath = "//table//tbody//tr[1]//td[6]//a")
	WebElement icon_Edit_StuList;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr")
	List<WebElement> tblRows_OutputGrid;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxStudentFeeGrMapping;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentAndGroupList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	WebElement btnMin_MaxStudentFeeGroupMappingList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]//thead//tr//th[2]/a")
	WebElement btnSortByStudentName;

	@FindBy(xpath = "//table//tbody//tr[1]//td[7]/a")
	WebElement icon_delete_OutputGrid;

	public Masters_Student_Fee_GroupMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToMasters_StudentFeegroupMap() throws Exception {
		if (btnFee.isDisplayed()) {
			btnFee.click();
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Button element not present.");
			Thread.sleep(500);
		}
		if (feeMasters.isDisplayed()) {
			feeMasters.click();
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
			Thread.sleep(1000);
		} else {
			log("Fee masters Button element not present.");
			Thread.sleep(500);
		}
		if (btnStudentFGrMap.isDisplayed()) {
			btnStudentFGrMap.click();
			log("Clicked on student Fee Group map Button and object is:-" + btnStudentFGrMap.toString());
			Thread.sleep(5000);
		} else {
			log("Student Fee Group map Button element not present.");
			Thread.sleep(500);
		}
	}

	public boolean verifyStudentFeeGroupMapPage() {
		try {
			System.out.println(txtStudentFeeGrmap.getText());
			txtStudentFeeGrmap.isDisplayed();
			log("student Fee Group Map page is dispalyed and object is:-" + txtStudentFeeGrmap.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAll(String academicYr) throws Exception {

		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("Radio button ALL is selected and object is:-" + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button ALL is already selected.");
			Thread.sleep(500);
		}
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}

	}

	public void mapStudentWithGroup(String bystudentName, String studentName) throws Exception {
		if (sel_Search_StuList.isDisplayed()) {
			select = new Select(sel_Search_StuList);
			select.selectByVisibleText(bystudentName);
			log("Selected serach for:-" + bystudentName + " and object is " + sel_Search_StuList.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), bystudentName);
			Thread.sleep(1000);
		} else {
			log("Select serach for element is not present");
			Thread.sleep(500);
		}
		if (input_Search_StuList.isDisplayed()) {
			input_Search_StuList.clear();
			input_Search_StuList.sendKeys(studentName);
			log("Entered Student name for search " + studentName + " and object is " + input_Search_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Search Input field element not present.");
			Thread.sleep(500);
		}
		if (btn_Search_StuList.isDisplayed()) {
			btn_Search_StuList.click();
			log("Search button for student list is clicked and object is " + btn_Search_StuList.toString());
			Thread.sleep(5000);
		} else {
			log("Search button element for student list is not present.");
			Thread.sleep(500);
		}
		// if(chk_toSelectStuForGroupMap.isDisplayed()){
		// if(!chk_toSelectStuForGroupMap.isSelected()){
		// chk_toSelectStuForGroupMap.click();
		// log("Student is selected form student list for group mapping and
		// object is "+chk_toSelectStuForGroupMap.toString());
		// Thread.sleep(1000);
		// }else{
		// log("Student is already selected for group mapping.");
		// Thread.sleep(500);
		// }
		// }else{
		// log("Check box element is not present in student list.");
		// Thread.sleep(500);
		// }
		//
		if (!chk_toSelectStuForGroupMap.isSelected()) {

			chk_toSelectStuForGroupMap.click();
			log("Student is selected from student list for group mapping and object is "
					+ chk_toSelectStuForGroupMap.toString());
			Thread.sleep(1000);
		} else {
			log("Student is already selected for group mapping.");
			Thread.sleep(500);

		}
		if (!chk_GroupList.isSelected()) {
			chk_GroupList.click();
			log("Group is selected from group list and object is " + chk_GroupList.toString());
			Thread.sleep(1000);
		} else {
			log("Group is already selected.");
			Thread.sleep(500);
		}

	}

	public void editStuentIn_StudentListToMapGroup() throws Exception {
		if (icon_Edit_StuList.isDisplayed()) {
			icon_Edit_StuList.click();
			log("Student is selected form student list for group mapping and object is "
					+ icon_Edit_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student is already selected for group mapping.");
			Thread.sleep(500);
		}

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise(String academicYr, String classSelection,
			String section) throws Exception {

		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("Radio button ALL is selected and object is:-" + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button ALL is already selected.");
			Thread.sleep(500);
		}
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classSelection);
			Thread.sleep(1000);
		} else {
			log("Select Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Select Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory(String academicYr, String feeclassCategory)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		
		if (!rdBtn_FeeClassCategory.isSelected()) {
			rdBtn_FeeClassCategory.click();
			log("Radio button Fee Class Category is selected and object is:-" + rdBtn_FeeClassCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Fee Class Category is already selected.");
			Thread.sleep(500);
		}
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_FeeClassCategory.isDisplayed()) {
			select = new Select(sel_FeeClassCategory);
			select.selectByVisibleText(feeclassCategory);
			log("Selected Fee Class Category:-" + feeclassCategory + " and object is "
					+ sel_FeeClassCategory.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), feeclassCategory);
			Thread.sleep(1000);
		} else {
			log("Fee Class Category dropdown element is not present");
			Thread.sleep(500);
		}

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory(String academicYr, String admissionclassCategory)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (!rdBtn_AdmissionClassCategory.isSelected()) {
			rdBtn_AdmissionClassCategory.click();
			log("Radio button Admission Category is selected and object is:-"
					+ rdBtn_AdmissionClassCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Admission Category is already selected.");
			Thread.sleep(500);
		}
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_AdmClassCategory.isDisplayed()) {
			select = new Select(sel_AdmClassCategory);
			select.selectByVisibleText(admissionclassCategory);
			log("Selected Admission Class Category:-" + admissionclassCategory + " and object is "
					+ sel_AdmClassCategory.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), admissionclassCategory);
			Thread.sleep(1000);
		} else {
			log("Admission Class Category dropdown element is not present");
			Thread.sleep(500);
		}

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise(String academicYr)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (!rdBtn_RegularStudent.isSelected()) {
			rdBtn_RegularStudent.click();
			log("Radio button Regular Student is selected and object is:-" + rdBtn_RegularStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Regular Student is already selected.");
			Thread.sleep(500);
		}
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise(String academicYr,
			String classSelection, String section) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (!rdBtn_RegularStudent.isSelected()) {
			rdBtn_RegularStudent.click();
			log("Radio button Regular Student is selected and object is:-" + rdBtn_RegularStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Regular Student is already selected.");
			Thread.sleep(500);
		}
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected or check box element is not present.");
			Thread.sleep(500);
		}

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classSelection);
			Thread.sleep(1000);
		} else {
			log("Select Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Select Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise(String academicYr) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (!rdBtn_NewStudent.isSelected()) {
			rdBtn_NewStudent.click();
			log("Radio button New Student is selected and object is:-" + rdBtn_NewStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button New Student is already selected.");
			Thread.sleep(500);
		}
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise(String academicYr, String classSelection,
			String section) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (!rdBtn_NewStudent.isSelected()) {
			rdBtn_NewStudent.click();
			log("Radio button New Student is selected and object is:-" + rdBtn_NewStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button New Student is already selected.");
			Thread.sleep(500);
		}
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected or check box element is not present.");
			Thread.sleep(500);
		}

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Select Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classSelection);
			Thread.sleep(1000);
		} else {
			log("Select Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Select Section element is not present");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save Button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button to submit blank form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);

		} else {
			log("Save Button element not present.");
			Thread.sleep(500);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
	}

	public void clickOnCancelButton() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("clicked on Cancel button and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel Button element not present.");
			Thread.sleep(500);
		}
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOkonSuccess.isDisplayed()) {
			btnOkonSuccess.click();
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(2000);
		} else {
			log("Ok Button element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with the Mapped Student
	 * 
	 * @param bystudentName
	 * @param studentName
	 * @throws Exception
	 */

	public void searchBy_StudentName_NameInOutputGrid(String bystudentName, String studentName) throws Exception {
		if (sel_Search_OutputGrid.isDisplayed()) {
			select = new Select(sel_Search_OutputGrid);
			select.selectByVisibleText(bystudentName);
			log("Selected serach for:-" + bystudentName + " and object is " + sel_Search_OutputGrid.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), bystudentName);
			Thread.sleep(1000);
		} else {
			log("Select serach for element is not present");
			Thread.sleep(500);
		}
		if (input_Search_OutputGrid.isDisplayed()) {
			input_Search_OutputGrid.clear();
			input_Search_OutputGrid.sendKeys(studentName);
			log("Entered Student name for search " + studentName + " and object is "
					+ input_Search_OutputGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Search Input field element not present.");
			Thread.sleep(500);
		}
		if (btn_Search_OutputGrid.isDisplayed()) {
			btn_Search_OutputGrid.click();
			log("Search button for Output grid is clicked and object is " + btn_Search_OutputGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Search button element for Output grid is not present.");
			Thread.sleep(500);
		}
	}

	public void deleteUpdatedRecordFrom_OutputGrid() throws Exception {

		if (icon_delete_OutputGrid.isDisplayed()) {
			icon_delete_OutputGrid.click();
			log("Click on delete button to delete record and object is:-" + icon_delete_OutputGrid.toString());
			Thread.sleep(2000);
		} else {
			log("Delete element is not present in the output grid.");
			Thread.sleep(500);
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes delete it button and object is:-" + btnYesDeleteOrDeactIt.toString());
			Thread.sleep(10000);
		} else {
			log("Yes Delete it button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_PopUp() throws Exception {
		if (btnPopUpCancel.isDisplayed()) {
			btnPopUpCancel.click();
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_StudentFeeGroupMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		if (btnMin_MaxStudentFeeGrMapping.isDisplayed()) {
			btnMin_MaxStudentFeeGrMapping.click();
			log("clicked on Student FeeGroup Mapping minimize Or maximize button and object is:-"
					+ btnMin_MaxStudentFeeGrMapping.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Student FeeGroup Mapping button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_StudentAndGroupList() throws Exception {
		if (btnMin_MaxStudentAndGroupList.isDisplayed()) {
			btnMin_MaxStudentAndGroupList.click();
			log("clicked on Student and Group list minimize Or maximize and object is:-"
					+ btnMin_MaxStudentAndGroupList.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Student and Group list button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_StudentFeeGroupMappingList() throws Exception {
		if (btnMin_MaxStudentFeeGroupMappingList.isDisplayed()) {
			btnMin_MaxStudentFeeGroupMappingList.click();
			log("clicked on Student Fee Group mapping list minimize Or maximize and object is:-"
					+ btnMin_MaxStudentFeeGroupMappingList.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Student Fee Group mapping list button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortByStudentName() throws Exception {
		if (btnSortByStudentName.isDisplayed()) {
			btnSortByStudentName.click();
			btnSortByStudentName.click();
			log("Sorted the record with Student name and object is:-" + btnSortByStudentName.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}
}
