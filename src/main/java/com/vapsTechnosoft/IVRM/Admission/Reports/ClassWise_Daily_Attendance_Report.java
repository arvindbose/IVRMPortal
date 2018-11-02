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
 *         Login with Staff Login Credentils UserName: Priya, Password=
 *         Password@123
 *
 */
public class ClassWise_Daily_Attendance_Report extends TestBase {

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')]/following::li[1]")
	// WebElement btnReports_ClassWiseDaily_AttendanceReport;

	@FindBy(xpath = "//a[@href='#/app/ClassWiseDailyAttendance/76']")
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

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[3]/span")
	WebElement btn_Date;
	
	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear2;

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
			Thread.sleep(2000);
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
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_ClassWiseDaily_AttendanceReport);
		log("Clicked on ClassWise Daily Attendance Button and object is:-"
				+ btnReports_ClassWiseDaily_AttendanceReport.toString());

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

		clickOnButton(btn_Report);
		log("Submit blank ClassWise Daily Attendance Report form and object is:-" + btn_Report.toString());

	}

	public void fillClassWiseDailyAttendanceReportForm(String academicYr, String class_Rep, String section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, class_Rep);
		log("selected Class: " + class_Rep + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendar_Date);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear2);
		//Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_Date.click();
		log("Attendance date is selected from calender.");

	}

	public void clickOnReportButtonToGenerateReport() throws Exception {

		clickOnButton(btn_Report);
		log("Clicked Report buttton and object is:-" + btn_Report.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btn_Cancel);
		log("Clicked cancel buttton and object is:-" + btn_Cancel.toString());

	}

	public void clickOnExportButton_ToDownloadExcelReport() throws Exception {

		clickOnButton(btn_Export);
		log("Clicked Export buttton and object is:-" + btn_Export.toString());

	}

	public void minimizeClassWiseDailyAttendance() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_ClassWiseDaily_AttendanceReportMsgDispaly);
		Thread.sleep(1000);
		clickOnButton(btnMin_MaxClassWiseDailyAttendance);
		log("ClassWise Daily Attendance page minimized and object is:-"
				+ btnMin_MaxClassWiseDailyAttendance.toString());

	}

	public void maximizeClassWiseDailyAttendance() throws Exception {

		clickOnButton(btnMin_MaxClassWiseDailyAttendance);
		log("ClassWise Daily Attendance page maximized and object is:-"
				+ btnMin_MaxClassWiseDailyAttendance.toString());

	}

	public void minimizeClassWiseDailyAttendanceListGrid() throws Exception {

		clickOnButton(btnMin_MaxClassWiseDailyAttendanceListGrid);
		log("ClassWise Daily Attendance List grid page minimized and object is:-"
				+ btnMin_MaxClassWiseDailyAttendanceListGrid.toString());

	}

	public void maximizeClassWiseDailyAttendanceListGrid() throws Exception {

		clickOnButton(btnMin_MaxClassWiseDailyAttendanceListGrid);
		log("ClassWise Daily Attendance List grid page maximized and object is:-"
				+ btnMin_MaxClassWiseDailyAttendanceListGrid.toString());

	}

	public void searchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid(String AdmissionNum) throws Exception {

		inputTextIntoInputField(input_Search, AdmissionNum);
		log("Entered Admission Number to search: " + AdmissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid(String AdmissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				if (admNumber.equals(AdmissionNum)) {
					// Assert.assertEquals(admNumber, AdmissionNum);
					log("Student is identified for the classwise attendance report.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel(String AdmissionNum,
			String attendance_Status) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(AdmissionNum)) {
					// Assert.assertEquals(admNumber, AdmissionNum);
					log("Admission Number matched with the grid admission number");
					Thread.sleep(500);
					String attendanceStatus = driver
							.findElement(By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i + "]/td[8]"))
							.getText().trim();
					Assert.assertEquals(attendanceStatus, attendance_Status);
					log("Student attendance status is validated in the Classwise attendance grid.");
					Thread.sleep(500);
					driver.findElement(
							By.xpath("//div[@class='box-body']/table[2]/tbody/tr[" + i + "]/td[1]/label/input"))
							.click();
					log("Selected student check box for export to excel report.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
