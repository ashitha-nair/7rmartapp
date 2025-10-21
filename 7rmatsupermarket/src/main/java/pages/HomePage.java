package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement adminbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logout;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	@FindBy(xpath="//i[@class='fas fa-arrow-circle-right']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement categorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following-sibling::i")WebElement contactmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement footermoreinfo;
	@FindBy(xpath="(//a[@class='small-box-footer']//following::i)[13]")WebElement morenews;
	WebDriver driver;

public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public AdminUserPage clickadminmoreinfo()
{
	adminmoreinfo.click();
	return new AdminUserPage(driver);
}

public ManageCategoryPage clickCategoryMoreinfo()
{
	categorymoreinfo.click();
	return new ManageCategoryPage(driver);
}

public ManageContactPage clickContactMoreInfo()
{
	contactmoreinfo.click();
	return new ManageContactPage(driver);
}

public ManageFooterTextPage clickFootermoreinfo()
{
	
	footermoreinfo.click();
	return new ManageFooterTextPage(driver);
}

public ManageNewsPage clickmorenews()
{
	morenews.click();
	return new ManageNewsPage(driver);
}

public HomePage clickadminbutton()
{
	adminbutton.click();
	return this;
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