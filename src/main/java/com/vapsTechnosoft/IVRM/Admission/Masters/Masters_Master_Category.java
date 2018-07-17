/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import java.awt.Robot;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Category.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[12]")
	WebElement btnMasters_masterCategory;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterCategoryMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_CategoryName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_AddressLine1;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement input_AddressLine2;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement input_AddressLine3;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
	WebElement input_AddressLine4;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[1]")
	WebElement sel_Institution;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[2]")
	WebElement sel_Type;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterCategoryList;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByCategoryName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	public Masters_Master_Category(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterCategory_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterCategory);

		btnMasters_masterCategory.click();
		log("Clicked on master category Button and object is:-" + btnMasters_masterCategory.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters master source screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterCategory_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterCategoryMsgDispaly.getText());
			txtMasters_MasterCategoryMsgDispaly.isDisplayed();
			log("Master category page is dispalyed and object is:-" + txtMasters_MasterCategoryMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankMasterCategoryForm() throws Exception {

		btnSave.click();
		log("Save blank master Category form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public void enterMasterCategoryFormData(String categoryName, String selectInstitution, String addressLine1,
			String addressLine2, String addressLine3, String addressLine4, String selectType) throws Exception {

		input_CategoryName.clear();
		input_CategoryName.sendKeys(categoryName);
		log("Entered category name: " + categoryName + " and object is:-" + input_CategoryName.toString());

		select = new Select(sel_Institution);
		select.selectByVisibleText(selectInstitution);
		log("selected institution " + selectInstitution + " and object is:- " + sel_Institution.toString());
		Thread.sleep(1000);

		/*
		 * option = select.getFirstSelectedOption();
		 * Assert.assertEquals(option.getText(), selectInstitution);
		 * Thread.sleep(1000);
		 */

		input_AddressLine1.clear();
		input_AddressLine1.sendKeys(addressLine1);
		log("Entered address line 1 : " + addressLine1 + " and object is:-" + input_AddressLine1.toString());

		input_AddressLine2.clear();
		input_AddressLine2.sendKeys(addressLine2);
		log("Entered address line 2 : " + addressLine2 + " and object is:-" + input_AddressLine2.toString());

		input_AddressLine3.clear();
		input_AddressLine3.sendKeys(addressLine3);
		log("Entered address line 3 : " + addressLine3 + " and object is:-" + input_AddressLine3.toString());

		input_AddressLine4.clear();
		input_AddressLine4.sendKeys(addressLine4);
		log("Entered address line 4 : " + addressLine4 + " and object is:-" + input_AddressLine4.toString());

		select = new Select(sel_Type);
		select.selectByVisibleText(selectType);
		log("selected type " + selectType + " and object is:- " + sel_Type.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), selectType);
		Thread.sleep(1000);

	}

	public void clearCategoryInfoData() throws Exception {
		btnCancel.click();
		log("Clicked on cancel button to clear filled master category and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}

	public void submitFilledMasterCategoryForm() throws Exception {

		btnSave.click();
		log("Save filled master category form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void sortByCategoryName() throws Exception {

		btnSortByCategoryName.click();
		log("Sorted the record with Category name and object is:-" + btnSortByCategoryName.toString());
		Thread.sleep(3000);
	}

	public void searchWithCategoryNameInTheGrid(String categoryName) {

		inputSearch.clear();
		inputSearch.sendKeys(categoryName);
		log("Entered category name to search: " + categoryName + " and object is:-" + inputSearch.toString());
	}

	public void verifyCategoryNameInTheGrid(String categoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String categoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Category Name: " + categoryname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(categoryname, categoryName);
				log("Category name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeMasterCategory() throws Exception {
		btnMin_MaxMasterCategory.click();
		log("clicked on master Category minimize button and object is:-" + btnMin_MaxMasterCategory.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterCategory() throws Exception {
		btnMin_MaxMasterCategory.click();
		log("clicked on master Category maximize button and object is:-" + btnMin_MaxMasterCategory.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterCategoryList() throws Exception {

		btnMin_MaxMasterCategoryList.click();
		log("Master Category list table data minimize and object is:-" + btnMin_MaxMasterCategoryList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterCategoryList() throws Exception {

		btnMin_MaxMasterCategoryList.click();
		log("Master Category list table table data maximized and object is:-"
				+ btnMin_MaxMasterCategoryList.toString());
		Thread.sleep(2000);
	}

	public void editMasterCategory(String categoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String categoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Category Name: " + categoryname);
			// Thread.sleep(2000);
			try {
				if (categoryname.equalsIgnoreCase(categoryName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/a")).click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master category list grid to edit record");

					break;
				} else {
					log("Category Name not matched with the master category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterCategory(String categoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String categoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Category Name: " + categoryname);
			// Thread.sleep(2000);
			try {
				if (categoryname.equalsIgnoreCase(categoryName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/span"));
					String deactivetext = deactiveLink.getText();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master category list grid");

					break;
				} else {
					log("Category Name not matched with the master category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterCategory(String categoryName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String categoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Category Name: " + categoryname);
			// Thread.sleep(2000);
			try {
				if (categoryname.equalsIgnoreCase(categoryName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]/span"));
					String activetext = activeLink.getText();
					Assert.assertEquals(activetext, "Activate");

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master category list grid");

					break;
				} else {
					log("Category Name not matched with the master category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}

	public void clickOnCancelButton() throws Exception {

		btnPopUpCancel.click();
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(15000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

}