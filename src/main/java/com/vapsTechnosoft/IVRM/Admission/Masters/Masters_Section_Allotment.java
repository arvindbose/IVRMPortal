/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

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
public class Masters_Section_Allotment extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Section_Allotment.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[16]")
	WebElement btnMasters_SectionAllotment;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/h1/strong")
	WebElement DashBoard;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_SectionAllotmentMsgDispaly;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[1]")
	WebElement btnSave_NewSection;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[1]")
	WebElement btnCancelClear_NewSection;

	@FindBy(xpath = "(//span[contains(text(),'New Section')])[1]")
	WebElement tab_NewSection;

	@FindBy(xpath = "(//span[contains(text(),'Change Section')])[1]")
	WebElement tab_ChangeSection;

	@FindBy(xpath = "(//span[contains(text(),'Delete Section')])[1]")
	WebElement tab_DeleteSection;

	@FindBy(xpath = "(//span[contains(text(),'Promotion Section')])[1]")
	WebElement tab_PromotionSection;

	@FindBy(xpath = "(//span[contains(text(),'Year Loss Section')])[1]")
	WebElement tab_YearLossSection;

	@FindBy(xpath = "(//span[contains(text(),'Update Roll Number')])[1]")
	WebElement tab_UpdateRollNumber;

	/**
	 * New Section locators
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[1]")
	WebElement sel_AcademicYr_NewSec;

	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[2]")
	WebElement sel_AcademicYr_NewSec_Disabled;

	@FindBy(xpath = "(//label[contains(text(),'Class Admitted:')]/following-sibling::div/select)[1]")
	WebElement sel_ClassAdmitted;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[1]")
	WebElement sel_Class_NewSec;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[1]")
	WebElement sel_Section_NewSec;

	@FindBy(xpath = "(//div[@class='col-sm-5']/table)[1]/tbody/tr")
	List<WebElement> tblRows_AllotStuToSection;

	@FindBy(xpath = "(//div[@class='col-sm-6']/table)[1]/tbody/tr")
	List<WebElement> tblRows_AllotedStuToSection;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[1])[1]")
	WebElement btn_shift_SelectedStudent;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[2])[1]")
	WebElement btn_shift_Back_SelectedStudent;

	@FindBy(xpath = "(//div[@class='input-group']/input)[1]")
	WebElement input_Search;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr")
	List<WebElement> tblRows_Grid;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxNewSection;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxAllotStuToSection;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxSectionAllotedStudentList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/thead/tr/th[2]/a")
	WebElement btn_sortByStudentName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	/**
	 * Delete section
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year :')]/following-sibling::div/select)[1]")
	WebElement sel_AcademicYr_DelSec;

	@FindBy(xpath = "(//label[contains(text(),'Class:')]/following-sibling::div/select)[1]")
	WebElement sel_Class_DelSec;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[4]")
	WebElement sel_Section_DelSec;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr")
	List<WebElement> tblRows_StudentList;

	@FindBy(xpath = "(//div[@class='input-group']/input)[3]")
	WebElement input_Search_Delete;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows_SecAllotedStudentListDel;

	@FindBy(xpath = "(//span[contains(text(),'Delete')]/parent::button)[1]")
	WebElement btn_Delete;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[3]")
	WebElement btn_Clear_DeleteSec;

	/**
	 * Change Section locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[3]")
	WebElement sel_AcademicYr_ChangeSec;

	@FindBy(xpath = "(//label[contains(text(),'Class Admitted:')]/following-sibling::div/select)[2]")
	WebElement sel_ClassAdmitted_ChangeSec;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[2]")
	WebElement sel_Section_ChangeSec;

	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[4]")
	WebElement sel_AcademicYr_Disable_ChangeSec;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[3]")
	WebElement sel_Class_ChangeSec;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[3]")
	WebElement sel_SectionToChange_ChangeSec;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[2]")
	WebElement btn_Save_ChangeSec;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[2]")
	WebElement btn_Clear_ChangeSec;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[3]/tbody/tr")
	List<WebElement> tblRows_StudentToNewSec_Change;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[4]/tbody/tr")
	List<WebElement> tblRows_SecAllotedToNewStudent_Change;

	@FindBy(xpath = "(//div[@class='input-group']/input)[2]")
	WebElement input_Search_ChangeSec;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr")
	List<WebElement> tblRows_GridSectionChange;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[1])[2]")
	WebElement btn_shift_SelectedStudent_SecChange;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[2])[2]")
	WebElement btn_shift_Back_SelectedStudent_SecChange;

	/**
	 * Promotion Section locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[5]")
	WebElement sel_AcademicYr_PromSec;

	@FindBy(xpath = "//label[contains(text(),'No Of Years to promoted:')]/following-sibling::div/input")
	WebElement input_YearsPromoted;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[5]")
	WebElement sel_CurrentClass;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[5]")
	WebElement sel_CurrentSection;

	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[6]")
	WebElement sel_AcademicYr_Disable_PromSec;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[7]")
	WebElement sel_Class_Promoted;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[6]")
	WebElement sel_SectionToPromot_PromSec;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[3]")
	WebElement btn_Save_PromotSec;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[4]")
	WebElement btn_Clear_PromotSec;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[5]/tbody/tr")
	List<WebElement> tblRows_StudentList_Promot;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[6]/tbody/tr")
	List<WebElement> tblRows_Student_Promoted;

	@FindBy(xpath = "(//div[@class='input-group']/input)[4]")
	WebElement input_Search_PromotedStu;

	@FindBy(xpath = "(//div[@class='box-body']/table)[3]/tbody/tr")
	List<WebElement> tblRows_GridPromoted;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[1])[3]")
	WebElement btn_shift_SelectedStudent_PromSection;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[2])[3]")
	WebElement btn_shift_Back_SelectedStudent_PromSection;

	/**
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[7]")
	WebElement sel_AcademicYr_YrLoss;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[9]")
	WebElement sel_Class_YrLoss;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[7]")
	WebElement sel_Section_YrLoss;

	@FindBy(xpath = "(//label[contains(text(),'Academic Year :')]/following-sibling::div/select)[2]")
	WebElement sel_AcademicYr_Disable_YrLoss;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[11]")
	WebElement sel_Class_Disable_YrLoss;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	WebElement sel_SectionToAllot_YrLoss;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[4]")
	WebElement btn_Save_YrLoss;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[5]")
	WebElement btn_Clear_YrLoss;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[7]/tbody/tr")
	List<WebElement> tblRows_StudentList_YrLoss;

	@FindBy(xpath = "(//div[@class='box-body']//div/table)[8]/tbody/tr")
	List<WebElement> tblRows_StudentSelected_YrLoss;

	@FindBy(xpath = "(//div[@class='input-group']/input)[5]")
	WebElement input_Search_YrLossStu_Updated;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows_GridYrLossStu;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[1])[4]")
	WebElement btn_shift_SelectedStudent_YrLoss;

	@FindBy(xpath = "(//div[@class='col-sm-1 text-center']/a[2])[4]")
	WebElement btn_shift_Back_SelectedStudent_YrLoss;

	/**
	 * Update roll number locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[8]")
	WebElement sel_AcademicYr_UpdateRoll;

	@FindBy(xpath = "(//label[contains(text(),'Class :')]/following-sibling::div/select)[13]")
	WebElement sel_Class_UpdateRoll;

	@FindBy(xpath = "(//label[contains(text(),'Section:')]/following-sibling::div/select)[8]")
	WebElement sel_Section_UpdateRoll;

	@FindBy(xpath = "(//div[@class='input-group']/input)[6]")
	WebElement input_Search_ToUpdateRoll;

	@FindBy(xpath = "(//div[@class='']/table)[1]/tbody/tr")
	List<WebElement> tblRows_UpdateRollList;

	@FindBy(xpath = "(//div[@class='input-group']/input)[7]")
	WebElement input_Search_ToUpdatedRollInGrid;

	@FindBy(xpath = "(//div[@class='']/table)[2]/tbody/tr")
	List<WebElement> tblRows_UpdatedRollGrid;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[5]")
	WebElement btn_Save_UpdatedRoll;

	@FindBy(xpath = "(//span[contains(text(),'Clear')]/parent::button)[6]")
	WebElement btn_Clear_UpdatedRoll;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[16]")
	WebElement btnMin_MaxUpdateRoll;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[17]")
	WebElement btnMin_MaxUpdateRollStuList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[18]")
	WebElement btnMin_MaxUpdateRollStuListGrid;

	@FindBy(xpath = "(//div[@class='']/table)[2]/thead/tr/th[2]/a")
	WebElement btn_sortByStudentNameRollGrid;

	public Masters_Section_Allotment(WebDriver driver) {
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
	 * Navigate to Admission Masters Section Allotment
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_SectionAllotment_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_SectionAllotment);

		btnMasters_SectionAllotment.click();
		log("Clicked on Section Allotment Button and object is:-" + btnMasters_SectionAllotment.toString());
		waitForElement(driver, 10, btnSave_NewSection);

	}

	/**
	 * Validation of masters Section Allotment screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_SectionAllotment_BGHSPage() {
		try {
			System.out.println(txtMasters_SectionAllotmentMsgDispaly.getText());
			txtMasters_SectionAllotmentMsgDispaly.isDisplayed();
			log("Section Allotment page is dispalyed and object is:-"
					+ txtMasters_SectionAllotmentMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankNewSectionAllotmentForm() throws Exception {

		btnSave_NewSection.click();
		log("Submit blank New Section Allotment form and object is:-" + btnSave_NewSection.toString());
		Thread.sleep(15000);
	}

	public void fillNewSectionAllotmentForm(String academicYr, String classAdmitted, String section_newSec)
			throws Exception {

		if (sel_AcademicYr_NewSec.isDisplayed()) {
			select = new Select(sel_AcademicYr_NewSec);
			select.selectByVisibleText(academicYr);

			log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_NewSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(2000);
		} else {
			log("Academic Year element is not present");
		}
		if (sel_AcademicYr_NewSec_Disabled.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr_NewSec_Disabled);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr);
			log("Disabled selected academic year: " + SelectedContent + " and object is:- "
					+ sel_AcademicYr_NewSec_Disabled.toString());
			Thread.sleep(2000);
		} else {
			log("Disable academic year element is not present");
		}

		if (sel_ClassAdmitted.isDisplayed()) {
			select = new Select(sel_ClassAdmitted);
			select.selectByVisibleText(classAdmitted);

			log("selected Class Admitted: " + classAdmitted + " and object is:- " + sel_ClassAdmitted.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classAdmitted);
			Thread.sleep(2000);
		} else {
			log("Class Admitted element is not present");
		}

		if (sel_Class_NewSec.isDisplayed()) {
			select = new Select(sel_Class_NewSec);
			select.selectByVisibleText(classAdmitted);

			log("selected Class disabled: " + classAdmitted + " and object is:- " + sel_Class_NewSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classAdmitted);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
		}

		if (sel_Section_NewSec.isDisplayed()) {
			select = new Select(sel_Section_NewSec);
			select.selectByVisibleText(section_newSec);

			log("selected section: " + section_newSec + " and object is:- " + sel_Section_NewSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_newSec);
			Thread.sleep(2000);
		} else {
			log("section element is not present");
		}
	}

	public void selectStudentForSectionAllotment(String admissionNumber) {
		int rows = tblRows_AllotStuToSection.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='col-sm-5']/table)[1]/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(
							By.xpath("(//div[@class='col-sm-5']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void verifyStudentForSectionAllotment_MovedToSectionAllotmentTable(String admissionNumber) {
		int rows = tblRows_AllotedStuToSection.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='col-sm-6']/table)[1]/tbody/tr[" + i + "]/td[4]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Section alloted Admission number is updated in the section allotment table.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void moveSelectedStudentForSectionAllotment() throws Exception {

		if (btn_shift_SelectedStudent.isDisplayed()) {
			btn_shift_SelectedStudent.click();
			log("Selected student for section allotment is moved for section allotment table and object is:-"
					+ btn_shift_SelectedStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Student shift button element is not present.");
			Thread.sleep(500);
		}
	}

	public void clearNewSectionAllotmemntForm() throws Exception {
		if (btnCancelClear_NewSection.isDisplayed()) {
			btnCancelClear_NewSection.click();
			log("Cleared filled section allotment form and object is:-" + btnCancelClear_NewSection.toString());
			Thread.sleep(1000);
		} else {
			log("Clear button element is not present.");
			Thread.sleep(500);
		}
	}

	public void saveNewSectionAllotmemntForm() throws Exception {
		if (btnSave_NewSection.isDisplayed()) {
			btnSave_NewSection.click();
			log("Save filled section allotment form and object is:-" + btnSave_NewSection.toString());
			Thread.sleep(20000);
		} else {
			log("Save button element is not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithStudentNameInNewSectionGrid(String admissionNumber) {
		if (input_Search.isDisplayed()) {
			input_Search.clear();
			input_Search.sendKeys(admissionNumber);
			log("Entered student admission number to search: " + admissionNumber + " and object is:-"
					+ input_Search.toString());
		} else {
			log("Element not present.");
		}
	}

	public void verifyStudentAdmissionNumberInTheGrid(String admissionNumber) throws Exception {

		int rows = tblRows_Grid.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]")).getText()
					.trim();
			System.out.println("Admission number: " + admissionNum);
			Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Section alloted Admission number is updated in the record grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeNewSection() throws Exception {
		if (btnMin_MaxNewSection.isDisplayed()) {
			btnMin_MaxNewSection.click();
			log("New Section page minimize and object is:-" + btnMin_MaxNewSection.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeNewSection() throws Exception {
		if (btnMin_MaxNewSection.isDisplayed()) {
			btnMin_MaxNewSection.click();
			log("New Section page maximized and object is:-" + btnMin_MaxNewSection.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void minimizeSectionAllotedStudentList() throws Exception {
		if (btnMin_MaxSectionAllotedStudentList.isDisplayed()) {
			btnMin_MaxSectionAllotedStudentList.click();
			log("clicked on Section Alloted Student List minimize button and object is:-"
					+ btnMin_MaxSectionAllotedStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeSectionAllotedStudentList() throws Exception {
		if (btnMin_MaxSectionAllotedStudentList.isDisplayed()) {
			btnMin_MaxSectionAllotedStudentList.click();
			log("clicked on Section Alloted Student List maximize button and object is:-"
					+ btnMin_MaxSectionAllotedStudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void minimizeAllotStudentToSection() throws Exception {
		if (btnMin_MaxAllotStuToSection.isDisplayed()) {
			btnMin_MaxAllotStuToSection.click();
			log("AllotStudentToSection minimize and object is:-" + btnMin_MaxAllotStuToSection.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeAllotStudentToSection() throws Exception {
		if (btnMin_MaxAllotStuToSection.isDisplayed()) {
			btnMin_MaxAllotStuToSection.click();
			log("AllotStudentToSection maximized and object is:-" + btnMin_MaxAllotStuToSection.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void sortByStudentNameInGrid() throws Exception {

		if (btn_sortByStudentName.isDisplayed()) {
			btn_sortByStudentName.click();
			log("Sorted the record with Student Name and object is:-" + btn_sortByStudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student name Element not present.");
		}
	}

	public void clickOnOkSuccessButton() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
			Thread.sleep(2000);
		} else {
			log("Ok button Element not present.");
		}
	}

	public void nevigateToDeleteSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_SectionAllotmentMsgDispaly);
		Thread.sleep(2000);

		if (tab_DeleteSection.isDisplayed()) {
			tab_DeleteSection.click();
			log("Navigated to delete section and object is:-" + tab_DeleteSection.toString());
			Thread.sleep(1000);
		} else {
			log("Delete section tab not present.");
			Thread.sleep(500);
		}
	}

	public void submitDeleteSectionForm() throws Exception {

		if (btn_Delete.isDisplayed()) {
			btn_Delete.click();
			log("Click on delete button to submit delete section form and object is:-" + btn_Delete.toString());
			Thread.sleep(15000);
		} else {
			log("Delete button is not present.");
			Thread.sleep(500);
		}
	}

	public void fillDeleteSectionFormToSelectStudentData(String academicYear, String class_Del, String section_del)
			throws Exception {

		if (sel_AcademicYr_DelSec.isDisplayed()) {
			select = new Select(sel_AcademicYr_DelSec);
			select.selectByVisibleText(academicYear);

			log("selected Academic year: " + academicYear + " and object is:- " + sel_AcademicYr_DelSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(2000);
		} else {
			log("Academic year element is not present");
		}

		if (sel_Class_DelSec.isDisplayed()) {
			select = new Select(sel_Class_DelSec);
			select.selectByVisibleText(class_Del);

			log("selected Class: " + class_Del + " and object is:- " + sel_Class_DelSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Del);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
		}
		if (sel_Section_DelSec.isDisplayed()) {
			select = new Select(sel_Section_DelSec);
			select.selectByVisibleText(section_del);

			log("selected Class: " + section_del + " and object is:- " + sel_Section_DelSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_del);
			Thread.sleep(2000);
		} else {
			log("Section element is not present");
		}
	}

	public void searchWithStudentNameInThe_DeleteSectionGrid(String admissionNumber) throws Exception {
		if (input_Search_Delete.isDisplayed()) {
			input_Search_Delete.clear();
			input_Search_Delete.sendKeys(admissionNumber);
			log("Entered student admission number to search: " + admissionNumber + " and object is:-"
					+ input_Search_Delete.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyStudentIn_DeleteSectionAllotedGrid(String admissionNumber) {
		int rows = tblRows_SecAllotedStudentListDel.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					log("Student section not deleted.");

				} else {
					log("Student section correctly deleted.");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clearfilledDeleteSectionForm() throws Exception {
		if (btn_Clear_DeleteSec.isDisplayed()) {
			btn_Clear_DeleteSec.click();
			log("clicked on clear button to clear all filled data ofr deleting of section and object is:-"
					+ btn_Clear_DeleteSec.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button not present.");
			Thread.sleep(500);
		}
	}

	public void selectStudentToDeleteSection(String admissionNumber) {
		int rows = tblRows_StudentList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[6]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void nevigateToNewSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (tab_NewSection.isDisplayed()) {
			tab_NewSection.click();
			log("Navigated to New section and object is:-" + tab_NewSection.toString());
			Thread.sleep(1000);
		} else {
			log("New section tab not present.");
			Thread.sleep(500);
		}
	}

	public void nevigateToChangeSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (tab_ChangeSection.isDisplayed()) {
			tab_ChangeSection.click();
			log("Navigated to change section and object is:-" + tab_ChangeSection.toString());
			Thread.sleep(1000);
		} else {
			log("Change section tab not present.");
			Thread.sleep(500);
		}
	}

	public void fillChangeSectionAllotmentForm(String academicYr, String classAdmitted, String section,
			String section_ToChange) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (sel_AcademicYr_ChangeSec.isDisplayed()) {
			select = new Select(sel_AcademicYr_ChangeSec);
			select.selectByVisibleText(academicYr);

			log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_ChangeSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(2000);
		} else {
			log("Academic Year element is not present");
		}
		if (sel_AcademicYr_Disable_ChangeSec.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr_Disable_ChangeSec);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr);
			log("Disabled selected academic year: " + SelectedContent + " and object is:- "
					+ sel_AcademicYr_Disable_ChangeSec.toString());
			Thread.sleep(2000);
		} else {
			log("Disable academic year element is not present");
		}

		if (sel_ClassAdmitted_ChangeSec.isDisplayed()) {
			select = new Select(sel_ClassAdmitted_ChangeSec);
			select.selectByVisibleText(classAdmitted);

			log("selected Class Admitted: " + classAdmitted + " and object is:- "
					+ sel_ClassAdmitted_ChangeSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classAdmitted);
			Thread.sleep(2000);
		} else {
			log("Class Admitted element is not present");
		}

		if (sel_Class_ChangeSec.isDisplayed()) {
			select = new Select(sel_Class_ChangeSec);
			select.selectByVisibleText(classAdmitted);

			log("selected Class disabled: " + classAdmitted + " and object is:- " + sel_Class_ChangeSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classAdmitted);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
		}

		if (sel_Section_ChangeSec.isDisplayed()) {
			select = new Select(sel_Section_ChangeSec);
			select.selectByVisibleText(section);

			log("selected section: " + section + " and object is:- " + sel_Section_ChangeSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section);
			Thread.sleep(2000);
		} else {
			log("section element is not present");
		}
		if (sel_SectionToChange_ChangeSec.isDisplayed()) {
			select = new Select(sel_SectionToChange_ChangeSec);
			select.selectByVisibleText(section_ToChange);

			log("selected section To change: " + section_ToChange + " and object is:- "
					+ sel_SectionToChange_ChangeSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_ToChange);
			Thread.sleep(2000);
		} else {
			log("section To Chnage element is not present");
		}
	}

	public void selectStudentForSection_Change(String admissionNumber) {
		int rows = tblRows_StudentToNewSec_Change.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[3]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(By.xpath(
							"(//div[@class='box-body']//div/table)[3]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void verifyStudentForSectionChange_MovedToSectionChangeTable(String admissionNumber) {
		int rows = tblRows_SecAllotedToNewStudent_Change.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[4]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Section alloted Admission number is updated in the section allotment table.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void moveSelectedStudentForSectionChange() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (btn_shift_SelectedStudent_SecChange.isDisplayed()) {
			btn_shift_SelectedStudent_SecChange.click();
			log("Selected student for section change is moved for section change table and object is:-"
					+ btn_shift_SelectedStudent_SecChange.toString());
			Thread.sleep(1000);
		} else {
			log("Student shift button element is not present.");
			Thread.sleep(500);
		}
	}

	public void saveSectionChange() throws Exception {
		if (btn_Save_ChangeSec.isDisplayed()) {
			btn_Save_ChangeSec.click();
			log("Clicked on Save button to save the section change request and object is:-"
					+ btn_Save_ChangeSec.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clearSectionChangeData() throws Exception {
		if (btn_Clear_ChangeSec.isDisplayed()) {
			btn_Clear_ChangeSec.click();
			log("Clear filled section change data and object is:-" + btn_Clear_ChangeSec.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void searchWithStudentNameInThe_ChangeSectionGrid(String admissionNumber) {
		if (input_Search_ChangeSec.isDisplayed()) {
			input_Search_ChangeSec.clear();
			input_Search_ChangeSec.sendKeys(admissionNumber);
			log("Entered student admission number to search: " + admissionNumber + " and object is:-"
					+ input_Search_ChangeSec.toString());
		} else {
			log("Element not present.");
		}
	}

	public void verifyStudentIn_ChangeSectionAllotedGrid(String admissionNumber) {
		int rows = tblRows_GridSectionChange.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admissionNum, admissionNumber);
				log("Student section chnage is updated in the section change grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void searchWithStudentNameInThe_PromoteStudentGrid(String admissionNumber) {
		if (input_Search_PromotedStu.isDisplayed()) {
			input_Search_PromotedStu.clear();
			input_Search_PromotedStu.sendKeys(admissionNumber);
			log("Entered student admission number to search: " + admissionNumber + " and object is:-"
					+ input_Search_PromotedStu.toString());
		} else {
			log("Element not present.");
		}
	}

	public void verifyStudentIn_PromotedStudentGrid(String admissionNumber) {
		int rows = tblRows_GridPromoted.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[3]/tbody/tr[" + i + "]/td[5]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				Assert.assertEquals(admissionNum, admissionNumber);
				log("Student promoted section is updated in the promotion section grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void nevigateToPromotionSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (tab_PromotionSection.isDisplayed()) {
			tab_PromotionSection.click();
			log("Navigated to promotion section and object is:-" + tab_PromotionSection.toString());
			Thread.sleep(1000);
		} else {
			log("Promotion section tab not present.");
			Thread.sleep(500);
		}
	}

	public void fillPromotionSectionAllotmentForm(String academicYr, String YrsToPromot, String class_Current,
			String section_Current, String academicYr_Promot, String promoted_Class, String section_ToPromot)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (sel_AcademicYr_PromSec.isDisplayed()) {
			select = new Select(sel_AcademicYr_PromSec);
			select.selectByVisibleText(academicYr);

			log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_PromSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(2000);
		} else {
			log("Academic Year element is not present");
		}

		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("Number of years to be promoted pop up is handled and object is:-" + btnOKSuccess.toString());
			Thread.sleep(1000);
		} else {
			log("Pop up OK button element not present.");
			Thread.sleep(500);
		}

		if (input_YearsPromoted.isDisplayed()) {
			input_YearsPromoted.clear();
			input_YearsPromoted.sendKeys(YrsToPromot);
			log("Entered No of years promoted:" + YrsToPromot + " and object is:-" + input_YearsPromoted.toString());
			Thread.sleep(500);
		} else {
			log("Number of years promoted element not present.");
		}

		if (sel_CurrentClass.isDisplayed()) {
			select = new Select(sel_CurrentClass);
			select.selectByVisibleText(class_Current);

			log("selected Current Class for promotion: " + class_Current + " and object is:- "
					+ sel_CurrentClass.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Current);
			Thread.sleep(2000);
		} else {
			log("Class Current element is not present");
		}

		if (sel_CurrentSection.isDisplayed()) {
			select = new Select(sel_CurrentSection);
			select.selectByVisibleText(section_Current);

			log("selected Current section: " + section_Current + " and object is:- " + sel_CurrentSection.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_Current);
			Thread.sleep(2000);
		} else {
			log("Current section element is not present");
		}

		if (sel_AcademicYr_Disable_PromSec.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr_Disable_PromSec);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr_Promot);
			log("Disabled promoted academic year: " + SelectedContent + " and object is:- "
					+ sel_AcademicYr_Disable_PromSec.toString());
			Thread.sleep(2000);
		} else {
			log("Disable promoted academic year element is not present");
		}
		if (sel_Class_Promoted.isDisplayed()) {
			Select dropdown1 = new Select(sel_Class_Promoted);
			WebElement dropdownOption1 = dropdown1.getFirstSelectedOption();
			String SelectedContent1 = dropdownOption1.getText().trim();
			System.out.println("selected Value " + SelectedContent1);
			Assert.assertEquals(SelectedContent1, promoted_Class);
			log("Disabled promoted class: " + SelectedContent1 + " and object is:- " + sel_Class_Promoted.toString());
			Thread.sleep(2000);
		} else {
			log("Disable promoted class element is not present");
		}

		if (sel_SectionToPromot_PromSec.isDisplayed()) {
			select = new Select(sel_SectionToPromot_PromSec);
			select.selectByVisibleText(section_ToPromot);

			log("selected section to promot: " + section_ToPromot + " and object is:- "
					+ sel_SectionToPromot_PromSec.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_ToPromot);
			Thread.sleep(2000);
		} else {
			log("Promoted section element is not present");
		}

	}

	public void selectStudentForSection_Promotion(String admissionNumber) {
		int rows = tblRows_StudentList_Promot.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[5]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(By.xpath(
							"(//div[@class='box-body']//div/table)[5]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void verifyStudentForSectionPromotion_MovedToSectionPromotionTable(String admissionNumber) {
		int rows = tblRows_Student_Promoted.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[6]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Section promoted Admission number is updated in the section promotion table.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void moveSelectedStudentForSectionPromotion() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (btn_shift_SelectedStudent_PromSection.isDisplayed()) {
			btn_shift_SelectedStudent_PromSection.click();
			log("Selected student for section promotion is moved for section promotion table and object is:-"
					+ btn_shift_SelectedStudent_PromSection.toString());
			Thread.sleep(1000);
		} else {
			log("Student shift button element is not present.");
			Thread.sleep(500);
		}
	}

	public void saveSectionPromotion() throws Exception {
		if (btn_Save_PromotSec.isDisplayed()) {
			btn_Save_PromotSec.click();
			log("Clicked on Save button to save the section promotion request and object is:-"
					+ btn_Save_PromotSec.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clearSectionPromotionData() throws Exception {
		if (btn_Clear_PromotSec.isDisplayed()) {
			btn_Clear_PromotSec.click();
			log("Clear filled section promotion data and object is:-" + btn_Clear_PromotSec.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void nevigateToYearLossSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (tab_YearLossSection.isDisplayed()) {
			tab_YearLossSection.click();
			log("Navigated to Year Loss Section and object is:-" + tab_YearLossSection.toString());
			Thread.sleep(1000);
		} else {
			log("Year Loss Section tab not present.");
			Thread.sleep(500);
		}
	}

	public void saveYearLossSection() throws Exception {
		if (btn_Save_YrLoss.isDisplayed()) {
			btn_Save_YrLoss.click();
			log("Clicked on Save button to save the Year Loss request and object is:-" + btn_Save_YrLoss.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clearYearLossSectionData() throws Exception {
		if (btn_Clear_YrLoss.isDisplayed()) {
			btn_Clear_YrLoss.click();
			log("Clear filled Year Loss Section data and object is:-" + btn_Clear_YrLoss.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillYearLossSectionAllotmentForm(String academicYr, String class_Current, String section_Current,
			String academicYr_New, String new_Class, String section_YrLoss) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (sel_AcademicYr_YrLoss.isDisplayed()) {
			select = new Select(sel_AcademicYr_YrLoss);
			select.selectByVisibleText(academicYr);

			log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_YrLoss.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(2000);
		} else {
			log("Academic Year element is not present");
		}

		if (sel_Class_YrLoss.isDisplayed()) {
			select = new Select(sel_Class_YrLoss);
			select.selectByVisibleText(class_Current);

			log("selected Current Class for YrLoss: " + class_Current + " and object is:- "
					+ sel_Class_YrLoss.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_Current);
			Thread.sleep(2000);
		} else {
			log("Class Current element is not present");
		}

		if (sel_Section_YrLoss.isDisplayed()) {
			select = new Select(sel_Section_YrLoss);
			select.selectByVisibleText(section_Current);

			log("selected Current section: " + section_Current + " and object is:- " + sel_Section_YrLoss.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_Current);
			Thread.sleep(2000);
		} else {
			log("Current section element is not present");
		}

		if (sel_AcademicYr_Disable_YrLoss.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYr_Disable_YrLoss);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr_New);
			log("Disabled promoted academic year: " + SelectedContent + " and object is:- "
					+ sel_AcademicYr_Disable_YrLoss.toString());
			Thread.sleep(2000);
		} else {
			log("Disable promoted academic year element is not present");
		}
		if (sel_Class_Disable_YrLoss.isDisplayed()) {
			Select dropdown2 = new Select(sel_Class_Disable_YrLoss);
			WebElement dropdownOption2 = dropdown2.getFirstSelectedOption();
			String SelectedContent2 = dropdownOption2.getText().trim();
			System.out.println("selected Value " + SelectedContent2);
			Assert.assertEquals(SelectedContent2, new_Class);
			log("Disabled Year loss class: " + SelectedContent2 + " and object is:- "
					+ sel_Class_Disable_YrLoss.toString());
			Thread.sleep(2000);
		} else {
			log("Disable year loss class element is not present");
		}

		if (sel_SectionToAllot_YrLoss.isDisplayed()) {
			select = new Select(sel_SectionToAllot_YrLoss);
			select.selectByVisibleText(section_YrLoss);

			log("selected section to year loss: " + section_YrLoss + " and object is:- "
					+ sel_SectionToAllot_YrLoss.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_YrLoss);
			Thread.sleep(2000);
		} else {
			log("year loss section element is not present");
		}

	}

	public void selectStudentFor_YearLossStudent(String admissionNumber) {
		int rows = tblRows_StudentList_YrLoss.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[7]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(By.xpath(
							"(//div[@class='box-body']//div/table)[7]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void verifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable(String admissionNumber) {
		int rows = tblRows_StudentSelected_YrLoss.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']//div/table)[8]/tbody/tr[" + i + "]/td[6]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Year Loss Section Admission number is updated in the section promotion table.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void moveSelectedStudentForYearLossSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (btn_shift_SelectedStudent_YrLoss.isDisplayed()) {
			btn_shift_SelectedStudent_YrLoss.click();
			log("Selected student for Year Loss section is moved for section promotion table and object is:-"
					+ btn_shift_SelectedStudent_YrLoss.toString());
			Thread.sleep(1000);
		} else {
			log("Student shift button element is not present.");
			Thread.sleep(500);
		}
	}

	public void searchStudentToValidateUpdatedYearLossStudentInGrid(String admissionNumber) throws Exception {

		if (input_Search_YrLossStu_Updated.isDisplayed()) {
			input_Search_YrLossStu_Updated.clear();
			input_Search_YrLossStu_Updated.sendKeys(admissionNumber);
			log("Entered admission number " + admissionNumber + " to search student in the grid and object is:-"
					+ input_Search_YrLossStu_Updated.toString());
			Thread.sleep(1000);
		} else {
			log("Search element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyUpdatedYearLossStudentInGrid(String admissionNumber) {
		int rows = tblRows_GridYrLossStu.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]")).getText()
					.trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Admission number updated in the year loss section output grid " + admissionNumber);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void nevigateToUpdateRollNumber() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (tab_UpdateRollNumber.isDisplayed()) {
			tab_UpdateRollNumber.click();
			log("Navigated to Update roll number and object is:-" + tab_UpdateRollNumber.toString());
			Thread.sleep(1000);
		} else {
			log("Update roll number tab not present.");
			Thread.sleep(500);
		}
	}

	public void saveUpdateRollNumber() throws Exception {
		if (btn_Save_UpdatedRoll.isDisplayed()) {
			btn_Save_UpdatedRoll.click();
			log("Clicked on Save button to save the updated roll number request and object is:-"
					+ btn_Save_UpdatedRoll.toString());
			Thread.sleep(10000);
		} else {
			log("Save button element not present.");
			Thread.sleep(500);
		}
	}

	public void clearUpdateRollNumberData() throws Exception {
		if (btn_Clear_UpdatedRoll.isDisplayed()) {
			btn_Clear_UpdatedRoll.click();
			log("Clear filled updated roll number data and object is:-" + btn_Clear_UpdatedRoll.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
			Thread.sleep(500);
		}
	}

	public void fillUpdateRollNumberAllotmentForm(String academicYr, String class_rollNo, String section_rollNo)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		if (sel_AcademicYr_UpdateRoll.isDisplayed()) {
			select = new Select(sel_AcademicYr_UpdateRoll);
			select.selectByVisibleText(academicYr);

			log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_UpdateRoll.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYr);
			Thread.sleep(2000);
		} else {
			log("Academic Year element is not present");
		}

		if (sel_Class_UpdateRoll.isDisplayed()) {
			select = new Select(sel_Class_UpdateRoll);
			select.selectByVisibleText(class_rollNo);

			log("selected Class for roll number update: " + class_rollNo + " and object is:- "
					+ sel_Class_UpdateRoll.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_rollNo);
			Thread.sleep(2000);
		} else {
			log("Class roll number element is not present");
		}

		if (sel_Section_UpdateRoll.isDisplayed()) {
			select = new Select(sel_Section_UpdateRoll);
			select.selectByVisibleText(section_rollNo);

			log("selected section for roll number: " + section_rollNo + " and object is:- "
					+ sel_Section_UpdateRoll.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), section_rollNo);
			Thread.sleep(2000);
		} else {
			log("Current section element is not present");
		}
	}

	public void updateRollNumberForTheStudent(String admissionNumber, String rollNumber) {
		int rows = tblRows_UpdateRollList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver.findElement(By.xpath("(//div[@class='']/table)[1]/tbody/tr[" + i + "]/td[5]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement rollnumber = driver
							.findElement(By.xpath("(//div[@class='']/table)[1]/tbody/tr[" + i + "]/td[7]/label/input"));

					rollnumber.clear();
					rollnumber.sendKeys(rollNumber);
					log("Entered roll for the student " + rollNumber + " and object is:-" + rollnumber.toString());

					break;
				} else {
					log("Admission Number not matched with the Student name list");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void searchStudentToUpdateRollNumber(String admissionNumber) throws Exception {

		if (input_Search_ToUpdateRoll.isDisplayed()) {
			input_Search_ToUpdateRoll.clear();
			input_Search_ToUpdateRoll.sendKeys(admissionNumber);
			log("Entered admission number " + admissionNumber + " to search student and object is:-"
					+ input_Search_ToUpdateRoll.toString());
			Thread.sleep(1000);
		} else {
			log("Search element not present.");
			Thread.sleep(500);
		}
	}

	public void searchStudentToValidateUpdatedRollNumberInGrid(String admissionNumber) throws Exception {

		if (input_Search_ToUpdatedRollInGrid.isDisplayed()) {
			input_Search_ToUpdatedRollInGrid.clear();
			input_Search_ToUpdatedRollInGrid.sendKeys(admissionNumber);
			log("Entered admission number " + admissionNumber + " to search student in the grid and object is:-"
					+ input_Search_ToUpdatedRollInGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Search element not present.");
			Thread.sleep(500);
		}
	}

	public void verifyUpdatedRollNumberForTheStudentInGrid(String admissionNumber, String rollNumber) {
		int rows = tblRows_UpdatedRollGrid.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String admissionNum = driver.findElement(By.xpath("(//div[@class='']/table)[2]/tbody/tr[" + i + "]/td[5]"))
					.getText().trim();
			System.out.println("Admission Number: " + admissionNum);
			// Thread.sleep(2000);
			try {
				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					String rollnumber = driver
							.findElement(By.xpath("(//div[@class='']/table)[2]/tbody/tr[" + i + "]/td[6]")).getText()
							.trim();

					Assert.assertEquals(rollnumber, rollNumber);
					log("Roll number updated in the output grid " + rollnumber);

					break;
				} else {
					log("Admission Number not matched with the Student name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void minimizeUpdateRollNumber() throws Exception {
		if (btnMin_MaxUpdateRoll.isDisplayed()) {
			btnMin_MaxUpdateRoll.click();
			log("Update roll number page minimize and object is:-" + btnMin_MaxUpdateRoll.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeUpdateRollNumber() throws Exception {
		if (btnMin_MaxUpdateRoll.isDisplayed()) {
			btnMin_MaxUpdateRoll.click();
			log("Update roll number page maximized and object is:-" + btnMin_MaxUpdateRoll.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void minimizeUpdateRollNumberStudentList() throws Exception {
		if (btnMin_MaxUpdateRollStuList.isDisplayed()) {
			btnMin_MaxUpdateRollStuList.click();
			log("clicked on update roll number Student List minimize button and object is:-"
					+ btnMin_MaxUpdateRollStuList.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeUpdateRollNumberStudentList() throws Exception {
		if (btnMin_MaxUpdateRollStuList.isDisplayed()) {
			btnMin_MaxUpdateRollStuList.click();
			log("clicked on update roll number Student List maximize button and object is:-"
					+ btnMin_MaxUpdateRollStuList.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void minimizeUpdatedRollNumberInGrid() throws Exception {
		if (btnMin_MaxUpdateRollStuListGrid.isDisplayed()) {
			btnMin_MaxUpdateRollStuListGrid.click();
			log("Student list grid minimize and object is:-" + btnMin_MaxUpdateRollStuListGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Minimize Element not present.");
		}
	}

	public void maximizeUpdatedRollNumberInGrid() throws Exception {
		if (btnMin_MaxUpdateRollStuListGrid.isDisplayed()) {
			btnMin_MaxUpdateRollStuListGrid.click();
			log("Student list grid maximized and object is:-" + btnMin_MaxUpdateRollStuListGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Maximize Element not present.");
		}
	}

	public void sortByStudentNameInUpdateRollNumberGrid() throws Exception {

		if (btn_sortByStudentNameRollGrid.isDisplayed()) {
			btn_sortByStudentNameRollGrid.click();
			log("Sorted the record with Student Name in the grid and object is:-"
					+ btn_sortByStudentNameRollGrid.toString());
			Thread.sleep(1000);
		} else {
			log("Student name Element not present.");
		}
	}
}
