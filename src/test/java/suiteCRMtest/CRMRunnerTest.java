package suiteCRMtest;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesOfSuitesCRM.*;

import static org.testng.Assert.assertEquals;
import static utilities.ConfigReader.*;
 
public class CRMRunnerTest extends TestBase{


	LoginPageOfCRM loginPage ;
	HomePageOfCRM homepage;
	CreatPage creatingTask;
	TaskOverviewPage taskOverviewpage;
	
	@BeforeMethod
	public void navigate() {
		//navigate to page
		driver.get(getProperty("suitecrm.url"));
		loginPage = new LoginPageOfCRM(driver);
		homepage = new HomePageOfCRM(driver);
		creatingTask = new CreatPage(driver);
		taskOverviewpage = new TaskOverviewPage(driver);
	}
	
	
	@Test
	public void createTeskInSuiteCRM() {
		
		driver.get(getProperty("suitecrm.url"));
		loginPage.login(getProperty("suitecrm.userName"), getProperty("suitecrm.password"));
		homepage.createNewItem("Create Task");
		creatingTask.subject.sendKeys(getProperty("suitecrm.subject"));
		new Select(creatingTask.status).selectByValue(getProperty("suitecrm.status"));;
		//creatingTask.contactName.sendKeys(getProperty("suitecrm.contactName"));
		creatingTask.description.sendKeys(getProperty("suitecrm.description"));

		creatingTask.saveButton.click();
		
		assertEquals(taskOverviewpage.subjectVer.getText(), getProperty("suitecrm.subject"));
		assertEquals(taskOverviewpage.statusVer.getText(), getProperty("suitecrm.status"));
		//assertEquals(taskOverviewpage.conactNameVer.getText(), getProperty("suitecrm.contactName"));
		assertEquals(taskOverviewpage.descriptionVer.getText(), getProperty("suitecrm.description"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
