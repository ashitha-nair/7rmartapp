package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	@Test(groups="regression")
	
	public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		boolean homepage=loginpage.isHomepageloaded();
		Assert.assertTrue(homepage,Constant.LOGINVALIDCREDENTIALS);  //Assert.assertequals(num,sum); for checking values
			
		
	}
	@Test
	
	public void verfiyTheUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		//String username="admin";
		//String password="asdfg";
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		boolean alertdisplayed=loginpage.isalertmessagedisplayed();
		Assert.assertTrue(alertdisplayed, Constant.LOGININVALIDPASSWORD);
	}
@Test

	public void verfiyTheUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		//String username="qwerty";
		//String password="admin";
	String username=ExcelUtility.getStringData(3, 0, "loginpage");
	String password=ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		boolean alertdisplayed=loginpage.isalertmessagedisplayed();
		Assert.assertTrue(alertdisplayed, Constant.LOGININVALIDUSERNAME);
	}
@Test(dataProvider="LoginProvider")

public void verfiyTheUserIsAbleToLoginWithInvalidCredentials(String username, String password) throws IOException
{
	//String username="qwerty";
	//String password="asdfg";
	//String username=ExcelUtility.getStringData(4, 0, "loginpage");
	//String password=ExcelUtility.getStringData(4, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username);
	loginpage.enterThePassword(password);
	loginpage.clickTheSignIn();
	boolean alertdisplayed=loginpage.isalertmessagedisplayed();
	Assert.assertTrue(alertdisplayed, Constant.LOGININVALIDCREDENTIALS);
}

@DataProvider(name="LoginProvider") 
	public Object[][] getDataFromTestData() throws IOException{ 
		return new Object[][] {{ExcelUtility.getStringData(4, 0,"loginpage"),ExcelUtility.getStringData(4,1,"loginpage")}}; 
		 
	 
	 
	}
}
