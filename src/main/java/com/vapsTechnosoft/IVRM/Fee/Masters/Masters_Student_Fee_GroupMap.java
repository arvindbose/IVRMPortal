/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

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

//	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[2]")
//	WebElement btnStudentFGrMap;
	
	@FindBy(xpath = "//a[@href='#/app/StudentFeeGroupMapping/88']")
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
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToMasters_StudentFeegroupMap() throws Exception {
	
			clickOnButton(btnFee);
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
	
			clickOnButton(feeMasters);
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

			clickOnButton(btnStudentFGrMap);
			log("Clicked on student Fee Group map Button and object is:-" + btnStudentFGrMap.toString());
		
	}

	public boolean verifyStudentFeeGroupMapPage() {
		try {
			System.out.println(txtStudentFeeGrmap.getText());
			txtStudentFeeGrmap.isDisplayed();
			log("student Fee Group Map page is dispalyed and object is:-" + txtStudentFeeGrmap.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAll(String academicYr) throws Exception {
		isDisplayed(rdBtn_All);
		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("Radio button ALL is selected and object is:-" + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button ALL is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());


	}

	public void mapStudentWithGroup(String bystudentName, String studentName) throws Exception {
	
			selectElementFromDropDown(sel_Search_StuList, bystudentName);
			log("Selected serach for:-" + bystudentName + " and object is " + sel_Search_StuList.toString());

			inputTextIntoInputField(input_Search_StuList, studentName);
			log("Entered Student name for search " + studentName + " and object is " + input_Search_StuList.toString());

			clickOnButton(btn_Search_StuList);
			log("Search button for student list is clicked and object is " + btn_Search_StuList.toString());
			Thread.sleep(1000);
		
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
			isDisplayed(chk_toSelectStuForGroupMap);
		if (!chk_toSelectStuForGroupMap.isSelected()) {

			chk_toSelectStuForGroupMap.click();
			log("Student is selected from student list for group mapping and object is "
					+ chk_toSelectStuForGroupMap.toString());
			Thread.sleep(1000);
		} else {
			log("Student is already selected for group mapping.");
			Thread.sleep(500);

		}
		isDisplayed(chk_GroupList);
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
	
			clickOnButton(icon_Edit_StuList);
			log("Student is selected form student list for group mapping and object is "
					+ icon_Edit_StuList.toString());
			

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise(String academicYr, String classSelection,
			String section) throws Exception {
		isDisplayed(rdBtn_All);
		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("Radio button ALL is selected and object is:-" + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button ALL is already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_ClassWise);
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			selectElementFromDropDown(sel_Class, classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			selectElementFromDropDown(sel_Section, section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory(String academicYr, String feeclassCategory)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_FeeClassCategory);
		if (!rdBtn_FeeClassCategory.isSelected()) {
			rdBtn_FeeClassCategory.click();
			log("Radio button Fee Class Category is selected and object is:-" + rdBtn_FeeClassCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Fee Class Category is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			selectElementFromDropDown(sel_FeeClassCategory, feeclassCategory);
			log("Selected Fee Class Category:-" + feeclassCategory + " and object is "
					+ sel_FeeClassCategory.toString());

		

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory(String academicYr, String admissionclassCategory)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_AdmissionClassCategory);
		if (!rdBtn_AdmissionClassCategory.isSelected()) {
			rdBtn_AdmissionClassCategory.click();
			log("Radio button Admission Category is selected and object is:-"
					+ rdBtn_AdmissionClassCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Admission Category is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			selectElementFromDropDown(sel_AdmClassCategory, admissionclassCategory);
			log("Selected Admission Class Category:-" + admissionclassCategory + " and object is "
					+ sel_AdmClassCategory.toString());

		
	}

	public void fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise(String academicYr)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_RegularStudent);
		if (!rdBtn_RegularStudent.isSelected()) {
			rdBtn_RegularStudent.click();
			log("Radio button Regular Student is selected and object is:-" + rdBtn_RegularStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Regular Student is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());


	}

	public void fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise(String academicYr,
			String classSelection, String section) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_RegularStudent);
		if (!rdBtn_RegularStudent.isSelected()) {
			rdBtn_RegularStudent.click();
			log("Radio button Regular Student is selected and object is:-" + rdBtn_RegularStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Regular Student is already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_ClassWise);
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected or check box element is not present.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			selectElementFromDropDown(sel_Class, classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			selectElementFromDropDown(sel_Section, section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

	}

	public void fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise(String academicYr) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_NewStudent);
		if (!rdBtn_NewStudent.isSelected()) {
			rdBtn_NewStudent.click();
			log("Radio button New Student is selected and object is:-" + rdBtn_NewStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button New Student is already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());


	}

	public void fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise(String academicYr, String classSelection,
			String section) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		isDisplayed(rdBtn_NewStudent);
		if (!rdBtn_NewStudent.isSelected()) {
			rdBtn_NewStudent.click();
			log("Radio button New Student is selected and object is:-" + rdBtn_NewStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button New Student is already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_ClassWise);
		if (!chk_ClassWise.isSelected()) {

			chk_ClassWise.click();
			log("Class Wise check box is selected and object is " + chk_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise check box is already selected or check box element is not present.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYr);
			log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

			selectElementFromDropDown(sel_Class, classSelection);
			log("Selected Class:-" + classSelection + " and object is " + sel_Class.toString());

			selectElementFromDropDown(sel_Section, section);
			log("Selected Section:-" + section + " and object is " + sel_Section.toString());

	}

	public void clickOnSaveButton() throws Exception {

			clickOnButton(btn_Save);
			log("clicked on save button and object is:-" + btn_Save.toString());
			Thread.sleep(1000);
	}

	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {
	
			clickOnButton(btn_Save);
			log("clicked on save button to submit blank form and object is:-" + btn_Save.toString());
			Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
	}

	public void clickOnCancelButton() throws Exception {
		
			clickOnButton(btn_Cancel);
			log("clicked on Cancel button and object is:-" + btn_Cancel.toString());
			Thread.sleep(1000);
		
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {
	
			clickOnButton(btnOkonSuccess);
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(1000);
		
	}

	/**
	 * Search with the Mapped Student
	 * 
	 * @param bystudentName
	 * @param studentName
	 * @throws Exception
	 */

	public void searchBy_StudentName_NameInOutputGrid(String bystudentName, String studentName) throws Exception {

			selectElementFromDropDown(sel_Search_OutputGrid, bystudentName);
			log("Selected serach for:-" + bystudentName + " and object is " + sel_Search_OutputGrid.toString());

			inputTextIntoInputField(input_Search_OutputGrid, studentName);
			log("Entered Student name for search " + studentName + " and object is "
					+ input_Search_OutputGrid.toString());

			clickOnButton(btn_Search_OutputGrid);
			log("Search button for Output grid is clicked and object is " + btn_Search_OutputGrid.toString());
			
	}

	public void deleteUpdatedRecordFrom_OutputGrid() throws Exception {

			clickOnButton(icon_delete_OutputGrid);
			log("Click on delete button to delete record and object is:-" + icon_delete_OutputGrid.toString());
			Thread.sleep(1000);
		
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
	
			clickOnButton(btnYesDeleteOrDeactIt);
			log("Clicked on yes delete it button and object is:-" + btnYesDeleteOrDeactIt.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnCancelButton_PopUp() throws Exception {
		
			clickOnButton(btnPopUpCancel);
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(1000);
	
	}

	public void minimizeAndMaximize_StudentFeeGroupMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtStudentFeeGrmap);
		Thread.sleep(1000);
		
			clickOnButton(btnMin_MaxStudentFeeGrMapping);
			log("clicked on Student FeeGroup Mapping minimize Or maximize button and object is:-"
					+ btnMin_MaxStudentFeeGrMapping.toString());
			Thread.sleep(1000);
		
	}

	public void minimizeAndMaximize_StudentAndGroupList() throws Exception {
	
			clickOnButton(btnMin_MaxStudentAndGroupList);
			log("clicked on Student and Group list minimize Or maximize and object is:-"
					+ btnMin_MaxStudentAndGroupList.toString());
			
	}

	public void minimizeAndMaximize_StudentFeeGroupMappingList() throws Exception {
		
			clickOnButton(btnMin_MaxStudentFeeGroupMappingList);
			log("clicked on Student Fee Group mapping list minimize Or maximize and object is:-"
					+ btnMin_MaxStudentFeeGroupMappingList.toString());
			
	}

	public void sortByStudentName() throws Exception {
		
			clickOnButton(btnSortByStudentName);
			clickOnButton(btnSortByStudentName);
			log("Sorted the record with Student name and object is:-" + btnSortByStudentName.toString());
			Thread.sleep(1000);
		
	}
}
