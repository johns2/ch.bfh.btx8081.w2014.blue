package ch.bfh.btx8081.w2014.blue.patient.model;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinSession;

import ch.bfh.btx8081.w2014.blue.patient.model.UserData;
import ch.bfh.btx8081.w2014.blue.patient.database.XmlFileReader;

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
	private Boolean isValid;

	public Authenticator(VaadinSession userSession) {
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
		List<UserData> Patient1 = new ArrayList<UserData>();
		// Load Patient1 from database
		Patient1 = XmlFileReader.getUserData();

		// Compares the input credentials with them of the user
		isValid = username.equalsIgnoreCase(Patient1.get(0)
				.getUsername())
				&& password.equals(Patient1.get(0).getPassword());
		return isValid;
	}

	public void unsetValidSession() {
		userSession.setAttribute("user", null);
	}

	public void setValidSession() {
		userSession.setAttribute("user", username);
	}
	
		public Boolean getIsValid() {
//			if (userSession.getAttribute("user") != null){
//				return true;
//			} else{
//				return false;
//			}
			return true;
	}
}