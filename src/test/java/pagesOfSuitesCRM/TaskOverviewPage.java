package pagesOfSuitesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskOverviewPage extends CreatPage {

	
	public TaskOverviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@type='name']")
	public WebElement subjectVer;
	@FindBy(xpath="//div[@type='relate']")
	public WebElement conactNameVer;
	
	@FindBy(xpath="//div[@type='enum']")
	public WebElement  statusVer;
	
	@FindBy(xpath="//div[@type='text']")
	public WebElement  descriptionVer;
}
