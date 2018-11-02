/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
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
public class Reports_Daily_Collection_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Reports_Daily_Collection_Report.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;
	
	@FindBy(xpath = "//a[@href='#/app/DailyFeeCollReport/205']")
	WebElement btnDailyCollectionReports;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtDailyCollectionReportsMsgDispaly;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/input)[1]")
	WebElement rdBtnLeftAll;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[2]/input)[1]")
	WebElement rdBtnIndividual;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[3]")
	WebElement selClass;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[1]")
	WebElement selAcademicYr;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/input)[2]")
	WebElement chkGroup;

	@FindBy(xpath = "//span[contains(text(),'suresh fee group1')]/preceding-sibling::input")
	WebElement chkGroupName;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/input)[4]")
	WebElement rdBtnRightAll;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/input)[5]")
	WebElement rdBtnPayModeAll;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[2]/input)[3]")
	WebElement rdBtnStudent;

	@FindBy(xpath = "//md-datepicker[@id='date1']/button")
	WebElement btnfromDate;

	@FindBy(xpath = "//md-datepicker[@id='date2']/button")
	WebElement btnToDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/input)[7]")
	WebElement chkClass;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnReport;

	@FindBy(xpath = "//body[@id='style-4']//div[1]/div[2]/div[2]/button[2]")
	WebElement btnCancel;

	@FindBy(xpath = "//td[@id='md-0-month-2017-11-1']/span")
	WebElement fromDate;

	/*
	 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy"); Date today =
	 * Calendar.getInstance().getTime(); String date = dateFormat.format(today);
	 */

	@FindBy(xpath = "//td[@id='md-0-month-2017-11-30']/span")
	WebElement toDate;

	@FindBy(xpath = "//md-datepicker[@id='date1']/div[1]/input")
	WebElement enterFromDate;

	@FindBy(xpath = "//md-datepicker[@id='date2']/div[1]/input")
	WebElement enterToDate;

	@FindBy(xpath = "//div[@id='gridind']/div[1]/a[1]")
	WebElement btnExportToExcel;

	@FindBy(xpath = "//div[@id='gridind']/div[1]/a[2]")
	WebElement btnExportToPdf;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Reports_Daily_Collection_Report(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify home button
	 * 
	 * @return
	 */
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
	 * Navigate to Daily Collection report page 1. Click on fee button 2.Click
	 * on reports 3.Clcik on Daily Collection report
	 * 
	 * @throws Exception
	 */
	public void nevigateToReports_Daily_CollectionReports() throws Exception {
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btnDailyCollectionReports);
		log("Clicked on Daily collection reports Button and object is:-" + btnDailyCollectionReports.toString());

	}

	/**
	 * Verify Daily Collection Report message displayed on the screen
	 * 
	 * @return
	 */
	public boolean verifyDailyCollectionReportsPage() {
		try {
			System.out.println(txtDailyCollectionReportsMsgDispaly.getText());
			txtDailyCollectionReportsMsgDispaly.isDisplayed();
			log("Daily collection reports page is dispalyed and object is:-"
					+ txtDailyCollectionReportsMsgDispaly.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter the required information to generate reports
	 * 
	 * @param academicYear
	 * @param class_Stu
	 * @param fromDate
	 * @param toDate
	 * @throws Exception
	 */
	public void requiredInfoToGenerateDailyCollectionReports(String academicYear, String class_Stu, String fromDate,
			String toDate) throws Exception {

		if (!rdBtnIndividual.isSelected()) {
			rdBtnIndividual.click();
			log("clicked on individual radio button and object is:-" + rdBtnIndividual.toString());
			Thread.sleep(2000);
		} else {
			log("Individual radio button is already selected and object is:-" + rdBtnIndividual.toString());
		}
		select = new Select(selAcademicYr);
		select.selectByVisibleText(academicYear);
		log("selected academic year:-" + academicYear + " and object is " + selAcademicYr.toString());
		Thread.sleep(2000);

		WebElement option = select.getFirstSelectedOption();
		System.out.println("Class--" + option.getText());
		Assert.assertEquals(option.getText(), academicYear);

		if (!chkGroup.isSelected()) {
			chkGroup.click();
			log("clicked on group checkbox and object is:-" + chkGroup.toString());
			Thread.sleep(2000);
		} else {
			log("Group check box is already selected and object is:-" + chkGroup.toString());
		}
		if (!chkGroupName.isSelected()) {
			chkGroupName.click();
			log("clicked on group name checkbox and object is:-" + chkGroupName.toString());
			Thread.sleep(2000);
		} else {
			log("Group name check box is already selected and object is:-" + chkGroupName.toString());
		}
		if (!rdBtnStudent.isSelected()) {
			rdBtnStudent.click();
			log("clicked on student radio button and object is:-" + rdBtnStudent.toString());
			Thread.sleep(2000);
		} else {
			log("Student radio button is already selected and object is:-" + rdBtnStudent.toString());
		}

		copyToClipbord(fromDate);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(enterFromDate);
		oAction.contextClick(enterFromDate).build().perform(); // this will
																// perform right
																// click

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered from date " + fromDate + " and object is:-" + enterFromDate.toString());
		Thread.sleep(2000);

		copyToClipbord(toDate);

		oAction.moveToElement(enterToDate);
		oAction.contextClick(enterToDate).build().perform(); // this will
																// perform right
																// click

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered to date " + toDate + " and object is:-" + enterToDate.toString());
		Thread.sleep(2000);

		if (!chkClass.isSelected()) {
			chkClass.click();
			log("clicked on class checkbox and object is:-" + chkClass.toString());
			Thread.sleep(2000);
		} else {
			log("class check box is already selected and object is:-" + chkClass.toString());
		}

		select = new Select(selClass);
		select.selectByVisibleText(class_Stu);
		log("selected class:-" + class_Stu + " and object is " + selClass.toString());
		Thread.sleep(2000);
		WebElement optionLkg = select.getFirstSelectedOption();
		System.out.println("Class--" + option.getText());
		Assert.assertEquals(optionLkg.getText(), class_Stu);
	}

	/**
	 * click on report button to generate report
	 * 
	 */
	public void generateReportsByClickingOnReportButton() {

		btnReport.click();
		log("Clicked on report button to generate report and object is:-" + btnReport.toString());
		waitForElement(driver, 10, btnExportToExcel);
	}

	/**
	 * click on export excel report
	 * 
	 * @throws Exception
	 */
	public void downloadExcelReport() throws Exception {

		btnExportToExcel.click();
		log("Clicked on export to excel download link and object is:-" + btnExportToExcel.toString());
		Thread.sleep(2000);
	}

	/**
	 * click on export pdf reports
	 * 
	 * @throws Exception
	 */
	public void downloadPdfReport() throws Exception {

		btnExportToPdf.click();
		log("Clicked on export to pdf download link and object is:-" + btnExportToPdf.toString());
		Thread.sleep(2000);
	}
}
