package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenewspPage;
	HomePage homepage;

	@Test(description="verify if the user is able to add news")

	public void verfiyUserCanAccessManageNewsPage() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String newsmessage = ExcelUtility.getStringData(0, 0, "managenews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		homepage = loginpage.clickTheSignIn();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage = homepage.clickmorenews();
		managenewspage.clicknewbutton().enternews(newsmessage).clicksave();
		// managenewspage.clicksave();
		boolean alertdisplay = managenewspage.isNewsSaved();
		Assert.assertTrue(alertdisplay, Constant.MANAGENEWS);
	}

}
