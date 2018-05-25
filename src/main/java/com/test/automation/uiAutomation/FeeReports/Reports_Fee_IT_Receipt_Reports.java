/**
 * 
 */
package com.test.automation.uiAutomation.FeeReports;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Reports_Fee_IT_Receipt_Reports extends TestBase {

	public static final Logger log = Logger.getLogger(Reports_Fee_IT_Receipt_Reports.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[4]")
	WebElement feeReports;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[4]/ul/li[28]")
	WebElement btnFeeItReceiptReports;
	
	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeItReceiptReportsMsgDispaly;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[1]")
	WebElement selAcademicYr;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[2]")
	WebElement selClass;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[3]")
	WebElement selSection;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[4]")
	WebElement selStudentName;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[5]")
	WebElement selReceiptNo;
	
	@FindBy(xpath = "//span[contains(text(),'Show')]")
	WebElement btnShow;
	
	@FindBy(xpath = "//span[contains(text(),'Print')]")
	WebElement btnPrint;
	
	
	public Reports_Fee_IT_Receipt_Reports(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			return true;

		} catch (Exception e) {
			return false;
		}

	}
	public void nevigateToReports_FeeIt_ReceiptReports() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		feeReports.click();
		log("Clicked on Fee Reports Button and object is:-" + feeReports.toString());
		Thread.sleep(1000);

		btnFeeItReceiptReports.click();
		log("Clicked on Fee It receipt reports Button and object is:-" + btnFeeItReceiptReports.toString());
		Thread.sleep(1000);
	}
	public boolean verifyFeeItReceiptReportsPage() {
		try {
			System.out.println(txtFeeItReceiptReportsMsgDispaly.getText());
			txtFeeItReceiptReportsMsgDispaly.isDisplayed();
			log("Fee It receipt reports page is dispalyed and object is:-" + txtFeeItReceiptReportsMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Fill with the required data for fee IT receipt generation
	 * 
	 * @param academicYr
	 * @param classname
	 * @param section
	 * @param studentName
	 * @param receiptNum
	 * @throws Exception
	 */
	public void selectAcademicYrClassSectionStuNameAndReceiptNo(String academicYr, String classname,String section, String studentName,String receiptNum) throws Exception{
		
		select = new Select(selAcademicYr);
		select.selectByVisibleText(academicYr);
		log("selected academic year:-" + academicYr + " and object is " + selAcademicYr.toString());
		Thread.sleep(1000);
		
		select = new Select(selClass);
		select.selectByVisibleText(classname);
		log("selected class:-" + classname + " and object is " + selClass.toString());
		Thread.sleep(1000);
		
		select = new Select(selSection);
		select.selectByVisibleText(section);
		log("selected section:-" + section + " and object is " + selSection.toString());
		Thread.sleep(1000);
		
		select = new Select(selStudentName);
		select.selectByVisibleText(studentName);
		log("selected student name:-" + studentName + " and object is " + selStudentName.toString());
		Thread.sleep(1000);
		
		select = new Select(selReceiptNo);
		select.selectByVisibleText(receiptNum);
		log("selected receipt number:-" + receiptNum + " and object is " + selReceiptNo.toString());
		Thread.sleep(1000);
	}
/**
 * Show the fee it receipt report
 * 
 */
	public void clickOnShowButton(){
		btnShow.click();
		log("clicked on SHOW button to show the it receipt report and object is:-"+btnShow.toString());
		waitForElement(driver, 10, btnPrint);
	}
	
	/**
	 * print fee it receipt report
	 * 
	 * @throws Exception
	 */
	public void clickOnPrintbutton() throws Exception{
		
		btnPrint.click();
		log("clicked on PRINT button to print the it receipt report and object is:-"+btnPrint.toString());
		Thread.sleep(2000);
	}
}
