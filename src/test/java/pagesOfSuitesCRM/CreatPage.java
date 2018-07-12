package pagesOfSuitesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatPage {

	WebDriver driver;
	public CreatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	public WebElement subject;
	
	public WebElement status;
	
	public WebElement description;
	
	@FindBy(id="contact_name")
	public WebElement contactName;
	
	
	@FindBy(xpath="//input[@id='SAVE']")
	public WebElement saveButton;
	
	
	
	
	
	
}
