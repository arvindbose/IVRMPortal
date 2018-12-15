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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Master_Fine_Slab_With_ECSFLAG;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Master_Fine_Slab_With_ECSFLAG extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Master_Fine_Slab_With_ECSFLAG.class.getName());

	Masters_Master_Fine_Slab_With_ECSFLAG masterfineslabWith_EcsFlag;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MasterFineSlabTestBWData")
	public String[][] getTestDataMFSBw() {
		String[][] testRecordsMFSBW = getData("FeeModueData.xlsx", "MasterFineSlabBetweenData");
		return testRecordsMFSBW;
	}

	@DataProvider(name = "MasterFineSlabTestGr&LessData")
	public String[][] getTestDataMFSGr() {
		String[][] testRecordsMFSGr = getData("FeeModueData.xlsx", "MasterFineSlabGreater&LThanData");
		return testRecordsMFSGr;
	}

	@DataProvider(name = "FromDAYFineSlabTestData")
	public String[][] getTestDataMFSfromDay() {
		String[][] testRecordsMFSFD = getData("FeeModueData.xlsx", "FromDAYFineSlab");
		return testRecordsMFSFD;
	}

	@DataProvider(name = "ToDAYFineSlabTestData")
	public String[][] getTestDataToDay() {
		String[][] testRecordsToDay = getData("FeeModueData.xlsx", "ToDAYFineSlab");
		return testRecordsToDay;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
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
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = masterfineslabWith_EcsFlag.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToMasters_masterFineSlab() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcNavigateToMasters_masterFineSlab Test===========");

			masterfineslabWith_EcsFlag.navigateToMasters_masterFineSlab();

			log.info("============= Finished tcNavigateToMasters_masterFineSlab Test===========");
			getScreenShot("tcNavigateToMasters_masterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_masterFineSlab");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasterFineSlabPage() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcVerifyMasterFineSlabPage Test===========");

			boolean status = masterfineslabWith_EcsFlag.verifyMasterFineSlabPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasterFineSlabPage Test===========");
			getScreenShot("tcVerifyMasterFineSlabPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFineSlabPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			masterfineslabWith_EcsFlag.clickOnSaveButton_ToSubmitBlankForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 6, dataProvider = "MasterFineSlabTestBWData")
	public void tcMastersFineSlabTypeFromDayAndToDay_Between(String fineslabType, String fromDay, String toDay,
			String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_Between Test===========");

			masterfineslabWith_EcsFlag.mastersFineSlabTypeFromDayAndToDay_Between(fineslabType, fromDay, toDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_Between Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between");
		} catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_MasterFineSlab() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcMinimize_MasterFineSlab Test===========");

			masterfineslabWith_EcsFlag.minimizeAndMaximize_MasterFineSlab();

			log.info("============= Finished tcMinimize_MasterFineSlab Test===========");
			getScreenShot("tcMinimize_MasterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterFineSlab");
		}
	}

	@Test(priority = 8)
	public void tcSortByFineSlabType() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcSortByFineSlabType Test===========");

			masterfineslabWith_EcsFlag.sortByFineSlabType();

			log.info("============= Finished tcSortByFineSlabType Test===========");
			getScreenShot("tcSortByFineSlabType");
		} catch (Exception e) {
			getScreenShot("tcSortByFineSlabType");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_MasterFineSlabGridView() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcMinimize_MasterFineSlabGridView Test===========");

			masterfineslabWith_EcsFlag.minimizeAndMaximize_MasterFineSlabGridView();

			log.info("============= Finished tcMinimize_MasterFineSlabGridView Test===========");
			getScreenShot("tcMinimize_MasterFineSlabGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterFineSlabGridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_MasterFineSlab() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcMaximize_MasterFineSlab Test===========");

			masterfineslabWith_EcsFlag.minimizeAndMaximize_MasterFineSlab();

			log.info("============= Finished tcMaximize_MasterFineSlab Test===========");
			getScreenShot("tcMaximize_MasterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterFineSlab");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_MasterFineSlabGridView() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcMaximize_MasterFineSlabGridView Test===========");

			masterfineslabWith_EcsFlag.minimizeAndMaximize_MasterFineSlabGridView();

			log.info("============= Finished tcMaximize_MasterFineSlabGridView Test===========");
			getScreenShot("tcMaximize_MasterFineSlabGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterFineSlabGridView");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_ToClearFilledData() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledData Test===========");

			masterfineslabWith_EcsFlag.clickOnCancelButton_ToClearFilledData();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		}
	}

	@Test(priority = 13, dataProvider = "MasterFineSlabTestBWData")
	public void tcMastersFineSlabTypeFromDayAndToDay_Between_AfterCancel(String fineslabType, String fromDay,
			String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_Between_AfterCancel Test===========");

			masterfineslabWith_EcsFlag.mastersFineSlabTypeFromDayAndToDay_Between(fineslabType, fromDay, toDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_Between_AfterCancel Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between_AfterCancel");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSaveButton_Between() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_Between Test===========");

			masterfineslabWith_EcsFlag.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_Between Test===========");
			getScreenShot("tcClickOnSaveButton_Between");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_Between");
		}
	}

	@Test(priority = 15)
	public void tcPopUpopWindowMessage_SubmitSuccessfully_Validation_Between() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info(
					"============= Strting tcPopUpopWindowMessage_SubmitSuccessfully_Validation_Between Test===========");

			masterfineslabWith_EcsFlag.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpopWindowMessage_SubmitSuccessfully_Validation_Between Test===========");
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_Between");
		} catch (Exception e) {
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_Between");
		}
	}

	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn_Between() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Between Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Between Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Between");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Between");
		}
	}

	@Test(priority = 17, dataProvider = "MasterFineSlabTestGr&LessData")
	public void tcMastersFineSlabTypeFromDayAndToDay_GreaterThan(String fineslabType, String fromDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("Ln")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_GreaterThan Test===========");

			masterfineslabWith_EcsFlag.mastersFineSlabTypeFromDayAndToDay_GreaterThan(fineslabType, fromDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_GreaterThan Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_GreaterThan");
		}
	}

	@Test(priority = 18)
	public void tcClickOnSaveButton_GreaterThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_GreaterThan Test===========");

			masterfineslabWith_EcsFlag.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_GreaterThan Test===========");
			getScreenShot("tcClickOnSaveButton_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_GreaterThan");
		}
	}

	@Test(priority = 19)
	public void tcPopUpopWindowMessage_SubmitSuccessfully_Validation_GreaterThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info(
					"============= Strting tcPopUpopWindowMessage_SubmitSuccessfully_Validation_GreaterThan Test===========");

			masterfineslabWith_EcsFlag.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpopWindowMessage_SubmitSuccessfully_Validation_GreaterThan Test===========");
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_GreaterThan");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSuccessOkBtn_GreaterThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_GreaterThan Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_GreaterThan Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_GreaterThan");
		}
	}

	@Test(priority = 21, dataProvider = "MasterFineSlabTestGr&LessData")
	public void tcMastersFineSlabTypeFromDayAndToDay_LessThan(String fineslabType, String fromDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("Gr")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_LessThan Test===========");

			masterfineslabWith_EcsFlag.mastersFineSlabTypeFromDayAndToDay_LessThan(fineslabType, fromDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_LessThan Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_LessThan");
		} catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_LessThan");
		}
	}

	@Test(priority = 22)
	public void tcClickOnSaveButton_LessThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_LessThan Test===========");

			masterfineslabWith_EcsFlag.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_LessThan Test===========");
			getScreenShot("tcClickOnSaveButton_LessThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_LessThan");
		}
	}

	@Test(priority = 23)
	public void tcPopUpopWindowMessage_SubmitSuccessfully_Validation_LessThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info(
					"============= Strting tcPopUpopWindowMessage_SubmitSuccessfully_Validation_LessThan Test===========");

			masterfineslabWith_EcsFlag.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpopWindowMessage_SubmitSuccessfully_Validation_LessThan Test===========");
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_LessThan");
		} catch (Exception e) {
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Validation_LessThan");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSuccessOkBtn_LessThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_LessThan Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_LessThan Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_LessThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_LessThan");
		}
	}

	@Test(priority = 25, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGrid(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGrid Test===========");

			masterfineslabWith_EcsFlag.searchByToDayInGrid(toDay);

			log.info("============= Finished tcSearchByToDayInGrid Test===========");
			getScreenShot("tcSearchByToDayInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGrid");
		}
	}

	@Test(priority = 26, dataProvider = "ToDAYFineSlabTestData")
	public void tcVerifyMasterFineSlabUpdatedInGrid(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterFineSlabUpdatedInGrid Test===========");

			masterfineslabWith_EcsFlag.verifyMasterFineSlabUpdatedInGrid(toDay);

			log.info("============= Finished tcVerifyMasterFineSlabUpdatedInGrid Test===========");
			getScreenShot("tcVerifyMasterFineSlabUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFineSlabUpdatedInGrid");
		}
	}

	@Test(priority = 27, dataProvider = "ToDAYFineSlabTestData")
	public void tcEdit_masterFineSlab(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_masterFineSlab Test===========");

			masterfineslabWith_EcsFlag.edit_masterFineSlab(toDay);

			log.info("============= Finished tcEdit_masterFineSlab Test===========");
			getScreenShot("tcEdit_masterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcEdit_masterFineSlab");
		}
	}

	@Test(priority = 28, dataProvider = "FromDAYFineSlabTestData")
	public void tcEditMasterFineSlab(String fromDay, String runMode) {

		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}

		try {
			log.info("============= Strting tcEditMasterFineSlab Test===========");

			masterfineslabWith_EcsFlag.editMasterFineSlab(fromDay);

			log.info("============= Finished tcEditMasterFineSlab Test===========");
			getScreenShot("tcEditMasterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcEditMasterFineSlab");
		}
	}

	@Test(priority = 29)
	public void tcClickOnSaveButtonEdit() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			masterfineslabWith_EcsFlag.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}

	@Test(priority = 30)
	public void tcPopUpopWindowMessage_SubmitSuccessfully_Edit_Validation_LessThan() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info(
					"============= Strting tcPopUpopWindowMessage_SubmitSuccessfully_Edit_Validation_LessThan Test===========");

			masterfineslabWith_EcsFlag.popWindowMessage_SubmitSuccessfully_Edit();

			log.info(
					"============= Finished tcPopUpopWindowMessage_SubmitSuccessfully_Edit_Validation_LessThan Test===========");
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Edit_Validation_LessThan");
		} catch (Exception e) {
			getScreenShot("tcPopUpopWindowMessage_SubmitSuccessfully_Edit_Validation_LessThan");
		}
	}

	@Test(priority = 31)
	public void tcClickOnSuccessOkBtnEdit() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		}
	}

	@Test(priority = 32, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGridForDeactivation(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGridForDeactivation Test===========");

			masterfineslabWith_EcsFlag.searchByToDayInGrid(toDay);

			log.info("============= Finished tcSearchByToDayInGridForDeactivation Test===========");
			getScreenShot("tcSearchByToDayInGridForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGridForDeactivation");
		}
	}
	// deactivation

	@Test(priority = 33, dataProvider = "ToDAYFineSlabTestData")
	public void tcDeactivationOfCreated_MasterFineslab(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFineslab Test===========");

			masterfineslabWith_EcsFlag.deactivationOfCreated_MasterFineslab(toDay);

			log.info("============= Finished tcDeactivationOfCreated_MasterFineslab Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFineslab");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFineslab");
		}
	}

	@Test(priority = 34)
	public void tcClickOnCancelButton_ToCancelDeactivate() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_ToCancelDeactivate Test===========");

			masterfineslabWith_EcsFlag.clickOnCancelButton_ToCancelDeactivateOrActivate();

			log.info("============= Finished tcClickOnCancelButton_ToCancelDeactivate Test===========");
			getScreenShot("tcClickOnCancelButton_ToCancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToCancelDeactivate");
		}
	}

	@Test(priority = 35)
	public void tcPopUpWindowMessage_DeactivateCancel_Validation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");

			masterfineslabWith_EcsFlag.popUpWindowMessage_DeactivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		}
	}

	@Test(priority = 36)
	public void tcClickOnDeactivation_CancelConfirm() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnDeactivation_CancelConfirm Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivation_CancelConfirm Test===========");
			getScreenShot("tcClickOnDeactivation_CancelConfirm");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivation_CancelConfirm");
		}
	}

	@Test(priority = 37, dataProvider = "ToDAYFineSlabTestData")
	public void tcDeactivationOfCreated_MasterFineslab_AfterCancel(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFineslab_AfterCancel Test===========");

			masterfineslabWith_EcsFlag.deactivationOfCreated_MasterFineslab(toDay);

			log.info("============= Finished tcDeactivationOfCreated_MasterFineslab_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFineslab_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFineslab_AfterCancel");
		}
	}

	@Test(priority = 38)
	public void tcConfirmationForDeactivation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcConfirmationForDeactivation Test===========");

			masterfineslabWith_EcsFlag.confirmationForDeactivation();

			log.info("============= Finished tcConfirmationForDeactivation Test===========");
			getScreenShot("tcConfirmationForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation");
		}
	}

	@Test(priority = 39)
	public void tcPopUpWindowMessage_DeactivateSucessfully_Validation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");

			masterfineslabWith_EcsFlag.popUpWindowMessage_DeactivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		}
	}

	@Test(priority = 40)
	public void tcClickOnDeactivationFinalOkBtn() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}

	// Activate
	@Test(priority = 41, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGridForActivation(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGridForActivation Test===========");

			masterfineslabWith_EcsFlag.searchByToDayInGrid(toDay);

			log.info("============= Finished tcSearchByToDayInGridForActivation Test===========");
			getScreenShot("tcSearchByToDayInGridForActivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGridForActivation");
		}
	}

	@Test(priority = 42, dataProvider = "ToDAYFineSlabTestData")
	public void tcActivationOf_MasterFineSlab(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOf_MasterFineSlab Test===========");

			masterfineslabWith_EcsFlag.activationOf_MasterFineSlab(toDay);

			log.info("============= Finished tcActivationOf_MasterFineSlab Test===========");
			getScreenShot("tcActivationOf_MasterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcActivationOf_MasterFineSlab");
		}
	}

	@Test(priority = 43)
	public void tcClickOnCancelButton_ToCancelActivate() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_ToCancelActivate Test===========");

			masterfineslabWith_EcsFlag.clickOnCancelButton_ToCancelDeactivateOrActivate();

			log.info("============= Finished tcClickOnCancelButton_ToCancelActivate Test===========");
			getScreenShot("tcClickOnCancelButton_ToCancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToCancelActivate");
		}
	}

	@Test(priority = 44)
	public void tcPopUpWindowMessage_ActivateCancel_Validation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateCancel_Validation Test===========");

			masterfineslabWith_EcsFlag.popUpWindowMessage_ActivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		}
	}

	@Test(priority = 45)
	public void tcClickOnActivation_CancelConfirm() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnActivation_CancelConfirm Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnActivation_CancelConfirm Test===========");
			getScreenShot("tcClickOnActivation_CancelConfirm");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivation_CancelConfirm");
		}
	}

	@Test(priority = 46, dataProvider = "ToDAYFineSlabTestData")
	public void tcActivationOf_MasterFineSlab_AfterCancel(String toDay, String runMode) {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOf_MasterFineSlab_AfterCancel Test===========");

			masterfineslabWith_EcsFlag.activationOf_MasterFineSlab(toDay);

			log.info("============= Finished tcActivationOf_MasterFineSlab_AfterCancel Test===========");
			getScreenShot("tcActivationOf_MasterFineSlab_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOf_MasterFineSlab_AfterCancel");
		}
	}

	@Test(priority = 47)
	public void tcConfirmationForActivation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		try {
			log.info("============= Strting tcConfirmationForActivation Test===========");

			masterfineslabWith_EcsFlag.confirmationForActivation();

			log.info("============= Finished tcConfirmationForActivation Test===========");
			getScreenShot("tcConfirmationForActivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForActivation");
		}
	}

	@Test(priority = 48)
	public void tcPopUpWindowMessage_ActivateSucessfully_Validation() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);
		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");

			masterfineslabWith_EcsFlag.popUpWindowMessage_ActivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		}
	}

	@Test(priority = 49)
	public void tcClickOnActivationFinalOkBtn() {
		masterfineslabWith_EcsFlag = new Masters_Master_Fine_Slab_With_ECSFLAG(driver);

		try {
			log.info("============= Strting tcClickOnActivationFinalOkBtn Test===========");

			masterfineslabWith_EcsFlag.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnActivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnActivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationFinalOkBtn");
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
