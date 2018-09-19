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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_BatchWise_Student_Mapping;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_BatchWise_Student_Mapping extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_BatchWise_Student_Mapping.class.getName());

	Masters_BatchWise_Student_Mapping batchwiseStudentmapp;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersCreateBatchData")
	public String[][] getTestData() {
		String[][] testRecordsCreateBatchDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_BSMCreateBatchData");
		return testRecordsCreateBatchDetails;
	}

	@DataProvider(name = "MastersUpdateBatchData")
	public String[][] getTestDataUpdateBatch() {
		String[][] testRecordsUpdateBatchDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_BSMUpdateBatchData");
		return testRecordsUpdateBatchDetails;
	}

	@DataProvider(name = "AcademicYrSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_AcademicYrSearchData");
		return testRecordsSearch;
	}
	
	@DataProvider(name = "BatchNameSearchData")
	public String[][] getTestBatchNameSearchData() {
		String[][] testRecordsBatchNameSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_BatchNameSearchData");
		return testRecordsBatchNameSearch;
	}

//	@DataProvider(name = "MastersClassTeacherXchangeData")
//	public String[][] getTestDataXchange() {
//		String[][] testRecordsClassTeacherXchangeDetails = getData("BGHS_AdmissionData.xlsx",
//				"BGHS_ClassTeachereXchangeData");
//		return testRecordsClassTeacherXchangeDetails;
//	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		batchwiseStudentmapp = new Masters_BatchWise_Student_Mapping(driver);
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

			boolean status = batchwiseStudentmapp.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_BatchWiseStudentMapping_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Masters_BatchWiseStudentMapping_BGHS Test===========");

			batchwiseStudentmapp.navigateToAdmission_Masters_BatchWiseStudentMapping_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Masters_BatchWiseStudentMapping_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_BatchWiseStudentMapping_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_BatchWiseStudentMapping_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_BatchWiseStudentMapp_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_BatchWiseStudentMapp_BGHSPage Test===========");

			boolean status = batchwiseStudentmapp.verifyMasters_BatchWiseStudentMapp_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_BatchWiseStudentMapp_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_BatchWiseStudentMapp_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_BatchWiseStudentMapp_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSelectRadioButtonTo_CreateNewBatch() {

		try {
			log.info("============= Starting tcSelectRadioButtonTo_CreateNewBatch Test===========");

			batchwiseStudentmapp.selectRadioButtonTo_CreateNewBatch();

			log.info("============= Finished tcSelectRadioButtonTo_CreateNewBatch Test===========");
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch");
		} catch (Exception e) {
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch");
		}
	}

	@Test(priority = 6, dataProvider = "MastersCreateBatchData")
	public void tcFillBatchwiseStudentMappFormTo_CreateNewBatch(String academicYr, String classBatch, String section,
			String subject, String batchName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSelectRadioButtonTo_CreateNewBatch Test===========");

			batchwiseStudentmapp.fillBatchwiseStudentMappFormTo_CreateNewBatch(academicYr, classBatch, section, subject,
					batchName);

			log.info("============= Finished tcSelectRadioButtonTo_CreateNewBatch Test===========");
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch");
		} catch (Exception e) {
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch");
		}
	}

	@Test(priority = 7, dataProvider = "AcademicYrSearchData")
	public void tcSearchWithRegNoAcademicYearTo_SelectStudent(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSearchWithRegNoAcademicYearTo_SelectStudent Test===========");

			batchwiseStudentmapp.searchWithRegNoAcademicYearTo_SelectStudent(academicYr);

			log.info("============= Finished tcSearchWithRegNoAcademicYearTo_SelectStudent Test===========");
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent");
		} catch (Exception e) {
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent");
		}
	}

	@Test(priority = 8, dataProvider = "AcademicYrSearchData")
	public void tcSelectStudentToMappWithBatchFromStudentList(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSelectStudentToMappWithBatchFromStudentList Test===========");

			batchwiseStudentmapp.selectStudentToMappWithBatchFromStudentList(academicYr);

			log.info("============= Finished tcSelectStudentToMappWithBatchFromStudentList Test===========");
			getScreenShot("tcSelectStudentToMappWithBatchFromStudentList");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentToMappWithBatchFromStudentList");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeBatchWiseStudentMapping() {

		try {
			log.info("============= Starting tcMinimizeBatchWiseStudentMapping Test===========");

			batchwiseStudentmapp.minimizeBatchWiseStudentMapping();
			log.info("============= Finished tcMinimizeBatchWiseStudentMapping Test===========");
			getScreenShot("tcMinimizeBatchWiseStudentMapping");
		} catch (Exception e) {
			getScreenShot("tcMinimizeBatchWiseStudentMapping");
		}
	}

	@Test(priority = 10)
	public void tcSortStudentListByStudentName() {

		try {
			log.info("============= Starting tcSortStudentListByStudentName Test===========");
			getScreenShot("tcSortStudentListByStudentName_Before Sorting");
			batchwiseStudentmapp.sortStudentListByStudentName();
			log.info("============= Finished tcSortStudentListByStudentName Test===========");
			getScreenShot("tcSortStudentListByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSortStudentListByStudentName");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeStudentList() {

		try {
			log.info("============= Starting tcMinimizeStudentList Test===========");

			batchwiseStudentmapp.minimizeStudentList();
			log.info("============= Finished tcMinimizeStudentList Test===========");
			getScreenShot("tcMinimizeStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentList");
		}
	}

	@Test(priority = 12)
	public void tcSortStudentMappListByStudentName() {

		try {
			log.info("============= Starting tcSortStudentMappListByStudentName Test===========");
			getScreenShot("tcSortStudentMappListByStudentName_Before Sorting");
			batchwiseStudentmapp.sortStudentMappListByStudentName();
			log.info("============= Finished tcSortStudentMappListByStudentName Test===========");
			getScreenShot("tcSortStudentMappListByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSortStudentMappListByStudentName");
		}
	}

	@Test(priority = 13)
	public void tcMinimizeStudentMappList() {

		try {
			log.info("============= Starting tcMinimizeStudentMappList Test===========");

			batchwiseStudentmapp.minimizeStudentMappList();
			log.info("============= Finished tcMinimizeStudentMappList Test===========");
			getScreenShot("tcMinimizeStudentMappList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentMappList");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeBatchWiseStudentMapping() {

		try {
			log.info("============= Starting tcMaximizeBatchWiseStudentMapping Test===========");

			batchwiseStudentmapp.maximizeBatchWiseStudentMapping();
			log.info("============= Finished tcMaximizeBatchWiseStudentMapping Test===========");
			getScreenShot("tcMaximizeBatchWiseStudentMapping");
		} catch (Exception e) {
			getScreenShot("tcMaximizeBatchWiseStudentMapping");
		}
	}

	@Test(priority = 15)
	public void tcMaximizeStudentList() {

		try {
			log.info("============= Starting tcMaximizeStudentList Test===========");

			batchwiseStudentmapp.maximizeStudentList();
			log.info("============= Finished tcMaximizeStudentList Test===========");
			getScreenShot("tcMaximizeStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentList");
		}
	}

	@Test(priority = 16)
	public void tcMaximizeStudentMappList() {

		try {
			log.info("============= Starting tcMaximizeStudentMappList Test===========");

			batchwiseStudentmapp.maximizeStudentMappList();
			log.info("============= Finished tcMaximizeStudentMappList Test===========");
			getScreenShot("tcMaximizeStudentMappList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentMappList");
		}
	}

	@Test(priority = 17)
	public void tcClearBatchWiseStudentMappInfoData() {

		try {
			log.info("============= Starting tcClearBatchWiseStudentMappInfoData Test===========");

			batchwiseStudentmapp.clearBatchWiseStudentMappInfoData();
			log.info("============= Finished tcClearBatchWiseStudentMappInfoData Test===========");
			getScreenShot("tcClearBatchWiseStudentMappInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearBatchWiseStudentMappInfoData");
		}
	}

	@Test(priority = 18)
	public void tcSelectRadioButtonTo_CreateNewBatch_AfterClear() {

		try {
			log.info("============= Starting tcSelectRadioButtonTo_CreateNewBatch_AfterClear Test===========");

			batchwiseStudentmapp.selectRadioButtonTo_CreateNewBatch();

			log.info("============= Finished tcSelectRadioButtonTo_CreateNewBatch_AfterClear Test===========");
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectRadioButtonTo_CreateNewBatch_AfterClear");
		}
	}

	@Test(priority = 19, dataProvider = "MastersCreateBatchData")
	public void tcFillBatchwiseStudentMappFormTo_CreateNewBatch_AfterClear(String academicYr, String classBatch,
			String section, String subject, String batchName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Starting tcFillBatchwiseStudentMappFormTo_CreateNewBatch_AfterClear Test===========");

			batchwiseStudentmapp.fillBatchwiseStudentMappFormTo_CreateNewBatch(academicYr, classBatch, section, subject,
					batchName);

			log.info(
					"============= Finished tcFillBatchwiseStudentMappFormTo_CreateNewBatch_AfterClear Test===========");
			getScreenShot("tcFillBatchwiseStudentMappFormTo_CreateNewBatch_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillBatchwiseStudentMappFormTo_CreateNewBatch_AfterClear");
		}
	}

	@Test(priority = 20, dataProvider = "AcademicYrSearchData")
	public void tcSearchWithRegNoAcademicYearTo_SelectStudent_AfterClear(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSearchWithRegNoAcademicYearTo_SelectStudent_AfterClear Test===========");

			batchwiseStudentmapp.searchWithRegNoAcademicYearTo_SelectStudent(academicYr);

			log.info("============= Finished tcSearchWithRegNoAcademicYearTo_SelectStudent_AfterClear Test===========");
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent_AfterClear");
		}
	}

	@Test(priority = 21, dataProvider = "AcademicYrSearchData")
	public void tcSelectStudentToMappWithBatchFromStudentList_AfterClear(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSelectStudentToMappWithBatchFromStudentList_AfterClear Test===========");

			batchwiseStudentmapp.selectStudentToMappWithBatchFromStudentList(academicYr);

			log.info("============= Finished tcSelectStudentToMappWithBatchFromStudentList_AfterClear Test===========");
			getScreenShot("tcSelectStudentToMappWithBatchFromStudentList_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentToMappWithBatchFromStudentList_AfterClear");
		}
	}

	@Test(priority = 22)
	 public void tcSaveBatchWiseStudentMappInfoData() {
	
	 try {
	 log.info("============= Starting tcSaveBatchWiseStudentMappInfoData Test===========");
	
	 batchwiseStudentmapp.saveBatchWiseStudentMappInfoData();
	 log.info("============= Finished tcSaveBatchWiseStudentMappInfoData Test===========");
	 getScreenShot("tcSaveBatchWiseStudentMappInfoData");
	 } catch (Exception e) {
	 getScreenShot("tcSaveBatchWiseStudentMappInfoData");
	 }
	 }

	@Test(priority = 23)
	 public void tcClickOnOkSuccessButton() {
	
	 try {
	 log.info("============= Strting tcClickOnOkSuccessButton Test===========");
	
	 batchwiseStudentmapp.clickOnOkSuccessButton();
	
	 log.info("============= Finished tcClickOnOkSuccessButton Test===========");
	 getScreenShot("tcClickOnOkSuccessButton");
	 } catch (Exception e) {
	 getScreenShot("tcClickOnOkSuccessButton");
	 }
	 }
	@Test(priority = 24, dataProvider = "BatchNameSearchData")
	public void tcSearchWithBatchNameIntheGrid(String batchName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSearchWithBatchNameIntheGrid Test===========");

			batchwiseStudentmapp.searchWithBatchNameIntheGrid(batchName);

			log.info("============= Finished tcSearchWithBatchNameIntheGrid Test===========");
			getScreenShot("tcSearchWithBatchNameIntheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithBatchNameIntheGrid");
		}
	}

	@Test(priority = 25, dataProvider = "BatchNameSearchData")
	public void tcVerifyBatchNameUpdatedInTheGrid(String batchName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyBatchNameUpdatedInTheGrid Test===========");

			batchwiseStudentmapp.verifyBatchNameUpdatedInTheGrid(batchName);

			log.info("============= Finished tcVerifyBatchNameUpdatedInTheGrid Test===========");
			getScreenShot("tcVerifyBatchNameUpdatedInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyBatchNameUpdatedInTheGrid");
		}
	}

	@Test(priority = 26)
	public void tcSelectRadioButtonTo_UpdateCreatedBatch() {

		try {
			log.info("============= Starting tcSelectRadioButtonTo_UpdateCreatedBatch Test===========");

			batchwiseStudentmapp.selectRadioButtonTo_UpdateCreatedBatch();

			log.info("============= Finished tcSelectRadioButtonTo_UpdateCreatedBatch Test===========");
			getScreenShot("tcSelectRadioButtonTo_UpdateCreatedBatch");
		} catch (Exception e) {
			getScreenShot("tcSelectRadioButtonTo_UpdateCreatedBatch");
		}
	}

	@Test(priority = 27, dataProvider = "MastersUpdateBatchData")
	public void tcFillBatchwiseStudentMappFormTo_UpdateBatch(String academicYr, String classBatch, String section,
			String subject, String batchName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcFillBatchwiseStudentMappFormTo_UpdateBatch Test===========");

			batchwiseStudentmapp.fillBatchwiseStudentMappFormTo_UpdateBatch(academicYr, classBatch, section, subject,
					batchName);

			log.info("============= Finished tcFillBatchwiseStudentMappFormTo_UpdateBatch Test===========");
			getScreenShot("tcFillBatchwiseStudentMappFormTo_UpdateBatch");
		} catch (Exception e) {
			getScreenShot("tcFillBatchwiseStudentMappFormTo_UpdateBatch");
		}
	}

	@Test(priority = 28, dataProvider = "AcademicYrSearchData")
	public void tcSearchWithRegNoAcademicYearTo_SelectStudent_ToUpdate(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcSearchWithRegNoAcademicYearTo_SelectStudent_ToUpdate Test===========");

			batchwiseStudentmapp.searchWithRegNoAcademicYearTo_SelectStudent(academicYr);

			log.info("============= Finished tcSearchWithRegNoAcademicYearTo_SelectStudent_ToUpdate Test===========");
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent_ToUpdate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithRegNoAcademicYearTo_SelectStudent_ToUpdate");
		}
	}

	@Test(priority = 29)
	public void tcSaveBatchWiseStudentMappInfoData_Update() {

		try {
			log.info("============= Starting tcSaveBatchWiseStudentMappInfoData_Update Test===========");

			batchwiseStudentmapp.saveBatchWiseStudentMappInfoData();
			log.info("============= Finished tcSaveBatchWiseStudentMappInfoData_Update Test===========");
			getScreenShot("tcSaveBatchWiseStudentMappInfoData_Update");
		} catch (Exception e) {
			getScreenShot("tcSaveBatchWiseStudentMappInfoData_Update");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_Update() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Update Test===========");

			batchwiseStudentmapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Update Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Update");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Update");
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
