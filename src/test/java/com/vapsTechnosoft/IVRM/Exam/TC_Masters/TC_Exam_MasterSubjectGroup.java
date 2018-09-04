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

import com.vapsTechnosoft.IVRM.Exam.Masters.Exam_MasterGrade;
import com.vapsTechnosoft.IVRM.Exam.Masters.Exam_MasterSubjectGroup;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Exam_MasterSubjectGroup extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Exam_MasterSubjectGroup.class.getName());

	Exam_MasterSubjectGroup mastersubjectgroup;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamMasterCategory_Form")
	public String[][] getTestData() {
		String[][] testRecordsCategory = getData("ExamMasters.xlsx", "ExamMasterCategory_FormData");
		return testRecordsCategory;
	}

	@DataProvider(name = "ExamCategoryClassMapping_FormData")
	public String[][] getTestDataCategoryClass() {
		String[][] testRecordsCategoryClassMap = getData("ExamMasters.xlsx", "CategoryClassMapping_FormDat");
		return testRecordsCategoryClassMap;
	}

	@DataProvider(name = "CategoryClassMapping_2ndData_ClassSection")
	public String[][] getTestSearchData() {
		String[][] testRecords2ndData = getData("ExamMasters.xlsx", "CategoryClassMapping_2ndData");
		return testRecords2ndData;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastersubjectgroup = new Exam_MasterSubjectGroup(driver);
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

			boolean status = mastersubjectgroup.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMasters_ExamMasterSubjectGroup() {

		try {
			log.info("============= Strting tcNavigateToExamMasters_ExamMasterSubjectGroup Test===========");

			mastersubjectgroup.navigateToExamMasters_ExamMasterSubjectGroup();

			log.info("============= Finished tcNavigateToExamMasters_ExamMasterSubjectGroup Test===========");
			getScreenShot("tcNavigateToExamMasters_ExamMasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMasters_ExamMasterSubjectGroup");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamMasterSubjectGroup_Page() {

		try {
			log.info("============= Strting tcVerifyExamMasterSubjectGroup_Page Test===========");

			boolean status = mastersubjectgroup.verifyExamMasterSubjectGroupPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamMasterSubjectGroup_Page Test===========");
			getScreenShot("tcVerifyExamMasterSubjectGroup_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamMasterSubjectGroup_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_MasterSubjectGroup() {

		try {
			log.info("============= Strting tcSubmitBlank_MasterSubjectGroup Test===========");

			mastersubjectgroup.submitBlank_MasterSubjectGroup();

			log.info("============= Finished tcSubmitBlank_MasterSubjectGroup Test===========");
			getScreenShot("tcSubmitBlank_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_MasterSubjectGroup");
		}
	}

	@Test(priority = 6, dataProvider = "WithoutElective")
	public void tcFill_Exam_MasterSubjectGroup_Form_WithoutElective(String groupName, String maxSubject,
			String maxApplSubject, String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterSubjectGroup_Form_WithoutElective Test===========");

			mastersubjectgroup.fill_Exam_MasterSubjectGroup_Form(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);

			log.info("============= Finished tcFill_Exam_MasterSubjectGroup_Form_WithoutElective Test===========");
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithoutElective");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithoutElective");
		}
	}

	@Test(priority = 7)
	public void tcSelectSubjectForGrouping_WithoutElectiveSubject() {

		try {
			log.info("============= Strting tcSelectSubjectForGrouping_WithoutElectiveSubject Test===========");

			mastersubjectgroup.selectSubjectForGrouping();

			log.info("============= Finished tcSelectSubjectForGrouping_WithoutElectiveSubject Test===========");
			getScreenShot("tcSelectSubjectForGrouping_WithoutElectiveSubject");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForGrouping_WithoutElectiveSubject");
		}
	}

	@Test(priority = 8, dataProvider = "Search")
	public void tcSearchWithSubjectName(String subjectName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithSubjectName Test===========");

			mastersubjectgroup.searchWithSubjectName(subjectName);

			log.info("============= Finished tcSearchWithSubjectName Test===========");
			getScreenShot("tcSearchWithSubjectName");
		} catch (Exception e) {
			getScreenShot("tcSearchWithSubjectName");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_MasterSubjectGroup() {

		try {
			log.info("============= Strting tcMinimize_MasterSubjectGroup Test===========");

			mastersubjectgroup.min_Max_MasterSubjectGroup();

			log.info("============= Finished tcMinimize_MasterSubjectGroup Test===========");
			getScreenShot("tcMinimize_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterSubjectGroup");
		}
	}

	@Test(priority = 10)
	public void tcMinimize_MasterGroupDetailsForm() {

		try {
			log.info("============= Strting tcMinimize_MasterGroupDetailsForm Test===========");

			mastersubjectgroup.min_Max_MasterGroupDetailsForm();
			log.info("============= Finished tcMinimize_MasterGroupDetailsForm Test===========");
			getScreenShot("tcMinimize_MasterGroupDetailsForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterGroupDetailsForm");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_MasterGroupDetailsForm_GridView() {

		try {
			log.info("============= Strting tcMaximize_MasterGroupDetailsForm_GridView Test===========");

			mastersubjectgroup.min_Max_MasterGroupDetailsForm();

			log.info("============= Finished tcMaximize_MasterGroupDetailsForm_GridView Test===========");
			getScreenShot("tcMaximize_MasterGroupDetailsForm_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterGroupDetailsForm_GridView");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_MasterSubjectGroupForm() {

		try {
			log.info("============= Strting tcMaximize_MasterSubjectGroupForm Test===========");

			mastersubjectgroup.min_Max_MasterSubjectGroup();

			log.info("============= Finished tcMaximize_MasterSubjectGroupForm Test===========");
			getScreenShot("tcMaximize_MasterSubjectGroupForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterSubjectGroupForm");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_ToClearMasterSubjectGroupFilledData() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearMasterSubjectGroupFilledData Test===========");

			mastersubjectgroup.clickOnCancelButton_ToClearMasterSubjectGroupFilledData();

			log.info(
					"============= Finished tcClickOnCancelButton_ToClearMasterSubjectGroupFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearMasterSubjectGroupFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearMasterSubjectGroupFilledData");
		}
	}

	@Test(priority = 13, dataProvider = "WithoutElective")
	public void tcFill_Exam_MasterSubjectGroup_Form_WithoutElective_AfetrCancel(String groupName, String maxSubject,
			String maxApplSubject, String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_Exam_MasterSubjectGroup_Form_WithoutElective_AfetrCancel Test===========");

			mastersubjectgroup.fill_Exam_MasterSubjectGroup_Form(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);

			log.info(
					"============= Finished tcFill_Exam_MasterSubjectGroup_Form_WithoutElective_AfetrCancel Test===========");
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithoutElective_AfetrCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithoutElective_AfetrCancel");
		}
	}

	@Test(priority = 14)
	public void tcSelectSubjectForGrouping_WithoutElectiveSubject_AfetrCancel() {

		try {
			log.info(
					"============= Strting tcSelectSubjectForGrouping_WithoutElectiveSubject_AfetrCancel Test===========");

			mastersubjectgroup.selectSubjectForGrouping();

			log.info(
					"============= Finished tcSelectSubjectForGrouping_WithoutElectiveSubject_AfetrCancel Test===========");
			getScreenShot("tcSelectSubjectForGrouping_WithoutElectiveSubject_AfetrCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForGrouping_WithoutElectiveSubject_AfetrCancel");
		}
	}

	@Test(priority = 15)
	public void tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithoutElective() {

		try {
			log.info(
					"============= Strting tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithoutElective Test===========");

			mastersubjectgroup.clickOnSaveButton_ToCreateMasterSubjectGroup();

			log.info(
					"============= Finished tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithoutElective Test===========");
			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithoutElective");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithoutElective");
		}
	}

	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn_ForConfirmation_WithoutElective_MasterSubjectGroup() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_ForConfirmation_WithoutElective_MasterSubjectGroup Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ForConfirmation_WithoutElective_MasterSubjectGroup Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_WithoutElective_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_WithoutElective_MasterSubjectGroup");
		}
	}

	@Test(priority = 17, dataProvider = "WithElective")
	public void tcFill_Exam_MasterSubjectGroup_Form_WithElective(String groupName, String maxSubject,
			String maxApplSubject, String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterSubjectGroup_Form_WithElective Test===========");

			mastersubjectgroup.fill_Exam_MasterSubjectGroup_Form(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);

			log.info("============= Finished tcFill_Exam_MasterSubjectGroup_Form_WithElective Test===========");
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithElective");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterSubjectGroup_Form_WithElective");
		}
	}

	@Test(priority = 18)
	public void tcSelectSubjectForGrouping_WithElectiveSubject() {

		try {
			log.info("============= Strting tcSelectSubjectForGrouping_WithElectiveSubject Test===========");

			mastersubjectgroup.selectSubjectForGrouping();

			log.info("============= Finished tcSelectSubjectForGrouping_WithElectiveSubject Test===========");
			getScreenShot("tcSelectSubjectForGrouping_WithElectiveSubject");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForGrouping_WithElectiveSubject");
		}
	}

	@Test(priority = 19)
	public void tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithElective() {

		try {
			log.info(
					"============= Strting tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithElective Test===========");

			mastersubjectgroup.clickOnSaveButton_ToCreateMasterSubjectGroup();

			log.info(
					"============= Finished tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithElective Test===========");
			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithElective");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_WithElective");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSuccessOkBtn_ForConfirmation_WithElective_MasterSubjectGroup() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_ForConfirmation_WithElective_MasterSubjectGroup Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ForConfirmation_WithElective_MasterSubjectGroup Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_WithElective_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_WithElective_MasterSubjectGroup");
		}
	}

	@Test(priority = 21)
	public void tcSortWithGroupNameInGridView() {

		try {
			log.info("============= Strting tcSortWithGroupNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithGroupNameInGridView");
			mastersubjectgroup.sortWithGroupNameInGridView();

			log.info("============= Finished tcSortWithGroupNameInGridView Test===========");
			getScreenShot("tcSortWithGroupNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithGroupNameInGridView");
		}
	}

	@Test(priority = 22)
	public void tcSortWithTotalSubjectsInGridView() {

		try {
			log.info("============= Strting tcSortWithTotalSubjectsInGridView Test===========");
			getScreenShot("_BeforeSorting_tcSortWithTotalSubjectsInGridView");
			mastersubjectgroup.sortWithTotalSubjectsInGridView();

			log.info("============= Finished tcSortWithTotalSubjectsInGridView Test===========");
			getScreenShot("tcSortWithTotalSubjectsInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithTotalSubjectsInGridView");
		}
	}

	@Test(priority = 23)
	public void tcSortWithMaxApplicableSubjectInGridView() {

		try {
			log.info("============= Strting tcSortWithMaxApplicableSubjectInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithMaxApplicableSubjectInGridView");
			mastersubjectgroup.sortWithMaxApplicableSubjectInGridView();

			log.info("============= Finished tcSortWithMaxApplicableSubjectInGridView Test===========");
			getScreenShot("tcSortWithMaxApplicableSubjectInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithMaxApplicableSubjectInGridView");
		}
	}

	@Test(priority = 24)
	public void tcSortWithMinApplicableSubjectInGridView() {

		try {
			log.info("============= Strting tcSortWithMinApplicableSubjectInGridView Test===========");
			getScreenShot("_BeforeSorting_tcSortWithMinApplicableSubjectInGridView");
			mastersubjectgroup.sortWithMinApplicableSubjectInGridView();

			log.info("============= Finished tcSortWithMinApplicableSubjectInGridView Test===========");
			getScreenShot("tcSortWithMinApplicableSubjectInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithMinApplicableSubjectInGridView");
		}
	}

	@Test(priority = 25)
	public void tcSortWithBestOfSubjectInGridView() {

		try {
			log.info("============= Strting tcSortWithBestOfSubjectInGridView Test===========");
			getScreenShot("_BeforeSorting_tcSortWithBestOfSubjectInGridView");
			mastersubjectgroup.sortWithBestOfSubjectInGridView();

			log.info("============= Finished tcSortWithBestOfSubjectInGridView Test===========");
			getScreenShot("tcSortWithBestOfSubjectInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithBestOfSubjectInGridView");
		}
	}

	@Test(priority = 26, dataProvider = "filter")
	public void tcFilterRecordsBasedOn_GroupName(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GroupName Test===========");

			mastersubjectgroup.filterRecordsBasedOn_GroupName(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);
			;

			log.info("============= Finished tcFilterRecordsBasedOn_GroupName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GroupName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GroupName");
		}
	}

	@Test(priority = 27)
	public void tcClearFilledDataForFilter_GroupName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_GroupName Test===========");

			mastersubjectgroup.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_GroupName Test===========");
			getScreenShot("tcClearFilledDataForFilter_GroupName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_GroupName");
		}
	}

	@Test(priority = 28, dataProvider = "filter")
	public void tcFilterRecordsBasedOn_TotalSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_TotalSubjects Test===========");

			mastersubjectgroup.filterRecordsBasedOn_TotalSubjects(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);

			log.info("============= Finished tcFilterRecordsBasedOn_TotalSubjects Test===========");
			getScreenShot("tcFilterRecordsBasedOn_TotalSubjects");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_TotalSubjects");
		}
	}

	@Test(priority = 29)
	public void tcClearFilledDataForFilter_TotalSubjects() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_TotalSubjects Test===========");

			mastersubjectgroup.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_TotalSubjects Test===========");
			getScreenShot("tcClearFilledDataForFilter_TotalSubjects");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_TotalSubjects");
		}
	}

	@Test(priority = 30, dataProvider = "filter")
	public void tcFilterRecordsBasedOn_MaxApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_MaxApplicableSubjects Test===========");

			mastersubjectgroup.filterRecordsBasedOn_MaxApplicableSubjects(groupName, maxSubject, maxApplSubject,
					minApplSubject, bestOfSubject);

			log.info("============= Finished tcFilterRecordsBasedOn_MaxApplicableSubjects Test===========");
			getScreenShot("tcFilterRecordsBasedOn_MaxApplicableSubjects");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_MaxApplicableSubjects");
		}
	}

	@Test(priority = 31)
	public void tcClearFilledDataForFilter_MaxApplicableSubjects() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_MaxApplicableSubjects Test===========");

			mastersubjectgroup.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_MaxApplicableSubjects Test===========");
			getScreenShot("tcClearFilledDataForFilter_MaxApplicableSubjects");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_MaxApplicableSubjects");
		}
	}

	@Test(priority = 32, dataProvider = "filter")
	public void tcFilterRecordsBasedOn_MinApplicableSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_MinApplicableSubjects Test===========");

			mastersubjectgroup.filterRecordsBasedOn_MinApplicableSubjects(groupName, maxSubject, maxApplSubject,
					minApplSubject, bestOfSubject);

			log.info("============= Finished tcFilterRecordsBasedOn_MinApplicableSubjects Test===========");
			getScreenShot("tcFilterRecordsBasedOn_MinApplicableSubjects");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_MinApplicableSubjects");
		}
	}

	@Test(priority = 33)
	public void tcClearFilledDataForFilter_MinApplicableSubjects() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_MinApplicableSubjects Test===========");

			mastersubjectgroup.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_MinApplicableSubjects Test===========");
			getScreenShot("tcClearFilledDataForFilter_MinApplicableSubjects");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_MinApplicableSubjects");
		}
	}

	@Test(priority = 34, dataProvider = "filter")
	public void tcFilterRecordsBasedOn_BestOfSubjects(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_BestOfSubjects Test===========");

			mastersubjectgroup.filterRecordsBasedOn_BestOfSubjects(groupName, maxSubject, maxApplSubject,
					minApplSubject, bestOfSubject);

			log.info("============= Finished tcFilterRecordsBasedOn_BestOfSubjects Test===========");
			getScreenShot("tcFilterRecordsBasedOn_BestOfSubjects");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_BestOfSubjects");
		}
	}

	@Test(priority = 35)
	public void tcClearFilledDataForFilter_BestOfSubjects() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_BestOfSubjects Test===========");

			mastersubjectgroup.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_BestOfSubjects Test===========");
			getScreenShot("tcClearFilledDataForFilter_BestOfSubjects");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_BestOfSubjects");
		}
	}

	@Test(priority = 36)
	public void tcClickOnViewIcon_ToSeeMasterSubjectGroup() {

		try {
			log.info("============= Strting tcClickOnViewIcon_ToSeeMasterSubjectGroup Test===========");

			mastersubjectgroup.clickOnViewIcon_ToSeeMasterSubjectGroup();
			log.info("============= Finished tcClickOnViewIcon_ToSeeMasterSubjectGroup Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeMasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeMasterSubjectGroup");
		}
	}

	@Test(priority = 37)
	public void tcCloseViewWindow_MasterSubjectGroup() {

		try {
			log.info("============= Strting tcCloseViewWindow_MasterSubjectGroup Test===========");

			mastersubjectgroup.closeViewWindow_MasterSubjectGroup();
			log.info("============= Finished tcCloseViewWindow_MasterSubjectGroup Test===========");
			getScreenShot("tcCloseViewWindow_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcCloseViewWindow_MasterSubjectGroup");
		}
	}

	@Test(priority = 38)
	public void tcClickOnEditIcon_ToUpdateMasterSubjectGroup() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateMasterSubjectGroup Test===========");

			mastersubjectgroup.clickOnEditIcon_ToUpdateMasterSubjectGroup();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateMasterSubjectGroup Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateMasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateMasterSubjectGroup");
		}
	}

	@Test(priority = 39)
	public void tcClickOnSaveButton_ToCreateMasterSubjectGroup_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToCreateMasterSubjectGroup_Edit Test===========");

			mastersubjectgroup.clickOnSaveButton_ToCreateMasterSubjectGroup();
			log.info("============= Finished tcClickOnSaveButton_ToCreateMasterSubjectGroup_Edit Test===========");

			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_Edit");

		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToCreateMasterSubjectGroup_Edit");
		}
	}

	@Test(priority = 40)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterSubjectGroup() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterSubjectGroup Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterSubjectGroup Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterSubjectGroup");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_MasterSubjectGroup");
		}
	}

	@Test(priority = 41, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFilterRecordsBasedOn_GroupName_FilterDeactivate(String groupName, String maxSubject, String maxApplSubject,
			String minApplSubject, String bestOfSubject, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GroupName_FilterDeactivate Test===========");

			mastersubjectgroup.filterRecordsBasedOn_GroupName(groupName, maxSubject, maxApplSubject, minApplSubject,
					bestOfSubject);

			log.info("============= Finished tcFilterRecordsBasedOn_GroupName_FilterDeactivate Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GroupName_FilterDeactivate");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GroupName_FilterDeactivate");
		}
	}

	@Test(priority = 42)
	public void tcDeactivateRecords_MasterSubjectGroupGrid() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterSubjectGroupGrid Test===========");

			mastersubjectgroup.deactivateRecords_MasterSubjectGroupGrid();

			log.info("============= Finished tcDeactivateRecords_MasterSubjectGroupGrid Test===========");
			getScreenShot("tcDeactivateRecords_MasterSubjectGroupGrid");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterSubjectGroupGrid");
		}
	}

	@Test(priority = 43)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			mastersubjectgroup.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 44)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}

	@Test(priority = 45)
	public void tcDeactivateRecords_MasterSubjectGroupGrid_AfterCancel() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterSubjectGroupGrid_AfterCancel Test===========");

			mastersubjectgroup.deactivateRecords_MasterSubjectGroupGrid();

			log.info("============= Finished tcDeactivateRecords_MasterSubjectGroupGrid_AfterCancel Test===========");
			getScreenShot("tcDeactivateRecords_MasterSubjectGroupGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterSubjectGroupGrid_AfterCancel");
		}
	}

	@Test(priority = 46)
	public void tcYesDeactivateMasterSubjectGroupRecord() {

		try {
			log.info("============= Strting tcYesDeactivateMasterSubjectGroupRecord Test===========");

			mastersubjectgroup.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesDeactivateMasterSubjectGroupRecord Test===========");
			getScreenShot("tcYesDeactivateMasterSubjectGroupRecord");
		} catch (Exception e) {
			getScreenShot("tcYesDeactivateMasterSubjectGroupRecord");
		}
	}

	@Test(priority = 47)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}

	@Test(priority = 48)
	public void tcActivateRecords_MasterSubjectGroupGrid() {

		try {
			log.info("============= Strting tcActivateRecords_MasterSubjectGroupGrid Test===========");

			mastersubjectgroup.activateRecords_MasterSubjectGroupGrid();

			log.info("============= Finished tcActivateRecords_MasterSubjectGroupGrid Test===========");
			getScreenShot("tcActivateRecords_MasterSubjectGroupGrid");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterSubjectGroupGrid");
		}
	}

	@Test(priority = 49)
	public void tcCancel_ActivatePopUp_viewWindow() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp_viewWindow Test===========");

			mastersubjectgroup.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_ActivatePopUp_viewWindow Test===========");
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		}
	}

	@Test(priority = 50)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 51)
	public void tcActivateRecords_MasterSubjectGroupGrid_AfterCancel() {

		try {
			log.info("============= Strting tcActivateRecords_MasterSubjectGroupGrid_AfterCancel Test===========");

			mastersubjectgroup.activateRecords_MasterSubjectGroupGrid();

			log.info("============= Finished tcActivateRecords_MasterSubjectGroupGrid_AfterCancel Test===========");
			getScreenShot("tcActivateRecords_MasterSubjectGroupGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterSubjectGroupGrid_AfterCancel");
		}
	}

	@Test(priority = 52)
	public void tcYesActivateMasterSubjectGroupRecord() {

		try {
			log.info("============= Strting tcYesActivateMasterSubjectGroupRecord Test===========");

			mastersubjectgroup.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesActivateMasterSubjectGroupRecord Test===========");
			getScreenShot("tcYesActivateMasterSubjectGroupRecord");
		} catch (Exception e) {
			getScreenShot("tcYesActivateMasterSubjectGroupRecord");
		}
	}

	@Test(priority = 53)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			mastersubjectgroup.clickOnSuccessOkBtn();

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
