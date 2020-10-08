package com.dollardays.listners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.dollardays.utilities.PropertyUtil;

public class ExtentReport {

	private static ExtentReports extentReport;
	private static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest test;
	
	/*public static void extentReportSetUp(String folderName) throws Exception {
		//String testReportPath = PropertyUtil.getProperty("testReportPath");
		extentSparkReporter = new ExtentSparkReporter(".\\\\reports"+"\\\\"+folderName);
		extentSparkReporter.config().setReportName("Dollar Days Report");
		extentSparkReporter.config().setDocumentTitle("Dollar Days Document");

		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		extentReport.setSystemInfo("Tester", "Tester Name");
	}
	*/
	public static ExtentReports getExtentReport() {
		return extentReport;
	}
	
	public static void flush() {
		extentReport.flush();
	}
	
	public static String getCurrentDateAnTime(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
		String formattedate = formatter.format(date);
		return formattedate;
	}
	
	
	private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+getCurrentDateAnTime()+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "reports";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
    	
    	extentSparkReporter = new ExtentSparkReporter(".\\\\reports"+"\\\\"+getCurrentDateAnTime());
		extentSparkReporter.config().setReportName("Dollar Days Report");
		extentSparkReporter.config().setDocumentTitle("Dollar Days Document");

		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
		extent.setSystemInfo("Tester", "Tester Name");
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 

}
