/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

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
public class Masters_Master_Subject extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Subject.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[20]")
	WebElement btnMasters_MasterSubject;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterSubjectMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//span[contains(text(),'Set Order')]/parent::button")
	WebElement btnSetOrder;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_SubjectName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_SubjectCode;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement input_MaxMarks;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement input_MinMarks;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[6]")
	WebElement input_Search;

	@FindBy(xpath = "(//div[@class='checkbox text-center well']/label/input)[1]")
	WebElement rdbtn_Written;

	@FindBy(xpath = "(//div[@class='checkbox text-center well']/label/input)[2]")
	WebElement rdbtn_Oral;

	@FindBy(xpath = "//span[contains(text(),'PreAdmission Flag')]/preceding-sibling::input")
	WebElement chk_PreAdmissionFlag;

	@FindBy(xpath = "//span[contains(text(),'Exam Flag')]/preceding-sibling::input")
	WebElement chk_ExamFlag;

	@FindBy(xpath = "//span[contains(text(),'Attendance Flag')]/preceding-sibling::input")
	WebElement chk_AttendanceFlag;

	@FindBy(xpath = "//span[contains(text(),'Batch Wise Flag')]/preceding-sibling::input")
	WebElement chk_BatchWiseFlag;

	@FindBy(xpath = "//span[contains(text(),'TimeTable Flag')]/preceding-sibling::input")
	WebElement chk_TimeTableFlag;

	@FindBy(xpath = "//span[contains(text(),'Extra Fee Flag')]/preceding-sibling::input")
	WebElement chk_ExtraFeeFlag;

	@FindBy(xpath = "//span[contains(text(),'Language Flag')]/preceding-sibling::input")
	WebElement chk_LanguageFlag;

	@FindBy(xpath = "//div[@class='box-body']//table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterSubject;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterSubjectList;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//div[@class='box-body']//table/thead/tr/th[2]/a")
	WebElement btnSortBySubjectName;

	@FindBy(xpath = "(//button[contains(text(),'Save')])[1]")
	WebElement btnSaveOrder;

	@FindBy(xpath = "(//button[contains(text(),'Close')])[1]")
	WebElement btnCloseOrder;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//div[@class='modal-body']/table/tbody/tr/td[2][contains(text(),'English')])[1]")
	WebElement From;

	@FindBy(xpath = "(//div[@class='modal-body']/table/tbody/tr/td[2][contains(text(),'GK')])[1]")
	WebElement To;

	public Masters_Master_Subject(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Subject
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterSubject_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_MasterSubject);

		btnMasters_MasterSubject.click();
		log("Clicked on Master Subject Button and object is:-" + btnMasters_MasterSubject.toString());
		waitForElement(driver, 10, btnSave);

	}

	/**
	 * Validation of masters Master Subject screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterSubject_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterSubjectMsgDispaly.getText());
			txtMasters_MasterSubjectMsgDispaly.isDisplayed();
			log("Master Subject page is dispalyed and object is:-" + txtMasters_MasterSubjectMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankMasterSubjectForm() throws Exception {

		btnSave.click();
		log("Submit blank Master Subject form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void select_PreAdmissionFlag_WrittenForm() throws Exception {

		if (!chk_PreAdmissionFlag.isSelected()) {
			chk_PreAdmissionFlag.click();
			log("Pre Admission flag check box is checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		} else {
			log("Pre Admission flag check box is already checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		}

		if (!rdbtn_Written.isSelected()) {
			rdbtn_Written.click();
			log("Written radio button under preAdmission flag is selected and object is:-" + rdbtn_Written.toString());
			Thread.sleep(2000);
		} else {
			log("Written radio button under preAdmission flag is already selected and object is:-"
					+ rdbtn_Written.toString());
			Thread.sleep(2000);
		}
	}

	public void select_PreAdmissionFlag_OralForm() throws Exception {

		if (!chk_PreAdmissionFlag.isSelected()) {
			chk_PreAdmissionFlag.click();
			log("Pre Admission flag check box is checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		} else {
			log("Pre Admission flag check box is already checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		}

		if (!rdbtn_Oral.isSelected()) {
			rdbtn_Oral.click();
			log("Oral radio button under preAdmission flag is selected and object is:-" + rdbtn_Oral.toString());
			Thread.sleep(2000);
		} else {
			log("Oral radio button under preAdmission flag is already selected and object is:-"
					+ rdbtn_Oral.toString());
			Thread.sleep(2000);
		}
	}

	public void enterMasterSubjectFormDetails_forPreAdmissionFlag(String subjectName, String subjectCode,
			String maxMarks, String minMarks) throws Exception {

		if (input_SubjectName.isDisplayed()) {
			input_SubjectName.clear();
			input_SubjectName.sendKeys(subjectName);
			log("Entered subject name: " + subjectName + " and object is:-" + input_SubjectName.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}

		if (input_SubjectCode.isDisplayed()) {
			input_SubjectCode.clear();
			input_SubjectCode.sendKeys(subjectCode);
			log("Entered subject Code: " + subjectCode + " and object is:-" + input_SubjectCode.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}

		if (input_MaxMarks.isDisplayed()) {
			input_MaxMarks.clear();
			input_MaxMarks.sendKeys(maxMarks);
			log("Entered max marks: " + maxMarks + " and object is:-" + input_MaxMarks.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}

		if (input_MinMarks.isDisplayed()) {
			input_MinMarks.clear();
			input_MinMarks.sendKeys(minMarks);
			log("Entered Min marks: " + minMarks + " and object is:-" + input_MinMarks.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}
	}

	public void enterMasterSubjectFormDetails_Without_PreAdmissionFlag(String subjectName, String subjectCode)
			throws Exception {

		if (input_SubjectName.isDisplayed()) {
			input_SubjectName.clear();
			input_SubjectName.sendKeys(subjectName);
			log("Entered subject name: " + subjectName + " and object is:-" + input_SubjectName.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}

		if (input_SubjectCode.isDisplayed()) {
			input_SubjectCode.clear();
			input_SubjectCode.sendKeys(subjectCode);
			log("Entered subject Code: " + subjectCode + " and object is:-" + input_SubjectCode.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
		}
		if (!chk_ExamFlag.isSelected()) {
			chk_ExamFlag.click();
			log("Exam flag check box is checked and object is:-" + chk_ExamFlag.toString());
			Thread.sleep(1000);
		} else {
			log("Exam flag check box is already checked and object is:-" + chk_ExamFlag.toString());
			Thread.sleep(1000);
		}

		if (!chk_BatchWiseFlag.isSelected()) {
			chk_BatchWiseFlag.click();
			log("Batch wise flag check box is checked and object is:-" + chk_BatchWiseFlag.toString());
			Thread.sleep(1000);
		} else {
			log("Batch wise flag check box is already checked and object is:-" + chk_BatchWiseFlag.toString());
			Thread.sleep(1000);
		}
	}

	public void clearMasterSubjectInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on cancel button to clear filled master subject info and object is:-" + btnCancelClear.toString());
		Thread.sleep(10000);
	}

	public void submitFilledMasterSubjectForm() throws Exception {

		btnSave.click();
		log("Save filled Master Subject form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeMasterSubject() throws Exception {
		btnMin_MaxMasterSubject.click();
		log("clicked on Master Subject minimize button and object is:-" + btnMin_MaxMasterSubject.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterSubject() throws Exception {
		btnMin_MaxMasterSubject.click();
		log("clicked on Master Subject maximize button and object is:-" + btnMin_MaxMasterSubject.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterSubjectList() throws Exception {

		btnMin_MaxMasterSubjectList.click();
		log("Master Subject List minimize and object is:-" + btnMin_MaxMasterSubjectList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterSubjectList() throws Exception {

		btnMin_MaxMasterSubjectList.click();
		log("Master Subject List maximized and object is:-" + btnMin_MaxMasterSubjectList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortBySubjectName() throws Exception {
		btnSortBySubjectName.click();
		log("Sorted the record with Subject Name and object is:-" + btnSortBySubjectName.toString());
		Thread.sleep(3000);
	}

	public void searchWithSubjectNameInTheGrid(String subjectName) {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(subjectName);
			log("Entered subject name to search: " + subjectName + " and object is:-" + input_Search.toString());
		} else {
			log("Element not present.");
		}
	}

	public void verifySubjectNameInTheGrid(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String subjectname = driver
					.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Subject Name: " + subjectname);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(subjectname, subjectName);
				log("Subject name created is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void editMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String subjectname = driver
					.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
					.trim();
			System.out.println("Subject Name: " + subjectname);
			// Thread.sleep(2000);
			try {
				if (subjectname.equalsIgnoreCase(subjectName)) {

					driver.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/a"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master Subject list grid to edit record");

					break;
				} else {
					log("Subject Name not matched with the master Subject list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String subjectname = driver
					.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Subject Name: " + subjectname);
			// Thread.sleep(2000);
			try {
				if (subjectname.equalsIgnoreCase(subjectName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master Subject list grid");

					break;
				} else {
					log("Subject Name not matched with the master Subject list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String subjectname = driver
					.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Subject Name: " + subjectname);
			// Thread.sleep(2000);
			try {
				if (subjectname.equalsIgnoreCase(subjectName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/a[2]"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master Subject list grid");

					break;
				} else {
					log("Subject Name not matched with the master Subject list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes deactivate or activate or delete it button and object is:-"
					+ btnYesDeleteOrDeactIt.toString());
			Thread.sleep(15000);
		} else {
			log("Element not present.");
		}
	}

	public void clickOnCancelButton() throws Exception {
		if (btnCancel.isDisplayed()) {
			btnCancel.click();
			log("Clicked on cancel button and object is:-" + btnCancel.toString());
			Thread.sleep(15000);
		} else {
			log("Element not present.");
		}
	}

	public void clickOnSetOrder() {
		if (btnSetOrder.isDisplayed()) {
			btnSetOrder.click();
			log("Set Order button is clicked and object is:-" + btnSetOrder.toString());
		} else {
			log("Element not present.");
		}
	}

	public void setSubjectOrder() {

		// Actions builder = new Actions(driver);
		//
		// Action dragAndDrop = builder.clickAndHold(From)
		//
		// .moveToElement(To)
		//
		// .release(To)
		//
		// .build();
		//
		// dragAndDrop.perform();
		// log("Subject order set using drag and drop.");

		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).perform();
		log("Subject order set using drag and drop.");

	}

	public void closeSetSubjectOrderPopUpWindow() {
		if (btnCloseOrder.isDisplayed()) {
			btnCloseOrder.click();
			log("Set Subject Order pop Up window is closed and object is:-" + btnCloseOrder.toString());
		} else {
			log("Element not present.");
		}
	}

	public void saveSetSubjectOrderPopUpWindow() throws Exception {
		if (btnSaveOrder.isDisplayed()) {
			btnSaveOrder.click();
			log("Set Subject Order save button is clicked, pop Up window is closed and object is:-"
					+ btnSaveOrder.toString());
			Thread.sleep(10000);
		} else {
			log("Element not present.");
		}
	}

}
