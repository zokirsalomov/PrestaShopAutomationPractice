package pagesOfSuitesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageOfCRM {

	private WebDriver driver;
	public HomePageOfCRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="CREATE")
	public WebElement quickCreator;
	
//	@FindBy(linkText="Create Task")
//	public WebElement createTask;
	
	
	public void createNewItem(String itemType) {
		Actions action = new Actions(driver);
		action.moveToElement(quickCreator).perform();
		driver.findElement(By.linkText(itemType)).click();
		
	}
	
	
	
	
	
	
}
