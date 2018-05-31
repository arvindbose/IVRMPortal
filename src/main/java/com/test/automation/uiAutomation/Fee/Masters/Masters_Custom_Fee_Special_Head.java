/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author Arvind
 *
 *         "Fee Module - Custom Fee Special Head"
 * 
 *         TC_F1_263,TC_F1_265,TC_F1_267,TC_F1_268
 * 
 */
public class Masters_Custom_Fee_Special_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Custom_Fee_Special_Head.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[5]")
	WebElement btnCustomFeeSpecialHead;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtCustomFeeSpecialHeadMsgDispaly;

	@FindBy(xpath = "//label[contains(text(),'Special Fee Head Name :')]/following-sibling::div/input")
	WebElement input_SplFeeHeadName;

	@FindBy(xpath = "//label[contains(text(),'Fee Head :')]/following-sibling::div/input")
	WebElement input_FeeHeadSearch;

	@FindBy(xpath = "//span[contains(text(),'Annual Fees')]")
	WebElement chk_FeeHeadText;

	@FindBy(xpath = "//span[contains(text(),'Annual Fees')]/preceding-sibling::input")
	WebElement chk_boxSelectionFeeHead;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//div[@class='input-group']/span/following-sibling::input")
	WebElement input_Search;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btn_OkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_Max_SpecialFeeHead;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_Max_SpecialHeadGridView;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[4]/a")
	WebElement btnSortBy_FeeHead;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	public Masters_Custom_Fee_Special_Head(WebDriver driver) {
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

	/**
	 * Navigate to custom special fee head
	 * 
	 * @throws Exception
	 */
	public void navigateToMasters_Custom_Special_FeeHead() throws Exception {
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
		if (btnCustomFeeSpecialHead.isDisplayed()) {
			btnCustomFeeSpecialHead.click();
			log("Clicked on Custom Fee Special Head Button and object is:-" + btnCustomFeeSpecialHead.toString());
			Thread.sleep(5000);
		} else {
			log("Fee Installment Navigation element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of custom special fee head screen message
	 * 
	 * @return
	 */
	public boolean verifyCustomSpecialFeeHeadPage() {
		try {
			System.out.println(txtCustomFeeSpecialHeadMsgDispaly.getText());
			txtCustomFeeSpecialHeadMsgDispaly.isDisplayed();
			log("Custom Special Fee Head page is dispalyed and object is:-"
					+ txtCustomFeeSpecialHeadMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter Special fee head name and select Fee head
	 * 
	 * @param specialFeeHead
	 * @param feehead
	 * @throws Exception
	 */

	public void fill_CustomSpecialFeeHeadForm(String specialFeeHead, String feehead) throws Exception {
		if (input_SplFeeHeadName.isDisplayed()) {
			input_SplFeeHeadName.clear();
			input_SplFeeHeadName.sendKeys(specialFeeHead);
			log("Entered special fee head name:" + specialFeeHead + " and object is:-"
					+ input_SplFeeHeadName.toString());
			Thread.sleep(1000);
		} else {
			log("Special Fee Head Name element not present.");
			Thread.sleep(500);
		}
		if (input_FeeHeadSearch.isDisplayed()) {
			input_FeeHeadSearch.clear();
			input_FeeHeadSearch.sendKeys(feehead);
			log("Entered fee head for search " + feehead + " and object is:-" + input_FeeHeadSearch.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head Search element not present.");
			Thread.sleep(500);
		}
		String feeHeadselection = chk_FeeHeadText.getText().trim();
		try {
			Assert.assertEquals(feeHeadselection, feehead);
		} catch (Exception e) {
			log("Fee head for selection  is not matched");
		}
		if (!chk_boxSelectionFeeHead.isSelected()) {

			chk_boxSelectionFeeHead.click();
			log("Fee head check box is selected for the specific group");
		} else {
			log("Fee head Check box is already selected");
		}
	}
	
	public void clickOnCancelButton_ClearFilledForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("clicked on cancel button and object is:-" + btn_Cancel.toString());
			Thread.sleep(7000);
		} else {
			log("Cancel Button element is not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Click on save button to save the custom special fee head input value
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button and object is:-" + btn_Save.toString());
			Thread.sleep(7000);
		} else {
			log("Save Button element is not present");
			Thread.sleep(500);
		}
	}

	/**
	 * validation of Record saved successfully message
	 * 
	 * @return
	 */
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

	/**
	 * click on OK button after Saving the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btn_OkonSuccess.isDisplayed()) {
			btn_OkonSuccess.click();
			log("clicked on OK button and object is:-" + btn_OkonSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK Button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void searchBySpLFeeHeadNameInGrid(String specialfeehead) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(specialfeehead);
			log("Entered custom special fee head name:" + specialfeehead + " and object is:-"
					+ input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * verify for the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void verifyCustomSPLFeeHeadupdatedInGrid(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customSPLFeeHead = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
			Thread.sleep(2000);

			try {
				Assert.assertEquals(customSPLFeeHead, specialFeeHead);
				log("Custom speceal fee head name is update in the grid:" + customSPLFeeHead);
				Thread.sleep(2000);
			} catch (Exception e) {
				log("Custom Special fee head is not updated in the grid.");
			}

		}
	}

	/**
	 * Edit custom Special fee head name created
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void edit_CustomSplFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customSPLFeeHead = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();

			Thread.sleep(2000);

			try {
				Assert.assertEquals(customSPLFeeHead, specialFeeHead);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/a")).click();
				log("Clicked on edit link for corresponding special Fee Head name in grid");

				Thread.sleep(1000);
			} catch (Exception e) {
				log("Edit link is not clicked for editing of custom special fee head");
				Thread.sleep(500);
			}

		}
	}

	/**
	 * Deactivation of created custom special Fee Head name
	 * 
	 * @param specialFeeHead
	 * @throws Exception
	 */
	public void deactivationOfCreatedCustomSPLFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customSPLFeeHead = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			Thread.sleep(2000);

			try {
				Assert.assertEquals(customSPLFeeHead, specialFeeHead);
				WebElement deactiveLink = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"));
				String deactivetext = deactiveLink.getText().trim();
				Assert.assertEquals("Deactivate", deactivetext);

				deactiveLink.click();
				log("Clicked on deactivation link in custom special Fee Head grid");

				Thread.sleep(2000);
			} catch (Exception e) {
				log("Deactivation link is not available for the custom special fee head");
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
	 * Activation of created custom group
	 * 
	 * @param customGroupName
	 * @throws Exception
	 */
	public void activationOfCreatedCustomSPLFeeHead(String specialFeeHead) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String customSPLFeeHead = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
			Thread.sleep(2000);

			try {
				Assert.assertEquals(customSPLFeeHead, specialFeeHead);
				WebElement activeLink = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"));
				String activatext = activeLink.getText().trim();
				Assert.assertEquals("Activate", activatext);
				activeLink.click();
				log("Clicked on activation link in Custom special Fee Head name grid");
				Thread.sleep(2000);
			} catch (Exception e) {
				log("Activation link is not available in the custom special fee head");
			}
		}
	}
	public void minimizeAndMaximize_SpecialFeeHead() throws Exception {
		if (btnMin_Max_SpecialFeeHead.isDisplayed()) {
			btnMin_Max_SpecialFeeHead.click();
			log("clicked on Special Fee Head minimize and maximize button and object is:-"
					+ btnMin_Max_SpecialFeeHead.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Special Fee Head button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_SpecialHeadGridView() throws Exception {
		if (btnMin_Max_SpecialHeadGridView.isDisplayed()) {
			btnMin_Max_SpecialHeadGridView.click();
			log("Special Head grid table data minimize and maximize and object is:-"
					+ btnMin_Max_SpecialHeadGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Special Head grid button element not present.");
			Thread.sleep(500);
		}
	}
	public void sortByFeeHead() throws Exception {
		if (btnSortBy_FeeHead.isDisplayed()) {
			btnSortBy_FeeHead.click();
			log("Sorted the record with Fee Head and object is:-" + btnSortBy_FeeHead.toString());
			Thread.sleep(2000);
		} else {
			log("Sort element not present.");
			Thread.sleep(500);
		}
	}
}
