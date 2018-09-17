/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.MarksEntry;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;


/**
 * Staff Login, UserName: Priya and Password: Password@123
 * 
 * @author Arvind
 *
 */

public class Exam_MarksEntry_After_MarksCalculation extends TestBase{
	
	public static final Logger log = Logger.getLogger(Exam_MarksEntry_After_MarksCalculation.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::li[1]")
	private WebElement btn_Exam_MarksEntry;
	
	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Marks Enrty')][1]/following::li[1]")
	private WebElement btn_MarksEntry;
	
	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_Exam_MarksEntryPage;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	private WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Exam :')]/following-sibling::div/select")
	private WebElement sel_ExamType;

	@FindBy(xpath = "//label[contains(text(),'Subject :')]/following-sibling::div/select")
	private WebElement sel_Subject;

	@FindBy(xpath = "//span[contains(text(),'Search')]/parent::button")
	private WebElement btn_Search;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	private WebElement btn_Cancel2;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Student Name')]/parent::div")
	private WebElement btnHdr_sort_StudentName;

	@FindBy(xpath = "//span[contains(text(),'Roll No')]/parent::div")
	private WebElement btnHdr_sort_RollNo;

	@FindBy(xpath = "//span[contains(text(),'Obtain Marks')]/parent::div")
	private WebElement btnHdr_sort_ObtainMarks;

	@FindBy(xpath = "(//input[@ng-model='colFilter.term'])[1]")
	private WebElement filter_StudentName;

	@FindBy(xpath = "(//input[@ng-model='colFilter.term'])[2]")
	private WebElement filter_AdmNumber;

	@FindBy(xpath = "(//input[@ng-model='colFilter.term'])[3]")
	private WebElement filter_RollNumber;

	@FindBy(xpath = "(//div[contains(@id,'-cell')])[2]/div")
	private WebElement txt_StudentName1StCell;

	@FindBy(xpath = "(//div[contains(@id,'-cell')])[8]/div/input")
	private WebElement input_ObtainMarks;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_MarksEntry;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_StudentMarksDetails;
	
	@FindBy(xpath = "//button[text()='Cancel..!']")
	private WebElement btn_Cancel_PopUp;
	
	@FindBy(xpath = "//button[text()='Yes, Update It!']")
	private WebElement btn_YesUpdateIt;
	
	
	
	
	

	public Exam_MarksEntry_After_MarksCalculation(WebDriver driver) {
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
	 * Navigate to Exam > Marks Entry
	 * 
	 * @throws Exception
	 */
	public void navigateToExam_MarksEntry() throws Exception {

		if (btn_Exam.isDisplayed()) {
			btn_Exam.click();
			log("Clicked on Exam Button and object is:-" + btn_Exam.toString());
			Thread.sleep(1000);
		} else {
			log("Exam Navigation element not present and object is:-" + btn_Exam.toString());
			Thread.sleep(500);
		}
		if (btn_Exam_MarksEntry.isDisplayed()) {
			btn_Exam_MarksEntry.click();
			log("Clicked on Exam Marks Entry Button and object is:-" + btn_Exam_MarksEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Entry sub section Navigation element not present and object is:-" + btn_Exam_MarksEntry.toString());
			Thread.sleep(500);
		}
		
		if (btn_MarksEntry.isDisplayed()) {
			btn_MarksEntry.click();
			log("Clicked on Marks Entry Button and object is:-" + btn_MarksEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Entry Navigation element not present and object is:-" + btn_MarksEntry.toString());
			Thread.sleep(500);
		}	
	}

	/**
	 * Validation of Exam Marks Entry page path
	 * 
	 * @return
	 */
	public boolean verifyExam_MarksEntryPage() {
		try {
			System.out.println(txt_Exam_MarksEntryPage.getText());
			txt_Exam_MarksEntryPage.isDisplayed();
			log("Exam Marks Entry page is dispalyed and object is:-" + txt_Exam_MarksEntryPage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Marks Entry
	 * 
	 * @param academicYear
	 * @param class_Me
	 * @param section
	 * @param examType
	 * @param subject
	 * @throws Exception
	 */
	public void fill_MarksEntry_Form(String academicYear, String class_Me, String section, String examType,
			String subject) throws Exception {

		if (sel_AcademicYr.isDisplayed()) {

			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present and object is:- " + sel_AcademicYr.toString());
			Thread.sleep(500);
		}

		if (sel_Class.isDisplayed()) {

			select = new Select(sel_Class);
			select.selectByVisibleText(class_Me);

			log("Selected Class: " + class_Me + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Me);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_Class.toString());
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {

			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(2000);
		} else {
			log("Section element is not present and object is:- " + sel_Section.toString());
			Thread.sleep(500);
		}
		if (sel_ExamType.isDisplayed()) {

			select = new Select(sel_ExamType);
			select.selectByVisibleText(examType);

			log("Selected Exam: " + examType + " and object is:- " + sel_ExamType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), examType);
			Thread.sleep(2000);
		} else {
			log("Exam element is not present and object is:- " + sel_ExamType.toString());
			Thread.sleep(500);
		}
		if (sel_Subject.isDisplayed()) {

			select = new Select(sel_Subject);
			select.selectByVisibleText(subject);

			log("Selected Subject: " + subject + " and object is:- " + sel_Subject.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), subject);
			Thread.sleep(2000);
		} else {
			log("Subject element is not present and object is:- " + sel_Subject.toString());
			Thread.sleep(500);
		}

	}

	public void clickOnSearchButton_ToGetStudentMarksEntryList() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Clicked on Search button to get list of student and object is:- " + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search button element is not presentand object is:- " + btn_Search.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearFilledRecords() throws Exception {
		if (btn_Cancel2.isDisplayed()) {
			btn_Cancel2.click();
			log("Clicked on Cancel button to clear filled data and object is:- " + btn_Cancel2.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel button element is not present and object is:- " + btn_Cancel2.toString());
			Thread.sleep(500);
		}
	}
	public void marksEntryFor_StudentMarksObtain(String marksobtains) throws Exception{
		if (input_ObtainMarks.isDisplayed()) {
			input_ObtainMarks.clear();
			input_ObtainMarks.sendKeys(marksobtains);
			log("Entered Marks Obtain: " + marksobtains + " to filter records and object is:- "
					+ input_ObtainMarks.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Obtain input field element not present in output grid and object is:- "
					+ input_ObtainMarks.toString());
			Thread.sleep(500);
		}
		
		
	}

	public void clickOnSaveButton_ToSubmitFilledRecords() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit filled data and object is:- " + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present and object is:- " + btn_Save.toString());
			Thread.sleep(500);
		}
	}

	public void sort_ByStudentName() throws Exception {

		if (btnHdr_sort_StudentName.isDisplayed()) {
			btnHdr_sort_StudentName.click();
			Thread.sleep(1000);
			btnHdr_sort_StudentName.click();
			log("Clicked on student Name tab to sort student in order and object is:- "
					+ btnHdr_sort_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("student Name tab element is not present and object is:- " + btnHdr_sort_StudentName.toString());
			Thread.sleep(500);
		}
	}

	public void sort_ByRollNumber() throws Exception {
		if (btnHdr_sort_RollNo.isDisplayed()) {
			btnHdr_sort_RollNo.click();
			Thread.sleep(1000);
			btnHdr_sort_RollNo.click();
			log("Clicked on Roll Number tab to sort student in order and object is:- "
					+ btnHdr_sort_RollNo.toString());
			Thread.sleep(1000);
		} else {
			log("Roll Number tab button element is not present and object is:- "
					+ btnHdr_sort_RollNo.toString());
			Thread.sleep(500);
		}
	}

	public void sort_ByMarksObtain() throws Exception {
		if (btnHdr_sort_ObtainMarks.isDisplayed()) {
			btnHdr_sort_ObtainMarks.click();
			Thread.sleep(1000);
			btnHdr_sort_ObtainMarks.click();
			log("Clicked on Marks Obtain tab to sort student in order and object is:- " + btnHdr_sort_ObtainMarks.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Obtain tab button element is not present and object is:- " + btnHdr_sort_ObtainMarks.toString());
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_StudentName(String studentName, String admNumber, String rollNumber) throws Exception {
		if (filter_StudentName.isDisplayed()) {
			filter_StudentName.clear();
			filter_StudentName.sendKeys(studentName);
			log("Entered Student Name: " + studentName + " to filter records and object is:- "
					+ filter_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name input field element not present and object is:- "
					+ filter_StudentName.toString());
			Thread.sleep(500);
		}
		assertEquals(studentName, txt_StudentName1StCell.getText().trim());
		log("Filtered student is available in the grid and object is:-"+txt_StudentName1StCell.toString());
		Thread.sleep(500);
	}

	public void filterRecordsBasedOn_AdmissionNum(String studentName, String admNumber, String rollNumber)
			throws Exception {
		if (filter_AdmNumber.isDisplayed()) {
			filter_AdmNumber.clear();
			filter_AdmNumber.sendKeys(admNumber);
			log("Entered Admission Number: " + admNumber + " to filter records and object is:- "
					+ filter_AdmNumber.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number input field element not present in output grid and object is:- "
					+ filter_AdmNumber.toString());
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_RollNumber(String studentName, String admNumber, String rollNumber)
			throws Exception {
		if (filter_RollNumber.isDisplayed()) {
			filter_RollNumber.clear();
			filter_RollNumber.sendKeys(rollNumber);
			log("Entered Roll Number: " + rollNumber + " to filter records and object is:- "
					+ filter_RollNumber.toString());
			Thread.sleep(1000);
		} else {
			log("Roll Number input field element not present in output grid and object is:- "
					+ filter_RollNumber.toString());
			Thread.sleep(500);
		}
	}
	public void clearFilledDataForFilter() throws Exception {
		filter_StudentName.clear();
		filter_AdmNumber.clear();
		filter_RollNumber.clear();
		log("Cleared filter data in Student marks details.");
		Thread.sleep(1000);
	}
	
	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}
	public void min_Max_MarksEntryFormSection() throws Exception {
		
		if (btn_Min_Max_MarksEntry.isDisplayed()) {
			btn_Min_Max_MarksEntry.click();
			log("Marks Entry Section minimized or maximized and object is:-"
					+ btn_Min_Max_MarksEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Entry Section Minimized OR Maximize Element not present and object is:-"
					+ btn_Min_Max_MarksEntry.toString());
		}
	}
	
public void min_Max_StudentMarksDetailsSection() throws Exception {
		
		if (btn_Min_Max_StudentMarksDetails.isDisplayed()) {
			btn_Min_Max_StudentMarksDetails.click();
			log("Student Marks Details Section minimized or maximized and object is:-"
					+ btn_Min_Max_StudentMarksDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Student Marks Details Section Minimized OR Maximize Element not present and object is:-"
					+ btn_Min_Max_StudentMarksDetails.toString());
		}
	}
public void clickOnCancelButton_ToCancelSubmission() throws Exception {
	if (btn_Cancel_PopUp.isDisplayed()) {
		btn_Cancel_PopUp.click();
		log("Clicked on Cancel button pop up window to Cancel sumit marks and object is:- " + btn_Cancel_PopUp.toString());
		Thread.sleep(3000);
	} else {
		log("Cancel pop up button element is not present and object is:- " + btn_Cancel_PopUp.toString());
		Thread.sleep(500);
	}
}

public void clickOnUpdateItButton_ToUpDateMarks() throws Exception {
	if (btn_YesUpdateIt.isDisplayed()) {
		btn_YesUpdateIt.click();
		log("Clicked on Yes Update it button pop up window to update marks and object is:- " + btn_YesUpdateIt.toString());
		Thread.sleep(3000);
	} else {
		log("Yes Update it button element is not present and object is:- " + btn_YesUpdateIt.toString());
		Thread.sleep(500);
	}
}
}
