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
public class Exam_MarksEntry extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MarksEntry.class.getName());

	private WebDriver driver;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::li[1]")
	private WebElement btn_Exam_MarksEntry;
	
//	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Marks Enrty')][1]/following::li[1]")
//	private WebElement btn_MarksEntry;
	
	@FindBy(xpath = "//a[@href='#/app/MarksEntry/252']")
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
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_MarksEntry(WebDriver driver) {
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

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_Exam_MarksEntry);
		log("Clicked on Exam Marks Entry Button and object is:-" + btn_Exam_MarksEntry.toString());

		clickOnButton(btn_MarksEntry);
		log("Clicked on Marks Entry Button and object is:-" + btn_MarksEntry.toString());

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

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
		
			selectElementFromDropDown(sel_Class, class_Me);
			log("Selected Class: " + class_Me + " and object is:- " + sel_Class.toString());
		
			selectElementFromDropDown(sel_Section, section);
			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
	
			selectElementFromDropDown(sel_ExamType, examType);
			log("Selected Exam: " + examType + " and object is:- " + sel_ExamType.toString());
	
			selectElementFromDropDown(sel_Subject, subject);
			log("Selected Subject: " + subject + " and object is:- " + sel_Subject.toString());
			

	}

	public void clickOnSearchButton_ToGetStudentMarksEntryList() throws Exception {
	
			clickOnButton(btn_Search);
			log("Clicked on Search button to get list of student and object is:- " + btn_Search.toString());
			
	}

	public void clickOnCancelButton_ToClearFilledRecords() throws Exception {
		
			clickOnButton(btn_Cancel2);
			log("Clicked on Cancel button to clear filled data and object is:- " + btn_Cancel2.toString());
			
	}

	public void marksEntryFor_StudentMarksObtain(String marksobtains) throws Exception {
	
			inputTextIntoInputField(input_ObtainMarks, marksobtains);
			log("Entered Marks Obtain: " + marksobtains + " to filter records and object is:- "
					+ input_ObtainMarks.toString());
		}

	public void clickOnSaveButton_ToSubmitFilledRecords() throws Exception {
	
			clickOnButton(btn_Save);
			log("Clicked on Save button to Submit filled data and object is:- " + btn_Save.toString());
			Thread.sleep(1000);
		
	}

	public void sort_ByStudentName() throws Exception {

			clickOnButton(btnHdr_sort_StudentName);
			clickOnButton(btnHdr_sort_StudentName);
			log("Clicked on student Name tab to sort student in order and object is:- "
					+ btnHdr_sort_StudentName.toString());
		
	}

	public void sort_ByRollNumber() throws Exception {
		
			clickOnButton(btnHdr_sort_RollNo);
			clickOnButton(btnHdr_sort_RollNo);
			log("Clicked on Roll Number tab to sort student in order and object is:- " + btnHdr_sort_RollNo.toString());
			
	}

	public void sort_ByMarksObtain() throws Exception {
	
			clickOnButton(btnHdr_sort_ObtainMarks);
			clickOnButton(btnHdr_sort_ObtainMarks);
			log("Clicked on Marks Obtain tab to sort student in order and object is:- "
					+ btnHdr_sort_ObtainMarks.toString());
		
	}

	public void filterRecordsBasedOn_StudentName(String studentName, String admNumber, String rollNumber)
			throws Exception {
	
			inputTextIntoInputField(filter_StudentName, studentName);
			log("Entered Student Name: " + studentName + " to filter records and object is:- "
					+ filter_StudentName.toString());
			isDisplayed(txt_StudentName1StCell);
		assertEquals(studentName, txt_StudentName1StCell.getText().trim());
		log("Filtered student is available in the grid and object is:-" + txt_StudentName1StCell.toString());
		Thread.sleep(500);
	}

	public void filterRecordsBasedOn_AdmissionNum(String studentName, String admNumber, String rollNumber)
			throws Exception {
	
			inputTextIntoInputField(filter_AdmNumber, admNumber);
			log("Entered Admission Number: " + admNumber + " to filter records and object is:- "
					+ filter_AdmNumber.toString());
			
	}

	public void filterRecordsBasedOn_RollNumber(String studentName, String admNumber, String rollNumber)
			throws Exception {
	
			inputTextIntoInputField(filter_RollNumber, rollNumber);
			log("Entered Roll Number: " + rollNumber + " to filter records and object is:- "
					+ filter_RollNumber.toString());
			
	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(filter_StudentName);
		filter_StudentName.clear();
		isDisplayed(filter_AdmNumber);
		filter_AdmNumber.clear();
		isDisplayed(filter_RollNumber);
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
	
			clickOnButton(btnOKSuccess);
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(1000);
		
	}

	public void min_Max_MarksEntryFormSection() throws Exception {

			clickOnButton(btn_Min_Max_MarksEntry);
			log("Marks Entry Section minimized or maximized and object is:-" + btn_Min_Max_MarksEntry.toString());
			
	}

	public void min_Max_StudentMarksDetailsSection() throws Exception {

			clickOnButton(btn_Min_Max_StudentMarksDetails);
			log("Student Marks Details Section minimized or maximized and object is:-"
					+ btn_Min_Max_StudentMarksDetails.toString());
			
	}
	public void popUpWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Data Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
