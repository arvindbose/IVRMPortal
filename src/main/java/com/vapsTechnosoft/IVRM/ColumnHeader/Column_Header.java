package com.vapsTechnosoft.IVRM.ColumnHeader;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Arvind
 *
 */
public class Column_Header {
	public static ArrayList<String> getColumns(List<WebElement> xpath) throws InterruptedException {

		List<WebElement> allHeaders = xpath;

		List<String> columnHeaderArray = new ArrayList<String>();

		for (WebElement header : allHeaders) {

			columnHeaderArray.add(header.getText());

		}
		System.out.println(columnHeaderArray);
		return (ArrayList<String>) columnHeaderArray;
	}

}
