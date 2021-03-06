/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.Reports;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class PreAdmission_StudentCountReport extends TestBase {

	public static final Logger log = Logger.getLogger(PreAdmission_StudentCountReport.class.getName());

	private WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_Preadmission_Reports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[2]")
	// private WebElement btn_StudentCountReport;

	@FindBy(xpath = "//a[@href='#/app/totalcount/41']")
	private WebElement btn_StudentCountReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_StudentCountReportPage;

	@FindBy(xpath = "//input[@name='yorb' and @value='yearwise']")
	private WebElement rdBtn_YearWise;

	@FindBy(xpath = "//input[@name='yorb' and @value='btwdates']")
	private WebElement rdBtn_BetweenDates;

	@FindBy(xpath = "//span[text()='Registered List']/preceding-sibling::input")
	private WebElement rdBtn_RegisteredList;

	@FindBy(xpath = "//span[text()='Registered but not filled Application form']/preceding-sibling::input")
	private WebElement rdBtn_RegisteredbutnotfilledApplicationform;

	@FindBy(xpath = "//span[text()='Registered and filled Application form']/preceding-sibling::input")
	private WebElement rdBtn_RegisteredandfilledApplicationform;

	@FindBy(xpath = "//span[text()='Registration payment Done List']/preceding-sibling::input")
	private WebElement rdBtn_RegistrationpaymentDoneList;

	@FindBy(xpath = "//span[text()='Registration payment Not Done List']/preceding-sibling::input")
	private WebElement rdBtn_RegistrationpaymentNotDoneList;

	@FindBy(xpath = "//span[text()='Transfer student(Admission Confirm)']/preceding-sibling::input")
	private WebElement rdBtn_Transferstudent;

	@FindBy(xpath = "(//label[contains(text(),'From Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_FromCalender;

	@FindBy(xpath = "//span[contains(text(),'May 2018')]")
	private WebElement btn_MonthYear_From;
	
	@FindBy(xpath = "//span[contains(text(),'Aug 2018')]")
	private WebElement btn_MonthYear_From2;

	@FindBy(xpath = "//span[contains(text(),'May 2018')]/following::td[3]")
	private WebElement btn_Date_From;

	@FindBy(xpath = "(//label[contains(text(),'To Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_ToCalender;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	private WebElement btn_MonthYear_To;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[8]")
	private WebElement btn_Date_To;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div//select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//span[contains(text(),'Search')]/parent::button")
	private WebElement btn_Search;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	private WebElement input_search;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[1]//input")
	private WebElement chk_selectAll;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[1]//input")
	private WebElement chk_FirstRecord;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[3]")
	private WebElement validate_searchedUserOrStudent;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_Details;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_StudentCountReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_Max_StudentCountReportGrid;

	public PreAdmission_StudentCountReport(WebDriver driver) {
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
	 * Navigate to PreAdmission > PreAdmission Report > Student Count Report
	 * 
	 * @throws Exception
	 */
	public void navigateToPreAdmission_StudentCountReport() throws Exception {

		clickOnButton(btn_PreAdmission);
		log("Clicked on PreAdmission Button and object is:-" + btn_PreAdmission.toString());

		clickOnButton(btn_Preadmission_Reports);
		log("Clicked on PreAdmission Reports and object is:-" + btn_Preadmission_Reports.toString());

		clickOnButton(btn_StudentCountReport);
		log("Clicked on Student count report to open page and object is:-" + btn_StudentCountReport.toString());

	}

	/**
	 * Validation ofPreAdmission > PreAdmission Report > Student Count Report
	 * page path
	 * 
	 * @return
	 */
	public boolean verifyPreAdmission_StudentCountReportPage() {
		try {
			System.out.println(txt_StudentCountReportPage.getText().trim());
			txt_StudentCountReportPage.isDisplayed();
			log("PreAdmission Student Count Report page is dispalyed and object is:-"
					+ txt_StudentCountReportPage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_PreadmissionStudentCountReportForm() throws Exception {

		clickOnButton(btn_Search);
		log("Submit blank Preadmission Student Count Report form and object is:-" + btn_Search.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Registered list
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList(String academicYear) throws Exception {
		isDisplayed(rdBtn_RegisteredList);
		if (!rdBtn_RegisteredList.isSelected()) {
			rdBtn_RegisteredList.click();
			log("Registered List radio button is selected and object is:-" + rdBtn_RegisteredList.toString());
			Thread.sleep(1000);
		} else {
			log("Registered List radio button is already selected and object is:-" + rdBtn_RegisteredList.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Registered but not filled
	 * Application form
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform(
			String academicYear) throws Exception {
		isDisplayed(rdBtn_RegisteredbutnotfilledApplicationform);
		if (!rdBtn_RegisteredbutnotfilledApplicationform.isSelected()) {
			rdBtn_RegisteredbutnotfilledApplicationform.click();
			log("Registered but not filled Application form radio button is selected and object is:-"
					+ rdBtn_RegisteredbutnotfilledApplicationform.toString());
			Thread.sleep(1000);
		} else {
			log("Registered but not filled Application form radio button is already selected and object is:-"
					+ rdBtn_RegisteredbutnotfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Registered and filled
	 * Application form
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform(
			String academicYear) throws Exception {
		isDisplayed(rdBtn_RegisteredandfilledApplicationform);
		if (!rdBtn_RegisteredandfilledApplicationform.isSelected()) {
			rdBtn_RegisteredandfilledApplicationform.click();
			log("Registered and filled Application form radio button is selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(1000);
		} else {
			log("Registered and filled Application form radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Registration payment Done
	 * List
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_RegistrationpaymentDoneList);
		if (!rdBtn_RegistrationpaymentDoneList.isSelected()) {
			rdBtn_RegistrationpaymentDoneList.click();
			log("Registration payment Done List radio button is selected and object is:-"
					+ rdBtn_RegistrationpaymentDoneList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration payment Done List radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Registration payment Not
	 * Done List
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_RegistrationpaymentNotDoneList);
		if (!rdBtn_RegistrationpaymentNotDoneList.isSelected()) {
			rdBtn_RegistrationpaymentNotDoneList.click();
			log("Registration payment Not Done List radio button is selected and object is:-"
					+ rdBtn_RegistrationpaymentNotDoneList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration payment Not Done List radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	/**
	 * PreAdmission Student Count Report, YearWise, Transfer student(Admission
	 * Confirm)
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_Transferstudent);
		if (!rdBtn_Transferstudent.isSelected()) {
			rdBtn_Transferstudent.click();
			log("Transfer student(Admission Confirm) radio button is selected and object is:-"
					+ rdBtn_Transferstudent.toString());
			Thread.sleep(1000);
		} else {
			log("Transfer student(Admission Confirm) radio button is already selected and object is:-"
					+ rdBtn_Transferstudent.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_YearWise);
		if (!rdBtn_YearWise.isSelected()) {
			rdBtn_YearWise.click();
			log("Year Wise radio button is selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(1000);
		} else {
			log("Year Wise radio button is already selected and object is:-" + rdBtn_YearWise.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

	}

	// BETWEEN DATE

	/**
	 * PreAdmission Student Count Report, Between Date, Registered list
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList() throws Exception {
		isDisplayed(rdBtn_RegisteredList);
		if (!rdBtn_RegisteredList.isSelected()) {
			rdBtn_RegisteredList.click();
			log("Registered List radio button is selected and object is:-" + rdBtn_RegisteredList.toString());
			Thread.sleep(1000);
		} else {
			log("Registered List radio button is already selected and object is:-" + rdBtn_RegisteredList.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}
		// Enter From Date
		clickOnButton(btn_FromCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From2);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
		Thread.sleep(500);
		btn_Date_From.click();
		log("From date is selected from calender.");
		Thread.sleep(1000);

		// Enter To Date
		clickOnButton(btn_ToCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
		Thread.sleep(500);
		btn_Date_To.click();
		log("To date is selected from calender.");
		Thread.sleep(1000);

	}

	/**
	 * PreAdmission Student Count Report, Between Date, Registered but not
	 * filled Application form
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform()
			throws Exception {
		isDisplayed(rdBtn_RegisteredbutnotfilledApplicationform);
		if (!rdBtn_RegisteredbutnotfilledApplicationform.isSelected()) {
			rdBtn_RegisteredbutnotfilledApplicationform.click();
			log("Registered but not filled Application form radio button is selected and object is:-"
					+ rdBtn_RegisteredbutnotfilledApplicationform.toString());
			Thread.sleep(1000);
		} else {
			log("Registered but not filled Application form radio button is already selected and object is:-"
					+ rdBtn_RegisteredbutnotfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}

		// Enter From date
		clickOnButton(btn_FromCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
		Thread.sleep(500);
		btn_Date_From.click();
		log("From date is selected from calender.");
		// Enter To Date
		clickOnButton(btn_ToCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
		Thread.sleep(500);
		btn_Date_To.click();
		log("To date is selected from calender.");

	}

	/**
	 * PreAdmission Student Count Report, Between Date, Registered and filled
	 * Application form
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform()
			throws Exception {
		isDisplayed(rdBtn_RegisteredandfilledApplicationform);
		if (!rdBtn_RegisteredandfilledApplicationform.isSelected()) {
			rdBtn_RegisteredandfilledApplicationform.click();
			log("Registered and filled Application form radio button is selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(1000);
		} else {
			log("Registered and filled Application form radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}
		// Enter From Date
		clickOnButton(btn_FromCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
		Thread.sleep(500);
		btn_Date_From.click();
		log("From date is selected from calender.");
		Thread.sleep(1000);
		// Enter To Date
		clickOnButton(btn_ToCalender);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
		Thread.sleep(500);
		btn_Date_To.click();
		log("To date is selected from calender.");
		Thread.sleep(1000);

	}

	/**
	 * PreAdmission Student Count Report, Between Date, Registration payment
	 * Done List
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList() throws Exception {
		isDisplayed(rdBtn_RegistrationpaymentDoneList);
		if (!rdBtn_RegistrationpaymentDoneList.isSelected()) {
			rdBtn_RegistrationpaymentDoneList.click();
			log("Registration payment Done List radio button is selected and object is:-"
					+ rdBtn_RegistrationpaymentDoneList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration payment Done List radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}
//Enter From date
			clickOnButton(btn_FromCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
		
//Enter To Date
			clickOnButton(btn_ToCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		
	}

	/**
	 * PreAdmission Student Count Report, Between Date, Registration payment Not
	 * Done List
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList() throws Exception {
		isDisplayed(rdBtn_RegistrationpaymentNotDoneList);
		if (!rdBtn_RegistrationpaymentNotDoneList.isSelected()) {
			rdBtn_RegistrationpaymentNotDoneList.click();
			log("Registration payment Not Done List radio button is selected and object is:-"
					+ rdBtn_RegistrationpaymentNotDoneList.toString());
			Thread.sleep(1000);
		} else {
			log("Registration payment Not Done List radio button is already selected and object is:-"
					+ rdBtn_RegisteredandfilledApplicationform.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}
//Enter From date
			clickOnButton(btn_FromCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			Thread.sleep(1000);
//Enter To Date
			clickOnButton(btn_ToCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
	
	}

	/**
	 * PreAdmission Student Count Report, BetweenDate, Transfer
	 * student(Admission Confirm)
	 * 
	 * @param academicYear
	 * @throws Exception
	 */
	public void fill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm()
			throws Exception {
		isDisplayed(rdBtn_Transferstudent);
		if (!rdBtn_Transferstudent.isSelected()) {
			rdBtn_Transferstudent.click();
			log("Transfer student(Admission Confirm) radio button is selected and object is:-"
					+ rdBtn_Transferstudent.toString());
			Thread.sleep(1000);
		} else {
			log("Transfer student(Admission Confirm) radio button is already selected and object is:-"
					+ rdBtn_Transferstudent.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_BetweenDates);
		if (!rdBtn_BetweenDates.isSelected()) {
			rdBtn_BetweenDates.click();
			log("Between Date radio button is selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(1000);
		} else {
			log("Between Date radio button is already selected and object is:-" + rdBtn_BetweenDates.toString());
			Thread.sleep(500);
		}
		//Enter From date

			clickOnButton(btn_FromCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_From);
			Thread.sleep(500);
			btn_Date_From.click();
			log("From date is selected from calender.");
			
//Enter To date
	
			clickOnButton(btn_ToCalender);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_To);
			Thread.sleep(500);
			btn_Date_To.click();
			log("To date is selected from calender.");
			Thread.sleep(1000);
		
	}

	public void clickOnSearchTo_GetRecords() throws Exception {

			clickOnButton(btn_Search);
			log("Submit filled Student Count report form and object is:-" + btn_Search.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnCancelTo_ClearFilledData_StudentCountReport() throws Exception {
		
			clickOnButton(btn_Cancel);
			log("Clear filled form and object is:-" + btn_Cancel.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnExportToExcel() throws Exception {
	
			clickOnButton(btn_ExportToExcel);
			log("Export To Excel Report button is clicked to DownLoad report and object is:-"
					+ btn_ExportToExcel.toString());
			Thread.sleep(3000);
		
	}

	public void searchWithUserName_InStudentCountReport(String userName) throws Exception {
		
			inputTextIntoInputField(input_search, userName);
			log("Entered User name:-" + userName + " and object is " + input_search.toString());
			Thread.sleep(1000);
	try{
		if (validate_searchedUserOrStudent.isDisplayed()) {
			String userOrStudent = validate_searchedUserOrStudent.getText().trim();
			assertEquals(userName, userOrStudent);
			log("First Schedule name and searched with schedule name is same and object is:-"
					+ validate_searchedUserOrStudent.toString());
			Thread.sleep(1000);
		} 
	}catch(Exception e) {
		e.printStackTrace();
			log("User Or Student not present and object is:-" + validate_searchedUserOrStudent.toString());
			Thread.sleep(500);
		}
	}

	public void generateReportForAllUser_ClickHeaderCheckBox() throws Exception {
		isDisplayed(chk_selectAll);
		if (!chk_selectAll.isSelected()) {
			chk_selectAll.click();
			log("All Records check box is selected in Student Count Report and object is:-" + chk_selectAll.toString());
			Thread.sleep(1000);
		} else {
			log("All Records check box element is already selected in Student Count Report and object is:-"
					+ chk_selectAll.toString());
			Thread.sleep(500);
		}
	}

	public void selectSpecificUser_InStudentCountReport() throws Exception {
		isDisplayed(chk_FirstRecord);
		if (!chk_FirstRecord.isSelected()) {
			chk_FirstRecord.click();
			log("First Records check box is selected in Student Count Report and object is:-"
					+ chk_FirstRecord.toString());
			Thread.sleep(1000);
		} else {
			log("First Records check box element is already selected in Student Count Report and object is:-"
					+ chk_FirstRecord.toString());
			Thread.sleep(500);
		}
	}

	public void min_Max_DetailsSection() throws Exception {
	
			clickOnButton(btn_Min_Max_Details);
			log("Details section minimized or maximized and object is:-" + btn_Min_Max_Details.toString());
			Thread.sleep(1000);
		
	}

	public void min_Max_StudentCountReportForm() throws Exception {
	
			clickOnButton(btn_Min_Max_StudentCountReport);
			log("Student Count Report Form section minimized or maximized and object is:-"
					+ btn_Min_Max_StudentCountReport.toString());
			Thread.sleep(1000);
		
	}

	public void min_Max_StudentCountReportGrid() throws Exception {
		
			clickOnButton(btn_Min_Max_StudentCountReportGrid);
			log("Student Count Report Grid section minimized or maximized and object is:-"
					+ btn_Min_Max_StudentCountReportGrid.toString());
			Thread.sleep(1000);
		
	}

	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
	
			clickOnButton(btnOKSuccess);
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(1000);
	}
}
