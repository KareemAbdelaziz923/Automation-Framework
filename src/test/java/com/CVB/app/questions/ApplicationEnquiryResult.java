package com.CVB.app.questions;

import net.serenitybdd.screenplay.Question;

public class ApplicationEnquiryResult {
	
	private static final String statusval = "Verified";

	public static Question<String> hasVerificationStatus(){
		return (actor) -> statusval;
	}
}