/**
 * 
 */
package com.vapsTechnosoft.IVRM.TCpreAdmission.TC_TransferStudent;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.preAdmission.TransferStudent.TransferFromPreAdmissionToAdmission;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_TransferFromPreAdmissionToAdmission extends TestBase {

	public static final Logger log = Logger.getLogger(TC_TransferFromPreAdmissionToAdmission.class.getName());

	TransferFromPreAdmissionToAdmission preAdmToAdmission;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "TransferPreAdmToAdmData_Form")
	public String[][] getTestData() {
		String[][] testRecordsPreAdmToAdm = getData("BGHS_PreAdmissionData.xlsx", "TransferPreAdmToAdmData");
		return testRecordsPreAdmToAdm;
	}

	@DataProvider(name = "search_registrationNumberTransfer")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_PreAdmissionData.xlsx", "search_transferStudent");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		preAdmToAdmission = new TransferFromPreAdmissionToAdmission(driver);
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

			boolean status = preAdmToAdmission.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToPreAdmission_TransferPreAdmToAdm() {

		try {
			log.info("============= Strting tcNavigateToPreAdmission_TransferPreAdmToAdm Test===========");

			preAdmToAdmission.navigateToPreAdmission_TransferPreAdmToAdm();

			log.info("============= Finished tcNavigateToPreAdmission_TransferPreAdmToAdm Test===========");
			getScreenShot("tcNavigateToPreAdmission_TransferPreAdmToAdm");
		} catch (Exception e) {
			getScreenShot("tcNavigateToPreAdmission_TransferPreAdmToAdm");
		}
	}

	@Test(priority = 4)
	public void tcVerifyPreAdmission_TransferpreAdmissionToAdmissionPage() {

		try {
			log.info("============= Strting tcVerifyPreAdmission_TransferpreAdmissionToAdmissionPage Test===========");

			boolean status = preAdmToAdmission.verifyPreAdmission_TransferpreAdmissionToAdmissionPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyPreAdmission_TransferpreAdmissionToAdmissionPage Test===========");
			getScreenShot("tcVerifyPreAdmission_TransferpreAdmissionToAdmissionPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyPreAdmission_TransferpreAdmissionToAdmissionPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_TransferPreAdmToAdmissionForm() {

		try {
			log.info("============= Strting tcSubmitBlank_TransferPreAdmToAdmissionForm Test===========");

			preAdmToAdmission.submitBlank_TransferPreAdmToAdmissionForm();

			log.info("============= Finished tcSubmitBlank_TransferPreAdmToAdmissionForm Test===========");
			getScreenShot("tcSubmitBlank_TransferPreAdmToAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_TransferPreAdmToAdmissionForm");
		}
	}

	@Test(priority = 6, dataProvider = "TransferPreAdmToAdmData_Form")
	public void tcFill_TransferPreAdmissionToAdmissionForm(String academicYear, String class_status, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_TransferPreAdmissionToAdmissionForm Test===========");

			preAdmToAdmission.fill_TransferpreAdmissionToAdmissionForm(academicYear, class_status);

			log.info("============= Finished tcFill_TransferPreAdmissionToAdmissionForm Test===========");
			getScreenShot("tcFill_TransferPreAdmissionToAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcFill_TransferPreAdmissionToAdmissionForm");
		}
	}

	@Test(priority = 7)
	public void tcClickOnSearchTo_GetRecords() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords Test===========");

			preAdmToAdmission.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords");
		}
	}

	@Test(priority = 8)
	public void tcClickOnSuccessOkBtn_RecordSearchConfirm() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_RecordSearchConfirm Test===========");

			preAdmToAdmission.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_RecordSearchConfirm Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_RecordSearchConfirm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_RecordSearchConfirm");
		}
	}

	@Test(priority = 9)
	public void tcClickOnExportToAdmission_WithoutStudentSelection() {

		try {
			log.info("============= Strting tcClickOnExportToAdmission_WithoutStudentSelection Test===========");

			preAdmToAdmission.clickOnExportToAdmission();

			log.info("============= Finished tcClickOnExportToAdmission_WithoutStudentSelection Test===========");
			getScreenShot("tcClickOnExportToAdmission_WithoutStudentSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToAdmission_WithoutStudentSelection");
		}
	}

	@Test(priority = 10)
	public void tcClickOnSuccessOkBtn_WithoutStudentSelection() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_WithoutStudentSelection Test===========");

			preAdmToAdmission.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_WithoutStudentSelection Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_WithoutStudentSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_WithoutStudentSelection");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_TransferPreAdmToAdmForm() {

		try {
			log.info("============= Strting tcMinimize_TransferPreAdmToAdmForm Test===========");

			preAdmToAdmission.min_Max_TransferPreAdmToAdmForm();

			log.info("============= Finished tcMinimize_TransferPreAdmToAdmForm Test===========");
			getScreenShot("tcMinimize_TransferPreAdmToAdmForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_TransferPreAdmToAdmForm");
		}
	}

	@Test(priority = 12)
	public void tcSortWithStudentNameInStatusDetails() {

		try {
			log.info("============= Strting tcSortWithStudentNameInStatusDetails Test===========");
			getScreenShot("BeforeSorting_tcSortWithStudentNameInStatusDetails");
			preAdmToAdmission.sortWithStudentNameInStatusDetails();

			log.info("============= Finished tcSortWithStudentNameInStatusDetails Test===========");
			getScreenShot("tcSortWithStudentNameInStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSortWithStudentNameInStatusDetails");
		}
	}

	@Test(priority = 13)
	public void tcSortWithRegistrationNumberInStatusDetails() {

		try {
			log.info("============= Strting tcSortWithRegistrationNumberInStatusDetails Test===========");
			getScreenShot("BeforeSorting_tcSortWithRegistrationNumberInStatusDetails");
			preAdmToAdmission.sortWithRegistrationNumberInStatusDetails();

			log.info("============= Finished tcSortWithRegistrationNumberInStatusDetails Test===========");
			getScreenShot("tcSortWithRegistrationNumberInStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSortWithRegistrationNumberInStatusDetails");
		}
	}

	@Test(priority = 14)
	public void tcMinimize_ListOfStudents() {

		try {
			log.info("============= Strting tcMinimize_ListOfStudents Test===========");

			preAdmToAdmission.min_Max_ListOfStudents();
			log.info("============= Finished tcMinimize_ListOfStudents Test===========");
			getScreenShot("tcMinimize_ListOfStudents");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ListOfStudents");
		}
	}

	@Test(priority = 15)
	public void tcMaximize_ListOfStudents() {

		try {
			log.info("============= Strting tcMaximize_ListOfStudents Test===========");

			preAdmToAdmission.min_Max_ListOfStudents();

			log.info("============= Finished tcMaximize_ListOfStudents Test===========");
			getScreenShot("tcMaximize_ListOfStudents");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ListOfStudents");
		}
	}

	@Test(priority = 16)
	public void tcMaximize_TransferPreAdmToAdmForm() {

		try {
			log.info("============= Strting tcMaximize_TransferPreAdmToAdmForm Test===========");

			preAdmToAdmission.min_Max_TransferPreAdmToAdmForm();

			log.info("============= Finished tcMaximize_TransferPreAdmToAdmForm Test===========");
			getScreenShot("tcMaximize_TransferPreAdmToAdmForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_TransferPreAdmToAdmForm");
		}
	}

	@Test(priority = 17)
	public void tcClickOnCancelTo_ClearFilledData_TransferpreAdmissionToAdmission() {

		try {
			log.info(
					"============= Strting tcClickOnCancelTo_ClearFilledData_TransferpreAdmissionToAdmission Test===========");

			preAdmToAdmission.clickOnCancelTo_ClearFilledData_Status();

			log.info(
					"============= Finished tcClickOnCancelTo_ClearFilledData_TransferpreAdmissionToAdmission Test===========");
			getScreenShot("tcClickOnCancelTo_ClearFilledData_TransferpreAdmissionToAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelTo_ClearFilledData_TransferpreAdmissionToAdmission");
		}
	}

	@Test(priority = 18, dataProvider = "TransferPreAdmToAdmData_Form")
	public void tcFill_TransferpreAdmissionToAdmissionForm_AfterCancel(String academicYear, String class_status,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_TransferpreAdmissionToAdmissionForm_AfterCancel Test===========");

			preAdmToAdmission.fill_TransferpreAdmissionToAdmissionForm(academicYear, class_status);

			log.info("============= Finished tcFill_TransferpreAdmissionToAdmissionForm_AfterCancel Test===========");
			getScreenShot("tcFill_TransferpreAdmissionToAdmissionForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_TransferpreAdmissionToAdmissionForm_AfterCancel");
		}
	}

	@Test(priority = 19)
	public void tcClickOnSearchTo_GetRecords_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_AfterCancel Test===========");

			preAdmToAdmission.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_AfterCancel");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSuccessOkBtn_RecordSearchConfirm_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_RecordSearchConfirm_AfterCancel Test===========");

			preAdmToAdmission.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_RecordSearchConfirm_AfterCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_RecordSearchConfirm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_RecordSearchConfirm_AfterCancel");
		}
	}

	@Test(priority = 21, dataProvider = "search_registrationNumberTransfer")
	public void tcSearchForStudent_InListOfStudents(String regNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchForStudent_InListOfStudents Test===========");

			preAdmToAdmission.searchForStudent_InListOfStudents(regNumber);

			log.info("============= Finished tcSearchForStudent_InListOfStudents Test===========");
			getScreenShot("tcSearchForStudent_InListOfStudents");
		} catch (Exception e) {
			getScreenShot("tcSearchForStudent_InListOfStudents");
		}
	}

	@Test(priority = 22)
	public void tcSelectSpecificStudent_InListOfStudentToTransfer() {

		try {
			log.info("============= Strting tcSelectSpecificStudent_InListOfStudentToTransfer Test===========");

			preAdmToAdmission.selectSpecificStudent_InListOfStudentToTransfer();

			log.info("============= Finished tcSelectSpecificStudent_InListOfStudentToTransfer Test===========");
			getScreenShot("tcSelectSpecificStudent_InListOfStudentToTransfer");
		} catch (Exception e) {
			getScreenShot("tcSelectSpecificStudent_InListOfStudentToTransfer");
		}
	}

	@Test(priority = 23)
	public void tcClickOnExportToAdmission_ToTranferSelectedStudent() {

		try {
			log.info("============= Strting tcClickOnExportToAdmission_ToTranferSelectedStudent Test===========");

			preAdmToAdmission.clickOnExportToAdmission();

			log.info("============= Finished tcClickOnExportToAdmission_ToTranferSelectedStudent Test===========");
			getScreenShot("tcClickOnExportToAdmission_ToTranferSelectedStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToAdmission_ToTranferSelectedStudent");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSuccessOkBtn_TranferSelectedStudent() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_TranferSelectedStudent Test===========");

			preAdmToAdmission.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_TranferSelectedStudent Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_TranferSelectedStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_TranferSelectedStudent");
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
