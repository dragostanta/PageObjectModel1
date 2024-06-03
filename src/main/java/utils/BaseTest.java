package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.LoginPage;
import pages.MenuPage;

public class BaseTest {

	public WebDriver driver;
	public MenuPage menu;
	public LoginPage login;
	
	//@Parameters({"url"})
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		//driver.get(appUrl);
		
	}
	
	//@AfterClass
	public void tearDown() throws InterruptedException {	
		Thread.sleep(5000);
		driver.quit();//inchide toate taburile
		//driver.close();//inchide tabul curent
	}
	

	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File poza = sc.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(poza, new File("poze/"+result.getName()+"-"+timeStamp+".png"));
				System.out.println("Picture saved!");
			}catch(IOException e) {
				System.out.println("Picture could not be saved!");
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
	
	
}
