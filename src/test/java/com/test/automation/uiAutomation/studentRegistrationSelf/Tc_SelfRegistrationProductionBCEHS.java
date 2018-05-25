/**
 * 
 */
package com.test.automation.uiAutomation.studentRegistrationSelf;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.selfRegistration.SelfRegistrationProductionBCEHS;
import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_SelfRegistrationProductionBCEHS extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_SelfRegistrationProductionBCEHS.class.getName());	

	SelfRegistrationProductionBCEHS BCEHS_SelfRegistration;

	@DataProvider(name="registrationData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		return testRecords;
	}
	

	@BeforeClass
	public void setUp() throws IOException {
     init();
     BCEHS_SelfRegistration = new SelfRegistrationProductionBCEHS(driver);
	}
	@Test(priority=1)
	public void verifyCancelButton(){
		BCEHS_SelfRegistration = new SelfRegistrationProductionBCEHS(driver);
		
		try {
			log.info("============= Strting verifyCancelButton Test===========");
			
			BCEHS_SelfRegistration.cancelButtonValidation();
	
			log.info("============= Finished verifyCancelButton Test===========");
			getScreenShot("verifyCancelButton");
		} catch (Exception e) {
			getScreenShot("verifyCancelButton");
		}
	}
	@Test(priority=2,dataProvider="registrationData")
	public void fillRegistrationFormWithDifferentStudent(String name, String Email, String mobileNo, 
			String userName, String password, String confirmPass, String runMode) {
		BCEHS_SelfRegistration = new SelfRegistrationProductionBCEHS(driver);
		
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting fillRegistrationFormWithDifferentStudent Test===========");
			
			BCEHS_SelfRegistration.studentRegistrationForm(name, Email, mobileNo, userName, password, confirmPass);
	
			log.info("============= Finished fillRegistrationFormWithDifferentStudent Test===========");
			getScreenShot("fillRegistrationFormWithDifferentStudent");
		} catch (Exception e) {
			getScreenShot("fillRegistrationFormWithDifferentStudent");
		}
	}
	@Test(priority=3)
	public void verifyRegisterButton(){
		BCEHS_SelfRegistration = new SelfRegistrationProductionBCEHS(driver);
		
		try {
			log.info("============= Strting verifyRegisterButton Test===========");
			
			BCEHS_SelfRegistration.registerButtonValidation();
	
			log.info("============= Finished verifyRegisterButton Test===========");
			getScreenShot("verifyRegisterButton");
		} catch (Exception e) {
			getScreenShot("verifyRegisterButton");
		}
	}
	@Test(priority=4)
	public void verifySuccessmessageOkButton(){
		BCEHS_SelfRegistration = new SelfRegistrationProductionBCEHS(driver);
		
		try {
			log.info("============= Strting verifySuccessmessageOkButton Test===========");
			
			BCEHS_SelfRegistration.successmessageValidation();
	
			log.info("============= Finished verifyCancelButton Test===========");
			getScreenShot("verifySuccessmessageOkButton");
		} catch (Exception e) {
			getScreenShot("verifySuccessmessageOkButton");
		}
	}
}
