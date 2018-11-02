/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.Masters;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[6]")
	// private WebElement btn_ExamMasterGrade;

	@FindBy(xpath = "//a[@href='#/app/MasterExamGrade/99']")
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
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_MasterGrade(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Master Grade
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterGrade() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_Exam_Masters);
		log("Clicked on Exam Masters Button and object is:-" + btn_Exam_Masters.toString());

		clickOnButton(btn_ExamMasterGrade);
		log("Clicked on Exam Master Grade Button and object is:-" + btn_ExamMasterGrade.toString());

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
		isDisplayed(rdBtn_Percentage);
		if (!rdBtn_Percentage.isSelected()) {
			rdBtn_Percentage.click();
			log("Percentage radio button is selected and object is:-" + rdBtn_Percentage.toString());
			Thread.sleep(1000);
		} else {
			log("Percentage radio button is already selected");
			Thread.sleep(500);
		}
		
			inputTextIntoInputField(input_GradeName, gradeName);
			log("Entered Master Grade Name:- and object is: " + input_GradeName.toString());
			
	}

	/**
	 * Fill Exam Master Grade Form for Marks
	 * 
	 * @param gradeName
	 * 
	 * @throws Exception
	 */
	public void fill_Exam_MasterGrade_Form_Marks(String gradeName) throws Exception {
		isDisplayed(rdBtn_Marks);
		if (!rdBtn_Marks.isSelected()) {
			rdBtn_Marks.click();
			log("Marks radio button is selected and object is:-" + rdBtn_Marks.toString());
			Thread.sleep(1000);
		} else {
			log("Marks radio button is already selected");
			Thread.sleep(500);
		}
		
			inputTextIntoInputField(input_GradeName, gradeName);
			log("Entered Master Grade Name:- and object is: " + input_GradeName.toString());
			
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

			inputTextIntoInputField(input_From_A, from_A);
			log("From Marks/Percentage value for grade A entered: " + from_A + " and object is:-"
					+ input_From_A.toString());
	
			inputTextIntoInputField(input_To_A, to_A);
			log("To Marks/Percentage value for grade A entered: " + to_A + " and object is:-" + input_To_A.toString());
	
			inputTextIntoInputField(input_Grade_A, grade_A);
			log("Grade entered: " + grade_A + " and object is:-" + input_Grade_A.toString());
	
			inputTextIntoInputField(input_GradePoint_A, gradePoint_A);
			log("Grade point entered: " + gradePoint_A + " and object is:-" + input_GradePoint_A.toString());
		
			inputTextIntoInputField(input_Remarks_A, remarks_A);
			log("Remarks entered: " + remarks_A + " and object is:-" + input_Remarks_A.toString());
			
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
	
			inputTextIntoInputField(input_From_B, from_B);
			log("From Marks/Percentage value for grade B entered: " + from_B + " and object is:-"
					+ input_From_B.toString());

			inputTextIntoInputField(input_To_B, to_B);
			log("To Marks/Percentage value for grade B entered: " + to_B + " and object is:-" + input_To_B.toString());
	
			inputTextIntoInputField(input_Grade_B, grade_B);
			log("Grade entered: " + grade_B + " and object is:-" + input_Grade_B.toString());
			
			inputTextIntoInputField(input_GradePoint_B, gradePoint_B);
			log("Grade point entered: " + gradePoint_B + " and object is:-" + input_GradePoint_B.toString());
		
			inputTextIntoInputField(input_Remarks_B, remarks_B);
			log("Remarks entered: " + remarks_B + " and object is:-" + input_Remarks_B.toString());
			
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
		
			inputTextIntoInputField(input_From_C, from_C);
			log("From Marks/Percentage value for grade C entered: " + from_C + " and object is:-"
					+ input_From_C.toString());
	
			inputTextIntoInputField(input_To_C, to_C);
			log("To Marks/Percentage value for grade C entered: " + to_C + " and object is:-" + input_To_C.toString());
		
			inputTextIntoInputField(input_Grade_C, grade_C);
			log("Grade entered: " + grade_C + " and object is:-" + input_Grade_C.toString());
			
			inputTextIntoInputField(input_GradePoint_C, gradePoint_C);
			log("Grade point entered: " + gradePoint_C + " and object is:-" + input_GradePoint_C.toString());
	
			inputTextIntoInputField(input_Remarks_C, remarks_C);
			log("Remarks entered: " + remarks_C + " and object is:-" + input_Remarks_C.toString());
			
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
	
			inputTextIntoInputField(input_From_D, from_D);
			log("From Marks/Percentage value for grade D entered: " + from_D + " and object is:-"
					+ input_From_D.toString());
			
			inputTextIntoInputField(input_To_D, to_D);
			log("To Marks/Percentage value for grade D entered: " + to_D + " and object is:-" + input_To_D.toString());
	
			inputTextIntoInputField(input_Grade_D, grade_D);
			log("Grade entered: " + grade_D + " and object is:-" + input_Grade_D.toString());
	
			inputTextIntoInputField(input_GradePoint_D, gradePoint_D);
			log("Grade point entered: " + gradePoint_D + " and object is:-" + input_GradePoint_D.toString());
	
			inputTextIntoInputField(input_Remarks_D, remarks_D);
			log("Remarks entered: " + remarks_D + " and object is:-" + input_Remarks_D.toString());
			
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeB() throws Exception {
	
			clickOnButton(btn_Action_Add_A);
			log("Clicked on grade A plus sign to get row for grade B and object:-" + btn_Action_Add_A.toString());
			
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeC() throws Exception {
	
			clickOnButton(btn_Action_Add_B);
			log("Clicked on grade B plus sign to get row for grade C and object:-" + btn_Action_Add_B.toString());
			
	}

	public void clickOnPlusSign_ToGetNewRowForGradeDetails_GradeD() throws Exception {
		
			clickOnButton(btn_Action_Add_C);
			log("Clicked on grade C plus sign to get row for grade D and object:-" + btn_Action_Add_C.toString());
			
	}

	public void clickOnMinusSign_ToRemoveRow_GradeD() throws Exception {
	
			clickOnButton(btn_Action_Minus_D);
			log("Clicked on grade D Minus sign to Remove row for grade D and object:-" + btn_Action_Minus_D.toString());
			
	}

	public void clickOnSaveButton_ToSubmitMasterGradeDetails() throws Exception {
		
			clickOnButton(btn_Save);
			log("Clicked on Save button to Submit Master Grade Form and object is:- " + btn_Save.toString());
			
	}

	public void clickOnCancelButton_ToClearMasterGradeFilledData() throws Exception {
		
			clickOnButton(btn_Cancel);
			log("Clicked on Cancel button to Clear Master Grade Form filled data and object is:- "
					+ btn_Cancel.toString());
			
	}

	public void submitBlank_MasterGradeDetails() throws Exception {
		
			clickOnButton(btn_Save);
			log("Clicked on Save button to Submit Blank Master Grade Form and object is:- " + btn_Save.toString());
			
	}

	public void min_Max_MasterGrade() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_MasterGrade);
		Thread.sleep(1000);
		
			clickOnButton(btn_Min_Max_GradeMaster);
			log("Exam Master Grade page minimized or maximized and object is:-" + btn_Min_Max_GradeMaster.toString());
		
	}

	public void min_Max_GradeMasterDetailsForm() throws Exception {
		
			clickOnButton(btn_Min_Max_GradeMasterDetails);
			log("Master Grade Details page minimized or maximized and object is:-"
					+ btn_Min_Max_GradeMasterDetails.toString());
			
	}

	public void min_Max_GradeMaster_GridView() throws Exception {
	
			clickOnButton(btn_Min_Max_GradeMasterGridView);
			log("Master Grade Grid View page minimized or maximized and object is:-"
					+ btn_Min_Max_GradeMasterGridView.toString());
			
	}

	public void sortWithGradeNameInGridView() throws Exception {

			clickOnButton(btn_Sort_GradeName);
			log("Sort by Grade Name in Master Grade grid and object is:- " + btn_Sort_GradeName.toString());
			
	}

	public void sortWithMarksOrPercentageInGridView() throws Exception {

		
			clickOnButton(btn_Sort_MarksOrPercentage);
			log("Sort by Marks Or Percentage in grid view and object is:- " + btn_Sort_MarksOrPercentage.toString());
			
	}

	public void filterRecordsBasedOn_GradeName(String gradeName, String marksOrPercentage) throws Exception {
	
			inputTextIntoInputField(input_GradeNameFilter, gradeName);
			log("Entered Grade Name: " + gradeName + " to filter records and object is:- "
					+ input_GradeNameFilter.toString());
		
	}

	public void filterRecordsBasedOn_MarksOrPercentage(String gradeName, String marksOrPercentage) throws Exception {
		
			inputTextIntoInputField(input_MarksOrPercentage, marksOrPercentage);
			log("Entered Marks/Percentage: " + marksOrPercentage + " to filter records and object is:- "
					+ input_MarksOrPercentage.toString());
			
	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_GradeNameFilter);
		input_GradeNameFilter.clear();
		isDisplayed(input_MarksOrPercentage);
		input_MarksOrPercentage.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeMasterGradeDetails() throws Exception {
		
		
			clickOnButton(icon_View);
			log("Clicked on View Icon to launch pop up windows to see created Master Grade Details and object is:-"
					+ icon_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			Thread.sleep(1000);
		
	}

	public void closeViewWindow_MasterGrade() throws Exception {

			clickOnButton(btn_View_ClosePopUp);
			log("View window close button is clicked and object is:- " + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
		
	}

	public void clickOnEditIcon_ToUpdateMasterGrade() throws Exception {

			clickOnButton(icon_Edit);
			log("Clicked on Edit Icon to update Master Grade and object is:-" + icon_Edit.toString());
			
	}

	public void deactivateRecords_MasterGradeGrid() throws Exception {

			isDisplayed(icon_Deactivate);
			String DeactivateText = icon_Deactivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_Deactivate.click();
			log("Clicked on Deacivate Icon to Deactivate Master Grade record and object is:-"
					+ icon_Deactivate.toString());
			Thread.sleep(1000);
		
	}

	public void activateRecords_MasterGradeGrid() throws Exception {


			isDisplayed(icon_Activate);
			String ActivateText = icon_Activate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_Activate.click();
			log("Clicked on Acivate Icon to Activate Master Grade record and object is:-" + icon_Activate.toString());
			Thread.sleep(1000);
		
	}

	public void yesDeactivateOrActivateRecords() throws Exception {

			clickOnButton(btnPopUp_YesDeactivateOrActivateit);
			log("Clicked on Yes Deactivate Or Activate button for deactivation or Activation of record and object is:- "
					+ btnPopUp_YesDeactivateOrActivateit.toString());
			
	}

	public void cancelDeactivationAndActivationOfRecord() throws Exception {
		
			clickOnButton(btnPopUp_Cancel);
			log("Clicked on Cancel button for Cancelation of Activation or Deactivation of record and object is:- "
					+ btnPopUp_Cancel.toString());
			
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
			
	}
	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record saved successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record updated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_DeactivateCancel_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_DeactivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record De-activated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateCancel_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void popUpWindowMessage_ActivateSucessfully_Validation() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
