/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[20]")
	// WebElement btnMasters_MasterSubject;

	@FindBy(xpath = "(//a[@href='#/app/subjectmaster/96'])[1]")
	WebElement btnMasters_MasterSubject;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterSubjectMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//span[contains(text(),'Set Order')]/parent::button")
	WebElement btnSetOrder;

	@FindBy(xpath = "//input[@name='Subject']")
	WebElement input_SubjectName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement input_SubjectCode;

	@FindBy(xpath = "//input[@name='maxmarks']")
	WebElement input_MaxMarks;

	@FindBy(xpath = "//input[@name='minmarks']")
	WebElement input_MinMarks;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement input_Search;

	@FindBy(xpath = "(//input[@name='SubjectFlag'])[1]")
	WebElement rdbtn_Written;

	@FindBy(xpath = "(//input[@name='SubjectFlag'])[2]")
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
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_SubjectName;

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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Subject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(3000);
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
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_MasterSubject);
		log("Clicked on Master Subject Button and object is:-" + btnMasters_MasterSubject.toString());

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

		clickOnButton(btnSave);
		log("Submit blank Master Subject form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void select_PreAdmissionFlag_WrittenForm() throws Exception {
		isDisplayed(chk_PreAdmissionFlag);
		if (!chk_PreAdmissionFlag.isSelected()) {
			chk_PreAdmissionFlag.click();
			log("Pre Admission flag check box is checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		} else {
			log("Pre Admission flag check box is already checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		}
		isDisplayed(rdbtn_Written);
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
		isDisplayed(chk_PreAdmissionFlag);
		if (!chk_PreAdmissionFlag.isSelected()) {
			chk_PreAdmissionFlag.click();
			log("Pre Admission flag check box is checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		} else {
			log("Pre Admission flag check box is already checked and object is:-" + chk_PreAdmissionFlag.toString());
			Thread.sleep(2000);
		}
		isDisplayed(rdbtn_Oral);
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

		inputTextIntoInputField(input_SubjectName, subjectName);
		log("Entered subject name: " + subjectName + " and object is:-" + input_SubjectName.toString());

		inputTextIntoInputField(input_SubjectCode, subjectCode);
		log("Entered subject Code: " + subjectCode + " and object is:-" + input_SubjectCode.toString());

		inputTextIntoInputField(input_MaxMarks, maxMarks);
		log("Entered max marks: " + maxMarks + " and object is:-" + input_MaxMarks.toString());

		inputTextIntoInputField(input_MinMarks, minMarks);
		log("Entered Min marks: " + minMarks + " and object is:-" + input_MinMarks.toString());

	}

	public void enterMasterSubjectFormDetails_Without_PreAdmissionFlag(String subjectName, String subjectCode)
			throws Exception {

		inputTextIntoInputField(input_SubjectName, subjectName);
		log("Entered subject name: " + subjectName + " and object is:-" + input_SubjectName.toString());

		inputTextIntoInputField(input_SubjectCode, subjectCode);
		log("Entered subject Code: " + subjectCode + " and object is:-" + input_SubjectCode.toString());

		isDisplayed(chk_ExamFlag);
		if (!chk_ExamFlag.isSelected()) {
			chk_ExamFlag.click();
			log("Exam flag check box is checked and object is:-" + chk_ExamFlag.toString());
			Thread.sleep(1000);
		} else {
			log("Exam flag check box is already checked and object is:-" + chk_ExamFlag.toString());
			Thread.sleep(1000);
		}
		isDisplayed(chk_BatchWiseFlag);
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

		clickOnButton(btnCancelClear);
		log("Clicked on cancel button to clear filled master subject info and object is:-" + btnCancelClear.toString());

	}

	public void submitFilledMasterSubjectForm() throws Exception {

		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Save filled Master Subject form and object is:-" + btnSave.toString());

	}

	public void minimizeMasterSubject() throws Exception {

		clickOnButton(btnMin_MaxMasterSubject);
		log("clicked on Master Subject minimize button and object is:-" + btnMin_MaxMasterSubject.toString());
	}

	public void maximizeMasterSubject() throws Exception {

		clickOnButton(btnMin_MaxMasterSubject);
		log("clicked on Master Subject maximize button and object is:-" + btnMin_MaxMasterSubject.toString());

	}

	public void minimizeMasterSubjectList() throws Exception {

		clickOnButton(btnMin_MaxMasterSubjectList);
		log("Master Subject List minimize and object is:-" + btnMin_MaxMasterSubjectList.toString());

	}

	public void maximizeMasterSubjectList() throws Exception {

		clickOnButton(btnMin_MaxMasterSubjectList);
		log("Master Subject List maximized and object is:-" + btnMin_MaxMasterSubjectList.toString());
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortBySubjectName() throws Exception {

		clickOnButton(btnSortBySubjectName);
		SortData_InColumn_DescendingOrder(list_SubjectName);
		log("Sorted the record with Subject Name in Descending order and object is:-" + btnSortBySubjectName.toString());

	}

	public void searchWithSubjectNameInTheGrid(String subjectName) throws Exception {

		inputTextIntoInputField(input_Search, subjectName);
		log("Entered subject name to search: " + subjectName + " and object is:-" + input_Search.toString());

	}

	public void verifySubjectNameInTheGrid(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String subjectname = driver
						.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Subject Name: " + subjectname);
				// Thread.sleep(2000);
				if (subjectname.equals(subjectName)) {
					// Assert.assertEquals(subjectname, subjectName);
					log("Subject name created is updated in the record grid.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String subjectname = driver
						.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Subject Name: " + subjectname);
				// Thread.sleep(2000);

				if (subjectname.equalsIgnoreCase(subjectName)) {

					driver.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/a"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the master Subject list grid to edit record");

					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String subjectname = driver
						.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Subject Name: " + subjectname);
				// Thread.sleep(2000);

				if (subjectname.equalsIgnoreCase(subjectName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals("De-Activate", deactivetext);

					deactiveLink.click();
					Thread.sleep(2000);
					log("Clicked on the deactivate link in the master Subject list grid");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateMasterSubject(String subjectName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String subjectname = driver
						.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[2]")).getText()
						.trim();
				System.out.println("Subject Name: " + subjectname);
				// Thread.sleep(2000);

				if (subjectname.equalsIgnoreCase(subjectName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']//table/tbody/tr[" + i + "]/td[14]/a[2]"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(2000);
					log("Clicked on the activate link in the master Subject list grid");

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void clickOnSetOrder() {

		clickOnButton(btnSetOrder);
		log("Set Order button is clicked and object is:-" + btnSetOrder.toString());

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

		clickOnButton(btnCloseOrder);
		log("Set Subject Order pop Up window is closed and object is:-" + btnCloseOrder.toString());

	}

	public void saveSetSubjectOrderPopUpWindow() throws Exception {

		clickOnButton(btnSaveOrder);
		log("Set Subject Order save button is clicked, pop Up window is closed and object is:-"
				+ btnSaveOrder.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_DeactivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record De-Activation Cancelled");
			log("Record deactivation Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_DeactivatedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record De-Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_ActivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activation Cancelled");
			log("Record Activation Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_ActivatedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
