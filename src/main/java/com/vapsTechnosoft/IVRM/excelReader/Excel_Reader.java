package com.vapsTechnosoft.IVRM.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * 
 * @author Arvind
 *
 */
public class Excel_Reader {
	// public static final Logger log =
	// Logger.getLogger(Excel_Reader.class.getName());
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public static XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public Excel_Reader() {

	}

	public Excel_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method will return 2D object Data for each record in excel sheet.
	 * 
	 * @param sheetName
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings({ "deprecation" })
	public String[][] getDataFromSheet(String sheetName, String ExcelName) {
		String dataSets[][] = null;
		try {
			// get sheet from excel workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow - 1][totalColumn];
			// Run for loop and store data in 2D array
			// This for loop will run on rows
			for (int i = 1; i < totalRow; i++) {
				XSSFRow rows = sheet.getRow(i);
				// This for loop will run on columns of that row
				for (int j = 0; j < totalColumn; j++) {
					// get Cell method will get cell
					XSSFCell cell = rows.getCell(j);

					// If cell of type String , then this if condition will work
					if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						dataSets[i - 1][j] = cell.getStringCellValue();
					// If cell of type Number , then this if condition will work
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getNumericCellValue());
						dataSets[i - 1][j] = cellText;
					} else
						// If cell of type boolean , then this if condition will
						// work
						dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
				}

			}
			return dataSets;
		} catch (Exception e) {
			System.out.println("Exception in reading Xlxs file" + e.getMessage());
			e.printStackTrace();
		}
		return dataSets;
	}

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
					break;
				}
			}
			row = sheet.getRow(rowNum - 1);

			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//
	public static ArrayList<String> getXLData(String filePath, String columnName, String sheetName)
			throws InterruptedException, IOException {

		ArrayList<String> cellArray = new ArrayList<String>();
		FileInputStream file = null;

		try {
			// String path = System.getProperty("user.dir") +
			// "/src/main/java/com/vapsTechnosoft/IVRM/data/"+filePath;
			file = new FileInputStream(new File(".").getCanonicalPath()
					+ "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\data\\" + filePath);

			workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int colNum = sheet.getRow(0).getLastCellNum();
			for (int coulunCount = 0; coulunCount < colNum; coulunCount++) {
				if ((sheet.getRow(0).getCell(coulunCount).getStringCellValue()).equals(columnName)) {

					for (int i = 1; i <= (sheet.getLastRowNum()); i++) {
						if ((sheet.getRow(i).getCell(coulunCount)) != null) {
							cellArray.add(sheet.getRow(i).getCell(coulunCount).getStringCellValue());
						}
					}
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			file.close();
		}
		return cellArray;
	}

	public static ArrayList<String> getXLData_Dwn(String filePath, String columnName, String sheetName)
			throws InterruptedException, IOException {

		ArrayList<String> cellArray = new ArrayList<String>();
		FileInputStream file = null;

		try {
			// String path = System.getProperty("user.dir") +
			// "/src/main/java/com/vapsTechnosoft/IVRM/data/"+filePath;
			file = new FileInputStream(new File(".").getCanonicalPath()
					+ "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\" + filePath);

			HSSFWorkbook workbook2 = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook2.getSheet(sheetName);
			int colNum = sheet.getRow(0).getLastCellNum();
			for (int coulunCount = 0; coulunCount < colNum; coulunCount++) {
				if ((sheet.getRow(0).getCell(coulunCount).getStringCellValue()).equals(columnName)) {

					for (int i = 1; i <= (sheet.getLastRowNum()); i++) {
						if ((sheet.getRow(i).getCell(coulunCount)) != null) {
							cellArray.add(sheet.getRow(i).getCell(coulunCount).getStringCellValue());
						}
					}
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			file.close();
		}
		return cellArray;
	}

	public static ArrayList<String> getXLData_DownLoadFile(String filePath, String columnName, String sheetName)
			throws InterruptedException, IOException {

		ArrayList<String> cellArray = new ArrayList<String>();
		FileInputStream file = null;

		try {

			file = new FileInputStream(new File(".").getCanonicalPath()
					+ "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\" + filePath);

			HSSFWorkbook workbook1 = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook1.getSheet(sheetName);
			int colNum = sheet.getRow(0).getLastCellNum();
			for (int coulunCount = 0; coulunCount < colNum; coulunCount++) {
				if ((sheet.getRow(0).getCell(coulunCount).getStringCellValue()).equals(columnName)) {

					for (int i = 1; i <= (sheet.getLastRowNum()); i++) {
						if ((sheet.getRow(i).getCell(coulunCount)) != null) {
							cellArray.add(sheet.getRow(i).getCell(coulunCount).getStringCellValue());
						}
					}
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			file.close();
		}
		return cellArray;
	}

	/**
	 * Read Excel Row data...
	 * 
	 */
	public static ArrayList<String> getXLDataRowWise(String filePath, String sheetName) {

		ArrayList<Object> list = new ArrayList<Object>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> strings = new ArrayList<String>();
		int maxDataCount = 0;

		try {

			FileInputStream file = new FileInputStream(new File(".").getCanonicalPath()
					+ "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\data\\" + filePath);

			// Create Workbook instance holding reference to .xlsx file

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook

			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through each rows one by one

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				// Skip the first row beacause it will be header

				if (row.getRowNum() == 0) {
				
					maxDataCount = row.getLastCellNum();

					//continue;
		

				}

				/**
				 * 
				 * if row is empty then break the loop,do not go further
				 * 
				 */

				if (isRowEmpty(row, maxDataCount)) {

					// Exit the processing

					break;

				}

				ArrayList<Object> singleRows = new ArrayList<Object>();

				// For each row, iterate through all the columns

				for (int cn = 0; cn < maxDataCount; cn++) {

					Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:

						if (DateUtil.isCellDateFormatted(cell)) {

							singleRows.add(new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));

						} else

							singleRows.add(cell.getNumericCellValue());

						break;

					case Cell.CELL_TYPE_STRING:

						singleRows.add(cell.getStringCellValue());

						break;

					case Cell.CELL_TYPE_BLANK:
						singleRows.add(null);
						break;

					default:
						singleRows.add(cell.getStringCellValue());
						

					}

				}

				list.add(singleRows);

			}
			//list.add(list.get(0));
			//list1.add(list.get(0));
			//String str=(String) list.get(0);
				//System.out.println(str);	
				
				for (Object object : list) {
				    strings.add(object != null ? object.toString() : null);
				}
			file.close();

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return strings;

	}

	public static boolean isRowEmpty(Row row, int lastcellno) {

		for (int c = row.getFirstCellNum(); c < lastcellno; c++) {

			Cell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);

			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)

				return false;

		}

		return true;

	}

	public static void main(String[] args) throws Exception, IOException {
		ArrayList<String> list = Excel_Reader.getXLData_Dwn("ExcelName.xls", "Name", "StuName");
		System.out.println("list.size()" + list.size());
		System.out.println(list);
		
		
TestBase tb = new TestBase();

		
		ArrayList list1 = Excel_Reader.getXLDataRowWise("AdmissionMasterGridHeader.xlsx", "Header_RowWise");
		System.out.println("Row: " + list1.size());
		System.out.println("Row: " + list1.get(0));
		tb.compareExcelValues_WithRowValues(list, list);
		
		//System.out.println("Row value: " + list1);
		//System.out.println("Row value: " + list1.get(1));	
		
		
	}
}
