/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_ExamMapping;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.Exam.ExamMapping.Exam_LoginPrivileges;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Exam_LoginPrivileges extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Exam_LoginPrivileges.class.getName());

	Exam_LoginPrivileges examloginprivilege;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamLoginPrivilege_ClassTeacher_Form")
	public String[][] getTestData() {
		String[][] testRecordsClassTeacher = getData("ExamMapping.xlsx", "ExamLoginPrivilege_ClassT");
		return testRecordsClassTeacher;
	}
	
	@DataProvider(name = "ExamLoginPrivilege_SubjectTeacher_Form")
	public String[][] getTestDataSubjectTeacher() {
		String[][] testRecordsSubjectTeacher = getData("ExamMapping.xlsx", "ExamLoginPrivilege_SubjectT");
		return testRecordsSubjectTeacher;
	}

	@DataProvider(name = "Filter_ExamLoginPrivilege_GridView")
	public String[][] getTestSearchData() {
		String[][] testRecordsFilter = getData("ExamMapping.xlsx", "ExamLoginPrivilege_GridView");
		return testRecordsFilter;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		examloginprivilege = new Exam_LoginPrivileges(driver);
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

			boolean status = examloginprivilege.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMapping_ExamLoginPrivilege() {

		try {
			log.info("============= Strting tcNavigateToExamMapping_ExamLoginPrivilege Test===========");

			examloginprivilege.navigateToExamMapping_ExamLoginPrivilege();

			log.info("============= Finished tcNavigateToExamMapping_ExamLoginPrivilege Test===========");
			getScreenShot("tcNavigateToExamMapping_ExamLoginPrivilege");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMapping_ExamLoginPrivilege");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamLoginPrivilegePage_Page() {

		try {
			log.info("============= Strting tcVerifyExamLoginPrivilegePage_Page Test===========");

			boolean status = examloginprivilege.verifyExamLoginPrivilegePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamLoginPrivilegePage_Page Test===========");
			getScreenShot("tcVerifyExamLoginPrivilegePage_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamLoginPrivilegePage_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_ExamLoginPrivilegeForm() {

		try {
			log.info("============= Strting tcSubmitBlank_ExamLoginPrivilegeForm Test===========");

			examloginprivilege.submitBlank_ExamLoginPrivilegeForm();

			log.info("============= Finished tcSubmitBlank_ExamLoginPrivilegeForm Test===========");
			getScreenShot("tcSubmitBlank_ExamLoginPrivilegeForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_ExamLoginPrivilegeForm");
		}
	}

	@Test(priority = 6, dataProvider = "ExamLoginPrivilege_ClassTeacher_Form")
	public void tcFill_ExamLoginPrivilege_Form_ForClassTeacher(String academicYear, String userName,String employeeName, String subject,
			String sub_Subject,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamLoginPrivilege_Form_ForClassTeacher Test===========");

			examloginprivilege.fill_ExamLoginPrivilege_Form_ForClassTeacher(academicYear, userName, employeeName, subject, sub_Subject);

			log.info("============= Finished tcFill_ExamLoginPrivilege_Form_ForClassTeacher Test===========");
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForClassTeacher");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForClassTeacher");
		}
	}
	@Test(priority = 7)
	public void tcAddToSubmit_ExamLoginPrivilegeForm() {

		try {
			log.info("============= Strting tcAddToSubmit_ExamLoginPrivilegeForm Test===========");

			examloginprivilege.addToSubmit_ExamLoginPrivilegeForm();

			log.info("============= Finished tcAddToSubmit_ExamLoginPrivilegeForm Test===========");
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm");
		} catch (Exception e) {
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_ExamLoginPrivilege_Form() {

		try {
			log.info("============= Strting tcMinimize_ExamLoginPrivilege_Form Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege();

			log.info("============= Finished tcMinimize_ExamLoginPrivilege_Form Test===========");
			getScreenShot("tcMinimize_ExamLoginPrivilege_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ExamLoginPrivilege_Form");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_ExamLoginPrivilege_DetailsSection() {

		try {
			log.info("============= Strting tcMinimize_ExamLoginPrivilege_DetailsSection Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege_Details();
			log.info("============= Finished tcMinimize_ExamLoginPrivilege_DetailsSection Test===========");
			getScreenShot("tcMinimize_ExamLoginPrivilege_DetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ExamLoginPrivilege_DetailsSection");
		}
	}
	@Test(priority = 10)
	public void tcMinimize_ExamLoginPrivilege_GridView() {

		try {
			log.info("============= Strting tcMinimize_ExamLoginPrivilege_GridView Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege_GridView();

			log.info("============= Finished tcMinimize_ExamLoginPrivilege_GridView Test===========");
			getScreenShot("tcMinimize_ExamLoginPrivilege_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ExamLoginPrivilege_GridView");
		}
	}


	@Test(priority = 11)
	public void tcMaximize_ExamLoginPrivilege_GridView() {

		try {
			log.info("============= Strting tcMaximize_ExamLoginPrivilege_GridView Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege_GridView();

			log.info("============= Finished tcMaximize_ExamLoginPrivilege_GridView Test===========");
			getScreenShot("tcMaximize_ExamLoginPrivilege_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ExamLoginPrivilege_GridView");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_ExamLoginPrivilege_DetailsSection() {

		try {
			log.info("============= Strting tcMaximize_ExamLoginPrivilege_DetailsSection Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege_Details();

			log.info("============= Finished tcMaximize_ExamLoginPrivilege_DetailsSection Test===========");
			getScreenShot("tcMaximize_ExamLoginPrivilege_DetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ExamLoginPrivilege_DetailsSection");
		}
	}
	@Test(priority = 13)
	public void tcMaximize_ExamLoginPrivilege_Form() {

		try {
			log.info("============= Strting tcMaximize_ExamLoginPrivilege_Form Test===========");

			examloginprivilege.min_Max_ExamLoginPrivilege();

			log.info("============= Finished tcMaximize_ExamLoginPrivilege_Form Test===========");
			getScreenShot("tcMaximize_ExamLoginPrivilege_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ExamLoginPrivilege_Form");
		}
	}

	@Test(priority = 14)
	public void tcClickOnCancelButton_ToClearFilledExamLoginPrivilegeForm() {

		try {
			log.info(
					"============= Strting tcClickOnCancelButton_ToClearFilledExamLoginPrivilegeForm Test===========");

			examloginprivilege.clickOnCancelButton_ToClearFilledExamLoginPrivilegeForm();

			log.info(
					"============= Finished tcClickOnCancelButton_ToClearFilledExamLoginPrivilegeForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledExamLoginPrivilegeForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledExamLoginPrivilegeForm");
		}
	}
	@Test(priority = 15, dataProvider = "ExamLoginPrivilege_ClassTeacher_Form")
	public void tcFill_ExamLoginPrivilege_Form_ForClassTeacher_AfterCancel(String academicYear, String userName,String employeeName, String subject,
			String sub_Subject,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamLoginPrivilege_Form_ForClassTeacher_AfterCancel Test===========");

			examloginprivilege.fill_ExamLoginPrivilege_Form_ForClassTeacher(academicYear, userName, employeeName, subject, sub_Subject);

			log.info("============= Finished tcFill_ExamLoginPrivilege_Form_ForClassTeacher_AfterCancel Test===========");
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForClassTeacher_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForClassTeacher_AfterCancel");
		}
	}
	@Test(priority = 16)
	public void tcAddToSubmit_ExamLoginPrivilegeForm_AfterCancel() {

		try {
			log.info("============= Strting tcAddToSubmit_ExamLoginPrivilegeForm_AfterCancel Test===========");

			examloginprivilege.addToSubmit_ExamLoginPrivilegeForm();

			log.info("============= Finished tcAddToSubmit_ExamLoginPrivilegeForm_AfterCancel Test===========");
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_AfterCancel");
		}
	}
	@Test(priority = 17, dataProvider = "ExamLoginPrivilege_ClassTeacher_Form")
	public void tcEditRecordsAndUpdateSubSubject_InDetailsSection(String academicYear, String userName,String employeeName, String subject,
			String sub_Subject,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditRecordsAndUpdateSubSubject_InDetailsSection Test===========");

			examloginprivilege.editRecordsAndUpdateSubSubject_InDetailsSection(academicYear, userName, employeeName, subject, sub_Subject);

			log.info("============= Finished tcEditRecordsAndUpdateSubSubject_InDetailsSection Test===========");
			getScreenShot("tcEditRecordsAndUpdateSubSubject_InDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcEditRecordsAndUpdateSubSubject_InDetailsSection");
		}
	}
	@Test(priority = 18)
	public void tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection() {

		try {
			log.info("============= Strting tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection Test===========");

			examloginprivilege.addToSubmit_ExamLoginPrivilegeForm();

			log.info("============= Finished tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection Test===========");
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection");
		}
	}
	@Test(priority = 19)
	public void tcDeleteRecordsFromDetailsSelection() {

		try {
			log.info("============= Strting tcDeleteRecordsFromDetailsSelection Test===========");

			examloginprivilege.deleteRecordsFromDetailsSelection();

			log.info("============= Finished tcDeleteRecordsFromDetailsSelection Test===========");
			getScreenShot("tcDeleteRecordsFromDetailsSelection");
		} catch (Exception e) {
			getScreenShot("tcDeleteRecordsFromDetailsSelection");
		}
	}
	@Test(priority = 20)
	public void tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_ClassTeacher() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_ClassTeacher Test===========");

			examloginprivilege.clickOnSaveButton_ToSubmitExamLoginPrivilegeForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_ClassTeacher Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_ClassTeacher");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_ClassTeacher");
		}
	}
	@Test(priority = 21)
	public void tcClickOnSuccessOkBtn_ForConfirmation_ClassTeacher() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_ClassTeacher Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_ClassTeacher Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_ClassTeacher");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_ClassTeacher");
		}
	}
	@Test(priority = 22, dataProvider = "ExamLoginPrivilege_SubjectTeacher_Form")
	public void tcFill_ExamLoginPrivilege_Form_ForSubjectTeacher(String academicYear, String userName,String employeeName, String subject,
			String sub_Subject,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamLoginPrivilege_Form_ForSubjectTeacher Test===========");

			examloginprivilege.fill_ExamLoginPrivilege_Form_ForSubjectTeacher(academicYear, userName, employeeName, subject, sub_Subject);

			log.info("============= Finished tcFill_ExamLoginPrivilege_Form_ForSubjectTeacher Test===========");
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForSubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamLoginPrivilege_Form_ForSubjectTeacher");
		}
	}
	@Test(priority = 23)
	public void tcAddToSubmit_ExamLoginPrivilegeForm_SubjectTeacher() {

		try {
			log.info("============= Strting tcAddToSubmit_ExamLoginPrivilegeForm_SubjectTeacher Test===========");

			examloginprivilege.addToSubmit_ExamLoginPrivilegeForm();

			log.info("============= Finished tcAddToSubmit_ExamLoginPrivilegeForm_SubjectTeacher Test===========");
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_SubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_SubjectTeacher");
		}
	}
	@Test(priority = 24, dataProvider = "ExamLoginPrivilege_SubjectTeacher_Form")
	public void tcEditRecordsAndUpdateSubSubject_InDetailsSection_SubjectTeacher(String academicYear, String userName,String employeeName, String subject,
			String sub_Subject,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditRecordsAndUpdateSubSubject_InDetailsSection_SubjectTeacher Test===========");

			examloginprivilege.editRecordsAndUpdateSubSubject_InDetailsSection(academicYear, userName, employeeName, subject, sub_Subject);

			log.info("============= Finished tcEditRecordsAndUpdateSubSubject_InDetailsSection_SubjectTeacher Test===========");
			getScreenShot("tcEditRecordsAndUpdateSubSubject_InDetailsSection_SubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcEditRecordsAndUpdateSubSubject_InDetailsSection_SubjectTeacher");
		}
	}
	@Test(priority = 25)
	public void tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection_SubjectTeacher() {

		try {
			log.info("============= Strting tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection_SubjectTeacher Test===========");

			examloginprivilege.addToSubmit_ExamLoginPrivilegeForm();

			log.info("============= Finished tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection_SubjectTeacher Test===========");
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection_SubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcAddToSubmit_ExamLoginPrivilegeForm_EditDetailsSection_SubjectTeacher");
		}
	}
	@Test(priority = 26)
	public void tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_SubjectTeacher() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_SubjectTeacher Test===========");

			examloginprivilege.clickOnSaveButton_ToSubmitExamLoginPrivilegeForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_SubjectTeacher Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_SubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_SubjectTeacher");
		}
	}
	@Test(priority = 27)
	public void tcClickOnSuccessOkBtn_ForConfirmation_SubjectTeacher() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_SubjectTeacher Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_SubjectTeacher Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_SubjectTeacher");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_SubjectTeacher");
		}
	}
	
	@Test(priority = 28)
	public void tcSortWithAcademicYearInGridView() {

		try {
			log.info("============= Strting tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithAcademicYearInGridView");
			examloginprivilege.sortWithAcademicYearInGridView();

			log.info("============= Finished tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("tcSortWithAcademicYearInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithAcademicYearInGridView");
		}
	}

	@Test(priority = 29)
	public void tcSortWithEmployeeNameInGridView() {

		try {
			log.info("============= Strting tcSortWithEmployeeNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithEmployeeNameInGridView");
			examloginprivilege.sortWithEmployeeNameInGridView();

			log.info("============= Finished tcSortWithEmployeeNameInGridView Test===========");
			getScreenShot("tcSortWithEmployeeNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithEmployeeNameInGridView");
		}
	}

	@Test(priority = 30)
	public void tcSortWithClassNameInGridView() {

		try {
			log.info("============= Strting tcSortWithClassNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithClassNameInGridView");
			examloginprivilege.sortWithClassNameInGridView();

			log.info("============= Finished tcSortWithClassNameInGridView Test===========");
			getScreenShot("tcSortWithClassNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithClassNameInGridView");
		}
	}

	@Test(priority = 31)
	public void tcSortWithSectionNameInGridView() {

		try {
			log.info("============= Strting tcSortWithSectionNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithSectionNameInGridView");
			examloginprivilege.sortWithSectionNameInGridView();

			log.info("============= Finished tcSortWithSectionNameInGridView Test===========");
			getScreenShot("tcSortWithSectionNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithSectionNameInGridView");
		}
	}

	@Test(priority = 32, dataProvider = "Filter_ExamLoginPrivilege_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear(String academicYear, String employeeName, String className,
			String sectionName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear Test===========");

			examloginprivilege.filterRecordsBasedOn_AcademicYear(academicYear, employeeName, className, sectionName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		}
	}

	@Test(priority = 33)
	public void tcClearFilledDataForFilter_AcademicYear() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_AcademicYear Test===========");

			examloginprivilege.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_AcademicYear Test===========");
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		}
	}

	@Test(priority = 34, dataProvider = "Filter_ExamLoginPrivilege_GridView")
	public void tcFilterRecordsBasedOn_EmployeeName(String academicYear, String employeeName, String className,
			String sectionName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_EmployeeName Test===========");

			examloginprivilege.filterRecordsBasedOn_EmployeeName(academicYear, employeeName, className, sectionName);

			log.info("============= Finished tcFilterRecordsBasedOn_EmployeeName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_EmployeeName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_EmployeeName");
		}
	}

	@Test(priority = 35)
	public void tcClearFilledDataForFilter_EmployeeName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_EmployeeName Test===========");

			examloginprivilege.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_EmployeeName Test===========");
			getScreenShot("tcClearFilledDataForFilter_EmployeeName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_EmployeeName");
		}
	}

	@Test(priority = 36, dataProvider = "Filter_ExamLoginPrivilege_GridView")
	public void tcFilterRecordsBasedOn_ClassName(String academicYear, String employeeName, String className,
			String sectionName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_ClassName Test===========");

			examloginprivilege.filterRecordsBasedOn_ClassName(academicYear, employeeName, className, sectionName);

			log.info("============= Finished tcFilterRecordsBasedOn_ClassName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_ClassName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_ClassName");
		}
	}

	@Test(priority = 37)
	public void tcClearFilledDataForFilter_ClassName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_ClassName Test===========");

			examloginprivilege.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_ClassName Test===========");
			getScreenShot("tcClearFilledDataForFilter_ClassName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_ClassName");
		}
	}

	@Test(priority = 38, dataProvider = "Filter_ExamLoginPrivilege_GridView")
	public void tcFilterRecordsBasedOn_SectionName(String academicYear, String employeeName, String className,
			String sectionName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_SectionName Test===========");

			examloginprivilege.filterRecordsBasedOn_SectionName(academicYear, employeeName, className, sectionName);

			log.info("============= Finished tcFilterRecordsBasedOn_SectionName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_SectionName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_SectionName");
		}
	}

	@Test(priority = 39)
	public void tcClearFilledDataForFilter_SectionName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_SectionName Test===========");

			examloginprivilege.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_SectionName Test===========");
			getScreenShot("tcClearFilledDataForFilter_SectionName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_SectionName");
		}
	}
	/**
	 * View, Edit and activate/deactivate
	 * 
	 */
	@Test(priority = 40)
	public void tcClickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation() {

		try {
			log.info("============= Strting tcClickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation Test===========");

			examloginprivilege.clickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation();
			log.info("============= Finished tcClickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeExamLoginPrivilegeDetailsAndActivationOrDeactivation");
		}
	}



	@Test(priority = 41)
	public void tcDeactivateRecords_ViewWindow() {

		try {
			log.info("============= Strting tcDeactivateRecords_ViewWindow Test===========");

			examloginprivilege.deactivateRecords_ViewWindow();

			log.info("============= Finished tcDeactivateRecords_ViewWindow Test===========");
			getScreenShot("tcDeactivateRecords_ViewWindow");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_ViewWindow");
		}
	}

	@Test(priority = 42)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			examloginprivilege.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 43)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}


	@Test(priority = 44)
	public void tcDeactivateRecords_ViewWindow_AfterCancel() {

		try {
			log.info(
					"============= Strting tcDeactivateRecords_ViewWindow_AfterCancel Test===========");

			examloginprivilege.deactivateRecords_ViewWindow();

			log.info(
					"============= Finished tcDeactivateRecords_ViewWindow_AfterCancel Test===========");
			getScreenShot("tcDeactivateRecords_ViewWindow_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_ViewWindow_AfterCancel");
		}
	}

	@Test(priority = 45)
	public void tcYesDeactivateExamLoginPrivilegeRecord() {

		try {
			log.info("============= Strting tcYesDeactivateExamLoginPrivilegeRecord Test===========");

			examloginprivilege.yesDeactivateExamLoginPrivilegeRecord();

			log.info("============= Finished tcYesDeactivateExamLoginPrivilegeRecord Test===========");
			getScreenShot("tcYesDeactivateExamLoginPrivilegeRecord");
		} catch (Exception e) {
			getScreenShot("tcYesDeactivateExamLoginPrivilegeRecord");
		}
	}

	@Test(priority = 46)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}

	@Test(priority = 47)
	public void tcActivateRecords_ViewWindow() {

		try {
			log.info("============= Strting tcActivateRecords_ViewWindow Test===========");

			examloginprivilege.activateRecords_ViewWindow();

			log.info("============= Finished tcActivateRecords_ViewWindow Test===========");
			getScreenShot("tcActivateRecords_ViewWindow");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_ViewWindow");
		}
	}

	@Test(priority = 48)
	public void tcCancel_ActivatePopUp() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp Test===========");

			examloginprivilege.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_ActivatePopUp Test===========");
			getScreenShot("tcCancel_ActivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp");
		}
	}

	@Test(priority = 49)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 50)
	public void tcActivateRecords_ViewWindow_AfterCancel() {

		try {
			log.info(
					"============= Strting tcActivateRecords_ViewWindow_AfterCancel Test===========");

			examloginprivilege.activateRecords_ViewWindow();

			log.info(
					"============= Finished tcActivateRecords_ViewWindow_AfterCancel Test===========");
			getScreenShot("tcActivateRecords_ViewWindow_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_ViewWindow_AfterCancel");
		}
	}

	@Test(priority = 51)
	public void tcYesActivateExamLoginPrivilegeRecord() {

		try {
			log.info("============= Strting tcYesActivateExamLoginPrivilegeRecord Test===========");

			examloginprivilege.yesActivateExamLoginPrivilegeRecord();

			log.info("============= Finished tcYesActivateExamLoginPrivilegeRecord Test===========");
			getScreenShot("tcYesActivateExamLoginPrivilegeRecord");
		} catch (Exception e) {
			getScreenShot("tcYesActivateExamLoginPrivilegeRecord");
		}
	}

	@Test(priority = 52)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		}
	}
	@Test(priority = 53)
	public void tcCloseViewWindow_LoginPrvilege() {

		try {
			log.info("============= Strting tcCloseViewWindow_LoginPrvilege Test===========");

			examloginprivilege.closeViewWindow_LoginPrvilege();
			log.info("============= Finished tcCloseViewWindow_LoginPrvilege Test===========");
			getScreenShot("tcCloseViewWindow_LoginPrvilege");
		} catch (Exception e) {
			getScreenShot("tcCloseViewWindow_LoginPrvilege");
		}
	}
	
	@Test(priority = 54)
	public void tcClickOnEditIcon_ToUpdateExamLoginPrivilege() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateExamLoginPrivilege Test===========");

			examloginprivilege.clickOnEditIcon_ToUpdateExamLoginPrivilege();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateExamLoginPrivilege Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateExamLoginPrivilege");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateExamLoginPrivilege");
		}
	}

	@Test(priority = 55)
	public void tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_Edit Test===========");

			examloginprivilege.clickOnSaveButton_ToSubmitExamLoginPrivilegeForm();
			log.info("============= Finished tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_Edit Test===========");

			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_Edit");

		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitExamLoginPrivilegeForm_Edit");
		}
	}

	@Test(priority = 56)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");

			examloginprivilege.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
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
