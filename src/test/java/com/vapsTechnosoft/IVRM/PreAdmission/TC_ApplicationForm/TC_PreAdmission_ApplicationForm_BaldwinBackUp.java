/**
 * 
 */
package com.vapsTechnosoft.IVRM.PreAdmission.TC_ApplicationForm;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.preAdmission.ApplicationForm.PreAdmission_ApplicationForm;
import com.vapsTechnosoft.IVRM.preAdmission.ApplicationForm.PreAdmission_ApplicationForm_BaldwinBackUp;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_PreAdmission_ApplicationForm_BaldwinBackUp extends TestBase {

	public static final Logger log = Logger.getLogger(TC_PreAdmission_ApplicationForm_BaldwinBackUp.class.getName());

	PreAdmission_ApplicationForm_BaldwinBackUp applicationform_BaldWinBackUp;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ApplicationForm_ChildDetails")
	public String[][] getTestData() {
		String[][] testRecordsApplicationChild = getData("PreAdmissionApllication.xlsx",
				"ApplicationForm_ChildDetails");
		return testRecordsApplicationChild;
	}

	@DataProvider(name = "ApplicationForm_OthersDetails")
	public String[][] getTestSearchData() {
		String[][] testRecordsAdmForm = getData("PreAdmissionApllication.xlsx", "ApplicationForm_OtherDetails");
		return testRecordsAdmForm;
	}

	@DataProvider(name = "Residential_Address")
	public String[][] getTestAddressData() {
		String[][] testRecordsAddressForm = getData("PreAdmissionApllication.xlsx", "ResidentialAddress");
		return testRecordsAddressForm;
	}

	@DataProvider(name = "FatherDetailsPreAdmApplicationForm_Data")
	public String[][] getTestFatherData() {
		String[][] testRecordsFatherForm = getData("PreAdmissionApllication.xlsx", "FatherDetailsPreAdmApplForm");
		return testRecordsFatherForm;
	}

	@DataProvider(name = "MotherDetails_PreAdmApplication_Data")
	public String[][] getTestMotherData() {
		String[][] testRecordsMotherForm = getData("PreAdmissionApllication.xlsx", "MotherDetails_PreAdmApplication");
		return testRecordsMotherForm;
	}

	@DataProvider(name = "MonthlyIncome_Parent_PreApplication")
	public String[][] getTestBondData() {
		String[][] testRecordsBondForm = getData("PreAdmissionApllication.xlsx", "MonthlyIncome_Parent");
		return testRecordsBondForm;
	}

	@DataProvider(name = "SiblingDetails_PreAdmAppl_Data")
	public String[][] getTestSiblingData() {
		String[][] testRecordsSiblingForm = getData("PreAdmissionApllication.xlsx", "SiblingDetails_PreAdmAppl");
		return testRecordsSiblingForm;
	}

	@DataProvider(name = "GuardianDetails_PreAdmApplicationData")
	public String[][] getTestGuardianData() {
		String[][] testRecordsGuardianForm = getData("PreAdmissionApllication.xlsx", "GuardianDetails_PreAdmAppl");
		return testRecordsGuardianForm;
	}

	@DataProvider(name = "PreviousSchoolDetails_PreAdmApplication")
	public String[][] getTestPreviousSchoolData() {
		String[][] testRecordsPreviousSchoolForm = getData("PreAdmissionApllication.xlsx", "PreviousSchoolDetails");
		return testRecordsPreviousSchoolForm;
	}

	@DataProvider(name = "UnderTaking_Text_PreAdmApplication")
	public String[][] getTestUndertakingText() {
		String[][] testRecordsUndertakingText = getData("PreAdmissionApllication.xlsx", "UnderTaking_Text");
		return testRecordsUndertakingText;
	}

	@DataProvider(name = "SearchInGrid_PreAdmApplication")
	public String[][] getTestSearch() {
		String[][] testRecordsSearch = getData("PreAdmissionApllication.xlsx", "Search_StudentInGrid");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		applicationform_BaldWinBackUp = new PreAdmission_ApplicationForm_BaldwinBackUp(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting login to the Vaps IVRM application===========");
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

		try {
			log.info("============= Starting tcHomeButtonValidation Test===========");

			boolean status = applicationform_BaldWinBackUp.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToPreAdmission_ApplicationForm() {

		try {
			log.info("============= Starting tcNavigateToPreAdmission_ApplicationForm Test===========");

			applicationform_BaldWinBackUp.navigateToPreAdmission_ApplicationForm();

			log.info("============= Finished tcNavigateToPreAdmission_ApplicationForm Test===========");
			getScreenShot("tcNavigateToPreAdmission_ApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcNavigateToPreAdmission_ApplicationForm");
		}
	}

	@Test(priority = 4)
	public void tcVerifyPreAdmission_ApplicationForm_PagePath() {

		try {
			log.info("============= Starting tcVerifyPreAdmission_ApplicationForm_PagePath Test===========");

			boolean status = applicationform_BaldWinBackUp.verifyPreAdmission_ApplicationForm_PagePath();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyPreAdmission_ApplicationForm_PagePath Test===========");
			getScreenShot("tcVerifyPreAdmission_ApplicationForm_PagePath");
		} catch (Exception e) {
			getScreenShot("tcVerifyPreAdmission_ApplicationForm_PagePath");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSubmitButton_ToSubmitBlankForm() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_ToSubmitBlankForm Test===========");

			applicationform_BaldWinBackUp.clickOnSubmitButton_submitBlankForm();

			log.info("============= Finished tcClickOnSubmitButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSubmitButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 6)
	public void tcPopUpValidationOnSuccess_ToSubmitBlankForm() {

		try {
			log.info("============= Starting tcPopUpValidationOnSuccess_ToSubmitBlankForm Test===========");

			applicationform_BaldWinBackUp.popUpValidationOnSuccess();

			log.info("============= Finished tcPopUpValidationOnSuccess_ToSubmitBlankForm Test===========");
			getScreenShot("tcPopUpValidationOnSuccess_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess_ToSubmitBlankForm");
		}
	}

	@Test(priority = 7, dataProvider = "ApplicationForm_ChildDetails")
	public void tcEnterStudentInformationFor_ApplicationForm_ChildDetails(String fName, String mName, String sName,
			String mNumber, String birthPlace, String religion, String caste, String gender, String apply_class,
			String email, String academicYear, String nationality, String motherTongue, String syllabus,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Starting tcEnterStudentInformationFor_ApplicationForm_ChildDetails Test===========");

			applicationform_BaldWinBackUp.enterStudentInformationFor_ApplicationForm(fName, mName, sName, mNumber, birthPlace,
					religion, caste, gender, apply_class, email, academicYear, nationality, motherTongue, syllabus);

			log.info(
					"============= Finished tcEnterStudentInformationFor_ApplicationForm_ChildDetails Test===========");
			getScreenShot("tcEnterStudentInformationFor_ApplicationForm_ChildDetails");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentInformationFor_ApplicationForm_ChildDetails");
		}
	}

	@Test(priority = 8)
	public void tcUpload_StudentPhoto() {

		try {
			log.info("============= Starting tcUpload_StudentPhoto Test===========");

			applicationform_BaldWinBackUp.upload_StudentPhoto();

			log.info("============= Finished tcUpload_StudentPhoto Test===========");
			getScreenShot("tcUpload_StudentPhoto");
		} catch (Exception e) {
			getScreenShot("tcUpload_StudentPhoto");
		}
	}

	@Test(priority = 9, dataProvider = "ApplicationForm_OthersDetails")
	public void tcOthersDetails_ForPreadmApplicationForm(String secondLang, String thirdLang, String tribe,
			String playGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcOthersDetails_ForPreadmApplicationForm Test===========");

			applicationform_BaldWinBackUp.othersDetails_ForPreadmApplicationForm(secondLang, thirdLang, tribe, playGroup);

			log.info("============= Finished tcOthersDetails_ForPreadmApplicationForm Test===========");
			getScreenShot("tcOthersDetails_ForPreadmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcOthersDetails_ForPreadmApplicationForm");
		}
	}

	@Test(priority = 10, dataProvider = "Residential_Address")
	public void tcResidentialAndPermanentAddress_PreAdmApplicationForm(String street, String area, String Country,
			String state, String city, String pinZip, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcResidentialAndPermanentAddress_PreAdmApplicationForm Test===========");

			applicationform_BaldWinBackUp.residentialAndPermanentAddress_PreAdmApplicationForm(street, area, Country, state, city,
					pinZip);

			log.info("============= Finished tcResidentialAndPermanentAddress_PreAdmApplicationForm Test===========");
			getScreenShot("tcResidentialAndPermanentAddress_PreAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcResidentialAndPermanentAddress_PreAdmApplicationForm");
		}
	}

	@Test(priority = 11, dataProvider = "FatherDetailsPreAdmApplicationForm_Data")
	public void tcFathersDetails_PreAdmission_ApplicationForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherOccupation, String fatherReligion, String fatherCaste,
			String fatherTribe, String fatherNationanlity, String fatherEmail, String fatherPhOffice,
			String fatherPhoneRes, String fatherMobile, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcFathersDetails_PreAdmission_ApplicationForm Test===========");

			applicationform_BaldWinBackUp.fathersDetails_PreAdmission_ApplicationForm(fatherName, fatherSurName, fatherQualification,
					fatherOccupation, fatherReligion, fatherCaste, fatherTribe, fatherNationanlity, fatherEmail,
					fatherPhOffice, fatherPhoneRes, fatherMobile);

			log.info("============= Finished tcFathersDetails_PreAdmission_ApplicationForm Test===========");
			getScreenShot("tcFathersDetails_PreAdmission_ApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcFathersDetails_PreAdmission_ApplicationForm");
		}
	}

	@Test(priority = 12, dataProvider = "MotherDetails_PreAdmApplication_Data")
	public void tcMothersDetails_PreAdmission_ApplicationForm(String motherName, String motherSurName,
			String motherQualification, String motherOccupation, String motherReligion, String motherCaste,
			String motherTribe, String motherNationanlity, String motherEmail, String motherPhOffice,
			String motherPhoneRes, String motherMobile, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcMothersDetails_PreAdmission_ApplicationForm Test===========");

			applicationform_BaldWinBackUp.mothersDetails_PreAdmission_ApplicationForm(motherName, motherSurName, motherQualification,
					motherOccupation, motherReligion, motherCaste, motherTribe, motherNationanlity, motherEmail,
					motherPhOffice, motherPhoneRes, motherMobile);

			log.info("============= Finished tcMothersDetails_PreAdmission_ApplicationForm Test===========");
			getScreenShot("tcMothersDetails_PreAdmission_ApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcMothersDetails_PreAdmission_ApplicationForm");
		}
	}

	@Test(priority = 13, dataProvider = "MonthlyIncome_Parent_PreApplication")
	public void tcParentMonthlyIncomeDetails_PreAdmissionApplication(String fatherIncome, String motherIncome,
			String altContact, String altEmail, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcParentMonthlyIncomeDetails_PreAdmissionApplication Test===========");

			applicationform_BaldWinBackUp.parentMonthlyIncomeDetails_PreAdmissionApplication(fatherIncome, motherIncome, altContact,
					altEmail);
			log.info("============= Finished tcParentMonthlyIncomeDetails_PreAdmissionApplication Test===========");
			getScreenShot("tcParentMonthlyIncomeDetails_PreAdmissionApplication");
		} catch (Exception e) {
			getScreenShot("tcParentMonthlyIncomeDetails_PreAdmissionApplication");
		}
	}

	@Test(priority = 14, dataProvider = "SiblingDetails_PreAdmAppl_Data")
	public void tcSiblingDetails_PreAdmApplication(String siblingName, String siblingClass, String siblingAdmNo,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSiblingDetails_PreAdmApplication Test===========");

			applicationform_BaldWinBackUp.siblingDetails_PreAdmApplication(siblingName, siblingClass, siblingAdmNo);
			log.info("============= Finished tcSiblingDetails_PreAdmApplication Test===========");
			getScreenShot("tcSiblingDetails_PreAdmApplication");
		} catch (Exception e) {
			getScreenShot("tcSiblingDetails_PreAdmApplication");
		}
	}

	@Test(priority = 15, dataProvider = "GuardianDetails_PreAdmApplicationData")
	public void tcGurdianDetails_PreAdmApplicationForm(String guardianName, String gurdianRelWithStu,
			String gurdianAddress, String guardianPhOffice, String guardianPhResidance, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcGurdianDetails_PreAdmApplicationForm Test===========");

			applicationform_BaldWinBackUp.gurdianDetails_PreAdmApplicationForm(guardianName, gurdianRelWithStu, gurdianAddress,
					guardianPhOffice, guardianPhResidance);
			log.info("============= Finished tcGurdianDetails_PreAdmApplicationForm Test===========");
			getScreenShot("tcGurdianDetails_PreAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcGurdianDetails_PreAdmApplicationForm");
		}
	}

	@Test(priority = 16)
	public void tcUpload_FatherPhoto() {

		try {
			log.info("============= Starting tcUpload_FatherPhoto Test===========");

			applicationform_BaldWinBackUp.upload_FatherPhoto();

			log.info("============= Finished tcUpload_FatherPhoto Test===========");
			getScreenShot("tcUpload_FatherPhoto");
		} catch (Exception e) {
			getScreenShot("tcUpload_FatherPhoto");
		}
	}

	@Test(priority = 17)
	public void tcUpload_MotherPhoto() {

		try {
			log.info("============= Starting tcUpload_MotherPhoto Test===========");

			applicationform_BaldWinBackUp.upload_MotherPhoto();

			log.info("============= Finished tcUpload_MotherPhoto Test===========");
			getScreenShot("tcUpload_MotherPhoto");
		} catch (Exception e) {
			getScreenShot("tcUpload_MotherPhoto");
		}
	}

	@Test(priority = 18, dataProvider = "PreviousSchoolDetails_PreAdmApplication")
	public void tcPreviousSchoolDetails_PreAdmissionApplication(String prevSchoolName, String prevClass,
			String prevGrade, String prevPassedYr, String PrevAddress, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcPreviousSchoolDetails_PreAdmissionApplication Test===========");

			applicationform_BaldWinBackUp.previousSchoolDetails_PreAdmissionApplication(prevSchoolName, prevClass, prevGrade,
					prevPassedYr, PrevAddress);
			log.info("============= Finished tcPreviousSchoolDetails_PreAdmissionApplication Test===========");
			getScreenShot("tcPreviousSchoolDetails_PreAdmissionApplication");
		} catch (Exception e) {
			getScreenShot("tcPreviousSchoolDetails_PreAdmissionApplication");
		}
	}

	@Test(priority = 19)
	public void tcUploadAndViewUploadedDocument() {

		try {
			log.info("============= Starting tcUploadRequiredDocuments Test===========");

			applicationform_BaldWinBackUp.uploadAndViewUploadedDocument();

			log.info("============= Finished tcUploadRequiredDocuments Test===========");
			getScreenShot("tcUploadRequiredDocuments");
		} catch (Exception e) {
			getScreenShot("tcUploadRequiredDocuments");
		}
	}

	// @Test(priority = 19)
	// public void ploadRequiredDocuments() {
	//
	// try {
	// log.info("============= Starting tcUploadRequiredDocuments
	// Test===========");
	//
	// applicationform.uploadRequiredDocuments();
	//
	// log.info("============= Finished tcUploadRequiredDocuments
	// Test===========");
	// getScreenShot("tcUploadRequiredDocuments");
	// } catch (Exception e) {
	// getScreenShot("tcUploadRequiredDocuments");
	// }
	// }
	//
	// @Test(priority = 20)
	// public void tcValidationOfUploadedDOBCertificate() {
	//
	// try {
	// log.info("============= Starting tcValidationOfUploadedDOBCertificate
	// Test===========");
	//
	// applicationform.validationOfUploadedDOBCertificate();
	//
	// log.info("============= Finished tcValidationOfUploadedDOBCertificate
	// Test===========");
	// getScreenShot("tcValidationOfUploadedDOBCertificate");
	// } catch (Exception e) {
	// getScreenShot("tcValidationOfUploadedDOBCertificate");
	// }
	// }
	//
	// @Test(priority = 21)
	// public void tcClickOnPopupCloseButton() {
	//
	// try {
	// log.info("============= Starting tcClickOnPopupCloseButton
	// Test===========");
	//
	// applicationform.clickOnPopupCloseButton();
	//
	// log.info("============= Finished tcClickOnPopupCloseButton
	// Test===========");
	// getScreenShot("tcClickOnPopupCloseButton");
	// } catch (Exception e) {
	// getScreenShot("tcClickOnPopupCloseButton");
	// }
	// }

	@Test(priority = 22, dataProvider = "UnderTaking_Text_PreAdmApplication")
	public void tcVerifyUndertakingText_PreAdmissionApplication(String textToVerify, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcPreviousSchoolDetails_PreAdmissionApplication Test===========");

			applicationform_BaldWinBackUp.verifyUndertakingText(textToVerify);

			log.info("============= Finished tcPreviousSchoolDetails_PreAdmissionApplication Test===========");
			getScreenShot("tcPreviousSchoolDetails_PreAdmissionApplication");
		} catch (Exception e) {
			getScreenShot("tcPreviousSchoolDetails_PreAdmissionApplication");
		}
	}

	@Test(priority = 23)
	public void tcConfirmUndertakingYes() {

		try {
			log.info("============= Starting tcConfirmUndertakingYes Test===========");

			applicationform_BaldWinBackUp.confirmUndertakingYes();

			log.info("============= Finished tcConfirmUndertakingYes Test===========");
			getScreenShot("tcConfirmUndertakingYes");
		} catch (Exception e) {
			getScreenShot("tcConfirmUndertakingYes");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSubmitButton_ToSubmitFilledForm() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_ToSubmitFilledForm Test===========");

			applicationform_BaldWinBackUp.clickOnSubmitButton();

			log.info("============= Finished tcClickOnSubmitButton_ToSubmitFilledForm Test===========");
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm");
		}
	}

	@Test(priority = 25)
	public void tcPopUpValidationCancel_ToSubmitFilledForm() {

		try {
			log.info("============= Starting tcPopUpValidationCancel_ToSubmitFilledForm Test===========");

			applicationform_BaldWinBackUp.popUpValidationCancel();

			log.info("============= Finished tcPopUpValidationCancel_ToSubmitFilledForm Test===========");
			getScreenShot("tcPopUpValidationCancel_ToSubmitFilledForm");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationCancel_ToSubmitFilledForm");
		}
	}

	@Test(priority = 26)
	public void tcClickOnSubmitButton_ToSubmitFilledForm_AfterCancel() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_ToSubmitFilledForm_AfterCancel Test===========");

			applicationform_BaldWinBackUp.clickOnSubmitButton();

			log.info("============= Finished tcClickOnSubmitButton_ToSubmitFilledForm_AfterCance Test===========");
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcPopUpValidationYes_FinalSubmit() {

		try {
			log.info("============= Starting tcPopUpValidationYes_FinalSubmit Test===========");

			applicationform_BaldWinBackUp.popUpValidationYes();

			log.info("============= Finished tcPopUpValidationYes_FinalSubmit Test===========");
			getScreenShot("tcPopUpValidationYes_FinalSubmit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYes_FinalSubmit");
		}
	}

	@Test(priority = 28)
	public void tcPopUpValidationOnSuccess_FinalSubmit() {

		try {
			log.info("============= Starting tcPopUpValidationOnSuccess_FinalSubmit Test===========");

			applicationform_BaldWinBackUp.popUpValidationOnSuccess();

			log.info("============= Finished tcPopUpValidationOnSuccess_FinalSubmit Test===========");
			getScreenShot("tcPopUpValidationOnSuccess_FinalSubmit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess_FinalSubmit");
		}
	}

	@Test(priority = 29, dataProvider = "SearchInGrid_PreAdmApplication")
	public void tcSearchByStudentNameInGrid_PreAdmissionApplication(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSearchByStudentNameInGrid_PreAdmissionApplication Test===========");

			applicationform_BaldWinBackUp.searchByStudentNameInGrid(studentName);

			log.info("============= Finished tcSearchByStudentNameInGrid_PreAdmissionApplication Test===========");
			getScreenShot("tcSearchByStudentNameInGrid_PreAdmissionApplication");
		} catch (Exception e) {
			getScreenShot("tcSearchByStudentNameInGrid_PreAdmissionApplication");
		}
	}
	@Test(priority = 30, dataProvider = "SearchInGrid_PreAdmApplication")
	public void tcVerifyStudentNameInStudentListGrid_PreAdmissionApplication(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcVerifyStudentNameInStudentListGrid_PreAdmissionApplication Test===========");

			applicationform_BaldWinBackUp.verifyStudentNameInStudentListGrid(studentName);

			log.info("============= Finished tcVerifyStudentNameInStudentListGrid_PreAdmissionApplication Test===========");
			getScreenShot("tcVerifyStudentNameInStudentListGrid_PreAdmissionApplication");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentNameInStudentListGrid_PreAdmissionApplication");
		}
	}
	@Test(priority = 31, dataProvider = "SearchInGrid_PreAdmApplication")
	public void tcEdit_PreAdmissionApplicationForm(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEdit_PreAdmissionApplicationForm Test===========");

			applicationform_BaldWinBackUp.edit_PreAdmissionApplicationForm(studentName);

			log.info("============= Finished tcEdit_PreAdmissionApplicationForm Test===========");
			getScreenShot("tcEdit_PreAdmissionApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcEdit_PreAdmissionApplicationForm");
		}
	}

	@Test(priority = 32)
	public void tcClickOnSubmitButton_ToSubmitFilledForm_Edit() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_ToSubmitFilledForm_Edit Test===========");

			applicationform_BaldWinBackUp.clickOnSubmitButton();

			log.info("============= Finished tcClickOnSubmitButton_ToSubmitFilledForm_Edit Test===========");
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_ToSubmitFilledForm_Edit");
		}
	}

	@Test(priority = 33)
	public void tcPopUpValidationYes_FinalSubmit_Edit() {

		try {
			log.info("============= Starting tcPopUpValidationYes_FinalSubmit_Edit Test===========");

			applicationform_BaldWinBackUp.popUpValidationYes();

			log.info("============= Finished tcPopUpValidationYes_FinalSubmit_Edit Test===========");
			getScreenShot("tcPopUpValidationYes_FinalSubmit_Edit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYes_FinalSubmit_Edit");
		}
	}

	@Test(priority = 34)
	public void tcPopUpValidationOnSuccess_FinalSubmit_Edit() {

		try {
			log.info("============= Starting tcPopUpValidationOnSuccess_FinalSubmit_Edit Test===========");

			applicationform_BaldWinBackUp.popUpValidationOnSuccess();

			log.info("============= Finished tcPopUpValidationOnSuccess_FinalSubmit_Edit Test===========");
			getScreenShot("tcPopUpValidationOnSuccess_FinalSubmit_Edit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess_FinalSubmit_Edit");
		}
	}

	@Test(priority = 35, dataProvider = "SearchInGrid_PreAdmApplication")
	public void tcView_PreAdmissionApplicationForm(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcView_PreAdmissionApplicationForm Test===========");

			applicationform_BaldWinBackUp.view_PreAdmissionApplicationForm(studentName);

			log.info("============= Finished tcView_PreAdmissionApplicationForm Test===========");
			getScreenShot("tcView_PreAdmissionApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcView_PreAdmissionApplicationForm");
		}
	}

	@Test(priority = 36)
	public void tcClickOnPrint_ForPrintPreview() {

		try {
			log.info("============= Starting tcClickOnPrint_ForPrintPreview Test===========");

			applicationform_BaldWinBackUp.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview");
		}
	}

	@Test(priority = 37)
	public void tcCloseViewApplicationWindow() {

		try {
			log.info("============= Starting tcCloseViewApplicationWindow Test===========");

			applicationform_BaldWinBackUp.closeViewApplicationWindow();

			log.info("============= Finished tcCloseViewApplicationWindow Test===========");
			getScreenShot("tcCloseViewApplicationWindow");
		} catch (Exception e) {
			getScreenShot("tcCloseViewApplicationWindow");
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
