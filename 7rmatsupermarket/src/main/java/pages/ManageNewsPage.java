package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	
	@FindBy(xpath="(//a[@class='small-box-footer']//following::i)[13]")WebElement morenews;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@class='form-control']")WebElement news;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickmorenews()
	{
		morenews.click();
	}

	public void clicknewbutton()
	{
		newbutton.click();
	}
	
	public void enternews(String newsmessage)
	{
		news.sendKeys(newsmessage);
	}
	public void clicksave()
	{
		save.click();
	}
	public boolean isNewsSaved()
	{
		return alert.isDisplayed();
		
	}
}
