package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Verifier_Page ;
import pages.Employee_Page;
import pages.Login_Page;



public class verifier_page_Test extends TestBase {
	
	Login_Page login ;
	
	Verifier_Page Verifier ;
	
	@Test( priority = 0)
	public void verifier_Creation () {
		

//		login = new Login_Page(driver);
	//	login.Admin_Login();
	Verifier = new Verifier_Page(driver);
	
	Verifier.Verifier_Creation();
	
	Assert.assertEquals(Verifier.Success_message.getText(), "User has been created successfully");

}
	
	@Test( priority = 1)
	public void Verifier_update () {
		
		
		Verifier = new Verifier_Page(driver);
		
		Verifier.Verifier_update();
		Assert.assertEquals(Verifier.Success_message.getText(), "User Has Been updated successfully");
		

	}

	@Test( priority = 2)
	public void Verifier_delete () throws InterruptedException {
		
		Verifier = new Verifier_Page(driver);
		
		Verifier.Verifier_delete();
		Verifier = new Verifier_Page(driver);
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(Verifier.Success_message.getText(), "Data has been deleted successfully.");

	}
}