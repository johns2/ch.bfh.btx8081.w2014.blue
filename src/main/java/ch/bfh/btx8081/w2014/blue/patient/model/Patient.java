package ch.bfh.btx8081.w2014.blue.patient.model;

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
public class Patient extends Person {
	private String username;
	private String password;
	private String emailaddress;

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
	public Patient(int userID, String PersonName, String username,
			String password) {
		super(userID, PersonName);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username in lower cases
	 * 
	 * @param username
	 *            in lower case characters
	 */
	public void setUsername(String username) {
		username = username.toLowerCase();
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of this Patient user.
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

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	/**
	 * Chooses a Task and returns the ID of the Task
	 * @return taskNumber Tasknumber as an Integer
	 */
	//To-Do: First implement Task-/Notification management
	public int chooseTask() {
		return 0;
	}

	/**
	 * Returns the doctor a message
	 * 
	 */
	public void informDoctor() {
		//To Do: Implement Task-/Notification management
	}

}
