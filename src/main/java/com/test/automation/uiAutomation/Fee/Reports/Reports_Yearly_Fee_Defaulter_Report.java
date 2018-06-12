/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Reports;

import java.awt.Robot;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Reports_Yearly_Fee_Defaulter_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Reports_Yearly_Fee_Defaulter_Report.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
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

	@FindBy(xpath = "//div[@class='multiselect']//label//input[@name='fee_ct1']")
	List<WebElement> Chk_CustomGroup;

	@FindBy(xpath = "//div[@class='multiselect']//label//input[@name='fee_gp1']")
	List<WebElement> Chk_FeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Class :')]/preceding-sibling::input")
	WebElement chk_Class;

	@FindBy(xpath = "//span[contains(text(),'Class :')]//following::div[1]//select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]//following::div[1]//select")
	WebElement sel_Section;

	@FindBy(xpath = "//span[contains(text(),'Active')]/preceding-sibling::input")
	WebElement rdBtn_Active;

	@FindBy(xpath = "//span[contains(text(),'Left')]/preceding-sibling::input")
	WebElement rdBtn_Left;

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
	List<WebElement> Chk_FeeDefaulterReportGrid;

	public Reports_Yearly_Fee_Defaulter_Report(WebDriver driver) {
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
		if (btn_YearlyFeeDefaulterReport.isDisplayed()) {
			btn_YearlyFeeDefaulterReport.click();
			log("Clicked on Yearly Fee Defaulter Report Button in navigation panel and object is:-"
					+ btn_YearlyFeeDefaulterReport.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Fee Defaulter Report button element not present.");
			Thread.sleep(500);
		}

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
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank YearlyFeeDefaulterReport form and object is:-" + btn_Report.toString());
			Thread.sleep(7000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise without selecting class
	 * and section
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear)
			throws Exception {

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
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

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
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
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeGroupWise.isSelected()) {
			rdBtn_FeeGroupWise.click();
			log("Fee Group Wise radio button is selected and object is:- " + rdBtn_FeeGroupWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
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
		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
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
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise, selecting class and
	 * section
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass(String academicYear,
			String select_class, String section) throws Exception {

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_FeeHeadWise.isSelected()) {
			rdBtn_FeeHeadWise.click();
			log("Fee Head Wise radio button is selected and object is:- " + rdBtn_FeeHeadWise.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
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
		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
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
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Active.isSelected()) {
			rdBtn_Active.click();
			log("Active Student radio button is selected and object is:- " + rdBtn_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
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

		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
		if (!rdBtn_StudentWise.isSelected()) {
			rdBtn_StudentWise.click();
			log("Student Wise radio button is selected and object is:- " + rdBtn_StudentWise.toString());
			Thread.sleep(1000);
		} else {
			log("Student Wise Radio button already selected.");
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
		if (!chk_Class.isSelected()) {
			chk_Class.click();
			log("Class check box is checked and object is:- " + chk_Class.toString());
			Thread.sleep(1000);
		} else {
			log("Class check box already checked.");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(select_class);

			log("selected class: " + select_class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), select_class);
			Thread.sleep(1000);
		} else {
			log("Class combo box element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("Selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section combo box element is not present");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Left Student radio button is selected and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_YearlyFeeDefaulterReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Yearly Fee Defaulter Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Yearly Fee Defaulter report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
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

	public void clickOnPrint_ForPrintPreview() throws Exception {

		String parentWin = driver.getWindowHandle();

		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

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
		if (btn_SMS.isDisplayed()) {
			btn_SMS.click();
			log("SMS is sent for selected student and object is:-" + btn_SMS.toString());
			Thread.sleep(2000);
		} else {
			log("SMS button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnEmailButton_StudentWiseReport() throws Exception {
		if (btn_Email.isDisplayed()) {
			btn_Email.click();
			log("Email is sent for selected student and object is:-" + btn_Email.toString());
			Thread.sleep(2000);
		} else {
			log("Email button element not present.");
			Thread.sleep(500);
		}
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

	public void min_Max_FeeDefaulterReport_Form() throws Exception {
		if (btnMin_MaxFeeDefaulterReport.isDisplayed()) {
			btnMin_MaxFeeDefaulterReport.click();
			log("Fee Defaulter Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeDefaulterReport.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Defaulter Report Minimized Element not present.");
		}
	}

	public void min_Max_FeeDefaulterReport_Grid() throws Exception {
		if (btnMin_MaxFeeDefaulterReportGrid.isDisplayed()) {
			btnMin_MaxFeeDefaulterReportGrid.click();
			log("Fee Defaulter Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxFeeDefaulterReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Defaulter Report Grid Minimized Element not present.");
		}
	}

	public void searchWithGroupName_InYearlyFeeDefaulterReportGrid(String groupName) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(groupName);
			log("Entered Group Name to search: " + groupName + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void sortRecordsByGroupName() throws Exception {
		if (btnSortByGroupName.isDisplayed()) {
			btnSortByGroupName.click();
			// btnSortByGroupName.click();
			log("Sorted the record with Group name and object is:-" + btnSortByGroupName.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}

	public void selectRecordToGenerateReport() throws Exception {
		int no_Of_Record = Chk_FeeDefaulterReportGrid.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_FeeDefaulterReportGrid.get(i).isSelected()) {
				Chk_FeeDefaulterReportGrid.get(i).click();
				log(i + " Custom Group Name check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Custom Group name checked box is already checked.");
				Thread.sleep(500);
			}
		}
	}
}
