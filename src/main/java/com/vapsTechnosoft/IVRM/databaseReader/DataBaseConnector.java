package com.vapsTechnosoft.IVRM.databaseReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class DataBaseConnector {

	private static String dbusername;
	private static String dbpassword;

	// Should be defined as jdbc:mysql://host:port/database name
	private static String databaseURLQA = "jdbc:sqlserver://localhost:1433;databasename=susdinydb";
	private static String databaseURLSTAGE = "jdbc:sqlserver://localhost:1433;databasename=susdinydb";
	private static String databaseURLPRODUCTION = "jdbc:sqlserver://localhost:1433;databasename=susdinydb";

	public static String executeSQLQuery(String testEnv, String sqlQuery) {
		String connectionUrl = "";
		Connection connection;
		String resultValue = "";
		ResultSet rs;

		// To connect with QA Database
		if (testEnv.equalsIgnoreCase("QA")) {
			connectionUrl = databaseURLQA;
			dbusername = "sa";
			dbpassword = "root";
		}
		// To connect with Stage Database
		else if (testEnv.equalsIgnoreCase("STAGE")) {
			connectionUrl = databaseURLSTAGE;
			dbusername = "sa";
			dbpassword = "root";
		}

		// To connect with Production Database
		else if (testEnv.equalsIgnoreCase("PRODUCTION")) {
			connectionUrl = databaseURLPRODUCTION;
			dbusername = "sa";
			dbpassword = "root";
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database...");
			} else {
				System.out.println("Database connection failed to " + testEnv + " Environment");
			}
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQuery);

			try {
				while (rs.next()) {
					resultValue = rs.getString(1).toString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException err) {
				System.out.println("No Records obtained for this specific query");
				err.printStackTrace();
			}
			connection.close();

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

	public static ArrayList<String> executeSQLQuery_List(String testEnv, String sqlQuery) {
		String connectionUrl = "";
		Connection connection;
		ArrayList<String> resultValue = new ArrayList<String>();
		ResultSet resultSet;

		// To connect with QA Database
		if (testEnv.equalsIgnoreCase("QA")) {
			connectionUrl = databaseURLQA;
			dbusername = "sa";
			dbpassword = "root";
		}

		// To connect with Stage Database
		else if (testEnv.equalsIgnoreCase("STAGE")) {
			connectionUrl = databaseURLSTAGE;
			dbusername = "sa";
			dbpassword = "root";
		}

		// To connect with Production Database
		else if (testEnv.equalsIgnoreCase("PRODUCTION")) {
			connectionUrl = databaseURLPRODUCTION;
			dbusername = "sa";
			dbpassword = "root";
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
			} else {
				System.out.println("Failed to connect to " + testEnv + " database");
			}
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);

			try {
				while (resultSet.next()) {
					int columnCount = resultSet.getMetaData().getColumnCount();
					StringBuilder stringBuilder = new StringBuilder();
					for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
						stringBuilder.append(resultSet.getString(iCounter).trim() + " ");
					}
					String reqValue = stringBuilder.substring(0, stringBuilder.length() - 1);
					resultValue.add(reqValue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("No Records found for this specific query" + ex.getStackTrace());
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println("SQL Exception:" + ex.getStackTrace());
					}
				}
			}

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

	public static void main(String[] args) {

		 boolean flag = false;
	        List<String> listOfDBValues = new ArrayList<String>();
		
		String sqlQuery = "select Name from employee";
        String expectedEmpName = "Arvind";
        //Getting employee data by Id
        listOfDBValues = DataBaseConnector.executeSQLQuery_List("QA", sqlQuery);
        System.out.println("Employee data retrieved from database :" + listOfDBValues);
       
        for (String strName : listOfDBValues) {
            if (strName.equalsIgnoreCase(expectedEmpName)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag, "Retrieved values are not matching with Expected values");
    
		
	}
}
