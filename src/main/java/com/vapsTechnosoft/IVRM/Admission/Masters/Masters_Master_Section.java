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
import org.openqa.selenium.interactions.Action;
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
public class Masters_Master_Section extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Section.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[9]")
	// WebElement btnMasters_masterSection;

	@FindBy(xpath = "//a[@href='#/app/section/20']")
	WebElement btnMasters_masterSection;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterSectionMsgDispaly;

	@FindBy(xpath = "//input[@name='Name']")
	WebElement input_SectionName;

	@FindBy(xpath = "//input[@name='order']")
	WebElement input_SectionOrder;

	@FindBy(xpath = "//input[@name='code']")
	WebElement input_SectionCode;

	@FindBy(xpath = "//input[@name='capacity']")
	WebElement input_SectionCapacity;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterSection;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterSectionList;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortBySectionName;

	@FindBy(xpath = "//span[contains(text(),'Submit')]/parent::button")
	WebElement btnSubmit;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;

	@FindBy(xpath = "//span[contains(text(),'Set Order')]/parent::button")
	WebElement btnSetOrder;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSaveOrder;

	@FindBy(xpath = "//span[contains(text(),'Close')]/parent::button")
	WebElement btnCloseOrder;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "//li[contains(text(),'D')]")
	WebElement From;

	@FindBy(xpath = "//li[contains(text(),'A')]")
	WebElement To;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Section(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterSection_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterSection);
		log("Clicked on master section Button and object is:-" + btnMasters_masterSection.toString());
	}

	/**
	 * Validation of masters master source screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterSection_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterSectionMsgDispaly.getText());
			txtMasters_MasterSectionMsgDispaly.isDisplayed();
			log("Master Section page is dispalyed and object is:-" + txtMasters_MasterSectionMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankMasterSectionForm() throws Exception {

		clickOnButton(btnSubmit);
		log("Submit blank master section form and object is:-" + btnSubmit.toString());

	}

	public void enterMasterSectionFormData(String sectionName, String sectionOrder, String sectionCode,
			String sectionCapacity) throws InterruptedException {

		inputTextIntoInputField(input_SectionName, sectionName);
		log("Entered section name: " + sectionName + " and object is:-" + input_SectionName.toString());

		inputTextIntoInputField(input_SectionOrder, sectionOrder);
		log("Entered section order: " + sectionOrder + " and object is:-" + input_SectionOrder.toString());

		inputTextIntoInputField(input_SectionCode, sectionCode);
		log("Entered section code: " + sectionCode + " and object is:-" + input_SectionCode.toString());

		inputTextIntoInputField(input_SectionCapacity, sectionCapacity);
		log("Entered section capacity: " + sectionCapacity + " and object is:-" + input_SectionCapacity.toString());

	}

	public void clearSectionInfoData() throws Exception {

		clickOnButton(btnClear);
		log("Clicked on clear button to clear filled master section and object is:-" + btnClear.toString());

	}

	public void submitFilledMasterSectionForm() throws Exception {

		clickOnButton(btnSubmit);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Submit filled master section form and object is:-" + btnSubmit.toString());

	}

	public void clickOnSetOrder() {

		clickOnButton(btnSetOrder);
		log("Set Order button is clicked and object is:-" + btnSetOrder.toString());
	}

	public void setSectionOrder() {

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();

		dragAndDrop.perform();
		log("Section order set using drag and drop.");
		/*
		 * Actions act=new Actions(driver);
		 * 
		 * //Drag and Drop by Pixel. act.dragAndDropBy(From,192,
		 * 20).build().perform();
		 * 
		 * 
		 * // action.dragAndDrop(To, From).build().perform();
		 */
	}

	public void closeSetSectionOrderPopUpWindow() {

		clickOnButton(btnCloseOrder);
		log("Set section Order pop Up window is closed and object is:-" + btnCloseOrder.toString());
	}

	public void saveSetSectionOrderPopUpWindow() throws Exception {

		clickOnButton(btnSaveOrder);
		log("Set section Order save button is clicked, pop Up window is closed and object is:-"
				+ btnSaveOrder.toString());
		Thread.sleep(1000);
	}

	public void sortBySectionName() throws Exception {

		clickOnButton(btnSortBySectionName);
		log("Sorted the record with section name and object is:-" + btnSortBySectionName.toString());
		Thread.sleep(1000);
	}

	public void searchWithSectionNameInTheGrid(String sectionName) {

		inputTextIntoInputField(inputSearch, sectionName);
		log("Entered section name to search: " + sectionName + " and object is:-" + inputSearch.toString());
	}

	public void verifySectionNameInTheGrid(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sectionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Section Name: " + sectionname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (sectionname.equals(sectionName)) {
					// Assert.assertEquals(sectionname, sectionName);
					log("Section name created is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeMasterSection() throws Exception {

		clickOnButton(btnMin_MaxMasterSection);
		log("clicked on master section minimize button and object is:-" + btnMin_MaxMasterSection.toString());

	}

	public void maximizeMasterSection() throws Exception {

		clickOnButton(btnMin_MaxMasterSection);
		log("clicked on master section maximize button and object is:-" + btnMin_MaxMasterSection.toString());

	}

	public void minimizeMasterSectionList() throws Exception {

		clickOnButton(btnMin_MaxMasterSectionList);
		log("Master section list table data minimize and object is:-" + btnMin_MaxMasterSectionList.toString());

	}

	public void maximizeMasterSectionList() throws Exception {

		clickOnButton(btnMin_MaxMasterSectionList);
		log("Master section list table table data maximized and object is:-" + btnMin_MaxMasterSectionList.toString());

	}

	public void editMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sectionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Section Name: " + sectionname);
				// Thread.sleep(2000);

				if (sectionname.equalsIgnoreCase(sectionName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master section list grid to edit record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sectionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Section Name: " + sectionname);
				// Thread.sleep(2000);

				if (sectionname.equalsIgnoreCase(sectionName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[2]"));
					String deactivetext = deactiveLink.getText();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master section list grid");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String sectionname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Section Name: " + sectionname);
				// Thread.sleep(2000);

				if (sectionname.equalsIgnoreCase(sectionName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[2]"));
					String activetext = activeLink.getText();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master section list grid");

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

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
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
			assertEquals(text, "Section De-Activate Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_ActivatedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Section Activate Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
