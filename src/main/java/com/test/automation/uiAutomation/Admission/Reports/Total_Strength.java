/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Reports;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Total_Strength extends TestBase {

	public static final Logger log = Logger.getLogger(Total_Strength.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	WebElement btnAdmission_Reports;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
	WebElement btnReports_TotalStrength;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtReports_TotalStrengthReportMsgDispaly;

	@FindBy(xpath = "(//label[@class='radio-inline']/child::span[contains(text(),'All')]/preceding-sibling::input)[1]")
	WebElement rdBtn_ALL;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Individual')]/preceding-sibling::input")
	WebElement rdBtn_Individual;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Present')]/preceding-sibling::input")
	WebElement rdBtn_Present;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Left')]/preceding-sibling::input")
	WebElement rdBtn_Left;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Deactive')]/preceding-sibling::input")
	WebElement rdBtn_DeActive;

	@FindBy(xpath = "//label[@class='radio-inline']/child::span[contains(text(),'Over All Total')]/preceding-sibling::input")
	WebElement rdBtn_overAllTotal;

	@FindBy(xpath = "//label[@class='checkbox-inline']/child::span[contains(text(),'With TC')]/preceding-sibling::input")
	WebElement chk_WithTC;

	@FindBy(xpath = "//label[@class='checkbox-inline']/child::span[contains(text(),'With Deactive')]/preceding-sibling::input")
	WebElement chk_WithDeactive;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	WebElement btn_Report;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Excel')]/parent::button")
	WebElement btn_ExportToExcel;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxTotalStrengthReportForm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxTotalStrengthReportGrid;

	public Total_Strength(WebDriver driver) {
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
	 * Navigate to Admission > Reports > Total Strength
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_TotalStrength() throws Exception {
		if (btn_Admission.isDisplayed()) {
			btn_Admission.click();
			log("Clicked on admission Button and object is:-" + btn_Admission.toString());
			Thread.sleep(1000);
		} else {
			log("Admission button element not present.");
			Thread.sleep(500);
		}
		if (btnAdmission_Reports.isDisplayed()) {
			btnAdmission_Reports.click();
			log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());
			Thread.sleep(1000);
		} else {
			log("Admission reports button element not present.");
			Thread.sleep(500);
		}
		if (btnReports_TotalStrength.isDisplayed()) {
			btnReports_TotalStrength.click();
			log("Clicked on Total Strength reports Button and object is:-" + btnReports_TotalStrength.toString());
			Thread.sleep(1000);
		} else {
			log("Total Strength reports button element not present.");
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of Admission > Reports > Total Strength reports screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmissionReports_TotalStrengthReport_BGHSPage() {
		try {
			System.out.println(txtReports_TotalStrengthReportMsgDispaly.getText());
			txtReports_TotalStrengthReportMsgDispaly.isDisplayed();
			log("Total Strength Report page is dispalyed and object is:-"
					+ txtReports_TotalStrengthReportMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_TotalStrengthReportForm() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Submit blank Total Strength Report form and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Present(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithTC(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithDeactive(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected With Deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("With Deactive check box already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithTCAndDeactive(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}
		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected With Deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("With Deactive check box already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Left(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Selected Left radio button and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_Deactive(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_DeActive.isSelected()) {
			rdBtn_DeActive.click();
			log("Selected Deactive radio button and object is:- " + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForALL_OverAllTotal(String academicYear) throws Exception {

		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_overAllTotal.isSelected()) {
			rdBtn_overAllTotal.click();
			log("Selected overall Total radio button and object is:- " + rdBtn_overAllTotal.toString());
			Thread.sleep(1000);
		} else {
			log("Overall Total Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present(String academicYear, String class_Ts, String section)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithTC(String academicYear, String class_Ts,
			String section) throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive(String academicYear, String class_Ts,
			String section) throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected with deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive check box already checked.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive(String academicYear,
			String class_Ts, String section) throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}

		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected with deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive check box already checked.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Left(String academicYear, String class_Ts, String section)
			throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Selected Left radio button and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Deactive(String academicYear, String class_Ts,
			String section) throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_DeActive.isSelected()) {
			rdBtn_DeActive.click();
			log("Selected deactive radio button and object is:- " + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void fillTotalStrengthReport_Form_ForIndividual_OverAllTotal(String academicYear, String class_Ts,
			String section) throws Exception {

		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}

		if (!rdBtn_overAllTotal.isSelected()) {
			rdBtn_overAllTotal.click();
			log("Selected overall total radio button and object is:- " + rdBtn_overAllTotal.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Total Radio button already selected.");
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_Ts);

			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Ts);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}

		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void clickReport_ToGenerate_TotalStrengthReport() throws Exception {
		if (btn_Report.isDisplayed()) {
			btn_Report.click();
			log("Total Strength Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(5000);
		} else {
			log("Report button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Total Strength Report filled form data is cleared and object is:-" + btn_Cancel.toString());
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

	public void min_Max_TotalStrenghtReport_Form() throws Exception {
		if (btnMin_MaxTotalStrengthReportForm.isDisplayed()) {
			btnMin_MaxTotalStrengthReportForm.click();
			log("Total Strength Report page minimized or maximized and object is:-"
					+ btnMin_MaxTotalStrengthReportForm.toString());
			Thread.sleep(1000);
		} else {
			log("Total Strength Report Minimized Element not present.");
		}
	}

	public void min_Max_TotalStrenghtReport_Grid() throws Exception {
		if (btnMin_MaxTotalStrengthReportGrid.isDisplayed()) {
			btnMin_MaxTotalStrengthReportGrid.click();
			log("Total Strength Report page minimized or maximized and object is:-"
					+ btnMin_MaxTotalStrengthReportGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Total Strength Report grid Minimized Element not present.");
		}
	}

	public void searchWithClassName_InTotalStrengthReportGrid(String Class_Name) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(Class_Name);
			log("Entered Class name to search: " + Class_Name + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}
}
