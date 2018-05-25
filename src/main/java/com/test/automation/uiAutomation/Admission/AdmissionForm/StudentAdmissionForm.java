/**
 * 
 */
package com.test.automation.uiAutomation.Admission.AdmissionForm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class StudentAdmissionForm extends TestBase {

	public static final Logger log = Logger.getLogger(StudentAdmissionForm.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;
	/**
	 * Admission from Student section locators
	 */
	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btnAdmission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Admission Form')][1]")
	WebElement btnAdmissionForm;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Admission Form')][1]/following::ul[1]")
	WebElement btnStudentAdmissionForm;

	@FindBy(xpath = "(//input[@id='usr'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@id='usr'])[2]")
	WebElement middleName;

	@FindBy(xpath = "(//input[@id='usr'])[3]")
	WebElement lastName;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement academicYear;

	@FindBy(xpath = "(//input[@id='reservation'])[1]")
	WebElement regNo;

	@FindBy(xpath = "(//input[@id='reservation'])[2]")
	WebElement admNo;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selClassToAdm;

	@FindBy(xpath = "(//button[contains(@aria-label,'Open calendar')])[1]")
	WebElement dateOfAdm;

	@FindBy(xpath = "(//button[contains(@aria-label,'Open calendar')])[2]")
	WebElement dateofBirth;

	@FindBy(xpath = "(//input[@id='reservation'])[3]")
	WebElement dobInWord;

	@FindBy(xpath = "(//select[@id='sel1'])[3]")
	WebElement selCasteCategory;

	@FindBy(xpath = "(//select[@id='sel1'])[4]")
	WebElement selCaste;

	@FindBy(xpath = "(//input[@id='usr'])[4]")
	WebElement bankIfscCode;

	@FindBy(xpath = "(//input[@id='usr'])[5]")
	WebElement birthPlace;

	@FindBy(xpath = "(//input[@id='usr'])[6]")
	WebElement birthCertificateNo;

	@FindBy(xpath = "(//input[@id='usr'])[7]")
	WebElement casteCertificateNo;

	@FindBy(xpath = "(//input[@id='reservation'])[4]")
	WebElement lblAge;

	@FindBy(xpath = "(//select[@id='sel1'])[5]")
	WebElement gender;

	@FindBy(xpath = "(//input[@id='reservation'])[5]")
	WebElement motherTongue;

	@FindBy(xpath = "(//select[@id='sel1'])[6]")
	WebElement religion;

	@FindBy(xpath = "(//select[@id='sel1'])[7]")
	WebElement nationality;

	@FindBy(xpath = "(//input[@id='reservation'])[6]")
	WebElement mobileNumber;

	@FindBy(xpath = "(//input[@id='reservation'])[7]")
	WebElement emailId;

	@FindBy(xpath = "(//input[@id='usr'])[8]")
	WebElement aadharNo;

	@FindBy(xpath = "(//select[@id='sel1'])[8]")
	WebElement bloodGroup;

	@FindBy(xpath = "(//select[@id='sel1'])[9]")
	WebElement studentCategory;

	@FindBy(xpath = "(//input[@id='usr'])[9]")
	WebElement studentBankACNo;

	@FindBy(xpath = "//span[contains(text(),'BPL Card No.')]")
	WebElement chkBPLcardNo;

	@FindBy(xpath = "(//input[@id='usr'])[10]")
	WebElement bplCardNo;

	@FindBy(xpath = "(//select[@id='sel1'])[10]")
	WebElement selFeeConcessionType;

	@FindBy(xpath = "(//span[contains(text(),'   Next ')])[1]")
	WebElement next_ButtonStudent;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[1]")
	WebElement uploadimage;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement ageConfirm;

	/**
	 * Admission form Address section
	 */
	@FindBy(xpath = "(//input[@id='usr'])[11]")
	WebElement enterAddress;

	@FindBy(xpath = "(//input[@id='usr'])[12]")
	WebElement enterArea;

	@FindBy(xpath = "(//select[@id='sel1'])[12]")
	WebElement selState;

	@FindBy(xpath = "(//select[@id='sel1'])[11]")
	WebElement selCountry;

	@FindBy(xpath = "(//input[@id='usr'])[13]")
	WebElement enterCity;

	@FindBy(xpath = "(//input[@id='usr'])[14]")
	WebElement enterPin;

	@FindBy(xpath = "//span[contains(text(),'Same As Permanent Address')]")
	WebElement chk_mapPermanentTocommAddress;

	@FindBy(xpath = "(//span[contains(text(),'   Next ')])[2]")
	WebElement next_ButtonAddress;

	/**
	 * Admission form parent page Father's details
	 */
	@FindBy(xpath = "(//span[contains(text(),'Alive')])[1]")
	WebElement chkFatherAlive;

	@FindBy(xpath = "(//input[@id='usr'])[19]")
	WebElement enterfatherName;

	@FindBy(xpath = "(//input[@id='usr'])[20]")
	WebElement enterFatherSurname;

	@FindBy(xpath = "(//input[@id='usr'])[21]")
	WebElement enterFatherAadhar;

	@FindBy(xpath = "(//input[@id='usr'])[22]")
	WebElement enterfatherQualification;

	@FindBy(xpath = "(//textarea[@id='comment'])[1]")
	WebElement fatherofficeAddr;

	@FindBy(xpath = "(//input[@id='usr'])[23]")
	WebElement fatherOccupation;

	@FindBy(xpath = "(//input[@id='usr'])[24]")
	WebElement fatherDesignation;

	@FindBy(xpath = "(//input[@id='usr'])[25]")
	WebElement fatherbankAccNo;

	@FindBy(xpath = "(//input[@id='usr'])[26]")
	WebElement fatherBankIfsc;

	@FindBy(xpath = "(//input[@id='usr'])[27]")
	WebElement fatherCasteCert;

	@FindBy(xpath = "(//select[@id='sel1'])[15]")
	WebElement fatherNationality;

	@FindBy(xpath = "(//input[@id='usr'])[28]")
	WebElement fatherMonthlyIncome;

	@FindBy(xpath = "(//input[@id='usr'])[29]")
	WebElement fatherAnnualIncome;

	@FindBy(xpath = "(//input[@id='reservation'])[8]")
	WebElement fatherMobileNumber;

	@FindBy(xpath = "(//input[@id='reservation'])[9]")
	WebElement fatherEmailId;

	/**
	 * Admission form parent page mother's details
	 */
	@FindBy(xpath = "(//span[contains(text(),'Alive')])[2]")
	WebElement chkMotherAlive;

	@FindBy(xpath = "(//input[@id='usr'])[30]")
	WebElement entermotherName;

	@FindBy(xpath = "(//input[@id='usr'])[31]")
	WebElement enterMotherSurname;

	@FindBy(xpath = "(//input[@id='usr'])[32]")
	WebElement enterMotherAadhar;

	@FindBy(xpath = "(//input[@id='usr'])[33]")
	WebElement enterMotherQualification;

	@FindBy(xpath = "(//textarea[@id='comment'])[2]")
	WebElement motherofficeAddr;

	@FindBy(xpath = "(//input[@id='usr'])[34]")
	WebElement motherOccupation;

	@FindBy(xpath = "(//input[@id='usr'])[35]")
	WebElement motherDesignation;

	@FindBy(xpath = "(//input[@id='usr'])[36]")
	WebElement motherbankAccNo;

	@FindBy(xpath = "(//input[@id='usr'])[37]")
	WebElement motherBankIfsc;

	@FindBy(xpath = "(//input[@id='usr'])[38]")
	WebElement motherCasteCert;

	@FindBy(xpath = "(//select[@id='sel1'])[16]")
	WebElement motherNationality;

	@FindBy(xpath = "(//input[@id='usr'])[39]")
	WebElement motherMonthlyIncome;

	@FindBy(xpath = "(//input[@id='usr'])[40]")
	WebElement motherAnnualIncome;

	@FindBy(xpath = "(//input[@id='reservation'])[10]")
	WebElement motherMobileNumber;

	@FindBy(xpath = "(//input[@id='reservation'])[11]")
	WebElement motherEmailId;

	@FindBy(xpath = "(//span[contains(text(),'   Next ')])[3]")
	WebElement next_ButtonParent;

	/**
	 * Calendar
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/md-datepicker/button)[2]")
	WebElement calendarButton;

	@FindBy(css = ".md-calendar-month-label")
	WebElement leftMonthYear;

	@FindBy(css = ".md-calendar-month-label")
	List<WebElement> leftYear;

	@FindBy(css = ".md-calendar-date-selection-indicator")
	List<WebElement> month;

	@FindBy(css = ".md-calendar-date-selection-indicator")
	List<WebElement> days;
	/**
	 * Others activities
	 */
	@FindBy(xpath = "(//label[@class='ng-scope'])[1]")
	WebElement activitiesSports;

	@FindBy(xpath = "(//label[@class='ng-scope'])[5]")
	WebElement activitiesDance;

	@FindBy(xpath = "(//label[@class='ng-scope'])[6]")
	WebElement activitiesSinging;
	/**
	 * Others Reference details
	 */
	@FindBy(xpath = "(//span[contains(text(),'Friends')])[1]")
	WebElement referenceFriend;

	@FindBy(xpath = "(//span[contains(text(),'Principal')])[1]")
	WebElement referPricipal;

	@FindBy(xpath = "(//span[contains(text(),'Vice Principal')])[1]")
	WebElement refVicePrincipal;

	/**
	 * Others source details
	 */
	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]//div//md-pagination-wrapper/md-tab-item[4]")
	WebElement btnOthers;

	@FindBy(xpath = "//span[contains(text(),'Internet')]")
	WebElement sourceInternet;

	@FindBy(xpath = "//span[contains(text(),'Social Mediaa')]")
	WebElement srcSocialMedia;

	@FindBy(xpath = "(//span[contains(text(),'Susdiny')])[1]")
	WebElement srcSusdiny;

	@FindBy(xpath = "(//textarea[@id='comment'])[3]")
	WebElement achivementTextField;
	/**
	 * Bond deatils
	 */
	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[1]")
	WebElement chkFirstBond;

	@FindBy(xpath = "(//input[@id='bondNo'])[1]")
	WebElement firstBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[2]")
	WebElement chkBONDII;

	@FindBy(xpath = "(//input[@id='bondNo'])[2]")
	WebElement iiBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[3]")
	WebElement chkBONDIII;

	@FindBy(xpath = "(//input[@id='bondNo'])[3]")
	WebElement iiiBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[4]")
	WebElement chkBONDFour;

	@FindBy(xpath = "(//input[@id='bondNo'])[4]")
	WebElement fourBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[5]")
	WebElement chkBONDV;

	@FindBy(xpath = "(//input[@id='bondNo'])[5]")
	WebElement vBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[6]")
	WebElement chkBONDVI;

	@FindBy(xpath = "(//input[@id='bondNo'])[6]")
	WebElement viBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[7]")
	WebElement chkbondI;

	@FindBy(xpath = "(//input[@id='bondNo'])[7]")
	WebElement ibondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[8]")
	WebElement chkbondVII;

	@FindBy(xpath = "(//input[@id='bondNo'])[8]")
	WebElement viibondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[9]")
	WebElement rationCard;

	@FindBy(xpath = "(//input[@id='bondNo'])[9]")
	WebElement rationcardTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[10]")
	WebElement chkaadharcard;

	@FindBy(xpath = "(//input[@id='bondNo'])[10]")
	WebElement aadharcardTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[11]")
	WebElement chkPancard;

	@FindBy(xpath = "(//input[@id='bondNo'])[11]")
	WebElement panCardTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[12]")
	WebElement chkBbmp;

	@FindBy(xpath = "(//input[@id='bondNo'])[12]")
	WebElement bbmpTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[13]")
	WebElement hdfcBondCard;

	@FindBy(xpath = "(//input[@id='bondNo'])[13]")
	WebElement hdfcBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[14]")
	WebElement chkDD;

	@FindBy(xpath = "(//input[@id='bondNo'])[14]")
	WebElement ddTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[15]")
	WebElement chkSportsbond;

	@FindBy(xpath = "(//input[@id='bondNo'])[15]")
	WebElement sportsBondTextField;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[1]/tbody/tr/td[2]/input)[16]")
	WebElement chkGreatBond;

	@FindBy(xpath = "(//input[@id='bondNo'])[16]")
	WebElement greatBondTextField;
	//
	@FindBy(xpath = "//*[@id='style-4']/ui-view/div[1]/div/ui-view/section/div[1]/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]")
	WebElement others;

	@FindBy(xpath = "//*[@id='style-4']/ui-view/div[1]/div/ui-view/section/div[1]/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]")
	WebElement parents;

	/**
	 * Previous school details
	 */
	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[2]/input")
	WebElement schoolNamePrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[3]/select")
	WebElement selschoolTypePrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[4]/select")
	WebElement selClassPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[5]/input")
	WebElement percentagePrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[6]/input")
	WebElement gradePrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[7]/select")
	WebElement passedYearPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[8]/input")
	WebElement totalMarksPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[9]/select")
	WebElement boardsPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[10]/select")
	WebElement countryPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[11]/select")
	WebElement statePrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[12]/input")
	WebElement addressPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[13]/input")
	WebElement leftReasonPrev;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[14]/input")
	WebElement mediumPrev;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[2]/tbody/tr/td[15]/span)[1]")
	WebElement plusSymbolPrev;

	/**
	 * Guardian details
	 */
	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[2]/input")
	WebElement guardianNameText;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[3]/input")
	WebElement guardianAddressText;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[4]/input")
	WebElement guardianMailText;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[5]/input")
	WebElement guardianPhoneNum;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[6]/input")
	WebElement uploadguardianPhoto;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[7]/input")
	WebElement uploadguardianSign;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[8]/input")
	WebElement uploadguardianFinPrint;

	@FindBy(xpath = "(//a[contains(text(),'view')])[1]")
	WebElement btnViewimagePhoto;

	@FindBy(xpath = "(//a[contains(text(),'view')])[2]")
	WebElement btnViewimageSign;

	@FindBy(xpath = "(//a[contains(text(),'view')])[3]")
	WebElement btnViewimageFinPrint;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement verifyImagePopup;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[3]/tbody/tr[1]/td[9]/span)[1]")
	WebElement tblGuardianPlus;

	/**
	 * siblings Details
	 */

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[4]/tbody/tr[1]/td[2]/input")
	WebElement tblSiblingName;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[4]/tbody/tr[1]/td[3]/select")
	WebElement tblSiblingClass;

	@FindBy(xpath = "(//table[@class='table table-responsive table-bordered'])[4]/tbody/tr[1]/td[4]/input")
	WebElement tblSiblingRelation;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[4]/tbody/tr[1]/td[5]/span)[1]")
	WebElement tblSiblingPlus;

	@FindBy(xpath = "(//span[contains(text(),'   Next ')])[4]")
	WebElement next_ButtonOthers;

	/**
	 * Documents upload for student admission form
	 *
	 */
	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[1]/label")
	WebElement tcDocUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[2]/label")
	WebElement BirthCertUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[3]/label")
	WebElement markSheetUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[4]/label")
	WebElement aadharDocUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[5]/label")
	WebElement residentialUpload1;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[6]/label")
	WebElement residentialUpload2;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[7]/label")
	WebElement incomeCertUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[8]/label")
	WebElement idProofUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[9]/label")
	WebElement FormIUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[10]/label")
	WebElement Form2Upload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[11]/label")
	WebElement Form4testUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[12]/label")
	WebElement conductCertUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[13]/label")
	WebElement testadasdUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[14]/label")
	WebElement pansUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[15]/label")
	WebElement addressProofUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[16]/label")
	WebElement passportUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[17]/label")
	WebElement DLUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[18]/label")
	WebElement transferCertUpload;

	@FindBy(xpath = "((//table[@class='table table-responsive table-bordered'])[5]//tbody/tr/td[3])[19]/label")
	WebElement importantCertUpload;

	/**
	 * Document upload page required details
	 */
	@FindBy(xpath = "//span[contains(text(),'Hostel Required')]")
	WebElement chkHostelReq;

	@FindBy(xpath = "//span[contains(text(),'Transport Required')]")
	WebElement chkTransportReq;

	@FindBy(xpath = "//span[contains(text(),'Gym Required')]")
	WebElement chkGymReq;

	@FindBy(xpath = "//span[contains(text(),'ECS')]")
	WebElement chkEcsReq;
	/**
	 * Photo Upload[Only JPEG Files (0-2MB)], Submit, Clear and ClearAll button
	 */
	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[21]")
	WebElement fatherPhotoUpload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[1]")
	WebElement btnViewFPhoto;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[22]")
	WebElement fathersignUpload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[2]")
	WebElement btnViewFSign;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[23]")
	WebElement fatherFinPrintupload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[3]")
	WebElement btnViewFFinPrint;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[24]")
	WebElement motherPhotoUpload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[4]")
	WebElement btnViewMPhoto;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[25]")
	WebElement mothersignUpload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[5]")
	WebElement btnViewMSign;

	@FindBy(xpath = "(//label[@class='custom-file-input file-blue'])[26]")
	WebElement motherFinPrintupload;

	@FindBy(xpath = "(//span[@class='ng-scope']/a)[6]")
	WebElement btnViewMFinPrint;

	@FindBy(xpath = "(//button[contains(text(),'Close')])[1]")
	WebElement btnPopUpClose;

	@FindBy(xpath = "(//div[@class='text-center ng-scope']/button)[2]")
	WebElement btnSubmit;

	@FindBy(xpath = "(//div[@class='text-center ng-scope']/button)[3]")
	WebElement btnClear;

	@FindBy(xpath = "(//div[@class='text-center']/button)[13]")
	WebElement btnClearAll;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement SuccessMsg;

	@FindBy(xpath = "(//div[@class='text-center']/button)[13]")
	WebElement btnSuccessOK;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public StudentAdmissionForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToStudentAdmForm() throws Exception {
		if (btnAdmission.isDisplayed()) {
			btnAdmission.click();
			log("Clicked on admission button and object is:-" + btnAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
			Thread.sleep(1000);
		}
		if (btnAdmissionForm.isDisplayed()) {
			btnAdmissionForm.click();
			log("Clicked on admission form button and object is:-" + btnAdmissionForm.toString());
			Thread.sleep(1000);
		} else {
			log("Element not present.");
			Thread.sleep(1000);
		}
		if (btnStudentAdmissionForm.isDisplayed()) {
			btnStudentAdmissionForm.click();
			log("Clicked on student admission form button and object is:-" + btnStudentAdmissionForm.toString());
			Thread.sleep(5000);
		} else {
			log("Element not present.");
			Thread.sleep(1000);
		}
		// WebElement uploadDoc =
		// driver.findElement(By.xpath("//*[@id='style-4']/ui-view/div[1]/div/ui-view/section/div[1]/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span"));
		// uploadDoc.click();
		imageAndDocumentUpload(uploadimage, "Photo.jpg");
		log("Student image uploaded successfully");
		Thread.sleep(3000);
	}

	public void studentAdmissionFormStudentSection(String FirstName, String MiddleName, String LastName, String RegNo,
			String AdmNo, String classToAdm, String casteCatg, String Caste, String BankIFSC, String BirthPlace,
			String BirthCert, String casteCert, String Gender, String MotherTongue, String Religion, String Nationality,

			String MobNo, String Email, String AadharNo, String BloodGr, String StBankAC, String BPLCardNo,
			String Feeconcession) throws Exception {

		firstName.sendKeys(FirstName);
		log("entered first name:-" + FirstName + " and object is " + firstName.toString());
		Thread.sleep(1000);
		middleName.sendKeys(MiddleName);
		log("entered middle name:-" + MiddleName + " and object is " + middleName.toString());
		Thread.sleep(1000);
		lastName.sendKeys(LastName);
		log("entered lastname:-" + LastName + " and object is " + lastName.toString());
		Thread.sleep(1000);
//		regNo.sendKeys(RegNo);
//		log("entered registration number:-" + RegNo + " and object is " + regNo.toString());
//		Thread.sleep(2000);
		admNo.sendKeys(AdmNo);
		log("entered admission number:-" + AdmNo + " and object is " + admNo.toString());
		Thread.sleep(2000);

		select = new Select(selClassToAdm);
		select.selectByVisibleText(classToAdm);
		log("selected class:-" + classToAdm + " and object is " + selClassToAdm.toString());
		Thread.sleep(5000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), classToAdm);
		Thread.sleep(1000);

		calendarButton.click();
		log("cliked on calendar button and object is:-" + calendarButton.toString());
		Thread.sleep(2000);
		leftMonthYear.click();
		log("cliked on left side of calendar month year button and object is:-" + leftMonthYear.toString());
		Thread.sleep(2000);
		// ((JavascriptExecutor)driver).executeScript("arguments[0].value='08-05-2015'",
		// datefield);

		selectDate(leftYear, month, days, "2015", "May", "20");
		ageConfirm.click();
		log("Clicked on age confirrmation pop up message.");
		
		boolean status = dobInWord.isDisplayed();
		Assert.assertEquals(status, true);

		select = new Select(selCasteCategory);
		select.selectByVisibleText(casteCatg);
		log("selected caste category:-" + casteCatg + " and object is " + selCasteCategory.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), casteCatg);
		Thread.sleep(1000);
		
		select = new Select(selCaste);
		select.selectByVisibleText(Caste);
		log("selected caste:-" + Caste + " and object is " + selCaste.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Caste);
		Thread.sleep(1000);
		
		bankIfscCode.sendKeys(BankIFSC);
		log("entered student bank IFSC number:-" + BankIFSC + " and object is " + bankIfscCode.toString());
		Thread.sleep(1000);
		birthPlace.sendKeys(BirthPlace);
		log("entered student birth place:-" + birthPlace + " and object is " + birthPlace.toString());
		Thread.sleep(1000);
		birthCertificateNo.sendKeys(BirthCert);
		log("entered birth certificate number:-" + BirthCert + " and object is " + birthCertificateNo.toString());
		Thread.sleep(1000);
		casteCertificateNo.sendKeys(casteCert);
		log("entered caste certificate number:-" + casteCert + " and object is " + casteCertificateNo.toString());
		Thread.sleep(2000);

		select = new Select(gender);
		select.selectByVisibleText(Gender);
		log("selected gender:-" + Gender + " and object is " + gender.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Gender);
		Thread.sleep(1000);
		
		motherTongue.sendKeys(MotherTongue);
		log("entered mother tongue:-" + MotherTongue + " and object is " + motherTongue.toString());
		Thread.sleep(1000);
		select = new Select(religion);
		select.selectByVisibleText(Religion);
		log("selected religion:-" + Religion + " and object is " + religion.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Religion);
		Thread.sleep(1000);
		
		select = new Select(nationality);
		select.selectByVisibleText(Nationality);
		log("selected natinality:-" + Nationality + " and object is " + nationality.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Nationality);
		Thread.sleep(1000);
		
		mobileNumber.sendKeys(MobNo);
		log("entered mobile number:-" + MobNo + " and object is " + mobileNumber.toString());
		Thread.sleep(1000);
		emailId.sendKeys(Email);
		log("entered email id:-" + Email + " and object is " + emailId.toString());
		Thread.sleep(1000);
		aadharNo.sendKeys(AadharNo);
		log("entered aadhar number:-" + AadharNo + " and object is " + aadharNo.toString());
		Thread.sleep(1000);
		
		select = new Select(bloodGroup);
		select.selectByVisibleText(BloodGr);
		log("selected blood group:-" + BloodGr + " and object is " + bloodGroup.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), BloodGr);
		Thread.sleep(1000);
		
		studentBankACNo.sendKeys(StBankAC);
		log("entered student bank account number:-" + StBankAC + " and object is " + studentBankACNo.toString());
		Thread.sleep(1000);
		chkBPLcardNo.click();
		log("Clicked on BPL card check box and object is:-" + chkBPLcardNo.toString());
		bplCardNo.sendKeys(BPLCardNo);
		log("entered BPL card number:-" + BPLCardNo + " and object is " + bplCardNo.toString());
		Thread.sleep(1000);
		select = new Select(selFeeConcessionType);
		select.selectByVisibleText(Feeconcession);
		log("selected blood group:-" + Feeconcession + " and object is " + selFeeConcessionType.toString());
		Thread.sleep(5000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Feeconcession);
		Thread.sleep(1000);

	}

	public void clickOnStudentPageNextButton() throws Exception {

		next_ButtonStudent.click();
		log("Clicked on student page next button and object is:-" + next_ButtonStudent.toString());
		Thread.sleep(3000);
	}

	public void studentAdmissionFormAddressSection(String enterAddr, String areaAddr, String Country, String State,
			String City, String PinCode) throws Exception {

		enterAddress.sendKeys(enterAddr);
		log("entered permanent address:-" + enterAddr + " and object is " + enterAddress.toString());
		Thread.sleep(1000);
		enterArea.sendKeys(areaAddr);
		log("entered area:-" + areaAddr + " and object is " + studentBankACNo.toString());
		Thread.sleep(1000);
		select = new Select(selCountry);
		select.selectByVisibleText(Country);
		log("selected country:-" + Country + " and object is " + selCountry.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Country);
		Thread.sleep(1000);
		
		select = new Select(selState);
		select.selectByVisibleText(State);
		log("selected state:-" + State + " and object is " + selState.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), State);
		Thread.sleep(1000);
		
		enterCity.sendKeys(City);
		log("entered city:-" + City + " and object is " + enterCity.toString());
		Thread.sleep(1000);
		enterPin.sendKeys(PinCode);
		log("entered pin code:-" + PinCode + " and object is " + enterPin.toString());
		Thread.sleep(1000);
		chk_mapPermanentTocommAddress.click();
		log("Clicked on check box to map permanent address to communication address");
		Thread.sleep(2000);

	}

	public void clickOnAddressPageNextButton() throws Exception {

		next_ButtonAddress.click();
		log("Clicked on student page next button and object is:-" + next_ButtonAddress.toString());
		Thread.sleep(3000);
	}

	public void clickOnFatherAlive() throws Exception {

		chkFatherAlive.click();
		log("Father is alive check box is checked");
		Thread.sleep(1000);
	}

	public void studentAdmissionFormFatherDetails(String Fname, String FSurName, String FAadharNum,
			String FQualification, String FoffAddr, String Foccupation, String FDesignation, String FBankAcNum,
			String FIFSCCode, String FcasteCert, String Fnationality, String FmonthlyIncome, String FAnuualIncome,
			String FmobileNum, String FEmailId) throws Exception {

		enterfatherName.sendKeys(Fname);
		log("entered father name:-" + Fname + " and object is " + enterfatherName.toString());
		Thread.sleep(1000);
		enterFatherSurname.sendKeys(FSurName);
		log("entered father surname:-" + FSurName + " and object is " + enterFatherSurname.toString());
		Thread.sleep(1000);
		enterFatherAadhar.sendKeys(FAadharNum);
		log("entered father aadhar number:-" + FAadharNum + " and object is " + enterFatherAadhar.toString());
		Thread.sleep(1000);
		enterfatherQualification.sendKeys(FQualification);
		log("entered father qualification:-" + FQualification + " and object is "
				+ enterfatherQualification.toString());
		Thread.sleep(1000);
		fatherofficeAddr.sendKeys(FoffAddr);
		log("entered father office address:-" + FoffAddr + " and object is " + fatherofficeAddr.toString());
		Thread.sleep(1000);
		fatherOccupation.sendKeys(Foccupation);
		log("entered father occupation:-" + Foccupation + " and object is " + fatherOccupation.toString());
		Thread.sleep(1000);
		fatherDesignation.sendKeys(FDesignation);
		log("entered father designation:-" + FDesignation + " and object is " + fatherDesignation.toString());
		Thread.sleep(1000);
		fatherbankAccNo.sendKeys(FBankAcNum);
		log("entered father bank account number:-" + FBankAcNum + " and object is " + fatherbankAccNo.toString());
		Thread.sleep(1000);
		fatherBankIfsc.sendKeys(FIFSCCode);
		log("entered father bank IFSC code:-" + FIFSCCode + " and object is " + fatherBankIfsc.toString());
		Thread.sleep(1000);
		fatherCasteCert.sendKeys(FcasteCert);
		log("entered father caste certificate number:-" + FcasteCert + " and object is " + fatherCasteCert.toString());
		Thread.sleep(1000);
		select = new Select(fatherNationality);
		select.selectByVisibleText(Fnationality);
		log("selected father nationality:-" + Fnationality + " and object is " + fatherNationality.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Fnationality);
		Thread.sleep(1000);
		
		fatherMonthlyIncome.sendKeys(FmonthlyIncome);
		log("entered father monthly income:-" + FmonthlyIncome + " and object is " + fatherMonthlyIncome.toString());
		Thread.sleep(1000);
		fatherAnnualIncome.sendKeys(FAnuualIncome);
		log("entered father annual income:-" + FAnuualIncome + " and object is " + fatherAnnualIncome.toString());
		Thread.sleep(1000);
		fatherMobileNumber.sendKeys(FmobileNum);
		log("entered father mobile number:-" + FmobileNum + " and object is " + fatherMobileNumber.toString());
		Thread.sleep(1000);
		fatherEmailId.sendKeys(FEmailId);
		log("entered father email id:-" + FEmailId + " and object is " + fatherEmailId.toString());
		Thread.sleep(3000);
	}

	public void clickOnMotherAlive() throws Exception {

		chkMotherAlive.click();
		log("Mother is alive check box is checked");
		Thread.sleep(1000);
	}

	public void studentAdmissionFormMothersDetails(String Mname, String MSurName, String MAadharNum,
			String MQualification, String MoffAddr, String Moccupation, String MDesignation, String MBankAcNum,
			String MIFSCCode, String McasteCert, String Mnationality, String MmonthlyIncome, String MAnuualIncome,
			String MmobileNum, String MEmailId) throws Exception {

		entermotherName.sendKeys(Mname);
		log("entered mother name:-" + Mname + " and object is " + entermotherName.toString());
		Thread.sleep(1000);
		enterMotherSurname.sendKeys(MSurName);
		log("entered mother surname:-" + MSurName + " and object is " + enterMotherSurname.toString());
		Thread.sleep(1000);
		enterMotherAadhar.sendKeys(MAadharNum);
		log("entered mother aadhar number:-" + MAadharNum + " and object is " + enterMotherAadhar.toString());
		Thread.sleep(1000);
		enterMotherQualification.sendKeys(MQualification);
		log("entered mother qualification:-" + MQualification + " and object is "
				+ enterMotherQualification.toString());
		Thread.sleep(1000);
		motherofficeAddr.sendKeys(MoffAddr);
		log("entered mother office address:-" + MoffAddr + " and object is " + motherofficeAddr.toString());
		Thread.sleep(1000);
		motherOccupation.sendKeys(Moccupation);
		log("entered mother occupation:-" + Moccupation + " and object is " + motherOccupation.toString());
		Thread.sleep(1000);
		motherDesignation.sendKeys(MDesignation);
		log("entered mother designation:-" + MDesignation + " and object is " + motherDesignation.toString());
		Thread.sleep(1000);
		motherbankAccNo.sendKeys(MBankAcNum);
		log("entered mother bank account number:-" + MBankAcNum + " and object is " + motherbankAccNo.toString());
		Thread.sleep(1000);
		motherBankIfsc.sendKeys(MIFSCCode);
		log("entered mother bank IFSC code:-" + MIFSCCode + " and object is " + motherBankIfsc.toString());
		Thread.sleep(1000);
		motherCasteCert.sendKeys(McasteCert);
		log("entered mother caste certificate number:-" + McasteCert + " and object is " + motherCasteCert.toString());
		Thread.sleep(1000);
		select = new Select(motherNationality);
		select.selectByVisibleText(Mnationality);
		log("selected mother nationality:-" + Mnationality + " and object is " + motherNationality.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), Mnationality);
		Thread.sleep(1000);

		motherMonthlyIncome.sendKeys(MmonthlyIncome);
		log("entered mother monthly income:-" + MmonthlyIncome + " and object is " + motherMonthlyIncome.toString());
		Thread.sleep(1000);
		motherAnnualIncome.sendKeys(MAnuualIncome);
		log("entered mother annual income:-" + MAnuualIncome + " and object is " + motherAnnualIncome.toString());
		Thread.sleep(1000);
		motherMobileNumber.sendKeys(MmobileNum);
		log("entered mother mobile number:-" + MmobileNum + " and object is " + motherMobileNumber.toString());
		Thread.sleep(1000);
		motherEmailId.sendKeys(MEmailId);
		log("entered mother email id:-" + MEmailId + " and object is " + motherEmailId.toString());
		Thread.sleep(1000);

	}

	public void clickOnParentPageNextButton() throws Exception {

		next_ButtonParent.click();
		log("Clicked no next page button on parent details");
		Thread.sleep(3000);
	}

	/**
	 * Students admission form others Activity, reference and source
	 * 
	 * @return
	 * @throws Exception
	 */

	public void studentFormOthers() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		robot.setAutoDelay(2000);
		if (activitiesSports.isDisplayed()) {
			activitiesSports.click();
			log("Clicked on activity sports check box and object is:-" + activitiesSports.toString());
			Thread.sleep(1000);
		}
		if (activitiesDance.isDisplayed()) {
			activitiesDance.click();
			log("Clicked on activity dance check box and object is:-" + activitiesDance.toString());
			Thread.sleep(1000);
		}
		if (activitiesSinging.isDisplayed()) {
			activitiesSinging.click();
			log("Clicked on activity Singing check box and object is:-" + activitiesSinging.toString());
			Thread.sleep(1000);
		}
		if (referenceFriend.isDisplayed()) {
			referenceFriend.click();
			log("Clicked on reference Friends check box and object is:-" + referenceFriend.toString());
			Thread.sleep(1000);
		}

		if (referPricipal.isDisplayed()) {
			referPricipal.click();
			log("Clicked on reference principal check box and object is:-" + referPricipal.toString());
			Thread.sleep(1000);
		}
		if (refVicePrincipal.isDisplayed()) {
			refVicePrincipal.click();
			log("Clicked on reference vice principal check box and object is:-" + refVicePrincipal.toString());
			Thread.sleep(1000);
		}
		if (sourceInternet.isDisplayed()) {
			sourceInternet.click();
			log("Clicked on source Internet check box and object is:-" + sourceInternet.toString());
			Thread.sleep(1000);
		}
		if (srcSocialMedia.isDisplayed()) {
			srcSocialMedia.click();
			log("Clicked on source social media check box and object is:-" + srcSocialMedia.toString());
			Thread.sleep(1000);
		}
		if (srcSusdiny.isDisplayed()) {
			srcSusdiny.click();
			log("Clicked on source susdiny check box and object is:-" + srcSusdiny.toString());
			Thread.sleep(1000);
		}
		String achivements = "Winner of inter school dance competition";
		Thread.sleep(1000);
		achivementTextField.sendKeys(achivements);
		log("entered achivements details:-" + achivements + " and object is " + achivementTextField.toString());
		Thread.sleep(3000);

	}

	public void bondDetailsOthers(String firstBond, String bond2, String bond3, String bondFour, String bondV,
			String bondVi, String bondI, String bondVii, String cardRation, String cardAadhar, String cardPan,
			String bondBBMP, String HDFCbond, String bondDD, String bondSports, String bondGreat)
			throws InterruptedException {

		chkFirstBond.click();
		log("Clicked on First bond check box and object is:-" + chkFirstBond.toString());
		Thread.sleep(1000);
		firstBondTextField.sendKeys(firstBond);
		log("entered first bond number:-" + firstBond + " and object is " + firstBondTextField.toString());
		Thread.sleep(1000);

		chkBONDII.click();
		log("Clicked on bond2 check box and object is:-" + chkBONDII.toString());
		Thread.sleep(1000);
		iiBondTextField.sendKeys(bond2);
		log("entered bond II number:-" + bond2 + " and object is " + iiBondTextField.toString());
		Thread.sleep(1000);

		chkBONDIII.click();
		log("Clicked on bond III check box and object is:-" + chkBONDIII.toString());
		Thread.sleep(1000);
		iiiBondTextField.sendKeys(bond3);
		log("entered bond 3 number:-" + bond3 + " and object is " + iiiBondTextField.toString());
		Thread.sleep(1000);

		chkBONDFour.click();
		log("Clicked on bond four check box and object is:-" + chkBONDFour.toString());
		Thread.sleep(1000);
		fourBondTextField.sendKeys(bondFour);
		log("entered bond four number:-" + bondFour + " and object is " + fourBondTextField.toString());
		Thread.sleep(1000);

		chkBONDV.click();
		log("Clicked on bond V check box and object is:-" + chkBONDV.toString());
		Thread.sleep(1000);
		vBondTextField.sendKeys(bondV);
		log("entered bond v number:-" + bondV + " and object is " + vBondTextField.toString());
		Thread.sleep(1000);

		chkBONDVI.click();
		log("Clicked on bond6 check box and object is:-" + chkBONDVI.toString());
		Thread.sleep(1000);
		viBondTextField.sendKeys(bondVi);
		log("entered bond VI number:-" + bondVi + " and object is " + viBondTextField.toString());
		Thread.sleep(1000);

		chkbondI.click();
		log("Clicked on bond I check box and object is:-" + chkbondI.toString());
		Thread.sleep(1000);
		ibondTextField.sendKeys(bondI);
		log("entered  bond I number:-" + bondI + " and object is " + ibondTextField.toString());
		Thread.sleep(1000);

		chkbondVII.click();
		log("Clicked on bond7 check box and object is:-" + chkbondVII.toString());
		Thread.sleep(1000);
		viibondTextField.sendKeys(bondVii);
		log("entered bond VII number:-" + bondVii + " and object is " + viibondTextField.toString());
		Thread.sleep(1000);

		rationCard.click();
		log("Clicked on ration card bond check box and object is:-" + rationCard.toString());
		Thread.sleep(1000);
		rationcardTextField.sendKeys(bondVii);
		log("entered ration card bond number:-" + bondVii + " and object is " + rationcardTextField.toString());
		Thread.sleep(1000);

		chkaadharcard.click();
		log("Clicked aadhar card bond check box and object is:-" + chkaadharcard.toString());
		Thread.sleep(1000);
		aadharcardTextField.sendKeys(cardAadhar);
		log("entered Aadhar card bond number:-" + cardAadhar + " and object is " + aadharcardTextField.toString());
		Thread.sleep(1000);

		chkPancard.click();
		log("Clicked on Pan card bond check box and object is:-" + chkPancard.toString());
		Thread.sleep(1000);
		panCardTextField.sendKeys(cardPan);
		log("entered pan card bond number:-" + cardPan + " and object is " + panCardTextField.toString());
		Thread.sleep(1000);

		chkBbmp.click();
		log("Clicked on BBMP bond check box and object is:-" + chkBbmp.toString());
		Thread.sleep(1000);
		bbmpTextField.sendKeys(bondBBMP);
		log("entered BBMP bond number:-" + bondBBMP + " and object is " + bbmpTextField.toString());
		Thread.sleep(1000);

		hdfcBondCard.click();
		log("Clicked on HDFC bond check box and object is:-" + hdfcBondCard.toString());
		Thread.sleep(1000);
		hdfcBondTextField.sendKeys(HDFCbond);
		log("entered HDFC bond number:-" + HDFCbond + " and object is " + hdfcBondTextField.toString());
		Thread.sleep(1000);

		chkDD.click();
		log("Clicked on DD bond check box and object is:-" + chkDD.toString());
		Thread.sleep(1000);
		ddTextField.sendKeys(bondDD);
		log("entered DD bond number:-" + bondDD + " and object is " + ddTextField.toString());
		Thread.sleep(1000);

		chkSportsbond.click();
		log("Clicked on sports bond check box and object is:-" + chkSportsbond.toString());
		Thread.sleep(1000);
		sportsBondTextField.sendKeys(bondSports);
		log("entered sports bond number:-" + bondSports + " and object is " + sportsBondTextField.toString());
		Thread.sleep(1000);

		chkGreatBond.click();
		log("Clicked on Great bond check box and object is:-" + chkGreatBond.toString());
		Thread.sleep(1000);
		greatBondTextField.sendKeys(bondGreat);
		log("entered great bond number:-" + bondGreat + " and object is " + greatBondTextField.toString());
		Thread.sleep(1000);

	}

	public void previousSchoolDetails(String prevSchoolName, String prevSchoolType, String prevClass,
			String prevPercentage, String prevGrade, String prevPassedYr, String prevTotalMarks, String prevBoard,
			String prevCountry, String prevState, String prevAddress, String prevLeftReason, String prevmedium)
			throws Exception {

		schoolNamePrev.sendKeys(prevSchoolName);
		log("entered previous school name:-" + prevSchoolName + " and object is " + schoolNamePrev.toString());
		Thread.sleep(2000);
		select = new Select(selschoolTypePrev);
		select.selectByVisibleText(prevSchoolType);
		log("selected previous school type:-" + prevSchoolType + " and object is " + selschoolTypePrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevSchoolType);
		Thread.sleep(1000);
		
		select = new Select(selClassPrev);
		select.selectByVisibleText(prevClass);
		log("selected previous class:-" + prevClass + " and object is " + selClassPrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevClass);
		Thread.sleep(1000);
		
		percentagePrev.sendKeys(prevPercentage);
		log("entered previous school percentage:-" + prevPercentage + " and object is " + percentagePrev.toString());
		Thread.sleep(1000);
		gradePrev.sendKeys(prevGrade);
		log("entered previous school grade:-" + prevGrade + " and object is " + gradePrev.toString());
		Thread.sleep(1000);
		select = new Select(passedYearPrev);
		select.selectByVisibleText(prevPassedYr);
		log("selected passed year:-" + prevPassedYr + " and object is " + passedYearPrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevPassedYr);
		Thread.sleep(1000);
		
		totalMarksPrev.sendKeys(prevTotalMarks);
		log("entered total marks:-" + prevTotalMarks + " and object is " + totalMarksPrev.toString());
		Thread.sleep(1000);
		select = new Select(boardsPrev);
		select.selectByVisibleText(prevBoard);
		log("selected previous boards:-" + prevBoard + " and object is " + boardsPrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevBoard);
		Thread.sleep(1000);
		
		select = new Select(countryPrev);
		select.selectByVisibleText(prevCountry);
		log("selected previous school country:-" + prevCountry + " and object is " + countryPrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevCountry);
		Thread.sleep(1000);
		
		select = new Select(statePrev);
		select.selectByVisibleText(prevState);
		log("selected previous school state:-" + prevState + " and object is " + statePrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), prevState);
		Thread.sleep(1000);
		
		addressPrev.sendKeys(prevAddress);
		log("entered previous school address:-" + prevAddress + " and object is " + addressPrev.toString());
		Thread.sleep(1000);
		leftReasonPrev.sendKeys(prevLeftReason);
		log("entered previous school reason for leaving:-" + prevLeftReason + " and object is "
				+ leftReasonPrev.toString());
		Thread.sleep(1000);
		mediumPrev.sendKeys(prevmedium);
		log("entered previous school medium:-" + prevmedium + " and object is " + mediumPrev.toString());
		Thread.sleep(1000);

	}

	public void guardianDetails(String guardianName, String guardianAddress, String guadrdianEmail,
			String guardianPhone) throws Exception {

		guardianNameText.sendKeys(guardianName);
		log("entered guardian Name:-" + guardianName + " and object is " + guardianNameText.toString());
		Thread.sleep(1000);
		guardianAddressText.sendKeys(guardianAddress);
		log("entered guardian address:-" + guardianAddress + " and object is " + guardianAddressText.toString());
		Thread.sleep(1000);
		guardianMailText.sendKeys(guadrdianEmail);
		log("entered guardian Email:-" + guadrdianEmail + " and object is " + guardianMailText.toString());
		Thread.sleep(1000);
		guardianPhoneNum.sendKeys(guardianPhone);
		log("entered guardian Email:-" + guardianPhone + " and object is " + guardianPhoneNum.toString());
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadguardianPhoto, "Guardian.jpg");
		log("Guardian PhotoGraph uploaded and object is:-" + uploadguardianPhoto.toString());
		Thread.sleep(1000);
		btnViewimagePhoto.click();
		log("clicked on guardian photo view button and object is:-" + btnViewimagePhoto.toString());
		Thread.sleep(1000);
		verifyImagePopup.click();
		log("clicked on view image close button and object is:-" + verifyImagePopup.toString());
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadguardianSign, "signature.jpg");
		log("Guardian signature uploaded and object is:-" + uploadguardianSign.toString());
		Thread.sleep(1000);
		btnViewimageSign.click();
		log("clicked on guardian signature view button and object is:-" + btnViewimageSign.toString());
		Thread.sleep(1000);
		verifyImagePopup.click();
		log("clicked on view image close button and object is:-" + verifyImagePopup.toString());
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadguardianFinPrint, "fingerPrint.jpg");
		log("Guardian finger print uploaded and object is:-" + uploadguardianFinPrint.toString());
		Thread.sleep(1000);
		btnViewimageFinPrint.click();
		log("clicked on guardian finger print view button and object is:-" + btnViewimageFinPrint.toString());
		Thread.sleep(1000);
		verifyImagePopup.click();
		log("clicked on view image close button and object is:-" + verifyImagePopup.toString());
		Thread.sleep(1000);
	}

	public void siblingDetails(String SiblingName, String SiblingClass, String SiblingRelation) throws Exception {
		tblSiblingName.sendKeys(SiblingName);
		log("entered Sibling Name:-" + SiblingName + " and object is " + tblSiblingName.toString());
		Thread.sleep(1000);
		select = new Select(tblSiblingClass);
		select.selectByVisibleText(SiblingClass);
		log("selected sibling class:-" + SiblingClass + " and object is " + countryPrev.toString());
		Thread.sleep(1000);
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), SiblingClass);
		Thread.sleep(1000);
		
		tblSiblingRelation.sendKeys(SiblingRelation);
		log("entered Sibling relation:-" + SiblingRelation + " and object is " + tblSiblingRelation.toString());
		Thread.sleep(1000);

	}

	public void clickOnOthersPageNextButton() throws Exception {
		next_ButtonOthers.click();
		log("Clicked on others page next button and object is:-" + next_ButtonOthers);
		Thread.sleep(3000);
	}

	public void requiredDocumentsUploladforAdmission() throws Exception {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

		if (tcDocUpload.isDisplayed()) {
			imageAndDocumentUpload(tcDocUpload, "TransferCertificate.jpg");
			log("Tc certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (BirthCertUpload.isDisplayed()) {
			imageAndDocumentUpload(BirthCertUpload, "TransferCertificate.jpg");
			log("Birth certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (markSheetUpload.isDisplayed()) {
			imageAndDocumentUpload(markSheetUpload, "TransferCertificate.jpg");
			log("Marks sheet certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (aadharDocUpload.isDisplayed()) {
			imageAndDocumentUpload(aadharDocUpload, "TransferCertificate.jpg");
			log("Aadhar documents uploaded successfully");
			Thread.sleep(1000);
		}
		if (residentialUpload1.isDisplayed()) {
			imageAndDocumentUpload(residentialUpload1, "TransferCertificate.jpg");
			log("Residential proof1 uploaded successfully");
			Thread.sleep(1000);
		}
		if (residentialUpload2.isDisplayed()) {
			imageAndDocumentUpload(residentialUpload2, "TransferCertificate.jpg");
			log("Residential proof2 uploaded successfully");
			Thread.sleep(1000);
		}
		if (incomeCertUpload.isDisplayed()) {
			imageAndDocumentUpload(incomeCertUpload, "TransferCertificate.jpg");
			log("Income certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (idProofUpload.isDisplayed()) {
			imageAndDocumentUpload(idProofUpload, "TransferCertificate.jpg");
			log("ID proof uploaded successfully");
		}
		if (FormIUpload.isDisplayed()) {
			imageAndDocumentUpload(FormIUpload, "TransferCertificate.jpg");
			log("Form I uploaded successfully");
			Thread.sleep(1000);
		}
		if (Form2Upload.isDisplayed()) {
			imageAndDocumentUpload(Form2Upload, "TransferCertificate.jpg");
			log("Form 2 uploaded successfully");
			Thread.sleep(1000);
		}
		if (Form4testUpload.isDisplayed()) {
			imageAndDocumentUpload(Form4testUpload, "TransferCertificate.jpg");
			log("Form 4 test uploaded successfully");
			Thread.sleep(1000);
		}
		if (conductCertUpload.isDisplayed()) {
			imageAndDocumentUpload(conductCertUpload, "TransferCertificate.jpg");
			log("Conduct certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (testadasdUpload.isDisplayed()) {
			imageAndDocumentUpload(testadasdUpload, "TransferCertificate.jpg");
			log("Testadasd uploaded successfully");
			Thread.sleep(1000);
		}
		if (pansUpload.isDisplayed()) {
			imageAndDocumentUpload(pansUpload, "TransferCertificate.jpg");
			log("Pan card uploaded successfully");
			Thread.sleep(1000);
		}
		if (addressProofUpload.isDisplayed()) {
			imageAndDocumentUpload(addressProofUpload, "TransferCertificate.jpg");
			log("Address proof uploaded successfully");
			Thread.sleep(1000);
		}
		if (passportUpload.isDisplayed()) {
			imageAndDocumentUpload(passportUpload, "TransferCertificate.jpg");
			log("Passport uploaded successfully");
			Thread.sleep(1000);
		}
		if (DLUpload.isDisplayed()) {
			imageAndDocumentUpload(DLUpload, "TransferCertificate.jpg");
			log("Driving licence uploaded successfully");
			Thread.sleep(1000);
		}
		if (transferCertUpload.isDisplayed()) {
			imageAndDocumentUpload(transferCertUpload, "TransferCertificate.jpg");
			log("Transfer certificate uploaded successfully");
			Thread.sleep(1000);
		}
		if (importantCertUpload.isDisplayed()) {
			imageAndDocumentUpload(importantCertUpload, "TransferCertificate.jpg");
			log("important certificate uploaded successfully");
			Thread.sleep(1000);
		}
	}

	public void requiredDetails() throws Exception {

		chkHostelReq.click();
		log("Clicked on hostel required check box and object is:-" + chkHostelReq.toString());
		Thread.sleep(1000);

		chkTransportReq.click();
		log("Clicked on transport required check box and object is:-" + chkTransportReq.toString());
		Thread.sleep(1000);
	}

	public void uploadFatherPhotoSignAndFinPrint() throws Exception {

		if (fatherPhotoUpload.isDisplayed()) {
			imageAndDocumentUpload(fatherPhotoUpload, "Guardian.jpg");
			log("Father PhotoGraph uploaded and object is:-" + fatherPhotoUpload.toString());

			btnViewFPhoto.click();
			log("clicked on father photo view button and object is:-" + btnViewFPhoto.toString());

			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());

		}
		if (fathersignUpload.isDisplayed()) {
			imageAndDocumentUpload(fathersignUpload, "signature.jpg");
			log("Father signature uploaded and object is:-" + fathersignUpload.toString());

			btnViewFSign.click();
			log("clicked on father signature view button and object is:-" + btnViewFSign.toString());

			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());

		}
		if (fatherFinPrintupload.isDisplayed()) {
			imageAndDocumentUpload(fatherFinPrintupload, "fingerPrint.jpg");
			log("Father finger print uploaded and object is:-" + fatherFinPrintupload.toString());

			btnViewFFinPrint.click();
			log("clicked on father finger print view button and object is:-" + btnViewFFinPrint.toString());

			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());

		}
	}

	public void uploadMotherPhotoSignAndFinPrint() throws Exception {
		if (motherPhotoUpload.isDisplayed()) {
			imageAndDocumentUpload(motherPhotoUpload, "Guardian.jpg");
			log("Mother PhotoGraph uploaded and object is:-" + motherPhotoUpload.toString());
			Thread.sleep(1000);
			btnViewMPhoto.click();
			log("clicked on mother photo view button and object is:-" + btnViewMPhoto.toString());
			Thread.sleep(1000);
			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());
			Thread.sleep(1000);
		}
		if (mothersignUpload.isDisplayed()) {
			imageAndDocumentUpload(mothersignUpload, "signature.jpg");
			log("Mother signature uploaded and object is:-" + mothersignUpload.toString());
			Thread.sleep(1000);
			btnViewMSign.click();
			log("clicked on mother signature view button and object is:-" + btnViewMSign.toString());
			Thread.sleep(1000);
			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());
			Thread.sleep(1000);
		}
		if (motherFinPrintupload.isDisplayed()) {
			imageAndDocumentUpload(motherFinPrintupload, "fingerPrint.jpg");
			log("Mother mother print uploaded and object is:-" + motherFinPrintupload.toString());
			Thread.sleep(1000);
			btnViewMFinPrint.click();
			log("clicked on father finger print view button and object is:-" + btnViewMFinPrint.toString());
			Thread.sleep(1000);
			btnPopUpClose.click();
			log("clicked on view image close button and object is:-" + btnPopUpClose.toString());
			Thread.sleep(1000);
		}
	}

	public void clickOnSubmitButton() {
		btnSubmit.click();
		log("Clicked on submit button and object is:-" + btnSubmit.toString());
	}

	public boolean successMessagevalidation() {
		try {

			SuccessMsg.isDisplayed();
			log("Record saved successfully is dispalyed and object is:-" + SuccessMsg.toString());
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnSuccessOkButton() {
		btnSuccessOK.click();
		log("Clicked on Ok button of success confirmation and object is:-" + btnSuccessOK.toString());
	}
}
