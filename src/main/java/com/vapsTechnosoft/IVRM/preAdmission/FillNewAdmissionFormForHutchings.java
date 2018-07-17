/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class FillNewAdmissionFormForHutchings extends TestBase {

	public static final Logger log = Logger.getLogger(FillNewAdmissionFormForHutchings.class.getName());

	WebDriver driver;
	Select select;
	Robot robot;
	/**
	 * locators for new admission form "Hutchings High School Admission Form"
	 */

	@FindBy(xpath = "(//body[@id='style-4']//div/button)[2]")
	WebElement fillNewapplicationFormButton;

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
	WebElement languageatHome;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/div[1]/div[3]/label)[1]")
	WebElement uploadPhoto;

	/**
	 * Other details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[6]")
	WebElement aadharCard;

	@FindBy(xpath = "(//input[@id='usr'])[7]")
	WebElement playGroup;

	@FindBy(xpath = "(//input[@id='usr'])[8]")
	WebElement participationInECA;

	/**
	 * Residential details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[9]")
	WebElement street;

	@FindBy(xpath = "(//input[@id='usr'])[10]")
	WebElement area;

	@FindBy(xpath = "(//select[@id='sel1'])[7]")
	WebElement country;

	@FindBy(xpath = "(//select[@id='sel1'])[8]")
	WebElement state;

	@FindBy(xpath = "(//input[@id='cityId'])[1]")
	WebElement city;

	@FindBy(xpath = "(//input[@id='usr'])[11]")
	WebElement pinCodeZip;

	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[4]/div[1]/div[8]/label")
	WebElement chk_paddsameAsRadd;

	/**
	 * Father's details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[15]")
	WebElement fatherName;

	@FindBy(xpath = "(//input[@id='usr'])[16]")
	WebElement fathersurname;

	@FindBy(xpath = "(//input[@id='usr'])[17]")
	WebElement fatherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[18]")
	WebElement serviceBusiness;

	@FindBy(xpath = "(//input[@id='usr'])[19]")
	WebElement designation;

	@FindBy(xpath = "(//select[@id='sel1'])[10]")
	WebElement fathersNationality;

	@FindBy(xpath = "(//input[@id='usr'])[20]")
	WebElement fatherofficeAddress;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[26]")
	WebElement fatherMobile;

	/**
	 * Mother's details locators
	 */

	@FindBy(xpath = "(//input[@id='usr'])[21]")
	WebElement motherName;

	@FindBy(xpath = "(//input[@id='usr'])[22]")
	WebElement mothersurname;

	@FindBy(xpath = "(//input[@id='usr'])[23]")
	WebElement motherQualification;

	@FindBy(xpath = "(//input[@id='usr'])[24]")
	WebElement motherserviceBusiness;

	@FindBy(xpath = "(//input[@id='usr'])[25]")
	WebElement motherdesignation;

	@FindBy(xpath = "(//select[@id='sel1'])[11]")
	WebElement mothersNationality;

	@FindBy(xpath = "(//input[@id='usr'])[26]")
	WebElement motherofficeAddress;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[33]")
	WebElement motherMobile;
	/**
	 * Monthly income locators
	 */
	@FindBy(xpath = "(//input[@id='usr'])[27]")
	WebElement fatherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[28]")
	WebElement motherIncome;

	@FindBy(xpath = "(//input[@id='usr'])[29]")
	WebElement alternateContact;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[37]")
	WebElement alternateEmail;

	/**
	 * Tables availble on page
	 */

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/table)[2]")
	WebElement table_documentsUpload;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/table)[1]")
	WebElement table_siblingDetails;

	@FindBy(xpath = "(//body[@id='style-4']//div/div[2]/table)[3]")
	WebElement table_studentsList;
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

	@FindBy(xpath = "//td[@id='md-2-month-2014-4-7']")
	WebElement day;
	
	@FindBy(xpath = "//div[@id='md-date-pane-1']//div/div[2]/table/tbody[5]/tr[1]/td[1]")
	WebElement year2015;
	
	@FindBy(xpath = "//td[@id='md-1-year-2015-4-1']/span")
	WebElement May2015;
	
	@FindBy(xpath = "//td[@id='md-1-month-2015-4-7']/span")
	WebElement dateMay2015;
	
	
	/**
	 * Hutching sibling details
	 *
	 */
	@FindBy(xpath = "(//input[@id='usr'])[30]")
	WebElement sibName;
	
	@FindBy(xpath = "(//input[@id='usr'])[31]")
	WebElement sibclass;
	
	@FindBy(xpath = "(//input[@id='usr'])[32]")
	WebElement sibAdmNo;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/table/tbody/tr/td[5])[1]")
	WebElement sibPlus;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/table/tbody/tr/td[5])[2]/span[1]")
	WebElement sibPlusPlus;
	
	@FindBy(xpath = "(//input[@id='usr'])[33]")
	WebElement sndsibName;
	
	@FindBy(xpath = "(//input[@id='usr'])[34]")
	WebElement sndsibclass;
	
	@FindBy(xpath = "(//input[@id='usr'])[35]")
	WebElement sndsibAdmNo;
	
	/**
	 * Documents upload for hutching admission
	 *
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[1]/td[3]/label")
	WebElement tcDocUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[2]/td[3]/label")
	WebElement BirthCertUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[3]/td[3]/label")
	WebElement markSheetUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[4]/td[3]/label")
	WebElement aadharDocUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[5]/td[3]/label")
	WebElement residentialUpload1;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[6]/td[3]/label")
	WebElement residentialUpload2;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[7]/td[3]/label")
	WebElement incomeCertUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[8]/td[3]/label")
	WebElement idProofUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[9]/td[3]/label")
	WebElement FormIUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[10]/td[3]/label")
	WebElement Form2Upload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[11]/td[3]/label")
	WebElement Form4testUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[12]/td[3]/label")
	WebElement conductCertUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[13]/td[3]/label")
	WebElement testadasdUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[14]/td[3]/label")
	WebElement pansUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[15]/td[3]/label")
	WebElement addressProofUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[16]/td[3]/label")
	WebElement passportUpload;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr[17]/td[3]/label")
	WebElement DLUpload;
	/**
	 * Undertaking text and radio button
	 */
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[9]/p")
	WebElement undertakingText;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/label[1]/span)[27]")
	WebElement rdBtnundertaking;
	
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[10]/span/button")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//body[@id='style-4']//div/div[2]/div[1]/div[2]/div[2]/div/div/div")
	WebElement applyingForClassMsg;
	
	
	//test xpath
	@FindBy(xpath = "//div[@id='md-date-pane-1']//div/div[2]/table/tbody[6]/tr[1]/td[1]")
	WebElement yearverify;
	
	@FindBy(xpath = "//td[@id='md-3-year-2015-4-1']/span")
	WebElement clickOnMonth;
	//
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
	 * Constructor 
	 * @param driver
	 */
	public FillNewAdmissionFormForHutchings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/**
 * Students details filling for new admission form
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
 * @param language
 * @param selClass
 * @throws Exception
 */
	public void hutchingNewApplicationFormStudentDetails(String fName, String mName, String sName, String mNumber,
			String birthPlace, String religion, String caste, String gender, String email, String nationality,
			String language, String selClass) throws Exception {
		fillNewapplicationFormButton.click();
		log("cliked on New application form link and object is:-" + fillNewapplicationFormButton.toString());
		Thread.sleep(5000);

		// ((JavascriptExecutor)driver).executeScript("arguments[0].value='08-05-2014'",
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
		log("selected the religion:-" + religion + " and object is " + selectReligion.toString());
		Thread.sleep(1000);
		select = new Select(selectCaste);
		select.selectByVisibleText(caste);
		log("selected the caste:-" + caste + " and object is " + selectCaste.toString());
		Thread.sleep(1000);
		select = new Select(selgender);
		select.selectByVisibleText(gender);
		log("selected the gender:-" + gender + " and object is " + selgender.toString());
		Thread.sleep(1000);

		emailID.sendKeys(email);
		log("entered student emailid:-" + email + " and object is " + emailID.toString());
		Thread.sleep(1000);
		select = new Select(selnationality);
		select.selectByVisibleText(nationality);
		log("selected the nationality:-" + nationality + " and object is " + selnationality.toString());
		Thread.sleep(1000);
		languageatHome.sendKeys(language);
		log("entered language use at home:-" + language + " and object is " + languageatHome.toString());

		
		imageAndDocumentUpload(uploadPhoto,"Photo.jpg");
		log("Student image uploaded successfully");
		
	
		calendarButton.click();
		log("cliked on calendar button and object is:-" + calendarButton.toString());
		Thread.sleep(2000);
		leftMonthYear.click();
		log("cliked on left side of calendar month year button and object is:-" + leftMonthYear.toString());
		Thread.sleep(2000);
//		((JavascriptExecutor)driver).executeScript("arguments[0].value='08052015'", datefield);
//		datefield.sendKeys(Keys.TAB);
		selectDate(leftYear, month, days, "2016", "May", "20");
		log("selected date of birth");
		Thread.sleep(2000);
		
		select = new Select(selectClass);
		select.selectByVisibleText(selClass);
		log("selected the class:-"+selClass+" and object is " + selectClass.toString());
		Thread.sleep(2000);
		
	}
/**
 * Filling of others details in Hutching new admission from
 * @param aadhar
 * @param PlayGroup
 * @param ECA
 * @throws Exception
 */
	public void hutchingOtherDetails(String aadhar, String PlayGroup, String ECA) throws Exception {

		aadharCard.sendKeys(aadhar);
		log("entered aadhar number:-" + aadhar + " and object is " + aadharCard.toString());
		Thread.sleep(1000);
		playGroup.sendKeys(PlayGroup);
		log("entered play group name:-" + PlayGroup + " and object is " + playGroup.toString());
		Thread.sleep(1000);
		participationInECA.sendKeys(ECA);
		log("entered extra corricular activity:-" + ECA + " and object is " + participationInECA.toString());
		Thread.sleep(1000);
	}
/**
 * Form fill of hutching residential details data and mapping the same for permanent address
 * @param rStreet
 * @param rArea
 * @param rCountry
 * @param rState
 * @param rCity
 * @param rPinZip
 * @throws Exception
 */
	public void residentialAddres(String rStreet, String rArea, String rCountry, String rState, String rCity,
			String rPinZip) throws Exception {

		street.sendKeys(rStreet);
		log("entered street name:-" + rStreet + " and object is " + street.toString());
		Thread.sleep(1000);
		area.sendKeys(rArea);
		log("entered first name:-" + rArea + " and object is " + area.toString());
		Thread.sleep(1000);
		select = new Select(country);
		select.selectByVisibleText(rCountry);
		log("selected the country from country list:-" + rCountry + " and object is " + country.toString());
		Thread.sleep(1000);
		select = new Select(state);
		select.selectByVisibleText(rState);
		log("selected the state from state list:-" + rState + " and object is " + state.toString());
		Thread.sleep(1000);
		city.sendKeys(rCity);
		log("entered city name:-" + rCity + " and object is " + city.toString());
		Thread.sleep(1000);
		pinCodeZip.sendKeys(rPinZip);
		log("entered pin code:-" + rPinZip + " and object is " + pinCodeZip.toString());
		Thread.sleep(1000);

		chk_paddsameAsRadd.click();
		log("cliked on permanent and residential address same check box and object is:-" + calendarButton.toString());
		Thread.sleep(1000);
	}
/**
 * Father's details for hutching new admission form
 * @param fname
 * @param fsurName
 * @param fQualification
 * @param fserBusiness
 * @param fDesignation
 * @param fNationality
 * @param fOfficeAdd
 * @param fmobileNo
 * @throws Exception
 */
	public void hutchingFathersDetails(String fname, String fsurName, String fQualification, String fserBusiness,
			String fDesignation, String fNationality, String fOfficeAdd, String fmobileNo) throws Exception {
		
		fatherName.sendKeys(fname);
		log("entered father Name:-" + fname + " and object is " + fatherName.toString());
		Thread.sleep(1000);
		fathersurname.sendKeys(fsurName);
		log("entered father surname:-" + fsurName + " and object is " + fathersurname.toString());
		Thread.sleep(1000);
		fatherQualification.sendKeys(fQualification);
		log("entered father qualification:-" + fQualification + " and object is " + fatherQualification.toString());
		Thread.sleep(1000);
		serviceBusiness.sendKeys(fserBusiness);
		log("entered father service or business:-" + fserBusiness + " and object is " + serviceBusiness.toString());
		Thread.sleep(1000);
		designation.sendKeys(fDesignation);
		log("entered father designation:-" + fDesignation + " and object is " + designation.toString());
		Thread.sleep(1000);
		select = new Select(fathersNationality);
		select.selectByVisibleText(fNationality);
		log("selected the father nationality:-" + fNationality + " and object is " + fathersNationality.toString());
		Thread.sleep(1000);
		fatherofficeAddress.sendKeys(fOfficeAdd);
		log("entered father official address:-" + fOfficeAdd + " and object is " + fatherofficeAddress.toString());
		Thread.sleep(1000);
		fatherMobile.sendKeys(fmobileNo);
		log("entered father mobile number:-" + fmobileNo + " and object is " + fatherMobile.toString());
		Thread.sleep(1000);
	}
/**
 * Mother's details for Hutching new admission form
 * @param mname
 * @param msurName
 * @param mQualification
 * @param mserBusiness
 * @param mDesignation
 * @param mNationality
 * @param mOfficeAdd
 * @param mmobileNo
 * @throws Exception
 */
	public void hutchingMothersDetails(String mname, String msurName, String mQualification, String mserBusiness,
			String mDesignation, String mNationality, String mOfficeAdd, String mmobileNo) throws Exception {
		
		motherName.sendKeys(mname);
		log("entered mother Name:-" + mname + " and object is " + motherName.toString());
		Thread.sleep(1000);
		mothersurname.sendKeys(msurName);
		log("entered mother surname:-" + msurName + " and object is " + mothersurname.toString());
		Thread.sleep(1000);
		motherQualification.sendKeys(mQualification);
		log("entered mother qualification:-" + mQualification + " and object is " + motherQualification.toString());
		Thread.sleep(1000);
		motherserviceBusiness.sendKeys(mserBusiness);
		log("entered mother service or business:-" + mserBusiness + " and object is " + motherserviceBusiness.toString());
		Thread.sleep(1000);
		motherdesignation.sendKeys(mDesignation);
		log("entered mother designation:-" + mDesignation + " and object is " + motherdesignation.toString());
		Thread.sleep(1000);
		select = new Select(mothersNationality);
		select.selectByVisibleText(mNationality);
		log("selected the mother nationality:-" + mNationality + " and object is " + mothersNationality.toString());
		Thread.sleep(1000);
		motherofficeAddress.sendKeys(mOfficeAdd);
		log("entered mother official address:-" + mOfficeAdd + " and object is " + motherofficeAddress.toString());
		Thread.sleep(1000);
		motherMobile.sendKeys(mmobileNo);
		log("entered mother mobile number:-" + mmobileNo + " and object is " + motherMobile.toString());
		Thread.sleep(1000);
	}
	/**
	 * Parents monthly income declaration for admission process
	 * @param fIncome
	 * @param mIncome
	 * @param altrContact
	 * @param altrEmail
	 * @throws Exception
	 */
	public void parentsMonthlyIncome(String fIncome, String mIncome, String altrContact, String altrEmail) throws Exception{
		
		fatherIncome.sendKeys(fIncome);
		log("entered father monthly income:-" + fIncome + " and object is " + fatherIncome.toString());
		Thread.sleep(1000);
		motherIncome.sendKeys(mIncome);
		log("entered mother monthly income:-" + mIncome + " and object is " + motherIncome.toString());
		Thread.sleep(1000);
		alternateContact.sendKeys(altrContact);
		log("entered parent alternate contact:-" + altrContact + " and object is " + alternateContact.toString());
		Thread.sleep(1000);
		alternateEmail.sendKeys(altrEmail);
		log("entered parent alternate email:-" + altrEmail + " and object is " + alternateEmail.toString());
		Thread.sleep(1000);	
	}
	/**
	 * Sibling details who is already admitted to hutching school
	 * @param sibName1
	 * @param sibClass1
	 * @param sibAdmNo1
	 * @throws Exception
	 */
	public void siblingDetails(String sibingName, String siblingClass, String siblingAdmNo) throws Exception{
		sibName.sendKeys(sibingName);
		log("entered sibling name:-" + sibingName + " and object is " + sibName.toString());
		Thread.sleep(1000);
		sibclass.sendKeys(siblingClass);
		log("entered sibling class:-" + siblingClass + " and object is " + sibclass.toString());
		Thread.sleep(1000);
		sibAdmNo.sendKeys(siblingAdmNo);
		log("entered sibling adm number:-" + siblingAdmNo + " and object is " + sibAdmNo.toString());
		Thread.sleep(1000);
		
		sibPlus.click();
		log("cliked on plus sign to add rows:-" + sibPlus.toString());
		Thread.sleep(2000);
		
		sndsibName.sendKeys(sibingName);
		log("entered sibling name:-" + sibingName + " and object is " + sibName.toString());
		Thread.sleep(1000);
		sndsibclass.sendKeys(siblingClass);
		log("entered sibling class:-" + siblingClass + " and object is " + sibclass.toString());
		Thread.sleep(1000);
		sndsibAdmNo.sendKeys(siblingAdmNo);
		log("entered sibling adm number:-" + siblingAdmNo + " and object is " + sibAdmNo.toString());
		Thread.sleep(1000);
	}
	public void requiredDocumentsUplolad() throws Exception{
		
		imageAndDocumentUpload(tcDocUpload,"TransferCertificate.jpg");
		log("Tc certificate uploaded successfully");
		
		imageAndDocumentUpload(BirthCertUpload,"TransferCertificate.jpg");
		log("Birth certificate uploaded successfully");
		
		imageAndDocumentUpload(markSheetUpload,"TransferCertificate.jpg");
		log("Marks sheet certificate uploaded successfully");
		
		imageAndDocumentUpload(aadharDocUpload,"TransferCertificate.jpg");
		log("Aadhar documents uploaded successfully");
		
		imageAndDocumentUpload(residentialUpload1,"TransferCertificate.jpg");
		log("Residential proof1 uploaded successfully");
		
		imageAndDocumentUpload(residentialUpload2,"TransferCertificate.jpg");
		log("Residential proof2 uploaded successfully");
		
		imageAndDocumentUpload(incomeCertUpload,"TransferCertificate.jpg");
		log("Income certificate uploaded successfully");
		
		imageAndDocumentUpload(idProofUpload,"TransferCertificate.jpg");
		log("ID proof uploaded successfully");
		
		imageAndDocumentUpload(FormIUpload,"TransferCertificate.jpg");
		log("Form I uploaded successfully");
		
		imageAndDocumentUpload(Form2Upload,"TransferCertificate.jpg");
		log("Form 2 uploaded successfully");
		
		imageAndDocumentUpload(Form4testUpload,"TransferCertificate.jpg");
		log("Form 4 test uploaded successfully");
		
		imageAndDocumentUpload(conductCertUpload,"TransferCertificate.jpg");
		log("Conduct certificate uploaded successfully");
		
		imageAndDocumentUpload(testadasdUpload,"TransferCertificate.jpg");
		log("Testadasd uploaded successfully");
		
		imageAndDocumentUpload(pansUpload,"TransferCertificate.jpg");
		log("Pan card uploaded successfully");
		
		imageAndDocumentUpload(addressProofUpload,"TransferCertificate.jpg");
		log("Address proof uploaded successfully");
		
		imageAndDocumentUpload(passportUpload,"TransferCertificate.jpg");
		log("Passport uploaded successfully");
		
		imageAndDocumentUpload(DLUpload,"TransferCertificate.jpg");
		log("Driving licence uploaded successfully");
	}
	/**
	 * Verify undertaking message is display and confirm the undertaking
	 */
	public boolean verifyUndertakingText(){
		
		try {
			undertakingText.isDisplayed();
			log("undertaking message is dispalyed and object is:-"+undertakingText.toString());
			return true;
			
		} catch (Exception e) {
			return false;
		}
	
	}
	public void confirmUndertaking() throws Exception{
		rdBtnundertaking.click();
		log("Yes button is selected and object is:"+rdBtnundertaking.toString());
		Thread.sleep(2000);
	}
	public void clickOnSubmitButton() throws Exception{
		btnSubmit.click();
		log("clicked on Submit button and object is:-"+btnSubmit);
		Thread.sleep(2000);
	}
	public void popUpValidationCancel() throws Exception{
		btnsubmitCancel.click();
		log("Submit confirmation popup cancel button clicked and object is:-"+btnsubmitCancel.toString());
		Thread.sleep(2000);
	}
	public void popUpValidationYes() throws InterruptedException{
		btnsubmitYes.click();
		log("Submit confirmation popup Yes button clicked and object is:-"+btnsubmitYes.toString());
		Thread.sleep(2000);
	}
	public void popUpValidationonSuccess() throws InterruptedException{
		btnOkonsuccess.click();
		log("Submit confirmation popup successful registration ok button clicked and object is:-"+btnOkonsuccess.toString());
		Thread.sleep(2000);
	}
}

