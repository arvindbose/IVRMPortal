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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Source;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Source extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Master_Source.class.getName());

	Masters_Master_Source mastersource;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterSourceData")
	public String[][] getTestData() {
		String[][] testRecordsSourceDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterSourceInfoData");
		return testRecordsSourceDetails;
	}

	@DataProvider(name = "MasterSourceSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchBySourceNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastersource = new Masters_Master_Source(driver);
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

			boolean status = mastersource.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterSource_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterSource_BGHS Test===========");

			mastersource.navigateToAdmission_Masters_MasterSource_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterSource_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterSource_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterSource_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterSource_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterSource_BGHSPage Test===========");

			boolean status = mastersource.verifyMasters_MasterSource_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterSource_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterSource_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterSource_BGHSPage");
		}
	}
	
	
	@Test(priority = 5)
	public void tcSubmitBlankMasterSourceForm() {

		try {
			log.info("============= Starting tcSubmitBlankMasterSourceForm Test===========");

			mastersource.submitBlankMasterSourceForm();

			log.info("============= Finished tcSubmitBlankMasterSourceForm Test===========");
			getScreenShot("tcSubmitBlankMasterSourceForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterSourceForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterSourceData")
	public void tcEnterMasterSourceDetailsData(String sourceName, String sourceDiscription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSourceDetailsData Test===========");

			mastersource.enterMasterSourceDetailsData(sourceName, sourceDiscription);

			log.info("============= Finished tcEnterMasterSourceDetailsData Test===========");
			getScreenShot("tcEnterMasterSourceDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSourceDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearSourceInfoData() {

		try {
			log.info("============= Strting tcClearSourceInfoData Test===========");

			mastersource.clearSourceInfoData();

			log.info("============= Finished tcClearSourceInfoData Test===========");
			getScreenShot("tcClearSourceInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearSourceInfoData");
		}
	}
	
	
	

	@Test(priority = 8)
	public void tcMinimizeMasterSource() {

		try {
			log.info("============= Strting tcMinimizeMasterSource Test===========");

			mastersource.minimizeMasterSource();

			log.info("============= Finished tcMinimizeMasterSource Test===========");
			getScreenShot("tcMinimizeMasterSource");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSource");
		}
	}
	

	@Test(priority = 9)
	public void tcSortBySourceName() {

		try {
			log.info("============= Strting tcSortBySourceName Test===========");
			getScreenShot("tcSortBySourceName_BeforeSorting");

			mastersource.sortBySourceName();

			log.info("============= Finished tcSortBySourceName Test===========");
			getScreenShot("tcSortBySourceName");
		} catch (Exception e) {
			getScreenShot("tcSortBySourceName");
		}
	}
	

	@Test(priority = 10)
	public void tcMaximizeMasterSource() {

		try {
			log.info("============= Strting tcMaximizeMasterSource Test===========");

			mastersource.maximizeMasterSource();

			log.info("============= Finished tcMaximizeMasterSource Test===========");
			getScreenShot("tcMaximizeMasterSource");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSource");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeMasterSourceList() {

		try {
			log.info("============= Strting tcMinimizeMasterSourceList Test===========");

			mastersource.minimizeMasterSourceList();

			log.info("============= Finished tcMinimizeMasterSourceList Test===========");
			getScreenShot("tcMinimizeMasterSourceList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSourceList");
		}
	}
	

	@Test(priority = 12)
	public void tcMaximizeMasterSourceList() {

		try {
			log.info("============= Strting tcMaximizeMasterSourceList Test===========");

			mastersource.maximizeMasterSourceList();

			log.info("============= Finished tcMaximizeMasterSourceList Test===========");
			getScreenShot("tcMaximizeMasterSourceList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSourceList");
		}
	}

	@Test(priority = 13, dataProvider = "MastersMasterSourceData")
	public void tcEnterMasterSourceDetailsData_AfterClear(String sourceName, String sourceDiscription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSourceDetailsData_AfterClear Test===========");

			mastersource.enterMasterSourceDetailsData(sourceName, sourceDiscription);

			log.info("============= Finished tcEnterMasterSourceDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterSourceDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSourceDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveSourceInfoData() {

		try {
			log.info("============= Strting tcSaveSourceInfoData Test===========");

			mastersource.saveSourceInfoData();

			log.info("============= Finished tcSaveSourceInfoData Test===========");
			getScreenShot("tcSaveSourceInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveSourceInfoData");
		}
	}
	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			mastersource.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 16)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			mastersource.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	

	@Test(priority = 17, dataProvider = "MasterSourceSearchData")
	public void tcSearchWithSourceNameInTheGrid(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSourceNameInTheGrid Test===========");

			mastersource.searchWithSourceNameInTheGrid(sourceName);

			log.info("============= Finished tcSearchWithSourceNameInTheGrid Test===========");
			getScreenShot("tcSearchWithSourceNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSourceNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterSourceSearchData")
	public void tcVerifySourceNameInTheGrid(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifySourceNameInTheGrid Test===========");

			mastersource.verifySourceNameInTheGrid(sourceName);

			log.info("============= Finished tcVerifySourceNameInTheGrid Test===========");
			getScreenShot("tcVerifySourceNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifySourceNameInTheGrid");
		}
	}

	@Test(priority = 19, dataProvider = "MasterSourceSearchData")
	public void tcEditMasterSource(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterSource Test===========");

			mastersource.editMasterSource(sourceName);

			log.info("============= Finished tcEditMasterSource Test===========");
			getScreenShot("tcEditMasterSource");
		} catch (Exception e) {
			getScreenShot("tcEditMasterSource");
		}
	}

	@Test(priority = 20)
	public void tcSaveSourceInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveSourceInfoData_Edit Test===========");

			mastersource.saveSourceInfoData();

			log.info("============= Finished tcSaveSourceInfoData_Edit Test===========");
			getScreenShot("tcSaveSourceInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveSourceInfoData_Edit");
		}
	}
	@Test(priority = 21)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			mastersource.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}
	@Test(priority = 22)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			mastersource.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 23, dataProvider = "MasterSourceSearchData")
	public void tcSearchWithSourceNameInTheGrid_delete(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSourceNameInTheGrid_delete Test===========");

			mastersource.searchWithSourceNameInTheGrid(sourceName);

			log.info("============= Finished tcSearchWithSourceNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithSourceNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSourceNameInTheGrid_delete");
		}
	}

	@Test(priority = 24, dataProvider = "MasterSourceSearchData")
	public void tcDeleteMasterSource(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterSource Test===========");

			mastersource.deleteMasterSource(sourceName);

			log.info("============= Finished tcDeleteMasterSource Test===========");
			getScreenShot("tcDeleteMasterSource");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterSource");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			mastersource.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			mastersource.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 27, dataProvider = "MasterSourceSearchData")
	public void tcDeleteMasterSource_AfterCancel(String sourceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterSource_AfterCancel Test===========");

			mastersource.deleteMasterSource(sourceName);

			log.info("============= Finished tcDeleteMasterSource_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterSource_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterSource_AfterCancel");
		}
	}

	@Test(priority = 28)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastersource.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 29)
	public void tcPopWindowMessage_DeletedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeletedSuccessfully_Validation Test===========");

			mastersource.popWindowMessage_DeletedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_DeletedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeletedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeletedSuccessfully_Validation");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			mastersource.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 31, dataProvider = "MastersMasterSourceData")
	public void tcEnterMasterSourceDetailsData_AfterDelete(String sourceName, String sourceDiscription,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSourceDetailsData_AfterDelete Test===========");

			mastersource.enterMasterSourceDetailsData(sourceName, sourceDiscription);

			log.info("============= Finished tcEnterMasterSourceDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterSourceDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSourceDetailsData_AfterDelete");
		}
	}

	@Test(priority = 32)
	public void tcSaveSourceInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveSourceInfoData_AfterDelete Test===========");

			mastersource.saveSourceInfoData();

			log.info("============= Finished tcSaveSourceInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveSourceInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveSourceInfoData_AfterDelete");
		}
	}
	@Test(priority = 33)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");

			mastersource.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		}
	}
	@Test(priority = 34)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			mastersource.clickOnOkSuccessButton();

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
