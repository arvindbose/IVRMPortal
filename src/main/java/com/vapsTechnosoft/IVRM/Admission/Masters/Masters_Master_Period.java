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
public class Masters_Master_Period extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Period.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[19]")
	WebElement btnMasters_masterPeriod;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterPeriodMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selPeriodName;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selPeriodOrder;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Category')]/preceding-sibling::input")
	WebElement chkCategory;

	@FindBy(xpath = "(//span[contains(text(),'I Half')]/preceding-sibling::input)[1]")
	WebElement rdIHalf;

	@FindBy(xpath = "(//span[contains(text(),'I Half')]/preceding-sibling::input)[2]")
	WebElement rdIIHalf;

	@FindBy(xpath = "//body[@id='style-4']//div/input")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByCategoryName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterPeriod;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterPeriodList;

	public Masters_Master_Period(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission Masters Master Period
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterPeriod_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterPeriod);

		btnMasters_masterPeriod.click();
		log("Clicked on master Period Button and object is:-" + btnMasters_masterPeriod.toString());
		waitForElement(driver, 10, btnSave);

	}

	/**
	 * Validation of masters master period screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterPeriod_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterPeriodMsgDispaly.getText());
			txtMasters_MasterPeriodMsgDispaly.isDisplayed();
			log("Master Period page is dispalyed and object is:-" + txtMasters_MasterPeriodMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterPeriodData(String periodName, String periodOrder) throws Exception {

		select = new Select(selPeriodName);
		select.selectByVisibleText(periodName);
		log("selected period name " + periodName + " and object is:- " + selPeriodName.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), periodName);
		Thread.sleep(1000);

		select = new Select(selPeriodOrder);
		select.selectByVisibleText(periodOrder);
		log("selected period order " + periodOrder + " and object is:- " + selPeriodOrder.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), periodOrder);
		Thread.sleep(1000);

		if (!chkCategory.isSelected()) {
			chkCategory.click();
			log("Category check box is selected and object is:-" + chkCategory.toString());
		} else {
			log("Category check box is already checked and object is:-" + chkCategory.toString());
		}
	}

	public void selectIstHalfPeriodRadioButton() {
		if (!rdIHalf.isSelected()) {
			rdIHalf.click();
			log("I Half period radio button is selected and object is:-" + rdIHalf.toString());
		} else {
			log("I Half period radio button is already selected and object is:-" + rdIHalf.toString());
		}
	}

	public void selectIIndHalfPeriodRadioButton() {
		if (!rdIIHalf.isSelected()) {
			rdIIHalf.click();
			log("II Half period radio button is selected and object is:-" + rdIIHalf.toString());
		} else {
			log("II Half period radio button is already selected and object is:-" + rdIIHalf.toString());
		}
	}

	public void submitBlankMasterPeriodForm() throws Exception {

		btnSave.click();
		log("Submit blank master Period form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void clearPeriodInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Period info and object is:-" + btnCancelClear.toString());
		Thread.sleep(10000);
	}

	public void savePeriodInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Period info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeMasterPeriod() throws Exception {
		btnMin_MaxMasterPeriod.click();
		log("clicked on master Period minimize button and object is:-" + btnMin_MaxMasterPeriod.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterPeriod() throws Exception {
		btnMin_MaxMasterPeriod.click();
		log("clicked on master Period maximize button and object is:-" + btnMin_MaxMasterPeriod.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterPeriodList() throws Exception {

		btnMin_MaxMasterPeriodList.click();
		log("Master Period list table data minimize and object is:-" + btnMin_MaxMasterPeriodList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterPeriodList() throws Exception {

		btnMin_MaxMasterPeriodList.click();
		log("Master Period list table table data maximized and object is:-" + btnMin_MaxMasterPeriodList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
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

	public void editMasterPeriod(String categoryName) {

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

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master Period list grid to edit record");

					break;
				} else {
					log("Category Name not matched with the master Period list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteMasterPeriod(String categoryName) {

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

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the master Period list grid to delete record");

					break;
				} else {
					log("Category Name not matched with the master Period list grid");
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

		btnCancel.click();
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}

}
