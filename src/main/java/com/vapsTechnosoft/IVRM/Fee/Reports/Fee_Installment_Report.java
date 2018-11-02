/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Fee_Installment_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_Installment_Report.class.getName());

	private WebDriver driver;


	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[4]")
	// private WebElement btn_FeeInstallmentReport;

	@FindBy(xpath = "//a[@href='#/app/FeeInstallmentReport/207']")
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
			Thread.sleep(1000);
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
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_FeeInstallmentReport);
		log("Clicked on Fee Installment Report Button in navigation panel and object is:-"
				+ btn_FeeInstallmentReport.toString());

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
	
			clickOnButton(btn_Report);
			log("Submit blank Fee Installment form and object is:-" + btn_Report.toString());
			
	}

	/*
	 * Generate report for Category Wise
	 * 
	 */
	public void fill_FeeInstallmentReportForm_ForCategoryWise(String academicYear, String category) throws Exception {
		isDisplayed(rdBtn_CategoryWise);
		if (!rdBtn_CategoryWise.isSelected()) {
			rdBtn_CategoryWise.click();
			log("Category Wise radio button is selected and object is:- " + rdBtn_CategoryWise.toString());
			Thread.sleep(1000);
		} else {
			log("Category Wise Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
	
			selectElementFromDropDown(sel_Category, category);
			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			
			isDisplayed(chk_InstallmentType);
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
	public void fill_FeeInstallmentReportForm_ForClassWise(String academicYear, String class_Inst, String section_Inst)
			throws Exception {
		isDisplayed(rdBtn_ClassWise);
		if (!rdBtn_ClassWise.isSelected()) {
			rdBtn_ClassWise.click();
			log("Class Wise radio button is selected and object is:- " + rdBtn_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Class Wise Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		
			selectElementFromDropDown(sel_Class, class_Inst);
			log("Selected Class: " + class_Inst + " and object is:- " + sel_Class.toString());
		
			selectElementFromDropDown(sel_Section, section_Inst);
			log("Selected Section: " + section_Inst + " and object is:- " + sel_Section.toString());
			
	}

	public void min_Max_FeeInstallmentReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeInstallmentReport);
		Thread.sleep(1000);

			clickOnButton(btnMin_MaxFeeInstallmentReport);
			log("Fee Installment Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeInstallmentReport.toString());
		
	}

	public void min_Max_FeeInstallmentReport_Grid() throws Exception {
	
			clickOnButton(btnMin_MaxFeeInstallmentReportGrid);
			log("Fee Installment Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeInstallmentReportGrid.toString());
			
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {

			clickOnButton(btn_ExportToExcel);
			log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(3000);
		
	}

	public void clickOnExportToPDF_ToDownLoadPDFReport() throws Exception {
		
			clickOnButton(btn_ExportToPDF);
			log("To Download PDF report click on Export to PDF and object is:-" + btn_ExportToPDF.toString());
			Thread.sleep(1000);
		
	}

	public void clickReport_ToGenerate_FeeInstallmentReport() throws Exception {
	
			clickOnButton(btn_Report);
			log("Fee Installment Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		
			clickOnButton(btn_Cancel);
			log("Fee Installment report filled form data is cleared and object is:-" + btn_Cancel.toString());
			
	}

}
