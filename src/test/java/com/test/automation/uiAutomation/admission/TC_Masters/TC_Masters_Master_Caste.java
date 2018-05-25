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

import com.test.automation.uiAutomation.Admission.Masters.Masters_Master_Caste;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Caste extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Caste.class.getName());

	Masters_Master_Caste mastercaste;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersCasteData")
	public String[][] getTestData() {
		String[][] testRecordsCasteDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterCasteInfoData");
		return testRecordsCasteDetails;
	}

	@DataProvider(name = "MasterCasteSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByCasteName");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastercaste = new Masters_Master_Caste(driver);
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

			boolean status = mastercaste.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterCaste_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterCaste_BGHS Test===========");

			mastercaste.navigateToAdmission_Masters_MasterCaste_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterCaste_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterCaste_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterCaste_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterCaste_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterCaste_BGHSPage Test===========");

			boolean status = mastercaste.verifyMasters_MasterCaste_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterCaste_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterCaste_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterCaste_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterCasteForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterCasteForm Test===========");

			mastercaste.submitBlankMasterCasteForm();

			log.info("============= Finished tcSubmitBlankMasterCasteForm Test===========");
			getScreenShot("tcSubmitBlankMasterCasteForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterCasteForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersCasteData")
	public void tcEnterMasterCasteDetailsData(String casteName, String casteDescription, String casteCategory,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteDetailsData Test===========");

			mastercaste.enterMasterCasteDetailsData(casteName, casteDescription, casteCategory);

			log.info("============= Finished tcEnterMasterCasteDetailsData Test===========");
			getScreenShot("tcEnterMasterCasteDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearMasterCasteInfoData() {

		try {
			log.info("============= Strting tcClearMasterCasteInfoData Test===========");

			mastercaste.clearMasterCasteInfoData();

			log.info("============= Finished tcClearMasterCasteInfoData Test===========");
			getScreenShot("tcClearMasterCasteInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearMasterCasteInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterCaste() {

		try {
			log.info("============= Strting tcMinimizeMasterCaste Test===========");

			mastercaste.minimizeMasterCaste();

			log.info("============= Finished tcMinimizeMasterCaste Test===========");
			getScreenShot("tcMinimizeMasterCaste");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterCaste");
		}
	}

	@Test(priority = 9)
	public void tcSortByCasteName() {

		try {
			log.info("============= Strting tcSortByCasteName Test===========");
			getScreenShot("tcSortByCasteName_BeforeSorting");

			mastercaste.sortByCasteName();

			log.info("============= Finished tcSortByCasteName Test===========");
			getScreenShot("tcSortByCasteName");
		} catch (Exception e) {
			getScreenShot("tcSortByCasteName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterCaste() {

		try {
			log.info("============= Strting tcMaximizeMasterCaste Test===========");

			mastercaste.maximizeMasterCaste();

			log.info("============= Finished tcMaximizeMasterCaste Test===========");
			getScreenShot("tcMaximizeMasterCaste");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterCaste");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeCreatedCasteList() {

		try {
			log.info("============= Strting tcMinimizeCreatedCasteList Test===========");

			mastercaste.minimizeCreatedCasteList();

			log.info("============= Finished tcMinimizeCreatedCasteList Test===========");
			getScreenShot("tcMinimizeCreatedCasteList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeCreatedCasteList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeCreatedCasteList() {

		try {
			log.info("============= Strting tcMaximizeCreatedCasteList Test===========");

			mastercaste.maximizeCreatedCasteList();

			log.info("============= Finished tcMaximizeCreatedCasteList Test===========");
			getScreenShot("tcMaximizeCreatedCasteList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeCreatedCasteList");
		}
	}

	@Test(priority = 13, dataProvider = "MastersCasteData")
	public void tcEnterMasterCasteDetailsData_AfterClear(String casteName,
			String casteDescription,String casteCategory, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteDetailsData_AfterClear Test===========");

			mastercaste.enterMasterCasteDetailsData(casteName, casteDescription, casteCategory);

			log.info("============= Finished tcEnterMasterCasteDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterCasteDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveMasterCasteInfoData() {

		try {
			log.info("============= Strting tcSaveMasterCasteInfoData Test===========");

			mastercaste.saveMasterCasteInfoData();

			log.info("============= Finished tcSaveMasterCasteInfoData Test===========");
			getScreenShot("tcSaveMasterCasteInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterCasteInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			mastercaste.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 16, dataProvider = "MasterCasteSearchData")
	public void tcSearchWithCasteNameInTheGrid(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCasteNameInTheGrid Test===========");

			mastercaste.searchWithCasteNameInTheGrid(casteName);

			log.info("============= Finished tcSearchWithCasteNameInTheGrid Test===========");
			getScreenShot("tcSearchWithCasteNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCasteNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MasterCasteSearchData")
	public void tcVerifyCasteNameInTheGrid(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCasteNameInTheGrid Test===========");

			mastercaste.verifyCasteNameInTheGrid(casteName);

			log.info("============= Finished tcVerifyCasteNameInTheGrid Test===========");
			getScreenShot("tcVerifyCasteNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCasteNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterCasteSearchData")
	public void tcEditMasterCaste(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterCaste Test===========");

			mastercaste.editMasterCaste(casteName);

			log.info("============= Finished tcEditMasterCaste Test===========");
			getScreenShot("tcEditMasterCaste");
		} catch (Exception e) {
			getScreenShot("tcEditMasterCaste");
		}
	}

	@Test(priority = 19)
	public void tcSaveMasterCasteInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveMasterCasteInfoData_Edit Test===========");

			mastercaste.saveMasterCasteInfoData();

			log.info("============= Finished tcSaveMasterCasteInfoData_Edit Test===========");
			getScreenShot("tcSaveMasterCasteInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterCasteInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			mastercaste.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 21, dataProvider = "MasterCasteSearchData")
	public void tcSearchWithCasteNameInTheGrid_delete(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCasteNameInTheGrid_delete Test===========");

			mastercaste.searchWithCasteNameInTheGrid(casteName);

			log.info("============= Finished tcSearchWithCasteNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithCasteNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCasteNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "MasterCasteSearchData")
	public void tcDeleteMasterCaste(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterCaste Test===========");

			mastercaste.deleteMasterCaste(casteName);

			log.info("============= Finished tcDeleteMasterCaste Test===========");
			getScreenShot("tcDeleteMasterCaste");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterCaste");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			mastercaste.clickOnCancelButton();

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

			mastercaste.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 25, dataProvider = "MasterCasteSearchData")
	public void tcDeleteMasterCaste_AfterCancel(String casteName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterCaste_AfterCancel Test===========");

			mastercaste.deleteMasterCaste(casteName);

			log.info("============= Finished tcDeleteMasterCaste_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterCaste_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterCaste_AfterCancel");
		}
	}

	@Test(priority = 26)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastercaste.yesDeleteOrDeactivateOrActivateIt();

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

			mastercaste.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 28, dataProvider = "MastersCasteData")
	public void tcEnterMasterCasteDetailsData_AfterDelete(String casteName,
			String casteDescription,String casteCategory, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteDetailsData_AfterDelete Test===========");

			mastercaste.enterMasterCasteDetailsData(casteName, casteDescription, casteCategory);
			log.info("============= Finished tcEnterMasterCasteDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterCasteDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteDetailsData_AfterDelete");
		}
	}

	@Test(priority = 29)
	public void tcSaveMasterCasteInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveMasterCasteInfoData_AfterDelete Test===========");

			mastercaste.saveMasterCasteInfoData();

			log.info("============= Finished tcSaveMasterCasteInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveMasterCasteInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveMasterCasteInfoData_AfterDelete");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			mastercaste.clickOnOkSuccessButton();

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
