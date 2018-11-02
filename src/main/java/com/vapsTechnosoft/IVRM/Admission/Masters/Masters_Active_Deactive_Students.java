/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Active_Deactive_Students extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Active_Deactive_Students.class.getName());

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
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[14]")
	// WebElement btnMasters_ActiveDeactiveStudent;

	@FindBy(xpath = "//a[@href='#/app/activedeactivestudent/50']")
	WebElement btnMasters_ActiveDeactiveStudent;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_ActiveDeactiveStudentMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btn_Clear;

	@FindBy(xpath = "//span[contains(text(),'Active students')]/preceding-sibling::input")
	WebElement rdBtn_ActiveStudent;

	@FindBy(xpath = "//span[contains(text(),'Deactive Students')]")
	WebElement rdBtn_DeActiveStudent;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section:')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement input_Search;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxActiveDeactiveStudent;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxActivateDeactivateStudent;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//span[contains(text(),'Activate the Students')]/preceding-sibling::input")
	WebElement chk_ActivateStudent;

	@FindBy(xpath = "//span[contains(text(),'Deactivate the Students')]/preceding-sibling::input")
	WebElement chk_DeActivateStudent;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Active_Deactive_Students(WebDriver driver) {
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
	 * Navigate to Admission > Masters > Active De-active Student
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_ActiveDeactiveStudent_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Admission masters and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_ActiveDeactiveStudent);
		log("Clicked on Active Deactive Student Button and object is:-" + btnMasters_ActiveDeactiveStudent.toString());
	}

	/**
	 * Validation of Admission > Masters > Active De-active Student screen
	 * message
	 * 
	 * @return
	 */
	public boolean verifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage() {
		try {
			System.out.println(txtMasters_ActiveDeactiveStudentMsgDispaly.getText());
			txtMasters_ActiveDeactiveStudentMsgDispaly.isDisplayed();
			log("Active Deactive Student page is dispalyed and object is:-"
					+ txtMasters_ActiveDeactiveStudentMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_ActiveDeactiveStudentForm() throws Exception {

		clickOnButton(btn_Save);
		log("Submit blank Active Deactive Student form and object is:-" + btn_Save.toString());
	}

	public void fillActiveDeactiveStudentForm(String academicYear, String class_AD, String section) throws Exception {

		selectElementFromDropDown(sel_AcademicYr, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());

		selectElementFromDropDown(sel_Class, class_AD);
		log("selected class: " + class_AD + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected section: " + section + " and object is:- " + sel_Section.toString());

	}

	public void select_ActiveStudent_RadioButton() throws Exception {
		isDisplayed(rdBtn_ActiveStudent);
		if (!rdBtn_ActiveStudent.isSelected()) {
			rdBtn_ActiveStudent.click();
			log("Active Student radio button is selected and object is:-" + rdBtn_ActiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Active Student radio button is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActiveStudent_RadioButton() throws Exception {
		isDisplayed(rdBtn_DeActiveStudent);
		if (!rdBtn_DeActiveStudent.isSelected()) {
			rdBtn_DeActiveStudent.click();
			log("De-Active Student radio button is selected and object is:-" + rdBtn_DeActiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active Student radio button is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_ActivateStudent_checkBox() throws Exception {
		isDisplayed(chk_ActivateStudent);
		if (!chk_ActivateStudent.isSelected()) {
			chk_ActivateStudent.click();
			log("Activate Student check box is checked and object is:-" + chk_ActivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Student check box is already checked (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActivateStudent_checkBox() throws Exception {
		isDisplayed(chk_DeActivateStudent);
		if (!chk_DeActivateStudent.isSelected()) {
			chk_DeActivateStudent.click();
			log("De-Activate Student check box is checked and object is:-" + chk_DeActivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("De-Activate Student check box is already checked (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void saveFilledActiveDeactiveStudentForm() throws Exception {

		clickOnButton(btn_Save);
		Thread.sleep(4000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Save Active Deactive Student form and object is:-" + btn_Save.toString());
	}

	public void clearFilledActiveDeactiveStudentForm() throws Exception {

		clickOnButton(btn_Clear);
		log("Clear Active Deactive Student form and object is:-" + btn_Clear.toString());

	}

	public void searchWithAdmissionNumber_ActivateDeactivateStudentListGrid(String admissionNum) {

		inputTextIntoInputField(input_Search, admissionNum);
		log("Entered Admission number to search: " + admissionNum + " and object is:-" + input_Search.toString());

	}

	public void verifyStudent_ForActiveDeactiveInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);

				if (admNumber.equals(admissionNum)) {
					//Assert.assertEquals(admNumber, admissionNum);
					log("Student available for active and deactive.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentForActivateDeactivate(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String admNumber = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]")).getText()
						.trim();
				System.out.println("Admission Number: " + admNumber);
				// Thread.sleep(2000);
				if (admNumber.equals(admissionNum)) {
					//Assert.assertEquals(admNumber, admissionNum);
					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]/label/input"))
							.click();
					log("Corresponding student check box is checked for Activate or deactivate.");
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void minimizeActiveDeactiveStudent() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_ActiveDeactiveStudentMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxActiveDeactiveStudent);
		log("Active Deactive Student page minimized and object is:-" + btnMin_MaxActiveDeactiveStudent.toString());

	}

	public void maximizeActiveDeactiveStudent() throws Exception {

		clickOnButton(btnMin_MaxActiveDeactiveStudent);
		log("Active Deactive Student page maximized and object is:-" + btnMin_MaxActiveDeactiveStudent.toString());
		Thread.sleep(1000);
	}

	public void minimizeActivateDeactivateStudent() throws Exception {

		clickOnButton(btnMin_MaxActivateDeactivateStudent);
		log("Activate Deactivate Student page minimized and object is:-"
				+ btnMin_MaxActivateDeactivateStudent.toString());
	}

	public void maximizeActivateDeactivateStudent() throws Exception {

		clickOnButton(btnMin_MaxActivateDeactivateStudent);
		log("Activate Deactivate Student page maximized and object is:-"
				+ btnMin_MaxActivateDeactivateStudent.toString());
	}

	public void popWindowMessage_DeactivatedSuccessfully() throws Exception {
		try {
			//validate_PopUpText.isDisplayed();
			isDisplayed(validate_PopUpText);
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactivated Successfully");
			log("Record Deactivated sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_ActivatedSuccessfully() throws Exception {
		try {
			//validate_PopUpText.isDisplayed();
			isDisplayed(validate_PopUpText);
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Activated Successfully");
			log("Record Activated sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
