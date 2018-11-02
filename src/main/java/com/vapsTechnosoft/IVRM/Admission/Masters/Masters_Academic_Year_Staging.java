/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class Masters_Academic_Year_Staging extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Academic_Year_Staging.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[5]")
	// WebElement btnMasters_AcademicYr;

	@FindBy(xpath = "//a[@href='#/app/academic/5']")
	WebElement btnMasters_AcademicYr;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_academicYearMsgDispaly;

	@FindBy(xpath = "//input[@name='fyear']")
	WebElement input_FromYear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputAcad_StartDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement inputPreAdm_StartDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement inputAcdYr_Order;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
	WebElement input_ToYear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[6]")
	WebElement inputAcad_EndDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement inputPreAdm_EndDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[8]")
	WebElement inputPreAdm_CutOffDate;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[9]")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/select)[1]")
	WebElement sel_Institution;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	// @FindBy(xpath = "//button[@id='save-btn']")
	// WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxAcdYrMaster;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxAcdYrGrid;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[3]")
	WebElement btnSortByAcdYear;

	// Calendar
	@FindBy(xpath = "(//label[text()='Start Date:']//following::md-datepicker/button)[1]")
	private WebElement btn_StartCalender;

	@FindBy(xpath = "//span[contains(text(),'May 2030')]")
	private WebElement btn_StartMonthYear;

	@FindBy(xpath = "//span[contains(text(),'May 2030')]/following::td[1]")
	private WebElement btn_StartDate;

	@FindBy(xpath = "(//label[text()='End Date:']//following::md-datepicker/button)[1]")
	private WebElement btn_EndCalender;

	@FindBy(xpath = "//span[contains(text(),'Apr 2031')]")
	private WebElement btn_EndMonthYear;

	@FindBy(xpath = "(//table/tbody[@role='rowgroup'])[6]")
	private WebElement scroll_Cal;

	@FindBy(xpath = "//span[contains(text(),'Oct 2030')]")
	private WebElement btn_EndMonthYear2;

	@FindBy(xpath = "//span[contains(text(),'Jan 2031')]")
	private WebElement btn_EndMonthYear3;

	@FindBy(xpath = "//span[contains(text(),'Apr 2031')]/following::td[32]")
	private WebElement btn_EndDate;

	@FindBy(xpath = "(//label[text()='Pre Admission Start Date:']//following::md-datepicker/button)[1]")
	private WebElement btn_PreAdmStartCalender;

	@FindBy(xpath = "//span[contains(text(),'Nov 2029')]")
	private WebElement btn_PreAdmStartMonthYear;

	@FindBy(xpath = "//span[contains(text(),'May 2029')]")
	private WebElement btn_PreAdmStartMonthYear2;

	@FindBy(xpath = "//span[contains(text(),'Aug 2029')]")
	private WebElement btn_PreAdmStartMonthYear3;

	@FindBy(xpath = "//span[contains(text(),'Nov 2029')]/following::td[2]")
	private WebElement btn_PreAdmStartDate;

	@FindBy(xpath = "(//label[text()='Pre Admission End Date:']//following::md-datepicker/button)[1]")
	private WebElement btn_PreAdmEndCalender;

	@FindBy(xpath = "//span[contains(text(),'Nov 2029')]")
	private WebElement btn_PreAdmEndMonthYear;

	@FindBy(xpath = "//span[contains(text(),'May 2029')]")
	private WebElement btn_PreAdmEndMonthYear2;

	@FindBy(xpath = "//span[contains(text(),'Nov 2029')]/following::td[21]")
	private WebElement btn_PreAdmEndDate;

	@FindBy(xpath = "//label[text()='Pre Admission Age Cut off Date:']//following::md-datepicker/button")
	private WebElement btn_PreAdmCutoffCalender;

	@FindBy(xpath = "//span[contains(text(),'Dec 2029')]")
	private WebElement btn_PreAdmCutoffMonthYear;

	@FindBy(xpath = "//span[contains(text(),'Dec 2029')]/following::td[18]")
	private WebElement btn_PreAdmCutoffDate;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Academic_Year_Staging(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyHomeButton() {
		isDisplayed(btnHome);
		log("Home button is dispalyed and object is:-" + btnHome.toString());
	}

	/**
	 * Navigate to Admission Masters Academic year
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_AcademicYear_BGHS() throws Exception {
		// btn_Admission.click();
		// log("Clicked on admission Button and object is:-" +
		// btn_Admission.toString());
		// waitForElement(driver, 10, btnAdmission_Masters);
		//
		// btnAdmission_Masters.click();
		// log("Clicked on Masters Button and object is:-" +
		// btnAdmission_Masters.toString());
		// waitForElement(driver, 10, btnMasters_AcademicYr);
		//
		// btnMasters_AcademicYr.click();
		// log("Clicked on academic year Button and object is:-" +
		// btnMasters_AcademicYr.toString());
		// waitForElement(driver, 10, btnSave);
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		clickOnButton(btnMasters_AcademicYr);
		log("Clicked on academic year Button and object is:-" + btnMasters_AcademicYr.toString());
	}

	/**
	 * Validation of masters Academic year screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_AcademicYear_BGHSPage() {
		try {
			System.out.println(txtMasters_academicYearMsgDispaly.getText());
			txtMasters_academicYearMsgDispaly.isDisplayed();
			log("Academic year page is dispalyed and object is:-" + txtMasters_academicYearMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fillAcademicYearDetailsForm(String FromAcademicYr, String academicYrOrder, String instituition)
			throws Exception {
		// if(input_FromYear.isDisplayed()){
		// input_FromYear.clear();
		// input_FromYear.sendKeys(FromAcademicYr);
		// log("Entered Academic from year " + FromAcademicYr + " and object
		// is:-" + input_FromYear.toString());
		// Thread.sleep(1000);
		// }
		// else{
		// log("From Year element is not present.");
		// Thread.sleep(1000);
		// }
		inputTextIntoInputField(input_FromYear, FromAcademicYr);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		try {
			String toyr = input_ToYear.getAttribute("value");
			System.out.println("To Year: " + toyr);

			Assert.assertEquals(Integer.parseInt(toyr) - 1, Integer.parseInt(FromAcademicYr));
			log("To year is +1Yr of From year for academic year");
		} catch (Exception e) {
			log("To year is not +1Yr of From year for academic year");
		}
		isDisplayed(btn_StartCalender);
		clickOnButton(btn_StartCalender);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_StartMonthYear);
		Thread.sleep(1000);
		clickOnButton(btn_StartDate);
		log("Start Date is selected for academic year.");
		Thread.sleep(1000);

		if (btn_EndCalender.isDisplayed()) {
			try {
				btn_EndCalender.click();
				Thread.sleep(1000);
				/*
				 * ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].scrollIntoView(true);",
				 * btn_EndMonthYear2); Thread.sleep(2000); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].scrollIntoView(true);",
				 * btn_EndMonthYear3); Thread.sleep(2000);
				 */
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll_Cal);
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_EndMonthYear);
				Thread.sleep(2000);
				// robot = new Robot();
				// robot.keyPress(KeyEvent.VK_DOWN);
				// robot.keyRelease(KeyEvent.VK_DOWN);
				btn_EndDate.click();
				log("End Date is selected for academic year.");
				Thread.sleep(1000);
			} catch (Exception e) {
				log("End date not selected.");
				Thread.sleep(1000);
			}
		} else {
			log("End Date Calendar button element not present.");
			Thread.sleep(500);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_academicYearMsgDispaly);
		Thread.sleep(1000);

		if (btn_PreAdmStartCalender.isDisplayed()) {
			try {
				btn_PreAdmStartCalender.click();
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_PreAdmStartMonthYear2);
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_PreAdmStartMonthYear3);
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_PreAdmStartMonthYear);
				Thread.sleep(1000);
				btn_PreAdmStartDate.click();
				log("Pre Admission Start Date is selected for academic year.");
				Thread.sleep(1000);
			} catch (Exception e) {
				log("Pre Admission Start date not selected.");
				Thread.sleep(1000);
			}
		} else {
			log("Pre Admission From Date Calendar button element not present.");
			Thread.sleep(500);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_academicYearMsgDispaly);
		Thread.sleep(1000);
		if (btn_PreAdmEndCalender.isDisplayed()) {
			try {
				btn_PreAdmEndCalender.click();
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_PreAdmEndMonthYear);
				Thread.sleep(2000);
				btn_PreAdmEndDate.click();
				log("Pre Admission End Date is selected for academic year.");
				Thread.sleep(1000);
			} catch (Exception e) {
				log("Pre Admission End date not selected.");
				Thread.sleep(1000);
			}
		} else {
			log("Pre Admission End Date Calendar button element not present.");
			Thread.sleep(500);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_academicYearMsgDispaly);
		Thread.sleep(1000);
		if (inputAcdYr_Order.isDisplayed()) {
			inputAcdYr_Order.clear();
			inputAcdYr_Order.sendKeys(academicYrOrder);
			log("Entered Academic year order " + academicYrOrder + " and object is:-" + inputAcdYr_Order.toString());
			Thread.sleep(500);
		} else {
			log("Academic Year order element not present.");
			Thread.sleep(500);
		}
		if (btn_PreAdmCutoffCalender.isDisplayed()) {
			try {
				btn_PreAdmCutoffCalender.click();
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_PreAdmCutoffMonthYear);
				Thread.sleep(2000);
				btn_PreAdmCutoffDate.click();
				log("Pre Admission Cutoff Date is selected for academic year.");
				Thread.sleep(1000);
			} catch (Exception e) {
				log("Pre Admission Cutoff date not selected.");
				Thread.sleep(1000);
			}
		} else {
			log("Pre Admission Cutoff Date Calendar button element not present.");
			Thread.sleep(500);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_academicYearMsgDispaly);
		Thread.sleep(1000);
		if (sel_Institution.isDisplayed()) {
			select = new Select(sel_Institution);
			select.selectByVisibleText(instituition);
			log("selected instituition for academic year:-" + instituition + " and object is "
					+ sel_Institution.toString());
			Thread.sleep(1000);

			WebElement option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText(), instituition);
			Thread.sleep(1000);
		} else {
			log("Instituition element not present.");
			Thread.sleep(500);
		}

	}

	public void enterMastersAcademicYearDetails(String FromAcademicYr, String startdate, String end_date,
			String preAdmStartDate, String preAdmEndDate, String academicYrOrder, String cutoffDate,
			String instituition) throws Exception {

		inputTextIntoInputField(input_FromYear, FromAcademicYr);
		Thread.sleep(1000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		log("Entered Academic from year " + FromAcademicYr + " and object is:-" + input_FromYear.toString());
		Thread.sleep(1000);
		try {
			String toyr = input_ToYear.getAttribute("value");
			System.out.println("To Year: " + toyr);

			Assert.assertEquals(Integer.parseInt(toyr) - 1, Integer.parseInt(FromAcademicYr));
			log("To year is +1Yr of From year for academic year");
			Thread.sleep(2000);
		} catch (Exception e) {
			log("To year is not +1Yr of From year for academic year");
		}
		try {
			copyToClipbord(startdate);
			Thread.sleep(1000);
			oAction = new Actions(driver);
			oAction.moveToElement(inputAcad_StartDate);
			oAction.contextClick(inputAcad_StartDate).build().perform();
			// Thread.sleep(1000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			log("Entered start date for academic year " + startdate + " and object is:-"
					+ inputAcad_StartDate.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// calendarDatePicker(btn_StartCalender, btn_StartMonthYear,
		// btn_StartDate);
		// Thread.sleep(2000);
		// calendarDatePicker(btn_EndCalender, btn_EndMonthYear, btn_EndDate);
		// Thread.sleep(2000);
		try {
			copyToClipbord(end_date);
			Thread.sleep(1000);
			oAction = new Actions(driver);
			oAction.moveToElement(inputAcad_EndDate);
			oAction.contextClick(inputAcad_EndDate).build().perform();
			// Thread.sleep(1000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered end date for academic year " + end_date + " and object is:-" + inputAcad_EndDate.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			copyToClipbord(preAdmStartDate);
			Thread.sleep(1000);
			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_StartDate);
			oAction.contextClick(inputPreAdm_StartDate).build().perform();
			// Thread.sleep(1000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered start date for preadmission " + preAdmStartDate + " and object is:-"
					+ inputPreAdm_StartDate.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			copyToClipbord(preAdmEndDate);
			Thread.sleep(1000);
			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_EndDate);
			oAction.contextClick(inputPreAdm_EndDate).build().perform();
			// Thread.sleep(1000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered end date for preadmission " + preAdmEndDate + " and object is:-"
					+ inputPreAdm_EndDate.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		inputTextIntoInputField(inputAcdYr_Order, academicYrOrder);
		log("Entered Academic year order " + academicYrOrder + " and object is:-" + inputAcdYr_Order.toString());
		try {
			copyToClipbord(cutoffDate);
			Thread.sleep(1000);
			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_CutOffDate);
			oAction.contextClick(inputPreAdm_CutOffDate).build().perform();
			// Thread.sleep(1000);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered cut off date for preadmission " + cutoffDate + " and object is:-"
					+ inputPreAdm_CutOffDate.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		selectElementFromDropDown(sel_Institution, instituition);
		log("selected instituition for academic year:-" + instituition + " and object is "
				+ sel_Institution.toString());

		// select = new Select(sel_Institution);
		// select.selectByVisibleText(instituition);
		// log("selected instituition for academic year:-" + instituition + "
		// and object is "
		// + sel_Institution.toString());
		// Thread.sleep(1000);
		//
		// WebElement option = select.getFirstSelectedOption();
		// Assert.assertEquals(option.getText(), instituition);
		// Thread.sleep(1000);
	}

	//
	public void submitBlankMasterAcademicYearForm() {

		clickOnButton(btnSave);
		log("Submit blank Master Academic year form and object is:-" + btnSave.toString());
	}

	public void minimizeMasterAcademicYear() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_academicYearMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxAcdYrMaster);
		log("clicked on academic year minimize button and object is:-" + btnMin_MaxAcdYrMaster.toString());
	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("clicked on Save button and object is:-" + btnSave.toString());
	}

	public void clickOnClearButton() throws Exception {

		clickOnButton(btnClear);
		log("clicked on clear button and object is:-" + btnClear.toString());
	}

	public void maximizeMasterAcademicYear() throws Exception {

		clickOnButton(btnMin_MaxAcdYrMaster);
		log("clicked on master academic year maximize button and object is:-" + btnMin_MaxAcdYrMaster.toString());
	}

	public void minimizeAcademicYearGrid() throws Exception {

		clickOnButton(btnMin_MaxAcdYrGrid);
		log("Academic year grid table data minimize and object is:-" + btnMin_MaxAcdYrGrid.toString());
	}

	public void maximizeAcademicYearGrid() throws Exception {

		clickOnButton(btnMin_MaxAcdYrGrid);
		log("Academic year grid table data maximized and object is:-" + btnMin_MaxAcdYrGrid.toString());
	}

	public void searchWithAcademicYear(String academicyear) throws Exception {
		inputTextIntoInputField(inputSearch, academicyear);
	}

	public void editAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String academicYrs = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Academic year: " + academicYrs);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (academicYrs.equals(academicyear)) {
					// assertEquals(academicYrs, academicyear);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]//div/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the academic year list grid");

					break;

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
	}

	public void deactivateAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String academicYrs = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
				System.out.println("Academic year: " + academicYrs);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (academicYrs.equals(academicyear)) {
					assertEquals(academicYrs, academicyear);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]//div/span"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the academic year list grid");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {

			for (int i = 1; i <= rows; i++) {
				String academicYrs = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Academic year: " + academicYrs);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (academicYrs.equals(academicyear)) {
					assertEquals(academicYrs, academicyear);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]//div/span"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the activate link in the academic year list grid");

					break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String academicYrs = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText()
						.trim();
				System.out.println("Academic year: " + academicYrs);
				// Thread.sleep(2000);

				Thread.sleep(1000);
				if (academicYrs.equals(academicyear)) {
					assertEquals(academicYrs, academicyear);

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[9]//div/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the academic year list grid");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(2000);
		Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		Thread.sleep(2000);
		Assert.assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(1000);

	}

	public void sortByAcademicYear() throws Exception {
		if (btnSortByAcdYear.isDisplayed()) {
			btnSortByAcdYear.click();
			log("Sorted the record with academic year and object is:-" + btnSortByAcdYear.toString());
			Thread.sleep(3000);
		} else {
			log("Sort Button element not present.");
			Thread.sleep(500);
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
}
