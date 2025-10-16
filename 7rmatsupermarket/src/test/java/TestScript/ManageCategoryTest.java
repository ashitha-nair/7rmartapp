package TestScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;


public class ManageCategoryTest extends Base{
	
	ManageCategoryPage managecategorypage;
	HomePage homepage;
	
	@Test
	
	public void verifyIfUserCanAddCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String categorydetails=ExcelUtility.getStringData(1, 0, "managecategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		//ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		//PageUtility pageutility=new PageUtility();
		//PageUtility.dragAndDrop(driver, selectgroups1, selectgroups2);
		managecategorypage= homepage.clickCategoryMoreinfo();
		managecategorypage.clickNewButton().enterCategory(categorydetails).fileUpload();
		//managecategorypage.enterCategory(categorydetails);
	//	managecategorypage.clickSelectgroups();
		//managecategorypage.fileUpload();
		boolean savecheck=managecategorypage.isSaveButtonDisplayed();
		Assert.assertTrue(savecheck, Constant.ADDCATEGORY);
	}

}
