/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Reports;

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

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Admission_Register_Report extends TestBase {

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[3]")
	WebElement btnReports_AdmissionRegister;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_AdmissionRegisterReportMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'All')]")
	WebElement rdBtn_ALL;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Present')]")
	WebElement rdBtn_Present;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Left')]")
	WebElement rdBtn_Left;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Deactive')]")
	WebElement rdBtn_DeActive;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'New Admission')]")
	WebElement rdBtn_NewAdmission;

	@FindBy(xpath = "(//span[contains(text(),'Select All ')])[1]")
	WebElement chk_SelAllClass;

	@FindBy(xpath = "(//span[contains(text(),'Select All ')])[2]")
	WebElement chk_SelAll_StudentDetails;

	@FindBy(xpath = "//span[contains(text(),'PN')]")
	WebElement chk_PN;

	@FindBy(xpath = "//span[contains(text(),'First Name')]")
	WebElement chk_FirstName;

	@FindBy(xpath = "//span[contains(text(),'Middle Name')]")
	WebElement chk_MiddleName;

	@FindBy(xpath = "//span[contains(text(),'Last Name')]")
	WebElement chk_LastName;

	@FindBy(xpath = "//span[contains(text(),'Adm No')]")
	WebElement chk_AdmNumber;

	@FindBy(xpath = "//span[contains(text(),'Registration No')]")
	WebElement chk_RegNumber;

	@FindBy(xpath = "(//div[@class='text-center'])[2]/button[1]")
	WebElement btn_Reports;

	@FindBy(xpath = "(//div[@class='text-center'])[2]/button[2]")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "(//div[@class='text-center'])[2]/button[3]")
	WebElement btn_Print;

	@FindBy(xpath = "(//div[@class='text-center'])[2]/button[4]")
	WebElement btn_Cancel;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxAdmissionRegisterReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxAdmissionRegisterReportStudentList;

	public Admission_Register_Report(WebDriver driver) {
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
	 * Navigate to Admission > Reports > Admission Register reports
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_AdmissionRegisterReport_BGHS() throws Exception {
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
		if (btnReports_AdmissionRegister.isDisplayed()) {
			btnReports_AdmissionRegister.click();
			log("Clicked on Admission Register reports Button and object is:-"
					+ btnReports_AdmissionRegister.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Register reports button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Admission > Reports > Admission Register reports screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmissionReports_AdmissionRegisterReport_BGHSPage() {
		try {
			System.out.println(txtReports_AdmissionRegisterReportMsgDispaly.getText());
			txtReports_AdmissionRegisterReportMsgDispaly.isDisplayed();
			log("Admission Register Report page is dispalyed and object is:-"
					+ txtReports_AdmissionRegisterReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_AdmissionRegisterReportForm() throws Exception {
		if (btn_Reports.isDisplayed()) {
			btn_Reports.click();
			log("Submit blank Admission Register Report form and object is:-" + btn_Reports.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void selectAcademicYearForAdmissionRegister(String academicYear) throws Exception {

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void select_All_RadioButton() throws Exception {
		if ((rdBtn_ALL.isDisplayed()) && (!rdBtn_ALL.isSelected())) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_Present_RadioButton() throws Exception {
		if ((rdBtn_Present.isDisplayed()) && (!rdBtn_Present.isSelected())) {
			rdBtn_Present.click();
			log("Present radio button is selected and object is:-" + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present radio button is already selected (OR) Present radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_Left_RadioButton() throws Exception {
		if ((rdBtn_Left.isDisplayed()) && (!rdBtn_Left.isSelected())) {
			rdBtn_Left.click();
			log("Left radio button is selected and object is:-" + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left radio button is already selected (OR) Left radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActive_RadioButton() throws Exception {
		if ((rdBtn_DeActive.isDisplayed()) && (!rdBtn_DeActive.isSelected())) {
			rdBtn_DeActive.click();
			log("DeActive radio button is selected and object is:-" + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive radio button is already selected (OR) DeActive radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_NewAdmission_RadioButton() throws Exception {
		if ((rdBtn_NewAdmission.isDisplayed()) && (!rdBtn_NewAdmission.isSelected())) {
			rdBtn_NewAdmission.click();
			log("New Admission radio button is selected and object is:-" + rdBtn_NewAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("New Admission radio button is already selected (OR) New Admission radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void selectAll_ClassCheckBox() throws Exception {
		if ((chk_SelAllClass.isDisplayed()) && (!chk_SelAllClass.isSelected())) {
			chk_SelAllClass.click();
			log("Select all class check box is checked and object is:-" + chk_SelAllClass.toString());
			Thread.sleep(1000);
		} else {
			log("Select all class check box is already checked (OR) Select all check box element not present.");
			Thread.sleep(500);
		}
	}

	public void selectAll_StudentdetailsCheckBox() throws Exception {
		if ((chk_SelAll_StudentDetails.isDisplayed()) && (!chk_SelAll_StudentDetails.isSelected())) {
			chk_SelAll_StudentDetails.click();
			log("Select all Student details check box is checked and object is:-"
					+ chk_SelAll_StudentDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Select all Student details check box is already checked (OR) Select all check box element not present.");
			Thread.sleep(500);
		}
	}

	public void selectClass_ForAdmissionRegisterReport() throws Exception {
		if ((chk_PN.isDisplayed()) && (!chk_PN.isSelected())) {
			chk_PN.click();
			log("Selected class check box is checked and object is:-" + chk_PN.toString());
			Thread.sleep(1000);
		} else {
			log("Select class check box is already checked (OR) Select class check box element not present.");
			Thread.sleep(500);
		}
	}

	public void selectStudentDetailsData() throws Exception {
		if ((chk_FirstName.isDisplayed()) && (!chk_FirstName.isSelected())) {
			chk_FirstName.click();
			log("Selected First Name check box is checked and object is:-" + chk_FirstName.toString());
			Thread.sleep(1000);
		} else {
			log("Select First Name check box is already checked (OR) Select First Name check box element not present.");
			Thread.sleep(500);
		}
		if ((chk_MiddleName.isDisplayed()) && (!chk_MiddleName.isSelected())) {
			chk_MiddleName.click();
			log("Selected Midle Name check box is checked and object is:-" + chk_MiddleName.toString());
			Thread.sleep(1000);
		} else {
			log("Select Midle Name check box is already checked (OR) Select Midle Name check box element not present.");
			Thread.sleep(500);
		}
		if ((chk_LastName.isDisplayed()) && (!chk_LastName.isSelected())) {
			chk_LastName.click();
			log("Selected Last Name check box is checked and object is:-" + chk_LastName.toString());
			Thread.sleep(1000);
		} else {
			log("Select Last Name check box is already checked (OR) Select Last Name check box element not present.");
			Thread.sleep(500);
		}
		if ((chk_AdmNumber.isDisplayed()) && (!chk_AdmNumber.isSelected())) {
			chk_AdmNumber.click();
			log("Selected Admission number check box is checked and object is:-" + chk_AdmNumber.toString());
			Thread.sleep(1000);
		} else {
			log("Select Admission number check box is already checked (OR) Select Admission number check box element not present.");
			Thread.sleep(500);
		}
		if ((chk_RegNumber.isDisplayed()) && (!chk_RegNumber.isSelected())) {
			chk_RegNumber.click();
			log("Selected Registration number check box is checked and object is:-"
					+ chk_RegNumber.getText().toString());
			Thread.sleep(1000);
		} else {
			log("Select Registration number check box is already checked (OR) Select Registration number check box element not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithAdmissionNumber_AdmissionRegisterReportStudentList(String admissionNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(admissionNum);
			log("Entered Admission number to search: " + admissionNum + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudent_ForAdmissionRegisterReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admNumber, admissionNum);
				log("Student available for Admission Register Report.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudentForAdmissionRegisterReport(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver
					.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding student check box is checked for Admission Register Report.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOnReport() throws Exception {
		if (btn_Reports.isDisplayed()) {
			btn_Reports.click();
			log("Report button is clicked to generate report and object is:-" + btn_Reports.toString());
			Thread.sleep(10000);
		} else {
			log("Report button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnExportToExcel() throws Exception {
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("Export To Excel Report button is clicked to generate report and object is:-"
					+ btn_ExportToExcel.toString());
			Thread.sleep(10000);
		} else {
			log("Export To Excel button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnPrint() throws Exception {

		String parentWin = driver.getWindowHandle();

		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
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

	public void clickOnCancel() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Cancel button is clicked and object is:-" + btn_Cancel.toString());
			Thread.sleep(10000);
		} else {
			log("Cancel button element is not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAdmissionRegisterReport() throws Exception {
		if (btnMin_MaxAdmissionRegisterReport.isDisplayed()) {
			btnMin_MaxAdmissionRegisterReport.click();
			log("Admission Register Report page minimized and object is:-"
					+ btnMin_MaxAdmissionRegisterReport.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Register Report Minimized Element not present.");
		}
	}

	public void maximizeAdmissionRegisterReport() throws Exception {
		if (btnMin_MaxAdmissionRegisterReport.isDisplayed()) {
			btnMin_MaxAdmissionRegisterReport.click();
			log("Admission Register Report page maximized and object is:-"
					+ btnMin_MaxAdmissionRegisterReport.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Register Report Maximize Element not present.");
		}
	}

	public void minimizeAdmissionRegisterReportStudentList() throws Exception {
		if (btnMin_MaxAdmissionRegisterReportStudentList.isDisplayed()) {
			btnMin_MaxAdmissionRegisterReportStudentList.click();
			log("Admission Register Report Student List page minimized and object is:-"
					+ btnMin_MaxAdmissionRegisterReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Register Report Student List Minimized Element not present.");
		}
	}

	public void maximizeAdmissionRegisterReportStudentList() throws Exception {
		if (btnMin_MaxAdmissionRegisterReportStudentList.isDisplayed()) {
			btnMin_MaxAdmissionRegisterReportStudentList.click();
			log("Admission Register Report Student List page maximized and object is:-"
					+ btnMin_MaxAdmissionRegisterReportStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Register Report Student List Maximize Element not present.");
		}
	}

}
