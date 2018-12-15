/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Subject;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Subject extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Master_Subject.class.getName());

	Masters_Master_Subject mastersubject;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterSubjectWrittenData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsWrittenDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterSubjectPreAdmWriData");
		return testRecordsWrittenDetails;
	}

	@DataProvider(name = "MastersMasterSubjectOralData")
	public String[][] getTestOralData() {
		String[][] testRecordsOralDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterSubjectPreAdmOraData");
		return testRecordsOralDetails;
	}

	@DataProvider(name = "MastersMasterSubjectWithoutPreAdmData")
	public String[][] getTestData() {
		String[][] testRecordsSubjectDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterSubjectWithoutPreAdm");
		return testRecordsSubjectDetails;
	}

	@DataProvider(name = "MasterSubjectSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchBySubjectNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastersubject = new Masters_Master_Subject(driver);
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

			boolean status = mastersubject.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterSubject_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterSubject_BGHS Test===========");

			mastersubject.navigateToAdmission_Masters_MasterSubject_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterSubject_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterSubject_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterSubject_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterSubject_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterSubject_BGHSPage Test===========");

			boolean status = mastersubject.verifyMasters_MasterSubject_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterSubject_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterSubject_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterSubject_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterSubjectForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterSubjectForm Test===========");

			mastersubject.submitBlankMasterSubjectForm();

			log.info("============= Finished tcSubmitBlankMasterSubjectForm Test===========");
			getScreenShot("tcSubmitBlankMasterSubjectForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterSubjectForm");
		}
	}

	@Test(priority = 6)
	public void tcSelect_PreAdmissionFlag_WrittenForm() {

		try {
			log.info("============= Strting tcSelect_PreAdmissionFlag_WrittenForm Test===========");

			mastersubject.select_PreAdmissionFlag_WrittenForm();

			log.info("============= Finished tcSelect_PreAdmissionFlag_WrittenForm Test===========");
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm");
		} catch (Exception e) {
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm");
		}
	}

	@Test(priority = 7, dataProvider = "MastersMasterSubjectWrittenData")
	public void tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written(String subjectName, String subjectCode,
			String maxMarks, String minMarks, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written Test===========");

			mastersubject.enterMasterSubjectFormDetails_forPreAdmissionFlag(subjectName, subjectCode, maxMarks,
					minMarks);

			log.info(
					"============= Finished tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written Test===========");
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written");
		}
	}

	@Test(priority = 8)
	public void tcClearMasterSubjectInfoData() {

		try {
			log.info("============= Strting tcClearMasterSubjectInfoData Test===========");

			mastersubject.clearMasterSubjectInfoData();

			log.info("============= Finished tcClearMasterSubjectInfoData Test===========");
			getScreenShot("tcClearMasterSubjectInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearMasterSubjectInfoData");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeMasterSubject() {

		try {
			log.info("============= Strting tcMinimizeMasterSubject Test===========");

			mastersubject.minimizeMasterSubject();

			log.info("============= Finished tcMinimizeMasterSubject Test===========");
			getScreenShot("tcMinimizeMasterSubject");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSubject");
		}
	}

	@Test(priority = 10)
	public void tcSortBySubjectName() {

		try {
			log.info("============= Strting tcSortBySubjectName Test===========");
			getScreenShot("tcSortBySubjectName_BeforeSorting");

			mastersubject.sortBySubjectName();

			log.info("============= Finished tcSortBySubjectName Test===========");
			getScreenShot("tcSortBySubjectName");
		} catch (Exception e) {
			getScreenShot("tcSortBySubjectName");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeMasterSubject() {

		try {
			log.info("============= Strting tcMaximizeMasterSubject Test===========");

			mastersubject.maximizeMasterSubject();

			log.info("============= Finished tcMaximizeMasterSubject Test===========");
			getScreenShot("tcMaximizeMasterSubject");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSubject");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeMasterSubjectList() {

		try {
			log.info("============= Strting tcMinimizeMasterSubjectList Test===========");

			mastersubject.minimizeMasterSubjectList();

			log.info("============= Finished tcMinimizeMasterSubjectList Test===========");
			getScreenShot("tcMinimizeMasterSubjectList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSubjectList");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeMasterSubjectList() {

		try {
			log.info("============= Strting tcMaximizeMasterSubjectList Test===========");

			mastersubject.maximizeMasterSubjectList();

			log.info("============= Finished tcMaximizeMasterSubjectList Test===========");
			getScreenShot("tcMaximizeMasterSubjectList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSubjectList");
		}
	}

	@Test(priority = 14)
	public void tcSelect_PreAdmissionFlag_WrittenForm_AfterClear() {

		try {
			log.info("============= Strting tcSelect_PreAdmissionFlag_WrittenForm_AfterClear Test===========");

			mastersubject.select_PreAdmissionFlag_WrittenForm();

			log.info("============= Finished tcSelect_PreAdmissionFlag_WrittenForm_AfterClear Test===========");
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm_AfterClear");
		}
	}

	@Test(priority = 15, dataProvider = "MastersMasterSubjectWrittenData")
	public void tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written_AfterClear(String subjectName,
			String subjectCode, String maxMarks, String minMarks, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written_AfterClear Test===========");

			mastersubject.enterMasterSubjectFormDetails_forPreAdmissionFlag(subjectName, subjectCode, maxMarks,
					minMarks);

			log.info(
					"============= Finished tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written_AfterClear Test===========");
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Written_AfterClear");
		}
	}

	@Test(priority = 16)
	public void tcSubmitFilledMasterSubjectForm_Written() {

		try {
			log.info("============= Strting tcSubmitFilledMasterSubjectForm_Written Test===========");

			mastersubject.submitFilledMasterSubjectForm();
			log.info("============= Finished tcSubmitFilledMasterSubjectForm_Written Test===========");
			getScreenShot("tcSubmitFilledMasterSubjectForm_Written");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterSubjectForm_Written");
		}
	}
	@Test(priority = 17)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_Written() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_Written Test===========");

			mastersubject.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_Written Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Written");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Written");
		}
	}
	@Test(priority = 18)
	public void tcClickOnOkSuccessButton_Written() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Written Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Written Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Written");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Written");
		}
	}

	@Test(priority = 19)
	public void tcSelect_PreAdmissionFlag_OralForm() {

		try {
			log.info("============= Strting tcSelect_PreAdmissionFlag_OralForm Test===========");

			mastersubject.select_PreAdmissionFlag_OralForm();

			log.info("============= Finished tcSelect_PreAdmissionFlag_OralForm Test===========");
			getScreenShot("tcSelect_PreAdmissionFlag_OralForm");
		} catch (Exception e) {
			getScreenShot("tcSelect_PreAdmissionFlag_OralForm");
		}
	}

	@Test(priority = 20, dataProvider = "MastersMasterSubjectOralData")
	public void tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Oral(String subjectName, String subjectCode,
			String maxMarks, String minMarks, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Oral Test===========");

			mastersubject.enterMasterSubjectFormDetails_forPreAdmissionFlag(subjectName, subjectCode, maxMarks,
					minMarks);

			log.info("============= Finished tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Oral Test===========");
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Oral");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSubjectFormDetails_forPreAdmissionFlag_Oral");
		}
	}

	@Test(priority = 21)
	public void tcSubmitFilledMasterSubjectForm_Oral() {

		try {
			log.info("============= Strting tcSubmitFilledMasterSubjectForm_Oral Test===========");

			mastersubject.submitFilledMasterSubjectForm();
			log.info("============= Finished tcSubmitFilledMasterSubjectForm_Oral Test===========");
			getScreenShot("tcSubmitFilledMasterSubjectForm_Oral");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterSubjectForm_Oral");
		}
	}
	@Test(priority = 22)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_Oral() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_Oral Test===========");

			mastersubject.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_Oral Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Oral");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Oral");
		}
	}
	@Test(priority = 23)
	public void tcClickOnOkSuccessButton_Oral() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Oral Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Oral Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Oral");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Oral");
		}
	}

	@Test(priority = 24, dataProvider = "MastersMasterSubjectWithoutPreAdmData")
	public void tcEnterMasterSubjectFormDetails_Without_PreAdmissionFlag(String subjectName, String subjectCode,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSubjectFormDetails_Without_PreAdmissionFlag Test===========");

			mastersubject.enterMasterSubjectFormDetails_Without_PreAdmissionFlag(subjectName, subjectCode);

			log.info("============= Finished tcEnterMasterSubjectFormDetails_Without_PreAdmissionFlag Test===========");
			getScreenShot("tcEnterMasterSubjectFormDetails_Without_PreAdmissionFlag");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSubjectFormDetails_Without_PreAdmissionFlag");
		}
	}

	@Test(priority = 25)
	public void tcSubmitFilledMasterSubjectForm_Without_PreAdmissionFlag() {

		try {
			log.info("============= Strting tcSubmitFilledMasterSubjectForm_Without_PreAdmissionFlag Test===========");

			mastersubject.submitFilledMasterSubjectForm();
			log.info("============= Finished tcSubmitFilledMasterSubjectForm_Without_PreAdmissionFlag Test===========");
			getScreenShot("tcSubmitFilledMasterSubjectForm_Without_PreAdmissionFlag");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterSubjectForm_Without_PreAdmissionFlag");
		}
	}
	@Test(priority = 26)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_Without_PreAdmissionFlag() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_Without_PreAdmissionFlag Test===========");

			mastersubject.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_Without_PreAdmissionFlag Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Without_PreAdmissionFlag");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Without_PreAdmissionFlag");
		}
	}
	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_Without_PreAdmissionFlag() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Without_PreAdmissionFlag Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Without_PreAdmissionFlag Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Without_PreAdmissionFlag");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Without_PreAdmissionFlag");
		}
	}

	@Test(priority = 28, dataProvider = "MasterSubjectSearchData")
	public void tcSearchWithSubjectNameInTheGrid(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSubjectNameInTheGrid Test===========");

			mastersubject.searchWithSubjectNameInTheGrid(subjectName);

			log.info("============= Finished tcSearchWithSubjectNameInTheGrid Test===========");
			getScreenShot("tcSearchWithSubjectNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectNameInTheGrid");
		}
	}

	@Test(priority = 29, dataProvider = "MasterSubjectSearchData")
	public void tcVerifySubjectNameInTheGrid(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifySubjectNameInTheGrid Test===========");

			mastersubject.verifySubjectNameInTheGrid(subjectName);

			log.info("============= Finished tcVerifySubjectNameInTheGrid Test===========");
			getScreenShot("tcVerifySubjectNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifySubjectNameInTheGrid");
		}
	}

	@Test(priority = 30, dataProvider = "MasterSubjectSearchData")
	public void tcEditMasterSubject(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterSubject Test===========");

			mastersubject.editMasterSubject(subjectName);

			log.info("============= Finished tcEditMasterSubject Test===========");
			getScreenShot("tcEditMasterSubject");
		} catch (Exception e) {
			getScreenShot("tcEditMasterSubject");
		}
	}

	@Test(priority = 31)
	public void tcSubmitFilledMasterSubjectForm_Edit() {

		try {
			log.info("============= Strting tcSubmitFilledMasterSubjectForm_Edit Test===========");

			mastersubject.submitFilledMasterSubjectForm();

			log.info("============= Finished tcSubmitFilledMasterSubjectForm_Edit Test===========");
			getScreenShot("tcSubmitFilledMasterSubjectForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterSubjectForm_Edit");
		}
	}
	@Test(priority = 32)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			mastersubject.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}
	@Test(priority = 33)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 34, dataProvider = "MasterSubjectSearchData")
	public void tcSearchWithSubjectNameInTheGrid_ForDeactivate(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSubjectNameInTheGrid_ForDeactivate Test===========");

			mastersubject.searchWithSubjectNameInTheGrid(subjectName);

			log.info("============= Finished tcSearchWithSubjectNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 35, dataProvider = "MasterSubjectSearchData")
	public void tcDeactivateMasterSubject(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterSubject Test===========");

			mastersubject.deactivateMasterSubject(subjectName);

			log.info("============= Finished tcDeactivateMasterSubject Test===========");
			getScreenShot("tcDeactivateMasterSubject");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterSubject");
		}
	}

	@Test(priority = 36)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			mastersubject.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}
	@Test(priority = 37)
	public void tcPopWindowMessage_DeactivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeactivateCancel_Validation Test===========");

			mastersubject.popWindowMessage_DeactivateCancel_Validation();

			log.info("============= Finished tcPopWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeactivateCancel_Validation");
		}
	}
	@Test(priority = 38)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 39, dataProvider = "MasterSubjectSearchData")
	public void tcSearchWithSubjectNameInTheGrid_ForDeactivate_AfterCancel(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithSubjectNameInTheGrid_ForDeactivate_AfterCancel Test===========");

			mastersubject.searchWithSubjectNameInTheGrid(subjectName);

			log.info(
					"============= Finished tcSearchWithSubjectNameInTheGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 40, dataProvider = "MasterSubjectSearchData")
	public void tcDeactivateMasterSubject_AfterCancel(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterSubject_AfterCancel Test===========");

			mastersubject.deactivateMasterSubject(subjectName);

			log.info("============= Finished tcDeactivateMasterSubject_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterSubject_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterSubject_AfterCancel");
		}
	}

	@Test(priority = 41)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastersubject.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 42)
	public void tcPopWindowMessage_DeactivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");

			mastersubject.popWindowMessage_DeactivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		}
	}
	@Test(priority = 43)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 44, dataProvider = "MasterSubjectSearchData")
	public void tcSearchWithSubjectNameInTheGrid_ForActivate(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSubjectNameInTheGrid_ForActivate Test===========");

			mastersubject.searchWithSubjectNameInTheGrid(subjectName);

			log.info("============= Finished tcSearchWithSubjectNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 45, dataProvider = "MasterSubjectSearchData")
	public void tcActivateMasterSubject(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterSubject Test===========");

			mastersubject.activateMasterSubject(subjectName);

			log.info("============= Finished tcActivateMasterSubject Test===========");
			getScreenShot("tcActivateMasterSubject");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterSubject");
		}
	}

	@Test(priority = 46)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			mastersubject.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}
	@Test(priority = 47)
	public void tcPopWindowMessage_ActivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_ActivateCancel_Validation Test===========");

			mastersubject.popWindowMessage_ActivateCancel_Validation();

			log.info("============= Finished tcPopWindowMessage_ActivateCancel_Validation Test===========");
			getScreenShot("tcPopWindowMessage_ActivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_ActivateCancel_Validation");
		}
	}
	@Test(priority = 48)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 49, dataProvider = "MasterSubjectSearchData")
	public void tcSearchWithSubjectNameInTheGrid_ForActivate_AfterCancel(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSubjectNameInTheGrid_ForActivate_AfterCancel Test===========");

			mastersubject.searchWithSubjectNameInTheGrid(subjectName);

			log.info("============= Finished tcSearchWithSubjectNameInTheGrid_ForActivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectNameInTheGrid_ForActivate_AfterCancel");
		}
	}

	@Test(priority = 50, dataProvider = "MasterSubjectSearchData")
	public void tcActivateMasterSubject_AfterCancel(String subjectName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterSubject_AfterCancel Test===========");

			mastersubject.activateMasterSubject(subjectName);
			log.info("============= Finished tcActivateMasterSubject_AfterCancel Test===========");
			getScreenShot("tcActivateMasterSubject_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterSubject_AfterCancel");
		}
	}

	@Test(priority = 51)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			mastersubject.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}
	@Test(priority = 52)
	public void tcPopWindowMessage_ActivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");

			mastersubject.popWindowMessage_ActivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		}
	}
	@Test(priority = 53)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			mastersubject.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
		}
	}

//	@Test(priority = 54)
//	public void tcClickOnSetOrder() {
//
//		try {
//			log.info("============= Strting tcClickOnSetOrder Test===========");
//
//			mastersubject.clickOnSetOrder();
//
//			log.info("============= Finished tcClickOnSetOrder Test===========");
//			getScreenShot("tcClickOnSetOrder");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSetOrder");
//		}
//	}
//
//	@Test(priority = 55)
//	public void tcSetSubjectOrder() {
//
//		try {
//			log.info("============= Strting tcSetSubjectOrder Test===========");
//
//			mastersubject.setSubjectOrder();
//
//			log.info("============= Finished tcSetSubjectOrder Test===========");
//			getScreenShot("tcSetSubjectOrder");
//		} catch (Exception e) {
//			getScreenShot("tcSetSubjectOrder");
//		}
//	}
//
//	@Test(priority = 56)
//	public void tcCloseSetSubjectOrderPopUpWindow() {
//
//		try {
//			log.info("============= Strting tcCloseSetSubjectOrderPopUpWindow Test===========");
//
//			mastersubject.closeSetSubjectOrderPopUpWindow();
//
//			log.info("============= Finished tcCloseSetSubjectOrderPopUpWindow Test===========");
//			getScreenShot("tcCloseSetSubjectOrderPopUpWindow");
//		} catch (Exception e) {
//			getScreenShot("tcCloseSetSubjectOrderPopUpWindow");
//		}
//	}
//
//	@Test(priority = 57)
//	public void tcClickOnSetOrder_AfterClose() {
//
//		try {
//			log.info("============= Strting tcClickOnSetOrder Test===========");
//
//			mastersubject.clickOnSetOrder();
//
//			log.info("============= Finished tcClickOnSetOrder Test===========");
//			getScreenShot("tcClickOnSetOrder");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSetOrder");
//		}
//	}
//
//	@Test(priority = 58)
//	public void tcSetSubjectOrder_AfterClose() {
//
//		try {
//			log.info("============= Strting tcSetSubjectOrder_AfterClose Test===========");
//
//			mastersubject.setSubjectOrder();
//
//			log.info("============= Finished tcSetSubjectOrder_AfterClose Test===========");
//			getScreenShot("tcSetSubjectOrder_AfterClose");
//		} catch (Exception e) {
//			getScreenShot("tcSetSubjectOrder_AfterClose");
//		}
//	}
//
//	@Test(priority = 59)
//	public void tcSaveSetSubjectOrderPopUpWindow() {
//
//		try {
//			log.info("============= Strting tcSaveSetSubjectOrderPopUpWindow Test===========");
//
//			mastersubject.saveSetSubjectOrderPopUpWindow();
//
//			log.info("============= Finished tcSaveSetSubjectOrderPopUpWindow Test===========");
//			getScreenShot("tcSaveSetSubjectOrderPopUpWindow");
//		} catch (Exception e) {
//			getScreenShot("tcSaveSetSubjectOrderPopUpWindow");
//		}
//	}

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
