/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_MarksCalculation;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Exam.MarksCalculation.Exam_MarksCalculation_Calculation;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_Exam_MarksCalculation_Calculation extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Exam_MarksCalculation_Calculation.class.getName());

	Exam_MarksCalculation_Calculation calculationmarks;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamMarksCalculation_Form")
	public String[][] getTestData() {
		String[][] testRecordsCategory = getData("ExamMasters.xlsx", "MarksCalculationData");
		return testRecordsCategory;
	}

	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		calculationmarks = new Exam_MarksCalculation_Calculation(driver);
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

			boolean status = calculationmarks.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExam_MarksCalculation_Calculation() {

		try {
			log.info("============= Strting tcNavigateToExam_MarksCalculation_Calculation Test===========");

			calculationmarks.navigateToExam_MarksCalculation_Calculation();

			log.info("============= Finished tcNavigateToExam_MarksCalculation_Calculation Test===========");
			getScreenShot("tcNavigateToExam_MarksCalculation_Calculation");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExam_MarksCalculation_Calculation");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamMarksCalculation_Calculation_Page() {

		try {
			log.info("============= Strting tcVerifyExamMarksCalculation_Calculation_Page Test===========");

			boolean status = calculationmarks.verifyExamMarksCalculation_CalculationPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamMarksCalculation_Calculation_Page Test===========");
			getScreenShot("tcVerifyExamMarksCalculation_Calculation_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamMarksCalculation_Calculation_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_MarksCalculation_CalculationForm() {

		try {
			log.info("============= Strting tcSubmitBlank_MarksCalculation_CalculationForm Test===========");

			calculationmarks.submitBlank_MarksCalculation_CalculationForm();

			log.info("============= Finished tcSubmitBlank_MarksCalculation_CalculationForm Test===========");
			getScreenShot("tcSubmitBlank_MarksCalculation_CalculationForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_MarksCalculation_CalculationForm");
		}
	}

	@Test(priority = 6, dataProvider = "ExamMarksCalculation_Form")
	public void tcFill_ExamMarksCalculation_CalculationForm(String academicYear, String class_mc, String section,
			String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamMarksCalculation_CalculationForm Test===========");

			calculationmarks.fill_ExamMarksCalculation_CalculationForm(academicYear, class_mc, section, examName);

			log.info("============= Finished tcFill_ExamMarksCalculation_CalculationForm Test===========");
			getScreenShot("tcFill_ExamMarksCalculation_CalculationForm");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamMarksCalculation_CalculationForm");
		}
	}
	@Test(priority = 7)
	public void tcSubmit_MarksCalculation_CalculationForm() {

		try {
			log.info("============= Strting tcSubmit_MarksCalculation_CalculationForm Test===========");

			calculationmarks.submit_MarksCalculation_CalculationForm();

			log.info("============= Finished tcSubmit_MarksCalculation_CalculationForm Test===========");
			getScreenShot("tcSubmit_MarksCalculation_CalculationForm");
		} catch (Exception e) {
			getScreenShot("tcSubmit_MarksCalculation_CalculationForm");
		}
	}
	@Test(priority = 8)
	public void tcPopUpWindowMessage_MarksCalCulationSuccessfully() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_MarksCalCulationSuccessfully Test===========");

			calculationmarks.popUpWindowMessage_MarksCalCulationSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_MarksCalCulationSuccessfully Test===========");
			getScreenShot("tcPopUpWindowMessage_MarksCalCulationSuccessfully");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_MarksCalCulationSuccessfully");
		}
	}
	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn_ConfirmSubmitCalculation() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ConfirmSubmitCalculation Test===========");

			calculationmarks.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ConfirmSubmitCalculation Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmSubmitCalculation");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmSubmitCalculation");
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
