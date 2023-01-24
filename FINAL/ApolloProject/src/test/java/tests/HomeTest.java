package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AppointmentsPage;
import pageobjects.ConsultationsPage;
import pageobjects.HomePage;

public class HomeTest extends Base{

	public WebDriver driver;
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		loadPropertiesFile();
		driver=openBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
		
		HomePage homePage=new HomePage(driver);
		homePage.handleAlert();
		
	}
	
	@Test(priority =2)
	public void NavigateToAppointments()
	{
		
		//driver.findElement(By.id("loginPopup")).click();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLoginbutton();
		homePage.EnterNumber(prop.getProperty("number1"));
		homePage.clickOnArrow();
		homePage.EnterOtp();
		homePage.clickOnArrow();
		//homePage.clickOnLoginbutton();
        homePage.clickOnAppointments();
        AppointmentsPage Ap = new AppointmentsPage(driver);
        Assert.assertTrue(Ap.foundAllPatients());
	}
	@Test(priority =1 )
	public void NavigateToConsultations()
	{
		HomePage homePage=new HomePage(driver);
		homePage.clickOnConsultDoctor();
		ConsultationsPage cp = new ConsultationsPage(driver);
		Assert.assertTrue(cp.FoundSearchBar());
	}
	
}
