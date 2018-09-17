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

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview Schedule')][1]/following::li[2]")
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

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[27]")
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
		if (btn_PreAdmission.isDisplayed()) {
			btn_PreAdmission.click();
			log("Clicked on pre admission button and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("Navigation menu pre admission button element not presentand object is:-"
					+ btn_PreAdmission.toString());
			Thread.sleep(500);
		}
		if (btn_InterviewSchedule.isDisplayed()) {
			btn_InterviewSchedule.click();
			log("Clicked on interview schedule button and object is:-" + btn_InterviewSchedule.toString());
			Thread.sleep(1000);
		} else {
			log("Navigation sub-menu Interview schedule button element not present.");
			Thread.sleep(500);
		}
		if (btn_WrittenTestSchedule.isDisplayed()) {
			btn_WrittenTestSchedule.click();
			log("Clicked on Written test schedule button and object is:-" + btn_WrittenTestSchedule.toString());
			Thread.sleep(1000);
		} else {
			log("Navigation sub-menu Written Test Schedule button element not present.");
			Thread.sleep(500);
		}
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

	public void fill_WrittenTestSchedule_Form(String scheduleName,String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin) throws Exception {
		
		if (input_ScheduleName.isDisplayed()) {
			input_ScheduleName.clear();
			input_ScheduleName.sendKeys(scheduleName);
			log("Entered schedule name " + scheduleName + " and object is:-" + input_ScheduleName.toString());
			Thread.sleep(2000);
		} else {
			log("Schedule name field element not present.");
			Thread.sleep(500);
		}

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

		if (btn_Calender.isDisplayed()) {
			btn_Calender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_ScheduleDate.click();
			log("Schedule date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Schedule Date Calendar button element not present.");
			Thread.sleep(500);
		}
		
		if (input_Remarks.isDisplayed()) {
			input_Remarks.clear();
			input_Remarks.sendKeys(remarks);
			log("Entered remarks " + remarks + " and object is:-" + input_Remarks.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks field element not present.");
			Thread.sleep(500);
		}
		
		if (input_Supervisor.isDisplayed()) {
			input_Supervisor.clear();
			input_Supervisor.sendKeys(supervisor);
			log("Entered supervisor " + supervisor + " and object is:-" + input_Supervisor.toString());
			Thread.sleep(1000);
		} else {
			log("Supervisor field element not present.");
			Thread.sleep(500);
		}
		
		if (input_Skills.isDisplayed()) {
			input_Skills.clear();
			input_Skills.sendKeys(skill);
			log("Entered skill " + skill + " and object is:-" + input_Skills.toString());
			Thread.sleep(1000);
		} else {
			log("Skills field element not present and object is:-" + input_Skills.toString());
			Thread.sleep(500);
		}

		if (input_ScheduleTime_FromHr.isDisplayed()) {
			input_ScheduleTime_FromHr.clear();
			input_ScheduleTime_FromHr.sendKeys(FromSchTimeHr);
			log("Entered From schedule time hour(From) " + FromSchTimeHr + " and object is:-"
					+ input_ScheduleTime_FromHr.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time hour(From) field element not present and object is:-"
					+ input_ScheduleTime_FromHr.toString());
			Thread.sleep(500);
		}
		if (input_ScheduleTime_FromMin.isDisplayed()) {
			input_ScheduleTime_FromMin.clear();
			input_ScheduleTime_FromMin.sendKeys(FromSchTimeMin);
			log("Entered From schedule time minute(From) " + FromSchTimeMin + " and object is:-"
					+ input_ScheduleTime_FromMin.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time minute(From) field element not present.");
			Thread.sleep(500);
		}
		if (input_ScheduleTime_ToHr.isDisplayed()) {
			input_ScheduleTime_ToHr.clear();
			input_ScheduleTime_ToHr.sendKeys(ToSchTimeHr);
			log("Entered To schedule time hour(To) " + ToSchTimeHr + " and object is:-"
					+ input_ScheduleTime_ToHr.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time hour(To) field element not present.");
			Thread.sleep(500);
		}
		if (input_ScheduleTime_ToMin.isDisplayed()) {
			input_ScheduleTime_ToMin.clear();
			input_ScheduleTime_ToMin.sendKeys(ToSchTimeMin);
			log("Entered To schedule time minute " + ToSchTimeMin + " and object is:-"
					+ input_ScheduleTime_ToMin.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time minute(To) field element not present.");
			Thread.sleep(500);
		}
		if (btn_To_AM_PM.isDisplayed()) {
			btn_To_AM_PM.click();
			log("PM is selected for To Time and object is:-" + btn_To_AM_PM.toString());
			Thread.sleep(1000);
		} else {
			log("To AM/PM button element not present.");
			Thread.sleep(500);
		}
	}

	public void selectStudentFromStudentList_ToScheduleWrittenTest() throws Exception {
		if (!chk_Student1StuList.isSelected()) {
			chk_Student1StuList.click();
			log("Student 1 is selected for written test schedule and object is:-" + chk_Student1StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student 1 is already selected for written test and object is:-" + chk_Student1StuList.toString());
			Thread.sleep(500);
		}

		if (!chk_Student2StuList.isSelected()) {
			chk_Student2StuList.click();
			log("Student 2 is selected for written test schedule and object is:-" + chk_Student2StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student 2 is already selected for written test and object is:-" + chk_Student2StuList.toString());
			Thread.sleep(500);
		}
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

			icon_deleteCart.click();
			log("Clicked on Delete Icon to delete student selected to cart for written test and object is:-"
					+ icon_deleteCart.toString());
			Thread.sleep(1000);
		} else {
			log("Delete Icon element is not presentand object is:-" + icon_deleteCart.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitWrittenTest() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Save button is clicked to save the Written test schedule and object is:-" + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element not present and object is:-" + btn_Save.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearFilledWrittenTest() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Cancel button is clicked to Clear filled Written test schedule and object is:-"
					+ btn_Cancel.toString());
			Thread.sleep(2000);
		} else {
			log("Save button element not present and object is:-" + btn_Cancel.toString());
			Thread.sleep(500);
		}
	}

	public void searchWithScheduleName_InwrittenTestScheduleList(String scheduleName) throws Exception {
		if (inputsearch_ScheduleName.isDisplayed()) {
			inputsearch_ScheduleName.clear();
			inputsearch_ScheduleName.sendKeys(scheduleName);
			log("Entered schedule name " + scheduleName + " and object is:-" + inputsearch_ScheduleName.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present in Written test schedule list and object is:-"
					+ inputsearch_ScheduleName.toString());
			Thread.sleep(500);
		}
		if(ScheduleName_Validate.isDisplayed()){
			String schName = ScheduleName_Validate.getText().trim();
			assertEquals(scheduleName, schName);
			log("First Schedule name and searched with schedule name is same and object is:-"+ScheduleName_Validate.toString());
			Thread.sleep(1000);		
		}
	}

	public void edit_WrittenTestSchedule() throws Exception {

		if (icon_Edit.isDisplayed()) {

			String EditText = icon_Edit.getAttribute("title");
			System.out.println("Tool tip text present :- " + EditText);

			// Compare toll tip text
			Assert.assertEquals(EditText, "Edit");

			icon_Edit.click();
			log("Clicked on Edit Icon to edit schedule for written test and object is:-" + icon_Edit.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present in schedule list grid and object is:-" + icon_Edit.toString());
			Thread.sleep(500);
		}
	}

	public void deleteStudentFrom_SelectedStudent_Edit() throws Exception {

		if (icon_Delete_SelectedStudentEdit.isDisplayed()) {

			String DeleteText = icon_Delete_SelectedStudentEdit.getAttribute("title");
			System.out.println("Tool tip text present :- " + DeleteText);

			// Compare toll tip text
			Assert.assertEquals(DeleteText, "Delete");

			icon_Delete_SelectedStudentEdit.click();
			log("Clicked on Delete Icon to delete student from selected list(edit) for written test and object is:-"
					+ icon_Delete_SelectedStudentEdit.toString());
			Thread.sleep(1000);
		} else {
			log("Delete Icon element is not present in selected student edit and object is:-"
					+ icon_Delete_SelectedStudentEdit.toString());
			Thread.sleep(500);
		}
	}

	public void confirmDelete_YesDeleteIt() throws Exception {
		if (btn_Yesdeleteit.isDisplayed()) {
			btn_Yesdeleteit.click();
			log("Yes Delete It is clicked to delete student from sheduled Written test schedule list and object is:-"
					+ btn_Yesdeleteit.toString());
			Thread.sleep(2000);
		} else {
			log("Yes Delete It button element not present and object is:-" + btn_Yesdeleteit.toString());
			Thread.sleep(500);
		}
	}

	public void confirmDelete_YesDeleteIt_Grid() throws Exception {
		if (btn_Yesdeleteit_Grid.isDisplayed()) {
			btn_Yesdeleteit_Grid.click();
			log("Yes Delete It is clicked to delete student from sheduled Written test schedule list and object is:-"
					+ btn_Yesdeleteit_Grid.toString());
			Thread.sleep(2000);
		} else {
			log("Yes Delete It button element not present and object is:-" + btn_Yesdeleteit_Grid.toString());
			Thread.sleep(500);
		}
	}

	public void confirmDelete_Cancel() throws Exception {
		if (btn_Cancel_delete.isDisplayed()) {
			btn_Cancel_delete.click();
			log("Cancel button pop up is clicked to cancel student from deleting, from sheduled Written test schedule list and object is:-"
					+ btn_Cancel_delete.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel (delete) button element not present and object is:-" + btn_Cancel_delete.toString());
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

	public void delete_ScheduleWrittenTest_FromScheduleListGrid() throws Exception {
		if (icon_Delete.isDisplayed()) {

			String DeleteText = icon_Delete.getAttribute("title");
			System.out.println("Tool tip text present :- " + DeleteText);

			// Compare toll tip text
			Assert.assertEquals(DeleteText, "Delete");

			icon_Delete.click();
			log("Clicked on Delete Icon to delete Schedule from schedule list grid for written test and object is:-"
					+ icon_Delete.toString());
			Thread.sleep(1000);
		} else {
			log("Delete Icon element is not present in schedule list grid and object is:-" + icon_Delete.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithStudentName_InStudentList() throws Exception {

		if (sort_StudentName_StuList.isDisplayed()) {
			sort_StudentName_StuList.click();
			Thread.sleep(500);
			sort_StudentName_StuList.click();
			log("Sort by Student Name in Student list and object is:- " + sort_StudentName_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name button element not present and object is:- " + sort_StudentName_StuList.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithRegistrationNumber_InStudentList() throws Exception {

		if (sort_RegNo_StuList.isDisplayed()) {
			sort_RegNo_StuList.click();
			log("Sort by Registration Number in Student list and object is:- " + sort_RegNo_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration Number button element not present and object is:- " + sort_RegNo_StuList.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithGender_InStudentList() throws Exception {

		if (sort_Gender_StuList.isDisplayed()) {
			sort_Gender_StuList.click();
			log("Sort by Gender in Student list and object is:- " + sort_Gender_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Gender button element not present and object is:- " + sort_Gender_StuList.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithClass_InStudentList() throws Exception {

		if (sort_Class_StuList.isDisplayed()) {
			sort_Class_StuList.click();
			log("Sort by Class in Student list and object is:- " + sort_Class_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Class button element not present and object is:- " + sort_Class_StuList.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithScheduleName_InScheduleList() throws Exception {

		if (sort_ScheduleName_ScheduleList.isDisplayed()) {
			sort_ScheduleName_ScheduleList.click();
			log("Sort by Schedule Name in Schedule list and object is:- " + sort_ScheduleName_ScheduleList.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithScheduleDate_InScheduleList() throws Exception {

		if (sort_ScheduleDate_ScheduleList.isDisplayed()) {
			sort_ScheduleDate_ScheduleList.click();
			log("Sort by Schedule Date in Schedule list and object is:- " + sort_ScheduleDate_ScheduleList.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule Date button element not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_WrittenTestScheduleForm() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txt_PreAdm_writtenTestSchedulePage);
		if (btn_Min_Max_WRITTENTESTSCHEDULE.isDisplayed()) {
			btn_Min_Max_WRITTENTESTSCHEDULE.click();
			log("Written Test Schedule form section minimized or maximized and object is:-"
					+ btn_Min_Max_WRITTENTESTSCHEDULE.toString());
			Thread.sleep(1000);
		} else {
			log("Written Test Schedule form section Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_WRITTENTESTSCHEDULE.toString());
		}
	}

	public void min_Max_StudentList() throws Exception {
		if (btn_Min_Max_StudentList.isDisplayed()) {
			btn_Min_Max_StudentList.click();
			log("Student list section minimized or maximized and object is:-" + btn_Min_Max_StudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Student list section Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_StudentList.toString());
		}
	}

	public void min_Max_SelectedStudentToCart() throws Exception {
		if (btn_Min_Max_SELECTEDSTUDENTTOCART.isDisplayed()) {
			btn_Min_Max_SELECTEDSTUDENTTOCART.click();
			log("Selected student to cart section minimized or maximized and object is:-"
					+ btn_Min_Max_SELECTEDSTUDENTTOCART.toString());
			Thread.sleep(1000);
		} else {
			log("Selected student to cart section Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_SELECTEDSTUDENTTOCART.toString());
		}
	}

	public void min_Max_WrittenTestScheduleListGrid() throws Exception {
		if (btn_Min_Max_WRITTENTESTSCHEDULELISTGrid.isDisplayed()) {
			btn_Min_Max_WRITTENTESTSCHEDULELISTGrid.click();
			log("Written Test Schedule list grid section minimized or maximized and object is:-"
					+ btn_Min_Max_WRITTENTESTSCHEDULELISTGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Written Test Schedule list grid section Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_WRITTENTESTSCHEDULELISTGrid.toString());
		}
	}
}
