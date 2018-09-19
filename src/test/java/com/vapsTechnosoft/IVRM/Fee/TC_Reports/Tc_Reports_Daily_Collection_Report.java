/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Reports.Reports_Daily_Collection_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Reports_Daily_Collection_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Reports_Daily_Collection_Report.class.getName());

	Reports_Daily_Collection_Report dailycollectionReport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "DailyCollectionData")
	public String[][] getTestDataDCR() {
		String[][] testRecordsDCR = getData("FeeReportsData.xlsx", "DailyCollectionReport");
		return testRecordsDCR;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);
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
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			dailycollectionReport.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToReports_Daily_CollectionReports() {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcNevigateToReports_Daily_CollectionReports Test===========");

			dailycollectionReport.nevigateToReports_Daily_CollectionReports();

			log.info("============= Finished tcNevigateToReports_Daily_CollectionReports Test===========");
			getScreenShot("tcNevigateToReports_Daily_CollectionReports");
		} catch (Exception e) {
			getScreenShot("tcNevigateToReports_Daily_CollectionReports");
		}
	}

	@Test(priority = 4)
	public void tcVerifyDailyCollectionReportsPage() {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcVerifyDailyCollectionReportsPage Test===========");

			boolean status = dailycollectionReport.verifyDailyCollectionReportsPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyDailyCollectionReportsPage Test===========");
			getScreenShot("tcVerifyDailyCollectionReportsPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyDailyCollectionReportsPage");
		}
	}

	@Test(priority = 5, dataProvider = "DailyCollectionData")
	public void tcRequiredInfoToGenerateDailyCollectionReports(String academicYear, String class_Stu, String fromDate,
			String toDate, String runMode) {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcRequiredInfoToGenerateDailyCollectionReports Test===========");

			dailycollectionReport.requiredInfoToGenerateDailyCollectionReports(academicYear, class_Stu, fromDate,
					toDate);
			log.info("============= Finished tcRequiredInfoToGenerateDailyCollectionReports Test===========");
			getScreenShot("tcRequiredInfoToGenerateDailyCollectionReports");
		} catch (Exception e) {
			getScreenShot("tcRequiredInfoToGenerateDailyCollectionReports");
		}
	}

	@Test(priority = 6)
	public void tcGenerateReportsByClickingOnReportButton() {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcGenerateReportsByClickingOnReportButton Test===========");

			dailycollectionReport.generateReportsByClickingOnReportButton();

			log.info("============= Finished tcGenerateReportsByClickingOnReportButton Test===========");
			getScreenShot("tcGenerateReportsByClickingOnReportButton");
		} catch (Exception e) {
			getScreenShot("tcGenerateReportsByClickingOnReportButton");
		}
	}

	@Test(priority = 7)
	public void tcDownloadExcelReport() {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcDownloadExcelReport Test===========");

			dailycollectionReport.downloadExcelReport();

			log.info("============= Finished tcDownloadExcelReport Test===========");
			getScreenShot("tcDownloadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcDownloadExcelReport");
		}
	}

	@Test(priority = 8)
	public void tcDownloadPdfReport() {
		dailycollectionReport = new Reports_Daily_Collection_Report(driver);

		try {
			log.info("============= Strting tcDownloadPdfReport Test===========");

			dailycollectionReport.downloadPdfReport();

			log.info("============= Finished tcDownloadPdfReport Test===========");
			getScreenShot("tcDownloadPdfReport");
		} catch (Exception e) {
			getScreenShot("tcDownloadPdfReport");
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