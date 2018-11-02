package com.vapsTechnosoft.IVRM.sortingGrid;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Arvind
 *
 */
public class Sort_Column_Grid {
	
	LinkedList<String> getTableColumnData(int column_no, WebElement table)
	{
	        LinkedList<String> values = new LinkedList<String>();
	       // WebElement table = getWebDriver().findElement(By.className(tableName));
	 List<WebElement> rows = table.findElements(By.tagName("tr"));
	 Iterator<WebElement> i = rows.iterator();
	 while(i.hasNext())
	 {
	      WebElement row=i.next();
	      List<WebElement> columns= row.findElements(By.tagName("td"));
	      Iterator<WebElement> j = columns.iterator();
	      int count =0;
	      String value;
	      while(j.hasNext())
	      {
	            WebElement column = j.next();
	            if(count == column_no)
	    {
	             String data = column.getText();
	       value = data;
	      values.add(value);
	      break;
	     }
	            count ++;
	               }

	  }

	 return values;
	}

	boolean isTableColumnSorted(LinkedList<String> expected, LinkedList<String> actual)
	{
	 boolean result = false;
	 Collections.sort(expected);
	 if(CollectionUtils.isEqualCollection(expected,actual))
	  result = true;
	 return result;
	}
}
