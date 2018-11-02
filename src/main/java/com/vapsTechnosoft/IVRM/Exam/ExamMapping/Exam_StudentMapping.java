/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Exam_StudentMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_StudentMapping.class.getName());

	private WebDriver driver;


	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam
	// Mapping')][1]/following::li[1]")
	// private WebElement btn_StudentMapping;

	@FindBy(xpath = "//a[@href='#/app/StudentMapping/249']")
	private WebElement btn_StudentMapping;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_StudentMapping;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Exam Category :')]/following-sibling::div/select")
	private WebElement sel_ExamCategory;

	@FindBy(xpath = "//label[contains(text(),'Subject Group :')]/following-sibling::div/select")
	private WebElement sel_SubjectGroup;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	private WebElement sel_Section;

	@FindBy(xpath = "//button[@id='save-btn']")
	private WebElement btn_Search;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//parent::button[@ng-show='!studentlist']")
	private WebElement btn_CancelSearch;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
	private WebElement btn_CancelFinal;

	@FindBy(xpath = "//div[@class='text-center']/table/tbody/tr/td[2]/label/input")
	private List<WebElement> Chk_StudentSelection;

	@FindBy(xpath = "//div[@class='text-center']/table/tbody/tr/td[6]/input")
	private List<WebElement> Chk_Sub1;

	@FindBy(xpath = "//div[@class='text-center']/table/tbody/tr/td[7]/input")
	private List<WebElement> Chk_Sub2;

	@FindBy(xpath = "//div[@class='text-center']/table/tbody/tr/td[8]/input")
	private List<WebElement> Chk_Sub3;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement input_Search;

	@FindBy(xpath = "//div[@class='text-center']/table/thead/tr/th[3]/a")
	private WebElement tab_Sort_Studentlist;

	@FindBy(xpath = "//div[@class='text-center']/table/thead/tr/th[4]/a")
	private WebElement tab_Sort_AdmNo;

	@FindBy(xpath = "//div[@class='text-center']/table/thead/tr/th[5]/a")
	private WebElement tab_Sort_RollNo;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_StudentMapping(WebDriver driver) {
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

	/**
	 * Navigate to Exam > Exam Mapping > Exam Student Mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_ExamStudentMapping() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_ExamMapping);
		log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());

		clickOnButton(btn_StudentMapping);
		log("Clicked on Student Mapping Button and object is:-" + btn_StudentMapping.toString());

	}

	/**
	 * Validation of Exam Student Mapping screen message
	 * 
	 * @return
	 */
	public boolean verifyExamStudentMappingPage() {
		try {
			System.out.println(txt_StudentMapping.getText());
			txt_StudentMapping.isDisplayed();
			log("Student Mapping  page is dispalyed and object is:-" + txt_StudentMapping.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Student Mapping Form
	 * 
	 * @param academicYear
	 * @param examCategory
	 * @param subjecGroup
	 * @param class_sm
	 * @param section_sm
	 * @throws Exception
	 */
	public void fill_StudentMapping_Form(String academicYear, String examCategory, String subjecGroup, String class_sm,
			String section_sm) throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_ExamCategory, examCategory);
		log("Selected Exam Category: " + examCategory + " and object is:- " + sel_ExamCategory.toString());

		selectElementFromDropDown(sel_SubjectGroup, subjecGroup);
		log("Selected Subject Group: " + subjecGroup + " and object is:- " + sel_SubjectGroup.toString());

		selectElementFromDropDown(sel_Class, class_sm);
		log("Selected Class: " + class_sm + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section_sm);
		log("Selected Section: " + section_sm + " and object is:- " + sel_Section.toString());

	}

	public void clickOnSearchButton_ToGetStudentSubjectList() throws Exception {

		clickOnButton(btn_Search);
		log("Clicked on Search button to get list of student and subject and object is:- " + btn_Search.toString());

	}

	public void clickOnCancelButton_ToClearSelectedRecords() throws Exception {

		clickOnButton(btn_CancelFinal);
		log("Clicked on Cancel button to clear selected and filled data and object is:- " + btn_CancelFinal.toString());

	}

	public void clickOnSaveButton_ToSubmitSelectedRecords() throws Exception {

		clickOnButton(btn_Save);
		log("Clicked on Save button to Submit selected and filled data and object is:- " + btn_Save.toString());
		Thread.sleep(2000);
	}

	public void clickOnSearchButton_ToSubmitBlankForm() throws Exception {

		clickOnButton(btn_Search);
		log("Clicked on Search button to Submit blank form and object is:- " + btn_Search.toString());

	}

	public void clickOnSaveButton_WithoutSelecting() throws Exception {

		clickOnButton(btn_Save);
		log("Clicked on Save button to Submit selected and filled data and object is:- " + btn_Save.toString());
		Thread.sleep(2000);

	}

	public void sort_StudentList() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);

		clickOnButton(tab_Sort_Studentlist);
		clickOnButton(tab_Sort_Studentlist);
		log("Clicked on student list tab to sort student in order and object is:- " + tab_Sort_Studentlist.toString());

	}

	public void sort_AdmissionNumber() throws Exception {

		clickOnButton(tab_Sort_AdmNo);
		log("Clicked on Admission Number tab to sort student in order and object is:- " + tab_Sort_AdmNo.toString());

	}

	public void sort_RollNumber() throws Exception {

		clickOnButton(tab_Sort_RollNo);
		log("Clicked on Roll Number tab to sort student in order and object is:- " + tab_Sort_RollNo.toString());

	}

	public void Search_ToFilterStudentFromList(String studentName) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);

		inputTextIntoInputField(input_Search, studentName);
		log("Search with student name: " + studentName + " to filter records and object is:- "
				+ input_Search.toString());

	}

	public void selectStudentForMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);
		// int no_Of_Student = Chk_StudentSelection.size();
		try {
			for (int i = 0; i < 3; i++) {

				if (!Chk_StudentSelection.get(i).isSelected()) {
					Chk_StudentSelection.get(i).click();
					log(i + " Student check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Student check box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deSelectStudentForMapping() throws Exception {
		try {
		int no_Of_Student = Chk_StudentSelection.size();
		for (int i = 0; i < no_Of_Student; i++) {
			if (Chk_StudentSelection.get(i).isSelected()) {
				Chk_StudentSelection.get(i).click();
				log(i + " Student check box is Unchecked.");
				Thread.sleep(1000);
			} else {
				log(i + " Student check box is already Unchecked.");
				Thread.sleep(500);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubjectForMapping_Sub1() throws Exception {
		try {
		// int no_Of_Sub1 = Chk_Sub1.size();
		for (int i = 0; i < 3; i++) {
			if (!Chk_Sub1.get(i).isSelected()) {
				Chk_Sub1.get(i).click();
				log(i + " Student subject 1 check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Student subject 1 check box is already checked.");
				Thread.sleep(500);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void selectSubjectForMapping_Sub2() throws Exception {
		try {
		// int no_Of_Sub1 = Chk_Sub2.size();
		for (int i = 0; i < 3; i++) {
			if (!Chk_Sub2.get(i).isSelected()) {
				Chk_Sub2.get(i).click();
				log(i + " Student subject 2 check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Student subject 2 check box is already checked.");
				Thread.sleep(500);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubjectForMapping_Sub3() throws Exception {
		try {
		// int no_Of_Sub1 = Chk_Sub3.size();
		for (int i = 0; i < 3; i++) {
			if (!Chk_Sub3.get(i).isSelected()) {
				Chk_Sub3.get(i).click();
				log(i + " Student subject 3 check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Student subject 3 check box is already checked.");
				Thread.sleep(500);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	/**
	 * click on OK button after Saving
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
	
			clickOnButton(btnOKSuccess);
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(2000);
	}
	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record saved successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_SubmitWithoutSelectingStudent() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Select Atleast One Student");
			log("Select Atleast One Student message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
