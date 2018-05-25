/**
 * 
 */
package com.test.automation.uiAutomation.admission.admissionForm;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Admission.AdmissionForm.StudentAdmissionForm;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_StudentAdmissionForm extends TestBase {

	public static final Logger log = Logger.getLogger(TC_StudentAdmissionForm.class.getName());

	StudentAdmissionForm studentAdmForm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "AdmissionFormData")
	public String[][] getAdmissionStudentData() {
		String[][] testRecordsAdmData = getData("TestData.xlsx", "StudentAdmFormData");
		return testRecordsAdmData;
	}

	@DataProvider(name = "AdmissionFormAddressData")
	public String[][] getAdmissionAddress() {
		String[][] admissionFormAddressData = getData("TestData.xlsx", "AdmFormAddress");
		return admissionFormAddressData;
	}

	@DataProvider(name = "AdmissionFormParentData")
	public String[][] getAdmissionFatherData() {
		String[][] admissionFormFatherData = getData("TestData.xlsx", "AdmFormParentData");
		return admissionFormFatherData;
	}

	@DataProvider(name = "AdmissionFormBondData")
	public String[][] getbondData() {
		String[][] admissionFormBondData = getData("TestData.xlsx", "BondDetailsData");
		return admissionFormBondData;
	}

	@DataProvider(name = "AdmissionPreviousSchoolData")
	public String[][] getpreviousSchoolData() {
		String[][] admissionFormPrevSchoolData = getData("TestData.xlsx", "PreviousSchoolData");
		return admissionFormPrevSchoolData;
	}

	@DataProvider(name = "AdmissionGuardianData")
	public String[][] getGuardianData() {
		String[][] admissionFormGuardianData = getData("TestData.xlsx", "GuardianDetailsData");
		return admissionFormGuardianData;
	}

	@DataProvider(name = "AdmissionSiblingData")
	public String[][] getSiblingData() {
		String[][] admissionFormSiblingData = getData("TestData.xlsx", "AdmSiblingDetails");
		return admissionFormSiblingData;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentAdmForm = new StudentAdmissionForm(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		ivrmportallogin = new IvrmPortalLogin(driver);
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
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			studentAdmForm.verifyHomeButton();
			
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcnavigateToStudentAdmForm() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcnavigateToStudentAdmForm Test===========");

			studentAdmForm.navigateToStudentAdmForm();
			
			log.info("============= Finished tcnavigateToStudentAdmForm Test===========");
			getScreenShot("tcnavigateToStudentAdmForm");
		} catch (Exception e) {
			getScreenShot("tcnavigateToStudentAdmForm");
		}
	}
	
	
	@Test(priority = 4, dataProvider = "AdmissionFormData")
	public void studentAdmissionFormInternalProcess(String FirstName, String MiddleName, String LastName, String RegNo,
			String AdmNo, String classToAdm, String casteCatg, String Caste, String BankIFSC, String BirthPlace,
			String BirthCert, String casteCert, String Gender, String MotherTongue, String Religion, String Nationality,
			String MobNo, String Email, String AadharNo, String BloodGr, String StBankAC, String BPLCardNo,
			String Feeconcession, String runMode) {
		studentAdmForm = new StudentAdmissionForm(driver);

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting studentAdmissionFormInternalProcess Test===========");

			studentAdmForm.studentAdmissionFormStudentSection(FirstName, MiddleName, LastName, RegNo, AdmNo, classToAdm,
					casteCatg, Caste, BankIFSC, BirthPlace, BirthCert, casteCert, Gender, MotherTongue, Religion,
					Nationality, MobNo, Email, AadharNo, BloodGr, StBankAC, BPLCardNo, Feeconcession);

			log.info("============= Finished studentAdmissionFormInternalProcess Test===========");
			getScreenShot("studentAdmissionFormInternalProcess");
		} catch (Exception e) {
			getScreenShot("studentAdmissionFormInternalProcess");
		}
	}
	@Test(priority = 5)
	public void tcClickOnStudentPageNextButton() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnStudentPageNextButton Test===========");

			studentAdmForm.clickOnStudentPageNextButton();
			
			log.info("============= Finished tcClickOnStudentPageNextButton Test===========");
			getScreenShot("tcClickOnStudentPageNextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnStudentPageNextButton");
		}
	}

	@Test(priority = 6, dataProvider = "AdmissionFormAddressData")
	public void tcStudentAdmissionFormAddressSection(String enterAddr, String areaAddr, String Country, String State,
			String City, String PinCode, String runMode) {
		studentAdmForm = new StudentAdmissionForm(driver);

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcStudentAdmissionFormAddressSection Test===========");

			studentAdmForm.studentAdmissionFormAddressSection(enterAddr, areaAddr, Country, State, City, PinCode);
			log.info("============= Finished tcStudentAdmissionFormAddressSection Test===========");
			getScreenShot("tcStudentAdmissionFormAddressSection");
		} catch (Exception e) {
			getScreenShot("tcStudentAdmissionFormAddressSection");
		}
	}
	@Test(priority = 7)
	public void tcClickOnAddressPageNextButton() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnAddressPageNextButton Test===========");

			studentAdmForm.clickOnAddressPageNextButton();
			
			log.info("============= Finished tcClickOnAddressPageNextButton Test===========");
			getScreenShot("tcClickOnAddressPageNextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddressPageNextButton");
		}
	}
	@Test(priority = 8)
	public void tcClickOnFatherAlive() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnFatherAlive Test===========");

			studentAdmForm.clickOnFatherAlive();
			
			log.info("============= Finished tcClickOnFatherAlive Test===========");
			getScreenShot("tcClickOnFatherAlive");
		} catch (Exception e) {
			getScreenShot("tcClickOnFatherAlive");
		}
	}
	
	@Test(priority = 9, dataProvider = "AdmissionFormParentData")
	public void tcStudentAdmissionFormParentFather(String Fname, String FSurName, String FAadharNum,
			String FQualification, String FoffAddr, String Foccupation, String FDesignation, String FBankAcNum,
			String FIFSCCode, String FcasteCert, String Fnationality, String FmonthlyIncome, String FAnuualIncome,
			String FmobileNum, String FEmailId, String runMode) {
		studentAdmForm = new StudentAdmissionForm(driver);

		if (runMode.equalsIgnoreCase("mother")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcStudentAdmissionFormParentFather Test===========");

			studentAdmForm.studentAdmissionFormFatherDetails(Fname, FSurName, FAadharNum, FQualification, FoffAddr,
					Foccupation, FDesignation, FBankAcNum, FIFSCCode, FcasteCert, Fnationality, FmonthlyIncome,
					FAnuualIncome, FmobileNum, FEmailId);
			log.info("============= Finished tcStudentAdmissionFormParentFather Test===========");
			getScreenShot("tcStudentAdmissionFormParentFather");
		} catch (Exception e) {
			getScreenShot("tcStudentAdmissionFormParentFather");
		}
	}
	@Test(priority = 10)
	public void tcClickOnMotherAlive() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnMotherAlive Test===========");

			studentAdmForm.clickOnMotherAlive();
			
			log.info("============= Finished tcClickOnMotherAlive Test===========");
			getScreenShot("tcClickOnMotherAlive");
		} catch (Exception e) {
			getScreenShot("tcClickOnMotherAlive");
		}
	}
	@Test(priority = 11, dataProvider = "AdmissionFormParentData")
	public void tcStudentAdmissionFormParentMother(String Mname, String MSurName, String MAadharNum,
			String MQualification, String MoffAddr, String Moccupation, String MDesignation, String MBankAcNum,
			String MIFSCCode, String McasteCert, String Mnationality, String MmonthlyIncome, String MAnuualIncome,
			String MmobileNum, String MEmailId, String runMode) {
		studentAdmForm = new StudentAdmissionForm(driver);

		if (runMode.equalsIgnoreCase("father")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcStudentAdmissionFormParentMother Test===========");

			studentAdmForm.studentAdmissionFormMothersDetails(Mname, MSurName, MAadharNum, MQualification, MoffAddr,
					Moccupation, MDesignation, MBankAcNum, MIFSCCode, McasteCert, Mnationality, MmonthlyIncome,
					MAnuualIncome, MmobileNum, MEmailId);
			log.info("============= Finished tcStudentAdmissionFormParentMother Test===========");
			getScreenShot("tcStudentAdmissionFormParentMother");
		} catch (Exception e) {
			getScreenShot("tcStudentAdmissionFormParentMother");
		}
	}
	@Test(priority = 12)
	public void tcClickOnParentPageNextButton() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnParentPageNextButton Test===========");

			studentAdmForm.clickOnParentPageNextButton();
			
			log.info("============= Finished tcClickOnParentPageNextButton Test===========");
			getScreenShot("tcClickOnParentPageNextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnParentPageNextButton");
		}
	}
	
	@Test(priority = 13)
	public void tcStudentAdmissionFormOthers() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcStudentAdmissionFormOthers Test===========");

			studentAdmForm.studentFormOthers();
			log.info("============= Finished tcStudentAdmissionFormOthers Test===========");
			getScreenShot("tcStudentAdmissionFormOthers");
		} catch (Exception e) {
			getScreenShot("tcStudentAdmissionFormOthers");
		}
	}

	@Test(priority = 14, dataProvider = "AdmissionFormBondData")
	public void bondDetails(String firstBond, String bond2, String bond3, String bondFour, String bondV, String bondVi,
			String bondI, String bondVii, String cardRation, String cardAadhar, String cardPan, String bondBBMP,
			String HDFCbond, String bondDD, String bondSports, String bondGreat, String runMode) throws Exception {
		studentAdmForm = new StudentAdmissionForm(driver);
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting bondDetails Test===========");

			studentAdmForm.bondDetailsOthers(firstBond, bond2, bond3, bondFour, bondV, bondVi, bondI, bondVii,
					cardRation, cardAadhar, cardPan, bondBBMP, HDFCbond, bondDD, bondSports, bondGreat);
			log.info("============= Finished bondDetails Test===========");
			getScreenShot("bondDetails");
		} catch (Exception e) {
			getScreenShot("bondDetails");
		}
	}

	@Test(priority = 15, dataProvider = "AdmissionPreviousSchoolData")
	public void tcPreviousSchoolDetails(String prevSchoolName, String prevSchoolType, String prevClass,
			String prevPercentage, String prevGrade, String prevPassedYr, String prevTotalMarks, String prevBoard,
			String prevCountry, String prevState, String prevAddress, String prevLeftReason, String prevmedium,
			String runMode) {
		studentAdmForm = new StudentAdmissionForm(driver);
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcPreviousSchoolDetails Test===========");

			studentAdmForm.previousSchoolDetails(prevSchoolName, prevSchoolType, prevClass, prevPercentage, prevGrade,
					prevPassedYr, prevTotalMarks, prevBoard, prevCountry, prevState, prevAddress, prevLeftReason,
					prevmedium);
			log.info("============= Finished tcPreviousSchoolDetails Test===========");
			getScreenShot("tcPreviousSchoolDetails");
		} catch (Exception e) {
			getScreenShot("tcPreviousSchoolDetails");
		}
	}

	@Test(priority = 16, dataProvider = "AdmissionGuardianData")
	public void tcGuardianDetails(String guardianName, String guardianAddress, String guadrdianEmail,
			String guardianPhone) {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcGuardianDetails Test===========");

			studentAdmForm.guardianDetails(guardianName, guardianAddress, guadrdianEmail, guardianPhone);
			log.info("============= Finished tcGuardianDetails Test===========");
			getScreenShot("tcGuardianDetails");
		} catch (Exception e) {
			getScreenShot("tcGuardianDetails");
		}
	}

	@Test(priority = 17, dataProvider = "AdmissionSiblingData")
	public void tcSiblingDetails(String SiblingName, String SiblingClass, String SiblingRelation) {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcSiblingDetails Test===========");

			studentAdmForm.siblingDetails(SiblingName, SiblingClass, SiblingRelation);
			log.info("============= Finished tcSiblingDetails Test===========");
			getScreenShot("tcSiblingDetails");
		} catch (Exception e) {
			getScreenShot("tcSiblingDetails");
		}
	}
	@Test(priority = 18)
	public void tcClickOnOthersPageNextButton() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Strting tcClickOnOthersPageNextButton Test===========");

			studentAdmForm.clickOnOthersPageNextButton();
			
			log.info("============= Finished tcClickOnOthersPageNextButton Test===========");
			getScreenShot("tcClickOnOthersPageNextButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOthersPageNextButton");
		}
	}
	@Test(priority = 19)
	public void tcRequiredDocumentsUploladforAdmission() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcRequiredDocumentsUploladforAdmission Test===========");

			studentAdmForm.requiredDocumentsUploladforAdmission();
			log.info("============= Finished tcRequiredDocumentsUploladforAdmission Test===========");
			getScreenShot("tcRequiredDocumentsUploladforAdmission");
		} catch (Exception e) {
			getScreenShot("tcRequiredDocumentsUploladforAdmission");
		}
	}
	@Test(priority = 20)
	public void tcRequiredDetails() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcRequiredDetails Test===========");

			studentAdmForm.requiredDetails();
			log.info("============= Finished tcRequiredDetails Test===========");
			getScreenShot("tcRequiredDetails");
		} catch (Exception e) {
			getScreenShot("tcRequiredDetails");
		}
	}
	@Test(priority = 21)
	public void tcUploadFatherPhotoSignAndFinPrint() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcUploadFatherPhotoSignAndFinPrint Test===========");

			studentAdmForm.uploadFatherPhotoSignAndFinPrint();
			log.info("============= Finished tcUploadFatherPhotoSignAndFinPrint Test===========");
			getScreenShot("tcUploadFatherPhotoSignAndFinPrint");
		} catch (Exception e) {
			getScreenShot("tcUploadFatherPhotoSignAndFinPrint");
		}
	}
	
	@Test(priority = 22)
	public void tcUploadMotherPhotoSignAndFinPrint() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcUploadMotherPhotoSignAndFinPrint Test===========");

			studentAdmForm.uploadMotherPhotoSignAndFinPrint();
			log.info("============= Finished tcUploadMotherPhotoSignAndFinPrint Test===========");
			getScreenShot("tcUploadMotherPhotoSignAndFinPrint");
		} catch (Exception e) {
			getScreenShot("tcUploadMotherPhotoSignAndFinPrint");
		}
	}
	@Test(priority = 23)
	public void tcClickOnSubmitButton() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcClickOnSubmitButton Test===========");

			studentAdmForm.clickOnSubmitButton();
			log.info("============= Finished tcClickOnSubmitButton Test===========");
			getScreenShot("tcClickOnSubmitButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSubmitButton");
		}
	}
	@Test(priority = 23)
	public void tcSuccessMessagevalidation() {
		studentAdmForm = new StudentAdmissionForm(driver);

		try {
			log.info("============= Starting tcSuccessMessagevalidation Test===========");

			boolean status = studentAdmForm.successMessagevalidation();
			if(status){
				studentAdmForm.clickOnSuccessOkButton();
				
			}
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcSuccessMessagevalidation Test===========");
			getScreenShot("tcSuccessMessagevalidation");
		} catch (Exception e) {
			getScreenShot("tcSuccessMessagevalidation");
		}
	}
}
