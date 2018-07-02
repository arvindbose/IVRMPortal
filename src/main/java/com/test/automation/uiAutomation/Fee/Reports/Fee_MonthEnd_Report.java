/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Reports;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
public class Fee_MonthEnd_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_MonthEnd_Report.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[11]")
	private WebElement btn_FeeMonthEndReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeMonthEndReport;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "(//label[contains(text(),'From Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_FromCalender;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear_From;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[3]/span")
	WebElement btn_Date_From;

	@FindBy(xpath = "(//label[contains(text(),'To Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_ToCalender;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear_To;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[30]/span")
	WebElement btn_Date_To;

	@FindBy(xpath = "//span[text()='User Entry']/preceding-sibling::input")
	private WebElement Chk_UserEntry;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	private WebElement btn_Clear;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeMonthEndReport_Form;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeMonthEndReport_Grid;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	public Fee_MonthEnd_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee Month End Report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeMonthEndReport() throws Exception {
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
		if (btn_FeeMonthEndReport.isDisplayed()) {
			btn_FeeMonthEndReport.click();
			log("Clicked on Fee Month End Report Button in navigation panel and object is:-"
					+ btn_FeeMonthEndReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Month End Report button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Fee > Reports > Fee Month End Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeMonthEndReport_Page() {
		try {
			System.out.println(txt_FeeMonthEndReport.getText().trim());
			txt_FeeMonthEndReport.isDisplayed();
			log("Fee Month End Report page text is dispalyed and object is:-" + txt_FeeMonthEndReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeMonthEndReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank Fee Month End Report form and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Fee Month End Report
	 * 
	 */
	public void fill_FeeMonthEndReportForm(String academicYear) throws Exception {

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

	public void clickReport_ToGenerate_FeeMonthEndReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Fee Month End Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickClearButton_ToClearFilledForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Fee Month End report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(7000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeMonthEndReport);
//		Thread.sleep(1000);

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
			Thread.sleep(3000);

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
				Thread.sleep(1000);
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
		Thread.sleep(1000);
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

	public void min_Max_FeeMonthEndReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeMonthEndReport);
		Thread.sleep(1000);
		if (btnMin_MaxFeeMonthEndReport_Form.isDisplayed()) {
			btnMin_MaxFeeMonthEndReport_Form.click();
			log("Fee Month End Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthEndReport_Form.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Month End Report Minimized Element not present.");
		}
	}

	public void min_Max_FeeMonthEndReport_Grid() throws Exception {
		if (btnMin_MaxFeeMonthEndReport_Grid.isDisplayed()) {
			btnMin_MaxFeeMonthEndReport_Grid.click();
			log("Fee Month End Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthEndReport_Grid.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Month End Report Grid Minimized Element not present.");
		}

	}

}
