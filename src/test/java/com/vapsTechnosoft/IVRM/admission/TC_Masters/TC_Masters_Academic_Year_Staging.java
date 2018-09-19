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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Academic_Year_Staging;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Academic_Year_Staging extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Academic_Year_Staging.class.getName());

	Masters_Academic_Year_Staging academicYear;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "Masters_AcdemicYearData")
	public String[][] getTestYearData() {
		String[][] testRecordsAcdemicYear = getData("BGHS_AdmissionData.xlsx", "AcademicYearData");
		return testRecordsAcdemicYear;
	}

	@DataProvider(name = "MastersAcdemicYearData")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_AcademicYearData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "MastersAcdemicYearSearchData")
	public String[][] getTestAcaYrData() {
		String[][] testRecordsAcaYr = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchAcademic_Year");
		return testRecordsAcaYr;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		academicYear = new Masters_Academic_Year_Staging(driver);
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

			boolean status = academicYear.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_AcademicYear_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_AcademicYear_BGHS Test===========");

			academicYear.navigateToAdmission_Masters_AcademicYear_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_AcademicYear_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_AcademicYear_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_AcademicYear_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_AcademicYear_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_AcademicYear_BGHSPage Test===========");

			boolean status = academicYear.verifyMasters_AcademicYear_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_AcademicYear_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_AcademicYear_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_AcademicYear_BGHSPage");
		}
	}
	
	@Test(priority = 5)
	public void tcSubmitBlankMasterAcademicYearForm() {

		try {
			log.info("============= Starting tcSubmitBlankMasterAcademicYearForm Test===========");

			academicYear.submitBlankMasterAcademicYearForm();

			log.info("============= Finished tcSubmitBlankMasterAcademicYearForm Test===========");
			getScreenShot("tcSubmitBlankMasterAcademicYearForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterAcademicYearForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "Masters_AcdemicYearData")
	public void tcFillAcademicYearDetailsForm(String FromAcademicYr,String academicYrOrder,String instituition, String runMode) {

		if (runMode.equalsIgnoreCase("BGHS")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillAcademicYearDetailsForm Test===========");

			academicYear.fillAcademicYearDetailsForm(FromAcademicYr,academicYrOrder,instituition);

			log.info("============= Finished tcFillAcademicYearDetailsForm Test===========");
			getScreenShot("tcFillAcademicYearDetailsForm");
		} catch (Exception e) {
			getScreenShot("tcFillAcademicYearDetailsForm");
		}
	}

//
//	@Test(priority = 6, dataProvider = "MastersAcdemicYearData")
//	public void tcEnterMastersAcademicYearDetails(String FromAcademicYr, String startdate, String end_date,
//			String preAdmStartDate, String preAdmEndDate, String academicYrOrder, String cutoffDate,
//			String instituition, String runMode) {
//
//		if (runMode.equalsIgnoreCase("BGHS")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcEnterMastersAcademicYearDetails Test===========");
//
//			academicYear.enterMastersAcademicYearDetails(FromAcademicYr, startdate, end_date, preAdmStartDate,
//					preAdmEndDate, academicYrOrder, cutoffDate, instituition);
//
//			log.info("============= Finished tcEnterMastersAcademicYearDetails Test===========");
//			getScreenShot("tcEnterMastersAcademicYearDetails");
//		} catch (Exception e) {
//			getScreenShot("tcEnterMastersAcademicYearDetails");
//		}
//	}

	
	@Test(priority = 7)
	public void tcMinimizeMasterAcademicYear() {

		try {
			log.info("============= Strting tcMinimizeMasterAcademicYear Test===========");

			academicYear.minimizeMasterAcademicYear();

			log.info("============= Finished tcMinimizeMasterAcademicYear Test===========");
			getScreenShot("tcMinimizeMasterAcademicYear");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterAcademicYear");
		}
	}
	@Test(priority = 8)
	public void tcSortByAcademicYear() {

		try {
			log.info("============= Strting tcSortByAcademicYear Test===========");
			
			getScreenShot("tcSortByAcademicYear_BeforeSorting");
			
			academicYear.sortByAcademicYear();

			log.info("============= Finished tcSortByAcademicYear Test===========");
			getScreenShot("tcSortByAcademicYear");
		} catch (Exception e) {
			getScreenShot("tcSortByAcademicYear");
		}
	} 
	

	@Test(priority = 9)
	public void tcMaximizeMasterAcademicYear() {

		try {
			log.info("============= Strting tcMaximizeMasterAcademicYear Test===========");

			academicYear.maximizeMasterAcademicYear();

			log.info("============= Finished tcMaximizeMasterAcademicYear Test===========");
			getScreenShot("tcMaximizeMasterAcademicYear");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterAcademicYear");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeAcademicYearGrid() {

		try {
			log.info("============= Strting tcMinimizeAcademicYearGrid Test===========");

			academicYear.minimizeAcademicYearGrid();

			log.info("============= Finished tcMinimizeAcademicYearGrid Test===========");
			getScreenShot("tcMinimizeAcademicYearGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAcademicYearGrid");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeAcademicYearGrid() {

		try {
			log.info("============= Strting tcMaximizeAcademicYearGrid Test===========");

			academicYear.maximizeAcademicYearGrid();

			log.info("============= Finished tcMaximizeAcademicYearGrid Test===========");
			getScreenShot("tcMaximizeAcademicYearGrid");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAcademicYearGrid");
		}
	}
	@Test(priority = 12)
	public void tcClickOnClearButton_ToClearedFilledData() {

		try {
			log.info("============= Strting tcClickOnClearButton_ToClearedFilledData Test===========");

			academicYear.clickOnClearButton();

			log.info("============= Finished tcClickOnClearButton_ToClearedFilledData Test===========");
			getScreenShot("tcClickOnClearButton_ToClearedFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnClearButton_ToClearedFilledData");
		}
	}
	@Test(priority = 13, dataProvider = "Masters_AcdemicYearData")
	public void tcFillAcademicYearDetailsForm_AfterClear(String FromAcademicYr,String academicYrOrder,String instituition, String runMode) {

		if (runMode.equalsIgnoreCase("BGHS")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillAcademicYearDetailsForm_AfterClear Test===========");

			academicYear.fillAcademicYearDetailsForm(FromAcademicYr,academicYrOrder,instituition);

			log.info("============= Finished tcFillAcademicYearDetailsForm_AfterClear Test===========");
			getScreenShot("tcFillAcademicYearDetailsForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillAcademicYearDetailsForm_AfterClear");
		}
	}
	
//	@Test(priority = 13, dataProvider = "MastersAcdemicYearData")
//	public void tcEnterMastersAcademicYearDetails_AfterClear(String FromAcademicYr, String startdate, String end_date,
//			String preAdmStartDate, String preAdmEndDate, String academicYrOrder, String cutoffDate,
//			String instituition, String runMode) {
//
//		if (runMode.equalsIgnoreCase("BGHS")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcEnterMastersAcademicYearDetails_AfterClear Test===========");
//
//			academicYear.enterMastersAcademicYearDetails(FromAcademicYr, startdate, end_date, preAdmStartDate,
//					preAdmEndDate, academicYrOrder, cutoffDate, instituition);
//
//			log.info("============= Finished tcEnterMastersAcademicYearDetails_AfterClear Test===========");
//			getScreenShot("tcEnterMastersAcademicYearDetails_AfterClear");
//		} catch (Exception e) {
//			getScreenShot("tcEnterMastersAcademicYearDetails_AfterClear");
//		}
//	}

	@Test(priority = 14)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			academicYear.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 16, dataProvider = "MastersAcdemicYearSearchData")
	public void tcSearchWithAcademicYear(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithAcademicYear Test===========");

			academicYear.searchWithAcademicYear(academicyear);

			log.info("============= Finished tcSearchWithAcademicYear Test===========");
			getScreenShot("tcSearchWithAcademicYear");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAcademicYear");
		}
	}

	@Test(priority = 17, dataProvider = "MastersAcdemicYearSearchData")
	public void tcEditAcademicYears(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditAcademicYears Test===========");

			academicYear.editAcademicYears(academicyear);

			log.info("============= Finished tcEditAcademicYears Test===========");
			getScreenShot("tcEditAcademicYears");
		} catch (Exception e) {
			getScreenShot("tcEditAcademicYears");
		}
	}

	@Test(priority = 18)
	public void tcClickOnSaveButton_edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_edit Test===========");

			academicYear.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_edit Test===========");
			getScreenShot("tcClickOnSaveButton_edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_edit");
		}
	}

	@Test(priority = 19)
	public void tcClickOnOkSuccessButton_edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_edit Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_edit");
		}
	}
	
	@Test(priority = 20, dataProvider = "MastersAcdemicYearSearchData")
	public void tcSearchWithAcademicYear_ForDeactivate(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithAcademicYear_ForDeactivate Test===========");

			academicYear.searchWithAcademicYear(academicyear);

			log.info("============= Finished tcSearchWithAcademicYear_ForDeactivate Test===========");
			getScreenShot("tcSearchWithAcademicYear_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAcademicYear_ForDeactivate");
		}
	}

	
	@Test(priority = 21, dataProvider = "MastersAcdemicYearSearchData")
	public void tcDeactivateAcademicYears(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateAcademicYears Test===========");

			academicYear.deactivateAcademicYears(academicyear);

			log.info("============= Finished tcDeactivateAcademicYears Test===========");
			getScreenShot("tcDeactivateAcademicYears");
		} catch (Exception e) {
			getScreenShot("tcDeactivateAcademicYears");
		}
	}
	
	@Test(priority = 22)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			academicYear.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}
	
	@Test(priority = 23)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}
	
	@Test(priority = 24, dataProvider = "MastersAcdemicYearSearchData")
	public void tcDeactivateAcademicYears_AfterCancel(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateAcademicYears_AfterCancel Test===========");

			academicYear.deactivateAcademicYears(academicyear);

			log.info("============= Finished tcDeactivateAcademicYears_AfterCancel Test===========");
			getScreenShot("tcDeactivateAcademicYears_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateAcademicYears_AfterCancel");
		}
	}
	
	@Test(priority = 25)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			academicYear.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}
	
	@Test(priority = 27, dataProvider = "MastersAcdemicYearSearchData")
	public void tcActivateAcademicYears(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateAcademicYears Test===========");

			academicYear.activateAcademicYears(academicyear);

			log.info("============= Finished tcActivateAcademicYears Test===========");
			getScreenShot("tcActivateAcademicYears");
		} catch (Exception e) {
			getScreenShot("tcActivateAcademicYears");
		}
	}
	@Test(priority = 28)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			academicYear.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}
	
	@Test(priority = 29)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}
	
	@Test(priority = 30, dataProvider = "MastersAcdemicYearSearchData")
	public void tcActivateAcademicYears_AfterCancel(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateAcademicYears_AfterCancel Test===========");

			academicYear.activateAcademicYears(academicyear);

			log.info("============= Finished tcActivateAcademicYears_AfterCancel Test===========");
			getScreenShot("tcActivateAcademicYears_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateAcademicYears_AfterCancel");
		}
	}
	
	@Test(priority = 31)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			academicYear.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
		}
	}
	
	@Test(priority = 33, dataProvider = "MastersAcdemicYearSearchData")
	public void tcDeleteteAcademicYears(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteteAcademicYears Test===========");

			academicYear.deleteAcademicYears(academicyear);

			log.info("============= Finished tcDeleteteAcademicYears Test===========");
			getScreenShot("tcDeleteteAcademicYears");
		} catch (Exception e) {
			getScreenShot("tcDeleteteAcademicYears");
		}
	}
	
	@Test(priority = 34)
	public void tcClickOnCancelButton_delete() {

		try {
			log.info("============= Strting tcClickOnCancelButton_delete Test===========");

			academicYear.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_delete Test===========");
			getScreenShot("tcClickOnCancelButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_delete");
		}
	}
	
	@Test(priority = 35)
	public void tcClickOnOkSuccessButton_deleteCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deleteCancel Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deleteCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		}
	}
	
	@Test(priority = 36, dataProvider = "MastersAcdemicYearSearchData")
	public void tcDeleteteAcademicYears_AfterCancel(String academicyear, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteteAcademicYears_AfterCancel Test===========");

			academicYear.deleteAcademicYears(academicyear);

			log.info("============= Finished tcDeleteteAcademicYears_AfterCancel Test===========");
			getScreenShot("tcDeleteteAcademicYears_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteteAcademicYears_AfterCancel");
		}
	}
	
	@Test(priority = 37)
	public void tcYesDeleteOrDeactivateOrActivateIt_Delete() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Delete Test===========");

			academicYear.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Delete Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Delete");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Delete");
		}
	}

	@Test(priority = 38)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	@Test(priority = 39, dataProvider = "Masters_AcdemicYearData")
	public void tcFillAcademicYearDetailsForm_AfterDelete(String FromAcademicYr,String academicYrOrder,String instituition, String runMode) {

		if (runMode.equalsIgnoreCase("BGHS")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillAcademicYearDetailsForm_AfterDelete Test===========");

			academicYear.fillAcademicYearDetailsForm(FromAcademicYr,academicYrOrder,instituition);

			log.info("============= Finished tcFillAcademicYearDetailsForm_AfterDelete Test===========");
			getScreenShot("tcFillAcademicYearDetailsForm_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcFillAcademicYearDetailsForm_AfterDelete");
		}
	}
//	@Test(priority = 39, dataProvider = "MastersAcdemicYearData")
//	public void tcEnterMastersAcademicYearDetails_AfterDelete(String FromAcademicYr, String startdate, String end_date,
//			String preAdmStartDate, String preAdmEndDate, String academicYrOrder, String cutoffDate,
//			String instituition, String runMode) {
//
//		if (runMode.equalsIgnoreCase("BGHS")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcEnterMastersAcademicYearDetails_AfterDelete Test===========");
//
//			academicYear.enterMastersAcademicYearDetails(FromAcademicYr, startdate, end_date, preAdmStartDate,
//					preAdmEndDate, academicYrOrder, cutoffDate, instituition);
//
//			log.info("============= Finished tcEnterMastersAcademicYearDetails_AfterDelete Test===========");
//			getScreenShot("tcEnterMastersAcademicYearDetails_AfterDelete");
//		} catch (Exception e) {
//			getScreenShot("tcEnterMastersAcademicYearDetails_AfterDelete");
//		}
//	}

	@Test(priority = 40)
	public void tcClickOnSaveButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDelete Test===========");

			academicYear.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		}
	}

	@Test(priority = 41)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			academicYear.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_AfterDelete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
		}
	}
	
	
	
	 @AfterClass
	 public void tearDown(){
	 try {
	 ivrmportallogin.logOutFromApplication();
	 } catch (Exception e) {
	
	 e.printStackTrace();
	 }
	 driver.quit();
	 }
}
