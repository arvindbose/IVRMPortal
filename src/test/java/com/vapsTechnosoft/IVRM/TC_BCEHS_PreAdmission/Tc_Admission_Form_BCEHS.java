/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_BCEHS_PreAdmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.BCEHS_PreAdmission.Admission_Form_BCEHS;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Admission_Form_BCEHS extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Admission_Form_BCEHS.class.getName());

	Admission_Form_BCEHS bcehsForm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "BCEHSPreAdmFormData")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_StudentDetailsData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "BCEHS_OthersDetails")
	public String[][] getTestDataOthersDetails() {
		String[][] testRecordsOtherDetails = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_OthersDetails");
		return testRecordsOtherDetails;
	}

	@DataProvider(name = "BCEHS_ResidentialAddress")
	public String[][] getTestDataResidentialAddress() {
		String[][] testRecordsAddress = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_Address");
		return testRecordsAddress;
	}

	@DataProvider(name = "BCEHSFatherDetails")
	public String[][] getTestDataFathersDetails() {
		String[][] testRecordsFather = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_FathersInfo");
		return testRecordsFather;
	}

	@DataProvider(name = "BCEHSMotherDetails")
	public String[][] getTestDataMothersDetails() {
		String[][] testRecordsmother = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_MothersInfo");
		return testRecordsmother;
	}

	@DataProvider(name = "BCEHSMonthlyIncome")
	public String[][] getTestDataMonthlyIncome() {
		String[][] testRecordsmonthlyIncome = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_MonthlyIncomeAdmFormData");
		return testRecordsmonthlyIncome;
	}

	@DataProvider(name = "GuardianDetailsData")
	public String[][] getTestDataGuardian() {
		String[][] testRecordsGuardian = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_PreAdm_GuardianData");
		return testRecordsGuardian;
	}

	@DataProvider(name = "SiblingDetailsData")
	public String[][] getTestDataSibling() {
		String[][] testRecordsSibling = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_SiblingData");
		return testRecordsSibling;
	}

	@DataProvider(name = "PreviousSchoolDetailsData")
	public String[][] getTestDataPrevSchool() {
		String[][] testRecordsPrevSchool = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_PreviousSchoolData");
		return testRecordsPrevSchool;
	}

	@DataProvider(name = "UndertakingTextData")
	public String[][] getTestDataDocUpload() {
		String[][] testRecordsDocUpload = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_UnderTakingTextData");
		return testRecordsDocUpload;
	}

	@DataProvider(name = "SearchByFatherNameData")
	public String[][] getTestDatafathername() {
		String[][] testRecordsFatherName = getData("BCEHS_PreAdmissionData.xlsx", "BCEHS_FatherNameSearchData");
		return testRecordsFatherName;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		bcehsForm = new Admission_Form_BCEHS(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting login to the Vaps IVRM application===========");
			getScreenShot("Login Page");
			ivrmportallogin.loginToApplication(username, password);

			boolean status = ivrmportallogin.verifyLoginToIVRMportal();

			Assert.assertEquals(status, true);
			log.info("============= Finished loginToappWithrequiredCredentials===========");

			getScreenShot("loginToappWithrequiredCredentials");
		} catch (Exception e) {
			getScreenShot("loginToappWithrequiredCredentials");
		}
	}

	@Test(priority = 2)
	public void tcHomeButtonValidation() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = bcehsForm.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Form_BCEHS() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcNavigateToAdmission_Form_BCEHS Test===========");

			bcehsForm.navigateToAdmission_Form_BCEHS();

			log.info("============= Finished tcNavigateToAdmission_Form_BCEHS Test===========");
			getScreenShot("tcNavigateToAdmission_Form_BCEHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Form_BCEHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Form_BCEHSPage() {

		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcVerifyAdmission_Form_BCEHSPage Test===========");

			boolean status = bcehsForm.verifyAdmission_Form_BCEHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmission_Form_BCEHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Form_BCEHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Form_BCEHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "BCEHSPreAdmFormData")
	public void enterStudentInformationFor_BCEHSPreAdmForm(String fName, String mName, String sName, String mNumber,
			String birthPlace, String religion, String caste, String gender, String email, String nationality,
			String motherTongue, String Syllabus, String selClass, String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting hutchingAdmissionForm Test===========");

			bcehsForm.enterStudentInformationFor_BCEHSPreAdmForm(fName, mName, sName, mNumber, birthPlace, religion,
					caste, gender, email, nationality, motherTongue, Syllabus, selClass);
			log.info("============= Finished hutchingAdmissionForm Test===========");
			getScreenShot("hutchingAdmissionForm");
		} catch (Exception e) {
			getScreenShot("hutchingAdmissionForm");
		}
	}

	@Test(priority = 6, dataProvider = "BCEHS_OthersDetails")
	public void tcOthersDetailsForBcehsAdmForm(String Language2, String Language3, String tribe, String playGroup,
			String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcothersDetailsForBcehsAdmForm Test===========");

			bcehsForm.othersDetailsForBcehsAdmForm(Language2, Language3, tribe, playGroup);
			log.info("============= Finished tcothersDetailsForBcehsAdmForm Test===========");
			getScreenShot("tcothersDetailsForBcehsAdmForm");
		} catch (Exception e) {
			getScreenShot("tcothersDetailsForBcehsAdmForm");
		}

	}

	@Test(priority = 7, dataProvider = "BCEHS_ResidentialAddress")
	public void tcResidentialAndPermanentAddress(String street, String area, String Country, String state, String city,
			String pinZip, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcResidentialAndPermanentAddress Test===========");

			bcehsForm.residentialAndPermanentAddress(street, area, Country, state, city, pinZip);
			log.info("============= Finished tcResidentialAndPermanentAddress Test===========");
			getScreenShot("tcResidentialAndPermanentAddress");
		} catch (Exception e) {
			getScreenShot("tcResidentialAndPermanentAddress");
		}
	}

	@Test(priority = 8, dataProvider = "BCEHSFatherDetails")
	public void tcFathersDetails_BCEHSPreAdmissionForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherOccupation, String fatherReligion, String fatherCaste,
			String fatherTribe, String fatherNationanlity, String fatherEmailid, String fatherPhOffice,
			String fatherPhoneRes, String fatherMobile, String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFathersDetails_BCEHSPreAdmissionForm Test===========");

			bcehsForm.fathersDetails_BCEHSPreAdmissionForm(fatherName, fatherSurName, fatherQualification,
					fatherOccupation, fatherReligion, fatherCaste, fatherTribe, fatherNationanlity, fatherEmailid,
					fatherPhOffice, fatherPhoneRes, fatherMobile);
			log.info("============= Finished tcFathersDetails_BCEHSPreAdmissionForm Test===========");
			getScreenShot("tcFathersDetails_BCEHSPreAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcFathersDetails_BCEHSPreAdmissionForm");
		}
	}

	@Test(priority = 9, dataProvider = "BCEHSMotherDetails")
	public void tcMothersDetails_BCEHSPreAdmissionForm(String motherName, String motherSurName,
			String motherQualification, String motherOccupation, String motherReligion, String motherCaste,
			String motherTribe, String motherNationanlity, String motherEmailid, String motherPhOffice,
			String motherPhoneRes, String motherMobile, String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMothersDetails_BCEHSPreAdmissionForm Test===========");

			bcehsForm.mothersDetails_BCEHSPreAdmissionForm(motherName, motherSurName, motherQualification,
					motherOccupation, motherReligion, motherCaste, motherTribe, motherNationanlity, motherEmailid,
					motherPhOffice, motherPhoneRes, motherMobile);
			log.info("============= Finished tcMothersDetails_BCEHSPreAdmissionForm Test===========");
			getScreenShot("tcMothersDetails_BCEHSPreAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcMothersDetails_BCEHSPreAdmissionForm");
		}
	}

	@Test(priority = 10, dataProvider = "BCEHSMonthlyIncome")
	public void tcMonthlyIncomeDetailsBCEHS(String fatherIncome, String motherIncome, String altContact,
			String altEmail, String runMode) {
		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMonthlyIncomeDetailsBCEHS Test===========");

			bcehsForm.monthlyIncomeDetailsBCEHS(fatherIncome, motherIncome, altContact, altEmail);
			log.info("============= Finished tcMonthlyIncomeDetailsBCEHS Test===========");
			getScreenShot("tcMonthlyIncomeDetailsBCEHS");
		} catch (Exception e) {
			getScreenShot("tcMonthlyIncomeDetailsBCEHS");
		}
	}

	@Test(priority = 11, dataProvider = "GuardianDetailsData")
	public void tcGurdianDetailsBCEHSPreAdm(String guardianName, String gurdianRelWithStu, String gurdianOccupation,
			String guardianPhoneOffice, String guardianPhRes, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcGurdianDetailsBCEHSPreAdm Test===========");

			bcehsForm.gurdianDetailsBCEHSPreAdm(guardianName, gurdianRelWithStu, gurdianOccupation, guardianPhoneOffice,
					guardianPhRes);
			log.info("============= Finished tcGurdianDetailsBCEHSPreAdm Test===========");
			getScreenShot("tcGurdianDetailsBCEHSPreAdm");
		} catch (Exception e) {
			getScreenShot("tcGurdianDetailsBCEHSPreAdm");
		}
	}

	@Test(priority = 12, dataProvider = "SiblingDetailsData")
	public void tcSiblingdetailsBCEHSPreAdm(String siblingName, String siblingClass, String siblingAdmNo,
			String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSiblingdetailsBCEHSPreAdm Test===========");

			bcehsForm.siblingdetailsBCEHSPreAdm(siblingName, siblingClass, siblingAdmNo);
			log.info("============= Finished tcSiblingdetailsBCEHSPreAdm Test===========");
			getScreenShot("tcSiblingdetailsBCEHSPreAdm");
		} catch (Exception e) {
			getScreenShot("tcSiblingdetailsBCEHSPreAdm");
		}
	}

	@Test(priority = 13)
	public void tcUploadfatherAndMotherPhotos() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcUploadfatherAndMotherPhotos Test===========");

			bcehsForm.uploadfatherAndMotherPhotos();
			log.info("============= Finished tcUploadfatherAndMotherPhotos Test===========");
			getScreenShot("tcUploadfatherAndMotherPhotos");
		} catch (Exception e) {
			getScreenShot("tcUploadfatherAndMotherPhotos");
		}
	}

	@Test(priority = 14, dataProvider = "PreviousSchoolDetailsData")
	public void tcPreviousSchoolDetailsBCEHS(String prevSchoolName, String prevClass, String prevGrade,
			String prevPassedYr, String PrevAddress, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcPreviousSchoolDetailsBCEHS Test===========");

			bcehsForm.previousSchoolDetailsBCEHS(prevSchoolName, prevClass, prevGrade, prevPassedYr, PrevAddress);
			log.info("============= Finished tcPreviousSchoolDetailsBCEHS Test===========");
			getScreenShot("tcPreviousSchoolDetailsBCEHS");
		} catch (Exception e) {
			getScreenShot("tcPreviousSchoolDetailsBCEHS");
		}
	}

	/*
	 * @Test(priority=15,dataProvider="DocumentsUploadData") public void
	 * tcUploadDOBCertificateDocumentsForBceHSPreAdmForm(String
	 * dobCertificateText,String runMode){
	 * 
	 * bcehsForm = new Admission_Form_BCEHS(driver);
	 * if(runMode.equalsIgnoreCase("Addr")){ throw new
	 * SkipException("user marked this record as no run"); } try { log.
	 * info("============= Strting tcUploadDOBCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * );
	 * 
	 * bcehsForm.uploadDOBCertificateDocumentsForBceHSPreAdmForm(
	 * dobCertificateText); log.
	 * info("============= Finished tcUploadDOBCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * ); getScreenShot("tcUploadDOBCertificateDocumentsForBceHSPreAdmForm"); }
	 * catch(Exception e){
	 * getScreenShot("tcUploadDOBCertificateDocumentsForBceHSPreAdmForm");
	 * 
	 * } }
	 * 
	 * @Test(priority=16,dataProvider="DocumentsUploadData") public void
	 * tcUploadAddressProofCertificateDocumentsForBceHSPreAdmForm(String
	 * addressProofText,String runMode){
	 * 
	 * bcehsForm = new Admission_Form_BCEHS(driver);
	 * if(runMode.equalsIgnoreCase("Dob")){ throw new
	 * SkipException("user marked this record as no run"); } try { log.
	 * info("============= Strting tcUploadAddressProofCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * );
	 * 
	 * bcehsForm.uploadAddressProofCertificateDocumentsForBceHSPreAdmForm(
	 * addressProofText); log.
	 * info("============= Finished tcUploadAddressProofCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * ); getScreenShot(
	 * "tcUploadAddressProofCertificateDocumentsForBceHSPreAdmForm"); }
	 * catch(Exception e){ getScreenShot(
	 * "tcUploadAddressProofCertificateDocumentsForBceHSPreAdmForm");
	 * 
	 * } }
	 * 
	 * @Test(priority=17,dataProvider="DocumentsUploadData") public void
	 * tcValidationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm(String
	 * dobCertificateText,String runMode){
	 * 
	 * bcehsForm = new Admission_Form_BCEHS(driver);
	 * if(runMode.equalsIgnoreCase("Addr")){ throw new
	 * SkipException("user marked this record as no run"); } try { log.
	 * info("============= Strting tcValidationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * );
	 * 
	 * bcehsForm.validationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm(
	 * dobCertificateText); log.
	 * info("============= Finished tcValidationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * ); getScreenShot(
	 * "tcValidationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm"); }
	 * catch(Exception e){ getScreenShot(
	 * "tcValidationOfUploadedDOBCertificateDocumentsForBceHSPreAdmForm");
	 * 
	 * } }
	 * 
	 * @Test(priority=18,dataProvider="DocumentsUploadData") public void
	 * tcValidationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm(
	 * String addressProofText,String runMode){
	 * 
	 * bcehsForm = new Admission_Form_BCEHS(driver);
	 * if(runMode.equalsIgnoreCase("Dob")){ throw new
	 * SkipException("user marked this record as no run"); } try { log.
	 * info("============= Strting tcValidationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * );
	 * 
	 * bcehsForm.
	 * validationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm(
	 * addressProofText); log.
	 * info("============= Finished tcValidationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm Test==========="
	 * ); getScreenShot(
	 * "tcValidationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm"
	 * ); } catch(Exception e){ getScreenShot(
	 * "tcValidationOfUploadedAddressProofCertificateDocumentsForBceHSPreAdmForm"
	 * );
	 * 
	 * } }
	 */
	@Test(priority = 15)
	public void tcUploadRequiredDetails() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcUploadRequiredDetails Test===========");

			bcehsForm.uploadRequiredDetails();
			log.info("============= Finished tcUploadRequiredDetails Test===========");
			getScreenShot("tcUploadRequiredDetails");
		} catch (Exception e) {
			getScreenShot("tcUploadRequiredDetails");
		}
	}

	@Test(priority = 16)
	public void tcValidationOfUploadedDOBCertificate() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcValidationOfUploadedDOBCertificate Test===========");

			bcehsForm.validationOfUploadedDOBCertificate();
			log.info("============= Finished tcValidationOfUploadedDOBCertificate Test===========");
			getScreenShot("tcValidationOfUploadedDOBCertificate");
		} catch (Exception e) {
			getScreenShot("tcValidationOfUploadedDOBCertificate");
		}
	}

	@Test(priority = 17)
	public void tcClickOnPopupCloseButtonForDOBCert() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcClickOnPopupCloseButtonForDOBCert Test===========");

			bcehsForm.clickOnPopupCloseButton();
			log.info("============= Finished tcClickOnPopupCloseButtonForDOBCert Test===========");
			getScreenShot("tcClickOnPopupCloseButtonForDOBCert");
		} catch (Exception e) {
			getScreenShot("tcClickOnPopupCloseButtonForDOBCert");
		}
	}

	@Test(priority = 18)
	public void tcValidationOfUploadedAddressProofCertificate() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcValidationOfUploadedAddressProofCertificate Test===========");

			bcehsForm.validationOfUploadedAddressProofCertificate();
			log.info("============= Finished tcValidationOfUploadedAddressProofCertificate Test===========");
			getScreenShot("tcValidationOfUploadedAddressProofCertificate");
		} catch (Exception e) {
			getScreenShot("tcValidationOfUploadedAddressProofCertificate");
		}
	}

	@Test(priority = 19)
	public void tcClickOnPopupCloseButtonForAddress() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcClickOnPopupCloseButtonForAddress Test===========");

			bcehsForm.clickOnPopupCloseButton();
			log.info("============= Finished tcClickOnPopupCloseButtonForAddress Test===========");
			getScreenShot("tcClickOnPopupCloseButtonForAddress");
		} catch (Exception e) {
			getScreenShot("tcClickOnPopupCloseButtonForAddress");
		}
	}

	@Test(priority = 20, dataProvider = "UndertakingTextData")
	public void tcVerifyUndertakingText(String textToVerify) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		try {
			log.info("============= Strting tcVerifyUndertakingText Test===========");

			bcehsForm.verifyUndertakingText(textToVerify);
			log.info("============= Finished tcVerifyUndertakingText Test===========");
			getScreenShot("tcVerifyUndertakingText");
		} catch (Exception e) {
			getScreenShot("tcVerifyUndertakingText");

		}
	}

	@Test(priority = 21)
	public void tcConfirmUndertakingYes() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcConfirmUndertakingYes Test===========");

			bcehsForm.confirmUndertakingYes();
			log.info("============= Finished tcConfirmUndertakingYes Test===========");
			getScreenShot("tcConfirmUndertakingYes");
		} catch (Exception e) {
			getScreenShot("tcConfirmUndertakingYes");
		}
	}

	@Test(priority = 22)
	public void tcClickOnSubmitButton() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButton Test===========");

			bcehsForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButton Test===========");
			getScreenShot("tcClickOnSubmitButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton");
		}
	}

	@Test(priority = 23)
	public void tcPopUpValidationCancel() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationCancel Test===========");

			bcehsForm.popUpValidationCancel();
			log.info("============= Finished tcPopUpValidationCancel Test===========");
			getScreenShot("tcClickOnSubmitButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSubmitButtonForFinalSubmit() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButtonForFinalSubmit Test===========");

			bcehsForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButtonForFinalSubmit Test===========");
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit");
		}
	}

	@Test(priority = 25)
	public void tcPopUpValidationYes() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationYes Test===========");

			bcehsForm.popUpValidationYes();
			log.info("============= Finished tcPopUpValidationYes Test===========");
			getScreenShot("tcPopUpValidationYes");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYes");
		}
	}

	@Test(priority = 26)
	public void tcPopUpValidationCancelForPaymentPage() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationCancelForPaymentPage Test===========");

			bcehsForm.popUpValidationCancel();
			log.info("============= Finished tcPopUpValidationCancelForPaymentPage Test===========");
			getScreenShot("tcPopUpValidationCancelForPaymentPage");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationCancelForPaymentPage");
		}
	}

	@Test(priority = 27, dataProvider = "SearchByFatherNameData")
	public void tcSearchByFatherNameInGridFor_PayRegistrationFee(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("y")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByFatherNameInGrid_PayRegistrationFee Test===========");

			bcehsForm.searchByFatherNameInGrid(FatherName);
			log.info("============= Finished tcSearchByFatherNameInGrid_PayRegistrationFee Test===========");
			getScreenShot("tcSearchByFatherNameInGrid_PayRegistrationFee");
		} catch (Exception e) {
			getScreenShot("tcSearchByFatherNameInGrid_PayRegistrationFee");

		}
	}

	@Test(priority = 28, dataProvider = "SearchByFatherNameData")
	public void tcVerifyFatherNameInStudentListGrid_PayRegistrationFee_BCEHSForm(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("y")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyFatherNameInStudentListGrid Test===========");

			bcehsForm.verifyFatherNameInStudentListGrid(FatherName);
			log.info("============= Finished tcVerifyFatherNameInStudentListGrid Test===========");
			getScreenShot("tcVerifyFatherNameInStudentListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyFatherNameInStudentListGrid");

		}
	}

	@Test(priority = 29, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm(String FatherName,
			String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("y")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm Test===========");

			bcehsForm.searchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm(FatherName);
			log.info(
					"============= Finished tcSearchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid__PayRegistrationFee_BCEHSForm");

		}
	}

	@Test(priority = 30)
	public void tcBack_PayRegistrationFee() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcBack_PayRegistrationFee Test===========");

			bcehsForm.back_PayRegistrationFee();
			log.info("============= Finished tcBack_PayRegistrationFee Test===========");
			getScreenShot("tcBack_PayRegistrationFee");
		} catch (Exception e) {
			getScreenShot("tcBack_PayRegistrationFee");
		}
	}

	@Test(priority = 31, dataProvider = "SearchByFatherNameData")
	public void tcSearchByFatherNameInGrid(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByFatherNameInGrid Test===========");

			bcehsForm.searchByFatherNameInGrid(FatherName);
			log.info("============= Finished tcSearchByFatherNameInGrid Test===========");
			getScreenShot("tcSearchByFatherNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByFatherNameInGrid");

		}
	}

	@Test(priority = 32, dataProvider = "SearchByFatherNameData")
	public void tcVerifyFatherNameInStudentListGrid(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyFatherNameInStudentListGrid Test===========");

			bcehsForm.verifyFatherNameInStudentListGrid(FatherName);
			log.info("============= Finished tcVerifyFatherNameInStudentListGrid Test===========");
			getScreenShot("tcVerifyFatherNameInStudentListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyFatherNameInStudentListGrid");

		}
	}

	@Test(priority = 33, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid_Edit_BCEHSForm(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithFatherNameInStudentListGrid_Edit_BCEHSForm Test===========");

			bcehsForm.searchWithFatherNameInStudentListGrid_Edit_BCEHSForm(FatherName);
			log.info("============= Finished tcSearchWithFatherNameInStudentListGrid_Edit_BCEHSForm Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_Edit_BCEHSForm");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_Edit_BCEHSForm");

		}
	}

	@Test(priority = 34)
	public void tcClickOnSubmitButtonForFinalSubmit_AfterEdit() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButtonForFinalSubmit_AfterEdit Test===========");

			bcehsForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButtonForFinalSubmit_AfterEdit Test===========");
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit_AfterEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit_AfterEdit");
		}
	}

	@Test(priority = 35)
	public void tcPopUpValidationYesEdit() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationYesEdit Test===========");

			bcehsForm.popUpValidationYes();
			log.info("============= Finished tcPopUpValidationYesEdit Test===========");
			getScreenShot("tcPopUpValidationYesEdit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYesEdit");
		}
	}

	@Test(priority = 36)
	public void tcSelctionOfSubmitActionForEdit() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcSelctionOfSubmitActionForEdit Test===========");

			bcehsForm.selctionOfSubmitActionForEdit();
			log.info("============= Finished tcSelctionOfSubmitActionForEdit Test===========");
			getScreenShot("tcSelctionOfSubmitActionForEdit");
		} catch (Exception e) {
			getScreenShot("tcSelctionOfSubmitActionForEdit");
		}
	}

	@Test(priority = 37, dataProvider = "SearchByFatherNameData")
	public void tcSearchByFatherNameInGrid_ProspectusDownload(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByFatherNameInGrid_ProspectusDownload Test===========");

			bcehsForm.searchByFatherNameInGrid(FatherName);
			log.info("============= Finished tcSearchByFatherNameInGrid_ProspectusDownload Test===========");
			getScreenShot("tcSearchByFatherNameInGrid_ProspectusDownload");
		} catch (Exception e) {
			getScreenShot("tcSearchByFatherNameInGrid_ProspectusDownload");

		}
	}
	///

	@Test(priority = 38, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm(String FatherName,
			String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm Test===========");

			bcehsForm.searchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm(FatherName);
			log.info(
					"============= Finished tcSearchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_DownLoadProspectus_BCEHS_AdmissionForm");

		}
	}

	@Test(priority = 39)
	public void tcSwitchWindowsForProspectusDownload() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcSwitchWindowsForProspectusDownload Test===========");

			bcehsForm.switchWindowsForProspectusDownload();
			log.info("============= Finished tcSwitchWindowsForProspectusDownload Test===========");
			getScreenShot("tcSwitchWindowsForProspectusDownload");
		} catch (Exception e) {
			getScreenShot("tcSwitchWindowsForProspectusDownload");
		}
	}

	@Test(priority = 40, dataProvider = "SearchByFatherNameData")
	public void tcSearchByFatherNameInGrid_view(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByFatherNameInGrid_view Test===========");

			bcehsForm.searchByFatherNameInGrid(FatherName);
			log.info("============= Finished tcSearchByFatherNameInGrid_view Test===========");
			getScreenShot("tcSearchByFatherNameInGrid_view");
		} catch (Exception e) {
			getScreenShot("tcSearchByFatherNameInGrid_view");

		}
	}

	@Test(priority = 41, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm(String FatherName, String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm Test===========");

			bcehsForm.searchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm(FatherName);
			log.info(
					"============= Finished tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm");

		}
	}

	@Test(priority = 42)
	public void tcCloseOpenAdmissionForm() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcCloseOpenAdmissionForm Test===========");

			bcehsForm.closeOpenAdmissionForm();
			log.info("============= Finished tcCloseOpenAdmissionForm Test===========");
			getScreenShot("tcCloseOpenAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenAdmissionForm");
		}
	}

	@Test(priority = 43, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm_Print(String FatherName,
			String runMode) {

		bcehsForm = new Admission_Form_BCEHS(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm_Print Test===========");

			bcehsForm.searchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm(FatherName);
			log.info(
					"============= Finished tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm_Print Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm_Print");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_View_BCEHS_AdmissionForm_Print");

		}
	}

	@Test(priority = 44)
	public void tcPrintOpenAdmissionForm() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcPrintOpenAdmissionForm Test===========");

			bcehsForm.printOpenAdmissionForm();
			log.info("============= Finished tcPrintOpenAdmissionForm Test===========");
			getScreenShot("tcPrintOpenAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcPrintOpenAdmissionForm");
		}
	}

	@Test(priority = 45)
	public void tcswitchToWindowUsingTab() {
		bcehsForm = new Admission_Form_BCEHS(driver);

		try {
			log.info("============= Strting tcswitchToWindowUsingTab Test===========");

			bcehsForm.switchToWindowUsingTab();
			log.info("============= Finished tcswitchToWindowUsingTab Test===========");
			getScreenShot("tcswitchToWindowUsingTab");
		} catch (Exception e) {
			getScreenShot("tcswitchToWindowUsingTab");
		}
	}

	@AfterClass
	public void tearDown() {
		try {
			ivrmportallogin.logOutFromApplication();
		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.quit();
	}

}
