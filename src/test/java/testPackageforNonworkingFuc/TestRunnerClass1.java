/**
 * 
 */
package testPackageforNonworkingFuc;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TestRunnerClass1 extends TestBase{

	public static final Logger log = Logger.getLogger(TestRunnerClass1.class.getName());

	
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		
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

				log.info("============= Finished loginToappWithrequiredCredentials===========");

				getScreenShot("loginToappWithrequiredCredentials");
			} catch (Exception e) {
				getScreenShot("loginToappWithrequiredCredentials");
			}
		}
	
}
