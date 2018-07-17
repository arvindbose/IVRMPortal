/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import java.util.List;
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
public class Fee_DueDates_Report extends TestBase{
	
	public static final Logger log = Logger.getLogger(Fee_DueDates_Report.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[12]")
	private WebElement btn_FeeDueDatesReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeDueDatesReport;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class Category:')]/following-sibling::div/select")
	private WebElement sel_ClassCategory;
	
	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_ShowReport;

	@FindBy(xpath = "//span[contains(text(),'print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeDueDatesReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeDueDatesReportGrid;

	@FindBy(xpath = "//table[@id='Table']/thead/tr/th[4]/a")
	private WebElement btnSortByFeeHeadName;

	@FindBy(xpath = "//div[@class='input-group']//input")
	private WebElement input_Search;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//table[@id='Table']/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_FeeDueDatesReportGrid;
	
	public Fee_DueDates_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee Due Dates Report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeDueDatesReport() throws Exception {
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
		if (btn_FeeDueDatesReport.isDisplayed()) {
			btn_FeeDueDatesReport.click();
			log("Clicked on Fee Due Dates Report Button in navigation panel and object is:-"
					+ btn_FeeDueDatesReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Due Dates Report button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Fee > Reports > Fee Due Dates Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeDueDatesReport_Page() {
		try {
			System.out.println(txt_FeeDueDatesReport.getText().trim());
			txt_FeeDueDatesReport.isDisplayed();
			log("Fee Due Dates Report page text is dispalyed and object is:-"
					+ txt_FeeDueDatesReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeDueDatesReportForm() throws Exception {
		if (btn_ShowReport.isDisplayed()) {
			btn_ShowReport.click();
			log("Submit blank Fee Due Dates Report form and object is:-" + btn_ShowReport.toString());
			Thread.sleep(7000);
		} else {
			log("Show Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Fee Due Dates
	 * 
	 */
	public void fill_FeeDueDatesReportForm(String academicYear, String classCategory)
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
		if (sel_ClassCategory.isDisplayed()) {
			select = new Select(sel_ClassCategory);
			select.selectByVisibleText(classCategory);

			log("selected class Category: " + classCategory + " and object is:- " + sel_ClassCategory.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classCategory);
			Thread.sleep(1000);
		} else {
			log("Class Category element is not present");
			Thread.sleep(500);
		}
	}
	
	public void clickReport_ToGenerate_FeeDueDatesReport() throws Exception {
		if (btn_ShowReport.isDisplayed()) {
			btn_ShowReport.click();
			log("Fee Due Dates Report is generated and object is:-" + btn_ShowReport.toString());
			Thread.sleep(5000);
		} else {
			log("Show Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Fee Due Dates Report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeDueDatesReport);
		Thread.sleep(1000);
		
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

	public void min_Max_FeeDueDatesReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeDueDatesReport);
		Thread.sleep(1000);
		if (btnMin_MaxFeeDueDatesReport.isDisplayed()) {
			btnMin_MaxFeeDueDatesReport.click();
			log("Fee Due Dates Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeDueDatesReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Due Dates Report Minimized Element not present.");
		}
	}

	public void min_Max_FeeDueDatesReport_Grid() throws Exception {
		if (btnMin_MaxFeeDueDatesReportGrid.isDisplayed()) {
			btnMin_MaxFeeDueDatesReportGrid.click();
			log("Fee Due Dates Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeDueDatesReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Due Dates Report Grid Minimized Element not present.");
		}
	}

	public void sortRecordsByFeeHeadName() throws Exception {
		if (btnSortByFeeHeadName.isDisplayed()) {
			btnSortByFeeHeadName.click();
			// btnSortByGroupName.click();
			log("Sorted the record with Fee Head name and object is:-" + btnSortByFeeHeadName.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}

	public void selectRecordToDownLoadAndPrintPreview() throws Exception {
		int no_Of_Record = Chk_Records_FeeDueDatesReportGrid.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_FeeDueDatesReportGrid.get(i).isSelected()) {
				Chk_Records_FeeDueDatesReportGrid.get(i).click();
				log(i + " records check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked.");
				Thread.sleep(500);
			}
		}
	}

	public void searchWithFeeHeadName_InFeeDueDatesReportGrid(String feeHeadName) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(feeHeadName);
			log("Entered Fee Head Name to search: " + feeHeadName + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}
}
