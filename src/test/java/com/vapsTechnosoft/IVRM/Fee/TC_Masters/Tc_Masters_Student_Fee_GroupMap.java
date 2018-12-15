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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Student_Fee_GroupMap;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Student_Fee_GroupMap extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Student_Fee_GroupMap.class.getName());

	Masters_Student_Fee_GroupMap studentFeegroupMap;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "StudentFeeGroupData_WithoutClassWise")
	public String[][] getTestDataStuFeeMapWithoutClassWise() {
		String[][] testRecordsWithoutClassWise = getData("FeeModueData.xlsx", "StudentFeeGrMap_wOutCLassWise");
		return testRecordsWithoutClassWise;
	}

	@DataProvider(name = "Search_StudentFeeGroupData_WithoutClassWise_All")
	public String[][] getTestDataStuFeeMapWithoutClassWise_Search_All() {
		String[][] testRecordsWithoutClassWise_Search_All = getData("FeeModueData.xlsx", "SFGMap_wOutCLassWiseAll");
		return testRecordsWithoutClassWise_Search_All;
	}
	@DataProvider(name = "Search_StudentFeeGroupData_WithoutClassWise_RegStudent")
	public String[][] getTestDataStuFeeMapWithoutClassWise_Search_RegStudent() {
		String[][] testRecordsWithoutClassWise_Search_RegStudent = getData("FeeModueData.xlsx", "SFGMap_RegStudent_woutClassWise");
		return testRecordsWithoutClassWise_Search_RegStudent;
	}
	@DataProvider(name = "Search_StudentFeeGroupData_WithoutClassWise_NewStudent")
	public String[][] getTestDataStuFeeMapWithoutClassWise_Search_NewStudent() {
		String[][] testRecordsWithoutClassWise_Search_NewStudent = getData("FeeModueData.xlsx", "SFGMap_NewStudent_woutClassWise");
		return testRecordsWithoutClassWise_Search_NewStudent;
	}
	@DataProvider(name = "StudentFeeGroupData_WithClassWise")
	public String[][] getTestDataStuFeeMapWithClassWise() {
		String[][] testRecordsWithClassWise = getData("FeeModueData.xlsx", "StudentFeeGrMap_withCLassWise");
		return testRecordsWithClassWise;
	}

	@DataProvider(name = "Search_StudentFeeGroupData_WithClassWise_All")
	public String[][] getTestDataStuFeeMapWithClassWise_Search() {
		String[][] testRecordsWithClassWise_Search = getData("FeeModueData.xlsx", "SFGMap_withCLassWise_All");
		return testRecordsWithClassWise_Search;
	}
	@DataProvider(name = "Search_StudentFeeGroupData_WithClassWise_RegStudent")
	public String[][] getTestDataStuFeeMapWithClassWise_Search_RegStudent() {
		String[][] testRecordsWithClassWise_Search_RegStudent = getData("FeeModueData.xlsx", "SFGMap_RegStudent_withClassWise");
		return testRecordsWithClassWise_Search_RegStudent;
	}
	@DataProvider(name = "Search_StudentFeeGroupData_WithClassWise_NewStudent")
	public String[][] getTestDataStuFeeMapWithClassWise_Search_NewStudent() {
		String[][] testRecordsWithClassWise_Search_NewStudent = getData("FeeModueData.xlsx", "SFGMap_NewStudent_withClassWise");
		return testRecordsWithClassWise_Search_NewStudent;
	}
	@DataProvider(name = "StudentFeeGroupData_FeeClassCategory")
	public String[][] getTestDataStuFeeMapFeeClassCategory() {
		String[][] testRecordsFeeClassCategory = getData("FeeModueData.xlsx", "StudentFeeGrMap_FCCategory");
		return testRecordsFeeClassCategory;
	}

	@DataProvider(name = "Search_StudentFeeGroupData_FeeClassCategory")
	public String[][] getTestDataStuFeeMapFeeClassCategory_Search() {
		String[][] testRecordsFeeClassCategory_Search = getData("FeeModueData.xlsx", "Search_SFGMap_FCCategory");
		return testRecordsFeeClassCategory_Search;
	}

	@DataProvider(name = "StudentFeeGroupData_AdmissionCategory")
	public String[][] getTestDataStuFeeMapAdmissionCategory() {
		String[][] testRecordsAdmissionCategory = getData("FeeModueData.xlsx", "StudentFeeGrMap_AdmCategory");
		return testRecordsAdmissionCategory;
	}

	@DataProvider(name = "Search_StudentFeeGroupData_AdmissionCategory")
	public String[][] getTestDataStuFeeMapAdmissionCategory_Search() {
		String[][] testRecordsAdmissionCategory_Search = getData("FeeModueData.xlsx", "Search_SFGMap_AdmCategory");
		return testRecordsAdmissionCategory_Search;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentFeegroupMap = new Masters_Student_Fee_GroupMap(driver);
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

			studentFeegroupMap.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToMasters_StudentFeegroupMap() {

		try {
			log.info("============= Strting tcNavigateToMasters_StudentFeegroupMap Test===========");

			studentFeegroupMap.navigateToMasters_StudentFeegroupMap();

			log.info("============= Finished tcNavigateToMasters_StudentFeegroupMap Test===========");
			getScreenShot("tcNavigateToMasters_StudentFeegroupMap");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_StudentFeegroupMap");
		}
	}

	@Test(priority = 4)
	public void tcVerifyStudentFeeGroupMapPage() {

		try {
			log.info("============= Strting tcVerifyStudentFeeGroupMapPage Test===========");

			boolean status = studentFeegroupMap.verifyStudentFeeGroupMapPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyStudentFeeGroupMapPage Test===========");
			getScreenShot("tcVerifyStudentFeeGroupMapPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentFeeGroupMapPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			studentFeegroupMap.clickOnSaveButton_ToSubmitBlankForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	/*
	 * Perform action for all radio button and cancel
	 */
	@Test(priority = 6, dataProvider = "StudentFeeGroupData_WithoutClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnAll(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnAll Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnAll(academicYr);

			log.info("============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnAll Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll");
		}
	}

	@Test(priority = 7, dataProvider = "Search_StudentFeeGroupData_WithoutClassWise_All")
	public void tcMapStudentWithGroup_rdBtnAll(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnAll Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnAll Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnAll");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_StudentFeeGroupMapping() {

		try {
			log.info("============= Strting tcMinimize_StudentFeeGroupMapping Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentFeeGroupMapping();

			log.info("============= Finished tcMinimize_StudentFeeGroupMapping Test===========");
			getScreenShot("tcMinimize_StudentFeeGroupMapping");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentFeeGroupMapping");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_StudentAndGroupList() {

		try {
			log.info("============= Strting tcMinimize_StudentAndGroupList Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentAndGroupList();

			log.info("============= Finished tcMinimize_StudentAndGroupList Test===========");
			getScreenShot("tcMinimize_StudentAndGroupList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentAndGroupList");
		}
	}

	@Test(priority = 10)
	public void tcSortByStudentName() {

		try {
			log.info("============= Strting tcSortByStudentName Test===========");
			getScreenShot("BeforeSort_tcSortByStudentName");

			studentFeegroupMap.sortByStudentName();

			log.info("============= Finished tcSortByStudentName Test===========");
			getScreenShot("tcSortByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSortByStudentName");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_StudentFeeGroupMappingList() {

		try {
			log.info("============= Strting tcMinimize_StudentFeeGroupMappingList Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentFeeGroupMappingList();

			log.info("============= Finished tcMinimize_StudentFeeGroupMappingList Test===========");
			getScreenShot("tcMinimize_StudentFeeGroupMappingList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentFeeGroupMappingList");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_StudentFeeGroupMappingList() {

		try {
			log.info("============= Strting tcMaximize_StudentFeeGroupMappingList Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentFeeGroupMappingList();

			log.info("============= Finished tcMaximize_StudentFeeGroupMappingList Test===========");
			getScreenShot("tcMaximize_StudentFeeGroupMappingList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentFeeGroupMappingList");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_StudentAndGroupList() {

		try {
			log.info("============= Strting tcMaximize_StudentAndGroupList Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentAndGroupList();

			log.info("============= Finished tcMaximize_StudentAndGroupList Test===========");
			getScreenShot("tcMaximize_StudentAndGroupList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentAndGroupList");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_StudentFeeGroupMapping() {

		try {
			log.info("============= Strting tcMaximize_StudentFeeGroupMapping Test===========");

			studentFeegroupMap.minimizeAndMaximize_StudentFeeGroupMapping();

			log.info("============= Finished tcMaximize_StudentFeeGroupMapping Test===========");
			getScreenShot("tcMaximize_StudentFeeGroupMapping");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentFeeGroupMapping");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancelButton_toClearFilledData() {

		try {
			log.info("============= Strting tcClickOnCancelButton_toClearFilledData Test===========");

			studentFeegroupMap.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_toClearFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_toClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_toClearFilledData");
		}
	}
	/*
	 * Perform action for all radio button and Save
	 */

	@Test(priority = 16, dataProvider = "StudentFeeGroupData_WithoutClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnAll_AfterCancel(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnAll_AfterCancel Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnAll(academicYr);

			log.info("============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnAll_AfterCancel Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll_AfterCancel");
		}
	}

	@Test(priority = 17, dataProvider = "Search_StudentFeeGroupData_WithoutClassWise_All")
	public void tcMapStudentWithGroup_rdBtnAll_AfterCancel(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnAll_AfterCancel Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnAll_AfterCancel Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnAll_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnAll_AfterCancel");
		}
	}

	@Test(priority = 18)
	public void tcClickOnSaveButton_rdBtnAll() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnAll Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnAll Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnAll");
		}
	}
	@Test(priority = 19)
	public void tcVerifySuccessfulPopUp_rdBtnAll() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnAll Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnAll Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAll");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSuccessOkBtn_rdBtnAll() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnAll Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnAll Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAll");
		}
	}
	/*
	 * Perform action for all radio button and class wise check box
	 */

	@Test(priority = 21, dataProvider = "StudentFeeGroupData_WithClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise(String academicYr, String classSelection,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise(academicYr, classSelection, section);

			log.info("============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAll_ClassWise");
		}
	}

	@Test(priority = 22, dataProvider = "Search_StudentFeeGroupData_WithClassWise_All")
	public void tcMapStudentWithGroup_rdBtnAll_ClassWise(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnAll_ClassWise Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, bystudentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnAll_ClassWise Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnAll_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnAll_ClassWise");
		}
	}

	@Test(priority = 23)
	public void tcClickOnSaveButton_rdBtnAll_ClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnAll_ClassWise Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnAll_ClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnAll_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnAll_ClassWise");
		}
	}
	@Test(priority = 24)
	public void tcVerifySuccessfulPopUp_rdBtnAll_ClassWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnAll_ClassWise Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnAll_ClassWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAll_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAll_ClassWise");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSuccessOkBtn_rdBtnAll_ClassWise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnAll_ClassWise Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnAll_ClassWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAll_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAll_ClassWise");
		}
	}
	/*
	 * Perform action for Fee Class Category radio button
	 */

	@Test(priority = 26, dataProvider = "StudentFeeGroupData_FeeClassCategory")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory(String academicYr, String feeclassCategory,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory(academicYr, feeclassCategory);

			log.info("============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnFeeClassCategory");
		}
	}

	@Test(priority = 27, dataProvider = "Search_StudentFeeGroupData_FeeClassCategory")
	public void tcMapStudentWithGroup_rdBtnFeeClassCategory(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnFeeClassCategory Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnFeeClassCategory Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnFeeClassCategory");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnFeeClassCategory");
		}
	}

	@Test(priority = 28)
	public void tcClickOnSaveButton_rdBtnFeeClassCategory() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnFeeClassCategory Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnFeeClassCategory Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnFeeClassCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnFeeClassCategory");
		}
	}
	@Test(priority = 29)
	public void tcVerifySuccessfulPopUp_rdBtnFeeClassCategory() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnFeeClassCategory Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnFeeClassCategory Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnFeeClassCategory");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnFeeClassCategory");
		}
	}
	@Test(priority = 30)
	public void tcClickOnSuccessOkBtn_rdBtnFeeClassCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnFeeClassCategory Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnFeeClassCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnFeeClassCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnFeeClassCategory");
		}
	}
	/*
	 * Perform action for Fee Admission Category radio button
	 */

	@Test(priority = 31, dataProvider = "StudentFeeGroupData_AdmissionCategory")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory(String academicYr,
			String admissionclassCategory, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory(academicYr,
					admissionclassCategory);

			log.info("============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnAdmissionCategory");
		}
	}

	@Test(priority = 32, dataProvider = "Search_StudentFeeGroupData_AdmissionCategory")
	public void tcMapStudentWithGroup_rdBtnAdmissionCategory(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnAdmissionCategory Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnAdmissionCategory Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnAdmissionCategory");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnAdmissionCategory");
		}
	}

	@Test(priority = 33)
	public void tcClickOnSaveButton_rdBtnAdmissionCategory() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnAdmissionCategory Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnAdmissionCategory Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnAdmissionCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnAdmissionCategory");
		}
	}
	@Test(priority = 34)
	public void tcVerifySuccessfulPopUp_rdBtnAdmissionCategory() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnAdmissionCategory Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnAdmissionCategory Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAdmissionCategory");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnAdmissionCategory");
		}
	}
	@Test(priority = 35)
	public void tcClickOnSuccessOkBtn_rdBtnAdmissionCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnAdmissionCategory Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnAdmissionCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAdmissionCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnAdmissionCategory");
		}
	}
	/*
	 * Perform action for Regular Student without class wise
	 */

	@Test(priority = 36, dataProvider = "StudentFeeGroupData_WithoutClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise(String academicYr,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise(academicYr);

			log.info(
					"============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithoutClassWise");
		}
	}

	@Test(priority = 37, dataProvider = "Search_StudentFeeGroupData_WithoutClassWise_RegStudent")
	public void tcMapStudentWithGroup_rdBtnRegularStudent_WithoutClassWise(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnRegularStudent_WithoutClassWise Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info(
					"============= Finished tcMapStudentWithGroup_rdBtnRegularStudent_WithoutClassWise Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnRegularStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnRegularStudent_WithoutClassWise");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSaveButton_rdBtnRegularStudent_WithoutClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnRegularStudent_WithoutClassWise Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnRegularStudent_WithoutClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnRegularStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnRegularStudent_WithoutClassWise");
		}
	}
	@Test(priority = 39)
	public void tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithoutClassWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithoutClassWise Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithoutClassWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithoutClassWise");
		}
	}

	@Test(priority = 40)
	public void tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithoutClassWise() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithoutClassWise Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithoutClassWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithoutClassWise");
		}
	}
	/*
	 * Perform action for Regular Student with class wise
	 */

	@Test(priority = 41, dataProvider = "StudentFeeGroupData_WithClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise(String academicYr,
			String classSelection, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise(academicYr,
					classSelection, section);

			log.info(
					"============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnRegularStudent_WithClassWise");
		}
	}

	@Test(priority = 42, dataProvider = "Search_StudentFeeGroupData_WithClassWise_RegStudent")
	public void tcMapStudentWithGroup_rdBtnRegularStudent_WithClassWise(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnRegularStudent_WithClassWise Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, bystudentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnRegularStudent_WithClassWise Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnRegularStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnRegularStudent_WithClassWise");
		}
	}

	@Test(priority = 43)
	public void tcClickOnSaveButton_rdBtnRegularStudent_WithClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnRegularStudent_WithClassWise Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnRegularStudent_WithClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnRegularStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnRegularStudent_WithClassWise");
		}
	}
	@Test(priority = 44)
	public void tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithClassWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithClassWise Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithClassWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnRegularStudent_WithClassWise");
		}
	}
	@Test(priority = 45)
	public void tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithClassWise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithClassWise Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithClassWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnRegularStudent_WithClassWise");
		}
	}
	/*
	 * Perform action for New Student without class wise
	 */

	@Test(priority = 46, dataProvider = "StudentFeeGroupData_WithoutClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise(String academicYr, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise(academicYr);

			log.info(
					"============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithoutClassWise");
		}
	}

	@Test(priority = 47, dataProvider = "Search_StudentFeeGroupData_WithoutClassWise_NewStudent")
	public void tcMapStudentWithGroup_rdBtnNewStudent_WithoutClassWise(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnNewStudent_WithoutClassWise Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnNewStudent_WithoutClassWise Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnNewStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnNewStudent_WithoutClassWise");
		}
	}

	@Test(priority = 48)
	public void tcClickOnSaveButton_rdBtnNewStudent_WithoutClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnNewStudent_WithoutClassWise Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnNewStudent_WithoutClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnNewStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnNewStudent_WithoutClassWise");
		}
	}
	@Test(priority = 49)
	public void tcVerifySuccessfulPopUp_rdBtnNewStudent_WithoutClassWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnNewStudent_WithoutClassWise Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnNewStudent_WithoutClassWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnNewStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnNewStudent_WithoutClassWise");
		}
	}
	@Test(priority = 50)
	public void tcClickOnSuccessOkBtn_rdBtnNewStudent_WithoutClassWise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnNewStudent_WithoutClassWise Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnNewStudent_WithoutClassWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnNewStudent_WithoutClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnNewStudent_WithoutClassWise");
		}
	}
	/*
	 * Perform action for New Student with class wise
	 */

	@Test(priority = 51, dataProvider = "StudentFeeGroupData_WithClassWise")
	public void tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise(String academicYr,
			String classSelection, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise Test===========");

			studentFeegroupMap.fill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise(academicYr, classSelection,
					section);

			log.info(
					"============= Finished tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise Test===========");
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentFeeGroupMappingForm_rdBtnNewStudent_WithClassWise");
		}
	}

	@Test(priority = 52, dataProvider = "Search_StudentFeeGroupData_WithClassWise_NewStudent")
	public void tcMapStudentWithGroup_rdBtnNewStudent_WithClassWise(String bystudentName, String studentName,String admNumber,String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMapStudentWithGroup_rdBtnNewStudent_WithClassWise Test===========");

			studentFeegroupMap.mapStudentWithGroup(bystudentName, studentName, admNumber, groupName);

			log.info("============= Finished tcMapStudentWithGroup_rdBtnNewStudent_WithClassWise Test===========");
			getScreenShot("tcMapStudentWithGroup_rdBtnNewStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcMapStudentWithGroup_rdBtnNewStudent_WithClassWise");
		}
	}

	@Test(priority = 53)
	public void tcClickOnSaveButton_rdBtnNewStudent_WithClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_rdBtnNewStudent_WithClassWise Test===========");

			studentFeegroupMap.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_rdBtnNewStudent_WithClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_rdBtnNewStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_rdBtnNewStudent_WithClassWise");
		}
	}
	@Test(priority = 54)
	public void tcVerifySuccessfulPopUp_rdBtnNewStudent_WithClassWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_rdBtnNewStudent_WithClassWise Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_rdBtnNewStudent_WithClassWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnNewStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_rdBtnNewStudent_WithClassWise");
		}
	}
	@Test(priority = 55)
	public void tcClickOnSuccessOkBtn_rdBtnNewStudent_WithClassWise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_rdBtnNewStudent_WithClassWise Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_rdBtnNewStudent_WithClassWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnNewStudent_WithClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_rdBtnNewStudent_WithClassWise");
		}
	}

	/*
	 * Output Grid data validation and deletion
	 */
	@Test(priority = 56, dataProvider = "Search_StudentFeeGroupData_WithClassWise_NewStudent")
	public void tcSearchBy_StudentName_NameInOutputGrid(String bystudentName, String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_StudentName_NameInOutputGrid Test===========");

			studentFeegroupMap.searchBy_StudentName_NameInOutputGrid(bystudentName, studentName);

			log.info("============= Finished tcSearchBy_StudentName_NameInOutputGrid Test===========");
			getScreenShot("tcSearchBy_StudentName_NameInOutputGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_StudentName_NameInOutputGrid");
		}
	}

	@Test(priority = 57)
	public void tcDeleteUpdatedRecordFrom_OutputGrid() {

		try {
			log.info("============= Strting tcDeleteUpdatedRecordFrom_OutputGrid Test===========");

			studentFeegroupMap.deleteUpdatedRecordFrom_OutputGrid();

			log.info("============= Finished tcDeleteUpdatedRecordFrom_OutputGrid Test===========");
			getScreenShot("tcDeleteUpdatedRecordFrom_OutputGrid");
		} catch (Exception e) {
			getScreenShot("tcDeleteUpdatedRecordFrom_OutputGrid");
		}
	}

	@Test(priority = 58)
	public void tcClickOnCancelButton_PopUp_Delete() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_Delete Test===========");

			studentFeegroupMap.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_Delete Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_Delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_Delete");
		}
	}
	@Test(priority = 59)
	public void tcVerifySuccessfulPopUp_PopUp_Delete_Cancel() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_PopUp_Delete_Cancel Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_PopUp_Delete_Cancel Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_PopUp_Delete_Cancel");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_PopUp_Delete_Cancel");
		}
	}
	@Test(priority = 60)
	public void tcClickOnSuccessOkBtn_DeleteCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_DeleteCancel Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_DeleteCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		}
	}

	@Test(priority = 61)
	public void tcDeleteUpdatedRecordFrom_OutputGrid_AfterCancel() {

		try {
			log.info("============= Strting tcDeleteUpdatedRecordFrom_OutputGrid_AfterCancel Test===========");

			studentFeegroupMap.deleteUpdatedRecordFrom_OutputGrid();

			log.info("============= Finished tcDeleteUpdatedRecordFrom_OutputGrid_AfterCancel Test===========");
			getScreenShot("tcDeleteUpdatedRecordFrom_OutputGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteUpdatedRecordFrom_OutputGrid_AfterCancel");
		}
	}

	@Test(priority = 62)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			studentFeegroupMap.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 63)
	public void tcVerifySuccessfulPopUp_PopUp_Delete_Yes() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_PopUp_Delete_Cancel Test===========");

			studentFeegroupMap.verifySuccessfulPopUp();

			log.info("============= Finished tcVerifySuccessfulPopUp_PopUp_Delete_Cancel Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_PopUp_Delete_Cancel");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_PopUp_Delete_Cancel");
		}
	}
	@Test(priority = 64)
	public void tcClickOnSuccessOkBtn_Delete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Delete Test===========");

			studentFeegroupMap.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Delete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
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
