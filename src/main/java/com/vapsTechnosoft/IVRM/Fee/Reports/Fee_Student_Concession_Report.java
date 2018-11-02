/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Fee_Student_Concession_Report extends TestBase {

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[9]")
	// WebElement btn_FeeStudentConcessionReport;

	@FindBy(xpath = "//a[@href='#/app/FeeStudentConcession/115']")
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
			Thread.sleep(2000);
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

		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_FeeStudentConcessionReport);
		log("Clicked on Fee Student Concession Report Button in navigation panel and object is:-"
				+ btn_FeeStudentConcessionReport.toString());
	}

	/**
	 * Validation of Fee > Reports > Fee Student Concession Report screen
	 * message
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

		clickOnButton(btn_Report);
		log("Submit blank Fee Student Concession Report form and object is:-" + btn_Report.toString());
		Thread.sleep(1000);

	}

	/*
	 * Generate report for Fee Student Concession, All
	 * 
	 */
	public void fill_FeeStudentConcessionReportForm_rdBtnAll(String academicYear, String concession_Type)
			throws Exception {
		isDisplayed(rdBtn_All);
		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("All radio button is selected and object is:- " + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		// selectElementFromDropDown(sel_AcademicYear, academicYear);
		select = new Select(sel_AcademicYear);
		select.selectByVisibleText(academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(Sel_ConcessionType, concession_Type);
		log("selected Concession type: " + concession_Type + " and object is:- " + Sel_ConcessionType.toString());
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Generate report for Fee Student Concession, Individual
	 * 
	 */
	public void fill_FeeStudentConcessionReportForm_rdBtnIndividual(String academicYear, String concession_Type,
			String select_class, String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		// selectElementFromDropDown(sel_AcademicYear, academicYear);
		Select select = new Select(sel_AcademicYear);
		select.selectByVisibleText(academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(Sel_ConcessionType, concession_Type);
		log("selected Concession type: " + concession_Type + " and object is:- " + Sel_ConcessionType.toString());

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickReport_ToGenerate_FeeStudentConcessionReport() throws Exception {

		clickOnButton(btn_Report);
		log("Fee Student Concession Report is generated and object is:-" + btn_Report.toString());
		Thread.sleep(2000);

	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {

		clickOnButton(btn_Clear);
		log("Yearly Fee Defaulter report filled form data is cleared and object is:-" + btn_Clear.toString());
		Thread.sleep(1000);

	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {

		clickOnButton(btn_ExportToExcel);
		log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
		Thread.sleep(1000);

	}

	public void clickOnPrint_ForPrintPreview() throws Exception {

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
				Thread.sleep(2000);

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

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void min_Max_FeeStudentConcessionReport_Form() throws Exception {

		clickOnButton(btnMin_MaxStudentConcessionReport);
		log("Fee Student Concession Report page minimized or maximized and object is:-"
				+ btnMin_MaxStudentConcessionReport.toString());

	}

	public void min_Max_ReportGridView_Grid() throws Exception {

		clickOnButton(btnMin_MaxReportGridView);
		log("Report Grid View page minimized or maximized and object is:-" + btnMin_MaxReportGridView.toString());

	}

	public void searchWithStudentName_InFeeStudentConcessionReportGridView(String studentName) throws Exception {

		inputTextIntoInputField(input_Search, studentName);
		log("Entered Student Name to search: " + studentName + " and object is:-" + input_Search.toString());

	}

	public void sortRecordsByStudentName() throws Exception {

		clickOnButton(btnSortByStudentName);
		log("Sorted the record with Student name and object is:-" + btnSortByStudentName.toString());

	}

	public void selectRecordToGenerateReport() {
		try {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
