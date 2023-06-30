package com.CVB.app.tasks.common.CVB;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.Map;
import java.util.logging.Logger;
import com.CVB.app.page_objects.VerifierPage;
import com.CVB.app.utils.CommonUtil;
import com.CVB.app.utils.ConvertCucumberDataTable;
import com.CVB.app.utils.Key;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Verifier extends PageObject implements Task {

private static Logger logger = Logger.getLogger(Verifier.class.getName());
	
	private static String lastname;
	private static String firstname;
	private static String email;
	private static String phone;
	private static String jobtitle;
	
	public Verifier(String lastname, String firstname, String email, String phone, String jobtitle) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.jobtitle = jobtitle;
	}

	public static Verifier withUnderlinedetails(DataTable managerdetails) {
		Map<String, String> managerdetail = ConvertCucumberDataTable.toMap(managerdetails);
		lastname = managerdetail.get("LastName");
		firstname = managerdetail.get("FirstName");
		email = managerdetail.get("Email");
		phone = managerdetail.get("Mobile");
		jobtitle = managerdetail.get("JobTitle");
		return new Verifier(lastname, firstname, email, phone, jobtitle);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
	
		waitABit(1200);
		String action = actor.recall(Key.ACTION);
		actor.attemptsTo(Scroll.to(VerifierPage.VERIFIERMENU).andAlignToBottom());
		
		waitABit(999);
		actor.attemptsTo(Click.on(VerifierPage.VERIFIERMENU));

		waitABit(1200);
		switch (action) {
		case "AddVerifier":

			actor.attemptsTo(Click.on(VerifierPage.ADD_VERIFIER));

			actor.attemptsTo(WaitUntil.the(VerifierPage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(VerifierPage.LASTNAME)));

			actor.attemptsTo(WaitUntil.the(VerifierPage.FIRSTNAME, isVisible())
					.then(Enter.theValue(firstname).into(VerifierPage.FIRSTNAME)));

			email = firstname + lastname + CommonUtil.generateRandomNumber() + "@gmail.com";
			actor.attemptsTo(WaitUntil.the(VerifierPage.EMAIL, isVisible())
					.then(Enter.theValue(email).into(VerifierPage.EMAIL)));

			actor.attemptsTo(WaitUntil.the(VerifierPage.PHONE, isVisible())
					.then(Enter.theValue(phone).into(VerifierPage.PHONE)));

			actor.attemptsTo(WaitUntil.the(VerifierPage.JOB_TITLE, isVisible())
					.then(Enter.theValue(jobtitle).into(VerifierPage.JOB_TITLE)));

			actor.attemptsTo(SelectFromOptions.byIndex(0).from(VerifierPage.ROLE));
			
			actor.attemptsTo(Click.on(VerifierPage.SEND_EMAIL_LATER));

			actor.attemptsTo(Click.on(VerifierPage.SAVE_BUTTON));
			waitABit(1000);

			String success = VerifierPage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been created successfully");
			break;

		case "UpdateVerifier":

			actor.attemptsTo(Click.on(VerifierPage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(VerifierPage.UPDATE));
			waitABit(999);
			
			actor.attemptsTo(WaitUntil.the(VerifierPage.LASTNAME, isVisible())
					.then(Enter.theValue(lastname).into(VerifierPage.LASTNAME)));
			
			actor.attemptsTo(Click.on(VerifierPage.UPDATE_BUTTON));
			waitABit(1000);

			success = VerifierPage.SUCCESS_MESSAGE.resolveFor(actor).getText();

			Ensure.that(success).isEqualTo("User has been updated successfully");
			break;

		case "DeleteVerifier":
			actor.attemptsTo(Click.on(VerifierPage.CHECKBOX));
			waitABit(1500);
			actor.attemptsTo(Click.on(VerifierPage.THREEDOT));
			waitABit(999);
			actor.attemptsTo(Click.on(VerifierPage.DELETE));
			waitABit(999);
			actor.attemptsTo(Switch.toAlert().andAccept());
			waitABit(999);
			success = VerifierPage.SUCCESS_MESSAGE.resolveFor(actor).getText();
			Ensure.that(success).isEqualTo("User has been deleted successfully");
			break;
		default:
			break;
		}
	}

}
