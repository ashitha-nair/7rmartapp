package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test
	
	
	public void customercanlogout() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();		
		LogoutPage logoutpage= new LogoutPage(driver);
		logoutpage.clickadminbutton();
		logoutpage.clicklogout();
		boolean alertlogout= logoutpage.isloggedout();
		Assert.assertTrue(alertlogout);
				
	}

}
