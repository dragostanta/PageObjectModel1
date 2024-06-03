package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshots {
	
	
	public void takeScreenShot(WebDriver  driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		File picture = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			
			Files.copy(picture, new File("poze/screen.png"));
			
		}catch(IOException e) {
			System.out.println("Picture could not be saved!");
			e.printStackTrace();
		}
		
	}
	

	
	

}
