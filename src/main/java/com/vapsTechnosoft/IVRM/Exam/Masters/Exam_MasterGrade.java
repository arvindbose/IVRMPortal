/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.Masters;

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
 * @author Arvind
 *
 */
public class Exam_MasterGrade extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MasterGrade.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]")
	private WebElement btn_Exam_Masters;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[6]")
	private WebElement btn_ExamMasterGrade;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_MasterGrade;

	@FindBy(xpath = "//label[contains(text(),'Grade Name:')]/following-sibling::div/input")
	private WebElement input_GradeName;

	@FindBy(xpath = "//span[text()='Percentage']/parent::label/input")
	private WebElement rdBtn_Percentage;

	@FindBy(xpath = "//span[text()='Marks']/parent::label/input")
	private WebElement rdBtn_Marks;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/input")
	private WebElement input_From_A;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]/input")
	private WebElement input_To_A;

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/input")
	private WebElement input_From_B;

	@FindBy(xpath = "//table/tbody/tr[2]/td[3]/input")
	private WebElement input_To_B;

	@FindBy(xpath = "//table/tbody/tr[3]/td[2]/input")
	private WebElement input_From_C;

	@FindBy(xpath = "//table/tbody/tr[3]/td[3]/input")
	private WebElement input_To_C;

	@FindBy(xpath = "//table/tbody/tr[4]/td[2]/input")
	private WebElement input_From_D;

	@FindBy(xpath = "//table/tbody/tr[4]/td[3]/input")
	private WebElement input_To_D;

	@FindBy(xpath = "//table/tbody/tr[1]/td[4]/input")
	private WebElement input_Grade_A;

	@FindBy(xpath = "//table/tbody/tr[1]/td[5]/input")
	private WebElement input_GradePoint_A;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/input")
	private WebElement input_Remarks_A;

	@FindBy(xpath = "//table/tbody/tr[2]/td[4]/input")
	private WebElement input_Grade_B;

	@FindBy(xpath = "//table/tbody/tr[2]/td[5]/input")
	private WebElement input_GradePoint_B;

	@FindBy(xpath = "//table/tbody/tr[2]/td[6]/input")
	private WebElement input_Remarks_B;

	@FindBy(xpath = "//table/tbody/tr[3]/td[4]/input")
	private WebElement input_Grade_C;

	@FindBy(xpath = "//table/tbody/tr[3]/td[5]/input")
	private WebElement input_GradePoint_C;

	@FindBy(xpath = "//table/tbody/tr[3]/td[6]/input")
	private WebElement input_Remarks_C;

	@FindBy(xpath = "//table/tbody/tr[4]/td[4]/input")
	private WebElement input_Grade_D;

	@FindBy(xpath = "//table/tbody/tr[4]/td[5]/input")
	private WebElement input_GradePoint_D;

	@FindBy(xpath = "//table/tbody/tr[4]/td[6]/input")
	private WebElement input_Remarks_D;

	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/span/a")
	private WebElement btn_Action_Add_A;

	@FindBy(xpath = "//table/tbody/tr[2]/td[7]/span/a")
	private WebElement btn_Action_Add_B;

	@FindBy(xpath = "//table/tbody/tr[3]/td[7]/span/a")
	private WebElement btn_Action_Add_C;

	@FindBy(xpath = "//table/tbody/tr[4]/td[8]/span/a")
	private WebElement btn_Action_Minus_D;

	@FindBy(xpath = "//button[@id='save-btn']")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Grade Name')]")
	private WebElement btn_Sort_GradeName;

	@FindBy(xpath = "//span[contains(text(),'Grade Name')]/following::div[2]/div/input")
	private WebElement input_GradeNameFilter;

	@FindBy(xpath = "//span[contains(text(),'Percentage / Marks')]")
	private WebElement btn_Sort_MarksOrPercentage;

	@FindBy(xpath = "//span[contains(text(),'Percentage / Marks')]/following::div[2]/div/input")
	private WebElement input_MarksOrPercentage;

	@FindBy(xpath = "//span[text()='Actions']/following::div[13]/a[1]")
	private WebElement icon_View;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "//span[text()='Actions']/following::div[13]/a[2]")
	private WebElement icon_Edit;

	@FindBy(xpath = "//span[text()='Actions']/following::div[13]/span/a")
	private WebElement icon_Deactivate;

	@FindBy(xpath = "//span[text()='Actions']/following::div[13]/a[3]")
	private WebElement icon_Activate;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement btnPopUp_YesDeactivateOrActivateit;

	@FindBy(xpath = "//button[@class='cancel' and text()='Cancel']")
	private WebElement btnPopUp_Cancel;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_GradeMaster;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_GradeMasterDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_Max_GradeMasterGridView;

	@FindBy(xpath = "//*[@id='style-4']/div[2]/div[1]/div[2]/select")
	private WebElement noOfItemPerPage;

	public Exam_MasterGrade(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Master Grade
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterGrade() throws Exception {

		if (btn_Exam.isDisplayed()) {
			btn_Exam.click();
			log("Clicked on Exam Button and object is:-" + btn_Exam.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Exam Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_Exam_Masters.isDisplayed()) {
			btn_Exam_Masters.click();
			log("Clicked on Exam Masters Button and object is:-" + btn_Exam_Masters.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Exam Master Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_ExamMasterGrade.isDisplayed()) {
			btn_ExamMasterGrade.click();
			log("Clicked on Exam Master Grade Button and object is:-" + btn_ExamMasterGrade.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Exam Master Grade Navigation element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of Exam Master Grade screen message
	 * 
	 * @return
	 */
	public boolean verifyExamMasterGradePage() {
		try {
			System.out.println(txt_MasterGrade.getText());
			txt_MasterGrade.isDisplayed();
			log("Exam Master Grade  page is dispalyed and object is:-" + txt_MasterGrade.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Master Grade Form for Percentage
	 * 
	 * @param gradeName
	 * 
	 * @throws Exception
	 */
	public void fill_Exam_MasterGrade_Form_Precentage(String gradeName) throws Exception {
		if (!rdBtn_Percentage.isSelected()) {
			rdBtn_Percentage.click();
			log("Percentage radio button is selected and object is:-" + rdBtn_Percentage.toString());
			Thread.sleep(1000);
		} else {
			log("Percentage radio button is already selected");
			Thread.sleep(500);
		}
		if (input_GradeName.isDisplayed()) {
			input_GradeName.clear();
			input_GradeName.sendKeys(gradeName);
			log("Entered Master Grade Name:- and object is: " + input_GradeName.toString());
			Thread.sleep(1000);
		} else {
			log("Grade Name element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Exam Master Grade Form for Marks
	 * 
	 * @param gradeName
	 * 
	 * @throws Exception
	 */
	public void fill_Exam_MasterGrade_Form_Marks(String gradeName) throws Exception {
		if (!rdBtn_Marks.isSelected()) {
			rdBtn_Marks.click();
			log("Marks radio button is selected and object is:-" + rdBtn_Marks.toString());
			Thread.sleep(1000);
		} else {
			log("Marks radio button is already selected");
			Thread.sleep(500);
		}
		if (input_GradeName.isDisplayed()) {
			input_GradeName.clear();
			input_GradeName.sendKeys(gradeName);
			log("Entered Master Grade Name:- and object is: " + input_GradeName.toString());
			Thread.sleep(1000);
		} else {
			log("Grade Name element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill First row of grade details
	 * 
	 * @param from_A
	 * @param to_A
	 * @param grade_A
	 * @param gradePoint_A
	 * @param remarks_A
	 * @throws Exception
	 */
	public void fill_MasterGradeDetails_Grade_A(String from_A, String to_A, String grade_A, String gradePoint_A,
			String remarks_A) throws Exception {
		if (input_From_A.isDisplayed()) {
			input_From_A.clear();
			input_From_A.sendKeys(from_A);
			log("From Marks/Percentage value for grade A entered: " + from_A + " and object is:-"
					+ input_From_A.toString());
			Thread.sleep(1000);
		} else {
			log("From input field element is not present for grade A.");
			Thread.sleep(500);
		}
		if (input_To_A.isDisplayed()) {
			input_To_A.clear();
			input_To_A.sendKeys(to_A);
			log("To Marks/Percentage value for grade A entered: " + to_A + " and object is:-" + input_To_A.toString());
			Thread.sleep(1000);
		} else {
			log("To input field element is not present for grade A.");
			Thread.sleep(500);
		}
		if (input_Grade_A.isDisplayed()) {
			input_Grade_A.clear();
			input_Grade_A.sendKeys(grade_A);
			log("Grade entered: " + grade_A + " and object is:-" + input_Grade_A.toString());
			Thread.sleep(1000);
		} else {
			log("Grade input field element is not present for grade A.");
			Thread.sleep(500);
		}
		if (input_GradePoint_A.isDisplayed()) {
			input_GradePoint_A.clear();
			input_GradePoint_A.sendKeys(gradePoint_A);
			log("Grade point entered: " + gradePoint_A + " and object is:-" + input_GradePoint_A.toString());
			Thread.sleep(1000);
		} else {
			log("Grade point input field element is not present for grade A.");
			Thread.sleep(500);
		}
		if (input_Remarks_A.isDisplayed()) {
			input_Remarks_A.clear();
			input_Remarks_A.sendKeys(remarks_A);
			log("Remarks entered: " + remarks_A + " and object is:-" + input_Remarks_A.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks input field element is not present for grade A.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Second row of grade details
	 * 
	 * @param from_B
	 * @param to_B
	 * @param grade_B
	 * @param gradePoint_B
	 * @param remarks_B
	 * @throws Exception
	 */
	public void fill_MasterGradeDetails_Grade_B(String from_B, String to_B, String grade_B, String gradePoint_B,
			String remarks_B) throws Exception {
		if (input_From_B.isDisplayed()) {
			input_From_B.clear();
			input_From_B.sendKeys(from_B);
			log("From Marks/Percentage value for grade B entered: " + from_B + " and object is:-"
					+ input_From_B.toString());
			Thread.sleep(1000);
		} else {
			log("From input field element is not present for grade B.");
			Thread.sleep(500);
		}
		if (input_To_B.isDisplayed()) {
			input_To_B.clear();
			input_To_B.sendKeys(to_B);
			log("To Marks/Percentage value for grade B entered: " + to_B + " and object is:-" + input_To_B.toString());
			Thread.sleep(1000);
		} else {
			log("To input field element is not present for grade B.");
			Thread.sleep(500);
		}
		if (input_Grade_B.isDisplayed()) {
			input_Grade_B.clear();
			input_Grade_B.sendKeys(grade_B);
			log("Grade entered: " + grade_B + " and object is:-" + input_Grade_B.toString());
			Thread.sleep(1000);
		} else {
			log("Grade input field element is not present for grade B.");
			Thread.sleep(500);
		}
		if (input_GradePoint_B.isDisplayed()) {
			input_GradePoint_B.clear();
			input_GradePoint_B.sendKeys(gradePoint_B);
			log("Grade point entered: " + gradePoint_B + " and object is:-" + input_GradePoint_B.toString());
			Thread.sleep(1000);
		} else {
			log("Grade point input field element is not present for grade B.");
			Thread.sleep(500);
		}
		if (input_Remarks_B.isDisplayed()) {
			input_Remarks_B.clear();
			input_Remarks_B.sendKeys(remarks_B);
			log("Remarks entered: " + remarks_B + " and object is:-" + input_Remarks_B.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks input field element is not present for grade B.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Third row of grade details
	 * 
	 * @param from_C
	 * @param to_C
	 * @param grade_C
	 * @param gradePoint_C
	 * @param remarks_C
	 * @throws Exception
	 */
	public void fill_MasterGradeDetails_Grade_C(String from_C, String to_C, String grade_C, String gradePoint_C,
			String remarks_C) throws Exception {
		if (input_From_C.isDisplayed()) {
			input_From_C.clear();
			input_From_C.sendKeys(from_C);
			log("From Marks/Percentage value for grade C entered: " + from_C + " and object is:-"
					+ input_From_C.toString());
			Thread.sleep(1000);
		} else {
			log("From input field element is not present for grade C.");
			Thread.sleep(500);
		}
		if (input_To_C.isDisplayed()) {
			input_To_C.clear();
			input_To_C.sendKeys(to_C);
			log("To Marks/Percentage value for grade C entered: " + to_C + " and object is:-" + input_To_C.toString());
			Thread.sleep(1000);
		} else {
			log("To input field element is not present for grade C.");
			Thread.sleep(500);
		}
		if (input_Grade_C.isDisplayed()) {
			input_Grade_C.clear();
			input_Grade_C.sendKeys(grade_C);
			log("Grade entered: " + grade_C + " and object is:-" + input_Grade_C.toString());
			Thread.sleep(1000);
		} else {
			log("Grade input field element is not present for grade C.");
			Thread.sleep(500);
		}
		if (input_GradePoint_C.isDisplayed()) {
			input_GradePoint_C.clear();
			input_GradePoint_C.sendKeys(gradePoint_C);
			log("Grade point entered: " + gradePoint_C + " and object is:-" + input_GradePoint_C.toString());
			Thread.sleep(1000);
		} else {
			log("Grade point input field element is not present for grade C.");
			Thread.sleep(500);
		}
		if (input_Remarks_C.isDisplayed()) {
			input_Remarks_C.clear();
			input_Remarks_C.sendKeys(remarks_C);
			log("Remarks entered: " + remarks_C + " and object is:-" + input_Remarks_C.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks input field element is not present for grade C.");
			Thread.sleep(500);
		}
	}

	/**
	 * Fill Forth row of grade details
	 * 
	 * @param from_D
	 * @param to_D
	 * @param grade_D
	 * @param gradePoint_D
	 * @param remarks_D
	 * @throws Exception
	 */
	public void fill_MasterGradeDetails_Grade_D(String from_D, String to_D, String grade_D, String gradePoint_D,
			String remarks_D) throws Exception {
		if (input_From_D.isDisplayed()) {
			input_From_D.clear();
			input_From_D.sendKeys(from_D);
			log("From Marks/Percentage value for grade D entered: " + from_D + " and object is:-"
					+ input_From_D.toString());
			Thread.sleep(1000);
		} else {
			log("From input field element is not present for grade D.");
			Thread.sleep(500);
		}
		if (input_To_D.isDisplayed()) {
			input_To_D.clear();
			input_To_D.sendKeys(to_D);
			log("To Marks/Percentage value for grade D entered: " + to_D + " and object is:-" + input_To_D.toString());
			Thread.sleep(1000);
		} else {
			log("To input field element is not present for grade D.");
			Thread.sleep(500);
		}
		if (input_Grade_D.isDisplayed()) {
			input_Grade_D.clear();
			input_Grade_D.sendKeys(grade_D);
			log("Grade entered: " + grade_D + " and object is:-" + input_Grade_D.toString());
			Thread.sleep(1000);
		} else {
			log("Grade input field element is not present for grade D.");
			Thread.sleep(500);
		}
		if (input_GradePoint_D.isDisplayed()) {
			input_GradePoint_D.clear();
			input_GradePoint_D.sendKeys(gradePoint_D);
			log("Grade point entered: " + gradePoint_D + " and object is:-" + input_GradePoint_D.toString());
			Thread.sleep(1000);
		} else {
			log("Grade point input field element is not present for grade D.");
			Thread.sleep(500);
		}
		if (input_Remarks_D.isDisplayed()) {
			input_Remarks_D.clear();
			input_Remarks_D.sendKeys(remarks_D);
			log("Remarks entered: " + remarks_D + " and object is:-" + input_Remarks_D.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks input field element is not present for grade D.");
			Thread.sleep(500);
		}
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeB() throws Exception {
		if (btn_Action_Add_A.isDisplayed()) {
			btn_Action_Add_A.click();
			log("Clicked on grade A plus sign to get row for grade B and object:-" + btn_Action_Add_A.toString());
			Thread.sleep(1000);
		} else {
			log("Grade A plus sign element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeC() throws Exception {
		if (btn_Action_Add_B.isDisplayed()) {
			btn_Action_Add_B.click();
			log("Clicked on grade B plus sign to get row for grade C and object:-" + btn_Action_Add_B.toString());
			Thread.sleep(1000);
		} else {
			log("Grade B plus sign element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeD() throws Exception {
		if (btn_Action_Add_C.isDisplayed()) {
			btn_Action_Add_C.click();
			log("Clicked on grade C plus sign to get row for grade D and object:-" + btn_Action_Add_C.toString());
			Thread.sleep(1000);
		} else {
			log("Grade C plus sign element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnMinusSign_ToRemoveRow_GradeD() throws Exception {
		if (btn_Action_Minus_D.isDisplayed()) {
			btn_Action_Minus_D.click();
			log("Clicked on grade D Minus sign to Remove row for grade D and object:-" + btn_Action_Minus_D.toString());
			Thread.sleep(1000);
		} else {
			log("Grade D Minus sign element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitMasterGradeDetails() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit Master Grade Form and object is:- " + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearMasterGradeFilledData() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clicked on Cancel button to Clear Master Grade Form filled data and object is:- "
					+ btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button for Master Grade form element is not present.");
			Thread.sleep(500);
		}
	}

	public void submitBlank_MasterGradeDetails() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit Blank Master Grade Form and object is:- " + btn_Save.toString());
			Thread.sleep(2000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_MasterGrade() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_MasterGrade);
		Thread.sleep(1000);
		if (btn_Min_Max_GradeMaster.isDisplayed()) {
			btn_Min_Max_GradeMaster.click();
			log("Exam Master Grade page minimized or maximized and object is:-" + btn_Min_Max_GradeMaster.toString());
			Thread.sleep(1000);
		} else {
			log("Master Grade Minimized OR Maximize Element not present.");
		}
	}

	public void min_Max_GradeMasterDetailsForm() throws Exception {
		if (btn_Min_Max_GradeMasterDetails.isDisplayed()) {
			btn_Min_Max_GradeMasterDetails.click();
			log("Master Grade Details page minimized or maximized and object is:-"
					+ btn_Min_Max_GradeMasterDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Master Grade Details Minimize OR Maximize Element not present.");
		}
	}

	public void min_Max_GradeMaster_GridView() throws Exception {
		if (btn_Min_Max_GradeMasterGridView.isDisplayed()) {
			btn_Min_Max_GradeMasterGridView.click();
			log("Master Grade Grid View page minimized or maximized and object is:-"
					+ btn_Min_Max_GradeMasterGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Master Grade Grid View Minimize OR Maximize Element not present.");
		}
	}

	public void sortWithGradeNameInGridView() throws Exception {

		if (btn_Sort_GradeName.isDisplayed()) {
			btn_Sort_GradeName.click();
			log("Sort by Grade Name in Master Grade grid and object is:- " + btn_Sort_GradeName.toString());
			Thread.sleep(1000);
		} else {
			log("Grade Name button element not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void sortWithMarksOrPercentageInGridView() throws Exception {

		if (btn_Sort_MarksOrPercentage.isDisplayed()) {
			btn_Sort_MarksOrPercentage.click();
			log("Sort by Marks Or Percentage in grid view and object is:- " + btn_Sort_MarksOrPercentage.toString());
			Thread.sleep(1000);
		} else {
			log("Marks/Percentage button element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_GradeName(String gradeName, String marksOrPercentage) throws Exception {
		if (input_GradeNameFilter.isDisplayed()) {
			input_GradeNameFilter.clear();
			input_GradeNameFilter.sendKeys(gradeName);
			log("Entered Grade Name: " + gradeName + " to filter records and object is:- "
					+ input_GradeNameFilter.toString());
			Thread.sleep(1000);
		} else {
			log("Grade Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_MarksOrPercentage(String gradeName, String marksOrPercentage)
			throws Exception {
		if (input_MarksOrPercentage.isDisplayed()) {
			input_MarksOrPercentage.clear();
			input_MarksOrPercentage.sendKeys(marksOrPercentage);
			log("Entered Marks/Percentage: " + marksOrPercentage + " to filter records and object is:- "
					+ input_MarksOrPercentage.toString());
			Thread.sleep(1000);
		} else {
			log("Marks/Percentage input field element not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void clearFilledDataForFilter() throws Exception {
		input_GradeNameFilter.clear();
		input_MarksOrPercentage.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeMasterGradeDetails() throws Exception {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// btn_Edit_Grid);
		// Thread.sleep(1000);
		if (icon_View.isDisplayed()) {
			icon_View.click();
			log("Clicked on View Icon to launch pop up windows to see created Master Grade Details and object is:-"
					+ icon_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			Thread.sleep(1000);
		} else {
			log("View Icon element is not present in grid.");
			Thread.sleep(500);
		}
	}

	public void closeViewWindow_MasterGrade() throws Exception {

		if (btn_View_ClosePopUp.isDisplayed()) {
			btn_View_ClosePopUp.click();
			log("View window close button is clicked and object is:- " + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
		} else {
			log("View Close button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnEditIcon_ToUpdateMasterGrade() throws Exception {

		if (icon_Edit.isDisplayed()) {
			icon_Edit.click();
			log("Clicked on Edit Icon to update Master Grade and object is:-" + icon_Edit.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void deactivateRecords_MasterGradeGrid() throws Exception {

		if (icon_Deactivate.isDisplayed()) {

			String DeactivateText = icon_Deactivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_Deactivate.click();
			log("Clicked on Deacivate Icon to Deactivate Master Grade record and object is:-"
					+ icon_Deactivate.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon Master Grade element is not present.");
			Thread.sleep(500);
		}
	}

	public void activateRecords_MasterGradeGrid() throws Exception {

		if (icon_Activate.isDisplayed()) {

			String ActivateText = icon_Activate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_Activate.click();
			log("Clicked on Acivate Icon to Activate Master Grade record and object is:-"
					+ icon_Activate.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon Master Grade Grid element is not present.");
			Thread.sleep(500);
		}
	}

	public void yesDeactivateOrActivateRecords() throws Exception {
		if (btnPopUp_YesDeactivateOrActivateit.isDisplayed()) {
			btnPopUp_YesDeactivateOrActivateit.click();
			log("Clicked on Yes Deactivate Or Activate button for deactivation or Activation of record and object is:- "
					+ btnPopUp_YesDeactivateOrActivateit.toString());
			Thread.sleep(2000);
		} else {
			log("Yes Deactivate or Activate it button is not present.");
			Thread.sleep(500);
		}
	}

	public void cancelDeactivationAndActivationOfRecord() throws Exception {
		if (btnPopUp_Cancel.isDisplayed()) {
			btnPopUp_Cancel.click();
			log("Clicked on Cancel button for Cancelation of Activation or Deactivation of record and object is:- "
					+ btnPopUp_Cancel.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel button is not present in Activation and deactivation pop up.");
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
			btnOKSuccess.click();
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}
}
