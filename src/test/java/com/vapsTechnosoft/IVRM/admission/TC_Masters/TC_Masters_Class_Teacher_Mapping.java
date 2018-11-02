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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Class_Teacher_Mapping;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Class_Teacher_Mapping extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Class_Teacher_Mapping.class.getName());

	Masters_Class_Teacher_Mapping classteachermapp;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersClassTeacher1MappData")
	public String[][] getTestData() {
		String[][] testRecordsClassTeacher1Details = getData("BGHS_AdmissionData.xlsx", "BGHS_ClassTeachere1Data");
		return testRecordsClassTeacher1Details;
	}

	@DataProvider(name = "MastersClassTeacher2MappData")
	public String[][] getTestDataCT2() {
		String[][] testRecordsClassTeacher2Details = getData("BGHS_AdmissionData.xlsx", "BGHS_ClassTeachere2Data");
		return testRecordsClassTeacher2Details;
	}

	@DataProvider(name = "StaffSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_StaffSearchData");
		return testRecordsSearch;
	}

	@DataProvider(name = "MastersClassTeacherXchangeData")
	public String[][] getTestDataXchange() {
		String[][] testRecordsClassTeacherXchangeDetails = getData("BGHS_AdmissionData.xlsx",
				"BGHS_ClassTeachereXchangeData");
		return testRecordsClassTeacherXchangeDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		classteachermapp = new Masters_Class_Teacher_Mapping(driver);
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

			boolean status = classteachermapp.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_ClassTeacherMapping_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_ClassTeacherMapping_BGHS Test===========");

			classteachermapp.navigateToAdmission_Masters_ClassTeacherMapping_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_ClassTeacherMapping_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_ClassTeacherMapping_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_ClassTeacherMapping_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_ClassTeacherMapp_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_ClassTeacherMapp_BGHSPage Test===========");

			boolean status = classteachermapp.verifyMasters_ClassTeacherMapp_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_ClassTeacherMapp_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_ClassTeacherMapp_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_ClassTeacherMapp_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankClassTeacherMappForm() {

		try {
			log.info("============= Starting tcSubmitBlankClassTeacherMappForm Test===========");

			classteachermapp.submitBlankClassTeacherMappForm();

			log.info("============= Finished tcSubmitBlankClassTeacherMappForm Test===========");
			getScreenShot("tcSubmitBlankClassTeacherMappForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankClassTeacherMappForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersClassTeacher1MappData")
	public void tcSelectClassTeacherMappingData(String academicYr, String class_Map, String section,
			String staff_Teacher, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectClassTeacherMappingData Test===========");

			classteachermapp.selectClassTeacherMappingData(academicYr, class_Map, section, staff_Teacher);

			log.info("============= Finished tcSelectClassTeacherMappingData Test===========");
			getScreenShot("tcSelectClassTeacherMappingData");
		} catch (Exception e) {
			getScreenShot("tcSelectClassTeacherMappingData");
		}
	}

	@Test(priority = 7)
	public void tcClearClassTeacherMappInfoData() {

		try {
			log.info("============= Strting tcClearClassTeacherMappInfoData Test===========");

			classteachermapp.clearClassTeacherMappInfoData();

			log.info("============= Finished tcClearClassTeacherMappInfoData Test===========");
			getScreenShot("tcClearClassTeacherMappInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearClassTeacherMappInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeClassTeacher() {

		try {
			log.info("============= Strting tcMinimizeClassTeacher Test===========");

			classteachermapp.minimizeClassTeacher();

			log.info("============= Finished tcMinimizeClassTeacher Test===========");
			getScreenShot("tcMinimizeClassTeacher");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassTeacher");
		}
	}

	@Test(priority = 9)
	public void tcSortByStaffName() {

		try {
			log.info("============= Strting tcSortByStaffName Test===========");
			getScreenShot("tcSortByStaffName_BeforeSorting");

			classteachermapp.sortByStaffName();

			log.info("============= Finished tcSortByStaffName Test===========");
			getScreenShot("tcSortByStaffName");
		} catch (Exception e) {
			getScreenShot("tcSortByStaffName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeClassTeacher() {

		try {
			log.info("============= Strting tcMaximizeClassTeacher Test===========");

			classteachermapp.maximizeClassTeacher();

			log.info("============= Finished tcMaximizeClassTeacher Test===========");
			getScreenShot("tcMaximizeClassTeacher");
		} catch (Exception e) {
			getScreenShot("tcMaximizeClassTeacher");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeClassTeacherMappingTable() {

		try {
			log.info("============= Strting tcMinimizeClassTeacherMappingTable Test===========");

			classteachermapp.minimizeClassTeacherMappingTable();

			log.info("============= Finished tcMinimizeClassTeacherMappingTable Test===========");
			getScreenShot("tcMinimizeClassTeacherMappingTable");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassTeacherMappingTable");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeClassTeacherMappingTable() {

		try {
			log.info("============= Strting tcMaximizeClassTeacherMappingTable Test===========");

			classteachermapp.maximizeClassTeacherMappingTable();

			log.info("============= Finished tcMaximizeClassTeacherMappingTable Test===========");
			getScreenShot("tcMaximizeClassTeacherMappingTable");
		} catch (Exception e) {
			getScreenShot("tcMaximizeClassTeacherMappingTable");
		}
	}

	//

	@Test(priority = 13, dataProvider = "MastersClassTeacher1MappData")
	public void tcSelectClassTeacherMappingData_AfterClear(String academicYr, String class_Map, String section,
			String staff_Teacher, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectClassTeacherMappingData_AfterClear Test===========");

			classteachermapp.selectClassTeacherMappingData(academicYr, class_Map, section, staff_Teacher);

			log.info("============= Finished tcSelectClassTeacherMappingData_AfterClear Test===========");
			getScreenShot("tcSelectClassTeacherMappingData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectClassTeacherMappingData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveClassTeacherMappInfoData() {

		try {
			log.info("============= Strting tcSaveClassTeacherMappInfoData Test===========");

			classteachermapp.saveClassTeacherMappInfoData();

			log.info("============= Finished tcSaveClassTeacherMappInfoData Test===========");
			getScreenShot("tcSaveClassTeacherMappInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveClassTeacherMappInfoData");
		}
	}
	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_1stStaff() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_1stStaff Test===========");

			classteachermapp.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_1stStaff Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_1stStaff");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_1stStaff");
		}
	}


	@Test(priority = 16)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 17, dataProvider = "MastersClassTeacher2MappData")
	public void tcSelectClassTeacherMappingData_2ndStaff(String academicYr, String class_Map, String section,
			String staff_Teacher, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectClassTeacherMappingData_2ndStaff Test===========");

			classteachermapp.selectClassTeacherMappingData(academicYr, class_Map, section, staff_Teacher);

			log.info("============= Finished tcSelectClassTeacherMappingData_2ndStaff Test===========");
			getScreenShot("tcSelectClassTeacherMappingData_2ndStaff");
		} catch (Exception e) {
			getScreenShot("tcSelectClassTeacherMappingData_2ndStaff");
		}
	}

	@Test(priority = 18)
	public void tcSaveClassTeacherMappInfoData_2ndStaff() {

		try {
			log.info("============= Strting tcSaveClassTeacherMappInfoData_2ndStaff Test===========");

			classteachermapp.saveClassTeacherMappInfoData();

			log.info("============= Finished tcSaveClassTeacherMappInfoData_2ndStaff Test===========");
			getScreenShot("tcSaveClassTeacherMappInfoData_2ndStaff");
		} catch (Exception e) {
			getScreenShot("tcSaveClassTeacherMappInfoData_2ndStaff");
		}
	}
	@Test(priority = 19)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_2ndStaff() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_2ndStaff Test===========");

			classteachermapp.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_2ndStaff Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_2ndStaff");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_2ndStaff");
		}
	}


	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_2ndStaff() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_2ndStaff Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_2ndStaff Test===========");
			getScreenShot("tcClickOnOkSuccessButton_2ndStaff");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_2ndStaff");
		}
	}

	@Test(priority = 21, dataProvider = "StaffSearchData")
	public void tcSearchWithStaffNameInTheGrid(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStaffNameInTheGrid Test===========");

			classteachermapp.searchWithStaffNameInTheGrid(staffName);

			log.info("============= Finished tcSearchWithStaffNameInTheGrid Test===========");
			getScreenShot("tcSearchWithStaffNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStaffNameInTheGrid");
		}
	}

	@Test(priority = 22, dataProvider = "StaffSearchData")
	public void tcVerifyStaffNameUpdatedInTheGrid(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStaffNameUpdatedInTheGrid Test===========");

			classteachermapp.verifyStaffNameUpdatedInTheGrid(staffName);

			log.info("============= Finished tcVerifyStaffNameUpdatedInTheGrid Test===========");
			getScreenShot("tcVerifyStaffNameUpdatedInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStaffNameUpdatedInTheGrid");
		}
	}

	@Test(priority = 23, dataProvider = "StaffSearchData")
	public void tcDeactivateClassTeacherMapped(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateClassTeacherMapped Test===========");

			classteachermapp.deactivateClassTeacherMapped(staffName);

			log.info("============= Finished tcDeactivateClassTeacherMapped Test===========");
			getScreenShot("tcDeactivateClassTeacherMapped");
		} catch (Exception e) {
			getScreenShot("tcDeactivateClassTeacherMapped");
		}
	}

	@Test(priority = 24)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			classteachermapp.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 25)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 26, dataProvider = "StaffSearchData")
	public void tcSearchWithStaffNameInTheGrid_AfterCancel(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStaffNameInTheGrid_AfterCancel Test===========");

			classteachermapp.searchWithStaffNameInTheGrid(staffName);

			log.info("============= Finished tcSearchWithStaffNameInTheGrid_AfterCancel Test===========");
			getScreenShot("tcSearchWithStaffNameInTheGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStaffNameInTheGrid_AfterCancel");
		}
	}

	@Test(priority = 27, dataProvider = "StaffSearchData")
	public void tcDeactivateClassTeacherMapped_AfterCancel(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateClassTeacherMapped_AfterCancel Test===========");

			classteachermapp.deactivateClassTeacherMapped(staffName);
			log.info("============= Finished tcDeactivateClassTeacherMapped_AfterCancel Test===========");
			getScreenShot("tcDeactivateClassTeacherMapped_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateClassTeacherMapped_AfterCancel");
		}
	}

	@Test(priority = 28)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			classteachermapp.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 29)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 30, dataProvider = "StaffSearchData")
	public void tcSearchWithStaffNameInTheGrid_ForActivate(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStaffNameInTheGrid_ForActivate Test===========");

			classteachermapp.searchWithStaffNameInTheGrid(staffName);

			log.info("============= Finished tcSearchWithStaffNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithStaffNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStaffNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 31, dataProvider = "StaffSearchData")
	public void tcActivateClassTeacherMapped(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateClassTeacherMapped Test===========");

			classteachermapp.activateClassTeacherMapped(staffName);

			log.info("============= Finished tcActivateClassTeacherMapped Test===========");
			getScreenShot("tcActivateClassTeacherMapped");
		} catch (Exception e) {
			getScreenShot("tcActivateClassTeacherMapped");
		}
	}

	@Test(priority = 32)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			classteachermapp.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 33)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 34, dataProvider = "StaffSearchData")
	public void tcSearchWithStaffNameInTheGrid_ForActivateAfterCancel(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStaffNameInTheGrid_ForActivateAfterCancel Test===========");

			classteachermapp.searchWithStaffNameInTheGrid(staffName);

			log.info("============= Finished tcSearchWithStaffNameInTheGrid_ForActivateAfterCancel Test===========");
			getScreenShot("tcSearchWithStaffNameInTheGrid_ForActivateAfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStaffNameInTheGrid_ForActivateAfterCancel");
		}
	}

	@Test(priority = 35, dataProvider = "StaffSearchData")
	public void tcActivateClassTeacherMapped_AfterCancel(String staffName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterClass_AfterCancel Test===========");

			classteachermapp.activateClassTeacherMapped(staffName);
			log.info("============= Finished tcActivateMasterClass_AfterCancel Test===========");
			getScreenShot("tcActivateMasterClass_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterClass_AfterCancel");
		}
	}

	@Test(priority = 36)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			classteachermapp.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 37)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
		}
	}

	@Test(priority = 38)
	public void tcClickOnclassTeacherXchange() {

		try {
			log.info("============= Strting tcClickOnclassTeacherXchange Test===========");

			classteachermapp.classTeacherXchange();

			log.info("============= Finished tcClickOnclassTeacherXchange Test===========");
			getScreenShot("tcClickOnclassTeacherXchange");
		} catch (Exception e) {
			getScreenShot("tcClickOnclassTeacherXchange");
		}
	}

	@Test(priority = 39)
	public void tcCloseXchangePopUpWindow() {

		try {
			log.info("============= Strting tcCloseXchangePopUpWindow Test===========");

			classteachermapp.closeXchangePopUpWindow();

			log.info("============= Finished tcCloseXchangePopUpWindow Test===========");
			getScreenShot("tcCloseXchangePopUpWindow");
		} catch (Exception e) {
			getScreenShot("tcCloseXchangePopUpWindow");
		}
	}

	@Test(priority = 40)
	public void tcClickOnclassTeacherXchange_AfterClose() {

		try {
			log.info("============= Strting tcClickOnclassTeacherXchange_AfterClose Test===========");

			classteachermapp.classTeacherXchange();

			log.info("============= Finished tcClickOnclassTeacherXchange_AfterClose Test===========");
			getScreenShot("tcClickOnclassTeacherXchange_AfterClose");
		} catch (Exception e) {
			getScreenShot("tcClickOnclassTeacherXchange_AfterClose");
		}
	}

	@Test(priority = 41, dataProvider = "MastersClassTeacherXchangeData")
	public void tcSelectTeacherClassXchangeData(String staff1, String staff2, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectTeacherClassXchangeData Test===========");

			classteachermapp.selectTeacherClassXchangeData(staff1, staff2);

			log.info("============= Finished tcSelectTeacherClassXchangeData Test===========");
			getScreenShot("tcSelectTeacherClassXchangeData");
		} catch (Exception e) {
			getScreenShot("tcSelectTeacherClassXchangeData");
		}
	}

	@Test(priority = 42)
	public void tcSaveTeacherClassXchangeData() {

		try {
			log.info("============= Strting tcSaveTeacherClassXchangeData Test===========");

			classteachermapp.saveTeacherClassXchangeData();

			log.info("============= Finished tcSaveTeacherClassXchangeData Test===========");
			getScreenShot("tcSaveTeacherClassXchangeData");
		} catch (Exception e) {
			getScreenShot("tcSaveTeacherClassXchangeData");
		}
	}
	
	@Test(priority = 43)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Xchange_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Xchange_Validation Test===========");

			classteachermapp.popWindowMessage_SubmitSuccessfully_Xchange();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Xchange_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Xchange_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Xchange_Validation");
		}
	}

	@Test(priority = 44)
	public void tcClickOnOkSuccessButton_Xchange() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Xchange Test===========");

			classteachermapp.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Xchange Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Xchange");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Xchange");
		}
	}

	// @Test(priority = 42)
	// public void tcClickOnclassTeacherXchange_AfterXchange() {
	//
	// try {
	// log.info("============= Strting tcClickOnclassTeacherXchange_AfterXchange
	// Test===========");
	//
	// classteachermapp.classTeacherXchange();
	//
	// log.info("============= Finished
	// tcClickOnclassTeacherXchange_AfterXchange Test===========");
	// getScreenShot("tcClickOnclassTeacherXchange_AfterXchange");
	// } catch (Exception e) {
	// getScreenShot("tcClickOnclassTeacherXchange_AfterXchange");
	// }
	// }
	//
	// @Test(priority = 43, dataProvider = "MastersClassTeacherXchangeData")
	// public void tcSelectTeacherClassXchangeData_AfterXchange(String staff1,
	// String staff2, String runMode) {
	//
	// if (runMode.equalsIgnoreCase("n")) {
	// throw new SkipException("user marked this record as no run");
	// }
	// try {
	// log.info("============= Strating
	// tcSelectTeacherClassXchangeData_AfterXchange Test===========");
	//
	// classteachermapp.selectTeacherClassXchangeData(staff1, staff2);
	//
	// log.info("============= Finished
	// tcSelectTeacherClassXchangeData_AfterXchange Test===========");
	// getScreenShot("tcSelectTeacherClassXchangeData_AfterXchange");
	// } catch (Exception e) {
	// getScreenShot("tcSelectTeacherClassXchangeData_AfterXchange");
	// }
	// }
	//
	// @Test(priority = 44)
	// public void tcCloseXchangePopUpWindow_AfterXchange() {
	//
	// try {
	// log.info("============= Strating tcCloseXchangePopUpWindow_AfterXchange
	// Test===========");
	//
	// classteachermapp.closeXchangePopUpWindow();
	//
	// log.info("============= Finished tcCloseXchangePopUpWindow_AfterXchange
	// Test===========");
	// getScreenShot("tcCloseXchangePopUpWindow_AfterXchange");
	// } catch (Exception e) {
	// getScreenShot("tcCloseXchangePopUpWindow_AfterXchange");
	// }
	// }

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
