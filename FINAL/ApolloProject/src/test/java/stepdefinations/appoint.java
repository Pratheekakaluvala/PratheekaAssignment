package stepdefinations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageobjects.AppointmentsPage;
import pageobjects.CheckoutPage;
import pageobjects.ConsultationsPage;
import pageobjects.HomePage;

public class appoint extends Base{
	
	WebDriver driver;
	
	@After
	public void Closure(Scenario scenario) {
		if(scenario.isFailed()) {
			captureScreenshot(driver,scenario.getName());
			driver.quit();
		}
	}
	
	
	@Given("^User has opened the Application URL$")
    public void user_has_opened_the_application_url() throws IOException  {
		 loadPropertiesFile();
		 driver = openBrowser(prop.getProperty("browserName"));
		 driver.get(prop.getProperty("url"));
		 HomePage homePage=new HomePage(driver);
		 homePage.handleAlert();

    }
	
	@And("^user logins by entering Number and OTP$")
	public void user_logins_by_entering_number_and_otp() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLoginbutton();
		homePage.EnterNumber(prop.getProperty("number1"));
		homePage.clickOnArrow();
		homePage.EnterOtp();
		homePage.clickOnArrow();
	    }
	
	 @And("^clicks on Appointments link$")
	    public void clicks_on_appointments_link() {
		 HomePage homepage = new HomePage(driver);
		 homepage.clickOnAppointments();
	        
	    }

     @When("^clicks on patient with no bookings$")
       public void clicks_on_patient_with_no_bookings() {
    	 AppointmentsPage Ap = new AppointmentsPage(driver);
    	 Ap.ClickOnPatientWithNoBookings();
       
        }
    
      @And("^clicks on book an appointment button$")
      public void clicks_on_book_an_appointment_button()  {
    	  AppointmentsPage Ap = new AppointmentsPage(driver);
    	  Ap.ClickOnBookAppointment();
      }
    
      @Then("^User should be able to navigate to Consultations Page$")
       public void user_should_be_able_to_navigate_to_consultations_page() {
    	  ConsultationsPage cp = new ConsultationsPage(driver);
			Assert.assertTrue(cp.FoundSearchBar());
			driver.quit();
      
       }
       
      
      @And("^search for a doctor and select the doctor$")
      public void search_for_a_doctor_and_select_the_doctor()  {
    	  AppointmentsPage Ap = new AppointmentsPage(driver);
    	  ConsultationsPage cg = Ap.ClickOnBookAppointment();
  		   cg.searchDoctor(prop.getProperty("doctor2"));
  		   cg.selectDoctor();
     
      }
      

      @And("^complete the booking process$")
      public void complete_the_booking_process() {
    	ConsultationsPage cg = new ConsultationsPage(driver);
  		cg.ClickOnBookHospitalVisit();
  		ConsultationsPage pp = new ConsultationsPage(driver);
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		pp.Selectdate();
  		pp.SelectTime();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  		ConsultationsPage kk= new ConsultationsPage(driver);
  		kk.ClickProceedButton();
  		CheckoutPage cp = new CheckoutPage(driver);
  		cp.ClickOnOldPatient();
  		//cp.ClickOnPatient1();
  		cp.ClickOnPayHospital();
  		cp.ClickOnconfirmation();
      }
      
      @Then("^user should see the booked appointment$")
      public void user_should_see_the_booked_appointment() {
    	  AppointmentsPage Ap =new AppointmentsPage(driver);
  		  Assert.assertTrue(Ap.foundAllPatients());	
  		  driver.quit();
      }

      @When("^clicks on patient with bookings$")
       public void clicks_on_patient_with_bookings()  {
    	  AppointmentsPage Ap = new AppointmentsPage(driver);
     	 Ap.ClickOnPatientWithBookings();
       
       }
      
      @And("^clicks on book an view details$")
      public void clicks_on_book_an_view_details() {
    	  AppointmentsPage Ap = new AppointmentsPage(driver);
    	  driver.navigate().refresh();    	 
    	  Ap.ClickOnViewDetails();
      }
      
      @And("^complete the cancellation process$")
      public void complete_the_cancellation_process()  {
        CheckoutPage cp = new CheckoutPage(driver);
    	cp.ClickOnOManage();
  		cp.ClickOnCancel1();
  		cp.ClickOnCancel2();
  		cp.ClickOnreasonp();
  		cp.ClickOnSelReason();
  		cp.ClickOnSubmit();
  		cp.ClickOnconfirmation();
  		driver.navigate().refresh();
      }
      @Then("^user should be able to see that booking is cancelled$")
      public void user_should_be_able_to_see_that_booking_is_cancelled(){
    	  AppointmentsPage kk =new AppointmentsPage(driver);
  		  Assert.assertTrue(kk.foundAllPatients());
  		   driver.quit();
      }
      
      @Then("^User should be able to see book an appointment button$")
      public void user_should_be_able_to_see_book_an_appointment_button() {
    	  AppointmentsPage kk =new AppointmentsPage(driver);
  		   Assert.assertTrue(kk.foundBookAppointments());
  		   driver.quit();
      }

      @When("^clicks on add patient$")
       public void clicks_on_add_patient() {
    	  AppointmentsPage Ap =new AppointmentsPage(driver);
  		   Ap.ClickOnAddPatient();
        }
      @And("^enters all the fields$")
      public void enters_all_the_fields() {
    	AppointmentsPage Ap =new AppointmentsPage(driver);
    	Ap.enterFirstName(prop.getProperty("firstname"));
  		Ap.enterLastName(prop.getProperty("lastname"));
  		Ap.enterDob(prop.getProperty("date"));
  		Ap.selectGender(prop.getProperty("gender"));
  		Ap.selectRelation();
  		Ap.EnterEmail(prop.getProperty("validEmail"));
  		Ap.ClickOnSaveButton();
  		Ap.ClickOnConfirmButton();
      }
      
      @Then("^user should be able to see the new patient$")
      public void user_should_be_able_to_see_the_new_patient(){
    	  AppointmentsPage Ap =new AppointmentsPage(driver);
    	  Assert.assertTrue(Ap.foundAllPatients());
    	  driver.quit();
      }  
      
      @Then("^user should see search results$")
      public void user_should_see_search_results(){
    	  ConsultationsPage cp = new ConsultationsPage(driver);
    	  Assert.assertTrue(cp.FoundSearchBar());
    	  driver.quit();  
      }
      
      @And("^User enters search data  as (.+) into search field$")
      public void user_enters_search_data_as_into_search_field(String data){
    	  AppointmentsPage Ap = new AppointmentsPage(driver);
    	  ConsultationsPage cg = Ap.ClickOnBookAppointment();
  		   cg.searchDoctor(data);
  		  
      }

}

