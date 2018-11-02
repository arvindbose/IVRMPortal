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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Fee_ITReceipt_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_ITReceipt_Report.class.getName());

	private WebDriver driver;


	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[7]")
	// private WebElement btn_FeeITReceiptReport;

	@FindBy(xpath = "//a[@href='#/app/FeeITreport/293']")
	private WebElement btn_FeeITReceiptReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeITReceiptReport;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	private WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Student Name:')]/following-sibling::div/select")
	private WebElement sel_StudentName;

	@FindBy(xpath = "//select[@name='rcpt_no']")
	private WebElement sel_ReceiptNo;

	@FindBy(xpath = "//span[contains(text(),'Show')]/parent::button")
	private WebElement btn_Show;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	private WebElement btn_Clear;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxITReceiptReport_Form;

	public Fee_ITReceipt_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Fee IT Receipt Report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeITReceiptReport() throws Exception {
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_FeeITReceiptReport);
		log("Clicked on Fee IT Receipt Report Button in navigation panel and object is:-"
				+ btn_FeeITReceiptReport.toString());
	}

	/**
	 * Validation of Fee > Reports > Fee IT Receipt Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeITReceiptReport_Page() {
		try {
			System.out.println(txt_FeeITReceiptReport.getText().trim());
			txt_FeeITReceiptReport.isDisplayed();
			log("Fee IT Receipt Report page text is dispalyed and object is:-" + txt_FeeITReceiptReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeITReceiptReportForm() throws Exception {
	
			clickOnButton(btn_Show);
			log("Submit blank Fee IT Receipt Report form and object is:-" + btn_Show.toString());
			Thread.sleep(1000);
		
	}

	/*
	 * Generate report for Fee IT Receipt Report
	 * 
	 */
	public void fill_FeeITReceiptReportForm(String academicYear, String class_It, String section_it,
			String student_Name, String receipt_No) throws Exception {

			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		
			selectElementFromDropDown(sel_Class, class_It);
			log("Selected Class: " + class_It + " and object is:- " + sel_Class.toString());
	
			selectElementFromDropDown(sel_Section, section_it);
			log("Selected Section: " + section_it + " and object is:- " + sel_Section.toString());
		
		//	selectElementFromDropDown(sel_StudentName, student_Name);
			Select select= new Select(sel_StudentName);
			select.selectByVisibleText(student_Name);
			log("Selected Student Name: " + student_Name + " and object is:- " + sel_StudentName.toString());
		
			selectElementFromDropDown(sel_ReceiptNo, receipt_No);
			log("Selected Receipt No.: " + receipt_No + " and object is:- " + sel_ReceiptNo.toString());
			
	}

	public void clickReport_ToGenerate_FeeITReceiptReport() throws Exception {

			clickOnButton(btn_Show);
			log("Fee IT Receipt Report is generated and object is:-" + btn_Show.toString());
			Thread.sleep(2000);
		
	}

	public void clickClearButton_ToClearFilledForm() throws Exception {
		
			clickOnButton(btn_Clear);
			log("Fee IT Receipt report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(2000);
		
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

	public void min_Max_FeeITReceiptReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeITReceiptReport);
		Thread.sleep(1000);
		
			clickOnButton(btnMin_MaxITReceiptReport_Form);
			log("Fee IT Receipt Report page minimized or maximized and object is:-"
					+ btnMin_MaxITReceiptReport_Form.toString());
			
	}

}
