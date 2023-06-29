package com.CVB.app.steps;

import java.util.logging.Logger;
import com.CVB.app.tasks.common.Login;
import com.CVB.app.tasks.common.CVB.ClientCompanyManager;
import com.CVB.app.tasks.common.CVB.Employee;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.CVB.app.questions.ApplicationEnquiryResult.*;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

public class ApplicationSteps extends UIInteractionSteps {
	
	private static Logger logger = Logger.getLogger(ApplicationSteps.class.getName());
	
	private Actor actor;
	
	@Before(order = 2)
	public void setup() {
		actor = OnStage.theActor("User");
	}

	@Given("{word} is on home page and login with valid credentials")
	public void User_is_on_home_page_and_login_with_valid_credentials(String role, DataTable logintype) {
		actor.assignName(role);
		givenThat(actor).attemptsTo(Login.withSpecificUser(logintype));
	}
	
	@Given("provides client company manager user information and add")
	public void provides_client_company_manager_user_informarion_and_add(DataTable managerinfo) {
		givenThat(actor).attemptsTo(ClientCompanyManager.withUnderlinedetails(managerinfo));
	}
	
	@Given("provides employee user information and add")
	public void provides_employee_user_information_and_add(DataTable employeeinfo) {
		givenThat(actor).attemptsTo(Employee.withUnderlinedetails(employeeinfo));
	}
	
	@When("navigate to dashboard and verify login")
	public void navigate_to_dashboard_and_verify_login() {}

	@Then("Verification status should be {string}")
	public void Verification_status_should_be(String status) {
	    givenThat(actor).attemptsTo(Ensure.that("Verification Status", hasVerificationStatus()).isEqualTo(status));
	}
}
