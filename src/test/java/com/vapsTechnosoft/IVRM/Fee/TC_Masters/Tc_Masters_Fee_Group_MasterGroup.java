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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Group_MasterGroup;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Group_MasterGroup extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Group_MasterGroup.class.getName());

	Masters_Fee_Group_MasterGroup feemastergroup;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeGroup_MasterGroup_FormData")
	public String[][] getTestDataMasterGroup() {
		String[][] testRecordsMasterGroup = getData("FeeModueData.xlsx", "MasterFeeGroupData");
		return testRecordsMasterGroup;
	}

	@DataProvider(name = "Search_FeeGroup_MasterGroup")
	public String[][] getTestDataFeeGroupMaster() {
		String[][] testRecordsFeegroupMaster = getData("FeeModueData.xlsx", "Search_FeeGroupMasterGroup");
		return testRecordsFeegroupMaster;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feemastergroup = new Masters_Fee_Group_MasterGroup(driver);
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

			feemastergroup.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToMasters_FeeGroup() {
		try {
			log.info("============= Strting tcNavigateToMasters_FeeGroup Test===========");

			feemastergroup.navigateToMasters_FeeGroup();

			log.info("============= Finished tcNavigateToMasters_FeeGroup Test===========");
			getScreenShot("tcNavigateToMasters_FeeGroup");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_FeeGroup");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeGroupPage() {

		try {
			log.info("============= Strting tcVerifyFeeGroupPage Test===========");

			boolean status = feemastergroup.verifyFeeGroupPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeGroupPage Test===========");
			getScreenShot("tcVerifyFeeGroupPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeGroupPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_MasterGroup_ToSublitBlankForm() {
		try {
			log.info("============= Strting tcClickOnSaveButton_MasterGroup_ToSublitBlankForm Test===========");

			feemastergroup.clickOnSaveButton_MasterGroup();

			log.info("============= Finished tcClickOnSaveButton_MasterGroup_ToSublitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_MasterGroup_ToSublitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_MasterGroup_ToSublitBlankForm");
		}
	}

	@Test(priority = 6, dataProvider = "FeeGroup_MasterGroup_FormData")
	public void tcFill_FeeGroup_MasterGroupForm(String feeGroupName, String feeGrType, String feeGroupRemarks,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");

		}
		try {
			log.info("============= Strting tcFill_FeeGroup_MasterGroupForm Test===========");

			feemastergroup.fill_FeeGroup_MasterGroupForm(feeGroupName, feeGrType, feeGroupRemarks);

			log.info("============= Finished tcFill_FeeGroup_MasterGroupForm Test===========");
			getScreenShot("tcFill_FeeGroup_MasterGroupForm");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeGroup_MasterGroupForm");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_MasterFeeGroup() {

		try {
			log.info("============= Strting tcMinimize_MasterFeeGroup Test===========");

			feemastergroup.minimizeAndMaximize_MasterFeeGroup();

			log.info("============= Finished tcMinimize_MasterFeeGroup Test===========");
			getScreenShot("tcMinimize_MasterFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterFeeGroup");
		}
	}

	@Test(priority = 8)
	public void tcSortByMasterFeeGroupName() {

		try {
			log.info("============= Strting tcSortByMasterFeeGroupName Test===========");
			getScreenShot("tcSortByMasterFeeGroupName_BeforeSorting");

			feemastergroup.sortByMasterFeeGroupName();

			log.info("============= Finished tcSortByMasterFeeGroupName Test===========");
			getScreenShot("tcSortByMasterFeeGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortByMasterFeeGroupName");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_MasterGroupFeeGrGridView() {

		try {
			log.info("============= Strting tcMinimize_MasterGroupFeeGrGridView Test===========");

			feemastergroup.minimizeAndMaximize_MasterGroupFeeGrGridView();

			log.info("============= Finished tcMinimize_MasterGroupFeeGrGridView Test===========");
			getScreenShot("tcMinimize_MasterGroupFeeGrGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterGroupFeeGrGridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_MasterGroupFeeGrGridView() {

		try {
			log.info("============= Strting tcMaximize_MasterGroupFeeGrGridView Test===========");

			feemastergroup.minimizeAndMaximize_MasterGroupFeeGrGridView();

			log.info("============= Finished tcMaximize_MasterGroupFeeGrGridView Test===========");
			getScreenShot("tcMaximize_MasterGroupFeeGrGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterGroupFeeGrGridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_MasterFeeGroup() {

		try {
			log.info("============= Strting tcMaximize_MasterFeeGroup Test===========");

			feemastergroup.minimizeAndMaximize_MasterFeeGroup();

			log.info("============= Finished tcMaximize_MasterFeeGroup Test===========");
			getScreenShot("tcMaximize_MasterFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterFeeGroup");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_MasterGroup() {
		try {
			log.info("============= Strting tcClickOnCancelButton_MasterGroup Test===========");

			feemastergroup.clickOnCancelButton_MasterGroup();

			log.info("============= Finished tcClickOnCancelButton_MasterGroup Test===========");
			getScreenShot("tcClickOnCancelButton_MasterGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_MasterGroup");
		}
	}

	@Test(priority = 13, dataProvider = "FeeGroup_MasterGroup_FormData")
	public void tcFill_FeeGroup_MasterGroupForm_AfterCancel(String feeGroupName, String feeGrType,
			String feeGroupRemarks, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeGroup_MasterGroupForm_AfterCancel Test===========");

			feemastergroup.fill_FeeGroup_MasterGroupForm(feeGroupName, feeGrType, feeGroupRemarks);

			log.info("============= Finished tcFill_FeeGroup_MasterGroupForm_AfterCancel Test===========");
			getScreenShot("tcFill_FeeGroup_MasterGroupForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeGroup_MasterGroupForm_AfterCancel");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSaveButton_MasterGroup() {
		try {
			log.info("============= Strting tcClickOnSaveButton_MasterGroup Test===========");

			feemastergroup.clickOnSaveButton_MasterGroup();

			log.info("============= Finished tcClickOnSaveButton_MasterGroup Test===========");
			getScreenShot("tcClickOnSaveButton_MasterGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_MasterGroup");
		}
	}

	@Test(priority = 15)
	public void tcClickOnSuccessOkBtn() {
		feemastergroup = new Masters_Fee_Group_MasterGroup(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feemastergroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 16, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcSearchBy_FeeGroup_MasterFeeGrNameInGrid(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_MasterFeeGrNameInGrid Test===========");

			feemastergroup.searchBy_FeeGroup_MasterFeeGrNameInGrid(feeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_MasterFeeGrNameInGrid Test===========");
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid");
		}
	}

	@Test(priority = 17, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcVerifyMasterFeeGroup_UpdatedInGrid(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterFeeGroup_UpdatedInGrid Test===========");

			feemastergroup.verifyMasterFeeGroup_UpdatedInGrid(feeGroup);

			log.info("============= Finished tcVerifyMasterFeeGroup_UpdatedInGrid Test===========");
			getScreenShot("tcVerifyMasterFeeGroup_UpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFeeGroup_UpdatedInGrid");
		}
	}

	@Test(priority = 18, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcEdit_MasterFeeGroup(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_MasterFeeGroup Test===========");

			feemastergroup.edit_MasterFeeGroup(feeGroup);
			log.info("============= Finished tcEdit_MasterFeeGroup Test===========");
			getScreenShot("tcEdit_MasterFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcEdit_MasterFeeGroup");
		}
	}

	@Test(priority = 19)
	public void tcClickOnSaveButton_MasterGroupForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_MasterGroupForm_Edit Test===========");

			feemastergroup.clickOnSaveButton_MasterGroup();

			log.info("============= Finished tcClickOnSaveButton_MasterGroupForm_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_MasterGroupForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_MasterGroupForm_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			feemastergroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	//

	@Test(priority = 21, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate Test===========");

			feemastergroup.searchBy_FeeGroup_MasterFeeGrNameInGrid(feeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate");
		}
	}

	@Test(priority = 22, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcDeactivationOfCreated_MasterFeeGroup(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFeeGroup Test===========");

			feemastergroup.deactivationOfCreated_MasterFeeGroup(feeGroup);

			log.info("============= Finished tcDeactivationOfCreated_MasterFeeGroup Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFeeGroup");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			feemastergroup.clickOnCancelButton();

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

			feemastergroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 25, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate_AfterCancel(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate_AfterCancel Test===========");

			feemastergroup.searchBy_FeeGroup_MasterFeeGrNameInGrid(feeGroup);

			log.info(
					"============= Finished tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 26, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcDeactivationOfCreated_MasterFeeGroup_AfterCancel(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFeeGroup_AfterCancel Test===========");

			feemastergroup.deactivationOfCreated_MasterFeeGroup(feeGroup);

			log.info("============= Finished tcDeactivationOfCreated_MasterFeeGroup_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFeeGroup_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFeeGroup_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			feemastergroup.yesDeleteOrDeactivateOrActivateIt();

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

			feemastergroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 29, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForActivate(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForActivate Test===========");

			feemastergroup.searchBy_FeeGroup_MasterFeeGrNameInGrid(feeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForActivate Test===========");
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_ForActivate");
		}
	}

	@Test(priority = 30, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcActivationOfCreatedFeeGroup_MasterGroup(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedFeeGroup_MasterGroup Test===========");

			feemastergroup.activationOfCreatedFeeGroup_MasterGroup(feeGroup);

			log.info("============= Finished tcActivationOfCreatedFeeGroup_MasterGroup Test===========");
			getScreenShot("tcActivationOfCreatedFeeGroup_MasterGroup");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeGroup_MasterGroup");
		}
	}

	@Test(priority = 31)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			feemastergroup.clickOnCancelButton();

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

			feemastergroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 33, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_AfterCancel(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_AfterCancel Test===========");

			feemastergroup.searchBy_FeeGroup_MasterFeeGrNameInGrid(feeGroup);

			log.info("============= Finished tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeGroup_MasterFeeGrNameInGrid_AfterCancel");
		}
	}

	@Test(priority = 34, dataProvider = "Search_FeeGroup_MasterGroup")
	public void tcActivationOfCreatedFeeGroup_MasterGroup_AfterCancel(String feeGroup, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedFeeGroup_MasterGroup_AfterCancel Test===========");

			feemastergroup.activationOfCreatedFeeGroup_MasterGroup(feeGroup);
			log.info("============= Finished tcActivationOfCreatedFeeGroup_MasterGroup_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreatedFeeGroup_MasterGroup_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeGroup_MasterGroup_AfterCancel");
		}
	}

	@Test(priority = 35)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			feemastergroup.yesDeleteOrDeactivateOrActivateIt();

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

			feemastergroup.clickOnSuccessOkBtn();

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
