package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage {
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	WebDriver driver;
	
public AdminUserPage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

/*public void clickadminmoreinfo()
{
	adminmoreinfo.click();
}*/

public AdminUserPage clickNew()
{
	newbutton.click();
	return this;
}

public AdminUserPage enterusername(String adminusername)
{
	username.sendKeys(adminusername);
	return this;
}

public AdminUserPage enterpassword(String adminpassword)
{
	password.sendKeys(adminpassword);
	return this;
}

public void clickusertype()
{
	PageUtility pageUtility=new PageUtility();
	pageUtility.selectByIndex(usertype, 1);
	
	//usertype.click();
	//return usertype;
}

public void clicksave()
{
	save.click();
}

public boolean isalertdisplayed()
{
	return alert.isDisplayed();
}

}
