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

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[15]")
	// WebElement btnMasters_SectionAllotment;

	@FindBy(xpath = "//a[@href='#/app/sectionallotment/51']")
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

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Section_Allotment(WebDriver driver) {
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
	 * Navigate to Admission Masters Section Allotment
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_SectionAllotment_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_SectionAllotment);
		log("Clicked on Section Allotment Button and object is:-" + btnMasters_SectionAllotment.toString());

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

		clickOnButton(btnSave_NewSection);
		log("Submit blank New Section Allotment form and object is:-" + btnSave_NewSection.toString());
		Thread.sleep(1000);
	}

	public void fillNewSectionAllotmentForm(String academicYr, String classAdmitted, String section_newSec)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYr_NewSec, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_NewSec.toString());

		selectedDropdownItemValidation(sel_AcademicYr_NewSec_Disabled, academicYr);
		log("Disabled selected academic year: " + academicYr + " and object is:- "
				+ sel_AcademicYr_NewSec_Disabled.toString());

		selectElementFromDropDown(sel_ClassAdmitted, classAdmitted);
		log("selected Class Admitted: " + classAdmitted + " and object is:- " + sel_ClassAdmitted.toString());

		selectElementFromDropDown(sel_Class_NewSec, classAdmitted);
		log("selected Class disabled: " + classAdmitted + " and object is:- " + sel_Class_NewSec.toString());

		selectElementFromDropDown(sel_Section_NewSec, section_newSec);
		log("selected section: " + section_newSec + " and object is:- " + sel_Section_NewSec.toString());

	}

	public void selectStudentForSectionAllotment(String admissionNumber) {
		int rows = tblRows_AllotStuToSection.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='col-sm-5']/table)[1]/tbody/tr[" + i + "]/td[4]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(
							By.xpath("(//div[@class='col-sm-5']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(1000);
					} else {
						log("Student check box is already selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(500);
					}

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyStudentForSectionAllotment_MovedToSectionAllotmentTable(String admissionNumber) {
		int rows = tblRows_AllotedStuToSection.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='col-sm-6']/table)[1]/tbody/tr[" + i + "]/td[4]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				if (admissionNum.equalsIgnoreCase(admissionNumber)) {
					// Assert.assertEquals(admissionNum, admissionNumber);
					log("Section alloted Admission number is updated in the section allotment table.");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveSelectedStudentForSectionAllotment() throws Exception {

		clickOnButton(btn_shift_SelectedStudent);
		log("Selected student for section allotment is moved for section allotment table and object is:-"
				+ btn_shift_SelectedStudent.toString());
	}

	public void clearNewSectionAllotmemntForm() throws Exception {

		clickOnButton(btnCancelClear_NewSection);
		log("Cleared filled section allotment form and object is:-" + btnCancelClear_NewSection.toString());

	}

	public void saveNewSectionAllotmemntForm() throws Exception {

		clickOnButton(btnSave_NewSection);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Save filled section allotment form and object is:-" + btnSave_NewSection.toString());

	}

	public void searchWithStudentNameInNewSectionGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search, admissionNumber);
		log("Entered student admission number to search: " + admissionNumber + " and object is:-"
				+ input_Search.toString());

	}

	public void verifyStudentAdmissionNumberInTheGrid(String admissionNumber) throws Exception {

		int rows = tblRows_Grid.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]"))
						.getText().trim();
				System.out.println("Admission number: " + admissionNum);
				Thread.sleep(2000);

				if (admissionNum.equals(admissionNumber)) {
					// Assert.assertEquals(admissionNum, admissionNumber);
					log("Section alloted Admission number is updated in the record grid.");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizeNewSection() throws Exception {

		clickOnButton(btnMin_MaxNewSection);
		log("New Section page minimize and object is:-" + btnMin_MaxNewSection.toString());

	}

	public void maximizeNewSection() throws Exception {

		clickOnButton(btnMin_MaxNewSection);
		log("New Section page maximized and object is:-" + btnMin_MaxNewSection.toString());

	}

	public void minimizeSectionAllotedStudentList() throws Exception {

		clickOnButton(btnMin_MaxSectionAllotedStudentList);
		log("clicked on Section Alloted Student List minimize button and object is:-"
				+ btnMin_MaxSectionAllotedStudentList.toString());

	}

	public void maximizeSectionAllotedStudentList() throws Exception {

		clickOnButton(btnMin_MaxSectionAllotedStudentList);
		log("clicked on Section Alloted Student List maximize button and object is:-"
				+ btnMin_MaxSectionAllotedStudentList.toString());

	}

	public void minimizeAllotStudentToSection() throws Exception {

		clickOnButton(btnMin_MaxAllotStuToSection);
		log("AllotStudentToSection minimize and object is:-" + btnMin_MaxAllotStuToSection.toString());
	}

	public void maximizeAllotStudentToSection() throws Exception {

		clickOnButton(btnMin_MaxAllotStuToSection);
		log("AllotStudentToSection maximized and object is:-" + btnMin_MaxAllotStuToSection.toString());

	}

	public void sortByStudentNameInGrid() throws Exception {

		clickOnButton(btn_sortByStudentName);
		log("Sorted the record with Student Name and object is:-" + btn_sortByStudentName.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void nevigateToDeleteSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtMasters_SectionAllotmentMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(tab_DeleteSection);
		log("Navigated to delete section and object is:-" + tab_DeleteSection.toString());
	}

	public void submitDeleteSectionForm() throws Exception {

		clickOnButton(btn_Delete);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Click on delete button to submit delete section form and object is:-" + btn_Delete.toString());

	}

	public void fillDeleteSectionFormToSelectStudentData(String academicYear, String class_Del, String section_del)
			throws Exception {

		selectElementFromDropDown(sel_AcademicYr_DelSec, academicYear);
		log("selected Academic year: " + academicYear + " and object is:- " + sel_AcademicYr_DelSec.toString());

		selectElementFromDropDown(sel_Class_DelSec, class_Del);
		log("selected Class: " + class_Del + " and object is:- " + sel_Class_DelSec.toString());

		selectElementFromDropDown(sel_Section_DelSec, section_del);
		log("selected Class: " + section_del + " and object is:- " + sel_Section_DelSec.toString());

	}

	public void searchWithStudentNameInThe_DeleteSectionGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search_Delete, admissionNumber);
		log("Entered student admission number to search: " + admissionNumber + " and object is:-"
				+ input_Search_Delete.toString());

	}

	public void verifyStudentIn_DeleteSectionAllotedGrid(String admissionNumber) {
		int rows = tblRows_SecAllotedStudentListDel.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		clickOnButton(btn_Clear_DeleteSec);
		log("clicked on clear button to clear all filled data ofr deleting of section and object is:-"
				+ btn_Clear_DeleteSec.toString());

	}

	public void selectStudentToDeleteSection(String admissionNumber) {
		int rows = tblRows_StudentList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(
							By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(1000);
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

		clickOnButton(tab_NewSection);
		log("Navigated to New section and object is:-" + tab_NewSection.toString());

	}

	public void nevigateToChangeSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		clickOnButton(tab_ChangeSection);
		log("Navigated to change section and object is:-" + tab_ChangeSection.toString());

	}

	public void fillChangeSectionAllotmentForm(String academicYr, String classAdmitted, String section,
			String section_ToChange) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		selectElementFromDropDown(sel_AcademicYr_ChangeSec, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_ChangeSec.toString());

		selectedDropdownItemValidation(sel_AcademicYr_Disable_ChangeSec, academicYr);
		log("Disabled selected academic year: " + academicYr + " and object is:- "
				+ sel_AcademicYr_Disable_ChangeSec.toString());

		selectElementFromDropDown(sel_ClassAdmitted_ChangeSec, classAdmitted);
		log("selected Class Admitted: " + classAdmitted + " and object is:- " + sel_ClassAdmitted_ChangeSec.toString());

		selectElementFromDropDown(sel_Class_ChangeSec, classAdmitted);
		log("selected Class disabled: " + classAdmitted + " and object is:- " + sel_Class_ChangeSec.toString());

		selectElementFromDropDown(sel_Section_ChangeSec, section);
		log("selected section: " + section + " and object is:- " + sel_Section_ChangeSec.toString());

		selectElementFromDropDown(sel_SectionToChange_ChangeSec, section_ToChange);
		log("selected section To change: " + section_ToChange + " and object is:- "
				+ sel_SectionToChange_ChangeSec.toString());

	}

	public void selectStudentForSection_Change(String admissionNumber) {
		int rows = tblRows_StudentToNewSec_Change.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[3]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				if (admissionNum.equalsIgnoreCase(admissionNumber)) {

					WebElement studentcheckbox = driver.findElement(By.xpath(
							"(//div[@class='box-body']//div/table)[3]/tbody/tr[" + i + "]/td[2]/label/input[2]"));
					if (!studentcheckbox.isSelected()) {
						studentcheckbox.click();
						log("Student check box is selected and object is:-" + studentcheckbox.toString());
						Thread.sleep(1000);
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
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[4]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		clickOnButton(btn_shift_SelectedStudent_SecChange);
		log("Selected student for section change is moved for section change table and object is:-"
				+ btn_shift_SelectedStudent_SecChange.toString());

	}

	public void saveSectionChange() throws Exception {

		clickOnButton(btn_Save_ChangeSec);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on Save button to save the section change request and object is:-"
				+ btn_Save_ChangeSec.toString());

	}

	public void clearSectionChangeData() throws Exception {

		clickOnButton(btn_Clear_ChangeSec);
		log("Clear filled section change data and object is:-" + btn_Clear_ChangeSec.toString());

	}

	public void searchWithStudentNameInThe_ChangeSectionGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search_ChangeSec, admissionNumber);
		log("Entered student admission number to search: " + admissionNumber + " and object is:-"
				+ input_Search_ChangeSec.toString());

	}

	public void verifyStudentIn_ChangeSectionAllotedGrid(String admissionNumber) {
		int rows = tblRows_GridSectionChange.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[1]/tbody/tr[" + i + "]/td[5]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				Assert.assertEquals(admissionNum, admissionNumber);
				log("Student section chnage is updated in the section change grid.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void searchWithStudentNameInThe_PromoteStudentGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search_PromotedStu, admissionNumber);
		log("Entered student admission number to search: " + admissionNumber + " and object is:-"
				+ input_Search_PromotedStu.toString());

	}

	public void verifyStudentIn_PromotedStudentGrid(String admissionNumber) {
		int rows = tblRows_GridPromoted.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[3]/tbody/tr[" + i + "]/td[5]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				Thread.sleep(1000);
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

		clickOnButton(tab_PromotionSection);
		log("Navigated to promotion section and object is:-" + tab_PromotionSection.toString());

	}

	public void fillPromotionSectionAllotmentForm(String academicYr, String YrsToPromot, String class_Current,
			String section_Current, String academicYr_Promot, String promoted_Class, String section_ToPromot)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		selectElementFromDropDown(sel_AcademicYr_PromSec, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_PromSec.toString());

		clickOnButton(btnOKSuccess);
		log("Number of years to be promoted pop up is handled and object is:-" + btnOKSuccess.toString());

		inputTextIntoInputField(input_YearsPromoted, YrsToPromot);
		log("Entered No of years promoted:" + YrsToPromot + " and object is:-" + input_YearsPromoted.toString());

		selectElementFromDropDown(sel_CurrentClass, class_Current);
		log("selected Current Class for promotion: " + class_Current + " and object is:- "
				+ sel_CurrentClass.toString());

		selectElementFromDropDown(sel_CurrentSection, section_Current);
		log("selected Current section: " + section_Current + " and object is:- " + sel_CurrentSection.toString());

		selectedDropdownItemValidation(sel_AcademicYr_Disable_PromSec, academicYr_Promot);
		log("Disabled promoted academic year: " + academicYr_Promot + " and object is:- "
				+ sel_AcademicYr_Disable_PromSec.toString());

		selectedDropdownItemValidation(sel_Class_Promoted, promoted_Class);
		log("Disabled promoted class: " + promoted_Class + " and object is:- " + sel_Class_Promoted.toString());

		selectElementFromDropDown(sel_SectionToPromot_PromSec, section_ToPromot);
		log("selected section to promot: " + section_ToPromot + " and object is:- "
				+ sel_SectionToPromot_PromSec.toString());

	}

	public void selectStudentForSection_Promotion(String admissionNumber) {
		int rows = tblRows_StudentList_Promot.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[5]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[6]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

				Thread.sleep(1000);
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

		clickOnButton(btn_shift_SelectedStudent_PromSection);
		log("Selected student for section promotion is moved for section promotion table and object is:-"
				+ btn_shift_SelectedStudent_PromSection.toString());

	}

	public void saveSectionPromotion() throws Exception {

		clickOnButton(btn_Save_PromotSec);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on Save button to save the section promotion request and object is:-"
				+ btn_Save_PromotSec.toString());

	}

	public void clearSectionPromotionData() throws Exception {

		clickOnButton(btn_Clear_PromotSec);
		log("Clear filled section promotion data and object is:-" + btn_Clear_PromotSec.toString());

	}

	public void nevigateToYearLossSection() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		clickOnButton(tab_YearLossSection);
		log("Navigated to Year Loss Section and object is:-" + tab_YearLossSection.toString());

	}

	public void saveYearLossSection() throws Exception {

		clickOnButton(btn_Save_YrLoss);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on Save button to save the Year Loss request and object is:-" + btn_Save_YrLoss.toString());

	}

	public void clearYearLossSectionData() throws Exception {

		clickOnButton(btn_Clear_YrLoss);
		log("Clear filled Year Loss Section data and object is:-" + btn_Clear_YrLoss.toString());

	}

	public void fillYearLossSectionAllotmentForm(String academicYr, String class_Current, String section_Current,
			String academicYr_New, String new_Class, String section_YrLoss) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		selectElementFromDropDown(sel_AcademicYr_YrLoss, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_YrLoss.toString());

		selectElementFromDropDown(sel_Class_YrLoss, class_Current);
		log("selected Current Class for YrLoss: " + class_Current + " and object is:- " + sel_Class_YrLoss.toString());

		selectElementFromDropDown(sel_Section_YrLoss, section_Current);
		log("selected Current section: " + section_Current + " and object is:- " + sel_Section_YrLoss.toString());

		selectedDropdownItemValidation(sel_AcademicYr_Disable_YrLoss, academicYr_New);
		log("Disabled promoted academic year: " + academicYr_New + " and object is:- "
				+ sel_AcademicYr_Disable_YrLoss.toString());

		selectedDropdownItemValidation(sel_Class_Disable_YrLoss, new_Class);
		log("Disabled Year loss class: " + new_Class + " and object is:- " + sel_Class_Disable_YrLoss.toString());

		selectElementFromDropDown(sel_SectionToAllot_YrLoss, section_YrLoss);
		log("selected section to year loss: " + section_YrLoss + " and object is:- "
				+ sel_SectionToAllot_YrLoss.toString());

	}

	public void selectStudentFor_YearLossStudent(String admissionNumber) {
		int rows = tblRows_StudentList_YrLoss.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[7]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']//div/table)[8]/tbody/tr[" + i + "]/td[6]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		clickOnButton(btn_shift_SelectedStudent_YrLoss);
		log("Selected student for Year Loss section is moved for section promotion table and object is:-"
				+ btn_shift_SelectedStudent_YrLoss.toString());
	}

	public void searchStudentToValidateUpdatedYearLossStudentInGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search_YrLossStu_Updated, admissionNumber);
		log("Entered admission number " + admissionNumber + " to search student in the grid and object is:-"
				+ input_Search_YrLossStu_Updated.toString());

	}

	public void verifyUpdatedYearLossStudentInGrid(String admissionNumber) {
		int rows = tblRows_GridYrLossStu.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[5]"))
						.getText().trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		clickOnButton(tab_UpdateRollNumber);
		log("Navigated to Update roll number and object is:-" + tab_UpdateRollNumber.toString());
		Thread.sleep(1000);

	}

	public void saveUpdateRollNumber() throws Exception {

		clickOnButton(btn_Save_UpdatedRoll);
		log("Clicked on Save button to save the updated roll number request and object is:-"
				+ btn_Save_UpdatedRoll.toString());

	}

	public void clearUpdateRollNumberData() throws Exception {

		clickOnButton(btn_Clear_UpdatedRoll);
		log("Clear filled updated roll number data and object is:-" + btn_Clear_UpdatedRoll.toString());

	}

	public void fillUpdateRollNumberAllotmentForm(String academicYr, String class_rollNo, String section_rollNo)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DashBoard);
		Thread.sleep(2000);

		selectElementFromDropDown(sel_AcademicYr_UpdateRoll, academicYr);
		log("selected Academic Year: " + academicYr + " and object is:- " + sel_AcademicYr_UpdateRoll.toString());

		selectElementFromDropDown(sel_Class_UpdateRoll, class_rollNo);
		log("selected Class for roll number update: " + class_rollNo + " and object is:- "
				+ sel_Class_UpdateRoll.toString());

		selectElementFromDropDown(sel_Section_UpdateRoll, section_rollNo);
		log("selected section for roll number: " + section_rollNo + " and object is:- "
				+ sel_Section_UpdateRoll.toString());

	}

	public void updateRollNumberForTheStudent(String admissionNumber, String rollNumber) {
		int rows = tblRows_UpdateRollList.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='']/table)[1]/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		inputTextIntoInputField(input_Search_ToUpdateRoll, admissionNumber);
		log("Entered admission number " + admissionNumber + " to search student and object is:-"
				+ input_Search_ToUpdateRoll.toString());

	}

	public void searchStudentToValidateUpdatedRollNumberInGrid(String admissionNumber) throws Exception {

		inputTextIntoInputField(input_Search_ToUpdatedRollInGrid, admissionNumber);
		log("Entered admission number " + admissionNumber + " to search student in the grid and object is:-"
				+ input_Search_ToUpdatedRollInGrid.toString());

	}

	public void verifyUpdatedRollNumberForTheStudentInGrid(String admissionNumber, String rollNumber) {
		int rows = tblRows_UpdatedRollGrid.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String admissionNum = driver
						.findElement(By.xpath("(//div[@class='']/table)[2]/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Admission Number: " + admissionNum);
				// Thread.sleep(2000);

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

		clickOnButton(btnMin_MaxUpdateRoll);
		log("Update roll number page minimize and object is:-" + btnMin_MaxUpdateRoll.toString());

	}

	public void maximizeUpdateRollNumber() throws Exception {

		clickOnButton(btnMin_MaxUpdateRoll);
		log("Update roll number page maximized and object is:-" + btnMin_MaxUpdateRoll.toString());

	}

	public void minimizeUpdateRollNumberStudentList() throws Exception {

		clickOnButton(btnMin_MaxUpdateRollStuList);
		log("clicked on update roll number Student List minimize button and object is:-"
				+ btnMin_MaxUpdateRollStuList.toString());

	}

	public void maximizeUpdateRollNumberStudentList() throws Exception {

		clickOnButton(btnMin_MaxUpdateRollStuList);
		log("clicked on update roll number Student List maximize button and object is:-"
				+ btnMin_MaxUpdateRollStuList.toString());

	}

	public void minimizeUpdatedRollNumberInGrid() throws Exception {

		clickOnButton(btnMin_MaxUpdateRollStuListGrid);
		log("Student list grid minimize and object is:-" + btnMin_MaxUpdateRollStuListGrid.toString());

	}

	public void maximizeUpdatedRollNumberInGrid() throws Exception {

		clickOnButton(btnMin_MaxUpdateRollStuListGrid);
		log("Student list grid maximized and object is:-" + btnMin_MaxUpdateRollStuListGrid.toString());

	}

	public void sortByStudentNameInUpdateRollNumberGrid() throws Exception {

		clickOnButton(btn_sortByStudentNameRollGrid);
		log("Sorted the record with Student Name in the grid and object is:-"
				+ btn_sortByStudentNameRollGrid.toString());

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

	public void popWindowMessage_SubmitSuccessfully_Promotion() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Selected Record Promoted Successfully");
			log("Record Promoted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_YrLoss() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Selected Record Year Loss Updated Successfully");
			log("Year Loss Updated sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Delete() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Selected Record Deleted Successfully");
			log("Record Deleted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_RollUpdate() throws Exception {
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

}
