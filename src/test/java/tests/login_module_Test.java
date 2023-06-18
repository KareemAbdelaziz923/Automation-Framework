package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Module;

public class login_module_Test extends TestBase {
	
	Login_Module login ;

	@Test
	public void Admin_can_login_successfully () {

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Module(driver);
		login.Admin_Login();


		Assert.assertTrue(login.SuccessMessage.getText().contains("Dashboard"));






	}

}