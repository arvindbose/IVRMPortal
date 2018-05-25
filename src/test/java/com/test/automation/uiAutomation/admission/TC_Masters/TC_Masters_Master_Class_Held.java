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

import com.test.automation.uiAutomation.Admission.Masters.Masters_Master_Class_Held;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Class_Held extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Class_Held.class.getName());

	Masters_Master_Class_Held master_classHeld;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterClassHeldData")
	public String[][] getTestClassHeldData() {
		String[][] testRecordsClassHeldDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassHeldInfoData");
		return testRecordsClassHeldDetails;
	}

	@DataProvider(name = "MastersClassHeldMonthlyData")
	public String[][] getTestData() {
		String[][] testRecordsClassHeld = getData("BGHS_AdmissionData.xlsx", "BGHS_ClassHeldMonthlyData");
		return testRecordsClassHeld;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		master_classHeld = new Masters_Master_Class_Held(driver);
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

			boolean status = master_classHeld.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterClassHeld_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterClassHeld_BGHS Test===========");

			master_classHeld.navigateToAdmission_Masters_MasterClassHeld_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterClassHeld_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterClassHeld_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterClassHeld_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterClassHeld_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterClassHeld_BGHSPage Test===========");

			boolean status = master_classHeld.verifyMasters_MasterClassHeld_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterClassHeld_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterClassHeld_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterClassHeld_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterClassHeldForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterClassHeldForm Test===========");

			master_classHeld.submitBlankMasterClassHeldForm();

			log.info("============= Finished tcSubmitBlankMasterClassHeldForm Test===========");
			getScreenShot("tcSubmitBlankMasterClassHeldForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterClassHeldForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterClassHeldData")
	public void tcEnterMasterClassHeldData(String academicYear, String className, String section, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassHeldData Test===========");

			master_classHeld.enterMasterClassHeldData(academicYear, className, section);

			log.info("============= Finished tcEnterMasterClassHeldData Test===========");
			getScreenShot("tcEnterMasterClassHeldData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassHeldData");
		}
	}
	
	@Test(priority = 7, dataProvider = "MastersClassHeldMonthlyData")
	public void tcUpdateWithMonthwiseClassHeldData(String classHeld, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateWithMonthwiseClassHeldData Test===========");

			master_classHeld.updateWithMonthwiseClassHeldData(classHeld);

			log.info("============= Finished tcUpdateWithMonthwiseClassHeldData Test===========");
			getScreenShot("tcUpdateWithMonthwiseClassHeldData");
		} catch (Exception e) {
			getScreenShot("tcUpdateWithMonthwiseClassHeldData");
		}
	}
	

	@Test(priority = 8)
	public void tcClearClassHeldInfoData() {

		try {
			log.info("============= Strting tcClearClassHeldInfoData Test===========");

			master_classHeld.clearClassHeldInfoData();

			log.info("============= Finished tcClearClassHeldInfoData Test===========");
			getScreenShot("tcClearClassHeldInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearClassHeldInfoData");
		}
	}
	@Test(priority = 9)
	public void tcMinimizeMasterClassHeld() {

		try {
			log.info("============= Strting tcMinimizeMasterClassHeld Test===========");

			master_classHeld.minimizeMasterClassHeld();

			log.info("============= Finished tcMinimizeMasterClassHeld Test===========");
			getScreenShot("tcMinimizeMasterClassHeld");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClassHeld");
		}
	}
	
	@Test(priority = 10)
	public void tcMaximizeMasterClassHeld() {

		try {
			log.info("============= Strting tcMaximizeMasterClassHeld Test===========");

			master_classHeld.maximizeMasterClassHeld();

			log.info("============= Finished tcMaximizeMasterClassHeld Test===========");
			getScreenShot("tcMaximizeMasterClassHeld");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClassHeld");
		}
	}


	
	@Test(priority = 11)
	public void tcMinimizeMasterClassHeldTable() {

		try {
			log.info("============= Strting tcMinimizeMasterClassHeldTable Test===========");

			master_classHeld.minimizeMasterClassHeldTable();

			log.info("============= Finished tcMinimizeMasterClassHeldTable Test===========");
			getScreenShot("tcMinimizeMasterClassHeldTable");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClassHeldTable");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterClassHeldTable() {

		try {
			log.info("============= Strting tcMaximizeMasterClassHeldTable Test===========");

			master_classHeld.maximizeMasterClassHeldTable();

			log.info("============= Finished tcMaximizeMasterClassHeldTable Test===========");
			getScreenShot("tcMaximizeMasterClassHeldTable");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClassHeldTable");
		}
	}
	
	
	@Test(priority = 13, dataProvider = "MastersMasterClassHeldData")
	public void tcEnterMasterClassHeldData_AfterClear(String academicYear, String className, String section, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassHeldData_AfterClear Test===========");

			master_classHeld.enterMasterClassHeldData(academicYear, className, section);

			log.info("============= Finished tcEnterMasterClassHeldData_AfterClear Test===========");
			getScreenShot("tcEnterMasterClassHeldData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassHeldData_AfterClear");
		}
	}
	
	@Test(priority = 14, dataProvider = "MastersClassHeldMonthlyData")
	public void tcUpdateWithMonthwiseClassHeldData_AfterClear(String classHeld, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateWithMonthwiseClassHeldData Test===========");

			master_classHeld.updateWithMonthwiseClassHeldData(classHeld);

			log.info("============= Finished tcUpdateWithMonthwiseClassHeldData Test===========");
			getScreenShot("tcUpdateWithMonthwiseClassHeldData");
		} catch (Exception e) {
			getScreenShot("tcUpdateWithMonthwiseClassHeldData");
		}
	}
	
	
	@Test(priority = 15)
	public void tcSubmitFilledMasterClassHeldForm() {

		try {
			log.info("============= Strting tcSubmitFilledMasterClassHeldForm Test===========");

			master_classHeld.submitFilledMasterClassHeldForm();

			log.info("============= Finished tcSubmitFilledMasterClassHeldForm Test===========");
			getScreenShot("tcSubmitFilledMasterClassHeldForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterClassHeldForm");
		}
	}

	@Test(priority = 16)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			master_classHeld.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
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
