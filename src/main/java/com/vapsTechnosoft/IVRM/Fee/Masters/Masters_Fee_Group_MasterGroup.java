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

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[3]")
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

	public Masters_Fee_Group_MasterGroup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToMasters_FeeGroup() throws Exception {
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
		if (btnFeeGroup.isDisplayed()) {
			btnFeeGroup.click();
			log("Clicked on Fee Group Button and object is:-" + btnFeeGroup.toString());
			Thread.sleep(5000);
		} else {
			log("Fee Group Navigation element not present.");
			Thread.sleep(500);
		}
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

		if (input_FeeGroupName.isDisplayed()) {
			input_FeeGroupName.clear();
			input_FeeGroupName.sendKeys(feeGroupName);
			log("Entered Fee group name:-" + feeGroupName + " and object is " + feeGroupName.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Name field element not present.");
			Thread.sleep(500);
		}

		if (sel_FeeGrType.isDisplayed()) {
			select = new Select(sel_FeeGrType);
			select.selectByVisibleText(feeGrType);

			log("selected Fee Group Type: " + feeGrType + " and object is:- " + sel_FeeGrType.toString());
			Thread.sleep(1000);
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), feeGrType);
			Thread.sleep(2000);
		} else {
			log("Class Admitted element is not present");
			Thread.sleep(500);
		}
		if (input_Remarks.isDisplayed()) {
			input_Remarks.clear();
			input_Remarks.sendKeys(feeGroupRemarks);
			log("Entered fee group remarks:-" + feeGroupRemarks + " and object is " + input_Remarks.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group remarks field element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_MasterGroup() throws Exception {
		if (btn_Save_MasterGr.isDisplayed()) {
			btn_Save_MasterGr.click();
			log("clicked on save button and object is:-" + btn_Save_MasterGr.toString());
			Thread.sleep(5000);
		} else {
			log("Save Button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_MasterGroup() throws Exception {
		if (btn_Cancel_MasterGr.isDisplayed()) {
			btn_Cancel_MasterGr.click();
			log("clicked on Cancel button and object is:-" + btn_Cancel_MasterGr.toString());
			Thread.sleep(5000);
		} else {
			log("Cancel Button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOkonSuccess.isDisplayed()) {
			btnOkonSuccess.click();
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK Button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with the created Fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	
	public void searchBy_FeeGroup_MasterFeeGrNameInGrid(String feeGroup) throws Exception {
		if (input_Search_MasterGr.isDisplayed()) {
			input_Search_MasterGr.clear();
			input_Search_MasterGr.sendKeys(feeGroup);
			log("Entered Master Fee Group name:" + feeGroup + " and object is:-" + input_Search_MasterGr.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present");
			Thread.sleep(500);
		}
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
		for (int i = 1; i <= rows; i++) {
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feegroup, feeGroup);
				log("Master Fee group name is update in the grid:" + feegroup);
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

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
		for (int i = 1; i <= rows; i++) {
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/a")).click();
				log("Clicked on edit link for corresponding Master Fee group name in grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

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
		for (int i = 1; i <= rows; i++) {
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on deactivation link in Master fee group grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Confirmation validation for deactivation, activation
	 * 
	 * @throws Exception
	 */

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes deactivate or activate or delete it button and object is:-"
					+ btnYesDeleteOrDeactIt.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Activate/Deactivate button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton() throws Exception {
		if (btnPopUpCancel.isDisplayed()) {
			btnPopUpCancel.click();
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
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
		for (int i = 1; i <= rows; i++) {
			String feegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + feegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feegroup, feeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]/span"))
						.click();
				log("Clicked on activation link in Master fee group in grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeAndMaximize_MasterFeeGroup() throws Exception {
		if (btnMin_MaxMasterFeeGroup.isDisplayed()) {
			btnMin_MaxMasterFeeGroup.click();
			log("clicked on master Fee Group minimize and maximize button and object is:-"
					+ btnMin_MaxMasterFeeGroup.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Master Group button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_MasterGroupFeeGrGridView() throws Exception {
		if (btnMin_MaxMasterGroupFeeGrGridView.isDisplayed()) {
			btnMin_MaxMasterGroupFeeGrGridView.click();
			log("Master Group Fee Group grid table data minimize and maximize and object is:-"
					+ btnMin_MaxMasterGroupFeeGrGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Master Fee Group grid button element not present.");
			Thread.sleep(500);
		}
	}
	public void sortByMasterFeeGroupName() throws Exception {
		if (btnSortByFeeGroupName.isDisplayed()) {
		btnSortByFeeGroupName.click();
		log("Sorted the record with Fee Group name and object is:-" + btnSortByFeeGroupName.toString());
		Thread.sleep(2000);
	} else {
		log("Sort element not present.");
		Thread.sleep(500);
	}
	}
}
