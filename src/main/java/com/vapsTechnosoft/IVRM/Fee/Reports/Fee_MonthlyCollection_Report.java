/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Fee_MonthlyCollection_Report extends TestBase {
	public static final Logger log = Logger.getLogger(Fee_MonthlyCollection_Report.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[10]")
	private WebElement btn_FeeMonthlyCollectionReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeMonthlyCollectionReport;

	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	private WebElement rdBtn_All;

	@FindBy(xpath = "//span[contains(text(),'Individual')]/preceding-sibling::input")
	private WebElement rdBtn_Individual;

	@FindBy(xpath = "//span[contains(text(),'Active')]/preceding-sibling::input")
	private WebElement rdBtn_Active;

	@FindBy(xpath = "//span[contains(text(),'Left')]/preceding-sibling::input")
	private WebElement rdBtn_Left;

	@FindBy(xpath = "//span[contains(text(),'Adm No')]/preceding-sibling::input")
	private WebElement rdBtn_AdmNo;

	@FindBy(xpath = "//span[contains(text(),'Name')]/preceding-sibling::input")
	private WebElement rdBtn_Name;

	@FindBy(xpath = "//span[contains(text(),'Cheque Date')]/preceding-sibling::input")
	private WebElement chk_ChequeDate;

	@FindBy(xpath = "//input[@name='fee_ct1']")
	private List<WebElement> Chk_CustomGroup;

	@FindBy(xpath = "//input[@name='fee_gp1']")
	private List<WebElement> Chk_FeeGroup;

	@FindBy(xpath = "(//label[contains(text(),'From Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_FromCalender;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	private WebElement btn_MonthYear_From;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[3]/span")
	private WebElement btn_Date_From;

	@FindBy(xpath = "(//label[contains(text(),'To Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_ToCalender;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	private WebElement btn_MonthYear_To;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[30]/span")
	private WebElement btn_Date_To;

	@FindBy(xpath = "//label[contains(text(),'Student Name :')]/following-sibling::div/select")
	private WebElement sel_StudentName;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeMonthlyCollectionReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeMonthlyCollectionReportGrid;

	@FindBy(xpath = "//a[contains(text(),'Export to Excel')]")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "//a[contains(text(),'Export to PDF')]")
	private WebElement btn_ExportToPDF;

	public Fee_MonthlyCollection_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee Monthly Collection report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeMonthlyCollectionReport() throws Exception {
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
		if (btn_FeeMonthlyCollectionReport.isDisplayed()) {
			btn_FeeMonthlyCollectionReport.click();
			log("Clicked on Fee Monthly Collection Report Button in navigation panel and object is:-"
					+ btn_FeeMonthlyCollectionReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Monthly Collection Report button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Fee > Reports > Fee Monthly Collection Report screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeMonthlyCollectionReport_Page() {
		try {
			System.out.println(txt_FeeMonthlyCollectionReport.getText().trim());
			txt_FeeMonthlyCollectionReport.isDisplayed();
			log("Fee Monthly Collection Report page text is dispalyed and object is:-"
					+ txt_FeeMonthlyCollectionReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeMonthlyCollectionReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank Fee Monthly Collection form and object is:-" + btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for All
	 * 
	 * For Active Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_All_ForActiveStudent() throws Exception {

		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("All radio button is selected and object is:- " + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
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

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for All
	 * 
	 * For Left Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_All_ForLeftStudent() throws Exception {

		if (!rdBtn_All.isSelected()) {
			rdBtn_All.click();
			log("All radio button is selected and object is:- " + rdBtn_All.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
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

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Individual
	 * 
	 * For Active Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent(String studentName)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_AdmNo.isSelected()) {
			rdBtn_AdmNo.click();
			log("AdmNo radio button is selected and object is:- " + rdBtn_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("AdmNo Radio button already selected.");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {
			select = new Select(sel_StudentName);
			select.selectByVisibleText(studentName);
			log("Selected Student Name: " + studentName + " and object is:- " + sel_StudentName.toString());
			Thread.sleep(3000);
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), studentName);
//			log("Selected student name matched with the input name.");
//			Thread.sleep(3000);
		} else {
			log("Student Name element is not present");
			Thread.sleep(500);
		}

		int no_Of_CustomGroup = Chk_CustomGroup.size();
		for (int i = 0; i < no_Of_CustomGroup; i++) {
			if (!Chk_CustomGroup.get(i).isSelected()) {
				Chk_CustomGroup.get(i).click();
				log(i + " Custom Group Name check box is checked.");
				Thread.sleep(2000);
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
				Thread.sleep(2000);
			} else {
				log(i + " Fee Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(2000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(1000);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(1000);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Individual
	 * 
	 * For Left Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent(String studentName)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_AdmNo.isSelected()) {
			rdBtn_AdmNo.click();
			log("AdmNo radio button is selected and object is:- " + rdBtn_AdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("AdmNo Radio button already selected.");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {
			select = new Select(sel_StudentName);
			select.selectByVisibleText(studentName);

			log("Selected Student Name: " + studentName + " and object is:- " + sel_StudentName.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), studentName);
//			Thread.sleep(1000);
		} else {
			log("Student Name element is not present");
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

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Individual
	 * 
	 * For Active Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent(String studentName)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Name.isSelected()) {
			rdBtn_Name.click();
			log("Name radio button is selected and object is:- " + rdBtn_Name.toString());
			Thread.sleep(1000);
		} else {
			log("Name Radio button already selected.");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {
			select = new Select(sel_StudentName);
			select.selectByVisibleText(studentName);

			log("Selected Student Name: " + studentName + " and object is:- " + sel_StudentName.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), studentName);
//			Thread.sleep(1000);
		} else {
			log("Student Name element is not present");
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

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Individual
	 * 
	 * For Left Student
	 */
	public void fill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent(String studentName)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Individual radio button is selected and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_Name.isSelected()) {
			rdBtn_Name.click();
			log("Name radio button is selected and object is:- " + rdBtn_Name.toString());
			Thread.sleep(1000);
		} else {
			log("Name Radio button already selected.");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {
			select = new Select(sel_StudentName);
			select.selectByVisibleText(studentName);

			log("Selected Student Name: " + studentName + " and object is:- " + sel_StudentName.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), studentName);
//			Thread.sleep(1000);
		} else {
			log("Student Name element is not present");
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

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
		if (btn_FromCalender.isDisplayed()) {
			btn_FromCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("From Date Calendar button element not present.");
			Thread.sleep(500);
		}

		if (btn_ToCalender.isDisplayed()) {
			btn_ToCalender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("To Date Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_FeeMonthlyCollectionReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeMonthlyCollectionReport);
		Thread.sleep(1000);
		if (btnMin_MaxFeeMonthlyCollectionReport.isDisplayed()) {
			btnMin_MaxFeeMonthlyCollectionReport.click();
			log("Fee Monthly Collection Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthlyCollectionReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Monthly Collection Report Minimized Element not present.");
		}
	}

	public void min_Max_FeeMonthlyCollectionReport_Grid() throws Exception {
		if (btnMin_MaxFeeMonthlyCollectionReportGrid.isDisplayed()) {
			btnMin_MaxFeeMonthlyCollectionReportGrid.click();
			log("Fee Monthly Collection Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthlyCollectionReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Monthly Collection Report Grid Minimized Element not present.");
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

	public void clickOnExportToPDF_ToDownLoadPDFReport() throws Exception {
		if (btn_ExportToPDF.isDisplayed()) {
			btn_ExportToPDF.click();
			log("To Download PDF report click on Export to PDF and object is:-" + btn_ExportToPDF.toString());
			Thread.sleep(5000);
		} else {
			log("Export to PDF button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_FeeMonthlyCollectionReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Fee Monthly Collection Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Fee Monthly Collection report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}
}
