/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Fee_Head.class.getName());

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
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[10]")
	// WebElement btn_FeeHead;

	@FindBy(xpath = "//a[@href='#/app/FeeHead/80']")
	WebElement btn_FeeHead;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeHeadDispaly;

	@FindBy(xpath = "//label[contains(text(),'Fee Head:')]/following-sibling::div/input")
	WebElement Input_FeeHeadName;

	@FindBy(xpath = "//label[contains(text(),'Fee Head Type:')]/following-sibling::div/select")
	WebElement sel_FeeHeadType;

	@FindBy(xpath = "//span[contains(text(),'Special Fee Head')]/preceding-sibling::input")
	WebElement chk_SpecialFeeHead;

	@FindBy(xpath = "//span[contains(text(),'PDA Expense')]/preceding-sibling::input")
	WebElement chk_PdaExpences;

	@FindBy(xpath = "//span[contains(text(),'Refundable')]/preceding-sibling::input")
	WebElement chk_Refundable;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Set  order')]/parent::button")
	WebElement btn_SetOrder;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement btn_SetOrder_Save;

	@FindBy(xpath = "(//button[contains(text(),'Close')])[1]")
	WebElement btn_SetOrder_Close;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//div[@class='input-group']/span/following-sibling::input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxFeeHead;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxFeeMasterHeadGridView;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByFeeHead;

	public Masters_Fee_Head(WebDriver driver) {
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

	public void nevigateToMasters_FeeHead() throws Exception {

		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeMasters);
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());

		clickOnButton(btn_FeeHead);
		log("Clicked on Fee Head Button and object is:-" + btn_FeeHead.toString());

	}

	public boolean verifyFeeHeadPage() {
		try {
			System.out.println(txtFeeHeadDispaly.getText());
			txtFeeHeadDispaly.isDisplayed();
			log("Fee Head page is dispalyed and object is:-" + txtFeeHeadDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fill_FeeHead_Form(String feeHeadName, String feeHeadType) throws Exception {

		inputTextIntoInputField(Input_FeeHeadName, feeHeadName);
		log("Entered Fee Head name:-" + feeHeadName + " and object is " + Input_FeeHeadName.toString());

		selectElementFromDropDown(sel_FeeHeadType, feeHeadType);
		log("selected Fee Head Type: " + feeHeadType + " and object is:- " + sel_FeeHeadType.toString());

	}

	public void select_SpecialFeeHead_CheckBox() throws Exception {
		isDisplayed(chk_SpecialFeeHead);
		if (!chk_SpecialFeeHead.isSelected()) {
			chk_SpecialFeeHead.click();
			log("Special Fee Head check box is checked and object is:-" + chk_SpecialFeeHead.toString());
			Thread.sleep(1000);
		} else {
			log("Special fee head check box already selected.");
			Thread.sleep(500);
		}
	}

	public void select_PDAExpense_CheckBox() throws Exception {
		isDisplayed(chk_PdaExpences);
		if (!chk_PdaExpences.isSelected()) {
			chk_PdaExpences.click();
			log("PDA Expense check box is checked and object is:-" + chk_PdaExpences.toString());
			Thread.sleep(5000);
		} else {
			log("PDA Expense check box already selected.");
			Thread.sleep(500);
		}
	}

	public void select_Refundable_CheckBox() throws Exception {
		isDisplayed(chk_Refundable);
		if (!chk_Refundable.isSelected()) {
			chk_Refundable.click();
			log("Refundable check box is checked and object is:-" + chk_Refundable.toString());
			Thread.sleep(1000);
		} else {
			log("Refundable check box already selected.");
			Thread.sleep(500);
		}
	}

	public void clickOnSaveButton_FeeHead() throws Exception {
		try {
			if (btn_Save.isDisplayed()) {
				// btn_Save.click();
				// JavascriptExecutor executor = (JavascriptExecutor)driver;
				// executor.executeScript("arguments[0].click();", btn_Save);
				Actions builder = new Actions(driver);
				builder.moveToElement(btn_Save).click(btn_Save);
				builder.perform();

				log("clicked on save button and object is:-" + btn_Save.toString());
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Save Button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_FeeHead() throws Exception {

		clickOnButton(btn_Cancel);
		log("clicked on Cancel button and object is:-" + btn_Cancel.toString());
		Thread.sleep(1000);

	}

	public void clickOnSetOrderButton_FeeHead() throws Exception {

		clickOnButton(btn_SetOrder);
		log("clicked on Set Order button and object is:-" + btn_SetOrder.toString());
		Thread.sleep(1000);

	}

	public void clickOn_Save_SetOrder_FeeHead() throws Exception {

		clickOnButton(btn_SetOrder_Save);
		log("clicked on Set Order Save button and object is:-" + btn_SetOrder_Save.toString());
		Thread.sleep(1000);

	}

	public void clickOn_Close_SetOrder_FeeHead() throws Exception {

		clickOnButton(btn_SetOrder_Close);
		log("clicked on Set Order close button and object is:-" + btn_SetOrder_Close.toString());
		Thread.sleep(1000);

	}

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(1000);

	}

	/**
	 * Search with the created Fee Head
	 * 
	 * @param feeHead
	 * @throws Exception
	 */

	public void searchBy_FeeHead_NameInGrid(String feeHead) throws Exception {

		inputTextIntoInputField(input_Search, feeHead);
		log("Entered  Fee Head name for search:" + feeHead + " and object is:-" + input_Search.toString());

	}

	/**
	 * verify for the created fee Head
	 * 
	 * @param feeHead
	 * @throws Exception
	 */
	public void verifyFeeHead_UpdatedInGrid(String feeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String feehead = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Created Fee Head " + feehead);
				Thread.sleep(2000);
				if (feehead.equals(feeHead)) {
					Assert.assertEquals(feehead, feeHead);
					log("Fee Head name is update in the grid:" + feehead);
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit Master fee Head name created
	 * 
	 * @param feeHead
	 * @throws Exception
	 */
	public void edit_FeeHead_updatedInGrid(String feeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String feehead = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Created Fee head " + feehead);
				Thread.sleep(2000);

				if (feehead.equals(feeHead)) {
					Assert.assertEquals(feehead, feeHead);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]/a")).click();
					log("Clicked on edit link for corresponding Fee head name in grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * De-activation of created Master Fee head
	 * 
	 * @param feeHead
	 * @throws Exception
	 */
	public void deactivationOfCreated_FeeHead(String feeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String feehead = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Created Fee Head " + feehead);
				Thread.sleep(2000);

				if (feehead.equals(feeHead)) {
					Assert.assertEquals(feehead, feeHead);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]/span"))
							.click();
					log("Clicked on deactivation link in Master fee head grid");
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
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes deactivate or activate or delete it button and object is:-"
					+ btnYesDeleteOrDeactIt.toString());
			Thread.sleep(10000);
		} else {
			log("Yes Activate/Deactivate button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_PopUp() throws Exception {
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
	 * Activation of created Master fee head
	 * 
	 * @param feeHead
	 * @throws Exception
	 */
	public void activationOfCreated_FeeHead(String feeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String feehead = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Created Fee Head " + feehead);
				Thread.sleep(2000);

				if (feehead.equals(feeHead)) {
					Assert.assertEquals(feehead, feeHead);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]/span"))
							.click();
					log("Clicked on activation link in Master fee head in grid");
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void minimizeAndMaximize_FeeHead() throws Exception {
		if (btnMin_MaxFeeHead.isDisplayed()) {
			btnMin_MaxFeeHead.click();
			log("clicked on Fee Head minimize and maximize button and object is:-" + btnMin_MaxFeeHead.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Fee Head button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_FeeMasterHeadGridView() throws Exception {
		if (btnMin_MaxFeeMasterHeadGridView.isDisplayed()) {
			btnMin_MaxFeeMasterHeadGridView.click();
			log("Fee Master Head grid table data minimize and maximize and object is:-"
					+ btnMin_MaxFeeMasterHeadGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Fee Master Head grid button element not present.");
			Thread.sleep(500);
		}
	}

	public void sortByFeeHeadName() throws Exception {
		if (btnSortByFeeHead.isDisplayed()) {
			btnSortByFeeHead.click();
			log("Sorted the record with Fee Head name and object is:-" + btnSortByFeeHead.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}
}
