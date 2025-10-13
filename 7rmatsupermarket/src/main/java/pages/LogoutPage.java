package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement adminbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	
	WebDriver driver;

public LogoutPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickadminbutton()
{
	adminbutton.click();
}

public void clicklogout()
{
	logout.click();
}

public boolean isloggedout()
{
	return signin.isDisplayed();

}

}