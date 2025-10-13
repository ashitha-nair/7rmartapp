package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement footermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @ class='btn btn-sm btn btn-primary btncss']")WebElement actionbutton;
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickmoreinfo()
	{
		
		footermoreinfo.click();
	}
	
	public void clickActionButton()
	{
		
		actionbutton.click();
	}
	
	public void enterAddress(String address2)
	{
		address.clear();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];",address, address2 );
		
	}
	
	public void enterEmail(String email2)
	{
		email.clear();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];",email, email2 );
	}
	
	public void enterPhone(String phone2)
	{
		phone.clear();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];",phone, phone2 );
	}
	
	public void clickUpdate()
	{
		update.click();
	}
	
	public boolean alertCheck()
	{
		return alert.isDisplayed();
	}
	

}
