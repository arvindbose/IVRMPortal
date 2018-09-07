/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.MarksCalculation;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Exam_MarksCalculation_Calculation extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MarksCalculation_Calculation.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Marks Calculation')][1]")
	private WebElement btn_Exam_MarksCalculation;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Marks Calculation')][1]/following::li[1]")
	private WebElement btn_Calculation_NavMenu;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_MarksCalculationPage;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'class :')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	private WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Exam Name :')]/following-sibling::div/select")
	private WebElement sel_ExamName;

	@FindBy(xpath = "//button[@id='save-btn']")
	private WebElement btn_CalculationSubmit;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	
	public Exam_MarksCalculation_Calculation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Exam > Marks Calculation > Calculation
	 * 
	 * @throws Exception
	 */
	public void navigateToExam_MarksCalculation_Calculation() throws Exception {
		if (btn_Exam.isDisplayed()) {
			btn_Exam.click();
			log("Clicked on Exam Navigation Menu Button and object is:-" + btn_Exam.toString());
			Thread.sleep(1000);
		} else {
			log("Exam Navigation Menu button element not present and object is:-" + btn_Exam.toString());
			Thread.sleep(500);
		}
		if (btn_Exam_MarksCalculation.isDisplayed()) {
			btn_Exam_MarksCalculation.click();
			log("Clicked on Marks Calculation to Navigate to Calculation and object is:-" + btn_Exam_MarksCalculation.toString());
			Thread.sleep(1000);
		} else {
			log("Marks Calculation button element not present and object is:-" + btn_Exam_MarksCalculation.toString());
			Thread.sleep(500);
		}
		if (btn_Calculation_NavMenu.isDisplayed()) {
			btn_Calculation_NavMenu.click();
			log("Clicked on Calculation and page opened Button and object is:-" + btn_Calculation_NavMenu.toString());
			Thread.sleep(1000);
		} else {
			log("Calculation button element not present and object is:-" + btn_Calculation_NavMenu.toString());
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of  Exam > Marks Calculation > Calculation Page Path message
	 * 
	 * @return
	 */
	public boolean verifyExamMarksCalculation_CalculationPage() {
		try {
			System.out.println(txt_MarksCalculationPage.getText());
			txt_MarksCalculationPage.isDisplayed();
			log("Marks Calculation page is dispalyed and object is:-" + txt_MarksCalculationPage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_MarksCalculation_CalculationForm() throws Exception {
		if (btn_CalculationSubmit.isDisplayed()) {
			btn_CalculationSubmit.click();
			log("Submit blank Calculation form and object is:-" + btn_CalculationSubmit.toString());
			Thread.sleep(2000);
		} else {
			log("Calculation button element not present and object is:-" + btn_CalculationSubmit.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Marks Calculation form
	 * 
	 * @param academicYear
	 * @param class_status
	 * @param status
	 * @throws Exception
	 */
	public void fill_ExamMarksCalculation_CalculationForm(String academicYear, String class_mc, String section, String examName)
			throws Exception {


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
			select.selectByVisibleText(class_mc);

			log("Selected Class: " + class_mc + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_mc);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_Class.toString());
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
			log("Section element is not present and object is:- " + sel_Section.toString());
			Thread.sleep(500);
		}
		if (sel_ExamName.isDisplayed()) {
			select = new Select(sel_ExamName);
			select.selectByVisibleText(examName);

			log("Selected Exam Name: " + examName + " and object is:- " + sel_ExamName.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), examName);
			Thread.sleep(1000);
		} else {
			log("Exam Name element is not present and object is:- " + sel_ExamName.toString());
			Thread.sleep(500);
		}
	}
	
	public void submit_MarksCalculation_CalculationForm() throws Exception {
		if (btn_CalculationSubmit.isDisplayed()) {
			btn_CalculationSubmit.click();
			waitForElement(driver, btnOKSuccess, 30);
			log("Submit Calculation form and object is:-" + btn_CalculationSubmit.toString());
			Thread.sleep(3000);
		} else {
			log("Calculation button element not present and object is:-" + btn_CalculationSubmit.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			assertEquals("OK", btnOKSuccess.getText().trim());
			btnOKSuccess.click();
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}
	

}
