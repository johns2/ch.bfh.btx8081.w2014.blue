package ch.bfh.btx8081.w2014.blue.patient.model;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

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
	private String username;
	private String password;
	private VaadinSession userSession;
	
	public Authenticator (VaadinSession userSession){
		this.userSession = userSession;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * This method will check submitted credentials (username, password) with
	 * the database and will return a boolean value
	 * 
	 * @param username
	 * @param password
	 * @return isValid A boolean value if the login was valid or not
	 */
	public boolean authenticate() {
		// Create Dummy User
		User dummyPatient1 = new User("Patient1", "password");
		
		//Compares the input credentials with them of the user
		boolean isValid = username.equals(dummyPatient1.getUsername())
				&& password.equals(dummyPatient1.getPassword());
		
		if (isValid == true){
			setValidSession();
		}
		else {
			unsetValidSession();
		}
		return isValid;
		

	}

	private void unsetValidSession() {
		
	}

	public void setValidSession() {
		// Store the username in the session
	}
}
