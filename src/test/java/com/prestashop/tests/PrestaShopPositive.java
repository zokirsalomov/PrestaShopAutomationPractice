package com.prestashop.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrestaShopPositive {
 
	WebDriver driver;
	Faker faker;
	
	WebElement signInBotton;
	
	WebElement newEmailField ;
	WebElement createAccountBotton;
	String fakeEmail ;
	String fakeFirstName;
	String fakeLastname;
	String fakePassword;
	String address ;
	String city;
	String zipCode;
	String phoneNumber;
	
	@BeforeClass
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 faker = new Faker();
		
	}
	
	@BeforeMethod
	public void gotoURL() {
		driver.get(" http://automationpractice.com");
		signInBotton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		signInBotton.click();
		
		newEmailField = driver.findElement(By.xpath("//input[@id='email_create']"));
		createAccountBotton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
		
		fakeEmail = faker.name().firstName()+faker.number().numberBetween(1, 99)+ "@gmail.com";
		fakeFirstName = faker.name().firstName();
		fakeLastname = faker.name().lastName();
		fakePassword = faker.name().firstName()+faker.number().numberBetween(1, 99);
		address = faker.address().buildingNumber()+ " "+ faker.address().streetName();
		city = faker.address().cityName();
		zipCode = ""+faker.number().numberBetween(10000, 99000);
		phoneNumber = faker.phoneNumber().cellPhone();
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		newEmailField.sendKeys(fakeEmail);
		createAccountBotton.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[2]/input[1]")).sendKeys(fakeFirstName);
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(fakeLastname);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(fakePassword);
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(address);
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(city);
		
		WebElement states = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		
//		Select state = new Select(states);
//		state.selectByIndex(faker.number().numberBetween(1, 50));
		states.click();
		states.sendKeys("" + Keys.chord("P") + Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(zipCode);
		
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
		
		//signOut
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(fakeEmail);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(fakePassword);
		
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		//assert correct name and last name displayed
		String output = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		
		assertEquals(output, fakeFirstName+" "+ fakeLastname);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
