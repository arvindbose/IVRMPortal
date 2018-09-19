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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Active_Deactive_Students;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Active_Deactive_Students extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Active_Deactive_Students.class.getName());

	Masters_Active_Deactive_Students active_deactivestudent;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Masters_ActDeactivateStudentData")
	public String[][] getTestData() {
		String[][] testRecordsActDeactivate = getData("BGHS_AdmissionData.xlsx", "BGHS_ActDeactiveStudentData");
		return testRecordsActDeactivate;
	}

	@DataProvider(name = "Search_DeactivateStudentData")
	public String[][] getDeactivateSearchData() {
		String[][] testRecordsDeactivateSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_DeactivateStudentData");
		return testRecordsDeactivateSearch;
	}

	@DataProvider(name = "Search_ActivateStudentData")
	public String[][] getTestActivateSearchData() {
		String[][] testRecordsActivateSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_ActivateStudentData");
		return testRecordsActivateSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		active_deactivestudent = new Masters_Active_Deactive_Students(driver);
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

			boolean status = active_deactivestudent.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_ActiveDeactiveStudent_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_ActiveDeactiveStudent_BGHS Test===========");

			active_deactivestudent.navigateToAdmission_Masters_ActiveDeactiveStudent_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_ActiveDeactiveStudent_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_ActiveDeactiveStudent_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_ActiveDeactiveStudent_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage Test===========");

			boolean status = active_deactivestudent.verifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmissionMasters_ActiveDeactiveStudent_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSelect_ActiveStudent_RadioButton() {

		try {
			log.info("============= Strting tcSelect_ActiveStudent_RadioButton Test===========");

			active_deactivestudent.select_ActiveStudent_RadioButton();

			log.info("============= Finished tcSelect_ActiveStudent_RadioButton Test===========");
			getScreenShot("tcSelect_ActiveStudent_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect_ActiveStudent_RadioButton");
		}
	}

	@Test(priority = 6, dataProvider = "Masters_ActDeactivateStudentData")
	public void tcFillActiveDeactiveStudentForm(String academicYear, String class_AD, String section, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillActiveDeactiveStudentForm Test===========");

			active_deactivestudent.fillActiveDeactiveStudentForm(academicYear, class_AD, section);

			log.info("============= Finished tcFillActiveDeactiveStudentForm Test===========");
			getScreenShot("tcFillActiveDeactiveStudentForm");
		} catch (Exception e) {
			getScreenShot("tcFillActiveDeactiveStudentForm");
		}
	}

	@Test(priority = 7)
	public void tcSubmitBlank_ActiveDeactiveStudentForm() {

		try {
			log.info("============= Strting tcSubmitBlank_ActiveDeactiveStudentForm Test===========");

			active_deactivestudent.submitBlank_ActiveDeactiveStudentForm();

			log.info("============= Finished tcSubmitBlank_ActiveDeactiveStudentForm Test===========");
			getScreenShot("tcSubmitBlank_ActiveDeactiveStudentForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_ActiveDeactiveStudentForm");
		}
	}

	@Test(priority = 8, dataProvider = "Search_DeactivateStudentData")
	public void tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid Test===========");

			active_deactivestudent.searchWithAdmissionNumber_ActivateDeactivateStudentListGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid");
		}
	}

	@Test(priority = 9, dataProvider = "Search_DeactivateStudentData")
	public void tcVerifyStudent_ForActiveDeactiveInGrid(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForActiveDeactiveInGrid Test===========");

			active_deactivestudent.verifyStudent_ForActiveDeactiveInGrid(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForActiveDeactiveInGrid Test===========");
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid");
		}
	}

	@Test(priority = 10, dataProvider = "Search_DeactivateStudentData")
	public void tcSelectStudentForActivateDeactivate(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForActiveDeactiveInGrid Test===========");

			active_deactivestudent.selectStudentForActivateDeactivate(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForActiveDeactiveInGrid Test===========");
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid");
		}
	}

	@Test(priority = 11)
	public void tcSelect_DeActivateStudent_checkBox() {

		try {
			log.info("============= Strting tcSelect_DeActivateStudent_checkBox Test===========");

			active_deactivestudent.select_DeActivateStudent_checkBox();

			log.info("============= Finished tcSelect_DeActivateStudent_checkBox Test===========");
			getScreenShot("tcSelect_DeActivateStudent_checkBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_DeActivateStudent_checkBox");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeActiveDeactiveStudent() {

		try {
			log.info("============= Strting tcMinimizeActiveDeactiveStudent Test===========");

			active_deactivestudent.minimizeActiveDeactiveStudent();

			log.info("============= Finished tcMinimizeActiveDeactiveStudent Test===========");
			getScreenShot("tcMinimizeActiveDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcMinimizeActiveDeactiveStudent");
		}
	}

	@Test(priority = 13)
	public void tcMinimizeActivateDeactivateStudent() {

		try {
			log.info("============= Strting tcMinimizeActivateDeactivateStudent Test===========");

			active_deactivestudent.minimizeActivateDeactivateStudent();

			log.info("============= Finished tcMinimizeActivateDeactivateStudent Test===========");
			getScreenShot("tcMinimizeActivateDeactivateStudent");
		} catch (Exception e) {
			getScreenShot("tcMinimizeActivateDeactivateStudent");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeActivateDeactivateStudent() {

		try {
			log.info("============= Strting tcMaximizeActivateDeactivateStudent Test===========");

			active_deactivestudent.maximizeActivateDeactivateStudent();

			log.info("============= Finished tcMaximizeActivateDeactivateStudent Test===========");
			getScreenShot("tcMaximizeActivateDeactivateStudent");
		} catch (Exception e) {
			getScreenShot("tcMaximizeActivateDeactivateStudent");
		}
	}

	@Test(priority = 15)
	public void tcMaximizeActiveDeactiveStudent() {

		try {
			log.info("============= Strting tcMaximizeActiveDeactiveStudent Test===========");

			active_deactivestudent.maximizeActiveDeactiveStudent();

			log.info("============= Finished tcMaximizeActiveDeactiveStudent Test===========");
			getScreenShot("tcMaximizeActiveDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcMaximizeActiveDeactiveStudent");
		}
	}

	@Test(priority = 16)
	public void tcClearFilledActiveDeactiveStudentForm() {

		try {
			log.info("============= Strting tcClearFilledActiveDeactiveStudentForm Test===========");

			active_deactivestudent.clearFilledActiveDeactiveStudentForm();

			log.info("============= Finished tcClearFilledActiveDeactiveStudentForm Test===========");
			getScreenShot("tcClearFilledActiveDeactiveStudentForm");
		} catch (Exception e) {
			getScreenShot("tcClearFilledActiveDeactiveStudentForm");
		}
	}

	@Test(priority = 17)
	public void tcSelect_ActiveStudent_RadioButton_ToDeactivate() {

		try {
			log.info("============= Strting tcSelect_ActiveStudent_RadioButton_ToDeactivate Test===========");

			active_deactivestudent.select_ActiveStudent_RadioButton();

			log.info("============= Finished tcSelect_ActiveStudent_RadioButton_ToDeactivate Test===========");
			getScreenShot("tcSelect_ActiveStudent_RadioButton_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSelect_ActiveStudent_RadioButton_ToDeactivate");
		}
	}

	@Test(priority = 18, dataProvider = "Masters_ActDeactivateStudentData")
	public void tcFillActiveDeactiveStudentForm_ToDeactivate(String academicYear, String class_AD, String section,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillActiveDeactiveStudentForm_ToDeactivate Test===========");

			active_deactivestudent.fillActiveDeactiveStudentForm(academicYear, class_AD, section);

			log.info("============= Finished tcFillActiveDeactiveStudentForm_ToDeactivate Test===========");
			getScreenShot("tcFillActiveDeactiveStudentForm_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcFillActiveDeactiveStudentForm_ToDeactivate");
		}
	}

	@Test(priority = 19, dataProvider = "Search_DeactivateStudentData")
	public void tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToDeactivate(String admissionNum,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToDeactivate Test===========");

			active_deactivestudent.searchWithAdmissionNumber_ActivateDeactivateStudentListGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToDeactivate Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToDeactivate");
		}
	}

	@Test(priority = 20, dataProvider = "Search_DeactivateStudentData")
	public void tcVerifyStudent_ForActiveDeactiveInGrid_ToDeactivate(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForActiveDeactiveInGrid_ToDeactivate Test===========");

			active_deactivestudent.verifyStudent_ForActiveDeactiveInGrid(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForActiveDeactiveInGrid_ToDeactivate Test===========");
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid_ToDeactivate");
		}
	}

	@Test(priority = 21, dataProvider = "Search_DeactivateStudentData")
	public void tcSelectStudentForActivateDeactivate_ToDeactivate(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForActivateDeactivate_ToDeactivate Test===========");

			active_deactivestudent.selectStudentForActivateDeactivate(admissionNum);

			log.info("============= Finished tcSelectStudentForActivateDeactivate_ToDeactivate Test===========");
			getScreenShot("tcSelectStudentForActivateDeactivate_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForActivateDeactivate_ToDeactivate");
		}
	}

	@Test(priority = 22)
	public void tcSelect_DeActivateStudent_checkBox_ToDeactivate() {

		try {
			log.info("============= Strting tcSelect_DeActivateStudent_checkBox_ToDeactivate Test===========");

			active_deactivestudent.select_DeActivateStudent_checkBox();

			log.info("============= Finished tcSelect_DeActivateStudent_checkBox_ToDeactivate Test===========");
			getScreenShot("tcSelect_DeActivateStudent_checkBox_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSelect_DeActivateStudent_checkBox_ToDeactivate");
		}
	}

	@Test(priority = 23)
	public void tcSaveFilledActiveDeactiveStudentForm_ToDeactivate() {

		try {
			log.info("============= Strting tcSaveFilledActiveDeactiveStudentForm_ToDeactivate Test===========");

			active_deactivestudent.saveFilledActiveDeactiveStudentForm();

			log.info("============= Finished tcSaveFilledActiveDeactiveStudentForm_ToDeactivate Test===========");
			getScreenShot("tcSaveFilledActiveDeactiveStudentForm_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledActiveDeactiveStudentForm_ToDeactivate");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_ToDeactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ToDeactivate Test===========");

			active_deactivestudent.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToDeactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToDeactivate");
		}
	}

	@Test(priority = 25)
	public void tcSelect_DeActiveStudent_RadioButton_ToActivate() {

		try {
			log.info("============= Strting tcSelect_DeActiveStudent_RadioButton_ToActivate Test===========");

			active_deactivestudent.select_DeActiveStudent_RadioButton();

			log.info("============= Finished tcSelect_DeActiveStudent_RadioButton_ToActivate Test===========");
			getScreenShot("tcSelect_DeActiveStudent_RadioButton_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSelect_DeActiveStudent_RadioButton_ToActivate");
		}
	}

	@Test(priority = 26, dataProvider = "Masters_ActDeactivateStudentData")
	public void tcFillActiveDeactiveStudentForm_ToActivate(String academicYear, String class_AD, String section,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillActiveDeactiveStudentForm_ToActivate Test===========");

			active_deactivestudent.fillActiveDeactiveStudentForm(academicYear, class_AD, section);

			log.info("============= Finished tcFillActiveDeactiveStudentForm_ToActivate Test===========");
			getScreenShot("tcFillActiveDeactiveStudentForm_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcFillActiveDeactiveStudentForm_ToActivate");
		}
	}

	@Test(priority = 27, dataProvider = "Search_ActivateStudentData")
	public void tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToActivate(String admissionNum,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToActivate Test===========");

			active_deactivestudent.searchWithAdmissionNumber_ActivateDeactivateStudentListGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToActivate Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_ActivateDeactivateStudentListGrid_ToActivate");
		}
	}

	@Test(priority = 28, dataProvider = "Search_ActivateStudentData")
	public void tcVerifyStudent_ForActiveDeactiveInGrid_ToActivate(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForActiveDeactiveInGrid_ToActivate Test===========");

			active_deactivestudent.verifyStudent_ForActiveDeactiveInGrid(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForActiveDeactiveInGrid_ToActivate Test===========");
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForActiveDeactiveInGrid_ToActivate");
		}
	}

	@Test(priority = 29, dataProvider = "Search_ActivateStudentData")
	public void tcSelectStudentForActivateDeactivate_ToActivate(String admissionNum, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForActivateDeactivate_ToActivate Test===========");

			active_deactivestudent.selectStudentForActivateDeactivate(admissionNum);

			log.info("============= Finished tcSelectStudentForActivateDeactivate_ToActivate Test===========");
			getScreenShot("tcSelectStudentForActivateDeactivate_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForActivateDeactivate_ToActivate");
		}
	}

	@Test(priority = 30)
	public void tcSelect_ActivateStudent_checkBox_ToActivate() {

		try {
			log.info("============= Strting tcSelect_ActivateStudent_checkBox_ToActivate Test===========");

			active_deactivestudent.select_ActivateStudent_checkBox();

			log.info("============= Finished tcSelect_ActivateStudent_checkBox_ToActivate Test===========");
			getScreenShot("tcSelect_ActivateStudent_checkBox_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSelect_ActivateStudent_checkBox_ToActivate");
		}
	}

	@Test(priority = 31)
	public void tcSaveFilledActiveDeactiveStudentForm_ToActivate() {

		try {
			log.info("============= Strting tcSaveFilledActiveDeactiveStudentForm_ToActivate Test===========");

			active_deactivestudent.saveFilledActiveDeactiveStudentForm();

			log.info("============= Finished tcSaveFilledActiveDeactiveStudentForm_ToActivate Test===========");
			getScreenShot("tcSaveFilledActiveDeactiveStudentForm_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledActiveDeactiveStudentForm_ToActivate");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_ToActivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ToActivate Test===========");

			active_deactivestudent.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToActivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToActivate");
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
