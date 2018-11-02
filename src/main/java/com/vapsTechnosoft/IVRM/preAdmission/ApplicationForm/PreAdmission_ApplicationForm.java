/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.ApplicationForm;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	// @FindBy(xpath =
	// "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Application
	// Form')][1]/following::li[2]")
	// private WebElement btn_ApplicationForm;

	@FindBy(xpath = "//a[@href='#/app/BCEHS/300']")
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

	@FindBy(xpath = "//table//tbody//tr/td[contains(text(),'2016')]")
	private WebElement btn_Year2;

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

	@FindBy(xpath = "(//table//tbody)[4]/tr")
	private List<WebElement> tblRows_DocumentUpload;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr")
	private List<WebElement> tblRows;

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
	@FindBy(xpath = "//button[@class='cancel']")
	private WebElement btnsubmitCancel;

	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement btnsubmitYes;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	private WebElement btnOkonsuccess;

	/**
	 * table data validation
	 */

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[5]/tbody/tr")
	List<WebElement> tblRowStuList;

	@FindBy(xpath = "//button[text()='Print']")
	private WebElement btn_Print;

	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btn_ViewAppl_Close;

	public PreAdmission_ApplicationForm(WebDriver driver) {
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
	 * Navigate to Application Form(PreAdmission>PreAdmission
	 * Application>Application Form)
	 * 
	 * @throws Exception
	 */
	public void navigateToPreAdmission_ApplicationForm() throws Exception {

		clickOnButton(btn_PreAdmission);
		log("Clicked on Pre admission Button and object is:-" + btn_PreAdmission.toString());

		clickOnButton(btn_PreAdmissionApplication);
		log("Clicked on PreAdmission Application link Button and object is:-" + btn_PreAdmissionApplication.toString());

		clickOnButton(btn_ApplicationForm);
		log("Clicked on Application form pre admission Button and object is:-" + btn_ApplicationForm.toString());

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
			Thread.sleep(2000);
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

		inputTextIntoInputField(input_FirstName, fName);
		log("Entered first name:-" + fName + " and object is " + input_FirstName.toString());

		inputTextIntoInputField(input_MiddleName, mName);
		log("Entered Middle name:-" + mName + " and object is " + input_MiddleName.toString());

		inputTextIntoInputField(input_SurName, sName);
		log("Entered Surname name:-" + sName + " and object is " + input_SurName.toString());

		inputTextIntoInputField(input_MobileNumberChild, mNumber);
		log("Entered Mobile Number(Child):-" + mNumber + " and object is " + input_MobileNumberChild.toString());

		inputTextIntoInputField(input_PlaceOfbirth, birthPlace);
		log("Entered Place of Birth(Child):-" + birthPlace + " and object is " + input_PlaceOfbirth.toString());

		selectElementFromDropDown(sel_ReligionStudent, religion);
		log("Selected Religion of Student: " + religion + " and object is:- " + sel_ReligionStudent.toString());

		selectElementFromDropDown(sel_CasteChild, caste);
		log("Selected Caste of Student: " + caste + " and object is:- " + sel_CasteChild.toString());

		selectElementFromDropDown(sel_GenderChild, gender);
		log("Selected Gender of Student: " + gender + " and object is:- " + sel_GenderChild.toString());

		clickOnButton(btn_Calender_DoB);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_MonthYear);
		Thread.sleep(1000);
		btn_MonthYear.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Year2);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn_Year);
		Thread.sleep(1000);
		btn_Month.click();
		Thread.sleep(1000);
		btn_Date.click();
		log("Date of Birth is selected from calender.");
		Thread.sleep(1000);

		selectElementFromDropDown(sel_ApplingForClass, apply_class);
		log("Selected Class: " + apply_class + " and object is:- " + sel_ApplingForClass.toString());

		inputTextIntoInputField(input_EmailIDChild, email);
		log("Entered Eamil id:-" + email + " and object is " + input_EmailIDChild.toString());

		selectedDropdownItemValidation(sel_DisableacademicYear, academicYear);
		log("Academic year selected is corret and object is:- " + sel_DisableacademicYear.toString());
		Thread.sleep(1000);

		selectElementFromDropDown(sel_NationalityChild, nationality);
		log("Selected Nationality child: " + nationality + " and object is:- " + sel_NationalityChild.toString());

		inputTextIntoInputField(input_MotherTongue, motherTongue);
		log("Entered Mother Tongue:-" + motherTongue + " and object is " + input_MotherTongue.toString());

		// selectElementFromDropDown(sel_LastSchoolSyllabus, syllabus);
		// log("Selected last school syllabus: " + syllabus + " and object is:-
		// " + sel_LastSchoolSyllabus.toString());

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

		selectElementFromDropDown(sel_2ndLanguage, secondLang);
		log("Selected 2nd Language: " + secondLang + " and object is:- " + sel_2ndLanguage.toString());

		selectElementFromDropDown(sel_3rddLanguage, thirdLang);
		log("Selected 3nd Language: " + thirdLang + " and object is:- " + sel_3rddLanguage.toString());

		inputTextIntoInputField(input_Tribe, tribe);
		log("Entered Tribe:-" + tribe + " and object is " + input_Tribe.toString());

		inputTextIntoInputField(input_PlayGroup, playGroup);
		log("Entered Play Group:-" + playGroup + " and object is " + input_PlayGroup.toString());

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

		inputTextIntoInputField(inputStreet, street);
		log("Entered street:-" + street + " and object is " + inputStreet.toString());

		inputTextIntoInputField(inputArea, area);
		log("entered area:-" + area + " and object is " + inputArea.toString());

		selectElementFromDropDown(selCountry, Country);
		log("Selected country of address from the list: " + Country + " and object is:- " + selCountry.toString());

		selectElementFromDropDown(selState, state);
		log("Selected State of address from the list: " + state + " and object is:- " + selState.toString());

		inputTextIntoInputField(inputCity, city);
		log("entered city:-" + city + " and object is " + inputCity.toString());

		inputTextIntoInputField(inputPinCodeZip, pinZip);
		log("entered pin/zip:-" + pinZip + " and object is " + inputPinCodeZip.toString());
		// Thread.sleep(1000);
		//
		inputPinCodeZip.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		isDisplayed(chk_permaddsameAsResAdd);
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean afterSel = chk_permaddsameAsResAdd.isSelected();
		try {
			Assert.assertEquals(afterSel, true);
		} catch (Exception e) {
			e.printStackTrace();
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

		inputTextIntoInputField(inputfatherName, fatherName);
		log("entered father's name:-" + fatherName + " and object is " + inputfatherName.toString());
		Thread.sleep(1000);

		inputTextIntoInputField(inputfathersurname, fatherSurName);
		log("entered father's surname:-" + fatherSurName + " and object is " + inputfathersurname.toString());
		Thread.sleep(1000);

		inputTextIntoInputField(inputfatherQualification, fatherQualification);
		log("entered father's Qualification:-" + fatherQualification + " and object is "
				+ inputfatherQualification.toString());

		inputTextIntoInputField(inputfatherOccupation, fatherOccupation);
		log("entered father's Occupation:-" + fatherOccupation + " and object is " + inputfatherOccupation.toString());

		selectElementFromDropDown(selfatherReligion, fatherReligion);
		log("Selected Religion of FAther: " + fatherReligion + " and object is:- " + selfatherReligion.toString());

		selectElementFromDropDown(selfatherCaste, fatherCaste);
		log("Selected Caste of Father: " + fatherCaste + " and object is:- " + selfatherCaste.toString());

		inputTextIntoInputField(inputfatherTribe, fatherTribe);
		log("entered father's Tribe:-" + fatherTribe + " and object is " + inputfatherTribe.toString());

		selectElementFromDropDown(sel_fathersNationality, fatherNationanlity);
		log("Selected Nationality of Father: " + fatherNationanlity + " and object is:- "
				+ sel_fathersNationality.toString());

		inputTextIntoInputField(inputFathersEmailId, fatherEmail);
		log("entered father's Email:-" + fatherEmail + " and object is " + inputFathersEmailId.toString());

		inputTextIntoInputField(inputfathers_PhOffice, fatherPhOffice);
		log("entered father's office phone Num:-" + fatherPhOffice + " and object is "
				+ inputfathers_PhOffice.toString());

		inputTextIntoInputField(inputfathers_PhResidence, fatherPhoneRes);
		log("entered father's residence phone Num:-" + fatherPhoneRes + " and object is "
				+ inputfathers_PhResidence.toString());

		inputTextIntoInputField(input_fatherMobile, fatherMobile);
		log("entered father's mobile:-" + fatherMobile + " and object is " + input_fatherMobile.toString());

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

		inputTextIntoInputField(inputmotherName, motherName);
		log("entered mother's name:-" + motherName + " and object is " + inputmotherName.toString());

		inputTextIntoInputField(inputmothersurname, motherSurName);
		log("entered mother's surname:-" + motherSurName + " and object is " + inputmothersurname.toString());

		inputTextIntoInputField(inputmotherQualification, motherQualification);
		log("entered mother's Qualification:-" + motherQualification + " and object is "
				+ inputmotherQualification.toString());

		inputTextIntoInputField(inputmotherOccupation, motherOccupation);
		log("entered mother's Occupation:-" + motherOccupation + " and object is " + inputmotherOccupation.toString());

		selectElementFromDropDown(selmotherReligion, motherReligion);
		log("Selected Religion of mother: " + motherReligion + " and object is:- " + selmotherReligion.toString());

		selectElementFromDropDown(selmotherCaste, motherCaste);
		log("Selected Caste of mother: " + motherCaste + " and object is:- " + selmotherCaste.toString());

		inputTextIntoInputField(inputmotherTribe, motherTribe);
		log("entered mother's Tribe:-" + motherTribe + " and object is " + inputmotherTribe.toString());

		selectElementFromDropDown(sel_mothersNationality, motherNationanlity);
		log("Selected Nationality of mother: " + motherNationanlity + " and object is:- "
				+ sel_fathersNationality.toString());

		inputTextIntoInputField(inputmothersEmailId, motherEmail);
		log("entered mother's Email:-" + motherEmail + " and object is " + inputmothersEmailId.toString());

		inputTextIntoInputField(inputmothers_PhOffice, motherPhOffice);
		log("entered mother's office phone Num:-" + motherPhOffice + " and object is "
				+ inputmothers_PhOffice.toString());

		inputTextIntoInputField(inputmothers_PhResidence, motherPhoneRes);
		log("entered mother's residence phone Num:-" + motherPhoneRes + " and object is "
				+ inputmothers_PhResidence.toString());

		inputTextIntoInputField(input_motherMobile, motherMobile);
		log("entered mother's mobile:-" + motherMobile + " and object is " + input_motherMobile.toString());

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

		inputTextIntoInputField(input_fatherIncome, fatherIncome);
		log("entered father's income:-" + fatherIncome + " and object is " + input_fatherIncome.toString());

		inputTextIntoInputField(input_motherIncome, motherIncome);
		log("entered mother's income:-" + motherIncome + " and object is " + input_motherIncome.toString());

		inputTextIntoInputField(input_alternateContact, altContact);
		log("entered alternet contact:-" + altContact + " and object is " + input_alternateContact.toString());

		inputTextIntoInputField(input_alternateEmail, altEmail);
		log("entered alternet email:-" + altEmail + " and object is " + input_alternateEmail.toString());

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
			String gurdianOccupation, String guardianPhOffice, String guardianPhResidance) throws Exception {

		inputTextIntoInputField(input_GuardianName, guardianName);
		log("entered guardian name:-" + guardianName + " and object is " + input_GuardianName.toString());

		inputTextIntoInputField(input_GurRelationshipToStudent, gurdianRelWithStu);
		log("entered guardian relationship to student:-" + gurdianRelWithStu + " and object is "
				+ input_GurRelationshipToStudent.toString());

		inputTextIntoInputField(input_Gur_Occupation, gurdianOccupation);
		log("entered guardian Occupation to student:-" + gurdianOccupation + " and object is "
				+ input_Gur_Occupation.toString());

		inputTextIntoInputField(input_Gur_PhOffice, guardianPhOffice);
		log("entered guardian Phone Number office:-" + guardianPhOffice + " and object is "
				+ input_Gur_PhOffice.toString());

		inputTextIntoInputField(input_Gur_PhResidence, guardianPhResidance);
		log("entered guardian phone number Residance:-" + guardianPhResidance + " and object is "
				+ input_Gur_PhResidence.toString());

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

		inputTextIntoInputField(inputsibName, siblingName);
		log("entered sibling name:-" + siblingName + " and object is " + inputsibName.toString());

		inputTextIntoInputField(inputsibclass, siblingClass);
		log("entered sibling Class:-" + siblingClass + " and object is " + inputsibclass.toString());

		inputTextIntoInputField(inputsibAdmNo, siblingAdmNo);
		log("entered sibling Admission number:-" + siblingAdmNo + " and object is " + inputsibAdmNo.toString());

		clickOnButton(clickSibPlus);
		log("cliked on plus sign to add rows:-" + clickSibPlus.toString());

		inputTextIntoInputField(input2ndsibName, siblingName);
		log("entered 2nd sibling name:-" + siblingName + " and object is " + input2ndsibName.toString());

		inputTextIntoInputField(input2ndsibclass, siblingClass);
		log("entered 2nd sibling Class:-" + siblingClass + " and object is " + input2ndsibclass.toString());

		inputTextIntoInputField(input2ndsibAdmNo, siblingAdmNo);
		log("entered 2nd sibling Admission number:-" + siblingAdmNo + " and object is " + input2ndsibAdmNo.toString());

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

		inputTextIntoInputField(inputSchoolName, prevSchoolName);
		log("entered previous school name:-" + prevSchoolName + " and object is " + inputSchoolName.toString());

		inputTextIntoInputField(inputClass, prevClass);
		log("entered previous class:-" + prevClass + " and object is " + inputClass.toString());

		inputTextIntoInputField(inputGrade, prevGrade);
		log("entered previous grade:-" + prevGrade + " and object is " + inputGrade.toString());

		inputTextIntoInputField(inputPassedYr, prevPassedYr);
		log("entered previous passed year:-" + prevPassedYr + " and object is " + inputPassedYr.toString());

		inputTextIntoInputField(inputAddress, PrevAddress);
		log("entered Address:-" + PrevAddress + " and object is " + inputAddress.toString());

	}

	/**
	 * Upload Student Photo
	 * 
	 * @throws Exception
	 */
	public void upload_StudentPhoto() throws Exception {
		try {
			if (btn_BrowseImg_Child.isDisplayed()) {

				imageAndDocumentUpload(btn_BrowseImg_Child, "Photo.jpg");
				log("Student Image uploded");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Upload Father Photo
	 * 
	 * @throws Exception
	 */
	public void upload_FatherPhoto() throws Exception {
		try {
			if (btn_BrowseImg_Father.isDisplayed()) {

				imageAndDocumentUpload(btn_BrowseImg_Father, "Father.jpg");
				log("Father Image uploded");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Upload Mother Photo
	 * 
	 * @throws Exception
	 */
	public void upload_MotherPhoto() throws Exception {
		try {
			if (btn_BrowseImg_Mother.isDisplayed()) {

				imageAndDocumentUpload(btn_BrowseImg_Mother, "Father.jpg");
				log("Mother Image uploded");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Document Upload

	public void uploadAndViewUploadedDocument() throws Exception {
		try {
			int rowsUpload = tblRows_DocumentUpload.size();
			System.out.println(rowsUpload);
			Thread.sleep(2000);
			for (int i = 1; i <= rowsUpload; i++) {
				WebElement documents = driver.findElement(By.xpath("(//table//tbody)[4]/tr[" + i + "]/td[3]/label"));
				Thread.sleep(1000);
				imageAndDocumentUpload(documents, "TransferCertificate.jpg");
				log(i + " Documents uploded");
				Thread.sleep(10000);
				WebElement views = driver.findElement(By.xpath("(//table//tbody)[4]/tr[" + i + "]/td[4]/span"));
				//views.click();
				clickOnButton(views);
				log(i + " uploded Documents viewed.");
				Thread.sleep(2000);
				btnPopUpClose.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Upload date of birth certificate
	 * 
	 * @throws Exception
	 */
	public void uploadRequiredDocuments() throws Exception {
		try {
			if (uploadDOBCert.isDisplayed()) {

				imageAndDocumentUpload(uploadDOBCert, "TransferCertificate.jpg");
				log("Date of birth certificate uploded");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * click on view button after upload of Date of birth certificate
	 * 
	 * @throws InterruptedException
	 */
	public void validationOfUploadedDOBCertificate() throws InterruptedException {
		try {
			if (viewUploadDOBCert.isDisplayed()) {
				viewUploadDOBCert.click();
				log("Date of birth certificate validated");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * View uploaded documents popup close button
	 * 
	 * @throws Exception
	 */
	public void clickOnPopupCloseButton() throws Exception {

				clickOnButton(btnPopUpClose);
				log("Uploaded documents validation done and opened window closed.");
				Thread.sleep(1000);
	}

	//

	/**
	 * Verify undertaking message is display and confirm the undertaking
	 */
	public boolean verifyUndertakingText(String textToVerify) {
		isDisplayed(undertakingText);
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
		isDisplayed(rdBtnundertakingYes);
		try {
			
			if (!rdBtnundertakingYes.isSelected()) {

				rdBtnundertakingYes.click();
				log("Undertaking radio button for yes is selected");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnSubmitButton_submitBlankForm() throws Exception {

		clickOnButton(btnSubmit);
		log("clicked on Submit button to submit blank form and object is:-" + btnSubmit.toString());
		Thread.sleep(2000);
	}

	/**
	 * After filling of admission form, select submit button
	 * 
	 * @throws Exception
	 */

	public void clickOnSubmitButton() throws Exception {

		clickOnButton(btnSubmit);
		Thread.sleep(3000);
		assertEquals(btnsubmitYes.getText().trim(), "Yes!");
		log("clicked on Submit button and object is:-" + btnSubmit.toString());
		
	}

	/**
	 * Select cancel button to cancel the admission form submission
	 * 
	 * @throws Exception
	 */
	public void popUpValidationCancel() throws Exception {

		clickOnButton(btnsubmitCancel);
		log("Submit confirmation popup cancel button clicked and object is:-" + btnsubmitCancel.toString());
		Thread.sleep(2000);
	}

	/**
	 * Select Yes for Submission of admission form
	 * 
	 * @throws InterruptedException
	 */
	public void popUpValidationYes() throws InterruptedException {

		clickOnButton(btnsubmitYes);
		log("Submit confirmation popup Yes button clicked and object is:-" + btnsubmitYes.toString());
		Thread.sleep(3000);

	}

	/**
	 * Ok button validation on successful submission of admission form
	 * 
	 * @throws InterruptedException
	 */
	public void popUpValidationOnSuccess() throws InterruptedException {

		clickOnButton(btnOkonsuccess);
		log("Submit confirmation popup successful registration ok button clicked and object is:-"
				+ btnOkonsuccess.toString());
		Thread.sleep(1000);

	}

	/**
	 * Search with student name
	 * 
	 * @param studentName
	 * @throws Exception
	 */
	public void searchByStudentNameInGrid(String studentName) throws Exception {

		inputTextIntoInputField(inputSearch, studentName);
		log("Entered Student name:" + studentName + " and object is:-" + inputSearch.toString());
		Thread.sleep(1000);

	}

	/**
	 * Verify father name for search is available in the grid
	 * 
	 * @param studentName
	 * @throws Exception
	 */
	public void verifyStudentNameInStudentListGrid(String studentName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			String StuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + StuName);
			Thread.sleep(2000);
			if (StuName.equalsIgnoreCase(studentName)) {
				
					Assert.assertEquals(StuName, studentName);
					log("Father name matched with the Student list grid");
					Thread.sleep(3000);
					break;
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit admission form for BCEHS
	 * 
	 * @param studentName
	 * @throws Exception
	 */

	public void edit_PreAdmissionApplicationForm(String studentName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			String StuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Father Name: " + StuName);
			Thread.sleep(2000);
			if (StuName.equalsIgnoreCase(studentName)) {
				
					Assert.assertEquals(StuName, studentName);

					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[7]/span"))
							.click();
					log("Clicked on the edit link in the student list grid");
					Thread.sleep(3000);
					break;
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void view_PreAdmissionApplicationForm(String studentName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		try {
		for (int i = 1; i <= rows; i++) {
			String StuName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Student Name: " + StuName);
			Thread.sleep(2000);
			if (StuName.equalsIgnoreCase(studentName)) {
				
					Assert.assertEquals(StuName, studentName);

					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[8]/span"))
							.click();
					log("Clicked on the view link in the student list grid");
					Thread.sleep(3000);
					break;
				
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void clickOnPrint_ForPrintPreview() throws Exception {

		String parentWin = driver.getWindowHandle();
		try {
			if (btn_Print.isDisplayed()) {
				String print = btn_Print.getText().trim();
				System.out.println(print);
				Assert.assertEquals(print, "Print");

				btn_Print.click();
				log("Print button is clicked to generate report and object is:-" + btn_Print.toString());
				Thread.sleep(3000);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> allWin = driver.getWindowHandles();

		System.out.println("Page title before Switching : " + driver.getTitle());
		System.out.println("Total Windows : " + allWin.size());

		for (String windows : allWin) {
			// if(!windows.equals(parentWin)){
			driver.switchTo().window(windows);

			if (driver.getTitle().toLowerCase().contains("Print")) {
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
				Thread.sleep(2000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(1000);
	}

	public void closeViewApplicationWindow() throws Exception {
	
			clickOnButton(btn_ViewAppl_Close);
			log("View application form window is closed and object is:-" + btn_ViewAppl_Close.toString());
			Thread.sleep(2000);
		
	}

}
