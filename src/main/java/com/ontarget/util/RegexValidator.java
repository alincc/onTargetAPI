package com.ontarget.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {
	private Pattern pattern;
	private Matcher matcher;

	public RegexValidator(String regexPattern) {
		pattern = Pattern.compile(regexPattern);
	}

	public boolean validate(final String value) {
		matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static void main(String args[]){
		RegexValidator regexValidator = new RegexValidator("^[a-z0-9_-]{3,15}$");
		boolean valid = regexValidator.validate("sanjeev_123");
		System.out.println("Valid: "+valid);
		
	}
}
