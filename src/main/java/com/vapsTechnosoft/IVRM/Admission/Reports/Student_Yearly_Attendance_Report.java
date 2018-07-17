/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Reports;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class Student_Yearly_Attendance_Report extends TestBase{
	
	public static final Logger log = Logger.getLogger(Student_Yearly_Attendance_Report.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	WebElement btnAdmission_Reports;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[3]")
	WebElement btnReports_StudentYearly_AttendanceReport;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_StudentYearly_AttendanceReportMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	WebElement rdBtn_ALL;

	@FindBy(xpath = "//span[contains(text(),'Individual')]/preceding-sibling::input")
	WebElement rdBtn_Individual;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export To Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxStudentYearly_AttendanceReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentYearly_AttendanceReportStudentList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	public Student_Yearly_Attendance_Report(WebDriver driver) {
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

	/**
	 * Navigate to Admission > Reports > Student Yearly attendance reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS() throws Exception {
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
		if (btnReports_StudentYearly_AttendanceReport.isDisplayed()) {
			btnReports_StudentYearly_AttendanceReport.click();
			log("Clicked on Student Yearly Attendance reports Button and object is:-"
					+ btnReports_StudentYearly_AttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("Student Yearly Attendance reports button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Admission > Reports > Student Yearly attendance reports screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_StudentYearly_AttendanceReportMsgDispaly.getText());
			txtReports_StudentYearly_AttendanceReportMsgDispaly.isDisplayed();
			log("Student Yearly Attendance Report page is dispalyed and object is:-"
					+ txtReports_StudentYearly_AttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
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

//	public void fillStudentYearly_AttendanceReportForm_All(String academicYear, String Class_Yearly, String section) throws Exception {
//
//		if (!rdBtn_ALL.isSelected()) {
//			rdBtn_ALL.click();
//			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
//			Thread.sleep(1000);
//		} else {
//			log("All radio button is already selected.");
//			Thread.sleep(500);
//		}
//
//		if (sel_AcademicYr.isDisplayed()) {
//			select = new Select(sel_AcademicYr);
//			select.selectByVisibleText(academicYear);
//			log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
//			Thread.sleep(1000);
//
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), academicYear);
//			Thread.sleep(1000);
//		} else {
//			log("Class element is not present.");
//			Thread.sleep(500);
//		}
//	}

	public void fillStudentYearly_AttendanceReportForm(String academicYear, String Class_Yearly, String section)
			throws Exception {

//		if (!rdBtn_Individual.isSelected()) {
//			rdBtn_Individual.click();
//			log("Individual radio button is selected and object is:-" + rdBtn_Individual.toString());
//			Thread.sleep(1000);
//		} else {
//			log("Individual radio button is already selected.");
//			Thread.sleep(500);
//		}

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
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_Yearly);
			log("selected Class: " + Class_Yearly + " and object is:- " + sel_Class.toString());
			Thread.sleep(1000);

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_Yearly);
			Thread.sleep(1000);
		} else {
			log("Class element is not present.");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void clickOnReport_TogetRecords() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("To Get the records for report generation click on Report Button and object is:-"
					+ btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOn_CancelButton_ToClearFilledData() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Cancel button is clicked to Clear filled data and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void exportReport_ToDownloadExcelReport() throws Exception {
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("To Download excel report click on Excel Button and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(7000);
		} else {
			log("Excel button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnPrint_WithoutSelectingRecords() throws Exception {

		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate report as print preview without selecting records and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

		} else {
			log("Print button element is not present.");
			Thread.sleep(500);
		}
	}
	
	public void clickOnPrint() throws Exception {

		String parentWin = driver.getWindowHandle();

		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate report as print preview and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

		} else {
			log("Print button element is not present.");
			Thread.sleep(500);
		}

		Set<String> allWin = driver.getWindowHandles();

		System.out.println("Page title before Switching : " + driver.getTitle());
		System.out.println("Total Windows : " + allWin.size());

		for (String windows : allWin) {
			// if(!windows.equals(parentWin)){
			driver.switchTo().window(windows);

			if (driver.getTitle().toLowerCase().contains("Print")) {
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
				Thread.sleep(5000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
	}

	public void minimize_StudentYearly_AttendanceReport() throws Exception {
		if (btnMin_MaxStudentYearly_AttendanceReport.isDisplayed()) {
			btnMin_MaxStudentYearly_AttendanceReport.click();
			log("Student Yearly attendance Report page minimized and object is:-"
					+ btnMin_MaxStudentYearly_AttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("Student Yearly attendance Report Minimized Element not present.");
		}
	}

	public void maximize_StudentYearly_AttendanceReport() throws Exception {
		if (btnMin_MaxStudentYearly_AttendanceReport.isDisplayed()) {
			btnMin_MaxStudentYearly_AttendanceReport.click();
			log("Student Yearly attendance Report page maximized and object is:-"
					+ btnMin_MaxStudentYearly_AttendanceReport.toString());
			Thread.sleep(1000);
		} else {
			log("Student Yearly attendance Report Maximize Element not present.");
		}
	}

	public void minimize_StudentYearly_AttendanceReportStudentList() throws Exception {
		if (btnMin_MaxStudentYearly_AttendanceReportStudentList.isDisplayed()) {
			btnMin_MaxStudentYearly_AttendanceReportStudentList.click();
			log("Student Yearly attendance Report Student List page minimized and object is:-"
					+ btnMin_MaxStudentYearly_AttendanceReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Student Yearly attendance Report Student List Minimized Element not present.");
		}
	}

	public void maximize_StudentYearly_AttendanceReportStudentList() throws Exception {
		if (btnMin_MaxStudentYearly_AttendanceReportStudentList.isDisplayed()) {
			btnMin_MaxStudentYearly_AttendanceReportStudentList.click();
			log("Student Yearly attendance Report Student List page maximized and object is:-"
					+ btnMin_MaxStudentYearly_AttendanceReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Student Yearly attendance Report Student List Maximize Element not present.");
		}
	}
	public void searchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid(String admissionNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(admissionNum);
			log("Entered Admission Number to search: " + admissionNum + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search input field element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudent_ForStudentYearly_AttendanceReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admNumber, admissionNum);
				log("Student available for Student Yearly attendance Report.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudentFor_StudentYearly_AttendanceReport(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding student check box is checked for Student Yearly attendance Report.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
