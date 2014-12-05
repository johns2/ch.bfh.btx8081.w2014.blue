package ch.bfh.btx8081.w2014.blue.patient.model;

import ch.bfh.btx8081.w2014.blue.patient.database.User;

/**
 * 
 * This Model compares a username and a password with the informations of the
 * database (User) returns a boolean value.
 * 
 * @author Stefan Johner, johns2@bfh.ch
 * @param isValid
 *            A boolean value if the authentification passed or not
 *
 */
public class Authenticator {
	
	/**
	 * 
	 * This method will check submitted credentials (username, password) with the database and will return a boolean value
	 * 
	 * @param username
	 * @param password
	 * @return isValid A boolean value if the login was valid or not
	 */
	public boolean authenticate(String username, String password) {
		// Create Dummy User
		User dummyPatient1 = new User("Patient1", "password");

		boolean isValid = username.equals(dummyPatient1.getUsername())
				&& password.equals(dummyPatient1.getPassword());
		return isValid;
	}
}
