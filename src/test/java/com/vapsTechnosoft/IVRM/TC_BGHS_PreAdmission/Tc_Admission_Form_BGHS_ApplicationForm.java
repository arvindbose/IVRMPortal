/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_BGHS_PreAdmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.BGHS_PreAdmission.Admission_Form_BGHS_ApplicationForm;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Admission_Form_BGHS_ApplicationForm extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Admission_Form_BGHS_ApplicationForm.class.getName());

	Admission_Form_BGHS_ApplicationForm bghsApplicationForm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "BGHSPreAdmApplFormData")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BGHS_PreAdmissionData.xlsx", "BGHS_StudentDetailsData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "BGHS_OthersDetails")
	public String[][] getTestDataOthersDetails() {
		String[][] testRecordsOtherDetails = getData("BGHS_PreAdmissionData.xlsx", "BGHS_OthersDetails");
		return testRecordsOtherDetails;
	}

	@DataProvider(name = "BGHS_ResidentialAddress")
	public String[][] getTestDataResidentialAddress() {
		String[][] testRecordsAddress = getData("BGHS_PreAdmissionData.xlsx", "BGHS_Address");
		return testRecordsAddress;
	}

	@DataProvider(name = "BGHSFatherDetails")
	public String[][] getTestDataFathersDetails() {
		String[][] testRecordsFather = getData("BGHS_PreAdmissionData.xlsx", "BGHS_FathersInfo");
		return testRecordsFather;
	}

	@DataProvider(name = "BGHSMotherDetails")
	public String[][] getTestDataMothersDetails() {
		String[][] testRecordsmother = getData("BGHS_PreAdmissionData.xlsx", "BGHS_MothersInfo");
		return testRecordsmother;
	}

	@DataProvider(name = "BGHSParentPassingYear")
	public String[][] getTestDataPassingYrDetails() {
		String[][] testRecordsPassYr = getData("BGHS_PreAdmissionData.xlsx", "BGHS_ParentPassYr");
		return testRecordsPassYr;
	}

	
	@DataProvider(name = "BGHSMonthlyIncome")
	public String[][] getTestDataMonthlyIncome() {
		String[][] testRecordsmonthlyIncome = getData("BGHS_PreAdmissionData.xlsx", "BGHS_MonthlyIncomeAdmFormData");
		return testRecordsmonthlyIncome;
	}

	@DataProvider(name = "BGHSGuardianDetailsData")
	public String[][] getTestDataGuardian() {
		String[][] testRecordsGuardian = getData("BGHS_PreAdmissionData.xlsx", "BGHS_PreAdm_GuardianData");
		return testRecordsGuardian;
	}

	@DataProvider(name = "BGHSSiblingDetailsData")
	public String[][] getTestDataSibling() {
		String[][] testRecordsSibling = getData("BGHS_PreAdmissionData.xlsx", "BGHS_SiblingData");
		return testRecordsSibling;
	}

	@DataProvider(name = "BGHSPreviousSchoolDetailsData")
	public String[][] getTestDataPrevSchool() {
		String[][] testRecordsPrevSchool = getData("BGHS_PreAdmissionData.xlsx", "BGHS_PreviousSchoolData");
		return testRecordsPrevSchool;
	}

	@DataProvider(name = "BGHSUndertakingTextData")
	public String[][] getTestDataDocUpload() {
		String[][] testRecordsDocUpload = getData("BGHS_PreAdmissionData.xlsx", "BGHS_UnderTakingTextData");
		return testRecordsDocUpload;
	}

	@DataProvider(name = "SearchByFatherNameData")
	public String[][] getTestDatafathername() {
		String[][] testRecordsFatherName = getData("BGHS_PreAdmissionData.xlsx", "BGHS_FatherNameSearchData");
		return testRecordsFatherName;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
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
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = bghsApplicationForm.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_ApplicationForm_BGHS() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcNavigateToAdmission_ApplicationForm_BGHS Test===========");

			bghsApplicationForm.navigateToAdmission_ApplicationForm_BGHS();

			log.info("============= Finished tcNavigateToAdmission_ApplicationForm_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_ApplicationForm_BGHSPage() {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcVerifyAdmission_ApplicationForm_BGHSPage Test===========");

			boolean status = bghsApplicationForm.verifyAdmission_ApplicationForm_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmission_ApplicationForm_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_ApplicationForm_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_ApplicationForm_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "BGHSPreAdmApplFormData")
	public void tcEnterStudentInformationFor_BGHSPreAdmApplicationForm(String fName, String mName, String sName,
			String mNumber, String birthPlace, String religion, String caste, String gender, String email,
			String nationality, String languageAtHome, String churchName, String dateOfBirth, String selClass,
			String runMode) {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterStudentInformationFor_BGHSPreAdmApplicationForm Test===========");

			bghsApplicationForm.enterStudentInformationFor_BGHSPreAdmApplicationForm(fName, mName, sName, mNumber,
					birthPlace, religion, caste, gender, email, nationality, languageAtHome, churchName, dateOfBirth,
					selClass);
			log.info("============= Finished tcEnterStudentInformationFor_BGHSPreAdmApplicationForm Test===========");
			getScreenShot("tcEnterStudentInformationFor_BGHSPreAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentInformationFor_BGHSPreAdmApplicationForm");
		}
	}

	@Test(priority = 6, dataProvider = "BGHS_OthersDetails")
	public void tcOthersDetailsForBGhsAdmApplicationForm(String aadharCardNo, String playGroup, String ECAPrticipation,String runMode) {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOthersDetailsForBGhsAdmApplicationForm Test===========");

			bghsApplicationForm.othersDetailsForBGhsAdmApplicationForm(aadharCardNo, playGroup, ECAPrticipation);
			log.info("============= Finished tcOthersDetailsForBGhsAdmApplicationForm Test===========");
			getScreenShot("tcOthersDetailsForBGhsAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcOthersDetailsForBGhsAdmApplicationForm");
		}
	}

	@Test(priority = 7, dataProvider = "BGHS_ResidentialAddress")
	public void tcResidentialAndPermanentAddress(String street, String area, String Country, String state, String city,
			String pinZip, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcResidentialAndPermanentAddress Test===========");

			bghsApplicationForm.residentialAndPermanentAddress(street, area, Country, state, city, pinZip);
			log.info("============= Finished tcResidentialAndPermanentAddress Test===========");
			getScreenShot("tcResidentialAndPermanentAddress");
		} catch (Exception e) {
			getScreenShot("tcResidentialAndPermanentAddress");
		}
	}

	@Test(priority = 8, dataProvider = "BGHSFatherDetails")
	public void tcFathersDetails_BGHSPreAdmission_ApplicationForm(String fatherName, String fatherSurName,
			String fatherQualification, String fatherService, String fatherDesignation, String fatherNationanlity,
			String fatherOfficeAddr, String fatherPhOffice, String fatherPhoneRes, String fatherMobile, String runMode) {
		
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		
		try {
			log.info("============= Strting tcFathersDetails_BGHSPreAdmission_ApplicationForm Test===========");

			bghsApplicationForm.fathersDetails_BGHSPreAdmission_ApplicationForm(fatherName, fatherSurName, fatherQualification, fatherService, fatherDesignation, fatherNationanlity, fatherOfficeAddr, fatherPhOffice, fatherPhoneRes, fatherMobile);
			log.info("============= Finished tcFathersDetails_BGHSPreAdmission_ApplicationForm Test===========");
			getScreenShot("tcFathersDetails_BGHSPreAdmission_ApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcFathersDetails_BGHSPreAdmission_ApplicationForm");
		}
	}

	@Test(priority = 9, dataProvider = "BGHSMotherDetails")
	public void tcMothersDetails_BGHSPreAdmission_ApplicationForm(String motherName, String motherSurName,
			String motherQualification, String motherService, String motherDesignation, String motherNationanlity,
			String motherOfficeAddr, String motherPhOffice, String motherPhoneRes, String motherMobile, String runMode) {
		
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMothersDetails_BGHSPreAdmission_ApplicationForm Test===========");

			bghsApplicationForm.mothersDetails_BGHSPreAdmission_ApplicationForm(motherName, motherSurName, motherQualification, motherService, motherDesignation, motherNationanlity, motherOfficeAddr, motherPhOffice, motherPhoneRes, motherMobile);
			log.info("============= Finished tcMothersDetails_BGHSPreAdmission_ApplicationForm Test===========");
			getScreenShot("tcMothersDetails_BGHSPreAdmission_ApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcMothersDetails_BGHSPreAdmission_ApplicationForm");
		}
	}

	@Test(priority = 10, dataProvider = "BGHSMonthlyIncome")
	public void tcParentMonthlyIncomeDetailsBGHS(String fatherIncome, String motherIncome, String altContact,
			String altEmail, String runMode) {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcParentMonthlyIncomeDetailsBGHS Test===========");

			bghsApplicationForm.parentMonthlyIncomeDetailsBGHS(fatherIncome, motherIncome, altContact, altEmail);
			log.info("============= Finished tcParentMonthlyIncomeDetailsBGHS Test===========");
			getScreenShot("tcParentMonthlyIncomeDetailsBGHS");
		} catch (Exception e) {
			getScreenShot("tcParentMonthlyIncomeDetailsBGHS");
		}
	}

	@Test(priority = 11, dataProvider = "BGHSParentPassingYear")
	public void tcYearOfPassingOfFatherAndMother(String FatherYrOfPass, String MotherYrOfPass, String runMode) {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcYearOfPassingOfFatherAndMother Test===========");

			bghsApplicationForm.yearOfPassingOfFatherAndMother(FatherYrOfPass, MotherYrOfPass);
			log.info("============= Finished tcYearOfPassingOfFatherAndMother Test===========");
			getScreenShot("tcYearOfPassingOfFatherAndMother");
		} catch (Exception e) {
			getScreenShot("tcYearOfPassingOfFatherAndMother");
		}
	}
	
	@Test(priority = 12, dataProvider = "BGHSGuardianDetailsData")
	public void tcGurdianDetailsBGHSPreAdmApplicationForm(String guardianName, String
	  gurdianRelWithStu, String gurdianAddress, String guardianEmail,
	  String guardianPhone, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcGurdianDetailsBGHSPreAdmApplicationForm Test===========");

			bghsApplicationForm.gurdianDetailsBGHSPreAdmApplicationForm(guardianName, gurdianRelWithStu, gurdianAddress, guardianEmail, guardianPhone);
			log.info("============= Finished tcGurdianDetailsBGHSPreAdmApplicationForm Test===========");
			getScreenShot("tcGurdianDetailsBGHSPreAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcGurdianDetailsBGHSPreAdmApplicationForm");
		}
	}

	@Test(priority = 13, dataProvider = "BGHSSiblingDetailsData")
	public void tcSiblingDetailsBGHSPune(String siblingName, String siblingClass, String siblingAdmNo,
			String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSiblingDetailsBGHSPune Test===========");

			bghsApplicationForm.siblingDetailsBGHSPune(siblingName, siblingClass, siblingAdmNo);
			log.info("============= Finished tcSiblingDetailsBGHSPune Test===========");
			getScreenShot("tcSiblingDetailsBGHSPune");
		} catch (Exception e) {
			getScreenShot("tcSiblingDetailsBGHSPune");
		}
	}

	@Test(priority = 14, dataProvider = "BGHSPreviousSchoolDetailsData")
	public void tcPreviousSchoolDetailsBGHS(String prevSchoolName, String prevClass, String prevGrade,
			String prevPassedYr, String PrevAddress, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcPreviousSchoolDetailsBGHS Test===========");

			bghsApplicationForm.previousSchoolDetailsBGHS(prevSchoolName, prevClass, prevGrade, prevPassedYr, PrevAddress);
			log.info("============= Finished tcPreviousSchoolDetailsBGHS Test===========");
			getScreenShot("tcPreviousSchoolDetailsBGHS");
		} catch (Exception e) {
			getScreenShot("tcPreviousSchoolDetailsBGHS");
		}
	}
	 
	@Test(priority = 15)
	public void tcUploadRequiredDocuments() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcUploadRequiredDocuments Test===========");

			bghsApplicationForm.uploadRequiredDocuments();
			log.info("============= Finished tcUploadRequiredDocuments Test===========");
			getScreenShot("tcUploadRequiredDocuments");
		} catch (Exception e) {
			getScreenShot("tcUploadRequiredDocuments");
		}
	}

	@Test(priority = 16)
	public void tcValidationOfUploadedDOBCertificate() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcValidationOfUploadedDOBCertificate Test===========");

			bghsApplicationForm.validationOfUploadedDOBCertificate();
			log.info("============= Finished tcValidationOfUploadedDOBCertificate Test===========");
			getScreenShot("tcValidationOfUploadedDOBCertificate");
		} catch (Exception e) {
			getScreenShot("tcValidationOfUploadedDOBCertificate");
		}
	}

	@Test(priority = 17)
	public void tcClickOnPopupCloseButtonForDOBCert() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcClickOnPopupCloseButtonForDOBCert Test===========");

			bghsApplicationForm.clickOnPopupCloseButton();
			log.info("============= Finished tcClickOnPopupCloseButtonForDOBCert Test===========");
			getScreenShot("tcClickOnPopupCloseButtonForDOBCert");
		} catch (Exception e) {
			getScreenShot("tcClickOnPopupCloseButtonForDOBCert");
		}
	}

	
	@Test(priority = 18, dataProvider = "BGHSUndertakingTextData")
	public void tcVerifyUndertakingText(String textToVerify) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		try {
			log.info("============= Strting tcVerifyUndertakingText Test===========");

			bghsApplicationForm.verifyUndertakingText(textToVerify);
			log.info("============= Finished tcVerifyUndertakingText Test===========");
			getScreenShot("tcVerifyUndertakingText");
		} catch (Exception e) {
			getScreenShot("tcVerifyUndertakingText");

		}
	}

	@Test(priority = 19)
	public void tcConfirmUndertakingYes() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcConfirmUndertakingYes Test===========");

			bghsApplicationForm.confirmUndertakingYes();
			log.info("============= Finished tcConfirmUndertakingYes Test===========");
			getScreenShot("tcConfirmUndertakingYes");
		} catch (Exception e) {
			getScreenShot("tcConfirmUndertakingYes");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSubmitButton() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButton Test===========");

			bghsApplicationForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButton Test===========");
			getScreenShot("tcClickOnSubmitButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton");
		}
	}

	@Test(priority = 21)
	public void tcPopUpValidationCancel() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcPopUpValidationCancel Test===========");

			bghsApplicationForm.popUpValidationCancel();
			log.info("============= Finished tcPopUpValidationCancel Test===========");
			getScreenShot("tcClickOnSubmitButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton");
		}
	}

	@Test(priority = 22)
	public void tcClickOnSubmitButtonForFinalSubmit() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButtonForFinalSubmit Test===========");

			bghsApplicationForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButtonForFinalSubmit Test===========");
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit");
		}
	}

	@Test(priority = 23)
	public void tcPopUpValidationYes() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcPopUpValidationYes Test===========");

			bghsApplicationForm.popUpValidationYes();
			log.info("============= Finished tcPopUpValidationYes Test===========");
			getScreenShot("tcPopUpValidationYes");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYes");
		}
	}


	@Test(priority = 24)
	public void tcPopUpValidationOnSuccess() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcPopUpValidationOnSuccess Test===========");

			bghsApplicationForm.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccess Test===========");
			getScreenShot("tcPopUpValidationOnSuccess");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess");
		}
	}


	@Test(priority = 25, dataProvider = "SearchByFatherNameData")
	public void tcSearchByFatherNameInGrid(String FatherName, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByFatherNameInGrid Test===========");

			bghsApplicationForm.searchByFatherNameInGrid(FatherName);
			log.info("============= Finished tcSearchByFatherNameInGrid Test===========");
			getScreenShot("tcSearchByFatherNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByFatherNameInGrid");

		}
	}

	@Test(priority = 26, dataProvider = "SearchByFatherNameData")
	public void tcVerifyFatherNameInStudentListGrid(String FatherName, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyFatherNameInStudentListGrid Test===========");

			bghsApplicationForm.verifyFatherNameInStudentListGrid(FatherName);
			log.info("============= Finished tcVerifyFatherNameInStudentListGrid Test===========");
			getScreenShot("tcVerifyFatherNameInStudentListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyFatherNameInStudentListGrid");

		}
	}

	@Test(priority = 27, dataProvider = "SearchByFatherNameData")
	public void tcSearchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm(String FatherName, String runMode) {

		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm Test===========");

			bghsApplicationForm.searchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm(FatherName);
			log.info("============= Finished tcSearchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm Test===========");
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFatherNameInStudentListGrid_Edit_BGHSApplicationForm");

		}
	}

	@Test(priority = 28)
	public void tcClickOnSubmitButtonForFinalSubmit_AfterEdit() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcClickOnSubmitButtonForFinalSubmit_AfterEdit Test===========");

			bghsApplicationForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButtonForFinalSubmit_AfterEdit Test===========");
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit_AfterEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButtonForFinalSubmit_AfterEdit");
		}
	}

	@Test(priority = 29)
	public void tcPopUpValidationYesEdit() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcPopUpValidationYesEdit Test===========");

			bghsApplicationForm.popUpValidationYes();
			log.info("============= Finished tcPopUpValidationYesEdit Test===========");
			getScreenShot("tcPopUpValidationYesEdit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationYesEdit");
		}
	}

	@Test(priority = 30)
	public void tcPopUpValidationOnSuccessEdit() {
		bghsApplicationForm = new Admission_Form_BGHS_ApplicationForm(driver);

		try {
			log.info("============= Strting tcPopUpValidationOnSuccessEdit Test===========");

			bghsApplicationForm.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccessEdit Test===========");
			getScreenShot("tcPopUpValidationOnSuccessEdit");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccessEdit");
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
