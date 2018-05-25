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
import org.openqa.selenium.interactions.Action;
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[9]")
	WebElement btnMasters_masterSection;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterSectionMsgDispaly;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_SectionName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_SectionOrder;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement input_SectionCode;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement input_SectionCapacity;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[6]")
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
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterSection);

		btnMasters_masterSection.click();
		log("Clicked on master section Button and object is:-" + btnMasters_masterSection.toString());
		waitForElement(driver, 10, btnSubmit);
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

		btnSubmit.click();
		log("Submit blank master section form and object is:-" + btnSubmit.toString());
		Thread.sleep(2000);
	}

	public void enterMasterSectionFormData(String sectionName, String sectionOrder, String sectionCode,
			String sectionCapacity) {

		input_SectionName.clear();
		input_SectionName.sendKeys(sectionName);
		log("Entered section name: " + sectionName + " and object is:-" + input_SectionName.toString());

		input_SectionOrder.clear();
		input_SectionOrder.sendKeys(sectionOrder);
		log("Entered section order: " + sectionOrder + " and object is:-" + input_SectionOrder.toString());

		input_SectionCode.clear();
		input_SectionCode.sendKeys(sectionCode);
		log("Entered section code: " + sectionCode + " and object is:-" + input_SectionCode.toString());

		input_SectionCapacity.clear();
		input_SectionCapacity.sendKeys(sectionCapacity);
		log("Entered section capacity: " + sectionCapacity + " and object is:-" + input_SectionCapacity.toString());
	}

	public void clearSectionInfoData() throws Exception {
		btnClear.click();
		log("Clicked on clear button to clear filled master section and object is:-" + btnClear.toString());
		Thread.sleep(10000);
	}

	public void submitFilledMasterSectionForm() throws Exception {

		btnSubmit.click();
		log("Submit filled master section form and object is:-" + btnSubmit.toString());
		Thread.sleep(10000);
	}

	public void clickOnSetOrder() {

		btnSetOrder.click();
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
		btnCloseOrder.click();
		log("Set section Order pop Up window is closed and object is:-" + btnCloseOrder.toString());
	}

	public void saveSetSectionOrderPopUpWindow() throws Exception {
		btnSaveOrder.click();
		log("Set section Order save button is clicked, pop Up window is closed and object is:-" + btnSaveOrder.toString());
		Thread.sleep(10000);
	}

	public void sortBySectionName() throws Exception {
		btnSortBySectionName.click();
		log("Sorted the record with section name and object is:-" + btnSortBySectionName.toString());
		Thread.sleep(3000);
	}

	public void searchWithSectionNameInTheGrid(String sectionName) {

		inputSearch.clear();
		inputSearch.sendKeys(sectionName);
		log("Entered section name to search: " + sectionName + " and object is:-" + inputSearch.toString());
	}

	public void verifySectionNameInTheGrid(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String sectionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Section Name: " + sectionname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(sectionname, sectionName);
				log("Section name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeMasterSection() throws Exception {
		btnMin_MaxMasterSection.click();
		log("clicked on master section minimize button and object is:-" + btnMin_MaxMasterSection.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterSection() throws Exception {
		btnMin_MaxMasterSection.click();
		log("clicked on master section maximize button and object is:-" + btnMin_MaxMasterSection.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterSectionList() throws Exception {

		btnMin_MaxMasterSectionList.click();
		log("Master section list table data minimize and object is:-" + btnMin_MaxMasterSectionList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterSectionList() throws Exception {

		btnMin_MaxMasterSectionList.click();
		log("Master section list table table data maximized and object is:-" + btnMin_MaxMasterSectionList.toString());
		Thread.sleep(2000);
	}

	public void editMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String sectionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Section Name: " + sectionname);
			// Thread.sleep(2000);
			try {
				if (sectionname.equalsIgnoreCase(sectionName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master section list grid to edit record");

					break;
				} else {
					log("Section Name not matched with the master section list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String sectionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Section Name: " + sectionname);
			// Thread.sleep(2000);
			try {
				if (sectionname.equalsIgnoreCase(sectionName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[2]"));
					String deactivetext = deactiveLink.getText();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master section list grid");

					break;
				} else {
					log("Section Name not matched with the master section list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterSection(String sectionName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String sectionname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Section Name: " + sectionname);
			// Thread.sleep(2000);
			try {
				if (sectionname.equalsIgnoreCase(sectionName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a[2]"));
					String activetext = activeLink.getText();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master section list grid");

					break;
				} else {
					log("Section Name not matched with the master section list grid");
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

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
}
