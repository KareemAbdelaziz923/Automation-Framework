package com.CVB.app.tasks.common.CVB;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.util.Map;
import java.util.logging.Logger;
import com.CVB.app.page_objects.ClientCompanyManagerPage;
import com.CVB.app.utils.CommonUtil;
import com.CVB.app.utils.ConvertCucumberDataTable;
import com.CVB.app.utils.Key;

import io.cucumber.datatable.DataTable;

public class ClientCompanyManager extends UIInteractions implements Task {

	private static Logger logger = Logger.getLogger(ClientCompanyManager.class.getName());
	private static String lastname;
	private static String firstname;
	private static String email;
	private static String phone;
	private static String jobtitle;

	public ClientCompanyManager(String lastname, String firstname, String email, String phone, String jobtitle) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.jobtitle = jobtitle;
	}

	public static ClientCompanyManager withUnderlinedetails(DataTable managerdetails) {
		Map<String, String> managerdetail = ConvertCucumberDataTable.toMap(managerdetails);
		lastname = managerdetail.get("LastName");
		firstname = managerdetail.get("FirstName");
		email = managerdetail.get("Email");
		phone = managerdetail.get("Mobile");
		jobtitle = managerdetail.get("JobTitle");
		return new ClientCompanyManager(lastname, firstname, email, phone, jobtitle);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		waitABit(1200);
		String action = actor.recall(Key.ACTION);
		System.out.println(action);
		actor.attemptsTo(Click.on(ClientCompanyManagerPage.CLIENTMANAGERMENU));

		waitABit(1200);
		switch (action) {
		case "AddCManager":

			actor.attemptsTo(Click.on(ClientCompanyManagerPage.ADD_MANAGER));

			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(ClientCompanyManagerPage.LASTNAME)));

			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.FIRSTNAME, isVisible())
					.then(Enter.theValue(firstname).into(ClientCompanyManagerPage.FIRSTNAME)));

			email = firstname + lastname + CommonUtil.generateRandomNumber() + "@gmail.com";
			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.EMAIL, isVisible())
					.then(Enter.theValue(email).into(ClientCompanyManagerPage.EMAIL)));

			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.PHONE, isVisible())
					.then(Enter.theValue(phone).into(ClientCompanyManagerPage.PHONE)));

			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.JOB_TITLE, isVisible())
					.then(Enter.theValue(jobtitle).into(ClientCompanyManagerPage.JOB_TITLE)));

			actor.attemptsTo(Click.on(ClientCompanyManagerPage.SEND_EMAIL_LATER));

			actor.attemptsTo(Click.on(ClientCompanyManagerPage.SAVE_BUTTON));
			waitABit(1000);

			String success = ClientCompanyManagerPage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been created successfully");
			break;

		case "UpdateCManager":

			actor.attemptsTo(Click.on(ClientCompanyManagerPage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(ClientCompanyManagerPage.UPDATE));
			waitABit(999);
			
			actor.attemptsTo(WaitUntil.the(ClientCompanyManagerPage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(ClientCompanyManagerPage.LASTNAME)));
			
			actor.attemptsTo(Click.on(ClientCompanyManagerPage.UPDATE_BUTTON));
			waitABit(1000);

			success = ClientCompanyManagerPage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been updated successfully");
			break;

		case "DeleteCManager":
			actor.attemptsTo(Click.on(ClientCompanyManagerPage.CHECKBOX));
			waitABit(1500);
			actor.attemptsTo(Click.on(ClientCompanyManagerPage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(ClientCompanyManagerPage.DELETE));
			waitABit(999);
			actor.attemptsTo(Switch.toAlert().andAccept());
			waitABit(999);
			success = ClientCompanyManagerPage.SUCCESS_MESSAGE.resolveFor(actor).getText();
			Ensure.that(success).isEqualTo("User has been deleted successfully");
			break;
		default:
			break;
		}
	}
}
