/**
 * 
 */
package com.vapsTechnosoft.IVRM.BCEHS_PreAdmission;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class Admission_Form_BCEHS extends TestBase {

	public static final Logger log = Logger.getLogger(Admission_Form_BCEHS.class.getName());

	WebDriver driver;
	Select select;
	ArrayList<String> tabs2;

	/**
	 * Admission from Student section locators
	 */
	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[3]")
	WebElement btnPre_Admission;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[3]/ul/li[6]")
	WebElement btnStudent_Admission;

	// @FindBy(xpath = "//span[contains(text(),'Application Form')]")
	// WebElement btnForm_Admission;

	// @FindBy(xpath = "//span[contains(text(),'Application
	// Form')]/following::li[1]")
	// WebElement btnForm_AdmissionInside;

	@FindBy(xpath = "//span[contains(text(),'Student Admission')]/following::li[1]")
	WebElement btnAdmForm_BCEHS;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmForm_BCEHSMsgDispaly;

	@FindBy(xpath = "(//input[@id='usr'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@id='usr'])[2]")
	WebElement middleName;

	@FindBy(xpath = "(//input[@id='usr'])[3]")
	WebElement surName;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement mobileNumber;

	@FindBy(xpath = "(//input[@id='usr'])[4]")
	WebElement placeOfbirth;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selectReligion;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement selectCaste;

	@FindBy(xpath = "(//select[@id='sel1'])[3]")
	WebElement selgender;

	@FindBy(xpath = "//body[@id='style-4']//div/md-datepicker/button")
	WebElement calendarButton;

	@FindBy(xpath = "(//select[@id='sel1'])[4]")
	WebElement selectClass;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement emailID;

	@FindBy(xpath = "(//select[@id='sel1'])[5]")
	WebElement selDisableacademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[6]")
	WebElement selnationality;

	@FindBy(xpath = "(//input[@id='usr'])[5]")
	WebElement input_MotherTongue;

	@FindBy(xpath = "(//select[@id='sel1'])[7]")
	WebElement selLast_Syllabus;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/div[1]/div[3]/label)[1]")
	WebElement uploadStudentPhoto;

	/**
	 * Calendar related locators
	 */
	@FindBy(xpath = "//div[@id='md-date-pane-77']//div/div[2]/table/tbody/tr/td")
	WebElement dateTableTd;

	@FindBy(xpath = "//body[@id='style-4']//div/md-datepicker/div[1]/input")
	WebElement datefield;

	@FindBy(css = ".md-calendar-month-label")
	WebElement leftMonthYear;

	@FindBy(xpath = "//div[@id='md-date-pane-1']//div/div[2]/table/tbody/tr/td[1]")
	List<WebElement> leftYear;

	@FindBy(xpath = "//div[@id='md-date-pane-1']//div/div[2]/table/tbody/tr/td")
	List<WebElement> month;

	@FindBy(xpath = "//div[@id='md-date-pane-1']//div/div[2]/table/tbody/tr/td")
	List<WebElement> days;

	/**
	 * Other details locators
	 */

	@FindBy(xpath = "(//div[@class='col-sm-6']/select)[1]")
	WebElement selPrefLanguage2;

	@FindBy(xpath = "(//div[@class='col-sm-6']/select)[2]")
	WebElement selPrefLanguage3;

	@FindBy(xpath = "(//div[@class='col-sm-6']/input)[1]")
	WebElement inputTribe;

	@FindBy(xpath = "(//div[@class='col-sm-6']/input)[2]")
	WebElement inputPlayGroup;

	/**
	 * Residential details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[8]")
	WebElement inputStreet;

	@FindBy(xpath = "(//input[@id='usr'])[9]")
	WebElement inputArea;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[8]")
	WebElement selCountry;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[9]")
	WebElement selState;

	@FindBy(xpath = "(//input[@id='cityId'])[1]")
	WebElement inputCity;

	@FindBy(xpath = "(//input[@id='usr'])[10]")
	WebElement inputPinCodeZip;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[4]/div[1]/div[8]/label/input")
	WebElement chk_permaddsameAsResAdd;

	/**
	 * Father details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//input[@id='usr'])[14]")
	WebElement inputfatherName;

	@FindBy(xpath = "(//input[@id='usr'])[15]")
	WebElement inputfathersurname;

	@FindBy(xpath = "(//input[@id='usr'])[16]")
	WebElement inputfatherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[17]")
	WebElement inputfatherOccupation;

	@FindBy(xpath = "(//select[@id='sel1'])[11]")
	WebElement selFatherReligion;

	@FindBy(xpath = "(//select[@id='sel1'])[12]")
	WebElement selFatherCaste;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[18]")
	WebElement inputFather_Tribe;

	@FindBy(xpath = "(//select[@id='sel1'])[13]")
	WebElement sel_fathersNationality;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[19]")
	WebElement inputFatherMail;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[20]")
	WebElement inputfathers_PhOffice;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[21]")
	WebElement inputfathers_PhResidence;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[27]")
	WebElement input_fatherMobile;

	/**
	 * Mother's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//input[@id='usr'])[22]")
	WebElement inputmotherName;

	@FindBy(xpath = "(//input[@id='usr'])[23]")
	WebElement inputmothersurname;

	@FindBy(xpath = "(//input[@id='usr'])[24]")
	WebElement inputmotherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[25]")
	WebElement inputmotherOccupation;

	@FindBy(xpath = "(//select[@id='sel1'])[14]")
	WebElement selmotherReligion;

	@FindBy(xpath = "(//select[@id='sel1'])[15]")
	WebElement selmotherCaste;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[26]")
	WebElement inputmother_Tribe;

	@FindBy(xpath = "(//select[@id='sel1'])[16]")
	WebElement sel_mothersNationality;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[27]")
	WebElement inputmotherMail;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[28]")
	WebElement inputmothers_PhOffice;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[29]")
	WebElement inputmothers_PhResidence;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[36]")
	WebElement input_motherMobile;

	/**
	 * Monthly income
	 */
	@FindBy(xpath = "(//input[@id='usr'])[30]")
	WebElement input_fatherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[31]")
	WebElement input_motherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[32]")
	WebElement input_alternateContact;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[40]")
	WebElement input_alternateEmail;

	/**
	 * Guardian's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//input[@id='usr'])[33]")
	WebElement input_GuardianName;

	@FindBy(xpath = "(//input[@id='usr'])[34]")
	WebElement input_GurRelationshipToStudent;

	@FindBy(xpath = "(//input[@id='usr'])[35]")
	WebElement input_Gur_Occupation;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[44]")
	WebElement input_GurPhoneOffice;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[45]")
	WebElement input_GurPhoneResidence;
	/**
	 * sibling details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//input[@id='usr'])[36]")
	WebElement inputsibName;

	@FindBy(xpath = "(//input[@id='usr'])[37]")
	WebElement inputsibclass;

	@FindBy(xpath = "(//input[@id='usr'])[38]")
	WebElement inputsibAdmNo;

	@FindBy(xpath = "(//body[@id='style-4']//div/table/tbody/tr/td[5])[1]")
	WebElement clickSibPlus;

	@FindBy(xpath = "(//input[@id='usr'])[39]")
	WebElement input2ndsibName;

	@FindBy(xpath = "(//input[@id='usr'])[40]")
	WebElement input2ndsibclass;

	@FindBy(xpath = "(//input[@id='usr'])[41]")
	WebElement input2ndsibAdmNo;

	/**
	 * Mother father image upload loacators
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[6]/div[2]/table/tbody/tr/td[1]/div/label")
	WebElement uploadFatherPhoto;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[6]/div[2]/table/tbody/tr/td[2]/div/label")
	WebElement uploadMotherPhoto;

	/**
	 * Previous school details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[2]/input")
	WebElement inputSchoolName;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[3]/input")
	WebElement inputClass;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[4]/input")
	WebElement inputGrade;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[5]/input")
	WebElement inputPassedYr;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[6]/input")
	WebElement inputAddress;

	/**
	 * Required documents upload for BCEHS pre admission form
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[1]/td[3]/label")
	WebElement uploadDOBCert;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[2]/td[3]/label")
	WebElement uploadAddressProof;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[1]/td[4]/span")
	WebElement viewUploadDOBCert;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr[2]/td[4]/span")
	WebElement viewUploadAddressProof;

	@FindBy(xpath = "//div[@id='myModal']/div/div/div[2]/button")
	WebElement btnPopUpClose;

	/**
	 * Undertaking text and radio button
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[10]/p")
	WebElement undertakingText;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[10]/div/label[1]/span/preceding-sibling::input")
	WebElement rdBtnundertakingYes;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]//div/div[2]/div[11]/span/button")
	WebElement btnSubmit;

	/**
	 * Pop Up message and action validation
	 */
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnsubmitCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnsubmitYes;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonsuccess;

	@FindBy(xpath = "//div[@class='la-ball-fall']")
	WebElement btnOkPaid;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successPaidMsg;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/p")
	WebElement successYetToPaidMsg;

	/**
	 * table data validation
	 */

	@FindBy(xpath = "//body[@id='style-4']//div/div[3]/div/div/input")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[5]/tbody/tr")
	List<WebElement> tblRowStuList;

	@FindBy(xpath = "//div[@id='myModal1']/div/div/div[1]/button[2]")
	WebElement btnClose;

	@FindBy(xpath = "//div[@id='myModal1']/div/div/div[1]/button[1]")
	WebElement btnPrint;
	/**
	 * Payment page
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/div[4]/button[1]")
	WebElement btnBack;

	@FindBy(xpath = "//body[@id='style-4']//div/div[4]/button[2]")
	WebElement btnNext;

	public Admission_Form_BCEHS(WebDriver driver) {
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
	 * Navigate to Admission form BCEHS
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Form_BCEHS() throws Exception {
		btnPre_Admission.click();
		log("Clicked on Pre admission Button and object is:-" + btnPre_Admission.toString());
		waitForElement(driver, 10, btnStudent_Admission);

		btnStudent_Admission.click();
		log("Clicked on Student Admission Button and object is:-" + btnStudent_Admission.toString());
		waitForElement(driver, 10, btnAdmForm_BCEHS);
		Thread.sleep(3000);
		
		btnAdmForm_BCEHS.click();
		log("Clicked on admission form BCEHS Button and object is:-" + btnAdmForm_BCEHS.toString());
		waitForElement(driver, 10, txtAdmForm_BCEHSMsgDispaly);
	}

	/**
	 * Validation of Admission form BCEHS screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_Form_BCEHSPage() {
		try {
			System.out.println(txtAdmForm_BCEHSMsgDispaly.getText());
			txtAdmForm_BCEHSMsgDispaly.isDisplayed();
			log("Admission form BCEHS page is dispalyed and object is:-" + txtAdmForm_BCEHSMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Enter student information for BCEHS pre Admission form
	 * 
	 * @param fName
	 * @param mName
	 * @param sName
	 * @param mNumber
	 * @param birthPlace
	 * @param religion
	 * @param caste
	 * @param gender
	 * @param email
	 * @param nationality
	 * @param motherTongue
	 * @param Syllabus
	 * @param selClass
	 * @throws Exception
	 */

	public void enterStudentInformationFor_BCEHSPreAdmForm(String fName, String mName, String sName, String mNumber,
			String birthPlace, String religion, String caste, String gender, String email, String nationality,
			String motherTongue, String Syllabus, String selClass) throws Exception {

		firstName.sendKeys(fName);
		log("entered first name:-" + fName + " and object is " + firstName.toString());
		Thread.sleep(1000);

		middleName.sendKeys(mName);
		log("entered middle name:-" + mName + " and object is " + middleName.toString());
		Thread.sleep(1000);

		surName.sendKeys(sName);
		log("entered surname:-" + sName + " and object is " + surName.toString());
		Thread.sleep(1000);

		mobileNumber.sendKeys(mNumber);
		log("entered mobile number:-" + mNumber + " and object is " + mobileNumber.toString());
		Thread.sleep(1000);

		placeOfbirth.sendKeys(birthPlace);
		log("entered student place of birth:-" + birthPlace + " and object is " + birthPlace.toString());
		Thread.sleep(1000);

		select = new Select(selectReligion);
		select.selectByVisibleText(religion);
		log("selected religion:-" + religion + " and object is " + selectReligion.toString());
		Thread.sleep(1000);

		select = new Select(selectCaste);
		select.selectByVisibleText(caste);
		log("selected caste:-" + caste + " and object is " + selectCaste.toString());
		Thread.sleep(1000);

		select = new Select(selgender);
		select.selectByVisibleText(gender);
		log("selected gender:-" + gender + " and object is " + selgender.toString());
		Thread.sleep(1000);

		emailID.sendKeys(email);
		log("entered student emailid:-" + email + " and object is " + emailID.toString());
		Thread.sleep(1000);

		select = new Select(selnationality);
		select.selectByVisibleText(nationality);
		log("selected nationality:-" + nationality + " and object is " + selnationality.toString());
		Thread.sleep(1000);

		input_MotherTongue.sendKeys(motherTongue);
		log("entered mother tongue:-" + motherTongue + " and object is " + input_MotherTongue.toString());

		select = new Select(selLast_Syllabus);
		select.selectByVisibleText(Syllabus);
		log("selected last syllabus:-" + Syllabus + " and object is " + selLast_Syllabus.toString());
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadStudentPhoto, "Photo.jpg");
		log("Student image uploaded successfully");

		calendarButton.click();
		log("cliked on calendar button and object is:-" + calendarButton.toString());
		Thread.sleep(2000);
		leftMonthYear.click();
		log("cliked on left side of calendar month year button and object is:-" + leftMonthYear.toString());
		Thread.sleep(2000);
		// ((JavascriptExecutor)driver).executeScript("arguments[0].value='08052015'",
		// datefield);
		// datefield.sendKeys(Keys.TAB);
		selectDate(leftYear, month, days, "2014", "May", "20");
		log("selected date of birth");
		Thread.sleep(2000);

		select = new Select(selectClass);
		select.selectByVisibleText(selClass);
		log("selected the class based on date of birth:-" + selClass + " and object is " + selectClass.toString());
		Thread.sleep(2000);

	}

	/**
	 * Select the others details required for bcehs admission form
	 * 
	 * @param Language2
	 * @param Language3
	 * @param tribe
	 * @param playGroup
	 * @throws Exception
	 */
	public void othersDetailsForBcehsAdmForm(String Language2, String Language3, String tribe, String playGroup)
			throws Exception {

		select = new Select(selPrefLanguage2);
		select.selectByVisibleText(Language2);
		log("selected preffred language II:-" + Language2 + " and object is " + selPrefLanguage2.toString());
		Thread.sleep(1000);

		select = new Select(selPrefLanguage3);
		select.selectByVisibleText(Language3);
		log("selected preffred language III:-" + Language3 + " and object is " + selPrefLanguage3.toString());
		Thread.sleep(1000);

		inputTribe.sendKeys(tribe);
		log("entered Tribe:-" + tribe + " and object is " + inputTribe.toString());
		Thread.sleep(1000);

		inputPlayGroup.sendKeys(playGroup);
		log("entered Play Group:-" + playGroup + " and object is " + inputPlayGroup.toString());
		Thread.sleep(1000);
	}

	public void residentialAndPermanentAddress(String street, String area, String Country, String state, String city,
			String pinZip) throws Exception {

		inputStreet.sendKeys(street);
		log("entered street:-" + street + " and object is " + inputStreet.toString());
		Thread.sleep(1000);

		inputArea.sendKeys(area);
		log("entered area:-" + area + " and object is " + inputArea.toString());
		Thread.sleep(1000);

		select = new Select(selCountry);
		select.selectByVisibleText(Country);
		log("selected country of address from the list:-" + Country + " and object is " + selCountry.toString());
		Thread.sleep(3000);

		select = new Select(selState);
		select.selectByVisibleText(state);
		log("selected state of address from the list:-" + state + " and object is " + selState.toString());
		Thread.sleep(2000);

		inputCity.sendKeys(city);
		log("entered city:-" + city + " and object is " + inputCity.toString());
		Thread.sleep(1000);

		inputPinCodeZip.sendKeys(pinZip);
		log("entered pin/zip:-" + pinZip + " and object is " + inputPinCodeZip.toString());
		Thread.sleep(1000);
		//
		inputPinCodeZip.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		//
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
	 * Father's information for BCEHS pre admission form
	 * 
	 * @param fatherName
	 * @param fatherSurName
	 * @param fatherQualification
	 * @param fatherOccupation
	 * @param fatherReligion
	 * @param fatherCaste
	 * @param fatherTribe
	 * @param fatherNationanlity
	 * @param fatherEmailid
	 * @param fatherPhOffice
	 * @param fatherPhoneRes
	 * @param fatherMobile
	 * @throws Exception
	 */
	public void fathersDetails_BCEHSPreAdmissionForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherOccupation, String fatherReligion, String fatherCaste,
			String fatherTribe, String fatherNationanlity, String fatherEmailid, String fatherPhOffice,
			String fatherPhoneRes, String fatherMobile) throws Exception {

		inputfatherName.sendKeys(fatherName);
		log("entered father's name:-" + fatherName + " and object is " + inputfatherName.toString());
		Thread.sleep(1000);

		inputfathersurname.sendKeys(fatherSurName);
		log("entered father's surname:-" + fatherSurName + " and object is " + inputfathersurname.toString());
		Thread.sleep(1000);

		inputfatherQualification.sendKeys(fatherQualification);
		log("entered father's Qualification:-" + fatherQualification + " and object is "
				+ inputfatherQualification.toString());
		Thread.sleep(1000);

		inputfatherOccupation.sendKeys(fatherOccupation);
		log("entered father's occupation:-" + fatherOccupation + " and object is " + inputfatherOccupation.toString());
		Thread.sleep(1000);

		select = new Select(selFatherReligion);
		select.selectByVisibleText(fatherReligion);
		log("selected father's religion from the list:-" + fatherReligion + " and object is "
				+ selFatherReligion.toString());
		Thread.sleep(2000);

		select = new Select(selFatherCaste);
		select.selectByVisibleText(fatherCaste);
		log("selected father's caste from the list:-" + fatherCaste + " and object is " + selFatherCaste.toString());
		Thread.sleep(2000);

		inputFather_Tribe.sendKeys(fatherTribe);
		log("entered father's tribe:-" + fatherTribe + " and object is " + inputFather_Tribe.toString());
		Thread.sleep(1000);

		select = new Select(sel_fathersNationality);
		select.selectByVisibleText(fatherNationanlity);
		log("selected father's nationality:-" + fatherNationanlity + " and object is " + selnationality.toString());
		Thread.sleep(1000);

		inputFatherMail.sendKeys(fatherEmailid);
		log("entered father's email id:-" + fatherEmailid + " and object is " + inputFatherMail.toString());
		Thread.sleep(1000);

		inputfathers_PhOffice.sendKeys(fatherPhOffice);
		log("entered father's office phone Num:-" + fatherPhOffice + " and object is "
				+ inputfathers_PhOffice.toString());
		Thread.sleep(1000);

		inputfathers_PhResidence.sendKeys(fatherPhoneRes);
		log("entered father's residence phone Num:-" + fatherPhoneRes + " and object is "
				+ inputfathers_PhResidence.toString());
		Thread.sleep(1000);

		input_fatherMobile.sendKeys(fatherMobile);
		log("entered father's mobile:-" + fatherMobile + " and object is " + input_fatherMobile.toString());
		Thread.sleep(1000);

	}

	/**
	 * Mother's information for BCEHS pre admission form
	 * 
	 * @param motherName
	 * @param motherSurName
	 * @param motherQualification
	 * @param motherOccupation
	 * @param motherReligion
	 * @param motherCaste
	 * @param motherTribe
	 * @param motherNationanlity
	 * @param motherEmailid
	 * @param motherPhOffice
	 * @param motherPhoneRes
	 * @param motherMobile
	 * @throws Exception
	 */
	public void mothersDetails_BCEHSPreAdmissionForm(String motherName, String motherSurName,
			String motherQualification, String motherOccupation, String motherReligion, String motherCaste,
			String motherTribe, String motherNationanlity, String motherEmailid, String motherPhOffice,
			String motherPhoneRes, String motherMobile) throws Exception {

		inputmotherName.sendKeys(motherName);
		log("entered mother's name:-" + motherName + " and object is " + inputmotherName.toString());
		Thread.sleep(1000);

		inputmothersurname.sendKeys(motherSurName);
		log("entered mother's surname:-" + motherSurName + " and object is " + inputmothersurname.toString());
		Thread.sleep(1000);

		inputmotherQualification.sendKeys(motherQualification);
		log("entered mother's Qualification:-" + motherQualification + " and object is "
				+ inputmotherQualification.toString());
		Thread.sleep(1000);

		inputmotherOccupation.sendKeys(motherOccupation);
		log("entered mother's occupation:-" + motherOccupation + " and object is " + inputmotherOccupation.toString());
		Thread.sleep(1000);

		select = new Select(selmotherReligion);
		select.selectByVisibleText(motherReligion);
		log("selected mother's religion from the list:-" + motherReligion + " and object is "
				+ selmotherReligion.toString());
		Thread.sleep(2000);

		select = new Select(selmotherCaste);
		select.selectByVisibleText(motherCaste);
		log("selected mother's caste from the list:-" + motherCaste + " and object is " + selmotherCaste.toString());
		Thread.sleep(2000);

		inputmother_Tribe.sendKeys(motherTribe);
		log("enteredmother's tribe:-" + motherTribe + " and object is " + inputmother_Tribe.toString());
		Thread.sleep(1000);

		select = new Select(sel_mothersNationality);
		select.selectByVisibleText(motherNationanlity);
		log("selected mother's nationality:-" + motherNationanlity + " and object is "
				+ sel_mothersNationality.toString());
		Thread.sleep(1000);

		inputmotherMail.sendKeys(motherEmailid);
		log("entered mother's email id:-" + motherEmailid + " and object is " + inputmotherMail.toString());
		Thread.sleep(1000);

		inputmothers_PhOffice.sendKeys(motherPhOffice);
		log("entered mother's office phone Num:-" + motherPhOffice + " and object is "
				+ inputmothers_PhOffice.toString());
		Thread.sleep(1000);

		inputmothers_PhResidence.sendKeys(motherPhoneRes);
		log("entered mother's residence phone Num:-" + motherPhoneRes + " and object is "
				+ inputmothers_PhResidence.toString());
		Thread.sleep(1000);

		input_motherMobile.sendKeys(motherMobile);
		log("entered mother's mobile:-" + motherMobile + " and object is " + input_motherMobile.toString());
		Thread.sleep(1000);
	}

	public void monthlyIncomeDetailsBCEHS(String fatherIncome, String motherIncome, String altContact, String altEmail)
			throws Exception {

		input_fatherIncome.sendKeys(fatherIncome);
		log("entered father's income:-" + fatherIncome + " and object is " + input_fatherIncome.toString());
		Thread.sleep(1000);

		input_motherIncome.sendKeys(motherIncome);
		log("entered mother's income:-" + motherIncome + " and object is " + input_motherIncome.toString());
		Thread.sleep(1000);

		input_alternateContact.sendKeys(altContact);
		log("entered alternet contact:-" + altContact + " and object is " + input_alternateContact.toString());
		Thread.sleep(1000);

		input_alternateEmail.sendKeys(altEmail);
		log("entered alternet email:-" + altEmail + " and object is " + input_alternateEmail.toString());
		Thread.sleep(1000);

	}

	/**
	 * Guardian details BCEHS
	 * 
	 * @param guardianName
	 * @param gurdianRelWithStu
	 * @param gurdianOccupation
	 * @param guardianPhoneOffice
	 * @param guardianPhRes
	 * @throws Exception
	 */
	public void gurdianDetailsBCEHSPreAdm(String guardianName, String gurdianRelWithStu, String gurdianOccupation,
			String guardianPhoneOffice, String guardianPhRes) throws Exception {

		input_GuardianName.sendKeys(guardianName);
		log("entered guardian name:-" + guardianName + " and object is " + input_GuardianName.toString());
		Thread.sleep(1000);

		input_GurRelationshipToStudent.sendKeys(gurdianRelWithStu);
		log("entered guardian relationship to student:-" + gurdianRelWithStu + " and object is "
				+ input_GurRelationshipToStudent.toString());
		Thread.sleep(1000);

		input_Gur_Occupation.sendKeys(gurdianOccupation);
		log("entered guardian occupation:-" + gurdianOccupation + " and object is " + input_Gur_Occupation.toString());
		Thread.sleep(1000);

		input_GurPhoneOffice.sendKeys(guardianPhoneOffice);
		log("entered guardian office phone number:-" + guardianPhoneOffice + " and object is "
				+ input_GurPhoneOffice.toString());
		Thread.sleep(1000);

		input_GurPhoneResidence.sendKeys(guardianPhRes);
		log("entered guardian residence phone number:-" + guardianPhRes + " and object is "
				+ input_GurPhoneResidence.toString());
		Thread.sleep(1000);

	}

	/**
	 * Sibling details BCEHS
	 * 
	 * @param siblingName
	 * @param siblingClass
	 * @param siblingAdmNo
	 * @throws Exception
	 */
	public void siblingdetailsBCEHSPreAdm(String siblingName, String siblingClass, String siblingAdmNo)
			throws Exception {

		inputsibName.sendKeys(siblingName);
		log("entered sibling name:-" + siblingName + " and object is " + inputsibName.toString());
		Thread.sleep(1000);

		inputsibclass.sendKeys(siblingClass);
		log("entered sibling Class:-" + siblingClass + " and object is " + inputsibclass.toString());
		Thread.sleep(1000);

		inputsibAdmNo.sendKeys(siblingAdmNo);
		log("entered sibling Admission number:-" + siblingAdmNo + " and object is " + inputsibAdmNo.toString());
		Thread.sleep(1000);

		clickSibPlus.click();
		log("cliked on plus sign to add rows:-" + clickSibPlus.toString());
		Thread.sleep(2000);

		input2ndsibName.sendKeys(siblingName);
		log("entered 2nd sibling name:-" + siblingName + " and object is " + input2ndsibName.toString());
		Thread.sleep(1000);

		input2ndsibclass.sendKeys(siblingClass);
		log("entered 2nd sibling Class:-" + siblingClass + " and object is " + input2ndsibclass.toString());
		Thread.sleep(1000);

		input2ndsibAdmNo.sendKeys(siblingAdmNo);
		log("entered 2nd sibling Admission number:-" + siblingAdmNo + " and object is " + input2ndsibAdmNo.toString());
		Thread.sleep(1000);
	}

	/**
	 * Upload father and mother photo for BCEHS pre admission form
	 * 
	 * @throws Exception
	 */
	public void uploadfatherAndMotherPhotos() throws Exception {
		imageAndDocumentUpload(uploadFatherPhoto, "Father.jpg");
		log("Father photo uploaded for bcehs pre admission form");
		Thread.sleep(3000);

		imageAndDocumentUpload(uploadMotherPhoto, "Mother.jpg");
		log("Mother photo uploaded for bcehs pre admission form");
		Thread.sleep(3000);
	}

	/**
	 * Enter previous school details for BCEHS school pre admission form
	 * 
	 * @param prevSchoolName
	 * @param prevClass
	 * @param prevGrade
	 * @param prevPassedYr
	 * @param PrevAddress
	 * @throws Exception
	 */
	public void previousSchoolDetailsBCEHS(String prevSchoolName, String prevClass, String prevGrade,
			String prevPassedYr, String PrevAddress) throws Exception {

		inputSchoolName.sendKeys(prevSchoolName);
		log("entered previous school name:-" + prevSchoolName + " and object is " + inputSchoolName.toString());
		Thread.sleep(1000);

		inputClass.sendKeys(prevClass);
		log("entered previous class:-" + prevClass + " and object is " + inputClass.toString());
		Thread.sleep(1000);

		inputGrade.sendKeys(prevGrade);
		log("entered previous grade:-" + prevGrade + " and object is " + inputGrade.toString());
		Thread.sleep(1000);

		inputPassedYr.sendKeys(prevPassedYr);
		log("entered previous passed year:-" + prevPassedYr + " and object is " + inputPassedYr.toString());
		Thread.sleep(1000);

		inputAddress.sendKeys(PrevAddress);
		log("entered Address:-" + PrevAddress + " and object is " + inputAddress.toString());
		Thread.sleep(1000);
	}
	/**
	 * upload date of birth certificate for the BCEHS pre admission form
	 * 
	 * @param dobCertificateText
	 * @param addressProofText
	 * @throws Exception
	 */
	/*
	 * public void uploadDOBCertificateDocumentsForBceHSPreAdmForm(String
	 * dobCertificateText) throws Exception{
	 * 
	 * int rows = tblRows.size(); System.out.println(rows); Thread.sleep(2000);
	 * for (int i = 1; i <= rows; i++) { String dobCert = driver
	 * .findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" +
	 * i + "]/td[2]")).getText(); System.out.println("Dob doc: "+dobCert);
	 * Thread.sleep(2000); if(dobCert.equalsIgnoreCase(dobCertificateText)){ try
	 * { Assert.assertEquals(dobCert, dobCertificateText); WebElement dobElement
	 * = driver.findElement(By.xpath(
	 * "(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i +
	 * "]/td[3]/label"));
	 * 
	 * imageAndDocumentUpload(dobElement,"TransferCertificate.jpg");
	 * log("Date of birth certificate uploaded for bcehs pre admission form");
	 * Thread.sleep(3000);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }
	 * 
	 * }
	 */

	/**
	 * Address proof documents uploaded for BCEHS pre admission form
	 * 
	 * @param dobCertificateText
	 * @param addressProofText
	 * @throws Exception
	 */
	/*
	 * public void
	 * uploadAddressProofCertificateDocumentsForBceHSPreAdmForm(String
	 * addressProofText) throws Exception{
	 * 
	 * int rows = tblRows.size(); System.out.println(rows); Thread.sleep(2000);
	 * for (int i = 1; i <= rows; i++) { String addressProofDoc = driver
	 * .findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" +
	 * i + "]/td[2]")).getText();
	 * System.out.println("Address doc: "+addressProofDoc); Thread.sleep(2000);
	 * if(addressProofDoc.equalsIgnoreCase(addressProofText)){ try {
	 * Assert.assertEquals(addressProofDoc, addressProofText); WebElement
	 * addProofElement = driver.findElement(By.xpath(
	 * "(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i +
	 * "]/td[3]/label"));
	 * 
	 * imageAndDocumentUpload(addProofElement,"signature.jpg");
	 * log("Address proof certificate uploaded for bcehs pre admission form");
	 * Thread.sleep(3000);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }
	 * 
	 * }
	 *//**
		 * validate uploaded birth certificate
		 * 
		 * @param dobCertificateText
		 * @param addressProofText
		 * @throws Exception
		 */

	/*
	 * public void
	 * validationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm(String
	 * dobCertificateText) throws Exception{
	 * 
	 * int rows = tblRows.size(); System.out.println(rows); Thread.sleep(2000);
	 * for (int i = 1; i <= rows; i++) { String dobCertDoc = driver
	 * .findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" +
	 * i + "]/td[2]")).getText(); System.out.println("Dob doc: "+dobCertDoc);
	 * Thread.sleep(2000); if(dobCertDoc.equalsIgnoreCase(dobCertificateText)){
	 * try { Assert.assertEquals(dobCertDoc, dobCertificateText);
	 * driver.findElement(By.xpath(
	 * "(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i + "]/td[4]/span"));
	 * 
	 * log("Date of birth certificate validation done for bcehs pre admission form"
	 * ); Thread.sleep(3000);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }
	 * 
	 * }
	 */
	/**
	 * Validate uploaded address proof for BCEHS pre admission form
	 * 
	 * @param dobCertificateText
	 * @param addressProofText
	 * @throws Exception
	 */
	/*
	 * 
	 * public void
	 * validationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm
	 * (String addressProofText) throws Exception{
	 * 
	 * int rows = tblRows.size(); System.out.println(rows); Thread.sleep(2000);
	 * for (int i = 1; i <= rows; i++) { String addressProofDoc = driver
	 * .findElement(By.xpath( "(//body[@id='style-4']//div/table)[4]/tbody/tr["
	 * + i + "]/td[2]")).getText();
	 * System.out.println("Address doc: "+addressProofDoc); Thread.sleep(2000);
	 * if(addressProofDoc.equalsIgnoreCase(addressProofText)){ try {
	 * Assert.assertEquals(addressProofDoc, addressProofText);
	 * 
	 * driver.findElement(By.xpath(
	 * "(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i +
	 * "]/td[4]/span")).click();
	 * log("Address proof certificate uploaded for bcehs pre admission form" );
	 * Thread.sleep(3000);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * Upload date of birth certificate and address proof
	 * 
	 * @throws Exception
	 */
	public void uploadRequiredDetails() throws Exception {

		imageAndDocumentUpload(uploadDOBCert, "TransferCertificate.jpg");
		log("Date of birth certificate uploded");
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadAddressProof, "signature.jpg");
		log("Address proof certificate uploded");
		Thread.sleep(1000);
	}

	/**
	 * click on view button after upload of Date of birth certificate
	 * 
	 * @throws InterruptedException
	 */
	public void validationOfUploadedDOBCertificate() throws InterruptedException {
		viewUploadDOBCert.click();
		log("Date of birth certificate validated");
		Thread.sleep(3000);

	}

	/**
	 * click on view button after upload of address proof documents
	 * 
	 * @throws InterruptedException
	 */
	public void validationOfUploadedAddressProofCertificate() throws InterruptedException {

		viewUploadAddressProof.click();
		log("Address proof certificate uploded");
		Thread.sleep(3000);
	}

	/**
	 * View uploaded documents popup close button
	 * 
	 * @throws Exception
	 */
	public void clickOnPopupCloseButton() throws Exception {

		btnPopUpClose.click();
		Thread.sleep(2000);
		log("Uploaded documents validation done.");
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
		btnSubmit.click();
		log("clicked on Submit button and object is:-" + btnSubmit);
		Thread.sleep(2000);
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
	public void popUpValidationonSuccess() throws InterruptedException {
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
	public void searchByFatherNameInGrid(String FatherName) throws Exception {
		inputSearch.clear();
		inputSearch.sendKeys(FatherName);
		log("Entered father name:" + FatherName + " and object is:-" + inputSearch.toString());
		Thread.sleep(2000);
	}

	/**
	 * Verify father name for search is available in the grid
	 * 
	 * @param FatherName
	 * @throws Exception
	 */
	public void verifyFatherNameInStudentListGrid(String FatherName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);
					log("Father name matched with the Student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Search with father name and click on pay registration fee link
	 * 
	 * @param FatherName
	 * @throws Exception
	 */

	public void searchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm(String FatherName)
			throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);

					driver.findElement(
							By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[6]/span/a[1]"))
							.click();
					log("Clicked on the pay registration fee link in the student list grid");
					waitForElement(driver, 20, btnBack);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Clicked back button to cancel registration fee payment
	 * 
	 * @throws Exception
	 */
	public void back_PayRegistrationFee() throws Exception {

		btnBack.click();
		log("Come back from payment page to main page");
		waitForElement(driver, 20, txtAdmForm_BCEHSMsgDispaly);

	}

	/**
	 * Edit admission form for BCEHS
	 * 
	 * @param FatherName
	 * @throws Exception
	 */

	public void searchWithFatherNameInStudentListGrid_Edit_BCEHSForm(String FatherName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);

					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[5]/span"))
							.click();
					log("Clicked on the edit link in the student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * click OK button based on message validation
	 * 
	 * @throws Exception
	 */

	public void selctionOfSubmitActionForEdit() throws Exception {
		String s1 = "Do you want Pay Pre-Admission Registration Form Fee ..!?";
		if (s1.equalsIgnoreCase(successYetToPaidMsg.getText())) {
			btnsubmitCancel.click();
			log("Clicked on pop up cancel button after editing");
			Thread.sleep(5000);
		} else {
			// waitForElement(driver, btnOkonsuccess, 20);
			btnOkonsuccess.click();
			log("Pyment already done click ok for successful update of form");
			Thread.sleep(5000);
		}

	}

	/**
	 * Open filled application form by view admission form link
	 * 
	 * @param FatherName
	 * @throws Exception
	 */
	public void searchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm(String FatherName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);

					driver.findElement(
							By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[6]/span/a[1]"))
							.click();
					log("Clicked on the view link in the student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * close the filled application opened by view admission form link
	 * 
	 * @throws Exception
	 */

	public void closeOpenAdmissionForm() throws Exception {

		btnClose.click();
		log("Opened admission form is closed and object is:-" + btnClose.toString());
		Thread.sleep(2000);
	}

	/**
	 * print the filled application by opening view admission form
	 * 
	 * @throws Exception
	 */
	public void printOpenAdmissionForm() throws Exception {

		btnPrint.click();
		log("Clicked print button and object is:-" + btnPrint.toString());
		Thread.sleep(5000);
	}

	/**
	 * Download prospectus
	 * 
	 * @param FatherName
	 * @throws Exception
	 */
	public void searchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm(String FatherName)
			throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);

					driver.findElement(
							By.xpath("(//body[@id='style-4']//div/table)[5]/tbody/tr[" + i + "]/td[6]/span/a[2]"))
							.click();
					log("Clicked on the download prospectus link in the student list grid");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Switching windows for prospectus download
	 * 
	 * @throws Exception
	 */
	public void switchWindowsForProspectusDownload() throws Exception {
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		log("Switched to the prospectus download window");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		log("Swiched back from prospectus download page to admission form BCEHS");
		Thread.sleep(2000);

	}

	/**
	 * Switching windows for print preview
	 * 
	 * @throws Exception
	 */
	public void switchToWindowUsingTab() throws Exception {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_TAB);

		// new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL,
		// Keys.TAB)).perform();
		Thread.sleep(7000);

		log("Switched for the print preview windows.");

	}
}
