/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

import java.util.List;

import org.apache.log4j.Logger;
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
public class Exam_StudentMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_StudentMapping.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]/following::li[1]")
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

	public Exam_StudentMapping(WebDriver driver) {
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
	 * Navigate to Exam > Exam Mapping > Exam Student Mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_ExamStudentMapping() throws Exception {

		if (btn_Exam.isDisplayed()) {
			btn_Exam.click();
			log("Clicked on Exam Button and object is:-" + btn_Exam.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Exam Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_ExamMapping.isDisplayed()) {
			btn_ExamMapping.click();
			log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Exam Mapping Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_StudentMapping.isDisplayed()) {
			btn_StudentMapping.click();
			log("Clicked on Student Mapping Button and object is:-" + btn_StudentMapping.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Student Mapping Navigation element not present.");
			Thread.sleep(500);
		}
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

		if (sel_AcademicYear.isDisplayed()) {

			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_ExamCategory.isDisplayed()) {

			select = new Select(sel_ExamCategory);
			select.selectByVisibleText(examCategory);

			log("Selected Exam Category: " + examCategory + " and object is:- " + sel_ExamCategory.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), examCategory);
			Thread.sleep(1000);
		} else {
			log("Exam Category element is not present");
			Thread.sleep(500);
		}
		if (sel_SubjectGroup.isDisplayed()) {

			select = new Select(sel_SubjectGroup);
			select.selectByVisibleText(subjecGroup);

			log("Selected Subject Group: " + subjecGroup + " and object is:- " + sel_SubjectGroup.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), subjecGroup);
			Thread.sleep(1000);
		} else {
			log("Subject Group element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {

			select = new Select(sel_Class);
			select.selectByVisibleText(class_sm);

			log("Selected Class: " + class_sm + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_sm);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {

			select = new Select(sel_Section);
			select.selectByVisibleText(section_sm);

			log("Selected Section: " + section_sm + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_sm);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void clickOnSearchButton_ToGetStudentSubjectList() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Clicked on Search button to get list of student and subject and object is:- " + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearSelectedRecords() throws Exception {
		if (btn_CancelFinal.isDisplayed()) {
			btn_CancelFinal.click();
			log("Clicked on Cancel button to clear selected and filled data and object is:- "
					+ btn_CancelFinal.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitSelectedRecords() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit selected and filled data and object is:- " + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnSearchButton_ToSubmitBlankForm() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Clicked on Search button to Submit blank form and object is:- " + btn_Search.toString());
			Thread.sleep(5000);
		} else {
			log("Search button element is not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnSaveButton_WithoutSelecting() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit selected and filled data and object is:- " + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}
	public void sort_StudentList() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);
		if (tab_Sort_Studentlist.isDisplayed()) {
			tab_Sort_Studentlist.click();
			Thread.sleep(1000);
			tab_Sort_Studentlist.click();
			log("Clicked on student list tab to sort student in order and object is:- "
					+ tab_Sort_Studentlist.toString());
			Thread.sleep(1000);
		} else {
			log("Student list tab button element is not present.");
			Thread.sleep(500);
		}
	}

	public void sort_AdmissionNumber() throws Exception {
		if (tab_Sort_AdmNo.isDisplayed()) {
			tab_Sort_AdmNo.click();

			log("Clicked on Admission Number tab to sort student in order and object is:- "
					+ tab_Sort_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number tab button element is not present.");
			Thread.sleep(500);
		}
	}

	public void sort_RollNumber() throws Exception {
		if (tab_Sort_RollNo.isDisplayed()) {
			tab_Sort_RollNo.click();

			log("Clicked on Roll Number tab to sort student in order and object is:- " + tab_Sort_RollNo.toString());
			Thread.sleep(1000);
		} else {
			log("Roll Number tab button element is not present.");
			Thread.sleep(500);
		}
	}

	public void Search_ToFilterStudentFromList(String studentName) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(studentName);
			log("Search with student name: " + studentName + " to filter records and object is:- "
					+ input_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search field element is not present.");
			Thread.sleep(500);
		}
	}

	public void selectStudentForMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_StudentMapping);
		Thread.sleep(1000);
		// int no_Of_Student = Chk_StudentSelection.size();
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
	}
	public void deSelectStudentForMapping() throws Exception {
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
	}

	public void selectSubjectForMapping_Sub1() throws Exception {
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
	}

	public void selectSubjectForMapping_Sub2() throws Exception {
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
	}

	public void selectSubjectForMapping_Sub3() throws Exception {
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
	}
	/**
	 * click on OK button after Saving
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

}
