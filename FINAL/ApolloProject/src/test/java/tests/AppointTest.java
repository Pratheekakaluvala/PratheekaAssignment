package tests;

import java.io.IOException;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;


import base.Base;
import pageobjects.AppointmentsPage;
import pageobjects.CheckoutPage;
import pageobjects.ConsultationsPage;
import pageobjects.HomePage;
import utils.ExcelReader;


public class AppointTest extends Base {
public WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException
	{
		loadPropertiesFile();
		driver=openBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
		HomePage homePage=new HomePage(driver);
		homePage.handleAlert();
		homePage.clickOnLoginbutton();
		homePage.EnterNumber(prop.getProperty("number1"));
		homePage.clickOnArrow();
		homePage.EnterOtp();
		homePage.clickOnArrow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		homePage.clickOnAppointments();
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterMethod
	public void setp() throws InterruptedException
	{
		Thread.sleep(3000);
		
	
	}
	
	@Test(priority =1 )
	public void SelectPatientWithNoBookings()
	
	{
		//failed test case because no book an appointment button
		AppointmentsPage Ap =new AppointmentsPage(driver);
		Ap.ClickOnPatientWithNoBookings();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ConsultationsPage cg = Ap.ClickOnBookAppointment();
		cg.searchDoctor(prop.getProperty("doctor2"));
		cg.selectDoctor();
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hospital Visit']")).isDisplayed());
		
	}
	
	@Test(priority =2, dependsOnMethods ={"SelectPatientWithNoBookings"})
	public void bookADoctor() throws InterruptedException 
	
	{
		ConsultationsPage cg = new ConsultationsPage(driver);
		cg.ClickOnBookHospitalVisit();
		ConsultationsPage pp = new ConsultationsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pp.Selectdate();
		pp.SelectTime();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		ConsultationsPage kk= new ConsultationsPage(driver);
		kk.ClickProceedButton();
		CheckoutPage cp = new CheckoutPage(driver);
		cp.ClickOnOldPatient();
		//cp.ClickOnPatient1();
		cp.ClickOnPayHospital();
		cp.ClickOnconfirmation();
		AppointmentsPage Ap =new AppointmentsPage(driver);
		Assert.assertTrue(Ap.foundAllPatients());		
	}
	
	@Test(priority =3, dependsOnMethods ={"bookADoctor"})
	public void cancelBooking()
	
	{
		AppointmentsPage Ap =new AppointmentsPage(driver);
		Ap.ClickOnPatientWithBookings();
		//if required add refresh page code
		driver.navigate().refresh();
		CheckoutPage cp = Ap.ClickOnViewDetails();
		cp.ClickOnOManage();
		cp.ClickOnCancel1();
		cp.ClickOnCancel2();
		cp.ClickOnreasonp();
		cp.ClickOnSelReason();
		cp.ClickOnSubmit();
		cp.ClickOnconfirmation();
		driver.navigate().refresh();
		AppointmentsPage kk =new AppointmentsPage(driver);
		Assert.assertTrue(kk.foundAllPatients());
	    
	}
	
	@Test(priority = 4)
	public void clickOnAppointmentAgain() {
		AppointmentsPage Ap =new AppointmentsPage(driver);
		Ap.ClickOnPatientWithBookings();
		AppointmentsPage kk =new AppointmentsPage(driver);
		Assert.assertTrue(kk.foundBookAppointments());

		
	}
	
	
	@Test(priority =6)
	public void addNewPatientbyEnteringAllfields()
	
	{   
		ConsultationsPage cg= new ConsultationsPage(driver);
		cg.ClickOnAppointments();
		AppointmentsPage Ap =new AppointmentsPage(driver);
		Ap.ClickOnAddPatient();
		Ap.enterFirstName(prop.getProperty("firstname"));
		Ap.enterLastName(prop.getProperty("lastname"));
		Ap.enterDob(prop.getProperty("date"));
		Ap.selectGender(prop.getProperty("gender"));
		Ap.selectRelation();
		Ap.EnterEmail(prop.getProperty("validEmail"));
		Ap.ClickOnSaveButton();
		Ap.ClickOnConfirmButton();
		Assert.assertTrue(Ap.foundAllPatients());
		
	}
	
	@Test(priority=5)
	public void Searchinvalid() {
		AppointmentsPage Ap =new AppointmentsPage(driver);
		driver.navigate().refresh();
		Ap.ClickOnPatientWithNoBookings();
		Ap.ClickOnBookAppointment();
		ConsultationsPage cg= new ConsultationsPage(driver);
		cg.searchDoctor(prop.getProperty("invalidtext"));
        //assert no warning
		Assert.assertTrue(cg.foundWarning());
	}
    
	@Test(priority=7,dataProvider="dataSupplierFromExcelFile")
    public void ImplementExcelReader(String search)  {
        
		AppointmentsPage Ap =new AppointmentsPage(driver);
		driver.navigate().refresh();
		Ap.ClickOnPatientWithNoBookings();
		Ap.ClickOnBookAppointment();
		ConsultationsPage cg= new ConsultationsPage(driver);
		cg.searchDoctor(search);
        cg.ClickOnAppointments();
        AppointmentsPage kk =new AppointmentsPage(driver);
		Assert.assertTrue(kk.foundAllPatients());
        }
	@DataProvider
    public Object[][] dataSupplierFromExcelFile() throws IOException {
        
        Object[][] data = ExcelReader.readDataFromExcelFile();
        
        return data;
        
    }
	
}
