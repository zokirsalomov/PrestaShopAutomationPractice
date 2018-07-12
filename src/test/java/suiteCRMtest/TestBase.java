package suiteCRMtest;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	Faker faker;
	
	
	@BeforeClass
	public void setUpBrowser()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		faker = new Faker();
		
	
	}
	
	/*
	 * switch to new tab based on expected title
	 * will switch back to the original tab
	 * 
	 * if expected title odes not exist
	 * 
	 */
	public void switchByTitle(String title) {
		String original = driver.getWindowHandle();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(title)) {
				//do not do anything else and leave the method
				// since we are in the right window
				return;
			}
		}
		
		driver.switchTo().window(original);
	}
	
	
//	@AfterClass
//	  public void tearDown() {
//	    driver.quit();
//	  }
	
}

 
