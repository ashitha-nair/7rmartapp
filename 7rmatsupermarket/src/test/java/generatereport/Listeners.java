package generatereport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtendReportUtility;

public class Listeners implements ITestListener {
	// ITestListener an interface which listen the console invoke the method according to the result- pass/fail.
	ExtentTest test; 
	  
 	ExtentReports extent = ExtendReportUtility.createExtentReports(); 
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	public void onTestStart(ITestResult result) { 
  
 		ITestListener.super.onTestStart(result); //when the test execution starts onTestStart invokes fetch all the methods name and adds in report
 		test = extent.createTest(result.getMethod().getMethodName()); 
 		extentTest.set(test); 
  
 	} 
  
 	public void onTestSuccess(ITestResult result) { 
 		//when the testcase runs and it passed it will add in the report as success
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
 	public void onTestFailure(ITestResult result) { 
 		//when the testcase runs and it failed it will add in the report as failed
 		ITestListener.super.onTestFailure(result); 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		WebDriver driver = null; 
 		String testMethodName = result.getMethod().getMethodName(); 
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); //when the test fails and throws exeption it will store in the report
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); 
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
 public void onTestSkipped(ITestResult result) { 
	 
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
 public void onTestFailedWithTimeout(ITestResult result) { 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) { 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) { //to generate the report flush need to be called otherwise it will not generate report.
  
 		ITestListener.super.onFinish(context); 
 		extent.flush(); 
 	}

}
