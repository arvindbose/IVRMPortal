/**
 * 
 */
package com.test.automation.uiAutomation.Admission.AdmissionForm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Admission Form')][1]/following::ul[1]")
	WebElement btn_StudentAdmissionForm;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmissionForm_StuAdmFormMsgDispaly;

	@FindBy(xpath = "(//span[contains(text(),'Next')])[1]/parent::button")
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

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[1]")
	WebElement btn_BrowseImg;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_FirstName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement input_MiddleName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement input_LastName;

	@FindBy(xpath = "(//label[contains(text(),'Admission No:')]/following-sibling::div/input)[1]")
	WebElement input_AdmNumber;

	@FindBy(xpath = "(//label[contains(text(),'Academic Year:')]/following-sibling::div/select)[1]")
	WebElement sel_AcademicYrDisabled;

	@FindBy(xpath = "(//label[contains(text(),'Class:')]/following-sibling::div/select)[1]")
	WebElement sel_Class;

	@FindBy(xpath = "(//div[@class='md-datepicker-input-container'])[1]")
	WebElement input_DateOfAdm;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[6]")
	WebElement input_DateOfBirth;

	@FindBy(xpath = "(//label[contains(text(),'DOB in Words:')]/following-sibling::div/input)[1]")
	WebElement input_DateOfBirth_InWord;

	@FindBy(xpath = "(//label[contains(text(),'Caste Category:')]/following-sibling::div/select)[1]")
	WebElement sel_CasteCategory;

	@FindBy(xpath = "(//label[contains(text(),'Caste:')]/following-sibling::div/select)[1]")
	WebElement sel_Caste;

	@FindBy(xpath = "(//label[contains(text(),'Sub Caste:')]/following-sibling::div/input)[1]")
	WebElement input_SubCaste;

	@FindBy(xpath = "(//label[contains(text(),'Bank IFSC Code:')]/following-sibling::div/input)[1]")
	WebElement input_Bank_IFSCCode;

	@FindBy(xpath = "(//label[contains(text(),'Student Birth Place:')]/following-sibling::div/input)[1]")
	WebElement input_Student_BirthPlace;

	@FindBy(xpath = "(//label[contains(text(),'Birth Certificate No.:')]/following-sibling::div/input)[1]")
	WebElement input_BirthCertNumber;

	@FindBy(xpath = "(//label[contains(text(),'Caste Certificate No.:')]/following-sibling::div/input)[1]")
	WebElement input_Caste_CertNumber;

	@FindBy(xpath = "(//label[contains(text(),'Age:')]/following-sibling::div/input)[1]")
	WebElement input_Age;

	@FindBy(xpath = "(//label[contains(text(),'Gender:')]/following-sibling::div/select)[1]")
	WebElement sel_Gender;

	@FindBy(xpath = "(//label[contains(text(),'Mother Tongue:')]/following-sibling::div/input)[1]")
	WebElement input_MotherTongue;

	@FindBy(xpath = "(//label[contains(text(),'Religion:')]/following-sibling::div/select)[1]")
	WebElement sel_Religion;

	@FindBy(xpath = "(//label[contains(text(),'Nationality:')]/following-sibling::div/select)[1]")
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

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[19]")
	WebElement input_BPLCardNo;

	@FindBy(xpath = "(//label[contains(text(),'Fee Concession Type:')]/following-sibling::div/select)[1]")
	WebElement sel_FeeConcessionType;

	@FindBy(xpath = "(//label[contains(text(),'Student TPIN:')]/following-sibling::div/input)[1]")
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

	@FindBy(xpath = "(//div[@class='text-center'])[3]/button[2]")
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

	@FindBy(xpath = "(//div[@class='text-center'])[4]/button[2]")
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

	@FindBy(xpath = "(//div[@class='text-center'])[5]/button[2]")
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

	public AdmissionForm_StudentAdmissionForm(WebDriver driver) {
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
	 * Navigate to Admission Student Admission Form
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS() throws Exception {

		if (btn_Admission.isDisplayed()) {
			btn_Admission.click();
			log("Clicked on admission Button and object is:-" + btn_Admission.toString());
			waitForElement(driver, 10, btn_AdmissionForm);
			Thread.sleep(3000);
		} else {
			log("Admission Element not present.");
		}
		if (btn_AdmissionForm.isDisplayed()) {
			btn_AdmissionForm.click();
			log("Clicked on Admission form Button and object is:-" + btn_AdmissionForm.toString());
			waitForElement(driver, 10, btn_StudentAdmissionForm);
			Thread.sleep(2000);
		} else {
			log("Admission form Element not present.");

		}
		if (btn_StudentAdmissionForm.isDisplayed()) {
			btn_StudentAdmissionForm.click();
			log("Clicked on Student Admission Form Button and object is:-" + btn_StudentAdmissionForm.toString());
			waitForElement(driver, 10, btn_Next_Student);
			Thread.sleep(2000);
		} else {
			log("Student Admission Form Element not present.");
		}
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
		if (btn_Next_Student.isDisplayed()) {
			btn_Next_Student.click();
			log("Click on NEXT button to submit blank Student deatils and object is:-" + btn_Next_Student.toString());
			Thread.sleep(3000);
		} else {
			log("Next button is not present.");
		}

	}

	public void uploadStudentPhotograph() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (btn_BrowseImg.isDisplayed()) {
			imageAndDocumentUpload(btn_BrowseImg, "Photo.jpg");
			log("Student image uploaded successfully");
			Thread.sleep(3000);
		} else {
			log("Photo upload button is not present.");
		}
	}

	public void enterStudentDetailsForStudentAdmForm_LeftPart(String firstName, String middleName, String lastName,
			String academicYr, String admissionNum, String classForAdm, String dateOfAdm, String dateOfBirth,
			String casteCategory, String caste, String subCaste, String bankIfscCode, String birthPlace,
			String birthCertificate, String casteCertificate) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (input_FirstName.isDisplayed()) {
			input_FirstName.clear();
			input_FirstName.sendKeys(firstName);
			log("Entered first name: " + firstName + " and object is:-" + input_FirstName.toString());
			Thread.sleep(500);
		} else {
			log("First name element is not present");
		}
		if (input_MiddleName.isDisplayed()) {
			input_MiddleName.clear();
			input_MiddleName.sendKeys(middleName);
			log("Entered middle name: " + middleName + " and object is:-" + input_MiddleName.toString());
			Thread.sleep(500);
		} else {
			log("Middle name element is not present");
		}
		if (input_LastName.isDisplayed()) {
			input_LastName.clear();
			input_LastName.sendKeys(lastName);
			log("Entered last name: " + lastName + " and object is:-" + input_LastName.toString());
			Thread.sleep(500);
		} else {
			log("Last name element is not present");
		}

		if (sel_AcademicYrDisabled.isDisplayed()) {
			Select dropdown = new Select(sel_AcademicYrDisabled);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, academicYr);
			log("Disabled selected academic year: " + SelectedContent + " and object is:- "
					+ sel_AcademicYrDisabled.toString());
			Thread.sleep(500);
		} else {
			log("Disable academic year element is not present");
		}
		if (input_AdmNumber.isDisplayed()) {
			input_AdmNumber.clear();
			input_AdmNumber.sendKeys(admissionNum);
			log("Entered Admission number: " + admissionNum + " and object is:-" + input_AdmNumber.toString());
			Thread.sleep(500);
		} else {
			log("Last name element is not present");
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(classForAdm);
			log("selected class: " + classForAdm + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), classForAdm);
			Thread.sleep(2000);
		} else {
			log("Class element is not present");
		}
		// try {
		// copyToClipbord(dateOfAdm);
		//
		// oAction = new Actions(driver);
		// oAction.moveToElement(input_DateOfAdm);
		// oAction.contextClick(input_DateOfAdm).build().perform();
		//
		// robot = new Robot();
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// log("Entered date of admission: " + dateOfAdm + " and object is:-" +
		// input_DateOfAdm.toString());
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

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
			log("Entered date of birth: " + dateOfBirth + " and object is:-" + input_DateOfBirth.toString());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/// String dob = input_DateOfBirth_InWord.getAttribute("value");

		if (sel_CasteCategory.isDisplayed()) {
			select = new Select(sel_CasteCategory);
			select.selectByVisibleText(casteCategory);
			log("selected caste category: " + casteCategory + " and object is:- " + sel_CasteCategory.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), casteCategory);
			Thread.sleep(1000);
		} else {
			log("Caste category element is not present");
		}
		if (sel_Caste.isDisplayed()) {
			select = new Select(sel_Caste);
			select.selectByVisibleText(caste);
			log("selected caste: " + caste + " and object is:- " + sel_Caste.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), caste);
			Thread.sleep(1000);
		} else {
			log("Caste element is not present");
		}

		if (input_SubCaste.isDisplayed()) {
			input_SubCaste.clear();
			input_SubCaste.sendKeys(subCaste);
			Thread.sleep(500);
			log("Entered sub Caste: " + subCaste + " and object is:-" + input_SubCaste.toString());
		} else {
			log("Sub Caste element is not present");
		}

		if (input_Bank_IFSCCode.isDisplayed()) {
			input_Bank_IFSCCode.clear();
			input_Bank_IFSCCode.sendKeys(bankIfscCode);
			Thread.sleep(500);
			log("Entered Bank IFSC code: " + bankIfscCode + " and object is:-" + input_Bank_IFSCCode.toString());
		} else {
			log("Bank IFSC code element is not present");
		}
		if (input_Student_BirthPlace.isDisplayed()) {
			input_Student_BirthPlace.clear();
			input_Student_BirthPlace.sendKeys(birthPlace);
			Thread.sleep(500);
			log("Entered student birth place: " + birthPlace + " and object is:-"
					+ input_Student_BirthPlace.toString());
		} else {
			log("Student birth place element is not present");
		}
		if (input_BirthCertNumber.isDisplayed()) {
			input_BirthCertNumber.clear();
			input_BirthCertNumber.sendKeys(birthCertificate);

			log("Entered student birth certificate number: " + birthCertificate + " and object is:-"
					+ input_BirthCertNumber.toString());
			Thread.sleep(500);
		} else {
			log("birth certificate element is not present");
		}

		if (input_Caste_CertNumber.isDisplayed()) {
			input_Caste_CertNumber.clear();
			input_Caste_CertNumber.sendKeys(casteCertificate);

			log("Entered student caste certificate number: " + casteCertificate + " and object is:-"
					+ input_Caste_CertNumber.toString());
			Thread.sleep(500);
		} else {
			log("Caste certificate element is not present");
		}
	}

	public void enterStudentDetailsForStudentAdmForm_RightPart(String gender, String motherTongue, String religion,
			String Nationality, String mobileNumber, String emailId, String aadharNum, String bloodGr,
			String studentCat, String stuBankAcNo, String bplCardNo, String concessionType) throws Exception {

		if (sel_Gender.isDisplayed()) {
			select = new Select(sel_Gender);
			select.selectByVisibleText(gender);
			Thread.sleep(2000);
			log("selected gender: " + gender + " and object is:- " + sel_Gender.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), gender);
			Thread.sleep(500);
		} else {
			log("Gender element is not present");
		}

		if (input_MotherTongue.isDisplayed()) {
			input_MotherTongue.clear();
			input_MotherTongue.sendKeys(motherTongue);
			Thread.sleep(1000);
			log("Entered Mother Tongue: " + motherTongue + " and object is:-" + input_MotherTongue.toString());
		} else {
			log("Mother Tongue element is not present");
		}

		if (sel_Religion.isDisplayed()) {
			select = new Select(sel_Religion);
			select.selectByVisibleText(religion);
			Thread.sleep(2000);
			log("selected religion: " + religion + " and object is:- " + sel_Religion.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), religion);
		} else {
			log("Religion element is not present");
		}

		if (sel_Nationality.isDisplayed()) {
			select = new Select(sel_Nationality);
			select.selectByVisibleText(Nationality);
			Thread.sleep(2000);
			log("selected nationality: " + Nationality + " and object is:- " + sel_Nationality.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Nationality);
		} else {
			log("Nationality element is not present");
		}

		if (input_MobileNumber.isDisplayed()) {
			input_MobileNumber.clear();
			input_MobileNumber.sendKeys(mobileNumber);
			Thread.sleep(1000);
			log("Entered Mobile number: " + mobileNumber + " and object is:-" + input_MobileNumber.toString());
		} else {
			log("Mobile Number element is not present");
		}

		if (input_EmailId.isDisplayed()) {
			input_EmailId.clear();
			input_EmailId.sendKeys(emailId);
			Thread.sleep(1000);
			log("Entered email Id: " + emailId + " and object is:-" + input_EmailId.toString());
		} else {
			log("Email Id element is not present");
		}

		if (input_AadharNumber.isDisplayed()) {
			input_AadharNumber.clear();
			input_AadharNumber.sendKeys(aadharNum);
			Thread.sleep(1000);
			log("Entered Aadhar number: " + aadharNum + " and object is:-" + input_AadharNumber.toString());
		} else {
			log("Aadhar number element is not present");
		}
		if (sel_BloodGroup.isDisplayed()) {
			select = new Select(sel_BloodGroup);
			select.selectByVisibleText(bloodGr);
			Thread.sleep(2000);
			log("selected Blood group: " + bloodGr + " and object is:- " + sel_BloodGroup.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), bloodGr);
		} else {
			log("Blood group element is not present");
		}
		if (sel_StuCategory.isDisplayed()) {
			Select dropdown = new Select(sel_StuCategory);
			WebElement dropdownOption = dropdown.getFirstSelectedOption();
			String SelectedContent = dropdownOption.getText().trim();
			System.out.println("selected Value " + SelectedContent);
			Assert.assertEquals(SelectedContent, studentCat);
			log("Disabled selected student category: " + SelectedContent + " and object is:- "
					+ sel_StuCategory.toString());

		} else {
			log("Disable student category element is not present");
		}

		if (input_BankACNumber.isDisplayed()) {
			input_BankACNumber.clear();
			input_BankACNumber.sendKeys(stuBankAcNo);
			Thread.sleep(1000);
			log("Entered student bank account number: " + stuBankAcNo + " and object is:-"
					+ input_BankACNumber.toString());
		} else {
			log("Student bank account number element is not present");
		}

		if (!chk_BPLCardNo.isSelected()) {
			chk_BPLCardNo.click();
			log("Bpl card number check box is checked and object is:-" + chk_BPLCardNo.toString());
			Thread.sleep(1000);
		} else {
			log("Bpl card number check box is already checked and object is:-" + chk_BPLCardNo.toString());
			Thread.sleep(1000);
		}
		if (input_BPLCardNo.isDisplayed()) {
			input_BPLCardNo.clear();
			input_BPLCardNo.sendKeys(bplCardNo);
			Thread.sleep(1000);
			log("Entered BPL card number: " + bplCardNo + " and object is:-" + input_BPLCardNo.toString());
		} else {
			log("BPL card number element is not present");
		}
		if (sel_FeeConcessionType.isDisplayed()) {
			select = new Select(sel_FeeConcessionType);
			select.selectByVisibleText(concessionType);
			log("selected Fee Concession type: " + concessionType + " and object is:- "
					+ sel_FeeConcessionType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), concessionType);
			Thread.sleep(3000);
		} else {
			log("Fee Concession type element is not present");
		}
	}

	public void minimizeStudentAdmissionForm() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (btnMin_MaxStudentAdmissionForm.isDisplayed()) {
			btnMin_MaxStudentAdmissionForm.click();
			log("Student admission form is minimized and object is:-" + btnMin_MaxStudentAdmissionForm.toString());
			Thread.sleep(2000);
		} else {
			log("Minimize student admission form button element not present.");
		}
	}

	public void sortByStudentFirstName() throws Exception {
		if (btnSortByFirstName.isDisplayed()) {
			btnSortByFirstName.click();
			log("Record sorted with student first name in the grid and object is:-" + btnSortByFirstName.toString());
			Thread.sleep(1000);
		} else {
			log("First name element not present.");
		}
	}

	public void minimizeStudentDetails() throws Exception {

		if (btnMin_MaxStudentDetails.isDisplayed()) {
			btnMin_MaxStudentDetails.click();
			log("Student details is minimized and object is:-" + btnMin_MaxStudentDetails.toString());
			Thread.sleep(2000);
		} else {
			log("Minimize student deatils button element not present.");
		}
	}

	public void maximizeStudentAdmissionForm() throws Exception {

		if (btnMin_MaxStudentAdmissionForm.isDisplayed()) {
			btnMin_MaxStudentAdmissionForm.click();
			log("Student admission form is maximized and object is:-" + btnMin_MaxStudentAdmissionForm.toString());
			Thread.sleep(2000);
		} else {
			log("Maximize student admission form button element not present.");
		}
	}

	public void maximizeStudentDetails() throws Exception {

		if (btnMin_MaxStudentDetails.isDisplayed()) {
			btnMin_MaxStudentDetails.click();
			log("Student details is maximized and object is:-" + btnMin_MaxStudentDetails.toString());
			Thread.sleep(2000);
		} else {
			log("Maximize student deatils button element not present.");
		}
	}

	public void clearFilledStudentAdmissionForm() throws Exception {
		if (btn_Clear_Student.isDisplayed()) {
			btn_Clear_Student.click();
			log("Student form filled data is cleared and object is:-" + btn_Clear_Student.toString());
			Thread.sleep(3000);
		} else {
			log("Clear button element not present.");
		}
	}

	public void clickOnNextToSwitchToAddressPage() throws Exception {
		if (btn_Next_Student.isDisplayed()) {
			btn_Next_Student.click();
			log("Clicked on Next Button and page switched to Address page and object is:-"
					+ btn_Next_Student.toString());
			Thread.sleep(10000);
		} else {
			log("Next button element not present.");
		}
	}

	public void clearAllFilledFieldInStudentAdmissionForm() throws Exception {
		if (btn_ClearAll_Student.isDisplayed()) {
			btn_ClearAll_Student.click();
			log("Student form filled all field data is cleared and object is:-" + btn_ClearAll_Student.toString());
			Thread.sleep(15000);
		} else {
			log("Clear all button element not present.");
		}
	}

	public void enterStudentAddressForAdmForm(String StuAddress, String area, String country, String state, String city,
			String pinCode) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (input_Address.isDisplayed()) {
			input_Address.clear();
			input_Address.sendKeys(StuAddress);
			Thread.sleep(1000);
			log("Entered student address: " + StuAddress + " and object is:-" + input_Address.toString());
		} else {
			log("student address element is not present");
		}
		if (input_Area.isDisplayed()) {
			input_Area.clear();
			input_Area.sendKeys(area);
			Thread.sleep(1000);
			log("Entered Area: " + area + " and object is:-" + input_Area.toString());
		} else {
			log("Area element is not present");
		}

		if (sel_Country.isDisplayed()) {
			select = new Select(sel_Country);
			select.selectByVisibleText(country);
			log("selected Country: " + country + " and object is:- " + sel_Country.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), country);
			Thread.sleep(3000);
		} else {
			log("Country element is not present");
		}
		if (sel_State.isDisplayed()) {
			select = new Select(sel_State);
			select.selectByVisibleText(state);
			log("selected state: " + state + " and object is:- " + sel_State.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), state);
			Thread.sleep(3000);
		} else {
			log("state element is not present");
		}
		if (input_City.isDisplayed()) {
			input_City.clear();
			input_City.sendKeys(city);
			Thread.sleep(1000);
			log("Entered city: " + city + " and object is:-" + input_City.toString());
		} else {
			log("city element is not present");
		}
		if (input_PinCode.isDisplayed()) {
			input_PinCode.clear();
			input_PinCode.sendKeys(pinCode);
			Thread.sleep(1000);
			log("Entered pin Code: " + pinCode + " and object is:-" + input_PinCode.toString());
		} else {
			log("pin Code element is not present");
		}

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
		if (btn_Clear_Address.isDisplayed()) {
			btn_Clear_Address.click();
			log("Address filled field data is cleared and object is:-" + btn_Clear_Address.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
		}

	}

	public void clickOnNextToSwitchFromAddressToParentsPage() throws Exception {
		if (btn_Next_Address.isDisplayed()) {
			btn_Next_Address.click();
			log("Clicked on Next Button and page switched to Parents page and object is:-"
					+ btn_Next_Address.toString());
			Thread.sleep(10000);
		} else {
			log("Next button element not present.");
		}

	}

	public void clickOnPreviousButtonToGoBackToStudentPage() throws Exception {

		if (btn_Previous_Address.isDisplayed()) {
			btn_Previous_Address.click();
			log("Clicked on Previous Button and page switched to student page and object is:-"
					+ btn_Previous_Address.toString());
			Thread.sleep(5000);
		} else {
			log("Previous button element not present.");
		}
	}

	public void submitBlankAddressForm() throws Exception {
		if (btn_Next_Address.isDisplayed()) {
			btn_Next_Address.click();
			log("Click on NEXT button to submit blank Address deatils and object is:-" + btn_Next_Address.toString());
			Thread.sleep(3000);
		} else {
			log("Next button is not present.");
		}
	}

	public void selectFatherAliveCheckBox() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		chk_Father_Alive.isDisplayed();

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

		chk_Mother_Alive.isDisplayed();

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

		if (input_MotherName.isDisplayed()) {
			input_MotherName.clear();
			input_MotherName.sendKeys(motherName);
			Thread.sleep(500);
			log("Entered Mother Name: " + motherName + " and object is:-" + input_MotherName.toString());
		} else {
			log("Mother Name element is not present");
		}
		if (input_MotherSurName.isDisplayed()) {
			input_MotherSurName.clear();
			input_MotherSurName.sendKeys(motherSurName);
			Thread.sleep(500);
			log("Entered Mother SurName: " + motherSurName + " and object is:-" + input_MotherSurName.toString());
		} else {
			log("Mother SurName element is not present");
		}
		if (input_Mother_Aadhar.isDisplayed()) {
			input_Mother_Aadhar.clear();
			input_Mother_Aadhar.sendKeys(m_AadharNo);
			Thread.sleep(500);
			log("Entered Mother Aadhar no.: " + m_AadharNo + " and object is:-" + input_Mother_Aadhar.toString());
		} else {
			log("Father Aadhar no. element is not present");
		}
		if (input_Mother_Qualification.isDisplayed()) {
			input_Mother_Qualification.clear();
			input_Mother_Qualification.sendKeys(m_Qualification);
			Thread.sleep(500);
			log("Entered Mother Qualification: " + m_Qualification + " and object is:-"
					+ input_Father_Qualification.toString());
		} else {
			log("Mother Qualification element is not present");
		}
		if (input_Mother_OfficeAddr.isDisplayed()) {
			input_Mother_OfficeAddr.clear();
			input_Mother_OfficeAddr.sendKeys(m_OfficeAddr);
			Thread.sleep(500);
			log("Entered Mother Office Addr: " + m_OfficeAddr + " and object is:-"
					+ input_Mother_OfficeAddr.toString());
		} else {
			log("Mother Office Addr element is not present");
		}
		if (input_Mother_Occupation.isDisplayed()) {
			input_Mother_Occupation.clear();
			input_Mother_Occupation.sendKeys(m_Occupation);
			Thread.sleep(500);
			log("Entered Mother Occupation: " + m_Occupation + " and object is:-" + input_Mother_Occupation.toString());
		} else {
			log("Mother Occupation element is not present");
		}
		if (input_Mother_Designation.isDisplayed()) {
			input_Mother_Designation.clear();
			input_Mother_Designation.sendKeys(m_Designation);
			Thread.sleep(500);
			log("Entered Mother Designation: " + m_Designation + " and object is:-"
					+ input_Mother_Designation.toString());
		} else {
			log("Mother Designation element is not present");
		}
		if (input_Mother_BankAc.isDisplayed()) {
			input_Mother_BankAc.clear();
			input_Mother_BankAc.sendKeys(m_AccountNo);
			Thread.sleep(500);
			log("Entered Mother Account no.: " + m_AccountNo + " and object is:-" + input_Mother_BankAc.toString());
		} else {
			log("Mother Account no. element is not present");
		}
		if (input_Mother_IFSCCode.isDisplayed()) {
			input_Mother_IFSCCode.clear();
			input_Mother_IFSCCode.sendKeys(m_IFSCCode);
			Thread.sleep(500);
			log("Entered Mother IFSC Code: " + m_IFSCCode + " and object is:-" + input_Mother_IFSCCode.toString());
		} else {
			log("Mother IFSC Code element is not present");
		}
		if (input_Mother_CasteCert.isDisplayed()) {
			input_Mother_CasteCert.clear();
			input_Mother_CasteCert.sendKeys(m_CasteCertNo);
			Thread.sleep(500);
			log("Entered Mother Caste Cert: " + m_CasteCertNo + " and object is:-" + input_Mother_CasteCert.toString());
		} else {
			log("Mother Caste Cert element is not present");
		}
		if (sel_Mother_Nationality.isDisplayed()) {
			select = new Select(sel_Mother_Nationality);
			select.selectByVisibleText(m_Nationality);
			Thread.sleep(500);
			log("selected Mother nationality: " + m_Nationality + " and object is:- "
					+ sel_Mother_Nationality.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), m_Nationality);
			Thread.sleep(500);
		} else {
			log("Mother Nationality element is not present");
		}

		if (sel_Mother_Religion.isDisplayed()) {
			select = new Select(sel_Mother_Religion);
			select.selectByVisibleText(m_Religion);
			Thread.sleep(500);
			log("selected Mother Religion: " + m_Religion + " and object is:- " + sel_Mother_Religion.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), m_Religion);
			Thread.sleep(500);
		} else {
			log("Mother Religion element is not present");
		}

		if (sel_Mother_Caste.isDisplayed()) {
			select = new Select(sel_Mother_Caste);
			select.selectByVisibleText(m_Caste);
			Thread.sleep(500);
			log("selected Mother caste: " + m_Caste + " and object is:- " + sel_Mother_Caste.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), m_Caste);
			Thread.sleep(500);
		} else {
			log("Mother Caste element is not present");
		}
		if (input_Mother_SubCaste.isDisplayed()) {
			input_Mother_SubCaste.clear();
			input_Mother_SubCaste.sendKeys(m_SubCaste);
			Thread.sleep(500);
			log("Entered Mother Sub Caste: " + m_SubCaste + " and object is:-" + input_Mother_SubCaste.toString());
		} else {
			log("Mother Sub Caste element is not present");
		}

		if (input_Mother_MonthlyIncome.isDisplayed()) {
			input_Mother_MonthlyIncome.clear();
			input_Mother_MonthlyIncome.sendKeys(m_MonthlyIncome);
			Thread.sleep(500);
			log("Entered Mother monthly income: " + m_MonthlyIncome + " and object is:-"
					+ input_Mother_MonthlyIncome.toString());
		} else {
			log("Mother monthly income element is not present");
		}
		if (input_Mother_AnnualIncome.isDisplayed()) {
			input_Mother_AnnualIncome.clear();
			input_Mother_AnnualIncome.sendKeys(m_AnnualIncome);
			Thread.sleep(500);
			log("Entered Mother Annual income.: " + m_AnnualIncome + " and object is:-"
					+ input_Mother_AnnualIncome.toString());
		} else {
			log("Mother Annual income element is not present");
		}
		if (input_Mother_MobileNum.isDisplayed()) {
			input_Mother_MobileNum.clear();
			input_Mother_MobileNum.sendKeys(m_MobileNumber);
			Thread.sleep(500);
			log("Entered Mother mobile number: " + m_MobileNumber + " and object is:-"
					+ input_Mother_MobileNum.toString());
		} else {
			log("Mother mobile number element is not present");
		}
		if (input_Mother_EmailId.isDisplayed()) {
			input_Mother_EmailId.clear();
			input_Mother_EmailId.sendKeys(m_EmailId);
			Thread.sleep(500);
			log("Entered Mother Email Id: " + m_EmailId + " and object is:-" + input_Mother_EmailId.toString());
		} else {
			log("Mother Email Id element is not present");
		}
	}

	public void enterFatherDetailsInParentsPage(String fatherName, String fatherSurName, String f_AadharNo,
			String f_Qualification, String f_OfficeAddr, String f_Occupation, String f_Designation, String f_AccountNo,
			String f_IFSCCode, String f_CasteCertNo, String f_Nationality, String f_Religion, String f_Caste,
			String f_SubCaste, String f_MonthlyIncome, String f_AnnualIncome, String f_MobileNumber, String f_EmailId)
			throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (input_FatherName.isDisplayed()) {
			input_FatherName.clear();
			input_FatherName.sendKeys(fatherName);
			Thread.sleep(500);
			log("Entered Father Name: " + fatherName + " and object is:-" + input_FatherName.toString());
		} else {
			log("Father Name element is not present");
		}
		if (input_FatherSurName.isDisplayed()) {
			input_FatherSurName.clear();
			input_FatherSurName.sendKeys(fatherSurName);
			Thread.sleep(500);
			log("Entered father SurName: " + fatherSurName + " and object is:-" + input_FatherSurName.toString());
		} else {
			log("Father SurName element is not present");
		}
		if (input_Father_Aadhar.isDisplayed()) {
			input_Father_Aadhar.clear();
			input_Father_Aadhar.sendKeys(f_AadharNo);
			Thread.sleep(500);
			log("Entered Father Aadhar no.: " + f_AadharNo + " and object is:-" + input_Father_Aadhar.toString());
		} else {
			log("Father Aadhar no. element is not present");
		}
		if (input_Father_Qualification.isDisplayed()) {
			input_Father_Qualification.clear();
			input_Father_Qualification.sendKeys(f_Qualification);
			Thread.sleep(500);
			log("Entered father Qualification: " + f_Qualification + " and object is:-"
					+ input_Father_Qualification.toString());
		} else {
			log("Father Qualification element is not present");
		}
		if (input_Father_OfficeAddr.isDisplayed()) {
			input_Father_OfficeAddr.clear();
			input_Father_OfficeAddr.sendKeys(f_OfficeAddr);
			Thread.sleep(500);
			log("Entered Father Office Addr: " + f_OfficeAddr + " and object is:-"
					+ input_Father_OfficeAddr.toString());
		} else {
			log("Father Office Addr element is not present");
		}
		if (input_Father_Occupation.isDisplayed()) {
			input_Father_Occupation.clear();
			input_Father_Occupation.sendKeys(f_Occupation);
			Thread.sleep(500);
			log("Entered Father Occupation: " + f_Occupation + " and object is:-" + input_Father_Occupation.toString());
		} else {
			log("Father Occupation element is not present");
		}
		if (input_Father_Designation.isDisplayed()) {
			input_Father_Designation.clear();
			input_Father_Designation.sendKeys(f_Designation);
			Thread.sleep(500);
			log("Entered father Designation: " + f_Designation + " and object is:-"
					+ input_Father_Designation.toString());
		} else {
			log("Father Designation element is not present");
		}
		if (input_Father_BankAc.isDisplayed()) {
			input_Father_BankAc.clear();
			input_Father_BankAc.sendKeys(f_AccountNo);
			Thread.sleep(500);
			log("Entered Father Account no.: " + f_AccountNo + " and object is:-" + input_Father_BankAc.toString());
		} else {
			log("Father Account no. element is not present");
		}
		if (input_Father_IFSCCode.isDisplayed()) {
			input_Father_IFSCCode.clear();
			input_Father_IFSCCode.sendKeys(f_IFSCCode);
			Thread.sleep(500);
			log("Entered father IFSC Code: " + f_IFSCCode + " and object is:-" + input_Father_IFSCCode.toString());
		} else {
			log("Father IFSC Code element is not present");
		}
		if (input_Father_CasteCert.isDisplayed()) {
			input_Father_CasteCert.clear();
			input_Father_CasteCert.sendKeys(f_CasteCertNo);
			Thread.sleep(500);
			log("Entered Father Caste Cert: " + f_CasteCertNo + " and object is:-" + input_Father_CasteCert.toString());
		} else {
			log("Father Caste Cert element is not present");
		}
		if (sel_Father_Nationality.isDisplayed()) {
			select = new Select(sel_Father_Nationality);
			select.selectByVisibleText(f_Nationality);
			Thread.sleep(500);
			log("selected Father nationality: " + f_Nationality + " and object is:- "
					+ sel_Father_Nationality.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), f_Nationality);
			Thread.sleep(500);
		} else {
			log("Father Nationality element is not present");
		}
		if (sel_Father_Religion.isDisplayed()) {
			select = new Select(sel_Father_Religion);
			select.selectByVisibleText(f_Religion);
			Thread.sleep(500);
			log("selected Father Religion: " + f_Religion + " and object is:- " + sel_Father_Religion.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), f_Religion);
			Thread.sleep(500);
		} else {
			log("Father Religion element is not present");
		}

		if (sel_Father_Caste.isDisplayed()) {
			select = new Select(sel_Father_Caste);
			select.selectByVisibleText(f_Caste);
			Thread.sleep(500);
			log("selected Father caste: " + f_Caste + " and object is:- " + sel_Father_Caste.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), f_Caste);
			Thread.sleep(500);
		} else {
			log("Father Caste element is not present");
		}
		if (input_Father_SubCaste.isDisplayed()) {
			input_Father_SubCaste.clear();
			input_Father_SubCaste.sendKeys(f_SubCaste);
			Thread.sleep(500);
			log("Entered Father Sub Caste: " + f_SubCaste + " and object is:-" + input_Father_SubCaste.toString());
		} else {
			log("Father Sub Caste element is not present");
		}

		if (input_Father_MonthlyIncome.isDisplayed()) {
			input_Father_MonthlyIncome.clear();
			input_Father_MonthlyIncome.sendKeys(f_MonthlyIncome);
			Thread.sleep(500);
			log("Entered father monthly income: " + f_MonthlyIncome + " and object is:-"
					+ input_Father_MonthlyIncome.toString());
		} else {
			log("Father monthly income element is not present");
		}
		if (input_Father_AnnualIncome.isDisplayed()) {
			input_Father_AnnualIncome.clear();
			input_Father_AnnualIncome.sendKeys(f_AnnualIncome);
			Thread.sleep(500);
			log("Entered Father Annual income.: " + f_AnnualIncome + " and object is:-"
					+ input_Father_AnnualIncome.toString());
		} else {
			log("Father Annual income element is not present");
		}
		if (input_Father_MobileNum.isDisplayed()) {
			input_Father_MobileNum.clear();
			input_Father_MobileNum.sendKeys(f_MobileNumber);
			Thread.sleep(500);
			log("Entered father mobile number: " + f_MobileNumber + " and object is:-"
					+ input_Father_MobileNum.toString());
		} else {
			log("Father mobile number element is not present");
		}
		if (input_Father_EmailId.isDisplayed()) {
			input_Father_EmailId.clear();
			input_Father_EmailId.sendKeys(f_EmailId);
			Thread.sleep(500);
			log("Entered Father Email Id: " + f_EmailId + " and object is:-" + input_Father_EmailId.toString());
		} else {
			log("Father Email Id element is not present");
		}
	}

	public void clearFilledParentsDetails() throws Exception {
		if (btn_Clear_Parents.isDisplayed()) {
			btn_Clear_Parents.click();
			log("Parents details filled field data is cleared and object is:-" + btn_Clear_Parents.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
		}

	}

	public void clickOnNextToSwitchFromParentsToOthersPage() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(1000);

		if (btn_Next_Parents.isDisplayed()) {
			btn_Next_Parents.click();
			log("Clicked on Next Button and page switched to Others page and object is:-"
					+ btn_Next_Parents.toString());
			Thread.sleep(10000);
		} else {
			log("Next button element not present.");
		}

	}

	public void clickOnPreviousButtonToGoBackToAddressPage() throws Exception {

		if (btn_Previous_Parents.isDisplayed()) {
			btn_Previous_Parents.click();
			log("Clicked on Previous Button and page switched to Address page and object is:-"
					+ btn_Previous_Parents.toString());
			Thread.sleep(5000);
		} else {
			log("Previous button element not present.");
		}
	}

	public void submitBlankParentsForm() throws Exception {
		if (btn_Next_Parents.isDisplayed()) {
			btn_Next_Parents.click();
			log("Click on NEXT button to submit blank parents deatils and object is:-" + btn_Next_Parents.toString());
			Thread.sleep(3000);
		} else {
			log("Next button is not present.");
		}
	}

	public void selectActivities() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		if (!chk_Activities_Singing.isSelected()) {
			chk_Activities_Singing.click();
			log("Singing activities check box is selected and object is:-" + chk_Activities_Singing.toString());
			Thread.sleep(500);
		} else {
			log("Singing activities check box is already selected and object is:-" + chk_Activities_Singing.toString());
			Thread.sleep(500);
		}

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
		if (input_Achievements.isDisplayed()) {
			input_Achievements.clear();
			input_Achievements.sendKeys(achievements);
			log("Entered achivements: " + achievements + " and object is:-" + input_Achievements.toString());
			Thread.sleep(500);
		} else {
			log("Achievements element is not present.");
		}
	}

	public void selectBondAndFillWithBondNumber(String bondName, String bondNumber) {
		int rows = tbl_BondRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String bondname = driver
					.findElement(By.xpath("(//div[@class='box']/table)[1]/tbody/tr[" + i + "]/td[2]/span")).getText()
					.trim();
			System.out.println("Bond Name: " + bondName);
			// Thread.sleep(2000);
			try {
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

		if (input_SchoolName.isDisplayed()) {
			input_SchoolName.clear();
			input_SchoolName.sendKeys(schoolName);
			log("Entered school name:" + schoolName + " and object is:-" + input_SchoolName.toString());
			Thread.sleep(500);
		} else {
			log("Previous school name element not present.");
		}
		if (sel_SchoolType.isDisplayed()) {
			select = new Select(sel_SchoolType);
			select.selectByVisibleText(schoolType);
			Thread.sleep(500);
			log("selected School Type: " + schoolType + " and object is:- " + sel_SchoolType.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), schoolType);
			Thread.sleep(500);
		} else {
			log("School Type element is not present");
		}

		if (sel_PreClass.isDisplayed()) {
			select = new Select(sel_PreClass);
			select.selectByVisibleText(preClass);
			Thread.sleep(500);
			log("Previous Class: " + preClass + " and object is:- " + sel_PreClass.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), preClass);
			Thread.sleep(500);
		} else {
			log("Previous Class element is not present");
		}
		if (input_Percentage.isDisplayed()) {
			input_Percentage.clear();
			input_Percentage.sendKeys(percentage);
			log("Entered Percentage:" + percentage + " and object is:-" + input_Percentage.toString());
			Thread.sleep(500);
		} else {
			log("Percentage element not present.");
		}

		if (input_Grade.isDisplayed()) {
			input_Grade.clear();
			input_Grade.sendKeys(grade);
			log("Entered Grade:" + grade + " and object is:-" + input_Grade.toString());
			Thread.sleep(500);
		} else {
			log("Grade element not present.");
		}
		if (sel_PassedYr.isDisplayed()) {
			select = new Select(sel_PassedYr);
			select.selectByVisibleText(passedYear);
			Thread.sleep(500);
			log("Passed Year: " + passedYear + " and object is:- " + sel_PassedYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), passedYear);
			Thread.sleep(500);
		} else {
			log("Passed Year element is not present");
		}

		if (input_TotalMarks.isDisplayed()) {
			input_TotalMarks.clear();
			input_TotalMarks.sendKeys(totalMarks);
			log("Entered Total Marks:" + totalMarks + " and object is:-" + input_TotalMarks.toString());
			Thread.sleep(500);
		} else {
			log("Total Marks element not present.");
		}

		if (sel_Board.isDisplayed()) {
			select = new Select(sel_Board);
			select.selectByVisibleText(board);
			Thread.sleep(500);
			log("Board of previous school: " + board + " and object is:- " + sel_Board.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), board);
			Thread.sleep(500);
		} else {
			log("Board element is not present");
		}

		if (sel_PrevCountry.isDisplayed()) {
			select = new Select(sel_PrevCountry);
			select.selectByVisibleText(country);
			Thread.sleep(500);
			log("Country of previous school: " + country + " and object is:- " + sel_PrevCountry.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), country);
			Thread.sleep(500);
		} else {
			log("Country element is not present");
		}

		if (sel_PrevState.isDisplayed()) {
			select = new Select(sel_PrevState);
			select.selectByVisibleText(state);
			Thread.sleep(500);
			log("Prevoius school state: " + state + " and object is:- " + sel_PrevState.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), state);
			Thread.sleep(500);
		} else {
			log("State element is not present");
		}

		if (input_PreAddress.isDisplayed()) {
			input_PreAddress.clear();
			input_PreAddress.sendKeys(address);
			log("Entered Previous school address:" + address + " and object is:-" + input_PreAddress.toString());
			Thread.sleep(500);
		} else {
			log("Previous school address element not present.");
		}
		if (input_LeftReason.isDisplayed()) {
			input_LeftReason.clear();
			input_LeftReason.sendKeys(leftReason);
			log("Entered Reason for leaving:" + leftReason + " and object is:-" + input_LeftReason.toString());
			Thread.sleep(500);
		} else {
			log("left Reason element not present.");
		}
		if (input_Medium.isDisplayed()) {
			input_Medium.clear();
			input_Medium.sendKeys(medium);
			log("Entered medium:" + medium + " and object is:-" + input_Medium.toString());
			Thread.sleep(500);
		} else {
			log("Medium element not present.");
		}
	}

	public void enterGuardianDetails(String guardianName, String guardianAddress, String guardianEmail,
			String guardianPhone) throws Exception {

		if (input_GuardianName.isDisplayed()) {
			input_GuardianName.clear();
			input_GuardianName.sendKeys(guardianName);
			log("Entered Guardian Name:" + guardianName + " and object is:-" + input_GuardianName.toString());
			Thread.sleep(500);
		} else {
			log("Guardian Name element not present.");
		}
		if (input_GuardianAddress.isDisplayed()) {
			input_GuardianAddress.clear();
			input_GuardianAddress.sendKeys(guardianAddress);
			log("Entered guardian address:" + guardianAddress + " and object is:-" + input_GuardianAddress.toString());
			Thread.sleep(500);
		} else {
			log("Guardian Address element not present.");
		}
		if (input_GuardianEmail.isDisplayed()) {
			input_GuardianEmail.clear();
			input_GuardianEmail.sendKeys(guardianEmail);
			log("Entered Guardian Email:" + guardianEmail + " and object is:-" + input_GuardianEmail.toString());
			Thread.sleep(500);
		} else {
			log("Guardian Email element not present.");
		}
		if (input_GuardianPhone.isDisplayed()) {
			input_GuardianPhone.clear();
			input_GuardianPhone.sendKeys(guardianPhone);
			log("Entered Guardian Phone:" + guardianPhone + " and object is:-" + input_GuardianPhone.toString());
			Thread.sleep(500);
		} else {
			log("Guardian phone element not present.");
		}
	}

	public void uploadGuardianPhoto() throws Exception {
		if (upload_GuardianPhoto.isDisplayed()) {
			imageAndDocumentUpload(upload_GuardianPhoto, "Guardian.jpg");
			log("Guardian image uploaded successfully");
			Thread.sleep(5000);
		} else {
			log("Guardian photo upload button element is not present.");
		}

	}

	public void uploadGuardianSignature() throws Exception {
		if (upload_GuardianPhoto.isDisplayed()) {
			imageAndDocumentUpload(upload_GuardianSign, "signature.jpg");
			log("Guardian signature image uploaded successfully");
			Thread.sleep(5000);
		} else {
			log("Guardian sign photo upload button element is not present.");
		}
	}

	public void uploadGuardianFingerPrint() throws Exception {
		if (upload_GuardianPhoto.isDisplayed()) {
			imageAndDocumentUpload(upload_GuardianFingerPrint, "fingerPrint.jpg");
			log("Guardian Finger print image uploaded successfully");
			Thread.sleep(5000);
		} else {
			log("Guardian finger print photo upload button element is not present.");
		}
	}

	public void viewUploadedGuardianPhoto() throws Exception {
		if (view_GuardianPhoto.isDisplayed()) {
			view_GuardianPhoto.click();
			log("clicked on photo view button and object is:-" + view_GuardianPhoto.toString());
			Thread.sleep(500);
		} else {
			log("photo view button element is not present.");
		}
	}

	public void viewUploadedGuardianSign() throws Exception {
		if (view_GuardianSign.isDisplayed()) {
			view_GuardianSign.click();
			log("clicked on sign view button and object is:-" + view_GuardianSign.toString());
			Thread.sleep(500);
		} else {
			log("Sign view button element is not present.");
		}
	}

	public void viewUploadedGuardianFingerPrint() throws Exception {
		if (view_GuardianFingerPrint.isDisplayed()) {
			view_GuardianFingerPrint.click();
			log("clicked on Finger Print view button and object is:-" + view_GuardianFingerPrint.toString());
			Thread.sleep(500);
		} else {
			log("Finger Print view button element is not present.");
		}
	}

	public void closeOpenedUploadedImagePopUp() throws Exception {
		if (btn_View_Close.isDisplayed()) {
			btn_View_Close.click();
			log("Closed opened uploaded image pop up and object is:-" + btn_View_Close.toString());
			Thread.sleep(1000);
		} else {
			log("View pop up close button element is not present.");
		}
	}

	public void enterSiblingDetails(String siblingName, String siblingClass, String siblingRelation) throws Exception {

		if (input_SiblingName.isDisplayed()) {
			input_SiblingName.clear();
			input_SiblingName.sendKeys(siblingName);
			log("Entered Sibling Name:" + siblingName + " and object is:-" + input_SiblingName.toString());
			Thread.sleep(500);
		} else {
			log("Sibling Name element not present.");
		}
		if (sel_sibClass.isDisplayed()) {
			select = new Select(sel_sibClass);
			select.selectByVisibleText(siblingClass);
			Thread.sleep(500);
			log("Sibling class: " + siblingClass + " and object is:- " + sel_sibClass.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), siblingClass);
			Thread.sleep(500);
		} else {
			log("Sibling class element is not present");
		}

		if (input_Relation.isDisplayed()) {
			input_Relation.clear();
			input_Relation.sendKeys(siblingRelation);
			log("Entered Sibling Marks:" + siblingRelation + " and object is:-" + input_Relation.toString());
			Thread.sleep(500);
		} else {
			log("Sibling Relation element not present.");
		}
	}

	public void clearFilledOthersDetails() throws Exception {
		if (btn_Clear_Others.isDisplayed()) {
			btn_Clear_Others.click();
			log("Others details filled field data is cleared and object is:-" + btn_Clear_Others.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
		}

	}

	public void clickOnNextToSwitchFromOthersToDocumentsPage() throws Exception {
		if (btn_Next_Others.isDisplayed()) {
			btn_Next_Others.click();
			log("Clicked on Next Button and page switched to Documents page and object is:-"
					+ btn_Next_Others.toString());
			Thread.sleep(10000);
		} else {
			log("Next button element not present.");
		}

	}

	public void clickOnPreviousButtonToGoBackToParentsPage() throws Exception {

		if (btn_Previous_Others.isDisplayed()) {
			btn_Previous_Others.click();
			log("Clicked on Previous Button and page switched to Parents page and object is:-"
					+ btn_Previous_Others.toString());
			Thread.sleep(5000);
		} else {
			log("Previous button element not present.");
		}
	}

	public void submitBlankOthersForm() throws Exception {
		if (btn_Next_Others.isDisplayed()) {
			btn_Next_Others.click();
			log("Click on NEXT button to submit blank Others deatils and object is:-" + btn_Next_Parents.toString());
			Thread.sleep(3000);
		} else {
			log("Next button is not present.");
		}
	}

	public void uploadDocumentCorrepondingToDocumentName(String documentName) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				txtAdmissionForm_StuAdmFormMsgDispaly);
		Thread.sleep(2000);

		int rowsDoc = tbl_DocumentRows.size();
		System.out.println(rowsDoc);
		// Thread.sleep(2000);
		for (int i = 1; i <= rowsDoc; i++) {
			String documentname = driver
					.findElement(By.xpath(
							"(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr[" + i + "]/td[2]"))
					.getText().trim();
			System.out.println("Document Name: " + documentname);
			// Thread.sleep(2000);
			try {
				if (documentname.equalsIgnoreCase(documentName)) {

					WebElement uploaddocument = driver.findElement(
							By.xpath("(//table[@class='table table-responsive table-bordered'])[5]/tbody/tr[" +i+ "]/td[3]/label"));
					
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
		if (btn_Clear_Document.isDisplayed()) {
			btn_Clear_Document.click();
			log("Documents details filled field data is cleared and object is:-" + btn_Clear_Document.toString());
			Thread.sleep(5000);
		} else {
			log("Clear button element not present.");
		}

	}

	public void clickOnSubmitButton_Documents() throws Exception {
		if (btn_Submit_Document.isDisplayed()) {
			btn_Submit_Document.click();
			log("Clicked on Submit Button and object is:-" + btn_Submit_Document.toString());
			Thread.sleep(10000);
		} else {
			log("Submit button element not present.");
		}

	}

	public void clickOnPreviousButtonToGoBackToOthersPage() throws Exception {

		if (btn_Previous_Document.isDisplayed()) {
			btn_Previous_Document.click();
			log("Clicked on Previous Button and page switched to Others page and object is:-"
					+ btn_Previous_Document.toString());
			Thread.sleep(5000);
		} else {
			log("Previous button element not present.");
		}
	}

	public void requiredDetailsInDocumentsPage() throws Exception {
		if (!chk_Hostel_Required.isSelected()) {
			chk_Hostel_Required.click();
			log("Hostel required check box is checked and object is:-" + chk_Hostel_Required.toString());
			Thread.sleep(500);
		} else {
			log("Hostel required check box is already checked and object is:-" + chk_Hostel_Required.toString());
			Thread.sleep(500);
		}

		if (!chk_Transport_Required.isSelected()) {
			chk_Transport_Required.click();
			log("Transport required check box is checked and object is:-" + chk_Transport_Required.toString());
			Thread.sleep(500);
		} else {
			log("Transport required check box is already checked and object is:-" + chk_Transport_Required.toString());
			Thread.sleep(500);
		}

		if (!chk_Gym_Required.isSelected()) {
			chk_Gym_Required.click();
			log("Gym required check box is checked and object is:-" + chk_Gym_Required.toString());
			Thread.sleep(500);
		} else {
			log("Gym required check box is already checked and object is:-" + chk_Gym_Required.toString());
			Thread.sleep(500);
		}

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
		if (upload_Father_Photo.isDisplayed()) {
			imageAndDocumentUpload(upload_Father_Photo, "Photo.jpg");
			log("Father image uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Father photo upload button element is not present.");
		}
	}

	public void uploadFatherSign() throws Exception {
		if (upload_Father_Sign.isDisplayed()) {
			imageAndDocumentUpload(upload_Father_Sign, "signature.jpg");
			log("Father signature uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Father signature upload button element is not present.");
		}
	}

	public void uploadFatherFingerPrint() throws Exception {
		if (upload_Father_FingerPrint.isDisplayed()) {
			imageAndDocumentUpload(upload_Father_FingerPrint, "fingerPrint.jpg");
			log("Father finger Print uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Father finger Print upload button element is not present.");
		}
	}

	public void viewUploadedFatherPhoto() throws Exception {
		if (view_Father_Photo.isDisplayed()) {
			view_Father_Photo.click();
			log("clicked on father photo view button and object is:-" + view_Father_Photo.toString());
			Thread.sleep(500);
		} else {
			log("Father photo view button element is not present.");
		}
	}

	public void viewUploadedFatherSign() throws Exception {
		if (view_Father_Sign.isDisplayed()) {
			view_Father_Sign.click();
			log("clicked on father Sign view button and object is:-" + view_Father_Sign.toString());
			Thread.sleep(500);
		} else {
			log("Father Sign view button element is not present.");
		}
	}

	public void viewUploadedFatherFingerPrint() throws Exception {
		if (view_Father_FingerPrint.isDisplayed()) {
			view_Father_FingerPrint.click();
			log("clicked on father Finger Print view button and object is:-" + view_Father_FingerPrint.toString());
			Thread.sleep(500);
		} else {
			log("Father Finger Print view button element is not present.");
		}
	}

	public void uploadMotherPhoto() throws Exception {
		if (upload_Mother_Photo.isDisplayed()) {
			imageAndDocumentUpload(upload_Mother_Photo, "SchoolGirl.jpg");
			log("Mother image uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Mother photo upload button element is not present.");
		}
	}

	public void uploadMotherSign() throws Exception {
		if (upload_Mother_Sign.isDisplayed()) {
			imageAndDocumentUpload(upload_Mother_Sign, "signature.jpg");
			log("Mother signature uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Mother signature upload button element is not present.");
		}
	}

	public void uploadMotherFingerPrint() throws Exception {
		if (upload_Mother_FingerPrint.isDisplayed()) {
			imageAndDocumentUpload(upload_Mother_FingerPrint, "fingerPrint.jpg");
			log("Mother finger Print uploaded successfully");
			Thread.sleep(2000);
		} else {
			log("Mother finger Print upload button element is not present.");
		}
	}

	public void viewUploadedMotherPhoto() throws Exception {
		if (view_Mother_Photo.isDisplayed()) {
			view_Mother_Photo.click();
			log("clicked on Mother photo view button and object is:-" + view_Mother_Photo.toString());
			Thread.sleep(500);
		} else {
			log("Mother photo view button element is not present.");
		}
	}

	public void viewUploadedMotherSign() throws Exception {
		if (view_Mother_Sign.isDisplayed()) {
			view_Mother_Sign.click();
			log("clicked on Mother Sign view button and object is:-" + view_Mother_Sign.toString());
			Thread.sleep(500);
		} else {
			log("Mother Sign view button element is not present.");
		}
	}

	public void viewUploadedMotherFingerPrint() throws Exception {
		if (view_Mother_FingerPrint.isDisplayed()) {
			view_Mother_FingerPrint.click();
			log("clicked on Mother Finger Print view button and object is:-" + view_Mother_FingerPrint.toString());
			Thread.sleep(500);
		} else {
			log("Mother Finger Print view button element is not present.");
		}
	}
	
	
	public void clickOnOkSuccessButton() throws Exception {
		if(btnOKSuccess.isDisplayed()){
		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
		}else{
			log("Ok button Element not present.");
		}
	}

}
