package TestScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUsersTest extends Base{
	
	AdminUserPage adminuserpage;
	HomePage homepage;
	
	@Test(groups="regression",retryAnalyzer=retry.Retry.class, description = "verify if the user is able to add admin user")
	
	public void isUserAbleToAddNewUser() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		//String adminusername=ExcelUtility.getStringData(1, 0, "adminuser");
		//String adminpassword=ExcelUtility.getStringData(1, 1, "adminuser");
		FakerUtility fakerutility= new FakerUtility();
		String adminusername=fakerutility.creatARandomFirstName();
		String adminpassword=fakerutility.creatARandomLastName();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(adminpassword);
		//loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		//AdminUserPage adminuserpage=new AdminUserPage(driver);
				adminuserpage= homepage.clickadminmoreinfo();
		adminuserpage.clickNew();
		adminuserpage.enterusername(adminusername).enterpassword(adminpassword) ;
		//adminuserpage.enterpassword(adminpassword);
		adminuserpage.clickusertype();
		
		adminuserpage.clicksave();
		boolean alertcheck=adminuserpage.isalertdisplayed();
		Assert.assertTrue(alertcheck);
	}

}
