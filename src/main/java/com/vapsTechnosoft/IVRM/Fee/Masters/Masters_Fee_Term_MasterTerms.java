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
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Term_MasterTerms extends TestBase {
	public static final Logger log = Logger.getLogger(Masters_Fee_Term_MasterTerms.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//a[@href='#/app/FeeMasterTerms/82']")
	WebElement btnFeeTerm;

	@FindBy(xpath = "//input[@name='tname' and @ng-model='FMT_Name']")
	WebElement input_TermName;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeTermMsgDispaly;

	@FindBy(xpath = "(//div[@class='input-group']/input)[1]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[1]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	public Masters_Fee_Term_MasterTerms(WebDriver driver) {
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

	public void nevigateToMasters_FeeTermMasterTerm() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeTerm);
		log("Clicked on Fee Term Button and object is:-" + btnFeeTerm.toString());

	}

	public boolean verifyFeeTermPage() {
		try {
			System.out.println(txtFeeTermMsgDispaly.getText());
			txtFeeTermMsgDispaly.isDisplayed();
			log("Fee Term page is dispalyed and object is:-" + txtFeeTermMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void mastersFeeMasterTerms(String feeTermName) throws Exception {

		inputTextIntoInputField(input_TermName, feeTermName);
		log("entered Fee Term name:-" + feeTermName + " and object is " + input_TermName.toString());
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
			Thread.sleep(2000);
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

	public void searchTermByTermName(String feeTermName) throws Exception {

		inputTextIntoInputField(inputSearch, feeTermName);
		log("Entered term name:" + feeTermName + "and object is:-" + inputSearch.toString());
		Thread.sleep(1000);
	}

	public void verifyTermNameUpdatedInGrid(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String TermName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(TermName);
				Thread.sleep(2000);
				if (TermName.equals(feeTermName)) {
					Assert.assertEquals(TermName, feeTermName);

					log("Term name is update in the grid:" + feeTermName);
					Thread.sleep(2000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Deactivation of fee term

	public void deactivationOfCreatedTerm(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String TermName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(TermName);
				Thread.sleep(2000);
				if (TermName.equals(feeTermName)) {
					Assert.assertEquals(TermName, feeTermName);
					driver.findElement(
							By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[4]/span/a")).click();
					log("Clicked on deactivation link in Fee term grid");

					Thread.sleep(2000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmationForDeactivation() throws Exception {
		
		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on record Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
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
	
		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);
	}

	// Activation of Fee Term

	public void activationOfCreatedTerm(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String TermName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(TermName);
				Thread.sleep(2000);
				if (TermName.equals(feeTermName)) {
					Assert.assertEquals(TermName, feeTermName);
					driver.findElement(
							By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[4]/span/a")).click();
					log("Clicked on activation link in Fee term grid");

					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmationForActivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}

	public boolean verifyActivationSuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Fee Term activated Successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnActivationFinalOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);
	}

	public void editFeeTerm_MasterTerm(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String TermName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]"))
						.getText();
				System.out.println(TermName);
				Thread.sleep(2000);

				if (TermName.equals(feeTermName)) {
					Assert.assertEquals(TermName, feeTermName);
					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[4]/a"))
							.click();
					log("Clicked on Edit link in Fee term grid");

					Thread.sleep(2000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editmastersFeeMasterTerms(String feeTermNameNew) throws Exception {
	
		inputTextIntoInputField(input_TermName, feeTermNameNew);
		log("entered new Fee Term name:-" + feeTermNameNew + " and object is " + input_TermName.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButtonEdit() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
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
	
		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
	
	}

}
