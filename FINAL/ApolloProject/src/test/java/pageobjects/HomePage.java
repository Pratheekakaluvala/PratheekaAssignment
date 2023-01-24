package pageobjects;

import java.util.*;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Consult Online']")
	private WebElement consultDoctor;
	
	@FindBy(id="wzrk-cancel")
	private WebElement alertOption;
	
	@FindBy(xpath="//span[@class='icon-ic_appointments_selected Navigation_menuicon__G8BXt']/following-sibling::p")
	private WebElement appointments;
	
	@FindBy(id= "loginPopup")
	private WebElement Loginbutton;
	
	@FindBy(xpath= "//span[@class='icon-ic_account']")
	private WebElement Loginbutton2;
	
	@FindBy(css= ".icon-ic_arrow_forward")
	private WebElement arrow;
	
	@FindBy(css = " .MuiInputBase-input")
	private WebElement otpfield;
	
	@FindBy( name = "mobileNumber")
	private WebElement numberfield; 
	
	
	
	public void handleAlert()
	{
		alertOption.click();
	}
	public void clickOnConsultDoctor()
	{
		consultDoctor.click();
	}
	public void clickOnAppointments()
	{
		appointments.click();
	}
	public void clickOnLoginbutton()
	{
		Loginbutton.click();
	}
	public void clickLoginButton2()
	{
		Actions action = new Actions(driver);
		action.moveToElement(Loginbutton2).click().perform();
	}
	public void clickOnArrow()
	{
		arrow.click();
	}
	public void EnterNumber(String number )
	{
		numberfield.sendKeys(number);
	}
	public void EnterOtp()
	{
		Scanner scanner = new Scanner(System.in);
		String otp= scanner.nextLine();
		otpfield.sendKeys(otp);
	}

}
