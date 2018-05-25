/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_Class_Held extends TestBase{
	
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[14]")
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
	
	public Masters_Master_Class_Held(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Class Held
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterClassHeld_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterClassHeld);

		btnMasters_masterClassHeld.click();
		log("Clicked on master Class Held Button and object is:-" + btnMasters_masterClassHeld.toString());
		waitForElement(driver, 10, btnSave);

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
			log("Master class held page is dispalyed and object is:-" + txtMasters_masterClassHeldMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterClassHeldData(String academicYear, String className, String section) throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtMasters_masterClassHeldMsgDispaly);
		Thread.sleep(2000);
		
		Select dropdown = new Select(selAcademicYear);
		WebElement dropdownOption = dropdown.getFirstSelectedOption();
		String SelectedContent = dropdownOption.getText().trim();
		System.out.println("selected Value " + SelectedContent);
		Assert.assertEquals(SelectedContent, academicYear);
		log("selected academic year: " + SelectedContent + " and object is:- " + selAcademicYear.toString());
		Thread.sleep(1000);
		
		
		select = new Select(selClass);
		select.selectByVisibleText(className);
		log("selected class: " + className + " and object is:- " + selClass.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), className);
		Thread.sleep(1000);

		select = new Select(selSection);
		select.selectByVisibleText(section);
		log("selected section: " + section + " and object is:- " + selSection.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), section);
		Thread.sleep(1000);

	}
	public void submitBlankMasterClassHeldForm() throws Exception {

		btnSave.click();
		log("Submit blank master class held form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void clearClassHeldInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled class held info and object is:-" + btnCancelClear.toString());
		Thread.sleep(10000);
	}

	public void submitFilledMasterClassHeldForm() throws Exception {

		btnSave.click();
		log("Save filled master class held form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}


	public void minimizeMasterClassHeld() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtMasters_masterClassHeldMsgDispaly);
		Thread.sleep(2000);
		
		
		btnMin_MaxMasterClassHeld.click();
		log("clicked on master Class Held minimize button and object is:-" + btnMin_MaxMasterClassHeld.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterClassHeld() throws Exception {
		btnMin_MaxMasterClassHeld.click();
		log("clicked on master Class Held maximize button and object is:-" + btnMin_MaxMasterClassHeld.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterClassHeldTable() throws Exception {

		btnMin_MaxMasterClassHeldTable.click();
		log("Master Class Held list table data minimize and object is:-" + btnMin_MaxMasterClassHeldTable.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterClassHeldTable() throws Exception {

		btnMin_MaxMasterClassHeldTable.click();
		log("Master Class Held table data maximized and object is:-" + btnMin_MaxMasterClassHeldTable.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
	public void updateWithMonthwiseClassHeldData(String classHeld) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			WebElement chkMonthWise = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[1]/label/input"));
			
			if(!chkMonthWise.isSelected()){
				chkMonthWise.click();
				Thread.sleep(2000);
				log("For "+i+" month class held check box checked");
			}
			
			else{
				log("For "+i+" month class held check box already checked");
				Thread.sleep(2000);
			}
			
			WebElement MonthWiseclassHeld = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[3]/input"));
			MonthWiseclassHeld.clear();
			MonthWiseclassHeld.sendKeys(classHeld);
			Thread.sleep(2000);
			log("Entered class held for "+i+" month");
			
		}
	}

	

	
}
