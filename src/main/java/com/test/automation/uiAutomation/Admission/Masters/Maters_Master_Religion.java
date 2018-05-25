/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Maters_Master_Religion extends TestBase{
	
	public static final Logger log = Logger.getLogger(Maters_Master_Religion.class.getName());

	WebDriver driver;
	

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[3]")
	WebElement btnMasters_masterReligion;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterReligionMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancel;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_ReligionName;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
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


	public Maters_Master_Religion(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Religion
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterReligion_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterReligion);

		btnMasters_masterReligion.click();
		log("Clicked on master Religion Button and object is:-" + btnMasters_masterReligion.toString());
		waitForElement(driver, 10, btnSave);
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

		btnSave.click();
		log("Save blank master Religion form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public void enterMasterReligionFormData(String religionName) throws Exception {

		input_ReligionName.clear();
		input_ReligionName.sendKeys(religionName);
		log("Entered Religion name: " + religionName + " and object is:-" + input_ReligionName.toString());

		

	}

	public void clearReligionInfoData() throws Exception {
		btnCancel.click();
		log("Clicked on cancel button to clear filled master Religion and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}

	public void submitFilledMasterReligionForm() throws Exception {

		btnSave.click();
		log("Save filled master Religion form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void sortByReligionName() throws Exception {

		btnSortByReligionName.click();
		log("Sorted the record with Religion name and object is:-" + btnSortByReligionName.toString());
		Thread.sleep(3000);
	}

	public void searchWithReligionNameInTheGrid(String religionName) {

		inputSearch.clear();
		inputSearch.sendKeys(religionName);
		log("Entered Religion name to search: " + religionName + " and object is:-" + inputSearch.toString());
	}

	public void verifyReligionNameInTheGrid(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String religionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Religion Name: " + religionname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(religionname, religionName);
				log("Religion name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeMasterReligion() throws Exception {
		btnMin_MaxMasterReligion.click();
		log("clicked on master Religion minimize button and object is:-" + btnMin_MaxMasterReligion.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterReligion() throws Exception {
		btnMin_MaxMasterReligion.click();
		log("clicked on master Religion maximize button and object is:-" + btnMin_MaxMasterReligion.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterReligionList() throws Exception {

		btnMin_MaxMasterReligionList.click();
		log("Master Religion list table data minimize and object is:-" + btnMin_MaxMasterReligionList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterReligionList() throws Exception {

		btnMin_MaxMasterReligionList.click();
		log("Master Religion list table table data maximized and object is:-"
				+ btnMin_MaxMasterReligionList.toString());
		Thread.sleep(2000);
	}

	public void editMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String religionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Religion Name: " + religionname);
			// Thread.sleep(2000);
			try {
				if (religionname.equalsIgnoreCase(religionName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a")).click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master Religion list grid to edit record");

					break;
				} else {
					log("Religion Name not matched with the master Religion list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String religionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Religion Name: " + religionname);
			// Thread.sleep(2000);
			try {
				if (religionname.equalsIgnoreCase(religionName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master Religion list grid");

					break;
				} else {
					log("Religion Name not matched with the master Religion list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterReligion(String religionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String religionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Religion Name: " + religionname);
			// Thread.sleep(2000);
			try {
				if (religionname.equalsIgnoreCase(religionName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/span"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals(activetext, "Activate");

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master Religion list grid");

					break;
				} else {
					log("Religion Name not matched with the master Religion list grid");
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

		btnPopUpCancel.click();
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(15000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

}
	

