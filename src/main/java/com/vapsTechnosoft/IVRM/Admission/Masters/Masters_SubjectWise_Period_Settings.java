/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class Masters_SubjectWise_Period_Settings extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_SubjectWise_Period_Settings.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[6]")
	WebElement btnMasters_SubjectWisePeriodSettings;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_SubjectWisePeriodSettingsMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//select[@id='sel1'])[1]")
	WebElement selAcademicYear;

	@FindBy(xpath = "(//select[@id='sel1'])[2]")
	WebElement sel_Class;

	@FindBy(xpath = "//span[contains(text(),'Susdiny Section')]/preceding-sibling::input")
	WebElement chk_Section;

	@FindBy(xpath = "//body[@id='style-4']//div/input")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxSubjectPeriodSetting;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxSubjectPeriodSettingDetails;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;
	
	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortBySubjectName;
	

	public Masters_SubjectWise_Period_Settings(WebDriver driver) {
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
	 * Navigate to Admission Masters Subject wise period settings
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_SubjectWisePeriodSettings_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_SubjectWisePeriodSettings);

		btnMasters_SubjectWisePeriodSettings.click();
		log("Clicked on Subject wise period settings Button and object is:-"
				+ btnMasters_SubjectWisePeriodSettings.toString());
		waitForElement(driver, 10, btnSave);

	}

	/**
	 * Validation of masters Subject wise period settings screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_SubjectWisePeriodSettings_BGHSPage() {
		try {
			System.out.println(txtMasters_SubjectWisePeriodSettingsMsgDispaly.getText());
			txtMasters_SubjectWisePeriodSettingsMsgDispaly.isDisplayed();
			log("Subject wise period settings page is dispalyed and object is:-"
					+ txtMasters_SubjectWisePeriodSettingsMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterSubjectWisePeriodSettingsData(String academicYear, String className)
			throws Exception {
		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txtMasters_SubjectWisePeriodSettingsMsgDispaly);
			Thread.sleep(2000);
		
		Select dropdown = new Select(selAcademicYear);
		WebElement dropdownOption = dropdown.getFirstSelectedOption();
		String SelectedContent = dropdownOption.getText().trim();
		System.out.println("selected Value " + SelectedContent);
		Assert.assertEquals(SelectedContent, academicYear);
		log("Disabled selected academic year: " + SelectedContent + " and object is:- " + selAcademicYear.toString());
		Thread.sleep(1000);

		select = new Select(sel_Class);
		select.selectByVisibleText(className);
		log("selected class: " + className + " and object is:- " + sel_Class.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), className);
		Thread.sleep(1000);

		if (!chk_Section.isSelected()) {
			chk_Section.click();
			log("Section check box is checked and object is:-" + chk_Section.toString());
			Thread.sleep(1000);
		} else {
			log("Section check box is already checked and object is:-" + chk_Section.toString());
			Thread.sleep(1000);
		}

	}
	
public void searchWithSujectCodeToUpdateMaxPeriod(String subjectCode){
		
		inputSearch.clear();
		inputSearch.sendKeys(subjectCode);
		log("Enterd subject code to search: "+subjectCode+" and object is:-"+inputSearch.toString());
	}
	

	public void submitBlankSubjectWisePeriodSettingsForm() throws Exception {

		btnSave.click();
		log("Submit blank Subject wise period settings form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void clearSubjectWisePeriodSettingsInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on clear button to clear filled Subject wise period settings info and object is:-"
				+ btnCancelClear.toString());
		Thread.sleep(10000);
	}

	public void submitFilledSubjectWisePeriodSettingsForm() throws Exception {

		btnSave.click();
		log("Save filled Subject wise period settings form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeSubjectPeriodSetting() throws Exception {
		btnMin_MaxSubjectPeriodSetting.click();
		log("clicked on Subject wise period settings minimize button and object is:-"
				+ btnMin_MaxSubjectPeriodSetting.toString());
		Thread.sleep(2000);
	}

	public void maximizeSubjectPeriodSetting() throws Exception {
		btnMin_MaxSubjectPeriodSetting.click();
		log("clicked on Subject wise period settings maximize button and object is:-"
				+ btnMin_MaxSubjectPeriodSetting.toString());
		Thread.sleep(2000);
	}

	public void minimizeSubjectPeriodSettingDetails() throws Exception {

		btnMin_MaxSubjectPeriodSettingDetails.click();
		log("Subject wise period settings details data minimize and object is:-"
				+ btnMin_MaxSubjectPeriodSettingDetails.toString());
		Thread.sleep(2000);
	}

	public void maximizeSubjectPeriodSettingDetails() throws Exception {

		btnMin_MaxSubjectPeriodSettingDetails.click();
		log("Subject wise period settings details data maximized and object is:-"
				+ btnMin_MaxSubjectPeriodSettingDetails.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}
	public void sortBySubjectName() throws Exception {
		btnSortBySubjectName.click();
		log("Sorted the record with Subject Name and object is:-" + btnSortBySubjectName.toString());
		Thread.sleep(3000);
	}


	public void updateWithMaxPeriodForSpecificSubjectData(String maxPeriod) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			WebElement maxperiod = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/input"));

			maxperiod.clear();
			maxperiod.sendKeys(maxPeriod);
			Thread.sleep(2000);
			log("Entered max period held " + maxPeriod + " for the searched subject.");

		}
	}

}
