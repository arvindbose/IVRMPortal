/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.ExamMapping;

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
public class Exam_CategorySubjectMapping extends TestBase {

	public static final Logger log = Logger.getLogger(Exam_CategorySubjectMapping.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button")
	private WebElement btn_Exam;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]")
	private WebElement btn_ExamMapping;

	@FindBy(xpath = "//span[contains(text(),'Exam')]/preceding-sibling::button/following::span[contains(text(),'Exam Mapping')][1]/following::li[5]")
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

	public Exam_CategorySubjectMapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(7000);
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

		if (btn_Exam.isDisplayed()) {
			btn_Exam.click();
			log("Clicked on Exam Button and object is:-" + btn_Exam.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Exam Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_ExamMapping.isDisplayed()) {
			btn_ExamMapping.click();
			log("Clicked on Exam Mapping Button and object is:-" + btn_ExamMapping.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Exam Mapping Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_CategorySubjectMapping.isDisplayed()) {
			btn_CategorySubjectMapping.click();
			log("Clicked on Exam Category Subject Mapping Button and object is:-"
					+ btn_CategorySubjectMapping.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Exam Category Subject Mapping Navigation element not present.");
			Thread.sleep(500);
		}
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
			select.selectByVisibleText(category);

			log("Selected Category: " + category + " and object is:- " + sel_Category.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), category);
			Thread.sleep(1000);
		} else {
			log("Category element is not present");
			Thread.sleep(500);
		}
		if (sel_SubjectGroup.isDisplayed()) {

			select = new Select(sel_SubjectGroup);
			select.selectByVisibleText(subjectGroup);

			log("Selected Subject Group: " + subjectGroup + " and object is:- " + sel_SubjectGroup.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), subjectGroup);
			Thread.sleep(1000);
		} else {
			log("Subject Group element is not present");
			Thread.sleep(500);
		}
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
	}

	/**
	 * Submit blank Category Subject Mapping form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_CategorySubjectMappingForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Category Subject Mapping form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Click on save button to save Category Subject Mapping data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitCategorySubjectMappingForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button to Submit the records for Category Subject Mapping and object is:-"
					+ btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save Element not present");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearFilledCategorySubjectMappingForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("clicked on Cancel button to clear filled data for Category Subject Mapping and object is:-"
					+ btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel Element not present");
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

	public void sortWithAcademicYearInGridView() throws Exception {

		if (btn_Sort_AcademicYear.isDisplayed()) {
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
			log("Sort by Category Name in grid view and object is:- " + btn_Sort_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortWithGroupNameInGridView() throws Exception {

		if (btn_Sort_GroupName.isDisplayed()) {
			btn_Sort_GroupName.click();
			log("Sort by Group Name in grid view and object is:- " + btn_Sort_GroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name button element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String groupName)
			throws Exception {
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

	public void filterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String groupName)
			throws Exception {
		if (input_CategoryName.isDisplayed()) {
			input_CategoryName.clear();
			input_CategoryName.sendKeys(categoryName);
			log("Entered Category Name " + categoryName + " to filter records and object is:- "
					+ input_CategoryName.toString());
			Thread.sleep(1000);
		} else {
			log("Category Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void filterRecordsBasedOn_GroupName(String academicYear, String categoryName, String groupName)
			throws Exception {
		if (input_GroupName.isDisplayed()) {
			input_GroupName.clear();
			input_GroupName.sendKeys(groupName);
			log("Entered Group Name " + groupName + " to filter records and object is:- " + input_GroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Group Name input field element not present.");
			Thread.sleep(500);
		}
	}

	public void clearFilledDataForFilter() throws Exception {
		input_AcademicYear.clear();
		input_CategoryName.clear();
		input_GroupName.clear();
		log("Cleared filter data in Grid View.");
		Thread.sleep(1000);
	}

	public void clickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode() throws Exception {

		if (btn_View.isDisplayed()) {
			btn_View.click();
			log("Clicked on View Icon to launch pop up windows to see subject and subject code and object is:-"
					+ btn_View.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertTrue(closeButton);
			Thread.sleep(1000);
		} else {
			log("View Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnEditIcon_ToUpdateCategorySubjectMapping() throws Exception {

		if (btn_Edit.isDisplayed()) {
			btn_Edit.click();
			log("Clicked on Edit Icon to update category subject mapping and object is:-" + btn_Edit.toString());
			Thread.sleep(1000);
		} else {
			log("Edit Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnDeActivationIcon_ToDeactivateCategorySubjectMapping() throws Exception {

		if (btn_DeactivateOrActivate.isDisplayed()) {

			String DeactivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present :- " + DeactivateText);

			// Compare toll tip text
			Assert.assertEquals(DeactivateText, "Deactivate Now");

			btn_DeactivateOrActivate.click();
			log("Clicked on Deacivate Icon to Deactivate Category subject mapping and object is:-"
					+ btn_DeactivateOrActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Deactivate Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnActivationIcon_ToActivateCategorySubjectMapping() throws Exception {

		if (btn_DeactivateOrActivate.isDisplayed()) {

			String ActivateText = btn_DeactivateOrActivate.getAttribute("aria-label");
			System.out.println("Tool tip text present(Activate) :- " + ActivateText);

			// Compare tool tip text
			Assert.assertEquals(ActivateText, "Activate Now");

			btn_DeactivateOrActivate.click();
			log("Clicked on Activate Icon to Activate Category subject mapping and object is:-"
					+ btn_DeactivateOrActivate.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Icon element is not present.");
			Thread.sleep(500);
		}
	}

	public void closeViewPopUpWindows() throws Exception {
		if (btn_View_ClosePopUp.isDisplayed()) {
			btn_View_ClosePopUp.click();
			log("View pop Up windows is closed and object is:-" + btn_View_ClosePopUp.toString());
			Thread.sleep(1000);
			boolean closeButton = btn_View_ClosePopUp.isDisplayed();
			Assert.assertFalse(closeButton);
			Thread.sleep(1000);
		} else {
			log("Close button element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Confirmation for deactivate and activate
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivateAndActivate() throws Exception {
		if (btnPopUpYesDeactivateOrActivateit.isDisplayed()) {
			btnPopUpYesDeactivateOrActivateit.click();
			log("Clicked Yes deactivate Or Activate it button and object is:"
					+ btnPopUpYesDeactivateOrActivateit.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Deactivate Or Activate Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Deactivate Or Activate cancel
	 * 
	 * @throws Exception
	 */

	public void cancel_DeactivateOrActivatePopUp() throws Exception {
		if (btn_PopUpCancel.isDisplayed()) {
			btn_PopUpCancel.click();
			log("Clicked on cancel button to cancel the Deactivate or Activate records and object is:-"
					+ btn_PopUpCancel.toString());
			Thread.sleep(1000);
		} else {
			log("Cancel button element is not present.");
			Thread.sleep(500);
		}
	}

	public void min_Max_CategorySubjectMapping() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_CategorySubjectMapping);
		Thread.sleep(1000);
		if (btnMin_MaxCategorySubjectMapping.isDisplayed()) {
			btnMin_MaxCategorySubjectMapping.click();
			log("Category Subject Mapping page minimized or maximized and object is:-"
					+ btnMin_MaxCategorySubjectMapping.toString());
			Thread.sleep(1000);
		} else {
			log("Category Subject Mapping Minimized Element not present.");
		}
	}

	public void min_Max_CategorySubjectMapping_GridView() throws Exception {
		if (btnMin_MaxCategorySubjectMappingGridView.isDisplayed()) {
			btnMin_MaxCategorySubjectMappingGridView.click();
			log("Category Subject Mapping Grid View page minimized or maximized and object is:-"
					+ btnMin_MaxCategorySubjectMappingGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Category Subject Mapping Grid View Minimized Element not present.");
		}
	}

}
