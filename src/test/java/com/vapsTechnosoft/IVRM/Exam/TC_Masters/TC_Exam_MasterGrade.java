/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Exam.Masters.Exam_MasterCategoryAndCategoryClassMapping;
import com.vapsTechnosoft.IVRM.Exam.Masters.Exam_MasterGrade;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Exam_MasterGrade extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Exam_MasterGrade.class.getName());

	Exam_MasterGrade mastergrade;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "ExamMasterGrade_Form_Percentage")
	public String[][] getTestDataPercentage() {
		String[][] testRecordsPercentage = getData("ExamMasters.xlsx", "ExamMasterGardeData_PerCentage");
		return testRecordsPercentage;
	}
	@DataProvider(name = "ExamMasterGrade_Form_Marks")
	public String[][] getTestDataMarks() {
		String[][] testRecordsMarks = getData("ExamMasters.xlsx", "ExamMasterGardeData_Marks");
		return testRecordsMarks;
	}

	@DataProvider(name = "MasterGradeDetails_GradeA")
	public String[][] getTestDataGradeA() {
		String[][] testRecordsGradeA = getData("ExamMasters.xlsx", "MasterGradeDetailsGradeA");
		return testRecordsGradeA;
	}
	
	@DataProvider(name = "MasterGradeDetails_GradeB")
	public String[][] getTestDataGradeB() {
		String[][] testRecordsGradeB = getData("ExamMasters.xlsx", "MasterGradeDetailsGradeB");
		return testRecordsGradeB;
	}
	@DataProvider(name = "MasterGradeDetails_GradeC")
	public String[][] getTestDataGradeC() {
		String[][] testRecordsGradeC = getData("ExamMasters.xlsx", "MasterGradeDetailsGradeC");
		return testRecordsGradeC;
	}
	@DataProvider(name = "MasterGradeDetails_GradeD")
	public String[][] getTestDataGradeD() {
		String[][] testRecordsGradeD = getData("ExamMasters.xlsx", "MasterGradeDetailsGradeD");
		return testRecordsGradeD;
	}

	@DataProvider(name = "filter_MasterGrade_Percentage")
	public String[][] getTestSearchData() {
		String[][] testRecordsFilter = getData("ExamMasters.xlsx", "filter_GradeMarksPercentage");
		return testRecordsFilter;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastergrade = new Exam_MasterGrade(driver);
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

			boolean status = mastergrade.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMasters_ExamMasterGrade() {

		try {
			log.info("============= Strting tcNavigateToExamMasters_ExamMasterGrade Test===========");

			mastergrade.navigateToExamMasters_ExamMasterGrade();

			log.info("============= Finished tcNavigateToExamMasters_ExamMasterGrade Test===========");
			getScreenShot("tcNavigateToExamMasters_ExamMasterGrade");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMasters_ExamMasterGrade");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamMasterGrade_Page() {

		try {
			log.info("============= Strting tcVerifyExamMasterGrade_Page Test===========");

			boolean status = mastergrade.verifyExamMasterGradePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamMasterGrade_Page Test===========");
			getScreenShot("tcVerifyExamMasterGrade_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamMasterGrade_Page");
		}
	}

	@Test(priority = 5, dataProvider = "ExamMasterGrade_Form_Percentage")
	public void tcFill_Exam_MasterGrade_Form_Percentage(String gradeName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterGrade_Form_Precentage Test===========");

			mastergrade.fill_Exam_MasterGrade_Form_Precentage(gradeName);

			log.info("============= Finished tcFill_Exam_MasterGrade_Form_Precentage Test===========");
			getScreenShot("tcFill_Exam_MasterGrade_Form_Precentage");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterGrade_Form_Precentage");
		}
	}

	@Test(priority = 6)
	public void tcClickOnSaveButton_ToSubmitBlank_MasterGradeDetails() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlank_MasterGradeDetails Test===========");

			mastergrade.submitBlank_MasterGradeDetails();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlank_MasterGradeDetails Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlank_MasterGradeDetails");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlank_MasterGradeDetails");
		}
	}

	@Test(priority = 7, dataProvider = "MasterGradeDetails_GradeA")
	public void tcFill_MasterGradeDetails_Grade_A_Percentage(String from_A, String to_A, String grade_A,
			String gradePoint_A, String remarks_A, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_A_Percentage Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_A(from_A, to_A, grade_A, gradePoint_A, remarks_A);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_A_Percentage Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Percentage");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Percentage");
		}
	}

	@Test(priority = 8)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeB();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage");
		}
	}

	@Test(priority = 9, dataProvider = "MasterGradeDetails_GradeB")
	public void tcFill_MasterGradeDetails_Grade_B_Percentage(String from_B, String to_B, String grade_B,
			String gradePoint_B, String remarks_B, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_B_Percentage Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_B(from_B, to_B, grade_B, gradePoint_B, remarks_B);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_B_Percentage Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Percentage");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Percentage");
		}
	}

	@Test(priority = 10)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeC();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage");
		}
	}

	@Test(priority = 11, dataProvider = "MasterGradeDetails_GradeC")
	public void tcFill_MasterGradeDetails_Grade_C_Percentage(String from_C, String to_C, String grade_C,
			String gradePoint_C, String remarks_C, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_C_Percentage Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_C(from_C, to_C, grade_C, gradePoint_C, remarks_C);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_C_Percentage Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Percentage");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Percentage");
		}
	}

	@Test(priority = 12)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeD();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage");
		}
	}

	@Test(priority = 13, dataProvider = "MasterGradeDetails_GradeD")
	public void tcFill_MasterGradeDetails_Grade_D_Percentage(String from_D, String to_D, String grade_D,
			String gradePoint_D, String remarks_D, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_D_Percentage Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_D(from_D, to_D, grade_D, gradePoint_D, remarks_D);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_D_Percentage Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Percentage");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Percentage");
		}
	}

	@Test(priority = 14)
	public void tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage() {

		try {
			log.info("============= Strting tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage Test===========");

			mastergrade.clickOnMinusSign_ToRemoveRow_GradeD();

			log.info("============= Finished tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage Test===========");
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage");
		}
	}

	@Test(priority = 15)
	public void tcMinimize_MasterGrade() {

		try {
			log.info("============= Strting tcMinimize_MasterGrade Test===========");

			mastergrade.min_Max_MasterGrade();

			log.info("============= Finished tcMinimize_MasterGrade Test===========");
			getScreenShot("tcMinimize_MasterGrade");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterGrade");
		}
	}

	@Test(priority = 16)
	public void tcMinimize_GradeMasterDetailsForm() {

		try {
			log.info("============= Strting tcMinimize_GradeMasterDetailsForm Test===========");

			mastergrade.min_Max_GradeMasterDetailsForm();
			log.info("============= Finished tcMinimize_GradeMasterDetailsForm Test===========");
			getScreenShot("tcMinimize_GradeMasterDetailsForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_GradeMasterDetailsForm");
		}
	}

	@Test(priority = 17)
	public void tcMinimize_GradeMaster_GridView() {

		try {
			log.info("============= Strting tcMinimize_GradeMaster_GridView Test===========");

			mastergrade.min_Max_GradeMaster_GridView();

			log.info("============= Finished tcMinimize_GradeMaster_GridView Test===========");
			getScreenShot("tcMinimize_GradeMaster_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_GradeMaster_GridView");
		}
	}

	@Test(priority = 18)
	public void tcMaximize_GradeMaster_GridView() {

		try {
			log.info("============= Strting tcMaximize_GradeMaster_GridView Test===========");

			mastergrade.min_Max_GradeMaster_GridView();

			log.info("============= Finished tcMaximize_GradeMaster_GridView Test===========");
			getScreenShot("tcMaximize_GradeMaster_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_GradeMaster_GridView");
		}
	}

	@Test(priority = 19)
	public void tcMaximize_GradeMasterDetailsForm() {

		try {
			log.info("============= Strting tcMaximize_GradeMasterDetailsForm Test===========");

			mastergrade.min_Max_GradeMasterDetailsForm();

			log.info("============= Finished tcMaximize_GradeMasterDetailsForm Test===========");
			getScreenShot("tcMaximize_GradeMasterDetailsForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_GradeMasterDetailsForm");
		}
	}

	@Test(priority = 20)
	public void tcMaximize_MasterGrade() {

		try {
			log.info("============= Strting tcMaximize_MasterGrade Test===========");

			mastergrade.min_Max_MasterGrade();

			log.info("============= Finished tcMaximize_MasterGrade Test===========");
			getScreenShot("tcMaximize_MasterGrade");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterGrade");
		}
	}

	@Test(priority = 21)
	public void tcClickOnCancelButton_ToClearMasterGradeFilledData_Percentage() {

		try {
			log.info(
					"============= Strting tcClickOnCancelButton_ToClearMasterGradeFilledData_Percentage Test===========");

			mastergrade.clickOnCancelButton_ToClearMasterGradeFilledData();

			log.info(
					"============= Finished tcClickOnCancelButton_ToClearMasterGradeFilledData_Percentage Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearMasterGradeFilledData_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearMasterGradeFilledData_Percentage");
		}
	}

	@Test(priority = 22, dataProvider = "ExamMasterGrade_Form_Percentage")
	public void tcFill_Exam_MasterGrade_Form_Percentage_AfterCancel(String gradeName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterGrade_Form_Percentage_AfterCancel Test===========");

			mastergrade.fill_Exam_MasterGrade_Form_Precentage(gradeName);

			log.info("============= Finished tcFill_Exam_MasterGrade_Form_Percentage_AfterCancel Test===========");
			getScreenShot("tcFill_Exam_MasterGrade_Form_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterGrade_Form_Percentage_AfterCancel");
		}
	}

	@Test(priority = 23, dataProvider = "MasterGradeDetails_GradeA")
	public void tcFill_MasterGradeDetails_Grade_A_Percentage_AfterCancel(String from_A, String to_A, String grade_A,
			String gradePoint_A, String remarks_A, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_A_Percentage_AfterCancel Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_A(from_A, to_A, grade_A, gradePoint_A, remarks_A);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_A_Percentage_AfterCancel Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Percentage_AfterCancel");
		}
	}

	@Test(priority = 24)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage_AfterCancel Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeB();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage_AfterCancel Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Percentage_AfterCancel");
		}
	}

	@Test(priority = 25, dataProvider = "MasterGradeDetails_GradeB")
	public void tcFill_MasterGradeDetails_Grade_B_Percentage_AfterCancel(String from_B, String to_B, String grade_B,
			String gradePoint_B, String remarks_B, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_B_Percentage_AfterCancel Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_B(from_B, to_B, grade_B, gradePoint_B, remarks_B);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_B_Percentage_AfterCancel Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Percentage_AfterCancel");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage_AfterCancel Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeC();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage_AfterCancel Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Percentage_AfterCancel");
		}
	}

	@Test(priority = 27, dataProvider = "MasterGradeDetails_GradeC")
	public void tcFill_MasterGradeDetails_Grade_C_Percentage_AfterCancel(String from_C, String to_C, String grade_C,
			String gradePoint_C, String remarks_C, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_C_Percentage_AfterCancel Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_C(from_C, to_C, grade_C, gradePoint_C, remarks_C);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_C_Percentage_AfterCancel Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Percentage_AfterCancel");
		}
	}

	@Test(priority = 28)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage_AfterCancel Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeD();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage_AfterCancel Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Percentage_AfterCancel");
		}
	}

	@Test(priority = 29, dataProvider = "MasterGradeDetails_GradeD")
	public void tcFill_MasterGradeDetails_Grade_D_Percentage_AfterCancel(String from_D, String to_D, String grade_D,
			String gradePoint_D, String remarks_D, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_D_Percentage_AfterCancel Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_D(from_D, to_D, grade_D, gradePoint_D, remarks_D);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_D_Percentage_AfterCancel Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Percentage_AfterCancel");
		}
	}

	@Test(priority = 30)
	public void tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage_AfterCancel Test===========");

			mastergrade.clickOnMinusSign_ToRemoveRow_GradeD();

			log.info(
					"============= Finished tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage_AfterCancel Test===========");
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Percentage_AfterCancel");
		}
	}

	@Test(priority = 31)
	public void tcClickOnSaveButton_ToSubmitMasterGradeDetails_Percentage() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitMasterGradeDetails_Percentage Test===========");

			mastergrade.clickOnSaveButton_ToSubmitMasterGradeDetails();

			log.info(
					"============= Finished tcClickOnSaveButton_ToSubmitMasterGradeDetails_Percentage Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Percentage");
		}
	}

	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Percentage() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Percentage Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Percentage Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Percentage");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Percentage");
		}
	}
	// Marks

	@Test(priority = 33, dataProvider = "ExamMasterGrade_Form_Marks")
	public void tcFill_Exam_MasterGrade_Form_Marks(String gradeName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterGrade_Form_Marks Test===========");

			mastergrade.fill_Exam_MasterGrade_Form_Marks(gradeName);

			log.info("============= Finished tcFill_Exam_MasterGrade_Form_Marks Test===========");
			getScreenShot("tcFill_Exam_MasterGrade_Form_Marks");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterGrade_Form_Marks");
		}
	}

	@Test(priority = 34, dataProvider = "MasterGradeDetails_GradeA")
	public void tcFill_MasterGradeDetails_Grade_A_Marks(String from_A, String to_A, String grade_A, String gradePoint_A,
			String remarks_A, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_A_Marks Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_A(from_A, to_A, grade_A, gradePoint_A, remarks_A);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_A_Marks Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Marks");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_A_Marks");
		}
	}

	@Test(priority = 35)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Marks() {

		try {
			log.info("============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Marks Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeB();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Marks Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeB_Marks");
		}
	}

	@Test(priority = 36, dataProvider = "MasterGradeDetails_GradeB")
	public void tcFill_MasterGradeDetails_Grade_B_Marks(String from_B, String to_B, String grade_B, String gradePoint_B,
			String remarks_B, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_B_Marks Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_B(from_B, to_B, grade_B, gradePoint_B, remarks_B);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_B_Marks Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Marks");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_B_Marks");
		}
	}

	@Test(priority = 37)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Marks() {

		try {
			log.info("============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Marks Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeC();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Marks Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeC_Marks");
		}
	}

	@Test(priority = 38, dataProvider = "MasterGradeDetails_GradeC")
	public void tcFill_MasterGradeDetails_Grade_C_Marks(String from_C, String to_C, String grade_C, String gradePoint_C,
			String remarks_C, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_C_Marks Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_C(from_C, to_C, grade_C, gradePoint_C, remarks_C);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_C_Marks Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Marks");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_C_Marks");
		}
	}

	@Test(priority = 39)
	public void tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Marks() {

		try {
			log.info("============= Strting tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Marks Test===========");

			mastergrade.clickOnPlusSign_ToGetNewRowForGradeDetails_GradeD();

			log.info(
					"============= Finished tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Marks Test===========");
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnPlusSign_ToGetNewRowForGradeDetails_GradeD_Marks");
		}
	}

	@Test(priority = 40, dataProvider = "MasterGradeDetails_GradeD")
	public void tcFill_MasterGradeDetails_Grade_D_Marks(String from_D, String to_D, String grade_D, String gradePoint_D,
			String remarks_D, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MasterGradeDetails_Grade_D_Marks Test===========");

			mastergrade.fill_MasterGradeDetails_Grade_D(from_D, to_D, grade_D, gradePoint_D, remarks_D);

			log.info("============= Finished tcFill_MasterGradeDetails_Grade_D_Marks Test===========");
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Marks");
		} catch (Exception e) {
			getScreenShot("tcFill_MasterGradeDetails_Grade_D_Marks");
		}
	}

	@Test(priority = 41)
	public void tcClickOnMinusSign_ToRemoveRow_GradeD_Marks() {

		try {
			log.info("============= Strting tcClickOnMinusSign_ToRemoveRow_GradeD_Marks Test===========");

			mastergrade.clickOnMinusSign_ToRemoveRow_GradeD();

			log.info("============= Finished tcClickOnMinusSign_ToRemoveRow_GradeD_Marks Test===========");
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnMinusSign_ToRemoveRow_GradeD_Marks");
		}
	}

	@Test(priority = 42)
	public void tcClickOnSaveButton_ToSubmitMasterGradeDetails_Marks() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitMasterGradeDetails_Marks Test===========");

			mastergrade.clickOnSaveButton_ToSubmitMasterGradeDetails();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitMasterGradeDetails_Marks Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Marks");
		}
	}

	@Test(priority = 43)
	public void tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Marks() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Marks Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Marks Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Marks");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ToSubmit_MasterGrade_Marks");
		}
	}

	@Test(priority = 44)
	public void tcSortWithGradeNameInGridView() {

		try {
			log.info("============= Strting tcSortWithGradeNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithGradeNameInGridView");
			mastergrade.sortWithGradeNameInGridView();

			log.info("============= Finished tcSortWithGradeNameInGridView Test===========");
			getScreenShot("tcSortWithGradeNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithGradeNameInGridView");
		}
	}

	@Test(priority = 45)
	public void tcSortWithMarksOrPercentageInGridView() {

		try {
			log.info("============= Strting tcSortWithMarksOrPercentageInGridView Test===========");
			getScreenShot("_BeforeSorting_tcSortWithMarksOrPercentageInGridView");
			mastergrade.sortWithMarksOrPercentageInGridView();

			log.info("============= Finished tcSortWithMarksOrPercentageInGridView Test===========");
			getScreenShot("tcSortWithMarksOrPercentageInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithMarksOrPercentageInGridView");
		}
	}

	@Test(priority = 46, dataProvider = "filter_MasterGrade_Percentage")
	public void tcFilterRecordsBasedOn_GradeName(String gradeName, String marksOrPercentage, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName Test===========");

			mastergrade.filterRecordsBasedOn_GradeName(gradeName, marksOrPercentage);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName");
		}
	}

	@Test(priority = 47)
	public void tcClearFilledDataForFilter_GradeName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_GradeName Test===========");

			mastergrade.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_GradeName Test===========");
			getScreenShot("tcClearFilledDataForFilter_GradeName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_GradeName");
		}
	}

	@Test(priority = 48, dataProvider = "filter_MasterGrade_Percentage")
	public void tcFilterRecordsBasedOn_MarksOrPercentage(String gradeName, String marksOrPercentage, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_MarksOrPercentage Test===========");

			mastergrade.filterRecordsBasedOn_MarksOrPercentage(gradeName, marksOrPercentage);

			log.info("============= Finished tcFilterRecordsBasedOn_MarksOrPercentage Test===========");
			getScreenShot("tcFilterRecordsBasedOn_MarksOrPercentage");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_MarksOrPercentage");
		}
	}

	@Test(priority = 49)
	public void tcClearFilledDataForFilter_MarksOrPercentage() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_MarksOrPercentage Test===========");

			mastergrade.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_MarksOrPercentage Test===========");
			getScreenShot("tcClearFilledDataForFilter_MarksOrPercentage");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_MarksOrPercentage");
		}
	}

	@Test(priority = 50)
	public void tcClickOnViewIcon_ToSeeMasterGradeDetails() {

		try {
			log.info("============= Strting tcClickOnViewIcon_ToSeeMasterGradeDetails Test===========");

			mastergrade.clickOnViewIcon_ToSeeMasterGradeDetails();
			log.info("============= Finished tcClickOnViewIcon_ToSeeMasterGradeDetails Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeMasterGradeDetails");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeMasterGradeDetails");
		}
	}

	@Test(priority = 51)
	public void tcCloseViewWindow_MasterGrade() {

		try {
			log.info("============= Strting tcCloseViewWindow_MasterGrade Test===========");

			mastergrade.closeViewWindow_MasterGrade();
			log.info("============= Finished tcCloseViewWindow_MasterGrade Test===========");
			getScreenShot("tcCloseViewWindow_MasterGrade");
		} catch (Exception e) {
			getScreenShot("tcCloseViewWindow_MasterGrade");
		}
	}

	@Test(priority = 52)
	public void tcClickOnEditIcon_ToUpdateMasterGrade() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateMasterGrade Test===========");

			mastergrade.clickOnEditIcon_ToUpdateMasterGrade();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateMasterGrade Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateMasterGrade");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateMasterGrade");
		}
	}

	@Test(priority = 53)
	public void tcClickOnSaveButton_ToSubmitMasterGradeDetails_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitMasterGradeDetails_Edit Test===========");

			mastergrade.clickOnSaveButton_ToSubmitMasterGradeDetails();
			log.info("============= Finished tcClickOnSaveButton_ToSubmitMasterGradeDetails_Edit Test===========");

			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Edit");

		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterGradeDetails_Edit");
		}
	}

	@Test(priority = 54)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterGrade() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterGrade Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterGrade Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterGrade");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterGrade");
		}
	}

	@Test(priority = 55, dataProvider = "filter_MasterGrade_Percentage")
	public void tcFilterRecordsBasedOn_GradeName_ForDeactivate(String gradeName, String marksOrPercentage,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName_ForDeactivate Test===========");

			mastergrade.filterRecordsBasedOn_GradeName(gradeName, marksOrPercentage);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName_ForDeactivate Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ForDeactivate");
		}
	}

	@Test(priority = 56)
	public void tcDeactivateRecords_MasterGradeGrid() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterGradeGrid Test===========");

			mastergrade.deactivateRecords_MasterGradeGrid();

			log.info("============= Finished tcDeactivateRecords_MasterGradeGrid Test===========");
			getScreenShot("tcDeactivateRecords_MasterGradeGrid");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterGradeGrid");
		}
	}

	@Test(priority = 57)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			mastergrade.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 58)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}

	@Test(priority = 59)
	public void tcDeactivateRecords_MasterGradeGrid_AfterCancel() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterGradeGrid_AfterCancel Test===========");

			mastergrade.deactivateRecords_MasterGradeGrid();

			log.info("============= Finished tcDeactivateRecords_MasterGradeGrid_AfterCancel Test===========");
			getScreenShot("tcDeactivateRecords_MasterGradeGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterGradeGrid_AfterCancel");
		}
	}

	@Test(priority = 60)
	public void tcYesDeactivateMasterGradeRecord() {

		try {
			log.info("============= Strting tcYesDeactivateMasterGradeRecord Test===========");

			mastergrade.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesDeactivateMasterGradeRecord Test===========");
			getScreenShot("tcYesDeactivateMasterGradeRecord");
		} catch (Exception e) {
			getScreenShot("tcYesDeactivateMasterGradeRecord");
		}
	}

	@Test(priority = 61)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}
	@Test(priority = 62, dataProvider = "filter_MasterGrade_Percentage")
	public void tcFilterRecordsBasedOn_GradeName_ForActivate(String gradeName, String marksOrPercentage,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName_ForActivate Test===========");

			mastergrade.filterRecordsBasedOn_GradeName(gradeName, marksOrPercentage);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName_ForActivate Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ForActivate");
		}
	}

	@Test(priority = 63)
	public void tcActivateRecords_MasterGradeGrid() {

		try {
			log.info("============= Strting tcActivateRecords_MasterGradeGrid Test===========");

			mastergrade.activateRecords_MasterGradeGrid();

			log.info("============= Finished tcActivateRecords_MasterGradeGrid Test===========");
			getScreenShot("tcActivateRecords_MasterGradeGrid");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterGradeGrid");
		}
	}

	@Test(priority = 64)
	public void tcCancel_ActivatePopUp_viewWindow() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp_viewWindow Test===========");

			mastergrade.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_ActivatePopUp_viewWindow Test===========");
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		}
	}

	@Test(priority = 65)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 66)
	public void tcActivateRecords_MasterGradeGrid_AfterCancel() {

		try {
			log.info("============= Strting tcActivateRecords_MasterGradeGrid_AfterCancel Test===========");

			mastergrade.activateRecords_MasterGradeGrid();

			log.info("============= Finished tcActivateRecords_MasterGradeGrid_AfterCancel Test===========");
			getScreenShot("tcActivateRecords_MasterGradeGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterGradeGrid_AfterCancel");
		}
	}

	@Test(priority = 67)
	public void tcYesActivateMasterGradeRecord() {

		try {
			log.info("============= Strting tcYesActivateMasterGradeRecord Test===========");

			mastergrade.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesActivateMasterGradeRecord Test===========");
			getScreenShot("tcYesActivateMasterGradeRecord");
		} catch (Exception e) {
			getScreenShot("tcYesActivateMasterGradeRecord");
		}
	}

	@Test(priority = 68)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			mastergrade.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
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
