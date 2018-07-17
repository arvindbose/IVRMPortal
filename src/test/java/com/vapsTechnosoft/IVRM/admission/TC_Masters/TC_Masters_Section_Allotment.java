/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Section_Allotment;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Section_Allotment extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Section_Allotment.class.getName());

	Masters_Section_Allotment sectionAllotment_NewSec;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "SectionAllotment_NewSection")
	public String[][] getTestNewSectionData() {
		String[][] testRecords_NewSection = getData("BGHS_AdmissionData.xlsx", "BGHS_NewSectionData");
		return testRecords_NewSection;
	}

	@DataProvider(name = "NewSection_AdmissionNum")
	public String[][] getTestPeriodData() {
		String[][] testRecordsAdmissionNumPeriod = getData("BGHS_AdmissionData.xlsx", "BGHS_NewSecAdmissionNumData");
		return testRecordsAdmissionNumPeriod;
	}

	@DataProvider(name = "MastersSectionChangeData")
	public String[][] getTestSectionChangeData() {
		String[][] testRecordsSectionChange = getData("BGHS_AdmissionData.xlsx", "BGHS_SectionChangeData");
		return testRecordsSectionChange;
	}

	@DataProvider(name = "MastersSectionPromotionData")
	public String[][] getTestSectionPromotionData() {
		String[][] testRecordsSectionPromotion = getData("BGHS_AdmissionData.xlsx", "BGHS_PromotionSectionData");
		return testRecordsSectionPromotion;
	}

	@DataProvider(name = "YearLossSectionData")
	public String[][] getTestYearLossData() {
		String[][] testRecordsYearLoss = getData("BGHS_AdmissionData.xlsx", "BGHS_YearLossStudentData");
		return testRecordsYearLoss;
	}

	@DataProvider(name = "YearLoss_AdmNumber")
	public String[][] getTestYearLossAdmData() {
		String[][] testRecordsYearLossAdm = getData("BGHS_AdmissionData.xlsx", "BGHS_YrLossAdmissionNum");
		return testRecordsYearLossAdm;
	}

	@DataProvider(name = "Update_RollNumberFormData")
	public String[][] getTestRollNumberFormData() {
		String[][] testRecordsRollNumberForm = getData("BGHS_AdmissionData.xlsx", "BGHS_UpdateRollNumberFormData");
		return testRecordsRollNumberForm;
	}

	@DataProvider(name = "Update_RollNumber")
	public String[][] getTestRollNumberData() {
		String[][] testRecordsRollNumber = getData("BGHS_AdmissionData.xlsx", "BGHS_UpdateRollNumber");
		return testRecordsRollNumber;
	}

	@DataProvider(name = "Update_RollNumberSearch")
	public String[][] getTestRollNumberSearchData() {
		String[][] testRecordsRollNumberSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_UpdateRollNumSearchData");
		return testRecordsRollNumberSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		sectionAllotment_NewSec = new Masters_Section_Allotment(driver);
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

			boolean status = sectionAllotment_NewSec.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_SectionAllotment_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_SectionAllotment_BGHS Test===========");

			sectionAllotment_NewSec.navigateToAdmission_Masters_SectionAllotment_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_SectionAllotment_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_SectionAllotment_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_SectionAllotment_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_SectionAllotment_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_SectionAllotment_BGHSPage Test===========");

			boolean status = sectionAllotment_NewSec.verifyMasters_SectionAllotment_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_SectionAllotment_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_SectionAllotment_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_SectionAllotment_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankNewSectionAllotmentForm() {

		try {
			log.info("============= Strting tcSubmitBlankNewSectionAllotmentForm Test===========");

			sectionAllotment_NewSec.submitBlankNewSectionAllotmentForm();

			log.info("============= Finished tcSubmitBlankNewSectionAllotmentForm Test===========");
			getScreenShot("tcSubmitBlankNewSectionAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankNewSectionAllotmentForm");
		}
	}

	@Test(priority = 6, dataProvider = "SectionAllotment_NewSection")
	public void tcFillNewSectionAllotmentForm(String academicYr, String classAdmitted, String section_newSec,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillNewSectionAllotmentForm Test===========");

			sectionAllotment_NewSec.fillNewSectionAllotmentForm(academicYr, classAdmitted, section_newSec);

			log.info("============= Finished tcFillNewSectionAllotmentForm Test===========");
			getScreenShot("tcFillNewSectionAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillNewSectionAllotmentForm");
		}
	}

	@Test(priority = 7, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSectionAllotment(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSectionAllotment Test===========");

			sectionAllotment_NewSec.selectStudentForSectionAllotment(admissionNumber);

			log.info("============= Finished tcSelectStudentForSectionAllotment Test===========");
			getScreenShot("tcSelectStudentForSectionAllotment");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSectionAllotment");
		}
	}

	@Test(priority = 8)
	public void tcMoveSelectedStudentForSectionAllotment() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionAllotment Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionAllotment();

			log.info("============= Finished tcMoveSelectedStudentForSectionAllotment Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionAllotment");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionAllotment");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeNewSection() {

		try {
			log.info("============= Strting tcMinimizeNewSection Test===========");

			sectionAllotment_NewSec.minimizeNewSection();

			log.info("============= Finished tcMinimizeNewSection Test===========");
			getScreenShot("tcMinimizeNewSection");
		} catch (Exception e) {
			getScreenShot("tcMinimizeNewSection");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeAllotStudentToSection() {

		try {
			log.info("============= Strting tcMinimizeAllotStudentToSection Test===========");

			sectionAllotment_NewSec.minimizeAllotStudentToSection();

			log.info("============= Finished tcMinimizeAllotStudentToSection Test===========");
			getScreenShot("tcMinimizeAllotStudentToSection");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAllotStudentToSection");
		}
	}

	@Test(priority = 11)
	public void tcSortByStudentNameInGrid() {

		try {
			log.info("============= Strting tcSortByStudentNameInGrid Test===========");
			getScreenShot("tcSortByStudentNameInGrid_BeforeSorting");
			sectionAllotment_NewSec.sortByStudentNameInGrid();

			log.info("============= Finished tcSortByStudentNameInGrid Test===========");
			getScreenShot("tcSortByStudentNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSortByStudentNameInGrid");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeSectionAllotedStudentList() {

		try {
			log.info("============= Strting tcMinimizeSectionAllotedStudentList Test===========");

			sectionAllotment_NewSec.minimizeSectionAllotedStudentList();

			log.info("============= Finished tcMinimizeSectionAllotedStudentList Test===========");
			getScreenShot("tcMinimizeSectionAllotedStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeSectionAllotedStudentList");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeSectionAllotedStudentList() {

		try {
			log.info("============= Strting tcMaximizeSectionAllotedStudentList Test===========");

			sectionAllotment_NewSec.maximizeSectionAllotedStudentList();

			log.info("============= Finished tcMaximizeSectionAllotedStudentList Test===========");
			getScreenShot("tcMaximizeSectionAllotedStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeSectionAllotedStudentList");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeAllotStudentToSection() {

		try {
			log.info("============= Strting tcMaximizeAllotStudentToSection Test===========");

			sectionAllotment_NewSec.maximizeAllotStudentToSection();

			log.info("============= Finished tcMaximizeAllotStudentToSection Test===========");
			getScreenShot("tcMaximizeAllotStudentToSection");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAllotStudentToSection");
		}
	}

	@Test(priority = 15)
	public void tcMaximizeNewSection() {

		try {
			log.info("============= Strting tcMaximizeNewSection Test===========");

			sectionAllotment_NewSec.maximizeNewSection();

			log.info("============= Finished tcMaximizeNewSection Test===========");
			getScreenShot("tcMaximizeNewSection");
		} catch (Exception e) {
			getScreenShot("tcMaximizeNewSection");
		}
	}

	@Test(priority = 16)
	public void tcClearNewSectionAllotmemntForm() {

		try {
			log.info("============= Strting tcClearNewSectionAllotmemntForm Test===========");

			sectionAllotment_NewSec.clearNewSectionAllotmemntForm();

			log.info("============= Finished tcClearNewSectionAllotmemntForm Test===========");
			getScreenShot("tcClearNewSectionAllotmemntForm");
		} catch (Exception e) {
			getScreenShot("tcClearNewSectionAllotmemntForm");
		}
	}

	@Test(priority = 17, dataProvider = "SectionAllotment_NewSection")
	public void tcFillNewSectionAllotmentForm_AfterClear(String academicYr, String classAdmitted, String section_newSec,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillNewSectionAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillNewSectionAllotmentForm(academicYr, classAdmitted, section_newSec);

			log.info("============= Finished tcFillNewSectionAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillNewSectionAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillNewSectionAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 18, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSectionAllotment_AfterClear(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSectionAllotment_AfterClear Test===========");

			sectionAllotment_NewSec.selectStudentForSectionAllotment(admissionNumber);

			log.info("============= Finished tcSelectStudentForSectionAllotment_AfterClear Test===========");
			getScreenShot("tcSelectStudentForSectionAllotment_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSectionAllotment_AfterClear");
		}
	}

	@Test(priority = 19)
	public void tcMoveSelectedStudentForSectionAllotment_AfterClear() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionAllotment_AfterClear Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionAllotment();

			log.info("============= Finished tcMoveSelectedStudentForSectionAllotment_AfterClear Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionAllotment_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionAllotment_AfterClear");
		}
	}

	@Test(priority = 20, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionAllotment_MovedToSectionAllotmentTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable Test===========");
			getScreenShot("tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable");
		}
	}

	@Test(priority = 21)
	public void tcSaveNewSectionAllotmemntForm() {

		try {
			log.info("============= Strting tcSaveNewSectionAllotmemntForm Test===========");

			sectionAllotment_NewSec.saveNewSectionAllotmemntForm();

			log.info("============= Finished tcSaveNewSectionAllotmemntForm Test===========");
			getScreenShot("tcSaveNewSectionAllotmemntForm");
		} catch (Exception e) {
			getScreenShot("tcSaveNewSectionAllotmemntForm");
		}
	}

	@Test(priority = 22)
	public void tcClickOnOkSuccessButton_NewSection() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_NewSection Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_NewSection Test===========");
			getScreenShot("tcClickOnOkSuccessButton_NewSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_NewSection");
		}
	}

	@Test(priority = 23, dataProvider = "SectionAllotment_NewSection")
	public void tcFillNewSectionAllotmentForm_ForSearch(String academicYr, String classAdmitted, String section_newSec,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillNewSectionAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillNewSectionAllotmentForm(academicYr, classAdmitted, section_newSec);

			log.info("============= Finished tcFillNewSectionAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillNewSectionAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillNewSectionAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 24, dataProvider = "NewSection_AdmissionNum")
	public void tcSearchWithStudentNameInNewSectionGrid(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentNameInNewSectionGrid Test===========");

			sectionAllotment_NewSec.searchWithStudentNameInNewSectionGrid(admissionNumber);

			log.info("============= Finished tcSearchWithStudentNameInNewSectionGrid Test===========");
			getScreenShot("tcSearchWithStudentNameInNewSectionGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentNameInNewSectionGrid");
		}
	}

	@Test(priority = 25, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentAdmissionNumberInTheGrid(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentAdmissionNumberInTheGrid Test===========");

			sectionAllotment_NewSec.verifyStudentAdmissionNumberInTheGrid(admissionNumber);

			log.info("============= Finished tcVerifyStudentAdmissionNumberInTheGrid Test===========");
			getScreenShot("tcVerifyStudentAdmissionNumberInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentAdmissionNumberInTheGrid");
		}
	}

	@Test(priority = 26)
	public void tcNevigateToDeleteSection() {

		try {
			log.info("============= Strting tcNevigateToDeleteSection Test===========");

			sectionAllotment_NewSec.nevigateToDeleteSection();

			log.info("============= Finished tcNevigateToDeleteSection Test===========");
			getScreenShot("tcNevigateToDeleteSection");
		} catch (Exception e) {
			getScreenShot("tcNevigateToDeleteSection");
		}
	}

	@Test(priority = 27)
	public void tcSubmitDeleteSectionForm_Blank() {

		try {
			log.info("============= Strting tcSubmitDeleteSectionForm_Blank Test===========");

			sectionAllotment_NewSec.submitDeleteSectionForm();

			log.info("============= Finished tcSubmitDeleteSectionForm_Blank Test===========");
			getScreenShot("tcSubmitDeleteSectionForm_Blank");
		} catch (Exception e) {
			getScreenShot("tcSubmitDeleteSectionForm_Blank");
		}
	}

	@Test(priority = 28, dataProvider = "SectionAllotment_NewSection")
	public void tcFillDeleteSectionFormToSelectStudentData(String academicYear, String class_Del, String section_del,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillDeleteSectionFormToSelectStudentData Test===========");

			sectionAllotment_NewSec.fillDeleteSectionFormToSelectStudentData(academicYear, class_Del, section_del);

			log.info("============= Finished tcFillDeleteSectionFormToSelectStudentData Test===========");
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData");
		} catch (Exception e) {
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData");
		}
	}

	@Test(priority = 29)
	public void tcSubmitDeleteSectionForm_WithoutSelectingStudent() {

		try {
			log.info("============= Strting tcSubmitDeleteSectionForm_WithoutSelectingStudent Test===========");

			sectionAllotment_NewSec.submitDeleteSectionForm();

			log.info("============= Finished tcSubmitDeleteSectionForm_WithoutSelectingStudent Test===========");
			getScreenShot("tcSubmitDeleteSectionForm_WithoutSelectingStudent");
		} catch (Exception e) {
			getScreenShot("tcSubmitDeleteSectionForm_WithoutSelectingStudent");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_DeleteSection_WithoutStuSelection() {

		try {
			log.info(
					"============= Strting tcClickOnOkSuccessButton_DeleteSection_WithoutStuSelection Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info(
					"============= Finished tcClickOnOkSuccessButton_DeleteSection_WithoutStuSelection Test===========");
			getScreenShot("tcClickOnOkSuccessButton_DeleteSection_WithoutStuSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_DeleteSection_WithoutStuSelection");
		}
	}

	@Test(priority = 31)
	public void tcNevigateToDeleteSection_After_WithoutSelectingStudentAction() {

		try {
			log.info(
					"============= Strting tcNevigateToDeleteSection_After_WithoutSelectingStudentAction Test===========");

			sectionAllotment_NewSec.nevigateToDeleteSection();

			log.info(
					"============= Finished tcNevigateToDeleteSection_After_WithoutSelectingStudentAction Test===========");
			getScreenShot("tcNevigateToDeleteSection_After_WithoutSelectingStudentAction");
		} catch (Exception e) {
			getScreenShot("tcNevigateToDeleteSection_After_WithoutSelectingStudentAction");
		}
	}

	@Test(priority = 32, dataProvider = "SectionAllotment_NewSection")
	public void tcFillDeleteSectionFormToSelectStudentData_After_WithoutSelectingStudentAction(String academicYear,
			String class_Del, String section_del, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillDeleteSectionFormToSelectStudentData_After_WithoutSelectingStudentAction Test===========");

			sectionAllotment_NewSec.fillDeleteSectionFormToSelectStudentData(academicYear, class_Del, section_del);

			log.info(
					"============= Finished tcFillDeleteSectionFormToSelectStudentData_After_WithoutSelectingStudentAction Test===========");
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_After_WithoutSelectingStudentAction");
		} catch (Exception e) {
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_After_WithoutSelectingStudentAction");
		}
	}

	@Test(priority = 33, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentToDeleteSection(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentToDeleteSection Test===========");

			sectionAllotment_NewSec.selectStudentToDeleteSection(admissionNumber);

			log.info("============= Finished tcSelectStudentToDeleteSection Test===========");
			getScreenShot("tcSelectStudentToDeleteSection");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentToDeleteSection");
		}
	}

	@Test(priority = 34)
	public void tcClearfilledDeleteSectionForm() {

		try {
			log.info("============= Strting tcClearfilledDeleteSectionForm Test===========");

			sectionAllotment_NewSec.clearfilledDeleteSectionForm();

			log.info("============= Finished tcClearfilledDeleteSectionForm Test===========");
			getScreenShot("tcClearfilledDeleteSectionForm");
		} catch (Exception e) {
			getScreenShot("tcClearfilledDeleteSectionForm");
		}
	}

	@Test(priority = 35, dataProvider = "SectionAllotment_NewSection")
	public void tcFillDeleteSectionFormToSelectStudentData_After_Clear(String academicYear, String class_Del,
			String section_del, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillDeleteSectionFormToSelectStudentData_After_Clear Test===========");

			sectionAllotment_NewSec.fillDeleteSectionFormToSelectStudentData(academicYear, class_Del, section_del);

			log.info("============= Finished tcFillDeleteSectionFormToSelectStudentData_After_Clear Test===========");
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_After_Clear");
		} catch (Exception e) {
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_After_Clear");
		}
	}

	@Test(priority = 36, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentToDeleteSection_AfterClear(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentToDeleteSection_AfterClear Test===========");

			sectionAllotment_NewSec.selectStudentToDeleteSection(admissionNumber);

			log.info("============= Finished tcSelectStudentToDeleteSection_AfterClear Test===========");
			getScreenShot("tcSelectStudentToDeleteSection_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentToDeleteSection_AfterClear");
		}
	}

	@Test(priority = 37)
	public void tcSubmitDeleteSectionForm_Final() {

		try {
			log.info("============= Strting tcSubmitDeleteSectionForm_Final Test===========");

			sectionAllotment_NewSec.submitDeleteSectionForm();

			log.info("============= Finished tcSubmitDeleteSectionForm_Final Test===========");
			getScreenShot("tcSubmitDeleteSectionForm_Final");
		} catch (Exception e) {
			getScreenShot("tcSubmitDeleteSectionForm_Final");
		}
	}

	@Test(priority = 38)
	public void tcClickOnOkSuccessButton_DeleteSection() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_DeleteSection Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_DeleteSection Test===========");
			getScreenShot("tcClickOnOkSuccessButton_DeleteSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_DeleteSection");
		}
	}

	@Test(priority = 39)
	public void tcNevigateToDeleteSection_After_SectionDelete() {

		try {
			log.info("============= Strting tcNevigateToDeleteSection_After_SectionDelete Test===========");

			sectionAllotment_NewSec.nevigateToDeleteSection();

			log.info("============= Finished tcNevigateToDeleteSection_After_SectionDelete Test===========");
			getScreenShot("tcNevigateToDeleteSection_After_SectionDelete");
		} catch (Exception e) {
			getScreenShot("tcNevigateToDeleteSection_After_SectionDelete");
		}
	}

	@Test(priority = 40, dataProvider = "SectionAllotment_NewSection")
	public void tcFillDeleteSectionFormToSelectStudentData_ForSearchValidation(String academicYear, String class_Del,
			String section_del, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillDeleteSectionFormToSelectStudentData_ForSearchValidation Test===========");

			sectionAllotment_NewSec.fillDeleteSectionFormToSelectStudentData(academicYear, class_Del, section_del);

			log.info(
					"============= Finished tcFillDeleteSectionFormToSelectStudentData_ForSearchValidation Test===========");
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_ForSearchValidation");
		} catch (Exception e) {
			getScreenShot("tcFillDeleteSectionFormToSelectStudentData_ForSearchValidation");
		}
	}

	@Test(priority = 41, dataProvider = "NewSection_AdmissionNum")
	public void tcSearchWithStudentNameInThe_DeleteSectionGrid(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentNameInThe_DeleteSectionGrid Test===========");

			sectionAllotment_NewSec.searchWithStudentNameInThe_DeleteSectionGrid(admissionNumber);

			log.info("============= Finished tcSearchWithStudentNameInThe_DeleteSectionGrid Test===========");
			getScreenShot("tcSearchWithStudentNameInThe_DeleteSectionGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentNameInThe_DeleteSectionGrid");
		}
	}

	@Test(priority = 42, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentIn_DeleteSectionAllotedGrid(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentIn_DeleteSectionAllotedGrid Test===========");

			sectionAllotment_NewSec.verifyStudentIn_DeleteSectionAllotedGrid(admissionNumber);

			log.info("============= Finished tcVerifyStudentIn_DeleteSectionAllotedGrid Test===========");
			getScreenShot("tcVerifyStudentIn_DeleteSectionAllotedGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentIn_DeleteSectionAllotedGrid");
		}
	}

	@Test(priority = 43)
	public void tcNevigateToNewSection() {

		try {
			log.info("============= Strting tcNevigateToNewSection Test===========");

			sectionAllotment_NewSec.nevigateToNewSection();

			log.info("============= Finished tcNevigateToNewSection Test===========");
			getScreenShot("tcNevigateToNewSection");
		} catch (Exception e) {
			getScreenShot("tcNevigateToNewSection");
		}
	}

	@Test(priority = 44, dataProvider = "SectionAllotment_NewSection")
	public void tcFillNewSectionAllotmentForm_AfterDelete(String academicYr, String classAdmitted,
			String section_newSec, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillNewSectionAllotmentForm_AfterDelete Test===========");

			sectionAllotment_NewSec.fillNewSectionAllotmentForm(academicYr, classAdmitted, section_newSec);

			log.info("============= Finished tcFillNewSectionAllotmentForm_AfterDelete Test===========");
			getScreenShot("tcFillNewSectionAllotmentForm_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcFillNewSectionAllotmentForm_AfterDelete");
		}
	}

	@Test(priority = 45, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSectionAllotment_AfterDelete(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSectionAllotment_AfterDelete Test===========");

			sectionAllotment_NewSec.selectStudentForSectionAllotment(admissionNumber);

			log.info("============= Finished tcSelectStudentForSectionAllotment_AfterDelete Test===========");
			getScreenShot("tcSelectStudentForSectionAllotment_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSectionAllotment_AfterDelete");
		}
	}

	@Test(priority = 46)
	public void tcMoveSelectedStudentForSectionAllotment_AfterDelete() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionAllotment_AfterDelete Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionAllotment();

			log.info("============= Finished tcMoveSelectedStudentForSectionAllotment_AfterDelete Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionAllotment_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionAllotment_AfterDelete");
		}
	}

	@Test(priority = 47, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable_AfterDelete(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable_AfterDelete Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionAllotment_MovedToSectionAllotmentTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable_AfterDelete Test===========");
			getScreenShot("tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionAllotment_MovedToSectionAllotmentTable_AfterDelete");
		}
	}

	@Test(priority = 48)
	public void tcSaveNewSectionAllotmemntForm_AfterDelete() {

		try {
			log.info("============= Strting tcSaveNewSectionAllotmemntForm_AfterDelete Test===========");

			sectionAllotment_NewSec.saveNewSectionAllotmemntForm();

			log.info("============= Finished tcSaveNewSectionAllotmemntForm_AfterDelete Test===========");
			getScreenShot("tcSaveNewSectionAllotmemntForm_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveNewSectionAllotmemntForm_AfterDelete");
		}
	}

	@Test(priority = 49)
	public void tcClickOnOkSuccessButton_NewSection_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_NewSection_AfterDelete Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_NewSection_AfterDelete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_NewSection_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_NewSection_AfterDelete");
		}
	}

	@Test(priority = 50)
	public void tcNevigateToChangeSection() {

		try {
			log.info("============= Strting tcNevigateToChangeSection Test===========");

			sectionAllotment_NewSec.nevigateToChangeSection();

			log.info("============= Finished tcNevigateToChangeSection Test===========");
			getScreenShot("tcNevigateToChangeSection");
		} catch (Exception e) {
			getScreenShot("tcNevigateToChangeSection");
		}
	}

	@Test(priority = 51)
	public void tcSaveSectionChange_SubmitBlankSectionChangeForm() {

		try {
			log.info("============= Strting tcSaveSectionChange_SubmitBlankSectionChangeForm Test===========");

			sectionAllotment_NewSec.saveSectionChange();

			log.info("============= Finished tcSaveSectionChange_SubmitBlankSectionChangeForm Test===========");
			getScreenShot("tcSaveSectionChange_SubmitBlankSectionChangeForm");
		} catch (Exception e) {
			getScreenShot("tcSaveSectionChange_SubmitBlankSectionChangeForm");
		}
	}

	@Test(priority = 52, dataProvider = "MastersSectionChangeData")
	public void tcFillChangeSectionAllotmentForm(String academicYr, String classAdmitted, String section,
			String section_ToChange, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillChangeSectionAllotmentForm Test===========");

			sectionAllotment_NewSec.fillChangeSectionAllotmentForm(academicYr, classAdmitted, section,
					section_ToChange);

			log.info("============= Finished tcFillChangeSectionAllotmentForm Test===========");
			getScreenShot("tcFillChangeSectionAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillChangeSectionAllotmentForm");
		}
	}

	@Test(priority = 53, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSection_Change(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSection_Change Test===========");

			sectionAllotment_NewSec.selectStudentForSection_Change(admissionNumber);

			log.info("============= Finished tcSelectStudentForSection_Change Test===========");
			getScreenShot("tcSelectStudentForSection_Change");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSection_Change");
		}
	}

	@Test(priority = 54)
	public void tcMoveSelectedStudentForSectionChange() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionChange Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionChange();

			log.info("============= Finished tcMoveSelectedStudentForSectionChange Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionChange");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionChange");
		}
	}

	@Test(priority = 55, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionChange_MovedToSectionChangeTable(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentForSectionChange_MovedToSectionChangeTable Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionChange_MovedToSectionChangeTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionChange_MovedToSectionChangeTable Test===========");
			getScreenShot("tcVerifyStudentForSectionChange_MovedToSectionChangeTable");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionChange_MovedToSectionChangeTable");
		}
	}

	@Test(priority = 56)
	public void tcClearSectionChangeFilledData() {

		try {
			log.info("============= Strting tcClearSectionChangeFilledData Test===========");

			sectionAllotment_NewSec.clearSectionChangeData();

			log.info("============= Finished tcClearSectionChangeFilledData Test===========");
			getScreenShot("tcClearSectionChangeFilledData");
		} catch (Exception e) {
			getScreenShot("tcClearSectionChangeFilledData");
		}
	}

	@Test(priority = 57, dataProvider = "MastersSectionChangeData")
	public void tcFillChangeSectionAllotmentForm_AfterClear(String academicYr, String classAdmitted, String section,
			String section_ToChange, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillChangeSectionAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillChangeSectionAllotmentForm(academicYr, classAdmitted, section,
					section_ToChange);

			log.info("============= Finished tcFillChangeSectionAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillChangeSectionAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillChangeSectionAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 58, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSection_Change_AfterClear(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSection_Change_AfterClear Test===========");

			sectionAllotment_NewSec.selectStudentForSection_Change(admissionNumber);

			log.info("============= Finished tcSelectStudentForSection_Change_AfterClear Test===========");
			getScreenShot("tcSelectStudentForSection_Change_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSection_Change_AfterClear");
		}
	}

	@Test(priority = 59)
	public void tcMoveSelectedStudentForSectionChange_AfterClear() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionChange_AfterClear Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionChange();

			log.info("============= Finished tcMoveSelectedStudentForSectionChange_AfterClear Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionChange_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionChange_AfterClear");
		}
	}

	@Test(priority = 60, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionChange_MovedToSectionChangeTable_AfterClear(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentForSectionChange_MovedToSectionChangeTable_AfterClear Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionChange_MovedToSectionChangeTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionChange_MovedToSectionChangeTable_AfterClear Test===========");
			getScreenShot("tcVerifyStudentForSectionChange_MovedToSectionChangeTable_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionChange_MovedToSectionChangeTable_AfterClear");
		}
	}

	@Test(priority = 61)
	public void tcSaveSectionChange_Final() {

		try {
			log.info("============= Strting tcSaveSectionChange_Final Test===========");

			sectionAllotment_NewSec.saveSectionChange();

			log.info("============= Finished tcSaveSectionChange_Final Test===========");
			getScreenShot("tcSaveSectionChange_Final");
		} catch (Exception e) {
			getScreenShot("tcSaveSectionChange_Final");
		}
	}

	@Test(priority = 62)
	public void tcClickOnOkSuccessButton_ChangeSection() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ChangeSection Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ChangeSection Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ChangeSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ChangeSection");
		}
	}

	@Test(priority = 63, dataProvider = "MastersSectionChangeData")
	public void tcFillChangeSectionAllotmentForm_ForSectionChangeGridUpdate(String academicYr, String classAdmitted,
			String section, String section_ToChange, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillChangeSectionAllotmentForm_ForSectionChangeGridUpdate Test===========");

			sectionAllotment_NewSec.fillChangeSectionAllotmentForm(academicYr, classAdmitted, section,
					section_ToChange);

			log.info(
					"============= Finished tcFillChangeSectionAllotmentForm_ForSectionChangeGridUpdate Test===========");
			getScreenShot("tcFillChangeSectionAllotmentForm_ForSectionChangeGridUpdate");
		} catch (Exception e) {
			getScreenShot("tcFillChangeSectionAllotmentForm_ForSectionChangeGridUpdate");
		}
	}

	@Test(priority = 64, dataProvider = "NewSection_AdmissionNum")
	public void tcSearchWithStudentNameInThe_ChangeSectionGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentNameInThe_ChangeSectionGrid Test===========");

			sectionAllotment_NewSec.searchWithStudentNameInThe_ChangeSectionGrid(admissionNumber);

			log.info("============= Finished tcSearchWithStudentNameInThe_ChangeSectionGrid Test===========");
			getScreenShot("tcSearchWithStudentNameInThe_ChangeSectionGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentNameInThe_ChangeSectionGrid");
		}
	}

	@Test(priority = 65, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentIn_ChangeSectionAllotedGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentIn_ChangeSectionAllotedGrid Test===========");

			sectionAllotment_NewSec.verifyStudentIn_ChangeSectionAllotedGrid(admissionNumber);

			log.info("============= Finished tcVerifyStudentIn_ChangeSectionAllotedGrid Test===========");
			getScreenShot("tcVerifyStudentIn_ChangeSectionAllotedGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentIn_ChangeSectionAllotedGrid");
		}
	}

	@Test(priority = 66)
	public void tcNevigateToPromotionSection() {

		try {
			log.info("============= Strting tcNevigateToPromotionSection Test===========");

			sectionAllotment_NewSec.nevigateToPromotionSection();

			log.info("============= Finished tcNevigateToPromotionSection Test===========");
			getScreenShot("tcNevigateToPromotionSection");
		} catch (Exception e) {
			getScreenShot("tcNevigateToPromotionSection");
		}
	}

	@Test(priority = 67)
	public void tcSaveSectionPromotion_SubmitBlankForm() {

		try {
			log.info("============= Strting tcSaveSectionPromotion_SubmitBlankForm Test===========");

			sectionAllotment_NewSec.saveSectionPromotion();

			log.info("============= Finished tcSaveSectionPromotion_SubmitBlankForm Test===========");
			getScreenShot("tcSaveSectionPromotion_SubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcSaveSectionPromotion_SubmitBlankForm");
		}
	}

	@Test(priority = 68, dataProvider = "MastersSectionPromotionData")
	public void tcFillPromotionSectionAllotmentForm(String academicYr, String YrsToPromot, String class_Current,
			String section_Current, String academicYr_Promot, String promoted_Class, String section_ToPromot,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillPromotionSectionAllotmentForm Test===========");

			sectionAllotment_NewSec.fillPromotionSectionAllotmentForm(academicYr, YrsToPromot, class_Current,
					section_Current, academicYr_Promot, promoted_Class, section_ToPromot);

			log.info("============= Finished tcFillPromotionSectionAllotmentForm Test===========");
			getScreenShot("tcFillPromotionSectionAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillPromotionSectionAllotmentForm");
		}
	}

	@Test(priority = 69, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSection_Promotion(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSection_Promotion Test===========");

			sectionAllotment_NewSec.selectStudentForSection_Promotion(admissionNumber);

			log.info("============= Finished tcSelectStudentForSection_Promotion Test===========");
			getScreenShot("tcSelectStudentForSection_Promotion");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSection_Promotion");
		}
	}

	@Test(priority = 70)
	public void tcMoveSelectedStudentForSectionPromotion() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionPromotion Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionPromotion();

			log.info("============= Finished tcMoveSelectedStudentForSectionPromotion Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionPromotion");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionPromotion");
		}
	}

	@Test(priority = 71, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionPromotion_MovedToSectionPromotionTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable Test===========");
			getScreenShot("tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable");
		}
	}

	@Test(priority = 72)
	public void tcClearSectionPromotionData() {

		try {
			log.info("============= Strting tcClearSectionPromotionData Test===========");

			sectionAllotment_NewSec.clearSectionPromotionData();

			log.info("============= Finished tcClearSectionPromotionData Test===========");
			getScreenShot("tcClearSectionPromotionData");
		} catch (Exception e) {
			getScreenShot("tcClearSectionPromotionData");
		}
	}

	@Test(priority = 73, dataProvider = "MastersSectionPromotionData")
	public void tcFillPromotionSectionAllotmentForm_AfterClear(String academicYr, String YrsToPromot,
			String class_Current, String section_Current, String academicYr_Promot, String promoted_Class,
			String section_ToPromot, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillPromotionSectionAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillPromotionSectionAllotmentForm(academicYr, YrsToPromot, class_Current,
					section_Current, academicYr_Promot, promoted_Class, section_ToPromot);

			log.info("============= Finished tcFillPromotionSectionAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillPromotionSectionAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillPromotionSectionAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 74, dataProvider = "NewSection_AdmissionNum")
	public void tcSelectStudentForSection_Promotion_AfterClear(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForSection_Promotion_AfterClear Test===========");

			sectionAllotment_NewSec.selectStudentForSection_Promotion(admissionNumber);

			log.info("============= Finished tcSelectStudentForSection_Change_AfterClear Test===========");
			getScreenShot("tcSelectStudentForSection_Promotion_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForSection_Promotion_AfterClear");
		}
	}

	@Test(priority = 75)
	public void tcMoveSelectedStudentForSectionPromotion_AfterClear() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForSectionPromotion_AfterClear Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForSectionPromotion();

			log.info("============= Finished tcMoveSelectedStudentForSectionPromotion_AfterClear Test===========");
			getScreenShot("tcMoveSelectedStudentForSectionPromotion_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForSectionPromotion_AfterClear");
		}
	}

	@Test(priority = 76, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable_AfterClear(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable_AfterClear Test===========");

			sectionAllotment_NewSec.verifyStudentForSectionPromotion_MovedToSectionPromotionTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable_AfterClear Test===========");
			getScreenShot("tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForSectionPromotion_MovedToSectionPromotionTable_AfterClear");
		}
	}

	@Test(priority = 77)
	public void tcSaveSectionPromotion_Final() {

		try {
			log.info("============= Strting tcSaveSectionPromotion_Final Test===========");

			sectionAllotment_NewSec.saveSectionPromotion();

			log.info("============= Finished tcSaveSectionPromotion_Final Test===========");
			getScreenShot("tcSaveSectionPromotion_Final");
		} catch (Exception e) {
			getScreenShot("tcSaveSectionPromotion_Final");
		}
	}

	@Test(priority = 78)
	public void tcClickOnOkSuccessButton_PromotionSection() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_PromotionSection Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_PromotionSection Test===========");
			getScreenShot("tcClickOnOkSuccessButton_PromotionSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_PromotionSection");
		}
	}

	@Test(priority = 79)
	public void tcNevigateToPromotionSection_GridUpdateCheck() {

		try {
			log.info("============= Strting tcNevigateToPromotionSection_GridUpdateCheck Test===========");

			sectionAllotment_NewSec.nevigateToPromotionSection();

			log.info("============= Finished tcNevigateToPromotionSection_GridUpdateCheck Test===========");
			getScreenShot("tcNevigateToPromotionSection_GridUpdateCheck");
		} catch (Exception e) {
			getScreenShot("tcNevigateToPromotionSection_GridUpdateCheck");
		}
	}

	@Test(priority = 80, dataProvider = "MastersSectionPromotionData")
	public void tcFillPromotionSectionAllotmentForm_ForSearchUpdatedInfrid(String academicYr, String YrsToPromot,
			String class_Current, String section_Current, String academicYr_Promot, String promoted_Class,
			String section_ToPromot, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillPromotionSectionAllotmentForm_ForSearchUpdatedInfrid Test===========");

			sectionAllotment_NewSec.fillPromotionSectionAllotmentForm(academicYr, YrsToPromot, class_Current,
					section_Current, academicYr_Promot, promoted_Class, section_ToPromot);

			log.info(
					"============= Finished tcFillPromotionSectionAllotmentForm_ForSearchUpdatedInfrid Test===========");
			getScreenShot("tcFillPromotionSectionAllotmentForm_ForSearchUpdatedInfrid");
		} catch (Exception e) {
			getScreenShot("tcFillPromotionSectionAllotmentForm_ForSearchUpdatedInfrid");
		}
	}

	@Test(priority = 81, dataProvider = "NewSection_AdmissionNum")
	public void tcSearchWithStudentNameInThe_PromoteStudentGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentNameInThe_PromoteStudentGrid Test===========");

			sectionAllotment_NewSec.searchWithStudentNameInThe_PromoteStudentGrid(admissionNumber);

			log.info("============= Finished tcSearchWithStudentNameInThe_PromoteStudentGrid Test===========");
			getScreenShot("tcSearchWithStudentNameInThe_PromoteStudentGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentNameInThe_PromoteStudentGrid");
		}
	}

	@Test(priority = 82, dataProvider = "NewSection_AdmissionNum")
	public void tcVerifyStudentIn_PromotedStudentGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentIn_PromotedStudentGrid Test===========");

			sectionAllotment_NewSec.verifyStudentIn_PromotedStudentGrid(admissionNumber);

			log.info("============= Finished tcVerifyStudentIn_PromotedStudentGrid Test===========");
			getScreenShot("tcVerifyStudentIn_PromotedStudentGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentIn_PromotedStudentGrid");
		}
	}

	@Test(priority = 83)
	public void tcNevigateToYearLossSection() {

		try {
			log.info("============= Strting tcNevigateToYearLossSection Test===========");

			sectionAllotment_NewSec.nevigateToYearLossSection();

			log.info("============= Finished tcNevigateToYearLossSection Test===========");
			getScreenShot("tcNevigateToYearLossSection");
		} catch (Exception e) {
			getScreenShot("tcNevigateToYearLossSection");
		}
	}

	@Test(priority = 84)
	public void tcSubmitBlankYearLossSectionForm() {

		try {
			log.info("============= Strting tcSubmitBlankYearLossSectionForm Test===========");

			sectionAllotment_NewSec.saveYearLossSection();

			log.info("============= Finished tcSubmitBlankYearLossSectionForm Test===========");
			getScreenShot("tcSubmitBlankYearLossSectionForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankYearLossSectionForm");
		}
	}

	@Test(priority = 85, dataProvider = "YearLossSectionData")
	public void tcFillYearLossSectionAllotmentForm(String academicYr, String class_Current, String section_Current,
			String academicYr_New, String new_Class, String section_YrLoss, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillYearLossSectionAllotmentForm Test===========");

			sectionAllotment_NewSec.fillYearLossSectionAllotmentForm(academicYr, class_Current, section_Current,
					academicYr_New, new_Class, section_YrLoss);

			log.info("============= Finished tcFillYearLossSectionAllotmentForm Test===========");
			getScreenShot("tcFillYearLossSectionAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillYearLossSectionAllotmentForm");
		}
	}

	@Test(priority = 86, dataProvider = "YearLoss_AdmNumber")
	public void tcSelectStudentFor_YearLossStudent(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_YearLossStudent Test===========");

			sectionAllotment_NewSec.selectStudentFor_YearLossStudent(admissionNumber);

			log.info("============= Finished tcSelectStudentFor_YearLossStudent Test===========");
			getScreenShot("tcSelectStudentFor_YearLossStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_YearLossStudent");
		}
	}

	@Test(priority = 87)
	public void tcMoveSelectedStudentForYearLossSection() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForYearLossSection Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForYearLossSection();

			log.info("============= Finished tcMoveSelectedStudentForYearLossSection Test===========");
			getScreenShot("tcMoveSelectedStudentForYearLossSection");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForYearLossSection");
		}
	}

	@Test(priority = 88, dataProvider = "YearLoss_AdmNumber")
	public void tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable Test===========");

			sectionAllotment_NewSec.verifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable Test===========");
			getScreenShot("tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable");
		}
	}

	@Test(priority = 89)
	public void tcClearYearLossSectionData() {

		try {
			log.info("============= Strting tcClearYearLossSectionData Test===========");

			sectionAllotment_NewSec.clearYearLossSectionData();

			log.info("============= Finished tcClearYearLossSectionData Test===========");
			getScreenShot("tcClearYearLossSectionData");
		} catch (Exception e) {
			getScreenShot("tcClearYearLossSectionData");
		}
	}

	@Test(priority = 90, dataProvider = "YearLossSectionData")
	public void tcFillYearLossSectionAllotmentForm_AfterClear(String academicYr, String class_Current,
			String section_Current, String academicYr_New, String new_Class, String section_YrLoss, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillYearLossSectionAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillYearLossSectionAllotmentForm(academicYr, class_Current, section_Current,
					academicYr_New, new_Class, section_YrLoss);

			log.info("============= Finished tcFillYearLossSectionAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillYearLossSectionAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillYearLossSectionAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 91, dataProvider = "YearLoss_AdmNumber")
	public void tcSelectStudentFor_YearLossStudent_AfterClear(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_YearLossStudent_AfterClear Test===========");

			sectionAllotment_NewSec.selectStudentFor_YearLossStudent(admissionNumber);

			log.info("============= Finished tcSelectStudentFor_YearLossStudent_AfterClear Test===========");
			getScreenShot("tcSelectStudentFor_YearLossStudent_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_YearLossStudent_AfterClear");
		}
	}

	@Test(priority = 92)
	public void tcMoveSelectedStudentForYearLossSection_AfterClear() {

		try {
			log.info("============= Strting tcMoveSelectedStudentForYearLossSection_AfterClear Test===========");

			sectionAllotment_NewSec.moveSelectedStudentForYearLossSection();

			log.info("============= Finished tcMoveSelectedStudentForYearLossSection_AfterClear Test===========");
			getScreenShot("tcMoveSelectedStudentForYearLossSection_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcMoveSelectedStudentForYearLossSection_AfterClear");
		}
	}

	@Test(priority = 93, dataProvider = "YearLoss_AdmNumber")
	public void tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable_AfterClear(String admissionNumber,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable_AfterClear Test===========");

			sectionAllotment_NewSec.verifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable(admissionNumber);

			log.info(
					"============= Finished tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable_AfterClear Test===========");
			getScreenShot("tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentFor_YearLossStudent_MovedTo_YearLossStudentTable_AfterClear");
		}
	}

	@Test(priority = 94)
	public void tcSaveYearLossSection() {

		try {
			log.info("============= Strting tcSaveYearLossSection Test===========");

			sectionAllotment_NewSec.saveYearLossSection();

			log.info("============= Finished tcSaveYearLossSection Test===========");
			getScreenShot("tcSaveYearLossSection");
		} catch (Exception e) {
			getScreenShot("tcSaveYearLossSection");
		}
	}

	@Test(priority = 95)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 96)
	public void tcNevigateToYearLossSection_AfterFinalSubmition() {

		try {
			log.info("============= Strting tcNevigateToYearLossSection_AfterFinalSubmition Test===========");

			sectionAllotment_NewSec.nevigateToYearLossSection();

			log.info("============= Finished tcNevigateToYearLossSection_AfterFinalSubmition Test===========");
			getScreenShot("tcNevigateToYearLossSection_AfterFinalSubmition");
		} catch (Exception e) {
			getScreenShot("tcNevigateToYearLossSection_AfterFinalSubmition");
		}
	}

	@Test(priority = 97, dataProvider = "YearLossSectionData")
	public void tcFillYearLossSectionAllotmentForm__AfterFinalSubmition(String academicYr, String class_Current,
			String section_Current, String academicYr_New, String new_Class, String section_YrLoss, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillYearLossSectionAllotmentForm__AfterFinalSubmition Test===========");

			sectionAllotment_NewSec.fillYearLossSectionAllotmentForm(academicYr, class_Current, section_Current,
					academicYr_New, new_Class, section_YrLoss);

			log.info("============= Finished tcFillYearLossSectionAllotmentForm__AfterFinalSubmition Test===========");
			getScreenShot("tcFillYearLossSectionAllotmentForm__AfterFinalSubmition");
		} catch (Exception e) {
			getScreenShot("tcFillYearLossSectionAllotmentForm__AfterFinalSubmition");
		}
	}

	@Test(priority = 98, dataProvider = "YearLoss_AdmNumber")
	public void tcSearchStudentToValidateUpdatedYearLossStudentInGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToValidateUpdatedYearLossStudentInGrid Test===========");

			sectionAllotment_NewSec.searchStudentToValidateUpdatedYearLossStudentInGrid(admissionNumber);

			log.info("============= Finished tcSearchStudentToValidateUpdatedYearLossStudentInGrid Test===========");
			getScreenShot("tcSearchStudentToValidateUpdatedYearLossStudentInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToValidateUpdatedYearLossStudentInGrid");
		}
	}

	@Test(priority = 99, dataProvider = "YearLoss_AdmNumber")
	public void tcVerifyUpdatedYearLossStudentInGrid(String admissionNumber, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyUpdatedYearLossStudentInGrid Test===========");

			sectionAllotment_NewSec.verifyUpdatedYearLossStudentInGrid(admissionNumber);

			log.info("============= Finished tcVerifyUpdatedYearLossStudentInGrid Test===========");
			getScreenShot("tcVerifyUpdatedYearLossStudentInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyUpdatedYearLossStudentInGrid");
		}
	}

	@Test(priority = 100)
	public void tcNavigateToUpdateRollNumber() {

		try {
			log.info("============= Strting tcNavigateToUpdateRollNumber Test===========");

			sectionAllotment_NewSec.nevigateToUpdateRollNumber();

			log.info("============= Finished tcNavigateToUpdateRollNumber Test===========");
			getScreenShot("tcNavigateToUpdateRollNumber");
		} catch (Exception e) {
			getScreenShot("tcNavigateToUpdateRollNumber");
		}
	}

	@Test(priority = 101)
	public void tcSubmitBlankUpdateRollNumberForm() {

		try {
			log.info("============= Strting tcSubmitBlankUpdateRollNumberForm Test===========");

			sectionAllotment_NewSec.saveUpdateRollNumber();

			log.info("============= Finished tcSubmitBlankUpdateRollNumberForm Test===========");
			getScreenShot("tcSubmitBlankUpdateRollNumberForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankUpdateRollNumberForm");
		}
	}

	@Test(priority = 102, dataProvider = "Update_RollNumberFormData")
	public void tcFillUpdateRollNumberAllotmentForm(String academicYr, String class_rollNo, String section_rollNo,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillUpdateRollNumberAllotmentForm Test===========");

			sectionAllotment_NewSec.fillUpdateRollNumberAllotmentForm(academicYr, class_rollNo, section_rollNo);

			log.info("============= Finished tcFillUpdateRollNumberAllotmentForm Test===========");
			getScreenShot("tcFillUpdateRollNumberAllotmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillUpdateRollNumberAllotmentForm");
		}
	}

	@Test(priority = 103, dataProvider = "Update_RollNumberSearch")
	public void tcSearchStudentToUpdateRollNumber(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToUpdateRollNumber Test===========");

			sectionAllotment_NewSec.searchStudentToUpdateRollNumber(admissionNumber);

			log.info("============= Finished tcSearchStudentToUpdateRollNumber Test===========");
			getScreenShot("tcSearchStudentToUpdateRollNumber");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToUpdateRollNumber");
		}
	}

	@Test(priority = 104, dataProvider = "Update_RollNumber")
	public void tcUpdateRollNumberForTheStudent(String admissionNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateRollNumberForTheStudent Test===========");

			sectionAllotment_NewSec.updateRollNumberForTheStudent(admissionNumber, rollNumber);

			log.info("============= Finished tcUpdateRollNumberForTheStudent Test===========");
			getScreenShot("tcUpdateRollNumberForTheStudent");
		} catch (Exception e) {
			getScreenShot("tcUpdateRollNumberForTheStudent");
		}
	}

	@Test(priority = 105)
	public void tcMinimizeUpdateRollNumber() {

		try {
			log.info("============= Strting tcMinimizeUpdateRollNumber Test===========");

			sectionAllotment_NewSec.minimizeUpdateRollNumber();

			log.info("============= Finished tcMinimizeUpdateRollNumber Test===========");
			getScreenShot("tcMinimizeUpdateRollNumber");
		} catch (Exception e) {
			getScreenShot("tcMinimizeUpdateRollNumber");
		}
	}

	@Test(priority = 106)
	public void tcMinimizeUpdateRollNumberStudentList() {

		try {
			log.info("============= Strting tcMinimizeUpdateRollNumberStudentList Test===========");

			sectionAllotment_NewSec.minimizeUpdateRollNumberStudentList();

			log.info("============= Finished tcMinimizeUpdateRollNumberStudentList Test===========");
			getScreenShot("tcMinimizeUpdateRollNumberStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeUpdateRollNumberStudentList");
		}
	}

	@Test(priority = 107)
	public void tcSortByStudentNameInUpdatedRollNumberGrid() {

		try {
			log.info("============= Strting tcSortByStudentNameInUpdatedRollNumberGrid Test===========");
			getScreenShot("tcSortByStudentNameInUpdatedRollNumberGrid_BeforeSorting");
			sectionAllotment_NewSec.sortByStudentNameInUpdateRollNumberGrid();

			log.info("============= Finished tcSortByStudentNameInUpdatedRollNumberGrid Test===========");
			getScreenShot("tcSortByStudentNameInUpdatedRollNumberGrid");
		} catch (Exception e) {
			getScreenShot("tcSortByStudentNameInUpdatedRollNumberGrid");
		}
	}

	@Test(priority = 108)
	public void tcMinimizeUpdatedRollNumberInGrid() {

		try {
			log.info("============= Strting tcMinimizeUpdatedRollNumberInGrid Test===========");

			sectionAllotment_NewSec.minimizeUpdatedRollNumberInGrid();

			log.info("============= Finished tcMinimizeUpdatedRollNumberInGrid Test===========");
			getScreenShot("tcMinimizeUpdatedRollNumberInGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimizeUpdatedRollNumberInGrid");
		}
	}

	@Test(priority = 109)
	public void tcMaximizeUpdateRollNumber() {

		try {
			log.info("============= Strting tcMaximizeUpdateRollNumber Test===========");

			sectionAllotment_NewSec.maximizeUpdateRollNumber();

			log.info("============= Finished tcMaximizeUpdateRollNumber Test===========");
			getScreenShot("tcMaximizeUpdateRollNumber");
		} catch (Exception e) {
			getScreenShot("tcMaximizeUpdateRollNumber");
		}
	}

	@Test(priority = 110)
	public void tcMaximizeUpdateRollNumberStudentList() {

		try {
			log.info("============= Strting tcMaximizeUpdateRollNumberStudentList Test===========");

			sectionAllotment_NewSec.maximizeUpdateRollNumberStudentList();

			log.info("============= Finished tcMaximizeUpdateRollNumberStudentList Test===========");
			getScreenShot("tcMaximizeUpdateRollNumberStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeUpdateRollNumberStudentList");
		}
	}

	@Test(priority = 111)
	public void tcMaximizeUpdatedRollNumberInGrid() {

		try {
			log.info("============= Strting tcMaximizeUpdatedRollNumberInGrid Test===========");

			sectionAllotment_NewSec.maximizeUpdatedRollNumberInGrid();

			log.info("============= Finished tcMaximizeUpdatedRollNumberInGrid Test===========");
			getScreenShot("tcMaximizeUpdatedRollNumberInGrid");
		} catch (Exception e) {
			getScreenShot("tcMaximizeUpdatedRollNumberInGrid");
		}
	}

	@Test(priority = 112)
	public void tcClearUpdateRollNumberData() {

		try {
			log.info("============= Strting tcSubmitBlankUpdateRollNumberForm Test===========");

			sectionAllotment_NewSec.clearUpdateRollNumberData();

			log.info("============= Finished tcSubmitBlankUpdateRollNumberForm Test===========");
			getScreenShot("tcSubmitBlankUpdateRollNumberForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankUpdateRollNumberForm");
		}
	}

	@Test(priority = 113, dataProvider = "Update_RollNumberFormData")
	public void tcFillUpdateRollNumberAllotmentForm_AfterClear(String academicYr, String class_rollNo,
			String section_rollNo, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillUpdateRollNumberAllotmentForm_AfterClear Test===========");

			sectionAllotment_NewSec.fillUpdateRollNumberAllotmentForm(academicYr, class_rollNo, section_rollNo);

			log.info("============= Finished tcFillUpdateRollNumberAllotmentForm_AfterClear Test===========");
			getScreenShot("tcFillUpdateRollNumberAllotmentForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillUpdateRollNumberAllotmentForm_AfterClear");
		}
	}

	@Test(priority = 114, dataProvider = "Update_RollNumberSearch")
	public void tcSearchStudentToUpdateRollNumber_AfterClear(String admissionNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToUpdateRollNumber_AfterClear Test===========");

			sectionAllotment_NewSec.searchStudentToUpdateRollNumber(admissionNumber);

			log.info("============= Finished tcSearchStudentToUpdateRollNumber_AfterClear Test===========");
			getScreenShot("tcSearchStudentToUpdateRollNumber_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToUpdateRollNumber_AfterClear");
		}
	}

	@Test(priority = 115, dataProvider = "Update_RollNumber")
	public void tcUpdateRollNumberForTheStudent_AfterClear(String admissionNumber, String rollNumber, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateRollNumberForTheStudent_AfterClear Test===========");

			sectionAllotment_NewSec.updateRollNumberForTheStudent(admissionNumber, rollNumber);

			log.info("============= Finished tcUpdateRollNumberForTheStudent_AfterClear Test===========");
			getScreenShot("tcUpdateRollNumberForTheStudent_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUpdateRollNumberForTheStudent_AfterClear");
		}
	}

	@Test(priority = 116)
	public void tcSaveUpdateRollNumber() {

		try {
			log.info("============= Strting tcSaveUpdateRollNumber Test===========");

			sectionAllotment_NewSec.saveUpdateRollNumber();

			log.info("============= Finished tcSaveUpdateRollNumber Test===========");
			getScreenShot("tcSaveUpdateRollNumber");
		} catch (Exception e) {
			getScreenShot("tcSaveUpdateRollNumber");
		}
	}

	@Test(priority = 117)
	public void tcClickOnOkSuccessButton_updateRoll() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_updateRoll Test===========");

			sectionAllotment_NewSec.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_updateRoll Test===========");
			getScreenShot("tcClickOnOkSuccessButton_updateRoll");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_updateRoll");
		}
	}
	@Test(priority = 118)
	public void tcNavigateToUpdateRollNumber_ForGridValidation() {

		try {
			log.info("============= Strting tcNavigateToUpdateRollNumber_ForGridValidation Test===========");

			sectionAllotment_NewSec.nevigateToUpdateRollNumber();

			log.info("============= Finished tcNavigateToUpdateRollNumber_ForGridValidation Test===========");
			getScreenShot("tcNavigateToUpdateRollNumber_ForGridValidation");
		} catch (Exception e) {
			getScreenShot("tcNavigateToUpdateRollNumber_ForGridValidation");
		}
	}

	@Test(priority = 119, dataProvider = "Update_RollNumberFormData")
	public void tcFillUpdateRollNumberAllotmentForm_ForOutputGridValidation(String academicYr, String class_rollNo,
			String section_rollNo, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillUpdateRollNumberAllotmentForm_ForOutputGridValidation Test===========");

			sectionAllotment_NewSec.fillUpdateRollNumberAllotmentForm(academicYr, class_rollNo, section_rollNo);

			log.info(
					"============= Finished tcFillUpdateRollNumberAllotmentForm_ForOutputGridValidation Test===========");
			getScreenShot("tcFillUpdateRollNumberAllotmentForm_ForOutputGridValidation");
		} catch (Exception e) {
			getScreenShot("tcFillUpdateRollNumberAllotmentForm_ForOutputGridValidation");
		}
	}

	@Test(priority = 120, dataProvider = "Update_RollNumber")
	public void tcVerifyUpdatedRollNumberForTheStudentInGrid(String admissionNumber, String rollNumber,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdateRollNumberForTheStudent_AfterClear Test===========");

			sectionAllotment_NewSec.verifyUpdatedRollNumberForTheStudentInGrid(admissionNumber, rollNumber);

			log.info("============= Finished tcUpdateRollNumberForTheStudent_AfterClear Test===========");
			getScreenShot("tcUpdateRollNumberForTheStudent_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcUpdateRollNumberForTheStudent_AfterClear");
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
