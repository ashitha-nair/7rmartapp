package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBy(name="username")WebElement username;
@FindBy(name="password")WebElement password;
@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertmessage;

public WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);//initelements to initialise webelements.call pagefactory if we used FindBy annotation
}
public LoginPage enterTheUsername(String username2)
{
	username.sendKeys(username2);
	return this;
}
public LoginPage enterThePassword(String password2)
{
	password.sendKeys(password2);
	return this;
}

public HomePage clickTheSignIn()
{
	signin.click();
	return new HomePage(driver);
}
public boolean isHomepageloaded()
{
	return dashboard.isDisplayed();
}
public boolean isalertmessagedisplayed()
{
	return alertmessage.isDisplayed();
}

}

