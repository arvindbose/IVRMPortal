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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Yearly_Group_HeadMap;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Yearly_Group_HeadMap extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Masters_Yearly_Group_HeadMap.class.getName());

	Masters_Yearly_Group_HeadMap groupHeadMap;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "groupHeadMapTestData")
	public String[][] getTestDataYGHMap() {
		String[][] testRecordsYGHMap = getData("FeeModueData.xlsx", "YearlyGrHeadMap");
		return testRecordsYGHMap;
	}
	@DataProvider(name = "FeeGrHeadMapTestData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsFeegroupmap = getData("FeeModueData.xlsx", "YGHMFeeHeadInstallment");
		return testRecordsFeegroupmap;
	}

	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);
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
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			groupHeadMap.verifyHomeButton();
			
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNevigateToMasters_YearlyGrHeadMap() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcNevigateToMasters_YearlyGrHeadMap Test===========");

			groupHeadMap.nevigateToMasters_YearlyGrHeadMap();
			
			log.info("============= Finished tcNevigateToMasters_YearlyGrHeadMap Test===========");
			getScreenShot("tcNevigateToMasters_YearlyGrHeadMap");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_YearlyGrHeadMap");
		}
	}
	@Test(priority = 4)
	public void tcVerifyYearlyFeeHeadGrMapPage() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcVerifyYearlyFeeHeadGrMapPage Test===========");

			boolean status =groupHeadMap.verifyYearlyFeeHeadGrMapPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyYearlyFeeHeadGrMapPage Test===========");
			getScreenShot("tcVerifyYearlyFeeHeadGrMapPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyYearlyFeeHeadGrMapPage");
		}
	}
	@Test(priority = 5, dataProvider = "groupHeadMapTestData")
	public void tcSelectAcademicYearAndFeeGroup(String AcademicYr, String FeeGroup, String runMode) {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearAndFeeGroup Test===========");

			groupHeadMap.selectAcademicYearAndFeeGroup(AcademicYr, FeeGroup);
			
			log.info("============= Finished tcSelectAcademicYearAndFeeGroup Test===========");
			getScreenShot("tcSelectAcademicYearAndFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearAndFeeGroup");
		}
	}
	@Test(priority = 6, dataProvider = "FeeGrHeadMapTestData")
	public void tcMapFeeHeadAndInstallment(String feeHead, String feeInstallment, String runMode) {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);
		if(runMode.equalsIgnoreCase("test2")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapFeeHeadAndInstallment Test===========");

			groupHeadMap.mapFeeHeadAndInstallment(feeHead, feeInstallment);
			
			log.info("============= Finished tcMapFeeHeadAndInstallment Test===========");
			getScreenShot("tcMapFeeHeadAndInstallment");
		} catch (Exception e) {
			getScreenShot("tcMapFeeHeadAndInstallment");
		}
	}
	@Test(priority = 7)
	public void tcAddNewFeeHead() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcAddNewFeeHead Test===========");

			groupHeadMap.addNewFeeHead();
			
			log.info("============= Finished tcAddNewFeeHead Test===========");
			getScreenShot("tcAddNewFeeHead");
		} catch (Exception e) {
			getScreenShot("tcAddNewFeeHead");
		}
	}
	@Test(priority = 8, dataProvider = "FeeGrHeadMapTestData")
	public void tcVerifyUserAbleToAddNewHead(String feeHead2, String feeInstallment2, String runMode) {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);
		if(runMode.equalsIgnoreCase("test1")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyUserAbleToAddNewHead Test===========");

			groupHeadMap.verifyUserAbleToAddNewHead(feeHead2, feeInstallment2);
			
			log.info("============= Finished tcVerifyUserAbleToAddNewHead Test===========");
			getScreenShot("tcVerifyUserAbleToAddNewHead");
		} catch (Exception e) {
			getScreenShot("tcVerifyUserAbleToAddNewHead");
		}
	}
	@Test(priority = 9)
	public void tcRemoveAddedFeeHeadAndInstallment() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcRemoveAddedFeeHeadAndInstallment Test===========");

			groupHeadMap.removeAddedFeeHeadAndInstallment();
			
			log.info("============= Finished tcRemoveAddedFeeHeadAndInstallment Test===========");
			getScreenShot("tcRemoveAddedFeeHeadAndInstallment");
		} catch (Exception e) {
			getScreenShot("tcRemoveAddedFeeHeadAndInstallment");
		}
	}
	@Test(priority = 10)
	public void tcClickOnSaveButton() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			groupHeadMap.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 11)
	public void tcVerifySuccessfulPopUp() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status =groupHeadMap.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}
	@Test(priority = 12)
	public void tcClickOnSuccessOkBtn() {
		groupHeadMap = new Masters_Yearly_Group_HeadMap(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			groupHeadMap.clickOnSuccessOkBtn();
			
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
