/**
 * 
 */
package com.vapsTechnosoft.IVRM.Staging_PreAdmission;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
public class Admission_Form_BGHS_ApplicationForm extends TestBase {

	public static final Logger log = Logger.getLogger(Admission_Form_BGHS_ApplicationForm.class.getName());

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

	@FindBy(xpath = "//span[contains(text(),'Student Admission')]")
	WebElement btnStudent_Admission;

	@FindBy(xpath = "//span[contains(text(),'Student Admission')]/following::li[1]")
	WebElement btnAdmForm_BGHS;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtAdmForm_BGHSMsgDispaly;

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

	@FindBy(xpath = "(//div[@class='md-datepicker-input-container']/input)[1]")
	WebElement inputcalendar;

	@FindBy(xpath = "(//select[@id='sel1'])[4]")
	WebElement selectClass;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[7]")
	WebElement emailID;

	@FindBy(xpath = "(//select[@id='sel1'])[5]")
	WebElement selDisableacademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[6]")
	WebElement selnationality;

	@FindBy(xpath = "(//input[@id='usr'])[5]")
	WebElement input_LangAtHome;

	@FindBy(xpath = "(//input[@id='usr'])[6]")
	WebElement input_ChurchAddr;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/div[1]/div[3]/label)[1]")
	WebElement uploadStudentPhoto;

	/**
	 * Other details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[7]")
	WebElement inputAadharCard;

	@FindBy(xpath = "(//input[@id='usr'])[8]")
	WebElement inputPlayGroup;

	@FindBy(xpath = "(//input[@id='usr'])[9]")
	WebElement inputParticipationInECA;

	/**
	 * Residential details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[10]")
	WebElement inputStreet;

	@FindBy(xpath = "(//input[@id='usr'])[11]")
	WebElement inputArea;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[7]")
	WebElement selCountry;

	@FindBy(xpath = "(//div[@class='col-sm-8']/select)[8]")
	WebElement selState;

	@FindBy(xpath = "(//input[@id='cityId'])[1]")
	WebElement inputCity;

	@FindBy(xpath = "(//input[@id='usr'])[12]")
	WebElement inputPinCodeZip;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[4]/div[1]/div[8]/label/input")
	WebElement chk_permaddsameAsResAdd;

	/**
	 * Father details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//input[@id='usr'])[16]")
	WebElement inputfatherName;

	@FindBy(xpath = "(//input[@id='usr'])[17]")
	WebElement inputfathersurname;

	@FindBy(xpath = "(//input[@id='usr'])[18]")
	WebElement inputfatherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[19]")
	WebElement inputfatherService;

	@FindBy(xpath = "(//input[@id='usr'])[20]")
	WebElement inputfatherDesignation;

	@FindBy(xpath = "(//select[@id='sel1'])[10]")
	WebElement sel_fathersNationality;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[20]")
	WebElement inputfathers_OfficeAddress;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[21]")
	WebElement inputfathers_PhOffice;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[22]")
	WebElement inputfathers_PhResidence;

	@FindBy(xpath = "(//div[@class='input-group-addon'])[3]/following-sibling::input")
	WebElement input_fatherMobile;

	/**
	 * Mother's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//input[@id='usr'])[24]")
	WebElement inputmotherName;

	@FindBy(xpath = "(//input[@id='usr'])[25]")
	WebElement inputmothersurname;

	@FindBy(xpath = "(//input[@id='usr'])[26]")
	WebElement inputmotherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[27]")
	WebElement inputmotherService;

	@FindBy(xpath = "(//input[@id='usr'])[28]")
	WebElement inputmotherDesignation;

	@FindBy(xpath = "(//select[@id='sel1'])[11]")
	WebElement sel_mothersNationality;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[28]")
	WebElement inputmothers_OfficeAddress;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[29]")
	WebElement inputmothers_PhOffice;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[30]")
	WebElement inputmothers_PhResidence;

	@FindBy(xpath = "(//div[@class='input-group-addon'])[4]/following-sibling::input")
	WebElement input_motherMobile;

	/**
	 * Monthly income
	 */
	@FindBy(xpath = "(//input[@id='usr'])[32]")
	WebElement input_fatherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[33]")
	WebElement input_motherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[34]")
	WebElement input_alternateContact;

	@FindBy(xpath = "(//div[@class='input-group-addon'])[5]/following-sibling::input")
	WebElement input_alternateEmail;
	/**
	 * Year of Passing of Mother/Father if they are Old Baldwinians
	 * 
	 */
	@FindBy(xpath = "(//input[@id='usr'])[35]")
	WebElement input_FatherYrOfPassing;

	@FindBy(xpath = "(//input[@id='usr'])[36]")
	WebElement input_MotherYrOfPassing;

	/**
	 * Guardian's details
	 * 
	 * @param driver
	 */

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[36]")
	WebElement input_GuardianName;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[37]")
	WebElement input_GurRelationshipToStudent;

	@FindBy(xpath = "(//div[@class='col-sm-8']/input)[38]")
	WebElement input_Gur_Address;

	@FindBy(xpath = "(//div[@class='input-group-addon'])[6]/following-sibling::input")
	WebElement input_GurEmail;

	@FindBy(xpath = "(//div[@class='input-group-addon'])[7]/following-sibling::input")
	WebElement input_GurPhone;
	/**
	 * sibling details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//input[@id='usr'])[37]")
	WebElement inputsibName;

	@FindBy(xpath = "(//input[@id='usr'])[38]")
	WebElement inputsibclass;

	@FindBy(xpath = "(//input[@id='usr'])[39]")
	WebElement inputsibAdmNo;

	@FindBy(xpath = "(//body[@id='style-4']//div/table/tbody/tr/td[5])[1]")
	WebElement clickSibPlus;

	@FindBy(xpath = "(//input[@id='usr'])[40]")
	WebElement input2ndsibName;

	@FindBy(xpath = "(//input[@id='usr'])[41]")
	WebElement input2ndsibclass;

	@FindBy(xpath = "(//input[@id='usr'])[42]")
	WebElement input2ndsibAdmNo;

	/**
	 * Previous school details
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr[1]/td[2]/input")
	WebElement inputSchoolName;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr[1]/td[3]/input")
	WebElement inputClass;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr[1]/td[4]/input")
	WebElement inputGrade;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr[1]/td[5]/input")
	WebElement inputPassedYr;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[2]/tbody/tr[1]/td[6]/input")
	WebElement inputAddress;

	/**
	 * Required documents upload for BGHS pre admission form
	 * 
	 * @param driver
	 */
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[3]/label")
	WebElement uploadDOBCert;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[3]/tbody/tr[1]/td[4]/span")
	WebElement viewUploadDOBCert;

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

	/**
	 * table data validation
	 */

	@FindBy(xpath = "//body[@id='style-4']//div/div[3]/div/div/input")
	WebElement inputSearch;

	@FindBy(xpath = "(//body[@id='style-4']//div/table)[4]/tbody/tr")
	List<WebElement> tblRowStuList;

	public Admission_Form_BGHS_ApplicationForm(WebDriver driver) {
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
	 * Navigate to Admission form BGHS
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_ApplicationForm_BGHS() throws Exception {
		btnPre_Admission.click();
		log("Clicked on Pre admission Button and object is:-" + btnPre_Admission.toString());
		waitForElement(driver, 10, btnStudent_Admission);

		btnStudent_Admission.click();
		log("Clicked on Student Admission Button and object is:-" + btnStudent_Admission.toString());
		waitForElement(driver, 10, btnAdmForm_BGHS);

		btnAdmForm_BGHS.click();
		log("Clicked on admission form BGHS Button and object is:-" + btnAdmForm_BGHS.toString());
		waitForElement(driver, 10, txtAdmForm_BGHSMsgDispaly);
	}

	/**
	 * Validation of Admission form BGHS screen message
	 * 
	 * @return
	 */
	public boolean verifyAdmission_ApplicationForm_BGHSPage() {
		try {
			System.out.println(txtAdmForm_BGHSMsgDispaly.getText());
			txtAdmForm_BGHSMsgDispaly.isDisplayed();
			log("Admission form BGHS page is dispalyed and object is:-" + txtAdmForm_BGHSMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Student information for BGHS Application form
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
	 * @param languageAtHome
	 * @param churchName
	 * @param dateOfBirth
	 * @param selClass
	 * @throws Exception
	 */

	public void enterStudentInformationFor_BGHSPreAdmApplicationForm(String fName, String mName, String sName,
			String mNumber, String birthPlace, String religion, String caste, String gender, String email,
			String nationality, String languageAtHome, String churchName, String dateOfBirth, String selClass)
			throws Exception {

		firstName.sendKeys(fName);
		log("entered first name:-" + fName + " and object is " + firstName.toString());
		Thread.sleep(1000);

//		middleName.sendKeys(mName);
//		log("entered middle name:-" + mName + " and object is " + middleName.toString());
//		Thread.sleep(1000);
//
//		surName.sendKeys(sName);
//		log("entered surname:-" + sName + " and object is " + surName.toString());
//		Thread.sleep(1000);

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

		// WebElement option = select.getFirstSelectedOption();
		// System.out.println("Religion:"+option.getText());
		// Assert.assertEquals(option.getText(), religion);
		// Thread.sleep(1000);

		select = new Select(selectCaste);
		select.selectByVisibleText(caste);
		log("selected caste:-" + caste + " and object is " + selectCaste.toString());
		Thread.sleep(1000);

		WebElement option1 = select.getFirstSelectedOption();
		Assert.assertEquals(option1.getText(), caste);
		Thread.sleep(1000);

		select = new Select(selgender);
		select.selectByVisibleText(gender);
		log("selected gender:-" + gender + " and object is " + selgender.toString());
		Thread.sleep(1000);

		WebElement option2 = select.getFirstSelectedOption();
		Assert.assertEquals(option2.getText(), gender);
		Thread.sleep(1000);

		emailID.sendKeys(email);
		log("entered student emailid:-" + email + " and object is " + emailID.toString());
		Thread.sleep(1000);

		select = new Select(selnationality);
		select.selectByVisibleText(nationality);
		log("selected nationality:-" + nationality + " and object is " + selnationality.toString());
		Thread.sleep(1000);

		WebElement option3 = select.getFirstSelectedOption();
		Assert.assertEquals(option3.getText(), nationality);
		Thread.sleep(1000);

		input_LangAtHome.sendKeys(languageAtHome);
		log("entered language spoken at home:-" + languageAtHome + " and object is " + input_LangAtHome.toString());
		Thread.sleep(1000);

		input_ChurchAddr.sendKeys(churchName);
		log("entered church name and address:-" + churchName + " and object is " + input_ChurchAddr.toString());
		Thread.sleep(1000);

		imageAndDocumentUpload(uploadStudentPhoto, "SchoolGirl.jpg");
		log("Student image uploaded successfully");

		copyToClipbord(dateOfBirth);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(inputcalendar);
		oAction.contextClick(inputcalendar).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log("Entered date of Birth " + dateOfBirth + " and object is:-" + inputcalendar.toString());
		Thread.sleep(2000);

		select = new Select(selectClass);
		select.selectByVisibleText(selClass);
		log("selected the class based on date of birth:-" + selClass + " and object is " + selectClass.toString());
		Thread.sleep(1000);

		WebElement option4 = select.getFirstSelectedOption();
		Assert.assertEquals(option4.getText(), selClass);
		Thread.sleep(1000);

	}

	/**
	 * Select the others details required for BGHS admission application form
	 * 
	 * @param aadharCardNo
	 * @param playGroup
	 * @param ECAPrticipation
	 * @throws Exception
	 */
	public void othersDetailsForBGhsAdmApplicationForm(String aadharCardNo, String playGroup, String ECAPrticipation)
			throws Exception {

		inputAadharCard.sendKeys(aadharCardNo);
		log("entered Aadhar number:-" + aadharCardNo + " and object is " + inputAadharCard.toString());
		Thread.sleep(1000);

		inputPlayGroup.sendKeys(playGroup);
		log("entered Play Group:-" + playGroup + " and object is " + inputPlayGroup.toString());
		Thread.sleep(1000);

		inputParticipationInECA.sendKeys(ECAPrticipation);
		log("entered participation in ECA:-" + ECAPrticipation + " and object is "
				+ inputParticipationInECA.toString());
		Thread.sleep(1000);
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
		Thread.sleep(2000);

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
	 * Father's information for BGHS pre admission application form
	 * 
	 * @param fatherName
	 * @param fatherSurName
	 * @param fatherQualification
	 * @param fatherService
	 * @param fatherDesignation
	 * @param fatherNationanlity
	 * @param fatherOfficeAddr
	 * @param fatherPhOffice
	 * @param fatherPhoneRes
	 * @param fatherMobile
	 * @throws Exception
	 */

	public void fathersDetails_BGHSPreAdmission_ApplicationForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherService, String fatherDesignation, String fatherNationanlity,
			String fatherOfficeAddr, String fatherPhOffice, String fatherPhoneRes, String fatherMobile)
			throws Exception {

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

		inputfatherService.sendKeys(fatherService);
		log("entered father's service/business:-" + fatherService + " and object is " + inputfatherService.toString());
		Thread.sleep(1000);

		inputfatherDesignation.sendKeys(fatherDesignation);
		log("entered father's designation:-" + fatherDesignation + " and object is "
				+ inputfatherDesignation.toString());
		Thread.sleep(1000);

		select = new Select(sel_fathersNationality);
		select.selectByVisibleText(fatherNationanlity);
		log("selected father's nationality:-" + fatherNationanlity + " and object is " + selnationality.toString());
		Thread.sleep(1000);

		WebElement option5 = select.getFirstSelectedOption();
		Assert.assertEquals(option5.getText(), fatherNationanlity);
		Thread.sleep(1000);

		inputfathers_OfficeAddress.sendKeys(fatherOfficeAddr);
		log("entered father's office address:-" + fatherOfficeAddr + " and object is "
				+ inputfathers_OfficeAddress.toString());
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

	public void mothersDetails_BGHSPreAdmission_ApplicationForm(String motherName, String motherSurName,
			String motherQualification, String motherService, String motherDesignation, String motherNationanlity,
			String motherOfficeAddr, String motherPhOffice, String motherPhoneRes, String motherMobile)
			throws Exception {

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

		inputmotherService.sendKeys(motherService);
		log("entered mother's service/business:-" + motherService + " and object is " + inputmotherService.toString());
		Thread.sleep(1000);

		inputmotherDesignation.sendKeys(motherDesignation);
		log("entered mother's designation:-" + motherDesignation + " and object is "
				+ inputmotherDesignation.toString());
		Thread.sleep(1000);

		select = new Select(sel_mothersNationality);
		select.selectByVisibleText(motherNationanlity);
		log("selected mother's nationality:-" + motherNationanlity + " and object is "
				+ sel_mothersNationality.toString());
		Thread.sleep(1000);

		WebElement option6 = select.getFirstSelectedOption();
		Assert.assertEquals(option6.getText(), motherNationanlity);
		Thread.sleep(1000);

		inputmothers_OfficeAddress.sendKeys(motherOfficeAddr);
		log("entered mother's office address:-" + motherOfficeAddr + " and object is "
				+ inputmothers_OfficeAddress.toString());
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

	/**
	 * Parent's monthly income
	 * 
	 * @param fatherIncome
	 * @param motherIncome
	 * @param altContact
	 * @param altEmail
	 * @throws Exception
	 */
	public void parentMonthlyIncomeDetailsBGHS(String fatherIncome, String motherIncome, String altContact,
			String altEmail) throws Exception {

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
	 * Father and mother Year of passing if Baldwinians
	 * 
	 * @param FatherYrOfPass
	 * @param MotherYrOfPass
	 * @throws Exception
	 */

	public void yearOfPassingOfFatherAndMother(String FatherYrOfPass, String MotherYrOfPass) throws Exception {

		input_FatherYrOfPassing.sendKeys(FatherYrOfPass);
		log("entered father's year of passing:-" + FatherYrOfPass + " and object is "
				+ input_FatherYrOfPassing.toString());
		Thread.sleep(1000);

		input_MotherYrOfPassing.sendKeys(MotherYrOfPass);
		log("entered mother's year of passing:-" + MotherYrOfPass + " and object is "
				+ input_MotherYrOfPassing.toString());
		Thread.sleep(1000);

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

	public void gurdianDetailsBGHSPreAdmApplicationForm(String guardianName, String gurdianRelWithStu,
			String gurdianAddress, String guardianEmail, String guardianPhone) throws Exception {

		input_GuardianName.sendKeys(guardianName);
		log("entered guardian name:-" + guardianName + " and object is " + input_GuardianName.toString());
		Thread.sleep(1000);

		input_GurRelationshipToStudent.sendKeys(gurdianRelWithStu);
		log("entered guardian relationship to student:-" + gurdianRelWithStu + " and object is "
				+ input_GurRelationshipToStudent.toString());
		Thread.sleep(1000);

		input_Gur_Address.sendKeys(gurdianAddress);
		log("entered guardian address:-" + gurdianAddress + " and object is " + input_Gur_Address.toString());
		Thread.sleep(1000);

		input_GurEmail.sendKeys(guardianEmail);
		log("entered guardian Email Id:-" + guardianEmail + " and object is " + input_GurEmail.toString());
		Thread.sleep(1000);

		input_GurPhone.sendKeys(guardianPhone);
		log("entered guardian phone number:-" + guardianPhone + " and object is " + input_GurPhone.toString());
		Thread.sleep(1000);

	}

	/**
	 * Sibling details for BGHS pune
	 * 
	 * @param siblingName
	 * @param siblingClass
	 * @param siblingAdmNo
	 * @throws Exception
	 */

	public void siblingDetailsBGHSPune(String siblingName, String siblingClass, String siblingAdmNo) throws Exception {

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
	 * Enter previous school details for BGHS school pre admission application
	 * form
	 * 
	 * @param prevSchoolName
	 * @param prevClass
	 * @param prevGrade
	 * @param prevPassedYr
	 * @param PrevAddress
	 * @throws Exception
	 */

	public void previousSchoolDetailsBGHS(String prevSchoolName, String prevClass, String prevGrade,
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
	 * Upload date of birth certificate
	 * 
	 * @throws Exception
	 */
	public void uploadRequiredDocuments() throws Exception {

		imageAndDocumentUpload(uploadDOBCert, "TransferCertificate.jpg");
		log("Date of birth certificate uploded");
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
		log("clicked on Submit button and object is:-" + btnSubmit.toString());
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
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i + "]/td[4]")).getText();
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
	 * Edit admission form for BCEHS
	 * 
	 * @param FatherName
	 * @throws Exception
	 */

	public void searchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm(String FatherName) throws Exception {

		int rows = tblRowStuList.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String FaName = driver
					.findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i + "]/td[4]")).getText();
			System.out.println("Father Name: " + FaName);
			Thread.sleep(2000);
			if (FaName.equalsIgnoreCase(FatherName)) {
				try {
					Assert.assertEquals(FaName, FatherName);

					driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[4]/tbody/tr[" + i + "]/td[5]/span"))
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
