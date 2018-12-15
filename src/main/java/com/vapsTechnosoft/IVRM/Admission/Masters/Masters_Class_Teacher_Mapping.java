/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Class_Teacher_Mapping extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Class_Teacher_Mapping.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[19]")
	// WebElement btnMasters_ClassTeacherMapp;

	@FindBy(xpath = "//a[@href='#/app/classTeacherMapping/59']")
	WebElement btnMasters_ClassTeacherMapp;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_ClassTeacherMappMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//span[contains(text(),'Exchange')]/parent::button")
	WebElement btnExchange;

	@FindBy(xpath = "//select[@id='sel1' and @name='acd']")
	WebElement selAcademicYear;

	@FindBy(xpath = "//select[@id='sel13' and @name='acd3']")
	WebElement selClass;

	@FindBy(xpath = "//select[@id='sel2' and @name='secname']")
	WebElement selSection;

	@FindBy(xpath = "//select[@id='sel14' and @name='acd4']")
	WebElement selStaff;

	@FindBy(xpath = "//select[@name='acd1234']")
	WebElement selStaff1xnge;

	@FindBy(xpath = "//select[@name='acd12345']")
	WebElement selStaff2xnge;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxClassTeacher;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxClassTeacherMappingTable;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[5]/a")
	WebElement btnSortByStaffName;
	
	@FindBy(xpath = "//table/tbody/tr/td[5]")
	private List<WebElement> list_StaffName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "//span[contains(text(),'Save Data For Changing The Class Teacher')]/parent::button")
	WebElement btnSavexnge;

	@FindBy(xpath = "//button[@class='close']")
	WebElement btnxngeClose;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Class_Teacher_Mapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission Masters class teacher mapping
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_ClassTeacherMapping_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_ClassTeacherMapp);
		log("Clicked on Class Teacher Mapp Button and object is:-" + btnMasters_ClassTeacherMapp.toString());

	}

	/**
	 * Validation of masters Class Teacher Mapp screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_ClassTeacherMapp_BGHSPage() {
		try {
			System.out.println(txtMasters_ClassTeacherMappMsgDispaly.getText());
			txtMasters_ClassTeacherMappMsgDispaly.isDisplayed();
			log("Class Teacher Mapp page is dispalyed and object is:-"
					+ txtMasters_ClassTeacherMappMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void selectClassTeacherMappingData(String academicYr, String class_Map, String section, String staff_Teacher)
			throws Exception {

		selectElementFromDropDown(selAcademicYear, academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());

		selectElementFromDropDown(selClass, class_Map);
		log("selected class: " + class_Map + " and object is:- " + selClass.toString());

		selectElementFromDropDown(selSection, section);
		log("selected section: " + section + " and object is:- " + selSection.toString());

		selectElementFromDropDown(selStaff, staff_Teacher);
		log("selected staff: " + staff_Teacher + " and object is:- " + selStaff.toString());

	}

	public void classTeacherXchange() throws Exception {

		clickOnButton(btnExchange);
		Thread.sleep(2000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Xchange of teacher class pop up window opened and object is:- " + btnExchange.toString());

	}

	public void selectTeacherClassXchangeData(String staff1, String staff2) throws Exception {

		selectElementFromDropDown(selStaff1xnge, staff1);
		log("selected staff1: " + staff1 + " and object is:- " + selStaff1xnge.toString());

		selectElementFromDropDown(selStaff2xnge, staff2);
		log("selected staff2: " + staff2 + " and object is:- " + selStaff2xnge.toString());

	}

	public void closeXchangePopUpWindow() throws Exception {

		clickOnButton(btnxngeClose);
		log("Opened teacher class xchange windows closed and object is:- " + btnxngeClose.toString());
		Thread.sleep(2000);
	}

	public void saveTeacherClassXchangeData() throws Exception {

		clickOnButton(btnSavexnge);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Teacher class xchange done and object is:- " + btnSavexnge.toString());

	}

	public void submitBlankClassTeacherMappForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank Class Teacher Mapp form and object is:-" + btnSave.toString());
		Thread.sleep(1000);
	}

	public void clearClassTeacherMappInfoData() throws Exception {
		clickOnButton(btnCancelClear);
		log("Clicked on clear button to clear filled Class Teacher Mapp info and object is:-"
				+ btnCancelClear.toString());

	}

	public void saveClassTeacherMappInfoData() throws Exception {
		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Class Teacher Mapp info and object is:-" + btnSave.toString());

	}

	public void searchWithStaffNameInTheGrid(String staffName) throws Exception {

		inputTextIntoInputField(inputSearch, staffName);
		log("Enterd staff name to search: " + staffName + " and object is:-" + inputSearch.toString());

	}

	public void minimizeClassTeacher() throws Exception {

		clickOnButton(btnMin_MaxClassTeacher);
		log("clicked on Class Teacher minimize button and object is:-" + btnMin_MaxClassTeacher.toString());

	}

	public void maximizeClassTeacher() throws Exception {

		clickOnButton(btnMin_MaxClassTeacher);
		log("clicked on Class Teacher maximize button and object is:-" + btnMin_MaxClassTeacher.toString());

	}

	public void minimizeClassTeacherMappingTable() throws Exception {

		clickOnButton(btnMin_MaxClassTeacherMappingTable);
		log("Master Class Teacher Mapping table data minimize and object is:-"
				+ btnMin_MaxClassTeacherMappingTable.toString());

	}

	public void maximizeClassTeacherMappingTable() throws Exception {

		clickOnButton(btnMin_MaxClassTeacherMappingTable);
		log("Class Teacher Mapping table data maximized and object is:-"
				+ btnMin_MaxClassTeacherMappingTable.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByStaffName() throws Exception {

		clickOnButton(btnSortByStaffName);
		SortData_InColumn_DescendingOrder(list_StaffName);
		log("Sorted the record with Staff name in descending order and object is:-" + btnSortByStaffName.toString());

	}

	public void verifyStaffNameUpdatedInTheGrid(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String staffname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Staff Name: " + staffname);
				// Thread.sleep(2000);

				if (staffname.equals(staffName)) {
					// Assert.assertEquals(staffname, staffName);
					log("Staff name mapped is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateClassTeacherMapped(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String staffname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]")).getText()
						.trim();
				System.out.println("Staff Name: " + staffname);
				// Thread.sleep(2000);

				if (staffname.equals(staffName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals("DeActivate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the class teacher mapp list grid");

					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activateClassTeacherMapped(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {
				String staffname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]")).getText();
				System.out.println("staff name: " + staffname);
				// Thread.sleep(2000);

				if (staffname.equalsIgnoreCase(staffName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the Class Teacher Mapped list grid");

					break;
				} 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		Assert.assertEquals(btnYesDeleteOrDeactIt.getText().trim(), "Yes, Deactive it!");
		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {
		Assert.assertEquals(btnCancel.getText().trim(), "Cancel");
		clickOnButton(btnCancel);
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Xchange() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Data Exchanged Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_DeactivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deactive Cancelled");
			log("Record Deactive Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_DectivateSuccess_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Deactivated Successfully");
			log("Record Deactivated Successfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_ActivateCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Active Cancelled");
			log("Record Active Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popWindowMessage_ActivateSuccess_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Activated Successfully");
			log("Record Activated Successfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
