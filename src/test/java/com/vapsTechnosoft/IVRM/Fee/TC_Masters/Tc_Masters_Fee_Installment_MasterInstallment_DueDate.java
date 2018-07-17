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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Installment_MasterInstallment_DueDate;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Installment_MasterInstallment_DueDate extends TestBase {

	public static final Logger log = Logger
			.getLogger(Tc_Masters_Fee_Installment_MasterInstallment_DueDate.class.getName());

	Masters_Fee_Installment_MasterInstallment_DueDate masterInstallmentDueDate;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "masterInstallmentDueDateData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsFeeInstallment = getData("FeeModueData.xlsx", "InstallmentDueDateData");
		return testRecordsFeeInstallment;
	}

	@DataProvider(name = "Search_DueDateInstallmentNameTestData")
	public String[][] getTestDataFeeInsName() {
		String[][] testRecordsFeeInsName = getData("FeeModueData.xlsx", "Search_DueDatFeeInstallmentName");
		return testRecordsFeeInsName;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	/**
	 * Login to application
	 * 
	 * @param username
	 * @param password
	 * @param runMode
	 */
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
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			masterInstallmentDueDate.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFeeInstallment_MasterInstallmentDueDate() {

		try {
			log.info("============= Strting tcNavigateToFeeInstallment_MasterInstallmentDueDate Test===========");

			masterInstallmentDueDate.navigateToFeeInstallment_MasterInstallmentDueDate();

			log.info("============= Finished tcNavigateToFeeInstallment_MasterInstallmentDueDate Test===========");
			getScreenShot("tcNavigateToFeeInstallment_MasterInstallmentDueDate");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFeeInstallment_MasterInstallmentDueDate");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeInstallmentScreen_DueDate() {

		try {
			log.info("============= Strting tcVerifyFeeInstallmentScreen Test===========");

			boolean status = masterInstallmentDueDate.verifyFeeInstallmentScreen_DueDate();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeInstallmentScreen Test===========");
			getScreenShot("tcVerifyFeeInstallmentScreen");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeInstallmentScreen");
		}
	}

	@Test(priority = 5, dataProvider = "masterInstallmentDueDateData")
	public void tcSelectAcademicYearAndInstallmentType(String academicYear, String installmentType, String runMode) {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearAndInstallmentType Test===========");

			masterInstallmentDueDate.selectAcademicYearAndInstallmentType(academicYear, installmentType);

			log.info("============= Finished tcSelectAcademicYearAndInstallmentType Test===========");
			getScreenShot("tcSelectAcademicYearAndInstallmentType");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearAndInstallmentType");
		}
	}

	@Test(priority = 6)
	public void tcDueDate_FirstInstallment_CalendarEntry() {

		try {
			log.info("============= Strting tcDueDate_FirstInstallment_CalendarEntry Test===========");

			masterInstallmentDueDate.dueDate_FirstInstallment_CalendarEntry();

			log.info("============= Finished tcDueDate_FirstInstallment_CalendarEntry Test===========");
			getScreenShot("tcDueDate_FirstInstallment_CalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FirstInstallment_CalendarEntry");
		}
	}

	@Test(priority = 7)
	public void tcDueDate_SecondInstallment_CalendarEntry() {

		try {
			log.info("============= Strting tcDueDate_SecondInstallment_CalendarEntry Test===========");

			masterInstallmentDueDate.dueDate_SecondInstallment_CalendarEntry();

			log.info("============= Finished tcDueDate_SecondInstallment_CalendarEntry Test===========");
			getScreenShot("tcDueDate_SecondInstallment_CalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDate_SecondInstallment_CalendarEntry");
		}
	}

	@Test(priority = 8)
	public void tcDueDate_ThirdInstallment_CalendarEntry() {

		try {
			log.info("============= Strting tcDueDate_ThirdInstallment_CalendarEntry Test===========");

			masterInstallmentDueDate.dueDate_ThirdInstallment_CalendarEntry();

			log.info("============= Finished tcDueDate_ThirdInstallment_CalendarEntry Test===========");
			getScreenShot("tcDueDate_ThirdInstallment_CalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDate_ThirdInstallment_CalendarEntry");
		}
	}

	@Test(priority = 9)
	public void tcDueDate_FourthInstallment_CalendarEntry() {

		try {
			log.info("============= Strting tcDueDate_FourthInstallment_CalendarEntry Test===========");

			masterInstallmentDueDate.dueDate_FourthInstallment_CalendarEntry();

			log.info("============= Finished tcDueDate_FourthInstallment_CalendarEntry Test===========");
			getScreenShot("tcDueDate_FourthInstallment_CalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FourthInstallment_CalendarEntry");
		}
	}

	@Test(priority = 10)
	public void tcDueDate_FifthInstallment_CalendarEntry() {

		try {
			log.info("============= Strting tcDueDate_FifthInstallment_CalendarEntry Test===========");

			masterInstallmentDueDate.dueDate_FifthInstallment_CalendarEntry();

			log.info("============= Finished tcDueDate_FifthInstallment_CalendarEntry Test===========");
			getScreenShot("tcDueDate_FifthInstallment_CalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FifthInstallment_CalendarEntry");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_MasterInstallmentDueDate() {

		try {
			log.info("============= Strting tcMinimize_MasterInstallmentDueDate Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_MasterInstallmentDueDate();

			log.info("============= Finished tcMinimize_MasterInstallmentDueDate Test===========");
			getScreenShot("tcMinimize_MasterInstallmentDueDate");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterInstallmentDueDate");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_FeeMasterInstallmentGridView() {

		try {
			log.info("============= Strting tcMinimize_FeeMasterInstallmentGridView Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_FeeMasterInstallmentGridView();

			log.info("============= Finished tcMinimize_FeeMasterInstallmentGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterInstallmentGridView");
		}
	}

	@Test(priority = 13)
	public void tcSortByMasterInstallmentName() {

		try {
			log.info("============= Strting tcSortByMasterInstallmentName Test===========");
			getScreenShot("BeforeSorting_tcSortByMasterInstallmentName");

			masterInstallmentDueDate.sortByMasterInstallmentName();

			log.info("============= Finished tcSortByMasterInstallmentName Test===========");
			getScreenShot("tcSortByMasterInstallmentName");
		} catch (Exception e) {
			getScreenShot("tcSortByMasterInstallmentName");
		}
	}

	@Test(priority = 14)
	public void tcMinimize_FeeMasterInstallmentDueDateGridView() {

		try {
			log.info("============= Strting tcMinimize_FeeMasterInstallmentDueDateGridView Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_FeeMasterInstallmentDueDateGridView();

			log.info("============= Finished tcMinimize_FeeMasterInstallmentDueDateGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterInstallmentDueDateGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterInstallmentDueDateGridView");
		}
	}

	@Test(priority = 15)
	public void tcMaximize_FeeMasterInstallmentDueDateGridView() {

		try {
			log.info("============= Strting tcMaximize_FeeMasterInstallmentDueDateGridView Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_FeeMasterInstallmentDueDateGridView();

			log.info("============= Finished tcMaximize_FeeMasterInstallmentDueDateGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterInstallmentDueDateGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterInstallmentDueDateGridView");
		}
	}

	@Test(priority = 16)
	public void tcMaximize_FeeMasterInstallmentGridView() {

		try {
			log.info("============= Strting tcMaximize_FeeMasterInstallmentGridView Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_FeeMasterInstallmentGridView();

			log.info("============= Finished tcMaximize_FeeMasterInstallmentGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterInstallmentGridView");
		}
	}

	@Test(priority = 17)
	public void tcMaximize_MasterInstallmentDueDate() {

		try {
			log.info("============= Strting tcMaximize_MasterInstallmentDueDate Test===========");

			masterInstallmentDueDate.minimizeAndMaximize_MasterInstallmentDueDate();

			log.info("============= Finished tcMaximize_MasterInstallmentDueDate Test===========");
			getScreenShot("tcMaximize_MasterInstallmentDueDate");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterInstallmentDueDate");
		}
	}

	@Test(priority = 18)
	public void tcClickOnCancelButton_ToClearedFilledForm() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearedFilledForm Test===========");

			masterInstallmentDueDate.clickOnCancelButton_ToClearedFilledForm();

			log.info("============= Finished tcClickOnCancelButton_ToClearedFilledForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearedFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearedFilledForm");
		}
	}

	@Test(priority = 19, dataProvider = "masterInstallmentDueDateData")
	public void tcSelectAcademicYearAndInstallmentType_AfterClearingFilledData(String academicYear,
			String installmentType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectAcademicYearAndInstallmentType_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.selectAcademicYearAndInstallmentType(academicYear, installmentType);

			log.info(
					"============= Finished tcSelectAcademicYearAndInstallmentType_AfterClearingFilledData Test===========");
			getScreenShot("tcSelectAcademicYearAndInstallmentType_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearAndInstallmentType_AfterClearingFilledData");
		}
	}

	@Test(priority = 20)
	public void tcDueDate_FirstInstallment_CalendarEntry_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcDueDate_FirstInstallment_CalendarEntry_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.dueDate_FirstInstallment_CalendarEntry();

			log.info(
					"============= Finished tcDueDate_FirstInstallment_CalendarEntry_AfterClearingFilledData Test===========");
			getScreenShot("tcDueDate_FirstInstallment_CalendarEntry_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FirstInstallment_CalendarEntry_AfterClearingFilledData");
		}
	}

	@Test(priority = 21)
	public void tcDueDate_SecondInstallment_CalendarEntry_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcDueDate_SecondInstallment_CalendarEntry_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.dueDate_SecondInstallment_CalendarEntry();

			log.info(
					"============= Finished tcDueDate_SecondInstallment_CalendarEntry_AfterClearingFilledData Test===========");
			getScreenShot("tcDueDate_SecondInstallment_CalendarEntry_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcDueDate_SecondInstallment_CalendarEntry_AfterClearingFilledData");
		}
	}

	@Test(priority = 22)
	public void tcDueDate_ThirdInstallment_CalendarEntry_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcDueDate_ThirdInstallment_CalendarEntry_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.dueDate_ThirdInstallment_CalendarEntry();

			log.info(
					"============= Finished tcDueDate_ThirdInstallment_CalendarEntry_AfterClearingFilledData Test===========");
			getScreenShot("tcDueDate_ThirdInstallment_CalendarEntry_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcDueDate_ThirdInstallment_CalendarEntry_AfterClearingFilledData");
		}
	}

	@Test(priority = 23)
	public void tcDueDate_FourthInstallment_CalendarEntry_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcDueDate_FourthInstallment_CalendarEntry_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.dueDate_FourthInstallment_CalendarEntry();

			log.info(
					"============= Finished tcDueDate_FourthInstallment_CalendarEntry_AfterClearingFilledData Test===========");
			getScreenShot("tcDueDate_FourthInstallment_CalendarEntry_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FourthInstallment_CalendarEntry_AfterClearingFilledData");
		}
	}

	@Test(priority = 24)
	public void tcDueDate_FifthInstallment_CalendarEntry_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcDueDate_FifthInstallment_CalendarEntry_AfterClearingFilledData Test===========");

			masterInstallmentDueDate.dueDate_FifthInstallment_CalendarEntry();

			log.info(
					"============= Finished tcDueDate_FifthInstallment_CalendarEntry_AfterClearingFilledData Test===========");
			getScreenShot("tcDueDate_FifthInstallment_CalendarEntry_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcDueDate_FifthInstallment_CalendarEntry_AfterClearingFilledData");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSaveButton() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			masterInstallmentDueDate.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 26)
	public void tcVerifySuccessfulPopUp() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = masterInstallmentDueDate.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 27)
	public void tcClickOnSuccessOkBtn() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			masterInstallmentDueDate.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 28, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView Test===========");

			masterInstallmentDueDate.searchBy_InstallmentName_InFeeInstallmentDueDateGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView");
		}
	}

	@Test(priority = 29, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcVerifyMasterFeeInstallmentName_UpdatedInGrid(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterFeeInstallmentName_UpdatedInGrid Test===========");

			masterInstallmentDueDate.verifyMasterFeeInstallmentName_UpdatedInGrid(installmentName);

			log.info("============= Finished tcVerifyMasterFeeInstallmentName_UpdatedInGrid Test===========");
			getScreenShot("tcVerifyMasterFeeInstallmentName_UpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFeeInstallmentName_UpdatedInGrid");
		}
	}

	@Test(priority = 30, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcEdit_MasterFeeInstallmentDueDate(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_MasterFeeInstallmentDueDate Test===========");

			masterInstallmentDueDate.edit_MasterFeeInstallmentDueDate(installmentName);
			log.info("============= Finished tcEdit_MasterFeeInstallmentDueDate Test===========");
			getScreenShot("tcEdit_MasterFeeInstallmentDueDate");
		} catch (Exception e) {
			getScreenShot("tcEdit_MasterFeeInstallmentDueDate");
		}
	}

	@Test(priority = 31)
	public void tcClickOnSaveButton_MasterFeeInstallmentForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_MasterFeeInstallmentForm_Edit Test===========");

			masterInstallmentDueDate.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_MasterFeeInstallmentForm_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_MasterFeeInstallmentForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_MasterFeeInstallmentForm_Edit");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterInstallmentDueDate.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	//

	@Test(priority = 33, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete Test===========");

			masterInstallmentDueDate.searchBy_InstallmentName_InFeeInstallmentDueDateGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete");
		}
	}

	@Test(priority = 34, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcDeletionOf_MasterFeeInstallmentDueDateFromGrid(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeletionOf_MasterFeeInstallmentDueDateFromGrid Test===========");

			masterInstallmentDueDate.deletionOf_MasterFeeInstallmentDueDateFromGrid(installmentName);

			log.info("============= Finished tcDeletionOf_MasterFeeInstallmentDueDateFromGrid Test===========");
			getScreenShot("tcDeletionOf_MasterFeeInstallmentDueDateFromGrid");
		} catch (Exception e) {
			getScreenShot("tcDeletionOf_MasterFeeInstallmentDueDateFromGrid");
		}
	}

	@Test(priority = 35)
	public void tcClickOnCancelButton_PopUp_delete() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_delete Test===========");

			masterInstallmentDueDate.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_delete Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_delete");
		}
	}

	@Test(priority = 36)
	public void tcClickOnOkSuccessButton_deleteCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deleteCancel Test===========");

			masterInstallmentDueDate.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deleteCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		}
	}

	@Test(priority = 37, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete_AfterCancel(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete_AfterCancel Test===========");

			masterInstallmentDueDate.searchBy_InstallmentName_InFeeInstallmentDueDateGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete_AfterCancel Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeInstallmentDueDateGridView_ForDelete_AfterCancel");
		}
	}

	@Test(priority = 38, dataProvider = "Search_DueDateInstallmentNameTestData")
	public void tcDeletionOf_MasterFeeInstallmentDueDateFromGrid_AfterCancel(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcDeletionOf_MasterFeeInstallmentDueDateFromGrid_AfterCancel Test===========");

			masterInstallmentDueDate.deletionOf_MasterFeeInstallmentDueDateFromGrid(installmentName);

			log.info(
					"============= Finished tcDeletionOf_MasterFeeInstallmentDueDateFromGrid_AfterCancel Test===========");
			getScreenShot("tcDeletionOf_MasterFeeInstallmentDueDateFromGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeletionOf_MasterFeeInstallmentDueDateFromGrid_AfterCancel");
		}
	}

	@Test(priority = 39)
	public void tcYesDeleteOrDeactivateOrActivateIt_delete() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_delete Test===========");

			masterInstallmentDueDate.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_delete Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_delete");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_delete");
		}
	}

	@Test(priority = 40)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			masterInstallmentDueDate.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
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
