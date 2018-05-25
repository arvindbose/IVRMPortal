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
 *"Fee Module - Custom Fee Special Head"
 * 
 * TC_F1_263,TC_F1_265,TC_F1_267,TC_F1_268
 * 
 */
public class Masters_Custom_Fee_Special_Head extends TestBase{
	
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
	
	@FindBy(xpath = "//span[contains(text(),'Tuition annual Fee')]/preceding-sibling::input")
	WebElement chk_FeeHead;
	
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
	WebElement btn_YesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btn_PopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_Max_SpecialFeeHead;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_Max_SpecialHeadGridView;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[4]/a")
	WebElement btnSortBy_FeeHead;
	

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
 *  Navigate to custom special fee head
 *  
 * @throws Exception
 */
	public void nevigateToMasters_Custom_Special_FeeHead() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		//waitForElement(driver, 10, btnFee);
		Thread.sleep(1000);
		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		//waitForElement(driver, 10, feeMasters);
		Thread.sleep(1000);
		btnCustomFeeSpecialHead.click();
		log("Clicked on Custom fee special head Button and object is:-" + btnCustomFeeSpecialHead.toString());
		//waitForElement(driver, 10, btnSave);
		Thread.sleep(1000);
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
			log("Custom Special Fee Head page is dispalyed and object is:-" + txtCustomFeeSpecialHeadMsgDispaly.toString());
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
	
	public void enterSpecialFeeHeadAndSelectFeeHead(String specialFeeHead, String feehead) throws Exception{
		
		inputSplFeeHeadName.clear();
		inputSplFeeHeadName.sendKeys(specialFeeHead);
		log("Entered special fee head name:"+specialFeeHead+" and object is:-"+inputSplFeeHeadName.toString());
		Thread.sleep(2000);
		
		inputFeeHeadSearch.sendKeys(feehead);
		log("Entered fee head for search " + feehead + " and object is:-" + inputFeeHeadSearch.toString());
		waitForElement(driver, 10, chkFeeHead);
		String feeHeadselection = chkFeeHead.getText();
		try {
			Assert.assertEquals(feeHeadselection, feehead);
		} catch (Exception e) {
			log("Fee head for selection  is not matched");
		}
		if (!chkboxSelectionFeeHead.isSelected()) {

			chkboxSelectionFeeHead.click();
			log("Fee head check box is selected for the specific group");
		} else {
			log("Fee head Check box is already selected");
		}
	}
	
	/**
	 * Click on save button to save the custom special fee head input value
	 * 
	 * @throws Exception
	 */
		public void clickOnSaveButton() throws Exception {
			btnSave.click();
			log("clicked on save button and object is:-" + btnSave.toString());
			Thread.sleep(2000);
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
			btnOkonSuccess.click();
			log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
			Thread.sleep(3000);
		}

		/**
		 * Search with the created custom special fee head name
		 * 
		 * @param specialFeeHead
		 * @throws Exception
		 */
		public void searchBySpLFeeHeadNameInGrid(String specialfeehead) throws Exception {
			if(inputSearch.isDisplayed()){
			inputSearch.clear();
			inputSearch.sendKeys(specialfeehead);
			log("Entered custom special fee head name:" + specialfeehead + " and object is:-" + inputSearch.getText().toString());
			Thread.sleep(1000);
			}
			else{
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
					String customSPLFeeHead = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
					Thread.sleep(2000);
					
					try{
						Assert.assertEquals(customSPLFeeHead, specialFeeHead);
						log("Custom speceal fee head name is update in the grid:" + customSPLFeeHead);
						Thread.sleep(2000);
					}
					catch (Exception e) {
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
					String customSPLFeeHead = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
				
					Thread.sleep(2000);
					
					try {
					Assert.assertEquals(customSPLFeeHead, specialFeeHead);
						driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/a"))
								.click();
						log("Clicked on edit link for corresponding special Fee Head name in grid");

						Thread.sleep(2000);
					} catch (Exception e) {
						log("Edit link is not clicked for editing of custom special fee head");
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
					String customSPLFeeHead = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
					Thread.sleep(2000);
					
					try {
						Assert.assertEquals(customSPLFeeHead, specialFeeHead);
						driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"))
								.click();
						log("Clicked on deactivation link in custom special Fee Head grid");

						Thread.sleep(2000);
					} catch (Exception e) {
						log("Deactivation link is not available for the custom special fee head");
					}
					
				}
			}
			
			/**
			 * Confirmation message validation for deactivation
			 * 
			 * @throws Exception
			 */
			
			public void confirmationForDeactivation() throws Exception {
				btnPopUpYesDeactivateit.click();
				log("Clicked Yes Deactivate it button and object is:" + btnPopUpYesDeactivateit.toString());
				Thread.sleep(5000);
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
						String customSPLFeeHead = driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[3]")).getText();
						Thread.sleep(2000);
						
						try {
							Assert.assertEquals(customSPLFeeHead, specialFeeHead);
							driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[5]/span"))
									.click();
							log("Clicked on activation link in Custom special Fee Head name grid");

							Thread.sleep(2000);
						} catch (Exception e) {
							log("Activation link is not available in the custom special fee head");
						}
					}
				}

				/**
				 * Activation confirmation pop up validation
				 * 
				 * @throws Exception
				 */
				public void confirmationForActivation() throws Exception {
					btnPopUpYesDeactivateit.click();
					log("Clicked on Yes activate it button and object is:" + btnPopUpYesDeactivateit.toString());
					Thread.sleep(5000);
				}
			
}
