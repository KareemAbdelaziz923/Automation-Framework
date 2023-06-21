package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ClientCompanyManager_page;
import pages.Login_Page;
import pages.Verifier_Page;

public class clientcompanymanager_Test extends TestBase {

	
	
    Login_Page login ;
	
	ClientCompanyManager_page Client ;
	
	@Test( priority = 0)
	public void ClientManager_Creation () {
		

	//login = new Login_Page(driver);
	//login.Admin_Login();
	
	
	Client = new ClientCompanyManager_page(driver);
	
	Client.ClientManager_Creation();
	
	Assert.assertEquals(Client.Successmessage.getText(), "User has been created successfully");

}
	
	@Test( priority = 1)
	public void ClientManager_update () {
		
		
		Client = new ClientCompanyManager_page(driver);
		
		Client.ClientManager_update();
		Assert.assertEquals(Client.Successmessage.getText(), "User Has Been updated successfully");
		

	}

	@Test( priority = 2)
	public void ClientManager_delete () throws InterruptedException {
		
		Client = new ClientCompanyManager_page(driver);
		
		Client.ClientManager_delete();
		Client = new ClientCompanyManager_page(driver);
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(Client.Successmessage.getText(), "Data has been deleted successfully.");

	}

}
