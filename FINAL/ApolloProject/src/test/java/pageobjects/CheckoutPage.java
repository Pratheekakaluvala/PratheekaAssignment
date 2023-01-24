package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import java.time.Duration;

import base.Base;

public class CheckoutPage extends Base{
	 
	 WebDriver driver;
		
		public CheckoutPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//button[text()='sreeja'] ")
		private WebElement Newpatient;
		
		@FindBy(xpath="//button[text()='pratheeka']")
		private WebElement OldPatient;

		@FindBy(xpath="//button[text()='raju ']")
		private WebElement patient1;
		
		@FindBy(xpath="//span[text()='Pay at Hospital']")
		private WebElement payathospital;
		
		
		
		@FindBy(xpath="//span[text()='MANAGE']")
		private WebElement Manage;
		
		@FindBy(xpath="//span[text()='Cancel Appointment']")
		private WebElement Cancel1;
		
		@FindBy(xpath="//span[text()='Cancel Consult'] ")
		private WebElement Cancel2;
		
		@FindBy(xpath="//div[text()='Select reason for cancelling']")
		private WebElement reasonp;
		
		@FindBy(xpath="//li[text()='Booked with wrong user details']")
		private WebElement selreason;
		
		@FindBy(xpath="//span[text()='Submit Request']")
		private WebElement Submitbutton;
		
		@FindBy(xpath="//span[text()='OK, GOT IT']")
		private WebElement confirmation;
		
		@FindBy(xpath="//span[text()='Pay Rs. ']")
		private WebElement Onlinepayrs;
		
		
		public void ClickOnNewPatient()
		{
			Newpatient.click();
		}
		public void ClickOnOldPatient()
		{
			OldPatient.click();
		}
		public void ClickOnPatient1()
		{
			patient1.click();
		}
		public void ClickOnPayHospital()
		{
			payathospital.click();
		}
		
		public void ClickOnOManage()
		{
			Manage.click();
		}
		public void ClickOnCancel1()
		{
			Cancel1.click();
		}
		public void ClickOnCancel2()
		{
			Cancel2.click();
		}
		public void ClickOnreasonp()
		{
			reasonp.click();
		}
		public void ClickOnSelReason()
		{
			selreason.click();
		}
		public void ClickOnSubmit()
		{
			Submitbutton.click();
		}
		public void ClickOnconfirmation()
		{
			confirmation.click();
		}
		
		

		
		
		

}
