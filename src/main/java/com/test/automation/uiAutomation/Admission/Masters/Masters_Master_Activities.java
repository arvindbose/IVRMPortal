/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

import java.awt.Robot;
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

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Activities extends TestBase{
	
	public static final Logger log = Logger.getLogger(Masters_Master_Activities.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[4]")
	WebElement btnMasters_MasterActivities;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterActivitiesMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_ActivityName;

	@FindBy(xpath = "//textarea[@name='act_des']")
	WebElement input_ActivityDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByActivityName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterActivity;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterActivitiesList;
	
	
	public Masters_Master_Activities(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Activities Bond
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterActivities_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_MasterActivities);

		btnMasters_MasterActivities.click();
		log("Clicked on master activity Button and object is:-" + btnMasters_MasterActivities.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters Master Activities screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterActivities_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterActivitiesMsgDispaly.getText());
			txtMasters_MasterActivitiesMsgDispaly.isDisplayed();
			log("Master Activities page is dispalyed and object is:-" + txtMasters_MasterActivitiesMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterActivitiesDetailsData(String activityName, String activityDescription) {

		input_ActivityName.clear();
		input_ActivityName.sendKeys(activityName);
		log("Entered Activity name " + activityName + " and object is:-" + input_ActivityName.toString());

		input_ActivityDescription.clear();
		input_ActivityDescription.sendKeys(activityDescription);
		log("Entered activity description " + activityDescription + " and object is:-" + input_ActivityDescription.toString());

	}

	public void submitBlankMasterActivitiesForm() throws Exception {

		btnSave.click();
		log("Submit blank Master Activities form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void clearMasterActivitiesInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Master Activities info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveMasterActivitiesInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Master Activities info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void searchWithMasterActivitiesNameInTheGrid(String activityName) {

		inputSearch.clear();
		inputSearch.sendKeys(activityName);
		log("Entered activity name to search: " + activityName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterActivities() throws Exception {
		btnMin_MaxMasterActivity.click();
		log("clicked on Master Activities minimize button and object is:-" + btnMin_MaxMasterActivity.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterActivities() throws Exception {
		btnMin_MaxMasterActivity.click();
		log("clicked on Master Activities maximize button and object is:-" + btnMin_MaxMasterActivity.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterActivitiesList() throws Exception {

		btnMin_MaxMasterActivitiesList.click();
		log("Master Activity list table data minimize and object is:-" + btnMin_MaxMasterActivitiesList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterActivitiesList() throws Exception {

		btnMin_MaxMasterActivitiesList.click();
		log("Master Activity list table data maximized and object is:-" + btnMin_MaxMasterActivitiesList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByActivityName() throws Exception {
		btnSortByActivityName.click();
		log("Sorted the record with Activity name and object is:-" + btnSortByActivityName.toString());
		Thread.sleep(3000);
	}

	public void editMasterActivities(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String activityname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Activity Name: " + activityname);
			// Thread.sleep(2000);
			try {
				if (activityname.equalsIgnoreCase(activityName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the Master Activities list grid to edit record");

					break;
				} else {
					log("Activity Name not matched with the Master Activities list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteMasterActivities(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String activityname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Activity Name: " + activityname);
			// Thread.sleep(2000);
			try {
				if (activityname.equalsIgnoreCase(activityName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the Master Activities list grid to delete record");

					break;
				} else {
					log("Activity Name not matched with the Master Activities list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}

	public void clickOnCancelButton() throws Exception {

		btnCancel.click();
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}

	public void verifyMasterActivitiesInTheGrid(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String activityname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Activity Name: " + activityname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(activityname, activityName);
				log("Activity name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}


}
