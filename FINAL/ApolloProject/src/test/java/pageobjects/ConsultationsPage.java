package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ConsultationsPage extends Base{
	
     WebDriver driver;
	
	public ConsultationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

//	@FindBy(xpath="//h2[@class='MuiTypography-root MuiTypography-body1' and text()='Dr. Ramesh Tirnati']")
//	private WebElement Doctor;
	
	@FindBy(xpath="//h2[text()='Dr. Monil Gupta']")
	private WebElement Doctor;
	
	@FindBy(xpath="//a[text()='Appointments']")
	private WebElement appointmentsc;
	
	@FindBy(xpath="//span[text()='Book an Appointment']")
	private WebElement BookAppointments;
	
	@FindBy(xpath="//input[@placeholder='Search doctors or specialities']")
	private WebElement Searchbar;
	
	@FindBy(xpath="//a[text()='Hyderabad']")
	private WebElement city1;
	
	@FindBy(xpath="//span[text()='Book Video Consult']")
	private WebElement bookvideoconsult;
	
	@FindBy(xpath="//span[text()='Book Hospital Visit']")
	private WebElement bookhospitalvisit;	
	
	@FindBy(xpath="//button[@value='10:30']")
	private WebElement timesel;
	
	@FindBy(xpath="//p[text()='26']")
	private WebElement datesel;
	
	@FindBy(xpath="//span[text()='PAY Rs. 300']")
	private WebElement payonline1;
	
	@FindBy(xpath="//span[text()='PROCEED']")
	private WebElement Proceedbutton;
	
	@FindBy(xpath="//span[text()='warning']")
	private WebElement Warning;
	
	@FindBy(xpath="//h4[text()='Hospital Visit']")
	private WebElement hospitalVisit;
	
	
	
	public void ClickOnAppointments()
	{
		appointmentsc.click();
		
	}
	public void searchDoctor(String Doctor) {
		Searchbar.click();
		Searchbar.sendKeys(Doctor);
	}
	public void selectDoctor() {
		Doctor.click();
	}
	
	public void Selectdate() {
		datesel.click();
	}
	public void SelectTime() {
		timesel.click();
	}
	
	public void ClickProceedButton() {
		for(int i =0;i<=2;i++) {
		try {
		Proceedbutton.click();
		break;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
	public void ClickOnBookAppointment()
	{
		BookAppointments.click();
		
	}
	public void ClickOnBookHospitalVisit() {
		
		bookhospitalvisit.click();
	}
	public boolean foundBookHospitalVisit() {
		return bookhospitalvisit.isDisplayed();
	}
	public boolean foundHospitalVisit() {
		return hospitalVisit.isDisplayed();
	}
	
	public boolean foundWarning() {
		return Warning.isDisplayed();
	}
	
	public boolean FoundSearchBar() {
		return Searchbar.isDisplayed();
	}
	
}
