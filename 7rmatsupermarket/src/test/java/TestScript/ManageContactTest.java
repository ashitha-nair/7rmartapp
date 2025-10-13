package TestScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	@Test
	
	
	public void isTheCustomerAbleToUpdateContact() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String phonenumber=ExcelUtility.getIntegerData(5, 1, "managecontact");
		String emailaddress=ExcelUtility.getStringData(1, 1, "managecontact");
		String addressdetails=ExcelUtility.getStringData(2, 1, "managecontact");
		String deliverytimedetails=ExcelUtility.getIntegerData(3, 1, "managecontact");
		String deliverychargelimitdetails=ExcelUtility.getIntegerData(4, 1, "managecontact");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignIn();
		ManageContactPage managecontactpage= new ManageContactPage(driver);
				managecontactpage.clickContactMoreInfo();
				managecontactpage.clickAction();
				managecontactpage.enterPhone(phonenumber);
				managecontactpage.enterEmail(emailaddress);
				managecontactpage.enterAddress(addressdetails);
				managecontactpage.enterDeliverytime(deliverytimedetails);
				managecontactpage.enterDeliverychargelimit(deliverychargelimitdetails);
				managecontactpage.clickUpdate();				
				boolean checkupdate=managecontactpage.isupdated();
				Assert.assertTrue(checkupdate);
				
				
				
	}

}
