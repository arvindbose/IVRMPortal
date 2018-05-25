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

import com.test.automation.uiAutomation.Fee.Masters.Masters_Student_Fee_GroupMap;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Student_Fee_GroupMap extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Student_Fee_GroupMap.class.getName());

	Masters_Student_Fee_GroupMap studentFeegroupMap;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "stuFeeGroupTestData")
	public String[][] getTestDataStuFeeMap() {
		String[][] testRecordsSFGM = getData("FeeModueData.xlsx", "studentFeeGroupTestData");
		return testRecordsSFGM;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentFeegroupMap = new Masters_Student_Fee_GroupMap(driver);
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

			studentFeegroupMap.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToMasters_StudentFeegroupMap() {

		try {
			log.info("============= Strting tcNevigateToMasters_StudentFeegroupMap Test===========");

			studentFeegroupMap.nevigateToMasters_StudentFeegroupMap();

			log.info("============= Finished tcNevigateToMasters_StudentFeegroupMap Test===========");
			getScreenShot("tcNevigateToMasters_StudentFeegroupMap");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_StudentFeegroupMap");
		}
	}

	@Test(priority = 4)
	public void tcVerifyStudentFeeGroupMapPage() {

		try {
			log.info("============= Strting tcVerifyStudentFeeGroupMapPage Test===========");

			boolean status = studentFeegroupMap.verifyStudentFeeGroupMapPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyStudentFeeGroupMapPage Test===========");
			getScreenShot("tcVerifyStudentFeeGroupMapPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentFeeGroupMapPage");
		}
	}

	@Test(priority = 5, dataProvider = "stuFeeGroupTestData")
	public void tcSelectByStudentName(String byStudentName, String StdName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectByStudentName Test===========");

			studentFeegroupMap.selectByStudentName(byStudentName, StdName);

			log.info("============= Finished tcSelectByStudentName Test===========");
			getScreenShot("tcSelectByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSelectByStudentName");
		}
	}

	@Test(priority = 6)
	public void tcClickOnSearchButton() {

		try {
			log.info("============= Strting tcClickOnSearchButton Test===========");

			studentFeegroupMap.clickOnSearchButton();

			log.info("============= Finished tcClickOnSearchButton Test===========");
			getScreenShot("tcClickOnSearchButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchButton");
		}
	}

	@Test(priority = 7)
	public void tcSelectTheCheckBoxForCorresponingStudent() {

		try {
			log.info("============= Strting tcSelectTheCheckBoxForCorresponingStudent Test===========");

			studentFeegroupMap.selectTheCheckBoxForCorresponingStudent("SURESH lkg lkg lkg");

			log.info("============= Finished tcSelectTheCheckBoxForCorresponingStudent Test===========");
			getScreenShot("tcSelectTheCheckBoxForCorresponingStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectTheCheckBoxForCorresponingStudent");
		}
	}

	@Test(priority = 8)
	public void tcMapStudentWithGroup() {
		try {
			log.info("============= Strting tcMapStudentWithGroup Test===========");

			studentFeegroupMap.mapStudentWithGroup();

			log.info("============= Finished tcMapStudentWithGroup Test===========");
			getScreenShot("tcMapStudentWithGroup");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup");
		}
	}

	@Test(priority = 9)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 10)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = studentFeegroupMap.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 11)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

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
