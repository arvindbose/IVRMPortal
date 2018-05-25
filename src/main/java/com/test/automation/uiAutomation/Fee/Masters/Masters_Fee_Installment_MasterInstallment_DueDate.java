/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Installment_MasterInstallment_DueDate extends TestBase{

	public static final Logger log = Logger.getLogger(Masters_Fee_Installment_MasterInstallment_DueDate.class.getName());

	WebDriver driver;
	Select select;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[3]")
	WebElement btnFeeInstallment;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[2]")
	WebElement selAcademicYear;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[3]")
	WebElement selInstallmentType;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeInstallmentScreen;
	
	@FindBy(xpath = "//h3[contains(text(),'Fee Master Instalment Grid View')]")
	WebElement txtFMasterInstGridView;
	
	@FindBy(xpath = "(//button[@id='save-btn'])[2]")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='well text-center']/button)[2]")
	WebElement btnClear;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;
	
	@FindBy(xpath = "//body[@id='style-4']//md-tab-item[2]/span")
	WebElement tabMasterInstallmentDueDate;
	
	@FindBy(xpath = "//md-tab-content[@id='tab-content-2']//div/table/tbody/tr[1]/td[4]/md-datepicker/button")
	WebElement btnCalendar;
	
	@FindBy(xpath = "//div[@id='md-date-pane-3']/div[2]/md-calendar//div/div[2]/table/tbody[1]/tr[1]/td[1]")
	WebElement april2017;
	
	@FindBy(xpath = "//div[@id='md-date-pane-3']/div[2]/md-calendar//div/div[2]/table/tbody[1]/tr[1]/td[1]//following::td[6]")
	WebElement thirdApril2017;
	
//	@FindBy(xpath = "//div[@id='md-date-pane-3']/div[2]//div/table/tbody[1]")
//	WebElement monthApril2017;
	
	@FindBy(xpath = "//md-tab-content[@id='tab-content-2']//div/table/tbody/tr[1]/td[4]/md-datepicker/div/input")
	WebElement calendarInput;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */

	public Masters_Fee_Installment_MasterInstallment_DueDate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Home button verification/display
	 * 
	 * @return
	 */
	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void nevigateToFeeInstallment_MasterInstallmentDueDate() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);

		btnFeeInstallment.click();
		log("Clicked on Fee Installment Button and object is:-" + btnFeeInstallment.toString());
		Thread.sleep(1000);
	}
	public boolean verifyFeeInstallmentScreen_DueDate() {
		try {
			System.out.println(txtFeeInstallmentScreen.getText());
			txtFeeInstallmentScreen.isDisplayed();
			log("Fee Installment screen page is dispalyed and object is:-" + txtFeeInstallmentScreen.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public boolean verifyMasterInstallmentDueDateTab() {
		try {
			System.out.println(tabMasterInstallmentDueDate.getText());
			tabMasterInstallmentDueDate.isDisplayed();
			log("Master Installment Due date tab is present and object is:-" + tabMasterInstallmentDueDate.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public void navigateToMasterInstallmentDueDateTab() throws Exception{
		tabMasterInstallmentDueDate.click();
		log("Clicked master installment due date and object is:-"+tabMasterInstallmentDueDate.toString());
		Thread.sleep(1000);
	}
	public void selectAcademicYearAndInstallmentType(String academicYear,String installmentType) throws Exception{
		
		select = new Select(selAcademicYear);
		select.selectByVisibleText(academicYear);
		log("selected academic year:-" + academicYear + " and object is " + selAcademicYear.toString());
		Thread.sleep(1000);
		
		select = new Select(selInstallmentType);
		select.selectByVisibleText(installmentType);
		log("selected installment type:-" + installmentType + " and object is " + selInstallmentType.toString());
		Thread.sleep(1000);
	}
	public void dueDateCalendarEntry() throws Exception{
		btnCalendar.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", thirdApril2017);
		Thread.sleep(2000);
		thirdApril2017.click();
		
	}
	public void clickOnSaveButton() throws Exception{
		btnSave.click();
		log("clicked on save button and object is:-"+btnSave.toString());
		Thread.sleep(2000);
	}
	public boolean verifySuccessfulPopUp(){
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public void clickOnSuccessOkBtn() throws Exception{
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-"+btnOkonSuccess.toString());
		Thread.sleep(3000);
	}
}
