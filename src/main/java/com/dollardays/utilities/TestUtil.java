package com.dollardays.utilities;



import java.lang.reflect.Method;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;



public class TestUtil {

	public static Logger APPLICATION_LOGS = Logger.getLogger(TestUtil.class);
	
	@DataProvider(name="dd-dataprovider")
	public static Object[][] getTestData(ITestContext context, Method metod){
		DDDataProvider params = metod.getAnnotation(DDDataProvider.class);
		Object obj[][] = getData(params.datafile(), params.sheetName(), params.testcaseID(), params.runmode());
		return obj;
	}

	// Function to check is Test Executable or not
	public static boolean isExecutable(Xls_Reader xlsfile, String sheet,String testName) {
		try {
			for (int rowNum = 2; rowNum<= xlsfile.getRowCount(sheet); rowNum++) {
				if (xlsfile.getCellData(sheet, "TCID", rowNum).equals(testName)) {
					if (xlsfile.getCellData(sheet, "Runmode", rowNum).equalsIgnoreCase("yes"))
						return true;
					else
						return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Function to to check the RunMode of Test
	public static void checkRunMode(String sheetName, String testName,String file) {
		 Xls_Reader xls = new Xls_Reader(file, sheetName);

		if (!TestUtil.isExecutable(xls, sheetName, testName))
			throw new SkipException("Test not found");
	}

	// Function to get Test Data form Excel File for a particular Test case
	public static Object[][] getData(String file ,String sheetName, String testName,String testMode) {
		

		Xls_Reader xlsData = new Xls_Reader(file, sheetName);
		Object[][] data = null;
		Hashtable<String, String> datatable = null;	
		System.out.println("rowcount"+xlsData.getRowCount(sheetName));
		System.out.println("\n colcount"+xlsData.getColumnCount(sheetName));
		
		if(testName !=null && !testName.isEmpty())
		{
			int testStartRow = -1;
			data = new Object [1] [1];
			// To find the Row Number from where our Test is being start
			for (int rNum = 1; rNum<= xlsData.getRowCount(sheetName); rNum++) {
				if (xlsData.getCellData(sheetName, "TCID", rNum).equalsIgnoreCase(testName)) 
				{
					testStartRow = rNum;
					APPLICATION_LOGS.debug("Test Case " + testName+ " starts from Row Number " + testStartRow + "in sheet" + sheetName);
					break;
				}
			}			
			if (testStartRow >= 0){
				datatable = new Hashtable<String, String>();
				datatable.put("SheetName", sheetName);
				for(int col = 0; col < xlsData.getColumnCount(sheetName); col++) {
					datatable.put(xlsData.getCellData(sheetName, col, 1), xlsData.getCellData(sheetName, col, testStartRow));
					System.out.print(xlsData.getCellData(sheetName, col, testStartRow) +" ");
				}
				/* It will put the Data into the Table for Each row and then 
				 * put the table inside the Two dimensional Array
				*/
				data[0][0]=datatable;
			}
			else {
				APPLICATION_LOGS.error("Data is not provided properly");
			}			
		}
		//if Test mode only provided
		else if(testMode !=null && !testMode.isEmpty())
		{  
			int dataIndex =0;	
		   
			int testStartRow=0;
			
			// To find the Row Number from where our Test is being start
			for (int rNum = 2; rNum<= xlsData.getRowCount(sheetName); rNum++)
			{
				 if (xlsData.getCellData(sheetName, "Runmode", rNum).equalsIgnoreCase(testMode)) 
				 {
					testStartRow ++;
				 }
			}
			// intiailse the object array for only based on runmode
			data = new Object [testStartRow][1];
		  // to start fecth the data
			for (int rNum = 2; rNum<=xlsData.getRowCount(sheetName); rNum++)
			{
				 if (xlsData.getCellData(sheetName, "Runmode", rNum).equalsIgnoreCase(testMode)) 
				 {
					
						datatable = new Hashtable<String, String>();
						datatable.put("SheetName", sheetName);
						for(int col = 0; col < xlsData.getColumnCount(sheetName); col++) 
						{
						   datatable.put(xlsData.getCellData(sheetName, col, 1), xlsData.getCellData(sheetName, col,rNum ));
						   System.out.print(xlsData.getCellData(sheetName, col,rNum ) +" ");
				        }
				      /* It will put the Data into the Table for Each row and then 
				       put the table inside the Two dimensional Array
					  APPLICATION_LOGS.debug("Test Case " + testMode+ " starts from Row Number " + testStartRow + "in sheet" + sheetName);*/
						System.out.println("");
						data[dataIndex][0]=datatable;
						dataIndex++;	
					
				 }
				 else
				  {
					APPLICATION_LOGS.error("Data is not provided properly");
				  }
				
			}
		}
		
		//if Test case/mode is not provided
		else {
			int totalRows = xlsData.getRowCount(sheetName);
			int dataIndex =0;	
			data = new Object [totalRows-1][1];
			
			for (int rNum = 2; rNum<= totalRows; rNum++)
			{
				datatable = new Hashtable<String, String>();
				datatable.put("SheetName", sheetName);
				for(int col = 0; col <xlsData.getColumnCount(sheetName); col++) 
				{
					datatable.put(xlsData.getCellData(sheetName, col, 1), xlsData.getCellData(sheetName, col, rNum));
					//System.out.print(xlsData.getCellData(sheetName, col, rNum) +" ");
				}
				System.out.println("");
				data[dataIndex][0]=datatable;
				dataIndex++;
			}
			
		}
		return data;
	}
}
