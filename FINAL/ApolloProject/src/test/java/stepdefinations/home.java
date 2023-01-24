package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.*;
import pageobjects.AppointmentsPage;
import pageobjects.ConsultationsPage;
import pageobjects.HomePage;

public class home extends Base{
	WebDriver driver;

	
	 @Given("^User has opened the Application$")
	    public void user_has_opened_the_application_url() throws IOException 
	 {
		 loadPropertiesFile();
		 driver = openBrowser(prop.getProperty("browserName"));
		 driver.get(prop.getProperty("url"));
		 HomePage homePage=new HomePage(driver);
		 homePage.handleAlert();
	    }
	    
	    @When("^clicks on Consult Online link$")
	    public void clicks_on_consult_online_link() {
	    	 HomePage homepage = new HomePage(driver);
		      homepage.clickOnConsultDoctor();
	    }
	    
	    @And("^user logins by entering Number$")
	    public void user_logins_by_entering_number_and_otp()
	    {
	    	HomePage homePage=new HomePage(driver);
			homePage.clickOnLoginbutton();
			homePage.EnterNumber(prop.getProperty("number1"));
			homePage.clickOnArrow();
			homePage.EnterOtp();
			homePage.clickOnArrow();
	    }

	    @When("^clicks on Appointments button$")
	    public void clicks_on_appointments_link() 
	    {
	    	HomePage homepage = new HomePage(driver);
		    homepage.clickOnAppointments();
	    }

	    @Then("^User should be able to navigate to Consultationspage$")
	    public void user_should_be_able_to_navigate_to_consultations_page()
	    {
	    	ConsultationsPage cp = new ConsultationsPage(driver);
			Assert.assertTrue(cp.FoundSearchBar());
			driver.quit();
	    }

	    @Then("^User should be able to navigate to Appointmentspage$")
	    public void user_should_be_able_to_navigate_to_appointments_page() 
	    {
	    	AppointmentsPage Ap = new AppointmentsPage(driver);
	        Assert.assertTrue(Ap.foundAllPatients());
	        driver.quit();
	    }

	   
}
