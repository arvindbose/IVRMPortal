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
 * @author vaps
 *
 */
public class Exam_MasterCategoryAndCategoryClassMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_MasterCategoryAndCategoryClassMapping.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]")
	private WebElement btn_Exam_Masters;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Master')][1]/following::li[3]")
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

	@FindBy(xpath = "//span[text()='Actions']//following::div[11]/a")
	private WebElement icon_Edit_MasterCategory;

	@FindBy(xpath = "//span[text()='Actions']//following::div[11]/span/a")
	private WebElement icon_DeactivateOrActivate_MasterCategory;

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
	

	public Exam_MasterCategoryAndCategoryClassMapping(WebDriver driver) {
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
	 * Navigate to Exam > Masters > Exam Master Category
	 * 
	 * @throws Exception
	 */
	public void navigateToExamMasters_ExamMasterCategory() throws Exception {

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
		if (btn_ExamMasterCategory.isDisplayed()) {
			btn_ExamMasterCategory.click();
			log("Clicked on Exam Master Category Button and object is:-" + btn_ExamMasterCategory.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Exam Master Category Navigation element not present.");
			Thread.sleep(500);
		}
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

		if (input_CategoryName.isDisplayed()) {
			input_CategoryName.clear();
			input_CategoryName.sendKeys(categoryName);
			log("Entered Master Category Name:- and object is: " + input_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_ToSubmitMasterCategory() throws Exception {
		if (btn_Save_MasterCategory.isDisplayed()) {
			btn_Save_MasterCategory.click();
			log("Clicked on Save button to Submit Master Category Form and object is:- "
					+ btn_Save_MasterCategory.toString());
			Thread.sleep(3000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearMasterCategoryFilledData() throws Exception {
		if (btn_Cancel_MasterCategory.isDisplayed()) {
			btn_Cancel_MasterCategory.click();
			log("Clicked on Cancel button to Clear Master Category Form filled data and object is:- "
					+ btn_Cancel_MasterCategory.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button for Master Category form element is not present.");
			Thread.sleep(500);
		}
	}

	public void sortByCategoryName_MasterCategory() throws Exception {
		if (sort_CategoryName_MasterCategory.isDisplayed()) {
			sort_CategoryName_MasterCategory.click();
			sort_CategoryName_MasterCategory.click();
			log("Record sorted by Master Category Name and object is:- " + sort_CategoryName_MasterCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name Sorting button element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordWithCategoryName(String categoryName) throws Exception {
		if (input_Filter_CategoryName_MasterCategory.isDisplayed()) {
			input_Filter_CategoryName_MasterCategory.clear();
			input_Filter_CategoryName_MasterCategory.sendKeys(categoryName);
			log("Entered Master Category Name:-" + categoryName + " to filter records and object is: "
					+ input_Filter_CategoryName_MasterCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name field element is not present.");
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

	/**
	 * Edit Master Category created for updation of Category Name
	 * 
	 * @throws Exception
	 */
	public void editMasterCategory() throws Exception {
		if (icon_Edit_MasterCategory.isDisplayed()) {

			String editText = icon_Edit_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + editText);

			// Compare toll tip text
			Assert.assertEquals(editText, "Edit");

			icon_Edit_MasterCategory.click();
			log("Clicked on Edit Icon to Edit Master Category record and object is:-"
					+ icon_Edit_MasterCategory.toString());
			Thread.sleep(2000);
		} else {
			log("Edit Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void deactivateRecords_MasterCategoryGrid() throws Exception {

		if (icon_DeactivateOrActivate_MasterCategory.isDisplayed()) {

			String DeactivateText = icon_DeactivateOrActivate_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_DeactivateOrActivate_MasterCategory.click();
			log("Clicked on Deacivate Icon to Deactivate Master Category record and object is:-"
					+ icon_DeactivateOrActivate_MasterCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon Master Category element is not present.");
			Thread.sleep(500);
		}
	}

	public void activateRecords_MasterCategoryGrid() throws Exception {

		if (icon_DeactivateOrActivate_MasterCategory.isDisplayed()) {

			String ActivateText = icon_DeactivateOrActivate_MasterCategory.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_DeactivateOrActivate_MasterCategory.click();
			log("Clicked on Acivate Icon to Activate Master Category record and object is:-"
					+ icon_DeactivateOrActivate_MasterCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon Master Category Grid element is not present.");
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

	// CATEGORY CLASS MAPPING

	public void navigateToCategoryClassMapping() throws Exception {

		if (tab_CategoryClassMapping.isDisplayed()) {
			tab_CategoryClassMapping.click();
			log("Page Swich from Master Category to Category Class mapping and object is:-"
					+ tab_CategoryClassMapping.toString());
			Thread.sleep(2000);
		} else {
			log("Category Class Mapping tab is not present.");
			Thread.sleep(500);
		}
	}

	public void fill_CategoryClassMapping_Form(String academicYear, String Category, String class_ccm)
			throws Exception {
		if (sel_AcademicYear.isDisplayed()) {

			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Category.isDisplayed()) {

			select = new Select(sel_Category);
			select.selectByVisibleText(Category);

			log("Selected Category: " + Category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Category);
			Thread.sleep(1000);
		} else {
			log("User Name element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {

			select = new Select(sel_Class);
			select.selectByVisibleText(class_ccm);

			log("Selected Class: " + class_ccm + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_ccm);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
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
		if (btn_Add.isDisplayed()) {
			btn_Add.click();
			log("Submit blank Category Class Mapping form and object is:-" + btn_Add.toString());
			Thread.sleep(5000);
		} else {
			log("Add button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Add Exam Category Class mapping form to get data updated in the details
	 * section
	 * 
	 * @throws Exception
	 */
	public void clickOnAddToSubmit_CategoryClassMappingForm() throws Exception {
		if (btn_Add.isDisplayed()) {
			btn_Add.click();
			log("Submit Category Class mapping form to add data in details section and object is:-"
					+ btn_Add.toString());
			Thread.sleep(3000);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// btn_Min_MaxLoginPrivilegeDetails);
			
		} else {
			log("Add button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Second Category Class Mapping
	 * 
	 * @throws Exception
	 * 
	 */
	public void selectClassAndSection_ForSecondCategoryClassMapping(String academicYear, String Category,
			String class_ccm) throws Exception {
		if (sel_Class.isDisplayed()) {

			select = new Select(sel_Class);
			select.selectByVisibleText(class_ccm);

			log("Selected Class: " + class_ccm + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_ccm);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
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
		if (btn_Save_CategoryClassMapping.isDisplayed()) {
			btn_Save_CategoryClassMapping.click();
			log("Save Category Class Mapping form and object is:-" + btn_Save_CategoryClassMapping.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection() throws Exception {
		if (btn_Cancel_CategoryClassMapping.isDisplayed()) {
			btn_Cancel_CategoryClassMapping.click();
			log("Clear Category Class Mapping form and details section data and object is:-"
					+ btn_Cancel_CategoryClassMapping.toString());
			Thread.sleep(5000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnClearButton_ToClearFilledForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Clear all the selected item to fill Category Class mapping form and object is:-"
					+ btn_Clear.toString());
			Thread.sleep(1000);
		} else {
			log("Clear button element is not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_CategoryDashBoard() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ExamMasterCategory);
		Thread.sleep(1000);
		if (btn_Min_Max_Category.isDisplayed()) {
			btn_Min_Max_Category.click();
			log("Exam Master Category Or Category Class Mapping dashboard page minimized or maximized and object is:-"
					+ btn_Min_Max_Category.toString());
			Thread.sleep(1000);
		} else {
			log("Category DashBoard Minimized OR Maximize Element not present.");
		}
	}

	public void min_Max_MasterCategoryForm() throws Exception {
		if (btn_Min_Max_MasterCategory.isDisplayed()) {
			btn_Min_Max_MasterCategory.click();
			log("Master Category page minimized or maximized and object is:-" + btn_Min_Max_MasterCategory.toString());
			Thread.sleep(1000);
		} else {
			log("Master Category Minimize OR Maximize Element not present.");
		}
	}

	public void min_Max_MasterCategory_GridView() throws Exception {
		if (btn_Min_Max_MasterCategoryGridView.isDisplayed()) {
			btn_Min_Max_MasterCategoryGridView.click();
			log("Master Category Grid View page minimized or maximized and object is:-"
					+ btn_Min_Max_MasterCategoryGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Master Category Grid View Minimize OR Maximize Element not present.");
		}
	}

	public void editRecordsAndUpdateSection_InDetailsSection() throws Exception {

		if (icon_Edit_Details.isDisplayed()) {
			icon_Edit_Details.click();
			log("Edit icon is clicked and object is:- " + icon_Edit_Details.toString());
			Thread.sleep(2000);
		} else {
			log("Edit icon element is not present in details section.");
			Thread.sleep(500);
		}
		if (chk_Section.isSelected()) {
			chk_Section.click();
			log("Already selected for edit and object is:- " + chk_Section_edit.toString());
			Thread.sleep(1000);
		} else {
			log("Sub-subject is already selected for class teacher.");
			Thread.sleep(500);
		}
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

		if (icon_Delete_Details.isDisplayed()) {
			icon_Delete_Details.click();
			log("Record deleted from details section and object is:- " + icon_Delete_Details.toString());
			Thread.sleep(1000);
		} else {
			log("Delete icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithAcademicYearInGridView() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noOfItemPerPage);
		Thread.sleep(1000);
		
		
		if (btn_Sort_AcademicYear.isDisplayed()) {
			btn_Sort_AcademicYear.click();
			Thread.sleep(500);
			btn_Sort_AcademicYear.click();
			log("Sort by academic year in grid view and object is:- " + btn_Sort_AcademicYear.toString());
			Thread.sleep(1000);
		} else {
			log("Academic Year button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithCategoryNameInGridView() throws Exception {

		if (btn_Sort_CategoryName.isDisplayed()) {
			btn_Sort_CategoryName.click();
			log("Sort by Category Name in Category Class Mapping details grid and object is:- " + btn_Sort_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name button element not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void sortWithClassNameInGridView() throws Exception {

		if (btn_Sort_ClassName.isDisplayed()) {
			btn_Sort_ClassName.click();
			log("Sort by Class Name in grid view and object is:- " + btn_Sort_ClassName.toString());
			Thread.sleep(1000);
		} else {
			log("Class Name button element not present.");
			Thread.sleep(500);
		}
	}
	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String className) throws Exception {
		if (input_AcademicYear.isDisplayed()) {
			input_AcademicYear.clear();
			input_AcademicYear.sendKeys(academicYear);
			log("Entered academic year " + academicYear + " to filter records and object is:- "
					+ input_AcademicYear.toString());
			Thread.sleep(1000);
		} else {
			log("Academic year input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String className) throws Exception {
		if (input_CategoryNameGrid.isDisplayed()) {
			input_CategoryNameGrid.clear();
			input_CategoryNameGrid.sendKeys(categoryName);
			log("Entered Category Name " + categoryName + " to filter records and object is:- "
					+ input_CategoryNameGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name input field element not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_ClassName(String academicYear, String categoryName, String className) throws Exception {
		if (input_ClassName.isDisplayed()) {
			input_ClassName.clear();
			input_ClassName.sendKeys(className);
			log("Entered Class Name " + className + " to filter records and object is:- " + input_ClassName.toString());
			Thread.sleep(1000);
		} else {
			log("Class Name input field element not present in output grid.");
			Thread.sleep(500);
		}
	}
	public void clearFilledDataForFilter() throws Exception {
		input_AcademicYear.clear();
		input_CategoryNameGrid.clear();
		input_ClassName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation() throws Exception {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Edit_Grid);
//		Thread.sleep(1000);
		if (btn_View_Grid.isDisplayed()) {
			btn_View_Grid.click();
			log("Clicked on View Icon to launch pop up windows to see created Category Class Mapping and object is:-"
					+ btn_View_Grid.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			Thread.sleep(1000);
		} else {
			log("View Icon element is not present in grid.");
			Thread.sleep(500);
		}
	}

	public void clickOnEditIcon_ToUpdateCategoryClassMapping() throws Exception {
		
		if (btn_Edit_Grid.isDisplayed()) {
			btn_Edit_Grid.click();
			log("Clicked on Edit Icon to update Category Class Mapping and object is:-" + btn_Edit_Grid.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present in output grid.");
			Thread.sleep(500);
		}
	}

	public void deactivateRecords_ViewWindow() throws Exception {

		if (icon_DeactivateAndActivate.isDisplayed()) {

			String DeactivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			icon_DeactivateAndActivate.click();
			log("Clicked on Deacivate Icon to Deactivate Category Class Mapping view popup window and object is:-"
					+ icon_DeactivateAndActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon element is not present in view popup window.");
			Thread.sleep(500);
		}
	}

	public void activateRecords_ViewWindow() throws Exception {

		if (icon_DeactivateAndActivate.isDisplayed()) {

			String ActivateText = icon_DeactivateAndActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + ActivateText);

			// Compare toll tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			icon_DeactivateAndActivate.click();
			log("Clicked on Acivate Icon to Activate Category Class Mapping view popup window record and object is:-"
					+ icon_DeactivateAndActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon element is not present in view popup window.");
			Thread.sleep(500);
		}
	}

	public void closeViewWindow_CategoryClassMapping() throws Exception{
		
		if(btn_View_ClosePopUp.isDisplayed()){
			btn_View_ClosePopUp.click();
			log("View window close button is clicked and object is:- "+btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
		}else{
			log("View button element is not present.");
			Thread.sleep(500);
		}
	}
}
