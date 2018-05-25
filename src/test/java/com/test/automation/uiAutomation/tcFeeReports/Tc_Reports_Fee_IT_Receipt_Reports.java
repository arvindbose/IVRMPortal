/**
 * 
 */
package com.test.automation.uiAutomation.tcFeeReports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.TC_Masters.Tc_Masters_Fee_Head;
import com.test.automation.uiAutomation.FeeReports.Reports_Fee_IT_Receipt_Reports;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Reports_Fee_IT_Receipt_Reports extends TestBase{
	
	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Head.class.getName());

	Reports_Fee_IT_Receipt_Reports itfeereceiptreports;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "FeeItReceiptReportsTestData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsFeegroup = getData("FeeModueData.xlsx", "FeeItReceiptData");
		return testRecordsFeegroup;
	}
	@BeforeClass
	public void setUp() throws IOException {
		init();
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);
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
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			itfeereceiptreports.verifyHomeButton();
			
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNevigateToReports_FeeIt_ReceiptReports() {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);

		try {
			log.info("============= Strting tcNevigateToReports_FeeIt_ReceiptReports Test===========");

			itfeereceiptreports.nevigateToReports_FeeIt_ReceiptReports();
			
			log.info("============= Finished tcNevigateToReports_FeeIt_ReceiptReports Test===========");
			getScreenShot("tcNevigateToReports_FeeIt_ReceiptReports");
		} catch (Exception e) {
			getScreenShot("tcNevigateToReports_FeeIt_ReceiptReports");
		}
	}
	@Test(priority = 4)
	public void tcVerifyFeeItReceiptReportsPage() {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);

		try {
			log.info("============= Strting tcVerifyFeeItReceiptReportsPage Test===========");

			boolean status =itfeereceiptreports.verifyFeeItReceiptReportsPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeItReceiptReportsPage Test===========");
			getScreenShot("tcVerifyFeeItReceiptReportsPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeItReceiptReportsPage");
		}
	}
	@Test(priority = 5, dataProvider = "FeeItReceiptReportsTestData")
	public void tcSelectAcademicYrClassSectionStuNameAndReceiptNo(String academicYr, String classname,String section, String studentName,String receiptNum, String runMode) {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYrClassSectionStuNameAndReceiptNo Test===========");

			itfeereceiptreports.selectAcademicYrClassSectionStuNameAndReceiptNo(academicYr, classname, section, studentName, receiptNum);
			log.info("============= Finished tcSelectAcademicYrClassSectionStuNameAndReceiptNo Test===========");
			getScreenShot("tcSelectAcademicYrClassSectionStuNameAndReceiptNo");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYrClassSectionStuNameAndReceiptNo");
		}
	}
	
	@Test(priority = 6)
	public void tcClickOnShowButton() {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);

		try {
			log.info("============= Strting tcClickOnShowButton Test===========");

			itfeereceiptreports.clickOnShowButton();
			
			log.info("============= Finished tcClickOnShowButton Test===========");
			getScreenShot("tcClickOnShowButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnShowButton");
		}
	}
	@Test(priority = 7)
	public void tcClickOnPrintbutton() {
		itfeereceiptreports = new Reports_Fee_IT_Receipt_Reports(driver);

		try {
			log.info("============= Strting tcClickOnPrintbutton Test===========");

			itfeereceiptreports.clickOnPrintbutton();
			
			log.info("============= Finished tcClickOnPrintbutton Test===========");
			getScreenShot("tcClickOnPrintbutton");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrintbutton");
		}
	}

}
