/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule;

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

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]/following::ul[1]/li[1]")
	private WebElement btnInterview_Schedule;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview Schedule')][1]/following::li[1]")
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

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[27]")
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

	@FindBy(xpath = "(//table/thead)[1]/tr/th[3]/a")
	private WebElement sort_RegNo_StuList;

	@FindBy(xpath = "(//table/thead)[1]/tr/th[4]/a")
	private WebElement sort_Gender_StuList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleName_ScheduleList;

	@FindBy(xpath = "(//table/thead)[4]/tr/th[2]/a")
	private WebElement sort_ScheduleDate_ScheduleList;

	public InterviewSchedule_OralTest_Schedule_AutoSelect12Hr(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void navigateToOralTestSchedule_BGHS() {
		if (btnPre_Admission.isDisplayed()) {
			btnPre_Admission.click();
			log("Clicked on pre admission button and object is:-" + btnPre_Admission.toString());
			waitForElement(driver, 10, btnInterview_Schedule);
		} else {
			log("Navigation menu pre admission button element not present.");
		}
		if (btnInterview_Schedule.isDisplayed()) {
			btnInterview_Schedule.click();
			log("Clicked on interview schedule button and object is:-" + btnInterview_Schedule.toString());
			waitForElement(driver, 10, btnOral_Test);
		} else {
			log("Navigation sub-menu Interview schedule button element not present.");
		}
		if (btnOral_Test.isDisplayed()) {
			btnOral_Test.click();
			log("Clicked on oral test schedule button and object is:-" + btnOral_Test.toString());
			waitForElement(driver, 10, txtPreAdm_BGHSIntrvMsgDispaly);
		} else {
			log("Navigation sub-menu Oral Test Schedule button element not present.");
		}
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
		if (inputScheduleName.isDisplayed()) {
			inputScheduleName.clear();
			inputScheduleName.sendKeys(scheduleName);
			log("Entered schedule name " + scheduleName + " and object is:-" + inputScheduleName.toString());
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
		if (inputRemarks.isDisplayed()) {
			inputRemarks.clear();
			inputRemarks.sendKeys(remarks);
			log("Entered remarks " + remarks + " and object is:-" + inputRemarks.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks field element not present.");
			Thread.sleep(500);
		}
		if (inputSupervisor.isDisplayed()) {
			inputSupervisor.clear();
			inputSupervisor.sendKeys(supervisor);
			log("Entered supervisor " + supervisor + " and object is:-" + inputSupervisor.toString());
			Thread.sleep(1000);
		} else {
			log("Supervisor field element not present.");
			Thread.sleep(500);
		}
		if (inputSkills.isDisplayed()) {
			inputSkills.clear();
			inputSkills.sendKeys(skill);
			log("Entered skill " + skill + " and object is:-" + inputSkills.toString());
			Thread.sleep(1000);
		} else {
			log("Skills field element not present.");
			Thread.sleep(500);
		}
		if (!rdBtn12Hr.isSelected()) {
			rdBtn12Hr.click();
			log("12 Hours format radio button is selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		} else {
			log("12 hours time format radio button is already selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		}
		if (inputScheduleTime_FromHr.isDisplayed()) {
			inputScheduleTime_FromHr.clear();
			inputScheduleTime_FromHr.sendKeys(FromSchTimeHr);
			log("Entered From schedule time hour(From) " + FromSchTimeHr + " and object is:-"
					+ inputScheduleTime_FromHr.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time hour(From) field element not present.");
			Thread.sleep(500);
		}
		if (inputScheduleTime_FromMin.isDisplayed()) {
			inputScheduleTime_FromMin.clear();
			inputScheduleTime_FromMin.sendKeys(FromSchTimeMin);
			log("Entered From schedule time minute(From) " + FromSchTimeMin + " and object is:-"
					+ inputScheduleTime_FromMin.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time minute(From) field element not present.");
			Thread.sleep(500);
		}
		if (inputScheduleTime_ToHr.isDisplayed()) {
			inputScheduleTime_ToHr.clear();
			inputScheduleTime_ToHr.sendKeys(ToSchTimeHr);
			log("Entered To schedule time hour(To) " + ToSchTimeHr + " and object is:-"
					+ inputScheduleTime_ToHr.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time hour(To) field element not present.");
			Thread.sleep(500);
		}
		if (inputScheduleTime_ToMin.isDisplayed()) {
			inputScheduleTime_ToMin.clear();
			inputScheduleTime_ToMin.sendKeys(ToSchTimeMin);
			log("Entered To schedule time minute " + ToSchTimeMin + " and object is:-"
					+ inputScheduleTime_ToMin.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule time minute(To) field element not present.");
			Thread.sleep(500);
		}
		if (btnTo_AM_PM.isDisplayed()) {
			btnTo_AM_PM.click();
			log("PM is selected and object is:-" + btnTo_AM_PM.toString());
			Thread.sleep(1000);
		} else {
			log("AM/PM button element not present.");
			Thread.sleep(500);
		}
		if (!chkAutoSelStudent.isSelected()) {
			chkAutoSelStudent.click();
			log("Auto select student check box is selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Auto select student check box is already selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		}
		if (inputMinute.isDisplayed()) {
			inputMinute.clear();
			inputMinute.sendKeys(minutes);
			log("Entered time in minute for each student " + minutes + " and object is:-" + inputMinute.toString());
			Thread.sleep(1000);
		} else {
			log("Time in minutes field element not present.");
			Thread.sleep(500);
		}
		if (inputNoOfStudent.isDisplayed()) {
			inputNoOfStudent.clear();
			inputNoOfStudent.sendKeys(nosOfStudents);
			log("Entered total number of student for oral test " + nosOfStudents + " and object is:-"
					+ inputNoOfStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Number of student field element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnResetButton_ToClearFilledData() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtPreAdm_BGHSIntrvMsgDispaly);
		Thread.sleep(1000);
		if (btnReset.isDisplayed()) {
			btnReset.click();
			log("Reset button is clicked to reset enterd value for oral interview schedule and object is:-"
					+ btnReset.toString());
			Thread.sleep(1000);
		} else {
			log("Reset button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton() throws Exception {
		if (btnSave.isDisplayed()) {
			btnSave.click();
			log("Save button is clicked to save the oral test schedule and object is:-" + btnSave.toString());
			waitForElement(driver, 20, btnOKSuccess);
			Thread.sleep(3000);
		} else {
			log("Save button element not present.");
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

	public void validationOf12HourTimeFormatScheduleList() throws Exception {

		inputSearch_SchList.clear();
		Thread.sleep(1000);
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

	}

	public void searchWithScheduleNameInScheduleList(String scheduleName) throws Exception {
		if (inputSearch_SchList.isDisplayed()) {
			inputSearch_SchList.clear();
			inputSearch_SchList.sendKeys(scheduleName);
			log("Entered schedule name " + scheduleName + " and object is:-" + inputSearch_SchList.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present in schedule list");
			Thread.sleep(500);
		}
	}

	public void validateSelectedStuFromStuList_withSelectedStuToCart() throws Exception {
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

	}

	public void verifyscheduleNameInOralTestScheduleListGrid(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String SchName = driver
					.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
					.getText().trim();
			System.out.println("schedule Name: " + SchName);
			Thread.sleep(2000);
			if (SchName.equalsIgnoreCase(scheduleName)) {
				try {
					Assert.assertEquals(SchName, scheduleName);
					log("Schedule name matched with the schedule list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			} else {
				log("Schedule name not matched with the schedule list");
			}
		}
	}

	public void deleteScheduledOralTest(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String SchName = driver
					.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("schedule Name: " + SchName);
			Thread.sleep(2000);
			if (SchName.equalsIgnoreCase(scheduleName)) {
				try {
					Assert.assertEquals(SchName, scheduleName);

					driver.findElement(
							By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[6]/span/a"))
							.click();
					log("Clicked on the delete link in the schedule list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			} else {
				log("Schedule name not matched with the schedule list");
			}
		}
	}

	public void cancellationOfDelete() throws Exception {
		if (btnDeleteCancel.isDisplayed()) {
		btnDeleteCancel.click();
		log("Delete cancel and object is:-" + btnDeleteCancel.toString());
		Thread.sleep(2000);
		} else {
			log("Delete button Element not present in Schedule list pop up window.");
			Thread.sleep(500);
		}
	}

	public void yesDeleteItButtonClick() throws Exception {
		if (btnYesDeleteIt.isDisplayed()) {
		btnYesDeleteIt.click();
		log("Yes Delete It button clicked and object is:-" + btnYesDeleteIt.toString());
		waitForElement(driver, 20, btnOKSuccess);
		Thread.sleep(5000);
		} else {
			log("Yes Delete it button Element not present in Schedule list pop up window.");
			Thread.sleep(500);
		}
	}

	public void min_Max_OralTestSchedule() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtPreAdm_BGHSIntrvMsgDispaly);
		Thread.sleep(1000);
		if (btn_Min_MaxOralTestSchedule.isDisplayed()) {
			btn_Min_MaxOralTestSchedule.click();
			log("Oral Test Schedule part minimized or maximized and object is:-"
					+ btn_Min_MaxOralTestSchedule.toString());
			Thread.sleep(1000);
		} else {
			log("Oral Test Schedule Minimized OR Maximize Element not present.");
		}
	}

	public void min_Max_StudentList() throws Exception {
		if (btn_Min_MaxStudentList.isDisplayed()) {
			btn_Min_MaxStudentList.click();
			log("Student List page minimized or maximized and object is:-" + btn_Min_MaxStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Student List Minimize OR Maximize Element not present.");
		}
	}

	public void min_Max_SelectedStudentToCart() throws Exception {
		if (btn_Min_MaxSelectedStudentToCart.isDisplayed()) {
			btn_Min_MaxSelectedStudentToCart.click();
			log("Selected Student to cart part minimized or maximized and object is:-"
					+ btn_Min_MaxSelectedStudentToCart.toString());
			Thread.sleep(1000);
		} else {
			log("Selected Student to cart Minimize OR Maximize Element not present.");
		}
	}

	public void min_Max_OralTestScheduleList_GridView() throws Exception {
		if (btn_Min_MaxOralTestScheduleList.isDisplayed()) {
			btn_Min_MaxOralTestScheduleList.click();
			log("Oral Test Schedule List part minimized or maximized and object is:-"
					+ btn_Min_MaxOralTestScheduleList.toString());
			Thread.sleep(1000);
		} else {
			log("Oral Test Schedule List Minimize OR Maximize Element not present.");
		}
	}

	public void sortWithStudentNameInStudentList() throws Exception {

		if (sort_StudentName_StuList.isDisplayed()) {
			sort_StudentName_StuList.click();
			Thread.sleep(500);
			sort_StudentName_StuList.click();
			log("Sort by Student Name in Student list and object is:- " + sort_StudentName_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithRegistrationNumberInStudentList() throws Exception {

		if (sort_RegNo_StuList.isDisplayed()) {
			sort_RegNo_StuList.click();
			log("Sort by Registration Number in Student list and object is:- " + sort_RegNo_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration Number button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithGenderInStudentList() throws Exception {

		if (sort_Gender_StuList.isDisplayed()) {
			sort_Gender_StuList.click();
			log("Sort by Gender in Student list and object is:- " + sort_Gender_StuList.toString());
			Thread.sleep(1000);
		} else {
			log("Gender button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithScheduleNameInScheduleList() throws Exception {

		if (sort_ScheduleName_ScheduleList.isDisplayed()) {
			sort_ScheduleName_ScheduleList.click();
			log("Sort by Schedule Name in Schedule list and object is:- " + sort_ScheduleName_ScheduleList.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithScheduleDateInScheduleList() throws Exception {

		if (sort_ScheduleDate_ScheduleList.isDisplayed()) {
			sort_ScheduleDate_ScheduleList.click();
			log("Sort by Schedule Date in Schedule list and object is:- " + sort_ScheduleDate_ScheduleList.toString());
			Thread.sleep(1000);
		} else {
			log("Schedule Date button element not present.");
			Thread.sleep(500);
		}
	}

}
