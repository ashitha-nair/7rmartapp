package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	
	
	public void customercanlogout() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();		
		HomePage logoutpage= new HomePage(driver);
		logoutpage.clickadminbutton().clicklogout();
		//logoutpage.clicklogout();
		boolean alertlogout= logoutpage.isloggedout();
		Assert.assertTrue(alertlogout, Constant.LOGOUT);
				
	}

}
