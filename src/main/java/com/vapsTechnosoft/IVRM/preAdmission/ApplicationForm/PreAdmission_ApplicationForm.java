/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.ApplicationForm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class PreAdmission_ApplicationForm extends TestBase {

	public static final Logger log = Logger.getLogger(PreAdmission_ApplicationForm.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;
	ArrayList<String> tabs2;

	/**
	 * Admission from Student section locators
	 */
	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Application Form')][1]")
	private WebElement btn_PreAdmissionApplication;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Application Form')][1]/following::li[2]")
	private WebElement btn_ApplicationForm;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_ApplicationFormDispaly;

	@FindBy(xpath = "//label[text()='Name of the Child:']/following-sibling::div/input")
	private WebElement input_FirstName;

	@FindBy(xpath = "//input[@id='usr' and @name='hmname']")
	private WebElement input_MiddleName;

	@FindBy(xpath = "//input[@id='usr' and @name='hlname']")
	private WebElement input_SurName;

	@FindBy(xpath = "//label[text()='Mobile Number:']/following-sibling::div/input[@name='hpno']")
	private WebElement input_MobileNumberChild;

	@FindBy(xpath = "//label[text()='Place of Birth:']/following-sibling::div/input")
	private WebElement input_PlaceOfbirth;

	@FindBy(xpath = "//label[text()='Religion:']/following-sibling::div/select[@name='hreligion']")
	private WebElement sel_ReligionStudent;

	@FindBy(xpath = "//label[text()='Caste:']/following-sibling::div/select[@name='casteere']")
	private WebElement sel_CasteChild;

	@FindBy(xpath = "//label[text()='Gender:']/following-sibling::div/select")
	private WebElement sel_GenderChild;

	@FindBy(xpath = "(//div[@class='md-datepicker-input-container']/input)[1]")
	private WebElement inputcalendar;// wrong

	@FindBy(xpath = "//label[text()='Applying For:']/following-sibling::div/select")
	private WebElement sel_ApplingForClass;

	@FindBy(xpath = "//label[text()='Email -Id:']/following-sibling::div/input")
	private WebElement input_EmailIDChild;

	@FindBy(xpath = "//label[text()='Academic Year:']/following-sibling::div/select")
	private WebElement sel_DisableacademicYear;

	@FindBy(xpath = "//label[text()='Nationality:']/following-sibling::div/select[@name='hnationality']")
	private WebElement sel_NationalityChild;

	@FindBy(xpath = "//label[text()='Mother Tongue:']/following-sibling::div/input")
	private WebElement input_MotherTongue;

	@FindBy(xpath = "//label[text()='Last School Syllabus:']/following-sibling::div/select")
	private WebElement sel_LastSchoolSyllabus;

	@FindBy(xpath = "//input[@name='file1']/parent::label")
	private WebElement upload_StudentPhoto;

	@FindBy(xpath = "(//label[contains(text(),'Date Of Birth:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_Calender_DoB;

	@FindBy(xpath = "//span[contains(text(),'Jun 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//table//tbody//tr/td[contains(text(),'2014')]")
	private WebElement btn_Year;

	@FindBy(xpath = "//table//tbody//tr/td[@aria-label='June 2014']/span[contains(text(),Jun)]")
	private WebElement btn_Month;

	@FindBy(xpath = "//span[contains(text(),'Jun 2014')]/following::td[30]/span")
	private WebElement btn_Date;

	@FindBy(xpath = "//input[@data-ng-model='reg.PASR_Student_Pic_Path']/parent::label")
	WebElement btn_BrowseImg_Child;

	@FindBy(xpath = "//input[@data-ng-model='reg.PASR_FatherPhoto']/parent::label")
	WebElement btn_BrowseImg_Father;

	@FindBy(xpath = "//input[@data-ng-model='reg.PASR_MotherPhoto']/parent::label")
	WebElement btn_BrowseImg_Mother;
	/**
	 * Other details locators
	 */
	@FindBy(xpath = "//label[text()='II Language Preffered:']/following-sibling::div/select")
	private WebElement sel_2ndLanguage;

	@FindBy(xpath = "//label[text()='III Language Preffered:']/following-sibling::div/select")
	private WebElement sel_3rddLanguage;

	@FindBy(xpath = "//input[@id='usr' and @name='tribe']")
	private WebElement input_Tribe;

	@FindBy(xpath = "//input[@id='usr' and @name='palygroup']")
	private WebElement input_PlayGroup;

	/**
	 * Residential details locators
	 */

	@FindBy(xpath = "//input[@id='usr' and @name='hconstreet']")
	private WebElement inputStreet;

	@FindBy(xpath = "//input[@id='usr' and @name='hconarea']")
	private WebElement inputArea;

	@FindBy(xpath = "//select[@id='sel1' and @name='hconcountry']")
	private WebElement selCountry;

	@FindBy(xpath = "//select[@id='sel1' and @name='hconstate']")
	private WebElement selState;

	@FindBy(xpath = "//input[@id='cityId' and @name='City']")
	private WebElement inputCity;

	@FindBy(xpath = "//input[@id='usr' and @name='pincode']")
	private WebElement inputPinCodeZip;

	@FindBy(xpath = "//div[@class='form-group']/label/input")
	private WebElement chk_permaddsameAsResAdd;

	/**
	 * Father details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "//input[@id='usr' and @name='hfathername']")
	private WebElement inputfatherName;

	@FindBy(xpath = "//input[@id='usr' and @name='hfathersurname']")
	private WebElement inputfathersurname;

	@FindBy(xpath = "//input[@id='usr' and @name='qual']")
	private WebElement inputfatherQualification;

	@FindBy(xpath = "//input[@id='usr' and @name='serv']")
	private WebElement inputfatherOccupation;

	@FindBy(xpath = "//select[@id='sel1' and @name='hreligionfather']")
	private WebElement selfatherReligion;

	@FindBy(xpath = "//select[@id='sel1' and @name='casteerefather']")
	private WebElement selfatherCaste;

	@FindBy(xpath = "//input[@id='usr' and @name='tribefather']")
	private WebElement inputfatherTribe;

	@FindBy(xpath = "//select[@id='sel1' and @name='adasdfsd']")
	private WebElement sel_fathersNationality;

	@FindBy(xpath = "//input[@id='usr' and @name='fatheremail']")
	private WebElement inputFathersEmailId;

	@FindBy(xpath = "//input[@id='usr' and @name='phoneoffm']")
	private WebElement inputfathers_PhOffice;

	@FindBy(xpath = "//input[@id='usr' and @name='phoneresm']")
	private WebElement inputfathers_PhResidence;

	@FindBy(xpath = "//input[@name='hfpno']")
	private WebElement input_fatherMobile;

	/**
	 * Mother's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "//input[@id='usr' and @name='hmothername']")
	private WebElement inputmotherName;

	@FindBy(xpath = "//input[@id='usr' and @name='hmothernamesurname']")
	private WebElement inputmothersurname;

	@FindBy(xpath = "//input[@id='usr' and @name='motquali']")
	private WebElement inputmotherQualification;

	@FindBy(xpath = "//input[@id='usr' and @name='motserbusi']")
	private WebElement inputmotherOccupation;

	@FindBy(xpath = "//select[@id='sel1' and @name='hreligionmother']")
	private WebElement selmotherReligion;

	@FindBy(xpath = "//select[@id='sel1' and @name='casteeremother']")
	private WebElement selmotherCaste;

	@FindBy(xpath = "//input[@id='usr' and @name='tribemother']")
	private WebElement inputmotherTribe;

	@FindBy(xpath = "//select[@id='sel1' and @name='motnation']")
	private WebElement sel_mothersNationality;

	@FindBy(xpath = "//input[@id='usr' and @name='fatheremailmm']")
	private WebElement inputmothersEmailId;

	@FindBy(xpath = "//input[@id='usr' and @name='phoneoffmmm']")
	private WebElement inputmothers_PhOffice;

	@FindBy(xpath = "//input[@id='usr' and @name='phoneresmm']")
	private WebElement inputmothers_PhResidence;

	@FindBy(xpath = "//input[@name='hMpno']")
	private WebElement input_motherMobile;

	/**
	 * Monthly income
	 */
	@FindBy(xpath = "//input[@id='usr' and @name='fathmoninco']")
	private WebElement input_fatherIncome;

	@FindBy(xpath = "//input[@id='usr' and @name='mothincome']")
	private WebElement input_motherIncome;

	@FindBy(xpath = "//input[@id='usr' and @name='haltno']")
	private WebElement input_alternateContact;

	@FindBy(xpath = "//input[@id='reservation' and @name='haltemail']")
	private WebElement input_alternateEmail;

	/**
	 * Guardian's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "//input[@id='usr' and @name='gname']")
	private WebElement input_GuardianName;

	@FindBy(xpath = "//input[@id='usr' and @name='grelationship']")
	private WebElement input_GurRelationshipToStudent;

	@FindBy(xpath = "//input[@id='usr' and @data-ng-model='reg.PASRG_Occupation']")
	private WebElement input_Gur_Occupation;

	@FindBy(xpath = "//input[@id='reservation' and @name='gemail']")
	private WebElement input_Gur_PhOffice;

	@FindBy(xpath = "//input[@id='reservation' and @name='gmob']")
	private WebElement input_Gur_PhResidence;
	/**
	 * sibling details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//input[@id='usr' and @name='hsname'])[1]")
	private WebElement inputsibName;

	@FindBy(xpath = "(//input[@id='usr' and @data-ng-model='sibling.pasrS_SiblingsClass'])[1]")
	private WebElement inputsibclass;

	@FindBy(xpath = "(//input[@id='usr' and @data-ng-model='sibling.pasrS_SiblingsAdmissionNo'])[1]")
	private WebElement inputsibAdmNo;

	@FindBy(xpath = "(//body[@id='style-4']//div/table/tbody/tr/td[5])[1]")
	private WebElement clickSibPlus;

	@FindBy(xpath = "(//input[@id='usr' and @name='hsname'])[2]")
	private WebElement input2ndsibName;

	@FindBy(xpath = "(//input[@id='usr' and @data-ng-model='sibling.pasrS_SiblingsClass'])[2]")
	private WebElement input2ndsibclass;

	@FindBy(xpath = "(//input[@id='usr' and @data-ng-model='sibling.pasrS_SiblingsAdmissionNo'])[2]")
	private WebElement input2ndsibAdmNo;

	/**
	 * Previous school details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[2]/input")
	private WebElement inputSchoolName;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[3]/input")
	private WebElement inputClass;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[4]/input")
	private WebElement inputGrade;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[5]/input")
	private WebElement inputPassedYr;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[6]/input")
	private WebElement inputAddress;

	/**
	 * Required documents upload for BGHS pre admission form
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[4]/td[3]/label")
	private WebElement uploadDOBCert;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[4]/td[4]/span")
	private WebElement viewUploadDOBCert;

	@FindBy(xpath = "//div[@id='myModal']/div/div/div[2]/button")
	private WebElement btnPopUpClose;

	/**
	 * Undertaking text and radio button
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[10]/p")
	private WebElement undertakingText;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[10]/div/label[1]/span/preceding-sibling::input")
	private WebElement rdBtnundertakingYes;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]//div/div[2]/div[11]/span/button")
	private WebElement btnSubmit;

	/**
	 * Pop Up message and action validation
	 */
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	private WebElement btnsubmitCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnsubmitYes;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnOkonsuccess;

	/**
	 * table data validation
	 */

	@FindBy(xpath = "//body[@id='style-4']//div/div[3]/div/div/input")
	private WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[5]/tbody/tr")
	List<WebElement> tblRowStuList;

	public PreAdmission_ApplicationForm(WebDriver driver) {
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
	 * Navigate to Application Form(PreAdmission>PreAdmission
	 * Application>Application Form)
	 * 
	 * @throws Exception
	 */
	public void navigateToPreAdmission_ApplicationForm() throws Exception {
		if (btn_PreAdmission.isDisplayed()) {
			btn_PreAdmission.click();
			log("Clicked on Pre admission Button and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("PreAdmission Module element not present in navigation menu and object is:-"
					+ btn_PreAdmission.toString());
			Thread.sleep(500);
		}
		if (btn_PreAdmissionApplication.isDisplayed()) {
			btn_PreAdmissionApplication.click();
			log("Clicked on PreAdmission Application link Button and object is:-"
					+ btn_PreAdmissionApplication.toString());
			Thread.sleep(1000);
		} else {
			log("PreAdmission Application link element not present in navigation menu and object is:-"
					+ btn_PreAdmissionApplication.toString());
			Thread.sleep(500);
		}
		if (btn_ApplicationForm.isDisplayed()) {
			btn_ApplicationForm.click();
			log("Clicked on Application form pre admission Button and object is:-" + btn_ApplicationForm.toString());
			Thread.sleep(1000);
		} else {
			log("Application Form link element not present in navigation menu and object is:-"
					+ btn_ApplicationForm.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Validation of Application form page path message
	 * 
	 * @return
	 */
	public boolean verifyPreAdmission_ApplicationForm_PagePath() {
		try {
			System.out.println(txt_ApplicationFormDispaly.getText());
			txt_ApplicationFormDispaly.isDisplayed();
			log("Application form pre admission page is dispalyed and object is:-"
					+ txt_ApplicationFormDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Student information for Application form
	 * 
	 * @param fName
	 * @param mName
	 * @param sName
	 * @param mNumber
	 * @param birthPlace
	 * @param religion
	 * @param caste
	 * @param gender
	 * @param apply_class
	 * @param email
	 * @param academicYear
	 * @param nationality
	 * @param motherTongue
	 * @param syllabus
	 * @throws Exception
	 */

	public void enterStudentInformationFor_ApplicationForm(String fName, String mName, String sName, String mNumber,
			String birthPlace, String religion, String caste, String gender, String apply_class, String email,
			String academicYear, String nationality, String motherTongue, String syllabus) throws Exception {

		if (input_FirstName.isDisplayed()) {
			input_FirstName.clear();
			input_FirstName.sendKeys(fName);
			log("Entered first name:-" + fName + " and object is " + input_FirstName.toString());
			Thread.sleep(1000);
		} else {
			log("First Name(Child) element not present and object is:-" + input_FirstName.toString());
			Thread.sleep(500);
		}
		if (input_MiddleName.isDisplayed()) {
			input_MiddleName.clear();
			input_MiddleName.sendKeys(mName);
			log("Entered Middle name:-" + mName + " and object is " + input_MiddleName.toString());
			Thread.sleep(1000);
		} else {
			log("Middle Name(Child) element not present and object is:-" + input_MiddleName.toString());
			Thread.sleep(500);
		}
		if (input_SurName.isDisplayed()) {
			input_SurName.clear();
			input_SurName.sendKeys(sName);
			log("Entered Surname name:-" + sName + " and object is " + input_SurName.toString());
			Thread.sleep(1000);
		} else {
			log("Surname Name(Child) element not present and object is:-" + input_SurName.toString());
			Thread.sleep(500);
		}
		if (input_MobileNumberChild.isDisplayed()) {
			input_MobileNumberChild.clear();
			input_MobileNumberChild.sendKeys(mNumber);
			log("Entered Mobile Number(Child):-" + mNumber + " and object is " + input_MobileNumberChild.toString());
			Thread.sleep(1000);
		} else {
			log("Mobile Number(Child) element not present and object is:-" + input_MobileNumberChild.toString());
			Thread.sleep(500);
		}
		if (input_PlaceOfbirth.isDisplayed()) {
			input_PlaceOfbirth.clear();
			input_PlaceOfbirth.sendKeys(birthPlace);
			log("Entered Place of Birth(Child):-" + birthPlace + " and object is " + input_PlaceOfbirth.toString());
			Thread.sleep(1000);
		} else {
			log("Place of Birth(Child) element not present and object is:-" + input_PlaceOfbirth.toString());
			Thread.sleep(500);
		}
		if (sel_ReligionStudent.isDisplayed()) {
			select = new Select(sel_ReligionStudent);
			select.selectByVisibleText(religion);

			log("Selected Religion of Student: " + religion + " and object is:- " + sel_ReligionStudent.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), religion);
			Thread.sleep(1000);
		} else {
			log("Religion of Student element is not present and object is:- " + sel_ReligionStudent.toString());
			Thread.sleep(500);
		}
		if (sel_CasteChild.isDisplayed()) {
			select = new Select(sel_CasteChild);
			select.selectByVisibleText(caste);

			log("Selected Caste of Student: " + caste + " and object is:- " + sel_CasteChild.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), caste);
			Thread.sleep(1000);
		} else {
			log("Caste of Student element is not present and object is:- " + sel_CasteChild.toString());
			Thread.sleep(500);
		}
		if (sel_GenderChild.isDisplayed()) {
			select = new Select(sel_GenderChild);
			select.selectByVisibleText(gender);

			log("Selected Gender of Student: " + gender + " and object is:- " + sel_GenderChild.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), gender);
			Thread.sleep(1000);
		} else {
			log("Gender of Student element is not present and object is:- " + sel_CasteChild.toString());
			Thread.sleep(500);
		}

		if (btn_Calender_DoB.isDisplayed()) {
			btn_Calender_DoB.click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
			Thread.sleep(1000);
			btn_MonthYear.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Year);
			Thread.sleep(1000);
			btn_Month.click();
			btn_Date.click();
			log("Date of Birth is selected from calender.");
			Thread.sleep(1000);
		} else {
			log("Date of Birth Calendar button element not present and object is:- " + btn_Calender_DoB.toString());
			Thread.sleep(500);
		}
		if (sel_ApplingForClass.isDisplayed()) {
			select = new Select(sel_ApplingForClass);
			select.selectByVisibleText(apply_class);

			log("Selected Class: " + apply_class + " and object is:- " + sel_ApplingForClass.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), apply_class);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_ApplingForClass.toString());
			Thread.sleep(500);
		}
		if (input_EmailIDChild.isDisplayed()) {
			input_EmailIDChild.clear();
			input_EmailIDChild.sendKeys(email);
			log("Entered Eamil id:-" + email + " and object is " + input_EmailIDChild.toString());
			Thread.sleep(1000);
		} else {
			log("Eamil id(Child) element not present and object is:-" + input_EmailIDChild.toString());
			Thread.sleep(500);
		}
		if (sel_DisableacademicYear.isDisplayed()) {
			select = new Select(sel_DisableacademicYear);
			// select.selectByVisibleText(apply_class);
			//
			// log("Selected Class: " + apply_class + " and object is:- " +
			// sel_ApplingForClass.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			log("Academic year selected is corret and object is:- " + sel_DisableacademicYear.toString());
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present and object is:- " + sel_DisableacademicYear.toString());
			Thread.sleep(500);
		}

		if (sel_NationalityChild.isDisplayed()) {
			select = new Select(sel_NationalityChild);
			select.selectByVisibleText(nationality);

			log("Selected Nationality child: " + nationality + " and object is:- " + sel_NationalityChild.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), nationality);
			Thread.sleep(1000);
		} else {
			log("Nationality(Child) element is not present and object is:- " + sel_NationalityChild.toString());
			Thread.sleep(500);
		}
		if (input_MotherTongue.isDisplayed()) {
			input_MotherTongue.clear();
			input_MotherTongue.sendKeys(motherTongue);
			log("Entered Mother Tongue:-" + motherTongue + " and object is " + input_MotherTongue.toString());
			Thread.sleep(1000);
		} else {
			log("Mother Tongue element not present and object is:-" + input_MotherTongue.toString());
			Thread.sleep(500);
		}
		if (sel_LastSchoolSyllabus.isDisplayed()) {
			select = new Select(sel_LastSchoolSyllabus);
			select.selectByVisibleText(syllabus);

			log("Selected last school syllabus: " + syllabus + " and object is:- " + sel_LastSchoolSyllabus.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), syllabus);
			Thread.sleep(1000);
		} else {
			log("Last school syllabus element is not present and object is:- " + sel_LastSchoolSyllabus.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Select the others details application form
	 * 
	 * @param secondLang
	 * @param thirdLang
	 * @param tribe
	 * @param playGroup
	 * @throws Exception
	 */
	public void othersDetails_ForPreadmApplicationForm(String secondLang, String thirdLang, String tribe,
			String playGroup) throws Exception {

		if (sel_2ndLanguage.isDisplayed()) {
			select = new Select(sel_2ndLanguage);
			select.selectByVisibleText(secondLang);

			log("Selected 2nd Language: " + secondLang + " and object is:- " + sel_2ndLanguage.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), secondLang);
			Thread.sleep(1000);
		} else {
			log("2nd Language element is not present and object is:- " + sel_2ndLanguage.toString());
			Thread.sleep(500);
		}

		if (sel_3rddLanguage.isDisplayed()) {
			select = new Select(sel_3rddLanguage);
			select.selectByVisibleText(thirdLang);

			log("Selected 3nd Language: " + thirdLang + " and object is:- " + sel_3rddLanguage.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), thirdLang);
			Thread.sleep(1000);
		} else {
			log("3nd Language element is not present and object is:- " + sel_3rddLanguage.toString());
			Thread.sleep(500);
		}
		if (input_Tribe.isDisplayed()) {
			input_Tribe.clear();
			input_Tribe.sendKeys(tribe);
			log("Entered Tribe:-" + tribe + " and object is " + input_Tribe.toString());
			Thread.sleep(1000);
		} else {
			log("Tribe element not present and object is:-" + input_Tribe.toString());
			Thread.sleep(500);
		}

		if (input_PlayGroup.isDisplayed()) {
			input_PlayGroup.clear();
			input_PlayGroup.sendKeys(playGroup);
			log("Entered Play Group:-" + playGroup + " and object is " + input_PlayGroup.toString());
			Thread.sleep(1000);
		} else {
			log("Play Group element not present and object is:-" + input_PlayGroup.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Residential and permanent address
	 * 
	 * @param street
	 * @param area
	 * @param Country
	 * @param state
	 * @param city
	 * @param pinZip
	 * @throws Exception
	 */
	public void residentialAndPermanentAddress_PreAdmApplicationForm(String street, String area, String Country,
			String state, String city, String pinZip) throws Exception {
		if (inputStreet.isDisplayed()) {
			inputStreet.clear();
			inputStreet.sendKeys(street);
			log("Entered street:-" + street + " and object is " + inputStreet.toString());
			Thread.sleep(1000);
		} else {
			log("Street element not present and object is:-" + inputStreet.toString());
			Thread.sleep(500);
		}
		if (inputArea.isDisplayed()) {
			inputArea.clear();
			inputArea.sendKeys(area);
			log("entered area:-" + area + " and object is " + inputArea.toString());
			Thread.sleep(1000);
		} else {
			log("area element not present and object is:-" + inputArea.toString());
			Thread.sleep(500);
		}
		if (selCountry.isDisplayed()) {
			select = new Select(selCountry);
			select.selectByVisibleText(Country);

			log("Selected country of address from the list: " + Country + " and object is:- " + selCountry.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), Country);
			Thread.sleep(1000);
		} else {
			log("country element is not present and object is:- " + selCountry.toString());
			Thread.sleep(500);
		}
		if (selState.isDisplayed()) {
			select = new Select(selState);
			select.selectByVisibleText(state);

			log("Selected State of address from the list: " + state + " and object is:- " + selState.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), state);
			Thread.sleep(1000);
		} else {
			log("State element is not present and object is:- " + selState.toString());
			Thread.sleep(500);
		}
		if (inputCity.isDisplayed()) {
			inputCity.clear();
			inputCity.sendKeys(city);
			log("entered city:-" + city + " and object is " + inputCity.toString());
			Thread.sleep(1000);
		} else {
			log("city element not present and object is:-" + inputCity.toString());
			Thread.sleep(500);
		}
		if (inputPinCodeZip.isDisplayed()) {
			inputPinCodeZip.clear();
			inputPinCodeZip.sendKeys(pinZip);
			log("entered pin/zip:-" + pinZip + " and object is " + inputPinCodeZip.toString());
			Thread.sleep(1000);
			//
			inputPinCodeZip.sendKeys(Keys.TAB);
			Thread.sleep(1000);
		} else {
			log("Zip element not present and object is:-" + inputPinCodeZip.toString());
			Thread.sleep(500);
		}
		boolean addressPermanent = chk_permaddsameAsResAdd.isSelected();

		if (addressPermanent) {
			log("Permanent Address Same As Residential Address ckeck box is already checked");
			Thread.sleep(1000);
		} else {
			chk_permaddsameAsResAdd.click();
			log("Permanent Address Same As Residential Address check box selected for mapping the address and object is:-"
					+ chk_permaddsameAsResAdd.toString());
			Thread.sleep(2000);
		}
		boolean afterSel = chk_permaddsameAsResAdd.isSelected();
		try {
			Assert.assertEquals(afterSel, true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Father's information for Pre admission application form
	 * 
	 * @param fatherName
	 * @param fatherSurName
	 * @param fatherQualification
	 * @param fatherOccupation
	 * @param fatherReligion
	 * @param fatherCaste
	 * @param fatherTribe
	 * @param fatherNationanlity
	 * @param fatherEmail
	 * @param fatherPhOffice
	 * @param fatherPhoneRes
	 * @param fatherMobile
	 * @throws Exception
	 */
	public void fathersDetails_PreAdmission_ApplicationForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherOccupation, String fatherReligion, String fatherCaste,
			String fatherTribe, String fatherNationanlity, String fatherEmail, String fatherPhOffice,
			String fatherPhoneRes, String fatherMobile) throws Exception {
		if (inputfatherName.isDisplayed()) {
			inputfatherName.clear();
			inputfatherName.sendKeys(fatherName);
			log("entered father's name:-" + fatherName + " and object is " + inputfatherName.toString());
			Thread.sleep(1000);
		} else {
			log("father's name element not present and object is:-" + inputfatherName.toString());
			Thread.sleep(500);
		}
		if (inputfathersurname.isDisplayed()) {
			inputfathersurname.clear();
			inputfathersurname.sendKeys(fatherSurName);
			log("entered father's surname:-" + fatherSurName + " and object is " + inputfathersurname.toString());
			Thread.sleep(1000);
		} else {
			log("father's surname element not present and object is:-" + inputfathersurname.toString());
			Thread.sleep(500);
		}
		if (inputfatherQualification.isDisplayed()) {
			inputfatherQualification.clear();
			inputfatherQualification.sendKeys(fatherQualification);
			log("entered father's Qualification:-" + fatherQualification + " and object is "
					+ inputfatherQualification.toString());
			Thread.sleep(1000);
		} else {
			log("father's Qualification element not present and object is:-" + inputfatherQualification.toString());
			Thread.sleep(500);
		}
		if (inputfatherOccupation.isDisplayed()) {
			inputfatherOccupation.clear();
			inputfatherOccupation.sendKeys(fatherOccupation);
			log("entered father's Occupation:-" + fatherOccupation + " and object is "
					+ inputfatherOccupation.toString());
			Thread.sleep(1000);
		} else {
			log("father's Occupation element not present and object is:-" + inputfatherQualification.toString());
			Thread.sleep(500);
		}
		if (selfatherReligion.isDisplayed()) {
			select = new Select(selfatherReligion);
			select.selectByVisibleText(fatherReligion);

			log("Selected Religion of FAther: " + fatherReligion + " and object is:- " + selfatherReligion.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), fatherReligion);
			Thread.sleep(1000);
		} else {
			log("Religion of FAther element is not present and object is:- " + selfatherReligion.toString());
			Thread.sleep(500);
		}
		if (selfatherCaste.isDisplayed()) {
			select = new Select(selfatherCaste);
			select.selectByVisibleText(fatherCaste);

			log("Selected Caste of Father: " + fatherCaste + " and object is:- " + selfatherCaste.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), fatherCaste);
			Thread.sleep(1000);
		} else {
			log("Caste of Father element is not present and object is:- " + selfatherCaste.toString());
			Thread.sleep(500);
		}
		if (inputfatherTribe.isDisplayed()) {
			inputfatherTribe.clear();
			inputfatherTribe.sendKeys(fatherTribe);
			log("entered father's Tribe:-" + fatherTribe + " and object is " + inputfatherTribe.toString());
			Thread.sleep(1000);
		} else {
			log("father's Tribe element not present and object is:-" + inputfatherTribe.toString());
			Thread.sleep(500);
		}

		if (sel_fathersNationality.isDisplayed()) {
			select = new Select(sel_fathersNationality);
			select.selectByVisibleText(fatherNationanlity);

			log("Selected Nationality of Father: " + fatherNationanlity + " and object is:- "
					+ sel_fathersNationality.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), fatherNationanlity);
			Thread.sleep(1000);
		} else {
			log("Nationality of Father element is not present and object is:- " + sel_fathersNationality.toString());
			Thread.sleep(500);
		}
		if (inputFathersEmailId.isDisplayed()) {
			inputFathersEmailId.clear();
			inputFathersEmailId.sendKeys(fatherEmail);
			log("entered father's Email:-" + fatherEmail + " and object is " + inputFathersEmailId.toString());
			Thread.sleep(1000);
		} else {
			log("father's Email element not present and object is:-" + inputFathersEmailId.toString());
			Thread.sleep(500);
		}
		if (inputfathers_PhOffice.isDisplayed()) {
			inputfathers_PhOffice.clear();
			inputfathers_PhOffice.sendKeys(fatherPhOffice);
			log("entered father's office phone Num:-" + fatherPhOffice + " and object is "
					+ inputfathers_PhOffice.toString());
			Thread.sleep(1000);
		} else {
			log("father's Phone office element not present and object is:-" + inputfatherTribe.toString());
			Thread.sleep(500);
		}
		if (inputfathers_PhResidence.isDisplayed()) {
			inputfathers_PhResidence.clear();
			inputfathers_PhResidence.sendKeys(fatherPhoneRes);
			log("entered father's residence phone Num:-" + fatherPhoneRes + " and object is "
					+ inputfathers_PhResidence.toString());
			Thread.sleep(1000);
		} else {
			log("father's Phone residence element not present and object is:-" + inputfathers_PhResidence.toString());
			Thread.sleep(500);
		}
		if (input_fatherMobile.isDisplayed()) {
			input_fatherMobile.clear();
			input_fatherMobile.sendKeys(fatherMobile);
			log("entered father's mobile:-" + fatherMobile + " and object is " + input_fatherMobile.toString());
			Thread.sleep(1000);
		} else {
			log("father's mobile element not present and object is:-" + input_fatherMobile.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Mother's information for BGHS pre admission application form
	 * 
	 * @param motherName
	 * @param motherSurName
	 * @param motherQualification
	 * @param motherService
	 * @param motherDesignation
	 * @param motherNationanlity
	 * @param motherOfficeAddr
	 * @param motherPhOffice
	 * @param motherPhoneRes
	 * @param motherMobile
	 * @throws Exception
	 */

	public void mothersDetails_PreAdmission_ApplicationForm(String motherName, String motherSurName,
			String motherQualification, String motherOccupation, String motherReligion, String motherCaste,
			String motherTribe, String motherNationanlity, String motherEmail, String motherPhOffice,
			String motherPhoneRes, String motherMobile) throws Exception {
		if (inputmotherName.isDisplayed()) {
			inputmotherName.clear();
			inputmotherName.sendKeys(motherName);
			log("entered mother's name:-" + motherName + " and object is " + inputmotherName.toString());
			Thread.sleep(1000);
		} else {
			log("Mother's name element not present and object is:-" + inputmotherName.toString());
			Thread.sleep(500);
		}
		if (inputmothersurname.isDisplayed()) {
			inputmothersurname.clear();
			inputmothersurname.sendKeys(motherSurName);
			log("entered mother's surname:-" + motherSurName + " and object is " + inputmothersurname.toString());
			Thread.sleep(1000);
		} else {
			log("Mother's surname element not present and object is:-" + inputmothersurname.toString());
			Thread.sleep(500);
		}

		if (inputmotherQualification.isDisplayed()) {
			inputmotherQualification.clear();
			inputmotherQualification.sendKeys(motherQualification);
			log("entered mother's Qualification:-" + motherQualification + " and object is "
					+ inputmotherQualification.toString());
			Thread.sleep(1000);
		} else {
			log("Mother's Qualification element not present and object is:-" + inputmotherQualification.toString());
			Thread.sleep(500);
		}
		if (inputmotherOccupation.isDisplayed()) {
			inputmotherOccupation.clear();
			inputmotherOccupation.sendKeys(motherOccupation);
			log("entered mother's Occupation:-" + motherOccupation + " and object is "
					+ inputmotherOccupation.toString());
			Thread.sleep(1000);
		} else {
			log("Mother's Occupation element not present and object is:-" + inputmotherOccupation.toString());
			Thread.sleep(500);
		}

		if (selmotherReligion.isDisplayed()) {
			select = new Select(selmotherReligion);
			select.selectByVisibleText(motherReligion);

			log("Selected Religion of mother: " + motherReligion + " and object is:- " + selmotherReligion.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), motherReligion);
			Thread.sleep(1000);
		} else {
			log("Religion of mother element is not present and object is:- " + selmotherReligion.toString());
			Thread.sleep(500);
		}
		if (selfatherCaste.isDisplayed()) {
			select = new Select(selmotherCaste);
			select.selectByVisibleText(motherCaste);

			log("Selected Caste of mother: " + motherCaste + " and object is:- " + selmotherCaste.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), motherCaste);
			Thread.sleep(1000);
		} else {
			log("Caste of mother element is not present and object is:- " + selmotherCaste.toString());
			Thread.sleep(500);
		}
		if (inputmotherTribe.isDisplayed()) {
			inputmotherTribe.clear();
			inputmotherTribe.sendKeys(motherTribe);
			log("entered mother's Tribe:-" + motherTribe + " and object is " + inputmotherTribe.toString());
			Thread.sleep(1000);
		} else {
			log("mother's Tribe element not present and object is:-" + inputmotherTribe.toString());
			Thread.sleep(500);
		}

		if (sel_mothersNationality.isDisplayed()) {
			select = new Select(sel_mothersNationality);
			select.selectByVisibleText(motherNationanlity);

			log("Selected Nationality of mother: " + motherNationanlity + " and object is:- "
					+ sel_fathersNationality.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), motherNationanlity);
			Thread.sleep(1000);
		} else {
			log("Nationality of mother element is not present and object is:- " + sel_mothersNationality.toString());
			Thread.sleep(500);
		}
		if (inputmothersEmailId.isDisplayed()) {
			inputmothersEmailId.clear();
			inputmothersEmailId.sendKeys(motherEmail);
			log("entered mother's Email:-" + motherEmail + " and object is " + inputmothersEmailId.toString());
			Thread.sleep(1000);
		} else {
			log("mother's Email element not present and object is:-" + inputmothersEmailId.toString());
			Thread.sleep(500);
		}

		if (inputmothers_PhOffice.isDisplayed()) {
			inputmothers_PhOffice.clear();
			inputmothers_PhOffice.sendKeys(motherPhOffice);
			log("entered mother's office phone Num:-" + motherPhOffice + " and object is "
					+ inputmothers_PhOffice.toString());
			Thread.sleep(1000);
		} else {
			log("mother's Phone office element not present and object is:-" + inputmothers_PhOffice.toString());
			Thread.sleep(500);
		}
		if (inputmothers_PhResidence.isDisplayed()) {
			inputmothers_PhResidence.clear();
			inputmothers_PhResidence.sendKeys(motherPhoneRes);
			log("entered mother's residence phone Num:-" + motherPhoneRes + " and object is "
					+ inputmothers_PhResidence.toString());
			Thread.sleep(1000);
		} else {
			log("mother's Phone residence element not present and object is:-" + inputfathers_PhResidence.toString());
			Thread.sleep(500);
		}
		if (input_motherMobile.isDisplayed()) {
			input_motherMobile.clear();
			input_motherMobile.sendKeys(motherMobile);
			log("entered mother's mobile:-" + motherMobile + " and object is " + input_motherMobile.toString());
			Thread.sleep(1000);
		} else {
			log("mother's mobile element not present and object is:-" + input_motherMobile.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Parent's monthly income
	 * 
	 * @param fatherIncome
	 * @param motherIncome
	 * @param altContact
	 * @param altEmail
	 * @throws Exception
	 */
	public void parentMonthlyIncomeDetails_PreAdmissionApplication(String fatherIncome, String motherIncome,
			String altContact, String altEmail) throws Exception {
		if (input_fatherIncome.isDisplayed()) {
			input_fatherIncome.clear();
			input_fatherIncome.sendKeys(fatherIncome);
			log("entered father's income:-" + fatherIncome + " and object is " + input_fatherIncome.toString());
			Thread.sleep(1000);
		} else {
			log("father's income element not present and object is:-" + input_fatherIncome.toString());
			Thread.sleep(500);
		}
		if (input_motherIncome.isDisplayed()) {
			input_motherIncome.clear();
			input_motherIncome.sendKeys(motherIncome);
			log("entered mother's income:-" + motherIncome + " and object is " + input_motherIncome.toString());
			Thread.sleep(1000);
		} else {
			log("mother's income element not present and object is:-" + input_motherIncome.toString());
			Thread.sleep(500);
		}
		if (input_alternateContact.isDisplayed()) {
			input_alternateContact.clear();
			input_alternateContact.sendKeys(altContact);
			log("entered alternet contact:-" + altContact + " and object is " + input_alternateContact.toString());
			Thread.sleep(1000);
		} else {
			log("alternet contact element not present and object is:-" + input_alternateContact.toString());
			Thread.sleep(500);
		}
		if (input_alternateEmail.isDisplayed()) {
			input_alternateEmail.clear();
			input_alternateEmail.sendKeys(altEmail);
			log("entered alternet email:-" + altEmail + " and object is " + input_alternateEmail.toString());
			Thread.sleep(1000);
		} else {
			log("alternet email element not present and object is:-" + input_alternateEmail.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Guardian details BGHS
	 * 
	 * @param guardianName
	 * @param gurdianRelWithStu
	 * @param gurdianAddress
	 * @param guardianEmail
	 * @param guardianPhone
	 * @throws Exception
	 */

	public void gurdianDetails_PreAdmApplicationForm(String guardianName, String gurdianRelWithStu,
			String gurdianAddress, String guardianPhOffice, String guardianPhResidance) throws Exception {
		if (input_GuardianName.isDisplayed()) {
			input_GuardianName.clear();
			input_GuardianName.sendKeys(guardianName);
			log("entered guardian name:-" + guardianName + " and object is " + input_GuardianName.toString());
			Thread.sleep(1000);
		} else {
			log("guardian name element not present and object is:-" + input_GuardianName.toString());
			Thread.sleep(500);
		}
		if (input_GurRelationshipToStudent.isDisplayed()) {
			input_GurRelationshipToStudent.clear();
			input_GurRelationshipToStudent.sendKeys(gurdianRelWithStu);
			log("entered guardian relationship to student:-" + gurdianRelWithStu + " and object is "
					+ input_GurRelationshipToStudent.toString());
			Thread.sleep(1000);
		} else {
			log("guardian relationship element not present and object is:-"
					+ input_GurRelationshipToStudent.toString());
			Thread.sleep(500);
		}

		if (input_Gur_PhOffice.isDisplayed()) {
			input_Gur_PhOffice.clear();
			input_Gur_PhOffice.sendKeys(guardianPhOffice);
			log("entered guardian Phone Number office:-" + guardianPhOffice + " and object is "
					+ input_Gur_PhOffice.toString());
			Thread.sleep(1000);
		} else {
			log("guardian Phone Number office element not present and object is:-" + input_Gur_PhOffice.toString());
			Thread.sleep(500);
		}
		if (input_Gur_PhResidence.isDisplayed()) {
			input_Gur_PhResidence.clear();
			input_Gur_PhResidence.sendKeys(guardianPhResidance);
			log("entered guardian phone number Residance:-" + guardianPhResidance + " and object is "
					+ input_Gur_PhResidence.toString());
			Thread.sleep(1000);
		} else {
			log("guardian Phone Number Residance element not present and object is:-"
					+ input_Gur_PhResidence.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Sibling details for BGHS pune
	 * 
	 * @param siblingName
	 * @param siblingClass
	 * @param siblingAdmNo
	 * @throws Exception
	 */

	public void siblingDetails_PreAdmApplication(String siblingName, String siblingClass, String siblingAdmNo)
			throws Exception {
		if (inputsibName.isDisplayed()) {
			inputsibName.clear();
			inputsibName.sendKeys(siblingName);
			log("entered sibling name:-" + siblingName + " and object is " + inputsibName.toString());
			Thread.sleep(1000);
		} else {
			log("sibling name element not present and object is:-" + inputsibName.toString());
			Thread.sleep(500);
		}
		if (inputsibclass.isDisplayed()) {
			inputsibclass.clear();
			inputsibclass.sendKeys(siblingClass);
			log("entered sibling Class:-" + siblingClass + " and object is " + inputsibclass.toString());
			Thread.sleep(1000);
		} else {
			log("sibling Class element not present and object is:-" + inputsibclass.toString());
			Thread.sleep(500);
		}

		if (inputsibAdmNo.isDisplayed()) {
			inputsibAdmNo.clear();
			inputsibAdmNo.sendKeys(siblingAdmNo);
			log("entered sibling Admission number:-" + siblingAdmNo + " and object is " + inputsibAdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("sibling Admission number element not present and object is:-" + inputsibAdmNo.toString());
			Thread.sleep(500);
		}
		if (clickSibPlus.isDisplayed()) {
			clickSibPlus.click();
			log("cliked on plus sign to add rows:-" + clickSibPlus.toString());
			Thread.sleep(2000);
		} else {
			log("plus sign element not present and object is:-" + clickSibPlus.toString());
			Thread.sleep(500);
		}
		if (input2ndsibName.isDisplayed()) {
			input2ndsibName.clear();
			input2ndsibName.sendKeys(siblingName);
			log("entered 2nd sibling name:-" + siblingName + " and object is " + input2ndsibName.toString());
			Thread.sleep(1000);
		} else {
			log("2nd sibling name element not present and object is:-" + input2ndsibName.toString());
			Thread.sleep(500);
		}
		if (input2ndsibclass.isDisplayed()) {
			input2ndsibclass.clear();
			input2ndsibclass.sendKeys(siblingClass);
			log("entered 2nd sibling Class:-" + siblingClass + " and object is " + input2ndsibclass.toString());
			Thread.sleep(1000);
		} else {
			log("2nd sibling Class element not present and object is:-" + input2ndsibclass.toString());
			Thread.sleep(500);
		}
		if (input2ndsibAdmNo.isDisplayed()) {
			input2ndsibAdmNo.clear();
			input2ndsibAdmNo.sendKeys(siblingAdmNo);
			log("entered 2nd sibling Admission number:-" + siblingAdmNo + " and object is "
					+ input2ndsibAdmNo.toString());
			Thread.sleep(1000);
		} else {
			log("2nd sibling Admission number element not present and object is:-" + inputsibAdmNo.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Enter previous school details for pre admission application form
	 * 
	 * @param prevSchoolName
	 * @param prevClass
	 * @param prevGrade
	 * @param prevPassedYr
	 * @param PrevAddress
	 * @throws Exception
	 */

	public void previousSchoolDetails_PreAdmissionApplication(String prevSchoolName, String prevClass, String prevGrade,
			String prevPassedYr, String PrevAddress) throws Exception {
		if (inputSchoolName.isDisplayed()) {
			inputSchoolName.clear();
			inputSchoolName.sendKeys(prevSchoolName);
			log("entered previous school name:-" + prevSchoolName + " and object is " + inputSchoolName.toString());
			Thread.sleep(1000);
		} else {
			log("previous school name element not present and object is:-" + inputSchoolName.toString());
			Thread.sleep(500);
		}
		if (inputClass.isDisplayed()) {
			inputClass.clear();
			inputClass.sendKeys(prevClass);
			log("entered previous class:-" + prevClass + " and object is " + inputClass.toString());
			Thread.sleep(1000);
		} else {
			log("previous class element not present and object is:-" + inputClass.toString());
			Thread.sleep(500);
		}
		if (inputGrade.isDisplayed()) {
			inputGrade.clear();
			inputGrade.sendKeys(prevGrade);
			log("entered previous grade:-" + prevGrade + " and object is " + inputGrade.toString());
			Thread.sleep(1000);
		} else {
			log("previous grade element not present and object is:-" + inputClass.toString());
			Thread.sleep(500);
		}
		if (inputPassedYr.isDisplayed()) {
			inputPassedYr.clear();
			inputPassedYr.sendKeys(prevPassedYr);
			log("entered previous passed year:-" + prevPassedYr + " and object is " + inputPassedYr.toString());
			Thread.sleep(1000);
		} else {
			log("previous passed year element not present and object is:-" + inputPassedYr.toString());
			Thread.sleep(500);
		}
		if (inputAddress.isDisplayed()) {
			inputAddress.clear();
			inputAddress.sendKeys(PrevAddress);
			log("entered Address:-" + PrevAddress + " and object is " + inputAddress.toString());
			Thread.sleep(1000);
		} else {
			log("Address element not present and object is:-" + inputAddress.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * Upload Student Photo
	 * 
	 * @throws Exception
	 */
	public void upload_StudentPhoto() throws Exception {
		if (btn_BrowseImg_Child.isDisplayed()) {

			imageAndDocumentUpload(btn_BrowseImg_Child, "Photo.jpg");
			log("Student Image uploded");
			Thread.sleep(2000);
		} else {
			log("Student Image element not present and object is:-" + btn_BrowseImg_Child.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * Upload Father Photo
	 * 
	 * @throws Exception
	 */
	public void upload_FatherPhoto() throws Exception {
		if (btn_BrowseImg_Father.isDisplayed()) {

			imageAndDocumentUpload(btn_BrowseImg_Father, "Father.jpg");
			log("Father Image uploded");
			Thread.sleep(2000);
		} else {
			log("Father Image element not present and object is:-" + btn_BrowseImg_Father.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * Upload Mother Photo
	 * 
	 * @throws Exception
	 */
	public void upload_MotherPhoto() throws Exception {
		if (btn_BrowseImg_Mother.isDisplayed()) {

			imageAndDocumentUpload(btn_BrowseImg_Mother, "Father.jpg");
			log("Mother Image uploded");
			Thread.sleep(2000);
		} else {
			log("Mother Image element not present and object is:-" + btn_BrowseImg_Mother.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * Upload date of birth certificate
	 * 
	 * @throws Exception
	 */
	public void uploadRequiredDocuments() throws Exception {
		if (uploadDOBCert.isDisplayed()) {

			imageAndDocumentUpload(uploadDOBCert, "TransferCertificate.jpg");
			log("Date of birth certificate uploded");
			Thread.sleep(2000);
		} else {
			log("Date of birth certificate element not present and object is:-" + uploadDOBCert.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * click on view button after upload of Date of birth certificate
	 * 
	 * @throws InterruptedException
	 */
	public void validationOfUploadedDOBCertificate() throws InterruptedException {
		if (viewUploadDOBCert.isDisplayed()) {
			viewUploadDOBCert.click();
			log("Date of birth certificate validated");
			Thread.sleep(3000);
		} else {
			log("View Uploaded certificate element not present and object is:-" + uploadDOBCert.toString());
			Thread.sleep(500);
		}

	}

	/**
	 * View uploaded documents popup close button
	 * 
	 * @throws Exception
	 */
	public void clickOnPopupCloseButton() throws Exception {
		if (btnPopUpClose.isDisplayed()) {
			btnPopUpClose.click();
			Thread.sleep(2000);
			log("Uploaded documents validation done and opened window closed.");
		} else {
			log("Close button element not present and object is:-" + btnPopUpClose.toString());
			Thread.sleep(500);
		}
	}

	//

	/**
	 * Verify undertaking message is display and confirm the undertaking
	 */
	public boolean verifyUndertakingText(String textToVerify) {

		String undertakingtext = undertakingText.getText();

		System.out.println(undertakingtext);
		try {
			Assert.assertEquals(undertakingtext, textToVerify);
			log("undertaking message is vedidated and object is:-" + undertakingText.toString());
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Select undertaking yes radio button
	 * 
	 * @throws Exception
	 */
	public void confirmUndertakingYes() throws Exception {

		if (!rdBtnundertakingYes.isSelected()) {

			rdBtnundertakingYes.click();
			log("Undertaking radio button for yes is selected");
			Thread.sleep(2000);
		} else {
			log("Radio button is already selected");
		}

	}

	/**
	 * After filling of admission form, select submit button
	 * 
	 * @throws Exception
	 */

	public void clickOnSubmitButton() throws Exception {
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
			log("clicked on Submit button and object is:-" + btnSubmit.toString());
			Thread.sleep(2000);
		} else {
			log("Submit button element not present and object is:-" + btnSubmit.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Select cancel button to cancel the admission form submission
	 * 
	 * @throws Exception
	 */
	public void popUpValidationCancel() throws Exception {
		btnsubmitCancel.click();
		log("Submit confirmation popup cancel button clicked and object is:-" + btnsubmitCancel.toString());
		Thread.sleep(5000);
	}

	/**
	 * Select Yes for Submission of admission form
	 * 
	 * @throws InterruptedException
	 */
	public void popUpValidationYes() throws InterruptedException {
		btnsubmitYes.click();
		log("Submit confirmation popup Yes button clicked and object is:-" + btnsubmitYes.toString());
		Thread.sleep(10000);
	}

	/**
	 * Ok button validation on successful submission of admission form
	 * 
	 * @throws InterruptedException
	 */
	public void popUpValidationOnSuccess() throws InterruptedException {
		btnOkonsuccess.click();
		log("Submit confirmation popup successful registration ok button clicked and object is:-"
				+ btnOkonsuccess.toString());
		Thread.sleep(3000);
	}

	/**
	 * Search with father name
	 * 
	 * @param FatherName
	 * @throws Exception
	 */
	public void searchByStudentNameInGrid(String studentName) throws Exception {
		if (inputSearch.isDisplayed()) {
		
		inputSearch.clear();
		inputSearch.sendKeys(studentName);
		log("Entered Student name:" + studentName + " and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
		} else {
			log("Search button element not present and object is:-" + inputSearch.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Verify father name for search is available in the grid
	 * 
	 * @param FatherName
	 * @throws Exception
	 */
	public void verifyFatherNameInStudentListGrid(String studentName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String StuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + StuName);
			Thread.sleep(2000);
			if (StuName.equalsIgnoreCase(studentName)) {
				try {
					Assert.assertEquals(StuName, studentName);
					log("Father name matched with the Student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Edit admission form for BCEHS
	 * 
	 * @param FatherName
	 * @throws Exception
	 */

	public void searchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm(String studentName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String StuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Father Name: " + StuName);
			Thread.sleep(2000);
			if (StuName.equalsIgnoreCase(studentName)) {
				try {
					Assert.assertEquals(StuName, studentName);

					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[7]/span"))
							.click();
					log("Clicked on the edit link in the student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
