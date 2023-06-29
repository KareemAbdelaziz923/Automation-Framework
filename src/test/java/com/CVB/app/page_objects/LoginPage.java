package com.CVB.app.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:login.page")
public class LoginPage extends PageObject {

	public static Target USERNAME = Target.the("username").locatedBy("//input[@name='username']");
	public static Target PASSWORD = Target.the("username").locatedBy("//input[@name='password']");
	public static Target SIGNIN_BTN = Target.the("username").locatedBy("//button[contains(text(),'Login')]");
	
}
