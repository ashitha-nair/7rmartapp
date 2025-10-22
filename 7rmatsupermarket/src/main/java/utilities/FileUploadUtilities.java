package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtilities {

	public void fileuploadUsingSendkeys(WebElement element, String filepath) {

		element.sendKeys(filepath);
	}

	public void fileUploadUsingRobotClass(WebElement element, String filepath) throws AWTException {
		StringSelection stringselection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);// copy the path in a
																							// clipboard. toolkit class,
																							// the other three are
																							// methods
		Robot robot = new Robot();// robot class is used for keyboard events. keypress and release are methods.
									// since these methods are instance we need to create class.
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);// keyevent is a class VK-virtual key. the pressed keys should be released
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
