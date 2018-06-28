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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[19]")
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

	@FindBy(xpath = "//span[contains(text(),'Class')]/preceding-sibling::input")
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
			Thread.sleep(10000);
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
		if (btnReports_ClassWiseDetails.isDisplayed()) {
			btnReports_ClassWiseDetails.click();
			log("Clicked on Class Wise Details reports Button and object is:-"
					+ btnReports_ClassWiseDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise Details button element not present.");
			Thread.sleep(500);
		}

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
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank ClassWise Details Report form and object is:-" + btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillClassWiseDetailsReport_Form_ForNewAdmission(String academicYear, String Class_CWD, String Section)
			throws Exception {

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			Thread.sleep(1000);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_CWD);

			log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_CWD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(Section);

			log("selected Section: " + Section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_NewAdmission.isSelected()) {
			rdBtn_NewAdmission.click();
			log("New Admission radio button is selected and object is:- " + rdBtn_NewAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("New Admission Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
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

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_CWD);

			log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_CWD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(Section);

			log("selected Section: " + Section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_TotalStudents.isSelected()) {
			rdBtn_TotalStudents.click();
			log("Total Student radio button is selected and object is:- " + rdBtn_TotalStudents.toString());
			Thread.sleep(1000);
		} else {
			log("Total Student Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
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

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_CWD);

			log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_CWD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(Section);

			log("selected Section: " + Section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Promoted.isSelected()) {
			rdBtn_Promoted.click();
			log("Promoted radio button is selected and object is:- " + rdBtn_Promoted.toString());
			Thread.sleep(1000);
		} else {
			log("Promoted Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
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

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_CWD);

			log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_CWD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(Section);

			log("selected Section: " + Section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_YearLoss.isSelected()) {
			rdBtn_YearLoss.click();
			log("Year Loss radio button is selected and object is:- " + rdBtn_YearLoss.toString());
			Thread.sleep(1000);
		} else {
			log("Year Loss Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
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

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(Class_CWD);

			log("selected Class: " + Class_CWD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Class_CWD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(Section);

			log("selected Section: " + Section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Deactivated.isSelected()) {
			rdBtn_Deactivated.click();
			log("Deactivated radio button is selected and object is:- " + rdBtn_Deactivated.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivated Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_StudentName.isSelected()) {
			chk_StudentName.click();
			log("Student Name check box is checked and object is:- " + chk_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Gender.isSelected()) {
			chk_Gender.click();
			log("Gender check box is checked and object is:- " + chk_Gender.toString());
			Thread.sleep(1000);
		} else {
			log("Gender check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_AdmNo.isSelected()) {
			chk_AdmNo.click();
			log("Admission Number check box is checked and object is:- " + chk_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("Admission Number check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:- " + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box already selected.");
			Thread.sleep(500);
		}
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
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("ClassWise Student Details Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("ClassWise Student Details Report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(5000);
		} else {
			log("Export to Excel button element not present.");
			Thread.sleep(500);
		}
	}
	
	public void clickOnPrintButton() throws Exception{
		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

		} else {
			log("Print button element is not present.");
			Thread.sleep(500);
		}
	}
	
	public void clickOnPrint_ForPrintPreview() throws Exception {

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

	public void min_Max_ClassWiseStudentDetailsReport_Form() throws Exception {
		if (btnMin_MaxClasswiseDetailsReportForm.isDisplayed()) {
			btnMin_MaxClasswiseDetailsReportForm.click();
			log("ClassWise Student Details Report page minimized or maximized and object is:-"
					+ btnMin_MaxClasswiseDetailsReportForm.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Student Details Report Minimized Element not present.");
		}
	}

	public void min_Max_ClassWiseStudentDetailsReport_Grid() throws Exception {
		if (btnMin_MaxClasswiseDetailsReportGrid.isDisplayed()) {
			btnMin_MaxClasswiseDetailsReportGrid.click();
			log("ClassWise Student Details Report page minimized or maximized and object is:-"
					+ btnMin_MaxClasswiseDetailsReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("ClassWise Student Details Report grid Minimized Element not present.");
		}
	}

	public void searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(String admissionNum) throws Exception {
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
	public void verifyStudent_ForClassWiseStudentDetailsReportInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admNumber, admissionNum);
				log("Student available for Classwise Student details Report.");

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
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/div/table/tbody/tr[" + i + "]/td[1]/label/input"))
						.click();
				log("Corresponding student check box is checked for ClassWise Student Details Report.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
}
