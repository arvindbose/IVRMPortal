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
public class Masters_Fee_Group_MasterGroup extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Group_MasterGroup.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[3]")
	// WebElement btnFeeGroup;

	@FindBy(xpath = "//a[@href='#/app/FeeGroup/79']")
	WebElement btnFeeGroup;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeGroupDispaly;

	@FindBy(xpath = "//label[contains(text(),'Fee Group:')]/following-sibling::div/input")
	WebElement input_FeeGroupName;

	@FindBy(xpath = "//label[contains(text(),'Remarks:')]/following-sibling::div/textarea")
	WebElement input_Remarks;

	@FindBy(xpath = "//label[contains(text(),'Fee Group Type:')]/following-sibling::div/select")
	WebElement sel_FeeGrType;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[1]")
	WebElement btn_Save_MasterGr;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	WebElement btn_Cancel_MasterGr;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "(//div[@class='input-group']/span/following-sibling::input)[1]")
	WebElement input_Search_MasterGr;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterFeeGroup;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterGroupFeeGrGridView;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByFeeGroupName;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> list_GroupName;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	
	
	public Masters_Fee_Group_MasterGroup(WebDriver driver) {
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

	public void navigateToMasters_FeeGroup() throws Exception {
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btnFeeGroup);
		log("Clicked on Fee Group Button and object is:-" + btnFeeGroup.toString());

	}

	public boolean verifyFeeGroupPage() {
		try {
			System.out.println(txtFeeGroupDispaly.getText());
			txtFeeGroupDispaly.isDisplayed();
			log("Fee group page is dispalyed and object is:-" + txtFeeGroupDispaly.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fill_FeeGroup_MasterGroupForm(String feeGroupName, String feeGrType, String feeGroupRemarks)
			throws Exception {

			inputTextIntoInputField(input_FeeGroupName, feeGroupName);
			log("Entered Fee group name:-" + feeGroupName + " and object is " + feeGroupName.toString());
	
			selectElementFromDropDown(sel_FeeGrType, feeGrType);
			log("selected Fee Group Type: " + feeGrType + " and object is:- " + sel_FeeGrType.toString());
	
			inputTextIntoInputField(input_Remarks, feeGroupRemarks);
			log("Entered fee group remarks:-" + feeGroupRemarks + " and object is " + input_Remarks.toString());
			
	}

	public void clickOnSaveButton_MasterGroup() throws Exception {
	
			clickOnButton(btn_Save_MasterGr);
			log("clicked on save button and object is:-" + btn_Save_MasterGr.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnCancelButton_MasterGroup() throws Exception {
	
			clickOnButton(btn_Cancel_MasterGr);
			log("clicked on Cancel button and object is:-" + btn_Cancel_MasterGr.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnSuccessOkBtn() throws Exception {
		
			clickOnButton(btnOkonSuccess);
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			
	}

	/**
	 * Search with the created Fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */

	public void searchBy_FeeGroup_MasterFeeGrNameInGrid(String feeGroup) throws Exception {
	
			inputTextIntoInputField(input_Search_MasterGr, feeGroup);
			log("Entered Master Fee Group name:" + feeGroup + " and object is:-" + input_Search_MasterGr.toString());
			
	}

	/**
	 * verify for the created Master Fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	public void verifyMasterFeeGroup_UpdatedInGrid(String feeGroup) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
				if(feegroup.equals(feeGroup)){
				Assert.assertEquals(feegroup, feeGroup);
				log("Master Fee group name is update in the grid:" + feegroup);
				Thread.sleep(1000);
				 break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit Master fee group name created
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	public void edit_MasterFeeGroup(String feeGroup) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			if(feegroup.equals(feeGroup)){
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/a")).click();
				log("Clicked on edit link for corresponding Master Fee group name in grid");
				Thread.sleep(1000);
				 break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * De-activation of created Master Fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	public void deactivationOfCreated_MasterFeeGroup(String feeGroup) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			if(feegroup.equals(feeGroup)){
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on deactivation link in Master fee group grid");
				Thread.sleep(1000);
				 break;
		}

		}
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
			
	}

	public void clickOnCancelButton() throws Exception {

			clickOnButton(btnPopUpCancel);
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			
	}

	/**
	 * Activation of created Master fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	public void activationOfCreatedFeeGroup_MasterGroup(String feeGroup) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
		
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			if(feegroup.equals(feeGroup)){
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on activation link in Master fee group in grid");
				Thread.sleep(1000);
				 break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeAndMaximize_MasterFeeGroup() throws Exception {
		
			clickOnButton(btnMin_MaxMasterFeeGroup);
			log("clicked on master Fee Group minimize and maximize button and object is:-"
					+ btnMin_MaxMasterFeeGroup.toString());
			
	}

	public void minimizeAndMaximize_MasterGroupFeeGrGridView() throws Exception {
	
			clickOnButton(btnMin_MaxMasterGroupFeeGrGridView);
			log("Master Group Fee Group grid table data minimize and maximize and object is:-"
					+ btnMin_MaxMasterGroupFeeGrGridView.toString());
			
	}

	public void sortByMasterFeeGroupName() throws Exception {
	
			clickOnButton(btnSortByFeeGroupName);
			SortData_InColumn_AscendingOrder(list_GroupName);
			log("Sorted the record with Fee Group name in ascending order and object is:-" + btnSortByFeeGroupName.toString());
			
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

	public void popUpWindowMessage_DeactivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_DeactivateSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_ActivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activate Cancelled");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popUpWindowMessage_ActivateSucessfully_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
