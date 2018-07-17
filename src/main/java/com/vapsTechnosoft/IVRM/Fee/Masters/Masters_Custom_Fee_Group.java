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
public class Masters_Custom_Fee_Group extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Yearly_Class_Category.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[6]")
	WebElement btnCustomFeeGr;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtCustomFeeGrMsgDispaly;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement inputFeeGroupName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputFeeGroupCode;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement inputFeeGroupSearch;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Fee Group')]")
	WebElement chkFeeGroup;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Fee Group')]/preceding-sibling::input")
	WebElement chkboxSelectionFeeGroup;

	@FindBy(xpath = "(//div[@class='text-center']/button)[2]")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
	WebElement inputSearch;

	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	public Masters_Custom_Fee_Group(WebDriver driver) {
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
	 * Navigate to custom fee group
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_Custom_FeeGroup() throws Exception {

		if (btnFee.isDisplayed()) {
			btnFee.click();
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Fee Navigation element not present.");
			Thread.sleep(500);
		}
		if (feeMasters.isDisplayed()) {
			feeMasters.click();
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee Masters Navigation element not present.");
			Thread.sleep(500);
		}
		if (btnCustomFeeGr.isDisplayed()) {
			btnCustomFeeGr.click();
			log("Clicked on Custom fee group Button and object is:-" + btnCustomFeeGr.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Fee Custom Group Navigation element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of custom fee group screen message
	 * 
	 * @return
	 */
	public boolean verifyCustomFeeGroupPage() {
		try {
			System.out.println(txtCustomFeeGrMsgDispaly.getText());
			txtCustomFeeGrMsgDispaly.isDisplayed();
			log("Custom Fee Group page is dispalyed and object is:-" + txtCustomFeeGrMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter the input for custom fee group creation
	 * 
	 * @param customFeeGrName
	 * @param feeGroupCode
	 * @param Feegroup
	 * @throws Exception
	 */
	public void enterCustomFeeGrNameGroupCodeAndSelectFeeGroup(String customFeeGrName, String feeGroupCode,
			String Feegroup) throws Exception {
		if (inputFeeGroupName.isDisplayed()) {
			inputFeeGroupName.sendKeys(customFeeGrName);
			log("Entered custom fee group name: " + customFeeGrName + " and object is:-"
					+ inputFeeGroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present");
			Thread.sleep(500);
		}
		if (inputFeeGroupCode.isDisplayed()) {
			inputFeeGroupCode.sendKeys(feeGroupCode);
			log("Entered fee group code: " + feeGroupCode + " and object is:-" + inputFeeGroupCode.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present");
			Thread.sleep(500);
		}
		if (inputFeeGroupSearch.isDisplayed()) {

			inputFeeGroupSearch.clear();
			inputFeeGroupSearch.sendKeys(Feegroup);

			log("Entered fee group for search " + Feegroup + " and object is:-" + inputFeeGroupSearch.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present");
			Thread.sleep(500);
		}
		String feeGroupselection = chkFeeGroup.getText();
		try {
			Assert.assertEquals(feeGroupselection, Feegroup);
		} catch (Exception e) {
			log("Fee group for selection  is not matched");
		}
		if (!chkboxSelectionFeeGroup.isSelected()) {

			chkboxSelectionFeeGroup.click();
			log("Fee group check box is selected for the specific group");
		} else {
			log("Check box is already selected");
		}
	}

	/**
	 * Click on save button to save the custom fee group input value
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton() throws Exception {
		if (btnSave.isDisplayed()) {
			btnSave.click();
			log("clicked on save button and object is:-" + btnSave.toString());
			Thread.sleep(3000);
		} else {
			log("Save Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * validation of Record saved successfully message
	 * 
	 * @return
	 */
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

	/**
	 * click on OK button after Saving the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOkonSuccess.isDisplayed()) {
			btnOkonSuccess.click();
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with the created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void searchByGroupNameInGrid(String customGroupName) throws Exception {
		if (inputSearch.isDisplayed()) {
			inputSearch.clear();
			inputSearch.sendKeys(customGroupName);
			log("Entered Class category name:" + customGroupName + " and object is:-" + inputSearch.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * verify for the created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void verifyCustomGroupupdatedInGrid(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customGroup = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(customGroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(customGroup, customGroupName);
				log("Custom group name is update in the grid:" + customGroup);
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Edit custom group name created
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void edit_CustomFeeGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customgroup = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(customgroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(customgroup, customGroupName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/a")).click();
				log("Clicked on edit link for corresponding group name in grid");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Deactivation of created custom group name
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void deactivationOfCreatedCustomGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customgroup = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(customgroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(customgroup, customGroupName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span")).click();
				log("Clicked on deactivation link in custom group grid");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Confirmation message validation for deactivation
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivation() throws Exception {
		if (btnPopUpYesDeactivateit.isDisplayed()) {
			btnPopUpYesDeactivateit.click();
			log("Clicked Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Deactivate Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Activation of created custom group
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void activationOfCreatedCustomGroup(String customGroupName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customgroup = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(customgroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(customgroup, customGroupName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span")).click();
				log("Clicked on activation link in Custom group name grid");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Activation confirmation pop up validation
	 * 
	 * @throws Exception
	 */
	public void confirmationForActivation() throws Exception {
		if (btnPopUpYesDeactivateit.isDisplayed()) {
			btnPopUpYesDeactivateit.click();
			log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
			Thread.sleep(5000);
		} else {
			log("Yes activate Element not present");
			Thread.sleep(500);
		}
	}
}
