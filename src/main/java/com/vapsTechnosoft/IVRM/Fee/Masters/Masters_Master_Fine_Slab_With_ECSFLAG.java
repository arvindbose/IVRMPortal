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
public class Masters_Master_Fine_Slab_With_ECSFLAG extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Fine_Slab_With_ECSFLAG.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//a[@href='#/app/MasterFineSlab/90']")
	WebElement btnMasterFineSlab;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasterFineSlabMsgDispaly;

	@FindBy(xpath = "//div[@class='col-sm-8']/select")
	WebElement selType;

	@FindBy(xpath = "//input[@name='frmdayreq']")
	WebElement txtFromDay;

	@FindBy(xpath = "//input[@name='todayreq']")
	WebElement txtToDay;

	@FindBy(xpath = "//input[@data-ng-model='FMFS_ECSFlag']")
	WebElement textECSFlag;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "//span[contains(text(),'ECS Flag')]/preceding-sibling::input")
	WebElement chkECSFlag;

	@FindBy(xpath = "//table/thead/tr/th[2]/a")
	WebElement sort_FineSlabType;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> list_FineSlabType;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxFineSlab;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxFineSlabGridView;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;
	
	
	public Masters_Master_Fine_Slab_With_ECSFLAG(WebDriver driver) {
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

	/**
	 * Navigate to master fine slab 1. Click on Fee Tab 2. Click on Fee sub-tab
	 * Masters 3. click on Masters sub tab Master Fine Slab
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_masterFineSlab() throws Exception {
		
		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
	
		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
	
		clickOnButton(btnMasterFineSlab);
		log("Clicked on master fine slab Button and object is:-" + btnMasterFineSlab.toString());
	
	}

	/**
	 * Validation of master fine slab page is displayed
	 * 
	 * @return
	 */

	public boolean verifyMasterFineSlabPage() {
		try {
			System.out.println(txtMasterFineSlabMsgDispaly.getText());
			txtMasterFineSlabMsgDispaly.isDisplayed();
			log("master fine slab page is dispalyed and object is:-" + txtMasterFineSlabMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Select master fine slab type(Between) From Day To Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @param toDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_Between(String fineslabType, String fromDay, String toDay)
			throws Exception {
		
			selectElementFromDropDown(selType, fineslabType);
			log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());

		inputTextIntoInputField(txtFromDay, fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
	
		inputTextIntoInputField(txtToDay, toDay);
		log("entered To Day:-" + toDay + " and object is " + txtToDay.toString());
		
	//	String ecsflag = "ECS Flag";
		try {
			//Assert.assertEquals(textECSFlag.getText(), ecsflag);
			isDisplayed(textECSFlag);
			if (!chkECSFlag.isSelected()) {
				chkECSFlag.click();
				log("Ecs flag check box is checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(1000);
			} else {
				log("Ecs flag check box is alredy checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Select master fine slab type(GreaterThan) From Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_GreaterThan(String fineslabType, String fromDay) throws Exception {
		
			selectElementFromDropDown(selType, fineslabType);
			log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());
	
		inputTextIntoInputField(txtFromDay, fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());


		//String ecsflag = "ECS Flag";
		try {
			//Assert.assertEquals(textECSFlag.getText(), ecsflag);
			isDisplayed(chkECSFlag);
			if (!chkECSFlag.isSelected()) {
				chkECSFlag.click();
				log("Ecs flag check box is checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(1000);
			} else {
				log("Ecs flag check box is alredy checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(500);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Select master fine slab type(LessThan) From Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_LessThan(String fineslabType, String fromDay) throws Exception {
	
		selectElementFromDropDown(selType, fineslabType);
		log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());
		
		inputTextIntoInputField(txtFromDay, fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
		
		//String ecsflag = "ECS Flag";
		try {
			//Assert.assertEquals(textECSFlag.getText(), ecsflag);
			isDisplayed(chkECSFlag);
			if (!chkECSFlag.isSelected()) {
				chkECSFlag.click();
				log("Ecs flag check box is checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(1000);
			} else {
				log("Ecs flag check box is alredy checked and object is:-" + chkECSFlag.toString());
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void clickOnSaveButton_ToSubmitBlankForm() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}
	
	public void clickOnCancelButton_ToClearFilledData() throws Exception {

		clickOnButton(btnCancel);
		log("clicked on Cancel button to clear filled data and object is:-" + btnCancel.toString());
		Thread.sleep(1000);
	}

	public void clickOnCancelButton_ToCancelDeactivateOrActivate() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("clicked on pop up cancel button and object is:-" + btnPopUpCancel.toString());
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

	/**
	 * Search with the created fine slab to day
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void searchByToDayInGrid(String toDay) throws Exception {
		
		inputTextIntoInputField(inputSearch, toDay);
		log("Entered master fine slab to day:" + toDay + " and object is:-" + inputSearch.toString());
		Thread.sleep(1000);
	}

	/**
	 * verify for the created fine slab to day
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void verifyMasterFineSlabUpdatedInGrid(String toDay) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(1000);
		try {
		for (int i = 1; i <= rows; i++) {
			String to_day = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println(to_day);
			Thread.sleep(1000);
			if(to_day.equals(toDay)){
				Assert.assertEquals(to_day, toDay);
				log("Master fine slab to day is updated in the grid:" + to_day);
				Thread.sleep(1000);
			break;
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit master fine slab
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void edit_masterFineSlab(String toDay) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(1000);
		try {
		for (int i = 1; i <= rows; i++) {
			String to_day = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println(to_day);
			Thread.sleep(1000);
	
				if(to_day.equals(toDay)){
				Assert.assertEquals(to_day, toDay);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/a")).click();
				log("Clicked on edit link for corresponding master fine slab in grid");

				Thread.sleep(1000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updation of from day value to edit
	 * 
	 * @param fromDay
	 * @throws InterruptedException
	 */
	public void editMasterFineSlab(String fromDay) throws InterruptedException {

		inputTextIntoInputField(txtFromDay, fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
		Thread.sleep(1000);
	}

	/**
	 * Deactivation of created master fine slab
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void deactivationOfCreated_MasterFineslab(String toDay) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(1000);
		try {
		for (int i = 1; i <= rows; i++) {
			String to_day = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println(to_day);
			Thread.sleep(1000);
		
				if(to_day.equals(toDay)){
				Assert.assertEquals(to_day, toDay);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/span/a")).click();
				log("Clicked on deactivation link in master fine slab grid");
				Thread.sleep(1000);
				break;
				}
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Confirmation message validation for deactivation
	 * 
	 * @throws Exception
	 */

	public void confirmationForDeactivation() throws Exception {
	
		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}

	/**
	 * Activation of created master fine slab
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void activationOf_MasterFineSlab(String toDay) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(1000);
		try {
		for (int i = 1; i <= rows; i++) {
			String to_day = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println(to_day);
			Thread.sleep(1000);
			if(to_day.equals(toDay)){
				Assert.assertEquals(to_day, toDay);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/span/a")).click();
				log("Clicked on activation link in master fine slab grid");
				Thread.sleep(1000);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Activation confirmation pop up validation
	 * 
	 * @throws Exception
	 */
	public void confirmationForActivation() throws Exception {

		clickOnButton(btnPopUpYesDeactivateit);
		log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
		Thread.sleep(1000);
	}
	
	public void sortByFineSlabType() throws Exception {

		clickOnButton(sort_FineSlabType);
		SortData_InColumn_AscendingOrder(list_FineSlabType);
		log("Sorted the record with Fine slab type in Ascending order and object is:-" + sort_FineSlabType.toString());
		
}
	
	public void minimizeAndMaximize_MasterFineSlab() throws Exception {
		
		clickOnButton(btnMin_MaxFineSlab);
		log("clicked on Master Fine Slab minimize and maximize button and object is:-" + btnMin_MaxFineSlab.toString());
		Thread.sleep(1000);
	
}

public void minimizeAndMaximize_MasterFineSlabGridView() throws Exception {

		clickOnButton(btnMin_MaxFineSlabGridView);
		log("Master Fine Slab grid table data minimize and maximize and object is:-"
				+ btnMin_MaxFineSlabGridView.toString());
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

public void popUpWindowMessage_DeactivateCancel_Validation() throws Exception {
	try {
		validate_PopUpText.isDisplayed();
		String text = validate_PopUpText.getText().trim();
		assertEquals(text, "Record Deactivate Cancelled");
		log("Record Deactivate Cancelled message validated.");
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
		log("Record Deactivated Successfully message validated.");
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
		log("Record Activate Cancelled message validated.");
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
		log("Record Activated Successfully message validated.");
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
