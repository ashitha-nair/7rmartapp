package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtilities;

public class ManageFooterTextPage {

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'
	// and @class='small-box-footer']")WebElement footermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @ class='btn btn-sm btn btn-primary btncss']")
	WebElement actionbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickFootermoreinfo() {
	 * 
	 * footermoreinfo.click(); }
	 */

	public ManageFooterTextPage clickActionButton() {

		actionbutton.click();
		return this;
	}

	public ManageFooterTextPage enterAddress(String address2) {
		address.clear();
		PageUtility pageutility = new PageUtility();
		pageutility.setValueByJS(driver, address, address2);
		return this;

	}

	public ManageFooterTextPage enterEmail(String email2) {
		email.clear();
		// JavascriptExecutor js=(JavascriptExecutor) driver;
		// js.executeScript("arguments[0].value=arguments[1];",email, email2 );

		PageUtility pageutility = new PageUtility();
		pageutility.setValueByJS(driver, email, email2);
		return this;
	}

	public ManageFooterTextPage enterPhone(String phone2) {
		phone.clear();
		PageUtility pageutility = new PageUtility();
		pageutility.setValueByJS(driver, phone, phone2);
		return this;
	}

	public ManageFooterTextPage clickUpdate() {
		WaitUtilities waitutilities = new WaitUtilities();
		waitutilities.waitForElement(driver, update);
		update.click();
		return this;
	}

	public boolean alertCheck() {
		return alert.isDisplayed();
	}

}
