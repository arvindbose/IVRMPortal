/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

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
public class Masters_Class_Teacher_Mapping extends TestBase{
	
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[21]")
	WebElement btnMasters_ClassTeacherMapp;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_ClassTeacherMappMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;
	
	@FindBy(xpath = "//span[contains(text(),'Exchange')]/parent::button")
	WebElement btnExchange;
	
	@FindBy(xpath = "//select[@name='acd']")
	WebElement selAcademicYear;

	@FindBy(xpath = "//select[@id='sel13']")
	WebElement selClass;
	
	@FindBy(xpath = "//select[@id='sel2']")
	WebElement selSection;
	
	@FindBy(xpath = "//select[@id='sel14']")
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
	
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;
	
	@FindBy(xpath = "//span[contains(text(),'Save Data For Changing The Class Teacher')]/parent::button")
	WebElement btnSavexnge;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement btnxngeClose;
	

	
	
	public Masters_Class_Teacher_Mapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(7000);
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
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_ClassTeacherMapp);

		btnMasters_ClassTeacherMapp.click();
		log("Clicked on Class Teacher Mapp Button and object is:-" + btnMasters_ClassTeacherMapp.toString());
		waitForElement(driver, 10, btnSave);
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
			log("Class Teacher Mapp page is dispalyed and object is:-" + txtMasters_ClassTeacherMappMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	public void selectClassTeacherMappingData(String academicYr, String class_Map, String section, String staff_Teacher) throws Exception{
		
		select = new Select(selAcademicYear);
		select.selectByVisibleText(academicYr);
		log("selected academic year: " + academicYr + " and object is:- " + selAcademicYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), academicYr);
		Thread.sleep(1000);
		
		select = new Select(selClass);
		select.selectByVisibleText(class_Map);
		log("selected class: " + class_Map + " and object is:- " + selClass.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), class_Map);
		Thread.sleep(1000);
		
		select = new Select(selSection);
		select.selectByVisibleText(section);
		log("selected section: " + section + " and object is:- " + selSection.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), section);
		Thread.sleep(1000);
		
		select = new Select(selStaff);
		select.selectByVisibleText(staff_Teacher);
		log("selected staff: " + staff_Teacher + " and object is:- " + selStaff.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), staff_Teacher);
		Thread.sleep(1000);
	}
	
	public void classTeacherXchange() throws Exception{
		
		btnExchange.click();
		log("Xchange of teacher class pop up window opened and object is:- "+btnExchange.toString());
		Thread.sleep(5000);
	}
	
	public void selectTeacherClassXchangeData(String staff1, String staff2) throws Exception{
		
		select = new Select(selStaff1xnge);
		select.selectByVisibleText(staff1);
		log("selected staff1: " + staff1 + " and object is:- " + selStaff1xnge.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), staff1);
		Thread.sleep(1000);
		
		select = new Select(selStaff2xnge);
		select.selectByVisibleText(staff2);
		log("selected staff2: " + staff2 + " and object is:- " + selStaff2xnge.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), staff2);
		Thread.sleep(1000);
		}
	
	public void closeXchangePopUpWindow() throws Exception{
		
		btnxngeClose.click();
		log("Opened teacher class xchange windows closed and object is:- "+btnxngeClose.toString());
		Thread.sleep(5000);
	}
	
	public void saveTeacherClassXchangeData() throws Exception{
		btnSavexnge.click();
		log("Teacher class xchange done and object is:- "+btnSavexnge.toString());
		Thread.sleep(10000);
	}

	public void submitBlankClassTeacherMappForm() throws Exception {

		btnSave.click();
		log("Submit blank Class Teacher Mapp form and object is:-" + btnSave.toString());
		Thread.sleep(3000);
	}
	
	public void clearClassTeacherMappInfoData() throws Exception{
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Class Teacher Mapp info and object is:-"+btnCancelClear.toString());
		Thread.sleep(15000);
	}
	
	public void saveClassTeacherMappInfoData() throws Exception{
		btnSave.click();
		log("Clicked on save button to save filled Class Teacher Mapp info and object is:-"+btnSave.toString());
		Thread.sleep(15000);
	}
	
	public void searchWithStaffNameInTheGrid(String staffName) throws Exception{
		
		inputSearch.clear();
		inputSearch.sendKeys(staffName);
		log("Enterd staff name to search: "+staffName+" and object is:-"+inputSearch.toString());
		Thread.sleep(2000);
	}
	
	
	public void minimizeClassTeacher() throws Exception {
		btnMin_MaxClassTeacher.click();
		log("clicked on Class Teacher minimize button and object is:-" + btnMin_MaxClassTeacher.toString());
		Thread.sleep(2000);
	}

	public void maximizeClassTeacher() throws Exception {
		btnMin_MaxClassTeacher.click();
		log("clicked on Class Teacher maximize button and object is:-" + btnMin_MaxClassTeacher.toString());
		Thread.sleep(2000);
	}

	public void minimizeClassTeacherMappingTable() throws Exception {

		btnMin_MaxClassTeacherMappingTable.click();
		log("Master Class Teacher Mapping table data minimize and object is:-" + btnMin_MaxClassTeacherMappingTable.toString());
		Thread.sleep(2000);
	}

	public void maximizeClassTeacherMappingTable() throws Exception {

		btnMin_MaxClassTeacherMappingTable.click();
		log("Class Teacher Mapping table data maximized and object is:-" + btnMin_MaxClassTeacherMappingTable.toString());
		Thread.sleep(2000);
	}
	
	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
	
	public void sortByStaffName() throws Exception {
		btnSortByStaffName.click();
		log("Sorted the record with Staff name and object is:-" + btnSortByStaffName.toString());
		Thread.sleep(3000);
	}
	
	public void verifyStaffNameUpdatedInTheGrid(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String staffname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]"))
					.getText().trim();
			System.out.println("Staff Name: " + staffname);
			// Thread.sleep(2000);
			try {
				
				Assert.assertEquals(staffname, staffName);	
				log("Staff name mapped is updated in the record grid.");


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void deactivateClassTeacherMapped(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String staffname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]"))
					.getText();
			System.out.println("Staff Name: " + staffname);
			// Thread.sleep(2000);
			try {
				if (staffname.equalsIgnoreCase(staffName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String deactivetext = deactiveLink.getText().trim();
					Assert.assertEquals("DeActivate", deactivetext);

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the class teacher mapp list grid");

					break;
				} else {
					log("staff name not matched with the class teacher mapp list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateClassTeacherMapped(String staffName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String staffname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[5]"))
					.getText();
			System.out.println("staff name: " + staffname);
			// Thread.sleep(2000);
			try {
				if (staffname.equalsIgnoreCase(staffName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String activetext = activeLink.getText().trim();
					Assert.assertEquals("Activate", activetext);

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the Class Teacher Mapped list grid");

					break;
				} else {
					log("staff name not matched with the Class Teacher Mapped list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}

	public void clickOnCancelButton() throws Exception {

		btnCancel.click();
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}
	
}
