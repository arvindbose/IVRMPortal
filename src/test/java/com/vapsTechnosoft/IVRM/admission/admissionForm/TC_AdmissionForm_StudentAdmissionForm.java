/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.admissionForm;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.AdmissionForm.AdmissionForm_StudentAdmissionForm;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_AdmissionForm_StudentAdmissionForm extends TestBase {

	public static final Logger log = Logger.getLogger(TC_AdmissionForm_StudentAdmissionForm.class.getName());

	AdmissionForm_StudentAdmissionForm studentadmissionform;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "AdmStudentAdmForm_Left")
	public String[][] getTestData() {
		String[][] testRecordsStuAdmDetails = getData("StudentAdmissionFormData.xlsx", "StudentAdmFormData_LeftPart");
		return testRecordsStuAdmDetails;
	}

	@DataProvider(name = "AdmStudentAdmForm_Right")
	public String[][] getTestSearchData() {
		String[][] testRecordsAdmForm = getData("StudentAdmissionFormData.xlsx", "StudentAdmFormData_RightPart");
		return testRecordsAdmForm;
	}

	@DataProvider(name = "StudentAdmForm_Address")
	public String[][] getTestAddressData() {
		String[][] testRecordsAddressForm = getData("StudentAdmissionFormData.xlsx", "StudentFormAddressData");
		return testRecordsAddressForm;
	}

	@DataProvider(name = "StudentAdmForm_Parents_Father")
	public String[][] getTestFatherData() {
		String[][] testRecordsFatherForm = getData("StudentAdmissionFormData.xlsx", "Parents_FatherDetailsData");
		return testRecordsFatherForm;
	}

	@DataProvider(name = "StudentAdmForm_Parents_Mother")
	public String[][] getTestMotherData() {
		String[][] testRecordsMotherForm = getData("StudentAdmissionFormData.xlsx", "Parents_MotherDetailsData");
		return testRecordsMotherForm;
	}

	@DataProvider(name = "StudentAdmForm_Others_Bond")
	public String[][] getTestBondData() {
		String[][] testRecordsBondForm = getData("StudentAdmissionFormData.xlsx", "StudentAdmForm_BondDetails");
		return testRecordsBondForm;
	}

	@DataProvider(name = "StudentAdmForm_Others_PreviousSchool")
	public String[][] getTestPreviousSchoolData() {
		String[][] testRecordsPreviousSchoolForm = getData("StudentAdmissionFormData.xlsx",
				"Others_PreviousSchoolData");
		return testRecordsPreviousSchoolForm;
	}

	@DataProvider(name = "StudentAdmForm_Others_Guardian")
	public String[][] getTestGuardianData() {
		String[][] testRecordsGuardianForm = getData("StudentAdmissionFormData.xlsx", "Others_GuardianDetailsData");
		return testRecordsGuardianForm;
	}

	@DataProvider(name = "StudentAdmForm_Others_Sibling")
	public String[][] getTestSiblingData() {
		String[][] testRecordsSiblingForm = getData("StudentAdmissionFormData.xlsx", "Others_SiblingDetailsData");
		return testRecordsSiblingForm;
	}

	@DataProvider(name = "StudentAdmForm_Others_Achievement")
	public String[][] getTestAchievementData() {
		String[][] testRecordsAchievementForm = getData("StudentAdmissionFormData.xlsx", "Others_AchievementData");
		return testRecordsAchievementForm;
	}

	@DataProvider(name = "StudentAdmForm_Document")
	public String[][] getTestDocumentData() {
		String[][] testRecordsDocumentForm = getData("StudentAdmissionFormData.xlsx", "DocumentsUpload_DocumentName");
		return testRecordsDocumentForm;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentadmissionform = new AdmissionForm_StudentAdmissionForm(driver);
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

			boolean status = studentadmissionform.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS() {

		try {
			log.info("============= Starting tcNavigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS Test===========");

			studentadmissionform.navigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS();

			log.info("============= Finished tcNavigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_AdmissionForm_StudentAdmissionForm_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_StudentAdmissionfrom_BGHSPage() {

		try {
			log.info("============= Starting tcVerifyAdmission_StudentAdmissionfrom_BGHSPage Test===========");

			boolean status = studentadmissionform.verifyAdmission_StudentAdmissionfrom_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmission_StudentAdmissionfrom_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_StudentAdmissionfrom_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_StudentAdmissionfrom_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankStudentAdmissionForm() {

		try {
			log.info("============= Starting tcSubmitBlankStudentAdmissionForm Test===========");

			studentadmissionform.submitBlankStudentAdmissionForm();

			log.info("============= Finished tcSubmitBlankStudentAdmissionForm Test===========");
			getScreenShot("tcSubmitBlankStudentAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankStudentAdmissionForm");
		}
	}

	@Test(priority = 6, dataProvider = "AdmStudentAdmForm_Left")
	public void tcEnterStudentDetailsForStudentAdmForm_LeftPart(String firstName, String middleName, String lastName,
			String academicYr, String admissionNum, String classForAdm, String dateOfAdm, String dateOfBirth,
			String casteCategory, String caste, String subCaste, String bankIfscCode, String birthPlace,
			String birthCertificate, String casteCertificate, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterStudentDetailsForStudentAdmForm_LeftPart Test===========");

			studentadmissionform.enterStudentDetailsForStudentAdmForm_LeftPart(firstName, middleName, lastName,
					academicYr, admissionNum, classForAdm, dateOfAdm, dateOfBirth, casteCategory, caste, subCaste,
					bankIfscCode, birthPlace, birthCertificate, casteCertificate);

			log.info("============= Finished tcEnterStudentDetailsForStudentAdmForm_LeftPart Test===========");
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_LeftPart");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_LeftPart");
		}
	}

	@Test(priority = 7, dataProvider = "AdmStudentAdmForm_Right")
	public void tcEnterStudentDetailsForStudentAdmForm_RightPart(String gender, String motherTongue, String religion,
			String Nationality, String mobileNumber, String emailId, String aadharNum, String bloodGr,
			String studentCat, String stuBankAcNo, String bplCardNo, String concessionType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterStudentDetailsForStudentAdmForm_RightPart Test===========");

			studentadmissionform.enterStudentDetailsForStudentAdmForm_RightPart(gender, motherTongue, religion,
					Nationality, mobileNumber, emailId, aadharNum, bloodGr, studentCat, stuBankAcNo, bplCardNo,
					concessionType);

			log.info("============= Finished tcEnterStudentDetailsForStudentAdmForm_RightPart Test===========");
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_RightPart");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_RightPart");
		}
	}

	@Test(priority = 8)
	public void tcUploadStudentPhotograph() {

		try {
			log.info("============= Starting tcUploadStudentPhotograph Test===========");

			studentadmissionform.uploadStudentPhotograph();

			log.info("============= Finished tcUploadStudentPhotograph Test===========");
			getScreenShot("tcUploadStudentPhotograph");
		} catch (Exception e) {
			getScreenShot("tcUploadStudentPhotograph");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeStudentAdmissionForm() {

		try {
			log.info("============= Starting tcMinimizeStudentAdmissionForm Test===========");

			studentadmissionform.minimizeStudentAdmissionForm();

			log.info("============= Finished tcMinimizeStudentAdmissionForm Test===========");
			getScreenShot("tcMinimizeStudentAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentAdmissionForm");
		}
	}

	@Test(priority = 10)
	public void tcSortByStudentFirstName() {

		try {
			log.info("============= Starting tcSortByStudentFirstName Test===========");
			getScreenShot("tcSortByStudentFirstName_BeforeSorting");
			studentadmissionform.sortByStudentFirstName();

			log.info("============= Finished tcSortByStudentFirstName Test===========");
			getScreenShot("tcSortByStudentFirstName");
		} catch (Exception e) {
			getScreenShot("tcSortByStudentFirstName");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeStudentDetails() {

		try {
			log.info("============= Starting tcMinimizeStudentDetails Test===========");

			studentadmissionform.minimizeStudentDetails();

			log.info("============= Finished tcMinimizeStudentDetails Test===========");
			getScreenShot("tcMinimizeStudentDetails");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentDetails");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeStudentDetails() {

		try {
			log.info("============= Starting tcMaximizeStudentDetails Test===========");

			studentadmissionform.maximizeStudentDetails();

			log.info("============= Finished tcMaximizeStudentDetails Test===========");
			getScreenShot("tcMaximizeStudentDetails");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentDetails");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeStudentAdmissionForm() {

		try {
			log.info("============= Starting tcMaximizeStudentAdmissionForm Test===========");

			studentadmissionform.maximizeStudentAdmissionForm();

			log.info("============= Finished tcMaximizeStudentAdmissionForm Test===========");
			getScreenShot("tcMaximizeStudentAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentAdmissionForm");
		}
	}

	@Test(priority = 14)
	public void tcClearAllFilledFieldInStudentAdmissionForm() {

		try {
			log.info("============= Starting tcClearAllFilledFieldInStudentAdmissionForm Test===========");

			studentadmissionform.clearAllFilledFieldInStudentAdmissionForm();

			log.info("============= Finished tcClearAllFilledFieldInStudentAdmissionForm Test===========");
			getScreenShot("tcClearAllFilledFieldInStudentAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcClearAllFilledFieldInStudentAdmissionForm");
		}
	}

	@Test(priority = 15, dataProvider = "AdmStudentAdmForm_Left")
	public void tcEnterStudentDetailsForStudentAdmForm_LeftPart_AfterClear(String firstName, String middleName,
			String lastName, String academicYr, String admissionNum, String classForAdm, String dateOfAdm,
			String dateOfBirth, String casteCategory, String caste, String subCaste, String bankIfscCode,
			String birthPlace, String birthCertificate, String casteCertificate, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Starting tcEnterStudentDetailsForStudentAdmForm_LeftPart_AfterClear Test===========");

			studentadmissionform.enterStudentDetailsForStudentAdmForm_LeftPart(firstName, middleName, lastName,
					academicYr, admissionNum, classForAdm, dateOfAdm, dateOfBirth, casteCategory, caste, subCaste,
					bankIfscCode, birthPlace, birthCertificate, casteCertificate);

			log.info(
					"============= Finished tcEnterStudentDetailsForStudentAdmForm_LeftPart_AfterClear Test===========");
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_LeftPart_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_LeftPart_AfterClear");
		}
	}

	@Test(priority = 16, dataProvider = "AdmStudentAdmForm_Right")
	public void tcEnterStudentDetailsForStudentAdmForm_RightPart_AfterClear(String gender, String motherTongue,
			String religion, String Nationality, String mobileNumber, String emailId, String aadharNum, String bloodGr,
			String studentCat, String stuBankAcNo, String bplCardNo, String concessionType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Starting tcEnterStudentDetailsForStudentAdmForm_RightPart_AfterClear Test===========");

			studentadmissionform.enterStudentDetailsForStudentAdmForm_RightPart(gender, motherTongue, religion,
					Nationality, mobileNumber, emailId, aadharNum, bloodGr, studentCat, stuBankAcNo, bplCardNo,
					concessionType);

			log.info(
					"============= Finished tcEnterStudentDetailsForStudentAdmForm_RightPart_AfterClear Test===========");
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_RightPart_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentDetailsForStudentAdmForm_RightPart_AfterClear");
		}
	}

	@Test(priority = 17)
	public void tcUploadStudentPhotograph_AfterClear() {

		try {
			log.info("============= Starting tcUploadStudentPhotograph Test===========");

			studentadmissionform.uploadStudentPhotograph();

			log.info("============= Finished tcUploadStudentPhotograph Test===========");
			getScreenShot("tcUploadStudentPhotograph");
		} catch (Exception e) {
			getScreenShot("tcUploadStudentPhotograph");
		}
	}

	@Test(priority = 18)
	public void tcClickOnNextToSwitchToAddressPage() {

		try {
			log.info("============= Starting tcClickOnNextToSwitchToAddressPage Test===========");

			studentadmissionform.clickOnNextToSwitchToAddressPage();
			;

			log.info("============= Finished tcClickOnNextToSwitchToAddressPage Test===========");
			getScreenShot("tcClickOnNextToSwitchToAddressPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchToAddressPage");
		}
	}

	@Test(priority = 19)
	public void tcSubmitBlankAddressForm() {

		try {
			log.info("============= Starting tcSubmitBlankAddressForm Test===========");

			studentadmissionform.submitBlankAddressForm();

			log.info("============= Finished tcSubmitBlankAddressForm Test===========");
			getScreenShot("tcSubmitBlankAddressForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankAddressForm");
		}
	}

	@Test(priority = 20, dataProvider = "StudentAdmForm_Address")
	public void tcEnterStudentAddressForAdmForm(String StuAddress, String area, String country, String state,
			String city, String pinCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterStudentAddressForAdmForm Test===========");

			studentadmissionform.enterStudentAddressForAdmForm(StuAddress, area, country, state, city, pinCode);

			log.info("============= Finished tcEnterStudentAddressForAdmForm Test===========");
			getScreenShot("tcEnterStudentAddressForAdmForm");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentAddressForAdmForm");
		}
	}

	@Test(priority = 21)
	public void tcClearFilledAddress() {

		try {
			log.info("============= Starting tcClearFilledAddress Test===========");

			studentadmissionform.clearFilledAddress();

			log.info("============= Finished tcClearFilledAddress Test===========");
			getScreenShot("tcClearFilledAddress");
		} catch (Exception e) {
			getScreenShot("tcClearFilledAddress");
		}
	}

	@Test(priority = 22)
	public void tcClickOnPreviousButtonToGoBackToStudentPage() {

		try {
			log.info("============= Starting tcClickOnPreviousButtonToGoBackToStudentPage Test===========");

			studentadmissionform.clickOnPreviousButtonToGoBackToStudentPage();

			log.info("============= Finished tcClickOnPreviousButtonToGoBackToStudentPage Test===========");
			getScreenShot("tcClickOnPreviousButtonToGoBackToStudentPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPreviousButtonToGoBackToStudentPage");
		}
	}

	@Test(priority = 23)
	public void tcClickOnNextToSwitchToAddressPage_AfterPreviousAddress() {

		try {
			log.info("============= Starting tcClickOnNextToSwitchToAddressPage_AfterPreviousAddress Test===========");

			studentadmissionform.clickOnNextToSwitchToAddressPage();
			;

			log.info("============= Finished tcClickOnNextToSwitchToAddressPage_AfterPreviousAddress Test===========");
			getScreenShot("tcClickOnNextToSwitchToAddressPage_AfterPreviousAddress");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchToAddressPage_AfterPreviousAddress");
		}
	}

	@Test(priority = 24, dataProvider = "StudentAdmForm_Address")
	public void tcEnterStudentAddressForAdmForm_AfterClear(String StuAddress, String area, String country, String state,
			String city, String pinCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterStudentAddressForAdmForm_AfterClear Test===========");

			studentadmissionform.enterStudentAddressForAdmForm(StuAddress, area, country, state, city, pinCode);

			log.info("============= Finished tcEnterStudentAddressForAdmForm_AfterClear Test===========");
			getScreenShot("tcEnterStudentAddressForAdmForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentAddressForAdmForm_AfterClear");
		}
	}

	@Test(priority = 25)
	public void tcClickOnNextToSwitchFromAddressToParentsPage() {

		try {
			log.info("============= Starting tcClickOnNextToSwitchFromAddressToParentsPage Test===========");

			studentadmissionform.clickOnNextToSwitchFromAddressToParentsPage();

			log.info("============= Finished tcClickOnNextToSwitchFromAddressToParentsPage Test===========");
			getScreenShot("tcClickOnNextToSwitchFromAddressToParentsPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromAddressToParentsPage");
		}
	}

	@Test(priority = 26)
	public void tcSelectFatherAliveCheckBox() {

		try {
			log.info("============= Starting tcSelectFatherAliveCheckBox Test===========");

			studentadmissionform.selectFatherAliveCheckBox();

			log.info("============= Finished tcSelectFatherAliveCheckBox Test===========");
			getScreenShot("tcSelectFatherAliveCheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelectFatherAliveCheckBox");
		}
	}

	@Test(priority = 27)
	public void tcSubmitBlankParentsForm() {

		try {
			log.info("============= Starting tcSubmitBlankParentsForm Test===========");

			studentadmissionform.submitBlankParentsForm();

			log.info("============= Finished tcSubmitBlankParentsForm Test===========");
			getScreenShot("tcSubmitBlankParentsForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankParentsForm");
		}
	}

	@Test(priority = 28, dataProvider = "StudentAdmForm_Parents_Father")
	public void tcEnterFatherDetailsInParentsPage(String fatherName, String fatherSurName, String f_AadharNo,
			String f_Qualification, String f_OfficeAddr, String f_Occupation, String f_Designation, String f_AccountNo,
			String f_IFSCCode, String f_CasteCertNo, String f_Nationality, String f_Religion, String f_Caste,
			String f_SubCaste, String f_MonthlyIncome, String f_AnnualIncome, String f_MobileNumber, String f_EmailId,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterFatherDetailsInParentsPage Test===========");

			studentadmissionform.enterFatherDetailsInParentsPage(fatherName, fatherSurName, f_AadharNo, f_Qualification,
					f_OfficeAddr, f_Occupation, f_Designation, f_AccountNo, f_IFSCCode, f_CasteCertNo, f_Nationality,
					f_Religion, f_Caste, f_SubCaste, f_MonthlyIncome, f_AnnualIncome, f_MobileNumber, f_EmailId);

			log.info("============= Finished tcEnterFatherDetailsInParentsPage Test===========");
			getScreenShot("tcEnterFatherDetailsInParentsPage");
		} catch (Exception e) {
			getScreenShot("tcEnterFatherDetailsInParentsPage");
		}
	}

	@Test(priority = 29)
	public void tcSelectMotherAliveCheckBox() {

		try {
			log.info("============= Starting tcSelectMotherAliveCheckBox Test===========");

			studentadmissionform.selectMotherAliveCheckBox();

			log.info("============= Finished tcSelectMotherAliveCheckBox Test===========");
			getScreenShot("tcSelectMotherAliveCheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelectMotherAliveCheckBox");
		}
	}

	@Test(priority = 30, dataProvider = "StudentAdmForm_Parents_Mother")
	public void tcEnterMotherDetailsInParentsPage(String motherName, String motherSurName, String m_AadharNo,
			String m_Qualification, String m_OfficeAddr, String m_Occupation, String m_Designation, String m_AccountNo,
			String m_IFSCCode, String m_CasteCertNo, String m_Nationality, String m_Religion, String m_Caste,
			String m_SubCaste, String m_MonthlyIncome, String m_AnnualIncome, String m_MobileNumber, String m_EmailId,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterMotherDetailsInParentsPage Test===========");

			studentadmissionform.enterMotherDetailsInParentsPage(motherName, motherSurName, m_AadharNo, m_Qualification,
					m_OfficeAddr, m_Occupation, m_Designation, m_AccountNo, m_IFSCCode, m_CasteCertNo, m_Nationality,
					m_Religion, m_Caste, m_SubCaste, m_MonthlyIncome, m_AnnualIncome, m_MobileNumber, m_EmailId);

			log.info("============= Finished tcEnterMotherDetailsInParentsPage Test===========");
			getScreenShot("tcEnterMotherDetailsInParentsPage");
		} catch (Exception e) {
			getScreenShot("tcEnterMotherDetailsInParentsPage");
		}
	}

	@Test(priority = 31)
	public void tcClearFilledParentsDetails() {

		try {
			log.info("============= Starting tcClearFilledParentsDetails Test===========");

			studentadmissionform.clearFilledParentsDetails();

			log.info("============= Finished tcClearFilledParentsDetails Test===========");
			getScreenShot("tcClearFilledParentsDetails");
		} catch (Exception e) {
			getScreenShot("tcClearFilledParentsDetails");
		}
	}

	@Test(priority = 32)
	public void tcClickOnPreviousButtonToGoBackToAddressPage() {

		try {
			log.info("============= Starting tcClickOnPreviousButtonToGoBackToAddressPage Test===========");

			studentadmissionform.clickOnPreviousButtonToGoBackToAddressPage();

			log.info("============= Finished tcClickOnPreviousButtonToGoBackToAddressPage Test===========");
			getScreenShot("tcClickOnPreviousButtonToGoBackToAddressPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPreviousButtonToGoBackToAddressPage");
		}
	}

	@Test(priority = 33)
	public void tcClickOnNextToSwitchFromAddressToParentsPage_AfterPreviousAddress() {

		try {
			log.info(
					"============= Starting tcClickOnNextToSwitchFromAddressToParentsPage_AfterPreviousAddress Test===========");

			studentadmissionform.clickOnNextToSwitchFromAddressToParentsPage();

			log.info(
					"============= Finished tcClickOnNextToSwitchFromAddressToParentsPage_AfterPreviousAddress Test===========");
			getScreenShot("tcClickOnNextToSwitchFromAddressToParentsPage_AfterPreviousAddress");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromAddressToParentsPage_AfterPreviousAddress");
		}
	}

	@Test(priority = 34)
	public void tcSelectFatherAliveCheckBox_AfterClear() {

		try {
			log.info("============= Starting tcSelectFatherAliveCheckBox_AfterClear Test===========");

			studentadmissionform.selectFatherAliveCheckBox();

			log.info("============= Finished tcSelectFatherAliveCheckBox_AfterClear Test===========");
			getScreenShot("tcSelectFatherAliveCheckBox_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectFatherAliveCheckBox_AfterClear");
		}
	}

	@Test(priority = 35)
	public void tcSubmitBlankParentsForm_AfterClear() {

		try {
			log.info("============= Starting tcSubmitBlankParentsForm_AfterClear Test===========");

			studentadmissionform.submitBlankParentsForm();

			log.info("============= Finished tcSubmitBlankParentsForm_AfterClear Test===========");
			getScreenShot("tcSubmitBlankParentsForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankParentsForm_AfterClear");
		}
	}

	@Test(priority = 36, dataProvider = "StudentAdmForm_Parents_Father")
	public void tcEnterFatherDetailsInParentsPage_AfterClear(String fatherName, String fatherSurName, String f_AadharNo,
			String f_Qualification, String f_OfficeAddr, String f_Occupation, String f_Designation, String f_AccountNo,
			String f_IFSCCode, String f_CasteCertNo, String f_Nationality, String f_Religion, String f_Caste,
			String f_SubCaste, String f_MonthlyIncome, String f_AnnualIncome, String f_MobileNumber, String f_EmailId,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterFatherDetailsInParentsPage_AfterClear Test===========");

			studentadmissionform.enterFatherDetailsInParentsPage(fatherName, fatherSurName, f_AadharNo, f_Qualification,
					f_OfficeAddr, f_Occupation, f_Designation, f_AccountNo, f_IFSCCode, f_CasteCertNo, f_Nationality,
					f_Religion, f_Caste, f_SubCaste, f_MonthlyIncome, f_AnnualIncome, f_MobileNumber, f_EmailId);

			log.info("============= Finished tcEnterFatherDetailsInParentsPage_AfterClear Test===========");
			getScreenShot("tcEnterFatherDetailsInParentsPage_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterFatherDetailsInParentsPage_AfterClear");
		}
	}

	@Test(priority = 37)
	public void tcSelectMotherAliveCheckBox_AfterClear() {

		try {
			log.info("============= Starting tcSelectMotherAliveCheckBox_AfterClear Test===========");

			studentadmissionform.selectMotherAliveCheckBox();

			log.info("============= Finished tcSelectMotherAliveCheckBox_AfterClear Test===========");
			getScreenShot("tcSelectMotherAliveCheckBox_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectMotherAliveCheckBox_AfterClear");
		}
	}

	@Test(priority = 38, dataProvider = "StudentAdmForm_Parents_Mother")
	public void tcEnterMotherDetailsInParentsPage_AfterClear(String motherName, String motherSurName, String m_AadharNo,
			String m_Qualification, String m_OfficeAddr, String m_Occupation, String m_Designation, String m_AccountNo,
			String m_IFSCCode, String m_CasteCertNo, String m_Nationality, String m_Religion, String m_Caste,
			String m_SubCaste, String m_MonthlyIncome, String m_AnnualIncome, String m_MobileNumber, String m_EmailId,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterMotherDetailsInParentsPage_AfterClear Test===========");

			studentadmissionform.enterMotherDetailsInParentsPage(motherName, motherSurName, m_AadharNo, m_Qualification,
					m_OfficeAddr, m_Occupation, m_Designation, m_AccountNo, m_IFSCCode, m_CasteCertNo, m_Nationality,
					m_Religion, m_Caste, m_SubCaste, m_MonthlyIncome, m_AnnualIncome, m_MobileNumber, m_EmailId);

			log.info("============= Finished tcEnterMotherDetailsInParentsPage_AfterClear Test===========");
			getScreenShot("tcEnterMotherDetailsInParentsPage_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMotherDetailsInParentsPage_AfterClear");
		}
	}

	@Test(priority = 39)
	public void tcClickOnNextToSwitchFromParentsToOthersPage() {

		try {
			log.info("============= Starting tcClickOnNextToSwitchFromParentsToOthersPage Test===========");

			studentadmissionform.clickOnNextToSwitchFromParentsToOthersPage();

			log.info("============= Finished tcClickOnNextToSwitchFromParentsToOthersPage Test===========");
			getScreenShot("tcClickOnNextToSwitchFromParentsToOthersPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromParentsToOthersPage");
		}
	}

	@Test(priority = 40)
	public void tcSelectActivities() {

		try {
			log.info("============= Starting tcSelectActivities Test===========");

			studentadmissionform.selectActivities();

			log.info("============= Finished tcSelectActivities Test===========");
			getScreenShot("tcSelectActivities");
		} catch (Exception e) {
			getScreenShot("tcSelectActivities");
		}
	}

	@Test(priority = 41)
	public void tcSelectReference() {

		try {
			log.info("============= Starting tcSelectReference Test===========");

			studentadmissionform.selectReference();

			log.info("============= Finished tcSelectReference Test===========");
			getScreenShot("tcSelectReference");
		} catch (Exception e) {
			getScreenShot("tcSelectReference");
		}
	}

	@Test(priority = 42)
	public void tcSelectSource() {

		try {
			log.info("============= Starting tcSelectSource Test===========");

			studentadmissionform.selectSource();

			log.info("============= Finished tcSelectSource Test===========");
			getScreenShot("tcSelectSource");
		} catch (Exception e) {
			getScreenShot("tcSelectSource");
		}
	}

	@Test(priority = 43, dataProvider = "StudentAdmForm_Others_Achievement")
	public void tcEnterAchievementsDetails(String achievements, String runMode) {

		try {
			log.info("============= Starting tcEnterAchievementsDetails Test===========");

			studentadmissionform.enterAchievementsDetails(achievements);

			log.info("============= Finished tcEnterAchievementsDetails Test===========");
			getScreenShot("tcEnterAchievementsDetails");
		} catch (Exception e) {
			getScreenShot("tcEnterAchievementsDetails");
		}
	}

	@Test(priority = 44, dataProvider = "StudentAdmForm_Others_Bond")
	public void tcSelectBondAndFillWithBondNumber(String bondName, String bondNumber, String runMode) {

		try {
			log.info("============= Starting tcSelectBondAndFillWithBondNumber Test===========");

			studentadmissionform.selectBondAndFillWithBondNumber(bondName, bondNumber);

			log.info("============= Finished tcSelectBondAndFillWithBondNumber Test===========");
			getScreenShot("tcSelectBondAndFillWithBondNumber");
		} catch (Exception e) {
			getScreenShot("tcSelectBondAndFillWithBondNumber");
		}
	}

	@Test(priority = 45, dataProvider = "StudentAdmForm_Others_PreviousSchool")
	public void tcEnterPreviousSchoolDetails(String schoolName, String schoolType, String preClass, String percentage,
			String grade, String passedYear, String totalMarks, String board, String country, String state,
			String address, String leftReason, String medium, String runMode) {

		try {
			log.info("============= Starting tcEnterPreviousSchoolDetails Test===========");

			studentadmissionform.enterPreviousSchoolDetails(schoolName, schoolType, preClass, percentage, grade,
					passedYear, totalMarks, board, country, state, address, leftReason, medium);

			log.info("============= Finished tcEnterPreviousSchoolDetails Test===========");
			getScreenShot("tcEnterPreviousSchoolDetails");
		} catch (Exception e) {
			getScreenShot("tcEnterPreviousSchoolDetails");
		}
	}

	@Test(priority = 46, dataProvider = "StudentAdmForm_Others_Guardian")
	public void tcEnterGuardianDetails(String guardianName, String guardianAddress, String guardianEmail,
			String guardianPhone, String runMode) {

		try {
			log.info("============= Starting tcEnterGuardianDetails Test===========");

			studentadmissionform.enterGuardianDetails(guardianName, guardianAddress, guardianEmail, guardianPhone);
			;

			log.info("============= Finished tcEnterGuardianDetails Test===========");
			getScreenShot("tcEnterGuardianDetails");
		} catch (Exception e) {
			getScreenShot("tcEnterGuardianDetails");
		}
	}

	@Test(priority = 47)
	public void tcUploadGuardianPhoto() {

		try {
			log.info("============= Starting tcUploadGuardianPhoto Test===========");

			studentadmissionform.uploadGuardianPhoto();

			log.info("============= Finished tcUploadGuardianPhoto Test===========");
			getScreenShot("tcUploadGuardianPhoto");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianPhoto");
		}
	}

	@Test(priority = 48)
	public void tcUploadGuardianSignature() {

		try {
			log.info("============= Starting tcUploadGuardianSignature Test===========");

			studentadmissionform.uploadGuardianSignature();

			log.info("============= Finished tcUploadGuardianSignature Test===========");
			getScreenShot("tcUploadGuardianSignature");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianSignature");
		}
	}

	@Test(priority = 49)
	public void tcUploadGuardianFingerPrint() {

		try {
			log.info("============= Starting tcUploadGuardianFingerPrint Test===========");

			studentadmissionform.uploadGuardianFingerPrint();

			log.info("============= Finished tcUploadGuardianFingerPrint Test===========");
			getScreenShot("tcUploadGuardianFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianFingerPrint");
		}
	}

	@Test(priority = 50)
	public void tcViewUploadedGuardianPhoto() {

		try {
			log.info("============= Starting tcViewUploadedGuardianPhoto Test===========");

			studentadmissionform.viewUploadedGuardianPhoto();

			log.info("============= Finished tcViewUploadedGuardianPhoto Test===========");
			getScreenShot("tcViewUploadedGuardianPhoto");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianPhoto");
		}
	}

	@Test(priority = 51)
	public void tcCloseOpenedUploadedImagePopUp_GuardianPhoto() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_GuardianPhoto Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_GuardianPhoto Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianPhoto");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianPhoto");
		}
	}

	@Test(priority = 52)
	public void tcViewUploadedGuardianSign() {

		try {
			log.info("============= Starting tcViewUploadedGuardianSign Test===========");

			studentadmissionform.viewUploadedGuardianSign();

			log.info("============= Finished tcViewUploadedGuardianSign Test===========");
			getScreenShot("tcViewUploadedGuardianSign");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianSign");
		}
	}

	@Test(priority = 53)
	public void tcCloseOpenedUploadedImagePopUp_GuardianSign() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_GuardianSign Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_GuardianSign Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianSign");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianSign");
		}
	}

	@Test(priority = 54)
	public void tcViewUploadedGuardianFingerPrint() {

		try {
			log.info("============= Starting tcViewUploadedGuardianFingerPrint Test===========");

			studentadmissionform.viewUploadedGuardianFingerPrint();

			log.info("============= Finished tcViewUploadedGuardianFingerPrint Test===========");
			getScreenShot("tcViewUploadedGuardianFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianFingerPrint");
		}
	}

	@Test(priority = 55)
	public void tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint");
		}
	}

	@Test(priority = 56, dataProvider = "StudentAdmForm_Others_Sibling")
	public void tcEnterSiblingDetails(String siblingName, String siblingClass, String siblingRelation, String runMode) {

		try {
			log.info("============= Starting tcEnterSiblingDetails Test===========");

			studentadmissionform.enterSiblingDetails(siblingName, siblingClass, siblingRelation);

			log.info("============= Finished tcEnterSiblingDetails Test===========");
			getScreenShot("tcEnterSiblingDetails");
		} catch (Exception e) {
			getScreenShot("tcEnterSiblingDetails");
		}
	}

	@Test(priority = 57)
	public void tcClearFilledOthersDetails() {

		try {
			log.info("============= Starting tcClearFilledOthersDetails Test===========");

			studentadmissionform.clearFilledOthersDetails();

			log.info("============= Finished tcClearFilledOthersDetails Test===========");
			getScreenShot("tcClearFilledOthersDetails");
		} catch (Exception e) {
			getScreenShot("tcClearFilledOthersDetails");
		}
	}

	@Test(priority = 58)
	public void tcClickOnPreviousButtonToGoBackToParentsPage() {

		try {
			log.info("============= Starting tcClickOnPreviousButtonToGoBackToParentsPage Test===========");

			studentadmissionform.clickOnPreviousButtonToGoBackToParentsPage();

			log.info("============= Finished tcClickOnPreviousButtonToGoBackToParentsPage Test===========");
			getScreenShot("tcClickOnPreviousButtonToGoBackToParentsPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPreviousButtonToGoBackToParentsPage");
		}
	}

	@Test(priority = 59)
	public void tcClickOnNextToSwitchFromParentsToOthersPage_AfterClearOthers() {

		try {
			log.info(
					"============= Starting tcClickOnNextToSwitchFromParentsToOthersPage_AfterClearOthers Test===========");

			studentadmissionform.clickOnNextToSwitchFromParentsToOthersPage();

			log.info(
					"============= Finished tcClickOnNextToSwitchFromParentsToOthersPage_AfterClearOthers Test===========");
			getScreenShot("tcClickOnNextToSwitchFromParentsToOthersPage_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromParentsToOthersPage_AfterClearOthers");
		}
	}

	@Test(priority = 60)
	public void tcSelectActivities_AfterClearOthers() {

		try {
			log.info("============= Starting tcSelectActivities_AfterClearOthers Test===========");

			studentadmissionform.selectActivities();

			log.info("============= Finished tcSelectActivities_AfterClearOthers Test===========");
			getScreenShot("tcSelectActivities_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcSelectActivities_AfterClearOthers");
		}
	}

	@Test(priority = 61)
	public void tcSelectReference_AfterClearOthers() {

		try {
			log.info("============= Starting tcSelectReference_AfterClearOthers Test===========");

			studentadmissionform.selectReference();

			log.info("============= Finished tcSelectReference_AfterClearOthers Test===========");
			getScreenShot("tcSelectReference_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcSelectReference_AfterClearOthers");
		}
	}

	@Test(priority = 62)
	public void tcSelectSource_AfterClearOthers() {

		try {
			log.info("============= Starting tcSelectSource_AfterClearOthers Test===========");

			studentadmissionform.selectSource();

			log.info("============= Finished tcSelectSource_AfterClearOthers Test===========");
			getScreenShot("tcSelectSource_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcSelectSource_AfterClearOthers");
		}
	}

	@Test(priority = 63, dataProvider = "StudentAdmForm_Others_Achievement")
	public void tcEnterAchievementsDetails_AfterClearOthers(String achievements, String runMode) {

		try {
			log.info("============= Starting tcEnterAchievementsDetails_AfterClearOthers Test===========");

			studentadmissionform.enterAchievementsDetails(achievements);

			log.info("============= Finished tcEnterAchievementsDetails_AfterClearOthers Test===========");
			getScreenShot("tcEnterAchievementsDetails_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcEnterAchievementsDetails_AfterClearOthers");
		}
	}

	@Test(priority = 64, dataProvider = "StudentAdmForm_Others_Bond")
	public void tcSelectBondAndFillWithBondNumber_AfterClearOthers(String bondName, String bondNumber, String runMode) {

		try {
			log.info("============= Starting tcSelectBondAndFillWithBondNumber_AfterClearOthers Test===========");

			studentadmissionform.selectBondAndFillWithBondNumber(bondName, bondNumber);

			log.info("============= Finished tcSelectBondAndFillWithBondNumber_AfterClearOthers Test===========");
			getScreenShot("tcSelectBondAndFillWithBondNumber_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcSelectBondAndFillWithBondNumber_AfterClearOthers");
		}
	}

	@Test(priority = 65, dataProvider = "StudentAdmForm_Others_PreviousSchool")
	public void tcEnterPreviousSchoolDetails_AfterClearOthers(String schoolName, String schoolType, String preClass,
			String percentage, String grade, String passedYear, String totalMarks, String board, String country,
			String state, String address, String leftReason, String medium, String runMode) {

		try {
			log.info("============= Starting tcEnterPreviousSchoolDetails_AfterClearOthers Test===========");

			studentadmissionform.enterPreviousSchoolDetails(schoolName, schoolType, preClass, percentage, grade,
					passedYear, totalMarks, board, country, state, address, leftReason, medium);

			log.info("============= Finished tcEnterPreviousSchoolDetails_AfterClearOthers Test===========");
			getScreenShot("tcEnterPreviousSchoolDetails_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcEnterPreviousSchoolDetails_AfterClearOthers");
		}
	}

	@Test(priority = 66, dataProvider = "StudentAdmForm_Others_Guardian")
	public void tcEnterGuardianDetails_AfterClearOthers(String guardianName, String guardianAddress,
			String guardianEmail, String guardianPhone, String runMode) {

		try {
			log.info("============= Starting tcEnterGuardianDetails_AfterClearOthers Test===========");

			studentadmissionform.enterGuardianDetails(guardianName, guardianAddress, guardianEmail, guardianPhone);
			;

			log.info("============= Finished tcEnterGuardianDetails_AfterClearOthers Test===========");
			getScreenShot("tcEnterGuardianDetails_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcEnterGuardianDetails_AfterClearOthers");
		}
	}

	@Test(priority = 67)
	public void tcUploadGuardianPhoto_AfterClearOthers() {

		try {
			log.info("============= Starting tcUploadGuardianPhoto_AfterClearOthers Test===========");

			studentadmissionform.uploadGuardianPhoto();

			log.info("============= Finished tcUploadGuardianPhoto_AfterClearOthers Test===========");
			getScreenShot("tcUploadGuardianPhoto_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianPhoto_AfterClearOthers");
		}
	}

	@Test(priority = 68)
	public void tcUploadGuardianSignature_AfterClearOthers() {

		try {
			log.info("============= Starting tcUploadGuardianSignature_AfterClearOthers Test===========");

			studentadmissionform.uploadGuardianSignature();

			log.info("============= Finished tcUploadGuardianSignature_AfterClearOthers Test===========");
			getScreenShot("tcUploadGuardianSignature_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianSignature_AfterClearOthers");
		}
	}

	@Test(priority = 69)
	public void tcUploadGuardianFingerPrint_AfterClearOthers() {

		try {
			log.info("============= Starting tcUploadGuardianFingerPrint_AfterClearOthers Test===========");

			studentadmissionform.uploadGuardianFingerPrint();

			log.info("============= Finished tcUploadGuardianFingerPrint_AfterClearOthers Test===========");
			getScreenShot("tcUploadGuardianFingerPrint_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcUploadGuardianFingerPrint_AfterClearOthers");
		}
	}

	@Test(priority = 70)
	public void tcViewUploadedGuardianPhoto_AfterClearOthers() {

		try {
			log.info("============= Starting tcViewUploadedGuardianPhoto_AfterClearOthers Test===========");

			studentadmissionform.viewUploadedGuardianPhoto();

			log.info("============= Finished tcViewUploadedGuardianPhoto_AfterClearOthers Test===========");
			getScreenShot("tcViewUploadedGuardianPhoto_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianPhoto_AfterClearOthers");
		}
	}

	@Test(priority = 71)
	public void tcCloseOpenedUploadedImagePopUp_GuardianPhoto_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_GuardianPhoto_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_GuardianPhoto_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianPhoto_AfterClear");
		}
	}

	@Test(priority = 72)
	public void tcViewUploadedGuardianSign_AfterClearOthers() {

		try {
			log.info("============= Starting tcViewUploadedGuardianSign_AfterClearOthers Test===========");

			studentadmissionform.viewUploadedGuardianSign();

			log.info("============= Finished tcViewUploadedGuardianSign_AfterClearOthers Test===========");
			getScreenShot("tcViewUploadedGuardianSign_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianSign_AfterClearOthers");
		}
	}

	@Test(priority = 73)
	public void tcCloseOpenedUploadedImagePopUp_GuardianSign_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_GuardianSign_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_GuardianSign_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianSign_AfterClear");
		}
	}

	@Test(priority = 74)
	public void tcViewUploadedGuardianFingerPrint_AfterClearOthers() {

		try {
			log.info("============= Starting tcViewUploadedGuardianFingerPrint_AfterClearOthers Test===========");

			studentadmissionform.viewUploadedGuardianFingerPrint();

			log.info("============= Finished tcViewUploadedGuardianFingerPrint_AfterClearOthers Test===========");
			getScreenShot("tcViewUploadedGuardianFingerPrint_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedGuardianFingerPrint_AfterClearOthers");
		}
	}

	@Test(priority = 75)
	public void tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint_AfterClear() {

		try {
			log.info(
					"============= Starting tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info(
					"============= Finished tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_GuardianFingerPrint_AfterClear");
		}
	}

	@Test(priority = 76, dataProvider = "StudentAdmForm_Others_Sibling")
	public void tcEnterSiblingDetails_AfterClearOthers(String siblingName, String siblingClass, String siblingRelation,
			String runMode) {

		try {
			log.info("============= Starting tcEnterSiblingDetails_AfterClearOthers Test===========");

			studentadmissionform.enterSiblingDetails(siblingName, siblingClass, siblingRelation);

			log.info("============= Finished tcEnterSiblingDetails_AfterClearOthers Test===========");
			getScreenShot("tcEnterSiblingDetails_AfterClearOthers");
		} catch (Exception e) {
			getScreenShot("tcEnterSiblingDetails_AfterClearOthers");
		}
	}

	@Test(priority = 77)
	public void tcClickOnNextToSwitchFromOthersToDocumentsPage() {

		try {
			log.info("============= Starting tcClickOnNextToSwitchFromOthersToDocumentsPage Test===========");

			studentadmissionform.clickOnNextToSwitchFromOthersToDocumentsPage();

			log.info("============= Finished tcClickOnNextToSwitchFromOthersToDocumentsPage Test===========");
			getScreenShot("tcClickOnNextToSwitchFromOthersToDocumentsPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromOthersToDocumentsPage");
		}
	}

	@Test(priority = 78)
	public void tcClickOnSubmitButton_Documents_Blank() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_Documents_Blank Test===========");

			studentadmissionform.clickOnSubmitButton_Documents();

			log.info("============= Finished tcClickOnSubmitButton_Documents_Blank Test===========");
			getScreenShot("tcClickOnSubmitButton_Documents_Blank");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_Documents_Blank");
		}
	}

	@Test(priority = 79, dataProvider = "StudentAdmForm_Document")
	public void tcUploadDocumentCorrepondingToDocumentName(String documentName, String runMode) {

		try {
			log.info("============= Starting tcUploadDocumentCorrepondingToDocumentName Test===========");

			studentadmissionform.uploadDocumentCorrepondingToDocumentName(documentName);

			log.info("============= Finished tcUploadDocumentCorrepondingToDocumentName Test===========");
			getScreenShot("tcUploadDocumentCorrepondingToDocumentName");
		} catch (Exception e) {
			getScreenShot("tcUploadDocumentCorrepondingToDocumentName");
		}
	}

	@Test(priority = 80)
	public void tcCloseOpenedUploadedImagePopUp_DocumentUpload() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_DocumentUpload Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_DocumentUpload Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_DocumentUpload");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_DocumentUpload");
		}
	}

	@Test(priority = 81)
	public void tcRequiredDetailsInDocumentsPage() {

		try {
			log.info("============= Starting tcRequiredDetailsInDocumentsPage Test===========");

			studentadmissionform.requiredDetailsInDocumentsPage();

			log.info("============= Finished tcRequiredDetailsInDocumentsPage Test===========");
			getScreenShot("tcRequiredDetailsInDocumentsPage");
		} catch (Exception e) {
			getScreenShot("tcRequiredDetailsInDocumentsPage");
		}
	}

	@Test(priority = 82)
	public void tcUploadFatherPhoto() {

		try {
			log.info("============= Starting tcUploadFatherPhoto Test===========");

			studentadmissionform.uploadFatherPhoto();

			log.info("============= Finished tcUploadFatherPhoto Test===========");
			getScreenShot("tcUploadFatherPhoto");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherPhoto");
		}
	}

	@Test(priority = 83)
	public void tcUploadFatherSign() {

		try {
			log.info("============= Starting tcUploadFatherSign Test===========");

			studentadmissionform.uploadFatherSign();

			log.info("============= Finished tcUploadFatherSign Test===========");
			getScreenShot("tcUploadFatherSign");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherSign");
		}
	}

	@Test(priority = 84)
	public void tcUploadFatherFingerPrint() {

		try {
			log.info("============= Starting tcUploadFatherFingerPrint Test===========");

			studentadmissionform.uploadFatherFingerPrint();

			log.info("============= Finished tcUploadFatherFingerPrint Test===========");
			getScreenShot("tcUploadFatherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherFingerPrint");
		}
	}

	@Test(priority = 85)
	public void tcViewUploadedFatherPhoto() {

		try {
			log.info("============= Starting tcViewUploadedFatherPhoto Test===========");

			studentadmissionform.viewUploadedFatherPhoto();

			log.info("============= Finished tcViewUploadedFatherPhoto Test===========");
			getScreenShot("tcViewUploadedFatherPhoto");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherPhoto");
		}
	}

	@Test(priority = 86)
	public void tcCloseOpenedUploadedImagePopUp_FatherPhoto() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_FatherPhoto Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_FatherPhoto Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherPhoto");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherPhoto");
		}
	}

	@Test(priority = 87)
	public void tcViewUploadedFatherSign() {

		try {
			log.info("============= Starting tcViewUploadedFatherSign Test===========");

			studentadmissionform.viewUploadedFatherSign();

			log.info("============= Finished tcViewUploadedFatherSign Test===========");
			getScreenShot("tcViewUploadedFatherSign");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherSign");
		}
	}

	@Test(priority = 88)
	public void tcCloseOpenedUploadedImagePopUp_FatherSign() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_FatherSign Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_FatherSign Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherSign");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherSign");
		}
	}

	@Test(priority = 89)
	public void tcViewUploadedFatherFingerPrint() {

		try {
			log.info("============= Starting tcViewUploadedFatherFingerPrint Test===========");

			studentadmissionform.viewUploadedFatherFingerPrint();

			log.info("============= Finished tcViewUploadedFatherFingerPrint Test===========");
			getScreenShot("tcViewUploadedFatherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherFingerPrint");
		}
	}

	@Test(priority = 90)
	public void tcCloseOpenedUploadedImagePopUp_FatherFingerPrint() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_FatherFingerPrint Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_FatherFingerPrint Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherFingerPrint");
		}
	}

	@Test(priority = 91)
	public void tcUploadMotherPhoto() {

		try {
			log.info("============= Starting tcUploadMotherPhoto Test===========");

			studentadmissionform.uploadMotherPhoto();

			log.info("============= Finished tcUploadMotherPhoto Test===========");
			getScreenShot("tcUploadMotherPhoto");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherPhoto");
		}
	}

	@Test(priority = 92)
	public void tcUploadMotherSign() {

		try {
			log.info("============= Starting tcUploadMotherSign Test===========");

			studentadmissionform.uploadMotherSign();

			log.info("============= Finished tcUploadMotherSign Test===========");
			getScreenShot("tcUploadMotherSign");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherSign");
		}
	}

	@Test(priority = 93)
	public void tcUploadMotherFingerPrint() {

		try {
			log.info("============= Starting tcUploadMotherFingerPrint Test===========");

			studentadmissionform.uploadMotherFingerPrint();

			log.info("============= Finished tcUploadMotherFingerPrint Test===========");
			getScreenShot("tcUploadMotherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherFingerPrint");
		}
	}

	@Test(priority = 94)
	public void tcViewUploadedMotherPhoto() {

		try {
			log.info("============= Starting tcViewUploadedMotherPhoto Test===========");

			studentadmissionform.viewUploadedMotherPhoto();

			log.info("============= Finished tcViewUploadedMotherPhoto Test===========");
			getScreenShot("tcViewUploadedMotherPhoto");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherPhoto");
		}
	}

	@Test(priority = 95)
	public void tcCloseOpenedUploadedImagePopUp_MotherPhoto() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_MotherPhoto Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_MotherPhoto Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherPhoto");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherPhoto");
		}
	}

	@Test(priority = 96)
	public void tcViewUploadedMotherSign() {

		try {
			log.info("============= Starting tcViewUploadedMotherSign Test===========");

			studentadmissionform.viewUploadedMotherSign();

			log.info("============= Finished tcViewUploadedMotherSign Test===========");
			getScreenShot("tcViewUploadedMotherSign");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherSign");
		}
	}

	@Test(priority = 97)
	public void tcCloseOpenedUploadedImagePopUp_MotherSign() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_MotherSign Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_MotherSign Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherSign");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherSign");
		}
	}

	@Test(priority = 98)
	public void tcViewUploadedMotherFingerPrint() {

		try {
			log.info("============= Starting tcViewUploadedMotherFingerPrint Test===========");

			studentadmissionform.viewUploadedMotherFingerPrint();

			log.info("============= Finished tcViewUploadedMotherFingerPrint Test===========");
			getScreenShot("tcViewUploadedMotherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherFingerPrint");
		}
	}

	@Test(priority = 99)
	public void tcCloseOpenedUploadedImagePopUp_MotherFingerPrint() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_MotherFingerPrint Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_MotherFingerPrint Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherFingerPrint");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherFingerPrint");
		}
	}

	@Test(priority = 100)
	public void tcClearFilledDocumentsDetails() {

		try {
			log.info("============= Starting tcClearFilledDocumentsDetails Test===========");

			studentadmissionform.clearFilledDocumentsDetails();

			log.info("============= Finished tcClearFilledDocumentsDetails Test===========");
			getScreenShot("tcClearFilledDocumentsDetails");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDocumentsDetails");
		}
	}

	@Test(priority = 101)
	public void tcClickOnPreviousButtonToGoBackToOthersPage() {

		try {
			log.info("============= Starting tcClickOnPreviousButtonToGoBackToOthersPage Test===========");

			studentadmissionform.clickOnPreviousButtonToGoBackToOthersPage();

			log.info("============= Finished tcClickOnPreviousButtonToGoBackToOthersPage Test===========");
			getScreenShot("tcClickOnPreviousButtonToGoBackToOthersPage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPreviousButtonToGoBackToOthersPage");
		}
	}

	@Test(priority = 102)
	public void tcClickOnNextToSwitchFromOthersToDocumentsPage_AfterClearDocuments() {

		try {
			log.info(
					"============= Starting tcClickOnNextToSwitchFromOthersToDocumentsPage_AfterClearDocuments Test===========");

			studentadmissionform.clickOnNextToSwitchFromOthersToDocumentsPage();
			log.info(
					"============= Finished tcClickOnNextToSwitchFromOthersToDocumentsPage_AfterClearDocuments Test===========");
			getScreenShot("tcClickOnNextToSwitchFromOthersToDocumentsPage_AfterClearDocuments");
		} catch (Exception e) {
			getScreenShot("tcClickOnNextToSwitchFromOthersToDocumentsPage_AfterClearDocuments");
		}
	}

	@Test(priority = 103)
	public void tcClickOnSubmitButton_Documents_Blank_AfterClear() {

		try {
			log.info("============= Starting tcClickOnSubmitButton_Documents_Blank_AfterClear Test===========");

			studentadmissionform.clickOnSubmitButton_Documents();

			log.info("============= Finished tcClickOnSubmitButton_Documents_Blank_AfterClear Test===========");
			getScreenShot("tcClickOnSubmitButton_Documents_Blank_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_Documents_Blank_AfterClear");
		}
	}

	@Test(priority = 104, dataProvider = "StudentAdmForm_Document")
	public void tcUploadDocumentCorrepondingToDocumentName_AfterClear(String documentName, String runMode) {

		try {
			log.info("============= Starting tcUploadDocumentCorrepondingToDocumentName_AfterClear Test===========");

			studentadmissionform.uploadDocumentCorrepondingToDocumentName(documentName);

			log.info("============= Finished tcUploadDocumentCorrepondingToDocumentName_AfterClear Test===========");
			getScreenShot("tcUploadDocumentCorrepondingToDocumentName_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadDocumentCorrepondingToDocumentName_AfterClear");
		}
	}

	@Test(priority = 105)
	public void tcCloseOpenedUploadedImagePopUp_DocumentUpload_AfterClear() {

		try {
			log.info(
					"============= Starting tcCloseOpenedUploadedImagePopUp_DocumentUpload_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info(
					"============= Finished tcCloseOpenedUploadedImagePopUp_DocumentUpload_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_DocumentUpload_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_DocumentUpload_AfterClear");
		}
	}

	@Test(priority = 106)
	public void tcRequiredDetailsInDocumentsPage_AfterClear() {

		try {
			log.info("============= Starting tcRequiredDetailsInDocumentsPage_AfterClear Test===========");

			studentadmissionform.requiredDetailsInDocumentsPage();

			log.info("============= Finished tcRequiredDetailsInDocumentsPage_AfterClear Test===========");
			getScreenShot("tcRequiredDetailsInDocumentsPage_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcRequiredDetailsInDocumentsPage_AfterClear");
		}
	}

	@Test(priority = 107)
	public void tcUploadFatherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcUploadFatherPhoto_AfterClear Test===========");

			studentadmissionform.uploadFatherPhoto();

			log.info("============= Finished tcUploadFatherPhoto_AfterClear Test===========");
			getScreenShot("tcUploadFatherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherPhoto_AfterClear");
		}
	}

	@Test(priority = 108)
	public void tcUploadFatherSign_AfterClear() {

		try {
			log.info("============= Starting tcUploadFatherSign_AfterClear Test===========");

			studentadmissionform.uploadFatherSign();

			log.info("============= Finished tcUploadFatherSign_AfterClear Test===========");
			getScreenShot("tcUploadFatherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherSign_AfterClear");
		}
	}

	@Test(priority = 109)
	public void tcUploadFatherFingerPrint_AfterClear() {

		try {
			log.info("============= Starting tcUploadFatherFingerPrint_AfterClear Test===========");

			studentadmissionform.uploadFatherFingerPrint();

			log.info("============= Finished tcUploadFatherFingerPrint_AfterClear Test===========");
			getScreenShot("tcUploadFatherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 110)
	public void tcViewUploadedFatherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedFatherPhoto_AfterClear Test===========");

			studentadmissionform.viewUploadedFatherPhoto();

			log.info("============= Finished tcViewUploadedFatherPhoto_AfterClear Test===========");
			getScreenShot("tcViewUploadedFatherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherPhoto_AfterClear");
		}
	}

	@Test(priority = 111)
	public void tcCloseOpenedUploadedImagePopUp_FatherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_FatherPhoto_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_FatherPhoto_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherPhoto_AfterClear");
		}
	}

	@Test(priority = 112)
	public void tcViewUploadedFatherSign_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedFatherSign_AfterClear Test===========");

			studentadmissionform.viewUploadedFatherSign();

			log.info("============= Finished tcViewUploadedFatherSign_AfterClear Test===========");
			getScreenShot("tcViewUploadedFatherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherSign_AfterClear");
		}
	}

	@Test(priority = 113)
	public void tcCloseOpenedUploadedImagePopUp_FatherSign_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_FatherSign_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_FatherSign_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherSign_AfterClear");
		}
	}

	@Test(priority = 114)
	public void tcViewUploadedFatherFingerPrint_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedFatherFingerPrint_AfterClear Test===========");

			studentadmissionform.viewUploadedFatherFingerPrint();

			log.info("============= Finished tcViewUploadedFatherFingerPrint_AfterClear Test===========");
			getScreenShot("tcViewUploadedFatherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedFatherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 115)
	public void tcCloseOpenedUploadedImagePopUp_FatherFingerPrint_AfterClear() {

		try {
			log.info(
					"============= Starting tcCloseOpenedUploadedImagePopUp_FatherFingerPrint_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info(
					"============= Finished tcCloseOpenedUploadedImagePopUp_FatherFingerPrint_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_FatherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 116)
	public void tcUploadMotherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcUploadMotherPhoto_AfterClear Test===========");

			studentadmissionform.uploadMotherPhoto();

			log.info("============= Finished tcUploadMotherPhoto_AfterClear Test===========");
			getScreenShot("tcUploadMotherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherPhoto_AfterClear");
		}
	}

	@Test(priority = 117)
	public void tcUploadMotherSign_AfterClear() {

		try {
			log.info("============= Starting tcUploadMotherSign_AfterClear Test===========");

			studentadmissionform.uploadMotherSign();

			log.info("============= Finished tcUploadMotherSign_AfterClear Test===========");
			getScreenShot("tcUploadMotherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherSign_AfterClear");
		}
	}

	@Test(priority = 118)
	public void tcUploadMotherFingerPrint_AfterClear() {

		try {
			log.info("============= Starting tcUploadMotherFingerPrint_AfterClear Test===========");

			studentadmissionform.uploadMotherFingerPrint();

			log.info("============= Finished tcUploadMotherFingerPrint_AfterClear Test===========");
			getScreenShot("tcUploadMotherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 119)
	public void tcViewUploadedMotherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedMotherPhoto_AfterClear Test===========");

			studentadmissionform.viewUploadedMotherPhoto();

			log.info("============= Finished tcViewUploadedMotherPhoto_AfterClear Test===========");
			getScreenShot("tcViewUploadedMotherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherPhoto_AfterClear");
		}
	}

	@Test(priority = 120)
	public void tcCloseOpenedUploadedImagePopUp_MotherPhoto_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_MotherPhoto_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_MotherPhoto_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherPhoto_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherPhoto_AfterClear");
		}
	}

	@Test(priority = 121)
	public void tcViewUploadedMotherSign_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedMotherSign_AfterClear Test===========");

			studentadmissionform.viewUploadedMotherSign();

			log.info("============= Finished tcViewUploadedMotherSign_AfterClear Test===========");
			getScreenShot("tcViewUploadedMotherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherSign_AfterClear");
		}
	}

	@Test(priority = 122)
	public void tcCloseOpenedUploadedImagePopUp_MotherSign_AfterClear() {

		try {
			log.info("============= Starting tcCloseOpenedUploadedImagePopUp_MotherSign_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info("============= Finished tcCloseOpenedUploadedImagePopUp_MotherSign_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherSign_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherSign_AfterClear");
		}
	}

	@Test(priority = 123)
	public void tcViewUploadedMotherFingerPrint_AfterClear() {

		try {
			log.info("============= Starting tcViewUploadedMotherFingerPrint_AfterClear Test===========");

			studentadmissionform.viewUploadedMotherFingerPrint();

			log.info("============= Finished tcViewUploadedMotherFingerPrint_AfterClear Test===========");
			getScreenShot("tcViewUploadedMotherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcViewUploadedMotherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 124)
	public void tcCloseOpenedUploadedImagePopUp_MotherFingerPrint_AfterClear() {

		try {
			log.info(
					"============= Starting tcCloseOpenedUploadedImagePopUp_MotherFingerPrint_AfterClear Test===========");

			studentadmissionform.closeOpenedUploadedImagePopUp();

			log.info(
					"============= Finished tcCloseOpenedUploadedImagePopUp_MotherFingerPrint_AfterClear Test===========");
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherFingerPrint_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenedUploadedImagePopUp_MotherFingerPrint_AfterClear");
		}
	}

	@Test(priority = 125)
	public void tcClickOnSubmitButton_Documents() {

		try {
			log.info("============= Strting tcClickOnSubmitButton_Documents Test===========");

			studentadmissionform.clickOnSubmitButton_Documents();

			log.info("============= Finished tcClickOnSubmitButton_Documents Test===========");
			getScreenShot("tcClickOnSubmitButton_Documents");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton_Documents");
		}
	}

	@Test(priority = 126)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			studentadmissionform.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
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
