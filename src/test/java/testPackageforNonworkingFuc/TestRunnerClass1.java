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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Caste_Category;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TestRunnerClass1 extends TestBase{

	public static final Logger log = Logger.getLogger(TestRunnerClass1.class.getName());

	
	IvrmPortalLogin ivrmportallogin;
	Masters_Caste_Category mastercastecategory;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "CasteCategorySearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByCasteCategoryName");
		return testRecordsSearch;
	}
	@BeforeClass
	public void setUp() throws IOException {
		init();
		
		ivrmportallogin = new IvrmPortalLogin(driver);
		mastercastecategory = new Masters_Caste_Category(driver);
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
		@Test(priority = 2)
		public void tcNavigateToAdmission_Masters_CasteCategory_BGHS() {

			try {
				log.info("============= Strting tcNavigateToAdmission_Masters_CasteCategory_BGHS Test===========");

				mastercastecategory.navigateToAdmission_Masters_CasteCategory_BGHS();

				log.info("============= Finished tcNavigateToAdmission_Masters_CasteCategory_BGHS Test===========");
				getScreenShot("tcNavigateToAdmission_Masters_CasteCategory_BGHS");
			} catch (Exception e) {
				getScreenShot("tcNavigateToAdmission_Masters_CasteCategory_BGHS");
			}
		}
		@Test(priority = 3)
		public void tcSortingOfElement() {

			try {
				log.info("============= Strting tcSortingOfElement Test===========");

				ivrmportallogin.sortingOfElement();

				log.info("============= Finished tcSortingOfElement Test===========");
				getScreenShot("tcSortingOfElement");
			} catch (Exception e) {
				getScreenShot("tcSortingOfElement");
			}
		}
		@Test(priority = 4, dataProvider = "CasteCategorySearchData")
		public void tcSearchWithCasteCategoryNameInTheGrid(String casteCategoryName, String runMode) {
			Masters_Caste_Category mastercastecategory= new Masters_Caste_Category(driver);
			if (runMode.equalsIgnoreCase("n")) {
				throw new SkipException("user marked this record as no run");
			}
			try {
				log.info("============= Strting tcSearchWithCasteCategoryNameInTheGrid Test===========");

				mastercastecategory.searchWithCasteCategoryNameInTheGrid(casteCategoryName);

				log.info("============= Finished tcSearchWithCasteCategoryNameInTheGrid Test===========");
				getScreenShot("tcSearchWithCasteCategoryNameInTheGrid");
			} catch (Exception e) {
				getScreenShot("tcSearchWithCasteCategoryNameInTheGrid");
			}
		}
		
		@Test(priority = 5)
		public void tcGetHeaderData_ExcelValueCompare() {
			Masters_Caste_Category mastercastecategory= new Masters_Caste_Category(driver);
			try {
				log.info("============= Strting tcGetHeaderData_ExcelValueCompare Test===========");

				mastercastecategory.validateGrid_ColumnHeader();

				log.info("============= Finished tcGetHeaderData_ExcelValueCompare Test===========");
				getScreenShot("tcGetHeaderData_ExcelValueCompare");
			} catch (Exception e) {
				getScreenShot("tcGetHeaderData_ExcelValueCompare");
			}
		}
		@Test(priority = 6)
		public void tcGetRowData_ExcelValueCompare() {
			Masters_Caste_Category mastercastecategory= new Masters_Caste_Category(driver);
			try {
				log.info("============= Strting tcGetRowData_ExcelValueCompare Test===========");

				mastercastecategory.validateGrid_RowValue();

				log.info("============= Finished tcGetRowData_ExcelValueCompare Test===========");
				getScreenShot("tcGetRowData_ExcelValueCompare");
			} catch (Exception e) {
				getScreenShot("tcGetRowData_ExcelValueCompare");
			}
		}
}
