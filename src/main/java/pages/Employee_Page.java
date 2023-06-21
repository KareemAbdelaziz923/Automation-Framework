package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.github.javafaker.Faker;

public class Employee_Page extends PageBase{


	public Employee_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"collapseSubItems4\"]/li[7]/a/span")

	WebElement Employee_link ;
	
	@FindBy(xpath="/html/body/main/div/div/div[2]/div[1]/div[1]/div/div[2]/div/a")

	WebElement Add_Employee ;
	
	@FindBy(id="last_name")

	WebElement lastname ;
	
	@FindBy(id="first_name")

	WebElement firstname ;
	
	@FindBy(id="email")

	WebElement email ;
	
	@FindBy(id="phone")

	WebElement phone ;
	
	@FindBy(id="job_title")

	WebElement jobtitle ;
	
	@FindBy(id="send_email_later")

	WebElement sendemail_later ;
	
	@FindBy(xpath="/html/body/main/div/div/div[2]/div[2]/div[2]/div/div/form/div[7]/div[4]/button")

	WebElement submit ;
	
	@FindBy(xpath="//*[@id=\"tbodydata\"]/tr[1]/td[8]/div/button/img")

	WebElement threedot ;
	
	@FindBy(xpath="//*[@id=\"tbodydata\"]/tr[1]/td[8]/div/div/a[1]")

	WebElement update ;
	
	@FindBy(xpath="//*[@id=\"tbodydata\"]/tr[1]/td[1]/div/input")

	 public WebElement checkbox_button ;
	
	@FindBy(xpath="//*[@id=\"tbodydata\"]/tr[1]/td[8]/div/div/a[5]")

	 public WebElement delete ;

	
	@FindBy(xpath="/html/body/main/div/div/div[2]/div[1]/div[2]/div[2]")

	 public WebElement Successmessage ;
	
    Faker faker = new Faker();
	
	public void Employee_Creation () {
		

		Employee_link.click();
		Add_Employee.click();
		lastname.sendKeys(faker.name().lastName());
		firstname.sendKeys(faker.name().firstName());
		email.sendKeys(faker.name().lastName()+"@gmail.com");
		phone.sendKeys(faker.phoneNumber().phoneNumber());
		jobtitle.sendKeys(faker.job().title());
		sendemail_later.click();
		submit.click();
		
	}

	public void Employee_update () {

		Employee_link.click();
		threedot.click();
		update.click();
		lastname.sendKeys(faker.name().lastName());
		submit.click();
		
	}

	public void Employee_delete () throws InterruptedException {

		Employee_link.click();
		checkbox_button.click();
		threedot.click();
		delete.click();
		
//		PageBase Page = new PageBase(driver);
		
//	driver.switchTo().alert().accept();
		
		
	}

}
