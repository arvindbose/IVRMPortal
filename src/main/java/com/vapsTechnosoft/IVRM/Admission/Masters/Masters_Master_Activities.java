/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Activities extends TestBase {

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[4]")
	// WebElement btnMasters_MasterActivities;

	@FindBy(xpath = "//a[@href='#/app/masteractivites/66']")
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
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_ActivityName;


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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Activities(WebDriver driver) {
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

	/**
	 * Navigate to Admission Masters Master Activities Bond
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterActivities_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_MasterActivities);
		log("Clicked on master activity Button and object is:-" + btnMasters_MasterActivities.toString());

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
			log("Master Activities page is dispalyed and object is:-"
					+ txtMasters_MasterActivitiesMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterActivitiesDetailsData(String activityName, String activityDescription) throws Exception {

		inputTextIntoInputField(input_ActivityName, activityName);
		log("Entered Activity name " + activityName + " and object is:-" + input_ActivityName.toString());

		inputTextIntoInputField(input_ActivityDescription, activityDescription);
		log("Entered activity description " + activityDescription + " and object is:-"
				+ input_ActivityDescription.toString());

	}

	public void submitBlankMasterActivitiesForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank Master Activities form and object is:-" + btnSave.toString());
	}

	public void clearMasterActivitiesInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled Master Activities info and object is:-"
				+ btnCancelClear.toString());

	}

	public void saveMasterActivitiesInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Master Activities info and object is:-" + btnSave.toString());

	}

	public void searchWithMasterActivitiesNameInTheGrid(String activityName) {

		inputTextIntoInputField(inputSearch, activityName);
		log("Entered activity name to search: " + activityName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterActivities() throws Exception {

		clickOnButton(btnMin_MaxMasterActivity);
		log("clicked on Master Activities minimize button and object is:-" + btnMin_MaxMasterActivity.toString());

	}

	public void maximizeMasterActivities() throws Exception {

		clickOnButton(btnMin_MaxMasterActivity);
		log("clicked on Master Activities maximize button and object is:-" + btnMin_MaxMasterActivity.toString());

	}

	public void minimizeMasterActivitiesList() throws Exception {

		clickOnButton(btnMin_MaxMasterActivitiesList);
		log("Master Activity list table data minimize and object is:-" + btnMin_MaxMasterActivitiesList.toString());

	}

	public void maximizeMasterActivitiesList() throws Exception {

		clickOnButton(btnMin_MaxMasterActivitiesList);
		log("Master Activity list table data maximized and object is:-" + btnMin_MaxMasterActivitiesList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByActivityName() throws Exception {

		clickOnButton(btnSortByActivityName);
		SortData_InColumn_DescendingOrder(list_ActivityName);
		log("Sorted the record with Activity name in Descending Order and object is:-" + btnSortByActivityName.toString());

	}

	public void editMasterActivities(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String activityname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Activity Name: " + activityname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if(activityname.equals(activityName)){
				assertEquals(activityname, activityName);

				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]")).click();
				Thread.sleep(2000);
				log("Clicked on the edit link in the Master Activities list grid to edit record");

				break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterActivities(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String activityname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Activity Name: " + activityname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (activityname.equals(activityName)) {
					// assertEquals(activityname, activityName);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the Master Activities list grid to delete record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(2000);
	}

	public void verifyMasterActivitiesInTheGrid(String activityName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String activityname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Activity Name: " + activityname);
				// Thread.sleep(2000);
				if (activityname.equals(activityName)) {
					// Assert.assertEquals(activityname, activityName);
					log("Activity name created is updated in the record grid.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_DeleteCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Cancelled");
			log("Record Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_DeleteSuccess_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record Deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
