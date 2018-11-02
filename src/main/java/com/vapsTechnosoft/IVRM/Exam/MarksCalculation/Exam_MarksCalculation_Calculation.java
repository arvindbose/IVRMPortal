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

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Marks
	// Calculation')][1]/following::li[1]")
	// private WebElement btn_Calculation_NavMenu;

	@FindBy(xpath = "//a[@href='#/app/exammarkcalculation/271']")
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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_MarksCalculation_Calculation(WebDriver driver) {
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
	 * Navigate to Exam > Marks Calculation > Calculation
	 * 
	 * @throws Exception
	 */
	public void navigateToExam_MarksCalculation_Calculation() throws Exception {
		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_Exam_MarksCalculation);
		log("Clicked on Marks Calculation to Navigate to Calculation and object is:-"
				+ btn_Exam_MarksCalculation.toString());

		clickOnButton(btn_Calculation_NavMenu);
		log("Clicked on Calculation and page opened Button and object is:-" + btn_Calculation_NavMenu.toString());

	}

	/**
	 * Validation of Exam > Marks Calculation > Calculation Page Path message
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

		clickOnButton(btn_CalculationSubmit);
		log("Submit blank Calculation form and object is:-" + btn_CalculationSubmit.toString());

	}

	/**
	 * Marks Calculation form
	 * 
	 * @param academicYear
	 * @param class_status
	 * @param status
	 * @throws Exception
	 */
	public void fill_ExamMarksCalculation_CalculationForm(String academicYear, String class_mc, String section,
			String examName) throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, class_mc);
		log("Selected Class: " + class_mc + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("Selected Section: " + section + " and object is:- " + sel_Section.toString());

		selectElementFromDropDown(sel_ExamName, examName);
		log("Selected Exam Name: " + examName + " and object is:- " + sel_ExamName.toString());

	}

	public void submit_MarksCalculation_CalculationForm() throws Exception {

		clickOnButton(btn_CalculationSubmit);
		log("Submit Calculation form and object is:-" + btn_CalculationSubmit.toString());

	}

	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		isDisplayed(btnOKSuccess);
		assertEquals("OK", btnOKSuccess.getText().trim());
		btnOKSuccess.click();
		log("clicked on OK button and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
	public void popUpWindowMessage_MarksCalCulationSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Marks Calculated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
