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

import com.vapsTechnosoft.IVRM.Fee.Masters.Configuration_Fee_Standard;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Configuration_Fee_Standard extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Configuration_Fee_Standard.class.getName());

	Configuration_Fee_Standard configfeeStandard;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		configfeeStandard = new Configuration_Fee_Standard(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		ivrmportallogin = new IvrmPortalLogin(driver);
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

			configfeeStandard.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateTofeeStandard() {

		try {
			log.info("============= Strting tcNevigateTofeeStandard Test===========");

			configfeeStandard.nevigateTofeeStandard();

			log.info("============= Finished tcNevigateTofeeStandard Test===========");
			getScreenShot("tcNevigateTofeeStandard");
		} catch (Exception e) {
			getScreenShot("tcNevigateTofeeStandard");
		}
	}

	@Test(priority = 4)
	public void tcSelectFeeGroupRadioBtn() {

		try {
			log.info("============= Strting tcSelectFeeGroupRadioBtn Test===========");

			configfeeStandard.selectFeeGroupRadioBtn();

			log.info("============= Finished tcSelectFeeGroupRadioBtn Test===========");
			getScreenShot("tcSelectFeeGroupRadioBtn");
		} catch (Exception e) {
			getScreenShot("tcSelectFeeGroupRadioBtn");
		}
	}

	@Test(priority = 5)
	public void tcSelectConcessionProcess() {

		try {
			log.info("============= Strting tcSelectConcessionProcess Test===========");

			configfeeStandard.selectConcessionProcess();

			log.info("============= Finished tcSelectConcessionProcess Test===========");
			getScreenShot("tcSelectConcessionProcess");
		} catch (Exception e) {
			getScreenShot("tcSelectConcessionProcess");
		}
	}

	@Test(priority = 6)
	public void tcSelectCardTypeAndEnterCharges() {

		try {
			log.info("============= Strting tcSelectCardTypeAndEnterCharges Test===========");

			configfeeStandard.selectCardTypeAndEnterCharges();

			log.info("============= Finished tcSelectCardTypeAndEnterCharges Test===========");
			getScreenShot("tcSelectCardTypeAndEnterCharges");
		} catch (Exception e) {
			getScreenShot("tcSelectCardTypeAndEnterCharges");
		}
	}

	@Test(priority = 7)
	public void tcClickedOnSaveButton() {

		try {
			log.info("============= Strting tcClickedOnSaveButton Test===========");

			configfeeStandard.clickedOnSaveButton();

			log.info("============= Finished tcClickedOnSaveButton Test===========");
			getScreenShot("tcClickedOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickedOnSaveButton");
		}
	}

	@Test(priority = 8)
	public void tcSuccessMessagevalidationAndConfirmation() {

		try {
			log.info("============= Starting tcSuccessMessagevalidationAndConfirmation Test===========");

			boolean status = configfeeStandard.successMessagevalidation();
			if (status) {
				configfeeStandard.clickOnSuccessOkButton();

			}
			Assert.assertEquals(status, true);

			log.info("============= Finished tcSuccessMessagevalidationAndConfirmation Test===========");
			getScreenShot("tcSuccessMessagevalidationAndConfirmation");
		} catch (Exception e) {
			getScreenShot("tcSuccessMessagevalidationAndConfirmation");
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
