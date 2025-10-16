package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtilities;




public class ManageCategoryPage {
	
	//@FindBy(xpath="//i[@class='fas fa-arrow-circle-right']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement categorymoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement category;
	@FindBy(xpath="//div[@class='ms-selectable']//child::ul")WebElement selectgroups1;
	@FindBy(xpath="//div[@class='ms-selection']//child::ul")WebElement selectgroups2;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@name='create']")WebElement save;

	
	WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickCategoryMoreinfo()
	{
		categorymoreinfo.click();
	}*/
	
	public ManageCategoryPage clickNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageCategoryPage enterCategory(String categorydetails)
	{
		category.sendKeys(categorydetails);
		return this;
	}
	
//	public  void clickSelectgroups()
	{	
	
		//selectgroups1.click();
	}
	
	public ManageCategoryPage fileUpload()
	{
		//choosefile.sendKeys(Constant.Constant.TESTIMAGE);
		FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
		fileuploadutilities.fileuploadUsingSendkeys(choosefile,Constant.TESTIMAGE);
		return this;
	}
	
	public boolean isSaveButtonDisplayed()
	{
		return save.isDisplayed();
	}


	}
	
	
	
	


