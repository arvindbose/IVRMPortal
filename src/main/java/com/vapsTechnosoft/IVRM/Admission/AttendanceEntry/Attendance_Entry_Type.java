/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.AttendanceEntry;

import static org.testng.Assert.assertEquals;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Attendance
	// Entry')]/following::li[2]")
	// WebElement btnAdmission_AttendanceEntry_Type;

	@FindBy(xpath = "//a[@href='#/app/attendanceEntryType/57']")
	WebElement btnAdmission_AttendanceEntry_Type;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmission_AttendanceEntrytypeMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/input")
	WebElement input_Search_Class;

	@FindBy(xpath = "//input[@name='option']")
	List<WebElement> chk_Class;
	// @FindBy(xpath = "//span[contains(text(),' LKG
	// ')]/preceding-sibling::input")
	// WebElement chk_Class;

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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Attendance_Entry_Type(WebDriver driver) {
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

	/**
	 * Navigate to Attendance entry > attendance entry type
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_AttendanceEntry);
		log("Clicked on Attendance entry and object is:-" + btnAdmission_AttendanceEntry.toString());

		clickOnButton(btnAdmission_AttendanceEntry_Type);
		log("Clicked on Attendance entry type Button and object is:-" + btnAdmission_AttendanceEntry_Type.toString());
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
		
			clickOnButton(btn_Save);
			log("Submit blank Attendance entry type form and object is:-" + btn_Save.toString());
	
	}

	public void fillAttendanceEntryTypeForm(String academicYear, String class_Search) throws Exception {
		
			selectedDropdownItemValidation(sel_AcademicYr, academicYear);
			log("Selected academic year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
			inputTextIntoInputField(input_Search_Class, class_Search);
			log("Entered student admission number to search: " + class_Search + " and object is:-"
					+ input_Search_Class.toString());
		
		try{
		int no_Of_ClassChkBox = chk_Class.size();
		for (int i = 0; i < no_Of_ClassChkBox; i++) {
			if (!chk_Class.get(i).isSelected()) {
				chk_Class.get(i).click();
				log(i + " Class check box is checked for attendance entry type and object is:-" + chk_Class.toString());
				Thread.sleep(1000);
			} else {
				log(i + " Class checked box is already checked for attendance entry type and object is:-"
						+ chk_Class.toString());
				Thread.sleep(500);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void select_DailyOnce_RadioButton() throws Exception {
		isDisplayed(rdBtn_Dailyonce);
		if (!rdBtn_Dailyonce.isSelected()) {
			rdBtn_Dailyonce.click();
			log("Daily Once attendance entry type is selected and object is:-" + rdBtn_Dailyonce.toString());
			Thread.sleep(1000);
		} else {
			log("Daily Once attendance entry type is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DailyTwice_RadioButton() throws Exception {
		isDisplayed(rdBtn_DailyTwice);
		if (!rdBtn_DailyTwice.isSelected()) {
			rdBtn_DailyTwice.click();
			log("Daily Twice attendance entry type is selected and object is:-" + rdBtn_DailyTwice.toString());
			Thread.sleep(1000);
		} else {
			log("Daily Twice attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void select_Monthly_RadioButton() throws Exception {
		isDisplayed(rdBtn_Monthly);
		if (!rdBtn_Monthly.isSelected()) {
			rdBtn_Monthly.click();
			log("Monthly attendance entry type is selected and object is:-" + rdBtn_Monthly.toString());
			Thread.sleep(1000);
		} else {
			log("Monthly attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void select_SubjectWise_RadioButton() throws Exception {
		isDisplayed(rdBtn_SubjectWise);
		if (!rdBtn_SubjectWise.isSelected()) {
			rdBtn_SubjectWise.click();
			log("SubjectWise attendance entry type is selected and object is:-" + rdBtn_SubjectWise.toString());
			Thread.sleep(1000);
		} else {
			log("SubjectWise attendance entry type is already selected.");
			Thread.sleep(500);
		}
	}

	public void clearFilledAttendanceEntryTypeForm() throws Exception {
		
			clickOnButton(btn_Clear);
			log("Clicked on clear button to clear filled attendance entry type form and object is:-"
					+ btn_Clear.toString());
		
	}

	public void saveFilledAttendanceEntryTypeForm() throws Exception {
		
			clickOnButton(btn_Save);
			Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
			log("Submit blank Attendance entry type form and object is:-" + btn_Save.toString());
		
	}

	public void minimizeAttendanceEntryType() throws Exception {
		
			clickOnButton(btnMin_MaxAttendanceEntryType);
			log("Attendance Entry Type page minimized and object is:-" + btnMin_MaxAttendanceEntryType.toString());
			
	}

	public void maximizeAttendanceEntryType() throws Exception {
	
			clickOnButton(btnMin_MaxAttendanceEntryType);
			log("Attendance Entry Type page maximized and object is:-" + btnMin_MaxAttendanceEntryType.toString());
			
	}

	public void minimizeAttendanceEntryTypeList() throws Exception {
	
			clickOnButton(btnMin_MaxAttendanceEntryTypeList);
			log("clicked on Attendance Entry Type List minimize button and object is:-"
					+ btnMin_MaxAttendanceEntryTypeList.toString());
		
	}

	public void maximizeAttendanceEntryTypeList() throws Exception {
	
			clickOnButton(btnMin_MaxAttendanceEntryTypeList);
			log("clicked on Attendance Entry Type List maximize button and object is:-"
					+ btnMin_MaxAttendanceEntryTypeList.toString());
		
	}

	public void searchWithClassNameInThe_AttendanceEntryTypeListGrid(String className) throws Exception {
		
			inputTextIntoInputField(input_Search_ClassInGrid, className);
			log("Entered Class Name to search: " + className + " and object is:-"
					+ input_Search_ClassInGrid.toString());
		
	}

	public void verifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(String className) {
		try {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
	
		for (int i = 1; i <= rows; i++) {
			
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]"))
					.getText().trim();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			
			if(classname.equals(className)){
				//Assert.assertEquals(classname, className);
				log("Attendance entry type class is updated in the output grid.");
				break;
			}
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editAttendanceEntryType(String className) {
		try {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]"))
					.getText().trim();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			
				if(classname.equals(className)){
				
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a")).click();
				log("Clicked on edit link in Attendance entry type to update the created record.");
				Thread.sleep(2000);
				break;
				}
		}

		} catch (Exception e) {
			//Assert.assertEquals(classname, className);
			e.printStackTrace();
		}
	}

	public void clickOnOkSuccessButton() throws Exception {
		
			clickOnButton(btnOKSuccess);
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		
	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			//validate_PopUpText.isDisplayed();
			isDisplayed(validate_PopUpText);
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try{
			//validate_PopUpText.isDisplayed();
			isDisplayed(validate_PopUpText);
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
