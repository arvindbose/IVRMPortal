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

import com.test.automation.uiAutomation.Admission.Masters.Masters_Master_Activities;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Activities extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Activities.class.getName());

	Masters_Master_Activities masteractivities;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MasterActivitiesData")
	public String[][] getTestData() {
		String[][] testRecordsCasteCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterActivityInfoData");
		return testRecordsCasteCategoryDetails;
	}

	@DataProvider(name = "MasterActivitiesSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByActivityName");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masteractivities = new Masters_Master_Activities(driver);
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

			boolean status = masteractivities.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterActivities_BGHS() {

		try {
			log.info("============= Starting tcNavigateToAdmission_Masters_MasterActivities_BGHS Test===========");

			masteractivities.navigateToAdmission_Masters_MasterActivities_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterActivities_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterActivities_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterActivities_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterActivities_BGHSPage() {

		try {
			log.info("============= Starting tcVerifyMasters_MasterActivities_BGHSPage Test===========");

			boolean status = masteractivities.verifyMasters_MasterActivities_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterActivities_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterActivities_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterActivities_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterActivitiesForm() {

		try {
			log.info("============= Starting tcSubmitBlankMasterActivitiesForm Test===========");

			masteractivities.submitBlankMasterActivitiesForm();

			log.info("============= Finished tcSubmitBlankMasterActivitiesForm Test===========");
			getScreenShot("tcSubmitBlankMasterActivitiesForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterActivitiesForm");
		}
	}

	@Test(priority = 6, dataProvider = "MasterActivitiesData")
	public void tcEnterMasterActivitiesDetailsData(String activityName, String activityDescription,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterMasterActivitiesDetailsData Test===========");

			masteractivities.enterMasterActivitiesDetailsData(activityName, activityDescription);

			log.info("============= Finished tcEnterMasterActivitiesDetailsData Test===========");
			getScreenShot("tcEnterMasterActivitiesDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterActivitiesDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearMasterActivitiesInfoData() {

		try {
			log.info("============= Starting tcClearMasterActivitiesInfoData Test===========");

			masteractivities.clearMasterActivitiesInfoData();

			log.info("============= Finished tcClearMasterActivitiesInfoData Test===========");
			getScreenShot("tcClearMasterActivitiesInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearMasterActivitiesInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterActivities() {

		try {
			log.info("============= Starting tcMinimizeMasterActivities Test===========");

			masteractivities.minimizeMasterActivities();

			log.info("============= Finished tcMinimizeMasterActivities Test===========");
			getScreenShot("tcMinimizeMasterActivities");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterActivities");
		}
	}

	@Test(priority = 9)
	public void tcSortByActivityName() {

		try {
			log.info("============= Starting tcSortByActivityName Test===========");
			getScreenShot("tcSortByActivityName_BeforeSorting");

			masteractivities.sortByActivityName();

			log.info("============= Finished tcSortByActivityName Test===========");
			getScreenShot("tcSortByActivityName");
		} catch (Exception e) {
			getScreenShot("tcSortByActivityName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterActivities() {

		try {
			log.info("============= Strting tcMaximizeMasterActivities Test===========");

			masteractivities.maximizeMasterActivities();

			log.info("============= Finished tcMaximizeMasterActivities Test===========");
			getScreenShot("tcMaximizeMasterActivities");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterActivities");
		}
	}
	

	@Test(priority = 11)
	public void tcMinimizeMasterActivitiesList() {

		try {
			log.info("============= Strting tcMinimizeMasterActivitiesList Test===========");

			masteractivities.minimizeMasterActivitiesList();

			log.info("============= Finished tcMinimizeMasterActivitiesList Test===========");
			getScreenShot("tcMinimizeMasterActivitiesList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterActivitiesList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterActivitiesList() {

		try {
			log.info("============= Starting tcMaximizeMasterActivitiesList Test===========");

			masteractivities.maximizeMasterActivitiesList();

			log.info("============= Finished tcMaximizeMasterActivitiesList Test===========");
			getScreenShot("tcMaximizeMasterActivitiesList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterActivitiesList");
		}
	}

	@Test(priority = 13, dataProvider = "MasterActivitiesData")
	public void tcEnterMasterActivitiesDetailsData_AfterClear(String activityName,
			String activityDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEnterMasterActivitiesDetailsData_AfterClear Test===========");

			masteractivities.enterMasterActivitiesDetailsData(activityName, activityDescription);

			log.info("============= Finished tcEnterMasterActivitiesDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterGovernmentBondDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterActivitiesDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveMasterActivitiesInfoData() {

		try {
			log.info("============= Strting tcSaveMasterActivitiesInfoData Test===========");

			masteractivities.saveMasterActivitiesInfoData();

			log.info("============= Finished tcSaveMasterActivitiesInfoData Test===========");
			getScreenShot("tcSaveMasterActivitiesInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterActivitiesInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masteractivities.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 16, dataProvider = "MasterActivitiesSearchData")
	public void tcSearchWithMasterActivitiesNameInTheGrid(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithMasterActivitiesNameInTheGrid Test===========");

			masteractivities.searchWithMasterActivitiesNameInTheGrid(activityName);

			log.info("============= Finished tcSearchWithMasterActivitiesNameInTheGrid Test===========");
			getScreenShot("tcSearchWithMasterActivitiesNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithMasterActivitiesNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MasterActivitiesSearchData")
	public void tcVerifyMasterActivitiesInTheGrid(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterActivitiesInTheGrid Test===========");

			masteractivities.verifyMasterActivitiesInTheGrid(activityName);

			log.info("============= Finished tcVerifyMasterActivitiesInTheGrid Test===========");
			getScreenShot("tcVerifyMasterActivitiesInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterActivitiesInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterActivitiesSearchData")
	public void tcEditMasterActivities(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterActivities Test===========");

			masteractivities.editMasterActivities(activityName);

			log.info("============= Finished tcEditMasterActivities Test===========");
			getScreenShot("tcEditMasterActivities");
		} catch (Exception e) {
			getScreenShot("tcEditMasterActivities");
		}
	}

	@Test(priority = 19)
	public void tcSaveMasterActivitiesInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveMasterActivitiesInfoData_Edit Test===========");

			masteractivities.saveMasterActivitiesInfoData();

			log.info("============= Finished tcSaveMasterActivitiesInfoData_Edit Test===========");
			getScreenShot("tcSaveMasterActivitiesInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterActivitiesInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masteractivities.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 21, dataProvider = "MasterActivitiesSearchData")
	public void tcSearchWithMasterActivitiesNameInTheGrid_delete(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithMasterActivitiesNameInTheGrid_delete Test===========");

			masteractivities.searchWithMasterActivitiesNameInTheGrid(activityName);

			log.info("============= Finished tcSearchWithMasterActivitiesNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithMasterActivitiesNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithMasterActivitiesNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "MasterActivitiesSearchData")
	public void tcDeleteMasterActivities(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterActivities Test===========");

			masteractivities.deleteMasterActivities(activityName);

			log.info("============= Finished tcDeleteMasterActivities Test===========");
			getScreenShot("tcDeleteMasterActivities");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterActivities");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			masteractivities.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			masteractivities.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 25, dataProvider = "MasterActivitiesSearchData")
	public void tcDeleteMasterActivities_AfterCancel(String activityName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterActivities_AfterCancel Test===========");

			masteractivities.deleteMasterActivities(activityName);

			log.info("============= Finished tcDeleteMasterActivities_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterActivities_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterActivities_AfterCancel");
		}
	}

	@Test(priority = 26)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masteractivities.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			masteractivities.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 28, dataProvider = "MasterActivitiesData")
	public void tcEnterMasterActivitiesDetailsData_AfterDelete(String activityName,
			String activityDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterActivitiesDetailsData_AfterDelete Test===========");

			masteractivities.enterMasterActivitiesDetailsData(activityName, activityDescription);

			log.info("============= Finished tcEnterMasterActivitiesDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterActivitiesDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterActivitiesDetailsData_AfterDelete");
		}
	}

	@Test(priority = 29)
	public void tcSaveMasterActivitiesInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveMasterActivitiesInfoData_AfterDelete Test===========");

			masteractivities.saveMasterActivitiesInfoData();

			log.info("============= Finished tcSaveMasterActivitiesInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveMasterActivitiesInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterActivitiesInfoData_AfterDelete");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			masteractivities.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_AfterDelete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
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
