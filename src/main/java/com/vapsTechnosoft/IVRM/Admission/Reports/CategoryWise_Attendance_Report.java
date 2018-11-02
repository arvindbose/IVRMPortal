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
 * @author vaps This Script will work for staff login credentials
 *         Username:Priya, Password: password@123
 * 
 */
public class CategoryWise_Attendance_Report extends TestBase {
	public static final Logger log = Logger.getLogger(CategoryWise_Attendance_Report.class.getName());

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
	// WebElement btnReports_CategoryWise_AttendanceReport;

	@FindBy(xpath = "//a[@href='#/app/CategoryWiseAttendance/168']")
	WebElement btnReports_CategoryWise_AttendanceReport;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_CategoryWise_AttendanceReportMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

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
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxCategoryWise_AttendanceReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxCategoryWise_AttendanceReportCategoryList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//table[@id='table1']/tbody/tr[1]/td[9]")
	WebElement total_PresentStudent;

	@FindBy(xpath = "//table[@id='table1']/tbody/tr[1]/td[12]")
	WebElement total_AbsentStudent;

	@FindBy(xpath = "//table[@id='table1']/tbody/tr[1]/td[6]")
	WebElement total_Student;

	public CategoryWise_Attendance_Report(WebDriver driver) {
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
	 * Navigate to Admission > Reports > CategoryWise attendance reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_CategoryWise_AttendanceReport);
		log("Clicked on CategoryWise Attendance reports Button and object is:-"
				+ btnReports_CategoryWise_AttendanceReport.toString());

	}

	/**
	 * Validation of Admission > Reports > CategoryWise attendance reports
	 * screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage() {
		try {
			System.out.println(txtReports_CategoryWise_AttendanceReportMsgDispaly.getText());
			txtReports_CategoryWise_AttendanceReportMsgDispaly.isDisplayed();
			log("Category Wise Attendance Report page is dispalyed and object is:-"
					+ txtReports_CategoryWise_AttendanceReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void exportReport_WithoutSelectingRecords() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("Without selecting records click on Excel Button and object is:-" + btn_ExportToExcel.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void fill_CategoryWise_AttendanceReportForm(String academicYear) throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected academic yaer: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

		clickOnButton(btnCalendar_Date);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear2);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(500);
		btn_Date.click();
		log("Attendance date is selected from calender.");

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
		Thread.sleep(1000);
	}

	public void minimize_CategoryWise_AttendanceReport() throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_CategoryWise_AttendanceReportMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxCategoryWise_AttendanceReport);
		log("Category Wise attendance Report page minimized and object is:-"
				+ btnMin_MaxCategoryWise_AttendanceReport.toString());

	}

	public void maximize_CategoryWise_AttendanceReport() throws Exception {

		clickOnButton(btnMin_MaxCategoryWise_AttendanceReport);
		log("Category Wise attendance Report page maximized and object is:-"
				+ btnMin_MaxCategoryWise_AttendanceReport.toString());

	}

	public void minimize_CategoryWise_AttendanceReportCategoryList() throws Exception {

		clickOnButton(btnMin_MaxCategoryWise_AttendanceReportCategoryList);
		log("Category Wise attendance Report Student List page minimized and object is:-"
				+ btnMin_MaxCategoryWise_AttendanceReportCategoryList.toString());

	}

	public void maximize_CategoryWise_AttendanceReportCategoryList() throws Exception {

		clickOnButton(btnMin_MaxCategoryWise_AttendanceReportCategoryList);
		log("Category Wise attendance Report Student List page maximized and object is:-"
				+ btnMin_MaxCategoryWise_AttendanceReportCategoryList.toString());

	}

	public void searchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid(String categoryName)
			throws Exception {

		inputTextIntoInputField(input_Search, categoryName);
		log("Entered Category Name to search: " + categoryName + " and object is:-" + input_Search.toString());

	}

	public void verifyCategory_ForCategoryWiseAttendanceReportInGrid(String categoryName) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String category_name = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Category Name: " + category_name);
				// Thread.sleep(2000);
				if(category_name.equals(categoryName)){
				//Assert.assertEquals(category_name, categoryName);
				log("Category available for Category Wise attendance Report.");
				break;
		}	
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectCategoryFor_CategoryWiseAttendanceReport(String categoryName) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
				String category_name = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Category Name: " + category_name);
				// Thread.sleep(2000);
				if(category_name.equals(categoryName)){
				//Assert.assertEquals(category_name, categoryName);
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding Category check box is checked for Category Wise attendance Report.");
				Thread.sleep(1000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateTotalStudentInACategory() throws Exception {
		isDisplayed(total_PresentStudent);
		String numberPresentStudent = total_PresentStudent.getText();
		int presentStudent = Integer.parseInt(numberPresentStudent);
		System.out.println("Present Student: " + presentStudent);
		isDisplayed(total_AbsentStudent);
		String numberAbsentStudent = total_AbsentStudent.getText();
		int absentStudent = Integer.parseInt(numberAbsentStudent);
		System.out.println("Absent Student: " + absentStudent);
		isDisplayed(total_Student);
		String numberStudent = total_Student.getText();
		int students = Integer.parseInt(numberStudent);
		System.out.println((presentStudent + absentStudent));
		Assert.assertEquals((presentStudent + absentStudent), students);
		log("Sum of Boys and Girls in a category is equal to number of students in that category.");
		Thread.sleep(2000);

	}
}
