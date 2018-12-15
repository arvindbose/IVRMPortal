/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.AttendanceEntry;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
 *         Login with Staff login credentials UserName: Priya Password:
 *         Password@123
 *
 */
public class Student_Attendance_Entry extends TestBase {

	public static final Logger log = Logger.getLogger(Student_Attendance_Entry.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance Entry')]")
	WebElement btnAdmission_AttendanceEntry;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance
	// Entry')]/following::li[1]")
	// WebElement btnAdmission_AttendanceEntry_StudentAttendanceEntry;

	@FindBy(xpath = "//a[@href='#/app/attendanceentry/54']")
	WebElement btnAdmission_AttendanceEntry_StudentAttendanceEntry;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmission_StudentAttendanceEntryMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "(//label[contains(text(),'DOE:')]/following::div//button)[1]")
	WebElement btnCalendar_DateOfEntry;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[17]/span")
	WebElement btn_Date;

	@FindBy(xpath = "//span[@class='input-group-addon']/following-sibling::input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxAttendanceEntry;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxDailyOnce;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxStudentDetails;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	@FindBy(xpath = "//label[contains(text(),' Attendance Entry Type Is Absent')]")
	WebElement msg_Validation_FilledForm;

	// h3[contains(text(),'Daily Once')]

	public Student_Attendance_Entry(WebDriver driver) {
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
	 * Navigate to Attendance entry > Student attendance entry
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_AttendanceEntry);
		log("Clicked on Attendance entry and object is:-" + btnAdmission_AttendanceEntry.toString());

		clickOnButton(btnAdmission_AttendanceEntry_StudentAttendanceEntry);
		log("Clicked on Student Attendance entry Button and object is:-"
				+ btnAdmission_AttendanceEntry_StudentAttendanceEntry.toString());
	}

	/**
	 * Validation of Attendance entry > Student attendance entry screen message
	 * 
	 * @return
	 */
	public boolean verifyAttendanceEntry_StudentAttendanceEntry_BGHSPage() {
		try {
			System.out.println(txtAdmission_StudentAttendanceEntryMsgDispaly.getText());
			txtAdmission_StudentAttendanceEntryMsgDispaly.isDisplayed();
			log("Student Attendance Entry page is dispalyed and object is:-"
					+ txtAdmission_StudentAttendanceEntryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fillWith_AttendanceEntry_Data(String academicYr, String class_Entry, String section) throws Exception {

		selectedDropdownItemValidation(sel_AcademicYr, academicYr);
		log("Selected academic year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());
		Thread.sleep(1000);
		selectElementFromDropDown(sel_Class, class_Entry);
		log("selected Class for Entry: " + class_Entry + " and object is:- " + sel_Class.toString());

	}

	public void fillwith_DailyOnce_EntryData(String academicYr, String class_Entry, String section) throws Exception {

		selectElementFromDropDown(sel_Section, section);
		log("selected Section for Entry: " + section + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendar_DateOfEntry);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_Date.click();
		log("Date Of Entry(DOE) is selected from calender.");

	}

	public void saveFilled_StudentAttendanceEntryForm() throws Exception {

		clickOnButton(btn_Save);
		Thread.sleep(2000);
		Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Submit Student Attendance entry form and object is:-" + btn_Save.toString());

	}

	public void cancelFilled_StudentAttendanceEntryForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("Clicked on cancel button to clear filled student attendance entry form and object is:-"
				+ btn_Cancel.toString());

	}

	public void minimizeAttendanceEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmission_StudentAttendanceEntryMsgDispaly);
		Thread.sleep(2000);

		clickOnButton(btnMin_MaxAttendanceEntry);
		log("Attendance Entry page minimized and object is:-" + btnMin_MaxAttendanceEntry.toString());

	}

	public void maximizeAttendanceEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmission_StudentAttendanceEntryMsgDispaly);
		Thread.sleep(2000);

		clickOnButton(btnMin_MaxAttendanceEntry);
		log("Attendance Entry page maximized and object is:-" + btnMin_MaxAttendanceEntry.toString());

	}

	public void minimize_DailyOnce() throws Exception {

		clickOnButton(btnMin_MaxDailyOnce);
		log("clicked on Daily once page minimize button and object is:-" + btnMin_MaxDailyOnce.toString());

	}

	public void maximize_DailyOnce() throws Exception {

		clickOnButton(btnMin_MaxDailyOnce);
		log("clicked on Daily once page maximize button and object is:-" + btnMin_MaxDailyOnce.toString());

	}

	public void minimize_StudentDetails() throws Exception {

		clickOnButton(btnMin_MaxStudentDetails);
		log("clicked on Student Details page minimize button and object is:-" + btnMin_MaxStudentDetails.toString());

	}

	public void maximize_StudentDetails() throws Exception {

		clickOnButton(btnMin_MaxStudentDetails);
		log("clicked on Student Details page maximize button and object is:-" + btnMin_MaxStudentDetails.toString());

	}

	public void searchWithRegistrationNumberInThe_StudentDetailsListGrid(String registrationNum) throws Exception {

		inputTextIntoInputField(input_Search, registrationNum);
		log("Entered Registration Number to search: " + registrationNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String registration_Numb = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Registration Number: " + registration_Numb);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (registration_Numb.equals(registrationNum)) {
					Assert.assertEquals(registration_Numb, registrationNum);
					log("Student with specific registration Number available in the student details list.");
					break;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudent_ForAttendanceEntry_FromStudentDetailsList(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String registration_Numb = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Registration Number: " + registration_Numb);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if(registration_Numb.equals(registrationNum)){
				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number available in the student details list.");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]/input"))
						.click();
				log("Student is selected for attendance corresponding to specific registration in the student details list.");
				Thread.sleep(1000);
				break;
				}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(3000);

	}

	/**
	 * Daily Twice attendance entry
	 * 
	 * @param academicYr
	 * @param class_Entry
	 * @param section
	 * @throws Exception
	 */
	public void fillwith_DailyTwice_AttendanceEntryData(String academicYr, String class_Entry, String section)
			throws Exception {

		selectElementFromDropDown(sel_Section, section);
		log("selected Section for Entry: " + section + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendar_DateOfEntry);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_Date.click();
		log("Date Of Entry(DOE) is selected from calender.");

	}

	public void searchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice(String registrationNum)
			throws Exception {

		inputTextIntoInputField(input_Search, registrationNum);
		log("Entered Registration Number to search: " + registrationNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
				String registration_Numb = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Registration Number: " + registration_Numb);
				// Thread.sleep(2000);
				if(registration_Numb.equals(registrationNum)){
				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number "+registrationNum+ "available in the student details list.");
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
				String registration_Numb = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Registration Number: " + registration_Numb);
				// Thread.sleep(2000);
				if(registration_Numb.equals(registrationNum)){
				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number available in the student details list.");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[7]/input"))
						.click();
				log("Ckeck box is checked for 1st half");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[8]/input"))
						.click();
				log("Ckeck box is checked for 2nd half");
				Thread.sleep(1000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validation_MessageForMarksEntry() throws Exception {
		try {
			msg_Validation_FilledForm.isDisplayed();
			String validation = msg_Validation_FilledForm.getText().trim();
			assertEquals(validation, "Attendance Entry Type Is Absent");
			log("Validation message not present on attendance entry page and object is:-"
					+ msg_Validation_FilledForm.toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully!");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
