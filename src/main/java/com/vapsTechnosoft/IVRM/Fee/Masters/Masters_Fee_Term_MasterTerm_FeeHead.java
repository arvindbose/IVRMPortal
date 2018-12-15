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
public class Masters_Fee_Term_MasterTerm_FeeHead extends TestBase{
	
	public static final Logger log = Logger.getLogger(Masters_Fee_Term_MasterTerm_FeeHead.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;
	
	@FindBy(xpath = "//a[@href='#/app/FeeMasterTerms/82']")
	WebElement btnFeeTerm;
	
	@FindBy(xpath = "//body[@id='style-4']//md-tab-item[2]")
	WebElement tabMasterTermFeeHead;

	@FindBy(xpath = "//select[@name='Termreq']")
	WebElement selTermName;
	
	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[2]")
	WebElement selFeeHead;
	
	@FindBy(xpath = "//input[@ng-model='searchchkbxhd']")
	WebElement input_FeeHead;
	
	@FindBy(xpath = "(//input[@name='head'])[1]")
	WebElement chk_FeeHead;
	
	@FindBy(xpath = "//input[@ng-model='searchchkbx']")
	WebElement input_Installment;
	
	@FindBy(xpath = "(//input[@name='installments'])[1]")
	WebElement chk_InstallmentName;
		
	@FindBy(xpath = "(//button[@id='save-btn'])[2]")
	WebElement btnSave;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeTermMsgDispaly;

	@FindBy(xpath = "//input[@ng-model='search2']")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;
	
	@FindBy(xpath = "//table/thead/tr/th[3]/a[text()='Term Name']")
	WebElement sort_TermName;
	
	@FindBy(xpath = "(//table/tbody)[2]/tr/td[3]")
	List<WebElement> list_TermName;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxFeeTerm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_MaxFeeMasterTermGridView;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;
	
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

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
	public void clickOnMasterTerm_FeeHeadTab() throws Exception{
	
		clickOnButton(tabMasterTermFeeHead);
		log("Selected master Term Fee Head and object is:-"+tabMasterTermFeeHead.toString());
		Thread.sleep(1000);
	}
	public void selectTermFeeHeadAndInstallmentName(String TermName, String FeesHead, String installmentName) throws Exception{
	
		selectElementFromDropDown(selTermName, TermName);
		log("selected Term Name from the list:-" + TermName + " and object is " + selTermName.toString());
	
		inputTextIntoInputField(input_FeeHead, FeesHead);
		log("Search Fee head to select check box and object is: "+input_FeeHead.toString());
		
		isDisplayed(chk_FeeHead);
		if(!chk_FeeHead.isSelected()){
			chk_FeeHead.click();
			log("Fee head chceck box is checked and object is: "+chk_FeeHead.toString());
		}
		else{
			log("Fee head chceck box is already checked and object is: "+chk_FeeHead.toString());	
		}
		inputTextIntoInputField(input_Installment, installmentName);
		log("Search installment name to select check box and object is: "+input_FeeHead.toString());
			
		isDisplayed(chk_InstallmentName);
		if(!chk_InstallmentName.isSelected()){
			chk_InstallmentName.click();
			log("Fee Installment chceck box is checked and object is: "+chk_InstallmentName.toString());
		}
		else{
			log("Fee Installment chceck box is already checked and object is: "+chk_InstallmentName.toString());	
		}
		
	}
	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {
		btnSave.click();
		log("clicked on save button To Submit Blank Form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnCancelButton_ToClearFilledForm() throws Exception {
		btnCancel.click();
		log("clicked on Cancel button and object is:-" + btnCancel.toString());
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
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}
	// search
	
	
	public void searchTermByTermName(String feeTermName) throws Exception {

		inputTextIntoInputField(inputSearch, feeTermName);
		log("Entered term name:" + feeTermName + "and object is:-" + inputSearch.toString());
		Thread.sleep(1000);
	}

	public void verifyTermNameUpdatedInGrid(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String TermName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText().trim();
			System.out.println(TermName);
			Thread.sleep(2000);
			try {
				if(TermName.equals(feeTermName)){
				Assert.assertEquals(TermName, feeTermName);

				log("Term name is update in the grid:" + TermName);
				Thread.sleep(2000);
				break;
				}
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
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[4]")).getText().trim();
			System.out.println(FeesHeadName);
			Thread.sleep(2000);
			try {
				if(FeesHeadName.equals(feeHeadName)){
				Assert.assertEquals(FeesHeadName, feeHeadName);

				log("Fees Head is update in the grid:" + feeHeadName);
				Thread.sleep(2000);
				break;
				}
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
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]")).getText().trim();
			System.out.println(TermName);
			Thread.sleep(2000);
			try {
				if(TermName.equals(feeTermName)){
				Assert.assertEquals(TermName, feeTermName);
				driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[6]/a[1]"))
						.click();
				log("Clicked on Edit link in Fee term Fees Head grid");

				Thread.sleep(2000);
				break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletiontionOfCreatedTermfeeHead(String feeTermName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String TermName = driver
						.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[3]"))
						.getText().trim();
				System.out.println(TermName);
				Thread.sleep(2000);
				if (TermName.equals(feeTermName)) {
					Assert.assertEquals(TermName, feeTermName);
					WebElement deleteLink = driver
							.findElement(By.xpath("(//body[@id='style-4']//div/table)[2]/tbody/tr[" + i + "]/td[6]/a[2]"));
					String DeleteText = deleteLink.getAttribute("title");
					System.out.println("Tool tip text present :- " + DeleteText);

					// Compare toll tip text
					Assert.assertEquals(DeleteText, "Delete");
					
					deleteLink.click();
					log("Clicked on delete link in Master Term Fee Head grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void sortByFeeTermName() throws Exception {

		clickOnButton(sort_TermName);
		SortData_InColumn_AscendingOrder(list_TermName);
		log("Sorted the record with Fee Term name in Ascending order and object is:-" + sort_TermName.toString());
		
}
	
	public void minimizeAndMaximize_FeeTerm() throws Exception {
		
		clickOnButton(btnMin_MaxFeeTerm);
		log("clicked on Fee Head minimize and maximize button and object is:-" + btnMin_MaxFeeTerm.toString());
		Thread.sleep(1000);
	
}

public void minimizeAndMaximize_FeeMasterTermGridView() throws Exception {

		clickOnButton(btnMin_MaxFeeMasterTermGridView);
		log("Fee Master Term grid table data minimize and maximize and object is:-"
				+ btnMin_MaxFeeMasterTermGridView.toString());
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

public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
	try {
		validate_PopUpText.isDisplayed();
		String text = validate_PopUpText.getText().trim();
		assertEquals(text, "Record Updated Successfully");
		log("Record submitted sucessfully message validated for edit.");
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


/**
 * Confirmation validation for deactivation, activation
 * 
 * @throws Exception
 */

public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(1000);
	
}

public void clickOnCancelButton_PopUp() throws Exception {
	
		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(1000);
	
}
}
