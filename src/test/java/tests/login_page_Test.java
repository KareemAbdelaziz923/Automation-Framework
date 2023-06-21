package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Page;

public class login_page_Test extends TestBase {
	
	Login_Page login ;

	@Test 
	public void Admin_can_login_successfully () 
	{

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Page(driver);
		login.Admin_Login();
	}
	@Test
	public void Admin_can_logout_successfully () 
	{

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Page(driver);
		login.Admin_Logout();
	}
	
	@Test
	public void Verifier_can_login_successfully () 
	{

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Page(driver);
		login.Verifier_Login();
	}
	

	
	@Test
	public void Contractor_can_login_successfully () 
	{

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Page(driver);
		login.Contractor_Login();
	}
	@Test
	public void Employee_can_login_successfully () 
	{

		//   home = new Homepage(driver) ;
		//  home.open_homepage();

		login = new Login_Page(driver);
		login.Employee_Login();
	}
}