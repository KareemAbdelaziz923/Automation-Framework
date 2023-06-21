package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Employee_Page;
import pages.Login_Page;


public class employeepage_Test extends TestBase {
	
Employee_Page   Employee ;
Login_Page login ; 

@Test(priority = 0)
public void Employee_creation () {
	
	
//	login = new Login_Page(driver);
//	login.Admin_Login();
	Employee = new Employee_Page(driver);
	
	Employee.Employee_Creation();
	
	Assert.assertEquals(Employee.Successmessage.getText(), "User has been created successfully");
	
}

@Test(priority = 1)
public void Employee_update () {
	
	
	Employee = new Employee_Page(driver);
	
	Employee.Employee_update();
	Assert.assertEquals(Employee.Successmessage.getText(), "User Has Been updated successfully");
	

}

@Test(priority = 2)
public void Employee_delete () throws InterruptedException {
	
	Employee = new Employee_Page(driver);
	
	Employee.Employee_delete();
	Employee = new Employee_Page(driver);
	
	driver.switchTo().alert().accept();
	Assert.assertEquals(Employee.Successmessage.getText(), "Data has been deleted successfully.");

}
}
