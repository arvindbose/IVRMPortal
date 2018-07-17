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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Documents;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Documents extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Documents.class.getName());

	Masters_Master_Documents masterdocuments;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterDocumentData")
	public String[][] getTestData() {
		String[][] testRecordsDocumentDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterDocumentInfoData");
		return testRecordsDocumentDetails;
	}

	@DataProvider(name = "MasterDocumentSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByDocumentNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterdocuments = new Masters_Master_Documents(driver);
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

			boolean status = masterdocuments.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterDocument_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterDocument_BGHS Test===========");

			masterdocuments.navigateToAdmission_Masters_MasterDocument_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterDocument_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterDocument_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterDocument_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterDocument_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterDocument_BGHSPage Test===========");

			boolean status = masterdocuments.verifyMasters_MasterDocument_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterDocument_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterDocument_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterDocument_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterDocumentForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterDocumentForm Test===========");

			masterdocuments.submitBlankMasterDocumentForm();

			log.info("============= Finished tcSubmitBlankMasterDocumentForm Test===========");
			getScreenShot("tcSubmitBlankMasterDocumentForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterDocumentForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "MastersMasterDocumentData")
	public void tcEnterMasterDocumentData(String documentName, String documentDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterDocumentData Test===========");

			masterdocuments.enterMasterDocumentData(documentName, documentDescription);

			log.info("============= Finished tcEnterMasterDocumentData Test===========");
			getScreenShot("tcEnterMasterDocumentData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterDocumentData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearDocumentInfoData() {

		try {
			log.info("============= Strting tcClearDocumentInfoData Test===========");

			masterdocuments.clearDocumentInfoData();

			log.info("============= Finished tcClearDocumentInfoData Test===========");
			getScreenShot("tcClearDocumentInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearDocumentInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterDocument() {

		try {
			log.info("============= Strting tcMinimizeMasterDocument Test===========");

			masterdocuments.minimizeMasterDocument();

			log.info("============= Finished tcMinimizeMasterDocument Test===========");
			getScreenShot("tcMinimizeMasterDocument");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterDocument");
		}
	}
	@Test(priority = 9)
	public void tcSortByDocumentName() {

		try {
			log.info("============= Strting tcSortByDocumentName Test===========");
			getScreenShot("tcSortByDocumentName_BeforeSort");
			
			masterdocuments.sortByDocumentName();

			log.info("============= Finished tcSortByDocumentName Test===========");
			getScreenShot("tcSortByDocumentName");
		} catch (Exception e) {
			getScreenShot("tcSortByDocumentName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterDocument() {

		try {
			log.info("============= Strting tcMaximizeMasterDocument Test===========");

			masterdocuments.maximizeMasterDocument();

			log.info("============= Finished tcMaximizeMasterDocument Test===========");
			getScreenShot("tcMaximizeMasterDocument");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterDocument");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeMasterDocumentList() {

		try {
			log.info("============= Strting tcMinimizeMasterDocumentList Test===========");

			masterdocuments.minimizeMasterDocumentList();

			log.info("============= Finished tcMinimizeMasterDocumentList Test===========");
			getScreenShot("tcMinimizeMasterDocumentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterDocumentList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterDocumentList() {

		try {
			log.info("============= Strting tcMaximizeMasterDocumentList Test===========");

			masterdocuments.maximizeMasterDocumentList();

			log.info("============= Finished tcMaximizeMasterDocumentList Test===========");
			getScreenShot("tcMaximizeMasterDocumentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterDocumentList");
		}
	}
	
	@Test(priority = 13, dataProvider = "MastersMasterDocumentData")
	public void tcEnterMasterDocumentData_AfterClear(String documentName, String documentDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterDocumentData_AfterClear Test===========");

			masterdocuments.enterMasterDocumentData(documentName, documentDescription);

			log.info("============= Finished tcEnterMasterDocumentData_AfterClear Test===========");
			getScreenShot("tcEnterMasterDocumentData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterDocumentData_AfterClear");
		}
	}
	
	@Test(priority = 14)
	public void tcSaveDocumentInfoData() {

		try {
			log.info("============= Strting tcSaveDocumentInfoData Test===========");

			masterdocuments.saveDocumentInfoData();

			log.info("============= Finished tcSaveDocumentInfoData Test===========");
			getScreenShot("tcSaveDocumentInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveDocumentInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterdocuments.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 16, dataProvider = "MasterDocumentSearchData")
	public void tcSearchWithDocumentNameInTheGrid(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithDocumentNameInTheGrid Test===========");

			masterdocuments.searchWithDocumentNameInTheGrid(documentName);

			log.info("============= Finished tcSearchWithDocumentNameInTheGrid Test===========");
			getScreenShot("tcSearchWithDocumentNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithDocumentNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MasterDocumentSearchData")
	public void tcVerifyDocumentNameInTheGrid(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyDocumentNameInTheGrid Test===========");

			masterdocuments.verifyDocumentNameInTheGrid(documentName);

			log.info("============= Finished tcVerifyDocumentNameInTheGrid Test===========");
			getScreenShot("tcVerifyDocumentNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyDocumentNameInTheGrid");
		}
	}
	
	@Test(priority = 18, dataProvider = "MasterDocumentSearchData")
	public void tcEditMasterDocument(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterDocument Test===========");

			masterdocuments.editMasterDocument(documentName);

			log.info("============= Finished tcEditMasterDocument Test===========");
			getScreenShot("tcEditMasterDocument");
		} catch (Exception e) {
			getScreenShot("tcEditMasterDocument");
		}
	}

	@Test(priority = 19)
	public void tcSaveDocumentInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveDocumentInfoData_Edit Test===========");

			masterdocuments.saveDocumentInfoData();

			log.info("============= Finished tcSaveDocumentInfoData_Edit Test===========");
			getScreenShot("tcSaveDocumentInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveDocumentInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterdocuments.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 21, dataProvider = "MasterDocumentSearchData")
	public void tcSearchWithDocumentNameInTheGrid_delete(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithDocumentNameInTheGrid_delete Test===========");

			masterdocuments.searchWithDocumentNameInTheGrid(documentName);

			log.info("============= Finished tcSearchWithDocumentNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithDocumentNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithDocumentNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "MasterDocumentSearchData")
	public void tcDeleteMasterDocument(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterDocument Test===========");

			masterdocuments.deleteMasterDocument(documentName);

			log.info("============= Finished tcDeleteMasterDocument Test===========");
			getScreenShot("tcDeleteMasterDocument");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterDocument");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			masterdocuments.clickOnCancelButton();

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

			masterdocuments.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}
	

	@Test(priority = 25, dataProvider = "MasterDocumentSearchData")
	public void tcSearchWithDocumentNameInTheGrid_AfterDeleteCancel(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithDocumentNameInTheGrid_AfterDeleteCancel Test===========");

			masterdocuments.searchWithDocumentNameInTheGrid(documentName);

			log.info("============= Finished tcSearchWithDocumentNameInTheGrid_AfterDeleteCancel Test===========");
			getScreenShot("tcSearchWithDocumentNameInTheGrid_AfterDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithDocumentNameInTheGrid_AfterDeleteCancel");
		}
	}

	@Test(priority = 26, dataProvider = "MasterDocumentSearchData")
	public void tcDeleteMasterDocument_AfterCancel(String documentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterDocument_AfterCancel Test===========");

			masterdocuments.deleteMasterDocument(documentName);

			log.info("============= Finished tcDeleteMasterDocument_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterDocument_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterDocument_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterdocuments.yesDeleteOrDeactivateOrActivateIt();

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

			masterdocuments.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	@Test(priority = 29, dataProvider = "MastersMasterDocumentData")
	public void tcEnterMasterDocumentData_AfterDelete(String documentName, String documentDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterDocumentData_AfterDelete Test===========");

			masterdocuments.enterMasterDocumentData(documentName, documentDescription);

			log.info("============= Finished tcEnterMasterDocumentData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterDocumentData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterDocumentData_AfterDelete");
		}
	}
	
	@Test(priority = 30)
	public void tcSaveDocumentInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveDocumentInfoData_AfterDelete Test===========");

			masterdocuments.saveDocumentInfoData();

			log.info("============= Finished tcSaveDocumentInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveDocumentInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveDocumentInfoData_AfterDelete");
		}
	}

	@Test(priority = 31)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			masterdocuments.clickOnOkSuccessButton();

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
