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
public class Masters_Master_Source extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Source.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[7]")
	// WebElement btnMasters_masterSource;

	@FindBy(xpath = "//a[@href='#/app/source/18']")
	WebElement btnMasters_masterSource;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterSourceMsgDispaly;

	@FindBy(xpath = "//input[@id='fname' and @name='sname']")
	WebElement input_SourceName;

	@FindBy(xpath = "//textarea[@id='comment' and @name='dsource']")
	WebElement input_SourceDiscription;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortBySourceName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterSource;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterSourceList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Source(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterSource_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterSource);
		log("Clicked on master source Button and object is:-" + btnMasters_masterSource.toString());

	}

	/**
	 * Validation of masters master source screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterSource_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterSourceMsgDispaly.getText());
			txtMasters_MasterSourceMsgDispaly.isDisplayed();
			log("Master Source page is dispalyed and object is:-" + txtMasters_MasterSourceMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterSourceDetailsData(String sourceName, String sourceDiscription) throws Exception {

		inputTextIntoInputField(input_SourceName, sourceName);
		log("Entered source name " + sourceName + " and object is:-" + input_SourceName.toString());

		inputTextIntoInputField(input_SourceDiscription, sourceDiscription);
		log("Entered source discription " + sourceDiscription + " and object is:-"
				+ input_SourceDiscription.toString());

	}

	public void submitBlankMasterSourceForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank Master Source form and object is:-" + btnSave.toString());

	}

	public void clearSourceInfoData() throws Exception {

		clickOnButton(btnClear);
		log("Clicked on clear button to clear filled source info and object is:-" + btnClear.toString());

	}

	public void saveSourceInfoData() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled source info and object is:-" + btnSave.toString());

	}

	public void searchWithSourceNameInTheGrid(String sourceName) {

		inputTextIntoInputField(inputSearch, sourceName);
		log("Enterd source name to search: " + sourceName + " and object is:-" + inputSearch.toString());
	}

	public void minimizeMasterSource() throws Exception {

		clickOnButton(btnMin_MaxMasterSource);
		log("clicked on master source minimize button and object is:-" + btnMin_MaxMasterSource.toString());

	}

	public void maximizeMasterSource() throws Exception {

		clickOnButton(btnMin_MaxMasterSource);
		log("clicked on master sorce maximize button and object is:-" + btnMin_MaxMasterSource.toString());

	}

	public void minimizeMasterSourceList() throws Exception {

		clickOnButton(btnMin_MaxMasterSourceList);
		log("Master source list table data minimize and object is:-" + btnMin_MaxMasterSourceList.toString());

	}

	public void maximizeMasterSourceList() throws Exception {

		clickOnButton(btnMin_MaxMasterSourceList);
		log("Master source list table data maximized and object is:-" + btnMin_MaxMasterSourceList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortBySourceName() throws Exception {
		btnSortBySourceName.click();
		log("Sorted the record with Source name and object is:-" + btnSortBySourceName.toString());
		Thread.sleep(1000);
	}

	public void editMasterSource(String sourceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sourcename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Source Name: " + sourcename);
				// Thread.sleep(2000);

				if (sourcename.equalsIgnoreCase(sourceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the master source list grid to edit record");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterSource(String sourceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sourcename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Source Name: " + sourcename);
				// Thread.sleep(2000);

				if (sourcename.equalsIgnoreCase(sourceName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the master source list grid to delete record");

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

		clickOnButton(btnCancel);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void verifySourceNameInTheGrid(String sourceName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sourcename = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText().trim();
				System.out.println("Source Name: " + sourcename);
				// Thread.sleep(2000);
				if (sourcename.equals(sourceName)) {

					//Assert.assertEquals(sourcename, sourceName);
					log("Source name created is updated in the record grid.");

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

	public void popWindowMessage_DeletedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
