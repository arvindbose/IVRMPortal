/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

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
public class Exam_MasterSubjectGroup extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MasterSubjectGroup.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]")
	private WebElement btn_Exam_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[7]")
	// private WebElement btn_ExamMasterSubjectGroup;

	@FindBy(xpath = "//a[@href='#/app/MasterSubjectGroup/229']")
	private WebElement btn_ExamMasterSubjectGroup;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_MasterSubjectGroup;

	@FindBy(xpath = "//label[contains(text(),'Group Name :')]/following-sibling::div/input")
	private WebElement input_GroupName;

	@FindBy(xpath = "//label[contains(text(),'Max.Subjects :')]/following-sibling::div/input")
	private WebElement input_MaxSubjects;

	@FindBy(xpath = "//label[text()='Max.Applicable Subjects:']/following-sibling::div/input[ @ng-model='EMG_MaxAplSubjects']")
	private WebElement input_MaxApplicableSubjects;

	@FindBy(xpath = "//label[text()='Min.Applicable Subjects :']/following-sibling::div/input")
	private WebElement input_MinApplicableSubjects;

	@FindBy(xpath = "//label[text()='Best Off Subjects :']/following-sibling::div/input")
	private WebElement input_BestOfSubjects;

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement input_Search;

	@FindBy(xpath = "//table//tbody/tr/td[2]/label/input")
	private List<WebElement> chk_SubjectList;

	@FindBy(xpath = "//button[@id='save-btn']")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_MasterSubjectGroup;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_MasterGroupDetails;

	// OUTPUT GRID
	@FindBy(xpath = "//span[contains(text(),'Group Name')]")
	private WebElement btn_Sort_GroupName;

	@FindBy(xpath = "//span[contains(text(),'Group Name')]/following::div[2]/div/input")
	private WebElement input_GroupNameFilter;

	@FindBy(xpath = "//span[contains(text(),'Total Subjects')]")
	private WebElement btn_Sort_TotalSubjects;

	@FindBy(xpath = "//span[contains(text(),'Total Subjects')]/following::div[2]/div/input")
	private WebElement input_TotalSubjects;

	@FindBy(xpath = "//span[contains(text(),'Max.Applicable Subjects')]")
	private WebElement btn_Sort_MaxApplicableSubjects;

	@FindBy(xpath = "//span[contains(text(),'Max.Applicable Subjects')]/following::div[2]/div/input")
	private WebElement input_MaxApplicableSubjectsFilter;

	@FindBy(xpath = "//span[contains(text(),'Min.Applicable Subjects')]")
	private WebElement btn_Sort_MinApplicableSubjects;

	@FindBy(xpath = "//span[contains(text(),'Min.Applicable Subjects')]/following::div[2]/div/input")
	private WebElement input_MinApplicableSubjectsFilter;

	@FindBy(xpath = "//span[contains(text(),'BestOff Subjects')]")
	private WebElement btn_Sort_BestOfSubjects;

	@FindBy(xpath = "//span[contains(text(),'BestOff Subjects')]/following::div[2]/div/input")
	private WebElement input_BestOfSubjectsFilter;

	@FindBy(xpath = "//span[text()='Actions']/following::div[21]/a[1]")
	private WebElement icon_View;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "//span[text()='Actions']/following::div[21]/a[2]")
	private WebElement icon_Edit;

	@FindBy(xpath = "//span[text()='Actions']/following::div[21]/span/a")
	private WebElement icon_Deactivate;

	@FindBy(xpath = "//span[text()='Actions']/following::div[21]/a[3]")
	private WebElement icon_Activate;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement btnPopUp_YesDeactivateOrActivateit;

	@FindBy(xpath = "//button[@class='cancel' and text()='Cancel']")
	private WebElement btnPopUp_Cancel;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_MasterSubjectGroup(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Master Subject Group
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterSubjectGroup() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_Exam_Masters);
		log("Clicked on Exam Masters Button and object is:-" + btn_Exam_Masters.toString());

		clickOnButton(btn_ExamMasterSubjectGroup);
		log("Clicked on Exam Master Subject Group Button and object is:-" + btn_ExamMasterSubjectGroup.toString());

	}

	/**
	 * Validation of Exam Master Subject Group screen message
	 * 
	 * @return
	 */
	public boolean verifyExamMasterSubjectGroupPage() {
		try {
			System.out.println(txt_MasterSubjectGroup.getText());
			txt_MasterSubjectGroup.isDisplayed();
			log("Exam Master Subject Group  page is dispalyed and object is:-" + txt_MasterSubjectGroup.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Master Subject Group Form
	 * 
	 * @param groupName
	 * @param maxSubject
	 * @param maxApplSubject
	 * @param minApplSubject
	 * @param bestOfSubject
	 * @throws Exception
	 */
	public void fill_Exam_MasterSubjectGroup_Form(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_MasterSubjectGroup);
		Thread.sleep(1000);

			inputTextIntoInputField(input_GroupName, groupName);
			log("Entered Master Group Name:- " + groupName + " and object is: " + input_GroupName.toString());
		
			inputTextIntoInputField(input_MaxSubjects, maxSubject);
			log("Entered Max Subjects:- " + maxSubject + " and object is: " + input_MaxSubjects.toString());
		
			inputTextIntoInputField(input_MaxApplicableSubjects, maxApplSubject);
			log("Entered Max Applicatble Subjects:- " + maxApplSubject + " and object is: "
					+ input_MaxApplicableSubjects.toString());
			
			inputTextIntoInputField(input_MinApplicableSubjects, minApplSubject);
			log("Entered Min Applicatble Subjects:- " + minApplSubject + " and object is: "
					+ input_MinApplicableSubjects.toString());

			inputTextIntoInputField(input_BestOfSubjects, bestOfSubject);
			log("Entered Best of Subjects:- " + bestOfSubject + " and object is: " + input_BestOfSubjects.toString());
			
	}

	/**
	 * Search or filter subject with subject name
	 * 
	 * @param subjectName
	 * @throws Exception
	 */

	public void searchWithSubjectName(String subjectName) throws Exception {
		
			inputTextIntoInputField(input_Search, subjectName);
			log("Entered Subject Name to filter subject:- " + subjectName + " and object is: "
					+ input_Search.toString());
			
	}

	/**
	 * Select Subject to create subject group
	 * 
	 * @throws Exception
	 */
	public void selectSubjectForGrouping() throws Exception {

		// int no_Of_Subject = chk_SubjectList.size();
	try{
		for (int i = 0; i < 5; i++) {
			if (!chk_SubjectList.get(i).isSelected()) {
				chk_SubjectList.get(i).click();
				log(i + " Subject check box is checked.");
				Thread.sleep(1000);
			} else {
				log(i + " Subject check box is already checked.");
				Thread.sleep(500);
			}
		}
	}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnSaveButton_ToCreateMasterSubjectGroup() throws Exception {
		
			clickOnButton(btn_Save);
			log("Clicked on Save button to Submit Master Subject Group Form and object is:- " + btn_Save.toString());
			
	}

	public void clickOnCancelButton_ToClearMasterSubjectGroupFilledData() throws Exception {
		
			clickOnButton(btn_Cancel);
			log("Clicked on Cancel button to Clear Master Subject Group Form filled data and object is:- "
					+ btn_Cancel.toString());
			
	}

	public void submitBlank_MasterSubjectGroup() throws Exception {
		
			clickOnButton(btn_Save);
			log("Clicked on Save button to Submit Blank Master Grade Form and object is:- " + btn_Save.toString());
			
	}

	public void min_Max_MasterSubjectGroup() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_MasterSubjectGroup);
		Thread.sleep(1000);
	
			clickOnButton(btn_Min_Max_MasterSubjectGroup);
			log("Exam Master Subject Group page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterSubjectGroup.toString());
			
	}

	public void min_Max_MasterGroupDetailsForm() throws Exception {
		
			clickOnButton(btn_Min_Max_MasterGroupDetails);
			log("Master Group Details page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterGroupDetails.toString());
			
	}

	public void sortWithGroupNameInGridView() throws Exception {

			clickOnButton(btn_Sort_GroupName);
			log("Sort by Group Name in Master Subject Group grid and object is:- " + btn_Sort_GroupName.toString());
			
	}

	public void sortWithTotalSubjectsInGridView() throws Exception {

			clickOnButton(btn_Sort_TotalSubjects);
			log("Sort by Total Subjects in grid view and object is:- " + btn_Sort_TotalSubjects.toString());
			
	}

	public void sortWithMaxApplicableSubjectInGridView() throws Exception {

			clickOnButton(btn_Sort_MaxApplicableSubjects);
			log("Sort by Maximum Applicable subjects in Master Subject group grid and object is:- "
					+ btn_Sort_MaxApplicableSubjects.toString());
			
	}

	public void sortWithMinApplicableSubjectInGridView() throws Exception {

			clickOnButton(btn_Sort_MinApplicableSubjects);
			log("Sort by Minimum Applicable subjects in Master Subject group grid and object is:- "
					+ btn_Sort_MinApplicableSubjects.toString());
			
	}

	public void sortWithBestOfSubjectInGridView() throws Exception {

			clickOnButton(btn_Sort_BestOfSubjects);
			log("Sort by Best of Subject in grid view and object is:- " + btn_Sort_BestOfSubjects.toString());
			
	}

	public void filterRecordsBasedOn_GroupName(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		
			inputTextIntoInputField(input_GroupNameFilter, groupName);
			log("Entered Group Name: " + groupName + " to filter records and object is:- "
					+ input_GroupNameFilter.toString());
			
	}

	public void filterRecordsBasedOn_TotalSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
	
			inputTextIntoInputField(input_TotalSubjects, maxSubject);
			log("Entered Total Subjects: " + maxSubject + " to filter records and object is:- "
					+ input_TotalSubjects.toString());
			
	}

	public void filterRecordsBasedOn_MaxApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		
			inputTextIntoInputField(input_MaxApplicableSubjectsFilter, maxApplSubject);
			log("Entered Max Applicable Subjects: " + maxApplSubject + " to filter records and object is:- "
					+ input_MaxApplicableSubjectsFilter.toString());
			
	}

	public void filterRecordsBasedOn_MinApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		
			inputTextIntoInputField(input_MinApplicableSubjectsFilter, minApplSubject);
			log("Entered Min Applicable Subjects: " + minApplSubject + " to filter records and object is:- "
					+ input_MinApplicableSubjectsFilter.toString());
			
	}

	public void filterRecordsBasedOn_BestOfSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
	
			inputTextIntoInputField(input_BestOfSubjectsFilter, bestOfSubject);
			log("Entered Best Of Subjects: " + bestOfSubject + " to filter records and object is:- "
					+ input_BestOfSubjectsFilter.toString());
			
	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_GroupNameFilter);
		input_GroupNameFilter.clear();
		isDisplayed(input_TotalSubjects);
		input_TotalSubjects.clear();
		isDisplayed(input_MaxApplicableSubjectsFilter);
		input_MaxApplicableSubjectsFilter.clear();
		isDisplayed(input_MinApplicableSubjectsFilter);
		input_MinApplicableSubjectsFilter.clear();
		input_BestOfSubjectsFilter.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeMasterSubjectGroup() throws Exception {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// btn_Edit_Grid);
		// Thread.sleep(1000);
	
			clickOnButton(icon_View);
			log("Clicked on View Icon to launch pop up windows to see created Master Subject Group Details and object is:-"
					+ icon_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			
	}

	public void closeViewWindow_MasterSubjectGroup() throws Exception {

			clickOnButton(btn_View_ClosePopUp);
			log("View window close button is clicked and object is:- " + btn_View_ClosePopUp.toString());
			
	}

	public void clickOnEditIcon_ToUpdateMasterSubjectGroup() throws Exception {

			clickOnButton(icon_Edit);
			log("Clicked on Edit Icon to update Master Subject Group and object is:-" + icon_Edit.toString());
			
	}

	public void deactivateRecords_MasterSubjectGroupGrid() throws Exception {

			isDisplayed(icon_Deactivate);
			String DeactivateText = icon_Deactivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_Deactivate.click();
			log("Clicked on Deacivate Icon to Deactivate Master Subject Group record and object is:-"
					+ icon_Deactivate.toString());
			
		
	}

	public void activateRecords_MasterSubjectGroupGrid() throws Exception {

		
			isDisplayed(icon_Activate);
			String ActivateText = icon_Activate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_Activate.click();
			log("Clicked on Acivate Icon to Activate Master Subject Group record and object is:-"
					+ icon_Activate.toString());
			
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
