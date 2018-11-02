/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Exam_LoginPrivileges extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_LoginPrivileges.class.getName());

	private WebDriver driver;


	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam
	// Mapping')][1]/following::li[3]")
	// private WebElement btn_ExamLoginPrivilege;

	@FindBy(xpath = "//a[@href='#/app/ExamLoginPrivilages/253']")
	private WebElement btn_ExamLoginPrivilege;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_ExamLoginPrivilege;

	@FindBy(xpath = "//span[contains(text(),'Entry By Class teacher')]/preceding-sibling::input")
	private WebElement rdBtn_EntryByClassteacher;

	@FindBy(xpath = "//span[contains(text(),'Entry By Subject Teacher')]/preceding-sibling::input")
	private WebElement rdBtn_EntryBySubjectteacher;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'User Name :')]/following-sibling::div/select")
	private WebElement sel_UserName;

	@FindBy(xpath = "//label[contains(text(),'Employee Name :')]/following-sibling::div/select")
	private WebElement sel_EmployeeName;

	@FindBy(xpath = "//label[text()='Subjects: ']/following::div[1]/div/input")
	private WebElement input_SearchSubject;

	@FindBy(xpath = "//label[text()='Subjects: ']/following::div[1]//label[1]/input")
	private WebElement chk_Subject;

	@FindBy(xpath = "//label[contains(text(),'Sub Subjects:')]/following::div[2]/input")
	private WebElement input_SearchSubSubject;

	@FindBy(xpath = "//label[contains(text(),'Sub Subjects:')]/following::div[2]//label[1]/input")
	private WebElement chk_SubSubject;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following::div[2]//label[1]/input")
	private WebElement chk_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following::div[2]//label[1]/input")
	private WebElement chk_Section;

	@FindBy(xpath = "//span[contains(text(),'Add')]/parent::button")
	private WebElement btn_Add;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[1]/td[9]/span[1]/a")
	private WebElement icon_Edit_Details;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[9]/span[2]/a")
	private WebElement icon_Delete_Details;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),' Academic Year')]")
	private WebElement btn_Sort_AcademicYear;

	@FindBy(xpath = "//span[contains(text(),' Academic Year')]/following::div[2]/div/input")
	private WebElement input_AcademicYear;

	@FindBy(xpath = "//span[contains(text(),'Employee Name')]")
	private WebElement btn_Sort_EmployeeName;

	@FindBy(xpath = "//span[contains(text(),'Employee Name')]/following::div[2]/div/input")
	private WebElement input_EmployeeName;

	@FindBy(xpath = "//span[contains(text(),'Class Name')]")
	private WebElement btn_Sort_ClassName;

	@FindBy(xpath = "//span[contains(text(),'Class Name')]/following::div[2]/div/input")
	private WebElement input_ClassName;

	@FindBy(xpath = "//span[contains(text(),'Section Name')]")
	private WebElement btn_Sort_SectionName;

	@FindBy(xpath = "//span[contains(text(),'Section Name')]/following::div[2]/div/input")
	private WebElement input_SectionName;

	@FindBy(xpath = "(//div[@class='grid-action-cell ng-scope'])[1]/a[1]")
	private WebElement btn_View_Grid;

	@FindBy(xpath = "(//div[@class='grid-action-cell ng-scope'])[1]/a[2]")
	private WebElement btn_Edit_Grid;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_MaxLoginPrivilege;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_MaxLoginPrivilegeDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_MaxLoginPrivilegeGridView;

	@FindBy(xpath = "//div[@class='modal-body']/table/tbody/tr[1]/td[6]/a")
	private WebElement icon_DeactivateAndActivate;

	@FindBy(xpath = "//button[@class='confirm' and text()='Yes, Deactive it!']")
	private WebElement btnPopUp_YesDeactivateit;

	@FindBy(xpath = "//button[@class='confirm' and text()='Yes, Active it!']")
	private WebElement btnPopUp_YesActivateit;

	@FindBy(xpath = "//button[@class='cancel' and text()='Cancel']")
	private WebElement btnPopUp_Cancel;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;


	public Exam_LoginPrivileges(WebDriver driver) {
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
	 * Navigate to Exam > Exam Mapping > Exam Login Privilege
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_ExamLoginPrivilege() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_ExamMapping);
		log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());

		clickOnButton(btn_ExamLoginPrivilege);
		log("Clicked on Exam Login Privilege Button and object is:-" + btn_ExamLoginPrivilege.toString());

	}

	/**
	 * Validation of Exam Login Privilege screen message
	 * 
	 * @return
	 */
	public boolean verifyExamLoginPrivilegePage() {
		try {
			System.out.println(txt_ExamLoginPrivilege.getText());
			txt_ExamLoginPrivilege.isDisplayed();
			log("Exam Login Privilege  page is dispalyed and object is:-" + txt_ExamLoginPrivilege.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Exam Login Privilege Form for Class Teacher
	 * 
	 * @param academicYear
	 * @param userName
	 * @param subject
	 * @param sub_Subject
	 * @throws Exception
	 */
	public void fill_ExamLoginPrivilege_Form_ForClassTeacher(String academicYear, String userName, String employeeName,
			String subject, String sub_Subject) throws Exception {
		isDisplayed(rdBtn_EntryByClassteacher);
		if (!rdBtn_EntryByClassteacher.isSelected()) {
			rdBtn_EntryByClassteacher.click();
			log("Class Teacher entry radio button is selected and object is:- " + rdBtn_EntryByClassteacher.toString());
			Thread.sleep(1000);
		} else {
			log("Enter By Class Teacher radio button is alraedy selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_UserName, userName);
		log("Selected User Name: " + userName + " and object is:- " + sel_UserName.toString());

		selectElementFromDropDown(sel_EmployeeName, employeeName);
		log("Selected Employee: " + employeeName + " and object is:- " + sel_EmployeeName.toString());

		inputTextIntoInputField(input_SearchSubject, subject);
		log("Search subject from list for selection:- " + subject + " and object is:-"
				+ input_SearchSubject.toString());
		isDisplayed(chk_Subject);
		if (!chk_Subject.isSelected()) {
			chk_Subject.click();
			log("Subject is selected for the class teacher and object is:- " + chk_Subject.toString());
			Thread.sleep(1000);
		} else {
			log("Subject is already selected for class teacher.");
			Thread.sleep(500);
		}
		// if(input_SearchSubSubject.isDisplayed()){
		// input_SearchSubSubject.clear();
		// input_SearchSubSubject.sendKeys(sub_Subject);
		// log("Search Sub-subject from list for selection:- "+sub_Subject+" and
		// object is:-"+input_SearchSubSubject.toString());
		// Thread.sleep(1000);
		// }else{
		// log("Seach Sub subject element is not present.");
		// Thread.sleep(500);
		// }
		// if(!chk_SubSubject.isSelected()){
		// chk_SubSubject.click();
		// log("Sub-subject is selected for the class teacher and object is:-
		// "+chk_SubSubject.toString());
		// Thread.sleep(1000);
		// }
		// else{
		// log("Sub-subject is already selected for class teacher.");
		// Thread.sleep(500);
		// }
	}

	/**
	 * Fill Exam Exam Login Privilege Form for Subject Teacher
	 * 
	 * @param academicYear
	 * @param userName
	 * @param subject
	 * @param sub_Subject
	 * @throws Exception
	 */
	public void fill_ExamLoginPrivilege_Form_ForSubjectTeacher(String academicYear, String userName,
			String employeeName, String subject, String sub_Subject) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamLoginPrivilege);
		Thread.sleep(1000);
		isDisplayed(rdBtn_EntryBySubjectteacher);
		if (!rdBtn_EntryBySubjectteacher.isSelected()) {
			rdBtn_EntryBySubjectteacher.click();
			log("Subject Teacher entry radio button is selected and object is:- "
					+ rdBtn_EntryBySubjectteacher.toString());
			Thread.sleep(1000);
		} else {
			log("Enter By Subject Teacher element is not present.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_UserName, userName);
		log("Selected User Name: " + userName + " and object is:- " + sel_UserName.toString());

		selectElementFromDropDown(sel_EmployeeName, employeeName);
		log("Selected Employee: " + employeeName + " and object is:- " + sel_EmployeeName.toString());
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class is selected for the Subject teacher and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class is already selected for Subject teacher.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section is selected for the Subject teacher and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section is already selected for Subject teacher.");
			Thread.sleep(500);
		}

		inputTextIntoInputField(input_SearchSubject, subject);
		log("Search subject from list for selection:- " + subject + " and object is:-"
				+ input_SearchSubject.toString());
		isDisplayed(chk_Subject);
		if (!chk_Subject.isSelected()) {
			chk_Subject.click();
			log("Subject is selected for the class teacher and object is:- " + chk_Subject.toString());
			Thread.sleep(1000);
		} else {
			log("Subject is already selected for class teacher.");
			Thread.sleep(500);
		}
		// if(input_SearchSubSubject.isDisplayed()){
		// input_SearchSubSubject.clear();
		// input_SearchSubSubject.sendKeys(sub_Subject);
		// log("Search Sub-subject from list for selection:- "+sub_Subject+" and
		// object is:-"+input_SearchSubSubject.toString());
		// Thread.sleep(1000);
		// }else{
		// log("Seach Sub subject element is not present.");
		// Thread.sleep(500);
		// }
		// if(!chk_SubSubject.isSelected()){
		// chk_SubSubject.click();
		// log("Sub-subject is selected for the class teacher and object is:-
		// "+chk_SubSubject.toString());
		// Thread.sleep(1000);
		// }
		// else{
		// log("Sub-subject is already selected for class teacher.");
		// Thread.sleep(500);
		// }
	}

	public void editRecordsAndUpdateSubSubject_InDetailsSection(String academicYear, String userName,
			String employeeName, String subject, String sub_Subject) throws Exception {

		clickOnButton(icon_Edit_Details);
		log("Edit icon is clicked and object is:- " + icon_Edit_Details.toString());

		inputTextIntoInputField(input_SearchSubSubject, sub_Subject);
		log("Search Sub-subject from list for selection:- " + sub_Subject + " and object is:-"
				+ input_SearchSubSubject.toString());
		isDisplayed(chk_SubSubject);
		if (!chk_SubSubject.isSelected()) {
			chk_SubSubject.click();
			log("Sub-subject is selected for the class teacher and object is:- " + chk_SubSubject.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-subject is already selected for class teacher.");
			Thread.sleep(500);
		}
	}

	/**
	 * Submit blank Exam Login Privilege form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_ExamLoginPrivilegeForm() throws Exception {

		clickOnButton(btn_Add);
		log("Submit blank Exam Login Privilege form and object is:-" + btn_Add.toString());

	}

	/**
	 * Add Exam login privilege form to get data updated in the details section
	 * 
	 * @throws Exception
	 */
	public void addToSubmit_ExamLoginPrivilegeForm() throws Exception {

		clickOnButton(btn_Add);
		log("Submit Exam Login Privilege form to add data in details section and object is:-" + btn_Add.toString());

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_Min_MaxLoginPrivilegeDetails);
		Thread.sleep(5000);

	}

	/**
	 * Click on save button to save Exam Login Privilege data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitExamLoginPrivilegeForm() throws Exception {

		clickOnButton(btn_Save);
		log("clicked on save button to Submit the records for Exam Login Privilege and object is:-"
				+ btn_Save.toString());

	}

	public void clickOnCancelButton_ToClearFilledExamLoginPrivilegeForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("clicked on Cancel button to clear filled data for Exam Login Privilege and object is:-"
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

	}

	public void sortWithAcademicYearInGridView() throws Exception {

		clickOnButton(btn_Sort_AcademicYear);
		clickOnButton(btn_Sort_AcademicYear);
		log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());

	}

	public void sortWithEmployeeNameInGridView() throws Exception {

		clickOnButton(btn_Sort_EmployeeName);
		log("Sort by Employee Name in grid view and object is:- " + btn_Sort_EmployeeName.toString());

	}

	public void sortWithClassNameInGridView() throws Exception {

		clickOnButton(btn_Sort_ClassName);
		log("Sort by Class Name in grid view and object is:- " + btn_Sort_ClassName.toString());

	}

	public void sortWithSectionNameInGridView() throws Exception {

		clickOnButton(btn_Sort_SectionName);
		log("Sort by Section Name in grid view and object is:- " + btn_Sort_SectionName.toString());

	}

	public void filterRecordsBasedOn_AcademicYear(String academicYear, String employeeName, String className,
			String sectionName) throws Exception {

		inputTextIntoInputField(input_AcademicYear, academicYear);
		log("Entered academic year " + academicYear + " to filter records and object is:- "
				+ input_AcademicYear.toString());

	}

	public void filterRecordsBasedOn_EmployeeName(String academicYear, String employeeName, String className,
			String sectionName) throws Exception {

		inputTextIntoInputField(input_EmployeeName, employeeName);
		log("Entered Employee Name " + employeeName + " to filter records and object is:- "
				+ input_EmployeeName.toString());

	}

	public void filterRecordsBasedOn_ClassName(String academicYear, String employeeName, String className,
			String sectionName) throws Exception {

		inputTextIntoInputField(input_ClassName, className);
		log("Entered Class Name " + className + " to filter records and object is:- " + input_ClassName.toString());

	}

	public void filterRecordsBasedOn_SectionName(String academicYear, String employeeName, String className,
			String sectionName) throws Exception {

		inputTextIntoInputField(input_SectionName, sectionName);
		log("Entered Section Name " + sectionName + " to filter records and object is:- "
				+ input_SectionName.toString());

	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_AcademicYear);
		input_AcademicYear.clear();
		isDisplayed(input_EmployeeName);
		input_EmployeeName.clear();
		isDisplayed(input_ClassName);
		input_ClassName.clear();
		isDisplayed(input_SectionName);
		input_SectionName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Edit_Grid);
		Thread.sleep(1000);

		clickOnButton(btn_View_Grid);
		log("Clicked on View Icon to launch pop up windows to see created exam login privilege and object is:-"
				+ btn_View_Grid.toString());
		Thread.sleep(1000);
		boolean closeButton = btn_View_ClosePopUp.isDisplayed();
		Assert.assertTrue(closeButton);
		Thread.sleep(1000);

	}

	public void clickOnEditIcon_ToUpdateExamLoginPrivilege() throws Exception {

		clickOnButton(btn_Edit_Grid);
		log("Clicked on Edit Icon to update exam login privilege and object is:-" + btn_Edit_Grid.toString());

	}

	public void deactivateRecords_ViewWindow() throws Exception {

		isDisplayed(icon_DeactivateAndActivate);
		String DeactivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
		System.out.println("Tool tip text present :- " + DeactivateText);

		// Compare toll tip text
		Assert.assertEquals(DeactivateText, "Deactivate Now");

		icon_DeactivateAndActivate.click();
		log("Clicked on Deacivate Icon to Deactivate Exam Login Privilege record and object is:-"
				+ icon_DeactivateAndActivate.toString());
		Thread.sleep(1000);

	}

	public void activateRecords_ViewWindow() throws Exception {

		isDisplayed(icon_DeactivateAndActivate);
		String ActivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
		System.out.println("Tool tip text present :- " + ActivateText);

		// Compare toll tip text
		Assert.assertEquals(ActivateText, "Activate Now");

		icon_DeactivateAndActivate.click();
		log("Clicked on Acivate Icon to Activate Exam Login Privilege record and object is:-"
				+ icon_DeactivateAndActivate.toString());
		Thread.sleep(1000);

	}

	public void yesDeactivateExamLoginPrivilegeRecord() throws Exception {

		clickOnButton(btnPopUp_YesDeactivateit);
		log("Clicked on Yes Deactivate button for deactivation of record and object is:- "
				+ btnPopUp_YesDeactivateit.toString());

	}

	public void yesActivateExamLoginPrivilegeRecord() throws Exception {

		clickOnButton(btnPopUp_YesActivateit);
		log("Clicked on Yes Activate button for Activation of record and object is:- "
				+ btnPopUp_YesActivateit.toString());

	}

	public void cancelDeactivationAndActivationOfRecord() throws Exception {

		clickOnButton(btnPopUp_Cancel);
		log("Clicked on Cancel button for Cancelation of Activation or Deactivation of record and object is:- "
				+ btnPopUp_Cancel.toString());

	}

	public void min_Max_ExamLoginPrivilege() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamLoginPrivilege);
		Thread.sleep(1000);

		clickOnButton(btn_Min_MaxLoginPrivilege);
		log("Exam Login Privilege page minimized or maximized and object is:-" + btn_Min_MaxLoginPrivilege.toString());

	}

	public void min_Max_ExamLoginPrivilege_Details() throws Exception {

		clickOnButton(btn_Min_MaxLoginPrivilegeDetails);
		log("Exam Login Privilege Details page minimized or maximized and object is:-"
				+ btn_Min_MaxLoginPrivilegeDetails.toString());

	}

	public void min_Max_ExamLoginPrivilege_GridView() throws Exception {

		clickOnButton(btn_Min_MaxLoginPrivilegeGridView);
		log("Exam Login Privilege Grid View page minimized or maximized and object is:-"
				+ btn_Min_MaxLoginPrivilegeGridView.toString());

	}

	public void deleteRecordsFromDetailsSelection() throws Exception {

		clickOnButton(icon_Delete_Details);
		log("Record deleted from details section and object is:- " + icon_Delete_Details.toString());

	}

	public void closeViewWindow_LoginPrvilege() throws Exception {

		clickOnButton(btn_View_ClosePopUp);
		log("View window close button is clicked and object is:- " + btn_View_ClosePopUp.toString());

	}
	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved/Updated Successfully");
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
			assertEquals(text, "Record Saved/Updated Successfully");
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
			assertEquals(text, "RecordDeactiveCancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_DeactivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Deactivated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateCancel_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "RecordActiveCancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Activated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
