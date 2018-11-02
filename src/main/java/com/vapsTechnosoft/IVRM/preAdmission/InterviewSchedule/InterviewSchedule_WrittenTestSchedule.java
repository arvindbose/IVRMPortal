/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule;

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
public class InterviewSchedule_WrittenTestSchedule extends TestBase {

	public static final Logger log = Logger.getLogger(InterviewSchedule_WrittenTestSchedule.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview Schedule')][1]")
	private WebElement btn_InterviewSchedule;

	// @FindBy(xpath =
	// "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview
	// Schedule')][1]/following::li[2]")
	// private WebElement btn_WrittenTestSchedule;

	@FindBy(xpath = "//a[@href='#/app/wschedule/15']")
	private WebElement btn_WrittenTestSchedule;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_PreAdm_writtenTestSchedulePage;

	@FindBy(xpath = "//label[contains(text(),'Schedule Name:')]/following-sibling::div/input")
	private WebElement input_ScheduleName;

	@FindBy(xpath = "//label[contains(text(),'Remarks:')]/following-sibling::div/input")
	private WebElement input_Remarks;

	@FindBy(xpath = "//label[contains(text(),'Supervisor:')]/following-sibling::div/input")
	private WebElement input_Supervisor;

	@FindBy(xpath = "//label[contains(text(),'Skill/Knowledge:')]/following-sibling::div/textarea")
	private WebElement input_Skills;

	// @FindBy(xpath = "//input[@class='md-datepicker-input']")
	// WebElement inputOraltestDate;

	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_Calender;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]/following::td[29]")
	private WebElement btn_ScheduleDate;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[1]/input")
	private WebElement input_ScheduleTime_FromHr;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[3]/input")
	private WebElement input_ScheduleTime_FromMin;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[6]/button")
	private WebElement btn_From_AM_PM;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[1]/input")
	private WebElement input_ScheduleTime_ToHr;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[3]/input")
	private WebElement input_ScheduleTime_ToMin;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[6]/button")
	private WebElement btn_To_AM_PM;

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement search_Student;

	@FindBy(xpath = "(//table/tbody)[3]/tr[1]/td[8]/input")
	private WebElement chk_Student1StuList;

	@FindBy(xpath = "(//table/tbody)[3]/tr[2]/td[8]/input")
	private WebElement chk_Student2StuList;

	@FindBy(xpath = "(//table/tbody)[3]/tr[3]/td[8]/input")
	private WebElement chk_Student3StuList;

	@FindBy(xpath = "(//table/tbody)[5]/tr[2]/td[9]/a")
	private WebElement icon_deleteCart;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	private WebElement inputsearch_ScheduleName;

	@FindBy(xpath = "(//table/tbody)[8]/tr[1]/td[2]")
	private WebElement ScheduleName_Validate;

	@FindBy(xpath = "(//table/tbody)[8]/tr[1]/td[7]/span[1]/a")
	private WebElement icon_Edit;

	@FindBy(xpath = "(//table/tbody)[8]/tr[1]/td[7]/span[2]/a")
	private WebElement icon_Delete;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement btn_sort_ScheduleName;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[3]/a")
	private WebElement btn_sort_ScheduleDate;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_WRITTENTESTSCHEDULE;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_StudentList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_Max_SELECTEDSTUDENTTOCART;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	private WebElement btn_Min_Max_WRITTENTESTSCHEDULELISTGrid;

	@FindBy(xpath = "(//table/tbody)[7]/tr[1]/td[9]/a")
	private WebElement icon_Delete_SelectedStudentEdit;

	@FindBy(xpath = "//button[@class='confirm' and text()='Yes,delete it!']")
	private WebElement btn_Yesdeleteit;

	@FindBy(xpath = "//button[@class='confirm' and text()='Yes,Delete it!']")
	private WebElement btn_Yesdeleteit_Grid;

	@FindBy(xpath = "//button[@class='cancel' and text()='Cancel..!']")
	private WebElement btn_Cancel_delete;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[2]/a")
	private WebElement sort_StudentName_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[3]/a")
	private WebElement sort_RegNo_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[4]/a")
	private WebElement sort_Class_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[5]/a")
	private WebElement sort_Gender_StuList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleName_ScheduleList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleDate_ScheduleList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public InterviewSchedule_WrittenTestSchedule(WebDriver driver) {
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

	public void navigateToInterViewSchedule_writtenTestSchedule() throws Exception {
		clickOnButton(btn_PreAdmission);
		log("Clicked on pre admission button and object is:-" + btn_PreAdmission.toString());

		clickOnButton(btn_InterviewSchedule);
		log("Clicked on interview schedule button and object is:-" + btn_InterviewSchedule.toString());

		clickOnButton(btn_WrittenTestSchedule);
		log("Clicked on Written test schedule button and object is:-" + btn_WrittenTestSchedule.toString());

	}

	public boolean verifyInterviewSchedule_WrittenTestSchedulePage() {
		try {
			System.out.println(txt_PreAdm_writtenTestSchedulePage.getText().trim());
			txt_PreAdm_writtenTestSchedulePage.isDisplayed();
			log("Interview schedule page is dispalyed and object is:-" + txt_PreAdm_writtenTestSchedulePage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void fill_WrittenTestSchedule_Form(String scheduleName, String remarks, String supervisor, String skill,
			String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin) throws Exception {

		inputTextIntoInputField(input_ScheduleName, scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + input_ScheduleName.toString());

		// copyToClipbord(scheduleDate);
		//
		// Actions oAction = new Actions(driver);
		// oAction.moveToElement(inputOraltestDate);
		// oAction.contextClick(inputOraltestDate).build().perform();
		//
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// log("Entered schedule date " + scheduleDate + " and object is:-" +
		// inputOraltestDate.toString());
		// Thread.sleep(2000);

		clickOnButton(btn_Calender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_ScheduleDate.click();
		log("Schedule date is selected from calender.");
		Thread.sleep(1000);

		inputTextIntoInputField(input_Remarks, remarks);
		log("Entered remarks " + remarks + " and object is:-" + input_Remarks.toString());

		inputTextIntoInputField(input_Supervisor, supervisor);
		log("Entered supervisor " + supervisor + " and object is:-" + input_Supervisor.toString());

		inputTextIntoInputField(input_Skills, skill);
		log("Entered skill " + skill + " and object is:-" + input_Skills.toString());

		inputTextIntoInputField(input_ScheduleTime_FromHr, FromSchTimeHr);
		log("Entered From schedule time hour(From) " + FromSchTimeHr + " and object is:-"
				+ input_ScheduleTime_FromHr.toString());

		inputTextIntoInputField(input_ScheduleTime_FromMin, FromSchTimeMin);
		log("Entered From schedule time minute(From) " + FromSchTimeMin + " and object is:-"
				+ input_ScheduleTime_FromMin.toString());

		inputTextIntoInputField(input_ScheduleTime_ToHr, ToSchTimeHr);
		log("Entered To schedule time hour(To) " + ToSchTimeHr + " and object is:-"
				+ input_ScheduleTime_ToHr.toString());

		inputTextIntoInputField(input_ScheduleTime_ToMin, ToSchTimeMin);
		log("Entered To schedule time minute " + ToSchTimeMin + " and object is:-"
				+ input_ScheduleTime_ToMin.toString());

		clickOnButton(btn_To_AM_PM);
		log("PM is selected for To Time and object is:-" + btn_To_AM_PM.toString());

	}

	public void selectStudentFromStudentList_ToScheduleWrittenTest() throws Exception {
		isDisplayed(chk_Student1StuList);
		if (!chk_Student1StuList.isSelected()) {
			chk_Student1StuList.click();
			log("Student 1 is selected for written test schedule and object is:-" + chk_Student1StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student 1 is already selected for written test and object is:-" + chk_Student1StuList.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Student2StuList);
		if (!chk_Student2StuList.isSelected()) {
			chk_Student2StuList.click();
			log("Student 2 is selected for written test schedule and object is:-" + chk_Student2StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student 2 is already selected for written test and object is:-" + chk_Student2StuList.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Student3StuList);
		if (!chk_Student3StuList.isSelected()) {
			chk_Student3StuList.click();
			log("Student 3 is selected for written test schedule and object is:-" + chk_Student3StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student 3 is already selected for written test and object is:-" + chk_Student3StuList.toString());
			Thread.sleep(500);
		}
	}

	public void delete2ndStudentFrom_SelectedStudentToCart() throws Exception {

		if (icon_deleteCart.isDisplayed()) {

			String DeleteText = icon_deleteCart.getAttribute("title");
			System.out.println("Tool tip text present :- " + DeleteText);

			// Compare toll tip text
			Assert.assertEquals(DeleteText, "Delete");

			clickOnButton(icon_deleteCart);
			log("Clicked on Delete Icon to delete student selected to cart for written test and object is:-"
					+ icon_deleteCart.toString());
			Thread.sleep(1000);
		} else {
			log("Delete Icon element is not presentand object is:-" + icon_deleteCart.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitWrittenTest() throws Exception {

		clickOnButton(btn_Save);
		log("Save button is clicked to save the Written test schedule and object is:-" + btn_Save.toString());
		Thread.sleep(1000);

	}

	public void clickOnCancelButton_ToClearFilledWrittenTest() throws Exception {

		clickOnButton(btn_Cancel);
		log("Cancel button is clicked to Clear filled Written test schedule and object is:-" + btn_Cancel.toString());

	}

	public void searchWithScheduleName_InwrittenTestScheduleList(String scheduleName) throws Exception {

		inputTextIntoInputField(inputsearch_ScheduleName, scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + inputsearch_ScheduleName.toString());
		try {
			if (ScheduleName_Validate.isDisplayed()) {
				String schName = ScheduleName_Validate.getText().trim();
				assertEquals(scheduleName, schName);
				log("First Schedule name and searched with schedule name is same and object is:-"
						+ ScheduleName_Validate.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit_WrittenTestSchedule() throws Exception {
		try {
			if (icon_Edit.isDisplayed()) {

				String EditText = icon_Edit.getAttribute("title");
				System.out.println("Tool tip text present :- " + EditText);

				// Compare toll tip text
				Assert.assertEquals(EditText, "Edit");

				icon_Edit.click();
				log("Clicked on Edit Icon to edit schedule for written test and object is:-" + icon_Edit.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentFrom_SelectedStudent_Edit() throws Exception {
		try {
			if (icon_Delete_SelectedStudentEdit.isDisplayed()) {

				String DeleteText = icon_Delete_SelectedStudentEdit.getAttribute("title");
				System.out.println("Tool tip text present :- " + DeleteText);

				// Compare toll tip text
				Assert.assertEquals(DeleteText, "Delete");

				icon_Delete_SelectedStudentEdit.click();
				log("Clicked on Delete Icon to delete student from selected list(edit) for written test and object is:-"
						+ icon_Delete_SelectedStudentEdit.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmDelete_YesDeleteIt() throws Exception {

		clickOnButton(btn_Yesdeleteit);
		log("Yes Delete It is clicked to delete student from sheduled Written test schedule list and object is:-"
				+ btn_Yesdeleteit.toString());

	}

	public void confirmDelete_YesDeleteIt_Grid() throws Exception {

		clickOnButton(btn_Yesdeleteit_Grid);
		log("Yes Delete It is clicked to delete student from sheduled Written test schedule list and object is:-"
				+ btn_Yesdeleteit_Grid.toString());
		Thread.sleep(1000);

	}

	public void confirmDelete_Cancel() throws Exception {

		clickOnButton(btn_Cancel_delete);
		log("Cancel button pop up is clicked to cancel student from deleting, from sheduled Written test schedule list and object is:-"
				+ btn_Cancel_delete.toString());

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

	public void delete_ScheduleWrittenTest_FromScheduleListGrid() throws Exception {
		try {
			if (icon_Delete.isDisplayed()) {
				String DeleteText = icon_Delete.getAttribute("title");
				System.out.println("Tool tip text present :- " + DeleteText);

				// Compare toll tip text
				Assert.assertEquals(DeleteText, "Delete");

				icon_Delete.click();
				log("Clicked on Delete Icon to delete Schedule from schedule list grid for written test and object is:-"
						+ icon_Delete.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortWithStudentName_InStudentList() throws Exception {

		clickOnButton(sort_StudentName_StuList);
		clickOnButton(sort_StudentName_StuList);
		log("Sort by Student Name in Student list and object is:- " + sort_StudentName_StuList.toString());

	}

	public void sortWithRegistrationNumber_InStudentList() throws Exception {

		clickOnButton(sort_RegNo_StuList);
		log("Sort by Registration Number in Student list and object is:- " + sort_RegNo_StuList.toString());

	}

	public void sortWithGender_InStudentList() throws Exception {

		clickOnButton(sort_Gender_StuList);
		log("Sort by Gender in Student list and object is:- " + sort_Gender_StuList.toString());

	}

	public void sortWithClass_InStudentList() throws Exception {

		clickOnButton(sort_Class_StuList);
		log("Sort by Class in Student list and object is:- " + sort_Class_StuList.toString());

	}

	public void sortWithScheduleName_InScheduleList() throws Exception {

		clickOnButton(sort_ScheduleName_ScheduleList);
		log("Sort by Schedule Name in Schedule list and object is:- " + sort_ScheduleName_ScheduleList.toString());

	}

	public void sortWithScheduleDate_InScheduleList() throws Exception {

		clickOnButton(sort_ScheduleDate_ScheduleList);
		log("Sort by Schedule Date in Schedule list and object is:- " + sort_ScheduleDate_ScheduleList.toString());

	}

	public void min_Max_WrittenTestScheduleForm() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txt_PreAdm_writtenTestSchedulePage);

		clickOnButton(btn_Min_Max_WRITTENTESTSCHEDULE);
		log("Written Test Schedule form section minimized or maximized and object is:-"
				+ btn_Min_Max_WRITTENTESTSCHEDULE.toString());

	}

	public void min_Max_StudentList() throws Exception {

		clickOnButton(btn_Min_Max_StudentList);
		log("Student list section minimized or maximized and object is:-" + btn_Min_Max_StudentList.toString());

	}

	public void min_Max_SelectedStudentToCart() throws Exception {

		clickOnButton(btn_Min_Max_SELECTEDSTUDENTTOCART);
		log("Selected student to cart section minimized or maximized and object is:-"
				+ btn_Min_Max_SELECTEDSTUDENTTOCART.toString());

	}

	public void min_Max_WrittenTestScheduleListGrid() throws Exception {

		clickOnButton(btn_Min_Max_WRITTENTESTSCHEDULELISTGrid);
		log("Written Test Schedule list grid section minimized or maximized and object is:-"
				+ btn_Min_Max_WRITTENTESTSCHEDULELISTGrid.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_DeletedCancelled() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Cancelled");
			log("Record Deleted Cancelled validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_DeletedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record Deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
