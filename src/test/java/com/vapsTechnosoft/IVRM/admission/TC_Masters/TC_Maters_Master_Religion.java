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

import com.vapsTechnosoft.IVRM.Admission.Masters.Maters_Master_Religion;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Maters_Master_Religion extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Maters_Master_Religion.class.getName());

	Maters_Master_Religion master_religion;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterReligionData")
	public String[][] getTestData() {
		String[][] testRecordsCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterReligionInfoData");
		return testRecordsCategoryDetails;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		master_religion = new Maters_Master_Religion(driver);
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

			boolean status = master_religion.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterReligion_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterReligion_BGHS Test===========");

			master_religion.navigateToAdmission_Masters_MasterReligion_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterReligion_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterReligion_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterReligion_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterReligion_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterReligion_BGHSPage Test===========");

			boolean status = master_religion.verifyMasters_MasterReligion_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterReligion_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterReligion_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterReligion_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterReligionForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterReligionForm Test===========");

			master_religion.submitBlankMasterReligionForm();

			log.info("============= Finished tcSubmitBlankMasterReligionForm Test===========");
			getScreenShot("tcSubmitBlankMasterReligionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterReligionForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterReligionData")
	public void tcEnterMasterReligionFormData(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterReligionFormData Test===========");

			master_religion.enterMasterReligionFormData(religionName);

			log.info("============= Finished tcEnterMasterReligionFormData Test===========");
			getScreenShot("tcEnterMasterReligionFormData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterReligionFormData");
		}
	}

	@Test(priority = 7)
	public void tcClearReligionInfoData() {

		try {
			log.info("============= Strting tcClearReligionInfoData Test===========");

			master_religion.clearReligionInfoData();

			log.info("============= Finished tcClearReligionInfoData Test===========");
			getScreenShot("tcClearReligionInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearReligionInfoData");
		}
	}
	@Test(priority = 8)
	public void tcMinimizeMasterReligion() {

		try {
			log.info("============= Strting tcMinimizeMasterReligion Test===========");

			master_religion.minimizeMasterReligion();

			log.info("============= Finished tcMinimizeMasterReligion Test===========");
			getScreenShot("tcMinimizeMasterReligion");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterReligion");
		}
	}
	@Test(priority = 9)
	public void tcSortByReligionName() {

		try {
			log.info("============= Strting tcSortByReligionName Test===========");
			getScreenShot("tcSortByReligionName_BeforeSorting");

			master_religion.sortByReligionName();

			log.info("============= Finished tcSortByReligionName Test===========");
			getScreenShot("tcSortByReligionName");
		} catch (Exception e) {
			getScreenShot("tcSortByReligionName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterReligion() {

		try {
			log.info("============= Strting tcMaximizeMasterReligion Test===========");

			master_religion.maximizeMasterReligion();

			log.info("============= Finished tcMaximizeMasterReligion Test===========");
			getScreenShot("tcMaximizeMasterReligion");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterReligion");
		}
	}


	
	@Test(priority = 11)
	public void tcMinimizeMasterReligionList() {

		try {
			log.info("============= Strting tcMinimizeMasterReligionList Test===========");

			master_religion.minimizeMasterReligionList();

			log.info("============= Finished tcMinimizeMasterReligionList Test===========");
			getScreenShot("tcMinimizeMasterReligionList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterReligionList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterReligionList() {

		try {
			log.info("============= Strting tcMaximizeMasterReligionList Test===========");

			master_religion.maximizeMasterReligionList();

			log.info("============= Finished tcMaximizeMasterReligionList Test===========");
			getScreenShot("tcMaximizeMasterReligionList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterReligionList");
		}
	}
	
	
	@Test(priority = 13, dataProvider = "MastersMasterReligionData")
	public void tcEnterMasterReligionFormData_AfterClear(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterReligionFormData_AfterClear Test===========");

			master_religion.enterMasterReligionFormData(religionName);

			log.info("============= Finished tcEnterMasterReligionFormData_AfterClear Test===========");
			getScreenShot("tcEnterMasterReligionFormData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterReligionFormData_AfterClear");
		}
	}
	
	@Test(priority = 14)
	public void tcSubmitFilledMasterReligionForm() {

		try {
			log.info("============= Strting tcSubmitFilledMasterReligionForm Test===========");

			master_religion.submitFilledMasterReligionForm();

			log.info("============= Finished tcSubmitFilledMasterReligionForm Test===========");
			getScreenShot("tcSubmitFilledMasterReligionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterReligionForm");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	
	

	@Test(priority = 16, dataProvider = "MastersMasterReligionData")
	public void tcSearchWithReligionNameInTheGrid(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReligionNameInTheGrid Test===========");

			master_religion.searchWithReligionNameInTheGrid(religionName);

			log.info("============= Finished tcSearchWithReligionNameInTheGrid Test===========");
			getScreenShot("tcSearchWithReligionNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReligionNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MastersMasterReligionData")
	public void tcVerifyReligionNameInTheGrid(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyReligionNameInTheGrid Test===========");

			master_religion.verifyReligionNameInTheGrid(religionName);

			log.info("============= Finished tcVerifyReligionNameInTheGrid Test===========");
			getScreenShot("tcVerifyReligionNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyReligionNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MastersMasterReligionData")
	public void tcEditMasterReligion(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterReligion Test===========");

			master_religion.editMasterReligion(religionName);
			log.info("============= Finished tcEditMasterReligion Test===========");
			getScreenShot("tcEditMasterReligion");
		} catch (Exception e) {
			getScreenShot("tcEditMasterReligion");
		}
	}

	@Test(priority = 19)
	public void tcSubmitFilledMasterReligionForm_Edit() {

		try {
			log.info("============= Strting tcSubmitFilledMasterReligionForm_Edit Test===========");

			master_religion.submitFilledMasterReligionForm();

			log.info("============= Finished tcSubmitFilledMasterReligionForm_Edit Test===========");
			getScreenShot("tcSubmitFilledMasterReligionForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterReligionForm_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}
	
	//
	
	@Test(priority = 21, dataProvider = "MastersMasterReligionData")
	public void tcSearchWithReligionNameInTheGrid_ForDeactivate(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReligionNameInTheGrid_ForDeactivate Test===========");

			master_religion.searchWithReligionNameInTheGrid(religionName);

			log.info("============= Finished tcSearchWithReligionNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 22, dataProvider = "MastersMasterReligionData")
	public void tcDeactivateMasterReligion(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterReligion Test===========");

			master_religion.deactivateMasterReligion(religionName);

			log.info("============= Finished tcDeactivateMasterReligion Test===========");
			getScreenShot("tcDeactivateMasterReligion");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterReligion");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			master_religion.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 25, dataProvider = "MastersMasterReligionData")
	public void tcSearchWithReligionNameInTheGrid_ForDeactivate_AfterCancel(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReligionNameInTheGrid_ForDeactivate_AfterCancel Test===========");

			master_religion.searchWithReligionNameInTheGrid(religionName);

			log.info("============= Finished tcSearchWithReligionNameInTheGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 26, dataProvider = "MastersMasterReligionData")
	public void tcDeactivateMasterReligion_AfterCancel(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterReligion_AfterCancel Test===========");

			master_religion.deactivateMasterReligion(religionName);

			log.info("============= Finished tcDeactivateMasterReligion_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterReligion_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterReligion_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			master_religion.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 28)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}
	
	@Test(priority = 29, dataProvider = "MastersMasterReligionData")
	public void tcSearchWithReligionNameInTheGrid_ForActivate(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReligionNameInTheGrid_ForActivate Test===========");

			master_religion.searchWithReligionNameInTheGrid(religionName);

			log.info("============= Finished tcSearchWithReligionNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 30, dataProvider = "MastersMasterReligionData")
	public void tcActivateMasterReligion(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterReligion Test===========");

			master_religion.activateMasterReligion(religionName);

			log.info("============= Finished tcActivateMasterReligion Test===========");
			getScreenShot("tcActivateMasterReligion");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterReligion");
		}
	}

	@Test(priority = 31)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			master_religion.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 33, dataProvider = "MastersMasterReligionData")
	public void tcSearchWithReligionNameInTheGrid_ForActivate_AfterCancel(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReligionNameInTheGrid_ForActivate_AfterCancel Test===========");

			master_religion.searchWithReligionNameInTheGrid(religionName);

			log.info("============= Finished tcSearchWithReligionNameInTheGrid_ForActivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReligionNameInTheGrid_ForActivate_AfterCancel");
		}
	}

	@Test(priority = 34, dataProvider = "MastersMasterReligionData")
	public void tcActivateMasterReligion_AfterCancel(String religionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterReligion_AfterCancel Test===========");

			master_religion.activateMasterReligion(religionName);
			log.info("============= Finished tcActivateMasterReligion_AfterCancel Test===========");
			getScreenShot("tcActivateMasterReligion_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterReligion_AfterCancel");
		}
	}

	@Test(priority = 35)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			master_religion.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 36)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			master_religion.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
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
