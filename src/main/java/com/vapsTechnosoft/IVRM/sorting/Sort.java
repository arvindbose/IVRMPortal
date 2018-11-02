package com.vapsTechnosoft.IVRM.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * 
 * @author Arvind
 *
 */
public class Sort extends TestBase{
	WebDriver driver;
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public void Sort_ColumnData_DescendingOrder(List<WebElement> elementList) {
	try{
		ArrayList<String> obtainedList = new ArrayList<>();
		System.out.println(obtainedList);
		// List<WebElement> elementList=
		// driver.findElements(By.xpath(YourLocator));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText().toLowerCase().trim());
			
		}
		log("List of element for sorting after clicking on header: "+obtainedList.toString());
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s.toLowerCase().trim());
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		log("List of element Sorted in Descending order: "+sortedList.toString());
		System.out.println(obtainedList);
		System.out.println(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}
	catch(Exception e){
		System.out.println("Exception in Sorting element" + e.getMessage());
		e.printStackTrace();
	}
	}
	public void Sort_ColumnData_AscendingOrder(List<WebElement> elementList) {
		try{
			ArrayList<String> obtainedList = new ArrayList<>();
			System.out.println(obtainedList);
			// List<WebElement> elementList=
			// driver.findElements(By.xpath(YourLocator));
			for (WebElement we : elementList) {
				obtainedList.add(we.getText().toLowerCase().trim());
			}
			log("List of element for sorting after clicking on header: "+obtainedList.toString());
			ArrayList<String> sortedList = new ArrayList<>();
			for (String s : obtainedList) {
				sortedList.add(s.toLowerCase().trim());
			}

			Collections.sort(sortedList);
			log("List of element Sorted in Ascending order: "+sortedList.toString());
			System.out.println(obtainedList);
			System.out.println(sortedList);
			Assert.assertTrue(sortedList.equals(obtainedList));
		}
		catch(Exception e){
			System.out.println("Exception in Sorting element" + e.getMessage());
			e.printStackTrace();
		}
		}
}
