package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	


	 public void selectByVisibleText(WebElement element,String visibleText) { 
	 		Select select =new Select(element); 
	 		select.selectByVisibleText(visibleText); 
	 		 
	 	}

	 public void selectByIndex(WebElement element,int index) { 
	 		Select select =new Select(element); 
	 		select.selectByIndex(index); 
	 			 
	 	}
	 
	 public void selectByValue(WebElement element,String value) { 
	 		Select select =new Select(element); 
	 		select.selectByValue(value); 	 			 
	 	}
	 
	 public static void dragAndDrop(WebDriver driver, WebElement element, WebElement element1)
	 {
		 Actions actions=new Actions(driver);
		 actions.dragAndDrop(element,element1).perform();
		 
	 }
	 
	 public void rightClick(WebDriver driver, WebElement element)
	 {
		 Actions actions=new Actions(driver);
		 actions.contextClick(element).perform();
	 }
	 
	 public void doubleClick(WebDriver driver, WebElement element)
	 {
		 Actions actions=new Actions(driver);
		 actions.doubleClick(element).perform();
	 }
	 
	 public void mousehover(WebDriver driver, WebElement element)
	 {
		 Actions actions=new Actions(driver);
		 actions.moveToElement(element).perform();
	 }
	 
}

