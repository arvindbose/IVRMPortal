/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Reports;

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
 * @author Arvind
 * 
 * Login with Staff Login Credentils
 * UserName: Priya, Password= Password@123
 *
 */
public class ClassWise_Daily_Attendance_Report extends TestBase{
	
	public static final Logger log = Logger.getLogger(ClassWise_Daily_Attendance_Report.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')]")
	WebElement btnAdmission_Reports;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')]/following::li[1]")
	WebElement btnReports_ClassWiseDaily_AttendanceReport;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_ClassWiseDaily_AttendanceReportMsgDispaly;
	
	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;
	
	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;
	
	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;
	
	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following::button[1])[1]")
	WebElement btnCalendar_Date;
	
	@FindBy(xpath = "//span[contains(text(),'Mar 2018')]")
	WebElement btn_MonthYear;
	
	@FindBy(xpath = "//span[contains(text(),'Mar 2018')]/following::td[25]/span")
	WebElement btn_Date;
	
	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;
	
	@FindBy(xpath = "//span[contains(text(),'Export')]/parent::button")
	WebElement btn_Export;
	
	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table[2]/tbody/tr")
	List<WebElement> tblRows;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxClassWiseDailyAttendance;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxClassWiseDailyAttendanceListGrid;
	
	
	public ClassWise_Daily_Attendance_Report(WebDriver driver) {
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
	 * Navigate to Admission > Reports > ClassWise Daily Attendance Report
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_ClassWiseDaily_AttendanceReport() throws Exception {
		if (btn_Admission.isDisplayed()) {
			btn_Admission.click();
			log("Clicked on admission Button and object is:-" + btn_Admission.toString());
			Thread.sleep(1000);
		} else {
			log("Admission button element not present.");
			Thread.sleep(500);
		}
		if (btnAdmission_Reports.isDisplayed()) {
			btnAdmission_Reports.click();
			log("Clicked on Admission Reports and object is:-" + btnAdmission_Reports.toString());
			Thread.sleep(1000);
		} else {
			log("Reports button element not present.");
			Thread.sleep(500);
		}
		if (btnReports_ClassWiseDaily_AttendanceReport.isDisplayed()) {
			btnReports_ClassWiseDaily_AttendanceReport.click();
			log("Clicked on ClassWise Daily Attendance Button and object is:-"
					+ btnReports_ClassWiseDaily_AttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Daily Attendance button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Reports > ClassWise Daily Attendance Report screen message
	 * 
	 * @return
	 */
	public boolean verifyReports_ClassWiseDailyAttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_ClassWiseDaily_AttendanceReportMsgDispaly.getText());
			txtReports_ClassWiseDaily_AttendanceReportMsgDispaly.isDisplayed();
			log("ClassWise Daily Attendance Report page is dispalyed and object is:-"
					+ txtReports_ClassWiseDaily_AttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_ClassWiseDailyAttendanceReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank ClassWise Daily Attendance Report form and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}
	
	public void fillClassWiseDailyAttendanceReportForm(String academicYr, String class_Rep, String section) throws Exception {
		if(sel_AcademicYr.isDisplayed()) {
		select = new Select(sel_AcademicYr);
		select.selectByVisibleText(academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), academicYr);
		Thread.sleep(1000);
		}
		else {
			log("Academic Year element is not present.");
			Thread.sleep(500);
		}
		
		if(sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Rep);
			log("selected Class: " + class_Rep + " and object is:- " + sel_Class.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Rep);
			Thread.sleep(1000);
			}
			else {
				log("Class element is not present.");
				Thread.sleep(500);
			}
		if(sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);
			log("selected section: " + section + " and object is:- " + sel_Section.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
			}
			else {
				log("Section element is not present.");
				Thread.sleep(500);
			}
		if (btnCalendar_Date.isDisplayed()) {
			btnCalendar_Date.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_Date.click();
			log("Attendance date is selected from calender.");
			Thread.sleep(1000);
		}else{
			log("Calendar button element not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnReportButtonToGenerateReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Clicked Report buttton and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}
	
	public void clickOnCancelButton() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clicked cancel buttton and object is:-" + btn_Cancel.toString());
			Thread.sleep(5000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnExportButton_ToDownloadExcelReport() throws Exception {
		if (btn_Export.isDisplayed()) {
			btn_Export.click();
			log("Clicked Export buttton and object is:-" + btn_Export.toString());
			Thread.sleep(5000);
		} else {
			log("Export button element not present.");
			Thread.sleep(500);
		}
	}
	public void minimizeClassWiseDailyAttendance() throws Exception {
		if (btnMin_MaxClassWiseDailyAttendance.isDisplayed()) {
			btnMin_MaxClassWiseDailyAttendance.click();
			log("ClassWise Daily Attendance page minimized and object is:-" + btnMin_MaxClassWiseDailyAttendance.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Daily Attendance Minimized Element not present.");
		}
	}

	public void maximizeClassWiseDailyAttendance() throws Exception {
		if (btnMin_MaxClassWiseDailyAttendance.isDisplayed()) {
			btnMin_MaxClassWiseDailyAttendance.click();
			log("ClassWise Daily Attendance page maximized and object is:-" + btnMin_MaxClassWiseDailyAttendance.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Daily Attendance Maximize Element not present.");
		}
	}

	public void minimizeClassWiseDailyAttendanceListGrid() throws Exception {
		if (btnMin_MaxClassWiseDailyAttendanceListGrid.isDisplayed()) {
			btnMin_MaxClassWiseDailyAttendanceListGrid.click();
			log("ClassWise Daily Attendance List grid page minimized and object is:-"
					+ btnMin_MaxClassWiseDailyAttendanceListGrid.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Daily Attendance List grid Minimize Element not present.");
		}
	}

	public void maximizeClassWiseDailyAttendanceListGrid() throws Exception {
		if (btnMin_MaxClassWiseDailyAttendanceListGrid.isDisplayed()) {
			btnMin_MaxClassWiseDailyAttendanceListGrid.click();
			log("ClassWise Daily Attendance List grid page maximized and object is:-"
					+ btnMin_MaxClassWiseDailyAttendanceListGrid.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Daily Attendance List grid Maximize Element not present.");
			Thread.sleep(500);
		}
	}
	public void searchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid(String AdmissionNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(AdmissionNum);
			log("Entered Admission Number to search: " + AdmissionNum + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid(String AdmissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i +"]/td[5]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admNumber, AdmissionNum);
				log("Student is identified for the classwise attendance report.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel(String AdmissionNum, String attendance_Status) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i + "]/td[5]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admNumber, AdmissionNum);
				log("Admission Number matched with the grid admission number");
				Thread.sleep(500);
				String attendanceStatus = driver.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[\" + i + \"]/td[6]")).getText().trim();
				Assert.assertEquals(attendanceStatus, attendance_Status);
				log("Student attendance status is validated in the Classwise attendance grid.");
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[\" + i + \"]/td[1]/label/input")).click();
				log("Selected student check box for export to excel report.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
