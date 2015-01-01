package ch.bfh.btx8081.w2014.blue.patient.model;

import java.util.List;

import ch.bfh.btx8081.w2014.blue.patient.database.XmlFileReader;

/**
 * 
 * This model implements a patient user of our application with his credentials,
 * status etc. and extends the Person class
 * 
 * @author Stefan Johner, johns2@bfh.ch
 * @param username
 *            A username string
 * @param password
 *            A password string
 * @throws
 *
 */
public class UserData {
	private String username;
	private String password;
	private String emailaddress;
	private List<showMedication> medications;

	/**
	 * The Patient constructor creates a Patient Object which extends the Person
	 * class.
	 * 
	 * @author Stefan Johner, johns2@bfh.ch
	 * 
	 * @param userID
	 *            The user ID of this person, used for a clear identification
	 * @param PersonName
	 *            The Name of the Patient
	 * @param username
	 * @param password
	 */
	public UserData() {}
	public UserData(String username,
			String password) {
		
		this.username = username;
		this.password = password;
	}
	
	/**
	 * @return The Medications for this patient
	 */
	public List<showMedication> getMedication() {
		this.medications = XmlFileReader.getMedication(null);
		return this.medications;
	}

	/**
	 * Returns the username in lower case
	 * 
	 * @return username in lower case characters
	 */
	public String getUsername() {
		username = username.toLowerCase();
		return username;
	}

	/**
	 * Sets the username
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns the password of a Patient user
	 * 
	 * @return password
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of a Patient user.
	 * 
	 * @param password
	 *            Password in plaintext as a String
	 */
	// To-Do: Maybe implement password-hashing with Java class MessageDigest
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * The emailaddress of the Patient user. May be used for recover password
	 * etc.
	 * 
	 * @param emailaddress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}

	/**
	 * Returns the e-mail address of a Patient user
	 * 
	 * @return e-mail address
	 * 
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	/**
	 * Chooses a Task and returns the ID of the Task
	 * 
	 * @return taskNumber Tasknumber as an Integer
	 */
	// To-Do: First implement Task-/Notification management
	public int chooseTask() {
		return 0;
	}

	/**
	 * Returns the doctor a message
	 * 
	 */
	public void informDoctor() {
		// To Do: Implement Task-/Notification management
	}

}
