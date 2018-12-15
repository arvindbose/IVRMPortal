/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
public class Masters_Fee_Yearly_Class_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Yearly_Class_Category.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

//	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[7]")
//	WebElement btnFeeClassCategory;

	@FindBy(xpath = "//a[@href='#/app/FeeClassCategory/83']")
	WebElement btnFeeClassCategory;
	
	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeClassCategoryMsgDispaly;

	@FindBy(xpath = "//body[@id='style-4']//md-tab-item[2]")
	WebElement tabYearlyClassCategory;

	@FindBy(xpath = "(//div[@class='form-group']/label)[6]")
	WebElement labelSelClass;

	@FindBy(xpath = "//select[@name='yer']")
	WebElement selAcademicYr;

	@FindBy(xpath = "(//div[@class='col-sm-8'])[3]")
	WebElement afterAcademicSelection;

	@FindBy(xpath = "//select[@name='clscate']")
	WebElement selClassCategory;

	@FindBy(xpath = "//input[@ng-model='searchchkbx']")
	WebElement search_Class;	
	
	@FindBy(xpath = "(//input[@name='clsse'])[1]")
	WebElement chk_Class;	

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[2]")
	WebElement btnSave;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//input[@ng-model='search1']")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeleteit;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement btnPopUpCancel;
	
	@FindBy(xpath = "(//table/thead)[2]/tr/th[3]/a")
	WebElement sort_YrlyClassCategory;
	
	@FindBy(xpath = "(//table/tbody)[2]/tr/td[3]")
	List<WebElement> list_ClassCategory;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxYearlyClassCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_MaxYearlyClassCategoryGridView;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;
	
	

	public Masters_Fee_Yearly_Class_Category(WebDriver driver) {
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

	public void nevigateToMasters_Fee_Yearly_ClassCategory() throws Exception {
		
			clickOnButton(btnFee);
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
		
			clickOnButton(feeMasters);
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		
			clickOnButton(btnFeeClassCategory);
			log("Clicked on Fee class category Button and object is:-" + btnFeeClassCategory.toString());
			
	}

	public boolean verifyFeeClassCategoryPage() {
		try {
			System.out.println(txtFeeClassCategoryMsgDispaly.getText());
			txtFeeClassCategoryMsgDispaly.isDisplayed();
			log("Fee class category page is dispalyed and object is:-" + txtFeeClassCategoryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnYearly_ClassCategoryTab() throws Exception {
	
		clickOnButton(tabYearlyClassCategory);
		log("Selected yearly class category and object is:-" + tabYearlyClassCategory.toString());
		
	}

	/**
	 * Select academic year, class category and class
	 * 
	 * @param academicYr
	 * @param classCategory
	 * @param className
	 * @throws Exception
	 */
	public void selectAcademicYearClassCategoryAndClass(String academicYr, String classCategory, String className)
			throws Exception {

			selectElementFromDropDown(selAcademicYr, academicYr);
			log("selected academic year from the list:-" + academicYr + " and object is " + selAcademicYr.toString());
		
			selectElementFromDropDown(selClassCategory, classCategory);
			log("selected fees class category from the list:-" + classCategory + " and object is "
					+ selClassCategory.toString());

		inputTextIntoInputField(search_Class, className);
		log("Class for search to select check box:" + className + " and object is:-" + search_Class.toString());
		Thread.sleep(1000);
		isDisplayed(chk_Class);
		if(!chk_Class.isSelected()){
			chk_Class.click();
			log("Check box is checked and object is: "+chk_Class.toString());
		}
		else{
			log("Check box is already checked and object is: "+chk_Class.toString());
		}
	}

	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {
		
		clickOnButton(btnSave);
		log("clicked on save button to submit blank form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnSaveButton() throws Exception {
	
		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnCancelButton_ToClearFilledData() throws Exception {
		
		clickOnButton(btnCancel);
		log("clicked on Cancel button to clear filled data and object is:-" + btnCancel.toString());
		Thread.sleep(1000);
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);
	}

	public void searchByClassCategoryInGrid(String classCategory) throws Exception {

		inputTextIntoInputField(inputSearch, classCategory);
		log("Entered Class category name:" + classCategory + "and object is:-" + inputSearch.toString());
		Thread.sleep(1000);
		
	}

	public void verifyClassCategoryUpdatedInGrid(String classCategory) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(2000);
				if(classCategoryName.equals(classCategory)){
				Assert.assertEquals(classCategoryName, classCategory);

				log("Class category name is update in the grid:" + classCategory);
				Thread.sleep(2000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete_Yearly_ClassCategoryFromGrid(String classCategory) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(2000);
		
				if(classCategoryName.equals(classCategory)){
				Assert.assertEquals(classCategoryName, classCategory);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[8]/a"))
						.click();
				log("Clicked on delete link for corresponding Yearly class category in grid");
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmationForDeletion() throws Exception {
	
		clickOnButton(btnPopUpYesDeleteit);
		log("Clicked on confirmation Yes Delete it button and object is:" + btnPopUpYesDeleteit.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnCancelButton_PopUp() throws Exception {
		
		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button for delete and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(3000);
	
}

	public boolean verifyDeletionSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record Deleted Successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnDeletionFinalOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);
	}
	
	public void sortByClassCategory_Yrly() throws Exception {

		clickOnButton(sort_YrlyClassCategory);
		SortData_InColumn_AscendingOrder(list_ClassCategory);
		log("Sorted the record with Class Category name in Ascending order and object is:-" + sort_YrlyClassCategory.toString());
		
}
	
	public void minimizeAndMaximize_YearlyClassCategory() throws Exception {
		
		clickOnButton(btnMin_MaxYearlyClassCategory);
		log("clicked on Fee Head minimize and maximize button and object is:-" + btnMin_MaxYearlyClassCategory.toString());
		Thread.sleep(1000);
	
}

public void minimizeAndMaximize_YearlyClassCategoryGridView() throws Exception {

		clickOnButton(btnMin_MaxYearlyClassCategoryGridView);
		log("Fee Master Term grid table data minimize and maximize and object is:-"
				+ btnMin_MaxYearlyClassCategoryGridView.toString());
		Thread.sleep(1000);
	
}
public void popWindowMessage_SubmitSuccessfully() throws Exception {
	try {
		validate_PopUpText.isDisplayed();
		String text = validate_PopUpText.getText().trim();
		assertEquals(text, "Record Saved Successfully");
		log("Record submitted sucessfully message validated.");
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void popUpWindowMessage_DeleteCancel_Validation() throws Exception {
	try {
		validate_PopUpText.isDisplayed();
		String text = validate_PopUpText.getText().trim();
		assertEquals(text, "Record Deletion Cancelled");
		log("Record Deletion Cancelled message validated.");
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void popUpWindowMessage_DeleteSucessfully_Validation() throws Exception {
	try {
		validate_PopUpText.isDisplayed();
		String text = validate_PopUpText.getText().trim();
		assertEquals(text, "Record Deleted Successfully");
		log("Record Deleted sucessfully message validated.");
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
