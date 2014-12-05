package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * 
 * This Model compares a username and a password with the informations of the
 * user model (Patient) returns a boolean value.
 * 
 * @author Stefan Johner
 * @param isValid
 *            A boolean value if the authentification passed or not
 *
 */
public class Authenticator {
	public boolean authenticate(String username, String password) {
		// Create Dummy User
		Patient dummyPatient1 = new Patient(1, "Hans Muster", "Patient1",
				"password");
		//
		// Validate username and password with database here. For
		// examples sake
		// I use a dummy username and password.
		//
		boolean isValid = username.equals(dummyPatient1.getUsername())
				&& password.equals(dummyPatient1.getPassword());
		return isValid;
	}
}
