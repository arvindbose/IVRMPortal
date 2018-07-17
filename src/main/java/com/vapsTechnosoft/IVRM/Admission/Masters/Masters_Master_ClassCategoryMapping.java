/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Master_ClassCategoryMapping extends TestBase{

	public static final Logger log = Logger.getLogger(Masters_Master_ClassCategoryMapping.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[10]")
	WebElement btnMasters_masterClassCategoryMap;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterClassCategoryMapMsgDispaly;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Clear')]/parent::button")
	WebElement btnClear;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/select)[1]")
	WebElement sel_AcademicYear;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/select)[2]")
	WebElement sel_Category;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/select)[3]")
	WebElement sel_Search;
	
	@FindBy(xpath = "//span[contains(text(),'Pre Nursery')]/preceding-sibling::input")
	WebElement chk_Class;
	
	@FindBy(xpath = "//span[contains(text(),'Susdiny Section')]/preceding-sibling::input")
	WebElement chk_Section;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]")
	WebElement inputSearch;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[2]/following-sibling::span/button")
	WebElement btnSearch;
	
	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterClassCategory;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterClassCategoryList;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;
	
	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByClassCategoryName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;
	
	
	public Masters_Master_ClassCategoryMapping(WebDriver driver) {
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
	 * Navigate to Admission Masters Master Source
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterClassCategoryMapping_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);

		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterClassCategoryMap);

		btnMasters_masterClassCategoryMap.click();
		log("Clicked on master class category mapping Button and object is:-" + btnMasters_masterClassCategoryMap.toString());
		waitForElement(driver, 10, btnSave);
	}

	/**
	 * Validation of masters master source screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterClassCategoryMap_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterClassCategoryMapMsgDispaly.getText());
			txtMasters_MasterClassCategoryMapMsgDispaly.isDisplayed();
			log("Master class category mapping page is dispalyed and object is:-" + txtMasters_MasterClassCategoryMapMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlankMasterClassCategoryMapForm() throws Exception {

		btnSave.click();
		log("Save blank master class Category mapping form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public void enterMasterClassCategoryMappingFormData(String academicYear, String category) throws Exception{
		
		select = new Select(sel_AcademicYear);
		select.selectByVisibleText(academicYear);
		log("selected academic year " + academicYear + " and object is:- " + sel_AcademicYear.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), academicYear);
		Thread.sleep(1000);
		
		if(!chk_Class.isSelected()){
			chk_Class.click();
			log("Class check box is selected and object is:-"+chk_Class.toString());
			Thread.sleep(1000);
		}
		else{
			log("Class check box is already selected and object is:-"+chk_Class.toString());
		}
		
		select = new Select(sel_Category);
		select.selectByVisibleText(category);
		log("selected category " + category + " and object is:- " + sel_Category.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), category);
		Thread.sleep(1000);
		
		if(!chk_Section.isSelected()){
			chk_Section.click();
			log("Section check box is selected and object is:-"+chk_Section.toString());
			Thread.sleep(1000);
		}
		else{
			log("Section check box is already selected and object is:-"+chk_Section.toString());
		}
	}
	
	public void clearMasterClassCategoryMappingInfoData() throws Exception {
		btnClear.click();
		log("Clicked on clear button to clear filled master category and object is:-" + btnClear.toString());
		Thread.sleep(15000);
	}

	public void submitFilledMasterClassCategoryMapForm() throws Exception {

		btnSave.click();
		log("Save filled master category form and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void sortByClassCategoryName() throws Exception {

		btnSortByClassCategoryName.click();
		log("Sorted the record with class Category name and object is:-" + btnSortByClassCategoryName.toString());
		Thread.sleep(3000);
	}
	
	public void searchWithClassCategoryNameInTheGrid(String categoryName, String selectFilter) throws InterruptedException {

		inputSearch.clear();
		inputSearch.sendKeys(categoryName);
		log("Entered class category name to search: " + categoryName + " and object is:-" + inputSearch.toString());
	
		select = new Select(sel_Search);
		select.selectByVisibleText(selectFilter);
		log("selected filter for search " + selectFilter + " and object is:- " + sel_Search.toString());
		Thread.sleep(1000);

		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText(), selectFilter);
		Thread.sleep(1000);
		
		btnSearch.click();
		log("Clicked search button to filter the item and object is:-"+btnSearch.toString());
		Thread.sleep(1000);
	
	}
	/**
	 * Sorting issue (Modification required)
	 * 
	 * @param categoryName
	 * @param selectFilter
	 */
	public void verifyClassCategoryNameInTheGrid(String categoryName, String selectFilter) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classcategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Class Category Name: " + classcategoryname);
			// Thread.sleep(2000);
			try {
				if (classcategoryname.equalsIgnoreCase(categoryName)) {

				Assert.assertEquals(classcategoryname, categoryName);
				log("Class category name created is updated in the record grid.");
				break;
				} else {
					log("Class Category Name not matched with the master class category list grid");
					// Thread.sleep(1000);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeMasterClassCategory() throws Exception {
		btnMin_MaxMasterClassCategory.click();
		log("clicked on master class Category minimize button and object is:-" + btnMin_MaxMasterClassCategory.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterClassCategory() throws Exception {
		btnMin_MaxMasterClassCategory.click();
		log("clicked on master class Category maximize button and object is:-" + btnMin_MaxMasterClassCategory.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterClassCategoryList() throws Exception {

		btnMin_MaxMasterClassCategoryList.click();
		log("Master class Category list table data minimize and object is:-" + btnMin_MaxMasterClassCategoryList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterClassCategoryList() throws Exception {

		btnMin_MaxMasterClassCategoryList.click();
		log("Master Class Category list table table data maximized and object is:-"
				+ btnMin_MaxMasterClassCategoryList.toString());
		Thread.sleep(2000);
	}

	public void editMasterClassCategory(String categoryName, String selectFilter) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classcategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Class Category Name: " + classcategoryname);
			// Thread.sleep(2000);
			try {
				if (classcategoryname.equalsIgnoreCase(categoryName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/a")).click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master class category list grid to edit record");

					break;
				} else {
					log("Class Category Name not matched with the master class category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void deactivateMasterClassCategory(String categoryName, String selectFilter) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classcategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Class Category Name: " + classcategoryname);
			// Thread.sleep(2000);
			try {
				if (classcategoryname.equalsIgnoreCase(categoryName)) {

					WebElement deactiveLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String deactivetext = deactiveLink.getText();
					Assert.assertEquals(deactivetext, "Deactivate");

					deactiveLink.click();
					Thread.sleep(5000);
					log("Clicked on the deactivate link in the master class category list grid");

					break;
				} else {
					log("Class Category Name not matched with the master class category list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void activateMasterClassCategory(String categoryName, String selectFilter) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String classcategoryname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Class category Name: " + classcategoryname);
			// Thread.sleep(2000);
			try {
				if (classcategoryname.equalsIgnoreCase(categoryName)) {

					WebElement activeLink = driver
							.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[6]/span"));
					String activetext = activeLink.getText();
					Assert.assertEquals(activetext, "Activate");

					activeLink.click();
					Thread.sleep(5000);
					log("Clicked on the activate link in the master class category list grid");

					break;
				} else {
					log("Category Name not matched with the master class category list grid");
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

		btnPopUpCancel.click();
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(15000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}


}
