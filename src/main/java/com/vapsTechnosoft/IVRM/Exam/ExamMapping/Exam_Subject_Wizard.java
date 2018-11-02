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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Exam_Subject_Wizard extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_Subject_Wizard.class.getName());

	private WebDriver driver;
	private Actions builder;
	private Action dragAndDrop;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam
	// Mapping')][1]/following::li[2]")
	// private WebElement btn_ExamSubjectWizard;

	@FindBy(xpath = "//a[@href='#/app/ExamSubjectWizard/251']")
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

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	private WebElement btn_MonthYear_From;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]/following::td[1]")
	private WebElement btn_Date_From;

	@FindBy(xpath = "(//label[contains(text(),'Attendance To :')]/following-sibling::div//child::button)[1]")
	private WebElement btn_ToCalender;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	private WebElement btn_MonthYear_To;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[19]")
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

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[10]/div/span/a")
	private WebElement btn_Deactivate;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[10]/div/a[3]")
	private WebElement btn_Activate;

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
	//

	// @FindBy(xpath = "//button[@class='confirm' and text()='OK']")
	// private WebElement btn_SucsessOkHandle;

	@FindBy(xpath = "//button[text()='No, Change Selection!']")
	private WebElement btn_ChangeSelection;

	@FindBy(xpath = "//button[text()='Yes, Delete Selection!']")
	private WebElement btn_DeleteSelection;

	@FindBy(xpath = "//button[text()=' cat, Change Selection!']")
	private WebElement btn_ChangeSelection_subSubject;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_Subject_Wizard(WebDriver driver) {
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
	 * Navigate to Exam > Exam Mapping > Exam Subject Wizard
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_ExamSubjectWizard() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_ExamMapping);
		log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());

		clickOnButton(btn_ExamSubjectWizard);
		log("Clicked on Exam Subject Wizard Button and object is:-" + btn_ExamSubjectWizard.toString());

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
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// btn_MonthYear_From);
		// Thread.sleep(500);
		
			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		
			selectElementFromDropDown(sel_Grade, grade);
			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
	
			selectElementFromDropDown(sel_Category, category);
			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			
			try{
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
		}catch(Exception e){
			e.printStackTrace();
		
		}

			clickOnButton(btn_FromCalender);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(2000);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);

			clickOnButton(btn_ToCalender);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(2000);
			btn_Date_To.click();
			log("To date is selected from calender.");
			
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
		
			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
	
			selectElementFromDropDown(sel_Grade, grade);
			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
	
			selectElementFromDropDown(sel_Category, category);
			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			
			try{
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
			}catch(Exception e){
				e.printStackTrace();
			
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
	
			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		
			selectElementFromDropDown(sel_Grade, grade);
			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
	
			selectElementFromDropDown(sel_Category, category);
			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
		try{
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
		}catch(Exception e){
			e.printStackTrace();
		
		}
	
			clickOnButton(btn_FromCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");

			clickOnButton(btn_ToCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			
			isDisplayed(chk_SubSubjectApplicable);
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
	
			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
	
			selectElementFromDropDown(sel_Grade, grade);
			log("Selected Grade: " + grade + " and object is:- " + sel_Grade.toString());
		
			selectElementFromDropDown(sel_Category, category);
			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			
			try{
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
			}catch(Exception e){
				e.printStackTrace();
			}

			clickOnButton(btn_FromCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
	
			clickOnButton(btn_ToCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			
			isDisplayed(chk_SubExamApplicable);
		if (!chk_SubExamApplicable.isSelected()) {
			chk_SubExamApplicable.click();
			log("Sub-Exam applicable check box is checked and object is:- " + chk_SubExamApplicable.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-Exam applicable element is not present.");
			Thread.sleep(500);
		}
		isDisplayed(chk_SubSubjectApplicable);
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

			clickOnButton(btn_Save);
			log("Submit blank Exam Subject Wizard form and object is:-" + btn_Save.toString());
			
	}

	/**
	 * Click on save button to save Exam Subject Wizard data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitExamSubjectWizardForm() throws Exception {
			clickOnButton(btn_Save);
			log("clicked on save button to Submit the records for Exam Subject Wizard and object is:-"
					+ btn_Save.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnCancelButton_ToClearFilledExamSubjectWizardForm() throws Exception {

			clickOnButton(btn_Cancel);
			log("clicked on Cancel button to clear filled data for Exam Subject Wizard and object is:-"
					+ btn_Cancel.toString());
		
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

	public void sortWithAcademicYearInGridView() throws Exception {

			clickOnButton(btn_Sort_AcademicYear);
			log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());
			Thread.sleep(1000);
	}

	public void sortWithExamNameInGridView() throws Exception {

			clickOnButton(btn_Sort_ExamName);
			log("Sort by Exam Name in grid view and object is:- " + btn_Sort_ExamName.toString());
			
	}

	public void sortWithCategoryNameInGridView() throws Exception {

			clickOnButton(btn_Sort_CategoryName);
			log("Sort by Category Name in grid view and object is:- " + btn_Sort_CategoryName.toString());
			
	}

	public void sortWithGradeNameInGridView() throws Exception {

			clickOnButton(btn_Sort_GradeName);
			log("Sort by Grade Name in grid view and object is:- " + btn_Sort_GradeName.toString());
			
	}

	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
	
			inputTextIntoInputField(input_AcademicYear, academicYear);
			log("Entered academic year " + academicYear + " to filter records and object is:- "
					+ input_AcademicYear.toString());
			
	}

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
		
			inputTextIntoInputField(input_CategoryName, categoryName);
			log("Entered Category Name " + categoryName + " to filter records and object is:- "
					+ input_CategoryName.toString());
		
	}

	public void filterRecordsBasedOn_GradeName(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
		
			inputTextIntoInputField(input_GradeName, gradeName);
			log("Entered Grade Name " + gradeName + " to filter records and object is:- " + input_GradeName.toString());
			
	}

	public void filterRecordsBasedOn_ExamName(String academicYear, String categoryName, String gradeName,
			String examName) throws Exception {
	
			inputTextIntoInputField(input_ExamName, examName);
			log("Entered Exam Name " + examName + " to filter records and object is:- " + input_ExamName.toString());
			
	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_AcademicYear);
		input_AcademicYear.clear();
		isDisplayed(input_CategoryName);
		input_CategoryName.clear();
		isDisplayed(input_GradeName);
		input_GradeName.clear();
		isDisplayed(input_ExamName);
		input_ExamName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeExamAndSubjectMapped() throws Exception {

			clickOnButton(btn_View);
			log("Clicked on View Icon to launch pop up windows to see created exam subject wizard and object is:-"
					+ btn_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			
	}

	public void clickOnEditIcon_ToUpdateExamSubjectWizard() throws Exception {

			clickOnButton(btn_Edit);
			log("Clicked on Edit Icon to update Exam subject wizard and object is:-" + btn_Edit.toString());
			
	}

	public void clickOnDeActivationIcon_ToDeactivateExamSubjectWizard() throws Exception {

			isDisplayed(btn_Deactivate);
			String DeactivateText = btn_Deactivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			btn_Deactivate.click();
			log("Clicked on Deacivate Icon to Deactivate Exam Subject Wizard and object is:-"
					+ btn_Deactivate.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnActivationIcon_ToActivateExamSubjectWizard() throws Exception {

			isDisplayed(btn_Activate);
			String ActivateText = btn_Activate.getAttribute("aria-label");
			System.out.println("Tool tip text present(Activate) :- " + ActivateText);

			// Compare tool tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			btn_Activate.click();
			log("Clicked on Activate Icon to Activate Exam Subject Wizard and object is:-" + btn_Activate.toString());
			Thread.sleep(1000);
		
	}

	public void closeViewPopUpWindows() throws Exception {
		
			clickOnButton(btn_View_ClosePopUp);
			log("View pop Up windows is closed and object is:-" + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertFalse(closeButton);
			Thread.sleep(1000);
		
	}

	/**
	 * Confirmation for deactivate and activate
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivateAndActivate() throws Exception {

			clickOnButton(btnPopUpYesDeactivateOrActivateit);
			log("Clicked Yes deactivate Or Activate it button and object is:"
					+ btnPopUpYesDeactivateOrActivateit.toString());
		
	}

	/**
	 * Deactivate Or Activate cancel
	 * 
	 * @throws Exception
	 */

	public void cancel_DeactivateOrActivatePopUp() throws Exception {
	
			clickOnButton(btn_PopUpCancel);
			log("Clicked on cancel button to cancel the Deactivate or Activate records and object is:-"
					+ btn_PopUpCancel.toString());
			
		
	}

	public void min_Max_ExamSubjectWizard() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamSubjectWizard);
		Thread.sleep(1000);

			clickOnButton(btnMin_MaxExamSubjectWizard);
			log("Exam Subject Wizard page minimized or maximized and object is:-"
					+ btnMin_MaxExamSubjectWizard.toString());
			
	}

	public void min_Max_ExamSubjectWizard_GridView() throws Exception {
	
			clickOnButton(btnMin_MaxExamSubjectWizardGridView);
			log("Exam Subject Wizard Grid View page minimized or maximized and object is:-"
					+ btnMin_MaxExamSubjectWizardGridView.toString());
			
	}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1) throws Exception {
		isDisplayed(chk_Subject1);
		if (!chk_Subject1.isSelected()) {
			chk_Subject1.click();
			log("First subject check box is seleted and object is:- " + chk_Subject1.toString());
			Thread.sleep(1000);
		} else {
			log("First subject check box is already seleted.");
			Thread.sleep(500);
		}
	
			inputTextIntoInputField(input_MaxMarks_Sub1, MaxMarks_Sub1);
			log("Max Marks entered " + MaxMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxMarks_Sub1.toString());
	
			inputTextIntoInputField(input_MinMarks_Sub1, MinMarks_Sub1);
			log("Min Marks entered " + MinMarks_Sub1 + " for First subject and object is:- "
					+ input_MinMarks_Sub1.toString());
	
			inputTextIntoInputField(input_MaxEntryMarks_Sub1, MaxEntryMarks_Sub1);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxEntryMarks_Sub1.toString());
		}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject2(String MaxMarks_Sub2, String MinMarks_Sub2,
			String MaxEntryMarks_Sub2) throws Exception {
		isDisplayed(chk_Subject2);
		if (!chk_Subject2.isSelected()) {
			chk_Subject2.click();
			log("Second subject check box is seleted and object is:- " + chk_Subject2.toString());
			Thread.sleep(1000);
		} else {
			log("Second subject check box is already seleted.");
			Thread.sleep(500);
		}
	
			inputTextIntoInputField(input_MaxMarks_Sub2, MaxMarks_Sub2);
			log("Max Marks entered " + MaxMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxMarks_Sub2.toString());

			inputTextIntoInputField(input_MinMarks_Sub2, MinMarks_Sub2);
			log("Min Marks entered " + MinMarks_Sub2 + " for Second subject and object is:- "
					+ input_MinMarks_Sub2.toString());
	
			inputTextIntoInputField(input_MaxEntryMarks_Sub2, MaxEntryMarks_Sub2);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxEntryMarks_Sub2.toString());			
	}

	public void enterSubjectWiseMarks_ForMarksDisplay_Subject3(String MaxMarks_Sub3, String MinMarks_Sub3,
			String MaxEntryMarks_Sub3) throws Exception {
		isDisplayed(chk_Subject3);
		if (!chk_Subject3.isSelected()) {
			chk_Subject3.click();
			log("Third subject check box is seleted and object is:- " + chk_Subject3.toString());
			Thread.sleep(1000);
		} else {
			log("Third subject check box is already seleted.");
			Thread.sleep(500);
		}

			inputTextIntoInputField(input_MaxMarks_Sub3, MaxMarks_Sub3);
			log("Max Marks entered " + MaxMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxMarks_Sub3.toString());
		
			inputTextIntoInputField(input_MinMarks_Sub3, MinMarks_Sub3);
			log("Min Marks entered " + MinMarks_Sub3 + " for Third subject and object is:- "
					+ input_MinMarks_Sub3.toString());
	
			inputTextIntoInputField(input_MaxEntryMarks_Sub3, MaxEntryMarks_Sub3);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxEntryMarks_Sub3.toString());
			
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1) throws Exception {
		isDisplayed(chk_Subject1);
		if (!chk_Subject1.isSelected()) {
			chk_Subject1.click();
			log("First subject check box is seleted and object is:- " + chk_Subject1.toString());
			Thread.sleep(1000);
		} else {
			log("First subject check box is already seleted.");
			Thread.sleep(500);
		}
	
			inputTextIntoInputField(input_MaxMarks_Sub1, MaxMarks_Sub1);
			log("Max Marks entered " + MaxMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxMarks_Sub1.toString());
		
			inputTextIntoInputField(input_MinMarks_Sub1, MinMarks_Sub1);
			log("Min Marks entered " + MinMarks_Sub1 + " for First subject and object is:- "
					+ input_MinMarks_Sub1.toString());
	
			inputTextIntoInputField(input_MaxEntryMarks_Sub1, MaxEntryMarks_Sub1);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub1 + " for First subject and object is:- "
					+ input_MaxEntryMarks_Sub1.toString());
		isDisplayed(chk_ApplyToResult_Sub1);
		if (chk_ApplyToResult_Sub1.isSelected()) {
			chk_ApplyToResult_Sub1.click();
			log("Uncheck checked apply to result check box for first subject and object is:-"
					+ chk_ApplyToResult_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MarksDispaly_Sub1);
		if (chk_MarksDispaly_Sub1.isSelected()) {
			chk_MarksDispaly_Sub1.click();
			log("Uncheck checked marks display check box for first subject and object is:-"
					+ chk_MarksDispaly_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 marks display is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_GradeDispaly_Sub1);
		if (!chk_GradeDispaly_Sub1.isSelected()) {
			chk_GradeDispaly_Sub1.click();
			log("Check Grade display check box for first subject and object is:-" + chk_GradeDispaly_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 Grade display check box is already checked.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Grade_Sub1);
		if (!rdBtn_Grade_Sub1.isSelected()) {
			rdBtn_Grade_Sub1.click();
			log("Check Grade radio button for first subject and object is:-" + rdBtn_Grade_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Grade radio for subject 1 button is already checked.");
			Thread.sleep(500);
		}
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject2(String MaxMarks_Sub2, String MinMarks_Sub2,
			String MaxEntryMarks_Sub2) throws Exception {
		isDisplayed(chk_Subject2);
		if (!chk_Subject2.isSelected()) {
			chk_Subject2.click();
			log("Second subject check box is seleted and object is:- " + chk_Subject2.toString());
			Thread.sleep(1000);
		} else {
			log("Second subject check box is already seleted.");
			Thread.sleep(500);
		}

			inputTextIntoInputField(input_MaxMarks_Sub2, MaxMarks_Sub2);
			log("Max Marks entered " + MaxMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxMarks_Sub2.toString());
	
			inputTextIntoInputField(input_MinMarks_Sub2, MinMarks_Sub2);
			log("Min Marks entered " + MinMarks_Sub2 + " for Second subject and object is:- "
					+ input_MinMarks_Sub2.toString());

			inputTextIntoInputField(input_MaxEntryMarks_Sub2, MaxEntryMarks_Sub2);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub2 + " for Second subject and object is:- "
					+ input_MaxEntryMarks_Sub2.toString());
			isDisplayed(chk_ApplyToResult_Sub2);
		if (chk_ApplyToResult_Sub2.isSelected()) {
			chk_ApplyToResult_Sub2.click();
			log("Uncheck checked apply to result check box for Second subject and object is:-"
					+ chk_ApplyToResult_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MarksDispaly_Sub2);
		if (chk_MarksDispaly_Sub2.isSelected()) {
			chk_MarksDispaly_Sub2.click();
			log("Uncheck checked marks display check box for Second subject and object is:-"
					+ chk_MarksDispaly_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 marks display is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_GradeDispaly_Sub2);
		if (!chk_GradeDispaly_Sub2.isSelected()) {
			chk_GradeDispaly_Sub2.click();
			log("Check Grade display check box for Second subject and object is:-" + chk_GradeDispaly_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 Grade display check box is already checked.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Grade_Sub2);
		if (!rdBtn_Grade_Sub2.isSelected()) {
			rdBtn_Grade_Sub2.click();
			log("Check Grade radio button for 2 subject and object is:-" + rdBtn_Grade_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Grade radio button for subject 2 is already checked.");
			Thread.sleep(500);
		}
	}

	public void enterSubjectWiseMarks_ForGradeDisplay_Subject3(String MaxMarks_Sub3, String MinMarks_Sub3,
			String MaxEntryMarks_Sub3) throws Exception {
		isDisplayed(chk_Subject3);
		if (!chk_Subject3.isSelected()) {
			chk_Subject3.click();
			log("Third subject check box is seleted and object is:- " + chk_Subject3.toString());
			Thread.sleep(1000);
		} else {
			log("Third subject check box is already seleted.");
			Thread.sleep(500);
		}

			inputTextIntoInputField(input_MaxMarks_Sub3, MaxMarks_Sub3);
			log("Max Marks entered " + MaxMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxMarks_Sub3.toString());
	
			inputTextIntoInputField(input_MinMarks_Sub3, MinMarks_Sub3);
			log("Min Marks entered " + MinMarks_Sub3 + " for Third subject and object is:- "
					+ input_MinMarks_Sub3.toString());
		
			inputTextIntoInputField(input_MaxEntryMarks_Sub3, MaxEntryMarks_Sub3);
			log("Max Entry Marks entered " + MaxEntryMarks_Sub3 + " for Third subject and object is:- "
					+ input_MaxEntryMarks_Sub3.toString());
			isDisplayed(chk_ApplyToResult_Sub3);
		if (chk_ApplyToResult_Sub3.isSelected()) {
			chk_ApplyToResult_Sub3.click();
			log("Uncheck checked apply to result check box for Third subject and object is:-"
					+ chk_ApplyToResult_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 apply to result is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MarksDispaly_Sub3);
		if (chk_MarksDispaly_Sub3.isSelected()) {
			chk_MarksDispaly_Sub3.click();
			log("Uncheck checked marks display check box for Third subject and object is:-"
					+ chk_MarksDispaly_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 marks display is already unchecked.");
			Thread.sleep(500);
		}
		isDisplayed(chk_GradeDispaly_Sub3);
		if (!chk_GradeDispaly_Sub3.isSelected()) {
			chk_GradeDispaly_Sub3.click();
			log("Check Grade display check box for Third subject and object is:-" + chk_GradeDispaly_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 3 Grade display check box is already checked.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Grade_Sub3);
		if (!rdBtn_Grade_Sub3.isSelected()) {
			rdBtn_Grade_Sub3.click();
			log("Check Grade radio button for 3 subject and object is:-" + rdBtn_Grade_Sub3.toString());
			Thread.sleep(1000);
		} else {
			log("Grade radio button for subject 3 is already checked.");
			Thread.sleep(500);
		}
	}

	public void clickOnSetOrder() throws Exception {
	
			clickOnButton(btn_SetOrder);
			log("Set order button is clicked and set order window appeared and object is:- " + btn_SetOrder.toString());
			
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
try{
		builder = new Actions(driver);

		dragAndDrop = builder.clickAndHold(btn_SetOrder_Source).moveToElement(btn_SetOrder_Destination)
				.release(btn_SetOrder_Destination).build();
		dragAndDrop.perform();
		log("Drag and drop to set order exam subject wizard.");
}catch(Exception e){
	e.printStackTrace();
}
	}

	public void clickOnSave_ToSetOrder() throws Exception {
	
			clickOnButton(btn_SetOrder_Save);
			log("Subject order is set(Save) and object is:- " + btn_SetOrder_Save.toString());
		
	}

	public void clickOnClose_ToCloseSetOrderwindow() throws Exception {
		
			clickOnButton(btn_SetOrder_Close);
			log("Subject order is set and window closed and object is:- " + btn_SetOrder_Close.toString());
			
	}

	// Sub Exam Check box operation

	public void launchSubExamSubjectMappingwindow_Sub1() throws Exception {
		isDisplayed(chk_subExam_Sub1);
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

	public void changeInSelectionAndDeleteSubExamMapped_Sub1() throws Exception {
		isDisplayed(chk_subExam_Sub1);
		if (chk_subExam_Sub1.isSelected()) {
			chk_subExam_Sub1.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub exam subject 1 mapping and object is:- "
					+ chk_subExam_Sub1.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is not checked for subject 1");
			Thread.sleep(500);
		}
	}

	public void launchSubExamSubjectMappingwindow_Sub2() throws Exception {
		isDisplayed(chk_subExam_Sub2);
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

	public void changeInSelectionAndDeleteSubExamMapped_Sub2() throws Exception {
		isDisplayed(chk_subExam_Sub2);
		if (chk_subExam_Sub2.isSelected()) {
			chk_subExam_Sub2.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub exam subject 2 mapping and object is:- "
					+ chk_subExam_Sub2.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is not checked for subject 2");
			Thread.sleep(500);
		}
	}

	public void launchSubExamSubjectMappingwindow_Sub3() throws Exception {
		isDisplayed(chk_subExam_Sub3);
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

	public void changeInSelectionAndDeleteSubExamMapped_Sub3() throws Exception {
		isDisplayed(chk_subExam_Sub3);
		if (chk_subExam_Sub3.isSelected()) {
			chk_subExam_Sub3.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub exam subject 3 mapping and object is:- "
					+ chk_subExam_Sub3.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Exam check box is not checked for subject 3");
			Thread.sleep(500);
		}
	}

	public void enterDataForSubExamMapping_Sub1(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1) throws Exception {
		isDisplayed(chk_subExamMapPopUpWin_Sub1);
		if (!chk_subExamMapPopUpWin_Sub1.isSelected()) {
			chk_subExamMapPopUpWin_Sub1.click();
			log("Subject 1 is slected for sub exam mapping and object is:- " + chk_subExamMapPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 is already selected for sub exam mapping");
			Thread.sleep(500);
		}
		
			inputTextIntoInputField(input_maxMarksSubExamPopUpWin_Sub1, maxMarks_subExamSub1);
			log("Entered maximum marks for sub exam subject 1: " + exemptedPercentage_subExamSub1 + " and object is:- "
					+ input_maxMarksSubExamPopUpWin_Sub1.toString());
		
			inputTextIntoInputField(input_minMarksSubExamPopUpWin_Sub1, minMarks_subExamSub1);
			log("Entered minimum marks for sub exam subject 1: " + exemptedPercentage_subExamSub1 + " and object is:- "
					+ input_minMarksSubExamPopUpWin_Sub1.toString());

			selectElementFromDropDown(sel_gradeSubExamPopUpWin_Sub1, grade_subExamSub1);
			log("Selected Garde: " + grade_subExamSub1 + " and object is:- "
					+ sel_gradeSubExamPopUpWin_Sub1.toString());
			isDisplayed(chk_ExemptedFlagsubExamPopUpWin_Sub1);
		if (!chk_ExemptedFlagsubExamPopUpWin_Sub1.isSelected()) {
			chk_ExemptedFlagsubExamPopUpWin_Sub1.click();
			log("Subject 1 Exempted flag is slected for sub exam mapping and object is:- "
					+ chk_ExemptedFlagsubExamPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 Exempted flag is already selected for sub exam mapping");
			Thread.sleep(500);
		}

			inputTextIntoInputField(input_ExemptedPercentagesubExamPopUpWin_Sub1, exemptedPercentage_subExamSub1);
			log("Entered Exempted percentage for sub exam subject 1 " + exemptedPercentage_subExamSub1
					+ " and object is:- " + input_ExemptedPercentagesubExamPopUpWin_Sub1.toString());
		
	}

	public void enterDataForSubExamMapping_Sub2(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2) throws Exception {
		isDisplayed(chk_subExamMapPopUpWin_Sub2);
		if (!chk_subExamMapPopUpWin_Sub2.isSelected()) {
			chk_subExamMapPopUpWin_Sub2.click();
			log("Subject 2 is slected for sub exam mapping and object is:- " + chk_subExamMapPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 is already selected for sub exam mapping");
			Thread.sleep(500);
		}
	
			inputTextIntoInputField(input_maxMarksSubExamPopUpWin_Sub2, maxMarks_subExamSub2);
			log("Entered maximum marks for sub exam subject 2: " + exemptedPercentage_subExamSub2 + " and object is:- "
					+ input_maxMarksSubExamPopUpWin_Sub2.toString());

			inputTextIntoInputField(input_minMarksSubExamPopUpWin_Sub2, minMarks_subExamSub2);
			log("Entered minimum marks for sub exam subject 2: " + exemptedPercentage_subExamSub2 + "  and object is:- "
					+ input_minMarksSubExamPopUpWin_Sub2.toString());
	
			selectElementFromDropDown(sel_gradeSubExamPopUpWin_Sub2, grade_subExamSub2);
			log("Selected Garde: " + grade_subExamSub2 + " and object is:- "
					+ sel_gradeSubExamPopUpWin_Sub2.toString());
			isDisplayed(chk_ExemptedFlagsubExamPopUpWin_Sub2);
		if (!chk_ExemptedFlagsubExamPopUpWin_Sub2.isSelected()) {
			chk_ExemptedFlagsubExamPopUpWin_Sub2.click();
			log("Subject 2 Exempted flag is slected for sub exam mapping and object is:- "
					+ chk_ExemptedFlagsubExamPopUpWin_Sub2.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 2 Exempted flag is already selected for sub exam mapping");
			Thread.sleep(500);
		}

			inputTextIntoInputField(input_ExemptedPercentagesubExamPopUpWin_Sub2, exemptedPercentage_subExamSub2);
			log("Entered Exempted percentage for sub exam subject 2 " + exemptedPercentage_subExamSub2
					+ " and object is:- " + input_ExemptedPercentagesubExamPopUpWin_Sub2.toString());
			
	}

	public void clickOnAddAndClose_ToSubmitSubExamMapping() throws Exception {
		
			clickOnButton(btn_AddAndClose_SubExamWindow);
			log("Clicked on Add&Close and sub exam mapping window is closed and object is:- "
					+ btn_AddAndClose_SubExamWindow.toString());
			
	}

	public void clickOnCancel_ToClearFilled_SubExamData() throws Exception {
	
			clickOnButton(btn_Cancel_SubExamWindow);
			log("Clicked on Cancel to clear filled data and object is:- " + btn_Cancel_SubExamWindow.toString());
			
	}

	public void clickOnClose_TocloseWindow_SubExamData() throws Exception {
		
			clickOnButton(btn_Close_SubExamWindow);
			log("Clicked on Close to close sub exam window and object is:- " + btn_Close_SubExamWindow.toString());
			
	}

	// Set Order sub Exam

	public void clickOnSetorder_subExamMapping() throws Exception {
	
			clickOnButton(btn_SetOrder_SubExamWindow);
			log("Sub exam mapping set order window apper and object is:- " + btn_SetOrder_SubExamWindow.toString());
			
	}

	public void setOrderForSubExamMapping_dragAndDrop() {
		isDisplayed(btn_SetOrder_Source);
		builder = new Actions(driver);

		dragAndDrop = builder.clickAndHold(btn_SetOrder_Source).moveToElement(btn_SetOrder_Destination)
				.release(btn_SetOrder_Destination).build();
		dragAndDrop.perform();
		log("Drag and drop to set order sub exam.");

	}

	public void clickOnSetOrder_Save_TosetOrder_SubExam() throws Exception {
	
			clickOnButton(btn_SetOrder_Save_subExam);
			log("Clicked on save sub exam set order window to set order and object is:- "
					+ btn_SetOrder_Save_subExam.toString());
			
	}

	public void clickOnClose_TocloseSetOrder_SubExamWindows() throws Exception {
	
			clickOnButton(btn_SetOrder_Close_subExam);
			log("Clicked on Close to close set order subexam window and object is:- "
					+ btn_SetOrder_Close_subExam.toString());
		
	}

	// public void clickOnOkForSuccessPopUpHandle() throws Exception {
	// // btn_SucsessOkHandle.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	// if (btn_SucsessOkHandle.isDisplayed()) {
	// //btn_SucsessOkHandle.click();
	// JavascriptExecutor executor = (JavascriptExecutor) driver;
	// executor.executeScript("arguments[0].click();", btn_SucsessOkHandle);
	// log("Clicked on Ok button to success message handle and object is:- " +
	// btn_SucsessOkHandle.toString());
	// Thread.sleep(2000);
	// } else {
	// log("Sucsess Ok button element not present.");
	// Thread.sleep(500);
	// }
	// }

	public void clickOnChangeSelection_ToChangeSubExamMappedSubject() throws Exception {

			isDisplayed(btn_ChangeSelection);
			// btn_ChangeSelection.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btn_ChangeSelection);
			log("Clicked on NO CHANGE SELECTION button to launch sub exam subject mapping window and object is:- "
					+ btn_ChangeSelection.toString());
			Thread.sleep(500);
		
	}

	public void clickOnDeleteSelection_ToDeleteSubExamMappedSubject() throws Exception {


			isDisplayed(btn_DeleteSelection);
			// btn_DeleteSelection.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btn_DeleteSelection);

			log("Clicked on YES DELETE SELECTION button to delete mapped subject for sub exam and object is:- "
					+ btn_DeleteSelection.toString());
			
	}

	//
	// Sub Subject Check box operation

	public void launchSubSubject_SubjectMappingwindow_Sub1() throws Exception {
		isDisplayed(chk_subSubject_Sub1);
		if (!chk_subSubject_Sub1.isSelected()) {
			chk_subSubject_Sub1.click();
			log("Sub Subject check box is checked for subject 1 & Sub-Subject subject mapping window appered and object is:- "
					+ chk_subSubject_Sub1.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is already checked for subject 1");
			Thread.sleep(500);
		}
	}

	public void changeInSelectionAndDeleteSubSubjectMapped_Sub1() throws Exception {
		isDisplayed(chk_subSubject_Sub1);
		if (chk_subSubject_Sub1.isSelected()) {
			chk_subSubject_Sub1.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub-subject subject 1 mapping and object is:- "
					+ chk_subSubject_Sub1.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is not checked for subject 1");
			Thread.sleep(500);
		}
	}

	public void launchSubSubject_SubjectMappingwindow_Sub2() throws Exception {
		isDisplayed(chk_subSubject_Sub2);
		if (!chk_subSubject_Sub2.isSelected()) {
			chk_subSubject_Sub2.click();
			log("Sub Subject check box is checked for subject 2 & Sub Subject subject mapping window appered and object is:- "
					+ chk_subSubject_Sub2.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is already checked for subject 2");
			Thread.sleep(500);
		}
	}

	public void changeInSelectionAndDeleteSubSubjectMapped_Sub2() throws Exception {
		isDisplayed(chk_subSubject_Sub2);
		if (chk_subSubject_Sub2.isSelected()) {
			chk_subSubject_Sub2.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub-Subject subject 2 mapping and object is:- "
					+ chk_subSubject_Sub2.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is not checked for subject 2");
			Thread.sleep(500);
		}
	}

	public void launchSubSubject_SubjectMappingwindow_Sub3() throws Exception {
		isDisplayed(chk_subSubject_Sub3);
		if (!chk_subSubject_Sub3.isSelected()) {
			chk_subSubject_Sub3.click();
			log("Sub Subject check box is checked for subject 3 & Sub-Subject subject mapping window appered and object is:- "
					+ chk_subSubject_Sub3.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is already checked for subject 3");
			Thread.sleep(500);
		}
	}

	public void changeInSelectionAndDeleteSubSubjectMapped_Sub3() throws Exception {
		isDisplayed(chk_subSubject_Sub3);
		if (chk_subSubject_Sub3.isSelected()) {
			chk_subSubject_Sub3.click();
			log("Clicked on checked check box for Delete and Change in Selection for sub-Subject subject 3 mapping and object is:- "
					+ chk_subSubject_Sub3.toString());
			Thread.sleep(2000);
		} else {
			log("Sub Subject check box is not checked for subject 3");
			Thread.sleep(500);
		}
	}

	public void enterDataForSubSubjectMapping_Sub1(String maxMarks_subSubjectSub1, String minMarks_subSubjectSub1,
			String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1) throws Exception {
		isDisplayed(chk_subSubjectMapPopUpWin_Sub1);
		if (!chk_subSubjectMapPopUpWin_Sub1.isSelected()) {
			chk_subSubjectMapPopUpWin_Sub1.click();
			log("Subject 1 is slected for sub-Subject mapping and object is:- "
					+ chk_subSubjectMapPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 is already selected for sub Subject mapping");
			Thread.sleep(500);
		}
	
			inputTextIntoInputField(input_maxMarksSubSubjectPopUpWin_Sub1, maxMarks_subSubjectSub1);
			log("Entered maximum marks for sub-Subject subject 1: " + exemptedPercentage_subSubjectSub1
					+ " and object is:- " + input_maxMarksSubSubjectPopUpWin_Sub1.toString());

			inputTextIntoInputField(input_minMarksSubSubjectPopUpWin_Sub1, minMarks_subSubjectSub1);
			log("Entered minimum marks for sub-Subject subject 1: " + exemptedPercentage_subSubjectSub1
					+ " and object is:- " + input_minMarksSubSubjectPopUpWin_Sub1.toString());
	
			selectElementFromDropDown(sel_gradeSubSubjectPopUpWin_Sub1, grade_subSubjectSub1);
			log("Selected Garde: " + grade_subSubjectSub1 + " and object is:- "
					+ sel_gradeSubSubjectPopUpWin_Sub1.toString());
			isDisplayed(chk_ExemptedFlagsubSubjectPopUpWin_Sub1);
		if (!chk_ExemptedFlagsubSubjectPopUpWin_Sub1.isSelected()) {
			chk_ExemptedFlagsubSubjectPopUpWin_Sub1.click();
			log("Subject 1 Exempted flag is slected for sub Subject mapping and object is:- "
					+ chk_ExemptedFlagsubSubjectPopUpWin_Sub1.toString());
			Thread.sleep(1000);
		} else {
			log("Subject 1 Exempted flag is already selected for sub Subject mapping");
			Thread.sleep(500);
		}
		
			inputTextIntoInputField(input_ExemptedPercentagesubSubjectPopUpWin_Sub1, exemptedPercentage_subSubjectSub1);
			log("Entered Exempted percentage for sub-Subject subject 1 " + exemptedPercentage_subSubjectSub1
					+ " and object is:- " + input_ExemptedPercentagesubSubjectPopUpWin_Sub1.toString());
		
	}

	public void clickOnAddAndClose_ToSubmitSubSubjectMapping() throws Exception {
	
			clickOnButton(btn_AddAndClose_SubSubjectWindow);
			log("Clicked on Add&Close and sub Subject mapping window is closed and object is:- "
					+ btn_AddAndClose_SubSubjectWindow.toString());
			
	}

	public void clickOnCancel_ToClearFilled_SubSubjectData() throws Exception {
	
			clickOnButton(btn_Cancel_SubSubjectWindow);
			log("Clicked on Cancel to clear filled data and object is:- " + btn_Cancel_SubSubjectWindow.toString());
			
	}

	public void clickOnClose_TocloseWindow_SubSubjectData() throws Exception {
	
			clickOnButton(btn_Close_SubSubjectWindow);
			log("Clicked on Close to close sub Subject window and object is:- "
					+ btn_Close_SubSubjectWindow.toString());
		
	}

	// Set Order sub Exam

	public void clickOnSetorder_subSubjectMapping() throws Exception {
	
			clickOnButton(btn_SetOrder_SubSubjectWindow);
			log("Sub Subject mapping set order window apper and object is:- "
					+ btn_SetOrder_SubSubjectWindow.toString());
			
	}

	public void setOrderForSubSubjectMapping_dragAndDrop() {
		isDisplayed(btn_SetOrder_Source);
		builder = new Actions(driver);

		dragAndDrop = builder.clickAndHold(btn_SetOrder_Source).moveToElement(btn_SetOrder_Destination)
				.release(btn_SetOrder_Destination).build();
		dragAndDrop.perform();
		log("Drag and drop to set order sub Subject.");

	}

	public void clickOnSetOrder_Save_TosetOrder_SubSubject() throws Exception {

			clickOnButton(btn_SetOrder_Save_subExam);
			log("Clicked on save sub Subject set order window to set order and object is:- "
					+ btn_SetOrder_Save_subExam.toString());
			
	}

	public void clickOnClose_TocloseSetOrder_SubSubjectWindows() throws Exception {
	
			clickOnButton(btn_SetOrder_Close_subExam);
			log("Clicked on Close to close set order sub-Subject window and object is:- "
					+ btn_SetOrder_Close_subExam.toString());
			
	}

	public void clickOnChangeSelection_ToChangeSubSubjectMappedSubject() throws Exception {

		isDisplayed(btn_ChangeSelection_subSubject);
			// btn_ChangeSelection.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btn_ChangeSelection_subSubject);
			log("Clicked on NO CHANGE SELECTION button to launch sub-Subject subject mapping window and object is:- "
					+ btn_ChangeSelection_subSubject.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnDeleteSelection_ToDeleteSubSubjectMappedSubject() throws Exception {

			isDisplayed(btn_DeleteSelection);
			// btn_DeleteSelection.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btn_DeleteSelection);

			log("Clicked on YES DELETE SELECTION button to delete mapped subject for sub Subject and object is:- "
					+ btn_DeleteSelection.toString());
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
	
	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record updated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_DeactivateCancel_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivate Cancelled");
			log("Record Deactivate Cancel message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_DeactivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record De-activated successfully");
			log("Record De-activated sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateCancel_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activate Cancelled");
			log("Record Activate Cancel message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated successfully");
			log("Record Activated sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_Chnage_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Now You Can Change Selection");
			log("Record Activated sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_Delete_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Deleted Successfully");
			log("Record Deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
