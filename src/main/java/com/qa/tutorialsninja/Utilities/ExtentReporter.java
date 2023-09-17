package com.qa.tutorialsninja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
	// Step1: make sure the dependency of extentreports is inside pom.xml file
		
	//Step2: Go to https://extentreports.com > Docs > Version5 > Java >Getting Started > Reports > ExtentSpankReporter
		
	// Step3 : Create the object of ExtentReports Class
				ExtentReports extentReport = new ExtentReports();
				
	// Step4 : Create the object of File Class and pass the path of the .html file in the constructor
	            File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
	
	// Step5: Create the Object of ExtentSparkReporter Class and pass the Filereference in the Constructor
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
	// Step6: using the sparkReporter, we can configure a lot of things
	            sparkReporter.config().setTheme(Theme.DARK);
	    		sparkReporter.config().setReportName("TN Automation Results");
	    		sparkReporter.config().setDocumentTitle("TNReportTitle|Automation|Results");
	    		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
	    		
	// Step7: We need to attach the ExtentReport with the SparkReporter
	    		extentReport.attachReporter(sparkReporter);
	    		
	    		
	// Step8: Additional information - System Information and pass it in the Extent Reports
	    		// Step8.1: Create a Properties file and add necessary details in the Properties file
	    		// Step8.2: You have to write the Code of how to read data from the Properties file here

	   Properties prop = new Properties();
	   FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\tutorialsninja\\Config\\config.properties");
	   prop.load(ip);

	// Application url, browserName, username, password, Operating System, Java version,name of the SDET

			extentReport.setSystemInfo("application url", prop.getProperty("url"));
			extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
			extentReport.setSystemInfo("username", prop.getProperty("validUsername"));
			extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
			extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
			extentReport.setSystemInfo("operating system version", System.getProperty("os.version"));
			extentReport.setSystemInfo("SDET name", System.getProperty("user.name"));
			extentReport.setSystemInfo("java version", System.getProperty("java.version"));
			extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
	
   // Step9: Return the extentReport
			return extentReport;
	}

}
