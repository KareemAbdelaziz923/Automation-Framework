package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class HiringCompany_Page extends PageBase {

	public HiringCompany_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"collapseSubItems3\"]/li[1]/a/span")

	public WebElement HiringCompany_link ;
	
	@FindBy(xpath="/html/body/main/div/div/div[2]/div/div[1]/div/div[2]/div/a")

	WebElement Add_HiringCompany ;
	
	@FindBy(id="name")

	WebElement name ;
	
	@FindBy(id="logo")

	WebElement logo ;
	
	@FindBy(id="website")

	WebElement website ;
	
	@FindBy(id="industry_id")

	WebElement industry_id ;
	
	@FindBy(id="description")

	WebElement description ;
	
	@FindBy(id="address")

	WebElement address ;
	
	@FindBy(id="phone")

	WebElement phone ;
	
	@FindBy(id="city")

	WebElement city ;
	
	@FindBy(id="region")

	WebElement region ;
	
	@FindBy(id="postal_code")

	WebElement postal_code ;
	
	@FindBy(xpath="/html/body/main/div/div/div[2]/div[2]/div/div/div/form/div[2]/button")

	 public WebElement submit ;
	
       @FindBy(name="industry_id")
	
	WebElement industrylist ;
	
       @FindBy(name="status")
   	
	WebElement statuslist ;
       

       
       @FindBy(xpath ="/html/body/main/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[5]/div/button")
       	WebElement threedot ;
       
   	
   @FindBy(xpath="//*[@id=\"tbodydata\"]/tr[1]/td[5]/div/div/a[1]")

   	WebElement update ;
       
   @FindBy(xpath="/html/body/main/div/div/div[2]/div/div[2]/div[1]/div[1]")

  	public WebElement success ;
	
	
	String imagename = "unnamed.png";
	String imagepath = System.getProperty("user.dir")+ "/Uploads/"+imagename;
	
	
    Faker faker = new Faker();
	
	public void Hiringcompany_Creation () throws InterruptedException {
		

		HiringCompany_link.click();
		Add_HiringCompany.click();
		
		name.sendKeys(faker.company().name());
		website.sendKeys(faker.company().url());
		logo.sendKeys(imagepath);
		address.sendKeys(faker.address().streetAddress());
		Select industry = new Select (industrylist);
		industry.selectByValue("4");
		description.sendKeys(faker.company().suffix());
		phone.sendKeys(faker.phoneNumber().phoneNumber());
		city.sendKeys(faker.address().cityName());
		region.sendKeys(faker.address().state());
		postal_code.sendKeys(faker.address().zipCode());
		Select status = new Select (statuslist);
		status.selectByValue("1");
		submit.click();
		Assert.assertEquals(success.getText(), "Record was added successfully");

		
	}

	public void Hiringcompany_update () throws InterruptedException    {

	
		HiringCompany_link.click();
		threedot.click();
		update.click();
		name.clear();
		name.sendKeys(faker.name().lastName());
		submit.click();
		
		
		
	}

	public void Hiringcompany_delete () throws InterruptedException {

	
	
		
//		PageBase Page = new PageBase(driver);
		
//	driver.switchTo().alert().accept();
		
		
	}
	
	
}
