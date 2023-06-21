package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilites.Helper;

public class TestBase {

	public static WebDriver driver ;
	

	@BeforeSuite

	public  void startdriver () {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://workforce-staging.iamdeveloper.in/");

	}



	@AfterSuite
	public void stopdriver() {


		driver.close();
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void screenshotonfailure(ITestResult result)
	{
		if ( result.getStatus() == ITestResult.FAILURE )
		{
			System.out.println("Failed !");
			System.out.println("Taking Screenshot");
			Helper.capturescreenshot(driver, result.getName());
			
		}
		
	}
	
	
}