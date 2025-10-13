package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following-sibling::i")WebElement contactmoreinfo;
	@FindBy(xpath="//a[@role='button']")WebElement action;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//textarea[@id='content'and @placeholder='Enter the Address']")WebElement address;
	@FindBy(xpath="//textarea[@id='content'and @placeholder='Enter Delivery Time']")WebElement deliverytime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargelimit;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
WebDriver driver;
	

	public ManageContactPage(WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}

	public void clickContactMoreInfo()
	{
		contactmoreinfo.click();
	}

	public void clickAction()
	{
		action.click();
	}
	
	public void enterPhone(String phonenumber)
	{
		phone.clear();
		phone.sendKeys(phonenumber);
	}
	public void enterEmail(String emailaddress)
	{
		email.clear();
		email.sendKeys(emailaddress);
	}
	public void enterAddress(String addressdetails)
	{
		address.clear();
		address.sendKeys(addressdetails);
	}
	public void enterDeliverytime(String deliverytimedetails)
	{
		deliverytime.clear();
		deliverytime.sendKeys(deliverytimedetails);
	}
	public void enterDeliverychargelimit(String deliverychargelimitdetails)
	{
		deliverychargelimit.clear();
		deliverychargelimit.sendKeys(deliverychargelimitdetails);
	}
	public void clickUpdate()
	{

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",update );
	}
	public boolean isupdated()
	{
		return alertmessage.isDisplayed();
		
	}
	

	

}
