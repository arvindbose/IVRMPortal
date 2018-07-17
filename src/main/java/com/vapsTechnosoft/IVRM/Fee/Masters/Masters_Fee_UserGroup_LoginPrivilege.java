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

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[12]")
	WebElement btnloginpreviledge;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFGLoginPreviledge;
	
	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selAcademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selGroup;
	
	@FindBy(xpath = "(//select[@id='sel1'])[3]")
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
			Thread.sleep(7000);
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

		select = new Select(selAcademicYear);
		select.selectByVisibleText(AcademicYear);
		log("selected Academic year:-" + AcademicYear + " and object is " + selAcademicYear.toString());
		Thread.sleep(1000);

		select = new Select(selGroup);
		select.selectByVisibleText(userGroup);
		log("selected group:-" + userGroup + " and object is " + selGroup.toString());
		Thread.sleep(1000);
		
		chkHead.click();
		log("selected the head check box and object is:-"+chkHead.toString());
		Thread.sleep(1000);
		
		select = new Select(selRole);
		select.selectByVisibleText(role);
		log("selected Role:-" + role + " and object is " + selRole.toString());
		Thread.sleep(1000);
		
		chkUserName.click();
		log("selected the user name check box and object is:-"+chkUserName.toString());
		Thread.sleep(1000);
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

}
