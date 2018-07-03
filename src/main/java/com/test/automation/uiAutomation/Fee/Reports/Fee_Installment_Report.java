/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Reports;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Fee_Installment_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_Installment_Report.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[4]")
	private WebElement btn_FeeInstallmentReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeInstallmentReport;

	@FindBy(xpath = "//span[contains(text(),'Category Wise')]/preceding-sibling::input")
	private WebElement rdBtn_CategoryWise;

	@FindBy(xpath = "//span[contains(text(),'Class Wise')]/preceding-sibling::input")
	private WebElement rdBtn_ClassWise;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Category')]/following-sibling::div/select")
	private WebElement sel_Category;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	private WebElement sel_Section;

	@FindBy(xpath = "//span[text()='Yearly']/preceding-sibling::input")
	private WebElement chk_InstallmentType;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeInstallmentReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeInstallmentReportGrid;

	@FindBy(xpath = "//a[contains(text(),'Export to Excel')]")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "//a[contains(text(),'Export to PDF')]")
	private WebElement btn_ExportToPDF;

	public Fee_Installment_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee Installment report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeInstallmentReport() throws Exception {
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
		if (btn_FeeInstallmentReport.isDisplayed()) {
			btn_FeeInstallmentReport.click();
			log("Clicked on Fee Installment Report Button in navigation panel and object is:-"
					+ btn_FeeInstallmentReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Installment Report button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Fee > Reports > Fee Installment Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeInstallmentReport_Page() {
		try {
			System.out.println(txt_FeeInstallmentReport.getText().trim());
			txt_FeeInstallmentReport.isDisplayed();
			log("Fee Installment Report page text is dispalyed and object is:-" + txt_FeeInstallmentReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeInstallmentReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank Fee Installment form and object is:-" + btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Category Wise
	 * 
	 */
	public void fill_FeeInstallmentReportForm_ForCategoryWise(String academicYear, String category) throws Exception {

		if (!rdBtn_CategoryWise.isSelected()) {
			rdBtn_CategoryWise.click();
			log("Category Wise radio button is selected and object is:- " + rdBtn_CategoryWise.toString());
			Thread.sleep(1000);
		} else {
			log("Category Wise Radio button already selected.");
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
		if (sel_Category.isDisplayed()) {
			select = new Select(sel_Category);
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(1000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}

		if (!chk_InstallmentType.isSelected()) {
			chk_InstallmentType.click();
			log("Installment check box is checked and object is:- " + chk_InstallmentType.toString());
			Thread.sleep(1000);
		} else {
			log("Installment check box is already checked.");
			Thread.sleep(500);
		}
	}
	/*
	 * Generate report for Class Wise
	 * 
	 */
	public void fill_FeeInstallmentReportForm_ForClassWise(String academicYear, String class_Inst, String section_Inst) throws Exception {

		if (!rdBtn_ClassWise.isSelected()) {
			rdBtn_ClassWise.click();
			log("Class Wise radio button is selected and object is:- " + rdBtn_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise Radio button already selected.");
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
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Inst);

			log("Selected Class: " + class_Inst + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Inst);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section_Inst);

			log("Selected Section: " + section_Inst + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_Inst);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}
	public void min_Max_FeeInstallmentReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeInstallmentReport);
		Thread.sleep(1000);
		if (btnMin_MaxFeeInstallmentReport.isDisplayed()) {
			btnMin_MaxFeeInstallmentReport.click();
			log("Fee Installment Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeInstallmentReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Installment Report Minimized Element not present.");
		}
	}

	public void min_Max_FeeInstallmentReport_Grid() throws Exception {
		if (btnMin_MaxFeeInstallmentReportGrid.isDisplayed()) {
			btnMin_MaxFeeInstallmentReportGrid.click();
			log("Fee Installment Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeInstallmentReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Installment Report Grid Minimized Element not present.");
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

	public void clickReport_ToGenerate_FeeInstallmentReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Fee Installment Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Fee Installment report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

}
