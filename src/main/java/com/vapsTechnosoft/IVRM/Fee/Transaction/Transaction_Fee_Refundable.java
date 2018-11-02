///**
// * 
// */
//package com.vapsTechnosoft.IVRM.Fee.Transaction;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//
//import com.vapsTechnosoft.IVRM.testBase.TestBase;
//
///**
// * @author Arvind
// *
// */
//public class Transaction_Fee_Refundable extends TestBase{
//	
//	public static final Logger log = Logger.getLogger(Transaction_Fee_Refundable.class.getName());
//
//	private WebDriver driver;
//	private Select select;
//	private WebElement option;
//
//	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
//	private WebElement btnHome;
//
//	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
//	private WebElement btn_Fee;
//
//	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]")
//	private WebElement btn_FeeTransaction;
//
////	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]/following::li[6]")
////	private WebElement btn_FeeChequeBounce;
//	
//	@FindBy(xpath = "//a[@href='#/app/FeeRefundable/91']")
//	private WebElement btn_FeeRefundable;
//
//	@FindBy(xpath = "//div//section//ol//li")
//	private WebElement txt_FeeRefundable;
//
//	@FindBy(xpath = "//select[@name='academicyear']")
//	WebElement sel_AcademicYear;
//
//	@FindBy(xpath = "//select[@name='clsname']")
//	WebElement sel_Class;
//
//	@FindBy(xpath = "//select[@name='stu_Section']")
//	WebElement sel_Section;
//	
//	@FindBy(xpath = "//select[@name='studentname']")
//	WebElement sel_StudentName;
//	
//	@FindBy(xpath = "//input[@value='Refunable']")
//	WebElement rdBtn_Refundable;
//	
//	@FindBy(xpath = "//input[@value='NonRefunable']")
//	WebElement rdBtn_NonRefundable;
//	
//	@FindBy(xpath = "//input[@name='roleG']")
//	WebElement chk_FeeGroup;
//	
//	@FindBy(xpath = "//input[@name='recno']")
//	WebElement input_VoucherNo;
//	
//	@FindBy(xpath = "(//label[contains(text(),'Refund Date :')]/following-sibling::div//child::button)[1]")
//	private WebElement btn_Calender;
//
//	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
//	WebElement btn_MonthYear;
//
//	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]/following::td[3]")
//	WebElement btn_Date;
//
//	@FindBy(xpath = "//span[contains(text(),'View Fee Details')]")
//	WebElement view_FeeDetails;
//	
//	@FindBy(xpath = "(//button[text()='Close'])[1]")
//	WebElement view_Close;
//	
//	@FindBy(xpath = "//textarea[@id='comment']")
//	WebElement input_Remarks;
//
//	@FindBy(xpath = "//label[contains(text(),'Search For:')]/following-sibling::div/select")
//	WebElement sel_SearchFor;
//
//	@FindBy(xpath = "//label[contains(text(),'Search Text:')]/following-sibling::div/input")
//	WebElement input_Search;
//
//	@FindBy(xpath = "//button[@name='btn_search']")
//	WebElement btn_Search;
//
//	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
//	WebElement btn_Save;
//
//	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
//	WebElement btn_Cancel;
//	
//	@FindBy(xpath = "//button[text()='OK']")
//	private WebElement btnOKSuccess;
//	
//	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
//	WebElement successfulMessage;
//
////	@FindBy(xpath = "(//body[@id='style-4']//div/input)[5]")
////	WebElement inputSearch;
//
//	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
//	List<WebElement> tblRows;
//
//	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
//	WebElement btnPopUpYesDeleteit;
//	
//	@FindBy(xpath = "//button[text()='Cancel']")
//	WebElement btn_PopUpCancel;
//	
//	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
//	private WebElement btnMin_MaxFeeChequeBounce;
//
//	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
//	private WebElement btnMin_MaxFeeChequeBounceGridView;
//	
//
//	public Transaction_Fee_Refundable(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//
//	public boolean verifyHomeButton() {
//		try {
//			btnHome.isDisplayed();
//			log("Home button is dispalyed and object is:-" + btnHome.toString());
//			Thread.sleep(3000);
//			return true;
//
//		} catch (Exception e) {
//			return false;
//		}
//
//	}
//
//	/**
//	 * Navigate to Fee Transaction Cheque Bounce
//	 * 
//	 * @throws Exception
//	 */
//	public void navigateToFeeTransaction_ChequeBounce() throws Exception {
//
//		if (btn_Fee.isDisplayed()) {
//			btn_Fee.click();
//			log("Clicked on Fee Button and object is:-" + btn_Fee.toString());
//			// waitForElement(driver, 10, btnFee);
//			Thread.sleep(1000);
//		} else {
//			log("Fee Navigation element not present.");
//			Thread.sleep(500);
//		}
//		if (btn_FeeTransaction.isDisplayed()) {
//			btn_FeeTransaction.click();
//			log("Clicked on Fee Transaction Button and object is:-" + btn_FeeTransaction.toString());
//			// waitForElement(driver, 10, feeMasters);
//			Thread.sleep(1000);
//		} else {
//			log("Fee Transaction Navigation element not present.");
//			Thread.sleep(500);
//		}
//		if (btn_FeeChequeBounce.isDisplayed()) {
//			btn_FeeChequeBounce.click();
//			log("Clicked on Fee Cheque Bounce Button and object is:-" + btn_FeeChequeBounce.toString());
//			// waitForElement(driver, 10, btnCustomFeeGr);
//			Thread.sleep(1000);
//		} else {
//			log("Fee Cheque Bounce Navigation element not present.");
//			Thread.sleep(500);
//		}
//	}
//
//	/**
//	 * Validation of Fee Cheque Bounce screen message
//	 * 
//	 * @return
//	 */
//	public boolean verifyFeeChequeBouncePage() {
//		try {
//			System.out.println(txt_FeeChequeBounce.getText());
//			txt_FeeChequeBounce.isDisplayed();
//			log("Fee Cheque Bounce page is dispalyed and object is:-" + txt_FeeChequeBounce.toString());
//			Thread.sleep(1000);
//			return true;
//
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	/**
//	 * Fee Cheque bounce form
//	 * 
//	 * @param academicYear
//	 * @param stu_Class
//	 * @param studentName
//	 * @param receiptNo
//	 * @param remarks
//	 * @throws Exception
//	 */
//	public void fill_FeeChequeBounce_Form(String academicYear, String stu_Class, String studentName, String receiptNo,
//			String remarks) throws Exception {
//		if (sel_AcademicYear.isDisplayed()) {
//
//			select = new Select(sel_AcademicYear);
//			select.selectByVisibleText(academicYear);
//
//			log("Selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), academicYear);
//			Thread.sleep(1000);
//		} else {
//			log("Academic Year element is not present");
//			Thread.sleep(500);
//		}
//		if (sel_Class.isDisplayed()) {
//
//			select = new Select(sel_Class);
//			select.selectByVisibleText(stu_Class);
//
//			log("Selected Class: " + stu_Class + " and object is:- " + sel_Class.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), stu_Class);
//			Thread.sleep(1000);
//		} else {
//			log("Class element is not present");
//			Thread.sleep(500);
//		}
//		if (sel_StudentName.isDisplayed()) {
//
//			select = new Select(sel_StudentName);
//			select.selectByVisibleText(studentName);
//
//			log("Selected Student: " + studentName + " and object is:- " + sel_StudentName.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), studentName);
//			Thread.sleep(1000);
//		} else {
//			log("Student Name element is not present");
//			Thread.sleep(500);
//		}
//		if (sel_ReceiptNo.isDisplayed()) {
//
//			select = new Select(sel_ReceiptNo);
//			select.selectByVisibleText(receiptNo);
//
//			log("Selected Receipt Number: " + receiptNo + " and object is:- " + sel_ReceiptNo.toString());
//			option = select.getFirstSelectedOption();
//			Assert.assertEquals(option.getText().trim(), receiptNo);
//			Thread.sleep(1000);
//		} else {
//			log("Receipt Number element is not present");
//			Thread.sleep(500);
//		}
//
//		if (btn_Calender.isDisplayed()) {
//			btn_Calender.click();
//			Thread.sleep(500);
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
//			Thread.sleep(500);
//			btn_Date.click();
//			log("Date is selected from calender.");
//			Thread.sleep(1000);
//		} else {
//			log("Date Calendar button element not present.");
//			Thread.sleep(500);
//		}
//		if (input_Remarks.isDisplayed()) {
//			input_Remarks.clear();
//			input_Remarks.sendKeys(remarks);
//			log("Remarks is enter as" + remarks + " and object is:- " + input_Remarks.toString());
//			Thread.sleep(1000);
//		} else {
//			log("Remarks element is not present.");
//			Thread.sleep(500);
//		}
//	}
//
//	/**
//	 * Submit blank cheque bounce form
//	 * 
//	 * @throws Exception
//	 */
//	public void submitBlank_FeeChequeBounceForm() throws Exception {
//		if (btn_Save.isDisplayed()) {
//			btn_Save.click();
//			log("Submit blank Fee Cheque Bounce form and object is:-" + btn_Save.toString());
//			Thread.sleep(5000);
//		} else {
//			log("Save button element not present.");
//			Thread.sleep(500);
//		}
//	}
//
//
//}
