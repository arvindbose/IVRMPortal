/**
 * 
 */
package com.vapsTechnosoft.IVRM.BGHS_PreAdmission;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Admission_Form_BGHS_HealthCertificateForm extends TestBase {

	public static final Logger log = Logger.getLogger(Admission_Form_BGHS_HealthCertificateForm.class.getName());

	WebDriver driver;
	Select select;
	ArrayList<String> tabs2;
	Actions oAction;
	Robot robot;

	/**
	 * BGHS Pre Admission form
	 */
	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[3]")
	WebElement btnPre_Admission;

	@FindBy(xpath = "//span[contains(text(),'Student Admission')]")
	WebElement btnStudent_Admission;

	@FindBy(xpath = "//span[contains(text(),'Student Admission')]/following::li[1]")
	WebElement btnAdmForm_BGHS;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmForm_BGHSMsgDispaly;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div//md-tab-item[2]")
	WebElement btnHealthCertForm_BGHS;

	@FindBy(xpath = "(//div[@class='box-tools pull-right']/button)[4]")
	WebElement btnMin_Maximize;

	/**
	 * Health certificate information
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "//select[@name='schname']")
	WebElement selStudentName;

	@FindBy(xpath = "(//div[@class='col-sm-7']/md-datepicker/div/input)[1]")
	WebElement inputChildVaccinatedDate;

	@FindBy(xpath = "(//div[@class='col-sm-7']/md-datepicker/div/input)[2]")
	WebElement inputFitsIFYesDate;

	@FindBy(xpath = "(//div[@class='col-sm-7']/md-datepicker/div/input)[3]")
	WebElement inputHepatitisBDate;

	@FindBy(xpath = "(//div[@class='col-sm-7']/md-datepicker/div/input)[4]")
	WebElement inputTyphoidFeverDate;

	@FindBy(xpath = "(//div[@class='col-sm-2']/label/input)[1]")
	WebElement rdBtnFitsYes;

	@FindBy(xpath = "(//div[@class='col-sm-2']/label/input)[2]")
	WebElement rdBtnFitsNo;

	@FindBy(xpath = "(//div[@class='col-sm-7']/label/input)[1]")
	WebElement rdBtnIllnessYes;

	@FindBy(xpath = "(//div[@class='col-sm-7']/label/input)[2]")
	WebElement rdBtnIllnessNo;

	@FindBy(xpath = "(//div[@class='col-sm-7']/label/input)[3]")
	WebElement rdBtnAllergicYes;

	@FindBy(xpath = "(//div[@class='col-sm-7']/label/input)[4]")
	WebElement rdBtnAllergicNo;

	@FindBy(xpath = "(//div[@class='col-sm-7']/input)[1]")
	WebElement inputAilments;

	@FindBy(xpath = "(//div[@class='col-sm-7']/input)[2]")
	WebElement inputHealthProblem;

	@FindBy(xpath = "//select[@name='vvv']")
	WebElement selBloodGroup;

	@FindBy(xpath = "(//span[contains(text(),'Submit')])[2]")
	WebElement btnSubmit;

	@FindBy(xpath = "(//div[@class='text-center']/button)[5]")
	WebElement btnClear;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "(//div[@class='input-group']/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "(//div[@class='box-body']/table)[4]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//span[contains(text(),'BACK')]")
	WebElement btnPaymentBack;
	
	@FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
	WebElement btnClose;

	@FindBy(xpath = "(//button[contains(text(),'Print')])[1]")
	WebElement btnPrint;
	
	@FindBy(xpath = "(//button[contains(text(),'Close')])[4]")
	WebElement btnCloseHCert;

	@FindBy(xpath = "(//button[contains(text(),'Print')])[2]")
	WebElement btnPrintHCert;
	
	
	
	

	public Admission_Form_BGHS_HealthCertificateForm(WebDriver driver) {
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
	 * Navigate to Admission form BGHS Health Certificate
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_ApplicationForm_BGHS() throws Exception {
		btnPre_Admission.click();
		log("Clicked on Pre admission Button and object is:-" + btnPre_Admission.toString());
		waitForElement(driver, 10, btnStudent_Admission);

		btnStudent_Admission.click();
		log("Clicked on Student Admission Button and object is:-" + btnStudent_Admission.toString());
		waitForElement(driver, 10, btnAdmForm_BGHS);

		btnAdmForm_BGHS.click();
		log("Clicked on admission form BGHS Button and object is:-" + btnAdmForm_BGHS.toString());
		waitForElement(driver, 10, txtAdmForm_BGHSMsgDispaly);
		
	}
	
	public void switchedToHealthCertificateForm() throws InterruptedException{
	
	btnHealthCertForm_BGHS.click();
	log("Clicked on Health Certificate form Button and object is:-" + btnHealthCertForm_BGHS.toString());
	//waitForElement(driver, 10, btnMin_Maximize);
	
	Thread.sleep(3000);
	}
	/**
	 * Validation of Admission form BGHS screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_ApplicationForm_BGHSPage() {
		try {
			System.out.println(txtAdmForm_BGHSMsgDispaly.getText());
			txtAdmForm_BGHSMsgDispaly.isDisplayed();
			log("Admission form BGHS page is dispalyed and object is:-" + txtAdmForm_BGHSMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Minimized the certificate page
	 * 
	 * @throws Exception
	 */
	public void minimizeHealthCertificate() throws Exception {

		btnMin_Maximize.click();
		log("Health certificate minimized and object is:-" + btnMin_Maximize.toString());
		Thread.sleep(2000);
	}

	/**
	 * Maximized the certificate page
	 * 
	 * @throws Exception
	 */

	public void maximizeHealthCertificate() throws Exception {

		btnMin_Maximize.click();
		log("Health certificate maximized and object is:-" + btnMin_Maximize.toString());
		Thread.sleep(2000);
	}
	

	public void healthCertificateInformationForBGHS(String StudentName, String vaccinationDate, String hepatitisBDate,
			String typhoidFeverDate, String AilmentsName, String HealthProblem, String bloodGroup) throws Exception {

		select = new Select(selStudentName);
		select.selectByVisibleText(StudentName);
		log("selected Student Name:-" + StudentName + " and object is " + selStudentName.toString());
		Thread.sleep(1000);

		// WebElement option = select.getFirstSelectedOption();
		// Assert.assertEquals(option.getText(), StudentName);
		// Thread.sleep(1000);

		copyToClipbord(vaccinationDate);

		oAction = new Actions(driver);
		oAction.moveToElement(inputChildVaccinatedDate);
		oAction.contextClick(inputChildVaccinatedDate).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered child vaccination date " + vaccinationDate + " and object is:-"
				+ inputChildVaccinatedDate.toString());
		Thread.sleep(2000);

		if (!rdBtnFitsNo.isSelected()) {
			rdBtnFitsNo.click();
			log("clicked on fits NO radio button and object is:-" + rdBtnFitsNo.toString());
			Thread.sleep(1000);
		} else {
			log("Fits NO radio button is already selected and object is:-" + rdBtnFitsNo.toString());
		}

		if (!rdBtnIllnessNo.isSelected()) {
			rdBtnIllnessNo.click();
			log("clicked on No illness radio button and object is:-" + rdBtnIllnessNo.toString());
			Thread.sleep(1000);
		} else {
			log("No Illness radio button is already selected and object is:-" + rdBtnIllnessYes.toString());
		}

		copyToClipbord(hepatitisBDate);

		oAction = new Actions(driver);
		oAction.moveToElement(inputHepatitisBDate);
		oAction.contextClick(inputHepatitisBDate).build().perform();

		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered last hepatitisB vaccination date " + hepatitisBDate + " and object is:-"
				+ inputHepatitisBDate.toString());
		Thread.sleep(2000);

		copyToClipbord(typhoidFeverDate);

		oAction = new Actions(driver);
		oAction.moveToElement(inputTyphoidFeverDate);
		oAction.contextClick(inputTyphoidFeverDate).build().perform();

		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered typhoid fever vaccination date " + typhoidFeverDate + " and object is:-"
				+ inputTyphoidFeverDate.toString());
		Thread.sleep(2000);

		inputAilments.sendKeys(AilmentsName);
		log("Child suffered from any ailments:-" + AilmentsName + " and object is " + inputAilments.toString());
		Thread.sleep(1000);

		if (!rdBtnAllergicNo.isSelected()) {
			rdBtnAllergicNo.click();
			log("clicked on No allergic radio button and object is:-" + rdBtnAllergicNo.toString());
			Thread.sleep(1000);
		} else {
			log("No allergic radio button is already selected and object is:-" + rdBtnIllnessYes.toString());
		}

		inputHealthProblem.sendKeys(HealthProblem);
		log("Child health problem:-" + HealthProblem + " and object is " + inputHealthProblem.toString());
		Thread.sleep(1000);

		select = new Select(selBloodGroup);
		select.selectByVisibleText(bloodGroup);
		log("selected blood group:-" + bloodGroup + " and object is " + selBloodGroup.toString());
		Thread.sleep(1000);

		WebElement option1 = select.getFirstSelectedOption();
		Assert.assertEquals(option1.getText(), bloodGroup);
		Thread.sleep(5000);

		
	}

	public void clearFilledHealthCertificateForm() throws Exception{
		btnClear.click();
		log("Clicked on clear button and object is:-" + btnClear.toString());
		Thread.sleep(4000);
	}
	
	public void submitHealthCertificateForm() throws Exception {
		
		btnSubmit.isDisplayed();
		btnSubmit.click();
		log("Clicked on submit button and object is:-" + btnSubmit.toString());
		Thread.sleep(5000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void searchWithStudentName(String studentName) throws Exception {
		
		inputSearch.clear();
		inputSearch.sendKeys(studentName);
		log("Entered student name for search " + studentName + " and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
	}

	public void verifyStudentNameInGrid(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + stuName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentName)) {
				try {
					Assert.assertEquals(stuName, studentName);
					log("Student name matched with the Student health certificate list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}
	}

	public void editSubmittedHealthCertificate(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + studentName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentName)) {
				try {
					Assert.assertEquals(stuName, studentName);

					driver.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[4]"))
							.click();
					log("Clicked on the edit link in the student health certificate list grid");
					Thread.sleep(7000);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
					else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}

	}

	public void payRegistrationFeeBGHS(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + stuName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentName)) {
				try {
					Assert.assertEquals(stuName, studentName);

					driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[5]/span[1]")).click();
					log("Clicked on the pay registration fee link in the student health certificate list grid");
					Thread.sleep(5000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}
	}

	public void returnBacktoApplicationPageFromPaymentPage() throws Exception {

		btnPaymentBack.click();
		log("Clicked on back button of payment page and object is:-" + btnPaymentBack.toString());
//		Thread.sleep(3000);
		
		waitForElement(driver, btnHealthCertForm_BGHS, 20);
	}



	public void viewAdmissionForm_BGHS(String studentname) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + stuName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentname)) {
				try {
					Assert.assertEquals(stuName, studentname);

					driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[5]/span[1]")).click();
					log("Clicked on the view admission form link in the student health certificate list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}
	}

	public void viewHealthCertificateForm_BGHS(String studentname) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + stuName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentname)) {
				try {
					Assert.assertEquals(stuName, studentname);

					driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[5]/span[2]/a[1]"))
							.click();
					log("Clicked on the view health certificate form link in the student health certificate list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}
	}

	public void downloadProspectus(String studentname) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String stuName = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + stuName);
			Thread.sleep(2000);
			if (stuName.equalsIgnoreCase(studentname)) {
				try {
					Assert.assertEquals(stuName, studentname);

					driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[4]/tbody/tr[" + i + "]/td[5]/span[2]/a[2]"))
							.click();
					log("Clicked on the download certificate link in the student health certificate list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else {
				log("Student name not matched with the Student health certificate list grid");
				Thread.sleep(1000);
			}
		}
	}

	public void closeOpenAdmissionForm() throws Exception {

		btnClose.click();
		log("Opened admission form is closed and object is:-" + btnClose.toString());
		Thread.sleep(2000);
	}
	
	public void printOpenAdmissionForm() throws Exception {

		btnPrint.click();
		log("Clicked print button and object is:-" + btnPrint.toString());
		Thread.sleep(5000);
	}
	
	/**
	 * Switching windows for prospectus download
	 * 
	 * @throws Exception
	 */
	public void switchWindowsForProspectusDownload() throws Exception {
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		log("Switched to the prospectus download window");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		log("Swiched back from prospectus download page to admission form BCEHS");
		Thread.sleep(2000);

	}
	
	/**
	 * Switching windows for print preview
	 * 
	 * @throws Exception
	 */
	public void switchToWindowUsingTab() throws Exception {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		// new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL,
		// Keys.TAB)).perform();
		Thread.sleep(7000);

		log("Switched for the print preview windows.");

	}

	public void closeOpenHealthCertficateForm() throws Exception {

		btnCloseHCert.click();
		log("Opened admission form is closed and object is:-" + btnCloseHCert.toString());
		Thread.sleep(2000);
	}
	
	public void printOpenHealthCertficateForm() throws Exception {

		btnPrintHCert.click();
		log("Clicked print button and object is:-" + btnPrintHCert.toString());
		Thread.sleep(5000);
	}
	
}
