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
public class Fee_ITReceipt_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_ITReceipt_Report.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[7]")
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

	@FindBy(xpath = "//label[contains(text(),'Receipt No:')]/following-sibling::div/select")
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
			Thread.sleep(5000);
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
		if (btn_FeeITReceiptReport.isDisplayed()) {
			btn_FeeITReceiptReport.click();
			log("Clicked on Fee IT Receipt Report Button in navigation panel and object is:-"
					+ btn_FeeITReceiptReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee IT Receipt Report button element not present.");
			Thread.sleep(500);
		}

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
		if (btn_Show.isDisplayed()) {
			btn_Show.click();
			log("Submit blank Fee IT Receipt Report form and object is:-" + btn_Show.toString());
			Thread.sleep(5000);
		} else {
			log("Show button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Fee IT Receipt Report
	 * 
	 */
	public void fill_FeeITReceiptReportForm(String academicYear, String class_It, String section_it,
			String student_Name, String receipt_No) throws Exception {

		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_It);

			log("Selected Class: " + class_It + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_It);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section_it);

			log("Selected Section: " + section_it + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_it);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {
			select = new Select(sel_StudentName);
			select.selectByVisibleText(student_Name);

			log("Selected Student Name: " + student_Name + " and object is:- " + sel_StudentName.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), student_Name);
			Thread.sleep(1000);
		} else {
			log("Student Name element is not present");
			Thread.sleep(500);
		}
		if (sel_ReceiptNo.isDisplayed()) {
			select = new Select(sel_ReceiptNo);
			select.selectByVisibleText(receipt_No);

			log("Selected Receipt No.: " + receipt_No + " and object is:- " + sel_ReceiptNo.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), receipt_No);
			Thread.sleep(1000);
		} else {
			log("Receipt No. element is not present");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_FeeITReceiptReport() throws Exception {
		if (btn_Show.isDisplayed()) {
			btn_Show.click();
			log("Fee IT Receipt Report is generated and object is:-" + btn_Show.toString());
			Thread.sleep(5000);
		} else {
			log("Show button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickClearButton_ToClearFilledForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Fee IT Receipt report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(7000);
		} else {
			log("Clear button element not present.");
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

	public void min_Max_FeeITReceiptReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeITReceiptReport);
		Thread.sleep(1000);
		if (btnMin_MaxITReceiptReport_Form.isDisplayed()) {
			btnMin_MaxITReceiptReport_Form.click();
			log("Fee IT Receipt Report page minimized or maximized and object is:-"
					+ btnMin_MaxITReceiptReport_Form.toString());
			Thread.sleep(1000);
		} else {
			log("Fee IT Receipt Report Minimized Element not present.");
		}
	}

}
