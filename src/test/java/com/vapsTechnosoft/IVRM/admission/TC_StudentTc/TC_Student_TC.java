/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_StudentTc;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.StudentTC.Student_TC;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Student_TC extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Student_TC.class.getName());

	Student_TC studenttc;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "StudentTC_FilterStudent")
	public String[][] getTestStudentTCData() {
		String[][] testRecords_FilterStudent = getData("Admission_StudentTC.xlsx", "BGHS_StudentTCFilterData");
		return testRecords_FilterStudent;
	}

	@DataProvider(name = "StudentTC_StudentDetails")
	public String[][] getTestStudentDetailsData() {
		String[][] testRecords_StudentDetails = getData("Admission_StudentTC.xlsx", "BGHS_StudentTC_StudentDetails");
		return testRecords_StudentDetails;
	}

	@DataProvider(name = "StudentTC_TCDetails")
	public String[][] getTestTCDetailsData() {
		String[][] testRecords_TCDetails = getData("Admission_StudentTC.xlsx", "BGHS_StudentTC_TCDetails");
		return testRecords_TCDetails;
	}

	@DataProvider(name = "StudentTC_StuPersonalDetailsLeft")
	public String[][] getTestPersonalDetailsLeftData() {
		String[][] testRecords_PersonalDetailsLeft = getData("Admission_StudentTC.xlsx",
				"BGHS_STC_StudentPersonalLeft");
		return testRecords_PersonalDetailsLeft;
	}

	@DataProvider(name = "StudentTC_StuPersonalDetailsRight")
	public String[][] getTestPersonalDetailsRightData() {
		String[][] testRecords_PersonalDetailsRight = getData("Admission_StudentTC.xlsx",
				"BGHS_STC_StudentPersonalRight");
		return testRecords_PersonalDetailsRight;
	}

	@DataProvider(name = "StudentTC_OtherDetails")
	public String[][] getTestOtherDetails() {
		String[][] testRecords_OtherDetails = getData("Admission_StudentTC.xlsx", "BGHS_StudentTC_OtherDetails");
		return testRecords_OtherDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studenttc = new Student_TC(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {

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

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = studenttc.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToStudentTC_BGHS() {

		try {
			log.info("============= Strting tcNavigateToStudentTC_BGHS Test===========");

			studenttc.navigateToStudentTC_BGHS();

			log.info("============= Finished tcNavigateToStudentTC_BGHS Test===========");
			getScreenShot("tcNavigateToStudentTC_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToStudentTC_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyStudentTC_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyStudentTC_BGHSPage Test===========");

			boolean status = studenttc.verifyStudentTC_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyStudentTC_BGHSPage Test===========");
			getScreenShot("tcVerifyStudentTC_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentTC_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "StudentTC_FilterStudent")
	public void tcFillStudentTcForm_Individual(String academicYr, String class_TC, String section, String stuName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillStudentTcForm_Individual Test===========");

			studenttc.fillStudentTcForm_Individual(academicYr, class_TC, section, stuName);

			log.info("============= Finished tcFillStudentTcForm_Individual Test===========");
			getScreenShot("tcFillStudentTcForm_Individual");
		} catch (Exception e) {
			getScreenShot("tcFillStudentTcForm_Individual");
		}
	}

	@Test(priority = 6, dataProvider = "StudentTC_StudentDetails")
	public void tcFill_StudentDetails_ForStudentTc(String dateOfAdm, String lastClassStudied, String caste,
			String InstrMedium, String languageStudied, String electiveStudied, String scholarship, String medicalExam,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentDetails_ForStudentTc Test===========");

			studenttc.fill_StudentDetails_ForStudentTc(dateOfAdm, lastClassStudied, caste, InstrMedium, languageStudied,
					electiveStudied, scholarship, medicalExam);

			log.info("============= Finished tcFill_StudentDetails_ForStudentTc Test===========");
			getScreenShot("tcFill_StudentDetails_ForStudentTc");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentDetails_ForStudentTc");
		}
	}

	@Test(priority = 7)
	public void tcClickOn_StudentDetails_NextButton() {

		try {
			log.info("============= Strting tcClickOn_StudentDetails_NextButton Test===========");

			studenttc.clickOn_StudentDetails_NextButton();

			log.info("============= Finished tcClickOn_StudentDetails_NextButton Test===========");
			getScreenShot("tcClickOn_StudentDetails_NextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOn_StudentDetails_NextButton");
		}
	}

	@Test(priority = 8, dataProvider = "StudentTC_TCDetails")
	public void tcFillStudent_TCDetailsForm(String tcNumber, String reasonForLeaving, String schoolDays,
			String attendanceDays, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentDetails_ForStudentTc Test===========");

			studenttc.fillStudent_TCDetailsForm(tcNumber, reasonForLeaving, schoolDays, attendanceDays);

			log.info("============= Finished tcFill_StudentDetails_ForStudentTc Test===========");
			getScreenShot("tcFill_StudentDetails_ForStudentTc");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentDetails_ForStudentTc");
		}
	}

	@Test(priority = 9)
	public void tcClickOnTC_Details_NextButton() {

		try {
			log.info("============= Strting tcClickOnTC_Details_NextButton Test===========");

			studenttc.clickOnTC_Details_NextButton();

			log.info("============= Finished tcClickOnTC_Details_NextButton Test===========");
			getScreenShot("tcClickOnTC_Details_NextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnTC_Details_NextButton");
		}
	}

	@Test(priority = 10, dataProvider = "StudentTC_StuPersonalDetailsLeft")
	public void tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart(String dateOfBirth,
			String dobInWords, String stuIFSCCode, String birthPlace, String birthCertNumber, String casteCertNumber,
			String age, String gender, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart Test===========");

			studenttc.validateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart(dateOfBirth, dobInWords,
					stuIFSCCode, birthPlace, birthCertNumber, casteCertNumber, age, gender);

			log.info(
					"============= Finished tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart Test===========");
			getScreenShot("tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart");
		} catch (Exception e) {
			getScreenShot("tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_LeftPart");
		}
	}

	@Test(priority = 11, dataProvider = "StudentTC_StuPersonalDetailsRight")
	public void tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart(String motherTongue,
			String nationality, String mobileNo, String emailId, String aadharNumber, String bloodGroup,
			String studentAccountNo, String bplCardNo, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart Test===========");

			studenttc.validateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart(motherTongue, nationality,
					mobileNo, emailId, aadharNumber, bloodGroup, studentAccountNo, bplCardNo);

			log.info(
					"============= Finished tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart Test===========");
			getScreenShot("tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart");
		} catch (Exception e) {
			getScreenShot("tcValidateStudentPersonaldetails_FromStudentAdmissionFrom_RightPart");
		}
	}

	@Test(priority = 12)
	public void tcClickOn_StudentPersonal_Details_NextButton() {

		try {
			log.info("============= Strting tcClickOn_StudentPersonal_Details_NextButton Test===========");

			studenttc.clickOn_StudentPersonal_Details_NextButton();

			log.info("============= Finished tcClickOn_StudentPersonal_Details_NextButton Test===========");
			getScreenShot("tcClickOn_StudentPersonal_Details_NextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOn_StudentPersonal_Details_NextButton");
		}
	}

	@Test(priority = 13, dataProvider = "StudentTC_OtherDetails")
	public void tcFill_OtherDetails_FroStudentTCForm(String feesPaid, String feeConcession, String lastExam,
			String results, String wheaterFailed, String qualifiedForPromotion, String qualifiedForWhichClass,
			String nccCadet, String extraCurricular, String conduct, String remarks, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_OtherDetails_FroStudentTCForm Test===========");

			studenttc.fill_OtherDetails_FroStudentTCForm(feesPaid, feeConcession, lastExam, results, wheaterFailed,
					qualifiedForPromotion, qualifiedForWhichClass, nccCadet, extraCurricular, conduct, remarks);

			log.info("============= Finished tcFill_OtherDetails_FroStudentTCForm Test===========");
			getScreenShot("tcFill_OtherDetails_FroStudentTCForm");
		} catch (Exception e) {
			getScreenShot("tcFill_OtherDetails_FroStudentTCForm");
		}
	}
	@Test(priority = 14)
	public void tcClickOn_Other_Details_NextButton() {

		try {
			log.info("============= Strting tcClickOn_Other_Details_NextButton Test===========");

			studenttc.clickOn_Other_Details_NextButton();

			log.info("============= Finished tcClickOn_Other_Details_NextButton Test===========");
			getScreenShot("tcClickOn_Other_Details_NextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOn_Other_Details_NextButton");
		}
	}
	
	@Test(priority = 15)
	public void tcSaveStudentTC() {

		try {
			log.info("============= Strting tcSaveStudentTC Test===========");

			studenttc.saveStudentTC();

			log.info("============= Finished tcSaveStudentTC Test===========");
			getScreenShot("tcSaveStudentTC");
		} catch (Exception e) {
			getScreenShot("tcSaveStudentTC");
		}
	}
	@Test(priority = 16)
	public void tcCancel_SavingOfStudentTC() {

		try {
			log.info("============= Strting tcCancel_SavingOfStudentTC Test===========");

			studenttc.cancel_SavingOfStudentTC();

			log.info("============= Finished tcCancel_SavingOfStudentTC Test===========");
			getScreenShot("tcCancel_SavingOfStudentTC");
		} catch (Exception e) {
			getScreenShot("tcCancel_SavingOfStudentTC");
		}
	}
	
	@Test(priority = 17)
	public void tcClickOnOkButton_Cancel() {

		try {
			log.info("============= Strting tcClickOnOkButton_Cancel Test===========");

			studenttc.clickOnOkButton();

			log.info("============= Finished tcClickOnOkButton_Cancel Test===========");
			getScreenShot("tcClickOnOkButton_Cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_Cancel");
		}
	}
	@Test(priority = 18)
	public void tcSaveStudentTC_AfterCancel() {

		try {
			log.info("============= Strting tcSaveStudentTC_AfterCancel Test===========");

			studenttc.saveStudentTC();

			log.info("============= Finished tcSaveStudentTC_AfterCancel Test===========");
			getScreenShot("tcSaveStudentTC_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSaveStudentTC_AfterCancel");
		}
	}
	@Test(priority = 19)
	public void tcYesSubmitIt_SavingOfStudentTC() {

		try {
			log.info("============= Strting tcYesSubmitIt_SavingOfStudentTC Test===========");

			studenttc.yesSubmitIt_SavingOfStudentTC();

			log.info("============= Finished tcYesSubmitIt_SavingOfStudentTC Test===========");
			getScreenShot("tcYesSubmitIt_SavingOfStudentTC");
		} catch (Exception e) {
			getScreenShot("tcYesSubmitIt_SavingOfStudentTC");
		}
	}
	
	@Test(priority = 20)
	public void tcClickOnOkButton_Submit() {

		try {
			log.info("============= Strting tcClickOnOkButton_Submit Test===========");

			studenttc.clickOnOkButton();

			log.info("============= Finished tcClickOnOkButton_Submit Test===========");
			getScreenShot("tcClickOnOkButton_Submit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_Submit");
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
