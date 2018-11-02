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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Section;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Section extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Master_Section.class.getName());

	Masters_Master_Section mastersection;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterSectionData")
	public String[][] getTestData() {
		String[][] testRecordsSectionDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterSectionInfoData");
		return testRecordsSectionDetails;
	}

	@DataProvider(name = "MasterSectionSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchBySectionNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastersection = new Masters_Master_Section(driver);
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

			boolean status = mastersection.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterSection_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterSection_BGHS Test===========");

			mastersection.navigateToAdmission_Masters_MasterSection_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterSection_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterSection_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterSection_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterSection_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterSection_BGHSPage Test===========");

			boolean status = mastersection.verifyMasters_MasterSection_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterSection_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterSection_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterSection_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterSectionForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterSectionForm Test===========");

			mastersection.submitBlankMasterSectionForm();

			log.info("============= Finished tcSubmitBlankMasterSectionForm Test===========");
			getScreenShot("tcSubmitBlankMasterSectionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterSectionForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterSectionData")
	public void tcEnterMasterSectionFormData(String sectionName, String sectionOrder, String sectionCode,
			String sectionCapacity, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSectionFormData Test===========");

			mastersection.enterMasterSectionFormData(sectionName, sectionOrder, sectionCode, sectionCapacity);

			log.info("============= Finished tcEnterMasterSectionFormData Test===========");
			getScreenShot("tcEnterMasterSectionFormData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSectionFormData");
		}
	}

	@Test(priority = 7)
	public void tcClearSectionInfoData() {

		try {
			log.info("============= Strting tcClearSectionInfoData Test===========");

			mastersection.clearSectionInfoData();

			log.info("============= Finished tcClearSectionInfoData Test===========");
			getScreenShot("tcClearSectionInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearSectionInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterSection() {

		try {
			log.info("============= Strting tcMinimizeMasterSection Test===========");

			mastersection.minimizeMasterSection();

			log.info("============= Finished tcMinimizeMasterSection Test===========");
			getScreenShot("tcMinimizeMasterSection");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSection");
		}
	}
	
	@Test(priority = 9)
	public void tcSortBySectionName() {

		try {
			log.info("============= Strting tcSortBySectionName Test===========");
			getScreenShot("tcSortBySectionName_BeforeSorting");

			mastersection.sortBySectionName();

			log.info("============= Finished tcSortBySectionName Test===========");
			getScreenShot("tcSortBySectionName");
		} catch (Exception e) {
			getScreenShot("tcSortBySectionName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterSection() {

		try {
			log.info("============= Strting tcMaximizeMasterSection Test===========");

			mastersection.maximizeMasterSection();

			log.info("============= Finished tcMaximizeMasterSection Test===========");
			getScreenShot("tcMaximizeMasterSection");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSection");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeMasterSectionList() {

		try {
			log.info("============= Strting tcMinimizeMasterSectionList Test===========");

			mastersection.minimizeMasterSectionList();

			log.info("============= Finished tcMinimizeMasterSectionList Test===========");
			getScreenShot("tcMinimizeMasterSectionList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterSectionList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterSectionList() {

		try {
			log.info("============= Strting tcMaximizeMasterSectionList Test===========");

			mastersection.maximizeMasterSectionList();

			log.info("============= Finished tcMaximizeMasterSectionList Test===========");
			getScreenShot("tcMaximizeMasterSectionList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterSectionList");
		}
	}

	@Test(priority = 13, dataProvider = "MastersMasterSectionData")
	public void tcEnterMasterSectionFormData_AfterClear(String sectionName, String sectionOrder, String sectionCode,
			String sectionCapacity, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterSectionFormData_AfterClear Test===========");

			mastersection.enterMasterSectionFormData(sectionName, sectionOrder, sectionCode, sectionCapacity);

			log.info("============= Finished tcEnterMasterSectionFormData_AfterClear Test===========");
			getScreenShot("tcEnterMasterSectionFormData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterSectionFormData_AfterClear");
		}
	}

	@Test(priority = 14)
	 public void tcSubmitFilledMasterSectionForm() {
	
	 try {
	 log.info("============= Strting tcSubmitFilledMasterSectionForm Test===========");
	
	 mastersection.submitFilledMasterSectionForm();
	
	 log.info("============= Finished tcSubmitFilledMasterSectionForm Test===========");
	 getScreenShot("tcSubmitFilledMasterSectionForm");
	 } catch (Exception e) {
	 getScreenShot("tcSubmitFilledMasterSectionForm");
	 }
	 }

	@Test(priority = 15)
	 public void tcClickOnOkSuccessButton() {
	
	 try {
	 log.info("============= Strting tcClickOnOkSuccessButton Test===========");
	
	 mastersection.clickOnOkSuccessButton();
	
	 log.info("============= Finished tcClickOnOkSuccessButton Test===========");
	 getScreenShot("tcClickOnOkSuccessButton");
	 } catch (Exception e) {
	 getScreenShot("tcClickOnOkSuccessButton");
	 }
	 }
	@Test(priority = 16)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			mastersection.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	

	@Test(priority = 17, dataProvider = "MasterSectionSearchData")
	public void tcSearchWithSectionNameInTheGrid(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSectionNameInTheGrid Test===========");

			mastersection.searchWithSectionNameInTheGrid(sectionName);

			log.info("============= Finished tcSearchWithSectionNameInTheGrid Test===========");
			getScreenShot("tcSearchWithSectionNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSectionNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterSectionSearchData")
	public void tcVerifySectionNameInTheGrid(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifySectionNameInTheGrid Test===========");

			mastersection.verifySectionNameInTheGrid(sectionName);

			log.info("============= Finished tcVerifySectionNameInTheGrid Test===========");
			getScreenShot("tcVerifySectionNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifySectionNameInTheGrid");
		}
	}

	@Test(priority = 19, dataProvider = "MasterSectionSearchData")
	public void tcEditMasterSection(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterSection Test===========");

			mastersection.editMasterSection(sectionName);

			log.info("============= Finished tcEditMasterSection Test===========");
			getScreenShot("tcEditMasterSection");
		} catch (Exception e) {
			getScreenShot("tcEditMasterSection");
		}
	}

	@Test(priority = 20)
	public void tcSubmitFilledMasterSectionForm_Edit() {

		try {
			log.info("============= Strting tcSubmitFilledMasterSectionForm_Edit Test===========");

			mastersection.submitFilledMasterSectionForm();

			log.info("============= Finished tcSubmitFilledMasterSectionForm_Edit Test===========");
			getScreenShot("tcSubmitFilledMasterSectionForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterSectionForm_Edit");
		}
	}
	@Test(priority = 21)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			mastersection.popWindowMessage_SubmitSuccessfully_Edit();

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

			mastersection.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	///
	@Test(priority = 23, dataProvider = "MasterSectionSearchData")
	public void tcSearchWithSectionNameInTheGrid_ForDeactivate(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSectionNameInTheGrid_ForDeactivate Test===========");

			mastersection.searchWithSectionNameInTheGrid(sectionName);

			log.info("============= Finished tcSearchWithSectionNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 24, dataProvider = "MasterSectionSearchData")
	public void tcDeactivateMasterSection(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterSection Test===========");

			mastersection.deactivateMasterSection(sectionName);

			log.info("============= Finished tcDeactivateMasterSection Test===========");
			getScreenShot("tcDeactivateMasterSection");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterSection");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			mastersection.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			mastersection.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 27, dataProvider = "MasterSectionSearchData")
	public void tcSearchWithSectionNameInTheGrid_ForDeactivate_AfterCancel(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSectionNameInTheGrid_ForDeactivate Test===========");

			mastersection.searchWithSectionNameInTheGrid(sectionName);

			log.info("============= Finished tcSearchWithSectionNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 28, dataProvider = "MasterSectionSearchData")
	public void tcDeactivateMasterSection_AfterCancel(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterSection_AfterCancel Test===========");

			mastersection.deactivateMasterSection(sectionName);

			log.info("============= Finished tcDeactivateMasterSection_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterSection_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterSection_AfterCancel");
		}
	}

	@Test(priority = 29)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastersection.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 30)
	public void tcPopWindowMessage_DeactivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");

			mastersection.popWindowMessage_DeactivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		}
	}

	@Test(priority = 31)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			mastersection.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 32, dataProvider = "MasterSectionSearchData")
	public void tcSearchWithSectionNameInTheGrid_ForActivate(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSectionNameInTheGrid_ForActivate Test===========");

			mastersection.searchWithSectionNameInTheGrid(sectionName);

			log.info("============= Finished tcSearchWithSectionNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 33, dataProvider = "MasterSectionSearchData")
	public void tcActivateMasterSection(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterSection Test===========");

			mastersection.activateMasterSection(sectionName);

			log.info("============= Finished tcActivateMasterSection Test===========");
			getScreenShot("tcActivateMasterSection");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterSection");
		}
	}

	@Test(priority = 34)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			mastersection.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 35)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			mastersection.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 36, dataProvider = "MasterSectionSearchData")
	public void tcSearchWithSectionNameInTheGrid_ForActivate_AfterCancel(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSectionNameInTheGrid_ForActivate_AfterCancel Test===========");

			mastersection.searchWithSectionNameInTheGrid(sectionName);

			log.info("============= Finished tcSearchWithSectionNameInTheGrid_ForActivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSectionNameInTheGrid_ForActivate_AfterCancel");
		}
	}

	@Test(priority = 37, dataProvider = "MasterSectionSearchData")
	public void tcActivateMasterSection_AfterCancel(String sectionName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterSection_AfterCancel Test===========");

			mastersection.activateMasterSection(sectionName);
			log.info("============= Finished tcActivateMasterSection_AfterCancel Test===========");
			getScreenShot("tcActivateMasterSection_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterSection_AfterCancel");
		}
	}

	@Test(priority = 38)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			mastersection.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}
	@Test(priority = 39)
	public void tcPopWindowMessage_ActivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");

			mastersection.popWindowMessage_ActivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		}
	}
	@Test(priority = 40)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			mastersection.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
		}
	}

//	@Test(priority = 41)
//	public void tcClickOnSetOrder() {
//
//		try {
//			log.info("============= Strting tcClickOnSetOrder Test===========");
//
//			mastersection.clickOnSetOrder();
//
//			log.info("============= Finished tcClickOnSetOrder Test===========");
//			getScreenShot("tcClickOnSetOrder");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSetOrder");
//		}
//	}
//
//	@Test(priority = 42)
//	public void tcSetSectionOrder() {
//
//		try {
//			log.info("============= Strting tcSetSectionOrder Test===========");
//
//			mastersection.setSectionOrder();
//
//			log.info("============= Finished tcSetSectionOrder Test===========");
//			getScreenShot("tcSetSectionOrder");
//		} catch (Exception e) {
//			getScreenShot("tcSetSectionOrder");
//		}
//	}
//
//	@Test(priority = 43)
//	public void tcCloseSetSectionOrderPopUpWindow() {
//
//		try {
//			log.info("============= Strting tcCloseSetSectionOrderPopUpWindow Test===========");
//
//			mastersection.closeSetSectionOrderPopUpWindow();
//
//			log.info("============= Finished tcCloseSetSectionOrderPopUpWindow Test===========");
//			getScreenShot("tcCloseSetSectionOrderPopUpWindow");
//		} catch (Exception e) {
//			getScreenShot("tcCloseSetSectionOrderPopUpWindow");
//		}
//	}
//
//	@Test(priority = 44)
//	public void tcClickOnSetOrder_AfterClose() {
//
//		try {
//			log.info("============= Strting tcClickOnSetOrder Test===========");
//
//			mastersection.clickOnSetOrder();
//
//			log.info("============= Finished tcClickOnSetOrder Test===========");
//			getScreenShot("tcClickOnSetOrder");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSetOrder");
//		}
//	}
//
//	@Test(priority = 45)
//	public void tcSetSectionOrder_AfterClose() {
//
//		try {
//			log.info("============= Strting tcSetSectionOrder_AfterClose Test===========");
//
//			mastersection.setSectionOrder();
//
//			log.info("============= Finished tcSetSectionOrder_AfterClose Test===========");
//			getScreenShot("tcSetSectionOrder_AfterClose");
//		} catch (Exception e) {
//			getScreenShot("tcSetSectionOrder_AfterClose");
//		}
//	}
//
//	@Test(priority = 46)
//	public void tcSaveSetSectionOrderPopUpWindow() {
//
//		try {
//			log.info("============= Strting tcSaveSetSectionOrderPopUpWindow Test===========");
//
//			mastersection.saveSetSectionOrderPopUpWindow();
//
//			log.info("============= Finished tcSaveSetSectionOrderPopUpWindow Test===========");
//			getScreenShot("tcSaveSetSectionOrderPopUpWindow");
//		} catch (Exception e) {
//			getScreenShot("tcSaveSetSectionOrderPopUpWindow");
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
