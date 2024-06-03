package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ShadowDomExample extends BaseTest{

	@Test
	public void shadowDomExample() {
		
		driver.navigate().to("https://keybooks.ro/events_calendar/");
		
		//driver.findElement(By.cssSelector("div[class='shadow-element']>button")).click();
		
		WebElement button = driver.findElement
				(By.cssSelector("div[id='shadow-host']")).getShadowRoot()
				.findElement(By.cssSelector("div[class='shadow-element']>button"));
		
		button.click();
		
		WebElement bookDayPicture = driver.findElement
				(By.xpath("//div[@id='shadow-host']")).getShadowRoot()
				.findElement(By.xpath("//img[contains(@src, 'www.keybooks.ro_.png')]"));
		
		
		assertTrue(bookDayPicture.isDisplayed());
		
		System.err.println("TEST CEVA CEVA");
		
		
	}
	
	
}
