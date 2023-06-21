package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HiringCompany_Page;
import pages.Login_Page;

public class hiringcompany_Test extends TestBase {
	
	HiringCompany_Page HiringCompany ;
	Login_Page login ;
	

	public void HiringCompany_Creation () throws InterruptedException {
		

		login = new Login_Page(driver);
		login.Admin_Login();
		
		HiringCompany = new HiringCompany_Page(driver);
		
		HiringCompany.Hiringcompany_Creation();
		
	}

	public void HiringCompany_update () throws InterruptedException {
		
		login = new Login_Page(driver);
		login.Admin_Login();
		HiringCompany = new HiringCompany_Page(driver);
	
	Thread.sleep(3000);
		HiringCompany.Hiringcompany_update();
	//	Assert.assertEquals(HiringCompany.Successmessage.getText(), "User Has Been updated successfully");
	}
}
