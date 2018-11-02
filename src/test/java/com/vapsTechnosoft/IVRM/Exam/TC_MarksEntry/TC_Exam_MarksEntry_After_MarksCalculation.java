/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_MarksEntry;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.Exam.MarksEntry.Exam_MarksEntry_After_MarksCalculation;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 * 
 * Staff Login, UserName: Priya and Password: Password@123
 *
 */
public class TC_Exam_MarksEntry_After_MarksCalculation extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Exam_MarksEntry.class.getName());

	Exam_MarksEntry_After_MarksCalculation marksentry_marksCalc;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin_Staff = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin_Staff;
	}
	@DataProvider(name = "Exam_MarksEntry_FormData")
	public String[][] getTestDataMarksEntry() {
		String[][] testRecordsMarksEntry = getData("ExamMasters.xlsx", "MarksEntryData_form");
		return testRecordsMarksEntry;
	}
	@DataProvider(name = "filter_MarksEntryDetails_Data")
	public String[][] getTestData() {
		String[][] testRecordsEntryDetails = getData("ExamMasters.xlsx", "filter_MarksEntryDetails");
		return testRecordsEntryDetails;
	}
	
	
	@DataProvider(name = "MarksEntry_MarksObtain_Data")
	public String[][] getTestDataMarksObtain() {
		String[][] testRecordsMarksObtain = getData("ExamMasters.xlsx", "MarksEntry_MarksObtain");
		return testRecordsMarksObtain;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		marksentry_marksCalc = new Exam_MarksEntry_After_MarksCalculation(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData_Staff")
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

			boolean status = marksentry_marksCalc.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExam_MarksEntry() {

		try {
			log.info("============= Strting tcNavigateToExam_MarksEntry Test===========");

			marksentry_marksCalc.navigateToExam_MarksEntry();

			log.info("============= Finished tcNavigateToExam_MarksEntry Test===========");
			getScreenShot("tcNavigateToExam_MarksEntry");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExam_MarksEntry");
		}
	}

	@Test(priority = 4)
	public void tcVverifyExam_MarksEntry_Page() {

		try {
			log.info("============= Strting tcVverifyExam_MarksEntry_Page Test===========");

			boolean status = marksentry_marksCalc.verifyExam_MarksEntryPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVverifyExam_MarksEntry_Page Test===========");
			getScreenShot("tcVverifyExam_MarksEntry_Page");
		} catch (Exception e) {
			getScreenShot("tcVverifyExam_MarksEntry_Page");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSearchButton_ToSubmitRecords_Blank() {

		try {
			log.info("============= Strting tcClickOnSearchButton_ToSubmitRecords_Blank Test===========");

			marksentry_marksCalc.clickOnSearchButton_ToGetStudentMarksEntryList();

			log.info("============= Finished tcClickOnSearchButton_ToSubmitRecords_Blank Test===========");
			getScreenShot("tcClickOnSearchButton_ToSubmitRecords_Blank");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchButton_ToSubmitRecords_Blank");
		}
	}
	@Test(priority = 6, dataProvider = "Exam_MarksEntry_FormData")
	public void tcFill_MarksEntry_Form(String academicYear, String class_Me, String section, String examType,
			String subject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MarksEntry_Form Test===========");

			marksentry_marksCalc.fill_MarksEntry_Form(academicYear, class_Me, section, examType, subject);
			log.info("============= Finished tcFill_MarksEntry_Form Test===========");
			getScreenShot("tcFill_MarksEntry_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_MarksEntry_Form");
		}
	}
	@Test(priority = 7)
	public void tcClickOnSearchButton_ToGetStudentMarksEntryList() {

		try {
			log.info("============= Strting tcClickOnSearchButton_ToGetStudentMarksEntryList Test===========");

			marksentry_marksCalc.clickOnSearchButton_ToGetStudentMarksEntryList();
			log.info("============= Finished tcClickOnSearchButton_ToGetStudentMarksEntryList Test===========");
			getScreenShot("tcClickOnSearchButton_ToGetStudentMarksEntryList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchButton_ToGetStudentMarksEntryList");
		}
	}
	@Test(priority = 8)
	public void tcSort_ByStudentName() {

		try {
			log.info("============= Strting tcSort_ByStudentName Test===========");
			getScreenShot("BeforeSorting_tcSort_ByStudentName");
			marksentry_marksCalc.sort_ByStudentName();

			log.info("============= Finished tcSort_ByStudentName Test===========");
			getScreenShot("tcSort_ByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSort_ByStudentName");
		}
	}

	@Test(priority = 9)
	public void tcSort_ByRollNumber() {

		try {
			log.info("============= Strting tcSort_ByRollNumber Test===========");
			getScreenShot("_BeforeSorting_tcSort_ByRollNumber");
			marksentry_marksCalc.sort_ByRollNumber();

			log.info("============= Finished tcSort_ByRollNumber Test===========");
			getScreenShot("tcSort_ByRollNumber");
		} catch (Exception e) {
			getScreenShot("tcSort_ByRollNumber");
		}
	}

	@Test(priority = 10)
	public void tcSort_ByMarksObtain() {

		try {
			log.info("============= Strting tcSort_ByMarksObtain Test===========");
			getScreenShot("BeforeSorting_tcSort_ByMarksObtain");
			marksentry_marksCalc.sort_ByMarksObtain();

			log.info("============= Finished tcSort_ByMarksObtain Test===========");
			getScreenShot("tcSort_ByMarksObtain");
		} catch (Exception e) {
			getScreenShot("tcSort_ByMarksObtain");
		}
	}
	@Test(priority = 11, dataProvider = "filter_MarksEntryDetails_Data")
	public void tcFilterRecordsBasedOn_StudentName(String studentName, String admNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_StudentName Test===========");

			marksentry_marksCalc.filterRecordsBasedOn_StudentName(studentName, admNumber, rollNumber);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_StudentName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_StudentName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_StudentName");
		}
	}

	@Test(priority = 12)
	public void tcClearFilledDataForFilter_StudentName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_StudentName Test===========");

			marksentry_marksCalc.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_StudentName Test===========");
			getScreenShot("tcClearFilledDataForFilter_StudentName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_StudentName");
		}
	}
	@Test(priority = 13, dataProvider = "filter_MarksEntryDetails_Data")
	public void tcFilterRecordsBasedOn_AdmissionNum(String studentName, String admNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AdmissionNum Test===========");

			marksentry_marksCalc.filterRecordsBasedOn_AdmissionNum(studentName, admNumber, rollNumber);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_AdmissionNum Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AdmissionNum");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AdmissionNum");
		}
	}
	@Test(priority = 14)
	public void tcClearFilledDataForFilter_AdmissionNum() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_AdmissionNum Test===========");

			marksentry_marksCalc.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_AdmissionNum Test===========");
			getScreenShot("tcClearFilledDataForFilter_AdmissionNum");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_AdmissionNum");
		}
	}

	@Test(priority = 15, dataProvider = "filter_MarksEntryDetails_Data")
	public void tcFilterRecordsBasedOn_RollNumber(String studentName, String admNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_RollNumber Test===========");

			marksentry_marksCalc.filterRecordsBasedOn_RollNumber(studentName, admNumber, rollNumber);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_RollNumber Test===========");
			getScreenShot("tcFilterRecordsBasedOn_RollNumber");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_RollNumber");
		}
	}
	@Test(priority = 16)
	public void tcClearFilledDataForFilter_RollNumber() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_RollNumber Test===========");

			marksentry_marksCalc.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_RollNumber Test===========");
			getScreenShot("tcClearFilledDataForFilter_RollNumber");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_RollNumber");
		}
	}
	
	@Test(priority = 17, dataProvider = "MarksEntry_MarksObtain_Data")
	public void tcMarksEntryFor_StudentMarksObtain(String marksobtains, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_RollNumber Test===========");

			marksentry_marksCalc.marksEntryFor_StudentMarksObtain(marksobtains);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_RollNumber Test===========");
			getScreenShot("tcFilterRecordsBasedOn_RollNumber");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_RollNumber");
		}
	}
	@Test(priority = 18)
	public void tcMinimize_MarksEntryFormSection() {

		try {
			log.info("============= Strting tcMinimize_MarksEntryFormSection Test===========");

			marksentry_marksCalc.min_Max_MarksEntryFormSection();

			log.info("============= Finished tcMinimize_MarksEntryFormSection Test===========");
			getScreenShot("tcMinimize_MarksEntryFormSection");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MarksEntryFormSection");
		}
	}

	@Test(priority = 19)
	public void tcMinimize_StudentMarksDetailsSection() {

		try {
			log.info("============= Strting tcMinimize_StudentMarksDetailsSection Test===========");

			marksentry_marksCalc.min_Max_StudentMarksDetailsSection();
			log.info("============= Finished tcMinimize_StudentMarksDetailsSection Test===========");
			getScreenShot("tcMinimize_StudentMarksDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentMarksDetailsSection");
		}
	}

	@Test(priority = 20)
	public void tcMaximize_StudentMarksDetailsSection() {

		try {
			log.info("============= Strting tcMaximize_StudentMarksDetailsSection Test===========");

			marksentry_marksCalc.min_Max_StudentMarksDetailsSection();

			log.info("============= Finished tcMaximize_StudentMarksDetailsSection Test===========");
			getScreenShot("tcMaximize_StudentMarksDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentMarksDetailsSection");
		}
	}

	@Test(priority = 21)
	public void tcMaximize_MarksEntryFormSection() {

		try {
			log.info("============= Strting tcMaximize_MarksEntryFormSection Test===========");

			marksentry_marksCalc.min_Max_MarksEntryFormSection();

			log.info("============= Finished tcMaximize_MarksEntryFormSection Test===========");
			getScreenShot("tcMaximize_MarksEntryFormSection");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MarksEntryFormSection");
		}
	}

	@Test(priority = 22)
	public void tcClickOnCancelButton_ToClearFilledRecords() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledRecords Test===========");

			marksentry_marksCalc.clickOnCancelButton_ToClearFilledRecords();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledRecords Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledRecords");
		}
	}
	@Test(priority = 23, dataProvider = "Exam_MarksEntry_FormData")
	public void tcFill_MarksEntry_Form_AfterCancel(String academicYear, String class_Me, String section, String examType,
			String subject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_MarksEntry_Form_AfterCancel Test===========");

			marksentry_marksCalc.fill_MarksEntry_Form(academicYear, class_Me, section, examType, subject);
			log.info("============= Finished tcFill_MarksEntry_Form_AfterCancel Test===========");
			getScreenShot("tcFill_MarksEntry_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_MarksEntry_Form_AfterCancel");
		}
	}
	@Test(priority = 24)
	public void tcClickOnSearchButton_ToGetStudentMarksEntryList_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnSearchButton_ToGetStudentMarksEntryList_AfterCancel Test===========");

			marksentry_marksCalc.clickOnSearchButton_ToGetStudentMarksEntryList();
			log.info("============= Finished tcClickOnSearchButton_ToGetStudentMarksEntryList_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchButton_ToGetStudentMarksEntryList_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchButton_ToGetStudentMarksEntryList_AfterCancel");
		}
	}
	@Test(priority = 25, dataProvider = "filter_MarksEntryDetails_Data")
	public void tcFilterRecordsBasedOn_StudentName_ToEnterMarks(String studentName, String admNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_StudentName_ToEnterMarks Test===========");

			marksentry_marksCalc.filterRecordsBasedOn_StudentName(studentName, admNumber, rollNumber);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_StudentName_ToEnterMarks Test===========");
			getScreenShot("tcFilterRecordsBasedOn_StudentName_ToEnterMarks");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_StudentName_ToEnterMarks");
		}
	}

	@Test(priority = 26, dataProvider = "MarksEntry_MarksObtain_Data")
	public void tcMarksEntryFor_StudentMarksObtain_submit(String marksobtains, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMarksEntryFor_StudentMarksObtain_submit Test===========");

			marksentry_marksCalc.marksEntryFor_StudentMarksObtain(marksobtains);
			;

			log.info("============= Finished tcMarksEntryFor_StudentMarksObtain_submit Test===========");
			getScreenShot("tcMarksEntryFor_StudentMarksObtain_submit");
		} catch (Exception e) {
			getScreenShot("tcMarksEntryFor_StudentMarksObtain_submit");
		}
	}
	@Test(priority = 27)
	public void tcClickOnSaveButton_ToSubmitFilledRecords() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitFilledRecords Test===========");

			marksentry_marksCalc.clickOnSaveButton_ToSubmitFilledRecords();
			log.info("============= Finished tcClickOnSaveButton_ToSubmitFilledRecords Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitFilledRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitFilledRecords");
		}
	}
	@Test(priority = 28)
	public void tcClickOnCancelButton_ToCancelSubmission() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToCancelSubmission Test===========");

			marksentry_marksCalc.clickOnCancelButton_ToCancelSubmission();
			log.info("============= Finished tcClickOnCancelButton_ToCancelSubmission Test===========");
			getScreenShot("tcClickOnCancelButton_ToCancelSubmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToCancelSubmission");
		}
	}
	@Test(priority = 29)
	public void tcClickOnSaveButton_AfterCancelPopUpWindow() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterCancelPopUpWindow Test===========");

			marksentry_marksCalc.clickOnSaveButton_ToSubmitFilledRecords();
			log.info("============= Finished tcClickOnSaveButton_AfterCancelPopUpWindow Test===========");
			getScreenShot("tcClickOnSaveButton_AfterCancelPopUpWindow");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterCancelPopUpWindow");
		}
	}
	@Test(priority = 30)
	public void tcClickOnUpdateItButton_ToUpDateMarks() {

		try {
			log.info("============= Strting tcClickOnUpdateItButton_ToUpDateMarks Test===========");

			marksentry_marksCalc.clickOnUpdateItButton_ToUpDateMarks();
			log.info("============= Finished tcClickOnUpdateItButton_ToUpDateMarks Test===========");
			getScreenShot("tcClickOnUpdateItButton_ToUpDateMarks");
		} catch (Exception e) {
			getScreenShot("tcClickOnUpdateItButton_ToUpDateMarks");
		}
	}
	@Test(priority = 31)
	public void tcPopUpWindowMessage_SubmitSuccessfully() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully Test===========");

			marksentry_marksCalc.popUpWindowMessage_SubmitSuccessfully();
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully");
		}
	}
	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_saved() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_saved Test===========");

			marksentry_marksCalc.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_saved Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_saved");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_saved");
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
