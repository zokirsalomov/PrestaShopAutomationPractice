package com.prestashop.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrestaShopNegative {
 
	WebDriver driver;
	Faker faker;
	WebElement signInBotton;
	WebElement emailField;
	WebElement pswdField;
	WebElement submitBotton;
	
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
		emailField = driver.findElement(By.id("email"));
		pswdField = driver.findElement(By.id("passwd"));
		submitBotton = driver.findElement(By.id("SubmitLogin"));
	}
	
	
	@Test
  public void aWrongCredentialsTest() {
		
		emailField.sendKeys(faker.name().firstName() + "@gmail.com");
		pswdField.sendKeys(faker.name().firstName()+ faker.number());
		submitBotton.click();
	   WebElement errorMessage = driver.findElement(By.xpath("//li[.='Authentication failed.']"));
		assertTrue(errorMessage.isDisplayed());
	
  }
	@Test
	public void bInvalidEmailTest() {
		emailField.sendKeys(faker.name().firstName()+ ".gmail.com");
		pswdField.sendKeys(faker.name().firstName() + faker.number());
		submitBotton.click();
		WebElement invalidEmailMsg = driver.findElement(By.xpath("//li[.='Invalid email address.']"));
		assertTrue(invalidEmailMsg.isDisplayed());
	}
	
	@Test
	public void cBlankEmailTest() {
		pswdField.sendKeys(faker.name().firstName()+ faker.number());
		submitBotton.click();
		WebElement emailRequiredMsg = driver.findElement(By.xpath("//li[.='An email address required.']"));
		assertTrue(emailRequiredMsg.isDisplayed());
	}
	
	@Test
	public void dBlankPasswordTest() {
		emailField.sendKeys(faker.name().firstName()+"@gmail.com");
		submitBotton.click();
		WebElement  pswRequiredMsg = driver.findElement(By.xpath("//li[.='Password is required.']"));
		assertTrue(pswRequiredMsg.isDisplayed());
		
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
