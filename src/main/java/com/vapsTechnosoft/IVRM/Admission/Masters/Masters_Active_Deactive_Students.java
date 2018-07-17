/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[14]")
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

	public Masters_Active_Deactive_Students(WebDriver driver) {
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
	 * Navigate to Admission > Masters > Active De-active Student
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_ActiveDeactiveStudent_BGHS() throws Exception {
		if (btn_Admission.isDisplayed()) {
			btn_Admission.click();
			log("Clicked on admission Button and object is:-" + btn_Admission.toString());
			Thread.sleep(1000);
		} else {
			log("Admission button element not present.");
			Thread.sleep(500);
		}
		if (btnAdmission_Masters.isDisplayed()) {
			btnAdmission_Masters.click();
			log("Clicked on Admission masters and object is:-" + btnAdmission_Masters.toString());
			Thread.sleep(1000);
		} else {
			log("Admission masters button element not present.");
			Thread.sleep(500);
		}
		if (btnMasters_ActiveDeactiveStudent.isDisplayed()) {
			btnMasters_ActiveDeactiveStudent.click();
			log("Clicked on Active Deactive Student Button and object is:-"
					+ btnMasters_ActiveDeactiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Active Deactive Student button element not present.");
			Thread.sleep(500);
		}

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
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Submit blank Active Deactive Student form and object is:-" + btn_Save.toString());
			Thread.sleep(5000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillActiveDeactiveStudentForm(String academicYear, String class_AD, String section) throws Exception {

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
			select.selectByVisibleText(class_AD);

			log("selected class: " + class_AD + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_AD);
			Thread.sleep(1000);
		} else {
			log("Class element is not present");
			Thread.sleep(500);
		}
		if (sel_Section.isDisplayed()) {
			select = new Select(sel_Section);
			select.selectByVisibleText(section);

			log("selected section: " + section + " and object is:- " + sel_Section.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(1000);
		} else {
			log("Section element is not present");
			Thread.sleep(500);
		}
	}

	public void select_ActiveStudent_RadioButton() throws Exception {
		if ((rdBtn_ActiveStudent.isDisplayed()) && (!rdBtn_ActiveStudent.isSelected())) {
			rdBtn_ActiveStudent.click();
			log("Active Student radio button is selected and object is:-" + rdBtn_ActiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Active Student radio button is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActiveStudent_RadioButton() throws Exception {
		if ((rdBtn_DeActiveStudent.isDisplayed()) && (!rdBtn_DeActiveStudent.isSelected())) {
			rdBtn_DeActiveStudent.click();
			log("De-Active Student radio button is selected and object is:-" + rdBtn_DeActiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("De-Active Student radio button is already selected (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_ActivateStudent_checkBox() throws Exception {
		if ((chk_ActivateStudent.isDisplayed()) && (!chk_ActivateStudent.isSelected())) {
			chk_ActivateStudent.click();
			log("Activate Student check box is checked and object is:-" + chk_ActivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Student check box is already checked (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void select_DeActivateStudent_checkBox() throws Exception {
		if ((chk_DeActivateStudent.isDisplayed()) && (!chk_DeActivateStudent.isSelected())) {
			chk_DeActivateStudent.click();
			log("De-Activate Student check box is checked and object is:-" + chk_DeActivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("De-Activate Student check box is already checked (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void saveFilledActiveDeactiveStudentForm() throws Exception {
		if (btn_Save.isDisplayed()) {
			btn_Save.click();
			log("Save Active Deactive Student form and object is:-" + btn_Save.toString());
			Thread.sleep(15000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clearFilledActiveDeactiveStudentForm() throws Exception {
		if (btn_Clear.isDisplayed()) {
			btn_Clear.click();
			log("Clear Active Deactive Student form and object is:-" + btn_Clear.toString());
			Thread.sleep(10000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithAdmissionNumber_ActivateDeactivateStudentListGrid(String admissionNum) throws Exception {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(admissionNum);
			log("Entered Admission number to search: " + admissionNum + " and object is:-" + input_Search.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudent_ForActiveDeactiveInGrid(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admNumber, admissionNum);
				log("Student available for active and deactive.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectStudentForActivateDeactivate(String admissionNum) {
		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admNumber = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]"))
					.getText().trim();
			System.out.println("Admission Number: " + admNumber);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admNumber, admissionNum);
				driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]/label/input"))
						.click();
				log("Corresponding student check box is checked for Activate or deactivate.");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOnOkSuccessButton() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
			Thread.sleep(5000);
		} else {
			log("Ok Button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeActiveDeactiveStudent() throws Exception {
		if (btnMin_MaxActiveDeactiveStudent.isDisplayed()) {
			btnMin_MaxActiveDeactiveStudent.click();
			log("Active Deactive Student page minimized and object is:-" + btnMin_MaxActiveDeactiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Active Deactive Student Minimized Element not present.");
		}
	}

	public void maximizeActiveDeactiveStudent() throws Exception {
		if (btnMin_MaxActiveDeactiveStudent.isDisplayed()) {
			btnMin_MaxActiveDeactiveStudent.click();
			log("Active Deactive Student page maximized and object is:-" + btnMin_MaxActiveDeactiveStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Active Deactive Student Maximize Element not present.");
		}
	}

	public void minimizeActivateDeactivateStudent() throws Exception {
		if (btnMin_MaxActivateDeactivateStudent.isDisplayed()) {
			btnMin_MaxActivateDeactivateStudent.click();
			log("Activate Deactivate Student page minimized and object is:-"
					+ btnMin_MaxActivateDeactivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Deactivate Student Minimized Element not present.");
		}
	}

	public void maximizeActivateDeactivateStudent() throws Exception {
		if (btnMin_MaxActivateDeactivateStudent.isDisplayed()) {
			btnMin_MaxActivateDeactivateStudent.click();
			log("Activate Deactivate Student page maximized and object is:-"
					+ btnMin_MaxActivateDeactivateStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Activate Deactivate Student Maximize Element not present.");
		}
	}
}
