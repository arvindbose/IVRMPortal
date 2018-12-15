/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Installment_MasterInstallment_DueDate extends TestBase {

	public static final Logger log = Logger
			.getLogger(Masters_Fee_Installment_MasterInstallment_DueDate.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[9]")
	// WebElement btnFeeInstallment;

	@FindBy(xpath = "//a[@href='#/app/MasterFeeInstallment/81']")
	WebElement btnFeeInstallment;

	@FindBy(xpath = "//span[contains(text(),'Master Installment Due Date')]/parent::md-tab-item")
	WebElement tab_MasterInstallmentDueDate;

	@FindBy(xpath = "//select[@name='yearsselect']")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//select[@name='instypeselect']")
	WebElement sel_MasterInstallment;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeInstallmentScreen;

	@FindBy(xpath = "//h3[contains(text(),'Fee Master Instalment Grid View')]")
	WebElement txtFMasterInstGridView;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[2]")
	WebElement btn_Save_MasterInstallmentDueDate;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	WebElement btn_Cancel_MasterInstallmentDueDate;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;
	/*
	 * Ist Installment details
	 */

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[1]/td[3]/following::button[1]")
	WebElement btnCalendar_1stInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]")
	WebElement btn_MonthYear;
	
	@FindBy(xpath = "//td[text()='2018']/following::td[@aria-label='May 2018']")
	WebElement btn_MonthFrom;
	
	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear_1stInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[3]/span")
	WebElement btn_Date_1stInsFromdate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[1]/td[4]/following::button[1]")
	WebElement btnCalendar_1stInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear_1stInsTodate;
	
	@FindBy(xpath = "//td[text()='2018']/following::td[@aria-label='June 2018']")
	WebElement btn_MonthTo;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]/following::td[31]/span")
	WebElement btn_Date_1stInsTodate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[1]/td[5]/following::button[1]")
	WebElement btnCalendar_1stInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	WebElement btn_MonthYear_1stInsApplicabledate;

	@FindBy(xpath = "//td[text()='2018']/following::td[@aria-label='May 2018']")
	WebElement btn_MonthApplicable;
	
	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]/following::td[17]/span")
	WebElement btn_Date_1stInsApplicabledate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[1]/td[6]/following::button[1]")
	WebElement btnCalendar_1stInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	WebElement btn_MonthYear_1stInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]/following::td[5]/span")
	WebElement btn_Date_1stInsDuedate;

	/*
	 * 2nd Installment details
	 */

	// @FindBy(xpath = "//div[@id='md-date-pane-3']/div[2]//div/table/tbody[1]")
	// WebElement monthApril2017;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[2]/td[3]/following::button[1]")
	WebElement btnCalendar_2ndInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	WebElement btn_MonthYear_2ndInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]/following::td[1]/span")
	WebElement btn_Date_2ndInsFromdate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[2]/td[4]/following::button[1]")
	WebElement btnCalendar_2ndInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear_2ndInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[33]/span")
	WebElement btn_Date_2ndInsTodate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[2]/td[5]/following::button[1]")
	WebElement btnCalendar_2ndInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	WebElement btn_MonthYear_2ndInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]/following::td[15]/span")
	WebElement btn_Date_2ndInsApplicabledate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[2]/td[6]/following::button[1]")
	WebElement btnCalendar_2ndInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
	WebElement btn_MonthYear_2ndInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]/following::td[6]/span")
	WebElement btn_Date_2ndInsDuedate;

	/*
	 * 3rd Installment details
	 */

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[3]/td[3]/following::button[1]")
	WebElement btnCalendar_3rdInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
	WebElement btn_MonthYear_3rdInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]/following::td[2]/span")
	WebElement btn_Date_3rdInsFromdate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[3]/td[4]/following::button[1]")
	WebElement btnCalendar_3rdInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]")
	WebElement btn_MonthYear_3rdInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Nov 2018')]/following::td[31]/span")
	WebElement btn_Date_3rdInsTodate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[3]/td[5]/following::button[1]")
	WebElement btnCalendar_3rdInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
	WebElement btn_MonthYear_3rdInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]/following::td[16]/span")
	WebElement btn_Date_3rdInsApplicabledate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[3]/td[6]/following::button[1]")
	WebElement btnCalendar_3rdInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]")
	WebElement btn_MonthYear_3rdInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]/following::td[8]/span")
	WebElement btn_Date_3rdInsDuedate;

	/*
	 * 4th Installment details
	 */

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[4]/td[3]/following::button[1]")
	WebElement btnCalendar_4thInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]")
	WebElement btn_MonthYear_4thInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]/following::td[4]/span")
	WebElement btn_Date_4thInsFromdate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[4]/td[4]/following::button[1]")
	WebElement btnCalendar_4thInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Jan 2019')]")
	WebElement btn_MonthYear_4thInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Jan 2019')]/following::td[33]/span")
	WebElement btn_Date_4thInsTodate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[4]/td[5]/following::button[1]")
	WebElement btnCalendar_4thInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]")
	WebElement btn_MonthYear_4thInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Dec 2018')]/following::td[18]/span")
	WebElement btn_Date_4thInsApplicabledate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[4]/td[6]/following::button[1]")
	WebElement btnCalendar_4thInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]")
	WebElement btn_MonthYear_4thInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]/following::td[7]/span")
	WebElement btn_Date_4thInsDuedate;

	/*
	 * 5th Installment details
	 */
	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[5]/td[3]/following::button[1]")
	WebElement btnCalendar_5thInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]")
	WebElement btn_MonthYear_5thInsFromdate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]/following::td[3]/span")
	WebElement btn_Date_5thInsFromdate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[5]/td[4]/following::button[1]")
	WebElement btnCalendar_5thInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Mar 2019')]")
	WebElement btn_MonthYear_5thInsTodate;

	@FindBy(xpath = "//span[contains(text(),'Mar 2019')]/following::td[33]/span")
	WebElement btn_Date_5thInsTodate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[5]/td[5]/following::button[1]")
	WebElement btnCalendar_5thInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]")
	WebElement btn_MonthYear_5thInsApplicabledate;

	@FindBy(xpath = "//span[contains(text(),'Feb 2019')]/following::td[17]/span")
	WebElement btn_Date_5thInsApplicabledate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr[5]/td[6]/following::button[1]")
	WebElement btnCalendar_5thInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Apr 2019')]")
	WebElement btn_MonthYear_5thInsDuedate;

	@FindBy(xpath = "//span[contains(text(),'Apr 2019')]/following::td[6]/span")
	WebElement btn_Date_5thInsDuedate;

	@FindBy(xpath = "//input[@ng-model='searchvalue1']")
	WebElement input_Search_InstDueDate;

	@FindBy(xpath = "(//div[@class='box-body']/table)[4]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//button[contains(text(),'Yes, Delete it')]")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_MaxMasterInstallmentDueDate;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	WebElement btnMin_MaxFeeMasterInstallmentGridView;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[6]")
	WebElement btnMin_MaxFeeInstallmentDueDateGridView;

	@FindBy(xpath = "(//div[@class='box-body']/table)[4]/thead/tr/th[3]/a")
	WebElement btnSortByInstallmentName;
	
	@FindBy(xpath = "//table/tbody/tr/td[3]")
	List<WebElement> list_InstallmentName;
	

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */

	public Masters_Fee_Installment_MasterInstallment_DueDate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Home button verification/display
	 * 
	 * @return
	 */
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

	public void navigateToFeeInstallment_MasterInstallmentDueDate() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeInstallment);
		log("Clicked on Fee Installment Button and object is:-" + btnFeeInstallment.toString());

		clickOnButton(tab_MasterInstallmentDueDate);
		log("Clicked on Fee Installment due date tab and object is:-" + tab_MasterInstallmentDueDate.toString());

	}

	public boolean verifyFeeInstallmentScreen_DueDate() {
		try {
			System.out.println(txtFeeInstallmentScreen.getText());
			txtFeeInstallmentScreen.isDisplayed();
			log("Fee Installment screen page is dispalyed and object is:-" + txtFeeInstallmentScreen.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void selectAcademicYearAndInstallmentType(String academicYear, String installmentType) throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("Selected Academic Year:-" + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_MasterInstallment, installmentType);
		log("Selected installment type:-" + installmentType + " and object is:- " + sel_MasterInstallment.toString());

	}

	public void dueDate_FirstInstallment_CalendarEntry() throws Exception {
		// btnCalendar.click();
		// Thread.sleep(2000);
		//
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// thirdApril2017);
		// Thread.sleep(2000);
		// thirdApril2017.click();

		clickOnButton(btnCalendar_1stInsFromdate);
		clickOnButton(btn_MonthYear);
		Thread.sleep(500);
		clickOnButton(btn_MonthFrom);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_1stInsFromdate);
		Thread.sleep(500);
		btn_Date_1stInsFromdate.click();
		log("First Installment From date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_1stInsTodate);
		clickOnButton(btn_MonthYear);
		clickOnButton(btn_MonthTo);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_1stInsTodate);
		Thread.sleep(500);
		btn_Date_1stInsTodate.click();
		log("First Installment To date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_1stInsApplicabledate);
		
//		clickOnButton(btn_MonthYear);
//		Thread.sleep(500);
//		clickOnButton(btn_MonthApplicable);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_MonthYear_1stInsApplicabledate);
		Thread.sleep(500);
		btn_Date_1stInsApplicabledate.click();
		log("First Installment Applicable date is selected from calender.");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_1stInsDuedate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_1stInsDuedate);
		Thread.sleep(500);
		btn_Date_1stInsDuedate.click();
		log("First Installment Due date is selected from calender.");

	}

	public void dueDate_SecondInstallment_CalendarEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_2ndInsFromdate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_2ndInsFromdate);
		Thread.sleep(500);
		btn_Date_2ndInsFromdate.click();
		log("Second Installment From date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_2ndInsTodate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_2ndInsTodate);
		Thread.sleep(500);
		btn_Date_2ndInsTodate.click();
		log("Second Installment To date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_2ndInsApplicabledate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_MonthYear_2ndInsApplicabledate);
		Thread.sleep(500);
		btn_Date_2ndInsApplicabledate.click();
		log("Second Installment Applicable date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_2ndInsDuedate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_2ndInsDuedate);
		Thread.sleep(500);
		btn_Date_2ndInsDuedate.click();
		log("Second Installment Due date is selected from calender.");

	}

	public void dueDate_ThirdInstallment_CalendarEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_3rdInsFromdate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_3rdInsFromdate);
		Thread.sleep(500);
		btn_Date_3rdInsFromdate.click();
		log("Third Installment From date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_3rdInsTodate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_3rdInsTodate);
		Thread.sleep(500);
		btn_Date_3rdInsTodate.click();
		log("Third Installment To date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_3rdInsApplicabledate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_MonthYear_3rdInsApplicabledate);
		Thread.sleep(500);
		btn_Date_3rdInsApplicabledate.click();
		log("Third Installment Applicable date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_3rdInsDuedate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_3rdInsDuedate);
		Thread.sleep(500);
		btn_Date_3rdInsDuedate.click();
		log("Third Installment Due date is selected from calender.");

	}

	public void dueDate_FourthInstallment_CalendarEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_4thInsFromdate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_4thInsFromdate);
		Thread.sleep(500);
		btn_Date_4thInsFromdate.click();
		log("Fourth Installment From date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_4thInsTodate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_4thInsTodate);
		Thread.sleep(500);
		btn_Date_4thInsTodate.click();
		log("Fourth Installment To date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_4thInsApplicabledate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_MonthYear_4thInsApplicabledate);
		Thread.sleep(500);
		btn_Date_4thInsApplicabledate.click();
		log("Fourth Installment Applicable date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_4thInsDuedate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_4thInsDuedate);
		Thread.sleep(500);
		btn_Date_4thInsDuedate.click();
		log("Fourth Installment Due date is selected from calender.");

	}

	public void dueDate_FifthInstallment_CalendarEntry() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_5thInsFromdate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_5thInsFromdate);
		Thread.sleep(500);
		btn_Date_5thInsFromdate.click();
		log("Fifth Installment From date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_5thInsTodate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_5thInsTodate);
		Thread.sleep(500);
		btn_Date_5thInsTodate.click();
		log("Fifth Installment To date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_5thInsApplicabledate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				btn_MonthYear_5thInsApplicabledate);
		Thread.sleep(500);
		btn_Date_5thInsApplicabledate.click();
		log("Fifth Installment Applicable date is selected from calender.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnCalendar_5thInsDuedate);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_5thInsDuedate);
		Thread.sleep(500);
		btn_Date_5thInsDuedate.click();
		log("Fifth Installment Due date is selected from calender.");

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btn_Save_MasterInstallmentDueDate);
		log("clicked on save button and object is:-" + btn_Save_MasterInstallmentDueDate.toString());
		Thread.sleep(2000);

	}

	public void clickOnCancelButton_ToClearedFilledForm() throws Exception {

		clickOnButton(btn_Cancel_MasterInstallmentDueDate);
		log("clicked on cancel button to cleared filled data and object is:-"
				+ btn_Cancel_MasterInstallmentDueDate.toString());

	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText().trim());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());

	}

	/**
	 * Search with the Fee Installment name in the grid
	 * 
	 * @param installmentName
	 * @throws Exception
	 */

	public void searchBy_InstallmentName_InFeeInstallmentDueDateGridView(String installmentName) throws Exception {

		inputTextIntoInputField(input_Search_InstDueDate, installmentName);
		log("Entered Fee Installment Name:" + installmentName + " and object is:-"
				+ input_Search_InstDueDate.toString());

	}

	/**
	 * verify Fee Installment Name in The Grid
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void verifyMasterFeeInstallmentName_UpdatedInGrid(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[3]"))
						.getText().trim();
				System.out.println("Created Fee Installment Master " + feeinstallment);
				Thread.sleep(1000);
				if (feeinstallment.equals(installmentName)) {
					Assert.assertEquals(feeinstallment, installmentName);
					log("Master Fee Installment name is update in the grid:" + feeinstallment);
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit Master fee Installment name created
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void edit_MasterFeeInstallmentDueDate(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
				String feeinstallmentname = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[3]"))
						.getText().trim();
				System.out.println("Fee Installment name:- " + installmentName);
				Thread.sleep(1000);
				if (feeinstallmentname.equals(installmentName)) {
				Assert.assertEquals(feeinstallmentname, installmentName);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[8]/a[1]"))
						.click();
				log("Clicked on edit link for corresponding Master Fee Installment name in grid");
				Thread.sleep(1000);
				 break;
				}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletion of Master Fee Installment due date from grid
	 * 
	 * @param installmentName
	 * @throws Exception
	 */
	public void deletionOf_MasterFeeInstallmentDueDateFromGrid(String installmentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
				String feeinstallment = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[3]"))
						.getText().trim();
				System.out.println("Created Fee Group Master " + feeinstallment);
				Thread.sleep(1000);
				if (feeinstallment.equals(installmentName)) {
				Assert.assertEquals(feeinstallment, installmentName);
				WebElement deleteLink = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[8]/a[2]"));
				String DeleteText = deleteLink.getAttribute("title");
				System.out.println("Tool tip text present :- " + DeleteText);

				// Compare toll tip text
				Assert.assertEquals(DeleteText, "Delete");
				
				deleteLink.click();
				log("Clicked on delete link in Master fee Installment Due Date grid");
				Thread.sleep(1000);
				break;
				}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Confirmation validation for delete
	 * 
	 * @throws Exception
	 */

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes delete it button and object is:-" + btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());

	}

	public void minimizeAndMaximize_MasterInstallmentDueDate() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtFeeInstallmentScreen);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxMasterInstallmentDueDate);
		log("clicked on master Installment Due date minimize and maximize button and object is:-"
				+ btnMin_MaxMasterInstallmentDueDate.toString());

	}

	public void minimizeAndMaximize_FeeMasterInstallmentGridView() throws Exception {

		clickOnButton(btnMin_MaxFeeMasterInstallmentGridView);
		log("Master Fee Installment grid table data minimize and maximize and object is:-"
				+ btnMin_MaxFeeMasterInstallmentGridView.toString());

	}

	public void minimizeAndMaximize_FeeMasterInstallmentDueDateGridView() throws Exception {

		clickOnButton(btnMin_MaxFeeInstallmentDueDateGridView);
		log("Fee Master Installment Due date grid view table data minimize and maximize and object is:-"
				+ btnMin_MaxFeeInstallmentDueDateGridView.toString());

	}

	public void sortByMasterInstallmentName() throws Exception {

		clickOnButton(btnSortByInstallmentName);
		SortData_InColumn_AscendingOrder(list_InstallmentName);
		log("Sorted the record with Fee Installment name in asceding order and object is:-" + btnSortByInstallmentName.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated for edit.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeleteCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deletion Cancelled");
			log("Record deleted Cancel message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeletedSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
