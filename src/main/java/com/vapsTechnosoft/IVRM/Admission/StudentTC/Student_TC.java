/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.StudentTC;

import java.awt.Robot;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
 * @author vaps
 *
 */
public class Student_TC extends TestBase {

	public static final Logger log = Logger.getLogger(Student_TC.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Student TC')]")
	WebElement btnAdmission_StudentTC;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Student
	// TC')]/following::li[1]")
	// WebElement btnStudentTC_Student_TC;

	@FindBy(xpath = "//a[@href='#/app/studenttc/71']")
	WebElement btnStudentTC_Student_TC;

	@FindBy(xpath = "//section[@class='content-header']/ol/li")
	WebElement txtStudentTC_StudentTCMsgDispaly;

	@FindBy(xpath = "//div[@class='well text-center']/input[1]")
	WebElement rdbtn_All;

	@FindBy(xpath = "//div[@class='well text-center']/input[2]")
	WebElement rdbtn_Individual;

	// @FindBy(xpath = "(//label[contains(text(),'Student Name
	// :')]//following-sibling::div//div/span)[1]")
	// WebElement sel_StudentName;

	@FindBy(xpath = "//span[contains(text(),'Active')]/preceding-sibling::input[1]")
	WebElement rdbtn_StuSelection_Active;

	@FindBy(xpath = "//span[contains(text(),'Left')]/preceding-sibling::input[1]")
	WebElement rdbtn_StuSelection_Left;

	@FindBy(xpath = "//span[contains(text(),'Deactive')]/preceding-sibling::input[1]")
	WebElement rdbtn_StuSelection_Deactive;

	@FindBy(xpath = "//span[contains(text(),'Temporary Students')]/preceding-sibling::input[1]")
	WebElement rdbtn_Temporary_Students;

	@FindBy(xpath = "//span[contains(text(),'Temporary TC')]/preceding-sibling::input")
	WebElement chk_Temporary_TC;

	@FindBy(xpath = "//span[contains(text(),'Name:Adm No.')]/preceding-sibling::input[1]")
	WebElement rdbtn_Name_Adm_No;

	@FindBy(xpath = "//span[contains(text(),'Adm. No:Name')]/preceding-sibling::input")
	WebElement rdbtn_Adm_No_Name;

	@FindBy(xpath = "(//span[contains(text(),'Student Details')])[1]")
	WebElement tab_Student_Details;

	@FindBy(xpath = "(//span[contains(text(),'TC Details')])[1]")
	WebElement tab_TC_Details;

	@FindBy(xpath = "(//span[contains(text(),'Student Personal Details')])[1]")
	WebElement tab_StuPersonal_Details;

	@FindBy(xpath = "(//span[contains(text(),'Other Details')])[1]")
	WebElement tab_Other_Details;

	@FindBy(xpath = "(//span[contains(text(),'Due Details')])[1]")
	WebElement tab_Due_Details;

	/**
	 * Student details locators
	 */

	@FindBy(xpath = "//label[contains(text(),'Date Of Admission:')]/following-sibling::div/label")
	WebElement sel_DateOfAdmission;

	@FindBy(xpath = "//label[contains(text(),'Date Of Promotion:')]/following::button[1]")
	WebElement btn_DateOfPromotion;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[20]")
	WebElement btn_Date;

	@FindBy(xpath = "//label[contains(text(),'Last Class Studied:')]/following-sibling::div/label")
	WebElement sel_LastClassStudied;

	@FindBy(xpath = "//label[contains(text(),'SC or ST:')]/following-sibling::div/label")
	WebElement sel_SC_ST;

	@FindBy(xpath = "//input[@id='usr' and @name='med_instr']")
	WebElement input_Medium_Of_Instruction;

	@FindBy(xpath = "//input[@id='usr' and @name='lan_stud']")
	WebElement input_Languages_Studied;

	@FindBy(xpath = "//input[@id='usr' and @name='elect']")
	WebElement input_Elective_Studied;

	@FindBy(xpath = "//input[@id='usr' and @name='scholar']")
	WebElement input_Scholarship;

	@FindBy(xpath = "//input[@id='usr' and @name='med_exa']")
	WebElement input_Medically_Examined;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[1]")
	WebElement btn_Cancel_StudentDetails;

	@FindBy(xpath = "(//span[contains(text(),'Clear All')]/parent::button)[1]")
	WebElement btn_ClearAll_StudentDetails;

	@FindBy(xpath = "(//span[contains(text(),'Next ')]/parent::button)[1]")
	WebElement btn_Next_StudentDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_Max_StudentTC;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_Max_StudentDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_Max_StudentDetailsForm;

	/**
	 * Tc Details locators
	 */

	@FindBy(xpath = "//label[contains(text(),'TC No.:')]/following-sibling::div/input")
	WebElement input_TC_Number;

	@FindBy(xpath = "//textarea[@id='comment' and @name='leav_reas']")
	WebElement input_LeavingReason;

	@FindBy(xpath = "//input[@id='usr' and @name='number_school_days']")
	WebElement input_NumberOfSchoolDays;

	@FindBy(xpath = "//input[@id='usr' and @name='attended_days']")
	WebElement input_NumberOfAttendedDays;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	WebElement btn_Cancel_TCDetails;

	@FindBy(xpath = "(//span[contains(text(),'Clear All')]/parent::button)[2]")
	WebElement btn_ClearAll_TCDetails;

	@FindBy(xpath = "(//span[contains(text(),'Next ')]/parent::button)[2]")
	WebElement btn_Next_TCDetails;

	@FindBy(xpath = "(//span[contains(text(),'Previous')]/parent::button)[1]")
	WebElement btn_Previous_TCDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_Max_TC_DetailsForm;
	//
	@FindBy(xpath = "//label[contains(text(),'TC Application Date:')]/following::button[1]")
	WebElement btn_DateOfTCApplication;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear_TcApplication;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[6]")
	WebElement btn_DateTcAppl;

	@FindBy(xpath = "//label[contains(text(),'TC Date:')]/following::button[1]")
	WebElement btn_TCDate;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear_TcDate;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[16]")
	WebElement btn_DateOfTc;

	@FindBy(xpath = "//label[contains(text(),'Last Date Of Attendance:')]/following::button[1]")
	WebElement btn_lastDateOFAttendance;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	WebElement btn_MonthYear_DateAttendance;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[14]")
	WebElement btn_DateOflastAttendance;

	/**
	 * Student personal details
	 */

	@FindBy(xpath = "//label[contains(text(),'Date Of Birth :')]/following-sibling::div/label")
	WebElement labelValue_DOB;

	@FindBy(xpath = "//label[contains(text(),'Date Of Birth in Words:')]/following-sibling::div/label")
	WebElement labelValue_DOB_InWords;

	@FindBy(xpath = "//label[contains(text(),'Student Bank IFSC Code:')]/following-sibling::div/label")
	WebElement labelValue_StuBankIFSC;

	@FindBy(xpath = "//label[contains(text(),'Birth Place:')]/following-sibling::div/label")
	WebElement labelValue_BirthPlace;

	@FindBy(xpath = "//label[contains(text(),'Birth Certificate Number:')]/following-sibling::div/label")
	WebElement labelValue_BirthCertNumber;

	@FindBy(xpath = "//label[contains(text(),'Caste Certificate Number:')]/following-sibling::div/label")
	WebElement labelValue_CasteCertNumber;

	@FindBy(xpath = "//label[contains(text(),'Age:')]/following-sibling::div/label")
	WebElement labelValue_Age;

	@FindBy(xpath = "//label[contains(text(),'Gender:')]/following-sibling::div/label")
	WebElement labelValue_Gender;

	@FindBy(xpath = "//label[contains(text(),'Mother Tongue:')]/following-sibling::div/label")
	WebElement labelValue_MotherTongue;

	@FindBy(xpath = "//label[contains(text(),'Nationality:')]/following-sibling::div/label")
	WebElement labelValue_Nationality;

	@FindBy(xpath = "//label[contains(text(),'Mobile No. :')]/following-sibling::div/label")
	WebElement labelValue_MobileNumber;

	@FindBy(xpath = "//label[contains(text(),'Email ID:')]/following-sibling::div/label")
	WebElement labelValue_EmailId;

	@FindBy(xpath = "//label[contains(text(),'Aadhar No. :')]/following-sibling::div/label")
	WebElement labelValue_AadharNumber;

	@FindBy(xpath = "//label[contains(text(),'Blood Group :')]/following-sibling::div/label")
	WebElement labelValue_BloodGroup;

	@FindBy(xpath = "//label[contains(text(),'Student Bank A/C No. :')]/following-sibling::div/label")
	WebElement labelValue_StuAccountNo;

	@FindBy(xpath = "//label[contains(text(),'BPL Card No. :')]/following-sibling::div/label")
	WebElement labelValue_BPLCardNo;

	@FindBy(xpath = "(//span[contains(text(),'Clear All')]/parent::button)[3]")
	WebElement btn_ClearAll_StuPersonalDetails;

	@FindBy(xpath = "(//span[contains(text(),'Next ')]/parent::button)[3]")
	WebElement btn_Next_StuPersonalDetails;

	@FindBy(xpath = "(//span[contains(text(),'Previous')]/parent::button)[2]")
	WebElement btn_Previous_StuPersonalDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	WebElement btnMin_Max_StuPersonal_DetailsForm;

	/**
	 * Student tc Others Details locators
	 */
	@FindBy(xpath = "//label[contains(text(),'Whether Students Paid all fees? :')]/following-sibling::div/input")
	WebElement labelValue_StuPaidFees;

	@FindBy(xpath = "//label[contains(text(),'Fees Concession (if any specifiy nature, period):')]/following-sibling::div/input")
	WebElement input_FeesConcession;

	@FindBy(xpath = "//label[contains(text(),'Last Exam Details :')]/following-sibling::div/input")
	WebElement input_LastExam;

	@FindBy(xpath = "//label[contains(text(),'Results:')]/following-sibling::div/input")
	WebElement input_Results;

	@FindBy(xpath = "//label[contains(text(),'Whether failed(give details):')]/following-sibling::div/input")
	WebElement input_Failed;

	@FindBy(xpath = "//label[contains(text(),'Whether qualified for promotion? :')]/following-sibling::div/input")
	WebElement input_QualifiedForPromotion;

	@FindBy(xpath = "(//label[contains(text(),'Qualified for which class :')]/following-sibling::div/select)[1]")
	WebElement sel_QualifiedForClass;

	@FindBy(xpath = "//label[contains(text(),'Whether NCC cadet/boy/scout/girl?:')]/following-sibling::div/input")
	WebElement input_NCC_Cadet;

	@FindBy(xpath = "//label[contains(text(),'Extra curricular activities:')]/following-sibling::div/textarea")
	WebElement input_ECA;

	@FindBy(xpath = "//label[contains(text(),'Conduct:')]/following-sibling::div/input")
	WebElement input_Conduct;

	@FindBy(xpath = "//label[contains(text(),'Remarks:')]/following-sibling::div/textarea")
	WebElement input_Remarks;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[3]")
	WebElement btn_Cancel_TC_OtherDetails;

	@FindBy(xpath = "(//span[contains(text(),'Clear All')]/parent::button)[4]")
	WebElement btn_ClearAll_T_OtherDetails;

	@FindBy(xpath = "(//span[contains(text(),'Next ')]/parent::button)[4]")
	WebElement btn_Next_TC_OtherDetails;

	@FindBy(xpath = "(//span[contains(text(),'Previous')]/parent::button)[3]")
	WebElement btn_Previous_TC_OtherDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[6]")
	WebElement btnMin_Max_OtherDetailsForm;

	/**
	 * TC Due details
	 */

	@FindBy(xpath = "//label[contains(text(),'Fee Due :')]/following-sibling::div/input")
	WebElement labelValue_FeeDue;

	@FindBy(xpath = "//label[contains(text(),'Library Due Transactions:')]/following-sibling::div/input")
	WebElement labelValue_Library_DueTransactions;

	@FindBy(xpath = "//label[contains(text(),'Store/Canteen Transactions Due :')]/following-sibling::div/input")
	WebElement labelValue_Canteen_DueTransactions;

	@FindBy(xpath = "//label[contains(text(),'PDA Due:')]/following-sibling::div/input")
	WebElement labelValue_PDADue;

	@FindBy(xpath = "(//span[contains(text(),'Clear All')]/parent::button)[5]")
	WebElement btn_ClearAll_T_DueDetails;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btn_Save_TC_DueDetails;

	@FindBy(xpath = "(//span[contains(text(),'Previous')]/parent::button)[4]")
	WebElement btn_Previous_TC_DueDetails;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[7]")
	WebElement btnMin_Max_Due_DetailsForm;

	/**
	 * Student TC Individual details locators
	 */
	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class :')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Section :')]/following-sibling::div/select")
	WebElement sel_Section;

	@FindBy(xpath = "//label[contains(text(),'Student Name :')]/following-sibling::div/div/div[1]")
	WebElement input_StudentName;

	@FindBy(xpath = "//label[contains(text(),'Student Name :')]/following-sibling::div/div/input[1]")
	WebElement input_StudentNameText;

	//
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnPopUpOKSuccess;

	@FindBy(xpath = "//button[contains(text(),'Yes Submit it')]")
	WebElement btnPopUpYesSubmit;

	@FindBy(xpath = "//button[contains(text(),'Cancel..!')]")
	WebElement btnPopUpCancel;

	public Student_TC(WebDriver driver) {
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

	/**
	 * Navigate to Student TC
	 * 
	 * @throws Exception
	 */
	public void navigateToStudentTC_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_StudentTC);
		log("Clicked on Student Tc Button and object is:-" + btnAdmission_StudentTC.toString());

		clickOnButton(btnStudentTC_Student_TC);
		log("Clicked on Student Tc form link and object is:-" + btnStudentTC_Student_TC.toString());

	}

	/**
	 * Validation of Student TC screen message
	 * 
	 * @return
	 */
	public boolean verifyStudentTC_BGHSPage() {
		try {
			System.out.println(txtStudentTC_StudentTCMsgDispaly.getText());
			txtStudentTC_StudentTCMsgDispaly.isDisplayed();
			log("Section Allotment page is dispalyed and object is:-" + txtStudentTC_StudentTCMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fillStudentTcForm_Individual(String academicYr, String class_TC, String section, String stuName)
			throws Exception {
		isDisplayed(rdbtn_Individual);
		if (!rdbtn_Individual.isSelected()) {
			rdbtn_Individual.click();
			log("Indvidual radio button is selected and object is:-" + rdbtn_Individual.toString());
			Thread.sleep(1000);
		} else {
			log("Individual radio button is already selected and object is:-" + rdbtn_Individual.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdbtn_StuSelection_Active);
		if (!rdbtn_StuSelection_Active.isSelected()) {
			rdbtn_StuSelection_Active.click();
			log("Student selection active radio button is selected and object is:-"
					+ rdbtn_StuSelection_Active.toString());
			Thread.sleep(1000);
		} else {
			log("Student selection active radio button is already selected and object is:-"
					+ rdbtn_StuSelection_Active.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Temporary_TC);
		if (!chk_Temporary_TC.isSelected()) {
			chk_Temporary_TC.click();
			log("Student selection temporary tc check box is selected and object is:-" + chk_Temporary_TC.toString());
			Thread.sleep(1000);
		} else {
			log("Student selection temporary tc check box is already selected and object is:-"
					+ chk_Temporary_TC.toString());
			Thread.sleep(500);
		}
		isDisplayed(rdbtn_Name_Adm_No);
		if (!rdbtn_Name_Adm_No.isSelected()) {
			rdbtn_Name_Adm_No.click();
			log("Student selection Name And Admission Number radio button is selected and object is:-"
					+ rdbtn_Name_Adm_No.toString());
			Thread.sleep(1000);
		} else {
			log("Student selection Name And Admission Number radio button is already selected and object is:-"
					+ rdbtn_Name_Adm_No.toString());
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, class_TC);
		log("selected class: " + class_TC + " and object is:- " + sel_Class.toString());

		selectElementFromDropDown(sel_Section, section);
		log("selected class: " + section + " and object is:- " + sel_Section.toString());
		try {
			if (input_StudentName.isDisplayed()) {
				copyToClipbord(stuName);
				input_StudentName.click();
				Thread.sleep(500);
				input_StudentNameText.sendKeys(Keys.chord(Keys.CONTROL, "v"), "");
				Thread.sleep(2000);
				input_StudentNameText.sendKeys(Keys.TAB);
				log("Entered Student name: " + stuName + " and object is:-" + stuName.toString());
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log("Student name element not present.");
			Thread.sleep(500);
		}
	}

	public void fill_StudentDetails_ForStudentTc(String dateOfAdm, String lastClassStudied, String caste,
			String InstrMedium, String languageStudied, String electiveStudied, String scholarship, String medicalExam)
			throws Exception {
		try {
			if (sel_DateOfAdmission.isDisplayed()) {
				String DOAdm = sel_DateOfAdmission.getText().trim();
				Assert.assertEquals(DOAdm, dateOfAdm);
				log("Date of admission from admission form is same in student tc and object is:-"
						+ sel_DateOfAdmission.toString());
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Date of admission not matched or element not present.");
			Thread.sleep(500);
		}
		try {
			if (btn_DateOfPromotion.isDisplayed()) {
				btn_DateOfPromotion.click();
				Thread.sleep(500);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
				Thread.sleep(500);
				btn_Date.click();
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (sel_LastClassStudied.isDisplayed()) {
				String lastClass = sel_LastClassStudied.getText().trim();
				Assert.assertEquals(lastClass, lastClassStudied);
				log("Last Class Studied from admission form is same in student tc and object is:-"
						+ sel_LastClassStudied.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Last Class Studied not matched or element not present.");
			Thread.sleep(500);
		}
		// Label name not proper in the application
		try {
			if (sel_SC_ST.isDisplayed()) {
				String casteTC = sel_SC_ST.getText().trim();
				Assert.assertEquals(casteTC, caste);
				log("Caste from admission form is same in student tc and object is:-" + sel_SC_ST.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Caste not matched or element not present.");
			Thread.sleep(500);
		}

		inputTextIntoInputField(input_Medium_Of_Instruction, InstrMedium);
		log("Entered medium of instruction: " + InstrMedium + " and object is:-"
				+ input_Medium_Of_Instruction.toString());

		inputTextIntoInputField(input_Languages_Studied, languageStudied);
		log("Entered language studied: " + languageStudied + " and object is:-" + input_Languages_Studied.toString());

		inputTextIntoInputField(input_Elective_Studied, electiveStudied);
		log("Entered Elective studied: " + electiveStudied + " and object is:-" + input_Elective_Studied.toString());

		inputTextIntoInputField(input_Scholarship, scholarship);
		log("Entered scholarship: " + scholarship + " and object is:-" + input_Scholarship.toString());

		inputTextIntoInputField(input_Medically_Examined, medicalExam);
		log("Entered medically examined: " + medicalExam + " and object is:-" + input_Medically_Examined.toString());

	}

	public void clickOn_StudentDetails_NextButton() throws Exception {

		clickOnButton(btn_Next_StudentDetails);
		log("Clicked on student details next button and page moved to tc details and object is:-"
				+ btn_Next_StudentDetails.toString());
		Thread.sleep(1000);

	}

	public void fillStudent_TCDetailsForm(String tcNumber, String reasonForLeaving, String schoolDays,
			String attendanceDays) throws Exception {

		inputTextIntoInputField(input_TC_Number, tcNumber);
		log("Entered tc number:" + tcNumber + " and object is:-" + input_TC_Number.toString());
		try {
			if (btn_DateOfTCApplication.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_DateOfTCApplication);
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						btn_MonthYear_TcApplication);
				Thread.sleep(500);
				btn_DateTcAppl.click();
				log("Date of TC application is entered and object is:-" + btn_DateOfTCApplication.toString());
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Date of TC application is not entered (OR) Date of application button element not present.");
			Thread.sleep(500);
		}

		inputTextIntoInputField(input_LeavingReason, reasonForLeaving);
		log("Entered Leaving reason:" + reasonForLeaving + " and object is:-" + input_LeavingReason.toString());

		// Enter TC Date
		clickOnButton(btn_TCDate);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_TcDate);
		Thread.sleep(500);
		btn_DateOfTc.click();
		log("TC date entered and object is:-" + btn_TCDate.toString());

		clickOnButton(btn_lastDateOFAttendance);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear_DateAttendance);
		Thread.sleep(500);
		btn_DateOflastAttendance.click();
		log("Last Date of attendance entered and object is:-" + btn_lastDateOFAttendance.toString());

		inputTextIntoInputField(input_NumberOfSchoolDays, schoolDays);
		log("Entered number of school days:" + schoolDays + " and object is:-" + input_NumberOfSchoolDays.toString());

		inputTextIntoInputField(input_NumberOfAttendedDays, attendanceDays);
		log("Entered number of attendance days:" + attendanceDays + " and object is:-"
				+ input_NumberOfAttendedDays.toString());

	}

	public void clickOnTC_Details_NextButton() throws Exception {

		clickOnButton(btn_Next_TCDetails);
		log("Clicked on TC details next button and page moved to Student personal details and object is:-"
				+ btn_Next_TCDetails.toString());
		Thread.sleep(1000);

	}

	public void validateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart(String dateOfBirth, String dobInWords,
			String stuIFSCCode, String birthPlace, String birthCertNumber, String casteCertNumber, String age,
			String gender) throws Exception {
		try {
			if (labelValue_DOB.isDisplayed()) {
				String dob = labelValue_DOB.getText().trim();
				Assert.assertEquals(dob, dateOfBirth);
				log("Date of birth from admission form is match with student tc personal details and object is:-"
						+ labelValue_DOB.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Date of birth from admission form is not matched (OR) element not present.");
			Thread.sleep(500);

		}
		try {
			if (labelValue_DOB_InWords.isDisplayed()) {
				String dob_words = labelValue_DOB_InWords.getText().trim();
				Assert.assertEquals(dob_words, dobInWords);
				log("Date of birth in words from admission form is match with student tc personal details and object is:-"
						+ labelValue_DOB_InWords.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Date of birth in words from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_StuBankIFSC.isDisplayed()) {
				String bank_ifsc = labelValue_StuBankIFSC.getText().trim();
				Assert.assertEquals(bank_ifsc, stuIFSCCode);
				log("Student IFSC number from admission form is match with student tc personal details and object is:-"
						+ labelValue_StuBankIFSC.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student IFSC number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_BirthPlace.isDisplayed()) {
				String birth_place = labelValue_BirthPlace.getText().trim();
				Assert.assertEquals(birth_place, birthPlace);
				log("Student Birth Palce from admission form is match with student tc personal details and object is:-"
						+ labelValue_BirthPlace.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student Birth Palce from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_BirthCertNumber.isDisplayed()) {
				String birth_certificate = labelValue_BirthCertNumber.getText().trim();
				Assert.assertEquals(birth_certificate, birthCertNumber);
				log("Student Birth certificate number from admission form is match with student tc personal details and object is:-"
						+ labelValue_BirthCertNumber.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student Birth certificate number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_CasteCertNumber.isDisplayed()) {
				String caste_certificate = labelValue_CasteCertNumber.getText().trim();
				Assert.assertEquals(caste_certificate, casteCertNumber);
				log("Caste number from admission form is match with student tc personal details and object is:-"
						+ labelValue_CasteCertNumber.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Caste certificate number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_Age.isDisplayed()) {
				String student_Age = labelValue_Age.getText().trim();
				Assert.assertEquals(student_Age, age);
				log("Student age from admission form is match with student tc personal details and object is:-"
						+ labelValue_Age.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student age from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_Gender.isDisplayed()) {
				String student_gender = labelValue_Gender.getText().trim();
				Assert.assertEquals(student_gender, gender);
				log("Student gender from admission form is match with student tc personal details and object is:-"
						+ labelValue_Gender.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student gender from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void validateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart(String motherTongue,
			String nationality, String mobileNo, String emailId, String aadharNumber, String bloodGroup,
			String studentAccountNo, String bplCardNo) throws Exception {
		try {
			if (labelValue_MotherTongue.isDisplayed()) {
				String mother_tongue = labelValue_MotherTongue.getText().trim();
				Assert.assertEquals(mother_tongue, motherTongue);
				log("Mother tongue from admission form is match with student tc personal details and object is:-"
						+ labelValue_MotherTongue.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Mother tongue from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_Nationality.isDisplayed()) {
				String student_nationality = labelValue_Nationality.getText().trim();
				Assert.assertEquals(student_nationality, nationality);
				log("Student nationality in words from admission form is match with student tc personal details and object is:-"
						+ labelValue_Nationality.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student nationality in words from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_MobileNumber.isDisplayed()) {
				String mobile_number = labelValue_MobileNumber.getText().trim();
				Assert.assertEquals(mobile_number, mobileNo);
				log("Student mobile number from admission form is match with student tc personal details and object is:-"
						+ labelValue_MobileNumber.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student mobile number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_EmailId.isDisplayed()) {
				String email_id = labelValue_EmailId.getText().trim();
				Assert.assertEquals(email_id, emailId);
				log("Student Email Id from admission form is match with student tc personal details and object is:-"
						+ labelValue_EmailId.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student Email Id from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_AadharNumber.isDisplayed()) {
				String aadhar_number = labelValue_AadharNumber.getText().trim();
				Assert.assertEquals(aadhar_number, aadharNumber);
				log("Student aadhar number from admission form is match with student tc personal details and object is:-"
						+ labelValue_AadharNumber.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student aadhar number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_BloodGroup.isDisplayed()) {
				String blood_group = labelValue_BloodGroup.getText().trim();
				Assert.assertEquals(blood_group, bloodGroup);
				log("Student blood group from admission form is match with student tc personal details and object is:-"
						+ labelValue_BloodGroup.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student blood group from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_StuAccountNo.isDisplayed()) {
				String bank_account = labelValue_StuAccountNo.getText().trim();
				Assert.assertEquals(bank_account, studentAccountNo);
				log("Student bank account number from admission form is match with student tc personal details and object is:-"
						+ labelValue_StuAccountNo.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student bank account number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
		try {
			if (labelValue_BPLCardNo.isDisplayed()) {
				String bank_account = labelValue_BPLCardNo.getText().trim();
				Assert.assertEquals(bank_account, studentAccountNo);
				log("Student BPL card number from admission form is match with student tc personal details and object is:-"
						+ labelValue_BPLCardNo.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log("Student BPL card number from admission form is not matched (OR) element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOn_StudentPersonal_Details_NextButton() throws Exception {
		
			clickOnButton(btn_Next_StuPersonalDetails);
			log("Clicked on student personal details next button and page moved to other details and object is:-"
					+ btn_Next_StuPersonalDetails.toString());
			Thread.sleep(1000);
		
	}

	public void fill_OtherDetails_FroStudentTCForm(String feesPaid, String feeConcession, String lastExam,
			String results, String wheatherFailed, String qualifiedForPromotion, String qualifiedForWhichClass,
			String nccCadet, String extraCurricular, String conduct, String remarks) throws Exception {
		// if (labelValue_StuPaidFees.isDisplayed()) {
		// String fees_paid = labelValue_StuPaidFees.getText().trim();
		// Assert.assertEquals(fees_paid, feesPaid);
		// log("Student fees paid or not is match with student tc other details
		// and object is:-"
		// + labelValue_StuPaidFees.toString());
		// Thread.sleep(1000);
		// } else {
		// log("Student fees paid element not present.");
		// Thread.sleep(500);
		// }
	
			inputTextIntoInputField(input_FeesConcession, feeConcession);
			log("Entered Fee Concession nature and period:" + feeConcession + " and object is:-"
					+ input_FeesConcession.toString());

			inputTextIntoInputField(input_LastExam, lastExam);
			log("Entered last exam details:" + lastExam + " and object is:-" + input_LastExam.toString());
	
			inputTextIntoInputField(input_Results, results);
			log("Entered last exam results:" + results + " and object is:-" + input_Results.toString());
	
			inputTextIntoInputField(input_Failed, wheatherFailed);
			log("Entered whether failed:" + wheatherFailed + " and object is:-" + input_Failed.toString());

			inputTextIntoInputField(input_QualifiedForPromotion, qualifiedForPromotion);
			log("Entered whether Qualified For Promotion:" + qualifiedForPromotion + " and object is:-"
					+ input_QualifiedForPromotion.toString());
	
			selectElementFromDropDown(sel_QualifiedForClass, qualifiedForWhichClass);
			log("Qualified for which class: " + qualifiedForWhichClass + " and object is:- "
					+ sel_QualifiedForClass.toString());
		
			inputTextIntoInputField(input_NCC_Cadet, nccCadet);
			log("Entered whether NCC Cadet:" + nccCadet + " and object is:-" + input_NCC_Cadet.toString());
	
			inputTextIntoInputField(input_ECA, extraCurricular);
			log("Entered Extra curricular activities:" + extraCurricular + " and object is:-" + input_ECA.toString());
		
			inputTextIntoInputField(input_Conduct, conduct);
			log("Entered Conduct:" + conduct + " and object is:-" + input_Conduct.toString());
	
			inputTextIntoInputField(input_Remarks, remarks);
			log("Entered Remarks:" + remarks + " and object is:-" + input_Remarks.toString());
			
	}

	public void clickOn_Other_Details_NextButton() throws Exception {
	
			clickOnButton(btn_Next_TC_OtherDetails);
			log("Clicked on student Other details next button and page moved to due details and object is:-"
					+ btn_Next_TC_OtherDetails.toString());
			Thread.sleep(1000);
		
	}

	public void saveStudentTC() throws InterruptedException {
		
			clickOnButton(btn_Save_TC_DueDetails);
			log("Clicked on save button to save student tc and object is:-" + btn_Save_TC_DueDetails.toString());
			Thread.sleep(2000);
		
	}

	public void cancel_SavingOfStudentTC() throws Exception {
		
			clickOnButton(btnPopUpCancel);
			log("Clicked on cancel button not to save student tc and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(2000);
		
	}

	public void yesSubmitIt_SavingOfStudentTC() throws InterruptedException {
		
			clickOnButton(btnPopUpYesSubmit);
			log("Clicked on Yes Submit it button to save student tc and object is:-" + btnPopUpYesSubmit.toString());
			Thread.sleep(2000);
		
	}

	public void clickOnOkButton() throws Exception {
		
			clickOnButton(btnPopUpOKSuccess);
			log("Clicked on OK button and object is:-" + btnPopUpOKSuccess.toString());
			Thread.sleep(1000);
		
	}
}
