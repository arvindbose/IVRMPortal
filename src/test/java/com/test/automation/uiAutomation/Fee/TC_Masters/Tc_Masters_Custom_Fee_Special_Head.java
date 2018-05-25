/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Masters.Masters_Custom_Fee_Special_Head;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 * 
 *         "Fee Module - Custom Fee Special Head"
 * 
 *         TC_F1_263,TC_F1_265,TC_F1_267,TC_F1_268
 *
 */
public class Tc_Masters_Custom_Fee_Special_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Custom_Fee_Group.class.getName());

	Masters_Custom_Fee_Special_Head customSplfeeHead;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "CustomSPlFeeHeadTestData")
	public String[][] getTestDataCSFH() {
		String[][] testRecordsCSFH = getData("FeeModueData.xlsx", "CustomSPlFeeHeadData");
		return testRecordsCSFH;
	}

	@DataProvider(name = "searchBySpecialFeeHeadName")
	public String[][] getTestDataSplHeadName() {
		String[][] testRecordsCSplHeadName = getData("FeeModueData.xlsx", "CustomSplFeeHeadNameData");
		return testRecordsCSplHeadName;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		customSplfeeHead = new Masters_Custom_Fee_Special_Head(driver);
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

			boolean status = customSplfeeHead.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToMasters_Custom_Special_FeeHead() {

		try {
			log.info("============= Strting tcNevigateToMasters_Custom_Special_FeeHead Test===========");

			customSplfeeHead.nevigateToMasters_Custom_Special_FeeHead();

			log.info("============= Finished tcNevigateToMasters_Custom_Special_FeeHead Test===========");
			getScreenShot("tcNevigateToMasters_Custom_Special_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_Custom_Special_FeeHead");
		}
	}

	@Test(priority = 4)
	public void tcVerifyCustomSpecialFeeHeadPage() {

		try {
			log.info("============= Strting tcVerifyCustomSpecialFeeHeadPage Test===========");

			boolean status = customSplfeeHead.verifyCustomSpecialFeeHeadPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyCustomSpecialFeeHeadPage Test===========");
			getScreenShot("tcVerifyCustomSpecialFeeHeadPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyCustomSpecialFeeHeadPage");
		}
	}

	@Test(priority = 5, dataProvider = "CustomSPlFeeHeadTestData")
	public void tcEnterSpecialFeeHeadAndSelectFeeHead(String specialFeeHead, String feehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSpecialFeeHeadAndSelectFeeHead Test===========");

			customSplfeeHead.enterSpecialFeeHeadAndSelectFeeHead(specialFeeHead, feehead);

			log.info("============= Finished tcEnterSpecialFeeHeadAndSelectFeeHead Test===========");
			getScreenShot("tcEnterSpecialFeeHeadAndSelectFeeHead");
		} catch (Exception e) {
			getScreenShot("tcEnterSpecialFeeHeadAndSelectFeeHead");
		}
	}

	@Test(priority = 6)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			customSplfeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 7)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = customSplfeeHead.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 8)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	/**
	 * Search with the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @param runMode
	 */

	@Test(priority = 9, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCustomSPLFeeHeadupdatedInGrid Test =============");
			
			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);
			
			log.info("============= tcSearchBySpLFeeHeadNameInGrid =============");

			getScreenShot("tcSearchBySpLFeeHeadNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid");
		}
	}

}
