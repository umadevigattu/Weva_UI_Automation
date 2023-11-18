package org.Weva.objectrepository;

public class WevaLoginPage {

	private static String login = "//input[@name='email']";
	private static String username = "//input[@name='email']";
	private static String password = "//input[@name='password']";
	private static String submit = "//button[text()='Sign in']";

	public static String getLogin() {
		return login;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static String getSubmit() {
		return submit;
	}

}
