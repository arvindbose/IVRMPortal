/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

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
public class Exam_CategorySubjectMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_CategorySubjectMapping.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	// @FindBy(xpath =
	// "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam
	// Mapping')][1]/following::li[5]")
	// private WebElement btn_CategorySubjectMapping;

	@FindBy(xpath = "//a[@href='#/app/CategorySubjectMapping/250']")
	private WebElement btn_CategorySubjectMapping;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_CategorySubjectMapping;

	@FindBy(xpath = "//label[contains(text(),'Academic Year :')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Category :')]/following-sibling::div/select")
	private WebElement sel_Category;

	@FindBy(xpath = "//label[contains(text(),'Subject Group :')]/following-sibling::div/select")
	private WebElement sel_SubjectGroup;

	@FindBy(xpath = "//input[@name='subjs']")
	private List<WebElement> Chk_Subjects;
	// label[contains(text(),'Subjects
	// :')]/following-sibling::div/div/label/input

	@FindBy(xpath = "//span[contains(text(),'save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[text()='Academic Year']")
	private WebElement btn_Sort_AcademicYear;

	@FindBy(xpath = "//span[text()='Academic Year']/following::div[2]/div/input")
	private WebElement input_AcademicYear;

	@FindBy(xpath = "//span[text()='Category Name']")
	private WebElement btn_Sort_CategoryName;

	@FindBy(xpath = "//span[text()='Category Name']/following::div[2]/div/input")
	private WebElement input_CategoryName;

	@FindBy(xpath = "//span[text()='Group Name']")
	private WebElement btn_Sort_GroupName;

	@FindBy(xpath = "//span[text()='Group Name']/following::div[2]/div/input")
	private WebElement input_GroupName;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[6]/div/a[1]")
	private WebElement btn_View;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[6]/div/a[2]")
	private WebElement btn_Edit;

	@FindBy(xpath = "//div[@class='ui-grid-canvas']/div[1]//div[6]/div/span/a")
	private WebElement btn_DeactivateOrActivate;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateOrActivateit;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btn_PopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxCategorySubjectMapping;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxCategorySubjectMappingGridView;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_CategorySubjectMapping(WebDriver driver) {
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
	 * Navigate to Exam > Exam Mapping > Category Subject Mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMapping_CategorySubjectMapping() throws Exception {

		clickOnButton(btn_Exam);
		log("Clicked on Exam Button and object is:-" + btn_Exam.toString());

		clickOnButton(btn_ExamMapping);
		log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());

		clickOnButton(btn_CategorySubjectMapping);
		log("Clicked on Exam Category Subject Mapping Button and object is:-" + btn_CategorySubjectMapping.toString());

	}

	/**
	 * Validation of Exam Category Subject Mapping screen message
	 * 
	 * @return
	 */
	public boolean verifyExamCategorySubjectMappingPage() {
		try {
			System.out.println(txt_CategorySubjectMapping.getText());
			txt_CategorySubjectMapping.isDisplayed();
			log("Exam Category Subject Mapping page is dispalyed and object is:-"
					+ txt_CategorySubjectMapping.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Category Subject Mapping Form
	 * 
	 * @param academicYear
	 * @param category
	 * @param subjectGroup
	 * @throws Exception
	 */
	public void fill_CategorySubjectMapping_Form(String academicYear, String category, String subjectGroup)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Category, category);
		log("Selected Category: " + category + " and object is:- " + sel_Category.toString());

		selectElementFromDropDown(sel_SubjectGroup, subjectGroup);
		log("Selected Subject Group: " + subjectGroup + " and object is:- " + sel_SubjectGroup.toString());
		try {
			int no_Of_Subjects = Chk_Subjects.size();
			for (int i = 0; i < no_Of_Subjects; i++) {
				if (!Chk_Subjects.get(i).isSelected()) {
					Chk_Subjects.get(i).click();
					log(i + " Subject check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " Subject checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Submit blank Category Subject Mapping form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_CategorySubjectMappingForm() throws Exception {

		clickOnButton(btn_Save);
		log("Submit blank Category Subject Mapping form and object is:-" + btn_Save.toString());

	}

	/**
	 * Click on save button to save Category Subject Mapping data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitCategorySubjectMappingForm() throws Exception {

		clickOnButton(btn_Save);
		log("clicked on save button to Submit the records for Category Subject Mapping and object is:-"
				+ btn_Save.toString());

	}

	public void clickOnCancelButton_ToClearFilledCategorySubjectMappingForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("clicked on Cancel button to clear filled data for Category Subject Mapping and object is:-"
				+ btn_Cancel.toString());

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

	public void sortWithAcademicYearInGridView() throws Exception {

		clickOnButton(btn_Sort_AcademicYear);
		log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());

	}

	public void sortWithCategoryNameInGridView() throws Exception {

		clickOnButton(btn_Sort_CategoryName);
		log("Sort by Category Name in grid view and object is:- " + btn_Sort_CategoryName.toString());

	}

	public void sortWithGroupNameInGridView() throws Exception {

		clickOnButton(btn_Sort_GroupName);
		log("Sort by Group Name in grid view and object is:- " + btn_Sort_GroupName.toString());

	}

	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String groupName)
			throws Exception {

		inputTextIntoInputField(input_AcademicYear, academicYear);
		log("Entered academic year " + academicYear + " to filter records and object is:- "
				+ input_AcademicYear.toString());

	}

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String groupName)
			throws Exception {

		inputTextIntoInputField(input_CategoryName, categoryName);
		log("Entered Category Name " + categoryName + " to filter records and object is:- "
				+ input_CategoryName.toString());

	}

	public void filterRecordsBasedOn_GroupName(String academicYear, String categoryName, String groupName)
			throws Exception {

		inputTextIntoInputField(input_GroupName, groupName);
		log("Entered Group Name " + groupName + " to filter records and object is:- " + input_GroupName.toString());

	}

	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_AcademicYear);
		input_AcademicYear.clear();
		isDisplayed(input_CategoryName);
		input_CategoryName.clear();
		isDisplayed(input_GroupName);
		input_GroupName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode() throws Exception {

		clickOnButton(btn_View);
		log("Clicked on View Icon to launch pop up windows to see subject and subject code and object is:-"
				+ btn_View.toString());
		Thread.sleep(1000);
		boolean closeButton = btn_View_ClosePopUp.isDisplayed();
		Assert.assertTrue(closeButton);

	}

	public void clickOnEditIcon_ToUpdateCategorySubjectMapping() throws Exception {

		clickOnButton(btn_Edit);
		log("Clicked on Edit Icon to update category subject mapping and object is:-" + btn_Edit.toString());

	}

	public void clickOnDeActivationIcon_ToDeactivateCategorySubjectMapping() throws Exception {

		isDisplayed(btn_DeactivateOrActivate);
		String DeactivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
		System.out.println("Tool tip text present :- " + DeactivateText);

		// Compare toll tip text
		Assert.assertEquals(DeactivateText, "Deactivate Now");

		btn_DeactivateOrActivate.click();
		log("Clicked on Deacivate Icon to Deactivate Category subject mapping and object is:-"
				+ btn_DeactivateOrActivate.toString());
		Thread.sleep(2000);
	}

	public void clickOnActivationIcon_ToActivateCategorySubjectMapping() throws Exception {

		isDisplayed(btn_DeactivateOrActivate);
		String ActivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
		System.out.println("Tool tip text present(Activate) :- " + ActivateText);

		// Compare tool tip text
		Assert.assertEquals(ActivateText, "Activate Now");

		btn_DeactivateOrActivate.click();
		log("Clicked on Activate Icon to Activate Category subject mapping and object is:-"
				+ btn_DeactivateOrActivate.toString());

	}

	public void closeViewPopUpWindows() throws Exception {

		clickOnButton(btn_View_ClosePopUp);
		log("View pop Up windows is closed and object is:-" + btn_View_ClosePopUp.toString());
		Thread.sleep(1000);
		boolean closeButton = btn_View_ClosePopUp.isDisplayed();
		Assert.assertFalse(closeButton);

	}

	/**
	 * Confirmation for deactivate and activate
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivateAndActivate() throws Exception {

		clickOnButton(btnPopUpYesDeactivateOrActivateit);
		log("Clicked Yes deactivate Or Activate it button and object is:"
				+ btnPopUpYesDeactivateOrActivateit.toString());

	}

	/**
	 * Deactivate Or Activate cancel
	 * 
	 * @throws Exception
	 */

	public void cancel_DeactivateOrActivatePopUp() throws Exception {

		clickOnButton(btn_PopUpCancel);
		log("Clicked on cancel button to cancel the Deactivate or Activate records and object is:-"
				+ btn_PopUpCancel.toString());

	}

	public void min_Max_CategorySubjectMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_CategorySubjectMapping);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxCategorySubjectMapping);
		log("Category Subject Mapping page minimized or maximized and object is:-"
				+ btnMin_MaxCategorySubjectMapping.toString());

	}

	public void min_Max_CategorySubjectMapping_GridView() throws Exception {

		clickOnButton(btnMin_MaxCategorySubjectMappingGridView);
		log("Category Subject Mapping Grid View page minimized or maximized and object is:-"
				+ btnMin_MaxCategorySubjectMappingGridView.toString());

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
