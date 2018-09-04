/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class InterviewSchedule_WrittenTestSchedule extends TestBase{
	
	public static final Logger log = Logger
			.getLogger(InterviewSchedule_WrittenTestSchedule.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]")
	private WebElement btn_PreAdmission;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding::button[1]/following::ul[1]/li[1]")
	private WebElement btn_InterviewSchedule;

	@FindBy(xpath = "//span[contains(text(),'Preadmission')]/preceding-sibling::button/following::span[contains(text(),'Interview Schedule')][1]/following::li[2]")
	private WebElement btn_WrittenTestSchedule;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_PreAdm_writtenTestSchedulePage;

	@FindBy(xpath = "//label[contains(text(),'Schedule Name:')]/following-sibling::div/input")
	private WebElement input_ScheduleName;

	@FindBy(xpath ="//label[contains(text(),'Remarks:')]/following-sibling::div/input")
	private WebElement input_Remarks;

	@FindBy(xpath ="//label[contains(text(),'Supervisor:')]/following-sibling::div/input")
	private WebElement input_Supervisor;

	@FindBy(xpath ="//label[contains(text(),'Skill/Knowledge:')]/following-sibling::div/textarea")
	private WebElement input_Skills;

	// @FindBy(xpath = "//input[@class='md-datepicker-input']")
	// WebElement inputOraltestDate;

	@FindBy(xpath = "(//label[contains(text(),'Date:')]/following-sibling::div//child::button)[1]")
	private WebElement btn_Calender;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]")
	private WebElement btn_MonthYear;

	@FindBy(xpath = "//span[contains(text(),'Sep 2018')]/following::td[27]")
	private WebElement btn_ScheduleDate;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[1]/input")
	private WebElement input_ScheduleTime_FromHr;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[3]/input")
	private WebElement input_ScheduleTime_FromMin;

	@FindBy(xpath = "(//table/tbody)[1]/tr[2]/td[6]/button")
	private WebElement btn_From_AM_PM;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[1]/input")
	private WebElement input_ScheduleTime_ToHr;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[3]/input")
	private WebElement input_ScheduleTime_ToMin;

	@FindBy(xpath = "(//table/tbody)[2]/tr[2]/td[6]/button")
	private WebElement btn_To_AM_PM;
	
	@FindBy(xpath = "//input[@ng-model='search']")
	private WebElement search_Student;
	
	@FindBy(xpath = "(//table/tbody)[3]/tr[1]/td[8]/input")
	private WebElement chk_Student1StuList;
	
	@FindBy(xpath = "(//table/tbody)[3]/tr[2]/td[8]/input")
	private WebElement chk_Student2StuList;
	
	@FindBy(xpath = "(//table/tbody)[5]/tr[2]/td[9]/a")
	private WebElement icon_deleteCart;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	private WebElement btn_Save;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;
	
	@FindBy(xpath = "//input[@ng-model='searchValue']")
	private WebElement search_ScheduleName;
	
}
