package com.CVB.app.tasks.common.CVB;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.Map;
import java.util.logging.Logger;

import com.CVB.app.page_objects.EmployeePage;
import com.CVB.app.utils.CommonUtil;
import com.CVB.app.utils.ConvertCucumberDataTable;
import com.CVB.app.utils.Key;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Employee extends UIInteractions implements Task {

	private static Logger logger = Logger.getLogger(Employee.class.getName());
	
	private static String lastname;
	private static String firstname;
	private static String email;
	private static String phone;
	private static String jobtitle;
	
	public Employee(String lastname, String firstname, String email, String phone, String jobtitle) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.jobtitle = jobtitle;
	}

	public static Employee withUnderlinedetails(DataTable managerdetails) {
		Map<String, String> managerdetail = ConvertCucumberDataTable.toMap(managerdetails);
		lastname = managerdetail.get("LastName");
		firstname = managerdetail.get("FirstName");
		email = managerdetail.get("Email");
		phone = managerdetail.get("Mobile");
		jobtitle = managerdetail.get("JobTitle");
		return new Employee(lastname, firstname, email, phone, jobtitle);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
	
		waitABit(1200);
		String action = actor.recall(Key.ACTION);
		System.out.println(action);
		actor.attemptsTo(Click.on(EmployeePage.EMPLOYEEMENU));

		waitABit(1200);
		switch (action) {
		case "AddEmployee":

			actor.attemptsTo(Click.on(EmployeePage.ADD_EMPLOYEE));

			actor.attemptsTo(WaitUntil.the(EmployeePage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(EmployeePage.LASTNAME)));

			actor.attemptsTo(WaitUntil.the(EmployeePage.FIRSTNAME, isVisible())
					.then(Enter.theValue(firstname).into(EmployeePage.FIRSTNAME)));

			email = firstname + lastname + CommonUtil.generateRandomNumber() + "@gmail.com";
			actor.attemptsTo(WaitUntil.the(EmployeePage.EMAIL, isVisible())
					.then(Enter.theValue(email).into(EmployeePage.EMAIL)));

			actor.attemptsTo(WaitUntil.the(EmployeePage.PHONE, isVisible())
					.then(Enter.theValue(phone).into(EmployeePage.PHONE)));

			actor.attemptsTo(WaitUntil.the(EmployeePage.JOB_TITLE, isVisible())
					.then(Enter.theValue(jobtitle).into(EmployeePage.JOB_TITLE)));

			actor.attemptsTo(Click.on(EmployeePage.SEND_EMAIL_LATER));

			actor.attemptsTo(Click.on(EmployeePage.SAVE_BUTTON));
			waitABit(1000);

			String success = EmployeePage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been created successfully");
			break;

		case "UpdateEmployee":

			actor.attemptsTo(Click.on(EmployeePage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(EmployeePage.UPDATE));
			waitABit(999);
			
			actor.attemptsTo(WaitUntil.the(EmployeePage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(EmployeePage.LASTNAME)));
			
			actor.attemptsTo(Click.on(EmployeePage.UPDATE_BUTTON));
			waitABit(1000);

			success = EmployeePage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been updated successfully");
			break;

		case "DeleteEmployee":
			actor.attemptsTo(Click.on(EmployeePage.CHECKBOX));
			waitABit(1500);
			actor.attemptsTo(Click.on(EmployeePage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(EmployeePage.DELETE));
			waitABit(999);
			actor.attemptsTo(Switch.toAlert().andAccept());
			waitABit(999);
			success = EmployeePage.SUCCESS_MESSAGE.resolveFor(actor).getText();
			Ensure.that(success).isEqualTo("User has been deleted successfully");
			break;
		default:
			break;
		}
	}

}
