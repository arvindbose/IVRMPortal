/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Reports;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 *         This Script will work for staff login credentials Username: Priya
 *         Password: password@123
 *
 */
public class Student_Attendance_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Admission_Register_Report.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[2]")
	// WebElement btnReports_StuAttendanceReport;

	@FindBy(xpath = "//a[@href='#/app/StudentAttendanceReport/164']")
	WebElement btnReports_StuAttendanceReport;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_StuAttendanceReportMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	WebElement rdBtn_ALL;

	@FindBy(xpath = "//span[contains(text(),'Individual')]/preceding-sibling::input")
	WebElement rdBtn_Individual;

	@FindBy(xpath = "//span[contains(text(),'Monthly')]/preceding-sibling::input")
	WebElement rdBtn_Monthly;

	@FindBy(xpath = "//span[contains(text(),'Between Date')]/preceding-sibling::input")
	WebElement rdBtn_BetweenDate;

	@FindBy(xpath = "//span[contains(text(),'Daily')]/preceding-sibling::input")
	WebElement rdBtn_Daily;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Month:')]/following-sibling::div/select")
	WebElement sel_Month;

	@FindBy(xpath = "//div[@class='col-sm-8']/label/span")
	WebElement chk_MonthDayWise;

	@FindBy(xpath = "//label[contains(text(),'From Date:')]/following::button[1]")
	WebElement btnCalendars_FromDate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	WebElement btn_MonthYear_FromDate;
	
	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear_FromDate2;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]/following::td[1]/span")
	WebElement btn_Date_FromDate;

	// @FindBy(xpath = "//span[contains(text(),'Jan 2018')]")
	// WebElement btn_MonthYear_FromDate;
	//
	// @FindBy(xpath = "//span[contains(text(),'Jan 2018')]/following::td[6]")
	// WebElement btn_Date_FromDate;

	@FindBy(xpath = "//label[contains(text(),'To Date:')]/following::button[1]")
	WebElement btnCalendars_ToDate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
	WebElement btn_MonthYear_ToDate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]//following::td[32]")
	WebElement btn_Date_ToDate;

	@FindBy(xpath = "//label[contains(text(),'Daily:')]/following::button[1]")
	WebElement btnCalendars_Daily;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	WebElement btn_MonthYear_Daily;
	
	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear_Daily2;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]/following::td[1]/span")
	WebElement btn_Date_Daily;

	// @FindBy(xpath = "//span[contains(text(),'Mar 2018')]")
	// WebElement btn_MonthYear_Daily;
	//
	// @FindBy(xpath = "//span[contains(text(),'Mar 2018')]//following::td[25]")
	// WebElement btn_Date_Daily;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//label[contains(text(),'Student Name:')]/following-sibling::div/select")
	WebElement sel_StudentName;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows_MonthDayWise;

	@FindBy(xpath = "(//div[@class='input-group']/input)[1]")
	WebElement input_Search;

	@FindBy(xpath = "(//div[@class='input-group']/input)[2]")
	WebElement input_Search_MonthDayWise;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxStudentAttendanceReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentAttendanceReportStudentList;

	@FindBy(xpath = "//span[contains(text(),'Name')]/preceding-sibling::input")
	WebElement rdBtn_Name;

	@FindBy(xpath = "//span[contains(text(),'Adm. No.')]/preceding-sibling::input")
	WebElement rdBtn_AdmNo;

	public Student_Attendance_Report(WebDriver driver) {
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
	 * Navigate to Admission > Reports > Student Attendance reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_StudentAttendanceReport_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_StuAttendanceReport);
		log("Clicked on Student attendance reports Button and object is:-" + btnReports_StuAttendanceReport.toString());
	}

	/**
	 * Validation of Admission > Reports > Student attendance reports screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Reports_StudentAttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_StuAttendanceReportMsgDispaly.getText());
			txtReports_StuAttendanceReportMsgDispaly.isDisplayed();
			log("Student attendance Report page is dispalyed and object is:-"
					+ txtReports_StuAttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_StudentAttendanceReportForm() throws Exception {

		clickOnButton(btn_Report);
		log("Submit blank Student attendance Report form and object is:-" + btn_Report.toString());
		Thread.sleep(1000);

	}

	public void fillWithStudentAttendanceReportDetailsFor_All_Monthly(String academicYr, String rep_class,
			String section, String month) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Monthly);
		if (!rdBtn_Monthly.isSelected()) {
			rdBtn_Monthly.click();
			log("Monthly radio button is selected and object is:-" + rdBtn_Monthly.toString());
			Thread.sleep(1000);
		} else {
			log("Monthly radio button is already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		selectElementFromDropDown(sel_Month, month);
		log("selected Month: " + month + " and object is:- " + sel_Month.toString());

	}

	public void select_MonthDateWise_CheckBox() throws Exception {
		isDisplayed(chk_MonthDayWise);
		if (!chk_MonthDayWise.isSelected()) {
			chk_MonthDayWise.click();
			log("Month DayWise check box is checked and object is:-" + chk_MonthDayWise.toString());
			Thread.sleep(1000);
		} else {
			log("Month DayWise check box is already checked (OR) Select all check box element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnReport() throws Exception {

		clickOnButton(btn_Report);
		log("Click on report button to get student data and object is:-" + btn_Report.toString());
		Thread.sleep(1000);

	}

	public void searchStudentToGenerateReport(String admissionNum) throws Exception {

		inputTextIntoInputField(input_Search, admissionNum);
		log("Entered Admission Number to search: " + admissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudent_ForStudentAttendanceReportInGrid(String admissionNum) {
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
					log("Student available for Student attendance Report.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentForStudentAttendanceReport(String admissionNum) {
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
					log("Corresponding student check box is checked for student attendance Report.");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchStudentToGenerateReport_MonthDayWise(String admissionNum) throws Exception {

		inputTextIntoInputField(input_Search_MonthDayWise, admissionNum);
		log("Entered Admission Number to search: " + admissionNum + " and object is:-"
				+ input_Search_MonthDayWise.toString());

	}

	public void verifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise(String admissionNum) {
		int rows = tblRows_MonthDayWise.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(admissionNum)) {
					Assert.assertEquals(admNumber, admissionNum);
					log("Student available for Student attendance Report.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentForStudentAttendanceReport_MonthDayWise(String admissionNum) {
		int rows = tblRows_MonthDayWise.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(admissionNum)) {
					Assert.assertEquals(admNumber, admissionNum);
					driver.findElement(
							By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
							.click();
					log("Corresponding student check box is checked for student attendance Report.");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeStudentAttendanceReport() throws Exception {

		clickOnButton(btnMin_MaxStudentAttendanceReport);
		log("Student attendance Report page minimized and object is:-" + btnMin_MaxStudentAttendanceReport.toString());

	}

	public void maximizeStudentAttendanceReport() throws Exception {

		clickOnButton(btnMin_MaxStudentAttendanceReport);
		log("Student attendance Report page maximized and object is:-" + btnMin_MaxStudentAttendanceReport.toString());

	}

	public void minimizeStudentAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxStudentAttendanceReportStudentList);
		log("Student attendance Report Student List page minimized and object is:-"
				+ btnMin_MaxStudentAttendanceReportStudentList.toString());

	}

	public void maximizeStudentAttendanceReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxStudentAttendanceReportStudentList);
		log("Student attendance Report Student List page maximized and object is:-"
				+ btnMin_MaxStudentAttendanceReportStudentList.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btn_Cancel);
		log("Click on Cancel button and object is:-" + btn_Cancel.toString());

	}

	public void clickOnExportToExcel() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("Export To Excel Report button is clicked to generate report and object is:-"
				+ btn_ExportToExcel.toString());

	}

	public void clickOnPrint() throws Exception {

		String parentWin = driver.getWindowHandle();

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
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

	public void fillWithStudentAttendanceReportDetailsFor_All_BetweenDate(String academicYr, String rep_class,
			String section) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDate);
		if (!rdBtn_BetweenDate.isSelected()) {
			rdBtn_BetweenDate.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDate.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendars_FromDate);
		Thread.sleep(500);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_FromDate2);
//		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_FromDate);
		Thread.sleep(500);
		btn_Date_FromDate.click();
		log("From Date selected to generate student attendance report.");

		clickOnButton(btnCalendars_ToDate);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_ToDate);
		Thread.sleep(500);
		btn_Date_ToDate.click();
		log("To Date selected to generate student attendance report.");

	}

	public void fillWithStudentAttendanceReportDetailsFor_All_Daily(String academicYr, String rep_class, String section)
			throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_StuAttendanceReportMsgDispaly);
		Thread.sleep(1000);
		
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Daily);
		if (!rdBtn_Daily.isSelected()) {
			rdBtn_Daily.click();
			log("Daily Date radio button is selected and object is:-" + rdBtn_Daily.toString());
			Thread.sleep(1000);
		} else {
			log("Daily Date radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendars_Daily);
		Thread.sleep(500);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_Daily2);
//		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_Daily);
		Thread.sleep(500);
		btn_Date_Daily.click();
		log("Daily Date selected to generate student attendance report.");

	}

	public void fillWithStudentAttendanceReportDetailsFor_Individual_Monthly(String academicYr, String rep_class,
			String section, String studentName, String month) throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_StuAttendanceReportMsgDispaly);
		Thread.sleep(1000);
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("All radio button is selected and object is:-" + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected.");
			Thread.sleep(500);
		}
		
		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_Name);
		if (!rdBtn_Name.isSelected()) {
			rdBtn_Name.click();
			log("Name radio button is selected and object is:-" + rdBtn_Name.toString());
			Thread.sleep(1000);
		} else {
			log("Name radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Monthly);
		if (!rdBtn_Monthly.isSelected()) {
			rdBtn_Monthly.click();
			log("Monthly radio button is selected and object is:-" + rdBtn_Monthly.toString());
			Thread.sleep(1000);
		} else {
			log("Monthly radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}

		
		selectElementFromDropDown(sel_StudentName, studentName);
		log("selected Student: " + studentName + " and object is:- " + sel_Section.toString());

		selectElementFromDropDown(sel_Month, month);
		log("selected Month: " + month + " and object is:- " + sel_Month.toString());

	}

	public void fillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate(String academicYr, String rep_class,
			String section, String studentName) throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_StuAttendanceReportMsgDispaly);
		Thread.sleep(1000);
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("All radio button is selected and object is:-" + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected.");
			Thread.sleep(500);
		}
		

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_Name);
		if (!rdBtn_Name.isSelected()) {
			rdBtn_Name.click();
			log("Name radio button is selected and object is:-" + rdBtn_Name.toString());
			Thread.sleep(1000);
		} else {
			log("Name radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDate);
		if (!rdBtn_BetweenDate.isSelected()) {
			rdBtn_BetweenDate.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDate.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		
		selectElementFromDropDown(sel_StudentName, studentName);
		log("selected Student: " + studentName + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendars_FromDate);
		Thread.sleep(500);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_FromDate2);
//		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_FromDate);
		Thread.sleep(500);
		btn_Date_FromDate.click();
		log("From Date selected to generate student attendance report.");

		clickOnButton(btnCalendars_ToDate);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_ToDate);
		Thread.sleep(500);
		btn_Date_ToDate.click();
		log("To Date selected to generate student attendance report.");

	}

	public void fillWithStudentAttendanceReportDetailsFor_Individual_Daily(String academicYr, String rep_class,
			String section, String studentName) throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_StuAttendanceReportMsgDispaly);
		Thread.sleep(1000);
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("All radio button is selected and object is:-" + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected.");
			Thread.sleep(500);
		}
		

		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, rep_class);
		log("selected class: " + rep_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_Name);
		if (!rdBtn_Name.isSelected()) {
			rdBtn_Name.click();
			log("Name radio button is selected and object is:-" + rdBtn_Name.toString());
			Thread.sleep(1000);
		} else {
			log("Name radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Daily);
		if (!rdBtn_Daily.isSelected()) {
			rdBtn_Daily.click();
			log("Daily radio button is selected and object is:-" + rdBtn_Daily.toString());
			Thread.sleep(1000);
		} else {
			log("Daily radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
		
		selectElementFromDropDown(sel_StudentName, studentName);
		log("selected Student: " + studentName + " and object is:- " + sel_Section.toString());

		clickOnButton(btnCalendars_Daily);
		Thread.sleep(500);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_Daily2);
//		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_Daily);
		Thread.sleep(500);
		btn_Date_Daily.click();
		log("Daily selected to generate student attendance report.");

	}

}
