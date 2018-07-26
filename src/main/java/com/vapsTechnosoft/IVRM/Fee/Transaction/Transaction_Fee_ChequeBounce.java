/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Transaction;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Transaction_Fee_ChequeBounce extends TestBase {

	public static final Logger log = Logger.getLogger(Transaction_Fee_ChequeBounce.class.getName());

	private WebDriver driver;
	private Select select;
	private WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]")
	private WebElement btn_FeeTransaction;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]/following::li[6]")
	private WebElement btn_FeeChequeBounce;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeChequeBounce;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Student Name:')]/following-sibling::div/select")
	WebElement sel_StudentName;

	@FindBy(xpath = "//label[contains(text(),'Receipt No:')]/following-sibling::div/select")
	WebElement sel_ReceiptNo;

	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_Calender;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Jul 2018')]/following::td[1]/span")
	WebElement btn_Date;

	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement input_Remarks;

	@FindBy(xpath = "//label[contains(text(),'Search For:')]/following-sibling::div/select")
	WebElement sel_SearchFor;

	@FindBy(xpath = "//label[contains(text(),'Search Text:')]/following-sibling::div/input")
	WebElement input_Search;

	@FindBy(xpath = "//button[@name='btn_search']")
	WebElement btn_Search;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btn_Cancel;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	
	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

//	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
//	WebElement inputSearch;

	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeleteit;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btn_PopUpCancel;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeChequeBounce;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeChequeBounceGridView;
	

	public Transaction_Fee_ChequeBounce(WebDriver driver) {
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
	 * Navigate to Fee Transaction Cheque Bounce
	 * 
	 * @throws Exception
	 */
	public void navigateToFeeTransaction_ChequeBounce() throws Exception {

		if (btn_Fee.isDisplayed()) {
			btn_Fee.click();
			log("Clicked on Fee Button and object is:-" + btn_Fee.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Fee Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_FeeTransaction.isDisplayed()) {
			btn_FeeTransaction.click();
			log("Clicked on Fee Transaction Button and object is:-" + btn_FeeTransaction.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee Transaction Navigation element not present.");
			Thread.sleep(500);
		}
		if (btn_FeeChequeBounce.isDisplayed()) {
			btn_FeeChequeBounce.click();
			log("Clicked on Fee Cheque Bounce Button and object is:-" + btn_FeeChequeBounce.toString());
			// waitForElement(driver, 10, btnCustomFeeGr);
			Thread.sleep(1000);
		} else {
			log("Fee Cheque Bounce Navigation element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of Fee Cheque Bounce screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeChequeBouncePage() {
		try {
			System.out.println(txt_FeeChequeBounce.getText());
			txt_FeeChequeBounce.isDisplayed();
			log("Fee Cheque Bounce page is dispalyed and object is:-" + txt_FeeChequeBounce.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Fee Cheque bounce form
	 * 
	 * @param academicYear
	 * @param stu_Class
	 * @param studentName
	 * @param receiptNo
	 * @param remarks
	 * @throws Exception
	 */
	public void fill_FeeChequeBounce_Form(String academicYear, String stu_Class, String studentName, String receiptNo,
			String remarks) throws Exception {
		if (sel_AcademicYear.isDisplayed()) {

			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {

			select = new Select(sel_Class);
			select.selectByVisibleText(stu_Class);

			log("Selected Class: " + stu_Class + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), stu_Class);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_StudentName.isDisplayed()) {

			select = new Select(sel_StudentName);
			select.selectByVisibleText(studentName);

			log("Selected Student: " + studentName + " and object is:- " + sel_StudentName.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), studentName);
			Thread.sleep(1000);
		} else {
			log("Student Name element is not present");
			Thread.sleep(500);
		}
		if (sel_ReceiptNo.isDisplayed()) {

			select = new Select(sel_ReceiptNo);
			select.selectByVisibleText(receiptNo);

			log("Selected Receipt Number: " + receiptNo + " and object is:- " + sel_ReceiptNo.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), receiptNo);
			Thread.sleep(1000);
		} else {
			log("Receipt Number element is not present");
			Thread.sleep(500);
		}

		if (btn_Calender.isDisplayed()) {
			btn_Calender.click();
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(500);
			btn_Date.click();
			log("Date is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Date Calendar button element not present.");
			Thread.sleep(500);
		}
		if (input_Remarks.isDisplayed()) {
			input_Remarks.clear();
			input_Remarks.sendKeys(remarks);
			log("Remarks is enter as" + remarks + " and object is:- " + input_Remarks.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks element is not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Submit blank cheque bounce form
	 * 
	 * @throws Exception
	 */
	public void submitBlank_FeeChequeBounceForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Fee Cheque Bounce form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Click on save button to save Cheque Bounce data
	 * 
	 * @throws Exception
	 */
	public void clickOnSaveButton_ToSubmitChequeBounceForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("clicked on save button to Submit the records for cheque bounce and object is:-" + btn_Save.toString());
			Thread.sleep(3000);
		} else {
			log("Save Element not present");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton_ToClearFilledChequeBounceForm() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("clicked on Cancel button to clear filled data cheque bounce and object is:-" + btn_Cancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * validation of Record saved successfully message
	 * 
	 * @return
	 */
	public boolean verifySuccessfulPopUp() {
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

	/**
	 * click on OK button after Saving the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * Search with Student name
	 * 
	 * @param byStudentName
	 * @param studentName
	 * @throws Exception
	 */
	public void searchByStudentNameInGrid(String byStudentName,String studentName) throws Exception {
		if (sel_SearchFor.isDisplayed()) {

			select = new Select(sel_SearchFor);
			select.selectByVisibleText(byStudentName);

			log("Selected Student: " + byStudentName + " and object is:- " + sel_SearchFor.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), byStudentName);
			Thread.sleep(1000);
		} else {
			log("SearchFor element is not present");
			Thread.sleep(500);
		}
		
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(studentName);
			log("Entered student name for search: " + studentName + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Input Element not present");
			Thread.sleep(500);
		}
		
		if(btn_Search.isDisplayed()){
			btn_Search.click();
			log("Clicked on search button  to filter cheque bounce student details. and object is:-"+btn_Search.toString());
			Thread.sleep(1000);
		}else{
			log("Search button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * verify student name in output grid
	 * 
	 * @param studentName
	 * @throws Exception
	 */
	public void verifyChequeBounceStudentDetailsUpdatedInGrid(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String student_name = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println(student_name);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(student_name, studentName);
				log("Student name is update in the cheque bounce grid:" + student_name);
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	

	/**
	 * Deletion of cheque bounce details updated in the output grid
	 * 
	 * @param studentName
	 * @throws Exception
	 */
	public void deleteChequeBounceDetailsFromGrid(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String student_name = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println(student_name);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(student_name, studentName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[7]/a")).click();
				log("Clicked on delete link in cheque bounce grid");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Confirmation for delete
	 * 
	 * @throws Exception
	 */

	public void confirmationForDelete() throws Exception {
		if (btnPopUpYesDeleteit.isDisplayed()) {
			btnPopUpYesDeleteit.click();
			log("Clicked Yes Delete it button and object is:" + btnPopUpYesDeleteit.toString());
			Thread.sleep(5000);
		} else {
			log("Yes Delete Element not present");
			Thread.sleep(500);
		}
	}
	/**
	 * Delete cancel
	 * 
	 * @throws Exception
	 */

	public void cancel_DeletePopUp() throws Exception{
		if(btn_PopUpCancel.isDisplayed()){
			btn_PopUpCancel.click();
			log("Clicked on cancel button to cancel the deletion of records and object is:-"+btn_PopUpCancel.toString());
			Thread.sleep(1000);
		}else{
			log("Cancel button element is not present.");
			Thread.sleep(500);
		}
	}
	public void min_Max_FeeChequeBounce() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeChequeBounce);
		Thread.sleep(1000);
		if (btnMin_MaxFeeChequeBounce.isDisplayed()) {
			btnMin_MaxFeeChequeBounce.click();
			log("Fee Due Dates Report page minimized or maximized and object is:-"
					+ btnMin_MaxFeeChequeBounce.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Cheque Bounce Minimized Element not present.");
		}
	}

	public void min_Max_FeeChequeBounce_GridView() throws Exception {
		if (btnMin_MaxFeeChequeBounceGridView.isDisplayed()) {
			btnMin_MaxFeeChequeBounceGridView.click();
			log("Fee Cheque Bounce Grid View page minimized or maximized and object is:-"
					+ btnMin_MaxFeeChequeBounceGridView.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Cheque Bounce Grid View Minimized Element not present.");
		}
	}

}
