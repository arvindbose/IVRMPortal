/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Yearly_Fee_Defaulter_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Yearly_Fee_Defaulter_Report.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
	// WebElement btn_YearlyFeeDefaulterReport;

	@FindBy(xpath = "//a[@href='#/app/FeeDefaulterReport/203']")
	WebElement btn_YearlyFeeDefaulterReport;

	@FindBy(xpath = "//div//section//ol//li")
	WebElement txt_YearlyFeeDefaulterReport;

	@FindBy(xpath = "//span[contains(text(),'Yearly Wise')]/preceding-sibling::input")
	WebElement rdBtn_YearlyWise;

	@FindBy(xpath = "//span[contains(text(),'Date Wise')]/preceding-sibling::input")
	WebElement rdBtn_DateWise;

	@FindBy(xpath = "//span[contains(text(),'Fee Group Wise')]/preceding-sibling::input")
	WebElement rdBtn_FeeGroupWise;

	@FindBy(xpath = "//span[contains(text(),'Fee Head Wise')]/preceding-sibling::input")
	WebElement rdBtn_FeeHeadWise;

	@FindBy(xpath = "//span[contains(text(),'Class Wise')]/preceding-sibling::input")
	WebElement rdBtn_ClassWise;

	@FindBy(xpath = "//span[contains(text(),'Student Wise')]/preceding-sibling::input")
	WebElement rdBtn_StudentWise;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//span[contains(text(),'Bus Route :')]/preceding-sibling::input")
	WebElement chk_BusRoute;

	@FindBy(xpath = "//span[contains(text(),'Bus Route :')]/following::div[1]//select")
	WebElement sel_BusRoute;

	@FindBy(xpath = "//div[@class='multiselect col-sm-6']//label//input[@name='fee_ct1']")
	List<WebElement> Chk_CustomGroup;

	@FindBy(xpath = "//div[@class='multiselect col-sm-6']//label//input[@name='fee_gp1']")
	List<WebElement> Chk_FeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Class :')]/preceding-sibling::input")
	WebElement chk_Class;

	@FindBy(xpath = "//span[contains(text(),'Class :')]//following::div[1]//select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]//following::div[1]//select")
	WebElement sel_Section;

	@FindBy(xpath = "//span[contains(text(),'Active')]/preceding-sibling::input")
	WebElement chk_Active;

	@FindBy(xpath = "//span[contains(text(),'Deactive')]/preceding-sibling::input")
	WebElement chk_De_Active;

	@FindBy(xpath = "//span[contains(text(),'Left')]/preceding-sibling::input")
	WebElement chk_Left;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@class='input-group']//input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='input-group']//child::select")
	WebElement sel_Search_Filter;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxFeeDefaulterReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxFeeDefaulterReportGrid;

	@FindBy(xpath = "//div[@id='table2']/table//thead//tr//th[3]/a")
	WebElement btnSortByGroupName;

	@FindBy(xpath = "//span[contains(text(),'SMS')]//parent::button")
	WebElement btn_SMS;

	@FindBy(xpath = "//span[contains(text(),'Email')]//parent::button")
	WebElement btn_Email;

	@FindBy(xpath = "//span[text()='Due Date']/preceding-sibling::input")
	WebElement rdBtn_DueDate;

	@FindBy(xpath = "//span[text()='Till Due Date']/preceding-sibling::input")
	WebElement rdBtn_TillDueDate;

	@FindBy(xpath = "(//label[text()=' Date:']//following-sibling::div//child::button)[1]")
	WebElement btn_Calander;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//div[@id='table2']//table//tbody//tr//td[1]//input")
	List<WebElement> Chk_FeeDefaulterReportGrid_FeeGrWise;

	@FindBy(xpath = "//div[@id='table3']//table//tbody//tr//td[1]//input")
	List<WebElement> Chk_FeeDefaulterReportGrid_FeeHeadWise;

	@FindBy(xpath = "//div[@id='table4']//table//tbody//tr//td[1]//input")
	List<WebElement> Chk_FeeDefaulterReportGrid_ClassWise;

	@FindBy(xpath = "//div[@id='table1']//table//tbody//tr//td[1]//input")
	List<WebElement> Chk_FeeDefaulterReportGrid_StudentWise;

	@FindBy(xpath = "//div[@ng-show='Grid_view']/div/h3")
	WebElement grid_HeaderName;

	public Yearly_Fee_Defaulter_Report(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Fee > Reports > Yearly Fee Defaulter report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_YearlyFeeDefaulterReport() throws Exception {
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_YearlyFeeDefaulterReport);
		log("Clicked on Yearly Fee Defaulter Report Button in navigation panel and object is:-"
				+ btn_YearlyFeeDefaulterReport.toString());

	}

	/**
	 * Validation of Fee > Reports > Yearly Fee Defaulter Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_YearlyFeeDefaulterReport_Page() {
		try {
			System.out.println(txt_YearlyFeeDefaulterReport.getText().trim());
			txt_YearlyFeeDefaulterReport.isDisplayed();
			log("Yearly Fee Defaulter Report page text is dispalyed and object is:-"
					+ txt_YearlyFeeDefaulterReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_YearlyFeeDefaulterReportForm() throws Exception {

		clickOnButton(btn_Report);
		log("Submit blank YearlyFeeDefaulterReport form and object is:-" + btn_Report.toString());
		Thread.sleep(1000);

	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise without selecting class
	 * and section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise without selecting class
	 * and section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active check box button already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise without selecting class
	 * and section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active check box button already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise without selecting class and
	 * section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active check box button already checked.");
			Thread.sleep(500);
		}

	}

	/*
	 * Generate report for Yearly Wise, Student Wise without selecting class and
	 * section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active check box button already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise without selecting class
	 * and section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left checked box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise, selecting class and
	 * section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise, selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise without selecting class
	 * and section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise without selecting class
	 * and section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise, selecting class and
	 * section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise, selecting class and
	 * section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeGroupWise);
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise, selecting class and
	 * section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise, selecting class and section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise, selecting class and
	 * section
	 * 
	 * For De-Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("De-Active Student check box is checked and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("DeActive check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise, selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass(String academicYear,
			String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_FeeHeadWise);
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise without selecting class and
	 * section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise without selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise, selecting class and section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass(String academicYear,
			String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise, selecting class and section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass(String academicYear,
			String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise without selecting class and
	 * section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise without selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent(String academicYear)
			throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise, selecting class and
	 * section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student check box is checked and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active check box is already checked.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise, selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass(String academicYear,
			String select_class, String section) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_StudentWise);
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		try {
			int no_Of_CustomGroup = Chk_CustomGroup.size();
			for (int i = 0; i < no_Of_CustomGroup; i++) {
				if (!Chk_CustomGroup.get(i).isSelected()) {
					Chk_CustomGroup.get(i).click();
					log(i + " Custom Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Custom Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int no_Of_FeeGroup = Chk_FeeGroup.size();
			for (int i = 0; i < no_Of_FeeGroup; i++) {
				if (!Chk_FeeGroup.get(i).isSelected()) {
					Chk_FeeGroup.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		isDisplayed(chk_Class);
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Class, select_class);
		log("selected class: " + select_class + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student check box is checked and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left check box is already checked");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_YearlyFeeDefaulterReport() throws Exception {

		clickOnButton(btn_Report);
		log("Yearly Fee Defaulter Report is generated and object is:-" + btn_Report.toString());
		Thread.sleep(1000);
		assertEquals(grid_HeaderName.getText().trim(), "FEE DEFAULTER REPORT");
		Thread.sleep(1000);
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("Yearly Fee Defaulter report filled form data is cleared and object is:-" + btn_Cancel.toString());
		Thread.sleep(1000);

	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_YearlyFeeDefaulterReport);
		Thread.sleep(1000);

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
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
				Thread.sleep(5000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
	}

	public void clickOnSMSButton_StudentWiseReport() throws Exception {

		clickOnButton(btn_SMS);
		log("SMS is sent for selected student and object is:-" + btn_SMS.toString());
		Thread.sleep(500);
	}

	public void clickOnEmailButton_StudentWiseReport() throws Exception {

		clickOnButton(btn_Email);
		log("Email is sent for selected student and object is:-" + btn_Email.toString());
		Thread.sleep(500);

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void min_Max_FeeDefaulterReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_YearlyFeeDefaulterReport);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxFeeDefaulterReport);
		log("Fee Defaulter Report page minimized or maximized and object is:-"
				+ btnMin_MaxFeeDefaulterReport.toString());

	}

	public void min_Max_FeeDefaulterReport_Grid() throws Exception {

		clickOnButton(btnMin_MaxFeeDefaulterReportGrid);
		log("Fee Defaulter Report Grid page minimized or maximized and object is:-"
				+ btnMin_MaxFeeDefaulterReportGrid.toString());

	}

	public void searchWithGroupName_InYearlyFeeDefaulterReportGrid(String groupName) throws Exception {

		inputTextIntoInputField(input_Search, groupName);
		log("Entered Group Name to search: " + groupName + " and object is:-" + input_Search.toString());

	}

	public void sortRecordsByGroupName() throws Exception {

		clickOnButton(btnSortByGroupName);
		log("Sorted the record with Group name and object is:-" + btnSortByGroupName.toString());

	}

	public void selectRecordToGenerateReport_FeeGroupWise() throws Exception {
		try {
			int no_Of_Record = Chk_FeeDefaulterReportGrid_FeeGrWise.size();
			for (int i = 0; i < no_Of_Record; i++) {
				if (!Chk_FeeDefaulterReportGrid_FeeGrWise.get(i).isSelected()) {
					Chk_FeeDefaulterReportGrid_FeeGrWise.get(i).click();
					log(i + " Fee Group Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Group name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecordToGenerateReport_FeeHeadWise() throws Exception {
		try {
			int no_Of_Record = Chk_FeeDefaulterReportGrid_FeeHeadWise.size();
			for (int i = 0; i < no_Of_Record; i++) {
				if (!Chk_FeeDefaulterReportGrid_FeeHeadWise.get(i).isSelected()) {
					Chk_FeeDefaulterReportGrid_FeeHeadWise.get(i).click();
					log(i + " Fee Head Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Fee Head name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecordToGenerateReport_ClassWise() throws Exception {
		try {
			int no_Of_Record = Chk_FeeDefaulterReportGrid_ClassWise.size();
			for (int i = 0; i < no_Of_Record; i++) {
				if (!Chk_FeeDefaulterReportGrid_ClassWise.get(i).isSelected()) {
					Chk_FeeDefaulterReportGrid_ClassWise.get(i).click();
					log(i + " Class Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Class name checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectRecordToGenerateReport_StudentWise() throws Exception {
		try {
			int no_Of_Record = Chk_FeeDefaulterReportGrid_StudentWise.size();
			for (int i = 0; i < no_Of_Record; i++) {
				if (!Chk_FeeDefaulterReportGrid_StudentWise.get(i).isSelected()) {
					Chk_FeeDefaulterReportGrid_StudentWise.get(i).click();
					log(i + " Student Name check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Student name checked box is already checked.");
					Thread.sleep(500);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
