/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Reports;

import java.util.List;

import org.apache.log4j.Logger;
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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[5]")
	// WebElement btnReports_TotalStrength;

	@FindBy(xpath = "//a[@href='#/app/totalstrength/104']")
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

	@FindBy(xpath = "(//div[@class='input-group']/input)[1]")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxTotalStrengthReportForm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxTotalStrengthReportGrid;

	@FindBy(xpath = "//table[@id='Table']//tfoot/tr/td[1]/b")
	WebElement col_FinalTotal;

	@FindBy(xpath = "//table[@id='Table']//tfoot/tr/td[2]/b")
	WebElement total_Boys;

	@FindBy(xpath = "//table[@id='Table']//tfoot/tr/td[3]/b")
	WebElement total_Girls;

	@FindBy(xpath = "//table[@id='Table']//tfoot/tr/td[4]/b")
	WebElement total_TotalStudent;

	@FindBy(xpath = "//div[contains(@ng-show,'totstr') and @class='box box-primary']/div/h3")
	WebElement grid_HeaderName;

	public Total_Strength(WebDriver driver) {
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
	 * Navigate to Admission > Reports > Total Strength
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Reports_TotalStrength() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Reports);
		log("Clicked on Admission reports and object is:-" + btnAdmission_Reports.toString());

		clickOnButton(btnReports_TotalStrength);
		log("Clicked on Total Strength reports Button and object is:-" + btnReports_TotalStrength.toString());

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
	
			clickOnButton(btn_Report);
			log("Submit blank Total Strength Report form and object is:-" + btn_Report.toString());
			Thread.sleep(1000);
		
	}

	public void fillTotalStrengthReport_Form_ForALL_Present(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithTC(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithTC);
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithDeactive(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithDeactive);
		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected With Deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("With Deactive check box already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_Present_WithTCAndDeactive(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithTC);
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithDeactive);
		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected With Deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("With Deactive check box already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_Left(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Left);
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Selected Left radio button and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_Deactive(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_DeActive);
		if (!rdBtn_DeActive.isSelected()) {
			rdBtn_DeActive.click();
			log("Selected Deactive radio button and object is:- " + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForALL_OverAllTotal(String academicYear) throws Exception {
		isDisplayed(rdBtn_ALL);
		if (!rdBtn_ALL.isSelected()) {
			rdBtn_ALL.click();
			log("Selected All radio button and object is:- " + rdBtn_ALL.toString());
			Thread.sleep(1000);
		} else {
			log("All Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_overAllTotal);
		if (!rdBtn_overAllTotal.isSelected()) {
			rdBtn_overAllTotal.click();
			log("Selected overall Total radio button and object is:- " + rdBtn_overAllTotal.toString());
			Thread.sleep(1000);
		} else {
			log("Overall Total Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present(String academicYear, String class_Ts, String section)
			throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());

			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithTC(String academicYear, String class_Ts,
			String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithTC);
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
	
			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
		
			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
		
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive(String academicYear, String class_Ts,
			String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithDeactive);
		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected with deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive check box already checked.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
	
			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
	
			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive(String academicYear,
			String class_Ts, String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Present);
		if (!rdBtn_Present.isSelected()) {
			rdBtn_Present.click();
			log("Selected present radio button and object is:- " + rdBtn_Present.toString());
			Thread.sleep(1000);
		} else {
			log("Present Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithTC);
		if (!chk_WithTC.isSelected()) {
			chk_WithTC.click();
			log("Selected WithTC check box and object is:- " + chk_WithTC.toString());
			Thread.sleep(1000);
		} else {
			log("with Tc check box already selected.");
			Thread.sleep(500);
		}
		isDisplayed(chk_WithDeactive);
		if (!chk_WithDeactive.isSelected()) {
			chk_WithDeactive.click();
			log("Selected with deactive check box and object is:- " + chk_WithDeactive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactive check box already checked.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
	
			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Left(String academicYear, String class_Ts, String section)
			throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_Left);
		if (!rdBtn_Left.isSelected()) {
			rdBtn_Left.click();
			log("Selected Left radio button and object is:- " + rdBtn_Left.toString());
			Thread.sleep(1000);
		} else {
			log("Left Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());

			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_Deactive(String academicYear, String class_Ts,
			String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_DeActive);
		if (!rdBtn_DeActive.isSelected()) {
			rdBtn_DeActive.click();
			log("Selected deactive radio button and object is:- " + rdBtn_DeActive.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
		
			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
	
			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
			
	}

	public void fillTotalStrengthReport_Form_ForIndividual_OverAllTotal(String academicYear, String class_Ts,
			String section) throws Exception {
		isDisplayed(rdBtn_Individual);
		if (!rdBtn_Individual.isSelected()) {
			rdBtn_Individual.click();
			log("Selected Individual radio button and object is:- " + rdBtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual Radio button already selected.");
			Thread.sleep(500);
		}
		isDisplayed(rdBtn_overAllTotal);
		if (!rdBtn_overAllTotal.isSelected()) {
			rdBtn_overAllTotal.click();
			log("Selected overall total radio button and object is:- " + rdBtn_overAllTotal.toString());
			Thread.sleep(1000);
		} else {
			log("OverAll Total Radio button already selected.");
			Thread.sleep(500);
		}

			selectElementFromDropDown(sel_AcademicYr, academicYear);
			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

			selectElementFromDropDown(sel_Class, class_Ts);
			log("selected class: " + class_Ts + " and object is:- " + sel_Class.toString());
	
			selectElementFromDropDown(sel_Section, section);
			log("selected Section: " + section + " and object is:- " + sel_Section.toString());
		
	}

	public void clickReport_ToGenerate_TotalStrengthReport() throws Exception {
		
			clickOnButton(btn_Report);
			log("Total Strength Report is generated and object is:-" + btn_Report.toString());
			Thread.sleep(4000);

	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {
	
			clickOnButton(btn_Cancel);
			log("Total Strength Report filled form data is cleared and object is:-" + btn_Cancel.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
	
			clickOnButton(btn_ExportToExcel);
			log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
			
	}

	public void min_Max_TotalStrenghtReport_Form() throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
				txtReports_TotalStrengthReportMsgDispaly);
			clickOnButton(btnMin_MaxTotalStrengthReportForm);
			log("Total Strength Report page minimized or maximized and object is:-"
					+ btnMin_MaxTotalStrengthReportForm.toString());
			
	}

	public void min_Max_TotalStrenghtReport_Grid() throws Exception {
		
			clickOnButton(btnMin_MaxTotalStrengthReportGrid);
			log("Total Strength Report page minimized or maximized and object is:-"
					+ btnMin_MaxTotalStrengthReportGrid.toString());
		
	}

	public void searchWithClassName_InTotalStrengthReportGrid(String Class_Name, String finalTotal) throws Exception {
	
			inputTextIntoInputField(input_Search, Class_Name);
			log("Entered Class name to search: " + Class_Name + " and object is:-" + input_Search.toString());
			
	}

	public void searchWithFinalTotal_InTotalStrengthReportGrid(String Class_Name, String finalTotal) throws Exception {
		
			inputTextIntoInputField(input_Search, finalTotal);
			log("Entered Final Total to search: " + finalTotal + " and object is:-" + input_Search.toString());
			
	}

	public void validateTotalStength_WithNumberOfBoysAndGirls() throws Exception {
	isDisplayed(total_Boys);
		String numberBoys = total_Boys.getText();
		int boys = Integer.parseInt(numberBoys);
		System.out.println("Total Boys: " + boys);
		isDisplayed(total_Girls);
		String numberGirls = total_Girls.getText();
		int girls = Integer.parseInt(numberGirls);
		System.out.println("Total Girls: " + girls);
		isDisplayed(total_TotalStudent);
		String numberStudent = total_TotalStudent.getText();
		int students = Integer.parseInt(numberStudent);
		System.out.println("Total Student: " + (boys + girls));
		Assert.assertEquals((boys + girls), students);
		log("Sum of Boys and Girls in a category is equal to total number of students.");
		Thread.sleep(2000);
	}
}
