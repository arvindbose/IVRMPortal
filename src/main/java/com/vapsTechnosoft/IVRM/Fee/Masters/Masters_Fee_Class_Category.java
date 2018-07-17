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
public class Masters_Fee_Class_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Class_Category.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[7]")
	WebElement btnFeeClassCategory;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeClassCategoryMsgDispaly;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[1]")
	WebElement txtClassCategoryName;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[2]")
	WebElement txtClassCategoryCode;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "(//div[@class='input-group']/input)[1]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	public Masters_Fee_Class_Category(WebDriver driver) {
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

	public void nevigateToMasters_Fee_ClassCategory() throws Exception {
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
			// waitForElement(driver, 10, btnFeeClassCategory);
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

	public void enterClassCategoryNameAndCode(String classCategoryName, String classCategoryCode) throws Exception {
	if(txtClassCategoryName.isDisplayed()){
		txtClassCategoryName.clear();
		txtClassCategoryName.sendKeys(classCategoryName);
		log("Entered class category name: " + classCategoryName + " and object is:-" + txtClassCategoryName.toString());
		Thread.sleep(1000);
	} else {
		log("Fee class category name element not present");
		Thread.sleep(500);
	}
	if(txtClassCategoryCode.isDisplayed()){
		txtClassCategoryCode.clear();
		txtClassCategoryCode.sendKeys(classCategoryCode);
		log("Entered class category Code: " + classCategoryCode + " and object is:-" + txtClassCategoryCode.toString());
		Thread.sleep(1000);
	} else {
		log("Class category Code element not present");
		Thread.sleep(500);
	}
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

	public void searchByClassCategoryName(String classCtgName) throws Exception {
		if(inputSearch.isDisplayed()){
		inputSearch.clear();
		inputSearch.sendKeys(classCtgName);
		log("Entered class category name for search:" + classCtgName + " and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
	} else {
		log("Class category name search element not present");
		Thread.sleep(500);
	}
	}

	public void verifyClassCategoryNameUpdatedInGrid(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(500);
			try {
				Assert.assertEquals(classCategoryName, classCtgName);

				log("Class category name is updated in the grid:" + classCategoryName);
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deactivationOfCreatedClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classCtgrName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(classCtgrName);
			Thread.sleep(500);
			try {
				Assert.assertEquals(classCtgrName, classCtgName);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on deactivation link in Fee term grid");

				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void confirmationForDeactivation() throws Exception {
		btnPopUpYesDeactivateit.click();
		log("Clicked on record Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(5000);
	}

	public boolean verifyDeactivationSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Fee Term Deactivated Successfully message is dispalyed and object is:-"
					+ successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnDeactivationFinalOkBtn() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}

	// Activation
	public void activationOfCreatedClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classCategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(classCategoryName);
			Thread.sleep(500);
			try {
				Assert.assertEquals(classCategoryName, classCtgName);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on activation link in Fee class category grid");

				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void confirmationForActivation() throws Exception {
		btnPopUpYesDeactivateit.click();
		log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(5000);
	}

	public boolean verifyActivationSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Class category activated Successfully message is dispalyed and object is:-"
					+ successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnActivationFinalOkBtn() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}

	// Edit

	public void editFeeClassCategory(String classCtgName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classcategoryName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(classcategoryName);
			Thread.sleep(500);
			try {
				Assert.assertEquals(classcategoryName, classCtgName);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[5]/a"))
						.click();
				log("Clicked on Edit link in class category grid");

				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOnSaveButtonEdit() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public boolean verifySuccessfulPopUpEdit() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record updated successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnSuccessOkBtnEdit() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}

}
