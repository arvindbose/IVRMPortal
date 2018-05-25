/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Reports;

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
	WebElement btnReports_OverallDailyAttendance;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_OverallDailyAttendanceReportMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following::div//button)[1]")
	WebElement btnCalendar_Date;

	@FindBy(xpath = "//span[contains(text(),'Apr 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Apr 2018')]/following::td[2]/span")
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
			log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());
			Thread.sleep(1000);
		} else {
			log("Admission reports button element not present.");
			Thread.sleep(500);
		}
		if (btnReports_OverallDailyAttendance.isDisplayed()) {
			btnReports_OverallDailyAttendance.click();
			log("Clicked on Overall Daily Attendance reports Button and object is:-"
					+ btnReports_OverallDailyAttendance.toString());
			Thread.sleep(1000);
		} else {
			log("Overall Daily Attendance reports button element not present.");
			Thread.sleep(500);
		}

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
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("Without selecting records click on Export Button and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(3000);
		} else {
			log("Export button element not present.");
			Thread.sleep(500);
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

	public void fillOverallDailyAttendanceReportForm(String academicYear) throws Exception {

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);
			log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present.");
			Thread.sleep(500);
		}
		if (btnCalendar_Date.isDisplayed()) {
			btnCalendar_Date.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_Date.click();
			log("Date Of Attendance is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOn_ReportButton_ToGenerateReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Report button is clicked to generate report and object is:-" + btn_Report.toString());
			Thread.sleep(3000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOn_CancelButton_ToClearFilledData() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Cancel button is clicked to Clear filled data and object is:-" + btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOn_ExportButton_ToGenerateExcelReport() throws Exception {
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("Export button is clicked to generate/download excel report and object is:-"
					+ btn_ExportToExcel.toString());
			Thread.sleep(5000);
		} else {
			log("Export button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimize_OverAllDailyAttendanceReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_OverallDailyAttendanceReportMsgDispaly);
		Thread.sleep(2000);
		if (btnMin_MaxOverAllDailyAttendanceReport.isDisplayed()) {
			btnMin_MaxOverAllDailyAttendanceReport.click();
			log("OverAll Daily attendance Report page minimized and object is:-"
					+ btnMin_MaxOverAllDailyAttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Daily attendance Report Minimized Element not present.");
		}
	}

	public void maximize_OverAllDailyAttendanceReport() throws Exception {
		if (btnMin_MaxOverAllDailyAttendanceReport.isDisplayed()) {
			btnMin_MaxOverAllDailyAttendanceReport.click();
			log("OverAll Daily attendance Report page maximized and object is:-"
					+ btnMin_MaxOverAllDailyAttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Daily attendance Report Maximize Element not present.");
		}
	}

	public void minimize_OverAllDailyAttendanceReportStudentList() throws Exception {
		if (btnMin_MaxOverAllDailyAttendanceReportStudentList.isDisplayed()) {
			btnMin_MaxOverAllDailyAttendanceReportStudentList.click();
			log("OverAll Daily attendance Report Student List page minimized and object is:-"
					+ btnMin_MaxOverAllDailyAttendanceReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Daily attendance Report Student List Minimized Element not present.");
		}
	}

	public void maximize_OverAllDailyAttendanceReportStudentList() throws Exception {
		if (btnMin_MaxOverAllDailyAttendanceReportStudentList.isDisplayed()) {
			btnMin_MaxOverAllDailyAttendanceReportStudentList.click();
			log("OverAll Daily attendance Report Student List page maximized and object is:-"
					+ btnMin_MaxOverAllDailyAttendanceReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Daily attendance Report Student List Maximize Element not present.");
		}
	}
	public void search_ClassSectionToGenerateOverAllDailyAttendanceReport(String class_section) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(class_section);
			log("Entered class-section to search: " + class_section + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search input field element not present.");
			Thread.sleep(500);
		}
	}
	public void verifySearchedRecords_OverallDialyAttendanceReportGrid(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classection = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Class Section: " + classection);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(classection, class_section);
				log("Searched class-section is available in overall daily attendance report grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Admission Number: " + classname);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(classname, class_section);
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]/a"))
						.click();
				log("Corresponding class click to view details link is clicked.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectRecord_ToGenerateSelected_ClassReport(String class_section) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Admission Number: " + classname);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(classname, class_section);
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding class is checked to generate report.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void search_Absentees_ToGenerateOverAllDailyAttendanceReport(String absentees_Name) throws Exception {
		if (input_Search_PopUp.isDisplayed()) {
			input_Search_PopUp.clear();
			input_Search_PopUp.sendKeys(absentees_Name);
			log("Entered Ansentees to search: " + absentees_Name + " and object is:-"
					+ input_Search_PopUp.toString());
			Thread.sleep(1000);
		} else {
			log("Search input field element not present.");
			Thread.sleep(500);
		}
	}
	public void verifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp(String absentees_Name) {
		int rows = tblRows_PopUp.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String absenteesname = driver
					.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Absentees Name: " + absenteesname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(absenteesname, absentees_Name);
				log("Searched absentees is available in overall daily attendance report grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectRecord_Absentees_ToExportAsExcelReport(String absentees_Name) {
		int rows = tblRows_PopUp.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String absenteesname = driver
					.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Absentees Name: " + absenteesname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(absenteesname, absentees_Name);
				log("Searched absentees is available in overall daily attendance report grid.");

				driver.findElement(By.xpath("(//table[@id='table1']/tbody)[2]/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding absentees check box is checked.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void exportReport_BySelectingAbsenteesName() throws Exception {
		if (btn_Export_PopUp.isDisplayed()) {
			btn_Export_PopUp.click();
			log("click on Export Button to get absentees report and object is:-" + btn_Export_PopUp.toString());
			Thread.sleep(3000);
		} else {
			log("Export popup button element not present.");
			Thread.sleep(500);
		}
	}
	public void clickOnCloseButton_ToCloseAbsenteesPopUp() throws Exception {
		if (btn_Close_PopUp.isDisplayed()) {
			btn_Close_PopUp.click();
			log("click on Close Button to close popup and object is:-" + btn_Close_PopUp.toString());
			Thread.sleep(3000);
		} else {
			log("Close popup button element not present.");
			Thread.sleep(500);
		}
	}
}
