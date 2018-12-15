/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Class_Held extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Class_Held.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[14]")
	// WebElement btnMasters_masterClassHeld;

	@FindBy(xpath = "//a[@href='#/app/masterclassheld/49']")
	WebElement btnMasters_masterClassHeld;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_masterClassHeldMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selAcademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selClass;

	@FindBy(xpath = "//select[@id='sel2']")
	WebElement selSection;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterClassHeld;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterClassHeldTable;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Class_Held(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Class Held
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterClassHeld_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterClassHeld);
		log("Clicked on master Class Held Button and object is:-" + btnMasters_masterClassHeld.toString());

	}

	/**
	 * Validation of masters master Class Held screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterClassHeld_BGHSPage() {
		try {
			System.out.println(txtMasters_masterClassHeldMsgDispaly.getText());
			txtMasters_masterClassHeldMsgDispaly.isDisplayed();
			log("Master class held page is dispalyed and object is:-"
					+ txtMasters_masterClassHeldMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterClassHeldData(String academicYear, String className, String section) throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_masterClassHeldMsgDispaly);
		Thread.sleep(2000);

		selectedDropdownItemValidation(selAcademicYear, academicYear);
		log("selected academic year: " + academicYear + " and object is:- " + selAcademicYear.toString());

		selectElementFromDropDown(selClass, className);
		log("selected class: " + className + " and object is:- " + selClass.toString());

		selectElementFromDropDown(selSection, section);
		log("selected section: " + section + " and object is:- " + selSection.toString());

	}

	public void submitBlankMasterClassHeldForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master class held form and object is:-" + btnSave.toString());

	}

	public void clearClassHeldInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled class held info and object is:-" + btnCancelClear.toString());

	}

	public void submitFilledMasterClassHeldForm() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Save filled master class held form and object is:-" + btnSave.toString());

	}

	public void minimizeMasterClassHeld() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_masterClassHeldMsgDispaly);
		Thread.sleep(2000);

		clickOnButton(btnMin_MaxMasterClassHeld);
		log("clicked on master Class Held minimize button and object is:-" + btnMin_MaxMasterClassHeld.toString());

	}

	public void maximizeMasterClassHeld() throws Exception {

		clickOnButton(btnMin_MaxMasterClassHeld);
		log("clicked on master Class Held maximize button and object is:-" + btnMin_MaxMasterClassHeld.toString());

	}

	public void minimizeMasterClassHeldTable() throws Exception {

		clickOnButton(btnMin_MaxMasterClassHeldTable);
		log("Master Class Held list table data minimize and object is:-" + btnMin_MaxMasterClassHeldTable.toString());

	}

	public void maximizeMasterClassHeldTable() throws Exception {

		clickOnButton(btnMin_MaxMasterClassHeldTable);
		log("Master Class Held table data maximized and object is:-" + btnMin_MaxMasterClassHeldTable.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void updateWithMonthwiseClassHeldData(String classHeld) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				WebElement chkMonthWise = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"));

				if (!chkMonthWise.isSelected()) {
					chkMonthWise.click();
					Thread.sleep(2000);
					log("For " + i + " month class held check box checked");
				}

				else {
					log("For " + i + " month class held check box already checked");
					Thread.sleep(2000);
				}

				WebElement MonthWiseclassHeld = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]/input"));
				MonthWiseclassHeld.clear();
				MonthWiseclassHeld.sendKeys(classHeld);
				Thread.sleep(2000);
				log("Entered class held for " + i + " month");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Data Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
