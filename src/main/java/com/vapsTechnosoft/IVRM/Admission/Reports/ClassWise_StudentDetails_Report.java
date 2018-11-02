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
 * @author Arvind
 *
 */
public class ClassWise_StudentDetails_Report extends TestBase {

	public static final Logger log = Logger.getLogger(ClassWise_StudentDetails_Report.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[19]")
	// WebElement btnReports_ClassWiseDetails;

	@FindBy(xpath = "//a[@href='#/app/classwisestudentdetails/169']")
	WebElement btnReports_ClassWiseDetails;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_ClassWiseDetailsReportMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//span[contains(text(),'New Admission')]/preceding-sibling::input")
	WebElement rdBtn_NewAdmission;

	@FindBy(xpath = "//span[contains(text(),'Total Students')]/preceding-sibling::input")
	WebElement rdBtn_TotalStudents;

	@FindBy(xpath = "//span[contains(text(),'Promoted')]/preceding-sibling::input")
	WebElement rdBtn_Promoted;

	@FindBy(xpath = "//span[contains(text(),'Year Loss')]/preceding-sibling::input")
	WebElement rdBtn_YearLoss;

	@FindBy(xpath = "//span[contains(text(),'Deactivated')]/preceding-sibling::input")
	WebElement rdBtn_Deactivated;

	@FindBy(xpath = "//span[contains(text(),'Student Name')]/preceding-sibling::input")
	WebElement chk_StudentName;

	@FindBy(xpath = "//span[contains(text(),'Gender')]/preceding-sibling::input")
	WebElement chk_Gender;

	@FindBy(xpath = "//span[contains(text(),'Student Photo')]/preceding-sibling::input")
	WebElement chk_StudentPhoto;

	@FindBy(xpath = "//span[contains(text(),'Adm. No.')]/preceding-sibling::input")
	WebElement chk_AdmNo;

	@FindBy(xpath = "//span[text()='Class']/preceding-sibling::input")
	WebElement chk_Class;

	@FindBy(xpath = "//span[contains(text(),'Section')]/preceding-sibling::input")
	WebElement chk_Section;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export To Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxClasswiseDetailsReportForm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxClasswiseDetailsReportGrid;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement btnOKSuccess;

	public ClassWise_StudentDetails_Report(WebDriver driver) {
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
	 * Navigate to Admission > Reports > ClassWise Details
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_ClassWiseDetailsReport() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_ClassWiseDetails);
		log("Clicked on Class Wise Details reports Button and object is:-" + btnReports_ClassWiseDetails.toString());

	}

	/**
	 * Validation of Admission > Reports > Class Wise Details Report screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmissionReports_ClassWiseDetailsReport_BGHSPage() {
		try {
			System.out.println(txtReports_ClassWiseDetailsReportMsgDispaly.getText());
			txtReports_ClassWiseDetailsReportMsgDispaly.isDisplayed();
			log("Total Strength Report page is dispalyed and object is:-"
					+ txtReports_ClassWiseDetailsReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_ClassWiseDetailsReportForm() throws Exception {

		clickOnButton(btn_Report);
		log("Submit blank ClassWise Details Report form and object is:-" + btn_Report.toString());

	}

	public void fillClassWiseDetailsReport_Form_ForNewAdmission(String academicYear, String Class_CWD, String Section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, Class_CWD);
		log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, Section);
		log("selected Section: " + Section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_NewAdmission);
		if (!rdBtn_NewAdmission.isSelected()) {
			rdBtn_NewAdmission.click();
			log("New Admission radio button is selected and object is:- " + rdBtn_NewAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("New Admission Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentName);
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Gender);
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_AdmNo);
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentPhoto);
		if (!chk_StudentPhoto.isSelected()) {
			chk_StudentPhoto.click();
			log("Student Photo check box is checked and object is:- " + chk_StudentPhoto.toString());
			Thread.sleep(1000);
		} else {
			log("Student Photo check box already selected.");
			Thread.sleep(500);
		}
	}

	public void fillClassWiseDetailsReport_Form_ForTotalStudent(String academicYear, String Class_CWD, String Section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, Class_CWD);
		log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, Section);
		log("selected Section: " + Section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_TotalStudents);
		if (!rdBtn_TotalStudents.isSelected()) {
			rdBtn_TotalStudents.click();
			log("Total Student radio button is selected and object is:- " + rdBtn_TotalStudents.toString());
			Thread.sleep(1000);
		} else {
			log("Total Student Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentName);
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Gender);
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_AdmNo);
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentPhoto);
		if (!chk_StudentPhoto.isSelected()) {
			chk_StudentPhoto.click();
			log("Student Photo check box is checked and object is:- " + chk_StudentPhoto.toString());
			Thread.sleep(1000);
		} else {
			log("Student Photo check box already selected.");
			Thread.sleep(500);
		}
	}

	public void fillClassWiseDetailsReport_Form_ForPromoted(String academicYear, String Class_CWD, String Section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, Class_CWD);
		log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, Section);
		log("selected Section: " + Section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_Promoted);
		if (!rdBtn_Promoted.isSelected()) {
			rdBtn_Promoted.click();
			log("Promoted radio button is selected and object is:- " + rdBtn_Promoted.toString());
			Thread.sleep(1000);
		} else {
			log("Promoted Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentName);
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Gender);
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_AdmNo);
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentPhoto);
		if (!chk_StudentPhoto.isSelected()) {
			chk_StudentPhoto.click();
			log("Student Photo check box is checked and object is:- " + chk_StudentPhoto.toString());
			Thread.sleep(1000);
		} else {
			log("Student Photo check box already selected.");
			Thread.sleep(500);
		}
	}

	public void fillClassWiseDetailsReport_Form_ForYearLoss(String academicYear, String Class_CWD, String Section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, Class_CWD);
		log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, Section);
		log("selected Section: " + Section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_YearLoss);
		if (!rdBtn_YearLoss.isSelected()) {
			rdBtn_YearLoss.click();
			log("Year Loss radio button is selected and object is:- " + rdBtn_YearLoss.toString());
			Thread.sleep(1000);
		} else {
			log("Year Loss Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentName);
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Gender);
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_AdmNo);
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentPhoto);
		if (!chk_StudentPhoto.isSelected()) {
			chk_StudentPhoto.click();
			log("Student Photo check box is checked and object is:- " + chk_StudentPhoto.toString());
			Thread.sleep(1000);
		} else {
			log("Student Photo check box already selected.");
			Thread.sleep(500);
		}
	}

	public void fillClassWiseDetailsReport_Form_ForDeactivated(String academicYear, String Class_CWD, String Section)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, Class_CWD);
		log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, Section);
		log("selected Section: " + Section + " and object is:- " + sel_Section.toString());

		isDisplayed(rdBtn_Deactivated);
		if (!rdBtn_Deactivated.isSelected()) {
			rdBtn_Deactivated.click();
			log("Deactivated radio button is selected and object is:- " + rdBtn_Deactivated.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivated Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentName);
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Gender);
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_AdmNo);
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_StudentPhoto);
		if (!chk_StudentPhoto.isSelected()) {
			chk_StudentPhoto.click();
			log("Student Photo check box is checked and object is:- " + chk_StudentPhoto.toString());
			Thread.sleep(1000);
		} else {
			log("Student Photo check box already selected.");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_ClassWiseStudentDetailsReport() throws Exception {
		clickOnButton(btn_Report);
		log("ClassWise Student Details Report is generated and object is:-" + btn_Report.toString());
		Thread.sleep(1000);
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("ClassWise Student Details Report filled form data is cleared and object is:-" + btn_Cancel.toString());

	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());

	}

	public void clickOnPrintButton() throws Exception {

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report and object is:-" + btn_Print.toString());

	}

	public void clickOnPrint_ForPrintPreview() throws Exception {

		String parentWin = driver.getWindowHandle();

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
		Thread.sleep(1000);
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

	public void min_Max_ClassWiseStudentDetailsReport_Form() throws Exception {

		clickOnButton(btnMin_MaxClasswiseDetailsReportForm);
		log("ClassWise Student Details Report page minimized or maximized and object is:-"
				+ btnMin_MaxClasswiseDetailsReportForm.toString());

	}

	public void min_Max_ClassWiseStudentDetailsReport_Grid() throws Exception {

		clickOnButton(btnMin_MaxClasswiseDetailsReportGrid);
		log("ClassWise Student Details Report page minimized or maximized and object is:-"
				+ btnMin_MaxClasswiseDetailsReportGrid.toString());

	}

	public void searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(String admissionNum) throws Exception {

		inputTextIntoInputField(input_Search, admissionNum);
		log("Entered Admission number to search: " + admissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudent_ForClassWiseStudentDetailsReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]/span"))
						.getText().trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				Assert.assertEquals(admNumber, admissionNum);
				log("Student available for Classwise Student details Report.");
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudentForClassWiseStudentDetailsReport(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]/span"))
						.getText().trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding student check box is checked for ClassWise Student Details Report.");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}
}
