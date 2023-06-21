package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends PageBase {

	public Login_Page(WebDriver driver) {
		super(driver);

	}

	String Adminusername = "vipinjoshi.joshi@gmail.com" ;
	String Adminpassword = "vipin@123";
	
	String Employee_username = "vipin@leavecode.com" ;
	String Employee_password = "vipin@1234";
	
	String Verifier_username = "verifier@gmail.com" ;
	String Verifier_password = "vipin@123";
	
	String Contractor_username = "contract@gmail.com" ;
	String Contractor_password = "vipin@123" ;
	

	@FindBy(name="username")

	WebElement username ;

	@FindBy(name="password")

	WebElement password ;

	@FindBy(xpath="/html/body/div[2]/main/div/div/div[2]/div/div/div/div/form/div[4]/button[1]")

	WebElement loginbutton ;
	
	
	@FindBy (xpath = "/html/body/nav[2]/ul/li[1]/a")
	
	 public WebElement SuccessMessage ;
	
	@FindBy (xpath = "/html/body/nav[1]/div[3]/ul/li[3]/div/button")
	 public WebElement togglebutton ;
	
	@FindBy (xpath = "/html/body/nav[1]/div[3]/ul/li[3]/div/div/a")
	 public WebElement logoutbutton ;
	
	public void Admin_Login() {

		username.sendKeys(Adminusername);
		password.sendKeys(Adminpassword);
		loginbutton.click();
//		togglebutton.click();
	//	logoutbutton.click();
	}
	
	public void Admin_Logout() {
		
		togglebutton.click();
		logoutbutton.click();
		
	}
	public void Verifier_Login() {

		username.sendKeys(Verifier_username);
		password.sendKeys(Verifier_password);
		loginbutton.click();
		togglebutton.click();
		logoutbutton.click();
	}
	
	
	public void Employee_Login() {

		username.sendKeys(Employee_username);
		password.sendKeys(Employee_password);
		loginbutton.click();	
		togglebutton.click();
		logoutbutton.click();
	}
	
	public void Contractor_Login() {

		username.sendKeys(Contractor_username);
		password.sendKeys(Contractor_password);
		loginbutton.click();	
		togglebutton.click();
		logoutbutton.click();
	}

	
}