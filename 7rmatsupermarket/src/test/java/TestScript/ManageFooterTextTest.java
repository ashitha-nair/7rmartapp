package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	
	@Test
	
	public void isTheUserAbleToUpdateFootertext() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String address=ExcelUtility.getStringData(1, 0, "footertext");
		String email=ExcelUtility.getStringData(1, 1, "footertext");
		String phone=ExcelUtility.getIntegerData(1, 2, "footertext");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		ManageFooterTextPage managefootertextPage=new ManageFooterTextPage(driver);
		managefootertextPage.clickmoreinfo();
		managefootertextPage.clickActionButton();
		managefootertextPage.enterAddress(address);
		managefootertextPage.enterEmail(email);
		managefootertextPage.enterPhone(phone);
		managefootertextPage.clickUpdate();
		boolean alertdisplayed=managefootertextPage.alertCheck();
		Assert.assertTrue(alertdisplayed);
		
	}

}
