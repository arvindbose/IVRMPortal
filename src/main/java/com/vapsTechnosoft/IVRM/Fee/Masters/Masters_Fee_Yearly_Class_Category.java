/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

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

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[1]")
	WebElement selAcademicYr;

	@FindBy(xpath = "(//div[@class='col-sm-8'])[3]")
	WebElement afterAcademicSelection;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[2]")
	WebElement selClassCategory;

	@FindBy(xpath = "//div[@class='btn-group']/button")
	WebElement selClassButton;
	@FindBy(xpath = "//div[@class='btn-group open']/button")
	WebElement btnAfterClassSelection;
	// div[@class='btn-group']

	// use inside script and try with different class name
	@FindBy(xpath = "//span[contains(text(),'Test')]")
	WebElement selClass;
	// span[contains(text(),'Test')]

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[1]")
	WebElement txtClassCategoryName;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[2]")
	WebElement txtClassCategoryCode;

	@FindBy(xpath = "(//div[@class='text-center']/button)[4]")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[5]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "(//div[@class='input-group']/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeleteit;

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

		clickOnButton(selClassButton);
		clickOnButton(selClass);
		clickOnButton(btnAfterClassSelection);
	
		Thread.sleep(1000);
		String selectedClass = selClassButton.getText();
		try {
			Assert.assertEquals(selectedClass, className);
		} catch (Exception e) {
			e.printStackTrace();
			log("Selected class not matched with the class provided.");
		}
		log("Class selected:" + selClassButton.getText() + " and object is:-" + selClassButton.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {
	
		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
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
}
