/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[7]")
	WebElement btnMasters_masterClass;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterClassMsgDispaly;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_ClassName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_ClassOrder;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement input_ClassCode;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement chkPreAdmFlag;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
	WebElement input_ClassCapacity;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[1]")
	WebElement sel_MaxAgeYear;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[2]")
	WebElement sel_MaxAgeMonth;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[3]")
	WebElement sel_MaxAgeDay;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[4]")
	WebElement sel_MinAgeYear;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[5]")
	WebElement sel_MinAgeMonth;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[6]")
	WebElement sel_MinAgeDay;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[7]")
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

	public Masters_Master_Class(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Class
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterClass_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterClass);

		btnMasters_masterClass.click();
		log("Clicked on master class Button and object is:-" + btnMasters_masterClass.toString());
		waitForElement(driver, 10, btnSave);
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
			String classCapacity) {

		input_ClassName.clear();
		input_ClassName.sendKeys(className);
		log("Entered class name " + className + " and object is:-" + input_ClassName.toString());

		input_ClassOrder.clear();
		input_ClassOrder.sendKeys(classOrder);
		log("Entered class Order " + classOrder + " and object is:-" + input_ClassOrder.toString());

		input_ClassCode.clear();
		input_ClassCode.sendKeys(classCode);
		log("Entered class code " + classCode + " and object is:-" + input_ClassCode.toString());

		input_ClassCapacity.clear();
		input_ClassCapacity.sendKeys(classCapacity);
		log("Entered class capacity " + classCapacity + " and object is:-" + input_ClassCapacity.toString());

		if (!chkPreAdmFlag.isSelected()) {
			chkPreAdmFlag.click();
			log("Selected pre admission flag check box and object is:-" + chkPreAdmFlag.toString());
		} else {
			log("Pre admission flag check box is already selected and object is:-" + chkPreAdmFlag.toString());

		}
	}

	public void selectMaximumAgeForClass(String maxAgeYear, String maxAgeMonth, String maxAgeDay) throws Exception {

		select = new Select(sel_MaxAgeYear);
		select.selectByVisibleText(maxAgeYear);
		log("selected maximum age year " + maxAgeYear + " and object is:- " + sel_MaxAgeYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), maxAgeYear);
		Thread.sleep(1000);

		select = new Select(sel_MaxAgeMonth);
		select.selectByVisibleText(maxAgeMonth);
		log("selected maximum age month " + maxAgeMonth + " and object is:- " + sel_MaxAgeMonth.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), maxAgeMonth);
		Thread.sleep(1000);

		select = new Select(sel_MaxAgeDay);
		select.selectByVisibleText(maxAgeDay);
		log("selected maximum age day " + maxAgeDay + " and object is:- " + sel_MaxAgeDay.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), maxAgeDay);
		Thread.sleep(1000);
	}

	public void selectMinimumAgeForClass(String minAgeYear, String minAgeMonth, String minAgeDay) throws Exception {

		select = new Select(sel_MinAgeYear);
		select.selectByVisibleText(minAgeYear);
		log("selected minximum age year " + minAgeYear + " and object is:- " + sel_MinAgeYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), minAgeYear);
		Thread.sleep(1000);

		select = new Select(sel_MinAgeMonth);
		select.selectByVisibleText(minAgeMonth);
		log("selected minimum age month " + minAgeMonth + " and object is:- " + sel_MinAgeMonth.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), minAgeMonth);
		Thread.sleep(1000);

		select = new Select(sel_MinAgeDay);
		select.selectByVisibleText(minAgeDay);
		log("selected minimum age day " + minAgeDay + " and object is:- " + sel_MinAgeDay.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), minAgeDay);
		Thread.sleep(1000);
	}

	public void submitBlankMasterClassForm() throws Exception {

		btnSave.click();
		log("Submit blank Master Class form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}
	
	public void clickOnClearButton() throws Exception {

		btnClear.click();
		log("clicked on clear button and object is:-" + btnClear.toString());
		Thread.sleep(10000);
	}

	public void clickOnSaveButton() throws Exception {

		btnSave.click();
		log("clicked on Save button and object is:-" + btnSave.toString());
		Thread.sleep(10000);
	}

	public void minimizeMasterClass() throws Exception {
		btnMin_MaxMasterClass.click();
		log("clicked on master class minimize button and object is:-" + btnMin_MaxMasterClass.toString());
		Thread.sleep(1000);
	}

	public void maximizeMasterClass() throws Exception {
		btnMin_MaxMasterClass.click();
		log("clicked on master class maximize button and object is:-" + btnMin_MaxMasterClass.toString());
		Thread.sleep(1000);
	}

	public void minimizeMasterClassList() {

		btnMin_MaxMasterClassList.click();
		log("Master class list table data minimize and object is:-" + btnMin_MaxMasterClassList.toString());

	}

	public void maximizeMasterClassList() {

		btnMin_MaxMasterClassList.click();
		log("Master class list table table data maximized and object is:-" + btnMin_MaxMasterClassList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void searchWithClassName(String className) throws Exception {
		inputSearch.clear();
		inputSearch.sendKeys(className);
		log("search with class Name in the Master class list and object is:-" + inputSearch.toString());
		btnSearch.click();
		log("search button is clicked in the Master class list and object is:-" + btnSearch.toString());
		Thread.sleep(3000);
	}

	public void clickSearchResetButton() {
		btnSearchReset.click();
		log("search reset button is clicked in the Master class list and object is:-" + btnSearchReset.toString());
	}

	public void sortByClasName() throws Exception {
		btnSortByClassName.click();
		log("Sorted the record with class name and object is:-" + btnSortByClassName.toString());
		Thread.sleep(3000);
	}

	public void editMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			try {
				if (classname.equalsIgnoreCase(className)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master class list grid");

					break;
				} else {
					log("Class Name not matched with the master class list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			try {
				if (classname.equalsIgnoreCase(className)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[2]"));
					String deactivetext = deactiveLink.getText();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master class list grid");

					break;
				} else {
					log("Class Name not matched with the master class list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterClass(String className) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Class Name: " + classname);
			// Thread.sleep(2000);
			try {
				if (classname.equalsIgnoreCase(className)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[13]/a[2]"));
					String activetext = activeLink.getText();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master class list grid");

					break;
				} else {
					log("Class Name not matched with the master class list grid");
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

	public void clickOnSetOrder() {

		btnSetOrder.click();
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
		btnCloseOrder.click();
		log("Set class Order pop Up window is closed and object is:-" + btnCloseOrder.toString());
	}

	public void saveSetClassOrderPopUpWindow() throws Exception {
		btnSaveOrder.click();
		log("Set class Order pop Up window is closed and object is:-" + btnSaveOrder.toString());
		Thread.sleep(10000);
	}
}
