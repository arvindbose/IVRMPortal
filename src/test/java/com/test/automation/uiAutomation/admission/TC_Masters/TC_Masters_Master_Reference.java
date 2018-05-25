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

import com.test.automation.uiAutomation.Admission.Masters.Masters_Master_Reference;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Reference extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Reference.class.getName());

	Masters_Master_Reference masterreference;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterReferenceData")
	public String[][] getTestData() {
		String[][] testRecordsSourceDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterReferenceInfoData");
		return testRecordsSourceDetails;
	}

	@DataProvider(name = "MasterReferenceSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByReferenceNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterreference = new Masters_Master_Reference(driver);
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

			boolean status = masterreference.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterReference_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterReference_BGHS Test===========");

			masterreference.navigateToAdmission_Masters_MasterReference_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterReference_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterReference_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterReference_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterReference_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterReference_BGHSPage Test===========");

			boolean status = masterreference.verifyMasters_MasterReference_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterReference_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterReference_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterReference_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterReferenceForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterReferenceForm Test===========");

			masterreference.submitBlankMasterReferenceForm();

			log.info("============= Finished tcSubmitBlankMasterReferenceForm Test===========");
			getScreenShot("tcSubmitBlankMasterReferenceForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterReferenceForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "MastersMasterReferenceData")
	public void tcEnterMasterReferenceDetailsData(String referenceName, String referenceDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterReferenceDetailsData Test===========");

			masterreference.enterMasterReferenceDetailsData(referenceName, referenceDescription);

			log.info("============= Finished tcEnterMasterReferenceDetailsData Test===========");
			getScreenShot("tcEnterMasterReferenceDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterReferenceDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearReferenceInfoData() {

		try {
			log.info("============= Strting tcClearReferenceInfoData Test===========");

			masterreference.clearReferenceInfoData();

			log.info("============= Finished tcClearReferenceInfoData Test===========");
			getScreenShot("tcClearReferenceInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearReferenceInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterReference() {

		try {
			log.info("============= Strting tcMinimizeMasterReference Test===========");

			masterreference.minimizeMasterReference();

			log.info("============= Finished tcMinimizeMasterReference Test===========");
			getScreenShot("tcMinimizeMasterReference");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterReference");
		}
	}
	@Test(priority = 9)
	public void tcSortByReferenceName() {

		try {
			log.info("============= Strting tcSortByReferenceName Test===========");
			getScreenShot("tcSortByReferenceName_BeforeSort");
			
			masterreference.sortByReferenceName();

			log.info("============= Finished tcSortByReferenceName Test===========");
			getScreenShot("tcSortByReferenceName");
		} catch (Exception e) {
			getScreenShot("tcSortByReferenceName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterReference() {

		try {
			log.info("============= Strting tcMaximizeMasterReference Test===========");

			masterreference.maximizeMasterReference();

			log.info("============= Finished tcMaximizeMasterReference Test===========");
			getScreenShot("tcMaximizeMasterReference");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterReference");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeMasterReferenceList() {

		try {
			log.info("============= Strting tcMinimizeMasterReferenceList Test===========");

			masterreference.minimizeMasterReferenceList();

			log.info("============= Finished tcMinimizeMasterReferenceList Test===========");
			getScreenShot("tcMinimizeMasterReferenceList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterReferenceList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterReferenceList() {

		try {
			log.info("============= Strting tcMaximizeMasterReferenceList Test===========");

			masterreference.maximizeMasterReferenceList();

			log.info("============= Finished tcMaximizeMasterReferenceList Test===========");
			getScreenShot("tcMaximizeMasterReferenceList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterReferenceList");
		}
	}
	
	@Test(priority = 13, dataProvider = "MastersMasterReferenceData")
	public void tcEnterMasterReferenceDetailsData_AfterClear(String referenceName, String referenceDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterReferenceDetailsData_AfterClear Test===========");

			masterreference.enterMasterReferenceDetailsData(referenceName, referenceDescription);

			log.info("============= Finished tcEnterMasterReferenceDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterReferenceDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterReferenceDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveReferenceInfoData() {

		try {
			log.info("============= Strting tcSaveReferenceInfoData Test===========");

			masterreference.saveReferenceInfoData();

			log.info("============= Finished tcSaveReferenceInfoData Test===========");
			getScreenShot("tcSaveReferenceInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveReferenceInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterreference.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 16, dataProvider = "MasterReferenceSearchData")
	public void tcSearchWithReferenceNameInTheGrid(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReferenceNameInTheGrid Test===========");

			masterreference.searchWithReferenceNameInTheGrid(referenceName);

			log.info("============= Finished tcSearchWithReferenceNameInTheGrid Test===========");
			getScreenShot("tcSearchWithReferenceNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReferenceNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MasterReferenceSearchData")
	public void tcVerifyReferenceNameInTheGrid(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyReferenceNameInTheGrid Test===========");

			masterreference.verifyReferenceNameInTheGrid(referenceName);

			log.info("============= Finished tcVerifyReferenceNameInTheGrid Test===========");
			getScreenShot("tcVerifyReferenceNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyReferenceNameInTheGrid");
		}
	}
	
	@Test(priority = 18, dataProvider = "MasterReferenceSearchData")
	public void tcEditMasterReference(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterReference Test===========");

			masterreference.editMasterReference(referenceName);

			log.info("============= Finished tcEditMasterReference Test===========");
			getScreenShot("tcEditMasterReference");
		} catch (Exception e) {
			getScreenShot("tcEditMasterReference");
		}
	}

	@Test(priority = 19)
	public void tcSaveReferenceInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveReferenceInfoData_Edit Test===========");

			masterreference.saveReferenceInfoData();

			log.info("============= Finished tcSaveReferenceInfoData_Edit Test===========");
			getScreenShot("tcSaveReferenceInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveReferenceInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterreference.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}


	@Test(priority = 21, dataProvider = "MasterReferenceSearchData")
	public void tcSearchWithReferenceNameInTheGrid_delete(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReferenceNameInTheGrid_delete Test===========");

			masterreference.searchWithReferenceNameInTheGrid(referenceName);

			log.info("============= Finished tcSearchWithReferenceNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithReferenceNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReferenceNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "MasterReferenceSearchData")
	public void tcDeleteMasterReference(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterReference Test===========");

			masterreference.deleteMasterReference(referenceName);

			log.info("============= Finished tcDeleteMasterReference Test===========");
			getScreenShot("tcDeleteMasterReference");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterReference");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			masterreference.clickOnCancelButton();

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

			masterreference.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}
	

	@Test(priority = 25, dataProvider = "MasterReferenceSearchData")
	public void tcSearchWithReferenceNameInTheGrid_AfterDeleteCancel(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithReferenceNameInTheGrid_AfterDeleteCancel Test===========");

			masterreference.searchWithReferenceNameInTheGrid(referenceName);

			log.info("============= Finished tcSearchWithReferenceNameInTheGrid_AfterDeleteCancel Test===========");
			getScreenShot("tcSearchWithReferenceNameInTheGrid_AfterDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithReferenceNameInTheGrid_AfterDeleteCancel");
		}
	}

	@Test(priority = 26, dataProvider = "MasterReferenceSearchData")
	public void tcDeleteMasterReference_AfterCancel(String referenceName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterReference_AfterCancel Test===========");

			masterreference.deleteMasterReference(referenceName);

			log.info("============= Finished tcDeleteMasterReference_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterReference_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterReference_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterreference.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 28)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			masterreference.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	
	@Test(priority = 29, dataProvider = "MastersMasterReferenceData")
	public void tcEnterMasterReferenceDetailsData_AfterDelete(String referenceName, String referenceDescription,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterReferenceDetailsData_AfterDelete Test===========");

			masterreference.enterMasterReferenceDetailsData(referenceName, referenceDescription);

			log.info("============= Finished tcEnterMasterReferenceDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterReferenceDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterReferenceDetailsData_AfterDelete");
		}
	}

	@Test(priority = 30)
	public void tcSaveReferenceInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveReferenceInfoData_AfterDelete Test===========");

			masterreference.saveReferenceInfoData();

			log.info("============= Finished tcSaveReferenceInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveReferenceInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveReferenceInfoData_AfterDelete");
		}
	}

	@Test(priority = 31)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			masterreference.clickOnOkSuccessButton();

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
