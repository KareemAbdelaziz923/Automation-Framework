package com.CVB.app.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import java.util.Map;

import com.CVB.app.page_objects.LoginPage;
import com.CVB.app.questions.Landing;
import com.CVB.app.utils.CommonUtil;
import com.CVB.app.utils.ConvertCucumberDataTable;
import com.CVB.app.utils.Key;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Login implements Task {

	private static String userType;
	private static String action;
	private static String username;
	private static String password;

	public Login(String username, String password, String userType, String action) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.action = action;
	}

	public static Login withSpecificUser(DataTable logindetails) {
		Map<String, String> logindetail = ConvertCucumberDataTable.toMap(logindetails);
		userType = logindetail.get("UserType");
		action = logindetail.get("Action");
		if (userType.equalsIgnoreCase("Employee")) {
			username = "vipin@leavecode.com";
			password = "vipin@1234";
		} else if (userType.equalsIgnoreCase("Admin")) {
			username = "vipinjoshi.joshi@gmail.com";
			password = "vipin@123";
		} else if (userType.equalsIgnoreCase("Contractor")) {
			username = "contract@gmail.com";
			password = "vipin@123";
		} else if (userType.equalsIgnoreCase("Verifier")) {
			username = "verifier@gmail.com";
			password = "vipin@123";
		} else {
			System.out.println("Something Went Wrong!");
		}

		return new Login(username, password, userType, action);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.wasAbleTo(NavigateTo.theLoginPage());

		CommonUtil.staticWaitFor((long) 999);
		actor.remember(Key.ACTION, action);

		CommonUtil.staticWaitFor((long) 999);
		actor.attemptsTo(WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(5).seconds(),
				Enter.theValue(username).into(LoginPage.USERNAME), Enter.theValue(password).into(LoginPage.PASSWORD),
				WaitUntil.the(LoginPage.SIGNIN_BTN, isClickable()), Click.on(LoginPage.SIGNIN_BTN));

		CommonUtil.staticWaitFor((long) 999);

		actor.should("Verify Dashboard after login", seeThat(Landing.isComplete()));

		CommonUtil.staticWaitFor((long) 999);
	}

}
