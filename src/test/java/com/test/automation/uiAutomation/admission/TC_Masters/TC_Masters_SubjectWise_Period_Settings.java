/**
 * 
 */
package com.test.automation.uiAutomation.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Admission.Masters.Masters_SubjectWise_Period_Settings;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_SubjectWise_Period_Settings extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_SubjectWise_Period_Settings.class.getName());

	Masters_SubjectWise_Period_Settings subjectwiseperiod;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersSubjectWisePeriodData")
	public String[][] getTestSubjectWisePeriodData() {
		String[][] testRecords_SubjectWisePeriod = getData("BGHS_AdmissionData.xlsx", "BGHS_SubjectWisePeriodData");
		return testRecords_SubjectWisePeriod;
	}

	@DataProvider(name = "MastersMax_PeriodData")
	public String[][] getTestPeriodData() {
		String[][] testRecords_SubjectWisePeriod = getData("BGHS_AdmissionData.xlsx", "BGHS_Subject_PeriodData");
		return testRecords_SubjectWisePeriod;
	}

	@DataProvider(name = "MastersSearchData")
	public String[][] getTestData() {
		String[][] testRecordsSubjectWisePeriod = getData("BGHS_AdmissionData.xlsx", "BGHS_SWPS_SearchData");
		return testRecordsSubjectWisePeriod;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		subjectwiseperiod = new Masters_SubjectWise_Period_Settings(driver);
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

			boolean status = subjectwiseperiod.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS Test===========");

			subjectwiseperiod.navigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_SubjectWisePeriodSettings_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_SubjectWisePeriodSettings_BGHSPage Test===========");

			boolean status = subjectwiseperiod.verifyMasters_SubjectWisePeriodSettings_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_SubjectWisePeriodSettings_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_SubjectWisePeriodSettings_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_SubjectWisePeriodSettings_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankSubjectWisePeriodSettingsForm() {

		try {
			log.info("============= Strting tcSubmitBlankSubjectWisePeriodSettingsForm Test===========");

			subjectwiseperiod.submitBlankSubjectWisePeriodSettingsForm();

			log.info("============= Finished tcSubmitBlankSubjectWisePeriodSettingsForm Test===========");
			getScreenShot("tcSubmitBlankSubjectWisePeriodSettingsForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankSubjectWisePeriodSettingsForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersSubjectWisePeriodData")
	public void tcEnterSubjectWisePeriodSettingsData(String academicYear, String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWisePeriodSettingsData Test===========");

			subjectwiseperiod.enterSubjectWisePeriodSettingsData(academicYear, className);

			log.info("============= Finished tcEnterSubjectWisePeriodSettingsData Test===========");
			getScreenShot("tcEnterSubjectWisePeriodSettingsData");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWisePeriodSettingsData");
		}
	}

	@Test(priority = 7, dataProvider = "MastersSearchData")
	public void tcSearchWithSujectCodeToUpdateMaxPeriod(String subjectCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");

			subjectwiseperiod.searchWithSujectCodeToUpdateMaxPeriod(subjectCode);

			log.info("============= Finished tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
		}
	}

	@Test(priority = 8, dataProvider = "MastersMax_PeriodData")
	public void tcUpdateWithMaxPeriodForSpecificSubjectData(String maxPeriod, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateWithMaxPeriodForSpecificSubjectData Test===========");

			subjectwiseperiod.updateWithMaxPeriodForSpecificSubjectData(maxPeriod);

			log.info("============= Finished tcUpdateWithMaxPeriodForSpecificSubjectData Test===========");
			getScreenShot("tcUpdateWithMaxPeriodForSpecificSubjectData");
		} catch (Exception e) {
			getScreenShot("tcUpdateWithMaxPeriodForSpecificSubjectData");
		}
	}

	@Test(priority = 9)
	public void tcClearSubjectWisePeriodSettingsInfoData() {

		try {
			log.info("============= Strting tcClearSubjectWisePeriodSettingsInfoData Test===========");

			subjectwiseperiod.clearSubjectWisePeriodSettingsInfoData();

			log.info("============= Finished tcClearSubjectWisePeriodSettingsInfoData Test===========");
			getScreenShot("tcClearSubjectWisePeriodSettingsInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearSubjectWisePeriodSettingsInfoData");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeSubjectPeriodSetting() {

		try {
			log.info("============= Strting tcMinimizeSubjectPeriodSetting Test===========");

			subjectwiseperiod.minimizeSubjectPeriodSetting();

			log.info("============= Finished tcMinimizeSubjectPeriodSetting Test===========");
			getScreenShot("tcMinimizeSubjectPeriodSetting");
		} catch (Exception e) {
			getScreenShot("tcMinimizeSubjectPeriodSetting");
		}
	}

	@Test(priority = 11)
	public void tcSortBySubjectName() {

		try {
			log.info("============= Strting tcSortBySubjectName Test===========");
			getScreenShot("tcSortBySubjectName");

			subjectwiseperiod.sortBySubjectName();

			log.info("============= Finished tcSortBySubjectName Test===========");
			getScreenShot("tcSortBySubjectName");
		} catch (Exception e) {
			getScreenShot("tcSortBySubjectName");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeSubjectPeriodSetting() {

		try {
			log.info("============= Strting tcMaximizeSubjectPeriodSetting Test===========");

			subjectwiseperiod.maximizeSubjectPeriodSetting();

			log.info("============= Finished tcMaximizeSubjectPeriodSetting Test===========");
			getScreenShot("tcMaximizeSubjectPeriodSetting");
		} catch (Exception e) {
			getScreenShot("tcMaximizeSubjectPeriodSetting");
		}
	}

	@Test(priority = 13)
	public void tcMinimizeSubjectPeriodSettingDetails() {

		try {
			log.info("============= Strting tcMinimizeSubjectPeriodSettingDetails Test===========");

			subjectwiseperiod.minimizeSubjectPeriodSettingDetails();

			log.info("============= Finished tcMinimizeSubjectPeriodSettingDetails Test===========");
			getScreenShot("tcMinimizeSubjectPeriodSettingDetails");
		} catch (Exception e) {
			getScreenShot("tcMinimizeSubjectPeriodSettingDetails");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeSubjectPeriodSettingDetails() {

		try {
			log.info("============= Strting tcMaximizeSubjectPeriodSettingDetails Test===========");

			subjectwiseperiod.maximizeSubjectPeriodSettingDetails();

			log.info("============= Finished tcMaximizeSubjectPeriodSettingDetails Test===========");
			getScreenShot("tcMaximizeSubjectPeriodSettingDetails");
		} catch (Exception e) {
			getScreenShot("tcMaximizeSubjectPeriodSettingDetails");
		}
	}

	@Test(priority = 15, dataProvider = "MastersSubjectWisePeriodData")
	public void tcEnterSubjectWisePeriodSettingsData_AfterClear(String academicYear, String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWisePeriodSettingsData_AfterClear Test===========");

			subjectwiseperiod.enterSubjectWisePeriodSettingsData(academicYear, className);

			log.info("============= Finished tcEnterSubjectWisePeriodSettingsData_AfterClear Test===========");
			getScreenShot("tcEnterSubjectWisePeriodSettingsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWisePeriodSettingsData_AfterClear");
		}
	}

	@Test(priority = 16, dataProvider = "MastersSearchData")
	public void tcSearchWithSujectCodeToUpdateMaxPeriod_AfterClear(String subjectCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");

			subjectwiseperiod.searchWithSujectCodeToUpdateMaxPeriod(subjectCode);

			log.info("============= Finished tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
		}
	}

	@Test(priority = 17, dataProvider = "MastersMax_PeriodData")
	public void tcUpdateWithMaxPeriodForSpecificSubjectData_AfterClear(String maxPeriod, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateWithMaxPeriodForSpecificSubjectData_AfterClear Test===========");

			subjectwiseperiod.updateWithMaxPeriodForSpecificSubjectData(maxPeriod);

			log.info("============= Finished tcUpdateWithMaxPeriodForSpecificSubjectData_AfterClear Test===========");
			getScreenShot("tcUpdateWithMaxPeriodForSpecificSubjectData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUpdateWithMaxPeriodForSpecificSubjectData_AfterClear");
		}
	}

	@Test(priority = 18)
	public void tcSubmitFilledSubjectWisePeriodSettingsForm() {

		try {
			log.info("============= Strting tcSubmitFilledSubjectWisePeriodSettingsForm Test===========");

			subjectwiseperiod.submitFilledSubjectWisePeriodSettingsForm();

			log.info("============= Finished tcSubmitFilledSubjectWisePeriodSettingsForm Test===========");
			getScreenShot("tcSubmitFilledSubjectWisePeriodSettingsForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledSubjectWisePeriodSettingsForm");
		}
	}

	@Test(priority = 19)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			subjectwiseperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 20, dataProvider = "MastersSearchData")
	public void tcSearchWithSujectCodeToUpdateMaxPeriod_ForValidation(String subjectCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");

			subjectwiseperiod.searchWithSujectCodeToUpdateMaxPeriod(subjectCode);

			log.info("============= Finished tcSearchWithSujectCodeToUpdateMaxPeriod Test===========");
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSujectCodeToUpdateMaxPeriod");
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
