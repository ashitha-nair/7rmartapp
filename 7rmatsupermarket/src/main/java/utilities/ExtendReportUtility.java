package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { // synchronized- prevent overlapping while parallel
																		// testing
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // location
		reporter.config().setReportName("7RMart  Project"); // give title for the report
		extentReports.attachReporter(reporter); // connects extentReport and ExtentSparkReporter
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Ashitha"); // give name of team members. for more than 1 member repeat the
														// line.
		return extentReports; // createExtentReports will be returning a report.
	}

}
