/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class InterviewSchedule_OralTest_Schedule_AutoSelect12Hr extends TestBase {

	public static final Logger log = Logger
			.getLogger(InterviewSchedule_OralTest_Schedule_AutoSelect12Hr.class.getName());

	WebDriver driver;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btnPre_Admission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview Schedule')][1]")
	private WebElement btnInterview_Schedule;

	// @FindBy(xpath =
	// "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview
	// Schedule')][1]/following::li[1]")
	// private WebElement btnOral_Test;

	@FindBy(xpath = "//a[@href='#/app/oschedule/14']")
	private WebElement btnOral_Test;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txtPreAdm_BGHSIntrvMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Schedule Name :')]/following-sibling::div/input")
	private WebElement inputScheduleName;

	@FindBy(xpath = "//label[contains(text(),'Remarks:')]/following-sibling::div/input")
	private WebElement inputRemarks;

	@FindBy(xpath = "//label[contains(text(),'Supervisor : ')]/following-sibling::div/input")
	private WebElement inputSupervisor;

	@FindBy(xpath = "//label[contains(text(),'Skill/Knowledge :')]/following-sibling::div/textarea")
	private WebElement inputSkills;

	// @FindBy(xpath = "//input[@class='md-datepicker-input']")
	// private WebElement inputOraltestDate;

	@FindBy(xpath = "(//label[contains(text(),'Schedule Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_Calender;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]/following::td[29]")
	private WebElement btn_ScheduleDate;

	// Date modification required

	@FindBy(xpath = "//input[@name='12hur']")
	private WebElement rdBtn12Hr;

	@FindBy(xpath = "//input[@name='24Hur']")
	private WebElement rdBtn24Hr;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[1]/input")
	private WebElement inputScheduleTime_FromHr;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[3]/input")
	private WebElement inputScheduleTime_FromMin;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[6]/button")
	private WebElement btnFrom_AM_PM;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[1]/input")
	private WebElement inputScheduleTime_ToHr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[3]/input")
	private WebElement inputScheduleTime_ToMin;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[6]/button")
	private WebElement btnTo_AM_PM;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[2]/tbody/tr[2]/td[1]")
	private WebElement inputScheduleTime_FromHr24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[2]/tbody/tr[2]/td[3]")
	private WebElement inputScheduleTime_FromMin24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[4]/tbody/tr[2]/td[1]")
	private WebElement inputScheduleTime_ToHr24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[4]/tbody/tr[2]/td[3]")
	private WebElement inputScheduleTime_ToMin24Hr;

	@FindBy(xpath = "//input[@name='autostudent']")
	private WebElement chkAutoSelStudent;

	@FindBy(xpath = "//input[@name='Min']")
	private WebElement inputMinute;

	@FindBy(xpath = "//input[@name='nofstud']")
	private WebElement inputNoOfStudent;

	@FindBy(xpath = "//input[@name='12hurrt']")
	private WebElement rdBtnScheduleList12Hr;

	@FindBy(xpath = "//input[@name='24Hurrt']")
	private WebElement rdBtnScheduleList24Hr;

	@FindBy(xpath = "(//div[@class='box box-primary']//table)[5]/tbody/tr")
	private List<WebElement> tblRowsStudentList;

	@FindBy(xpath = "(//div[@class='box box-primary']//table)[6]/tbody/tr")
	private List<WebElement> tblRowsScheduleList;

	@FindBy(xpath = "//body[@id='style-4']//form/div[1]/div[1]/div/button[1]")
	private WebElement btnReset;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_MaxOralTestSchedule;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_MaxStudentList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_MaxSelectedStudentToCart;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	private WebElement btn_Min_MaxOralTestScheduleList;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	private WebElement inputSearch_SchList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	private WebElement btnDeleteCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnYesDeleteIt;

	@FindBy(xpath = "(//div[@class='box box-primary']//table)[6]/thead/tr/th[2]/a")
	private WebElement btnSortSchName;

	@FindBy(xpath = "(//table/tbody)[5]/tr[1]/td[7]/input")
	private WebElement chk_StudentList;

	@FindBy(xpath = "(//table/tbody)[5]/tr[1]/td[2]")
	private WebElement StudentFirstName_StuList;

	@FindBy(xpath = "(//table/tbody)[6]/tr[1]/td[2]")
	private WebElement StudentFirstName_CartStudent;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[2]/a")
	private WebElement sort_StudentName_StuList;

	@FindBy(xpath = "(//table/tbody)[9]/tr/td[2]")
	private List<WebElement> list_StudentName_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[3]/a")
	private WebElement sort_RegNo_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[4]/a")
	private WebElement sort_Gender_StuList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleName_ScheduleList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleDate_ScheduleList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public InterviewSchedule_OralTest_Schedule_AutoSelect12Hr(WebDriver driver) {
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

	public void navigateToOralTestSchedule_BGHS() {

		clickOnButton(btnPre_Admission);
		log("Clicked on pre admission button and object is:-" + btnPre_Admission.toString());

		clickOnButton(btnInterview_Schedule);
		log("Clicked on interview schedule button and object is:-" + btnInterview_Schedule.toString());

		clickOnButton(btnOral_Test);
		log("Clicked on oral test schedule button and object is:-" + btnOral_Test.toString());

	}

	public boolean verifyInterviewSchedule_BGHSPage() {
		try {
			System.out.println(txtPreAdm_BGHSIntrvMsgDispaly.getText());
			txtPreAdm_BGHSIntrvMsgDispaly.isDisplayed();
			log("Interview schedule page is dispalyed and object is:-" + txtPreAdm_BGHSIntrvMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void oralTestScheduleInfo(String scheduleName, String scheduleDate, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String minutes, String nosOfStudents) throws Exception {

		inputTextIntoInputField(inputScheduleName, scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + inputScheduleName.toString());

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

		inputTextIntoInputField(inputRemarks, remarks);
		log("Entered remarks " + remarks + " and object is:-" + inputRemarks.toString());

		inputTextIntoInputField(inputSupervisor, supervisor);
		log("Entered supervisor " + supervisor + " and object is:-" + inputSupervisor.toString());

		inputTextIntoInputField(inputSkills, skill);
		log("Entered skill " + skill + " and object is:-" + inputSkills.toString());
		isDisplayed(rdBtn12Hr);
		if (!rdBtn12Hr.isSelected()) {
			rdBtn12Hr.click();
			log("12 Hours format radio button is selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		} else {
			log("12 hours time format radio button is already selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		}

		inputTextIntoInputField(inputScheduleTime_FromHr, FromSchTimeHr);
		log("Entered From schedule time hour(From) " + FromSchTimeHr + " and object is:-"
				+ inputScheduleTime_FromHr.toString());

		inputTextIntoInputField(inputScheduleTime_FromMin, FromSchTimeMin);
		log("Entered From schedule time minute(From) " + FromSchTimeMin + " and object is:-"
				+ inputScheduleTime_FromMin.toString());

		inputTextIntoInputField(inputScheduleTime_ToHr, ToSchTimeHr);
		log("Entered To schedule time hour(To) " + ToSchTimeHr + " and object is:-"
				+ inputScheduleTime_ToHr.toString());

		inputTextIntoInputField(inputScheduleTime_ToMin, ToSchTimeMin);
		log("Entered To schedule time minute " + ToSchTimeMin + " and object is:-"
				+ inputScheduleTime_ToMin.toString());

		clickOnButton(btnTo_AM_PM);
		log("PM is selected and object is:-" + btnTo_AM_PM.toString());
		isDisplayed(chkAutoSelStudent);
		if (!chkAutoSelStudent.isSelected()) {
			chkAutoSelStudent.click();
			log("Auto select student check box is selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Auto select student check box is already selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		}

		inputTextIntoInputField(inputMinute, minutes);
		log("Entered time in minute for each student " + minutes + " and object is:-" + inputMinute.toString());
		Thread.sleep(1000);

		inputTextIntoInputField(inputNoOfStudent, nosOfStudents);
		log("Entered total number of student for oral test " + nosOfStudents + " and object is:-"
				+ inputNoOfStudent.toString());

	}

	public void clickOnResetButton_ToClearFilledData() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtPreAdm_BGHSIntrvMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btnReset);
		log("Reset button is clicked to reset enterd value for oral interview schedule and object is:-"
				+ btnReset.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("Save button is clicked to save the oral test schedule and object is:-" + btnSave.toString());
		waitForElement(driver, 20, btnOKSuccess);

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

	public void validationOf12HourTimeFormatScheduleList() throws Exception {

		inputSearch_SchList.clear();
		Thread.sleep(1000);
		isDisplayed(rdBtnScheduleList12Hr);
		if (!rdBtnScheduleList12Hr.isSelected()) {

			rdBtnScheduleList12Hr.click();
			log("12 Hour time format radio button is selected for oral test schedule list and object is:-"
					+ rdBtnScheduleList12Hr.toString());
			Thread.sleep(2000);
		} else {
			log("12 hour time format radio button is already selected and object is:-"
					+ rdBtnScheduleList12Hr.toString());
			Thread.sleep(1000);
		}

	}

	public void validationOf24HourTimeFormatScheduleList() throws Exception {

		inputSearch_SchList.clear();
		Thread.sleep(1000);
		isDisplayed(rdBtnScheduleList24Hr);
		try {
			if (!rdBtnScheduleList24Hr.isSelected()) {

				rdBtnScheduleList24Hr.click();
				log("24 Hour time format radio button is selected for oral test schedule list and object is:-"
						+ rdBtnScheduleList24Hr.toString());
				Thread.sleep(2000);
			} else {
				log("24 hour time format radio button is already selected and object is:-"
						+ rdBtnScheduleList24Hr.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchWithScheduleNameInScheduleList(String scheduleName) throws Exception {

		inputTextIntoInputField(inputSearch_SchList, scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + inputSearch_SchList.toString());

	}

	public void validateSelectedStuFromStuList_withSelectedStuToCart() throws Exception {
		isDisplayed(chk_StudentList);
		try {
			if (chk_StudentList.isSelected()) {
				String firstNameStulist = StudentFirstName_StuList.getText().trim();
				log("Student selected for oral test and object is:-" + chk_StudentList.toString());
				Thread.sleep(1000);
				String firstNameCartStu = StudentFirstName_CartStudent.getText().trim();
				log("First name of the student from selected student to cart.");

				Assert.assertEquals(firstNameStulist, firstNameCartStu);
				log("Student from Student list and selected student to cart is same.");
				Thread.sleep(1000);
			} else {
				log("Student not selected for oral test.");
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyscheduleNameInOralTestScheduleListGrid(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String SchName = driver
						.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("schedule Name: " + SchName);
				Thread.sleep(2000);
				if (SchName.equalsIgnoreCase(scheduleName)) {

					Assert.assertEquals(SchName, scheduleName);
					log("Schedule name matched with the schedule list grid");
					Thread.sleep(3000);

					break;

				} else {
					log("Schedule name not matched with the schedule list");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteScheduledOralTest(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String SchName = driver
						.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("schedule Name: " + SchName);
				Thread.sleep(2000);
				if (SchName.equalsIgnoreCase(scheduleName)) {

					Assert.assertEquals(SchName, scheduleName);

					driver.findElement(
							By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[6]/span/a"))
							.click();
					log("Clicked on the delete link in the schedule list grid");
					Thread.sleep(3000);

					break;

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancellationOfDelete() throws Exception {

		clickOnButton(btnDeleteCancel);
		log("Delete cancel and object is:-" + btnDeleteCancel.toString());

	}

	public void yesDeleteItButtonClick() throws Exception {

		clickOnButton(btnYesDeleteIt);
		log("Yes Delete It button clicked and object is:-" + btnYesDeleteIt.toString());
		Thread.sleep(1000);
	}

	public void min_Max_OralTestSchedule() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtPreAdm_BGHSIntrvMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btn_Min_MaxOralTestSchedule);
		log("Oral Test Schedule part minimized or maximized and object is:-" + btn_Min_MaxOralTestSchedule.toString());

	}

	public void min_Max_StudentList() throws Exception {

		clickOnButton(btn_Min_MaxStudentList);
		log("Student List page minimized or maximized and object is:-" + btn_Min_MaxStudentList.toString());

	}

	public void min_Max_SelectedStudentToCart() throws Exception {

		clickOnButton(btn_Min_MaxSelectedStudentToCart);
		log("Selected Student to cart part minimized or maximized and object is:-"
				+ btn_Min_MaxSelectedStudentToCart.toString());

	}

	public void min_Max_OralTestScheduleList_GridView() throws Exception {

		clickOnButton(btn_Min_MaxOralTestScheduleList);
		log("Oral Test Schedule List part minimized or maximized and object is:-"
				+ btn_Min_MaxOralTestScheduleList.toString());

	}

	public void sortWithStudentNameInStudentList() throws Exception {

		clickOnButton(sort_StudentName_StuList);
		clickOnButton(sort_StudentName_StuList);
		log("Clicked on Student Name Header and object is:- " + sort_StudentName_StuList.toString());
		SortData_InColumn_DescendingOrder(list_StudentName_StuList);
		log("Sort by Student Name in Student list and object is:- " + list_StudentName_StuList.toString());

	}

	public void sortWithRegistrationNumberInStudentList() throws Exception {

		clickOnButton(sort_RegNo_StuList);
		log("Sort by Registration Number in Student list and object is:- " + sort_RegNo_StuList.toString());

	}

	public void sortWithGenderInStudentList() throws Exception {

		clickOnButton(sort_Gender_StuList);
		log("Sort by Gender in Student list and object is:- " + sort_Gender_StuList.toString());

	}

	public void sortWithScheduleNameInScheduleList() throws Exception {

		clickOnButton(sort_ScheduleName_ScheduleList);
		log("Sort by Schedule Name in Schedule list and object is:- " + sort_ScheduleName_ScheduleList.toString());

	}

	public void sortWithScheduleDateInScheduleList() throws Exception {

		clickOnButton(sort_ScheduleDate_ScheduleList);
		log("Sort by Schedule Date in Schedule list and object is:- " + sort_ScheduleDate_ScheduleList.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Interview Scheduled Successfully");
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
			assertEquals(text, "Record Deleted successfully");
			log("Record Deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
