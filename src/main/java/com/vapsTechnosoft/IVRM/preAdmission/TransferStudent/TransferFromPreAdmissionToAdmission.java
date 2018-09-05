/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.TransferStudent;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TransferFromPreAdmissionToAdmission extends TestBase {

	public static final Logger log = Logger.getLogger(TransferFromPreAdmissionToAdmission.class.getName());

	private WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Transfer Student')][1]")
	private WebElement btn_TransferStudent;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Transfer Student')][1]/following::li[1]")
	private WebElement btn_TransferPreAdmToAdm;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_TransferPreAdmToAdmPage;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYr;

	@FindBy(xpath = "//label[contains(text(),'Class: ')]/following-sibling::div/select")
	private WebElement sel_Class;

	@FindBy(xpath = "//span[contains(text(),'Search')]/parent::button")
	private WebElement btn_Search;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//span[contains(text(),'Export to Admission')]/parent::button")
	private WebElement btn_ExportToAdmission;

	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement input_search;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement search_Validate;
	

	@FindBy(xpath = "//table/thead/tr/th[4]/a")
	private WebElement sort_StudentName;

	@FindBy(xpath = "//table/thead/tr/th[3]/a")
	private WebElement sort_RegNo;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]/label/input")
	private WebElement chk_StudentSelection;
	
	

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btn_Min_Max_TransferPreAdmToAdm;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btn_Min_Max_ListOfStudents;

	public TransferFromPreAdmissionToAdmission(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to PreAdmission > Transfer Student > Transfer pre admission to
	 * admission
	 * 
	 * @throws Exception
	 */
	public void navigateToPreAdmission_TransferPreAdmToAdm() throws Exception {
		if (btn_PreAdmission.isDisplayed()) {
			btn_PreAdmission.click();
			log("Clicked on PreAdmission Button and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(1000);
		} else {
			log("PreAdmission button element not present and object is:-" + btn_PreAdmission.toString());
			Thread.sleep(500);
		}
		if (btn_TransferStudent.isDisplayed()) {
			btn_TransferStudent.click();
			log("Clicked on Transfer Students and object is:-" + btn_TransferStudent.toString());
			Thread.sleep(1000);
		} else {
			log("Transfer Students button element not present and object is:-" + btn_TransferStudent.toString());
			Thread.sleep(500);
		}
		if (btn_TransferPreAdmToAdm.isDisplayed()) {
			btn_TransferPreAdmToAdm.click();
			log("Clicked on Transfer preAdmission to Admission Button and object is:-"
					+ btn_TransferPreAdmToAdm.toString());
			Thread.sleep(1000);
		} else {
			log("Transfer preAdmission to Admission button element not present and object is:-"
					+ btn_TransferPreAdmToAdm.toString());
			Thread.sleep(500);
		}

	}

	/**
	 * Validation of PreAdmission > Transfer Student > Transfer preAdmission to
	 * Admission screen message
	 * 
	 * @return
	 */
	public boolean verifyPreAdmission_TransferpreAdmissionToAdmissionPage() {
		try {
			System.out.println(txt_TransferPreAdmToAdmPage.getText().trim());
			txt_TransferPreAdmToAdmPage.isDisplayed();
			log("Transfer Student page is dispalyed and object is:-" + txt_TransferPreAdmToAdmPage.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_TransferPreAdmToAdmissionForm() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Submit blank Transfer preAdmission to Admission form and object is:-" + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search to get records button element not present and object is:-" + btn_Search.toString());
			Thread.sleep(500);
		}
	}

	/**
	 * Transfer preAdmission to Admission form
	 * 
	 * @param academicYear
	 * @param class_status
	 * @throws Exception
	 */
	public void fill_TransferpreAdmissionToAdmissionForm(String academicYear, String class_status) throws Exception {

		if (sel_AcademicYr.isDisplayed()) {
			select = new Select(sel_AcademicYr);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYr.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(1000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (sel_Class.isDisplayed()) {
			select = new Select(sel_Class);
			select.selectByVisibleText(class_status);

			log("Selected Class: " + class_status + " and object is:- " + sel_Class.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), class_status);
			Thread.sleep(1000);
		} else {
			log("Class element is not present and object is:- " + sel_Class.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnSearchTo_GetRecords() throws Exception {
		if (btn_Search.isDisplayed()) {
			btn_Search.click();
			log("Submit filled Transfer preAdmission to Admission form and object is:-" + btn_Search.toString());
			Thread.sleep(2000);
		} else {
			log("Search to get records button element not present and object is:-" + btn_Search.toString());
			Thread.sleep(500);
		}
	}

	public void clickOnCancelTo_ClearFilledData_Status() throws Exception {
		if (btn_Cancel.isDisplayed()) {
			btn_Cancel.click();
			log("Clear filled form and object is:-" + btn_Cancel.toString());
			Thread.sleep(2000);
		} else {
			log("Cancel button element not present and object is:-" + btn_Cancel.toString());
			Thread.sleep(500);
		}
	}

	public void searchForStudent_InListOfStudents(String regNumber) throws Exception {
		if (input_search.isDisplayed()) {
			input_search.clear();
			input_search.sendKeys(regNumber);
			log("Entered Student name:-" + regNumber + " and object is " + input_search.toString());
			Thread.sleep(1000);
		} else {
			log("Search element in List Of Students not present and object is:-" + input_search.toString());
			Thread.sleep(500);
		}
		if(search_Validate.isDisplayed()){
			String regName = search_Validate.getText().trim();
			assertEquals(regNumber, regName);
			log("First Registration Number and searched with Registration Number is same and object is:-"+search_Validate.toString());
			Thread.sleep(1000);		
		}
	}
	// Search only working for first name not for full name which is appear in
	// the grid

	public void sortWithStudentNameInStatusDetails() throws Exception {

		if (sort_StudentName.isDisplayed()) {
			sort_StudentName.click();
			Thread.sleep(1000);
			sort_StudentName.click();
			log("Sort by Student Name in List Of Students and object is:- " + sort_StudentName.toString());
			Thread.sleep(1000);
		} else {
			log("Student Name button element not present in List Of Students and object is:- "
					+ sort_StudentName.toString());
			Thread.sleep(500);
		}
	}

	public void sortWithRegistrationNumberInStatusDetails() throws Exception {

		if (sort_RegNo.isDisplayed()) {
			sort_RegNo.click();
			log("Sort by Registration Number in List Of Students and object is:- " + sort_RegNo.toString());
			Thread.sleep(1000);
		} else {
			log("Registration Number button element not present in List Of Students and object is:- "
					+ sort_RegNo.toString());
			Thread.sleep(500);
		}
	}
	
	public void clickOnExportToAdmission() throws Exception {
		if (btn_ExportToAdmission.isDisplayed()) {
			btn_ExportToAdmission.click();
			log("Export To Admission Report button is clicked to transfer student and object is:-"
					+ btn_ExportToAdmission.toString());
			Thread.sleep(10000);
		} else {
			log("Export To Admission button element is not present and object is:-" + btn_ExportToAdmission.toString());
			Thread.sleep(500);
		}
	}
	/**
	 * click on OK button after Saving, Cancel Pop Up, Activation and
	 * De-activation of the record
	 * 
	 * @throws Exception
	 */
	public void clickOnSuccessOkBtn() throws Exception {
		if (btnOKSuccess.isDisplayed()) {
			btnOKSuccess.click();
			log("clicked on OK button and object is:-" + btnOKSuccess.toString());
			Thread.sleep(3000);
		} else {
			log("OK button Element not present");
			Thread.sleep(500);
		}
	}
	public void selectSpecificStudent_InListOfStudentToTransfer() throws Exception {
		if (!chk_StudentSelection.isSelected()) {
			chk_StudentSelection.click();
			log("First Records check box is selected in List of students and object is:-" + chk_StudentSelection.toString());
			Thread.sleep(1000);
		} else {
			log("First Records check box element is already selected in List of students and object is:-"
					+ chk_StudentSelection.toString());
			Thread.sleep(500);
		}		
	}
	public void min_Max_TransferPreAdmToAdmForm() throws Exception {
		if (btn_Min_Max_TransferPreAdmToAdm.isDisplayed()) {
			btn_Min_Max_TransferPreAdmToAdm.click();
			log("Transfer PreAdm To Adm Form section minimized or maximized and object is:-"
					+ btn_Min_Max_TransferPreAdmToAdm.toString());
			Thread.sleep(1000);
		} else {
			log("Transfer PreAdm To Adm Form Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_TransferPreAdmToAdm.toString());
		}
	}

	public void min_Max_ListOfStudents() throws Exception {
		if (btn_Min_Max_ListOfStudents.isDisplayed()) {
			btn_Min_Max_ListOfStudents.click();
			log("List Of Students section minimized or maximized and object is:-"
					+ btn_Min_Max_ListOfStudents.toString());
			Thread.sleep(1000);
		} else {
			log("List Of Students Minimize OR Maximize Element not present and object is:-"
					+ btn_Min_Max_ListOfStudents.toString());
		}
	}
	
}
