/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Group_YearlyGroup;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Tc_Masters_Fee_Group_YearlyGroup extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Group_YearlyGroup.class.getName());

	Masters_Fee_Group_YearlyGroup feeGroupYearlyGroup;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeGroupYearlyTestData")
	public String[][] getTestDataFeeGroup_Yearly() {
		String[][] testRecordsFeegroup = getData("FeeModueData.xlsx", "FeeGroupYearlyData");
		return testRecordsFeegroup;
	}

	@DataProvider(name = "Search_FeeGroupYearlyTestData")
	public String[][] getTestDataFeeGroup_Search() {
		String[][] testRecords_SearchYearly = getData("FeeModueData.xlsx", "Search_FeeGroupYearlyData");
		return testRecords_SearchYearly;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeGroupYearlyGroup = new Masters_Fee_Group_YearlyGroup(driver);
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

			feeGroupYearlyGroup.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToMasters_FeeGroup_YearlyFeeGroup() {

		try {
			log.info("============= Strting tcNavigateToMasters_FeeGroup_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.navigateToMasters_FeeGroup_YearlyFeeGroup();

			log.info("============= Finished tcNavigateToMasters_FeeGroup_YearlyFeeGroup Test===========");
			getScreenShot("tcNavigateToMasters_FeeGroup_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_FeeGroup_YearlyFeeGroup");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeGroupPage_YearlyGroup() {

		try {
			log.info("============= Strting tcVerifyFeeGroupPage_YearlyGroup Test===========");

			boolean status = feeGroupYearlyGroup.verifyFeeGroupPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeGroupPage_YearlyGroup Test===========");
			getScreenShot("tcVerifyFeeGroupPage_YearlyGroup");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeGroupPage_YearlyGroup");
		}
	}

	@Test(priority = 5)
	public void tcNavigateTo_YearlyGroupTab() {

		try {
			log.info("============= Strting tcNavigateTo_YearlyGroupTab Test===========");

			feeGroupYearlyGroup.NavigateTo_YearlyGroupTab();

			log.info("============= Finished tcNavigateTo_YearlyGroupTab Test===========");
			getScreenShot("tcNavigateTo_YearlyGroupTab");
		} catch (Exception e) {
			getScreenShot("tcNavigateTo_YearlyGroupTab");
		}
	}

	@Test(priority = 6)
	public void tcClickOnSaveButton_YearlyGroup_ToSubmitBlankForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_YearlyGroup_ToSubmitBlankForm Test===========");

			feeGroupYearlyGroup.clickOnSaveButton_YearlyGroup();

			log.info("============= Finished tcClickOnSaveButton_YearlyGroup_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_YearlyGroup_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_YearlyGroup_ToSubmitBlankForm");
		}
	}

	@Test(priority = 7, dataProvider = "FeeGroupYearlyTestData")
	public void tcFill_FeeGroup_YearlyGroupForm(String academicYear, String groupName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeGroup_YearlyGroupForm Test===========");

			feeGroupYearlyGroup.fill_FeeGroup_YearlyGroupForm(academicYear, groupName);

			log.info("============= Finished tcFill_FeeGroup_YearlyGroupForm Test===========");
			getScreenShot("tcFill_FeeGroup_YearlyGroupForm");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeGroup_YearlyGroupForm");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_YearlyFeeGroup() {

		try {
			log.info("============= Strting tcMinimize_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.minimizeAndMaximize_YearlyFeeGroup();

			log.info("============= Finished tcMinimize_YearlyFeeGroup Test===========");
			getScreenShot("tcMinimize_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyFeeGroup");
		}
	}

	@Test(priority = 9)
	public void tcSortBy_YearlyFeeGroupName() {

		try {
			log.info("============= Strting tcSortBy_YearlyFeeGroupName Test===========");
			getScreenShot("tcSortBy_YearlyFeeGroupName_BeforeSorting");

			feeGroupYearlyGroup.sortBy_YearlyFeeGroupName();

			log.info("============= Finished tcSortBy_YearlyFeeGroupName Test===========");
			getScreenShot("tcSortBy_YearlyFeeGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortBy_YearlyFeeGroupName");
		}
	}

	@Test(priority = 10)
	public void tcMinimize_YearlyGroupFeeGrGridView() {

		try {
			log.info("============= Strting tcMinimize_YearlyGroupFeeGrGridView Test===========");

			feeGroupYearlyGroup.minimizeAndMaximize_YearlyGroupFeeGrGridView();

			log.info("============= Finished tcMinimize_YearlyGroupFeeGrGridView Test===========");
			getScreenShot("tcMinimize_YearlyGroupFeeGrGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyGroupFeeGrGridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_YearlyGroupFeeGrGridView() {

		try {
			log.info("============= Strting tcMaximize_YearlyGroupFeeGrGridView Test===========");

			feeGroupYearlyGroup.minimizeAndMaximize_YearlyGroupFeeGrGridView();

			log.info("============= Finished tcMaximize_YearlyGroupFeeGrGridView Test===========");
			getScreenShot("tcMaximize_YearlyGroupFeeGrGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyGroupFeeGrGridView");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_YearlyFeeGroup() {

		try {
			log.info("============= Strting tcMaximize_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.minimizeAndMaximize_YearlyFeeGroup();

			log.info("============= Finished tcMaximize_YearlyFeeGroup Test===========");
			getScreenShot("tcMaximize_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyFeeGroup");
		}
	}

	@Test(priority = 13)
	public void tcClickOnCancelButton_YearlyFeeGroup() {
		try {
			log.info("============= Strting tcClickOnCancelButton_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.clickOnCancelButton_YearlyFeeGroup();

			log.info("============= Finished tcClickOnCancelButton_YearlyFeeGroup Test===========");
			getScreenShot("tcClickOnCancelButton_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_YearlyFeeGroup");
		}
	}

	@Test(priority = 14, dataProvider = "FeeGroupYearlyTestData")
	public void tcFill_FeeGroup_YearlyGroupForm_AfterClearingFilledData(String academicYear, String groupName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeGroup_YearlyGroupForm_AfterClearingFilledData Test===========");

			feeGroupYearlyGroup.fill_FeeGroup_YearlyGroupForm(academicYear, groupName);

			log.info("============= Finished tcFill_FeeGroup_YearlyGroupForm_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeGroup_YearlyGroupForm_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeGroup_YearlyGroupForm_AfterClearingFilledData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnSaveButton_YearlyGroup() {

		try {
			log.info("============= Strting tcClickOnSaveButton_YearlyGroup Test===========");

			feeGroupYearlyGroup.clickOnSaveButton_YearlyGroup();

			log.info("============= Finished tcClickOnSaveButton_YearlyGroup Test===========");
			getScreenShot("tcClickOnSaveButton_YearlyGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_YearlyGroup");
		}
	}
	@Test(priority = 16)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			feeGroupYearlyGroup.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 17)
	public void tcClickOnSuccessOkBtn_YearlyGroup() {
		feeGroupYearlyGroup = new Masters_Fee_Group_YearlyGroup(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup");
		}
	}
	@Test(priority = 18, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid Test===========");

			feeGroupYearlyGroup.searchBy_FeeGroup_YearlyFeeGrNameInGrid(yearlyFeeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid Test===========");
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid");
		}
	}

	@Test(priority = 19, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcVerifyYearlyFeeGroup_UpdatedInGrid(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyYearlyFeeGroup_UpdatedInGrid Test===========");

			feeGroupYearlyGroup.verifyYearlyFeeGroup_UpdatedInGrid(yearlyFeeGroup);

			log.info("============= Finished tcVerifyYearlyFeeGroup_UpdatedInGrid Test===========");
			getScreenShot("tcVerifyYearlyFeeGroup_UpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyYearlyFeeGroup_UpdatedInGrid");
		}
	}

	@Test(priority = 20, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcEdit_YearlyFeeGroup(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.edit_YearlyFeeGroup(yearlyFeeGroup);
			log.info("============= Finished tcEdit_YearlyFeeGroup Test===========");
			getScreenShot("tcEdit_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcEdit_YearlyFeeGroup");
		}
	}

	@Test(priority = 21)
	public void tcClickOnSaveButton_YearlyGroupForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_YearlyGroupForm_Edit Test===========");

			feeGroupYearlyGroup.clickOnSaveButton_YearlyGroup();

			log.info("============= Finished tcClickOnSaveButton_YearlyGroupForm_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_YearlyGroupForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_YearlyGroupForm_Edit");
		}
	}
	@Test(priority = 22)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			feeGroupYearlyGroup.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}
	@Test(priority = 23)
	public void tcClickOnSuccessOkBtn_YearlyGroup_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup_Edit Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_Edit");
		}
	}

	//

	@Test(priority = 24, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate Test===========");

			feeGroupYearlyGroup.searchBy_FeeGroup_YearlyFeeGrNameInGrid(yearlyFeeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate");
		}
	}

	@Test(priority = 25, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcDeactivationOfCreated_YearlyFeeGroup(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_YearlyFeeGroup Test===========");

			feeGroupYearlyGroup.deactivationOfCreated_YearlyFeeGroup(yearlyFeeGroup);

			log.info("============= Finished tcDeactivationOfCreated_YearlyFeeGroup Test===========");
			getScreenShot("tcDeactivationOfCreated_YearlyFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_YearlyFeeGroup");
		}
	}

	@Test(priority = 26)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			feeGroupYearlyGroup.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}
	
	@Test(priority = 27)
	public void tcPopUpWindowMessage_DeactivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");

			feeGroupYearlyGroup.popUpWindowMessage_DeactivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		}
	}

	@Test(priority = 28)
	public void tcClickOnSuccessOkBtn_YearlyGroup_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup_deactivateCancel Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup_deactivateCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_deactivateCancel");
		}
	}

	@Test(priority = 29, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate_AfterCancel(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate_AfterCancel Test===========");

			feeGroupYearlyGroup.searchBy_FeeGroup_YearlyFeeGrNameInGrid(yearlyFeeGroup);

			log.info(
					"============= Finished tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 30, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcDeactivationOfCreated_YearlyFeeGroup_AfterCancel(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_YearlyFeeGroup_AfterCancel Test===========");

			feeGroupYearlyGroup.deactivationOfCreated_YearlyFeeGroup(yearlyFeeGroup);

			log.info("============= Finished tcDeactivationOfCreated_YearlyFeeGroup_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreated_YearlyFeeGroup_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_YearlyFeeGroup_AfterCancel");
		}
	}

	@Test(priority = 31)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			feeGroupYearlyGroup.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 32)
	public void tcPopUpWindowMessage_DeactivateSucessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");

			feeGroupYearlyGroup.popUpWindowMessage_DeactivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		}
	}
	@Test(priority = 33)
	public void tcClickOnSuccessOkBtn_YearlyGroup_deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup_deactivate Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup_deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_deactivate");
		}
	}

	@Test(priority = 34, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForActivate(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForActivate Test===========");

			feeGroupYearlyGroup.searchBy_FeeGroup_YearlyFeeGrNameInGrid(yearlyFeeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForActivate Test===========");
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_ForActivate");
		}
	}

	@Test(priority = 35, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcActivationOfCreatedFeeGroup_YearlyGroup(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedFeeGroup_YearlyGroup Test===========");

			feeGroupYearlyGroup.activationOfCreatedFeeGroup_YearlyGroup(yearlyFeeGroup);

			log.info("============= Finished tcActivationOfCreatedFeeGroup_YearlyGroup Test===========");
			getScreenShot("tcActivationOfCreatedFeeGroup_YearlyGroup");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeGroup_YearlyGroup");
		}
	}

	@Test(priority = 36)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			feeGroupYearlyGroup.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}
	@Test(priority = 37)
	public void tcPopUpWindowMessage_ActivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateCancel_Validation Test===========");

			feeGroupYearlyGroup.popUpWindowMessage_ActivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		}
	}
	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_YearlyGroup_activateCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup_activateCancel Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup_activateCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_activateCancel");
		}
	}

	@Test(priority = 39, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_AfterCancel(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_AfterCancel Test===========");

			feeGroupYearlyGroup.searchBy_FeeGroup_YearlyFeeGrNameInGrid(yearlyFeeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_YearlyFeeGrNameInGrid_AfterCancel");
		}
	}

	@Test(priority = 40, dataProvider = "Search_FeeGroupYearlyTestData")
	public void tcActivationOfCreatedFeeGroup_YearlyGroup_AfterCancel(String yearlyFeeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedFeeGroup_YearlyGroup_AfterCancel Test===========");

			feeGroupYearlyGroup.activationOfCreatedFeeGroup_YearlyGroup(yearlyFeeGroup);
			log.info("============= Finished tcActivationOfCreatedFeeGroup_YearlyGroup_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreatedFeeGroup_YearlyGroup_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeGroup_YearlyGroup_AfterCancel");
		}
	}

	@Test(priority = 41)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			feeGroupYearlyGroup.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}
	@Test(priority = 42)
	public void tcPopUpWindowMessage_ActivateSucessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");

			feeGroupYearlyGroup.popUpWindowMessage_ActivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		}
	}
	@Test(priority = 43)
	public void tcClickOnSuccessOkBtn_YearlyGroup_activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_YearlyGroup_activate Test===========");

			feeGroupYearlyGroup.clickOnSuccessOkBtn_YearlyGroup();

			log.info("============= Finished tcClickOnSuccessOkBtn_YearlyGroup_activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearlyGroup_activate");
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
