/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.Reports;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.preAdmission.PreAdmissionStatus.PreAdmission_Status;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class PreAdmission_StudentCountReport extends TestBase{
	
	public static final Logger log = Logger.getLogger(PreAdmission_StudentCountReport.class.getName());

	private WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_Preadmission_Reports;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[2]")
	private WebElement btn_StudentCountReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_StudentCountReportPage;

	@FindBy(xpath = "//input[@name='yorb' and @value='yearwise']")
	private WebElement rdBtn_YearWise;

	@FindBy(xpath = "//input[@name='yorb' and @value='btwdates']")
	private WebElement rdBtn_BetweenDates;


}
