/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Exam_Subject_Wizard extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_Subject_Wizard.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;
	private Actions builder;
	private Action dragAndDrop;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]/following::li[2]")
	private WebElement btn_ExamSubjectWizard;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_ExamSubjectWizard;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Grade :')]/following-sibling::div/select")
	private WebElement sel_Grade;

	@FindBy(xpath = "//label[contains(text(),'Category :')]/following-sibling::div/select")
	private WebElement sel_Category;

	@FindBy(xpath = "//input[@name='examoption']")
	private List<WebElement> Chk_Exam;

	@FindBy(xpath = "(//label[contains(text(),'Attendance From :')]/following-sibling::div//child::button)[1]")
	private WebElement btn_FromCalender;

	@FindBy(xpath = "//span[contains(text(),'May 2018')]")
	private WebElement btn_MonthYear_From;

	@FindBy(xpath = "//span[contains(text(),'May 2018')]/following::td[3]")
	private WebElement btn_Date_From;

	@FindBy(xpath = "(//label[contains(text(),'Attendance To :')]/following-sibling::div//child::button)[1]")
	private WebElement btn_ToCalender;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	private WebElement btn_MonthYear_To;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]/following::td[20]")
	private WebElement btn_Date_To;

	@FindBy(xpath = "//input[@name='fhcbx']")
	private WebElement chk_SubExamApplicable;

	@FindBy(xpath = "//input[@name='fghbx']")
	private WebElement chk_SubSubjectApplicable;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	private WebElement btn_Cancel;

	@FindBy(xpath = "(//span[contains(text(),'Set  Order')]/parent::button)[1]")
	private WebElement btn_SetOrder;

	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement btn_SetOrder_Save;

	@FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
	private WebElement btn_SetOrder_Close;

	@FindBy(xpath = "(//table//tbody//tr[3])[2]")
	private WebElement btn_SetOrder_Source;

	@FindBy(xpath = "(//table//tbody//tr[1])[4]")
	private WebElement btn_SetOrder_Destination;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr")
	List<WebElement> tbl_Rows;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[2]/label/input")
	private WebElement chk_Subject1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[4]/input")
	private WebElement input_MaxMarks_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[5]/input")
	private WebElement input_MinMarks_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[6]/input")
	private WebElement input_MaxEntryMarks_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[2]/label/input")
	private WebElement chk_Subject2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[4]/input")
	private WebElement input_MaxMarks_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[5]/input")
	private WebElement input_MinMarks_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[6]/input")
	private WebElement input_MaxEntryMarks_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[2]/label/input")
	private WebElement chk_Subject3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[4]/input")
	private WebElement input_MaxMarks_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[5]/input")
	private WebElement input_MinMarks_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[6]/input")
	private WebElement input_MaxEntryMarks_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[7]//label[1]/input")
	private WebElement rdBtn_Marks_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[7]//label[2]/input")
	private WebElement rdBtn_Grade_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[7]//label[1]/input")
	private WebElement rdBtn_Marks_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[7]//label[2]/input")
	private WebElement rdBtn_Grade_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[7]//label[1]/input")
	private WebElement rdBtn_Marks_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[7]//label[2]/input")
	private WebElement rdBtn_Grade_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[8]/label/input")
	private WebElement chk_MarksDispaly_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[8]/label/input")
	private WebElement chk_MarksDispaly_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[8]/label/input")
	private WebElement chk_MarksDispaly_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[9]/label/input")
	private WebElement chk_GradeDispaly_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[9]/label/input")
	private WebElement chk_GradeDispaly_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[9]/label/input")
	private WebElement chk_GradeDispaly_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[10]/label/input")
	private WebElement chk_ApplyToResult_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[10]/label/input")
	private WebElement chk_ApplyToResult_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[10]/label/input")
	private WebElement chk_ApplyToResult_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[11]/select")
	private WebElement sel_Grade_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[11]/select")
	private WebElement sel_Grade_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[11]/select")
	private WebElement sel_Grade_Sub3;

	@FindBy(xpath = "//span[text()='Academic Year']")
	private WebElement btn_Sort_AcademicYear;

	@FindBy(xpath = "//span[text()='Academic Year']/following::div[2]/div/input")
	private WebElement input_AcademicYear;

	@FindBy(xpath = "//span[text()='Category Name']")
	private WebElement btn_Sort_CategoryName;

	@FindBy(xpath = "//span[text()='Category Name']/following::div[2]/div/input")
	private WebElement input_CategoryName;

	@FindBy(xpath = "//span[text()='Exam Name']")
	private WebElement btn_Sort_ExamName;

	@FindBy(xpath = "//span[text()='Exam Name']/following::div[2]/div/input")
	private WebElement input_ExamName;

	@FindBy(xpath = "//span[text()='Grade Name']")
	private WebElement btn_Sort_GradeName;

	@FindBy(xpath = "//span[text()='Grade Name']/following::div[2]/div/input")
	private WebElement input_GradeName;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[10]/div/a[1]")
	private WebElement btn_View;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[10]/div/a[2]")
	private WebElement btn_Edit;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[10]/div/span")
	private WebElement btn_DeactivateOrActivate;

	@FindBy(xpath = "(//button[text()='Close'])[6]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateOrActivateit;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btn_PopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxExamSubjectWizard;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxExamSubjectWizardGridView;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[7]/label/input")
	private WebElement chk_subExam_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[1]/td[8]/label/input")
	private WebElement chk_subSubject_Sub1;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[7]/label/input")
	private WebElement chk_subExam_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[2]/td[8]/label/input")
	private WebElement chk_subSubject_Sub2;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[7]/label/input")
	private WebElement chk_subExam_Sub3;

	@FindBy(xpath = "//table[@ng-show='select_cat']//tbody/tr[3]/td[8]/label/input")
	private WebElement chk_subSubject_Sub3;

	// Sub Exam Mapping

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[2]/label/input")
	private WebElement chk_subExamMapPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[2]/label/input")
	private WebElement chk_subExamMapPopUpWin_Sub2;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[4]/input")
	private WebElement input_maxMarksSubExamPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[5]/input")
	private WebElement input_minMarksSubExamPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[4]/input")
	private WebElement input_maxMarksSubExamPopUpWin_Sub2;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[5]/input")
	private WebElement input_minMarksSubExamPopUpWin_Sub2;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[6]/select")
	private WebElement sel_gradeSubExamPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[6]/select")
	private WebElement sel_gradeSubExamPopUpWin_Sub2;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[7]/label/input")
	private WebElement chk_ExemptedFlagsubExamPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[7]/label/input")
	private WebElement chk_ExemptedFlagsubExamPopUpWin_Sub2;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[1]/td[8]/input")
	private WebElement input_ExemptedPercentagesubExamPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm2']//table//tbody/tr[2]/td[8]/input")
	private WebElement input_ExemptedPercentagesubExamPopUpWin_Sub2;

	@FindBy(xpath = "(//span[contains(text(),'ADD & Close')]//parent::button)[2]")
	private WebElement btn_AddAndClose_SubExamWindow;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]//parent::button)[3]")
	private WebElement btn_Cancel_SubExamWindow;

	@FindBy(xpath = "(//span[contains(text(),'Set  Order')]//parent::button)[3]")
	private WebElement btn_SetOrder_SubExamWindow;
	
	@FindBy(xpath = "(//button[text()='Close'])[5]")
	private WebElement btn_SetOrder_Close_subExam;
	
	@FindBy(xpath = "(//button[text()='Save'])[3]")
	private WebElement btn_SetOrder_Save_subExam;
 
	@FindBy(xpath = "(//div[@class='modal-body']/table)[3]//tbody//tr[1]")
	private WebElement source_SetOrder_subExam;
	
	@FindBy(xpath = "(//div[@class='modal-body']/table)[3]//tbody//tr[2]")
	private WebElement destination_SetOrder_subExam;
	
	@FindBy(xpath = "(//button[text()='Close'])[2]")
	private WebElement btn_Close_SubExamWindow;
	
	

	// Sub Subject Mapping
	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[2]/label/input")
	private WebElement chk_subSubjectMapPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[4]/input")
	private WebElement input_maxMarksSubSubjectPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[5]/input")
	private WebElement input_minMarksSubSubjectPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[6]/select")
	private WebElement sel_gradeSubSubjectPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[7]/label/input")
	private WebElement chk_ExemptedFlagsubSubjectPopUpWin_Sub1;

	@FindBy(xpath = "//form[@name='myForm1']//table//tbody/tr[1]/td[8]/input")
	private WebElement input_ExemptedPercentagesubSubjectPopUpWin_Sub1;

	@FindBy(xpath = "(//span[contains(text(),'ADD & Close')]//parent::button)[1]")
	private WebElement btn_AddAndClose_SubSubjectWindow;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]//parent::button)[2]")
	private WebElement btn_Cancel_SubSubjectWindow;

	@FindBy(xpath = "(//span[contains(text(),'Set  Order')]//parent::button)[2]")
	private WebElement btn_SetOrder_SubSubjectWindow;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_Close_SubSubjectWindow;

	public Exam_Subject_Wizard(WebDriver driver) {
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
	 * Navigate to Exam > Exam Mapping > Exam Subject Wizard
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_ExamSubjectWizard() throws Exception {

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
		if (btn_ExamSubjectWizard.isDisplayed()) {
			btn_ExamSubjectWizard.click();
			log("Clicked on Exam Subject Wizard Button and object is:-" + btn_ExamSubjectWizard.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);

			Thread.sleep(10000);
		} else {
			log("Exam Subject Wizard Navigation element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of Exam Subject Wizard screen message
	 * 
	 * @return
	 */
	public boolean verifyExamSubjectWizardPage() {
		try {
			System.out.println(txt_ExamSubjectWizard.getText());
			txt_ExamSubjectWizard.isDisplayed();
			log("Exam Subject Wizard page is dispalyed and object is:-" + txt_ExamSubjectWizard.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Subject Wizard Form without selecting sub-Exam and sub-Subject
	 * applicable
	 * 
	 * @param academicYear
	 * @param grade
	 * @param category
	 * @throws Exception
	 */
	public void fill_ExamSubjectWizard_Form(String academicYear, String grade, String category) throws Exception {
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
		if (sel_Grade.isDisplayed()) {

			select = new Select(sel_Grade);
			select.selectByVisibleText(grade);

			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade);
			Thread.sleep(1000);
		} else {
			log("Grade element is not present");
			Thread.sleep(500);
		}
		if (sel_Category.isDisplayed()) {

			select = new Select(sel_Category);
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(2000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}

		int no_Of_Subjects = Chk_Exam.size();
		for (int i = 0; i < no_Of_Subjects; i++) {
			if (!Chk_Exam.get(i).isSelected()) {
				Chk_Exam.get(i).click();
				log(i + " Subject check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Subject checked box is already checked.");
				Thread.sleep(500);
			}
		}

		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Exam Subject Wizard Form,selecting sub-Exam applicable
	 * 
	 * @param academicYear
	 * @param grade
	 * @param category
	 * @throws Exception
	 */
	public void fill_ExamSubjectWizard_Form_SubExamApplicable(String academicYear, String grade, String category)
			throws Exception {
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
		if (sel_Grade.isDisplayed()) {

			select = new Select(sel_Grade);
			select.selectByVisibleText(grade);

			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade);
			Thread.sleep(1000);
		} else {
			log("Grade element is not present");
			Thread.sleep(500);
		}
		if (sel_Category.isDisplayed()) {

			select = new Select(sel_Category);
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(1000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}

		int no_Of_Subjects = Chk_Exam.size();
		for (int i = 0; i < no_Of_Subjects; i++) {
			if (!Chk_Exam.get(i).isSelected()) {
				Chk_Exam.get(i).click();
				log(i + " Subject check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Subject checked box is already checked.");
				Thread.sleep(500);
			}
		}

		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (!chk_SubExamApplicable.isSelected()) {
			chk_SubExamApplicable.click();
			log("Sub-Exam applicable check box is checked and object is:- " + chk_SubExamApplicable.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-Exam applicable element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Exam Subject Wizard Form,selecting sub-Subject applicable
	 * 
	 * @param academicYear
	 * @param grade
	 * @param category
	 * @throws Exception
	 */
	public void fill_ExamSubjectWizard_Form_SubSubjectApplicable(String academicYear, String grade, String category)
			throws Exception {
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
		if (sel_Grade.isDisplayed()) {

			select = new Select(sel_Grade);
			select.selectByVisibleText(grade);

			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade);
			Thread.sleep(1000);
		} else {
			log("Grade element is not present");
			Thread.sleep(500);
		}
		if (sel_Category.isDisplayed()) {

			select = new Select(sel_Category);
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(1000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}

		int no_Of_Subjects = Chk_Exam.size();
		for (int i = 0; i < no_Of_Subjects; i++) {
			if (!Chk_Exam.get(i).isSelected()) {
				Chk_Exam.get(i).click();
				log(i + " Subject check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Subject checked box is already checked.");
				Thread.sleep(500);
			}
		}

		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (!chk_SubSubjectApplicable.isSelected()) {
			chk_SubSubjectApplicable.click();
			log("Sub-Subject applicable check box is checked and object is:- " + chk_SubSubjectApplicable.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-Subject applicable element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Exam Subject Wizard Form,selecting sub-Exam and sub-Subject
	 * applicable
	 * 
	 * @param academicYear
	 * @param grade
	 * @param category
	 * @throws Exception
	 */
	public void fill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable(String academicYear, String grade,
			String category) throws Exception {
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
		if (sel_Grade.isDisplayed()) {

			select = new Select(sel_Grade);
			select.selectByVisibleText(grade);

			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade);
			Thread.sleep(1000);
		} else {
			log("Grade element is not present");
			Thread.sleep(500);
		}
		if (sel_Category.isDisplayed()) {

			select = new Select(sel_Category);
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(1000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}

		int no_Of_Subjects = Chk_Exam.size();
		for (int i = 0; i < no_Of_Subjects; i++) {
			if (!Chk_Exam.get(i).isSelected()) {
				Chk_Exam.get(i).click();
				log(i + " Subject check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Subject checked box is already checked.");
				Thread.sleep(500);
			}
		}

		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
		if (!chk_SubExamApplicable.isSelected()) {
			chk_SubExamApplicable.click();
			log("Sub-Exam applicable check box is checked and object is:- " + chk_SubExamApplicable.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-Exam applicable element is not present.");
			Thread.sleep(500);
		}
		if (!chk_SubSubjectApplicable.isSelected()) {
			chk_SubSubjectApplicable.click();
			log("Sub-Subject applicable check box is checked and object is:- " + chk_SubSubjectApplicable.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-Subject applicable element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Submit blank Exam Subject Wizard form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_ExamSubjectWizardForm() throws Exception {

		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Exam Subject Wizard form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Click on save button to save Exam Subject Wizard data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitExamSubjectWizardForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button to Submit the records for Exam Subject Wizard and object is:-"
					+ btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save Element not present");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearFilledExamSubjectWizardForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("clicked on Cancel button to clear filled data for Exam Subject Wizard and object is:-"
					+ btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel Element not present");
			Thread.sleep(500);
		}
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

	public void sortWithAcademicYearInGridView() throws Exception {

		if (btn_Sort_AcademicYear.isDisplayed()) {
			btn_Sort_AcademicYear.click();
			log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());
			Thread.sleep(1000);
		} else {
			log("Academic Year button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithExamNameInGridView() throws Exception {

		if (btn_Sort_ExamName.isDisplayed()) {
			btn_Sort_ExamName.click();
			log("Sort by Exam Name in grid view and object is:- " + btn_Sort_ExamName.toString());
			Thread.sleep(1000);
		} else {
			log("Exam Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithCategoryNameInGridView() throws Exception {

		if (btn_Sort_CategoryName.isDisplayed()) {
			btn_Sort_CategoryName.click();
			log("Sort by Category Name in grid view and object is:- " + btn_Sort_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithGradeNameInGridView() throws Exception {

		if (btn_Sort_GradeName.isDisplayed()) {
			btn_Sort_GradeName.click();
			log("Sort by Grade Name in grid view and object is:- " + btn_Sort_GradeName.toString());
			Thread.sleep(1000);
		} else {
			log("Grade Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
		if (input_AcademicYear.isDisplayed()) {
			input_AcademicYear.clear();
			input_AcademicYear.sendKeys(academicYear);
			log("Entered academic year " + academicYear + " to filter records and object is:- "
					+ input_AcademicYear.toString());
			Thread.sleep(1000);
		} else {
			log("Academic year input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
		if (input_CategoryName.isDisplayed()) {
			input_CategoryName.clear();
			input_CategoryName.sendKeys(categoryName);
			log("Entered Category Name " + categoryName + " to filter records and object is:- "
					+ input_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_GradeName(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
		if (input_GradeName.isDisplayed()) {
			input_GradeName.clear();
			input_GradeName.sendKeys(gradeName);
			log("Entered Grade Name " + gradeName + " to filter records and object is:- " + input_GradeName.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void clearFilledDataForFilter() throws Exception {
		input_AcademicYear.clear();
		input_CategoryName.clear();
		input_GradeName.clear();
		input_ExamName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeExamAndSubjectMapped() throws Exception {

		if (btn_View.isDisplayed()) {
			btn_View.click();
			log("Clicked on View Icon to launch pop up windows to see created exam subject wizard and object is:-"
					+ btn_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			Thread.sleep(1000);
		} else {
			log("View Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnEditIcon_ToUpdateCategorySubjectMapping() throws Exception {

		if (btn_Edit.isDisplayed()) {
			btn_Edit.click();
			log("Clicked on Edit Icon to update Exam subject wizard and object is:-" + btn_Edit.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnDeActivationIcon_ToDeactivateExamSubjectWizard() throws Exception {

		if (btn_DeactivateOrActivate.isDisplayed()) {

			String DeactivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			btn_DeactivateOrActivate.click();
			log("Clicked on Deacivate Icon to Deactivate Exam Subject Wizard and object is:-"
					+ btn_DeactivateOrActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnActivationIcon_ToActivateExamSubjectWizard() throws Exception {

		if (btn_DeactivateOrActivate.isDisplayed()) {

			String ActivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present(Activate) :- " + ActivateText);

			// Compare tool tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			btn_DeactivateOrActivate.click();
			log("Clicked on Activate Icon to Activate Exam Subject Wizard and object is:-"
					+ btn_DeactivateOrActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void closeViewPopUpWindows() throws Exception {
		if (btn_View_ClosePopUp.isDisplayed()) {
			btn_View_ClosePopUp.click();
			log("View pop Up windows is closed and object is:-" + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertFalse(closeButton);
			Thread.sleep(1000);
		} else {
			log("Close button element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Confirmation for deactivate and activate
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivateAndActivate() throws Exception {
		if (btnPopUpYesDeactivateOrActivateit.isDisplayed()) {
			btnPopUpYesDeactivateOrActivateit.click();
			log("Clicked Yes deactivate Or Activate it button and object is:"
					+ btnPopUpYesDeactivateOrActivateit.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Deactivate Or Activate Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Deactivate Or Activate cancel
	 * 
	 * @throws Exception
	 */

	public void cancel_DeactivateOrActivatePopUp() throws Exception {
		if (btn_PopUpCancel.isDisplayed()) {
			btn_PopUpCancel.click();
			log("Clicked on cancel button to cancel the Deactivate or Activate records and object is:-"
					+ btn_PopUpCancel.toString());
			Thread.sleep(1000);
		} else {
			log("Cancel button element is not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_ExamSubjectWizard() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamSubjectWizard);
		Thread.sleep(1000);
		if (btnMin_MaxExamSubjectWizard.isDisplayed()) {
			btnMin_MaxExamSubjectWizard.click();
			log("Exam Subject Wizard page minimized or maximized and object is:-"
					+ btnMin_MaxExamSubjectWizard.toString());
			Thread.sleep(1000);
		} else {
			log("Exam Subject Wizard Minimized Element not present.");
			Thread.sleep(1000);
		}
	}

	public void min_Max_ExamSubjectWizard_GridView() throws Exception {
		if (btnMin_MaxExamSubjectWizardGridView.isDisplayed()) {
			btnMin_MaxExamSubjectWizardGridView.click();
			log("Exam Subject Wizard Grid View page minimized or maximized and object is:-"
					+ btnMin_MaxExamSubjectWizardGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Exam Subject Wizard Grid View Minimized Element not present.");
			Thread.sleep(1000);
		}
	}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1) throws Exception {
		if (!chk_Subject1.isSelected()) {
			chk_Subject1.click();
			log("First subject check box is seleted and object is:- " + chk_Subject1.toString());
			Thread.sleep(1000);
		} else {
			log("First subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub1.isDisplayed()) {
			input_MaxMarks_Sub1.clear();
			input_MaxMarks_Sub1.sendKeys(MaxMarks_Sub1);
			log("Max Marks entered " + MaxMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub1.isDisplayed()) {
			input_MinMarks_Sub1.clear();
			input_MinMarks_Sub1.sendKeys(MinMarks_Sub1);
			log("Min Marks entered " + MinMarks_Sub1 + " for First subject and object is:- "
					+ input_MinMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub1.isDisplayed()) {
			input_MaxEntryMarks_Sub1.clear();
			input_MaxEntryMarks_Sub1.sendKeys(MaxEntryMarks_Sub1);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxEntryMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
	}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject2(String MaxMarks_Sub2, String MinMarks_Sub2,
			String MaxEntryMarks_Sub2) throws Exception {
		if (!chk_Subject2.isSelected()) {
			chk_Subject2.click();
			log("Second subject check box is seleted and object is:- " + chk_Subject2.toString());
			Thread.sleep(1000);
		} else {
			log("Second subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub2.isDisplayed()) {
			input_MaxMarks_Sub2.clear();
			input_MaxMarks_Sub2.sendKeys(MaxMarks_Sub2);
			log("Max Marks entered " + MaxMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub2.isDisplayed()) {
			input_MinMarks_Sub2.clear();
			input_MinMarks_Sub2.sendKeys(MinMarks_Sub2);
			log("Min Marks entered " + MinMarks_Sub2 + " for Second subject and object is:- "
					+ input_MinMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub2.isDisplayed()) {
			input_MaxEntryMarks_Sub2.clear();
			input_MaxEntryMarks_Sub2.sendKeys(MaxEntryMarks_Sub2);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxEntryMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
	}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject3(String MaxMarks_Sub3, String MinMarks_Sub3,
			String MaxEntryMarks_Sub3) throws Exception {
		if (!chk_Subject3.isSelected()) {
			chk_Subject3.click();
			log("Third subject check box is seleted and object is:- " + chk_Subject3.toString());
			Thread.sleep(1000);
		} else {
			log("Third subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub3.isDisplayed()) {
			input_MaxMarks_Sub3.clear();
			input_MaxMarks_Sub3.sendKeys(MaxMarks_Sub3);
			log("Max Marks entered " + MaxMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub3.isDisplayed()) {
			input_MinMarks_Sub3.clear();
			input_MinMarks_Sub3.sendKeys(MinMarks_Sub3);
			log("Min Marks entered " + MinMarks_Sub3 + " for Third subject and object is:- "
					+ input_MinMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub3.isDisplayed()) {
			input_MaxEntryMarks_Sub3.clear();
			input_MaxEntryMarks_Sub3.sendKeys(MaxEntryMarks_Sub3);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxEntryMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1) throws Exception {
		if (!chk_Subject1.isSelected()) {
			chk_Subject1.click();
			log("First subject check box is seleted and object is:- " + chk_Subject1.toString());
			Thread.sleep(1000);
		} else {
			log("First subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub1.isDisplayed()) {
			input_MaxMarks_Sub1.clear();
			input_MaxMarks_Sub1.sendKeys(MaxMarks_Sub1);
			log("Max Marks entered " + MaxMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub1.isDisplayed()) {
			input_MinMarks_Sub1.clear();
			input_MinMarks_Sub1.sendKeys(MinMarks_Sub1);
			log("Min Marks entered " + MinMarks_Sub1 + " for First subject and object is:- "
					+ input_MinMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub1.isDisplayed()) {
			input_MaxEntryMarks_Sub1.clear();
			input_MaxEntryMarks_Sub1.sendKeys(MaxEntryMarks_Sub1);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxEntryMarks_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject1 Element not present.");
			Thread.sleep(1000);
		}
		if (chk_ApplyToResult_Sub1.isSelected()) {
			chk_ApplyToResult_Sub1.click();
			log("Uncheck checked apply to result check box for first subject and object is:-"
					+ chk_ApplyToResult_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		if (chk_MarksDispaly_Sub1.isSelected()) {
			chk_MarksDispaly_Sub1.click();
			log("Uncheck checked marks display check box for first subject and object is:-"
					+ chk_MarksDispaly_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 marks display is already unchecked.");
			Thread.sleep(500);
		}
		if (!chk_GradeDispaly_Sub1.isSelected()) {
			chk_GradeDispaly_Sub1.click();
			log("Check Grade display check box for first subject and object is:-" + chk_GradeDispaly_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 Grade display check box is already checked.");
			Thread.sleep(500);
		}
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject2(String MaxMarks_Sub2, String MinMarks_Sub2,
			String MaxEntryMarks_Sub2) throws Exception {
		if (!chk_Subject2.isSelected()) {
			chk_Subject2.click();
			log("Second subject check box is seleted and object is:- " + chk_Subject2.toString());
			Thread.sleep(1000);
		} else {
			log("Second subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub2.isDisplayed()) {
			input_MaxMarks_Sub2.clear();
			input_MaxMarks_Sub2.sendKeys(MaxMarks_Sub2);
			log("Max Marks entered " + MaxMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub2.isDisplayed()) {
			input_MinMarks_Sub2.clear();
			input_MinMarks_Sub2.sendKeys(MinMarks_Sub2);
			log("Min Marks entered " + MinMarks_Sub2 + " for Second subject and object is:- "
					+ input_MinMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub2.isDisplayed()) {
			input_MaxEntryMarks_Sub2.clear();
			input_MaxEntryMarks_Sub2.sendKeys(MaxEntryMarks_Sub2);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxEntryMarks_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject2 Element not present.");
			Thread.sleep(1000);
		}
		if (chk_ApplyToResult_Sub2.isSelected()) {
			chk_ApplyToResult_Sub2.click();
			log("Uncheck checked apply to result check box for Second subject and object is:-"
					+ chk_ApplyToResult_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		if (chk_MarksDispaly_Sub2.isSelected()) {
			chk_MarksDispaly_Sub2.click();
			log("Uncheck checked marks display check box for Second subject and object is:-"
					+ chk_MarksDispaly_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 marks display is already unchecked.");
			Thread.sleep(500);
		}
		if (!chk_GradeDispaly_Sub2.isSelected()) {
			chk_GradeDispaly_Sub2.click();
			log("Check Grade display check box for Second subject and object is:-" + chk_GradeDispaly_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 Grade display check box is already checked.");
			Thread.sleep(500);
		}
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject3(String MaxMarks_Sub3, String MinMarks_Sub3,
			String MaxEntryMarks_Sub3) throws Exception {
		if (!chk_Subject3.isSelected()) {
			chk_Subject3.click();
			log("Third subject check box is seleted and object is:- " + chk_Subject3.toString());
			Thread.sleep(1000);
		} else {
			log("Third subject check box is already seleted.");
			Thread.sleep(500);
		}
		if (input_MaxMarks_Sub3.isDisplayed()) {
			input_MaxMarks_Sub3.clear();
			input_MaxMarks_Sub3.sendKeys(MaxMarks_Sub3);
			log("Max Marks entered " + MaxMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Max Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MinMarks_Sub3.isDisplayed()) {
			input_MinMarks_Sub3.clear();
			input_MinMarks_Sub3.sendKeys(MinMarks_Sub3);
			log("Min Marks entered " + MinMarks_Sub3 + " for Third subject and object is:- "
					+ input_MinMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Min Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
		if (input_MaxEntryMarks_Sub3.isDisplayed()) {
			input_MaxEntryMarks_Sub3.clear();
			input_MaxEntryMarks_Sub3.sendKeys(MaxEntryMarks_Sub3);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxEntryMarks_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Max Entry Marks subject3 Element not present.");
			Thread.sleep(1000);
		}
		if (chk_ApplyToResult_Sub3.isSelected()) {
			chk_ApplyToResult_Sub3.click();
			log("Uncheck checked apply to result check box for Third subject and object is:-"
					+ chk_ApplyToResult_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		if (chk_MarksDispaly_Sub3.isSelected()) {
			chk_MarksDispaly_Sub3.click();
			log("Uncheck checked marks display check box for Third subject and object is:-"
					+ chk_MarksDispaly_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 marks display is already unchecked.");
			Thread.sleep(500);
		}
		if (!chk_GradeDispaly_Sub3.isSelected()) {
			chk_GradeDispaly_Sub3.click();
			log("Check Grade display check box for Third subject and object is:-" + chk_GradeDispaly_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 Grade display check box is already checked.");
			Thread.sleep(500);
		}
	}

	public void clickOnSetOrder() throws Exception {
		if (btn_SetOrder.isDisplayed()) {
			btn_SetOrder.click();
			log("Set order button is clicked and set order window appeared and object is:- " + btn_SetOrder.toString());
			Thread.sleep(3000);
		} else {
			log("set order element is not present.");
			Thread.sleep(500);
		}
	}

	public void dragAndDropToSetSubjectOrder() throws Exception {

		// if (btn_SetOrder_Source.isDisplayed()) {
		// Actions action = new Actions(driver);
		// action.dragAndDrop(btn_SetOrder_Source,
		// btn_SetOrder_Destination).build().perform();
		// Thread.sleep(3000);
		// } else {
		// System.out.println("Element was not displayed to drag");
		// Thread.sleep(500);
		// }
		/*
		 * Actions builder = new Actions(driver);
		 * 
		 * builder.keyDown(Keys.CONTROL) .click(btn_SetOrder_Source)
		 * .click(btn_SetOrder_Destination) .keyUp(Keys.CONTROL);
		 */

		builder = new Actions(driver);

		dragAndDrop = builder.clickAndHold(btn_SetOrder_Source).moveToElement(btn_SetOrder_Destination)
				.release(btn_SetOrder_Destination).build();
		dragAndDrop.perform();
		log("Drag and drop to set order exam subject wizard.");

	}

	public void clickOnSave_ToSetOrder() throws Exception {
		if (btn_SetOrder_Save.isDisplayed()) {
			btn_SetOrder_Save.click();
			log("Subject order is set(Save) and object is:- " + btn_SetOrder_Save.toString());
			Thread.sleep(1000);
		} else {
			log("Set Order Save element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnClose_ToCloseSetOrderwindow() throws Exception {
		if (btn_SetOrder_Close.isDisplayed()) {
			btn_SetOrder_Close.click();
			log("Subject order is set and window closed and object is:- " + btn_SetOrder_Close.toString());
			Thread.sleep(1000);
		} else {
			log("Set Order Close element is not present.");
			Thread.sleep(500);
		}
	}
	
	
//Sub Exam Check box operation
	
	public void launchSubExamSubjectMappingwindow_Sub1() throws Exception {
		if (!chk_subExam_Sub1.isSelected()) {
			chk_subExam_Sub1.click();
			log("Sub Exam check box is checked for subject 1 & Sub Exam subject mapping window appered and object is:- "
					+ chk_subExam_Sub1.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is already checked for subject 1");
			Thread.sleep(500);
		}
	}

	public void launchSubExamSubjectMappingwindow_Sub2() throws Exception {
		if (!chk_subExam_Sub2.isSelected()) {
			chk_subExam_Sub2.click();
			log("Sub Exam check box is checked for subject 2 & Sub Exam subject mapping window appered and object is:- "
					+ chk_subExam_Sub2.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is already checked for subject 2");
			Thread.sleep(500);
		}
	}

	public void launchSubExamSubjectMappingwindow_Sub3() throws Exception {
		if (!chk_subExam_Sub3.isSelected()) {
			chk_subExam_Sub3.click();
			log("Sub Exam check box is checked for subject 3 & Sub Exam subject mapping window appered and object is:- "
					+ chk_subExam_Sub3.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is already checked for subject 3");
			Thread.sleep(500);
		}
	}

	public void enterDataForSubExamMapping_Sub1(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1) throws Exception {
		if (!chk_subExam_Sub1.isSelected()) {
			chk_subExam_Sub1.click();
			log("Subject 1 is slected for sub exam mapping and object is:- " + chk_subExam_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 is already selected for sub exam mapping");
			Thread.sleep(500);
		}
		if (input_maxMarksSubExamPopUpWin_Sub1.isDisplayed()) {
			input_maxMarksSubExamPopUpWin_Sub1.clear();
			input_maxMarksSubExamPopUpWin_Sub1.sendKeys(maxMarks_subExamSub1);
			log("Entered maximum marks for sub exam subject 1: " + exemptedPercentage_subExamSub1 + " and object is:- "
					+ input_maxMarksSubExamPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam max marks subject 1 field element not present.");
			Thread.sleep(500);
		}
		if (input_minMarksSubExamPopUpWin_Sub1.isDisplayed()) {
			input_minMarksSubExamPopUpWin_Sub1.clear();
			input_minMarksSubExamPopUpWin_Sub1.sendKeys(minMarks_subExamSub1);
			log("Entered minimum marks for sub exam subject 1: " + exemptedPercentage_subExamSub1 + " and object is:- "
					+ input_minMarksSubExamPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam min marks field subject 1 element not present.");
			Thread.sleep(500);
		}
		if (sel_gradeSubExamPopUpWin_Sub1.isDisplayed()) {

			select = new Select(sel_gradeSubExamPopUpWin_Sub1);
			select.selectByVisibleText(grade_subExamSub1);

			log("Selected Garde: " + grade_subExamSub1 + " and object is:- "
					+ sel_gradeSubExamPopUpWin_Sub1.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade_subExamSub1);
			Thread.sleep(1000);
		} else {
			log("Grade element subject 1  is not present");
			Thread.sleep(500);
		}
		if (!chk_ExemptedFlagsubExamPopUpWin_Sub1.isSelected()) {
			chk_ExemptedFlagsubExamPopUpWin_Sub1.click();
			log("Subject 1 Exempted flag is slected for sub exam mapping and object is:- "
					+ chk_ExemptedFlagsubExamPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 Exempted flag is already selected for sub exam mapping");
			Thread.sleep(500);
		}
		if (input_ExemptedPercentagesubExamPopUpWin_Sub1.isDisplayed()) {
			input_ExemptedPercentagesubExamPopUpWin_Sub1.clear();
			input_ExemptedPercentagesubExamPopUpWin_Sub1.sendKeys(exemptedPercentage_subExamSub1);
			log("Entered Exempted percentage for sub exam subject 1 " + exemptedPercentage_subExamSub1
					+ " and object is:- " + input_ExemptedPercentagesubExamPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam Exempted percentage field subject 1 element not present.");
			Thread.sleep(500);
		}
	}

	public void enterDataForSubExamMapping_Sub2(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2) throws Exception {
		if (!chk_subExam_Sub2.isSelected()) {
			chk_subExam_Sub2.click();
			log("Subject 2 is slected for sub exam mapping and object is:- " + chk_subExam_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 is already selected for sub exam mapping");
			Thread.sleep(500);
		}
		if (input_maxMarksSubExamPopUpWin_Sub2.isDisplayed()) {
			input_maxMarksSubExamPopUpWin_Sub2.clear();
			input_maxMarksSubExamPopUpWin_Sub2.sendKeys(maxMarks_subExamSub2);
			log("Entered maximum marks for sub exam subject 2: " + exemptedPercentage_subExamSub2 + " and object is:- "
					+ input_maxMarksSubExamPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam max marks subject 2 field element not present.");
			Thread.sleep(500);
		}
		if (input_minMarksSubExamPopUpWin_Sub2.isDisplayed()) {
			input_minMarksSubExamPopUpWin_Sub2.clear();
			input_minMarksSubExamPopUpWin_Sub2.sendKeys(minMarks_subExamSub2);
			log("Entered minimum marks for sub exam subject 2: " + exemptedPercentage_subExamSub2 + "  and object is:- "
					+ input_minMarksSubExamPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam min marks subject 2 field element not present.");
			Thread.sleep(500);
		}
		if (sel_gradeSubExamPopUpWin_Sub2.isDisplayed()) {

			select = new Select(sel_gradeSubExamPopUpWin_Sub2);
			select.selectByVisibleText(grade_subExamSub2);

			log("Selected Garde: " + grade_subExamSub2 + " and object is:- "
					+ sel_gradeSubExamPopUpWin_Sub2.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), grade_subExamSub2);
			Thread.sleep(1000);
		} else {
			log("Grade element subject 2 is not present");
			Thread.sleep(500);
		}
		if (!chk_ExemptedFlagsubExamPopUpWin_Sub2.isSelected()) {
			chk_ExemptedFlagsubExamPopUpWin_Sub2.click();
			log("Subject 2 Exempted flag is slected for sub exam mapping and object is:- "
					+ chk_ExemptedFlagsubExamPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 Exempted flag is already selected for sub exam mapping");
			Thread.sleep(500);
		}
		if (input_ExemptedPercentagesubExamPopUpWin_Sub2.isDisplayed()) {
			input_ExemptedPercentagesubExamPopUpWin_Sub2.clear();
			input_ExemptedPercentagesubExamPopUpWin_Sub2.sendKeys(exemptedPercentage_subExamSub2);
			log("Entered Exempted percentage for sub exam subject 2 " + exemptedPercentage_subExamSub2
					+ " and object is:- " + input_ExemptedPercentagesubExamPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Sub Exam Exempted percentage subject 2 field element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnAddAndClose_ToSubmitSubExamMapping() throws Exception {
		if (btn_AddAndClose_SubExamWindow.isDisplayed()) {
			btn_AddAndClose_SubExamWindow.click();
			log("Clicked on Add&Close and sub exam mapping window is closed and object is:- "
					+ btn_AddAndClose_SubExamWindow.toString());
			Thread.sleep(3000);
		} else {
			log("Add&Close button sub exam is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancel_ToClearFilled_SubExamData() throws Exception {
		if (btn_Cancel_SubExamWindow.isDisplayed()) {
			btn_Cancel_SubExamWindow.click();
			log("Clicked on Cancel to clear filled data and object is:- " + btn_Cancel_SubExamWindow.toString());
			Thread.sleep(1000);
		} else {
			log("Cancel button sub exam window is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnClose_TocloseWindow_SubExamData() throws Exception {
		if (btn_Close_SubExamWindow.isDisplayed()) {
			btn_Close_SubExamWindow.click();
			log("Clicked on Close to close sub exam window and object is:- " + btn_Close_SubExamWindow.toString());
			Thread.sleep(1000);
		} else {
			log("Close button sub exam window is not present.");
			Thread.sleep(500);
		}
	}
	
	//Set Order sub Exam
	
	
	
	public void clickOnSetorder_subExamMapping() throws Exception{
		if(btn_SetOrder_SubExamWindow.isDisplayed()){
			btn_SetOrder_SubExamWindow.click();
			log("Sub exam mapping set order window apper and object is:- "+btn_SetOrder_SubExamWindow.toString());
			Thread.sleep(2000);
		}else{
			log("Set order sub exam window not present.");
			Thread.sleep(500);
		}
	}
	public void setOrderForSubExamMapping_dragAndDrop(){
		
			builder = new Actions(driver);

		dragAndDrop = builder.clickAndHold(btn_SetOrder_Source).moveToElement(btn_SetOrder_Destination)
				.release(btn_SetOrder_Destination).build();
		dragAndDrop.perform();
		log("Drag and drop to set order sub exam.");
		
	}
	public void clickOnSetOrder_Save_TosetOrder_SubExam() throws Exception {
		if (btn_SetOrder_Save_subExam.isDisplayed()) {
			btn_SetOrder_Save_subExam.click();
			log("Clicked on save sub exam set order window to set order and object is:- " + btn_SetOrder_Save_subExam.toString());
			Thread.sleep(1000);
		} else {
			log("Save button set order sub exam window is not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnClose_TocloseSetOrder_SubExamWindows() throws Exception {
		if (btn_SetOrder_Close_subExam.isDisplayed()) {
			btn_SetOrder_Close_subExam.click();
			log("Clicked on Close to close set order subexam window and object is:- " + btn_SetOrder_Close_subExam.toString());
			Thread.sleep(1000);
		} else {
			log("Close button set order sub exam window is not present.");
			Thread.sleep(500);
		}
	}
	
}
