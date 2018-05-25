/**
 * 
 */
package com.test.automation.uiAutomation.BGHS_Admission;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class Masters_Academic_Year extends TestBase{
	
	public static final Logger log = Logger.getLogger(Masters_Academic_Year.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[1]")
	WebElement btnMasters_AcademicYr;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_academicYearMsgDispaly;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
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
	

	public Masters_Academic_Year(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission Masters Academic year
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_AcademicYear_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_AcademicYr);

		btnMasters_AcademicYr.click();
		log("Clicked on academic year Button and object is:-" + btnMasters_AcademicYr.toString());
		waitForElement(driver, 10, btnSave);
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
	
	public void enterMastersAcademicYearDetails(String FromAcademicYr, String startdate, String end_date,
			String preAdmStartDate, String preAdmEndDate, String academicYrOrder, String cutoffDate,
			String instituition) throws Exception{
		
		input_FromYear.clear();
		input_FromYear.sendKeys(FromAcademicYr);
		input_ToYear.click();
		log("Entered Academic from year "+FromAcademicYr+" and object is:-"+input_FromYear.toString());
		
		try{
		String toyr = input_ToYear.getAttribute("value");
		System.out.println("To Year: "+toyr);

		Assert.assertEquals(Integer.parseInt(toyr)-1, Integer.parseInt(FromAcademicYr));
		log("To year is +1Yr of From year for academic year");
		}
		catch(Exception e){
			log("To year is not +1Yr of From year for academic year");
		}
		try{
		copyToClipbord(startdate);

		oAction = new Actions(driver);
		oAction.moveToElement(inputAcad_StartDate);
		oAction.contextClick(inputAcad_StartDate).build().perform();

		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered start date for academic year " + startdate + " and object is:-" + inputAcad_StartDate.toString());
		Thread.sleep(2000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			copyToClipbord(end_date);

			oAction = new Actions(driver);
			oAction.moveToElement(inputAcad_EndDate);
			oAction.contextClick(inputAcad_EndDate).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered end date for academic year " + end_date + " and object is:-" + inputAcad_EndDate.toString());
			Thread.sleep(2000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		try{
			copyToClipbord(preAdmStartDate);

			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_StartDate);
			oAction.contextClick(inputPreAdm_StartDate).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered start date for preadmission " + preAdmStartDate + " and object is:-" + inputPreAdm_StartDate.toString());
			Thread.sleep(2000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		try{
			copyToClipbord(preAdmEndDate);

			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_EndDate);
			oAction.contextClick(inputPreAdm_EndDate).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered end date for preadmission " + preAdmEndDate + " and object is:-" + inputPreAdm_EndDate.toString());
			Thread.sleep(2000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		inputAcdYr_Order.clear();
		inputAcdYr_Order.sendKeys(academicYrOrder);
		log("Entered Academic year order "+academicYrOrder+" and object is:-"+inputAcdYr_Order.toString());
		
		
		try{
			copyToClipbord(cutoffDate);

			oAction = new Actions(driver);
			oAction.moveToElement(inputPreAdm_CutOffDate);
			oAction.contextClick(inputPreAdm_CutOffDate).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered cut off date for preadmission " + cutoffDate + " and object is:-" + inputPreAdm_CutOffDate.toString());
			Thread.sleep(2000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		select = new Select(sel_Institution);
		select.selectByVisibleText(instituition);
		log("selected instituition for academic year:-" + instituition + " and object is " + sel_Institution.toString());
		Thread.sleep(1000);

		WebElement option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), instituition);
		Thread.sleep(1000);
	}
	
	public void minimizeAcademicYear() throws Exception {
		btnMin_MaxAcdYrMaster.click();
		log("clicked on academic year minimize button and object is:-" + btnMin_MaxAcdYrMaster.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on Save button and object is:-" + btnSave.toString());
		// waitForElement(driver, 20, btnOKSuccess);
		Thread.sleep(15000);
		
	}

	public void clickOnClearButton() throws Exception {
		btnClear.click();
		log("clicked on clear button and object is:-" + btnClear.toString());
		waitForElement(driver, 20, btn_Admission);
	}

	public void maximizeAcademicYear() throws Exception {
		btnMin_MaxAcdYrMaster.click();
		log("clicked on academic year maximize button and object is:-" + btnMin_MaxAcdYrMaster.toString());
		Thread.sleep(1000);
	}

	public void minimizeAcademicYearGrid() {

		btnMin_MaxAcdYrGrid.click();
		log("Academic year grid table data minimize and object is:-" + btnMin_MaxAcdYrGrid.toString());

	}

	public void maximizeAcademicYearGrid() {

		btnMin_MaxAcdYrGrid.click();
		log("Academic year grid table data maximized and object is:-" + btnMin_MaxAcdYrGrid.toString());

	}

	public void searchWithAcademicYear(String academicyear) {
		inputSearch.clear();
		inputSearch.sendKeys(academicyear);
		log("search with academic year in the academic year grid and object is:-" + inputSearch.toString());
	}

	public void editAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String academicYrs = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println("Academic year: " + academicYrs);
			// Thread.sleep(2000);
			try {
				if (academicYrs.equalsIgnoreCase(academicyear)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[8]//div/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the academic year list grid");

					break;
				} else {
					log("Academic year not matched with the academic year list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void deactivateAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String academicYrs = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println("Academic year: " + academicYrs);
			// Thread.sleep(2000);
			try {
				if (academicYrs.equalsIgnoreCase(academicyear)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[8]//div/span"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the academic year list grid");

					break;
				} else {
					log("Academic year not matched with the academic year list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void activateAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String academicYrs = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println("Academic year: " + academicYrs);
			// Thread.sleep(2000);
			try {
				if (academicYrs.equalsIgnoreCase(academicyear)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[8]//div/span"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the academic year list grid");

					break;
				} else {
					log("Academic year not matched with the academic year list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deleteAcademicYears(String academicyear) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String academicYrs = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println("Academic year: " + academicYrs);
			// Thread.sleep(2000);
			try {
				if (academicYrs.equalsIgnoreCase(academicyear)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[8]//div/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the academic year list grid");

					break;
				} else {
					log("Academic year not matched with the academic year list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void yesDeleteOrDeactivateOrActivateIt() throws Exception{
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"+btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}
	
	public void clickOnCancelButton() throws Exception{
		
		btnCancel.click();
		log("Clicked on cancel button and object is:-"+btnCancel.toString());
		Thread.sleep(15000);
	}
	
	public void sortByAcademicYear() throws Exception{
		btnSortByAcdYear.click();
		log("Sorted the record with academic year and object is:-"+btnSortByAcdYear.toString());
		Thread.sleep(3000);
	}
}
