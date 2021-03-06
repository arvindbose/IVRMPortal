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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[3]")
	// WebElement btnReports_AdmissionRegister;

	@FindBy(xpath = "//a[@href='#/app/AdmissionRegister/77']")
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

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btn_Reports;

	@FindBy(xpath = "//div[@id='gridlst']/div[1]/a[1]")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@id='gridlst']/div[1]/a[2]")
	WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
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
			Thread.sleep(2000);
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
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_AdmissionRegister);
		log("Clicked on Admission Register reports Button and object is:-" + btnReports_AdmissionRegister.toString());

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

		clickOnButton(btn_Reports);
		log("Submit blank Admission Register Report form and object is:-" + btn_Reports.toString());

	}

	public void selectAcademicYearForAdmissionRegister(String academicYear) throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

	}

	public void select_All_RadioButton() throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("All radio button is selected and object is:-" + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All radio button is already selected (OR) all radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_Present_RadioButton() throws Exception {
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Present radio button is selected and object is:-" + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present radio button is already selected (OR) Present radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_Left_RadioButton() throws Exception {
		isDisplayed(rdBtn_Left);
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left radio button is selected and object is:-" + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left radio button is already selected (OR) Left radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActive_RadioButton() throws Exception {
		isDisplayed(rdBtn_DeActive);
		if (!rdBtn_DeActive.isSelected()) {
			rdBtn_DeActive.click();
			log("DeActive radio button is selected and object is:-" + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive radio button is already selected (OR) DeActive radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void select_NewAdmission_RadioButton() throws Exception {
		isDisplayed(rdBtn_NewAdmission);
		if (!rdBtn_NewAdmission.isSelected()) {
			rdBtn_NewAdmission.click();
			log("New Admission radio button is selected and object is:-" + rdBtn_NewAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("New Admission radio button is already selected (OR) New Admission radio button element not present.");
			Thread.sleep(500);
		}
	}

	public void selectAll_ClassCheckBox() throws Exception {
		isDisplayed(chk_SelAllClass);
		if (!chk_SelAllClass.isSelected()) {
			chk_SelAllClass.click();
			log("Select all class check box is checked and object is:-" + chk_SelAllClass.toString());
			Thread.sleep(1000);
		} else {
			log("Select all class check box is already checked (OR) Select all check box element not present.");
			Thread.sleep(500);
		}
	}

	public void selectAll_StudentdetailsCheckBox() throws Exception {
		isDisplayed(chk_SelAll_StudentDetails);
		if (!chk_SelAll_StudentDetails.isSelected()) {
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
		isDisplayed(chk_PN);
		if (!chk_PN.isSelected()) {
			chk_PN.click();
			log("Selected class check box is checked and object is:-" + chk_PN.toString());
			Thread.sleep(1000);
		} else {
			log("Select class check box is already checked (OR) Select class check box element not present.");
			Thread.sleep(500);
		}
	}

	public void selectStudentDetailsData() throws Exception {
		isDisplayed(chk_FirstName);
		if (!chk_FirstName.isSelected()) {
			chk_FirstName.click();
			log("Selected First Name check box is checked and object is:-" + chk_FirstName.toString());
			Thread.sleep(1000);
		} else {
			log("Select First Name check box is already checked (OR) Select First Name check box element not present.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MiddleName);
		if (!chk_MiddleName.isSelected()) {
			chk_MiddleName.click();
			log("Selected Midle Name check box is checked and object is:-" + chk_MiddleName.toString());
			Thread.sleep(1000);
		} else {
			log("Select Midle Name check box is already checked (OR) Select Midle Name check box element not present.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MiddleName);
		if (!chk_LastName.isSelected()) {
			chk_LastName.click();
			log("Selected Last Name check box is checked and object is:-" + chk_LastName.toString());
			Thread.sleep(1000);
		} else {
			log("Select Last Name check box is already checked (OR) Select Last Name check box element not present.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MiddleName);
		if (!chk_AdmNumber.isSelected()) {
			chk_AdmNumber.click();
			log("Selected Admission number check box is checked and object is:-" + chk_AdmNumber.toString());
			Thread.sleep(1000);
		} else {
			log("Select Admission number check box is already checked (OR) Select Admission number check box element not present.");
			Thread.sleep(500);
		}
		isDisplayed(chk_MiddleName);
		if (!chk_RegNumber.isSelected()) {
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

		inputTextIntoInputField(input_Search, admissionNum);
		log("Entered Admission number to search: " + admissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudent_ForAdmissionRegisterReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				if (admNumber.equals(admissionNum)) {
					//Assert.assertEquals(admNumber, admissionNum);
					log("Student available for Admission Register Report.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentForAdmissionRegisterReport(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(admissionNum)) {
				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding student check box is checked for Admission Register Report.");
				Thread.sleep(1000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnReport() throws Exception {

		clickOnButton(btn_Reports);
		log("Report button is clicked to generate report and object is:-" + btn_Reports.toString());
		Thread.sleep(2000L);
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

		clickOnButton(btn_Cancel);
		log("Cancel button is clicked and object is:-" + btn_Cancel.toString());

	}

	public void minimizeAdmissionRegisterReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_AdmissionRegisterReportMsgDispaly);
		Thread.sleep(1000);
		clickOnButton(btnMin_MaxAdmissionRegisterReport);
		log("Admission Register Report page minimized and object is:-" + btnMin_MaxAdmissionRegisterReport.toString());

	}

	public void maximizeAdmissionRegisterReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_AdmissionRegisterReportMsgDispaly);
		Thread.sleep(1000);
		clickOnButton(btnMin_MaxAdmissionRegisterReport);
		log("Admission Register Report page maximized and object is:-" + btnMin_MaxAdmissionRegisterReport.toString());

	}

	public void minimizeAdmissionRegisterReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxAdmissionRegisterReportStudentList);
		log("Admission Register Report Student List page minimized and object is:-"
				+ btnMin_MaxAdmissionRegisterReportStudentList.toString());

	}

	public void maximizeAdmissionRegisterReportStudentList() throws Exception {

		clickOnButton(btnMin_MaxAdmissionRegisterReportStudentList);
		log("Admission Register Report Student List page maximized and object is:-"
				+ btnMin_MaxAdmissionRegisterReportStudentList.toString());

	}

}
