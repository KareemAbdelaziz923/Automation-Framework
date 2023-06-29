package com.CVB.app.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ClientCompanyManagerPage extends PageObject {
	
	public static Target CLIENTMANAGERMENU = Target.the("client manager menu").locatedBy("//*[@id='collapseSubItems4']/li[2]/a/span");
	public static Target ADD_MANAGER = Target.the("add manager").locatedBy("//a[contains(text(),'Add User')]");
	public static Target LASTNAME = Target.the("last name").locatedBy("//input[@id='last_name']");
	public static Target FIRSTNAME = Target.the("first name").locatedBy("//input[@id='first_name']");
	public static Target EMAIL = Target.the("email").locatedBy("//input[@id='email']");
	public static Target PHONE = Target.the("phone").locatedBy("//input[@id='phone']");
	public static Target JOB_TITLE = Target.the("job title").locatedBy("//input[@id='job_title']");
	public static Target SEND_EMAIL_LATER = Target.the("send email later").locatedBy("//input[@id='send_email_later']");
	public static Target SAVE_BUTTON = Target.the("save button").locatedBy("//button[contains(text(),'SAVE')]");
	public static Target UPDATE_BUTTON = Target.the("update button").locatedBy("//button[contains(text(),'UPDATE')]");
	public static Target THREEDOT = Target.the("threedot").locatedBy("(//button[@class='btn btn-primary dropdown-toggle user-action'])[1]");
	public static Target UPDATE = Target.the("update").locatedBy("//*[@id='tbodydata']/tr[1]/td[8]/div/div/a[1]");
	public static Target CHECKBOX = Target.the("checkbox").locatedBy("//*[@id='tbodydata']/tr[1]/td[1]/div/input");
	public static Target DELETE = Target.the("delete").locatedBy("//*[@id='tbodydata']/tr[1]/td[8]/div/div/a[5]");
	public static Target SUCCESS_MESSAGE = Target.the("success message").locatedBy("/html/body/main/div/div/div[2]/div[1]/div[2]/div[2]");
}
