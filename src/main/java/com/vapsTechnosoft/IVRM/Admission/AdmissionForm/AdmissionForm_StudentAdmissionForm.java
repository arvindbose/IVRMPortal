/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.AdmissionForm;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class AdmissionForm_StudentAdmissionForm extends TestBase {

	public static final Logger log = Logger.getLogger(AdmissionForm_StudentAdmissionForm.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Admission Form')][1]")
	WebElement btn_AdmissionForm;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Admission
	// Form')][1]/following::ul[1]")
	// WebElement btn_StudentAdmissionForm;

	@FindBy(xpath = "//a[@href='#/app/admissionform/65']")
	WebElement btn_StudentAdmissionForm;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmissionForm_StuAdmFormMsgDispaly;

	@FindBy(xpath = "(//span[contains(text(),'Save And Proceed')])[1]/parent::button")
	WebElement btn_Next_Student;

	@FindBy(xpath = "(//span[contains(text(),'Clear')])[1]/parent::button")
	WebElement btn_Clear_Student;

	@FindBy(xpath = "(//span[contains(text(),'ClearAll')])[1]/parent::button")
	WebElement btn_ClearAll_Student;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxStudentAdmissionForm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentDetails;

	@FindBy(xpath = "(//div[@class='box-body']//md-tabs-canvas/md-pagination-wrapper/md-tab-item)[1]")
	WebElement btn_Student_Tab;

	@FindBy(xpath = "(//div[@class='box-body']//md-tabs-canvas/md-pagination-wrapper/md-tab-item)[2]")
	WebElement btn_Address_Tab;

	@FindBy(xpath = "(//div[@class='box-body']//md-tabs-canvas/md-pagination-wrapper/md-tab-item)[3]")
	WebElement btn_Parents_Tab;

	@FindBy(xpath = "(//div[@class='box-body']//md-tabs-canvas/md-pagination-wrapper/md-tab-item)[4]")
	WebElement btn_Others_Tab;

	@FindBy(xpath = "(//div[@class='box-body']//md-tabs-canvas/md-pagination-wrapper/md-tab-item)[5]")
	WebElement btn_Doc_Upload_Tab;

	@FindBy(xpath = "//div[@class='box-tools pull-right']/label/input")
	WebElement chk_ReAdmit;

	@FindBy(xpath = "//input[@name='stufile']/parent::label")
	WebElement btn_BrowseImg;

	@FindBy(xpath = "//label[text()='Student Name:']/following-sibling::div/input")
	WebElement input_FirstName;

	@FindBy(xpath = "//input[@id='usr' and @name='middlenam']")
	WebElement input_MiddleName;

	@FindBy(xpath = "//input[@id='usr' and @name='lname']")
	WebElement input_LastName;

	@FindBy(xpath = "//label[contains(text(),'RegNo:')]/following-sibling::div/input")
	WebElement input_RegNumber;

	@FindBy(xpath = "//label[contains(text(),'Admission No:')]/following-sibling::div/input")
	WebElement input_AdmNumber;

	@FindBy(xpath = "//select[@id='sel1' and @name='stuayear']")
	WebElement sel_AcademicYr;

	@FindBy(xpath = "//select[@name='stuclass']")
	WebElement sel_Class;

	@FindBy(xpath = "(//div[@class='md-datepicker-input-container'])[1]")
	WebElement input_DateOfAdm;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement input_DateOfBirth;

	@FindBy(xpath = "//label[contains(text(),'DOB in Words:')]/following-sibling::div/input")
	WebElement input_DateOfBirth_InWord;

	@FindBy(xpath = "//select[@id='sel1' and @name='stucstcat']")
	WebElement sel_CasteCategory;

	@FindBy(xpath = "(//label[text()='Caste:']/following-sibling::div//span)[1]")
	WebElement btn_Caste;

	@FindBy(xpath = "//input[@aria-label='Select box']")
	WebElement input_Caste;

	@FindBy(xpath = "//input[@id='sub' and @name='subcaste']")
	WebElement input_SubCaste;

	@FindBy(xpath = "//input[@id='usr' and @name='stubifsc']")
	WebElement input_Bank_IFSCCode;

	@FindBy(xpath = "//input[@id='usr' and @name='stubplace']")
	WebElement input_Student_BirthPlace;

	@FindBy(xpath = "//label[contains(text(),'Birth Certificate No.:')]/following-sibling::div/input")
	WebElement input_BirthCertNumber;

	@FindBy(xpath = "//label[contains(text(),'Caste Certificate No.:')]/following-sibling::div/input")
	WebElement input_Caste_CertNumber;

	@FindBy(xpath = "(//label[contains(text(),'Age:')]/following-sibling::div/input)[1]")
	WebElement input_Age;

	@FindBy(xpath = "//label[contains(text(),'Gender:')]/following-sibling::div/select")
	WebElement sel_Gender;

	@FindBy(xpath = "//label[contains(text(),'Mother Tongue:')]/following-sibling::div/input")
	WebElement input_MotherTongue;

	@FindBy(xpath = "(//label[contains(text(),'Religion:')]/following-sibling::div/select)[1]")
	WebElement sel_Religion;

	@FindBy(xpath = "//select[@id='sel1' and @name='stunat']")
	WebElement sel_Nationality;

	@FindBy(xpath = "(//label[contains(text(),'Mobile Number:')]/following-sibling::div/input)[1]")
	WebElement input_MobileNumber;

	@FindBy(xpath = "(//label[contains(text(),'Email-ID:')]/following-sibling::div/input)[1]")
	WebElement input_EmailId;

	@FindBy(xpath = "(//label[contains(text(),'Aadhaar No.:')]/following-sibling::div/input)[1]")
	WebElement input_AadharNumber;

	@FindBy(xpath = "(//label[contains(text(),'Blood Group:')]/following-sibling::div/select)[1]")
	WebElement sel_BloodGroup;

	@FindBy(xpath = "(//label[contains(text(),'Student Category:')]/following-sibling::div/select)[1]")
	WebElement sel_StuCategory;

	@FindBy(xpath = "(//label[contains(text(),'Student Bank Account No.:')]/following-sibling::div/input)[1]")
	WebElement input_BankACNumber;

	@FindBy(xpath = "//div[@class='form-group']/label/input")
	WebElement chk_BPLCardNo;

	@FindBy(xpath = "//input[@id='usr' and @name='bplcard']")
	WebElement input_BPLCardNo;

	@FindBy(xpath = "//label[contains(text(),'Fee Concession Type:')]/following-sibling::div/select")
	WebElement sel_FeeConcessionType;

	@FindBy(xpath = "//label[contains(text(),'Student TPIN:')]/following-sibling::div/input")
	WebElement input_Student_TPIN;

	@FindBy(xpath = "//select[@id='sel1223']")
	WebElement sel_AcademicYr_InGrid;

	@FindBy(xpath = "//div[@class='input-group']/select")
	WebElement sel_By_InGrid;

	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/div/table/thead/tr/th[2]")
	WebElement btnSortByFirstName;

	@FindBy(xpath = "//div[@class='box-body']/div/table/tbody/tr/td[2]")
	List<WebElement> list_FirstNameAdmForm;
	
	/**
	 * Locator for Address page
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//label[contains(text(),'Permanent Address:')]/following-sibling::div/input)[1]")
	WebElement input_Address;

	@FindBy(xpath = "(//label[contains(text(),'Permanent Address:')]/following::div/input)[2]")
	WebElement input_Area;

	@FindBy(xpath = "(//label[contains(text(),'Country:')]/following-sibling::div/select)[1]")
	WebElement sel_Country;

	@FindBy(xpath = "(//label[contains(text(),'State:')]/following-sibling::div/select)[1]")
	WebElement sel_State;

	@FindBy(xpath = "(//label[contains(text(),'City:')]/following-sibling::div/input)[1]")
	WebElement input_City;

	@FindBy(xpath = "(//label[contains(text(),'Pincode')]/following-sibling::div/input)[1]")
	WebElement input_PinCode;

	@FindBy(xpath = "(//span[@class='lbl padding-8']/parent::label/input)[3]")
	WebElement chk_SameAsPermAddress;

	@FindBy(xpath = "(//div[@class='text-center'])[3]/button[3]")
	WebElement btn_Clear_Address;

	@FindBy(xpath = "(//span[contains(text(),'Save And Proceed')])[2]/parent::button")
	WebElement btn_Next_Address;

	@FindBy(xpath = "(//div[@class='text-center'])[3]/button[1]")
	WebElement btn_Previous_Address;

	@FindBy(xpath = "(//div[@class='text-center'])[6]/button")
	WebElement btn_ClearAll_Address;

	/**
	 * Father details locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//div[@class='md-subheader-content']/label/input)[1]")
	WebElement chk_Father_Alive;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[29]")
	WebElement input_FatherName;

	@FindBy(xpath = "(//label[contains(text(),'Sur Name:')]/following-sibling::div/input)[1]")
	WebElement input_FatherSurName;

	@FindBy(xpath = "(//label[contains(text(),'Aadhaar No.:')]/following-sibling::div/input)[2]")
	WebElement input_Father_Aadhar;

	@FindBy(xpath = "(//label[contains(text(),'Qualification:')]/following-sibling::div/input)[1]")
	WebElement input_Father_Qualification;

	@FindBy(xpath = "(//label[contains(text(),'Office Address:')]/following-sibling::div/textarea)[1]")
	WebElement input_Father_OfficeAddr;

	@FindBy(xpath = "(//label[contains(text(),'Occupation:')]/following-sibling::div/input)[1]")
	WebElement input_Father_Occupation;

	@FindBy(xpath = "(//label[contains(text(),'Designation:')]/following-sibling::div/input)[1]")
	WebElement input_Father_Designation;

	@FindBy(xpath = "(//label[contains(text(),'Bank Account No.:')]/following-sibling::div/input)[2]")
	WebElement input_Father_BankAc;

	@FindBy(xpath = "(//label[contains(text(),'Bank IFSC Code:')]/following-sibling::div/input)[2]")
	WebElement input_Father_IFSCCode;

	@FindBy(xpath = "(//label[contains(text(),'Caste Certificate No.:')]/following-sibling::div/input)[2]")
	WebElement input_Father_CasteCert;

	@FindBy(xpath = "(//label[contains(text(),'Nationality:')]/following-sibling::div/select)[2]")
	WebElement sel_Father_Nationality;
	// new field added
	@FindBy(xpath = "(//label[contains(text(),'Father Religion:')]/following-sibling::div/select)[1]")
	WebElement sel_Father_Religion;

	@FindBy(xpath = "(//label[contains(text(),'Father Caste:')]/following-sibling::div/select)[1]")
	WebElement sel_Father_Caste;

	@FindBy(xpath = "(//label[contains(text(),'Father Sub Caste:')]/following-sibling::div/input)[1]")
	WebElement input_Father_SubCaste;
	//

	@FindBy(xpath = "(//label[contains(text(),'Income:')]/following-sibling::div/input)[1]")
	WebElement input_Father_MonthlyIncome;

	@FindBy(xpath = "(//label[contains(text(),'Income:')]/following-sibling::div/input)[2]")
	WebElement input_Father_AnnualIncome;

	@FindBy(xpath = "(//label[contains(text(),'Mobile Number:')]/following-sibling::div/input)[2]")
	WebElement input_Father_MobileNum;

	@FindBy(xpath = "(//label[contains(text(),'Email-ID:')]/following-sibling::div/input)[2]")
	WebElement input_Father_EmailId;

	/**
	 * Mother details locators
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//div[@class='md-subheader-content']/label/input)[2]")
	WebElement chk_Mother_Alive;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[43]")
	WebElement input_MotherName;

	@FindBy(xpath = "(//label[contains(text(),'Sur Name:')]/following-sibling::div/input)[2]")
	WebElement input_MotherSurName;

	@FindBy(xpath = "(//label[contains(text(),'Aadhaar No.:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_Aadhar;

	@FindBy(xpath = "(//label[contains(text(),'Qualification:')]/following-sibling::div/input)[2]")
	WebElement input_Mother_Qualification;

	@FindBy(xpath = "(//label[contains(text(),'Office Address:')]/following-sibling::div/textarea)[2]")
	WebElement input_Mother_OfficeAddr;

	@FindBy(xpath = "(//label[contains(text(),'Occupation:')]/following-sibling::div/input)[2]")
	WebElement input_Mother_Occupation;

	@FindBy(xpath = "(//label[contains(text(),'Designation:')]/following-sibling::div/input)[2]")
	WebElement input_Mother_Designation;

	@FindBy(xpath = "(//label[contains(text(),'Bank Account No.:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_BankAc;

	@FindBy(xpath = "(//label[contains(text(),'Bank IFSC Code:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_IFSCCode;

	@FindBy(xpath = "(//label[contains(text(),'Caste Certificate No.:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_CasteCert;

	@FindBy(xpath = "(//label[contains(text(),'Nationality:')]/following-sibling::div/select)[3]")
	WebElement sel_Mother_Nationality;
	// new field added
	@FindBy(xpath = "(//label[contains(text(),'Mother Religion:')]/following-sibling::div/select)[1]")
	WebElement sel_Mother_Religion;

	@FindBy(xpath = "(//label[contains(text(),'Mother Caste:')]/following-sibling::div/select)[1]")
	WebElement sel_Mother_Caste;

	@FindBy(xpath = "(//label[contains(text(),'Mother Sub Caste:')]/following-sibling::div/input)[1]")
	WebElement input_Mother_SubCaste;
	//

	@FindBy(xpath = "(//label[contains(text(),'Income:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_MonthlyIncome;

	@FindBy(xpath = "(//label[contains(text(),'Income:')]/following-sibling::div/input)[4]")
	WebElement input_Mother_AnnualIncome;

	@FindBy(xpath = "(//label[contains(text(),'Mobile Number:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_MobileNum;

	@FindBy(xpath = "(//label[contains(text(),'Email-ID:')]/following-sibling::div/input)[3]")
	WebElement input_Mother_EmailId;

	@FindBy(xpath = "(//div[@class='text-center'])[4]/button[3]")
	WebElement btn_Clear_Parents;

	@FindBy(xpath = "(//span[contains(text(),'Save And Proceed')])[3]/parent::button")
	WebElement btn_Next_Parents;

	@FindBy(xpath = "(//div[@class='text-center'])[4]/button[1]")
	WebElement btn_Previous_Parents;

	@FindBy(xpath = "(//div[@class='text-center'])[6]/button")
	WebElement btn_ClearAll_Parents;

	/**
	 * Others page locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "//span[contains(text(),'Singing')]/preceding-sibling::input")
	WebElement chk_Activities_Singing;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Activity')]/preceding-sibling::input")
	WebElement chk_Activities_Susdiny;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Reference')]/preceding-sibling::input")
	WebElement chk_Reference_Susdiny;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Service')]/preceding-sibling::input")
	WebElement chk_Source_Susdiny;

	@FindBy(xpath = "//label[contains(text(),'Achievements:')]/following-sibling::div/textarea")
	WebElement input_Achievements;

	/**
	 * Previous school details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[2]/input")
	WebElement input_SchoolName;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[3]/select")
	WebElement sel_SchoolType;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[4]/select")
	WebElement sel_PreClass;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[5]/input")
	WebElement input_Percentage;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[6]/input")
	WebElement input_Grade;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[7]/select")
	WebElement sel_PassedYr;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[8]/input")
	WebElement input_TotalMarks;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[9]/select")
	WebElement sel_Board;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[10]/select")
	WebElement sel_PrevCountry;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[11]/select")
	WebElement sel_PrevState;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[12]/input")
	WebElement input_PreAddress;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[13]/input")
	WebElement input_LeftReason;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr/td[14]/input")
	WebElement input_Medium;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr[1]/td[15]/span[1]")
	WebElement btn_Action_Add;

	@FindBy(xpath = "//div[@class='box']/div/table/tbody/tr[1]/td[15]/span[2]")
	WebElement btn_Action_Remove;

	/**
	 * Bond details locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//div[@class='box']/table)[1]/tbody/tr")
	List<WebElement> tbl_BondRows;

	/**
	 * Guardian Details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[2]/input")
	WebElement input_GuardianName;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[3]/input")
	WebElement input_GuardianAddress;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[4]/input")
	WebElement input_GuardianEmail;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[5]/input")
	WebElement input_GuardianPhone;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[6]/input")
	WebElement upload_GuardianPhoto;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[6]/span")
	WebElement view_GuardianPhoto;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[7]/input")
	WebElement upload_GuardianSign;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[7]/span")
	WebElement view_GuardianSign;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[8]/input")
	WebElement upload_GuardianFingerPrint;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr/td[8]/span")
	WebElement view_GuardianFingerPrint;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr[1]/td[9]/span[1]")
	WebElement btn_GuarAction_Add;

	@FindBy(xpath = "(//div[@class='box']/table)[2]/tbody/tr[1]/td[9]/span[2]")
	WebElement btn_GuarAction_Remove;

	@FindBy(xpath = "(//button[contains(text(), 'Close')])[1]")
	WebElement btn_View_Close;

	/**
	 * Sibling details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//div[@class='box']/table)[3]/tbody/tr[1]/td[2]/input")
	WebElement input_SiblingName;

	@FindBy(xpath = "(//div[@class='box']/table)[3]/tbody/tr[1]/td[3]/select")
	WebElement sel_sibClass;

	@FindBy(xpath = "(//div[@class='box']/table)[3]/tbody/tr[1]/td[4]/input")
	WebElement input_Relation;

	@FindBy(xpath = "(//div[@class='box']/table)[3]/tbody/tr[1]/td[5]/span[1]")
	WebElement btn_SibAction_Add;

	@FindBy(xpath = "(//div[@class='box']/table)[3]/tbody/tr[1]/td[5]/span[2]")
	WebElement btn_SibAction_Remove;

	@FindBy(xpath = "(//div[@class='text-center'])[5]/button[3]")
	WebElement btn_Clear_Others;

	@FindBy(xpath = "(//span[contains(text(),'Save And Proceed')])[4]/parent::button")
	WebElement btn_Next_Others;

	@FindBy(xpath = "(//div[@class='text-center'])[5]/button[1]")
	WebElement btn_Previous_Others;

	@FindBy(xpath = "(//div[@class='text-center'])[6]/button")
	WebElement btn_ClearAll_Others;

	/**
	 * Document upload locators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr")
	List<WebElement> tbl_DocumentRows;

	@FindBy(xpath = "(//div[@class='text-center ng-scope'])/button[3]")
	WebElement btn_Clear_Document;

	@FindBy(xpath = "(//div[@class='text-center ng-scope'])/button[2]")
	WebElement btn_Submit_Document;

	@FindBy(xpath = "(//div[@class='text-center ng-scope'])/button[1]")
	WebElement btn_Previous_Document;

	@FindBy(xpath = "(//div[@class='text-center'])[6]/button")
	WebElement btn_ClearAll_Document;

	@FindBy(xpath = "//span[contains(text(),'Hostel Required')]/preceding-sibling::input")
	WebElement chk_Hostel_Required;

	@FindBy(xpath = "//span[contains(text(),'Transport Required')]/preceding-sibling::input")
	WebElement chk_Transport_Required;

	@FindBy(xpath = "//span[contains(text(),'Gym Required')]/preceding-sibling::input")
	WebElement chk_Gym_Required;

	@FindBy(xpath = "//span[contains(text(),'ECS')]/preceding-sibling::input")
	WebElement chk_ECS;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[24]")
	WebElement upload_Father_Photo;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[25]")
	WebElement upload_Father_Sign;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[26]")
	WebElement upload_Father_FingerPrint;

	@FindBy(xpath = "(//div[@class='form-group']//span)[2]")
	WebElement view_Father_Photo;

	@FindBy(xpath = "(//div[@class='form-group']//span)[3]")
	WebElement view_Father_Sign;

	@FindBy(xpath = "(//div[@class='form-group']//span)[4]")
	WebElement view_Father_FingerPrint;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[27]")
	WebElement upload_Mother_Photo;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[28]")
	WebElement upload_Mother_Sign;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[29]")
	WebElement upload_Mother_FingerPrint;

	@FindBy(xpath = "(//div[@class='form-group']//span)[5]")
	WebElement view_Mother_Photo;

	@FindBy(xpath = "(//div[@class='form-group']//span)[6]")
	WebElement view_Mother_Sign;

	@FindBy(xpath = "(//div[@class='form-group']//span)[7]")
	WebElement view_Mother_FingerPrint;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//button[text()='Cancel!!']")
	WebElement btn_Cancel_PopUp;

	@FindBy(xpath = "//button[text()='Yes, continue!']")
	WebElement btn_Continue_PopUp;

	@FindBy(xpath = "//h2")
	WebElement PopUp_MsgValidation;

	@FindBy(xpath = "//label[contains(text(),'Date Of Birth:')]/following-sibling::md-datepicker/button")
	private WebElement btn_Calender_DoB;

	@FindBy(xpath = "//span[contains(text(),'Oct 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//table//tbody//tr/td[contains(text(),'2014')]")
	private WebElement btn_Year;

	@FindBy(xpath = "//table//tbody//tr/td[contains(text(),'2016')]")
	private WebElement btn_Year2;

	@FindBy(xpath = "//table//tbody//tr/td[@aria-label='June 2014']/span[contains(text(),Jun)]")
	private WebElement btn_Month;

	@FindBy(xpath = "//span[contains(text(),'Jun 2014')]/following::td[30]/span")
	private WebElement btn_Date;
	
	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public AdmissionForm_StudentAdmissionForm(WebDriver driver) {
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
	 * Navigate to Admission Student Admission Form
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS() throws Exception {

		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btn_AdmissionForm);
		log("Clicked on Admission form Button and object is:-" + btn_AdmissionForm.toString());

		clickOnButton(btn_StudentAdmissionForm);
		log("Clicked on Student Admission Form Button and object is:-" + btn_StudentAdmissionForm.toString());

	}

	/**
	 * Validation of Admission Student Admission Form screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_StudentAdmissionfrom_BGHSPage() {
		try {
			System.out.println(txtAdmissionForm_StuAdmFormMsgDispaly.getText());
			txtAdmissionForm_StuAdmFormMsgDispaly.isDisplayed();
			log("Student admission form page is dispalyed and object is:-"
					+ txtAdmissionForm_StuAdmFormMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankStudentAdmissionForm() throws Exception {

		clickOnButton(btn_Next_Student);
		log("Click on NEXT button to submit blank Student deatils and object is:-" + btn_Next_Student.toString());
	}

	public void uploadStudentPhotograph() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		imageAndDocumentUpload(btn_BrowseImg, "Photo.jpg");
		log("Student image uploaded successfully");
		Thread.sleep(2000);

	}

	public void selectClassForAdm_And_DateofBirth_ForLessThanRequiredAge(String classForAdm, String dobLessThanEligible,
			String lessThanEligibleAge) throws Exception {

		selectElementFromDropDown(sel_Class, classForAdm);
		log("selected class: " + classForAdm + " and object is:- " + sel_Class.toString());

		try {
			copyToClipbord(dobLessThanEligible);

			oAction = new Actions(driver);
			oAction.moveToElement(input_DateOfBirth);
			oAction.contextClick(input_DateOfBirth).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered date of birth: " + dobLessThanEligible + " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(PopUp_MsgValidation.getText().trim(), lessThanEligibleAge);
		clickOnButton(btn_Cancel_PopUp);
		Thread.sleep(3000);

		try {
			copyToClipbord(dobLessThanEligible);

			oAction = new Actions(driver);
			oAction.moveToElement(input_DateOfBirth);
			oAction.contextClick(input_DateOfBirth).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered date of birth: " + dobLessThanEligible + " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(PopUp_MsgValidation.getText().trim(), lessThanEligibleAge);
		clickOnButton(btn_Continue_PopUp);
		Thread.sleep(3000);

	}

	public void selectClassForAdm_And_DateofBirth_ForGreaterThanRequiredAge(String classForAdm,
			String dobGreaterThanEligible, String greaterThanEligibleAge) throws Exception {

		selectElementFromDropDown(sel_Class, classForAdm);
		log("selected class: " + classForAdm + " and object is:- " + sel_Class.toString());

		try {
			copyToClipbord(dobGreaterThanEligible);

			oAction = new Actions(driver);
			oAction.moveToElement(input_DateOfBirth);
			oAction.contextClick(input_DateOfBirth).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered date of birth: " + dobGreaterThanEligible + " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(PopUp_MsgValidation.getText().trim(), greaterThanEligibleAge);
		clickOnButton(btn_Cancel_PopUp);
		Thread.sleep(3000);

		try {
			copyToClipbord(dobGreaterThanEligible);

			oAction = new Actions(driver);
			oAction.moveToElement(input_DateOfBirth);
			oAction.contextClick(input_DateOfBirth).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered date of birth: " + dobGreaterThanEligible + " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(PopUp_MsgValidation.getText().trim(), greaterThanEligibleAge);
		clickOnButton(btn_Continue_PopUp);
		Thread.sleep(3000);

	}

	public void selectClassForAdm_And_DateofBirth(String classForAdm, String dateOfBirth) {

		selectElementFromDropDown(sel_Class, classForAdm);
		log("selected class: " + classForAdm + " and object is:- " + sel_Class.toString());

		try {
			copyToClipbord(dateOfBirth);

			oAction = new Actions(driver);
			oAction.moveToElement(input_DateOfBirth);
			oAction.contextClick(input_DateOfBirth).build().perform();

			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log("Entered date of birth As per Application(Within Specified Range or Configuration): " + dateOfBirth
					+ " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Age value= " + ((JavascriptExecutor) driver)
				.executeScript("angular.element($('.ng-valid-required#reservation')).Text()"));

	}

	@FindBy(xpath = "//input[@ng-model='obj.pasR_Age']")
	WebElement age;

	public void enterStudentDetailsForStudentAdmForm_LeftPart(String firstName, String middleName, String lastName,
			String academicYr, String regNumber, String admissionNum, String casteCategory, String caste,
			String subCaste, String bankIfscCode, String birthPlace, String birthCertificate, String casteCertificate)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);
		// Enter First Name
		inputTextIntoInputField(input_FirstName, firstName);
		log("Entered first name: " + firstName + " and object is:-" + input_FirstName.toString());
		// Enter Middle Name

		inputTextIntoInputField(input_MiddleName, middleName);
		log("Entered middle name: " + middleName + " and object is:-" + input_MiddleName.toString());

		// Enter Last Name

		inputTextIntoInputField(input_LastName, lastName);
		log("Entered last name: " + lastName + " and object is:-" + input_LastName.toString());
		// Select Academic Year
		selectElementFromDropDown(sel_AcademicYr, academicYr);
		log("Selected academic year: " + academicYr + " and object is:- " + sel_AcademicYr.toString());
		// Enter Registration Number
		inputTextIntoInputField(input_RegNumber, regNumber);
		// Enter Admission Number
		inputTextIntoInputField(input_AdmNumber, admissionNum);
		log("Entered Admission number: " + admissionNum + " and object is:-" + input_AdmNumber.toString());

		/// String dob = input_DateOfBirth_InWord.getAttribute("value");

		/**
		 * 
		 * NEED TO UPDATE SCRIPT FOR DOB WORD VALIDATION
		 */

		selectElementFromDropDown(sel_CasteCategory, casteCategory);
		log("selected caste category: " + casteCategory + " and object is:- " + sel_CasteCategory.toString());

		clickOnButton(btn_Caste);
		inputTextIntoInputField(input_Caste, caste);
		input_Caste.sendKeys(Keys.TAB);
		log("Entered caste: " + caste + " and object is:- " + btn_Caste.toString());

		inputTextIntoInputField(input_SubCaste, subCaste);
		log("Entered sub Caste: " + subCaste + " and object is:-" + input_SubCaste.toString());

		inputTextIntoInputField(input_Bank_IFSCCode, bankIfscCode);
		log("Entered Bank IFSC code: " + bankIfscCode + " and object is:-" + input_Bank_IFSCCode.toString());

		inputTextIntoInputField(input_Student_BirthPlace, birthPlace);
		log("Entered student birth place: " + birthPlace + " and object is:-" + input_Student_BirthPlace.toString());

		inputTextIntoInputField(input_BirthCertNumber, birthCertificate);
		log("Entered student birth certificate number: " + birthCertificate + " and object is:-"
				+ input_BirthCertNumber.toString());

		inputTextIntoInputField(input_Caste_CertNumber, casteCertificate);
		log("Entered student caste certificate number: " + casteCertificate + " and object is:-"
				+ input_Caste_CertNumber.toString());
	}

	public void enterStudentDetailsForStudentAdmForm_RightPart(String gender, String motherTongue, String religion,
			String Nationality, String mobileNumber, String emailId, String aadharNum, String bloodGr,
			String studentCat, String stuBankAcNo, String bplCardNo, String concessionType) throws Exception {

		selectElementFromDropDown(sel_Gender, gender);
		log("selected gender: " + gender + " and object is:- " + sel_Gender.toString());

		inputTextIntoInputField(input_MotherTongue, motherTongue);
		log("Entered Mother Tongue: " + motherTongue + " and object is:-" + input_MotherTongue.toString());

		selectElementFromDropDown(sel_Religion, religion);
		log("selected religion: " + religion + " and object is:- " + sel_Religion.toString());

		selectElementFromDropDown(sel_Nationality, Nationality);
		log("selected nationality: " + Nationality + " and object is:- " + sel_Nationality.toString());

		inputTextIntoInputField(input_MobileNumber, mobileNumber);
		log("Entered Mobile number: " + mobileNumber + " and object is:-" + input_MobileNumber.toString());

		inputTextIntoInputField(input_EmailId, emailId);
		log("Entered email Id: " + emailId + " and object is:-" + input_EmailId.toString());

		inputTextIntoInputField(input_AadharNumber, aadharNum);
		log("Entered Aadhar number: " + aadharNum + " and object is:-" + input_AadharNumber.toString());

		selectElementFromDropDown(sel_BloodGroup, bloodGr);
		log("selected Blood group: " + bloodGr + " and object is:- " + sel_BloodGroup.toString());

		selectedDropdownItemValidation(sel_StuCategory, studentCat);
		log("Disabled selected student category: " + studentCat + " and object is:- " + sel_StuCategory.toString());

		inputTextIntoInputField(input_BankACNumber, stuBankAcNo);
		log("Entered student bank account number: " + stuBankAcNo + " and object is:-" + input_BankACNumber.toString());

		isDisplayed(chk_BPLCardNo);
		if (!chk_BPLCardNo.isSelected()) {
			chk_BPLCardNo.click();
			log("Bpl card number check box is checked and object is:-" + chk_BPLCardNo.toString());
			Thread.sleep(1000);
		} else {
			log("Bpl card number check box is already checked and object is:-" + chk_BPLCardNo.toString());
			Thread.sleep(1000);
		}

		inputTextIntoInputField(input_BPLCardNo, bplCardNo);
		log("Entered BPL card number: " + bplCardNo + " and object is:-" + input_BPLCardNo.toString());

		selectElementFromDropDown(sel_FeeConcessionType, concessionType);
		log("selected Fee Concession type: " + concessionType + " and object is:- " + sel_FeeConcessionType.toString());

	}

	public void minimizeStudentAdmissionForm() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);
		
		clickOnButton(btnMin_MaxStudentAdmissionForm);
		log("Student admission form is minimized and object is:-" + btnMin_MaxStudentAdmissionForm.toString());
		Thread.sleep(1000);
	}

	public void sortByStudentFirstName() throws Exception {

		clickOnButton(btnSortByFirstName);
		 SortData_InColumn_DescendingOrder(list_FirstNameAdmForm);
		 log("Element is sorted in descending order and object is:- "+list_FirstNameAdmForm.toString());

		log("Record sorted with student first name in the grid and object is:-" + btnSortByFirstName.toString());

	}

	public void minimizeStudentDetails() throws Exception {

		clickOnButton(btnMin_MaxStudentDetails);
		log("Student details is minimized and object is:-" + btnMin_MaxStudentDetails.toString());
		Thread.sleep(1000);
	}

	public void maximizeStudentAdmissionForm() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);
		
		clickOnButton(btnMin_MaxStudentAdmissionForm);
		log("Student admission form is maximized and object is:-" + btnMin_MaxStudentAdmissionForm.toString());
		Thread.sleep(1000);
	}

	public void maximizeStudentDetails() throws Exception {

		clickOnButton(btnMin_MaxStudentDetails);
		log("Student details is maximized and object is:-" + btnMin_MaxStudentDetails.toString());
		Thread.sleep(1000);
	}

	public void clearFilledStudentAdmissionForm() throws Exception {

		clickOnButton(btn_Clear_Student);
		log("Student form filled data is cleared and object is:-" + btn_Clear_Student.toString());

	}

	public void clickOnNextToSwitchToAddressPage() throws Exception {

		clickOnButton(btn_Next_Student);
		log("Clicked on Next Button and page switched to Address page and object is:-" + btn_Next_Student.toString());

	}

	public void clearAllFilledFieldInStudentAdmissionForm() throws Exception {

		clickOnButton(btn_ClearAll_Student);
		log("Student form filled all field data is cleared and object is:-" + btn_ClearAll_Student.toString());

	}

	public void enterStudentAddressForAdmForm(String StuAddress, String area, String country, String state, String city,
			String pinCode) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		inputTextIntoInputField(input_Address, StuAddress);
		log("Entered student address: " + StuAddress + " and object is:-" + input_Address.toString());

		inputTextIntoInputField(input_Area, area);
		log("Entered Area: " + area + " and object is:-" + input_Area.toString());

		selectElementFromDropDown(sel_Country, country);
		log("selected Country: " + country + " and object is:- " + sel_Country.toString());

		selectElementFromDropDown(sel_State, state);
		log("selected state: " + state + " and object is:- " + sel_State.toString());

		inputTextIntoInputField(input_City, city);
		log("Entered city: " + city + " and object is:-" + input_City.toString());

		inputTextIntoInputField(input_PinCode, pinCode);
		log("Entered pin Code: " + pinCode + " and object is:-" + input_PinCode.toString());

		isDisplayed(chk_SameAsPermAddress);
		if (!chk_SameAsPermAddress.isSelected()) {
			chk_SameAsPermAddress.click();
			log("Same as permanent address check box is selected and object is:-" + chk_SameAsPermAddress.toString());
			Thread.sleep(2000);
		} else {
			log("Same as permanent address check box is already selected and object is:-"
					+ chk_SameAsPermAddress.toString());
			Thread.sleep(2000);
		}
	}

	public void clearFilledAddress() throws Exception {

		clickOnButton(btn_Clear_Address);
		log("Address filled field data is cleared and object is:-" + btn_Clear_Address.toString());

	}

	public void clickOnNextToSwitchFromAddressToParentsPage() throws Exception {

		clickOnButton(btn_Next_Address);
		log("Clicked on Next Button and page switched to Parents page and object is:-" + btn_Next_Address.toString());

	}

	public void clickOnPreviousButtonToGoBackToStudentPage() throws Exception {

		clickOnButton(btn_Previous_Address);
		log("Clicked on Previous Button and page switched to student page and object is:-"
				+ btn_Previous_Address.toString());
	}

	public void submitBlankAddressForm() throws Exception {

		clickOnButton(btn_Next_Address);
		log("Click on NEXT button to submit blank Address deatils and object is:-" + btn_Next_Address.toString());
		Thread.sleep(1000);
	}

	public void selectFatherAliveCheckBox() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);
		isDisplayed(chk_Father_Alive);

		if (!chk_Father_Alive.isSelected()) {
			chk_Father_Alive.click();
			log("Father alive check box is selected and obejct is:-" + chk_Father_Alive.toString());
			Thread.sleep(500);
		} else {
			log("Father alive check box is already selected and obejct is:-" + chk_Father_Alive.toString());
			Thread.sleep(500);
		}
	}

	public void selectMotherAliveCheckBox() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		isDisplayed(chk_Mother_Alive);

		if (!chk_Mother_Alive.isSelected()) {
			chk_Mother_Alive.click();
			log("Mother alive check box is selected and obejct is:-" + chk_Mother_Alive.toString());
			Thread.sleep(500);
		} else {
			log("Mother alive check box is already selected and obejct is:-" + chk_Mother_Alive.toString());
			Thread.sleep(500);
		}
	}

	public void enterMotherDetailsInParentsPage(String motherName, String motherSurName, String m_AadharNo,
			String m_Qualification, String m_OfficeAddr, String m_Occupation, String m_Designation, String m_AccountNo,
			String m_IFSCCode, String m_CasteCertNo, String m_Nationality, String m_Religion, String m_Caste,
			String m_SubCaste, String m_MonthlyIncome, String m_AnnualIncome, String m_MobileNumber, String m_EmailId)
			throws Exception {

		inputTextIntoInputField(input_MotherName, motherName);
		log("Entered Mother Name: " + motherName + " and object is:-" + input_MotherName.toString());

		inputTextIntoInputField(input_MotherSurName, motherSurName);
		log("Entered Mother SurName: " + motherSurName + " and object is:-" + input_MotherSurName.toString());

		inputTextIntoInputField(input_Mother_Aadhar, m_AadharNo);
		log("Entered Mother Aadhar no.: " + m_AadharNo + " and object is:-" + input_Mother_Aadhar.toString());

		inputTextIntoInputField(input_Mother_Qualification, m_Qualification);
		log("Entered Mother Qualification: " + m_Qualification + " and object is:-"
				+ input_Father_Qualification.toString());

		inputTextIntoInputField(input_Mother_OfficeAddr, m_OfficeAddr);
		log("Entered Mother Office Addr: " + m_OfficeAddr + " and object is:-" + input_Mother_OfficeAddr.toString());

		inputTextIntoInputField(input_Mother_Occupation, m_Occupation);
		log("Entered Mother Occupation: " + m_Occupation + " and object is:-" + input_Mother_Occupation.toString());

		inputTextIntoInputField(input_Mother_Designation, m_Designation);
		log("Entered Mother Designation: " + m_Designation + " and object is:-" + input_Mother_Designation.toString());

		inputTextIntoInputField(input_Mother_BankAc, m_AccountNo);
		log("Entered Mother Account no.: " + m_AccountNo + " and object is:-" + input_Mother_BankAc.toString());

		inputTextIntoInputField(input_Mother_IFSCCode, m_IFSCCode);
		log("Entered Mother IFSC Code: " + m_IFSCCode + " and object is:-" + input_Mother_IFSCCode.toString());

		inputTextIntoInputField(input_Mother_CasteCert, m_CasteCertNo);
		log("Entered Mother Caste Cert: " + m_CasteCertNo + " and object is:-" + input_Mother_CasteCert.toString());

		selectElementFromDropDown(sel_Mother_Nationality, m_Nationality);
		log("selected Mother nationality: " + m_Nationality + " and object is:- " + sel_Mother_Nationality.toString());

		selectElementFromDropDown(sel_Mother_Religion, m_Religion);
		log("selected Mother Religion: " + m_Religion + " and object is:- " + sel_Mother_Religion.toString());

		selectElementFromDropDown(sel_Mother_Caste, m_Caste);
		log("selected Mother caste: " + m_Caste + " and object is:- " + sel_Mother_Caste.toString());

		inputTextIntoInputField(input_Mother_SubCaste, m_SubCaste);
		log("Entered Mother Sub Caste: " + m_SubCaste + " and object is:-" + input_Mother_SubCaste.toString());

		inputTextIntoInputField(input_Mother_MonthlyIncome, m_MonthlyIncome);
		log("Entered Mother monthly income: " + m_MonthlyIncome + " and object is:-"
				+ input_Mother_MonthlyIncome.toString());

		inputTextIntoInputField(input_Mother_AnnualIncome, m_AnnualIncome);
		log("Entered Mother Annual income.: " + m_AnnualIncome + " and object is:-"
				+ input_Mother_AnnualIncome.toString());

		inputTextIntoInputField(input_Mother_MobileNum, m_MobileNumber);
		log("Entered Mother mobile number: " + m_MobileNumber + " and object is:-" + input_Mother_MobileNum.toString());

		inputTextIntoInputField(input_Mother_EmailId, m_EmailId);
		log("Entered Mother Email Id: " + m_EmailId + " and object is:-" + input_Mother_EmailId.toString());

	}

	public void enterFatherDetailsInParentsPage(String fatherName, String fatherSurName, String f_AadharNo,
			String f_Qualification, String f_OfficeAddr, String f_Occupation, String f_Designation, String f_AccountNo,
			String f_IFSCCode, String f_CasteCertNo, String f_Nationality, String f_Religion, String f_Caste,
			String f_SubCaste, String f_MonthlyIncome, String f_AnnualIncome, String f_MobileNumber, String f_EmailId)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		inputTextIntoInputField(input_FatherName, fatherName);
		log("Entered Father Name: " + fatherName + " and object is:-" + input_FatherName.toString());

		inputTextIntoInputField(input_FatherSurName, fatherSurName);
		log("Entered father SurName: " + fatherSurName + " and object is:-" + input_FatherSurName.toString());

		inputTextIntoInputField(input_Father_Aadhar, f_AadharNo);
		log("Entered Father Aadhar no.: " + f_AadharNo + " and object is:-" + input_Father_Aadhar.toString());

		inputTextIntoInputField(input_Father_Qualification, f_Qualification);
		log("Entered father Qualification: " + f_Qualification + " and object is:-"
				+ input_Father_Qualification.toString());

		inputTextIntoInputField(input_Father_OfficeAddr, f_OfficeAddr);
		log("Entered Father Office Addr: " + f_OfficeAddr + " and object is:-" + input_Father_OfficeAddr.toString());

		inputTextIntoInputField(input_Father_Occupation, f_Occupation);
		log("Entered Father Occupation: " + f_Occupation + " and object is:-" + input_Father_Occupation.toString());

		inputTextIntoInputField(input_Father_Designation, f_Designation);
		log("Entered father Designation: " + f_Designation + " and object is:-" + input_Father_Designation.toString());

		inputTextIntoInputField(input_Father_BankAc, f_AccountNo);
		log("Entered Father Account no.: " + f_AccountNo + " and object is:-" + input_Father_BankAc.toString());

		inputTextIntoInputField(input_Father_IFSCCode, f_IFSCCode);
		log("Entered father IFSC Code: " + f_IFSCCode + " and object is:-" + input_Father_IFSCCode.toString());

		inputTextIntoInputField(input_Father_CasteCert, f_CasteCertNo);
		log("Entered Father Caste Cert: " + f_CasteCertNo + " and object is:-" + input_Father_CasteCert.toString());

		selectElementFromDropDown(sel_Father_Nationality, f_Nationality);
		log("selected Father nationality: " + f_Nationality + " and object is:- " + sel_Father_Nationality.toString());

		selectElementFromDropDown(sel_Father_Religion, f_Religion);
		log("selected Father Religion: " + f_Religion + " and object is:- " + sel_Father_Religion.toString());

		selectElementFromDropDown(sel_Father_Caste, f_Caste);
		log("selected Father caste: " + f_Caste + " and object is:- " + sel_Father_Caste.toString());

		inputTextIntoInputField(input_Father_SubCaste, f_SubCaste);
		log("Entered Father Sub Caste: " + f_SubCaste + " and object is:-" + input_Father_SubCaste.toString());

		inputTextIntoInputField(input_Father_MonthlyIncome, f_MonthlyIncome);
		log("Entered father monthly income: " + f_MonthlyIncome + " and object is:-"
				+ input_Father_MonthlyIncome.toString());

		inputTextIntoInputField(input_Father_AnnualIncome, f_AnnualIncome);
		log("Entered Father Annual income.: " + f_AnnualIncome + " and object is:-"
				+ input_Father_AnnualIncome.toString());

		inputTextIntoInputField(input_Father_MobileNum, f_MobileNumber);
		log("Entered father mobile number: " + f_MobileNumber + " and object is:-" + input_Father_MobileNum.toString());

		inputTextIntoInputField(input_Father_EmailId, f_EmailId);
		log("Entered Father Email Id: " + f_EmailId + " and object is:-" + input_Father_EmailId.toString());

	}

	public void clearFilledParentsDetails() throws Exception {

		clickOnButton(btn_Clear_Parents);
		log("Parents details filled field data is cleared and object is:-" + btn_Clear_Parents.toString());

	}

	public void clickOnNextToSwitchFromParentsToOthersPage() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		clickOnButton(btn_Next_Parents);
		log("Clicked on Next Button and page switched to Others page and object is:-" + btn_Next_Parents.toString());
	}

	public void clickOnPreviousButtonToGoBackToAddressPage() throws Exception {

		clickOnButton(btn_Previous_Parents);
		log("Clicked on Previous Button and page switched to Address page and object is:-"
				+ btn_Previous_Parents.toString());

	}

	public void submitBlankParentsForm() throws Exception {

		clickOnButton(btn_Next_Parents);
		log("Click on NEXT button to submit blank parents deatils and object is:-" + btn_Next_Parents.toString());

	}

	public void selectActivities() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);
		isDisplayed(chk_Activities_Singing);
		if (!chk_Activities_Singing.isSelected()) {
			chk_Activities_Singing.click();
			log("Singing activities check box is selected and object is:-" + chk_Activities_Singing.toString());
			Thread.sleep(500);
		} else {
			log("Singing activities check box is already selected and object is:-" + chk_Activities_Singing.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Activities_Susdiny);
		if (!chk_Activities_Susdiny.isSelected()) {
			chk_Activities_Susdiny.click();
			log("Susdiny activities check box is selected and object is:-" + chk_Activities_Susdiny.toString());
			Thread.sleep(500);
		} else {
			log("Susdiny activities check box is already selected and object is:-" + chk_Activities_Singing.toString());
			Thread.sleep(500);
		}
	}

	public void selectReference() throws Exception {
		isDisplayed(chk_Reference_Susdiny);
		if (!chk_Reference_Susdiny.isSelected()) {
			chk_Reference_Susdiny.click();
			log("Susdiny reference check box is selected and object is:-" + chk_Reference_Susdiny.toString());
			Thread.sleep(500);
		} else {
			log("Susdiny reference check box is already selected and object is:-" + chk_Reference_Susdiny.toString());
			Thread.sleep(500);
		}
	}

	public void selectSource() throws Exception {
		isDisplayed(chk_Source_Susdiny);
		if (!chk_Source_Susdiny.isSelected()) {
			chk_Source_Susdiny.click();
			log("Susdiny service check box is selected and object is:-" + chk_Source_Susdiny.toString());
			Thread.sleep(500);
		} else {
			log("Susdiny service check box is already selected and object is:-" + chk_Source_Susdiny.toString());
			Thread.sleep(500);
		}
	}

	public void enterAchievementsDetails(String achievements) throws Exception {

		inputTextIntoInputField(input_Achievements, achievements);
		log("Entered achivements: " + achievements + " and object is:-" + input_Achievements.toString());

	}

	public void selectBondAndFillWithBondNumber(String bondName, String bondNumber) {
		int rows = tbl_BondRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			try {
				String bondname = driver
						.findElement(By.xpath("(//div[@class='box']/table)[1]/tbody/tr[" + i + "]/td[2]/span"))
						.getText().trim();
				System.out.println("Bond Name: " + bondName);
				// Thread.sleep(2000);

				if (bondname.equalsIgnoreCase(bondName)) {

					WebElement bondcheckbox = driver.findElement(By.xpath("(//div[@class='box']/table)[1]/tbody/tr[" + i
							+ "]/td[2]/span[contains(text(),'" + bondname + "')]/preceding-sibling::input"));
					if (!bondcheckbox.isSelected()) {
						bondcheckbox.click();
						log("Bond check box is selected and object is:-" + bondcheckbox.toString());
						Thread.sleep(500);
					} else {
						log("Bond check box is already selected and object is:-" + bondcheckbox.toString());
						Thread.sleep(500);
					}
					WebElement bondNum = driver
							.findElement(By.xpath("(//div[@class='box']/table)[1]/tbody/tr[" + i + "]/td[3]/input"));
					bondNum.clear();
					bondNum.sendKeys(bondNumber);
					log("Entered bond number:" + bondNumber + " and object is:-" + bondNum.toString());
					Thread.sleep(500);
					break;
				} else {
					log("Bond Name not matched with the bond name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void enterPreviousSchoolDetails(String schoolName, String schoolType, String preClass, String percentage,
			String grade, String passedYear, String totalMarks, String board, String country, String state,
			String address, String leftReason, String medium) throws Exception {

		inputTextIntoInputField(input_SchoolName, schoolName);
		log("Entered school name:" + schoolName + " and object is:-" + input_SchoolName.toString());

		selectElementFromDropDown(sel_SchoolType, schoolType);
		log("selected School Type: " + schoolType + " and object is:- " + sel_SchoolType.toString());

		selectElementFromDropDown(sel_PreClass, preClass);
		log("Previous Class: " + preClass + " and object is:- " + sel_PreClass.toString());

		inputTextIntoInputField(input_Percentage, percentage);
		log("Entered Percentage:" + percentage + " and object is:-" + input_Percentage.toString());

		inputTextIntoInputField(input_Grade, grade);
		log("Entered Grade:" + grade + " and object is:-" + input_Grade.toString());

		selectElementFromDropDown(sel_PassedYr, passedYear);
		log("Passed Year: " + passedYear + " and object is:- " + sel_PassedYr.toString());

		inputTextIntoInputField(input_TotalMarks, totalMarks);
		log("Entered Total Marks:" + totalMarks + " and object is:-" + input_TotalMarks.toString());

		selectElementFromDropDown(sel_Board, board);
		log("Board of previous school: " + board + " and object is:- " + sel_Board.toString());

		selectElementFromDropDown(sel_PrevCountry, country);
		log("Country of previous school: " + country + " and object is:- " + sel_PrevCountry.toString());

		selectElementFromDropDown(sel_PrevState, state);
		log("Prevoius school state: " + state + " and object is:- " + sel_PrevState.toString());

		inputTextIntoInputField(input_PreAddress, address);
		log("Entered Previous school address:" + address + " and object is:-" + input_PreAddress.toString());

		inputTextIntoInputField(input_LeftReason, leftReason);
		log("Entered Reason for leaving:" + leftReason + " and object is:-" + input_LeftReason.toString());

		inputTextIntoInputField(input_Medium, medium);
		log("Entered medium:" + medium + " and object is:-" + input_Medium.toString());

	}

	public void enterGuardianDetails(String guardianName, String guardianAddress, String guardianEmail,
			String guardianPhone) throws Exception {

		inputTextIntoInputField(input_GuardianName, guardianName);
		log("Entered Guardian Name:" + guardianName + " and object is:-" + input_GuardianName.toString());

		inputTextIntoInputField(input_GuardianAddress, guardianAddress);
		log("Entered guardian address:" + guardianAddress + " and object is:-" + input_GuardianAddress.toString());

		inputTextIntoInputField(input_GuardianEmail, guardianEmail);
		log("Entered Guardian Email:" + guardianEmail + " and object is:-" + input_GuardianEmail.toString());

		inputTextIntoInputField(input_GuardianPhone, guardianPhone);
		log("Entered Guardian Phone:" + guardianPhone + " and object is:-" + input_GuardianPhone.toString());

	}

	public void uploadGuardianPhoto() throws Exception {

		imageAndDocumentUpload(upload_GuardianPhoto, "Guardian.jpg");
		log("Guardian image uploaded successfully");

	}

	public void uploadGuardianSignature() throws Exception {

		imageAndDocumentUpload(upload_GuardianSign, "signature.jpg");
		log("Guardian signature image uploaded successfully");

	}

	public void uploadGuardianFingerPrint() throws Exception {

		imageAndDocumentUpload(upload_GuardianFingerPrint, "fingerPrint.jpg");
		log("Guardian Finger print image uploaded successfully");

	}

	public void viewUploadedGuardianPhoto() throws Exception {

		clickOnButton(view_GuardianPhoto);
		log("clicked on photo view button and object is:-" + view_GuardianPhoto.toString());

	}

	public void viewUploadedGuardianSign() throws Exception {

		clickOnButton(view_GuardianSign);
		log("clicked on sign view button and object is:-" + view_GuardianSign.toString());

	}

	public void viewUploadedGuardianFingerPrint() throws Exception {

		clickOnButton(view_GuardianFingerPrint);
		log("clicked on Finger Print view button and object is:-" + view_GuardianFingerPrint.toString());

	}

	public void closeOpenedUploadedImagePopUp() throws Exception {

		clickOnButton(btn_View_Close);
		log("Closed opened uploaded image pop up and object is:-" + btn_View_Close.toString());

	}

	public void enterSiblingDetails(String siblingName, String siblingClass, String siblingRelation) throws Exception {

		inputTextIntoInputField(input_SiblingName, siblingName);
		log("Entered Sibling Name:" + siblingName + " and object is:-" + input_SiblingName.toString());

		selectElementFromDropDown(sel_sibClass, siblingClass);
		log("Sibling class: " + siblingClass + " and object is:- " + sel_sibClass.toString());

		inputTextIntoInputField(input_Relation, siblingRelation);
		log("Entered Sibling Marks:" + siblingRelation + " and object is:-" + input_Relation.toString());

	}

	public void clearFilledOthersDetails() throws Exception {

		clickOnButton(btn_Clear_Others);
		log("Others details filled field data is cleared and object is:-" + btn_Clear_Others.toString());

	}

	public void clickOnNextToSwitchFromOthersToDocumentsPage() throws Exception {

		clickOnButton(btn_Next_Others);
		log("Clicked on Next Button and page switched to Documents page and object is:-" + btn_Next_Others.toString());

	}

	public void clickOnPreviousButtonToGoBackToParentsPage() throws Exception {

		clickOnButton(btn_Previous_Others);
		log("Clicked on Previous Button and page switched to Parents page and object is:-"
				+ btn_Previous_Others.toString());

	}

	public void submitBlankOthersForm() throws Exception {

		clickOnButton(btn_Next_Others);
		log("Click on NEXT button to submit blank Others deatils and object is:-" + btn_Next_Parents.toString());

	}

	public void uploadDocumentCorrepondingToDocumentName(String documentName) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		int rowsDoc = tbl_DocumentRows.size();
		System.out.println(rowsDoc);
		// Thread.sleep(2000);
		for (int i = 1; i <= rowsDoc; i++) {
			try {
				String documentname = driver.findElement(By.xpath(
						"(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr[" + i + "]/td[2]"))
						.getText().trim();
				System.out.println("Document Name: " + documentname);
				// Thread.sleep(2000);

				if (documentname.equalsIgnoreCase(documentName)) {

					WebElement uploaddocument = driver.findElement(
							By.xpath("(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr[" + i
									+ "]/td[3]/label"));

					imageAndDocumentUpload(uploaddocument, "TransferCertificate.jpg");
					log("Document uploded and object is:-" + uploaddocument.toString());
					Thread.sleep(5000);

					WebElement viewuploadeddoc = driver.findElement(
							By.xpath("(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr[" + i
									+ "]/td[4]/a"));
					viewuploadeddoc.click();
					Thread.sleep(1000);
					break;
				} else {
					log("Document Name not matched with the Document name list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clearFilledDocumentsDetails() throws Exception {

		clickOnButton(btn_Clear_Document);
		log("Documents details filled field data is cleared and object is:-" + btn_Clear_Document.toString());

	}

	public void clickOnSubmitButton_Documents() throws Exception {

		clickOnButton(btn_Submit_Document);
		log("Clicked on Submit Button and object is:-" + btn_Submit_Document.toString());

	}

	public void clickOnPreviousButtonToGoBackToOthersPage() throws Exception {

		clickOnButton(btn_Previous_Document);
		log("Clicked on Previous Button and page switched to Others page and object is:-"
				+ btn_Previous_Document.toString());

	}

	public void requiredDetailsInDocumentsPage() throws Exception {
		isDisplayed(chk_Hostel_Required);
		if (!chk_Hostel_Required.isSelected()) {
			chk_Hostel_Required.click();
			log("Hostel required check box is checked and object is:-" + chk_Hostel_Required.toString());
			Thread.sleep(500);
		} else {
			log("Hostel required check box is already checked and object is:-" + chk_Hostel_Required.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Transport_Required);
		if (!chk_Transport_Required.isSelected()) {
			chk_Transport_Required.click();
			log("Transport required check box is checked and object is:-" + chk_Transport_Required.toString());
			Thread.sleep(500);
		} else {
			log("Transport required check box is already checked and object is:-" + chk_Transport_Required.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_Gym_Required);
		if (!chk_Gym_Required.isSelected()) {
			chk_Gym_Required.click();
			log("Gym required check box is checked and object is:-" + chk_Gym_Required.toString());
			Thread.sleep(500);
		} else {
			log("Gym required check box is already checked and object is:-" + chk_Gym_Required.toString());
			Thread.sleep(500);
		}
		isDisplayed(chk_ECS);
		if (!chk_ECS.isSelected()) {
			chk_ECS.click();
			log("ECS check box is checked and object is:-" + chk_ECS.toString());
			Thread.sleep(500);
		} else {
			log("ECS check box is already checked and object is:-" + chk_ECS.toString());
			Thread.sleep(500);
		}
	}

	public void uploadFatherPhoto() throws Exception {

		imageAndDocumentUpload(upload_Father_Photo, "Photo.jpg");
		log("Father image uploaded successfully");

	}

	public void uploadFatherSign() throws Exception {

		imageAndDocumentUpload(upload_Father_Sign, "signature.jpg");
		log("Father signature uploaded successfully");

	}

	public void uploadFatherFingerPrint() throws Exception {

		imageAndDocumentUpload(upload_Father_FingerPrint, "fingerPrint.jpg");
		log("Father finger Print uploaded successfully");

	}

	public void viewUploadedFatherPhoto() throws Exception {

		clickOnButton(view_Father_Photo);
		log("clicked on father photo view button and object is:-" + view_Father_Photo.toString());

	}

	public void viewUploadedFatherSign() throws Exception {

		clickOnButton(view_Father_Sign);
		log("clicked on father Sign view button and object is:-" + view_Father_Sign.toString());

	}

	public void viewUploadedFatherFingerPrint() throws Exception {

		clickOnButton(view_Father_FingerPrint);
		log("clicked on father Finger Print view button and object is:-" + view_Father_FingerPrint.toString());

	}

	public void uploadMotherPhoto() throws Exception {

		imageAndDocumentUpload(upload_Mother_Photo, "SchoolGirl.jpg");
		log("Mother image uploaded successfully");

	}

	public void uploadMotherSign() throws Exception {

		imageAndDocumentUpload(upload_Mother_Sign, "signature.jpg");
		log("Mother signature uploaded successfully");

	}

	public void uploadMotherFingerPrint() throws Exception {

		imageAndDocumentUpload(upload_Mother_FingerPrint, "fingerPrint.jpg");
		log("Mother finger Print uploaded successfully");

	}

	public void viewUploadedMotherPhoto() throws Exception {

		clickOnButton(view_Mother_Photo);
		log("clicked on Mother photo view button and object is:-" + view_Mother_Photo.toString());

	}

	public void viewUploadedMotherSign() throws Exception {

		clickOnButton(view_Mother_Sign);
		log("clicked on Mother Sign view button and object is:-" + view_Mother_Sign.toString());

	}

	public void viewUploadedMotherFingerPrint() throws Exception {

		clickOnButton(view_Mother_FingerPrint);
		log("clicked on Mother Finger Print view button and object is:-" + view_Mother_FingerPrint.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}
	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try{
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
