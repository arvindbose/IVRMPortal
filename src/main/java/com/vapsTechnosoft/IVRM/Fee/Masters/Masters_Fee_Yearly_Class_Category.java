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

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[7]")
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
			Thread.sleep(7000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void nevigateToMasters_Fee_Yearly_ClassCategory() throws Exception {
		if (btnFee.isDisplayed()) {
			btnFee.click();
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
			Thread.sleep(1000);
			// waitForElement(driver, 10, btnFee);
		} else {
			log("Fee Button element not present");
			Thread.sleep(500);
		}
		if (feeMasters.isDisplayed()) {
			feeMasters.click();
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee Masters Button element not present");
			Thread.sleep(500);
		}
		if (btnFeeClassCategory.isDisplayed()) {
			btnFeeClassCategory.click();
			log("Clicked on Fee class category Button and object is:-" + btnFeeClassCategory.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee class category Button element not present");
			Thread.sleep(500);
		}
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
		waitForElement(driver, 10, tabYearlyClassCategory);
		tabYearlyClassCategory.click();
		log("Selected yearly class category and object is:-" + tabYearlyClassCategory.toString());
		waitForElement(driver, 10, labelSelClass);
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
		if (selAcademicYr.isDisplayed()) {
			select = new Select(selAcademicYr);
			select.selectByVisibleText(academicYr);
			log("selected academic year from the list:-" + academicYr + " and object is " + selAcademicYr.toString());
			Thread.sleep(1000);
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(1000);
		} else {
			log("Academic year element not present");
			Thread.sleep(500);
		}
		if (selClassCategory.isDisplayed()) {
			select = new Select(selClassCategory);
			select.selectByVisibleText(classCategory);
			log("selected fees class category from the list:-" + classCategory + " and object is "
					+ selClassCategory.toString());

			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classCategory);
			Thread.sleep(1000);
		} else {
			log("fees class category element not present");
			Thread.sleep(500);
		}

		selClassButton.click();
		Thread.sleep(1000);
		selClass.click();
		btnAfterClassSelection.click();
		Thread.sleep(1000);
		String selectedClass = selClassButton.getText();
		try {
			Assert.assertEquals(selectedClass, className);
		} catch (Exception e) {
			log("Selected class not matched with the class provided.");
		}
		log("Class selected:" + selClassButton.getText() + " and object is:-" + selClassButton.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(7000);
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
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}

	public void searchByClassCategoryInGrid(String classCategory) throws Exception {
		if (inputSearch.isDisplayed()) {
		inputSearch.clear();
		inputSearch.sendKeys(classCategory);
		log("Entered Class category name:" + classCategory + "and object is:-" + inputSearch.toString());
		Thread.sleep(1000);
		} else {
			log("Class category element not present");
			Thread.sleep(500);
		}
	}

	public void verifyClassCategoryUpdatedInGrid(String classCategory) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(classCategoryName, classCategory);

				log("Class category name is update in the grid:" + classCategory);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete_Yearly_ClassCategoryFromGrid(String classCategory) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(classCategoryName, classCategory);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[8]/a"))
						.click();
				log("Clicked on delete link for corresponding Yearly class category in grid");

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void confirmationForDeletion() throws Exception {
		btnPopUpYesDeleteit.click();
		log("Clicked on confirmation Yes Delete it button and object is:" + btnPopUpYesDeleteit.toString());
		Thread.sleep(2000);
	}

	public boolean verifyDeletionSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record Deleted Successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnDeletionFinalOkBtn() throws Exception {

		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(5000);
	}
}
