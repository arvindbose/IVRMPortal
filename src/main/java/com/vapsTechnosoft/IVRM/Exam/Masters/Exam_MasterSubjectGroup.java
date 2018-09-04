/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.Masters;

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

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[7]")
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

	public Exam_MasterSubjectGroup(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Master Subject Group
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterSubjectGroup() throws Exception {

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
		if (btn_ExamMasterSubjectGroup.isDisplayed()) {
			btn_ExamMasterSubjectGroup.click();
			log("Clicked on Exam Master Subject Group Button and object is:-" + btn_ExamMasterSubjectGroup.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Exam Master Subject Group Navigation element not present.");
			Thread.sleep(500);
		}
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
		if (input_GroupName.isDisplayed()) {
			input_GroupName.clear();
			input_GroupName.sendKeys(groupName);
			log("Entered Master Group Name:- " + groupName + " and object is: " + input_GroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name element is not present.");
			Thread.sleep(500);
		}
		if (input_MaxSubjects.isDisplayed()) {
			input_MaxSubjects.clear();
			input_MaxSubjects.sendKeys(maxSubject);
			log("Entered Max Subjects:- " + maxSubject + " and object is: " + input_MaxSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Max Subjects element is not present.");
			Thread.sleep(500);
		}
		if (input_MaxApplicableSubjects.isDisplayed()) {
			input_MaxApplicableSubjects.clear();
			input_MaxApplicableSubjects.sendKeys(maxApplSubject);
			log("Entered Max Applicatble Subjects:- " + maxApplSubject + " and object is: "
					+ input_MaxApplicableSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Max Applicatble Subjects element is not present.");
			Thread.sleep(500);
		}
		if (input_MinApplicableSubjects.isDisplayed()) {
			input_MinApplicableSubjects.clear();
			input_MinApplicableSubjects.sendKeys(minApplSubject);
			log("Entered Min Applicatble Subjects:- " + minApplSubject + " and object is: "
					+ input_MinApplicableSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Min Applicatble Subjects element is not present.");
			Thread.sleep(500);
		}
		if (input_BestOfSubjects.isDisplayed()) {
			input_BestOfSubjects.clear();
			input_BestOfSubjects.sendKeys(groupName);
			log("Entered Best of Subjects:- " + groupName + " and object is: " + input_BestOfSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Best of Subjects element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Search or filter subject with subject name
	 * 
	 * @param subjectName
	 * @throws Exception
	 */

	public void searchWithSubjectName(String subjectName) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(subjectName);
			log("Entered Subject Name to filter subject:- " + subjectName + " and object is: "
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search/filter  element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Select Subject to create subject group
	 * 
	 * @throws Exception
	 */
	public void selectSubjectForGrouping() throws Exception {

		// int no_Of_Subject = chk_SubjectList.size();
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
	}

	public void clickOnSaveButton_ToCreateMasterSubjectGroup() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit Master Subject Group Form and object is:- " + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearMasterSubjectGroupFilledData() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clicked on Cancel button to Clear Master Subject Group Form filled data and object is:- "
					+ btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button for Master Subject Group form element is not present.");
			Thread.sleep(500);
		}
	}

	public void submitBlank_MasterSubjectGroup() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Clicked on Save button to Submit Blank Master Grade Form and object is:- " + btn_Save.toString());
			Thread.sleep(2000);

		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_MasterSubjectGroup() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_MasterSubjectGroup);
		Thread.sleep(1000);
		if (btn_Min_Max_MasterSubjectGroup.isDisplayed()) {
			btn_Min_Max_MasterSubjectGroup.click();
			log("Exam Master Subject Group page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterSubjectGroup.toString());
			Thread.sleep(1000);
		} else {
			log("Master Subject Group Minimized OR Maximize Element not present.");
		}
	}

	public void min_Max_MasterGroupDetailsForm() throws Exception {
		if (btn_Min_Max_MasterGroupDetails.isDisplayed()) {
			btn_Min_Max_MasterGroupDetails.click();
			log("Master Group Details page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterGroupDetails.toString());
			Thread.sleep(1000);
		} else {
			log("Master Group Details Minimize OR Maximize Element not present.");
		}
	}
	public void sortWithGroupNameInGridView() throws Exception {

		if (btn_Sort_GroupName.isDisplayed()) {
			btn_Sort_GroupName.click();
			log("Sort by Group Name in Master Subject Group grid and object is:- " + btn_Sort_GroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name button element not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void sortWithTotalSubjectsInGridView() throws Exception {

		if (btn_Sort_TotalSubjects.isDisplayed()) {
			btn_Sort_TotalSubjects.click();
			log("Sort by Total Subjects in grid view and object is:- " + btn_Sort_TotalSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Total Subjects button element not present.");
			Thread.sleep(500);
		}
	}
	public void sortWithMaxApplicableSubjectInGridView() throws Exception {

		if (btn_Sort_MaxApplicableSubjects.isDisplayed()) {
			btn_Sort_MaxApplicableSubjects.click();
			log("Sort by Maximum Applicable subjects in Master Subject group grid and object is:- " + btn_Sort_MaxApplicableSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Maximum Applicable subjects button element not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void sortWithMinApplicableSubjectInGridView() throws Exception {

		if (btn_Sort_MinApplicableSubjects.isDisplayed()) {
			btn_Sort_MinApplicableSubjects.click();
			log("Sort by Minimum Applicable subjects in Master Subject group grid and object is:- " + btn_Sort_MinApplicableSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Minimum Applicable subjects button element not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void sortWithBestOfSubjectInGridView() throws Exception {

		if (btn_Sort_BestOfSubjects.isDisplayed()) {
			btn_Sort_BestOfSubjects.click();
			log("Sort by Best of Subject in grid view and object is:- " + btn_Sort_BestOfSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Best of Subject button element not present.");
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_GroupName(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		if (input_GroupNameFilter.isDisplayed()) {
			input_GroupNameFilter.clear();
			input_GroupNameFilter.sendKeys(groupName);
			log("Entered Group Name: " + groupName + " to filter records and object is:- "
					+ input_GroupNameFilter.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_TotalSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject)
			throws Exception {
		if (input_TotalSubjects.isDisplayed()) {
			input_TotalSubjects.clear();
			input_TotalSubjects.sendKeys(maxSubject);
			log("Entered Total Subjects: " + maxSubject + " to filter records and object is:- "
					+ input_TotalSubjects.toString());
			Thread.sleep(1000);
		} else {
			log("Total Subjects input field element not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_MaxApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		if (input_MaxApplicableSubjectsFilter.isDisplayed()) {
			input_MaxApplicableSubjectsFilter.clear();
			input_MaxApplicableSubjectsFilter.sendKeys(maxApplSubject);
			log("Entered Max Applicable Subjects: " + maxApplSubject + " to filter records and object is:- "
					+ input_MaxApplicableSubjectsFilter.toString());
			Thread.sleep(1000);
		} else {
			log("Max Applicable Subjects input field element not present.");
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_MinApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject) throws Exception {
		if (input_MinApplicableSubjectsFilter.isDisplayed()) {
			input_MinApplicableSubjectsFilter.clear();
			input_MinApplicableSubjectsFilter.sendKeys(minApplSubject);
			log("Entered Min Applicable Subjects: " + minApplSubject + " to filter records and object is:- "
					+ input_MinApplicableSubjectsFilter.toString());
			Thread.sleep(1000);
		} else {
			log("Min Applicable Subjects input field element not present.");
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_BestOfSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject)
			throws Exception {
		if (input_BestOfSubjectsFilter.isDisplayed()) {
			input_BestOfSubjectsFilter.clear();
			input_BestOfSubjectsFilter.sendKeys(bestOfSubject);
			log("Entered Best Of Subjects: " + bestOfSubject + " to filter records and object is:- "
					+ input_BestOfSubjectsFilter.toString());
			Thread.sleep(1000);
		} else {
			log("Best Of Subjects input field element not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void clearFilledDataForFilter() throws Exception {
		input_GroupNameFilter.clear();
		input_TotalSubjects.clear();
		input_MaxApplicableSubjectsFilter.clear();
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
		if (icon_View.isDisplayed()) {
			icon_View.click();
			log("Clicked on View Icon to launch pop up windows to see created Master Subject Group Details and object is:-"
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

	public void closeViewWindow_MasterSubjectGroup() throws Exception {

		if (btn_View_ClosePopUp.isDisplayed()) {
			btn_View_ClosePopUp.click();
			log("View window close button is clicked and object is:- " + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
		} else {
			log("View Close button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnEditIcon_ToUpdateMasterSubjectGroup() throws Exception {

		if (icon_Edit.isDisplayed()) {
			icon_Edit.click();
			log("Clicked on Edit Icon to update Master Subject Group and object is:-" + icon_Edit.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present in output grid.");
			Thread.sleep(500);
		}
	}
	
	public void deactivateRecords_MasterSubjectGroupGrid() throws Exception {

		if (icon_Deactivate.isDisplayed()) {

			String DeactivateText = icon_Deactivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_Deactivate.click();
			log("Clicked on Deacivate Icon to Deactivate Master Subject Group record and object is:-"
					+ icon_Deactivate.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon Master Subject Group element is not present.");
			Thread.sleep(500);
		}
	}

	public void activateRecords_MasterSubjectGroupGrid() throws Exception {

		if (icon_Activate.isDisplayed()) {

			String ActivateText = icon_Activate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_Activate.click();
			log("Clicked on Acivate Icon to Activate Master Subject Group record and object is:-"
					+ icon_Activate.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon Master Subject Group Grid element is not present.");
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
