package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class Base {
	Properties properties;
	FileInputStream fileinputstream;
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	
	public void browserinitialisation(String browser) throws Exception
		
	{
		try 
		{
			properties =new Properties();
			fileinputstream= new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else
		{
			throw new Exception("invalid");
		}
		
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	 public void browserQuit(ITestResult iTestResult) throws IOException { 
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
 			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj 
 			scrShot.getScreenShot(driver, iTestResult.getName());//get the name of the testcase 
 		}
 		
 		driver.quit();

}}
