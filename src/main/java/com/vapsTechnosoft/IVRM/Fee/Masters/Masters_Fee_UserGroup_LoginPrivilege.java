/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_UserGroup_LoginPrivilege extends TestBase{

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
	
	@FindBy(xpath = "//span[contains(text(),'Tuition annual Fee')]")
	WebElement chkHead;
	
	@FindBy(xpath = "//span[contains(text(),' RAKESH')]")
	WebElement chkUserName;
	
	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

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
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);

		btnloginpreviledge.click();
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
		
		selectElementFromDropDown(selGroup, userGroup);
		log("selected group:-" + userGroup + " and object is " + selGroup.toString());
		
		isDisplayed(chkHead);
		if(!chkHead.isSelected()){
		chkHead.click();
		log("selected the head check box and object is:-"+chkHead.toString());
		Thread.sleep(1000);
		}else{
			log("Head check box already selected and object is:-"+chkHead.toString());
		}

		selectElementFromDropDown(selRole, role);
		log("selected Role:-" + role + " and object is " + selRole.toString());
	
		isDisplayed(chkUserName);
		if(!chkUserName.isSelected()){
			chkUserName.click();
			log("selected the user name check box and object is:-"+chkUserName.toString());
		Thread.sleep(1000);
		}else{
			log("user name check box already selected and object is:-"+chkUserName.toString());
		}
		
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

}
