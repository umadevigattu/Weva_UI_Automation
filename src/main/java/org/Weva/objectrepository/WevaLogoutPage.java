package org.Weva.objectrepository;

public class WevaLogoutPage {

	private static String myNaukari = "//div[contains(text(),'My Naukri')]";
	private static String logout = "//a[contains(text(),'Logout')]";
	
	public static String getMyNaukari() {
		return myNaukari;
	}
	public static String getLogout() {
		return logout;
	}
}
