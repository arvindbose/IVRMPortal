/**
 * 
 */
package com.vapsTechnosoft.IVRM.loginToVaps;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author arvind
 *
 */
public class TC_LoginToIvrmApp extends TestBase{

	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name="vapsloginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecords;
	}
	

	@BeforeClass
	public void setUp() throws IOException {
     init();
     ivrmportallogin = new IvrmPortalLogin(driver);
	}
	
	@Test(dataProvider="vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		ivrmportallogin = new IvrmPortalLogin(driver);
		if(runMode.equalsIgnoreCase("n")){
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
}
