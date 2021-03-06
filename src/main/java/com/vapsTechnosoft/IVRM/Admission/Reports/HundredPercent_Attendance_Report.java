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
 * @author vaps This Script will work for staff login credentials Username:
 *         Priya, Password: password@123
 */
public class HundredPercent_Attendance_Report extends TestBase {
	public static final Logger log = Logger.getLogger(HundredPercent_Attendance_Report.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[3]")
	// WebElement btnReports_100_Percent_AttendanceReport;

	@FindBy(xpath = "//a[@href='#/app/100AttendanceReport/166']")
	WebElement btnReports_100_Percent_AttendanceReport;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_100_Percent_AttendanceReportMsgDispaly;

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

	@FindBy(xpath = "//span[contains(text(),'Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_Max100_PercentAttendanceReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_Max100_PercentAttendanceReportStudentList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	public HundredPercent_Attendance_Report(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission > Reports > 100% attendance reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_100Present_AttendanceReport_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_100_Percent_AttendanceReport);
		log("Clicked on 100% Attendance reports Button and object is:-"
				+ btnReports_100_Percent_AttendanceReport.toString());

	}

	/**
	 * Validation of Admission > Reports > 100% attendance reports screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_100_Percent_AttendanceReportMsgDispaly.getText());
			txtReports_100_Percent_AttendanceReportMsgDispaly.isDisplayed();
			log("100% Attendance Report page is dispalyed and object is:-"
					+ txtReports_100_Percent_AttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void exportReport_WithoutSelectingRecords() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("Without selecting records click on Excel Button and object is:-" + btn_ExportToExcel.toString());
		Thread.sleep(2000);

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void fill100Percent_AttendanceReportForm_All(String academicYear, String Class_100, String section)
			throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

	}

	public void fill100Percent_AttendanceReportForm_Individual(String academicYear, String Class_100, String section)
			throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:-" + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual radio button is already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, Class_100);
		log("selected Class: " + Class_100 + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

	}

	public void clickOnReport_TogetRecords() throws Exception {

		clickOnButton(btn_Report);
		log("To Get the records for report generation click on Report Button and object is:-" + btn_Report.toString());

	}

	public void clickOn_CancelButton_ToClearFilledData() throws Exception {

		clickOnButton(btn_Cancel);
		log("Cancel button is clicked to Clear filled data and object is:-" + btn_Cancel.toString());

	}

	public void exportReport_ToDownloadExcelReport() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("To Download excel report click on Excel Button and object is:-" + btn_ExportToExcel.toString());

	}

	public void clickOnPrint_WithoutSelectingRecords() throws Exception {

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report as print preview without selecting records and object is:-"
				+ btn_Print.toString());
	}

	public void clickOnPrint() throws Exception {

		String parentWin = driver.getWindowHandle();

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report as print preview and object is:-" + btn_Print.toString());
		Thread.sleep(2000);

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

	public void minimize_100_PercentAttendanceReport() throws Exception {

		clickOnButton(btnMin_Max100_PercentAttendanceReport);
		log("100% attendance Report page minimized and object is:-" + btnMin_Max100_PercentAttendanceReport.toString());

	}

	public void maximize_100_PercentAttendanceReport() throws Exception {

		clickOnButton(btnMin_Max100_PercentAttendanceReport);
		log("100% attendance Report page maximized and object is:-" + btnMin_Max100_PercentAttendanceReport.toString());

	}

	public void minimize_100_PercentAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_Max100_PercentAttendanceReportStudentList);
		log("100% attendance Report Student List page minimized and object is:-"
				+ btnMin_Max100_PercentAttendanceReportStudentList.toString());

	}

	public void maximize_100_PercentAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_Max100_PercentAttendanceReportStudentList);
		log("100% attendance Report Student List page maximized and object is:-"
				+ btnMin_Max100_PercentAttendanceReportStudentList.toString());

	}

	public void searchStudentToGenerateReport_From100_PercentAttendanceReportGrid(String admissionNum)
			throws Exception {

		inputTextIntoInputField(input_Search, admissionNum);
		log("Entered Admission Number to search: " + admissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudent_For100_PercentAttendanceReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				if (admNumber.equals(admissionNum)) {
					// Assert.assertEquals(admNumber, admissionNum);
					log("Student available for 100% attendance Report.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentFor_100PercentAttendanceReport(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(admissionNum)) {
					Assert.assertEquals(admNumber, admissionNum);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"))
							.click();
					log("Corresponding student check box is checked for 100% attendance Report.");
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
