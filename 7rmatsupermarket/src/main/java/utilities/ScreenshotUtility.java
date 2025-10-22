package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		// getScrrenshotAs method is used to capture screenshot. it save scrnshot as
		// file temporarily inside screenShot
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		// SimpleDateFormat class is used to tell the date and time format.
		// Date class is used to get current date. format method is used to convert the
		// date as String.
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
		// OutputScreenShot"-the scrrenshot is generated in this folder ie the loctn
		// only

		if (!f1.exists()) {
			f1.mkdirs(); // if dir not exists,make it . mkdirs- means make directory
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		// System.getProperty is used to give the directory

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		// FileHandler-class , copy method are used to copy from one location to another
		// ie from screenShot to finalDestination
		// copy is a static method.
	}
}
