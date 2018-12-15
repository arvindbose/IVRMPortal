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
public class Masters_Fee_UserGroup_LoginPrivilege extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_UserGroup_LoginPrivilege.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//a[@href='#/app/MasterFeePrevilege/312']")
	WebElement btnloginpreviledge;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFGLoginPreviledge;

	@FindBy(xpath = "//select[@name='ayr']")
	WebElement selAcademicYear;

	@FindBy(xpath = "//select[@name='cat' and @ng-model='fmG_Id']")
	WebElement selGroup;

	@FindBy(xpath = "//select[@name='rol']")
	WebElement selRole;

	@FindBy(xpath = "(//input[@name='head'])[1]")
	WebElement chkHead;

	@FindBy(xpath = "(//input[@name='name'])[1]")
	WebElement chkUserName;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//input[@ng-model='searchValue1']")
	WebElement input_Search;

	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//table/thead/tr/th[2]/a")
	WebElement sort_UserName;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> list_UserName;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxFeePrevilege;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxFeePrevilegeGridView;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	public Masters_Fee_UserGroup_LoginPrivilege(WebDriver driver) {
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

	public void nevigateToFeeUserGr_LoginPreviledge() throws Exception {

		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);

		clickOnButton(btnloginpreviledge);
		log("Clicked on fee user group login previledge Button and object is:-" + btnloginpreviledge.toString());
		Thread.sleep(1000);
	}

	public boolean verifyFeeUserGrLoginPreviledgePage() {
		try {
			System.out.println(txtFGLoginPreviledge.getText());
			txtFGLoginPreviledge.isDisplayed();
			log("Fee user group login previledge page is dispalyed and object is:-" + txtFGLoginPreviledge.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void selectAcademicYear_GroupAndRole(String AcademicYear, String userGroup, String role) throws Exception {

		selectElementFromDropDown(selAcademicYear, AcademicYear);
		log("selected Academic year:-" + AcademicYear + " and object is " + selAcademicYear.toString());
		Thread.sleep(2000);
		
		selectElementFromDropDown(selRole, role);
		log("selected Role:-" + role + " and object is " + selRole.toString());
		Thread.sleep(2000);
		
		isDisplayed(chkUserName);
		if (!chkUserName.isSelected()) {
			chkUserName.click();
			log("selected the user name check box and object is:-" + chkUserName.toString());
			Thread.sleep(1000);
		} else {
			log("user name check box already selected and object is:-" + chkUserName.toString());
		}
		
		selectElementFromDropDown(selGroup, userGroup);
		log("selected group:-" + userGroup + " and object is " + selGroup.toString());
		Thread.sleep(3000);
		
		isDisplayed(chkHead);
		if (!chkHead.isSelected()) {
			chkHead.click();
			log("selected the head check box and object is:-" + chkHead.toString());
			Thread.sleep(2000);
		} else {
			log("Head check box already selected and object is:-" + chkHead.toString());
		}	

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(5000);
	}

	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button to submit balnk form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
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
		Thread.sleep(2000);
	}

	public void sortByUserName() throws Exception {

		clickOnButton(sort_UserName);
		SortData_InColumn_AscendingOrder(list_UserName);
		log("Sorted the record with User Name in Ascending order and object is:-" + sort_UserName.toString());

	}

	public void minimizeAndMaximize_FeePrevilege() throws Exception {

		clickOnButton(btnMin_MaxFeePrevilege);
		log("clicked on Fee Login Previlege minimize and maximize button and object is:-"
				+ btnMin_MaxFeePrevilege.toString());
		Thread.sleep(2000);

	}

	public void minimizeAndMaximize_FeePrevilegeGridView() throws Exception {

		clickOnButton(btnMin_MaxFeePrevilegeGridView);
		log("Fee Login Previlege grid table data minimize and maximize and object is:-"
				+ btnMin_MaxFeePrevilegeGridView.toString());
		Thread.sleep(2000);

	}

	public void searchLoginPrevilegeByUserName(String userName) throws Exception {

		inputTextIntoInputField(input_Search, userName);
		log("Entered UserName:" + userName + "and object is:-" + input_Search.toString());
		Thread.sleep(1000);
	}

	public void verifyUserNameUpdatedInGrid(String userName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String username = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().trim();
			System.out.println(username);
			Thread.sleep(2000);
			try {
				if (username.equals(userName)) {
					Assert.assertEquals(username, userName);

					log("User name is update in the grid:" + username);
					Thread.sleep(2000);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void editLoginPreviele_FeeUserGrLoginPrevilege(String userName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String username = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().trim();
			System.out.println(username);
			Thread.sleep(2000);
			try {
				if (username.equals(userName)) {
					Assert.assertEquals(username, userName);
					driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]/a[1]")).click();
					log("Clicked on Edit link in Fee User Group Login Previlege grid");

					Thread.sleep(5000);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deletiontionOfCreatedFeeUserGroupLoginPrevilege(String userName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String username = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().trim();
			System.out.println(username);
			Thread.sleep(2000);
			try {
				if (username.equals(userName)) {
					Assert.assertEquals(username, userName);
					WebElement deleteLink = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]/a[2]"));
					String DeleteText = deleteLink.getAttribute("title");
					System.out.println("Tool tip text present :- " + DeleteText);

					// Compare toll tip text
					Assert.assertEquals(DeleteText, "Delete");

					deleteLink.click();
					log("Clicked on delete link in Fee User Group Login Previlege grid");
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		Thread.sleep(3000);

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(5000);

	}
}
