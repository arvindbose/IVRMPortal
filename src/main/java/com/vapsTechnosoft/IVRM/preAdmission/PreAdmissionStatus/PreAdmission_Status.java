/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.PreAdmissionStatus;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class PreAdmission_Status extends TestBase {

	public static final Logger log = Logger.getLogger(PreAdmission_Status.class.getName());

	private WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Preadmission Status')][1]")
	private WebElement btn_PreadmissionStatus;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Preadmission Status')][1]/following::li[1]")
	private WebElement btn_Status;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_PreadmissionStatusPage;

	@FindBy(xpath = "//div[@class='well']//label[1]/input")
	private WebElement rdBtn_ApplicationStatus;

	@FindBy(xpath = "//div[@class='well']//label[2]/input")
	private WebElement rdBtn_AdmissionStatus;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class: ')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Status: ')]/following-sibling::div/select")
	private WebElement sel_Status;

	@FindBy(xpath = "//span[contains(text(),'Search')]/parent::button")
	private WebElement btn_Search;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "//span[contains(text(),'Print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//select[@id='sel2' and @name='stu_stat']")
	private WebElement sel_UpdateStatusAll;

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement input_search;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[7]/a")
	private WebElement sort_StudentName;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[8]/a")
	private WebElement sort_AdmittedClass;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[10]/a")
	private WebElement sort_sexGender;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[11]/a")
	private WebElement sort_RegNo;

	@FindBy(xpath = "(//table)[1]/thead/tr/th[2]/label/input")
	private WebElement chk_AllRecords;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[2]/label/input")
	private WebElement chk_FirstStudent;

	@FindBy(xpath = "(//table)[1]/tbody/tr[1]/td[5]/input")
	private WebElement input_remarks;

	@FindBy(xpath = "//input[@ng-model='email']")
	private WebElement chk_Email;

	@FindBy(xpath = "//input[@ng-model='sms']")
	private WebElement chk_SmS;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	private WebElement btn_CancelEmailSms;

	@FindBy(xpath = "//input[@name='email_subject']")
	private WebElement input_email_subject;

	@FindBy(xpath = "//input[@name='email_header']")
	private WebElement input_email_header;

	@FindBy(xpath = "//textarea[@name='email_footer']")
	private WebElement input_email_Message;

	@FindBy(xpath = "//input[@name='footer']")
	private WebElement input_email_footer;

	@FindBy(xpath = "//textarea[@name='smscontent']")
	private WebElement input_smsContent;

	@FindBy(xpath = "(//span[contains(text(),'Update Status')]/parent::button)[1]")
	private WebElement btn_UpdateStatus;
	
	@FindBy(xpath = "(//span[contains(text(),'Update Status')]/parent::button)[2]")
	private WebElement btn_UpdateStatusPopUp;
	
	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement btnPopUp_Yes_UpdateStatus;

	@FindBy(xpath = "//div[@class='sa-button-container']/button")
	private WebElement btnPopUp_Cancel_UpdateStatus;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	

	public PreAdmission_Status(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to PreAdmission > PreAdmission Status > Status
	 * 
	 * @throws Exception
	 */
	public void navigateToPreAdmission_Status() throws Exception {
		if (btn_PreAdmission.isDisplayed()) {
			btn_PreAdmission.click();
			log("Clicked on PreAdmission Button and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("PreAdmission button element not present and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(500);
		}
		if (btn_PreadmissionStatus.isDisplayed()) {
			btn_PreadmissionStatus.click();
			log("Clicked on PreAdmission Status and object is:-" + btn_PreadmissionStatus.toString());
			Thread.sleep(1000);
		} else {
			log("PreAdmission Status button element not present and object is:-" + btn_PreadmissionStatus.toString());
			Thread.sleep(500);
		}
		if (btn_Status.isDisplayed()) {
			btn_Status.click();
			log("Clicked on Status Button and object is:-" + btn_Status.toString());
			Thread.sleep(1000);
		} else {
			log("Status button element not present and object is:-" + btn_Status.toString());
			Thread.sleep(500);
		}

	}

	/**
	 * Validation ofPreAdmission > PreAdmission Status > Status screen message
	 * 
	 * @return
	 */
	public boolean verifyPreAdmission_StatusPage() {
		try {
			System.out.println(txt_PreadmissionStatusPage.getText());
			txt_PreadmissionStatusPage.isDisplayed();
			log("PreAdmission Status page is dispalyed and object is:-" + txt_PreadmissionStatusPage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_PreadmissionStatusForm() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Submit blank Preadmission Status form and object is:-" + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search to get records button element not present and object is:-" + btn_Search.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Pre Admission Status for Application status
	 * 
	 * @param academicYear
	 * @param class_status
	 * @param status
	 * @throws Exception
	 */
	public void fillPreAdmissionStatusForm_ApplicationStatus(String academicYear, String class_status, String status)
			throws Exception {
		if (!rdBtn_ApplicationStatus.isSelected()) {
			rdBtn_ApplicationStatus.click();
			log("Application status radio button is selected and object is:-" + rdBtn_ApplicationStatus.toString());
			Thread.sleep(1000);
		} else {
			log("Application status radio button element is not present and object is:-"
					+ rdBtn_ApplicationStatus.toString());
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_status);

			log("Selected Class: " + class_status + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_status);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_Class.toString());
			Thread.sleep(500);
		}
		if (sel_Status.isDisplayed()) {
			select = new Select(sel_Status);
			select.selectByVisibleText(status);

			log("Selected Status: " + class_status + " and object is:- " + sel_Status.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), status);
			Thread.sleep(1000);
		} else {
			log("status element is not present and object is:- " + sel_Status.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Pre Admission Status for Admission status
	 * 
	 * @param academicYear
	 * @param class_status
	 * @param status
	 * @throws Exception
	 */

	public void fillPreAdmissionStatusForm_AdmissionStatus(String academicYear, String class_status, String status)
			throws Exception {
		if (!rdBtn_AdmissionStatus.isSelected()) {
			rdBtn_AdmissionStatus.click();
			log("Admission status radio button is selected and object is:-" + rdBtn_AdmissionStatus.toString());
			Thread.sleep(1000);
		} else {
			log("Admission status radio button element is not present and object is:-"
					+ rdBtn_AdmissionStatus.toString());
			Thread.sleep(500);
		}

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_status);

			log("Selected Class: " + class_status + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_status);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_Class.toString());
			Thread.sleep(500);
		}
		if (sel_Status.isDisplayed()) {
			select = new Select(sel_Status);
			select.selectByVisibleText(status);

			log("Selected Status: " + class_status + " and object is:- " + sel_Status.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), status);
			Thread.sleep(1000);
		} else {
			log("status element is not present and object is:- " + sel_Status.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnSearchTo_GetRecords() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Submit filled Preadmission Status form and object is:-" + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search to get records button element not present and object is:-" + btn_Search.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnCancelTo_ClearFilledData_Status() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clear filled form and object is:-" + btn_Cancel.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel button element not present and object is:-" + btn_Cancel.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnExportToExcel() throws Exception {
		if (btn_ExportToExcel.isDisplayed()) {
			btn_ExportToExcel.click();
			log("Export To Excel Report button is clicked to DownLoad report and object is:-"
					+ btn_ExportToExcel.toString());
			Thread.sleep(10000);
		} else {
			log("Export To Excel button element is not present and object is:-" + btn_ExportToExcel.toString());
			Thread.sleep(500);
		}
	}
	public void clickOnPrint_withoutSelectingRecord() throws Exception {

	
		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate print preview report and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

		} else {
			log("Print button element is not present and object is:-" + btn_Print.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnPrint() throws Exception {

		String parentWin = driver.getWindowHandle();

		if (btn_Print.isDisplayed()) {
			btn_Print.click();
			log("Print button is clicked to generate print preview report and object is:-" + btn_Print.toString());
			Thread.sleep(5000);

		} else {
			log("Print button element is not present and object is:-" + btn_Print.toString());
			Thread.sleep(500);
		}

		Set<String> allWin = driver.getWindowHandles();

		System.out.println("Page title before Switching : " + driver.getTitle());
		System.out.println("Total Windows : " + allWin.size());

		for (String windows : allWin) {
			// if(!windows.equals(parentWin)){
			driver.switchTo().window(windows);

			if (driver.getTitle().toLowerCase().contains("Print")) {
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
				Thread.sleep(5000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
	}

	public void update_StatusforAllStudent(String status_All) throws Exception {
		if (sel_UpdateStatusAll.isDisplayed()) {
			select = new Select(sel_UpdateStatusAll);
			select.selectByVisibleText(status_All);

			log("Selected Status: " + status_All + " and object is:- " + sel_UpdateStatusAll.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), status_All);
			Thread.sleep(1000);
		} else {
			log("Update Status all element is not present and object is:- " + sel_UpdateStatusAll.toString());
			Thread.sleep(500);
		}
	}

	public void searchForStudent_InStatusDetails(String studentName) throws Exception {
		if (input_search.isDisplayed()) {
			input_search.clear();
			input_search.sendKeys(studentName);
			log("Entered Student name:-" + studentName + " and object is " + input_search.toString());
			Thread.sleep(1000);
		} else {
			log("Search element in Status details not present and object is:-" + input_search.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithStudentNameInStatusDetails() throws Exception {

		if (sort_StudentName.isDisplayed()) {
			sort_StudentName.click();
			log("Sort by Student Name in Status Details and object is:- " + sort_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name button element not present in Status Details and object is:- "
					+ sort_StudentName.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithGenderSexInStatusDetails() throws Exception {

		if (sort_sexGender.isDisplayed()) {
			sort_sexGender.click();
			log("Sort by sex in Status Details and object is:- " + sort_sexGender.toString());
			Thread.sleep(1000);
		} else {
			log("sex button element not present in Status Details and object is:- " + sort_sexGender.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithRegistrationNumberInStatusDetails() throws Exception {

		if (sort_RegNo.isDisplayed()) {
			sort_RegNo.click();
			log("Sort by Registration Number in Status Details and object is:- " + sort_RegNo.toString());
			Thread.sleep(1000);
		} else {
			log("Registration Number button element not present in Status Details and object is:- "
					+ sort_RegNo.toString());
			Thread.sleep(500);
		}
	}

	public void generateReportForAllStudent_ClickHeaderCheckBox() throws Exception {
		if (!chk_AllRecords.isSelected()) {
			chk_AllRecords.click();
			log("All Records check box is selected in Status details and object is:-" + chk_AllRecords.toString());
			Thread.sleep(1000);
		} else {
			log("All Records check box element is not present in Status details and object is:-"
					+ chk_AllRecords.toString());
			Thread.sleep(500);
		}
	}

	public void selectSpecificStudentStatusReport(String remarks) throws Exception {
		if (!chk_FirstStudent.isSelected()) {
			chk_FirstStudent.click();
			log("First Records check box is selected in Status details and object is:-" + chk_FirstStudent.toString());
			Thread.sleep(1000);
		} else {
			log("First Records check box element is already selected in Status details and object is:-"
					+ chk_FirstStudent.toString());
			Thread.sleep(500);
		}
		if (input_remarks.isDisplayed()) {
			input_remarks.clear();
			input_search.sendKeys(remarks);
			log("Entered Remarks:-" + remarks + " and object is " + input_remarks.toString());
			Thread.sleep(1000);
		} else {
			log("Remarks element in Status details not present and object is:-" + input_remarks.toString());
			Thread.sleep(500);
		}
	}

	public void checkEmailAndSms() throws Exception {
		if (!chk_Email.isSelected()) {
			chk_Email.click();
			log("Email check box is selected and object is:-" + chk_Email.toString());
			Thread.sleep(1000);
		} else {
			log("Email check box element is not present and object is:-" + chk_Email.toString());
			Thread.sleep(500);
		}
		if (!chk_SmS.isSelected()) {
			chk_SmS.click();
			log("SMS check box is selected and object is:-" + chk_SmS.toString());
			Thread.sleep(1000);
		} else {
			log("SMS check box element is not present and object is:-" + chk_SmS.toString());
			Thread.sleep(500);
		}
	}

	public void fillEmailAndSmsDetails(String emailSubject, String emailHeader, String emailMessage, String emailFooter,
			String smsContent) throws Exception {
		if (input_email_subject.isDisplayed()) {
			input_email_subject.clear();
			input_email_subject.sendKeys(emailSubject);
			log("Entered Email Subject:-" + emailSubject + " and object is " + input_email_subject.toString());
			Thread.sleep(1000);
		} else {
			log("Email Subject element in not present and object is:-" + input_email_subject.toString());
			Thread.sleep(500);
		}
		if (input_email_header.isDisplayed()) {
			input_email_header.clear();
			input_email_header.sendKeys(emailHeader);
			log("Entered Email Header:-" + emailHeader + " and object is " + input_email_header.toString());
			Thread.sleep(1000);
		} else {
			log("Email Header element in not present and object is:-" + input_email_header.toString());
			Thread.sleep(500);
		}
		if (input_email_Message.isDisplayed()) {
			input_email_Message.clear();
			input_email_Message.sendKeys(emailMessage);
			log("Entered Email Message:-" + emailMessage + " and object is " + input_email_Message.toString());
			Thread.sleep(1000);
		} else {
			log("Email Message element in not present and object is:-" + input_email_Message.toString());
			Thread.sleep(500);
		}
		if (input_email_footer.isDisplayed()) {
			input_email_footer.clear();
			input_email_footer.sendKeys(emailFooter);
			log("Entered Email footer:-" + emailFooter + " and object is " + input_email_footer.toString());
			Thread.sleep(1000);
		} else {
			log("Email footer element in not present and object is:-" + input_email_footer.toString());
			Thread.sleep(500);
		}

		if (input_smsContent.isDisplayed()) {
			input_smsContent.clear();
			input_smsContent.sendKeys(emailFooter);
			log("Entered sms content:-" + emailFooter + " and object is " + input_smsContent.toString());
			Thread.sleep(1000);
		} else {
			log("sms content element in not present and object is:-" + input_smsContent.toString());
			Thread.sleep(500);
		}
	}

	public void updateStatusSend_EmailAndSms() throws Exception {
		if (btn_UpdateStatus.isDisplayed()) {
			btn_UpdateStatus.click();
			log("Click on Update Status button to submit change in status and send Email & SMS and object is:-"
					+ btn_UpdateStatus.toString());
			Thread.sleep(1000);
		} else {
			log("Update Status button element is not present and object is:-" + btn_UpdateStatus.toString());
			Thread.sleep(500);
		}
	}
	
	public void confirm_UpdateStatusSend_EmailAndSms() throws Exception {
		if (btn_UpdateStatusPopUp.isDisplayed()) {
			btn_UpdateStatusPopUp.click();
			log("Update Status button pop up window to submit change in status and send Email & SMS and object is:-"
					+ btn_UpdateStatusPopUp.toString());
			Thread.sleep(1000);
		} else {
			log("Update Status button pop up window element is not present and object is:-" + btn_UpdateStatusPopUp.toString());
			Thread.sleep(500);
		}
	}
	
	public void confirm_UpdateStatus_Yes() throws Exception {
		if (btnPopUp_Yes_UpdateStatus.isDisplayed()) {
			btnPopUp_Yes_UpdateStatus.click();
			log("Confirm Update Status Yes button pop up window to submit change in status and send Email & SMS and object is:-"
					+ btnPopUp_Yes_UpdateStatus.toString());
			Thread.sleep(1000);
		} else {
			log("Update Status Yes button pop up window element is not present and object is:-" + btnPopUp_Yes_UpdateStatus.toString());
			Thread.sleep(500);
		}
	}
	
	public void confirm_UpdateStatus_Cancel() throws Exception {
		if (btnPopUp_Cancel_UpdateStatus.isDisplayed()) {
			btnPopUp_Cancel_UpdateStatus.click();
			log("Confirm Update Status Cancel button pop up window to Cancel change in status and send Email & SMS and object is:-"
					+ btnPopUp_Cancel_UpdateStatus.toString());
			Thread.sleep(1000);
		} else {
			log("Update Status Cancel button pop up window element is not present and object is:-" + btnPopUp_Cancel_UpdateStatus.toString());
			Thread.sleep(500);
		}
	}
	
	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
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
	
}
