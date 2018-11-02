/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Fee_MonthEnd_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_MonthEnd_Report.class.getName());

	private WebDriver driver;
	

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[11]")
	// private WebElement btn_FeeMonthEndReport;

	@FindBy(xpath = "//a[@href='#/app/FeeMonthEndReport/141']")
	private WebElement btn_FeeMonthEndReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeMonthEndReport;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Month :')]/following-sibling::div/select")
	private WebElement sel_Month;

	@FindBy(xpath = "//label[contains(text(),'Year :')]/following-sibling::div/select")
	private WebElement sel_Year;

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
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_FeeMonthEndReport);
		log("Clicked on Fee Month End Report Button in navigation panel and object is:-"
				+ btn_FeeMonthEndReport.toString());

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
	
			clickOnButton(btn_Report);
			log("Submit blank Fee Month End Report form and object is:-" + btn_Report.toString());
			
	}

	/*
	 * Generate report for Fee Month End Report
	 * 
	 */
	public void fill_FeeMonthEndReportForm(String academicYear, String month, String year) throws Exception {

			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
	
			selectElementFromDropDown(sel_Month, month);
			log("selected Month: " + month + " and object is:- " + sel_Month.toString());

			selectElementFromDropDown(sel_Year, year);
			log("selected Year: " + year + " and object is:- " + sel_Year.toString());
			
	}

	public void clickReport_ToGenerate_FeeMonthEndReport() throws Exception {
	
			clickOnButton(btn_Report);
			log("Fee Month End Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		
	}

	public void clickClearButton_ToClearFilledForm() throws Exception {
	
			clickOnButton(btn_Clear);
			log("Fee Month End report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// txt_FeeMonthEndReport);
		// Thread.sleep(1000);

			clickOnButton(btn_ExportToExcel);
			log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(1000);
		
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

			clickOnButton(btnOKSuccess);
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
			
		
	}

	public void min_Max_FeeMonthEndReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeMonthEndReport);
		Thread.sleep(1000);
		
			clickOnButton(btnMin_MaxFeeMonthEndReport_Form);
			log("Fee Month End Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthEndReport_Form.toString());
			
	}

	public void min_Max_FeeMonthEndReport_Grid() throws Exception {

			clickOnButton(btnMin_MaxFeeMonthEndReport_Grid);
			log("Fee Month End Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeMonthEndReport_Grid.toString());
			

	}

}
