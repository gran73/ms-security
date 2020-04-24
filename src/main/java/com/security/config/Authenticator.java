package com.security.config;

public class Authenticator {

	public static boolean checkUser(String username) {
		if ( (username != null && username.length() > 0) && 
		     (username.equalsIgnoreCase("gurinder") || username.equalsIgnoreCase("Jyothi")) ) {
		    	 return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkPassword(String username, String password) {
		if (checkUser(username)) {
			if (username.equalsIgnoreCase("gurinder") && password.equals("pa$$w0rd")) {
				return true;
			}
			if (username.equalsIgnoreCase("jyothi") && password.equals("pa$$w0rd")) {
				return true;
			} 
			else {
				return false;
			} 
		} else {
			return false;
		}
	}
}
