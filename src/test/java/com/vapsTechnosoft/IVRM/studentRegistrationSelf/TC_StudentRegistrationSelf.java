/**
 * 
 */
package com.vapsTechnosoft.IVRM.studentRegistrationSelf;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.selfRegistration.StudentRegistrationSelf;
import com.vapsTechnosoft.IVRM.testBase.TestBase;


/**
 * Filling of Student registration form using excel data and dataprovider
 * @author arvind
 *
 */
public class TC_StudentRegistrationSelf extends TestBase {

	public static final Logger log = Logger.getLogger(TC_StudentRegistrationSelf.class.getName());	

	StudentRegistrationSelf studentreg;

	@DataProvider(name="registrationData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		return testRecords;
	}
	

	@BeforeClass
	public void setUp() throws IOException {
     init();
     studentreg = new StudentRegistrationSelf(driver);
	}
	@Test(priority=1)
	public void verifyCancelButton(){
		studentreg = new StudentRegistrationSelf(driver);
		
		try {
			log.info("============= Strting verifyCancelButton Test===========");
			
			studentreg.cancelButtonValidation();
	
			log.info("============= Finished verifyCancelButton Test===========");
			getScreenShot("verifyCancelButton");
		} catch (Exception e) {
			getScreenShot("verifyCancelButton");
		}
	}
	@Test(priority=2,dataProvider="registrationData")
	public void fillRegistrationFormWithDifferentStudent(String name, String Email, String mobileNo, 
			String userName, String password, String confirmPass, String runMode) {
		studentreg = new StudentRegistrationSelf(driver);
		
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting fillRegistrationFormWithDifferentStudent Test===========");
			
			studentreg.studentRegistrationForm(name, Email, mobileNo, userName, password, confirmPass);
	
			log.info("============= Finished fillRegistrationFormWithDifferentStudent Test===========");
			getScreenShot("fillRegistrationFormWithDifferentStudent");
		} catch (Exception e) {
			getScreenShot("fillRegistrationFormWithDifferentStudent");
		}
	}
	@Test(priority=3)
	public void verifyRegisterButton(){
		studentreg = new StudentRegistrationSelf(driver);
		
		try {
			log.info("============= Strting verifyRegisterButton Test===========");
			
			studentreg.registerButtonValidation();
	
			log.info("============= Finished verifyRegisterButton Test===========");
			getScreenShot("verifyRegisterButton");
		} catch (Exception e) {
			getScreenShot("verifyRegisterButton");
		}
	}
	@Test(priority=4)
	public void verifySuccessmessageOkButton(){
		studentreg = new StudentRegistrationSelf(driver);
		
		try {
			log.info("============= Strting verifySuccessmessageOkButton Test===========");
			
			studentreg.successmessageValidation();
	
			log.info("============= Finished verifyCancelButton Test===========");
			getScreenShot("verifySuccessmessageOkButton");
		} catch (Exception e) {
			getScreenShot("verifySuccessmessageOkButton");
		}
	}
}
