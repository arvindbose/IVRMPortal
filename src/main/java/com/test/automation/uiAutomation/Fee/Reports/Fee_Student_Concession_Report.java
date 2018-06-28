/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Reports;

import java.awt.Robot;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
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
public class Fee_Student_Concession_Report extends TestBase{

	public static final Logger log = Logger.getLogger(Fee_Student_Concession_Report.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[7]")
	WebElement btn_FeeStudentConcessionReport;

	@FindBy(xpath = "//div//section//ol//li")
	WebElement txt_FeeStudentConcessionReport;

	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	WebElement rdBtn_All;

	@FindBy(xpath = "//span[contains(text(),'Individual')]/preceding-sibling::input")
	WebElement rdBtn_Individual;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Concession Type:')]/following-sibling::div/select")
	WebElement Sel_ConcessionType;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]//following::div[1]//select")
	WebElement sel_Section;
	
	@FindBy(xpath = "//div[@class='multiselect']//label//input[@name='fee_ct1']")
	List<WebElement> Chk_CustomGroup;

	@FindBy(xpath = "//div[@class='multiselect col-sm-12']//label//input[@name='fee_gp1']")
	List<WebElement> Chk_FeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btn_Clear;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@class='input-group']//input")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxStudentConcessionReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxReportGridView;

	@FindBy(xpath = "//table[@id='Table'][2]//thead//tr//th[3]/a")
	WebElement btnSortByStudentName;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//table[@id='Table'][2]//tbody//tr//td[1]//input")
	List<WebElement> Chk_FeeDefaulterReportGrid;

	public Fee_Student_Concession_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee Student Concession Report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeStudentConcessionReport() throws Exception {
		if (btn_Fee.isDisplayed()) {
			btn_Fee.click();
			log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());
			Thread.sleep(1000);
		} else {
			log("Fee button element not present.");
			Thread.sleep(500);
		}
		if (btn_FeeReports.isDisplayed()) {
			btn_FeeReports.click();
			log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());
			Thread.sleep(1000);
		} else {
			log("Fee reports button element not present.");
			Thread.sleep(500);
		}
		if (btn_FeeStudentConcessionReport.isDisplayed()) {
			btn_FeeStudentConcessionReport.click();
			log("Clicked on Fee Student Concession Report Button in navigation panel and object is:-"
					+ btn_FeeStudentConcessionReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Student Concession Report button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Fee > Reports > Fee Student Concession Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeStudentConcessionReport_Page() {
		try {
			System.out.println(txt_FeeStudentConcessionReport.getText().trim());
			txt_FeeStudentConcessionReport.isDisplayed();
			log("Fee Student Concession Report page text is dispalyed and object is:-"
					+ txt_FeeStudentConcessionReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeStudentConcessionReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank Fee Student Concession Report form and object is:-" + btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Fee Student Concession, All 
	 * 
	 */
	public void fill_FeeStudentConcessionReportForm_rdBtnAll(String academicYear, String concession_Type)
			throws Exception {

		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("All radio button is selected and object is:- " + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		
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
		if (Sel_ConcessionType.isDisplayed()) {
			select = new Select(Sel_ConcessionType);
			select.selectByVisibleText(concession_Type);

			log("selected Concession type: " + concession_Type + " and object is:- " + Sel_ConcessionType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), concession_Type);
			Thread.sleep(1000);
		} else {
			log("Concession type element is not present");
			Thread.sleep(500);
		}
		int no_Of_CustomGroup = Chk_CustomGroup.size();
		for (int i = 0; i < no_Of_CustomGroup; i++) {
			if (!Chk_CustomGroup.get(i).isSelected()) {
				Chk_CustomGroup.get(i).click();
				log(i + " Custom Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Custom Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}

		int no_Of_FeeGroup = Chk_FeeGroup.size();
		for (int i = 0; i < no_Of_FeeGroup; i++) {
			if (!Chk_FeeGroup.get(i).isSelected()) {
				Chk_FeeGroup.get(i).click();
				log(i + " Fee Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Fee Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}
	}
	/*
	 * Generate report for Fee Student Concession, Individual 
	 * 
	 */
	public void fill_FeeStudentConcessionReportForm_rdBtnIndividual(String academicYear, String concession_Type, String select_class, String section)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		
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
		if (Sel_ConcessionType.isDisplayed()) {
			select = new Select(Sel_ConcessionType);
			select.selectByVisibleText(concession_Type);

			log("selected Concession type: " + concession_Type + " and object is:- " + Sel_ConcessionType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), concession_Type);
			Thread.sleep(1000);
		} else {
			log("Concession type element is not present");
			Thread.sleep(500);
		}
		
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}
		int no_Of_CustomGroup = Chk_CustomGroup.size();
		for (int i = 0; i < no_Of_CustomGroup; i++) {
			if (!Chk_CustomGroup.get(i).isSelected()) {
				Chk_CustomGroup.get(i).click();
				log(i + " Custom Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Custom Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}

		int no_Of_FeeGroup = Chk_FeeGroup.size();
		for (int i = 0; i < no_Of_FeeGroup; i++) {
			if (!Chk_FeeGroup.get(i).isSelected()) {
				Chk_FeeGroup.get(i).click();
				log(i + " Fee Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Fee Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}
	}
	public void clickReport_ToGenerate_FeeStudentConcessionReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Fee Student Concession Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Yearly Fee Defaulter report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(7000);
		} else {
			log("Clear button element not present.");
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

	public void min_Max_FeeStudentConcessionReport_Form() throws Exception {
		if (btnMin_MaxStudentConcessionReport.isDisplayed()) {
			btnMin_MaxStudentConcessionReport.click();
			log("Fee Student Concession Report page minimized or maximized and object is:-"
					+ btnMin_MaxStudentConcessionReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Student Concession Report Minimized Element not present.");
		}
	}

	public void min_Max_ReportGridView_Grid() throws Exception {
		if (btnMin_MaxReportGridView.isDisplayed()) {
			btnMin_MaxReportGridView.click();
			log("Report Grid View page minimized or maximized and object is:-"
					+ btnMin_MaxReportGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Report Grid View Minimized Element not present.");
		}
	}

	public void searchWithStudentName_InFeeStudentConcessionReportGridView(String studentName) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(studentName);
			log("Entered Student Name to search: " + studentName + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void sortRecordsByStudentName() throws Exception {
		if (btnSortByStudentName.isDisplayed()) {
			btnSortByStudentName.click();
			// btnSortByGroupName.click();
			log("Sorted the record with Student name and object is:-" + btnSortByStudentName.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}

	public void selectRecordToGenerateReport() throws Exception {
		int no_Of_Record = Chk_FeeDefaulterReportGrid.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_FeeDefaulterReportGrid.get(i).isSelected()) {
				Chk_FeeDefaulterReportGrid.get(i).click();
				log(i + " Custom Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Custom Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}
	}
}
