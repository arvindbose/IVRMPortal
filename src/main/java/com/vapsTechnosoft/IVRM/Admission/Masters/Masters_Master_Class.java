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
public class Masters_Master_Class extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Academic_Year_Staging.class.getName());

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
	// WebElement btnMasters_masterClass;

	@FindBy(xpath = "//a[@href='#/app/masterclass/6']")
	WebElement btnMasters_masterClass;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterClassMsgDispaly;

	@FindBy(xpath = "//input[@name='classname']")
	WebElement input_ClassName;

	@FindBy(xpath = "//input[@name='classorder']")
	WebElement input_ClassOrder;

	@FindBy(xpath = "//input[@name='classcode']")
	WebElement input_ClassCode;

	@FindBy(xpath = "//input[@name='PreAdmissionFlag']")
	WebElement chkPreAdmFlag;

	@FindBy(xpath = "//input[@name='classcapacity']")
	WebElement input_ClassCapacity;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "//select[@name='classmaxyear']")
	WebElement sel_MaxAgeYear;

	@FindBy(xpath = "//select[@name='classmaxmonth']")
	WebElement sel_MaxAgeMonth;

	@FindBy(xpath = "//select[@name='classmaxday']")
	WebElement sel_MaxAgeDay;

	@FindBy(xpath = "//select[@name='minyear']")
	WebElement sel_MinAgeYear;

	@FindBy(xpath = "//select[@name='minmonth']")
	WebElement sel_MinAgeMonth;

	@FindBy(xpath = "//select[@name='minday']")
	WebElement sel_MinAgeDay;

	@FindBy(xpath = "//select[@ng-model='searchColumn']")
	WebElement sel_GridSearchCategory;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[1]")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;

	@FindBy(xpath = "//span[contains(text(),'Set Order')]/parent::button")
	WebElement btnSetOrder;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[2]")
	WebElement btnSaveOrder;

	@FindBy(xpath = "//span[contains(text(),'Close')]/parent::button")
	WebElement btnCloseOrder;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]/following-sibling::span[1]")
	WebElement btnSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]/following-sibling::span[2]")
	WebElement btnSearchReset;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterClass;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterClassList;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByClassName;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	// @FindBy(xpath = "//li[contains(text(),'UKG')]")
	// WebElement From;

	@FindBy(xpath = "//ul[@id='single']/li[3]")
	WebElement From;

	// @FindBy(xpath = "//li[contains(text(),'PN')]")
	// WebElement To;

	@FindBy(xpath = "//ul[@id='single']/li[1]")
	WebElement To;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Class(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Class
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterClass_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterClass);
		log("Clicked on master class Button and object is:-" + btnMasters_masterClass.toString());

	}

	/**
	 * Validation of masters master class screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterClass_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterClassMsgDispaly.getText());
			txtMasters_MasterClassMsgDispaly.isDisplayed();
			log("Master class page is dispalyed and object is:-" + txtMasters_MasterClassMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterClassRequiredFormData(String className, String classOrder, String classCode,
			String classCapacity) throws Exception {

		inputTextIntoInputField(input_ClassName, className);
		log("Entered class name " + className + " and object is:-" + input_ClassName.toString());

		inputTextIntoInputField(input_ClassOrder, classOrder);
		log("Entered class Order " + classOrder + " and object is:-" + input_ClassOrder.toString());

		inputTextIntoInputField(input_ClassCode, classCode);
		log("Entered class code " + classCode + " and object is:-" + input_ClassCode.toString());

		inputTextIntoInputField(input_ClassCapacity, classCapacity);
		log("Entered class capacity " + classCapacity + " and object is:-" + input_ClassCapacity.toString());

		isDisplayed(chkPreAdmFlag);
		if (!chkPreAdmFlag.isSelected()) {
			chkPreAdmFlag.click();
			log("Selected pre admission flag check box and object is:-" + chkPreAdmFlag.toString());
		} else {
			log("Pre admission flag check box is already selected and object is:-" + chkPreAdmFlag.toString());

		}
	}

	public void selectMaximumAgeForClass(String maxAgeYear, String maxAgeMonth, String maxAgeDay) throws Exception {

		selectElementFromDropDown(sel_MaxAgeYear, maxAgeYear);
		log("selected maximum age year " + maxAgeYear + " and object is:- " + sel_MaxAgeYear.toString());

		selectElementFromDropDown(sel_MaxAgeMonth, maxAgeMonth);
		log("selected maximum age month " + maxAgeMonth + " and object is:- " + sel_MaxAgeMonth.toString());

		selectElementFromDropDown(sel_MaxAgeDay, maxAgeDay);
		log("selected maximum age day " + maxAgeDay + " and object is:- " + sel_MaxAgeDay.toString());

	}

	public void selectMinimumAgeForClass(String minAgeYear, String minAgeMonth, String minAgeDay) throws Exception {

		selectElementFromDropDown(sel_MinAgeYear, minAgeYear);
		log("selected minximum age year " + minAgeYear + " and object is:- " + sel_MinAgeYear.toString());

		selectElementFromDropDown(sel_MinAgeMonth, minAgeMonth);
		log("selected minimum age month " + minAgeMonth + " and object is:- " + sel_MinAgeMonth.toString());

		selectElementFromDropDown(sel_MinAgeDay, minAgeDay);
		log("selected minimum age day " + minAgeDay + " and object is:- " + sel_MinAgeDay.toString());

	}

	public void submitBlankMasterClassForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank Master Class form and object is:-" + btnSave.toString());

	}

	public void clickOnClearButton() throws Exception {

		clickOnButton(btnClear);
		log("clicked on clear button and object is:-" + btnClear.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("clicked on Save button and object is:-" + btnSave.toString());

	}

	public void minimizeMasterClass() throws Exception {

		clickOnButton(btnMin_MaxMasterClass);
		log("clicked on master class minimize button and object is:-" + btnMin_MaxMasterClass.toString());

	}

	public void maximizeMasterClass() throws Exception {

		clickOnButton(btnMin_MaxMasterClass);
		log("clicked on master class maximize button and object is:-" + btnMin_MaxMasterClass.toString());

	}

	public void minimizeMasterClassList() {
		clickOnButton(btnMin_MaxMasterClassList);
		log("Master class list table data minimize and object is:-" + btnMin_MaxMasterClassList.toString());

	}

	public void maximizeMasterClassList() {

		clickOnButton(btnMin_MaxMasterClassList);
		log("Master class list table table data maximized and object is:-" + btnMin_MaxMasterClassList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void searchWithClassName(String className) throws Exception {

		inputTextIntoInputField(inputSearch, className);
		log("search with class Name in the Master class list and object is:-" + inputSearch.toString());

		clickOnButton(btnSearch);
		log("search button is clicked in the Master class list and object is:-" + btnSearch.toString());
		Thread.sleep(1000);
	}

	public void clickSearchResetButton() {

		clickOnButton(btnSearchReset);
		log("search reset button is clicked in the Master class list and object is:-" + btnSearchReset.toString());
	}

	public void sortByClasName() throws Exception {

		clickOnButton(btnSortByClassName);
		log("Sorted the record with class name and object is:-" + btnSortByClassName.toString());

	}

	public void editMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Class Name: " + classname);
				Thread.sleep(1000);
				if (classname.equals(className)) {
					// Assert.assertEquals(classname, className);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the master class list grid");

					break;

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);

		try {
			for (int i = 1; i <= rows; i++) {

				String classname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Class Name: " + classname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (classname.equals(className)) {
					// Assert.assertEquals(classname, className);

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[2]"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master class list grid");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String classname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Class Name: " + classname);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (classname.equals(className)) {
					Assert.assertEquals(classname, className);

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[2]"));
					String activetext = activeLink.getText();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(2000);
					log("Clicked on the activate link in the master class list grid");

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
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void clickOnSetOrder() throws Exception {

		clickOnButton(btnSetOrder);
		log("Set Order button is clicked and object is:-" + btnSetOrder.toString());

	}

	public void setClassOrder() {

		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();

		dragAndDrop.perform();
		log("Class order set using drag and drop.");
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

	public void closeSetClassOrderPopUpWindow() {

		clickOnButton(btnCloseOrder);
		log("Set class Order pop Up window is closed and object is:-" + btnCloseOrder.toString());
	}

	public void saveSetClassOrderPopUpWindow() throws Exception {

		clickOnButton(btnSaveOrder);
		log("Set class Order pop Up window is closed and object is:-" + btnSaveOrder.toString());
		Thread.sleep(1000);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SearchedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Searched Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
