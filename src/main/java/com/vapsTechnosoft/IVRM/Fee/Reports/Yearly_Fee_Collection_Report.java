/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import static org.testng.Assert.assertEquals;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Yearly_Fee_Collection_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Yearly_Fee_Collection_Report.class.getName());

	private WebDriver driver;
	

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[6]")
	// private WebElement btn_YearlyFeeCollectionReport;

	@FindBy(xpath = "//a[@href='#/app/FeeCollectionReport/191']")
	private WebElement btn_YearlyFeeCollectionReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_YearlyFeeCollectionReport;

	@FindBy(xpath = "//span[contains(text(),'Yearly Wise')]/preceding-sibling::input")
	private WebElement rdBtn_YearlyWise;

	@FindBy(xpath = "//span[contains(text(),'Date Wise')]/preceding-sibling::input")
	private WebElement rdBtn_DateWise;

	@FindBy(xpath = "//span[contains(text(),'Fee Group Wise')]/preceding-sibling::input")
	private WebElement rdBtn_FeeGroupWise;

	@FindBy(xpath = "//span[contains(text(),'Fee Head Wise')]/preceding-sibling::input")
	private WebElement rdBtn_FeeHeadWise;

	@FindBy(xpath = "//span[contains(text(),'Class Wise')]/preceding-sibling::input")
	private WebElement rdBtn_ClassWise;

	@FindBy(xpath = "//span[contains(text(),'Student Wise')]/preceding-sibling::input")
	private WebElement rdBtn_StudentWise;

	@FindBy(xpath = "//span[contains(text(),'Category Wise')]/preceding-sibling::input")
	private WebElement rdBtn_CategoryWise;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//input[@name='fee_ct1']")
	private List<WebElement> Chk_CustomGroup;

	@FindBy(xpath = "//input[@name='fee_gp1']")
	private List<WebElement> Chk_FeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Active')]/preceding-sibling::input")
	private WebElement chk_Active;

	@FindBy(xpath = "//span[contains(text(),'Deactive')]/preceding-sibling::input")
	private WebElement chk_De_Active;

	@FindBy(xpath = "//span[contains(text(),'Left')]/preceding-sibling::input")
	private WebElement chk_Left;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	private WebElement btn_Clear;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Display')]/parent::button")
	private WebElement btn_Display;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxYearlyFeeCollectionReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxYearlyFeeCollectionReportGrid;

	@FindBy(xpath = "//table[@id='table1'][2]/thead/tr/th[3]/a")
	private WebElement btnSortByGroupName;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//table[@id='table1'][1]/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_YrlyFeeCollectionReportGrid_FeeGrWise;

	@FindBy(xpath = "//table[@id='table1'][2]/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_YrlyFeeCollectionReportGrid_FeeHeadWise;

	@FindBy(xpath = "//table[@id='table1'][3]/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_YrlyFeeCollectionReportGrid_ClassWise;

	@FindBy(xpath = "//table[@id='table1'][4]/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise;

	@FindBy(xpath = "//span[contains(text(),'Waived Off')]/preceding-sibling::input")
	private WebElement chk_WaivedOff_Display;

	@FindBy(xpath = "(//button[@class='btn btn-default' and text()='Close'])[1]")
	private WebElement btn_Close_Display;

	@FindBy(xpath = "//div[@ng-show='Grid_view']/div/h3")
	WebElement grid_HeaderName;

	public Yearly_Fee_Collection_Report(WebDriver driver) {
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
	 * Navigate to Fee > Reports > Yearly Fee Collection report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_YearlyFeeCollectionReport() throws Exception {
		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_YearlyFeeCollectionReport);
		log("Clicked on Yearly Fee Collection Report Button in navigation panel and object is:-"
				+ btn_YearlyFeeCollectionReport.toString());

	}

	/**
	 * Validation of Fee > Reports > Yearly Fee Collection Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_YearlyFeeCollectionReport_Page() {
		try {
			System.out.println(txt_YearlyFeeCollectionReport.getText().trim());
			txt_YearlyFeeCollectionReport.isDisplayed();
			log("Yearly Fee Collection Report page text is dispalyed and object is:-"
					+ txt_YearlyFeeCollectionReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_YearlyFeeCollectionReportForm() throws Exception {

		clickOnButton(btn_Report);
		log("Submit blank YearlyFeeCollectionReport form and object is:-" + btn_Report.toString());
		Thread.sleep(2000);

	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear)
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(String academicYear)
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
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise
	 * 
	 * For De-active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(String academicYear)
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
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise
	 * 
	 * For without selecting Active, De-active abd left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student(
			String academicYear) throws Exception {
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
	}

	/*
	 * Generate report for Yearly Wise, Fee Group Wise
	 * 
	 * For Active, De-active and left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent(
			String academicYear) throws Exception {
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(String academicYear)
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(String academicYear)
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
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise
	 * 
	 * For De-active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(String academicYear)
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
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise
	 * 
	 * For without selecting Active, De-active abd left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student(
			String academicYear) throws Exception {
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
	}

	/*
	 * Generate report for Yearly Wise, Fee Head Wise
	 * 
	 * For Active, De-active and left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent(
			String academicYear) throws Exception {
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Fee Class Wise
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent(String academicYear)
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent(String academicYear)
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
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise
	 * 
	 * For De-active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent(String academicYear)
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
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Class Wise
	 * 
	 * For without selecting Active, De-active abd left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
			String academicYear) throws Exception {
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
	}

	/*
	 * Generate report for Yearly Wise, Class Wise
	 * 
	 * For Active, De-active and left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent(
			String academicYear) throws Exception {
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent(String academicYear)
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent(String academicYear)
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
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise
	 * 
	 * For De-active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent(String academicYear)
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
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Student Wise
	 * 
	 * For without selecting Active, De-active abd left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student(
			String academicYear) throws Exception {
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
	}

	/*
	 * Generate report for Yearly Wise, Student Wise
	 * 
	 * For Active, De-active and left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent(
			String academicYear) throws Exception {
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Category Wise
	 * 
	 * For Active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent(String academicYear)
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
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Category Wise
	 * 
	 * For Left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent(String academicYear)
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
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Category Wise
	 * 
	 * For De-active Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent(String academicYear)
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
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
	}

	/*
	 * Generate report for Yearly Wise, Category Wise
	 * 
	 * For without selecting Active, De-active abd left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student(
			String academicYear) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
			
		
		try{
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
	try{
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
	}

	/*
	 * Generate report for Yearly Wise, Category Wise
	 * 
	 * For Active, De-active and left Student
	 */
	public void fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent(
			String academicYear) throws Exception {
		isDisplayed(rdBtn_YearlyWise);
		if (!rdBtn_YearlyWise.isSelected()) {
			rdBtn_YearlyWise.click();
			log("Yearly Wise radio button is selected and object is:- " + rdBtn_YearlyWise.toString());
			Thread.sleep(1000);
		} else {
			log("Yearly Wise Radio button already selected.");
			Thread.sleep(500);
		}
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
			try{
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
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
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
			}catch(Exception e){
				e.printStackTrace();
			}
		isDisplayed(chk_Active);
		if (!chk_Active.isSelected()) {
			chk_Active.click();
			log("Active Student radio button is selected and object is:- " + chk_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Active Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_De_Active);
		if (!chk_De_Active.isSelected()) {
			chk_De_Active.click();
			log("Deactive Student radio button is selected and object is:- " + chk_De_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Left);
		if (!chk_Left.isSelected()) {
			chk_Left.click();
			log("Left Student radio button is selected and object is:- " + chk_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_YearlyFeeCollectionReport() throws Exception {
		
			clickOnButton(btn_Report);
			log("Yearly Fee Collection Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(2000);
			assertEquals(grid_HeaderName.getText().trim(), "YEARLY FEE COLLECTION REPORT");
		
	}

	public void clickClearButton_ToClearFilledForm() throws Exception {
	
			clickOnButton(btn_Clear);
			log("Yearly Fee Collection report filled form data is cleared and object is:-" + btn_Clear.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		
			clickOnButton(btn_ExportToExcel);
			log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnPrint_ForPrintPreview() throws Exception {

		String parentWin = driver.getWindowHandle();

			clickOnButton(btn_Print);
			log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
			

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
				Thread.sleep(1000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(1000);
	}

	public void clickOnOkSuccessButton() throws Exception {
	
			clickOnButton(btnOKSuccess);
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
			
	}

	public void min_Max_YearlyFeeCollectionReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txt_YearlyFeeCollectionReport);
		Thread.sleep(1000);
	
			clickOnButton(btnMin_MaxYearlyFeeCollectionReport);
			log("Yearly Fee Collection Report page minimized or maximized and object is:-"
					+ btnMin_MaxYearlyFeeCollectionReport.toString());
			
	}

	public void min_Max_YearlyFeeCollectionReport_Grid() throws Exception {
	
			clickOnButton(btnMin_MaxYearlyFeeCollectionReportGrid);
			log("Yearly Fee Collection Report Grid page minimized or maximized and object is:-"
					+ btnMin_MaxYearlyFeeCollectionReportGrid.toString());
			
	}

	public void sortRecordsByGroupName() throws Exception {
	
			clickOnButton(btnSortByGroupName);
			log("Sorted the record with Group name and object is:-" + btnSortByGroupName.toString());
			
	}

	public void selectRecordToGenerateReport_FeeGroupWise() throws Exception {
		try{
		int no_Of_Record = Chk_Records_YrlyFeeCollectionReportGrid_FeeGrWise.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_YrlyFeeCollectionReportGrid_FeeGrWise.get(i).isSelected()) {
				Chk_Records_YrlyFeeCollectionReportGrid_FeeGrWise.get(i).click();
				log(i + " records check box is checked for Fee Group Wise.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked for Fee Group Wise.");
				Thread.sleep(500);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void selectRecordToGenerateReport_FeeHeadWise() throws Exception {
		try{
		int no_Of_Record = Chk_Records_YrlyFeeCollectionReportGrid_FeeHeadWise.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_YrlyFeeCollectionReportGrid_FeeHeadWise.get(i).isSelected()) {
				Chk_Records_YrlyFeeCollectionReportGrid_FeeHeadWise.get(i).click();
				log(i + " records check box is checked for Fee Head Wise.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked for Fee Head Wise.");
				Thread.sleep(500);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public void selectRecordToGenerateReport_ClassWise() throws Exception {
		try{
		int no_Of_Record = Chk_Records_YrlyFeeCollectionReportGrid_ClassWise.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_YrlyFeeCollectionReportGrid_ClassWise.get(i).isSelected()) {
				Chk_Records_YrlyFeeCollectionReportGrid_ClassWise.get(i).click();
				log(i + " records check box is checked for Class Wise.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked for Class Wise.");
				Thread.sleep(500);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public void selectRecordToGenerateReport_CategoryWise() throws Exception {
		try{
		int no_Of_Record = Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.get(i).isSelected()) {
				Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.get(i).click();
				log(i + " records check box is checked for Category Wise.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked for Category Wise.");
				Thread.sleep(500);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public void selectRecordToGenerateReport_StudentWise() throws Exception {
		try{
		int no_Of_Record = Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.size();
		for (int i = 0; i < no_Of_Record; i++) {
			if (!Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.get(i).isSelected()) {
				Chk_Records_YrlyFeeCollectionReportGrid_CategoryWise.get(i).click();
				log(i + " records check box is checked for Category Wise.");
				Thread.sleep(1000);
			} else {
				log(i + " records checked box is already checked for Category Wise.");
				Thread.sleep(500);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public void selectColumnName_ForDisplayInGrid() throws Exception {

			clickOnButton(btn_Display);
			log("Display Pop up window open and object is:" + btn_Display.toString());
			
			isDisplayed(chk_WaivedOff_Display);
		if (!chk_WaivedOff_Display.isSelected()) {
			chk_WaivedOff_Display.click();
			log("Waived off column name is selected and objected is:-" + chk_WaivedOff_Display.toString());
			Thread.sleep(1000);
		} else {
			log("Waived off check box element not present.");
			Thread.sleep(500);
		}
	}

	public void closeDisplayPopUpWindow() throws Exception {

			clickOnButton(btn_Close_Display);
			log("Clicked on Close button of display pop up and object is:-" + btn_Close_Display.toString());
		
	}
}
