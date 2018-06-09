/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Transaction;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class Transaction_Fee_Transaction extends TestBase {

	public static final Logger log = Logger.getLogger(Transaction_Fee_Transaction.class.getName());

	WebDriver driver;
	Select select;
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[3]")
	WebElement btnTransaction;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[3]/ul/li[3]")
	WebElement btnFee_Transaction;

	@FindBy(xpath = "//span[contains(text(),'Regular')]")
	WebElement rdbtn_Regular;

	@FindBy(xpath = "//md-datepicker[@id='reservation']/div/input")
	WebElement inputDate;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement dselAcademicYear;

	@FindBy(xpath = "(//div[@id='sel1']/div)[1]")
	WebElement inputStudentName;

	@FindBy(xpath = "//*[@id='sel1']/input[1]")
	WebElement txtStudentName;

	@FindBy(xpath = "//span[contains(text(),'New Admission Fees')]")
	WebElement chkNewAdmFee;

	@FindBy(xpath = "//span[contains(text(),'suresh fee group1')]")
	WebElement chkSureshFeeGr1;

	@FindBy(xpath = "//div[@id='sel1']/div[1]/span/i")
	WebElement selIcon;

	/**
	 * Student Information location
	 */
	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[1]")
	WebElement txt_StudentFirstName;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[2]")
	WebElement txt_StudentAdmNo;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[3]")
	WebElement txt_StudentRollNo;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[4]")
	WebElement txt_StudentMobNo;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[5]")
	WebElement txt_StudentClass;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[6]")
	WebElement txt_Section;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[7]")
	WebElement txt_Father;

	@FindBy(xpath = "(//div[@class='well text-bold sinfo']/div/div[2])[8]")
	WebElement txt_StudentDoB;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txt_FeeTransaction;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[1]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//textarea[@id='Narration']")
	WebElement input_narration;

	@FindBy(xpath = "//span[contains(text(),'Bank')]")
	WebElement rdbtn_Bank;

	@FindBy(xpath = "//input[@id='chequeno']")
	WebElement input_ChequeNo;

	@FindBy(xpath = "//body[@id='style-4']//div/div[4]/div[3]/div/input")
	WebElement input_bankname;

	@FindBy(xpath = "//md-datepicker[@id='chequedddate']/button")
	WebElement btnCalendar;

	@FindBy(xpath = "//td[@id='md-2-month-2017-11-12']/span")
	WebElement chequeDate;

	@FindBy(xpath = "//md-datepicker[@id='chequedddate']/div/input")
	WebElement inputchequeDate;

	/**
	 * Save cancel and success message validation
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr")
	List<WebElement> outputTblRows;

	@FindBy(xpath = "(//select[@id='sel1'])[3]")
	WebElement selSearch;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[2]/div[2]/div[1]/div/input")
	WebElement inputSearchStu;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[2]/div[3]/div/button[1]")
	WebElement btnSearch;

	@FindBy(xpath = "//button[contains(text(),'Print')]/following-sibling::Button")
	WebElement btnFeeReceiptClose;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesSaveIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpRecordSaveCancel;

	@FindBy(xpath = "//button[contains(text(),'Print')]")
	WebElement btnReceiptPrint;
	
	

	@FindBy(xpath = "//*[@id='print-header']/div/button[1]")
	WebElement btnPrint;

	public Transaction_Fee_Transaction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void nevigateTo_FeeTransaction() throws Exception {
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);

		btnTransaction.click();
		log("Clicked on Transaction Button and object is:-" + btnTransaction.toString());
		Thread.sleep(1000);

		btnFee_Transaction.click();
		log("Clicked on Fee Transaction Button and object is:-" + btnFee_Transaction.toString());
		Thread.sleep(2000);
	}

	public boolean verifyFeeTransactionPage() {
		try {
			System.out.println(txt_FeeTransaction.getText());
			txt_FeeTransaction.isDisplayed();
			log("Fee Transaction page is dispalyed and object is:-" + txt_FeeTransaction.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void selectRegularButton() throws Exception {
		rdbtn_Regular.click();
		log("Regular radio button selected and object is:-" + rdbtn_Regular.toString());
		Thread.sleep(2000);
	}

	public boolean verifyAcademicYear() {
		try {
			System.out.println(dselAcademicYear.getText());
			dselAcademicYear.isDisplayed();
			log("Academic year is dispalyed and object is:-" + dselAcademicYear.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterStudentNameAndSeelctFeeGrCheck(String studentName) throws Exception {

		copyToClipbord(studentName);
		inputStudentName.click();
		txtStudentName.sendKeys(Keys.chord(Keys.CONTROL, "v"), "");
		Thread.sleep(5000);
		txtStudentName.sendKeys(Keys.TAB);

		waitForElement(driver, 120, chkSureshFeeGr1);

		chkSureshFeeGr1.click();
		log("Select the check box suresh fee group1:" + chkSureshFeeGr1);
		Thread.sleep(2000);
	}

	public void validateStudentInformationData(String stuName, String stuAdmNo, String stuRollNo, String stuMobNo,
			String stuClass, String stuSection, String stuFather, String stuDateOB) {

		try {
			String studentname = txt_StudentFirstName.getText();
			Assert.assertEquals(studentname, stuName);
			log("Student name match with the record and Name:" + txt_StudentFirstName.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student name Not matched with the record and Name:" + txt_StudentFirstName.getText().toString());
		}

		try {
			String admissionNo = txt_StudentAdmNo.getText();
			Assert.assertEquals(admissionNo, stuAdmNo);
			log("Student Adm No matched with the record and Adm No:" + txt_StudentAdmNo.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student Adm No not matched with the record and Adm No:" + txt_StudentAdmNo.getText().toString());
		}

		try {
			String rollNum = txt_StudentRollNo.getText();
			Assert.assertEquals(rollNum, stuRollNo);
			log("Student roll No matched with the record and Roll No:" + txt_StudentRollNo.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student roll No not matched with the record and Roll No:" + txt_StudentRollNo.getText().toString());
		}

		try {
			String mobileNum = txt_StudentMobNo.getText();
			Assert.assertEquals(mobileNum, stuMobNo);
			log("Student mobile No matched with the record and Mobile No:" + txt_StudentMobNo.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student mobile No not matched with the record and Mobile No:" + txt_StudentMobNo.getText().toString());
		}

		try {
			String classValue = txt_StudentClass.getText();
			Assert.assertEquals(classValue, stuClass);
			log("Student class matched with the record and Class:" + txt_StudentClass.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student class not matched with the record and Class:" + txt_StudentClass.getText().toString());
		}

		try {
			String classSection = txt_Section.getText();
			Assert.assertEquals(classSection, stuSection);
			log("Student section matched with the record and section:" + txt_Section.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student section not matched with the record and section:" + txt_Section.getText().toString());
		}
		try {
			String fathername = txt_Father.getText();
			Assert.assertEquals(fathername, stuFather);
			log("Father name matched with the record and Father:" + txt_Father.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Father name not matched with the record and Father:" + txt_Father.getText().toString());
		}

		try {
			String dob = txt_StudentDoB.getText();
			Assert.assertEquals(dob, stuDateOB);
			log("Student date of birth matched with the record and DOB:" + txt_StudentDoB.getText().toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			log("Student date of birth not matched with the record and DOB:" + txt_StudentDoB.getText().toString());
		}

	}

	public void tableEnterPayableAmount(String feeHead, String amount) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String feeheadName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(feeheadName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(feeheadName, feeHead);
				driver.findElement(
						By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[2]/label/input"))
						.click();
				log("Select the check box corresponding to selected fee head:" + feeHead);
				WebElement payAmount = driver.findElement(
						By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr[" + i + "]/td[12]/input"));
				payAmount.clear();
				payAmount.sendKeys(amount);
				log("Enter the amount payable corresponding to selected fee head:" + amount);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void bankDetailsAndNarration(String enterNarration, String chequeNo, String bankName, String chequeDueDate) {
		try {
			input_narration.sendKeys(enterNarration);
			log("Entered narration as" + enterNarration + "and object is:" + input_narration.toString());
			Thread.sleep(2000);

			rdbtn_Bank.click();
			log("Selected bank radio button and object is:-" + rdbtn_Bank.toString());
			Thread.sleep(1000);

			inputchequeDate.clear();
			Thread.sleep(1000);
			inputchequeDate.sendKeys(chequeDueDate);
			log("Entered cheque date:" + chequeDueDate + "and object is:" + input_ChequeNo.toString());
			Thread.sleep(2000);

			input_ChequeNo.sendKeys(chequeNo);
			log("Entered cheque number is:" + chequeNo + "and object is:" + input_ChequeNo.toString());
			Thread.sleep(2000);

			input_bankname.sendKeys(bankName);
			log("Entered bank name:" + bankName + "and object is:" + input_bankname.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			log("check missing bank details");
		}

	}

	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}

	public void afterSavePupUpHandlingCancel() throws Exception {
		btnPopUpRecordSaveCancel.click();
		log("Clicked on record Save cancel button and object is:" + btnPopUpRecordSaveCancel.toString());
		Thread.sleep(5000);
	}

	public void afterSavePupUpHandlingYesSaveit() throws Exception {
		btnPopUpYesSaveIt.click();
		log("Clicked on record Yes Save it button and object is:" + btnPopUpYesSaveIt.toString());
		Thread.sleep(5000);
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(5000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}

	public void validationOfDataInOutputTableGrid(String byStudentName, String StdName) throws Exception {

		select = new Select(selSearch);
		select.selectByVisibleText(byStudentName);
		log("selected Student name for search:-" + byStudentName + " and object is " + selSearch.toString());
		Thread.sleep(1000);
		
		inputSearchStu.clear();
		inputSearchStu.sendKeys(StdName);
		log("Entered student name for search:" + StdName + "and object is:-" + inputSearchStu.toString());
		Thread.sleep(1000);

		btnSearch.click();
		log("clicked on search button and object is:-" + btnSearch.toString());
		Thread.sleep(2000);

		int rows = outputTblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String studName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(studName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(studName, StdName);

				log("Created record is added into the output grid" + studName.toString());
				Thread.sleep(2000);
			} catch (Exception e) {
				log("Creted record is not added into the output grid");
			}
		}
	}

	public void printReceiptValidation(String studentName) throws Exception {

		int rows = outputTblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(stuName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(stuName, studentName);

				log("Creted record is added into the output grid" + stuName.toString());
				Thread.sleep(2000);
			} catch (Exception e) {
				log("Creted record is not added into the output grid");
			}
			try {
				driver.findElement(
						By.xpath("(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr[" + i + "]/td[12]/a[1]"))
						.click();
				log("Clicked on print receipt and receipt is open");
				Thread.sleep(3000);
			} catch (Exception e) {
				log("Clicked on print receipt and receipt not opened");
			}
		}
	}

	public void clickOnFeeReceiptCloseButton() throws Exception {
		btnFeeReceiptClose.click();
		log("Clicked on Fee receipt screen close button");
		Thread.sleep(2000);
	}

	public void clickOnPrintReceiptButton(String byStudentName, String StdName) throws InterruptedException {
		select = new Select(selSearch);
		select.selectByVisibleText(byStudentName);
		log("selected Student name for search:-" + byStudentName + " and object is " + selSearch.toString());
		Thread.sleep(1000);
		inputSearchStu.clear();
		inputSearchStu.sendKeys(StdName);
		log("Entered student name for search:" + StdName + "and object is:-" + inputSearchStu.toString());
		Thread.sleep(1000);

		btnSearch.click();
		log("clicked on search button and object is:-" + btnSearch.toString());
		Thread.sleep(2000);
		
		
		
		int rows = outputTblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(stuName);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(stuName, StdName);

				log("Creted record is added into the output grid" + StdName.toString());
				Thread.sleep(2000);
			} catch (Exception e) {
				log("Creted record is not added into the output grid");
			}
			try {
				driver.findElement(
						By.xpath("(//body[@id='style-4']//div/div[2]/table)[3]/tbody/tr[" + i + "]/td[12]/a[1]"))
						.click();
				log("Clicked on print receipt and receipt is open");
				Thread.sleep(3000);
			} catch (Exception e) {
				log("Clicked on print receipt and receipt not opened");
			}
		}
	}

	public void printOfFeereceipt() throws Exception {

		btnReceiptPrint.click();
		log("Selected print of fee receipt and object is:-" + btnReceiptPrint.toString());
		Thread.sleep(5000);

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    Thread.sleep(5000);
		}
	
	}
}
