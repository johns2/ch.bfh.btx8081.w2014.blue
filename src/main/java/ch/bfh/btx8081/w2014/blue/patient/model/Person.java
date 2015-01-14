package ch.bfh.btx8081.w2014.blue.patient.model;

/**
 * This class models a person with his informations ID and name
 * 
 * @author Stefan Johner, johns2@bfh.ch
 * 
 */

public abstract class Person {
	private int userID;
	private String personName;
	
	/**
	 * Construct a Person with given userID and given Name.
	 * @param userID
	 * @param Name
	 */
	public Person (int userID, String Name){
		this.userID = userID;
		this.personName = Name;
	}

	/**
	 *  
	 * @return the UserID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID set UserID with given userID
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return the persons name
	 */
	public String getPersonName() {
		return this.personName;
	}

	/**
	 * set the persons name 
	 * @param PersonName
	 */
	public void setPersonName(String PersonName) {
		this.personName = PersonName;
	}

}
