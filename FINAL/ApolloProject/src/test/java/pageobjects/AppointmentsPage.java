package pageobjects;



//import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

import base.Base;


public class AppointmentsPage extends Base{
	
     WebDriver driver;
	
	public AppointmentsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[text()='All Patients']")
	private WebElement dropdown;
	
	@FindBy(xpath="//img[@title='Online Doctor Consultation & Medicines']")
	private WebElement Img247;
	
	@FindBy(xpath="//li[text()='sreeja komps']")
	private WebElement patient1;
	
	@FindBy(xpath="//li[text()='pratheeka kaluvala']")
	private WebElement patient2;
	
	@FindBy(xpath="//li[text()='sreeja kompelly']")
	private WebElement patient4;
	
	@FindBy(xpath="//li[text()='raju  kaluvala']")
	private WebElement patient5;
	
	@FindBy(xpath="//li[@data-value='ADD_PATIENT']")
	private WebElement patient3;
	
	@FindBy(xpath="//span[text()='Book an Appointment']")
	private WebElement BookAppointments;
	
	@FindBy(xpath="//h2[@Class='MuiTypography-root MuiTypography-h6']")
	private WebElement HeadingMem;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last name']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
	private WebElement DOB;
	
	@FindBy(xpath="//li[text()='Mother']")
	private WebElement relationm;
	
	@FindBy(xpath="//span[text()='Male']")
	private WebElement MaleButton;
	
	@FindBy(xpath="//span[text()='Female']")
	private WebElement FemaleButton;
	
	@FindBy(xpath="//label[text()='Relation']/following-sibling::div")
	private WebElement Relation;
	
	@FindBy(xpath="//input[@placeholder='name@email.com']")
	private WebElement Emailfield;
	
	@FindBy(xpath="//span[text()='Save']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//span[text()='CONFIRM']")
	private WebElement confirmbutton;
	
	@FindBy(xpath="//span[text()='VIEW DETAILS']")
	private WebElement Viewdetails;
	
	
	public void ClickOnSaveButton()
	{
		SaveButton.click();
	}
	public void ClickOnConfirmButton()
	{
		confirmbutton.click();
	}
	public void EnterEmail(String Email)
	{
		Emailfield.sendKeys(Email);
	}
	public void enterFirstName(String First)
	{
		FirstName.sendKeys(First);
	}
	public void enterLastName(String Last)
	{
		LastName.sendKeys(Last);
	}
	public void selectRelation()
	{
		Relation.click();
		relationm.click();
		
	}
	public void selectGender(String Gender)
	{   
		String m ="male";
		if(!(Gender==m)) {
			MaleButton.click();
			}else {
				FemaleButton.click();
			}
	}
	public void enterDob(String dob)
	{
		DOB.sendKeys(dob);
	}
	public void ClickOnDropDown()
	{
		dropdown.click();
	}
	public void ClickOnImg()
	{
		Img247.click();
	}
	public ConsultationsPage ClickOnBookAppointment()
	{
		BookAppointments.click();
		return new ConsultationsPage(driver);
	}
	public void ClickOnPatientWithBookings() {
		//String p= driver.getWindowHandle();
		dropdown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		patient2.click();
		
	}
	public void ClickOnPatientWithNoBookings() {
		dropdown.click();
		patient1.click();
	}
	public void ClickOnAddPatient() {
		dropdown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		action.moveToElement(patient3).click().perform();
	
	}
	public CheckoutPage ClickOnViewDetails()
	{
		Viewdetails.click();
		return new CheckoutPage(driver);
	}
	public boolean foundAllPatients() {
		return dropdown.isDisplayed();
	}
	public boolean foundBookAppointments() {
		return BookAppointments.isDisplayed();
	}
}
