/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Maters_Master_Religion extends TestBase {

	public static final Logger log = Logger.getLogger(Maters_Master_Religion.class.getName());

	WebDriver driver;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[3]")
	// WebElement btnMasters_masterReligion;

	@FindBy(xpath = "//a[@href='#/app/masterreligion/74']")
	WebElement btnMasters_masterReligion;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterReligionMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "//input[@name='name']")
	WebElement input_ReligionName;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterReligion;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterReligionList;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByReligionName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Maters_Master_Religion(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Religion
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterReligion_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterReligion);
		log("Clicked on master Religion Button and object is:-" + btnMasters_masterReligion.toString());

	}

	/**
	 * Validation of masters master Religion screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterReligion_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterReligionMsgDispaly.getText());
			txtMasters_MasterReligionMsgDispaly.isDisplayed();
			log("Master Religion page is dispalyed and object is:-" + txtMasters_MasterReligionMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankMasterReligionForm() throws Exception {

		clickOnButton(btnSave);
		log("Save blank master Religion form and object is:-" + btnSave.toString());

	}

	public void enterMasterReligionFormData(String religionName) throws Exception {

		inputTextIntoInputField(input_ReligionName, religionName);
		log("Entered Religion name: " + religionName + " and object is:-" + input_ReligionName.toString());
	}

	public void clearReligionInfoData() throws Exception {

		clickOnButton(btnCancel);
		log("Clicked on cancel button to clear filled master Religion and object is:-" + btnCancel.toString());

	}

	public void submitFilledMasterReligionForm() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Save filled master Religion form and object is:-" + btnSave.toString());

	}

	public void sortByReligionName() throws Exception {

		clickOnButton(btnSortByReligionName);
		log("Sorted the record with Religion name and object is:-" + btnSortByReligionName.toString());

	}

	public void searchWithReligionNameInTheGrid(String religionName) throws Exception {

		inputTextIntoInputField(inputSearch, religionName);
		log("Entered Religion name to search: " + religionName + " and object is:-" + inputSearch.toString());

	}

	public void verifyReligionNameInTheGrid(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String religionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Religion Name: " + religionname);
				// Thread.sleep(2000);

				if (religionname.equals(religionName)) {
					// Assert.assertEquals(religionname, religionName);
					log("Religion name created is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeMasterReligion() throws Exception {

		clickOnButton(btnMin_MaxMasterReligion);
		log("clicked on master Religion minimize button and object is:-" + btnMin_MaxMasterReligion.toString());

	}

	public void maximizeMasterReligion() throws Exception {

		clickOnButton(btnMin_MaxMasterReligion);
		log("clicked on master Religion maximize button and object is:-" + btnMin_MaxMasterReligion.toString());

	}

	public void minimizeMasterReligionList() throws Exception {

		clickOnButton(btnMin_MaxMasterReligionList);
		log("Master Religion list table data minimize and object is:-" + btnMin_MaxMasterReligionList.toString());

	}

	public void maximizeMasterReligionList() throws Exception {

		clickOnButton(btnMin_MaxMasterReligionList);
		log("Master Religion list table table data maximized and object is:-"
				+ btnMin_MaxMasterReligionList.toString());

	}

	public void editMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String religionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Religion Name: " + religionname);
				// Thread.sleep(2000);

				if (religionname.equalsIgnoreCase(religionName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a")).click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master Religion list grid to edit record");

					break;
				} 
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String religionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Religion Name: " + religionname);
				// Thread.sleep(2000);

				if (religionname.equalsIgnoreCase(religionName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master Religion list grid");

					break;
				} 
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			
				String religionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Religion Name: " + religionname);
				// Thread.sleep(2000);

				if (religionname.equalsIgnoreCase(religionName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/span"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals(activetext, "Activate");

					activeLink.click();
					Thread.sleep(2000);
					log("Clicked on the activate link in the master Religion list grid");

					break;
				} 

		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnPopUpCancel);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

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

	public void popWindowMessage_DeactivatedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Religion Deactivated Successfully");
			log("Record Deactivated sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_ActivatedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Religion Activated Successfully");
			log("Record Activated sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
