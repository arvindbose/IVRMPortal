/**
 * 
 */
package com.test.automation.uiAutomation.Admission.AttendanceEntry;

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

import com.test.automation.uiAutomation.testBase.TestBase;

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance Entry')]/following::li[1]")
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

	@FindBy(xpath = "//span[contains(text(),'Apr 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Apr 2018')]/following::td[2]/span")
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

	public Student_Attendance_Entry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(10000);
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
		if (btn_Admission.isDisplayed()) {
			btn_Admission.click();
			log("Clicked on admission Button and object is:-" + btn_Admission.toString());
			Thread.sleep(1000);
		} else {
			log("Admission button element not present.");
			Thread.sleep(500);
		}
		if (btnAdmission_AttendanceEntry.isDisplayed()) {
			btnAdmission_AttendanceEntry.click();
			log("Clicked on Attendance entry and object is:-" + btnAdmission_AttendanceEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance entry button element not present.");
			Thread.sleep(500);
		}
		if (btnAdmission_AttendanceEntry_StudentAttendanceEntry.isDisplayed()) {
			btnAdmission_AttendanceEntry_StudentAttendanceEntry.click();
			log("Clicked on Student Attendance entry Button and object is:-"
					+ btnAdmission_AttendanceEntry_StudentAttendanceEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Student Attendance entry button element not present.");
			Thread.sleep(500);
		}

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

		if (sel_AcademicYr.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr);
			log("Selected academic year: " + SelectedContent + " and object is:- " + sel_AcademicYr.toString());
			Thread.sleep(1000);
		} else {
			log("Academic year element is not present");
			Thread.sleep(500);
		}

		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Entry);
			log("selected Class for Entry: " + class_Entry + " and object is:- " + sel_Class.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Entry);
			Thread.sleep(1000);
		} else {
			log("Class element is not present.");
			Thread.sleep(500);
		}

	}

	public void fillwith_DailyOnce_EntryData(String academicYr, String class_Entry, String section) throws Exception {
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("selected Section for Entry: " + section + " and object is:- " + sel_Section.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present.");
			Thread.sleep(500);
		}
		if (btnCalendar_DateOfEntry.isDisplayed()) {
			btnCalendar_DateOfEntry.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_Date.click();
			log("Date Of Entry(DOE) is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Date Of Entry(DOE) Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	public void saveFilled_StudentAttendanceEntryForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit Student Attendance entry form and object is:-" + btn_Save.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void cancelFilled_StudentAttendanceEntryForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clicked on cancel button to clear filled student attendance entry form and object is:-"
					+ btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAttendanceEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtAdmission_StudentAttendanceEntryMsgDispaly);
		Thread.sleep(2000);
		if (btnMin_MaxAttendanceEntry.isDisplayed()) {
			btnMin_MaxAttendanceEntry.click();
			log("Attendance Entry page minimized and object is:-" + btnMin_MaxAttendanceEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Minimize Element not present.");
		}
	}

	public void maximizeAttendanceEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtAdmission_StudentAttendanceEntryMsgDispaly);
		Thread.sleep(2000);
		if (btnMin_MaxAttendanceEntry.isDisplayed()) {
			btnMin_MaxAttendanceEntry.click();
			log("Attendance Entry page maximized and object is:-" + btnMin_MaxAttendanceEntry.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Maximize Element not present.");
		}
	}

	public void minimize_DailyOnce() throws Exception {
		if (btnMin_MaxDailyOnce.isDisplayed()) {
			btnMin_MaxDailyOnce.click();
			log("clicked on Daily once page minimize button and object is:-" + btnMin_MaxDailyOnce.toString());
			Thread.sleep(1000);
		} else {
			log("Daily once page Minimize Element not present.");
		}
	}

	public void maximize_DailyOnce() throws Exception {
		if (btnMin_MaxDailyOnce.isDisplayed()) {
			btnMin_MaxDailyOnce.click();
			log("clicked on Daily once page maximize button and object is:-" + btnMin_MaxDailyOnce.toString());
			Thread.sleep(1000);
		} else {
			log("Daily once page Maximize Element not present.");
			Thread.sleep(500);
		}
	}

	public void minimize_StudentDetails() throws Exception {
		if (btnMin_MaxStudentDetails.isDisplayed()) {
			btnMin_MaxStudentDetails.click();
			log("clicked on Student Details page minimize button and object is:-"
					+ btnMin_MaxStudentDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Student Details page Minimize Element not present.");
		}
	}

	public void maximize_StudentDetails() throws Exception {
		if (btnMin_MaxStudentDetails.isDisplayed()) {
			btnMin_MaxStudentDetails.click();
			log("clicked on Student Details page maximize button and object is:-"
					+ btnMin_MaxStudentDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Student Details page Maximize Element not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithRegistrationNumberInThe_StudentDetailsListGrid(String registrationNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(registrationNum);
			log("Entered Registration Number to search: " + registrationNum + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String registration_Numb = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Registration Number: " + registration_Numb);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number available in the student details list.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudent_ForAttendanceEntry_FromStudentDetailsList(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String registration_Numb = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Registration Number: " + registration_Numb);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number available in the student details list.");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]/input"))
						.click();
				log("Student is selected for attendance corresponding to specific registration in the student details list.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOnOkSuccessButton() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button element is not present.");
			Thread.sleep(500);
		}
	}
	/**
	 * Daily Twice attendance entry
	 * 
	 * @param academicYr
	 * @param class_Entry
	 * @param section
	 * @throws Exception
	 */
	public void fillwith_DailyTwice_AttendanceEntryData(String academicYr, String class_Entry, String section) throws Exception {
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("selected Section for Entry: " + section + " and object is:- " + sel_Section.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present.");
			Thread.sleep(500);
		}
		if (btnCalendar_DateOfEntry.isDisplayed()) {
			btnCalendar_DateOfEntry.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_Date.click();
			log("Date Of Entry(DOE) is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Date Of Entry(DOE) Calendar button element not present.");
			Thread.sleep(500);
		}
	}
	public void searchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice(String registrationNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(registrationNum);
			log("Entered Registration Number to search: " + registrationNum + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String registration_Numb = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Registration Number: " + registration_Numb);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(registration_Numb, registrationNum);
				log("Student with specific registration Number available in the student details list.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice(String registrationNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String registration_Numb = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Registration Number: " + registration_Numb);
			// Thread.sleep(2000);
			try {

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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
