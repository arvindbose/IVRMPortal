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
public class Masters_Fee_Term_MasterTerm_FeeHead extends TestBase{
	
	public static final Logger log = Logger.getLogger(Masters_Fee_Term_MasterTerm_FeeHead.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[4]")
	WebElement btnFeeTerm;
	
	@FindBy(xpath = "//body[@id='style-4']//md-tab-item[2]")
	WebElement tabMasterTermFeeHead;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[1]")
	WebElement selTermName;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[2]")
	WebElement selFeeHead;
	
	@FindBy(xpath = "(//span[contains(text(),'Test Installment I')])[1]")
	WebElement chkInstallmentName;
	
	@FindBy(xpath = "(//button[@id='save-btn'])[2]")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeTermMsgDispaly;

	@FindBy(xpath = "(//div[@class='input-group']/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;

	public Masters_Fee_Term_MasterTerm_FeeHead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void nevigateToMasters_FeeTermMasterTerm_FeeHead() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		waitForElement(driver, 10, btnFee);

		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		waitForElement(driver, 10, feeMasters);

		btnFeeTerm.click();
		log("Clicked on Fee Term Button and object is:-" + btnFeeTerm.toString());
		waitForElement(driver, 10, btnFeeTerm);
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
	public void clickOnMasterTerm_FeeHeadTab() throws Exception{
		tabMasterTermFeeHead.click();
		log("Selected master Term Fee Head and object is:-"+tabMasterTermFeeHead.toString());
		Thread.sleep(3000);
	}
	public void selectTermFeeHeadAndInstallmentName(String TermName, String FeesHead) throws Exception{
		
		select = new Select(selTermName);
		select.selectByVisibleText(TermName);
		log("selected Term Name from the list:-" + TermName + " and object is " + selTermName.toString());
		Thread.sleep(2000); 
		
		select = new Select(selFeeHead);
		select.selectByVisibleText(FeesHead);
		log("selected fees Head from the list:-" + FeesHead + " and object is " + selFeeHead.toString());
		Thread.sleep(2000); 
		
		chkInstallmentName.click();
		log("selected installment name and object is: "+chkInstallmentName.toString());
		Thread.sleep(2000);
	}

	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(2000);
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
	// search
	
	
	public void searchTermByTermName(String feeTermName) throws Exception {

		inputSearch.sendKeys(feeTermName);
		log("Entered term name:" + feeTermName + "and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
	}

	public void verifyTermNameUpdatedInGrid(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String TermName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(TermName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(TermName, feeTermName);

				log("Term name is update in the grid:" + TermName);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void verifyFeeHeadUpdatedInGrid(String feeHeadName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FeesHeadName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println(FeesHeadName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(FeesHeadName, feeHeadName);

				log("Fees Head is update in the grid:" + feeHeadName);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editFeeTerm_MasterTerm_FeeHead(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String TermName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(TermName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(TermName, feeTermName);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[6]/a[1]"))
						.click();
				log("Clicked on Edit link in Fee term Fees Head grid");

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickOnSaveButtonEdit() throws Exception {
		btnSave.click();
		log("clicked on save button for edit and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public boolean verifySuccessfulPopUpEdit() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record updated successfully message for edit is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnSuccessOkBtnEdit() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button for edit and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}
}
