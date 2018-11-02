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
public class Exam_MasterCategoryAndCategoryClassMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MasterCategoryAndCategoryClassMapping.class.getName());

	private WebDriver driver;

	

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]")
	private WebElement btn_Exam_Masters;

//	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[3]")
//	private WebElement btn_ExamMasterCategory;

	@FindBy(xpath = "//a[@href='#/app/exammastercategory/94']")
	private WebElement btn_ExamMasterCategory;
	
	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_ExamMasterCategory;

	@FindBy(xpath = "//span[contains(text(),'Master Category')]//parent::md-tab-item")
	private WebElement tab_MasterCategory;

	@FindBy(xpath = "//label[contains(text(),'Category Name:')]/following-sibling::div/input")
	private WebElement input_CategoryName;

	@FindBy(xpath = "//span[contains(text(),'Save')]//parent::button")
	private WebElement btn_Save_MasterCategory;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//parent::button")
	private WebElement btn_Cancel_MasterCategory;

	@FindBy(xpath = "(//span[contains(text(),'Category Name')]/parent::div)[1]")
	private WebElement sort_CategoryName_MasterCategory;

	@FindBy(xpath = "(//div[@class='ng-scope']/input)[1]")
	private WebElement input_Filter_CategoryName_MasterCategory;

	@FindBy(xpath = "//span[text()='Actions']//following::div[11]/a[1]")
	private WebElement icon_Edit_MasterCategory;

	@FindBy(xpath = "//span[text()='Actions']//following::div[11]//span//a")
	private WebElement icon_Deactivate_MasterCategory;
		
	@FindBy(xpath = "//span[text()='Actions']//following::div[11]/a[2]")
	private WebElement icon_Activate_MasterCategory;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	/**
	 * Category Class Mapping
	 */

	@FindBy(xpath = "//span[contains(text(),'Category Class Mapping')]//parent::md-tab-item")
	private WebElement tab_CategoryClassMapping;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Category:')]/following-sibling::div/select")
	private WebElement sel_Category;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/label[1]/input")
	private WebElement chk_Section;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/label[2]/input")
	private WebElement chk_Section_edit;

	@FindBy(xpath = "//span[contains(text(),'ADD')]/parent::button")
	private WebElement btn_Add;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	private WebElement btn_Clear;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[6]/span[1]/a")
	private WebElement icon_Edit_Details;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr[2]/td[6]/span[2]/a")
	private WebElement icon_Delete_Details;

	@FindBy(xpath = "(//button[@id='save-btn'])[2]")
	private WebElement btn_Save_CategoryClassMapping;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	private WebElement btn_Cancel_CategoryClassMapping;

	@FindBy(xpath = "//span[contains(text(),'Academic Year')]")
	private WebElement btn_Sort_AcademicYear;

	@FindBy(xpath = "//span[contains(text(),'Academic Year')]/following::div[2]/div/input")
	private WebElement input_AcademicYear;

	@FindBy(xpath = "(//span[text()='Category Name'])[2]")
	private WebElement btn_Sort_CategoryName;

	@FindBy(xpath = "(//span[text()='Category Name'])[2]/following::div[2]/div/input")
	private WebElement input_CategoryNameGrid;

	@FindBy(xpath = "//span[contains(text(),'Class Name')]")
	private WebElement btn_Sort_ClassName;

	@FindBy(xpath = "//span[contains(text(),'Class Name')]/following::div[2]/div/input")
	private WebElement input_ClassName;

	@FindBy(xpath = "(//span[text()='Actions'])[2]//following::div[15]/a[1]")
	private WebElement btn_View_Grid;

	@FindBy(xpath = "(//span[text()='Actions'])[2]//following::div[15]/a[2]")
	private WebElement btn_Edit_Grid;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_View_ClosePopUp;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_Category;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_MasterCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	private WebElement btn_Min_Max_MasterCategoryGridView;

	@FindBy(xpath = "//div[@class='modal-body']/table/tbody/tr[1]/td[4]/div/a")
	private WebElement icon_DeactivateAndActivate;

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement btnPopUp_YesDeactivateOrActivateit;

	@FindBy(xpath = "//button[@class='cancel' and text()='Cancel']")
	private WebElement btnPopUp_Cancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	private WebElement btn_Min_Max_CategoryClassMapping;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	private WebElement btn_Min_Max_CategoryClassDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[6]")
	private WebElement btn_Min_Max_CategoryClassGridView;
	
	@FindBy(xpath = "(//*[@id='style-4']/div[2]/div[1]/div[2]/select)[2]")
	private WebElement noOfItemPerPage;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Exam_MasterCategoryAndCategoryClassMapping(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Exam Master Category
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterCategory() throws Exception {

		
			clickOnButton(btn_Exam);
			log("Clicked on Exam Button and object is:-" + btn_Exam.toString());
	
			clickOnButton(btn_Exam_Masters);
			log("Clicked on Exam Masters Button and object is:-" + btn_Exam_Masters.toString());
	
			clickOnButton(btn_ExamMasterCategory);
			log("Clicked on Exam Master Category Button and object is:-" + btn_ExamMasterCategory.toString());
		
	}

	/**
	 * Validation of Exam Master Category screen message
	 * 
	 * @return
	 */
	public boolean verifyExamMasterCategoryPage() {
		try {
			System.out.println(txt_ExamMasterCategory.getText());
			txt_ExamMasterCategory.isDisplayed();
			log("Exam Master Category  page is dispalyed and object is:-" + txt_ExamMasterCategory.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fill Exam Master Category Form
	 * 
	 * @param categoryName
	 * 
	 * @throws Exception
	 */
	public void fill_Exam_MasterCategory_Form(String categoryName) throws Exception {

			inputTextIntoInputField(input_CategoryName, categoryName);
			log("Entered Master Category Name:- and object is: " + input_CategoryName.toString());
			
	}

	public void clickOnSaveButton_ToSubmitMasterCategory() throws Exception {
		
			clickOnButton(btn_Save_MasterCategory);
			log("Clicked on Save button to Submit Master Category Form and object is:- "
					+ btn_Save_MasterCategory.toString());
			
	}

	public void clickOnCancelButton_ToClearMasterCategoryFilledData() throws Exception {
		
			clickOnButton(btn_Cancel_MasterCategory);
			log("Clicked on Cancel button to Clear Master Category Form filled data and object is:- "
					+ btn_Cancel_MasterCategory.toString());
			
	}

	public void sortByCategoryName_MasterCategory() throws Exception {
		
			clickOnButton(sort_CategoryName_MasterCategory);
			clickOnButton(sort_CategoryName_MasterCategory);
			log("Record sorted by Master Category Name and object is:- " + sort_CategoryName_MasterCategory.toString());
			
	}

	public void filterRecordWithCategoryName(String categoryName) throws Exception {
	
			inputTextIntoInputField(input_Filter_CategoryName_MasterCategory, categoryName);
			log("Entered Master Category Name:-" + categoryName + " to filter records and object is: "
					+ input_Filter_CategoryName_MasterCategory.toString());
			
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

	/**
	 * Edit Master Category created for updation of Category Name
	 * 
	 * @throws Exception
	 */
	public void editMasterCategory() throws Exception {
	
			isDisplayed(icon_Edit_MasterCategory);
			String editText = icon_Edit_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + editText);

			// Compare toll tip text
			Assert.assertEquals(editText, "Edit");

			clickOnButton(icon_Edit_MasterCategory);
			log("Clicked on Edit Icon to Edit Master Category record and object is:-"
					+ icon_Edit_MasterCategory.toString());
			
	}

	public void deactivateRecords_MasterCategoryGrid() throws Exception {

			isDisplayed(icon_Deactivate_MasterCategory);
			String DeactivateText = icon_Deactivate_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			clickOnButton(icon_Deactivate_MasterCategory);
			log("Clicked on Deacivate Icon to Deactivate Master Category record and object is:-"
					+ icon_Deactivate_MasterCategory.toString());
			
	}

	public void activateRecords_MasterCategoryGrid() throws Exception {

			isDisplayed(icon_Activate_MasterCategory);
			String ActivateText = icon_Activate_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");
			clickOnButton(icon_Activate_MasterCategory);
			log("Clicked on Acivate Icon to Activate Master Category record and object is:-"
					+ icon_Activate_MasterCategory.toString());
		
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

	// CATEGORY CLASS MAPPING

	public void navigateToCategoryClassMapping() throws Exception {

			clickOnButton(tab_CategoryClassMapping);
			log("Page Swich from Master Category to Category Class mapping and object is:-"
					+ tab_CategoryClassMapping.toString());
			
	}

	public void fill_CategoryClassMapping_Form(String academicYear, String Category, String class_ccm)
			throws Exception {
	
			selectElementFromDropDown(sel_AcademicYear, academicYear);
			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		
			selectElementFromDropDown(sel_Category, Category);
			log("Selected Category: " + Category + " and object is:- " + sel_Category.toString());

			selectElementFromDropDown(sel_Class, class_ccm);
			log("Selected Class: " + class_ccm + " and object is:- " + sel_Class.toString());
			
			isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section Check box is checked and object is:-" + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box is already checked.");
			Thread.sleep(500);
		}
	}

	/**
	 * Submit blank Category Class Mapping form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_CategoryClassMappingForm() throws Exception {
	
			clickOnButton(btn_Add);
			log("Submit blank Category Class Mapping form and object is:-" + btn_Add.toString());
			
	}

	/**
	 * Add Exam Category Class mapping form to get data updated in the details
	 * section
	 * 
	 * @throws Exception
	 */
	public void clickOnAddToSubmit_CategoryClassMappingForm() throws Exception {
	
			clickOnButton(btn_Add);
			log("Submit Category Class mapping form to add data in details section and object is:-"
					+ btn_Add.toString());
		
	}

	/**
	 * Second Category Class Mapping
	 * 
	 * @throws Exception
	 * 
	 */
	public void selectClassAndSection_ForSecondCategoryClassMapping(String academicYear, String Category,
			String class_ccm) throws Exception {
	
			selectElementFromDropDown(sel_Class, class_ccm);
			log("Selected Class: " + class_ccm + " and object is:- " + sel_Class.toString());
			
			isDisplayed(chk_Section);
		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section Check box is checked and object is:-" + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box is already checked.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveToSubmit_CategoryClassMappingForm() throws Exception {
		
			clickOnButton(btn_Save_CategoryClassMapping);
			log("Save Category Class Mapping form and object is:-" + btn_Save_CategoryClassMapping.toString());
			
	}

	public void clickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection() throws Exception {
		
			clickOnButton(btn_Cancel_CategoryClassMapping);
			log("Clear Category Class Mapping form and details section data and object is:-"
					+ btn_Cancel_CategoryClassMapping.toString());
			
	}

	public void clickOnClearButton_ToClearFilledForm() throws Exception {
		
			clickOnButton(btn_Clear);
			log("Clear all the selected item to fill Category Class mapping form and object is:-"
					+ btn_Clear.toString());
			
	}

	public void min_Max_CategoryDashBoard() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamMasterCategory);
		Thread.sleep(1000);
		
			clickOnButton(btn_Min_Max_Category);
			log("Exam Master Category Or Category Class Mapping dashboard page minimized or maximized and object is:-"
					+ btn_Min_Max_Category.toString());
			
	}

	public void min_Max_MasterCategoryForm() throws Exception {
	
			clickOnButton(btn_Min_Max_MasterCategory);
			log("Master Category page minimized or maximized and object is:-" + btn_Min_Max_MasterCategory.toString());
			
	}

	public void min_Max_MasterCategory_GridView() throws Exception {
		
			clickOnButton(btn_Min_Max_MasterCategoryGridView);
			log("Master Category Grid View page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterCategoryGridView.toString());
			
	}

	public void editRecordsAndUpdateSection_InDetailsSection() throws Exception {

			clickOnButton(icon_Edit_Details);
			log("Edit icon is clicked and object is:- " + icon_Edit_Details.toString());
		isDisplayed(chk_Section);
		if (chk_Section.isSelected()) {
			chk_Section.click();
			log("Already selected for edit and object is:- " + chk_Section_edit.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-subject is already selected for class teacher.");
			Thread.sleep(500);
		}
		isDisplayed(chk_Section_edit);
		if (!chk_Section_edit.isSelected()) {
			chk_Section_edit.click();
			log("Change of section is selected for edit and object is:- " + chk_Section_edit.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-subject is already selected for class teacher.");
			Thread.sleep(500);
		}
	}

	public void deleteRecordsFromDetailsSelection() throws Exception {

			clickOnButton(icon_Delete_Details);
			log("Record deleted from details section and object is:- " + icon_Delete_Details.toString());
			
	}

	public void sortWithAcademicYearInGridView() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noOfItemPerPage);
		Thread.sleep(1000);
			clickOnButton(btn_Sort_AcademicYear);
			clickOnButton(btn_Sort_AcademicYear);
			log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());
			
	}

	public void sortWithCategoryNameInGridView() throws Exception {

			clickOnButton(btn_Sort_CategoryName);
			log("Sort by Category Name in Category Class Mapping details grid and object is:- " + btn_Sort_CategoryName.toString());
			
	}

	public void sortWithClassNameInGridView() throws Exception {

			clickOnButton(btn_Sort_ClassName);
			log("Sort by Class Name in grid view and object is:- " + btn_Sort_ClassName.toString());
			
	}
	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String className) throws Exception {
		
			inputTextIntoInputField(input_AcademicYear, academicYear);
			log("Entered academic year " + academicYear + " to filter records and object is:- "
					+ input_AcademicYear.toString());
			
	}

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String className) throws Exception {
		
			inputTextIntoInputField(input_CategoryNameGrid, categoryName);
			log("Entered Category Name " + categoryName + " to filter records and object is:- "
					+ input_CategoryNameGrid.toString());
		
	}

	public void filterRecordsBasedOn_ClassName(String academicYear, String categoryName, String className) throws Exception {
		
			inputTextIntoInputField(input_ClassName, className);
			log("Entered Class Name " + className + " to filter records and object is:- " + input_ClassName.toString());
			
	}
	public void clearFilledDataForFilter() throws Exception {
		isDisplayed(input_AcademicYear);
		input_AcademicYear.clear();
		isDisplayed(input_CategoryNameGrid);
		input_CategoryNameGrid.clear();
		isDisplayed(input_ClassName);
		input_ClassName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation() throws Exception {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Edit_Grid);
//		Thread.sleep(1000);
		
			clickOnButton(btn_View_Grid);
			log("Clicked on View Icon to launch pop up windows to see created Category Class Mapping and object is:-"
					+ btn_View_Grid.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			
	}

	public void clickOnEditIcon_ToUpdateCategoryClassMapping() throws Exception {
		
	
			clickOnButton(btn_Edit_Grid);
			log("Clicked on Edit Icon to update Category Class Mapping and object is:-" + btn_Edit_Grid.toString());
			
	}

	public void deactivateRecords_ViewWindow() throws Exception {

			isDisplayed(icon_DeactivateAndActivate);
			String DeactivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			clickOnButton(icon_DeactivateAndActivate);
			log("Clicked on Deacivate Icon to Deactivate Category Class Mapping view popup window and object is:-"
					+ icon_DeactivateAndActivate.toString());
			
	}

	public void activateRecords_ViewWindow() throws Exception {

			isDisplayed(icon_DeactivateAndActivate);
			String ActivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			clickOnButton(icon_DeactivateAndActivate);
			log("Clicked on Acivate Icon to Activate Category Class Mapping view popup window record and object is:-"
					+ icon_DeactivateAndActivate.toString());
			
	}

	public void closeViewWindow_CategoryClassMapping() throws Exception{
		
			clickOnButton(btn_View_ClosePopUp);
			log("View window close button is clicked and object is:- "+btn_View_ClosePopUp.toString());
			
	}
	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record saved Successfully");
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
			assertEquals(text, "Record updated Successfully");
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
			assertEquals(text, "Record De-activated Successfully");
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
			assertEquals(text, "Record Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
