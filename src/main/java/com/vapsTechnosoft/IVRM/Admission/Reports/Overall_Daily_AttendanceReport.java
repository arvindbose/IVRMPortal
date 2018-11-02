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
 * @author vaps This Script will work for staff login credentials Username:
 *         Priya Password: password@123
 */
public class Overall_Daily_AttendanceReport extends TestBase {

	public static final Logger log = Logger.getLogger(Overall_Daily_AttendanceReport.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	WebElement btnAdmission_Reports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
	// WebElement btnReports_OverallDailyAttendance;

	@FindBy(xpath = "//a[@href='#/app/OverallDailyAttendanceReport/167']")
	WebElement btnReports_OverallDailyAttendance;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_OverallDailyAttendanceReportMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following::div//button)[1]")
	WebElement btnCalendar_Date;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear2;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[3]/span")
	WebElement btn_Date;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "(//span[contains(text(),'Export')]/parent::button)[1]")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxOverAllDailyAttendanceReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxOverAllDailyAttendanceReportStudentList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//div[@id='content_id1']/div[2]/div/input")
	WebElement input_Search_PopUp;

	@FindBy(xpath = "(//table[@id='table1']/tbody)[2]/tr")
	List<WebElement> tblRows_PopUp;

	@FindBy(xpath = "(//span[contains(text(),'Export')]/parent::button)[2]")
	WebElement btn_Export_PopUp;

	@FindBy(xpath = "(//span[contains(text(),'Close')]/parent::button)[1]")
	WebElement btn_Close_PopUp;

	public Overall_Daily_AttendanceReport(WebDriver driver) {
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
	 * Navigate to Admission > Reports > Overall Daily Attendance reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_OverallDailyAttendance);
		log("Clicked on Overall Daily Attendance reports Button and object is:-"
				+ btnReports_OverallDailyAttendance.toString());
	}

	/**
	 * Validation of Admission > Reports > Overall Daily Attendance reports
	 * screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_OverallDailyAttendanceReportMsgDispaly.getText());
			txtReports_OverallDailyAttendanceReportMsgDispaly.isDisplayed();
			log("Overall Daily Attendance Report page is dispalyed and object is:-"
					+ txtReports_OverallDailyAttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void exportReport_WithoutSelectingRecords() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("Without selecting records click on Export Button and object is:-" + btn_ExportToExcel.toString());
		Thread.sleep(1000);

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void fillOverallDailyAttendanceReportForm(String academicYear) throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

		clickOnButton(btnCalendar_Date);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear2);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_Date.click();
		log("Date Of Attendance is selected from calender.");

	}

	public void clickOn_ReportButton_ToGenerateReport() throws Exception {

		clickOnButton(btn_Report);
		log("Report button is clicked to generate report and object is:-" + btn_Report.toString());
		Thread.sleep(1000);

	}

	public void clickOn_CancelButton_ToClearFilledData() throws Exception {

		clickOnButton(btn_Cancel);
		log("Cancel button is clicked to Clear filled data and object is:-" + btn_Cancel.toString());

	}

	public void clickOn_ExportButton_ToGenerateExcelReport() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("Export button is clicked to generate/download excel report and object is:-"
				+ btn_ExportToExcel.toString());
		Thread.sleep(1000);

	}

	public void minimize_OverAllDailyAttendanceReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_OverallDailyAttendanceReportMsgDispaly);
		Thread.sleep(2000);

		clickOnButton(btnMin_MaxOverAllDailyAttendanceReport);
		log("OverAll Daily attendance Report page minimized and object is:-"
				+ btnMin_MaxOverAllDailyAttendanceReport.toString());

	}

	public void maximize_OverAllDailyAttendanceReport() throws Exception {

		clickOnButton(btnMin_MaxOverAllDailyAttendanceReport);
		log("OverAll Daily attendance Report page maximized and object is:-"
				+ btnMin_MaxOverAllDailyAttendanceReport.toString());

	}

	public void minimize_OverAllDailyAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxOverAllDailyAttendanceReportStudentList);
		log("OverAll Daily attendance Report Student List page minimized and object is:-"
				+ btnMin_MaxOverAllDailyAttendanceReportStudentList.toString());

	}

	public void maximize_OverAllDailyAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxOverAllDailyAttendanceReportStudentList);
		log("OverAll Daily attendance Report Student List page maximized and object is:-"
				+ btnMin_MaxOverAllDailyAttendanceReportStudentList.toString());

	}

	public void search_ClassSectionToGenerateOverAllDailyAttendanceReport(String class_section) throws Exception {

		inputTextIntoInputField(input_Search, class_section);
		log("Entered class-section to search: " + class_section + " and object is:-" + input_Search.toString());

	}

	public void verifySearchedRecords_OverallDialyAttendanceReportGrid(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classection = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Class Section: " + classection);
				// Thread.sleep(2000);
				if (classection.equals(class_section)) {
					// Assert.assertEquals(classection, class_section);
					log("Searched class-section is available in overall daily attendance report grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);

		try {
			for (int i = 1; i <= rows; i++) {

				String classname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Class Name: " + classname);
				// Thread.sleep(2000);
				if (classname.equals(class_section)) {
					Assert.assertEquals(classname, class_section);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]/a")).click();
					log("Corresponding class click to view details link is clicked.");
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecord_ToGenerateSelected_ClassReport(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Admission Number: " + classname);
				// Thread.sleep(2000);
				if (classname.equals(class_section)) {
					Assert.assertEquals(classname, class_section);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"))
							.click();
					log("Corresponding class is checked to generate report.");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search_Absentees_ToGenerateOverAllDailyAttendanceReport(String absentees_Name) throws Exception {

		inputTextIntoInputField(input_Search_PopUp, absentees_Name);
		log("Entered Ansentees to search: " + absentees_Name + " and object is:-" + input_Search_PopUp.toString());
		Thread.sleep(1000);

	}

	public void verifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp(String absentees_Name) {
		int rows = tblRows_PopUp.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String absenteesname = driver
						.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[3]")).getText().trim();
				System.out.println("Absentees Name: " + absenteesname);
				// Thread.sleep(2000);
				if (absenteesname.equals(absentees_Name)) {
					Assert.assertEquals(absenteesname, absentees_Name);
					log("Searched absentees is available in overall daily attendance report grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecord_Absentees_ToExportAsExcelReport(String absentees_Name) {
		int rows = tblRows_PopUp.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String absenteesname = driver
						.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[3]")).getText().trim();
				System.out.println("Absentees Name: " + absenteesname);
				// Thread.sleep(2000);
				if (absenteesname.equals(absentees_Name)) {
					Assert.assertEquals(absenteesname, absentees_Name);
					log("Searched absentees is available in overall daily attendance report grid.");

					driver.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[1]/label/input"))
							.click();
					log("Corresponding absentees check box is checked.");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportReport_BySelectingAbsenteesName() throws Exception {

		clickOnButton(btn_Export_PopUp);
		log("click on Export Button to get absentees report and object is:-" + btn_Export_PopUp.toString());

	}

	public void clickOnCloseButton_ToCloseAbsenteesPopUp() throws Exception {

		clickOnButton(btn_Close_PopUp);
		log("click on Close Button to close popup and object is:-" + btn_Close_PopUp.toString());

	}
}
