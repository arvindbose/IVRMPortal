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
 * @author vaps
 *
 */
public class Masters_Master_Fine_Slab_Without_ECSFlag extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Fine_Slab_Without_ECSFlag.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[11]")
	WebElement btnMasterFineSlab;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasterFineSlabMsgDispaly;

	@FindBy(xpath = "//div[@class='col-sm-8']/select")
	WebElement selType;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[1]")
	WebElement txtFromDay;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[2]")
	WebElement txtToDay;

	@FindBy(xpath = "//div[@class='well text-center']/label/input")
	WebElement chkECSFlag;

	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputSearch;
	
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeactivateit;
	
	
	

	public Masters_Master_Fine_Slab_Without_ECSFlag(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			return true;

		} catch (Exception e) {
			return false;
		}

	}
/**
 * Navigate to master fine slab
 * 1. Click on Fee Tab
 * 2. Click on Fee sub-tab Masters
 * 3. click on Masters sub tab Master Fine Slab
 * 
 * @throws Exception
 */
	public void navigateToMasters_masterFineSlab() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);

		btnMasterFineSlab.click();
		log("Clicked on master fine slab Button and object is:-" + btnMasterFineSlab.toString());
		Thread.sleep(1000);
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
	 * Select master fine slab type(Between)
	 * From Day
	 * To Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @param toDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_Between(String fineslabType, String fromDay, String toDay)
			throws Exception {

		Select select = new Select(selType);
		select.selectByVisibleText(fineslabType);
		log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());
		waitForElement(driver, 10, txtFromDay);

		txtFromDay.sendKeys(fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
		Thread.sleep(1000);

		txtToDay.sendKeys(toDay);
		log("entered To Day:-" + toDay + " and object is " + txtToDay.toString());
		Thread.sleep(1000);

	}
	/**
	 * Select master fine slab type(GreaterThan)
	 * From Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_GreaterThan(String fineslabType, String fromDay) throws Exception {

		Select select = new Select(selType);
		select.selectByVisibleText(fineslabType);
		log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());
		waitForElement(driver, 10, txtFromDay);

		txtFromDay.sendKeys(fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
		Thread.sleep(1000);

	}
	/**
	 * Select master fine slab type(LessThan)
	 * From Day
	 * 
	 * @param fineslabType
	 * @param fromDay
	 * @throws Exception
	 */

	public void mastersFineSlabTypeFromDayAndToDay_LessThan(String fineslabType, String fromDay) throws Exception {

		Select select = new Select(selType);
		select.selectByVisibleText(fineslabType);
		log("selected fine slab  type:-" + fineslabType + " and object is " + selType.toString());
		waitForElement(driver, 10, txtFromDay);

		txtFromDay.sendKeys(fromDay);
		log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
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

	/**
	 * Search with the created fine slab to day
	 * 
	 * @param toDay
	 * @throws Exception
	 */
	public void searchByToDayInGrid(String toDay) throws Exception {
		inputSearch.clear();
		inputSearch.sendKeys(toDay);
		log("Entered master fine slab to day:" + toDay + " and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
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
			Thread.sleep(2000);
			for (int i = 1; i <= rows; i++) {
				String to_day = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
				System.out.println(to_day);
				Thread.sleep(2000);
				try {
					Assert.assertEquals(to_day, toDay);
					log("Master fine slab to day is updated in the grid:" + to_day);
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
			Thread.sleep(2000);
			for (int i = 1; i <= rows; i++) {
				String to_day = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
				System.out.println(to_day);
				Thread.sleep(2000);
				try {
					Assert.assertEquals(to_day, toDay);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/a"))
							.click();
					log("Clicked on edit link for corresponding master fine slab in grid");

					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * Updation of from day value to edit
		 * 
		 * @param fromDay
		 * @throws InterruptedException
		 */
		public void editMasterFineSlab(String fromDay) throws InterruptedException{
			
			txtFromDay.clear();
			Thread.sleep(1000);
			txtFromDay.sendKeys(fromDay);
			log("entered From Day:-" + fromDay + " and object is " + txtFromDay.toString());
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			for (int i = 1; i <= rows; i++) {
				String to_day = driver
						.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
				System.out.println(to_day);
				Thread.sleep(2000);
				try {
					Assert.assertEquals(to_day, toDay);
					driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/span"))
							.click();
					log("Clicked on deactivation link in master fine slab grid");

					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
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
		 * Activation of created master fine slab
		 * 
		 * @param toDay
		 * @throws Exception
		 */
			public void activationOf_MasterFineSlab(String toDay) throws Exception {

				int rows = tblRows.size();
				System.out.println(rows);
				Thread.sleep(2000);
				for (int i = 1; i <= rows; i++) {
					String to_day = driver
							.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
					System.out.println(to_day);
					Thread.sleep(2000);
					try {
						Assert.assertEquals(to_day, toDay);
						driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[6]/span"))
								.click();
						log("Clicked on activation link in master fine slab grid");

						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
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
