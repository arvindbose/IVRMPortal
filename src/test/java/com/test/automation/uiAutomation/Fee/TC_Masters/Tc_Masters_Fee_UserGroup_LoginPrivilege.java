/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Masters.Masters_Fee_UserGroup_LoginPrivilege;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_UserGroup_LoginPrivilege extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_UserGroup_LoginPrivilege.class.getName());

	Masters_Fee_UserGroup_LoginPrivilege groupLoginPreviledge;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeePreviledgeTestData")
	public String[][] getTestDataYGHMap() {
		String[][] testRecordsYGHMap = getData("FeeModueData.xlsx", "FeeLoginPreviledge");
		return testRecordsYGHMap;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		groupLoginPreviledge = new Masters_Fee_UserGroup_LoginPrivilege(driver);
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

			groupLoginPreviledge.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToFeeUserGr_LoginPreviledge() {

		try {
			log.info("============= Strting tcNevigateToFeeUserGr_LoginPreviledge Test===========");

			groupLoginPreviledge.nevigateToFeeUserGr_LoginPreviledge();

			log.info("============= Finished tcNevigateToFeeUserGr_LoginPreviledge Test===========");
			getScreenShot("tcNevigateToFeeUserGr_LoginPreviledge");
		} catch (Exception e) {
			getScreenShot("tcNevigateToFeeUserGr_LoginPreviledge");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeUserGrLoginPreviledgePagee() {

		try {
			log.info("============= Strting tcVerifyFeeUserGrLoginPreviledgePagee Test===========");

			boolean status = groupLoginPreviledge.verifyFeeUserGrLoginPreviledgePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeUserGrLoginPreviledgePagee Test===========");
			getScreenShot("tcVerifyFeeUserGrLoginPreviledgePagee");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeUserGrLoginPreviledgePagee");
		}
	}

	@Test(priority = 5, dataProvider = "FeePreviledgeTestData")
	public void tcSelectAcademicYear_GroupAndRole(String AcademicYear, String userGroup, String role, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYear_GroupAndRole Test===========");

			groupLoginPreviledge.selectAcademicYear_GroupAndRole(AcademicYear, userGroup, role);
			;

			log.info("============= Finished tcSelectAcademicYear_GroupAndRole Test===========");
			getScreenShot("tcSelectAcademicYear_GroupAndRole");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYear_GroupAndRole");
		}
	}

	@Test(priority = 10)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			groupLoginPreviledge.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 11)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = groupLoginPreviledge.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 12)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
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
