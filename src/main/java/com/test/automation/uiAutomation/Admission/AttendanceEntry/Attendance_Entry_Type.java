/**
 * 
 */
package com.test.automation.uiAutomation.Admission.AttendanceEntry;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Attendance_Entry_Type extends TestBase {

	public static final Logger log = Logger.getLogger(Attendance_Entry_Type.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance Entry')]")
	WebElement btnAdmission_AttendanceEntry;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance Entry')]/following::li[2]")
	WebElement btnAdmission_AttendanceEntry_Type;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmission_AttendanceEntrytypeMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/input")
	WebElement input_Search_Class;

	@FindBy(xpath = "//span[contains(text(),' LKG  ')]/preceding-sibling::input")
	WebElement chk_Class;

	@FindBy(xpath = "//span[contains(text(),'Daily Once')]/preceding-sibling::input")
	WebElement rdBtn_Dailyonce;

	@FindBy(xpath = "//span[contains(text(),'Daily Twice')]/preceding-sibling::input")
	WebElement rdBtn_DailyTwice;

	@FindBy(xpath = "//span[contains(text(),'Monthly')]/preceding-sibling::input")
	WebElement rdBtn_Monthly;

	@FindBy(xpath = "//span[contains(text(),'Subject Wise')]/preceding-sibling::input")
	WebElement rdBtn_SubjectWise;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btn_Clear;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxAttendanceEntryType;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxAttendanceEntryTypeList;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search_ClassInGrid;

	public Attendance_Entry_Type(WebDriver driver) {
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
	 * Navigate to Attendance entry > attendance entry type
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS() throws Exception {
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
		if (btnAdmission_AttendanceEntry_Type.isDisplayed()) {
			btnAdmission_AttendanceEntry_Type.click();
			log("Clicked on Attendance entry type Button and object is:-"
					+ btnAdmission_AttendanceEntry_Type.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance entry type button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Attendance entry > attendance entry type screen message
	 * 
	 * @return
	 */
	public boolean verifyAttendanceEntry_AttendanceEntryType_BGHSPage() {
		try {
			System.out.println(txtAdmission_AttendanceEntrytypeMsgDispaly.getText());
			txtAdmission_AttendanceEntrytypeMsgDispaly.isDisplayed();
			log("Attendance entry type page is dispalyed and object is:-"
					+ txtAdmission_AttendanceEntrytypeMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankAttendanceEntryTypeForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Attendance entry type form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillAttendanceEntryTypeForm(String academicYear, String class_Search) throws Exception {
		if (sel_AcademicYr.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYear);
			log("Selected academic year: " + SelectedContent + " and object is:- " + sel_AcademicYr.toString());
			Thread.sleep(1000);
		} else {
			log("Academic year element is not present");
			Thread.sleep(500);
		}

		if (input_Search_Class.isDisplayed()) {
			input_Search_Class.clear();
			input_Search_Class.sendKeys(class_Search);
			log("Entered student admission number to search: " + class_Search + " and object is:-"
					+ input_Search_Class.toString());
			Thread.sleep(2000);
		} else {
			log("Class Search Element not present.");
			Thread.sleep(500);
		}
		if(!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class is selected for attendance entry type and object is:-" + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class is already selected for attendance entry type.");
			Thread.sleep(500);
		}
	}

	public void select_DailyOnce_RadioButton() throws Exception {
		if(!rdBtn_Dailyonce.isSelected()) {
			rdBtn_Dailyonce.click();
			log("Daily Once attendance entry type is selected and object is:-" + rdBtn_Dailyonce.toString());
			Thread.sleep(1000);
		} else {
			log("Daily Once attendance entry type is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DailyTwice_RadioButton() throws Exception {
		if(!rdBtn_DailyTwice.isSelected()) {
			rdBtn_DailyTwice.click();
			log("Daily Twice attendance entry type is selected and object is:-" + rdBtn_DailyTwice.toString());
			Thread.sleep(1000);
		} else {
			log("Daily Twice attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void select_Monthly_RadioButton() throws Exception {
		if(!rdBtn_Monthly.isSelected()) {
			rdBtn_Monthly.click();
			log("Monthly attendance entry type is selected and object is:-" + rdBtn_Monthly.toString());
			Thread.sleep(1000);
		} else {
			log("Monthly attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void select_SubjectWise_RadioButton() throws Exception {
		if(!rdBtn_SubjectWise.isSelected()) {
			rdBtn_SubjectWise.click();
			log("SubjectWise attendance entry type is selected and object is:-" + rdBtn_SubjectWise.toString());
			Thread.sleep(1000);
		} else {
			log("SubjectWise attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void clearFilledAttendanceEntryTypeForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Clicked on clear button to clear filled attendance entry type form and object is:-"
					+ btn_Clear.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void saveFilledAttendanceEntryTypeForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Attendance entry type form and object is:-" + btn_Save.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAttendanceEntryType() throws Exception {
		if (btnMin_MaxAttendanceEntryType.isDisplayed()) {
			btnMin_MaxAttendanceEntryType.click();
			log("Attendance Entry Type page minimized and object is:-" + btnMin_MaxAttendanceEntryType.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Type Minimized Element not present.");
		}
	}

	public void maximizeAttendanceEntryType() throws Exception {
		if (btnMin_MaxAttendanceEntryType.isDisplayed()) {
			btnMin_MaxAttendanceEntryType.click();
			log("Attendance Entry Type page maximized and object is:-" + btnMin_MaxAttendanceEntryType.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Type Maximize Element not present.");
		}
	}

	public void minimizeAttendanceEntryTypeList() throws Exception {
		if (btnMin_MaxAttendanceEntryTypeList.isDisplayed()) {
			btnMin_MaxAttendanceEntryTypeList.click();
			log("clicked on Attendance Entry Type List minimize button and object is:-"
					+ btnMin_MaxAttendanceEntryTypeList.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Type List Minimize Element not present.");
		}
	}

	public void maximizeAttendanceEntryTypeList() throws Exception {
		if (btnMin_MaxAttendanceEntryTypeList.isDisplayed()) {
			btnMin_MaxAttendanceEntryTypeList.click();
			log("clicked on Attendance Entry Type List maximize button and object is:-"
					+ btnMin_MaxAttendanceEntryTypeList.toString());
			Thread.sleep(1000);
		} else {
			log("Attendance Entry Type List Maximize Element not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithClassNameInThe_AttendanceEntryTypeListGrid(String className) throws Exception {
		if (input_Search_ClassInGrid.isDisplayed()) {
			input_Search_ClassInGrid.clear();
			input_Search_ClassInGrid.sendKeys(className);
			log("Entered Class Name to search: " + className + " and object is:-"
					+ input_Search_ClassInGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(String className) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]"))
					.getText().trim();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(classname, className);
				log("Attendance entry type class is updated in the output grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void editAttendanceEntryType(String className) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]"))
					.getText().trim();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(classname, className);
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a")).click();
				log("Clicked on edit link in Attendance entry type to update the created record.");
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
			Thread.sleep(2000);
		} else {
			log("Ok Button element not present.");
			Thread.sleep(500);
		}
	}

}
