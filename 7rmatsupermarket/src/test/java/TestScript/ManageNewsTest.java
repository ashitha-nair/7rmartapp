package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	
	public void verfiyUserCanAccessManageNewsPage() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String newsmessage= ExcelUtility.getStringData(0, 0, "managenews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		ManageNewsPage managenewspage= new ManageNewsPage(driver);
		managenewspage.clickmorenews();
		managenewspage.clicknewbutton();
		managenewspage.enternews(newsmessage);
		managenewspage.clicksave();
		boolean alertdisplay=managenewspage.isNewsSaved();
		Assert.assertTrue(alertdisplay);
	}

	
}
