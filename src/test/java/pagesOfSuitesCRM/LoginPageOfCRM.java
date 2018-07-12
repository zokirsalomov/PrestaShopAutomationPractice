package pagesOfSuitesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOfCRM{

	
	public LoginPageOfCRM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="username_password")
	public WebElement password;
	
	@FindBy(id="bigbutton")
	public WebElement loginButton;
	
	public void login(String username, String password) {
		userName.sendKeys(username);
		this.password.sendKeys(password);
		this.loginButton.click();
	}
	
	
}
