/**
 * 
 */
package com.vapsTechnosoft.IVRM.BGHS_PreAdmission;

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
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS extends TestBase {

	public static final Logger log = Logger
			.getLogger(PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS.class.getName());

	WebDriver driver;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	WebElement btnPre_Admission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]/following::ul[1]/li[1]")
	WebElement btnInterview_Schedule;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]/following::ul[1]/li[1]/ul[1]/li[1]")
	WebElement btnOral_Test;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtPreAdm_BGHSIntrvMsgDispaly;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[1]")
	WebElement inputScheduleName;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[2]")
	WebElement inputRemarks;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[3]")
	WebElement inputSupervisor;

	@FindBy(xpath = "//div[@class='col-sm-8']/textarea")
	WebElement inputSkills;

	@FindBy(xpath = "//input[@class='md-datepicker-input']")
	WebElement inputOraltestDate;

	@FindBy(xpath = "//input[@name='12hur']")
	WebElement rdBtn12Hr;

	@FindBy(xpath = "//input[@name='24Hur']")
	WebElement rdBtn24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[1]/tbody/tr[2]/td[1]/input")
	WebElement inputScheduleTime_FromHr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[1]/tbody/tr[2]/td[3]/input")
	WebElement inputScheduleTime_FromMin;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[1]/tbody/tr[2]/td[6]/button")
	WebElement btnFrom_AM_PM;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[1]/input")
	WebElement inputScheduleTime_ToHr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[3]/input")
	WebElement inputScheduleTime_ToMin;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[3]/tbody/tr[2]/td[6]/button")
	WebElement btnTo_AM_PM;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[2]/tbody/tr[2]/td[1]")
	WebElement inputScheduleTime_FromHr24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[2]/tbody/tr[2]/td[3]")
	WebElement inputScheduleTime_FromMin24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[4]/tbody/tr[2]/td[1]")
	WebElement inputScheduleTime_ToHr24Hr;

	@FindBy(xpath = "(//table[@class='uib-timepicker'])[4]/tbody/tr[2]/td[3]")
	WebElement inputScheduleTime_ToMin24Hr;

	@FindBy(xpath = "//input[@name='autostudent']")
	WebElement chkAutoSelStudent;

	@FindBy(xpath = "//input[@name='Min']")
	WebElement inputMinute;

	@FindBy(xpath = "//input[@name='nofstud']")
	WebElement inputNoOfStudent;

	@FindBy(xpath = "//input[@name='12hurrt']")
	WebElement rdBtnScheduleList12Hr;

	@FindBy(xpath = "//input[@name='24Hurrt']")
	WebElement rdBtnScheduleList24Hr;

	@FindBy(xpath = "(//div[@class='box box-primary']//table)[5]/tbody/tr")
	List<WebElement> tblRowsStudentList;

	@FindBy(xpath = "(//div[@class='box box-primary']//table)[6]/tbody/tr")
	List<WebElement> tblRowsScheduleList;

	@FindBy(xpath = "//body[@id='style-4']//form/div[1]/div[1]/div/button[1]")
	WebElement btnReset;

	@FindBy(xpath = "//body[@id='style-4']//form/div[1]/div[1]/div/button[2]")
	WebElement btnMinus_Plus;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement btnSave;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonsuccess;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[3]/div/div/input)[3]")
	WebElement inputSearch_SchList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnDeleteCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteIt;
	
	@FindBy(xpath = "(//div[@class='box box-primary']//table)[6]/thead/tr/th[2]/a")
	WebElement btnSortSchName;
	
	

	public PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(WebDriver driver) {
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

	public void navigateToOralTestSchedule_BGHS() {

		btnPre_Admission.click();
		log("Clicked on pre admission button and object is:-" + btnPre_Admission.toString());
		waitForElement(driver, 10, btnInterview_Schedule);

		btnInterview_Schedule.click();
		log("Clicked on interview schedule button and object is:-" + btnInterview_Schedule.toString());
		waitForElement(driver, 10, btnOral_Test);

		btnOral_Test.click();
		log("Clicked on oral test schedule button and object is:-" + btnOral_Test.toString());
		waitForElement(driver, 10, txtPreAdm_BGHSIntrvMsgDispaly);
	}

	public boolean verifyInterviewSchedule_BGHSPage() {
		try {
			System.out.println(txtPreAdm_BGHSIntrvMsgDispaly.getText());
			txtPreAdm_BGHSIntrvMsgDispaly.isDisplayed();
			log("Interview schedule page is dispalyed and object is:-" + txtPreAdm_BGHSIntrvMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void oralTestScheduleInfo(String scheduleName, String scheduleDate, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String minutes, String nosOfStudents) throws Exception {

		inputScheduleName.clear();
		inputScheduleName.sendKeys(scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + inputScheduleName.toString());
		Thread.sleep(2000);

		copyToClipbord(scheduleDate);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(inputOraltestDate);
		oAction.contextClick(inputOraltestDate).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered schedule date " + scheduleDate + " and object is:-" + inputOraltestDate.toString());
		Thread.sleep(2000);

		inputRemarks.clear();
		inputRemarks.sendKeys(remarks);
		log("Entered remarks " + remarks + " and object is:-" + inputRemarks.toString());
		Thread.sleep(1000);

		inputSupervisor.clear();
		inputSupervisor.sendKeys(supervisor);
		log("Entered supervisor " + supervisor + " and object is:-" + inputSupervisor.toString());
		Thread.sleep(1000);

		inputSkills.clear();
		inputSkills.sendKeys(skill);
		log("Entered skill " + skill + " and object is:-" + inputSkills.toString());
		Thread.sleep(1000);

		if (!rdBtn12Hr.isSelected()) {
			rdBtn12Hr.click();
			log("12 Hours format radio button is selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		} else {
			log("12 hours time format radio button is already selected and object is:-" + rdBtn12Hr.toString());
			Thread.sleep(1000);
		}

		inputScheduleTime_FromHr.clear();
		inputScheduleTime_FromHr.sendKeys(FromSchTimeHr);
		log("Entered From schedule time hour " + FromSchTimeHr + " and object is:-"
				+ inputScheduleTime_FromHr.toString());
		Thread.sleep(1000);

		inputScheduleTime_FromMin.clear();
		inputScheduleTime_FromMin.sendKeys(FromSchTimeMin);
		log("Entered From schedule time minute " + FromSchTimeMin + " and object is:-"
				+ inputScheduleTime_FromMin.toString());
		Thread.sleep(1000);

		inputScheduleTime_ToHr.clear();
		inputScheduleTime_ToHr.sendKeys(ToSchTimeHr);
		log("Entered To schedule time hour " + ToSchTimeHr + " and object is:-" + inputScheduleTime_ToHr.toString());
		Thread.sleep(1000);

		inputScheduleTime_ToMin.clear();
		inputScheduleTime_ToMin.sendKeys(ToSchTimeMin);
		log("Entered To schedule time minute " + ToSchTimeMin + " and object is:-"
				+ inputScheduleTime_ToMin.toString());
		Thread.sleep(1000);

		btnTo_AM_PM.click();
		log("PM is selected and object is:-" + btnTo_AM_PM.toString());
		Thread.sleep(1000);

		if (!chkAutoSelStudent.isSelected()) {
			chkAutoSelStudent.click();
			log("Auto select student check box is selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Auto select student check box is already selected and object is:-" + chkAutoSelStudent.toString());
			Thread.sleep(1000);
		}

		inputMinute.clear();
		inputMinute.sendKeys(minutes);
		log("Entered time in minute for each student " + minutes + " and object is:-" + inputMinute.toString());
		Thread.sleep(1000);

		inputNoOfStudent.clear();
		inputNoOfStudent.sendKeys(nosOfStudents);
		log("Entered total number of student for oral test " + nosOfStudents + " and object is:-"
				+ inputNoOfStudent.toString());
		Thread.sleep(1000);

	}

	public void resetMinimizeAndMaximize() throws Exception {

		btnReset.click();
		log("Reset button is clicked to reset enterd value for oral interview schedule and object is:-"
				+ btnReset.toString());
		Thread.sleep(1000);

		btnMinus_Plus.click();
		log("Minimize oral schedule test page and object is:-" + btnMinus_Plus.toString());
		Thread.sleep(1000);

		btnMinus_Plus.click();
		log("Maximize oral schedule test page and object is:-" + btnMinus_Plus.toString());
		Thread.sleep(1000);
	}

	public void clickOnSaveButton() throws Exception {

		btnSave.click();
		log("Save button is clicked to save the oral test schedule and object is:-" + btnSave.toString());
		waitForElement(driver, 20, btnOkonsuccess);
		Thread.sleep(7000);
	}

	public void popUpValidationOnSuccess() throws InterruptedException {
		btnOkonsuccess.click();
		log("After successful saving for oral test schedule and object is:-" + btnOkonsuccess.toString());
		Thread.sleep(3000);
	}

	public void validationOf12HourTimeFormatScheduleList() throws Exception {

		inputSearch_SchList.clear();
		Thread.sleep(1000);
		if (!rdBtnScheduleList12Hr.isSelected()) {

			rdBtnScheduleList12Hr.click();
			log("12 Hour time format radio button is selected for oral test schedule list and object is:-"
					+ rdBtnScheduleList12Hr.toString());
			Thread.sleep(2000);
		} else {
			log("12 hour time format radio button is already selected and object is:-"
					+ rdBtnScheduleList12Hr.toString());
			Thread.sleep(1000);
		}

	}
	public void validationOf24HourTimeFormatScheduleList() throws Exception {

		inputSearch_SchList.clear();
		Thread.sleep(1000);
		if (!rdBtnScheduleList24Hr.isSelected()) {

			rdBtnScheduleList24Hr.click();
			log("24 Hour time format radio button is selected for oral test schedule list and object is:-"
					+ rdBtnScheduleList24Hr.toString());
			Thread.sleep(2000);
		} else {
			log("24 hour time format radio button is already selected and object is:-"
					+ rdBtnScheduleList24Hr.toString());
			Thread.sleep(1000);
		}

	}

	public void sortingUsingColumnHeader() throws Exception{
		
		inputSearch_SchList.clear();
		Thread.sleep(1000);
		btnSortSchName.click();
		log("Item is sorted by schedule name and object is:-"+btnSortSchName.toString());
		Thread.sleep(2000);
	}

	public void searchWithScheduleNameInScheduleList(String scheduleName) throws Exception {

		inputSearch_SchList.clear();
		inputSearch_SchList.sendKeys(scheduleName);
		log("Entered schedule name " + scheduleName + " and object is:-" + inputSearch_SchList.toString());
		Thread.sleep(1000);
	}

	public void verifyscheduleNameInOralTestScheduleListGrid(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String SchName = driver
					.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("schedule Name: " + SchName);
			Thread.sleep(2000);
			if (SchName.equalsIgnoreCase(scheduleName)) {
				try {
					Assert.assertEquals(SchName, scheduleName);
					log("Schedule name matched with the schedule list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			} else {
				log("Schedule name not matched with the schedule list");
			}
		}
	}

	public void deleteScheduledOralTest(String scheduleName) throws Exception {

		int rows = tblRowsScheduleList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String SchName = driver
					.findElement(By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("schedule Name: " + SchName);
			Thread.sleep(2000);
			if (SchName.equalsIgnoreCase(scheduleName)) {
				try {
					Assert.assertEquals(SchName, scheduleName);

					driver.findElement(
							By.xpath("(//div[@class='box box-primary']//table)[6]/tbody/tr[" + i + "]/td[7]/span"))
							.click();
					log("Clicked on the delete link in the student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			} else {
				log("Schedule name not matched with the schedule list");
			}
		}
	}

	public void cancellationOfDelete() throws Exception {

		btnDeleteCancel.click();
		log("Delete cancel and object is:-" + btnDeleteCancel.toString());
		Thread.sleep(2000);
	}

	public void yesDeleteItButtonClick() throws Exception {

		btnYesDeleteIt.click();
		log("Yes Delete It button clicked and object is:-" + btnYesDeleteIt.toString());
		waitForElement(driver, 20, btnOkonsuccess);
		Thread.sleep(5000);
	}

}
